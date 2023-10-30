package mceq.mceverquest.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class RatEntity extends PathAwareEntity {
    public RatEntity(EntityType<? extends PathAwareEntity> entityType, World world){
        super(entityType, world);
    }
}
