package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;

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
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick) * 2.0F;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.FLegRight.rotateAngleX = 0;
		this.FLegRight.rotateAngleY = 0;
		this.FLegRight.rotateAngleZ = 0;
		this.FeetRight.rotateAngleX = 0;
		this.FeetRight.rotateAngleY = 0;
		this.FeetRight.rotateAngleZ = 0;
		this.BLegLeft.rotateAngleX = 0;
		this.BLegLeft.rotateAngleY = 0;
		this.BLegLeft.rotateAngleZ = 0;
		this.BLegRight.rotateAngleX = 0;
		this.BLegRight.rotateAngleY = 0;
		this.BLegRight.rotateAngleZ = 0;
		this.FLegLeft.rotateAngleX = 0;
		this.FLegLeft.rotateAngleY = 0;
		this.FLegRight.rotateAngleZ = 0;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleY = 0;
		this.Body.rotateAngleZ = 0;
		this.FeetLeft.rotateAngleX = 0;
		this.FeetLeft.rotateAngleY = 0;
		this.Tailtip.rotateAngleX = 0;
		this.Tailtip.rotateAngleY = 0;
		this.Tailtip.rotateAngleZ = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Body.rotationPointX = 0;
		this.Body.rotationPointY = 13;
		this.BLegLeft.rotationPointX = 1.5F;
		this.BLegLeft.rotationPointY = 2F;
		this.BLegLeft.rotationPointZ = 4F;
		this.BLegRight.rotationPointX = -1.5F;
		this.BLegRight.rotationPointY = 2F;
		this.BLegRight.rotationPointZ = 4F;
		this.Neck.rotationPointX = 0;
		this.Neck.rotationPointY = -1.5F;
		this.Head.rotationPointX = 0;
		this.Head.rotationPointY = 1;
		this.Head.rotationPointZ = -2F;
		if (entityIn.isAsleep()) {
			this.Body.rotationPointX = -1.1F;
			this.Body.rotationPointY = 21.1F;
			this.BLegLeft.rotationPointX = 2.2F;
			this.BLegLeft.rotationPointY = 3.8F;
			this.BLegLeft.rotationPointZ = 4.1F;
			this.BLegRight.rotationPointX = -1.2F;
			this.BLegRight.rotationPointY = 1F;
			this.BLegRight.rotationPointZ = 4.3F;
			this.Neck.rotationPointX = 0.4F;
			this.Neck.rotationPointY = -1;
			this.Head.rotationPointX = 0.4F;
			this.Head.rotationPointY = 2;
			this.Head.rotationPointZ = -4.2F;
			this.Head.rotateAngleX = 0.14556046227948816F;
			this.Head.rotateAngleY = -0.5473352640780661F;
			this.Head.rotateAngleZ = 0.9121090377974647F;
			this.FLegRight.rotateAngleX = 0.037175515064850034F;
			this.FLegRight.rotateAngleY = 0.07278023113974408F;
			this.FLegRight.rotateAngleZ = 1.2039281766152325F;
			this.FeetRight.rotateAngleX = -0.291993575869168F;
			this.FeetRight.rotateAngleY = 3.141592653589793F;
			this.FeetRight.rotateAngleZ = -1.7453292129831807E-4F;
			this.BLegLeft.rotateAngleX = -0.1090830782496456F;
			this.BLegLeft.rotateAngleY = 0.03630284710990151F;
			this.BLegLeft.rotateAngleZ = 0.8389797661073521F;
			this.BLegRight.rotateAngleX = 0.7298966878577064F;
			this.BLegRight.rotateAngleY = -0.055326938619800786F;
			this.BLegRight.rotateAngleZ = 0.12740903872453743F;
			this.FLegLeft.rotateAngleX = -0.9861110273767961F;
			this.FLegLeft.rotateAngleY = 0.07312929665724782F;
			this.FLegLeft.rotateAngleZ = 0.1090830782496456F;
			this.Body.rotateAngleX = -1.7453292129831807E-4F;
			this.Body.rotateAngleY = -0.0015707963892127347F;
			this.Body.rotateAngleZ = -1.680228412305397F;
			this.FeetLeft.rotateAngleX = 0.8402014912574258F;
			this.FeetLeft.rotateAngleY = 3.141592653589793F;
			this.Tailtip.rotateAngleX = -0.36477380700891215F;
			this.Tailtip.rotateAngleY = 0.07295475973730675F;
			this.Tailtip.rotateAngleZ = -0.1096066806870904F;
			this.Tail.rotateAngleX = 0.291819038949227F;
			this.Tail.rotateAngleY = -0.18256144042439712F;
			this.Tail.rotateAngleZ = 0.2183406934192323F;
			this.Neck.rotateAngleX = 0.18238690350445608F;
			this.Neck.rotateAngleY = 0.1096066806870904F;
			this.Neck.rotateAngleZ = 0.3281218860591285F;
		}
		else {
			this.Neck.rotateAngleX = 0;
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
			this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount) + attackProgress * (float) Math.toRadians(25F);
			if (entityIn.isEating()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
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
