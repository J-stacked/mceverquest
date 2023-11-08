package net.mceq.mceverquest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mceq.mceverquest.entity.ModEntities;
import net.mceq.mceverquest.entity.client.ModModelLayers;
import net.mceq.mceverquest.entity.client.RatModel;
import net.mceq.mceverquest.entity.client.RatRenderer;

public class MCEverQuestClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.RAT, RatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);
    }
}
