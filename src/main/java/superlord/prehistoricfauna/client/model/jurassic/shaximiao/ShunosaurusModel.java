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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Shunosaurus;

public class ShunosaurusModel extends EntityModel<Shunosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public ShunosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -6.8533F, 14.2719F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -23.0F, -1.0F, 20.0F, 23.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.8533F, -35.2719F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create(), PartPose.offset(0.0F, -11.1467F, -32.5219F));

		PartDefinition cube_r2 = Neck1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(40, 109).addBox(-4.0F, -22.0F, -1.0F, 8.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.75F, 0.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -17.25F));

		PartDefinition cube_r3 = Neck2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(124, 35).addBox(-2.5F, -24.0F, 1.0F, 5.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.5F, 1.0036F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(56, 142).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 150).addBox(-2.0F, 1.0F, -9.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(150, 146).addBox(-1.5F, -1.0F, -8.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.3533F, -15.7281F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(150, 53).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(150, 139).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create(), PartPose.offset(0.0F, -7.1467F, 7.7281F));

		PartDefinition cube_r4 = Tail1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 65).addBox(-4.5F, -13.0F, -1.0F, 9.0F, 11.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, -2.25F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 31.0F));

		PartDefinition cube_r5 = Tail2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(73, 145).addBox(0.0F, -11.5F, 32.0F, 0.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 141).addBox(-3.0F, -7.5F, 32.0F, 6.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(90, 71).addBox(-2.5F, -7.0F, 5.0F, 5.0F, 6.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -7.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(124, 0).addBox(-5.0F, -3.0F, -3.0F, 7.0F, 28.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).mirror().addBox(-7.0F, 23.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 5.8533F, -28.2719F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(124, 0).mirror().addBox(-2.0F, -3.0F, -3.0F, 7.0F, 28.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(5.0F, 23.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 5.8533F, -28.2719F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(84, 104).addBox(-4.0F, -4.1467F, -6.2719F, 8.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(30, 142).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.8533F, -4.2719F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(78, 136).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 4.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(84, 104).mirror().addBox(-4.0F, -4.1467F, -6.2719F, 8.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(30, 142).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 15.8533F, -4.2719F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(78, 136).mirror().addBox(-4.0F, 0.0F, -7.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 192, 192);
	}

	@Override
	public void setupAnim(Shunosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.root.y = Mth.lerp(sleepProgress, -6.8533F, 12F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.0522F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, 0.0079F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -1.4701F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0, 0.4171F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 0.3232F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.0561F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, 0, 0.2676F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, -0.0596F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, 0.1181F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.2552F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.3152F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.051F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.206F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, -0.1642F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.1591F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.0235F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -0.2443F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.1071F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 5.8533F, 8F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.2745F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.5672F);
				this.RightThigh.x = Mth.lerp(sleepProgress, -9, -3);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0, 10);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.1737F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0166F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -1.5344F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.5206F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.05F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, -0.121F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0, -7.75F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.0436F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -1.029F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.3926F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.root.y = Mth.lerp(sleepProgress, 12, -6.8533F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.0522F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0.0079F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -1.4701F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.4171F, 0);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0.3232F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.0561F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, 0.2676F, 0);
				this.Neck2.yRot = Mth.lerp(sleepProgress, -0.0596F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0.1181F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.2552F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.3152F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.051F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.206F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.1642F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.1591F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.0235F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.2443F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.1071F, 0);
				this.LeftArm.y = Mth.lerp(sleepProgress, 8, 5.8533F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.2745F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.5672F, 0);
				this.RightThigh.x = Mth.lerp(sleepProgress, -3, -9);
				this.RightThigh.y = Mth.lerp(sleepProgress, 10, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.1737F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.0166F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -1.5344F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.5206F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.05F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, -0.121F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -7.75F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.0436F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -1.029F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.3926F, 0);
			} else {
				this.Body.xRot = (attackProgress * (float)Math.toRadians(-50));
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + (headPitch * ((float) Math.PI / 270F)) + (attackProgress * (float)Math.toRadians(50));
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 360F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + (headPitch * ((float) Math.PI / 270F));
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount + (netHeadYaw * ((float) Math.PI / 270));
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) - (headPitch * ((float) Math.PI / 270F)); 
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftArm.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.RightArm.xRot = (Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.root.y = 25;
					this.root.xRot = 0.15F;
//					this.Tail1.xRot = 0.125F;
//					this.Tail2.xRot = 0.125F;
//					this.RightThigh.y = 27;
//					this.LeftThigh.y = 27;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck1.xRot = 0.1F;
					this.Head.xRot = -0.25F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.root.y = -6.8533F;
		this.root.xRot = 0;
		this.Body.x = 0;
		this.Body.y = 0;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.Neck1.y = -11.1467F;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.y = -6;
		this.Neck2.xRot = 0;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Head.xRot = 0.0873F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = 9;
		this.LeftArm.y = 5.8533F;
		this.LeftArm.z = -28.2719F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.x = -9F;
		this.RightArm.y = 5.8533F;
		this.RightArm.z = -28.2719F;
		this.RightArm.xRot = 0F;
		this.RightArm.zRot = 0;
		this.LeftThigh.x = 9;
		this.LeftThigh.y = 0;
		this.LeftThigh.z = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.x = -9;
		this.RightThigh.y = 0;
		this.RightThigh.z = 0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 11F;
		this.RightFoot.z = 4F;
		this.LeftFoot.xRot = 0F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
	}

	public void sleepPose() {
		this.root.y = 12F;
		this.Body.xRot = -0.0522F;
		this.Body.yRot = 0.0079F;
		this.Body.zRot = -1.4701F;
		this.Neck1.xRot = 0.4171F;
		this.Neck1.yRot = 0.3232F;
		this.Neck1.zRot = 0.0561F;
		this.Neck2.xRot = 0.2676F;
		this.Neck2.yRot = -0.0596F;
		this.Neck2.zRot = 0.1181F;
		this.Head.yRot = -0.2552F;
		this.Tail1.xRot = -0.3152F;
		this.Tail1.yRot = -0.051F;
		this.Tail1.zRot = 0.206F;
		this.Tail2.xRot = -0.1642F;
		this.Tail2.yRot = 0.1591F;
		this.Tail2.zRot = 0.0235F;
		this.RightArm.xRot = -0.2443F;
		this.RightArm.zRot = -0.1071F;
		this.LeftArm.y = 8F;
		this.LeftArm.xRot = 0.2745F;
		this.LeftArm.zRot = 0.5672F;
		this.RightThigh.x = -3;
		this.RightThigh.y = 10;
		this.RightThigh.xRot = -0.1737F;
		this.RightThigh.yRot = -0.0166F;
		this.RightThigh.zRot = -1.5344F;
		this.RightLeg.xRot = 0.5206F;
		this.RightLeg.yRot = 0.05F;
		this.RightLeg.zRot = -0.121F;
		this.LeftThigh.y = -7.75F;
		this.LeftThigh.xRot = 0.0436F;
		this.LeftThigh.zRot = -1.029F;
		this.LeftLeg.xRot = 0.3926F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}