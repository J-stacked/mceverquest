package net.mceq.mceverquest.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class FireelementalEntity extends HostileEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState fireAttackAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private static final TrackedData<Byte> FIREELEMENTAL_FLAGS = DataTracker.registerData(FireelementalEntity.class, TrackedDataHandlerRegistry.BYTE);

    public FireelementalEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.experiencePoints = 10;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking()){
            this.attackAnimationState.start(this.age);
        }else{
            this.attackAnimationState.stop();
        }
    }

    public static DefaultAttributeContainer.Builder createFireelementalAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FIREELEMENTAL_FLAGS, (byte)0);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    public void tickMovement() {
        if (this.getWorld().isClient) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.getWorld().playSound(this.getX() + 0.5, this.getY() + 0.5, this.getZ() + 0.5,
                        SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 0.3f + this.random.nextFloat(),
                        this.random.nextFloat() * 0.7f + 0.3f, false);
            }
            for (int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.SMALL_FLAME, this.getParticleX(0.2), this.getRandomBodyY(),
                        this.getParticleZ(0.2), 0.0, 0.0, 0.0);
            }
        }
        super.tickMovement();
    }

    @Override
    public boolean hurtByWater() {
        return true;
    }

    @Override
    public boolean isOnFire() {
        return this.isFireActive();
    }

    private boolean isFireActive() {
        return (this.dataTracker.get(FIREELEMENTAL_FLAGS) & 1) != 0;
    }

    void setFireActive(boolean fireActive) {
        byte b = this.dataTracker.get(FIREELEMENTAL_FLAGS);
        b = fireActive ? (byte)(b | 1) : (byte)(b & 0xFFFFFFFE);
        this.dataTracker.set(FIREELEMENTAL_FLAGS, b);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(1, new ShootFireballGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, BeeEntity.class, true));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BLAZE_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_CELEBRATE;
    }

    static class ShootFireballGoal extends Goal {
        private final FireelementalEntity fireelemental;
        private int fireballsFired;
        private int fireballCooldown;
        private int targetNotVisibleTicks;

        public ShootFireballGoal(FireelementalEntity fireelemental) {
            this.fireelemental = fireelemental;
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            LivingEntity livingEntity = this.fireelemental.getTarget();
            return livingEntity != null && livingEntity.isAlive() && this.fireelemental.canTarget(livingEntity);
        }

        @Override
        public void start() {
            this.fireballsFired = 0;
            this.fireelemental.fireAttackAnimationState.start(this.fireelemental.age);
        }

        @Override
        public void stop() {
            this.fireelemental.setFireActive(false);
            this.fireelemental.fireAttackAnimationState.stop();
            this.targetNotVisibleTicks = 0;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            --this.fireballCooldown;
            LivingEntity livingEntity = this.fireelemental.getTarget();
            if (livingEntity == null) {
                return;
            }
            boolean bl = this.fireelemental.getVisibilityCache().canSee(livingEntity);
            this.targetNotVisibleTicks = bl ? 0 : ++this.targetNotVisibleTicks;
            double d = this.fireelemental.squaredDistanceTo(livingEntity);
            if (d < 4.0) {
                if (!bl) {
                    return;
                }
                if (this.fireballCooldown <= 0) {
                    this.fireballCooldown = 80;
                    this.fireelemental.tryAttack(livingEntity);
                }
                this.fireelemental.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0);
            } else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
                double e = livingEntity.getX() - this.fireelemental.getX();
                double f = livingEntity.getBodyY(0.5) - this.fireelemental.getBodyY(0.5);
                double g = livingEntity.getZ() - this.fireelemental.getZ();
                if (this.fireballCooldown <= 0) {
                    ++this.fireballsFired;
                    if (this.fireballsFired == 1) {
                        this.fireballCooldown = 60;
                        this.fireelemental.setFireActive(true);
                    } else if (this.fireballsFired <= 4) {
                        this.fireballCooldown = 6;
                    } else {
                        this.fireballCooldown = 100;
                        this.fireballsFired = 0;
                        this.fireelemental.setFireActive(false);
                    }
                    if (this.fireballsFired > 1) {
                        double h = Math.sqrt(Math.sqrt(d)) * 0.5;
                        if (!this.fireelemental.isSilent()) {
                            this.fireelemental.getWorld().syncWorldEvent(null, WorldEvents.BLAZE_SHOOTS, this.fireelemental.getBlockPos(), 0);
                        }
                        for (int i = 0; i < 1; ++i) {
                            SmallFireballEntity smallFireballEntity = new SmallFireballEntity(this.fireelemental.getWorld(), this.fireelemental, this.fireelemental.getRandom().nextTriangular(e, 2.297 * h), f, this.fireelemental.getRandom().nextTriangular(g, 2.297 * h));
                            smallFireballEntity.setPosition(smallFireballEntity.getX(), this.fireelemental.getBodyY(0.5) + 0.5, smallFireballEntity.getZ());
                            this.fireelemental.getWorld().spawnEntity(smallFireballEntity);
                        }
                    }
                }
                this.fireelemental.getLookControl().lookAt(livingEntity, 10.0f, 10.0f);
            } else if (this.targetNotVisibleTicks < 5) {
                this.fireelemental.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0);
            }
            super.tick();
        }

        private double getFollowRange() {
            return this.fireelemental.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
        }
    }

}
