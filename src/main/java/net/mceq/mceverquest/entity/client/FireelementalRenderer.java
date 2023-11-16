package net.mceq.mceverquest.entity.client;

import net.mceq.mceverquest.MCEverQuest;
import net.mceq.mceverquest.entity.custom.FireelementalEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FireelementalRenderer extends MobEntityRenderer<FireelementalEntity, FireelementalModel<FireelementalEntity>>{
    private static final Identifier TEXTURE = new Identifier(MCEverQuest.MOD_ID, "textures/entity/fireelementaltexture.png");

    public FireelementalRenderer(EntityRendererFactory.Context context) {
        super(context, new FireelementalModel<>(context.getPart(ModModelLayers.FIREELEMENTAL)), 0.6f);
    }

    @Override
    public Identifier getTexture(FireelementalEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FireelementalEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
