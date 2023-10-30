package mceq.mceverquest.client;

import mceq.mceverquest.Mceverquest;
import mceq.mceverquest.client.model.RatEntityModel;
import net.fabricmc.api.ClientModInitializer;
import mceq.mceverquest.client.renderer.RatEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MceverquestClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("mceverquest", "rat"), "main");
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Mceverquest.RAT, (context) -> {
            return new RatEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, RatEntityModel::getTexturedModelData);
    }
}
