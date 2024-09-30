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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Anzu;

@SuppressWarnings("unused")
public class AnzuModel extends EntityModel<Anzu> {
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart LeftArm;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart Jaw;
	private final ModelPart JawSnout;
	private final ModelPart Cheek;
	private final ModelPart jaw_feathers;
	private final ModelPart Crest;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart TailFan;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public AnzuModel(ModelPart root) {
		this.Body1 = root.getChild("Body1");
		this.Body2 = Body1.getChild("Body2");
		this.LeftArm = Body2.getChild("LeftArm");
		this.Neck1 = Body2.getChild("Neck1");
		this.Neck2 = Neck1.getChild("Neck2");
		this.Head = Neck2.getChild("Head");
		this.Snout = Head.getChild("Snout");
		this.Jaw = Head.getChild("Jaw");
		this.JawSnout = Jaw.getChild("JawSnout");
		this.Cheek = Jaw.getChild("Cheek");
		this.jaw_feathers = Jaw.getChild("jaw_feathers");
		this.Crest = Head.getChild("Crest");
		this.RightArm = Body2.getChild("RightArm");
		this.Tail1 = Body1.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.TailFan = Tail2.getChild("TailFan");
		this.RightThigh = Body1.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Body1.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 1).addBox(-5.0F, -29.0F, -8.0F, 10.0F, 17.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -2.0F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 33).addBox(-4.5F, -7.5F, -13.0F, 9.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.5F, -8.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(91, 72).mirror().addBox(-1.5F, -2.0F, -2.0F, 3.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 3.5F, -10.0F));

		PartDefinition Neck1 = Body2.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(0, 61).addBox(-2.5F, -4.0F, -10.0F, 5.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(32, 63).addBox(-2.5F, 3.0F, -10.0F, 5.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -13.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(0, 79).addBox(-1.5F, -12.5F, -4.0F, 3.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(19, 83).addBox(-1.5F, 2.5F, -4.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -8.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 101).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.5F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(21, 104).addBox(-1.5F, -37.0F, -39.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 38.0F, 29.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 112).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition JawSnout = Jaw.addOrReplaceChild("JawSnout", CubeListBuilder.create().texOffs(21, 115).addBox(-1.5F, -34.0F, -39.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 35.0F, 29.0F));

		PartDefinition Cheek = Jaw.addOrReplaceChild("Cheek", CubeListBuilder.create().texOffs(76, 116).addBox(-1.5F, -37.75F, -34.25F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 35.0F, 29.0F));

		PartDefinition jaw_feathers = Jaw.addOrReplaceChild("jaw_feathers", CubeListBuilder.create().texOffs(39, 114).addBox(-2.0F, -33.0F, -35.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(61, 114).addBox(0.0F, -33.0F, -35.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 35.0F, 29.0F));

		PartDefinition Crest = Head.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(38, 95).addBox(-1.0F, -45.0F, -38.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 38.0F, 29.0F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(91, 72).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 3.5F, -10.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(50, 0).addBox(-3.0F, -2.9F, -1.0F, 6.0F, 8.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(50, 25).addBox(-3.0F, 5.1F, 0.0F, 6.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.0F, 7.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(98, 0).addBox(-2.0F, -1.8F, -1.0F, 4.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 14.0F));

		PartDefinition TailFan = Tail2.addOrReplaceChild("TailFan", CubeListBuilder.create().texOffs(74, 27).addBox(-5.0F, -27.8F, 21.0F, 10.0F, 9.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 27.0F, -21.0F));

		PartDefinition RightThigh = Body1.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(118, 66).addBox(-4.0F, -4.0F, -5.0F, 6.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(127, 94).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 13.0F, 4.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(123, 112).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.9F, 0.0F));

		PartDefinition LeftThigh = Body1.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(118, 66).mirror().addBox(-2.0F, -3.5F, -4.0F, 6.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -22.5F, -1.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(127, 94).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 13.5F, 5.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(123, 112).mirror().addBox(-2.0F, -0.1F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 150, 124);
	}

	@Override
	public void setupAnim(Anzu entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {

			} else setSleepingPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {

			} else {
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Body1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Head.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
				this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
				this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			}
		}
	}
	
	public void resetModel() {
		
	}
	
	public void setSleepingPose() {
		
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}