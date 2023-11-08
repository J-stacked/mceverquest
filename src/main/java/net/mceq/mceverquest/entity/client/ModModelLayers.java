package net.mceq.mceverquest.entity.client;

import net.mceq.mceverquest.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer RAT =
            new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "rat"), "main");
}
