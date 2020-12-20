package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.SaurosuchusEntity;

/**
 * Saurosuchus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Saurosuchus extends EntityModel<SaurosuchusEntity> {
	public ModelRenderer Body;
	public ModelRenderer Osteos;
	public ModelRenderer Arm;
	public ModelRenderer Thigh;
	public ModelRenderer Neck;
	public ModelRenderer Arm_1;
	public ModelRenderer Thigh_1;
	public ModelRenderer Tail;
	public ModelRenderer Calf;
	public ModelRenderer Foot;
	public ModelRenderer Osteos2;
	public ModelRenderer Head;
	public ModelRenderer Snout;
	public ModelRenderer Jaw;
	public ModelRenderer SnoutTeeth;
	public ModelRenderer JawSnout;
	public ModelRenderer Cheek;
	public ModelRenderer JawTeeth;
	public ModelRenderer Calf_1;
	public ModelRenderer Foot_1;
	public ModelRenderer Tail2;
	public ModelRenderer osteos3;

	public Saurosuchus() {
		this.textureWidth = 200;
		this.textureHeight = 200;
		this.Thigh_1 = new ModelRenderer(this, 11, 15);
		this.Thigh_1.setRotationPoint(-2.0F, -1.0F, 12.0F);
		this.Thigh_1.addBox(-5.0F, -2.0F, -9.0F, 5.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Foot = new ModelRenderer(this, 83, 0);
		this.Foot.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.Foot.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 133, 0);
		this.Head.setRotationPoint(0.0F, 0.0F, -10.0F);
		this.Head.addBox(-3.5F, -4.0F, -8.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Arm_1 = new ModelRenderer(this, 180, 19);
		this.Arm_1.setRotationPoint(-2.6F, -1.0F, -17.0F);
		this.Arm_1.addBox(-4.0F, 0.0F, -2.0F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 0, 48);
		this.Tail2.setRotationPoint(0.0F, 1.0F, 20.0F);
		this.Tail2.addBox(-2.0F, -3.0F, 1.0F, 4.0F, 5.0F, 40.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 97, 0);
		this.Neck.setRotationPoint(0.0F, -3.0F, -20.0F);
		this.Neck.addBox(-4.0F, -4.0F, -10.0F, 8.0F, 10.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.Cheek = new ModelRenderer(this, 161, 13);
		this.Cheek.setRotationPoint(0.0F, -1.85F, 0.0F);
		this.Cheek.addBox(-2.5F, -2.0F, -7.0F, 5.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Calf_1 = new ModelRenderer(this, 59, 19);
		this.Calf_1.setRotationPoint(-2.5F, 10.0F, -5.0F);
		this.Calf_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Foot_1 = new ModelRenderer(this, 98, 20);
		this.Foot_1.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.Foot_1.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.SnoutTeeth = new ModelRenderer(this, 180, 6);
		this.SnoutTeeth.setRotationPoint(0.0F, 1.0F, 0.1F);
		this.SnoutTeeth.addBox(-1.5F, -1.0F, -8.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(SnoutTeeth, 0.13962634015954636F, 0.0F, 0.0F);
		this.Calf = new ModelRenderer(this, 18, 0);
		this.Calf.setRotationPoint(2.5F, 10.0F, -5.0F);
		this.Calf.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Jaw = new ModelRenderer(this, 75, 12);
		this.Jaw.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.Jaw.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Arm = new ModelRenderer(this, 0, 0);
		this.Arm.setRotationPoint(2.6F, -1.0F, -17.0F);
		this.Arm.addBox(0.0F, 0.0F, -2.0F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Osteos2 = new ModelRenderer(this, 0, 101);
		this.Osteos2.setRotationPoint(0.0F, -5.0F, -10.0F);
		this.Osteos2.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 8.0F, 6.0F);
		this.Body.addBox(-6.0F, -8.0F, -21.0F, 12.0F, 13.0F, 35.0F, 0.0F, 0.0F, 0.0F);
		this.JawSnout = new ModelRenderer(this, 125, 13);
		this.JawSnout.setRotationPoint(0.0F, 2.0F, -9.0F);
		this.JawSnout.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.osteos3 = new ModelRenderer(this, 0, 84);
		this.osteos3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.osteos3.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 163, 0);
		this.Snout.setRotationPoint(0.0F, 0.0F, -8.0F);
		this.Snout.addBox(-2.0F, -3.0F, -8.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.JawTeeth = new ModelRenderer(this, 141, 13);
		this.JawTeeth.setRotationPoint(0.0F, -1.0F, 0.1F);
		this.JawTeeth.addBox(-1.5F, -1.0F, -7.0F, 3.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Thigh = new ModelRenderer(this, 59, 0);
		this.Thigh.setRotationPoint(2.0F, -1.0F, 12.0F);
		this.Thigh.addBox(0.0F, -2.0F, -9.0F, 5.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 101, 23);
		this.Tail.setRotationPoint(0.0F, -4.0F, 14.0F);
		this.Tail.addBox(-4.0F, -3.0F, 0.0F, 8.0F, 9.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.Osteos = new ModelRenderer(this, 0, 65);
		this.Osteos.setRotationPoint(0.0F, -9.0F, -21.0F);
		this.Osteos.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 35.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.Thigh_1);
		this.Calf.addChild(this.Foot);
		this.Neck.addChild(this.Head);
		this.Body.addChild(this.Arm_1);
		this.Tail.addChild(this.Tail2);
		this.Body.addChild(this.Neck);
		this.Jaw.addChild(this.Cheek);
		this.Thigh_1.addChild(this.Calf_1);
		this.Calf_1.addChild(this.Foot_1);
		this.Snout.addChild(this.SnoutTeeth);
		this.Thigh.addChild(this.Calf);
		this.Head.addChild(this.Jaw);
		this.Body.addChild(this.Arm);
		this.Neck.addChild(this.Osteos2);
		this.Jaw.addChild(this.JawSnout);
		this.Tail.addChild(this.osteos3);
		this.Head.addChild(this.Snout);
		this.JawSnout.addChild(this.JawTeeth);
		this.Body.addChild(this.Thigh);
		this.Body.addChild(this.Tail);
		this.Body.addChild(this.Osteos);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(SaurosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.Thigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Thigh_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Arm_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
