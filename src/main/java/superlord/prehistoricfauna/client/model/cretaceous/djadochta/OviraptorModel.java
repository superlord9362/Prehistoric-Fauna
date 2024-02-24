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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Oviraptor;

public class OviraptorModel extends EntityModel<Oviraptor> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart Tail;

	public OviraptorModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = Body.getChild("Neck1");
		this.LeftWing = Body.getChild("LeftWing");
		this.RightWing = Body.getChild("RightWing");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.Tail = Body.getChild("Tail");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -5.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(40, 1).addBox(-1.0F, -1.5F, -5.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(25, 19).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -3.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(43, 11).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(0.0F, -1.0F, -1.9F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 1.0F, 2.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.9F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, 2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(17, 5).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 10.0F));

		PartDefinition TailFeathers = Tail.addOrReplaceChild("TailFeathers", CubeListBuilder.create().texOffs(6, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 3.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(32, 6).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 7.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(32, 6).addBox(0.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 7.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 5.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 58, 25);
	}

	@Override
	public void setupAnim(Oviraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			setSleepingPose();
		} else {
			float partialTick = ageInTicks - entity.tickCount;
			float attackProgress = entity.getMeleeProgress(partialTick);
			this.Neck1.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Neck1.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.LeftWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.RightWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			if (entity.isEating()) {
				this.Body.xRot = 0.5F;
				this.LeftThigh.xRot = -0.5F;
				this.RightThigh.xRot = -0.5F;
				this.Neck1.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.Body.y = 17;
				this.Body.xRot = -0.25F;
				this.Tail.xRot = 0.25F;
				this.Neck1.xRot = 0.25F + (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
				this.LeftWing.zRot = 0.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.RightWing.zRot = -0.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = 16F;
		this.Body.xRot = 0F;
		this.Neck1.xRot = 0F;
		this.Neck1.yRot = 0F;
		this.RightWing.xRot = 0F;
		this.RightWing.zRot = 0F;
		this.LeftWing.xRot = 0F;
		this.LeftWing.zRot = 0F;
		this.Tail.xRot = 0F;
		this.Tail.yRot = 0F;
		this.LeftThigh.xRot = 0F;
		this.LeftThigh.yRot = 0F;
		this.LeftLeg.xRot = 0F;
		this.LeftFoot.xRot = 0F;
		this.RightThigh.xRot = 0F;
		this.RightThigh.yRot = 0F;
		this.RightLeg.xRot = 0F;
		this.RightFoot.xRot = 0F;
	}
	
	public void setSleepingPose() {
		this.Body.y = 19.5F;
		this.Neck1.xRot = 0.3491F;
		this.Neck1.yRot = 0.5672F;
		this.RightWing.xRot = 0.0873F;
		this.RightWing.zRot = -0.7854F;
		this.LeftWing.xRot = 0.0873F;
		this.LeftWing.zRot = 0.7854F;
		this.Tail.xRot = -0.3054F;
		this.Tail.yRot = -0.3491F;
		this.LeftThigh.xRot = -0.4363F;
		this.LeftThigh.yRot = 0.1745F;
		this.LeftLeg.xRot = -1.1345F;
		this.LeftFoot.xRot = 1.5708F;
		this.RightThigh.xRot = -0.4363F;
		this.RightThigh.yRot = -0.1745F;
		this.RightLeg.xRot = -1.1345F;
		this.RightFoot.xRot = 1.5708F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}