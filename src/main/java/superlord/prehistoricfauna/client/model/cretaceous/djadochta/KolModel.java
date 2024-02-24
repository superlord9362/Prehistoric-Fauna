package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Kol;

public class KolModel extends EntityModel<Kol> {
	private final ModelPart Body;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftClaw;
	private final ModelPart RightClaw;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public KolModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.LeftClaw = Body.getChild("LeftClaw");
		this.RightClaw = Body.getChild("RightClaw");
		this.Neck = Body.getChild("Neck");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 1).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -4.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(1, 25).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -6.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 37).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -5.0F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(1, 44).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tongue = Snout.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(7, 37).addBox(-0.5F, 0.0F, -5.9F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadCrest = Head.addOrReplaceChild("HeadCrest", CubeListBuilder.create().texOffs(17, 34).addBox(-0.5F, -4.0F, -3.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftClaw = Body.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(14, 16).addBox(0.0F, -1.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -4.0F, 0.3927F, 0.4363F, 0.0F));

		PartDefinition RightClaw = Body.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(14, 16).addBox(0.0F, -1.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, -4.0F, 0.3927F, -0.4363F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(28, 33).addBox(-1.0F, -2.0F, -2.99F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 4.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(8, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(1, 2).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(28, 33).mirror().addBox(-1.0F, -2.0F, -2.99F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 4.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(8, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(1, 2).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(42, 33).addBox(-1.5F, -1.99F, -1.0F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 6.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(28, 16).addBox(-1.0F, -0.98F, -1.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 7.0F));

		PartDefinition TailFeathers = Tail1.addOrReplaceChild("TailFeathers", CubeListBuilder.create().texOffs(37, 0).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftQuills = Body.addOrReplaceChild("LeftQuills", CubeListBuilder.create().texOffs(44, 48).addBox(0.25F, -5.0F, -3.0F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.0F, 5.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition RightQuills = Body.addOrReplaceChild("RightQuills", CubeListBuilder.create().texOffs(44, 48).addBox(-0.75F, -5.0F, -3.0F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -3.0F, 5.0F, 0.0F, 0.0F, -0.1745F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Kol entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
			this.RightClaw.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LeftClaw.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.Body.y = 18;
				this.Body.xRot = -0.5F;
				this.Tail1.xRot = 0.25F;
				this.Tail2.xRot = 0.25F;
				this.Neck.xRot = 0.5F;
				this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftClaw.xRot = 0.5F;
				this.RightClaw.xRot = 0.5F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.LeftThigh.y = 0F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftClaw.z = -4F;
		this.LeftClaw.xRot = 0.3927F;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.y = 15;
		this.Body.xRot = 0;
		this.RightThigh.y = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		//0.0F, 1.0F, -6.0F, 0.0436F, 0.0F, 0.0F
		this.Neck.xRot = 0.0436F;
		this.Neck.yRot = 0;
		//		this.Head.x = 0;
		//		this.Head.z = -0.5F;
		//		this.Head.xRot = 0;
		//		this.Head.yRot = 0;
		//2.0F, 2.0F, -4.0F, 0.3927F, 0.4363F, 0.0F
		this.RightLeg.xRot = 0;
		this.RightClaw.z = -4F;
		this.RightClaw.xRot = -0.3927F;
		this.Tail1.x = 0;
		this.Tail1.z = 6;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.xRot = 0;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.45378560551852565F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = -0.296705972839036F;
		this.LeftThigh.y = 1F;
		this.LeftClaw.z = -4F;
		this.LeftClaw.xRot = 0.8726646259971648F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Body.y = 18;
		this.Body.xRot = -0.24434609527920614F;
		this.RightThigh.y = 1F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = 0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		//		this.Head.x = 0.5F;
		//		this.Head.z = -1.5F;
		//		this.Head.xRot = 0.5585053606381855F;
		//		this.Head.yRot = 1.3962634015954636F;
		this.RightLeg.xRot = -0.45378560551852565F;
		this.RightClaw.xRot = 0.8726646259971648F;
		this.RightClaw.z = -4F;
		//this.Tail1.x = 0.7F;
		//this.Tail1.z = 18;
		this.Tail1.xRot = 0.07853981633974483F;
		this.Tail1.yRot = -0.29670597283F;
		this.Tail1.zRot = -0.10471975511965977F;
		this.Tail2.yRot = -0.5082398928281348F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
