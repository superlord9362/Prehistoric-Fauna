package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Sinraptor;

public class SinraptorModel extends EntityModel<Sinraptor> {

	private final ModelPart Root;
	private final ModelPart Hips;
	private final ModelPart Chest;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public SinraptorModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Hips = this.Root.getChild("Hips");
		this.Chest = this.Hips.getChild("Chest");
		this.Neck = this.Chest.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.RightArm = this.Chest.getChild("RightArm");
		this.LeftArm = this.Chest.getChild("LeftArm");
		this.Tail1 = this.Hips.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition Hips = Root.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.0F, -19.0F, 11.0F, 23.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -3.0F, -2.0F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(93, 64).addBox(-13.0F, -20.0F, -10.0F, 13.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 20.0F, -20.0F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(50, 0).addBox(-2.5F, -12.0F, -7.0F, 5.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -15.0F, -7.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(37, 61).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 51).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(80, 0).addBox(-1.0F, 5.0F, -16.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.05F, -6.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, 0.0F, -7.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(80, 13).addBox(-2.5F, -3.0F, -5.025F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(92, 1).addBox(-2.0F, 1.0F, -17.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, 0.0F, -17.0F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(-1.0F, -2.0F, -2.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -4.0F, -3.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, -2.0F, -2.5F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -3.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(23, 74).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 11.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.0F, 9.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(90, 0).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 6.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, 28.0F, 0.0873F, 0.0F, 0.0F));
		
		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(64, 37).mirror().addBox(-3.0F, -8.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 6.0F, -4.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 81).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 5.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(78, 25).mirror().addBox(-2.5F, -1.0F, -8.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, 2.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(64, 37).addBox(-3.0F, -8.0F, -7.0F, 6.0F, 24.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 6.0F, -4.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 81).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 5.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(78, 25).addBox(-2.5F, -1.0F, -8.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 172, 114);
	}

	@Override
	public void setupAnim(Sinraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.1F, -0.6600982340775168F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.1F, -0.6600982340775168F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0873F, -0.2400491170387584F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.0873F, 0.0601964681550337F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.1F, -0.7428121536172364F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 2, -1F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.402910321115726F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.1309F, 0.581101130194616F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.481101130194616F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0873F, 0.02547687289441354F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Root.y = Mth.lerp(sleepProgress, -9, 5.0F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 2, -1.0F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.4465288361160007F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -1.2300491170387584F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 1.2300491170387584F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.1F, -0.7428121536172364F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.23457224414434488F);
			} else sleepPose();
			this.Jaw.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F;
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.6600982340775168F, 0.1F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.6600982340775168F, 0.1F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2400491170387584F, -0.0873F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.0601964681550337F, -0.0873F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7428121536172364F, -0.1F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -1F, 2);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.402910321115726F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.581101130194616F, 0.1309F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.481101130194616F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.02547687289441354F, 0.0873F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Root.y = Mth.lerp(sleepProgress, 5.0F, -9);
				this.RightFoot.z = Mth.lerp(sleepProgress, -1.0F, 2);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.4465288361160007F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -1.2300491170387584F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 1.2300491170387584F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7428121536172364F, -0.1F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.23457224414434488F, 0);
			} else {
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.1309F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
				this.Hips.xRot = (-0.0125F * Mth.sin(0.1F * ageInTicks / 3) + 0.025F) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.0873F;
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.0873F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.0873F + attackProgress * (float)Math.toRadians(-40F);
				this.Jaw.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.RightArm.zRot = 0.05F * Mth.sin(0.15F * ageInTicks / 3) - 0.025F;
				this.LeftArm.zRot = -0.05F * Mth.sin(0.15F * ageInTicks / 3) + 0.025F;
				this.RightArm.xRot = (-0.05F * Mth.sin(0.15F * ageInTicks / 3) + 0.2618F) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount;
				this.LeftArm.xRot = (-0.05F * Mth.sin(0.15F * ageInTicks / 3) + 0.2618F) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.1F;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.1F;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.1F;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.1F;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
//					this.RightThigh.y = -3;
//					this.LeftThigh.y = -3;
					this.Root.y = 16;
					this.Hips.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.Neck.xRot = 0.25F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.125F;
					this.RightArm.xRot = 0.125F;
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Root.y = -9F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.y = 11F;
		this.RightLeg.y = 11F;
		this.Tail1.xRot = -0.0873F;
		this.Tail1.yRot = 0;
		this.Head.y = -10.05F;
		this.Head.z = -6;
		this.Head.xRot = -0.0873F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LeftThigh.x = 5.5F;
		this.LeftThigh.y = 6F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftFoot.z = 2.0F;
		this.LeftFoot.xRot = 0;
		this.Neck.y = -15F;
		this.Neck.z = -7.5F;
		this.Neck.xRot = 0.1309F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail2.xRot = 0.0873F;
		this.Tail2.yRot = 0;
		this.Hips.y = -3F;
		this.Hips.xRot = 0;
		this.Hips.zRot = 0;
		this.RightFoot.z = 2.0F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.LeftArm.xRot = 0.2618F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.xRot = 0.2618F;
		this.RightArm.zRot = 0;
		this.RightThigh.x = -5.5F;
		this.RightThigh.y = 6F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Jaw.xRot = 0;
	}

	public void sleepPose() {
		this.RightLeg.xRot = -0.6600982340775168F;
		this.LeftLeg.xRot = -0.6600982340775168F;
		this.Tail1.xRot = -0.2400491170387584F;
		this.Tail1.yRot = 0.19547687289441354F;
		this.Head.xRot = 0.0601964681550337F;
		this.LeftThigh.xRot = -0.7428121536172364F;
		this.LeftThigh.yRot = -0.23457224414434488F;
		this.LeftFoot.z = -1F;
		this.LeftFoot.xRot = 1.402910321115726F;
		this.Neck.xRot = 0.581101130194616F;
		this.Neck.yRot = 0.481101130194616F;
		this.Tail2.xRot = 0.02547687289441354F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Root.y = 5.0F;
		this.RightFoot.z = -1.0F;
		this.RightFoot.xRot = 1.4465288361160007F;
		this.LeftArm.zRot = -1.2300491170387584F;
		this.RightArm.zRot = 1.2300491170387584F;
		this.RightThigh.xRot = -0.7428121536172364F;
		this.RightThigh.yRot = 0.23457224414434488F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
