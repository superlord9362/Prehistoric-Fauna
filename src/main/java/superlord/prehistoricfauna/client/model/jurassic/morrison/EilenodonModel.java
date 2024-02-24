package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;

public class EilenodonModel extends EntityModel<Eilenodon> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart ArmL;
	private final ModelPart ArmR;
	private final ModelPart LegL;
	private final ModelPart LegR;
	private final ModelPart Tail;

	public EilenodonModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.ArmL = Body.getChild("ArmL");
		this.ArmR = Body.getChild("ArmR");
		this.LegL = Body.getChild("LegL");
		this.LegR = Body.getChild("LegR");
		this.Tail = Body.getChild("Tail");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 2.0F));

		PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(28, 5).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.0F, -4.0F));

		PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(35, 5).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.0F, 1.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.0F));

		PartDefinition HeadSpine = Neck.addOrReplaceChild("HeadSpine", CubeListBuilder.create().texOffs(9, 17).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -1.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition Dewlap = Head.addOrReplaceChild("Dewlap", CubeListBuilder.create().texOffs(9, 11).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(18, 11).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition BackSpine = Body.addOrReplaceChild("BackSpine", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -0.5F, -1.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -4.0F));

		PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(35, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -1.0F, 1.0F));

		PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -1.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Eilenodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//Body
			//this.Body.y = 22;
			if (this.Body.y < 23) this.Body.y += 0.15;
			//LegR
			//this.LegR.y = -1.0F;
			if (this.LegR.y < 1) this.LegR.y += 0.15;
			if (this.LegR.zRot > -1.5707963267948966F) this.LegR.zRot -= 0.05;
			//ArmR
			//this.ArmR.y = -1.0F;
			if (this.ArmR.y < 1) this.ArmR.y += 0.15;
			if (this.ArmR.zRot > -1.5707963267948966F) this.ArmR.zRot -= 0.05;
			//LegL
			//this.LegL.y = -1.0F;
			if (this.LegL.y < 1) this.LegL.y += 0.15;
			if (this.LegL.zRot < 1.5707963267948966F) this.LegL.zRot += 0.05;
			//ArmL
			//this.ArmL.y = -1.0F;
			if (this.ArmL.y < 1) this.ArmL.y += 0.15;
			if (this.ArmL.zRot < 1.5707963267948966F) this.ArmL.zRot += 0.05;
			//Neck
			//this.Neck.z = -5.0F;
			if (this.Neck.z < -4.8) this.Neck.z += 0.15;
			if (this.Neck.xRot < 0.19547687289441354F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 0.27366763203903305F) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > -1.2901473511162753F) this.Neck.zRot -= 0.05;
			sleepPose();
		} else if (entity.isSitting() && !entity.isAsleep()) {
			//Body
			if (this.Body.y < 23) this.Body.y += 0.15;
			//LegR
			if (this.LegR.y < 1) this.LegR.y += 0.15;
			if (this.LegR.zRot > -1.5707963267948966F) this.LegR.zRot -= 0.05;
			//ArmR
			if (this.ArmR.y < 1) this.ArmR.y += 0.15;
			if (this.ArmR.zRot > -1.5707963267948966F) this.ArmR.zRot -= 0.05;
			//LegL
			if (this.LegL.y < 1) this.LegL.y += 0.15;
			if (this.LegL.zRot < 1.5707963267948966F) this.LegL.zRot += 0.05;
			//ArmL
			if (this.ArmL.y < 1) this.ArmL.y += 0.15;
			if (this.ArmL.zRot < 1.5707963267948966F) this.ArmL.zRot += 0.05;
		} else {
			this.Neck.xRot = headPitch * ((float)Math.PI / 180F);
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LegL.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LegR.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.ArmL.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.ArmR.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck.xRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.ArmR.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.ArmL.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.LegL.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.LegR.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Body
			//this.Body.y = 22;
			if (this.Body.y > 22) this.Body.y -= 0.15;
			//LegR
			//this.LegR.y = -1.0F;
			if (this.LegR.y > -1) this.LegR.y -= 0.15;
			if (this.LegR.zRot < 0) this.LegR.zRot += 0.05;
			//ArmR
			//this.ArmR.y = -1.0F;
			if (this.ArmR.y > -1) this.ArmR.y -= 0.15;
			if (this.ArmR.zRot < 0) this.ArmR.zRot += 0.05;
			//LegL
			//this.LegL.y = -1.0F;
			if (this.LegL.y > -1) this.LegL.y -= 0.15;
			if (this.LegL.zRot > 0) this.LegL.zRot -= 0.05;
			//ArmL
			//this.ArmL.y = -1.0F;
			if (this.ArmL.y > -1) this.ArmL.y -= 0.15;
			if (this.ArmL.zRot > 0) this.ArmL.zRot -= 0.05;
			//Neck
			//this.Neck.z = -5.0F;
			if (this.Neck.z > -5) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot < 0) this.Neck.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Body.y = 22;
		this.LegR.y = -1.0F;
		this.LegR.zRot = 0;
		this.LegR.xRot = 0;
		this.LegR.yRot = 0;
		this.ArmR.y = -1.0F;
		this.ArmR.zRot = 0;
		this.ArmR.xRot = 0;
		this.ArmR.yRot = 0;
		this.LegL.y = -1.0F;
		this.LegL.zRot = 0;
		this.LegL.xRot = 0;
		this.LegL.yRot = 0;
		this.ArmL.y = -1.0F;
		this.ArmL.zRot = 0;
		this.ArmL.xRot = 0;
		this.ArmL.yRot = 0;
		this.Neck.xRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Neck.z = -5.0F;
	}

	public void sleepPose() {
		this.Body.y = 23;
		this.LegR.y = 1;
		this.LegR.zRot = -1.5707963267948966F;
		this.ArmR.y = 1;
		this.ArmR.zRot = -1.5707963267948966F;
		this.LegL.y = 1;
		this.LegL.zRot = 1.5707963267948966F;
		this.ArmL.y = 1;
		this.ArmL.zRot = 1.5707963267948966F;
		this.Neck.z = -4.8F;
		this.Neck.xRot = 0.19547687289441354F;
		this.Neck.yRot = 0.27366763203903305F;
		this.Neck.zRot = -1.2901473511162753F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}