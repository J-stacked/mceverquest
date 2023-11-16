package net.mceq.mceverquest.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mceq.mceverquest.MCEverQuest;
import net.mceq.mceverquest.entity.custom.FireelementalEntity;
import net.mceq.mceverquest.entity.custom.RatEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RatEntity> RAT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MCEverQuest.MOD_ID, "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RatEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<FireelementalEntity> FIREELEMENTAL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MCEverQuest.MOD_ID, "fireelemental"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireelementalEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());

    //add new entities here!
}
