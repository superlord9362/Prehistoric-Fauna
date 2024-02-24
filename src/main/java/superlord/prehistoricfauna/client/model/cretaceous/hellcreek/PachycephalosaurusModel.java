package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Pachycephalosaurus;

public class PachycephalosaurusModel extends EntityModel<Pachycephalosaurus> {
	private final ModelPart Body;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public PachycephalosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Neck = Body.getChild("Neck");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 35).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -10.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.05F, 21.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.95F, 8.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 8.0F, 2.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(20, 20).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 8.0F, 2.5F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(41, 35).addBox(-4.0F, -2.0F, -3.5F, 4.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 5.0F, 14.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(25, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 9.0F, 3.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(36, 0).addBox(0.0F, -2.0F, -3.5F, 4.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 5.0F, 14.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(21, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 9.0F, 3.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -7.0F, -5.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 18).addBox(-2.5F, -2.0F, -6.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -7.0F));

		PartDefinition NoseBumps1 = Snout.addOrReplaceChild("NoseBumps1", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(1.5F, -0.7F, -2.5F));

		PartDefinition InnerNoseBump = Snout.addOrReplaceChild("InnerNoseBump", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.5F));

		PartDefinition BackCrest = Head.addOrReplaceChild("BackCrest", CubeListBuilder.create().texOffs(14, 15).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Horns = BackCrest.addOrReplaceChild("Horns", CubeListBuilder.create().texOffs(0, 43).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition Helmet = Head.addOrReplaceChild("Helmet", CubeListBuilder.create().texOffs(52, 12).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Pachycephalosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			sleepPose();
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
	}
	
	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.LeftThigh.y = 5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.z = 2.5F;
		this.LeftArm.xRot = 0;
//		this.LeftFoot.xRot = 0;
//		this.RightFoot.xRot = 0;
		this.Body.y = 2;
		this.Body.xRot = 0;
		this.RightThigh.y = 5;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
//		this.Head.x = 0;
//		this.Head.z = -0.5F;
//		this.Head.xRot = 0;
//		this.Head.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.z = 2.5F;
		this.RightArm.xRot = 0;
		this.Tail1.x = 0;
		this.Tail1.z = 21;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.45378560551852565F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = 0.296705972839036F;
		this.LeftThigh.y = 3.2F;
		this.LeftArm.z = 2.5F;
		this.LeftArm.xRot = 0.8726646259971648F;
//		this.LeftFoot.xRot = 1.5707963267948966F;
//		this.RightFoot.xRot = 1.5707963267948966F;
		this.Body.y = 12;
		this.Body.xRot = -0.24434609527920614F;
		this.RightThigh.y = 3.2F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = -0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
//		this.Head.x = 0.5F;
//		this.Head.z = -1.5F;
//		this.Head.xRot = 0.5585053606381855F;
//		this.Head.yRot = 1.3962634015954636F;
		this.RightLeg.xRot = -0.45378560551852565F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.RightArm.z = 2.5F;
//		this.Tail.x = 0.7F;
//		this.Tail.z = 18;
//		this.Tail.xRot = 0.07853981633974483F;
//		this.Tail.yRot = -0.593411945678072F;
//		this.Tail.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}