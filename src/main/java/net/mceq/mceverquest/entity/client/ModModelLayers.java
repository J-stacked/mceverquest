package net.mceq.mceverquest.entity.client;

import net.mceq.mceverquest.MCEverQuest;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer RAT =
            new EntityModelLayer(new Identifier(MCEverQuest.MOD_ID, "rat"), "main");

    public static final EntityModelLayer FIREELEMENTAL =
            new EntityModelLayer(new Identifier(MCEverQuest.MOD_ID, "fireelemental"), "main");

    //add new here
}
