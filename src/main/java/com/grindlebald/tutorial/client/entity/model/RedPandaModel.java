package com.grindlebald.tutorial.client.entity.model;

import com.grindlebald.tutorial.entities.RedPandaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class RedPandaModel<T extends RedPandaEntity> extends net.minecraft.client.renderer.entity.model.EntityModel<com.grindlebald.tutorial.entities.RedPandaEntity> {
    private final ModelRenderer head2;
    private final ModelRenderer mouth;
    private final ModelRenderer body;
    private final ModelRenderer body_rotation;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer tail;
    private final ModelRenderer tail_rotation;

    public RedPandaModel() {
        textureWidth = 64;
        textureHeight = 64;

        head2 = new ModelRenderer(this);
        head2.setRotationPoint(0.0F, 17.0F, -1.9F);
        head2.setTextureOffset(16, 0).addBox(-3.0F, -2.25F, -3.1F, 6.0F, 5.0F, 3.0F, 0.0F, false);
        head2.setTextureOffset(0, 31).addBox(2.0F, -3.25F, -2.1F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head2.setTextureOffset(16, 24).addBox(-4.0F, -3.25F, -2.1F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head2.setTextureOffset(12, 31).addBox(-1.0F, 0.75F, -4.1F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setRotationPoint(0.0F, 2.25F, -0.1F);
        head2.addChild(mouth);
        setRotationAngle(mouth, 0.1745F, 0.0F, 0.0F);
        mouth.setTextureOffset(6, 31).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 7.5F, 3.5F);


        body_rotation = new ModelRenderer(this);
        body_rotation.setRotationPoint(0.0F, 9.0F, -0.5F);
        body.addChild(body_rotation);
        setRotationAngle(body_rotation, 1.5708F, 0.0F, 0.0F);
        body_rotation.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -3.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(-2.0F, 19.0F, 5.0F);
        leg1.setTextureOffset(8, 24).addBox(-1.001F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(2.0F, 18.75F, 5.0F);
        leg2.setTextureOffset(0, 24).addBox(-1.0F, 0.25F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(-2.0F, 18.75F, 0.0F);
        leg3.setTextureOffset(16, 13).addBox(-1.001F, 0.25F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(2.0F, 18.8F, 0.0F);
        leg4.setTextureOffset(8, 13).addBox(-0.999F, 0.2F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 17.75F, 7.0F);


        tail_rotation = new ModelRenderer(this);
        tail_rotation.setRotationPoint(0.0F, -2.25F, 4.5F);
        tail.addChild(tail_rotation);
        setRotationAngle(tail_rotation, 1.2217F, 0.0F, 0.0F);
        tail_rotation.setTextureOffset(0, 13).addBox(-1.0F, -3.987F, -4.8794F, 2.0F, 9.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(RedPandaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head2.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head2.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body_rotation.rotateAngleX = ((float)Math.PI / 2F);
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head2.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
