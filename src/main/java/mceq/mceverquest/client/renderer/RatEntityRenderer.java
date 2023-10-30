package mceq.mceverquest.client.renderer;

import mceq.mceverquest.client.MceverquestClient;
import mceq.mceverquest.client.model.RatEntityModel;
import mceq.mceverquest.entity.RatEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RatEntityRenderer extends MobEntityRenderer<RatEntity, RatEntityModel>{
    public RatEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RatEntityModel(context.getPart(MceverquestClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(RatEntity entity) {
        return new Identifier("mceverquest", "entity/rat/rat.png");
    }
}
