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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yangchuanosaurus;

public class YangchuanosaurusModel extends EntityModel<Yangchuanosaurus> {
	private final ModelPart Root;
	private final ModelPart Hips;
	private final ModelPart Chest;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public YangchuanosaurusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Hips = this.Root.getChild("Hips");
		this.Chest = this.Hips.getChild("Chest");
		this.RightArm = this.Chest.getChild("RightArm");
		this.LeftArm = this.Chest.getChild("LeftArm");
		this.Neck = this.Chest.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
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

		PartDefinition Hips = Root.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(88, 106).addBox(-6.5F, -7.5F, -8.5F, 13.0F, 25.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.5F, -3.5F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(90, 57).addBox(-7.5F, -1.0F, -24.5F, 15.0F, 24.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, -9.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(14, 67).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 15.0F, -17.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(14, 67).mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 15.0F, -17.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, -14.5F, -9.0F, 7.0F, 21.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.3F, -24.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(55, 77).addBox(-4.0F, -9.0F, -7.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(15, 27).addBox(-2.5F, -9.0F, -19.0F, 5.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.3F, -5.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(86, 36).mirror().addBox(0.0F, -2.0F, -5.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, -9.0F, -12.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 36).addBox(-2.0F, -2.0F, -5.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -9.0F, -12.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(82, 67).addBox(-4.0F, -0.75F, -11.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.25F, -7.5F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(66, 35).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(61, 26).addBox(-3.5F, -3.99F, -5.01F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.01F))
				.texOffs(134, 38).addBox(-2.5F, 1.0F, -19.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Jaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(61, 13).addBox(-1.5F, -0.625F, -11.0F, 3.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.875F, -7.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 58).addBox(-5.0F, -7.0F, 0.0F, 10.0F, 16.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 13.5F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 9.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 34.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 109).mirror().addBox(-4.5F, -3.5F, -8.0F, 9.0F, 23.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, -35.5F, -1.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -1.5F, 6.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.5F, 4.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(110, 35).mirror().addBox(-3.5F, 0.0F, -10.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.0F, 4.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 109).addBox(-4.5F, -3.5F, -8.0F, 9.0F, 23.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -35.5F, -1.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -1.5F, 6.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.5F, 4.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(110, 35).addBox(-3.5F, 0.0F, -10.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 170, 154);
	}

	@Override
	public void setupAnim(Yangchuanosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.6600982340775168F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.6600982340775168F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.2300491170387584F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.2201964681550337F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -35.5F, -19);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7428121536172364F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.23457224414434488F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 4, -1F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.402910321115726F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.481101130194616F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.04547687289441354F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Hips.y = Mth.lerp(sleepProgress, -37.5F, -22.0F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 4, -1.0F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.4465288361160007F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.7300491170387584F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.7300491170387584F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -35.5F, -19);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7428121536172364F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.6600982340775168F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.6600982340775168F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2300491170387584F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.2201964681550337F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -19, -35.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7428121536172364F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.23457224414434488F, 0);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -1F, 4);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.402910321115726F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.481101130194616F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.04547687289441354F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Hips.y = Mth.lerp(sleepProgress, -22.0F, -37.5F);
				this.RightFoot.z = Mth.lerp(sleepProgress, -1.0F, 4);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.4465288361160007F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.7300491170387584F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.7300491170387584F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -19, -35.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7428121536172364F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
			} else {
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
				this.Hips.xRot = (-0.0125F * Mth.sin(0.1F * ageInTicks / 3) + 0.025F) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float)Math.toRadians(-40F);
				this.Jaw.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.RightArm.zRot = 0.05F * Mth.sin(0.15F * ageInTicks / 3) - 0.025F;
				this.LeftArm.zRot = -0.05F * Mth.sin(0.15F * ageInTicks / 3) + 0.025F;
				this.RightArm.xRot = (-0.05F * Mth.sin(0.15F * ageInTicks / 3) + 0.025F) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftArm.xRot = (-0.05F * Mth.sin(0.15F * ageInTicks / 3) + 0.025F) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
					this.RightThigh.y = -3;
					this.LeftThigh.y = -3;
					this.Hips.y = -5;
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
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.y = 14.5F;
		this.RightLeg.y = 14.5F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Head.y = -5.3F;
		this.Head.z = -5;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LeftThigh.x = -6.5F;
		this.LeftThigh.y = -35.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftFoot.z = 4.0F;
		this.LeftFoot.xRot = 0;
		this.Neck.y = 5.3F;
		this.Neck.z = -21.5F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Hips.y = -37.5F;
		this.Hips.xRot = 0;
		this.Hips.zRot = 0;
		this.RightFoot.z = 4.0F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.zRot = 0;
		this.RightThigh.x = 6.5F;
		this.RightThigh.y = -35.5F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Jaw.xRot = 0;
	}

	public void sleepPose() {
		this.RightLeg.xRot = -0.6600982340775168F;
		this.LeftLeg.xRot = -0.6600982340775168F;
		this.Tail1.xRot = -0.2300491170387584F;
		this.Tail1.yRot = 0.19547687289441354F;
		this.Head.xRot = -0.2201964681550337F;
		this.LeftThigh.y = -19;
		this.LeftThigh.xRot = -0.7428121536172364F;
		this.LeftThigh.yRot = 0.23457224414434488F;
		this.LeftFoot.z = -1F;
		this.LeftFoot.xRot = 1.402910321115726F;
		this.Neck.xRot = 0.481101130194616F;
		this.Tail2.xRot = 0.04547687289441354F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Hips.y = -22.0F;
		this.RightFoot.z = -1.0F;
		this.RightFoot.xRot = 1.4465288361160007F;
		this.LeftArm.zRot = 0.7300491170387584F;
		this.RightArm.zRot = -0.7300491170387584F;
		this.RightThigh.y = -19;
		this.RightThigh.xRot = -0.7428121536172364F;
		this.RightThigh.yRot = -0.23457224414434488F;
	}
	
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
