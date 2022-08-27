package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;

/**
 * Telmasaurus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TelmasaurusModel extends EntityModel<TelmasaurusEntity> implements IHasArm {
    public ModelRenderer Body;
    public ModelRenderer Frontlegright;
    public ModelRenderer Frontlegleft;
    public ModelRenderer Backlegright;
    public ModelRenderer Backlegleft;
    public ModelRenderer Head;
    public ModelRenderer Tail;
    public ModelRenderer Tongue;
    public ModelRenderer Frontfootright;
    public ModelRenderer Frontfootleft;
    public ModelRenderer Backfootright;
    public ModelRenderer Backfootleft;

    public TelmasaurusModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Backlegleft = new ModelRenderer(this, 0, 28);
        this.Backlegleft.setRotationPoint(1.0F, 20.7F, 4.0F);
        this.Backlegleft.addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Frontfootright = new ModelRenderer(this, 0, 0);
        this.Frontfootright.mirror = true;
        this.Frontfootright.setRotationPoint(-1.0F, 3.29F, 1.0F);
        this.Frontfootright.setTextureOffset(17, 26).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Frontfootright, 0.0F, 0.7853981633974483F, 0.0F);
        this.Tongue = new ModelRenderer(this, 32, 9);
        this.Tongue.setRotationPoint(0.0F, 0.0F, -5.8F);
        this.Tongue.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tongue, 0.11623892551966127F, 0.0F, 0.0F);
        this.Backfootright = new ModelRenderer(this, 0, 0);
        this.Backfootright.mirror = true;
        this.Backfootright.setRotationPoint(0.0F, 3.29F, 0.0F);
        this.Backfootright.setTextureOffset(16, 30).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 19.7F, -2.0F);
        this.Body.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 22);
        this.Tail.setRotationPoint(0.0F, 0.5F, 9.0F);
        this.Tail.addBox(-1.0F, -1.2F, -0.4F, 2.0F, 2.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 29, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, -4.2F);
        this.Head.addBox(-1.0F, -1.0F, -5.8F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Backlegright = new ModelRenderer(this, 0, 28);
        this.Backlegright.setRotationPoint(-1.0F, 20.7F, 4.0F);
        this.Backlegright.addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Backfootleft = new ModelRenderer(this, 0, 0);
        this.Backfootleft.setRotationPoint(0.0F, 3.29F, 0.0F);
        this.Backfootleft.setTextureOffset(16, 30).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Frontlegleft = new ModelRenderer(this, 0, 20);
        this.Frontlegleft.setRotationPoint(1.0F, 20.7F, -4.0F);
        this.Frontlegleft.addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Frontlegright = new ModelRenderer(this, 0, 20);
        this.Frontlegright.setRotationPoint(-1.0F, 20.7F, -4.0F);
        this.Frontlegright.addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Frontfootleft = new ModelRenderer(this, 0, 0);
        this.Frontfootleft.setRotationPoint(1.0F, 3.29F, 1.0F);
        this.Frontfootleft.setTextureOffset(17, 26).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Frontfootleft, 0.0F, -0.7853981633974483F, 0.0F);
        this.Frontlegright.addChild(this.Frontfootright);
        this.Head.addChild(this.Tongue);
        this.Backlegright.addChild(this.Backfootright);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Head);
        this.Backlegleft.addChild(this.Backfootleft);
        this.Frontlegleft.addChild(this.Frontfootleft);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Backlegleft, this.Body, this.Backlegright, this.Frontlegleft, this.Frontlegright).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
	public void setRotationAngles(TelmasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		this.Body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
		this.Tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.05F * ageInTicks / 5))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
		this.Tail.rotateAngleY = (-0.12F * MathHelper.sin(0.05F * ageInTicks / 5)) + (MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.Tail.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
		this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
		this.Backlegleft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
		this.Backlegright.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
		this.Frontlegleft.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.Frontlegright.rotateAngleX = MathHelper.cos(5.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		float f = sideIn == HandSide.RIGHT ? 1.0F : -1.0F;
		ModelRenderer modelrenderer = this.getArmForSide(sideIn);
		modelrenderer.rotationPointX += f;
		modelrenderer.translateRotate(matrixStackIn);
		modelrenderer.rotationPointX -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.Head : this.Head;
	}
}
