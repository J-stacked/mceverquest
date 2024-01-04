package net.mceq.mceverquest;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mceq.mceverquest.entity.ModEntities;
import net.mceq.mceverquest.entity.custom.FireelementalEntity;
import net.mceq.mceverquest.entity.custom.RatEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCEverQuest implements ModInitializer {
	public static final String MOD_ID = "mceverquest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.RAT, RatEntity.createRatAttributes());

		FabricDefaultAttributeRegistry.register(ModEntities.FIREELEMENTAL, FireelementalEntity.createFireelementalAttributes());

		//add here
	}
}