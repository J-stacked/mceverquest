package net.mceq.mceverquest;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mceq.mceverquest.entity.ModEntities;
import net.mceq.mceverquest.entity.custom.RatEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCEverQuest implements ModInitializer {
	public static final String MOD_ID = "mceverquest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.RAT, RatEntity.createRatAttributes());
	}
}