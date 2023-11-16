package net.mceq.mceverquest;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.mceq.mceverquest.entity.ModEntities;
import net.mceq.mceverquest.entity.client.ModModelLayers;

import net.mceq.mceverquest.entity.client.RatModel;
import net.mceq.mceverquest.entity.client.RatRenderer;

import net.mceq.mceverquest.entity.client.FireelementalModel;
import net.mceq.mceverquest.entity.client.FireelementalRenderer;

public class MCEverQuestClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.RAT, RatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.FIREELEMENTAL, FireelementalRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIREELEMENTAL, FireelementalModel::getTexturedModelData);

        //add here!
    }
}
