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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Brachiosaurus;

public class BrachiosaurusSubadultModel extends EntityModel<Brachiosaurus> {
	private final ModelPart Root;
	private final ModelPart Hips;
	private final ModelPart Chest;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public BrachiosaurusSubadultModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Hips = this.Root.getChild("Hips");
		this.Chest = this.Hips.getChild("Chest");
		this.Neck1 = this.Chest.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.LeftArm = this.Chest.getChild("LeftArm");
		this.RightArm = this.Chest.getChild("RightArm");
		this.Tail1 = this.Hips.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
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

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Hips = Root.addOrReplaceChild("Hips", CubeListBuilder.create(), PartPose.offset(0.0F, -37.0F, 22.0F));

		PartDefinition cube_r1 = Hips.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(132, 88).addBox(-12.0F, -37.0F, -8.0F, 24.0F, 37.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -15.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -48.0F, -1.0F, 32.0F, 48.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, -54.0F));

		PartDefinition Neck1 = Chest.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(144, 0).addBox(-5.5F, -49.0F, -16.1F, 11.0F, 65.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -49.0F, 10.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(0, 158).addBox(-3.0F, -59.0F, -9.0F, 6.0F, 61.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -49.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(102, 158).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.005F))
		.texOffs(102, 173).addBox(-2.0F, 4.0F, -12.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.005F))
		.texOffs(102, 183).addBox(-1.5F, -2.0F, -10.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.005F))
		.texOffs(204, 63).addBox(-1.0F, 8.0F, -8.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.005F)), PartPose.offsetAndRotation(0.0F, -58.0F, -6.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(34, 158).mirror().addBox(-7.0F, -4.0F, -4.0F, 8.0F, 49.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(144, 84).mirror().addBox(-9.0F, 44.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(16.0F, -17.0F, 8.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(34, 158).addBox(-1.0F, -4.0F, -4.0F, 8.0F, 49.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(144, 84).addBox(7.0F, 44.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -17.0F, 8.0F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(132, 157).addBox(-6.5F, -3.0F, 0.0F, 13.0F, 15.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 12.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 88).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 8.0F, 62.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 23.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(102, 198).addBox(-8.0F, -5.0F, -8.0F, 10.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -37.0F, 22.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(204, 36).mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 18.0F, 9.0F, new CubeDeformation(-0.001F)).mirror(false), PartPose.offset(-3.0F, 17.0F, -4.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(204, 0).mirror().addBox(-4.5F, 0.0F, -11.0F, 9.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, 6.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(102, 198).addBox(-2.0F, -5.0F, -8.0F, 10.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -37.0F, 22.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(204, 36).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 18.0F, 9.0F, new CubeDeformation(-0.001F)), PartPose.offset(3.0F, 17.0F, -4.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(204, 0).addBox(-4.5F, 0.0F, -11.0F, 9.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Brachiosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Hips.y = Mth.lerp(sleepProgress, -37, -10F);
				this.Hips.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Hips.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck1.x = Mth.lerp(sleepProgress, 0, 4.5F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.2618F, 0.9162978572970231F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -0.3294172592861477F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.51728612207217244F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.22775073568927633F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, 0.3510520131558576F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.30260075936930908F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.2864306020384839F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0873F, 0.2818657326886875F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.1405726395466833F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.069269908169872414F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.2189378856769737F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.03039819087864056F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -37, -15F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.1531F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -37, -13F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.2251F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Hips.y = Mth.lerp(sleepProgress, -10F, -37);
				this.Hips.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Hips.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck1.x = Mth.lerp(sleepProgress, 4.5F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.9162978572970231F, 0.2618F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -0.3294172592861477F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.51728612207217244F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.22775073568927633F, -0.1745F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0.3510520131558576F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.30260075936930908F, -0.1745F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.2864306020384839F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.2818657326886875F, 0.0873F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.1405726395466833F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.069269908169872414F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.2189378856769737F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.03039819087864056F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -15F, -37);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.1531F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -13F, -37);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.2251F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
			} else {
				this.Hips.zRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.1F) * degree * 0.2F * limbSwingAmount - 0.1745F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.05F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.1F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.1F) * degree * 0.2F * limbSwingAmount + 0.0873F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.05F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * degree * 0.15F * limbSwingAmount + 0.2618F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.05F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 270F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.1745F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.0873F);
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.1F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.abs(Mth.cos(limbSwing * 0.05F) * 0.75F * limbSwingAmount);
				this.LeftFoot.xRot = Mth.abs(Mth.cos(1.0F + limbSwing * 0.05F) * 0.4F * limbSwingAmount);
				this.RightThigh.xRot = -Mth.cos(limbSwing * 0.1F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.abs(Mth.cos(4.0F + limbSwing * 0.05F) * 0.75F * limbSwingAmount);
				this.RightFoot.xRot = Mth.abs(Mth.cos(5.0F + limbSwing * 0.05F) * 0.4F * limbSwingAmount);
				this.LeftArm.xRot = (Mth.cos(1.0F + limbSwing * 0.1F) * 0.7F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.RightArm.xRot = -(Mth.cos(1.0F + limbSwing * 0.1F) * 0.7F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.Hips.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.Hips.y = 25;
//					this.Hips.xRot = -0.25F;
//					this.Tail1.xRot = 0.125F;
//					this.Tail2.xRot = 0.125F;
					this.LeftThigh.y = 25;
					this.RightThigh.y = 25;
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.RightLeg.xRot = 0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
//					this.Neck1.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Hips.y =  -37.0F;
		this.Hips.xRot = 0;
		this.Hips.yRot = 0;
		this.Hips.zRot = 0;
		this.LeftArm.x = 16F;
		this.LeftArm.y = -17.0F;
		this.LeftArm.z = 8.0F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.Tail1.z = 12F;
		this.Tail1.xRot = -0.1745F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.RightArm.x = -16F;
		this.RightArm.y = -17F;
		this.RightArm.z = 8F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0;
		this.RightFoot.y = 16;
		this.RightFoot.z = 6F;
		this.RightFoot.xRot = 0;
		this.RightFoot.zRot = 0;
		this.RightLeg.y = 17.0F;
		this.RightLeg.z = -4F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.Neck2.xRot = -0.1745F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.y = 16;
		this.LeftFoot.z = 6F;
		this.LeftLeg.y = 17;
		this.LeftLeg.z = -4F;
		this.LeftLeg.xRot = 0;
		this.RightThigh.x = -12F;
		this.RightThigh.y = -37F;
		this.RightThigh.z = 22;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.LeftThigh.x = 12F;
		this.LeftThigh.y = -37F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.Neck1.x = 0F;
		this.Neck1.y = -49;
		this.Neck1.z = 10.5F;
		this.Neck1.xRot = 0.2618F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Tail2.xRot = 0.0873F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Head.x = 0F;
		this.Head.z = -6F;
		this.Head.xRot = -0.0873F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LeftThigh.zRot = 0;
	}

	public void sleepPose() {
		this.Hips.y = -10F;
		this.Hips.yRot = -0.038920842652368684F;
		this.Hips.zRot = -0.1563815016444822F;
		this.Neck1.x = 4.5F;
		this.Neck1.xRot = 0.9162978572970231F;
		this.Neck1.yRot = -0.3294172592861477F;
		this.Neck1.zRot = 0.51728612207217244F;
		this.Neck2.xRot = -0.22775073568927633F;
		this.Neck2.yRot = -0.1563815016444822F;
		this.Neck2.zRot = 0.3510520131558576F;
		this.Tail1.xRot = -0.30260075936930908F;
		this.Tail1.yRot = 0.2864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.Tail2.xRot = 0.2818657326886875F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Tail2.zRot = 0.19547687289441354F;
		this.LeftArm.xRot = -1.1405726395466833F;
		this.LeftArm.yRot = 0.069269908169872414F;
		this.RightArm.xRot = -1.2189378856769737F;
		this.RightArm.yRot = -0.03039819087864056F;
		this.LeftThigh.y = -15F;
		this.LeftThigh.xRot = 0.6472F;
		this.LeftThigh.yRot = -0.0018F;
		this.LeftThigh.zRot = -0.1531F;
		this.LeftLeg.xRot = 0.9163F;
		this.RightThigh.y = -13F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.zRot = 0.2251F;
		this.RightLeg.xRot = 1.1345F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
