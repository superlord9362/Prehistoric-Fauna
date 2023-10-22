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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;

public class DryosaurusModel extends EntityModel<Dryosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart LLeg1;
	private final ModelPart LLeg2;
	private final ModelPart LLeg3;
	private final ModelPart RLeg1;
	private final ModelPart RLeg2;
	private final ModelPart RLeg3;

	public DryosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.RArm = Body.getChild("RArm");
		this.LArm = Body.getChild("LArm");
		this.LLeg1 = Body.getChild("LLeg1");
		this.LLeg2 = LLeg1.getChild("LLeg2");
		this.LLeg3 = LLeg2.getChild("LLeg3");
		this.RLeg1 = Body.getChild("RLeg1");
		this.RLeg2 = RLeg1.getChild("RLeg2");
		this.RLeg3 = RLeg2.getChild("RLeg3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -10.0F));

		PartDefinition RLeg1 = Body.addOrReplaceChild("RLeg1", CubeListBuilder.create().texOffs(31, 0).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 5.0F, 14.0F));

		PartDefinition RLeg2 = RLeg1.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 6.0F, 3.0F));

		PartDefinition RLeg3 = RLeg2.addOrReplaceChild("RLeg3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(49, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 7.0F, 3.0F));

		PartDefinition LLeg1 = Body.addOrReplaceChild("LLeg1", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-2.0F, -3.0F, -3.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 5.0F, 14.0F));

		PartDefinition LLeg2 = LLeg1.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(6, 3).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.0F, 3.0F));

		PartDefinition LLeg3 = LLeg2.addOrReplaceChild("LLeg3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 47).addBox(-1.5F, -3.0F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(49, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 7.0F, 3.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 27).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 19.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Dryosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.LLeg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RLeg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.RArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
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
					this.RLeg1.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg1.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LArm.xRot = 0.5F;
					this.RArm.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LLeg2
			if (this.LLeg2.xRot < 0) this.LLeg2.xRot += 0.05;
			//LLeg1
			//this.LLeg1.y = 5.0F;
			if (this.LLeg1.y < 5) this.LLeg1.y += 0.15;
			if (this.LLeg1.xRot < 0) this.LLeg1.xRot += 0.05;
			if (this.LLeg1.yRot < 0) this.LLeg1.yRot += 0.05;
			//LArm
			//this.LArm.z = 3;
			if (this.LArm.y < 3) this.LArm.y += 0.15;
			if (this.LArm.xRot > 0) this.LArm.xRot -= 0.05;
			//LLeg3
			if (this.LLeg3.xRot > 0) this.LLeg3.xRot -= 0.05;
			//RLeg3
			if (this.RLeg3.xRot > 0) this.RLeg3.xRot -= 0.05;
			//Body
			//this.Body.y = 5;
			if (this.Body.y > 5) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//Tail2
			//this.Tail2.x = 0.0F;
			//this.Tail2.z = 15;
			if (this.Tail2.x > 0) this.Tail2.x -= 0.15;
			if (this.Tail2.y < 15) this.Tail2.y += 0.15;
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot < 0) this.Tail2.zRot += 0.05;
			//RLeg1
			//this.RLeg1.y = 5;
			if (this.RLeg1.y < 5) this.RLeg1.y += 0.15;
			if (this.RLeg1.xRot < 0) this.RLeg1.xRot += 0.05;
			if (this.RLeg1.yRot > 0) this.RLeg1.yRot -= 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			//Head
			//this.Head.x = 0;
			//this.Head.z = -1;
			if (this.Head.x > 0) this.Head.x -= 0.15;
			if (this.Head.y < -1) this.Head.y += 0.15;
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			if (this.Head.yRot > 0) this.Head.yRot -= 0.05;
			//RLeg2
			if (this.RLeg2.xRot < 0) this.RLeg2.xRot += 0.05;
			//RArm
			//this.RArm.z = 3.0F;
			if (this.RArm.z < 3) this.RArm.z += 0.15;
			if (this.RArm.xRot > 0) this.RArm.xRot -= 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.z = 19;
			if (this.Tail1.x > 0) this.Tail1.x -= 0.15;
			if (this.Tail1.z < 19) this.Tail1.z += 0.15;
			if (this.Tail1.xRot > 0) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
			if (this.Tail1.zRot < 0) this.Tail1.zRot += 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//LLeg2
			if (this.LLeg2.xRot > -0.45378560551852565F) this.LLeg2.xRot -= 0.05;
			//LLeg1
			//this.LLeg1.y = 5.0F;
			if (this.LLeg1.y > 3.2) this.LLeg1.y -= 0.15;
			if (this.LLeg1.xRot > -0.8726646259971648F) this.LLeg1.xRot -= 0.05;
			if (this.LLeg1.yRot > -0.296705972839036F) this.LLeg1.yRot -= 0.05;
			//LArm
			//this.LArm.z = 3;
			if (this.LArm.y > 2.5) this.LArm.y -= 0.15;
			if (this.LArm.xRot < 0.8726646259971648F) this.LArm.xRot += 0.05;
			//LLeg3
			if (this.LLeg3.xRot < 1.5707963267948966F) this.LLeg3.xRot += 0.05;
			//RLeg3
			if (this.RLeg3.xRot < 1.5707963267948966F) this.RLeg3.xRot += 0.05;
			//Body
			//this.Body.y = 5;
			if (this.Body.y < 12) this.Body.y += 0.15;
			if (this.Body.xRot > -0.24434609527920614F) this.Body.xRot -= 0.05;
			//Tail2
			//this.Tail2.x = 0.0F;
			//this.Tail2.z = 15;
			if (this.Tail2.x < 0.5) this.Tail2.x += 0.15;
			if (this.Tail2.y > 14.4) this.Tail2.y -= 0.15;
			if (this.Tail2.xRot < 0.13962634015954636F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > -0.593411945678072F) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > -0.10471975511965977F) this.Tail2.zRot -= 0.05;
			//RLeg1
			//this.RLeg1.y = 5;
			if (this.RLeg1.y > 3.2) this.RLeg1.y -= 0.15;
			if (this.RLeg1.xRot > -0.8726646259971648F) this.RLeg1.xRot -= 0.05;
			if (this.RLeg1.yRot < 0.296705972839036F) this.RLeg1.yRot += 0.05;
			//Neck
			if (this.Neck.xRot < 0.8726646259971648F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 0.9773843811168246F) this.Neck.yRot += 0.05;
			//Head
			//this.Head.x = 0;
			//this.Head.z = -1;
			if (this.Head.x < 0.5) this.Head.x += 0.15;
			if (this.Head.y > -1.5) this.Head.y -= 0.15;
			if (this.Head.xRot < 0.5585053606381855F) this.Head.xRot += 0.05;
			if (this.Head.yRot < 1.3962634015954636F) this.Head.yRot += 0.05;
			//RLeg2
			if (this.RLeg2.xRot > -0.45378560551852565F) this.RLeg2.xRot -= 0.05;
			//RArm
			//this.RArm.z = 3.0F;
			if (this.RArm.z > 2.5) this.RArm.z -= 0.15;
			if (this.RArm.xRot < 0.8726646259971648F) this.RArm.xRot += 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.z = 19;
			if (this.Tail1.x < 0.7) this.Tail1.x += 0.15;
			if (this.Tail1.z > 18) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot < 0.07853981633974483F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > -0.593411945678072F) this.Tail1.yRot -= 0.05;
			if (this.Tail1.zRot > -0.10471975511965977F) this.Tail1.zRot -= 0.05;
		}
	}

	public void resetModel() {
		this.LLeg2.xRot = 0;
		this.LLeg1.y = 5.0F;
		this.LLeg1.xRot = 0;
		this.LLeg1.yRot = 0;
		this.LArm.z = 3;
		this.LArm.xRot = 0;
		this.LLeg3.xRot = 0;
		this.RLeg3.xRot = 0;
		this.Body.y = 5;
		this.Body.xRot = 0;
		this.Tail2.x = 0.0F;
		this.Tail2.z = 15;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RLeg1.y = 5;
		this.RLeg1.xRot = 0;
		this.RLeg1.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Head.x = 0;
		this.Head.z = -1;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.RLeg2.xRot = 0;
		this.RArm.z = 3.0F;
		this.RArm.xRot = 0;
		this.Tail1.x = 0;
		this.Tail1.z = 19;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
	}

	public void sleepPose() {
		this.LLeg2.xRot = -0.45378560551852565F;
		this.LLeg1.xRot = -0.8726646259971648F;
		this.LLeg1.yRot = -0.296705972839036F;
		this.LLeg1.y = 3.2F;
		this.LArm.z = 2.5F;
		this.LArm.xRot = 0.8726646259971648F;
		this.LLeg3.xRot = 1.5707963267948966F;
		this.RLeg3.xRot = 1.5707963267948966F;
		this.Body.y = 12;
		this.Body.xRot = -0.24434609527920614F;
		this.Tail2.x = 0.5F;
		this.Tail2.z = 14.4F;
		this.Tail2.xRot = 0.13962634015954636F;
		this.Tail2.yRot = -0.593411945678072F;
		this.Tail2.zRot = -0.10471975511965977F;
		this.RLeg1.y = 3.2F;
		this.RLeg1.xRot = -0.8726646259971648F;
		this.RLeg1.yRot = 0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		this.Head.x = 0.5F;
		this.Head.z = -1.5F;
		this.Head.xRot = 0.5585053606381855F;
		this.Head.yRot = 1.3962634015954636F;
		this.RLeg2.xRot = -0.45378560551852565F;
		this.RArm.xRot = 0.8726646259971648F;
		this.RArm.z = 2.5F;
		this.Tail1.x = 0.7F;
		this.Tail1.z = 18;
		this.Tail1.xRot = 0.07853981633974483F;
		this.Tail1.yRot = -0.593411945678072F;
		this.Tail1.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}