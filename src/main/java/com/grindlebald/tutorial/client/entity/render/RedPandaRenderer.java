package com.grindlebald.tutorial.client.entity.render;

import com.grindlebald.tutorial.Tutorial;
import com.grindlebald.tutorial.client.entity.model.RedPandaModel;
import com.grindlebald.tutorial.entities.RedPandaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RedPandaRenderer extends MobRenderer<RedPandaEntity, RedPandaModel<RedPandaEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Tutorial.MOD_ID, "textures/entity/red_panda.png");

    public RedPandaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RedPandaModel<>(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(RedPandaEntity entity) {
        return TEXTURE;
    }
}
