package mceq.mceverquest;

import mceq.mceverquest.entity.RatEntity;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class Mceverquest implements ModInitializer {
    public static final EntityType<RatEntity> RAT = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("mceverquest", "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RatEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        /*
         * Register our entitys' default attributes.
         * Attributes are properties or stats of the mobs, including things like attack damage and health.
         * The game will crash if the entity doesn't have the proper attributes registered in time.
         *
         * In 1.15, this was done by a method override inside the entity class.
         * Most vanilla entities have a static method (eg. ZombieEntity#createZombieAttributes) for initializing their attributes.
         */

        FabricDefaultAttributeRegistry.register(RAT, RatEntity.createMobAttributes());
    }
}
