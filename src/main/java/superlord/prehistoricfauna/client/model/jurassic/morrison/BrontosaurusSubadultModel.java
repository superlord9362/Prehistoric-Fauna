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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Brontosaurus;

public class BrontosaurusSubadultModel extends EntityModel<Brontosaurus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public BrontosaurusSubadultModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Tail3 = this.Tail2.getChild("Tail3");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -25.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -16.0F, -46.0F, 25.0F, 35.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 45.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(0, 171).addBox(-6.5F, -2.0F, -24.0F, 13.0F, 20.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -43.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Neck1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(58, 148).mirror().addBox(0.0F, 0.0F, -24.0F, 0.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 18.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r2 = Neck1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 148).addBox(0.0F, 0.0F, -24.0F, 0.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 18.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(155, 67).addBox(-2.5F, -1.0F, -38.0F, 5.0F, 12.0F, 44.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Neck2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(58, 131).mirror().addBox(0.0F, 1.0F, -35.0F, 0.0F, 3.0F, 40.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r4 = Neck2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(58, 131).addBox(0.0F, 1.0F, -35.0F, 0.0F, 3.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 10.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(188, 53).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(82, 91).addBox(-3.0F, 2.0F, -12.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -37.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(82, 100).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -6.75F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(162, 0).addBox(-8.0F, -3.0F, -1.0F, 16.0F, 22.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(82, 91).addBox(-4.5F, -2.0F, -1.0F, 9.0F, 12.0F, 55.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 30.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Tail3 = Tail2.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(0, 91).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 74.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 54.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 91).addBox(-6.0F, -3.0F, -3.5F, 7.0F, 36.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(82, 106).addBox(-9.0F, 31.0F, -2.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(12.5F, 6.0F, -38.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 91).mirror().addBox(-1.0F, -3.0F, -3.5F, 7.0F, 36.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(82, 106).mirror().addBox(6.0F, 31.0F, -2.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.5F, 6.0F, -38.5F));
				
		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(28, 91).addBox(-7.0F, -4.0F, -7.0F, 9.0F, 27.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(12.5F, -19.0F, 45.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(162, 53).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 23.0F, -4.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(162, 75).addBox(-3.5F, 0.0F, -10.0F, 7.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 7.025F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(28, 91).mirror().addBox(-2.0F, -4.0F, -7.0F, 9.0F, 27.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.5F, -19.0F, 45.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(162, 53).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 23.0F, -4.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(162, 75).mirror().addBox(-3.5F, 0.0F, -10.0F, 7.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 7.025F));

		return LayerDefinition.create(meshdefinition, 288, 288);
	}

	@Override
	public void setupAnim(Brontosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -19, 6F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.0805F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, 0.0376F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 0.215F);
				this.Neck1.y = Mth.lerp(sleepProgress, -16, -10);
				this.Neck1.xRot = Mth.lerp(sleepProgress, -0.2618F, 0.5531F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 0.3487F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, -0.02275F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.4363F, -0.2269F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, 0.3427F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, -0.2839F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.9163F, -0.0709F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0873F, -0.0186F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.3537F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.2426F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0436F, 0.1401F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.1778F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.1404F);
				this.Tail3.xRot = Mth.lerp(sleepProgress, -0.0873F, 0.1001F);
				this.Tail3.yRot = Mth.lerp(sleepProgress, 0, -0.3778F);
				this.Tail3.zRot = Mth.lerp(sleepProgress, 0, -0.2404F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3301F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.0462F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.2503F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.0769F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.0313F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.0938F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -19, 2F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.1531F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -19, 1F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1091F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.5251F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 6, -19F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.0805F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0.0376F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 0.215F, 0);
				this.Neck1.y = Mth.lerp(sleepProgress, -10, -16);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.5531F, -0.2618F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0.3487F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, -0.02275F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.2269F, -0.4363F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0.3427F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, -0.2839F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.0709F, 0.9163F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0186F, -0.0873F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.3537F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.2426F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1401F, 0.0436F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.1778F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.1404F, 0);
				this.Tail3.xRot = Mth.lerp(sleepProgress, 0.1001F, -0.0873F);
				this.Tail3.yRot = Mth.lerp(sleepProgress, -0.3778F, 0);
				this.Tail3.zRot = Mth.lerp(sleepProgress, -0.2404F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3301F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.0462F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.2503F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.0769F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.0313F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.0938F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 2F, -19);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.1531F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 1, -19F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.1091F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.5251F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
			} else {
				this.Body.xRot = (attackProgress * (float)Math.toRadians(-50));
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.0873F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.0436F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Tail3.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.0873F);
				this.Tail3.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = 0.05F * Mth.sin(0.1F * ageInTicks / 3) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.2618F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.3927F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = -0.025F * Mth.sin(0.1F * ageInTicks / 3) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.9163F);
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = -Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.RightArm.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftArm.xRot = -(Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.Body.y = 35;
					this.Body.xRot = -0.05F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.RightThigh.y = 35;
					this.LeftThigh.y = 35;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.LeftLeg.xRot = 0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F)) - 0.15F;
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F)) - 0.15F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y =  -19.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightArm.x = -12.5F;
		this.RightArm.y = 6.0F;
		this.RightArm.z = -38.5F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail1.z = 10;
		this.Tail1.xRot = -0.0873F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftArm.x = 12.5F;
		this.LeftArm.y = 6F;
		this.LeftArm.z = -38.5F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftFoot.y = 12F;
		this.LeftFoot.z = 7.025F;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftLeg.y = 23F;
		this.LeftLeg.z = -4F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.Neck2.xRot = -0.3927F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.RightFoot.y = 12F;
		this.RightFoot.z = 7.025F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
		this.RightLeg.y = 23F;
		this.RightLeg.z = -4F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftThigh.x = 12.5F;
		this.LeftThigh.y = -19;
		this.LeftThigh.z = 45;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightThigh.x = -12.5F;
		this.RightThigh.y = -19;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Neck1.x = 0F;
		this.Neck1.y = -16;
		this.Neck1.z = -43;
		this.Neck1.xRot = -0.2618F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Tail2.xRot = 0.0436F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Tail3.xRot = -0.0873F;
		this.Tail3.yRot = 0;
		this.Tail3.zRot = 0;
		this.Head.x = 0;
		this.Head.z = -37;
		this.Head.xRot = 0.9163F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 6F;
		this.Body.xRot = -0.0805F;
		this.Body.yRot = 0.0376F;
		this.Body.zRot = 0.215F;
		this.Neck1.y = -10;
		this.Neck1.xRot = 0.5531F;
		this.Neck1.yRot = 0.3487F;
		this.Neck1.zRot = -0.02275F;
		this.Neck2.xRot = -0.2269F;
		this.Neck2.yRot = 0.3427F;
		this.Neck2.zRot = -0.2839F;
		this.Head.xRot = -0.0709F;
		this.Tail1.xRot = -0.0186F;
		this.Tail1.yRot = -0.3537F;
		this.Tail1.zRot = -0.2426F;
		this.Tail2.xRot = 0.1401F;
		this.Tail2.yRot = -0.1778F;
		this.Tail2.zRot = -0.1404F;
		this.Tail3.xRot = 0.1001F;
		this.Tail3.yRot = -0.3778F;
		this.Tail3.zRot = -0.2404F;
		this.LeftArm.xRot = -1.3301F;
		this.LeftArm.yRot = 0.0462F;
		this.LeftArm.zRot = -0.2503F;
		this.RightArm.xRot = -1.0769F;
		this.RightArm.yRot = -0.0313F;
		this.RightArm.zRot = -0.0938F;
		this.LeftThigh.y = 2F;
		this.LeftThigh.xRot = 0.6472F;
		this.LeftThigh.yRot = -0.0018F;
		this.LeftThigh.zRot = -0.1531F;
		this.LeftLeg.xRot = 0.9163F;
		this.RightThigh.y = 1F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.yRot = 0.1091F;
		this.RightThigh.zRot = 0.5251F;
		this.RightLeg.xRot = 1.1345F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
