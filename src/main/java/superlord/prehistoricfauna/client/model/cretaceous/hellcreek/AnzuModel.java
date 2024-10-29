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
				this.Body1.y = Mth.lerp(sleepProgress, 16, 34.6F);
				this.Body2.z = Mth.lerp(sleepProgress, -8, -6);
				this.Body2.xRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 1.0337F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.2446F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.0358F);
				this.Neck1.z = Mth.lerp(sleepProgress, -13, -11.9F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0, 0.1587F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -0.6506F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.1293F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, 0, -0.6109F);
				this.Head.z = Mth.lerp(sleepProgress, 0, -1.15F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.5672F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.914F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.3535F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.2613F);
				this.Tail1.y = Mth.lerp(sleepProgress, -26, -25.5F);
				this.Tail1.z = Mth.lerp(sleepProgress, 7, 6.5F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.3103F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.1494F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.0281F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.1747F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.043F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.0076F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -22, -24);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.0452F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2615F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.0117F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5272F);
				this.RightFoot.y = Mth.lerp(sleepProgress, 16.9F, 17);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6581F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -22.5F, -24.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.0457F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.3051F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.0138F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress,0 , -1.5272F);
				this.LeftFoot.y = Mth.lerp(sleepProgress, 16.9F, 17F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6144F);
			} else setSleepingPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body1.y = Mth.lerp(sleepProgress, 34.6F, 16);
				this.Body2.z = Mth.lerp(sleepProgress, -6, -8);
				this.Body2.xRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 1.0337F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.2446F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.0358F, 0);
				this.Neck1.z = Mth.lerp(sleepProgress, -11.9F, -13);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.1587F, 0);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -0.6506F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.1293F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.6109F, 0);
				this.Head.z = Mth.lerp(sleepProgress, -1.15F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.5672F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.914F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.3535F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.2613F, 0);
				this.Tail1.y = Mth.lerp(sleepProgress, -25.5F, -26F);
				this.Tail1.z = Mth.lerp(sleepProgress, 6.5F, 7);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.3103F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.1494F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.0281F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1747F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.043F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.0076F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -24, -22);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.0452F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2615F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.0117F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.5272F, 0);
				this.RightFoot.y = Mth.lerp(sleepProgress, 17F, 16.9F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.6581F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -24.5F, -22.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.0457F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.3051F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.0138F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.5272F, 0);
				this.LeftFoot.y = Mth.lerp(sleepProgress, 17F, 16.9F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.6144F, 0);
			} else {
				this.RightThigh.xRot = Mth.sin(0.4F * limbSwing) * 0.25F * limbSwingAmount;
				this.RightLeg.xRot = Mth.sin(limbSwing*0.4F) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.RightFoot.xRot = Mth.sin(limbSwing * 0.4F) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.LeftThigh.xRot = Mth.sin(0.4F * limbSwing + (float)Math.PI) * 0.25F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.sin(limbSwing*0.4F + (float)Math.PI) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.LeftFoot.xRot = Mth.sin(limbSwing * 0.4F + (float)Math.PI) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Head.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
//				this.RightThigh.xRot = Mth.sin(limbSwing * 0.4F) * 0.75F * limbSwingAmount;
//				this.RightLeg.xRot =  -Mth.abs( Mth.sin(limbSwing * 0.75F) * 0.75F * limbSwingAmount);
//				this.RightFoot.xRot = Mth.abs( Mth.sin(limbSwing * 0.75F) * -1.25F * limbSwingAmount);
//				this.LeftThigh.xRot = Mth.sin(limbSwing * 0.4F) * -0.75F * limbSwingAmount;
//				this.LeftLeg.xRot =  -Mth.abs( Mth.sin(limbSwing * 0.75F) * -0.75F * limbSwingAmount);
//				this.LeftFoot.xRot = Mth.abs( Mth.sin(limbSwing * 0.75F) * 1.25F * limbSwingAmount);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount) - 0.1F;
				this.Tail2.xRot = Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount + 0.1F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.RightArm.xRot = Mth.sin(limbSwing * 0.4F) * 0.1F * limbSwingAmount + 0.1F;
				this.LeftArm.xRot = Mth.sin(limbSwing * 0.4F) * 0.1F * limbSwingAmount + 0.1F;
				this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
				this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
				this.Neck1.xRot = Mth.abs(Mth.sin(limbSwing * 0.2F) * 0.25F * limbSwingAmount) + 0.25F;
				this.Neck2.xRot = Mth.abs(Mth.sin(limbSwing * 0.2F) * 0.25F * limbSwingAmount) - 0.1F;
//				if (entity.isInWater()) {
//					this.RightArm.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
//					this.LeftArm.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
//					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
//					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
//					this.Tail1.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
//					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
//					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
//					this.Body1.y = 34;
//				}
			}
		}
	}
	
	public void resetModel() {
		this.Body1.y = 16;
		this.Body2.z = -8;
		this.Body2.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.Neck1.z = -13F;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.xRot = 0;
		this.Head.z = 0F;
		this.Head.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail1.y = -26F;
		this.Tail1.z = 7F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightThigh.y = -22;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 16.9F;
		this.RightFoot.xRot = 0F;
		this.LeftThigh.y = -22.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.y = 16.9F;
		this.LeftFoot.xRot = 0;
	}
	
	public void setSleepingPose() {
		this.Body1.y = 34.6F;
		this.Body2.z = -6;
		this.Body2.xRot = 0.2618F;
		this.LeftArm.xRot = 1.0337F;
		this.LeftArm.yRot = -0.2446F;
		this.LeftArm.zRot = 0.0358F;
		this.Neck1.z = -11.9F;
		this.Neck1.xRot = 0.1587F;
		this.Neck1.yRot = -0.6506F;
		this.Neck1.zRot = 0.1293F;
		this.Neck2.xRot = -0.6109F;
		this.Head.z = -1.15F;
		this.Head.xRot = 0.5672F;
		this.RightArm.xRot = 0.914F;
		this.RightArm.yRot = 0.3535F;
		this.RightArm.zRot = -0.2613F;
		this.Tail1.y = -25.5F;
		this.Tail1.z = 6.5F;
		this.Tail1.xRot = -0.3103F;
		this.Tail1.yRot = 0.1494F;
		this.Tail1.zRot = 0.0281F;
		this.Tail2.xRot = 0.1747F;
		this.Tail2.yRot = 0.043F;
		this.Tail2.zRot = 0.0076F;
		this.RightThigh.y = -24;
		this.RightThigh.xRot = -0.0452F;
		this.RightThigh.yRot = -0.2615F;
		this.RightThigh.zRot = 0.0117F;
		this.RightLeg.xRot = -1.5272F;
		this.RightFoot.y = 17;
		this.RightFoot.xRot = 1.6581F;
		this.LeftThigh.y = -24.5F;
		this.LeftThigh.xRot = -0.0457F;
		this.LeftThigh.yRot = 0.3051F;
		this.LeftThigh.zRot = -0.0138F;
		this.LeftLeg.xRot = -1.5272F;
		this.LeftFoot.y = 17F;
		this.LeftFoot.xRot = 1.6144F;
		//1.0F, 13.5F, 5.0F
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}