package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.ProtoceratopsEntity;

/**
 * Protoceratops - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ProtoceratopsModel extends EntityModel<ProtoceratopsEntity> {
	public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer FLegRight;
    public ModelRenderer FLegLeft;
    public ModelRenderer BLegLeft;
    public ModelRenderer BLegRight;
    public ModelRenderer Neck;
    public ModelRenderer Tailtip;
    public ModelRenderer FeetLeft;
    public ModelRenderer FeetRight;
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Crest;

    public ProtoceratopsModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.BLegRight = new ModelRenderer(this, 30, 35);
        this.BLegRight.mirror = true;
        this.BLegRight.setRotationPoint(-1.5F, 2.0F, 4.0F);
        this.BLegRight.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 48, 27);
        this.Beak.setRotationPoint(0.0F, -1.0F, -5.5F);
        this.Beak.addBox(-1.5F, -2.0F, -2.5F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 34, 0);
        this.Crest.setRotationPoint(0.0F, -2.0F, 0.5F);
        this.Crest.addBox(-5.5F, -7.5F, -1.4F, 11.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.47123889803846897F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Body.addBox(-2.5F, -3.0F, -4.0F, 5.0F, 9.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.FeetLeft = new ModelRenderer(this, 30, 46);
        this.FeetLeft.setRotationPoint(1.0F, 5.0F, 3.0F);
        this.FeetLeft.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.FLegRight = new ModelRenderer(this, 0, 0);
        this.FLegRight.setRotationPoint(1.5F, 5.0F, -2.0F);
        this.FLegRight.addBox(0.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.FLegLeft = new ModelRenderer(this, 0, 0);
        this.FLegLeft.mirror = true;
        this.FLegLeft.setRotationPoint(-1.5F, 5.0F, -2.0F);
        this.FLegLeft.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tailtip = new ModelRenderer(this, 20, 22);
        this.Tailtip.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.Tailtip.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 22);
        this.Tail.setRotationPoint(0.0F, 0.5F, 6.0F);
        this.Tail.addBox(-1.5F, -5.0F, -1.0F, 3.0F, 7.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.BLegLeft = new ModelRenderer(this, 30, 35);
        this.BLegLeft.setRotationPoint(1.5F, 2.0F, 4.0F);
        this.BLegLeft.addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.FeetRight = new ModelRenderer(this, 30, 46);
        this.FeetRight.mirror = true;
        this.FeetRight.setRotationPoint(-1.0F, 5.0F, 3.0F);
        this.FeetRight.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 43);
        this.Neck.setRotationPoint(0.0F, -1.5F, -4.0F);
        this.Neck.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 39, 12);
        this.Head.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.BLegRight);
        this.Head.addChild(this.Beak);
        this.Head.addChild(this.Crest);
        this.BLegLeft.addChild(this.FeetLeft);
        this.Body.addChild(this.FLegRight);
        this.Body.addChild(this.FLegLeft);
        this.Tail.addChild(this.Tailtip);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.BLegLeft);
        this.BLegRight.addChild(this.FeetRight);
        this.Body.addChild(this.Neck);
        this.Neck.addChild(this.Head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ProtoceratopsEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.BLegRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.BLegLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.FLegRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.FLegLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tailtip.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Tailtip.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		this.Head.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
