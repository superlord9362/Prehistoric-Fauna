package superlord.prehistoricfauna.client.model.cretaceous.yixian;

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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Psittacosaurus;

public class PsittacosaurusModel extends EntityModel<Psittacosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public PsittacosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -4.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(25, 21).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition LeftQuillFan = Tail2.addOrReplaceChild("LeftQuillFan", CubeListBuilder.create().texOffs(18, 46).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightQuillFan = Tail2.addOrReplaceChild("RightQuillFan", CubeListBuilder.create().texOffs(18, 46).mirror().addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -5.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -3.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(27, 1).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(45, 2).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition JugalHorns = Head.addOrReplaceChild("JugalHorns", CubeListBuilder.create().texOffs(41, 13).addBox(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(31, 40).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 4.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 40).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 4.0F, 0.0F));

		PartDefinition Knife = LeftArm.addOrReplaceChild("Knife", CubeListBuilder.create().texOffs(44, 17).addBox(0.0F, 0.0F, -6.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.6F, -0.2F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 2.0F, 7.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(3, 53).mirror().addBox(-1.5F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 58).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(15, 37).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 7.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(10, 53).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(7, 58).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Psittacosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//LeftLeg
			if (this.LeftLeg.xRot > -0.45378560551852565F) this.LeftLeg.xRot -= 0.05;
			//LeftThigh
			//this.LeftThigh.y = 5.0F;
			if (this.LeftThigh.y > 3.2) this.LeftThigh.y -= 0.15;
			if (this.LeftThigh.xRot > -0.8726646259971648F) this.LeftThigh.xRot -= 0.05;
			if (this.LeftThigh.yRot > -0.296705972839036F) this.LeftThigh.yRot -= 0.05;
			//LeftArm
			//this.LeftArm.z = 3;
			if (this.LeftArm.z > 2.5) this.LeftArm.z -= 0.15;
			if (this.LeftArm.xRot < 0.8726646259971648F) this.LeftArm.xRot += 0.05;
			//LeftFoot
			if (this.LeftFoot.xRot < 1.5707963267948966F) this.LeftFoot.xRot += 0.05;
			//RightFoot
			if (this.RightFoot.xRot < 1.5707963267948966F) this.RightFoot.xRot += 0.05;
			//Body
			//this.Body.y = 5;
			if (this.Body.y < 12) this.Body.y += 0.15;
			if (this.Body.xRot > -0.24434609527920614F) this.Body.xRot -= 0.05;
			//Tail2
			//this.Tail2.x = 0.0F;
			//this.Tail2.z = 15;
			if (this.Tail2.x < 0.5) this.Tail2.x += 0.15;
			if (this.Tail2.z > 14.4) this.Tail2.z -= 0.15;
			if (this.Tail2.xRot < 0.13962634015954636F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > -0.593411945678072F) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > -0.10471975511965977F) this.Tail2.zRot -= 0.05;
			//RightThigh
			//this.RightThigh.y = 5;
			if (this.RightThigh.y > 3.2) this.RightThigh.y -= 0.15;
			if (this.RightThigh.xRot > -0.8726646259971648F) this.RightThigh.xRot -= 0.05;
			if (this.RightThigh.yRot < 0.296705972839036F) this.RightThigh.yRot += 0.05;
			//Neck
			if (this.Neck.xRot < 0.8726646259971648F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 0.9773843811168246F) this.Neck.yRot += 0.05;
			//RightLeg
			if (this.RightLeg.xRot > -0.45378560551852565F) this.RightLeg.xRot -= 0.05;
			//RightArm
			//this.RightArm.z = 3.0F;
			if (this.RightArm.z > 2.5) this.RightArm.z -= 0.15;
			if (this.RightArm.xRot < 0.8726646259971648F) this.RightArm.xRot += 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.z = 19;
			if (this.Tail1.x < 0.7) this.Tail1.x += 0.15;
			if (this.Tail1.z > 18) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot < 0.07853981633974483F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > -0.593411945678072F) this.Tail1.yRot -= 0.05;
			if (this.Tail1.zRot > -0.10471975511965977F) this.Tail1.zRot -= 0.05;
			this.sleepPose();
		} else {
			this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.Body.y = 10;
				this.Body.xRot = -0.5F;
				this.Tail1.xRot = 0.25F;
				this.Tail2.xRot = 0.25F;
				this.Neck.xRot = 0.5F;
				this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftArm.xRot = 0.5F;
				this.RightArm.xRot = 0.5F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LeftLeg
			if (this.LeftLeg.xRot < 0) this.LeftLeg.xRot += 0.05;
			//LeftThigh
			//this.LeftThigh.y = 5.0F;
			if (this.LeftThigh.y < 5) this.LeftThigh.y += 0.15;
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot < 0) this.LeftThigh.yRot += 0.05;
			//LeftArm
			//this.LeftArm.z = 3;
			if (this.LeftArm.z < 3) this.LeftArm.z += 0.15;
			if (this.LeftArm.xRot > 0) this.LeftArm.xRot -= 0.05;
			//LeftFoot
			if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
			//RightFoot
			if (this.RightFoot.xRot > 0) this.RightFoot.xRot -= 0.05;
			//Body
			//this.Body.y = 5;
			if (this.Body.y > 5) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//Tail2
			//this.Tail2.x = 0.0F;
			//this.Tail2.z = 15;
			if (this.Tail2.x > 0) this.Tail2.x -= 0.15;
			if (this.Tail2.z < 15) this.Tail2.z += 0.15;
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot < 0) this.Tail2.zRot += 0.05;
			//RightThigh
			//this.RightThigh.y = 5;
			if (this.RightThigh.y < 5) this.RightThigh.y += 0.15;
			if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.yRot > 0) this.RightThigh.yRot -= 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			//Head
			//this.Head.x = 0;
			//this.Head.z = -1;
			//RightLeg
			if (this.RightLeg.xRot < 0) this.RightLeg.xRot += 0.05;
			//RightArm
			//this.RightArm.z = 3.0F;
			if (this.RightArm.z < 3) this.RightArm.z += 0.15;
			if (this.RightArm.xRot > 0) this.RightArm.xRot -= 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.z = 19;
			if (this.Tail1.x > 0) this.Tail1.x -= 0.15;
			if (this.Tail1.z < 19) this.Tail1.z += 0.15;
			if (this.Tail1.xRot > 0) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
			if (this.Tail1.zRot < 0) this.Tail1.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Body.y = 12;
		this.LeftThigh.y = 2.0F;
		this.RightThigh.y = 2;
		this.LeftArm.z = 0;
		this.RightArm.z = 0.0F;
		this.Tail1.x = 0;
		this.Tail1.z = 10;
		this.Tail2.x = 0.0F;
		this.Tail2.z = 8;
		this.LeftLeg.xRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.45378560551852565F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = -0.296705972839036F;
		this.LeftThigh.y = 2F;
		this.LeftArm.z = 0;
		this.LeftArm.xRot = 0.8726646259971648F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Body.y = 15.5F;
		this.Body.xRot = -0.24434609527920614F;
		this.Tail2.x = 0.5F;
		this.Tail2.z = 7.4F;
		this.Tail2.xRot = 0.24962634015954636F;
		this.Tail2.yRot = -0.593411945678072F;
		this.Tail2.zRot = -0.10471975511965977F;
		this.RightThigh.y = 2F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = 0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		this.RightLeg.xRot = -0.45378560551852565F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.RightArm.z = 0F;
		this.Tail1.x = 0.7F;
		this.Tail1.z = 9;
		this.Tail1.xRot = -0.17853981633974483F;
		this.Tail1.yRot = -0.593411945678072F;
		this.Tail1.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}