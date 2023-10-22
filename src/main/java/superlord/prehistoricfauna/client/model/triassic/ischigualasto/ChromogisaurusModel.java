package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;

public class ChromogisaurusModel extends EntityModel<Chromogisaurus> {
	private final ModelPart RightThigh;
	private final ModelPart LeftLeg_1;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail;

	public ChromogisaurusModel(ModelPart root) {
		this.RightThigh = root.getChild("RightThigh");
		this.LeftLeg_1 = RightThigh.getChild("LeftLeg_1");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Tail = Body.getChild("Tail");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(39, 0).addBox(-0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 15.0F, 2.0F));

		PartDefinition LeftLeg_1 = RightThigh.addOrReplaceChild("LeftLeg_1", CubeListBuilder.create().texOffs(60, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6F, 5.0F, 1.0F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(30, 0).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 15.0F, 2.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(60, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.6F, 5.0F, 1.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 2.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(12, 18).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.0F, -6.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(12, 18).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, -6.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -3.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.0F, -8.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 28).addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(31, 3).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 4.0F, -0.1F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 64);
	}

	@Override
	public void setupAnim(Chromogisaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Neck.xRot = headPitch * ((float)Math.PI / 180F);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.RightArm.zRot = Mth.cos(0.05F * ageInTicks) * 0.05F;
				this.LeftArm.zRot = -Mth.cos(0.05F * ageInTicks) * 0.05F;
				this.Tail.yRot = -Mth.cos(0.05F * ageInTicks) * 0.05F;
				this.Tail.xRot = -Mth.cos(0.1F * ageInTicks) * 0.1F;
				if (entity.isEating()) {
					this.Body.xRot = 0.2F;
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
				}
				if (entity.isInWater()) {
					this.RightThigh.y = 20;
					this.LeftThigh.y = 20;
					this.Body.y = 20;
					this.Body.xRot = -0.125F;
					this.Tail.xRot = 0.125F;
					this.Neck.xRot = 0.125F;
					this.LeftLeg_1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg_1.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Body
			//this.Body.y = 16;
			if (this.Body.y > 16) this.Body.y -= 0.15;
			if (this.Body.zRot < 0) this.Body.zRot += 0.05;
			//LeftLeg
			//this.LeftLeg.x = -0.6F;
			//this.LeftLeg.y = 5.0F;
			//this.LeftLeg.z = 1.0F;
			if (this.LeftLeg.x > -0.6) this.LeftLeg.x -= 0.15;
			if (this.LeftLeg.y < 5) this.LeftLeg.y += 0.15;
			if (this.LeftLeg.z < 1) this.LeftLeg.z += 0.15;
			if (this.LeftLeg.xRot > 0) this.LeftLeg.xRot -= 0.05;
			if (this.LeftLeg.yRot > 0) this.LeftLeg.yRot -= 0.05;
			//LeftArm
			//this.LeftArm.x = -1.5F;
			//this.LeftArm.y = 1.0F;
			//this.LeftArm.z = -6.0F;
			if (this.LeftArm.x < -1.5) this.LeftLeg.x += 0.15;
			if (this.LeftArm.y < 1) this.LeftArm.y += 0.15;
			if (this.LeftArm.z > -6) this.LeftArm.z -= 0.15;
			if (this.LeftArm.xRot < 0) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot < 0) this.LeftArm.yRot += 0.05;
			if (this.LeftArm.zRot > 0) this.LeftArm.zRot -= 0.05;
			//LeftThigh
			//this.LeftThigh.y = 15.0F;
			//this.LeftThigh.z = 2.0F;
			if (this.LeftThigh.x > 15) this.LeftThigh.x -= 0.15;
			if (this.LeftThigh.y > 2) this.LeftThigh.y -= 0.15;
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot > 0) this.LeftThigh.yRot -= 0.05;
			//RightThigh
			//this.RightThigh.y = 15.0F;
			//this.RightThigh.z = 2.0F;
			if (this.RightThigh.x > 15) this.RightThigh.x -= 0.15;
			if (this.RightThigh.y > 2) this.RightThigh.y -= 0.15;
			if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.yRot < 0) this.RightThigh.yRot += 0.05;
			//LeftLeg_1
			//this.LeftLeg_1.x = 0.6F;
			//this.LeftLeg_1.y = 5.0F;
			//this.LeftLeg_1.z = 1.0F;
			if (this.LeftLeg_1.x < 0.6) this.LeftLeg_1.x += 0.15;
			if (this.LeftLeg_1.y < 5) this.LeftLeg_1.y += 0.15;
			if (this.LeftLeg_1.z < 1) this.LeftLeg_1.z += 0.15;
			if (this.LeftLeg_1.zRot < 0) this.LeftLeg_1.zRot += 0.05;
			//RightArm
			//this.RightArm.x = 1.5F;
			//this.RightArm.y = 1.0F;
			//this.RightArm.z = -6.0F;
			if (this.RightArm.x > 1.5) this.RightArm.x -= 0.15;
			if (this.RightArm.y > 1) this.RightArm.y -= 0.15;
			if (this.RightArm.z > -6) this.RightArm.z -= 0.15;
			if (this.RightArm.xRot < 0) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot > 0) this.RightArm.yRot -= 0.05;
			if (this.RightArm.zRot < 0) this.RightArm.zRot += 0.05;
			//Neck
			//this.Neck.z = -8.0F;
			if (this.Neck.z > -8) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.05;
			//Tail
			//this.Tail.y = -0.9F;
			if (this.Tail.y > -0.9) this.Tail.y -= 0.15;
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Body
			//this.Body.y = 16;
			if (this.Body.y < 22) this.Body.y += 0.15;
			if (this.Body.zRot > -0.19547687289441354F) this.Body.zRot -= 0.05;
			//LeftLeg
			//this.LeftLeg.x = -0.6F;
			//this.LeftLeg.y = 5.0F;
			//this.LeftLeg.z = 1.0F;
			if (this.LeftLeg.x < -0.5) this.LeftLeg.x += 0.15;
			if (this.LeftLeg.y > 3.6) this.LeftLeg.y -= 0.15;
			if (this.LeftLeg.z > 0.9) this.LeftLeg.z -= 0.15;
			if (this.LeftLeg.xRot < 0.07836527941980377F) this.LeftLeg.xRot += 0.05;
			if (this.LeftLeg.yRot < 0.009250244536227243F) this.LeftLeg.yRot += 0.05;
			//LeftArm
			//this.LeftArm.x = -1.5F;
			//this.LeftArm.y = 1.0F;
			//this.LeftArm.z = -6.0F;
			if (this.LeftArm.x > -2.3) this.LeftLeg.x -= 0.15;
			if (this.LeftArm.y > 0.9) this.LeftArm.y -= 0.15;
			if (this.LeftArm.z < -5) this.LeftArm.z += 0.15;
			if (this.LeftArm.xRot > -1.6030848913251807F) this.LeftArm.xRot -= 0.05;
			if (this.LeftArm.yRot > -0.036477379868653376F) this.LeftArm.yRot -= 0.05;
			if (this.LeftArm.zRot < 0.6003932893176602F) this.LeftArm.zRot += 0.05;
			//LeftThigh
			//this.LeftThigh.y = 15.0F;
			//this.LeftThigh.z = 2.0F;
			if (this.LeftThigh.x < 23) this.LeftThigh.x += 0.15;
			if (this.LeftThigh.y < 5) this.LeftThigh.y += 0.15;
			if (this.LeftThigh.xRot > -1.6041321794238546F) this.LeftThigh.xRot -= 0.05;
			if (this.LeftThigh.yRot < 0.35185837453889574F) this.LeftThigh.yRot += 0.05;
			//RightThigh
			//this.RightThigh.y = 15.0F;
			//this.RightThigh.z = 2.0F;
			if (this.RightThigh.x < 23) this.RightThigh.x += 0.15;
			if (this.RightThigh.y < 5) this.RightThigh.y += 0.15;
			if (this.RightThigh.xRot > -1.5653858487242918F) this.RightThigh.xRot -= 0.05;
			if (this.RightThigh.yRot > -0.3127630032889644F) this.RightThigh.yRot -= 0.05;
			//LeftLeg_1
			//this.LeftLeg_1.x = 0.6F;
			//this.LeftLeg_1.y = 5.0F;
			//this.LeftLeg_1.z = 1.0F;
			if (this.LeftLeg_1.x > 0.5) this.LeftLeg_1.x -= 0.15;
			if (this.LeftLeg_1.y > 3.6) this.LeftLeg_1.y -= 0.15;
			if (this.LeftLeg_1.z > 0.9) this.LeftLeg_1.z -= 0.15;
			if (this.LeftLeg_1.zRot > -0.15620696472454113F) this.LeftLeg_1.zRot -= 0.05;
			//RightArm
			//this.RightArm.x = 1.5F;
			//this.RightArm.y = 1.0F;
			//this.RightArm.z = -6.0F;
			if (this.RightArm.x < 1.9) this.RightArm.x += 0.15;
			if (this.RightArm.y < 1.4) this.RightArm.y += 0.15;
			if (this.RightArm.z < -5.1) this.RightArm.z += 0.15;
			if (this.RightArm.xRot > -1.486671462175092F) this.RightArm.xRot -= 0.05;
			if (this.RightArm.yRot < 0.002617993982021224F) this.RightArm.yRot += 0.05;
			if (this.RightArm.zRot > -0.24015730906916136F) this.RightArm.zRot -= 0.05;
			//Neck
			//this.Neck.z = -8.0F;
			if (this.Neck.z < -7.1) this.Neck.z += 0.15;
			if (this.Neck.xRot < 0.23177972000431504F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.39357173300891585F) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot < 0.37262780195869205F) this.Neck.zRot += 0.05;
			//Tail
			//this.Tail.y = -0.9F;
			if (this.Tail.y < -0.4) this.Tail.y += 0.15;
			if (this.Tail.xRot > -0.1563815016444822F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot < 0.3127630032889644F) this.Tail.yRot += 0.05;
			if (this.Tail.zRot < 0.11903145798206952F) this.Tail.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Body.y = 16;
		this.Body.xRot = 0;
		this.Body.zRot = 0;
		this.LeftLeg.x = -0.6F;
		this.LeftLeg.y = 5.0F;
		this.LeftLeg.z = 1.0F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftArm.x = -1.5F;
		this.LeftArm.y = 1.0F;
		this.LeftArm.z = -6.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftThigh.y = 15.0F;
		this.LeftThigh.z = 2.0F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightThigh.y = 15.0F;
		this.RightThigh.z = 2.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.LeftLeg_1.x = 0.6F;
		this.LeftLeg_1.y = 5.0F;
		this.LeftLeg_1.z = 1.0F;
		this.LeftLeg_1.xRot = 0;
		this.LeftLeg_1.zRot = 0;
		this.RightArm.x = 1.5F;
		this.RightArm.y = 1.0F;
		this.RightArm.z = -6.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Neck.z = -8.0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail.y = -0.9F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 22;
		this.Body.zRot =  -0.19547687289441354F;
		this.LeftLeg.x = -0.5F;
		this.LeftLeg.y = 3.6F;
		this.LeftLeg.z = 0.9F;
		this.LeftLeg.xRot = 0.07836527941980377F;
		this.LeftLeg.zRot = 0.009250244536227243F;
		this.LeftArm.x = -2.3F;
		this.LeftArm.y = 0.9F;
		this.LeftArm.z = -5.0F;
		this.LeftArm.xRot = -1.6030848913251807F;
		this.LeftArm.yRot = -0.036477379868653376F;
		this.LeftArm.zRot = 0.6003932893176602F;
		this.LeftThigh.y = 23.0F;
		this.LeftThigh.z = 5.0F;
		this.LeftThigh.xRot = -1.6041321794238546F;
		this.LeftThigh.yRot = 0.35185837453889574F;
		this.RightThigh.y = 23.0F;
		this.RightThigh.z = 5.0F;
		this.RightThigh.xRot = -1.5653858487242918F;
		this.RightThigh.yRot = -0.3127630032889644F;
		this.LeftLeg_1.x = 0.5F;
		this.LeftLeg_1.y = 3.6F;
		this.LeftLeg_1.z = 0.9F;
		this.LeftLeg_1.zRot = -0.15620696472454113F;
		this.RightArm.x = 1.9F;
		this.RightArm.y = 1.4F;
		this.RightArm.z = -5.1F;
		this.RightArm.xRot = -1.486671462175092F;
		this.RightArm.yRot = 0.002617993982021224F;
		this.RightArm.zRot = -0.24015730906916136F;
		this.Neck.z = -7.1F;
		this.Neck.xRot = 0.23177972000431504F;
		this.Neck.yRot = -0.39357173300891585F;
		this.Neck.zRot = 0.37262780195869205F;
		this.Tail.y = -0.4F;
		this.Tail.xRot = -0.1563815016444822F;
		this.Tail.yRot = 0.3127630032889644F;
		this.Tail.zRot = 0.11903145798206952F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}