package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;

/**
 * Citipati - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CitipatiModel extends EntityModel<CitipatiEntity> {
	public ModelRenderer Body;
	public ModelRenderer Neck;
	public ModelRenderer WingLeft;
	public ModelRenderer WingRight;
	public ModelRenderer Tail;
	public ModelRenderer ThighLeft;
	public ModelRenderer ThighRight;
	public ModelRenderer Head;
	public ModelRenderer Crest;
	public ModelRenderer TailFan;
	public ModelRenderer LegLeft;
	public ModelRenderer LegRight;

	public CitipatiModel() {
		this.textureWidth = 64;
		this.textureHeight = 80;
		this.LegRight = new ModelRenderer(this, 0, 60);
		this.LegRight.mirror = true;
		this.LegRight.setRotationPoint(-1.5F, 8.0F, 4.0F);
		this.LegRight.addBox(-1.0F, 0.0F, -4.0F, 3.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 6.0F, -4.0F);
		this.Body.addBox(-2.5F, -3.0F, -7.0F, 5.0F, 8.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.WingLeft = new ModelRenderer(this, 42, 21);
		this.WingLeft.mirror = true;
		this.WingLeft.setRotationPoint(2.0F, 0.9F, -3.0F);
		this.WingLeft.addBox(0.0F, -1.0F, -2.0F, 2.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Crest = new ModelRenderer(this, 41, 2);
		this.Crest.setRotationPoint(0.0F, -1.0F, -4.0F);
		this.Crest.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.ThighLeft = new ModelRenderer(this, 0, 44);
		this.ThighLeft.mirror = true;
		this.ThighLeft.setRotationPoint(1.0F, 1.0F, 6.0F);
		this.ThighLeft.addBox(0.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.ThighRight = new ModelRenderer(this, 0, 44);
		this.ThighRight.setRotationPoint(-1.0F, 1.0F, 6.0F);
		this.ThighRight.addBox(-3.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.WingRight = new ModelRenderer(this, 42, 21);
		this.WingRight.setRotationPoint(-2.0F, 1.0F, -3.0F);
		this.WingRight.addBox(-2.0F, -1.0F, -2.0F, 2.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 40, 6);
		this.Tail.setRotationPoint(0.0F, -0.5F, 12.0F);
		this.Tail.addBox(-2.0F, -2.0F, -1.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.TailFan = new ModelRenderer(this, 0, 27);
		this.TailFan.setRotationPoint(0.0F, -0.5F, 7.5F);
		this.TailFan.addBox(-2.5F, -1.0F, -1.0F, 5.0F, 3.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 0);
		this.Neck.setRotationPoint(0.0F, -1.0F, -7.0F);
		this.Neck.addBox(-1.5F, -11.0F, -2.0F, 3.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.LegLeft = new ModelRenderer(this, 0, 60);
		this.LegLeft.setRotationPoint(1.5F, 8.0F, 4.0F);
		this.LegLeft.addBox(-2.0F, 0.0F, -4.0F, 3.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 29, 0);
		this.Head.setRotationPoint(0.0F, -11.0F, 0.0F);
		this.Head.addBox(-1.0F, -2.0F, -6.0F, 2.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.ThighRight.addChild(this.LegRight);
		this.Body.addChild(this.WingLeft);
		this.Head.addChild(this.Crest);
		this.Body.addChild(this.ThighLeft);
		this.Body.addChild(this.ThighRight);
		this.Body.addChild(this.WingRight);
		this.Body.addChild(this.Tail);
		this.Tail.addChild(this.TailFan);
		this.Body.addChild(this.Neck);
		this.ThighLeft.addChild(this.LegLeft);
		this.Neck.addChild(this.Head);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(CitipatiEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.ThighLeft.rotationPointY = 1F;
		this.ThighRight.rotationPointY = 1F;
		this.Neck.rotateAngleX = 0;
		this.Body.rotateAngleX = 0;
		this.WingRight.rotateAngleX = 0;
		this.WingRight.rotateAngleY = 0;
		this.WingRight.rotateAngleZ = 0;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.ThighLeft.rotateAngleX = 0;
		this.ThighLeft.rotateAngleY = 0;
		this.TailFan.rotateAngleX = 0;
		this.TailFan.rotateAngleY = 0;
		this.TailFan.rotateAngleZ = 0;
		this.ThighRight.rotateAngleX = 0;
		this.ThighRight.rotateAngleY = 0;
		this.WingLeft.rotateAngleX = 0;
		this.WingLeft.rotateAngleY = 0;
		this.WingLeft.rotateAngleZ = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.LegLeft.rotateAngleX = 0;
		this.LegLeft.rotateAngleY = 0;
		this.LegLeft.rotateAngleZ = 0;
		this.LegRight.rotateAngleX = 0;
		this.LegRight.rotateAngleY = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Body.rotationPointY = 6;
		if (entityIn.isAsleep() || entityIn.isSitting()) {
			this.Body.rotationPointY = 16.9F;
			this.WingRight.rotateAngleX = 0.39025563139857644F;
			this.WingRight.rotateAngleY = -0.5866051722479385F;
			this.WingRight.rotateAngleZ = 0.7428121536172364F;
			this.Head.rotateAngleX = 0.9773843811168246F;
			this.Head.rotateAngleY = 0.11728612207217244F;
			this.ThighLeft.rotateAngleX = -1.0950196019960143F;
			this.ThighLeft.rotateAngleY = -0.35185837453889574F;
			this.TailFan.rotateAngleX = 0.0781907508222411F;
			this.TailFan.rotateAngleY = -0.27366763203903305F;
			this.TailFan.rotateAngleZ = -0.11728612207217244F;
			this.ThighRight.rotateAngleX = -1.1730357742864224F;
			this.ThighRight.rotateAngleY = 0.4300491170387584F;
			this.Body.rotateAngleX = -0.3909537457888271F;
			this.WingLeft.rotateAngleX = 0.15690509575954859F;
			this.WingLeft.rotateAngleY = 0.7429866572476639F;
			this.WingLeft.rotateAngleZ = -0.8990190684075072F;
			this.Neck.rotateAngleX = -0.35185837453889574F;
			this.Neck.rotateAngleY = 0.23457224414434488F;
			this.Neck.rotateAngleZ = -0.0781907508222411F;
			this.LegLeft.rotateAngleX = 0.16580627893946132F;
			this.LegLeft.rotateAngleY = 3.1398472178113552F;
			this.LegLeft.rotateAngleZ = 0.0607374583022978F;
			this.LegRight.rotateAngleX = 0.03874630989361682F;
			this.LegRight.rotateAngleY = 3.141592653589793F;
			this.Tail.rotateAngleX = 0.23457224414434488F;
			this.Tail.rotateAngleY = -0.19547687289441354F;
		} else {
			float partialTick = ageInTicks - entityIn.ticksExisted;
			float attackProgress = entityIn.getMeleeProgress(partialTick);
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.ThighRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.ThighLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.TailFan.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.TailFan.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Head.rotateAngleX = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.WingLeft.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.WingRight.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			if (entityIn.isEating()) {
				this.Body.rotateAngleX = 0.5F;
				this.ThighLeft.rotateAngleX = -0.5F;
				this.ThighRight.rotateAngleX = -0.5F;
				this.ThighLeft.rotationPointY = 4F;
				this.ThighRight.rotationPointY = 4F;
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
		}
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
