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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Abrosaurus;

public class AbrosaurusModel extends EntityModel<Abrosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;

	public AbrosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftArm = this.root.getChild("LeftArm");
		this.RightArm = this.root.getChild("RightArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 9.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -34.0F, -8.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -21.0F, -34.0F, 22.0F, 31.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 8.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 26.0F));

		PartDefinition cube_r2 = Tail1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(132, 83).addBox(-7.0F, -9.0F, -3.0F, 14.0F, 17.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.6719F, 2.5773F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 83).addBox(-3.5F, -3.3281F, -1.4227F, 7.0F, 7.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 43.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create(), PartPose.offset(0.0F, -17.0F, -24.0F));

		PartDefinition cube_r3 = Neck1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(132, 146).addBox(-5.0F, -14.0F, -29.0F, 10.0F, 15.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, -16.0F));

		PartDefinition cube_r4 = Neck2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(60, 149).addBox(-3.0F, -33.1716F, -7.3015F, 6.0F, 32.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(92, 171).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(134, 195).addBox(-3.0F, -2.0F, -11.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 185).addBox(-3.0F, -4.0F, -9.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -23.0F, -16.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(148, 0).addBox(-5.0F, -7.1467F, -7.2719F, 10.0F, 25.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -35.8533F, 10.2719F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(92, 149).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.8533F, -4.2719F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(60, 191).addBox(-5.0F, 0.0F, -7.0F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 4.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(148, 39).addBox(-5.0F, -7.1467F, -7.2719F, 10.0F, 25.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -35.8533F, 10.2719F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(102, 195).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.8533F, -4.2719F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 195).addBox(-5.0F, 0.0F, -7.0F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 4.0F));

		PartDefinition LeftArm = root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 149).addBox(-5.0F, -3.0F, -4.0F, 7.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(148, 78).addBox(-7.0F, 33.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -35.0F, -26.0F));

		PartDefinition RightArm = root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(30, 149).addBox(-2.0F, -3.0F, -4.0F, 7.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(124, 149).addBox(5.0F, 33.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -35.0F, -26.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Abrosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.root.y = Mth.lerp(sleepProgress, 24, 47F);
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
				this.RightArm.x = Mth.lerp(sleepProgress, -11, -3F);
				this.RightArm.y = Mth.lerp(sleepProgress, -35, -24F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -0.2443F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -1.5571F);
				this.LeftArm.x = Mth.lerp(sleepProgress, 11, 0);
				this.LeftArm.y = Mth.lerp(sleepProgress, -35, -47F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.2745F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.9672F);
				this.RightThigh.x = Mth.lerp(sleepProgress, -9, -3);
				this.RightThigh.y = Mth.lerp(sleepProgress, -35.8533F, -26);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.1737F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0166F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -1.5344F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.5206F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.05F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -35.8533F, -43F);
				this.LeftThigh.x = Mth.lerp(sleepProgress, 9, 0.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.0436F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -1.29F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.3926F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.root.y = Mth.lerp(sleepProgress, 47F, 24);
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
				this.RightArm.x = Mth.lerp(sleepProgress, -3, -11F);
				this.RightArm.y = Mth.lerp(sleepProgress, -24, -35F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.2443F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -1.5571F, 0);
				this.LeftArm.x = Mth.lerp(sleepProgress, 0, 11);
				this.LeftArm.y = Mth.lerp(sleepProgress, -47F, -35);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.2745F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.9672F, 0);
				this.RightThigh.x = Mth.lerp(sleepProgress, -3, -9);
				this.RightThigh.y = Mth.lerp(sleepProgress, -26, -35.8533F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.1737F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.0166F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -1.5344F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.5206F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.05F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -43F, -35.8533F);
				this.LeftThigh.x = Mth.lerp(sleepProgress, 0.5F, 9);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.0436F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -1.29F, 0);
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
					this.root.y = 70;
					this.root.xRot = 0.19F;
					this.Tail1.xRot = -0.125F;
					this.Tail2.xRot = -0.125F;
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
					this.Neck1.xRot = 0.4F;
					this.Head.xRot = -0.6F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.root.y = 24F;
		this.Body.x = 0;
		this.Body.y = -34;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.Neck1.y = -17F;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.y = -15;
		this.Neck2.xRot = 0;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = 11;
		this.LeftArm.y = -35;
		this.LeftArm.z = -26;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.x = -11F;
		this.RightArm.y = -35F;
		this.RightArm.z = -26F;
		this.RightArm.xRot = 0F;
		this.RightArm.zRot = 0;
		this.LeftThigh.x = 9;
		this.LeftThigh.y = -35.8533F;
		this.LeftThigh.z = 10.2719F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.x = -9;
		this.RightThigh.y = -35.8533F;
		this.RightThigh.z = 10.2719F;
		this.RightThigh.xRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 14F;
		this.RightFoot.z = 4F;
		this.LeftFoot.xRot = 0F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.root.xRot = 0;
	}

	public void sleepPose() {
		this.root.y = 47F;
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
		this.RightArm.x = -3F;
		this.RightArm.y = -24F;
		this.RightArm.xRot = -0.2443F;
		this.RightArm.zRot = -1.5571F;
		this.LeftArm.x = 0;
		this.LeftArm.y = -47F;
		this.LeftArm.xRot = 0.2745F;
		this.LeftArm.zRot = -0.9672F;
		this.RightThigh.x = -3;
		this.RightThigh.y = -26;
		this.RightThigh.xRot = -0.1737F;
		this.RightThigh.yRot = -0.0166F;
		this.RightThigh.zRot = -1.5344F;
		this.RightLeg.xRot = 0.5206F;
		this.RightLeg.yRot = 0.05F;
		this.LeftThigh.y = -43F;
		this.LeftThigh.x = 0.5F;
		this.LeftThigh.xRot = 0.0436F;
		this.LeftThigh.zRot = -1.29F;
		this.LeftLeg.xRot = 0.3926F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}