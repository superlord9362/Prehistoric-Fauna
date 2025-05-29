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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Bashanosaurus;

public class BashanosaurusModel extends EntityModel<Bashanosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public BashanosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
		this.Tail2 = this.Tail.getChild("Tail2");
		this.RightArm = this.root.getChild("RightArm");
		this.LeftArm = this.root.getChild("LeftArm");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(80, 103).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 9.0F, 16.0F, new CubeDeformation(0.01F))
		.texOffs(32, 25).addBox(1.0F, -8.0F, -8.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-1.0F, -8.0F, -8.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(50, 58).addBox(-1.5F, -2.5F, -6.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(72, 66).addBox(-0.5F, -3.5F, -6.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(72, 72).addBox(0.5F, -3.5F, -6.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -8.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(83, 12).addBox(-1.52F, -1.49F, -2.01F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.01F))
		.texOffs(73, 12).addBox(-1.02F, -1.49F, -5.01F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.02F, -1.0F, -6.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(63, 78).addBox(-2.0F, -2.225F, 0.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-0.5F, -5.225F, 1.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(48, 12).addBox(0.5F, -5.225F, 1.0F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.75F, 7.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(66, 12).addBox(-0.5F, -3.4842F, 0.1407F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(50, 67).addBox(0.5F, -3.4842F, 0.1407F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(76, 78).addBox(-1.0F, -1.4842F, -0.8593F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.7158F, 9.8593F));

		PartDefinition cube_r1 = Tail2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, -4.95F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.5342F, 10.1407F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = Tail2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 67).addBox(0.0F, -4.95F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.5342F, 10.1407F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightArm = root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 61).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -8.0F, -5.5F));

		PartDefinition LeftArm = root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 61).mirror().addBox(-2.0F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -8.0F, -5.5F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(32, 58).addBox(0.0F, -2.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(41, 116).addBox(0.0F, -2.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(1.5F, -10.0F, 4.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(24, 70).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.3F, 5.0F, 1.9F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(64, 38).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(32, 58).mirror().addBox(-4.0F, -2.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 116).mirror().addBox(-4.0F, -2.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(-1.5F, -10.0F, 4.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(24, 70).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.3F, 5.0F, 1.9F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(64, 38).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Bashanosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.z = Mth.lerp(sleepProgress, -8, -7);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.4025023820775095F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.23665191262740524F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 0.18256144042439712F);
				this.LeftFoot.yRot = Mth.lerp(sleepProgress, 0, 0.18256144042439712F);
				this.LeftFoot.zRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -10, -7.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.14608405639455457F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.14625859331449564F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, 0.6932448001974364F);
				this.RightArm.y = Mth.lerp(sleepProgress, -8, -1F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -0.21868975061435758F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 1.460491523395177F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.1459095194746135F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.07278023113974408F);
				this.Tail.z = Mth.lerp(sleepProgress, 8, 7);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.4782202083885436F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.18238690350445608F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, -0.2553416715641412F);
				this.Body.y = Mth.lerp(sleepProgress, -10, -5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.03665191262740524F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.07312929665724782F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 1.2407545013269026F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -10, -3.7F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.4742059590984399F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 1.4606660936046318F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, -0.10943214376714933F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.4010766541188137F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.3282964229790696F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.3282964229790696F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -1.7453292129831807E-4F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.56477380700891215F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.z = Mth.lerp(sleepProgress, -7, -8);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.4025023820775095F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.23665191262740524F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0.18256144042439712F, 0);
				this.LeftFoot.yRot = Mth.lerp(sleepProgress, 0.18256144042439712F, 0);
				this.LeftFoot.zRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -7.5F, -10);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.14608405639455457F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.14625859331449564F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0.6932448001974364F, 0);
				this.RightArm.y = Mth.lerp(sleepProgress, -1, -8F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.21868975061435758F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 1.460491523395177F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.1459095194746135F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.07278023113974408F, 0);
				this.Tail.z = Mth.lerp(sleepProgress, 7, 8);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.4782202083885436F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.18238690350445608F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, -0.2553416715641412F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -5, -10F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.03665191262740524F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.07312929665724782F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 1.2407545013269026F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -3.7F, -10);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.4742059590984399F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 1.4606660936046318F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.10943214376714933F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.4010766541188137F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.3282964229790696F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.3282964229790696F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -1.7453292129831807E-4F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.56477380700891215F, 0);
			} else {
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount);
				this.Tail2.zRot = attackProgress * leftOrRight * (float)Math.toRadians(30F);
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = 0.3F;
					this.RightArm.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.Body.y = -5;
					this.Body.xRot = -0.125F;
					this.Tail.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.RightThigh.y = -5;
					this.LeftThigh.y = -5;
					this.RightArm.y = -5;
					this.LeftArm.y = -5;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.125F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Neck.x = 0;
		this.Neck.y = -1.5F;
		this.Neck.z = -8;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftThigh.x = -1.5F;
		this.LeftThigh.y = -10;
		this.LeftThigh.z = 4;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.y = -8F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.zRot = 0;
		this.Tail.y = -2.75F;
		this.Tail.z = 8;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Body.x = 0;
		this.Body.y = -10;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightThigh.y = -10.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Head.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.y = -8.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
	}

	public void sleepPose() {
		this.Neck.z = -7;
		this.Neck.xRot = 0.4025023820775095F;
		this.Neck.yRot = -0.23665191262740524F;
		this.LeftFoot.xRot = 0.18256144042439712F;
		this.LeftFoot.yRot = 0.18256144042439712F;
		this.LeftFoot.zRot = -0.036477379868653376F;
		this.LeftThigh.y = -7.5F;
		this.LeftThigh.xRot = -0.14608405639455457F;
		this.LeftThigh.yRot = -0.14625859331449564F;
		this.LeftThigh.zRot = 0.6932448001974364F;
		this.RightArm.y = -1F;
		this.RightArm.xRot = -0.21868975061435758F;
		this.RightArm.yRot = -0.036477379868653376F;
		this.RightArm.zRot = 1.460491523395177F;
		this.RightLeg.xRot = 0.1459095194746135F;
		this.RightLeg.zRot = 0.07278023113974408F;
		this.Tail.z = 7;
		this.Tail.xRot = -0.4782202083885436F;
		this.Tail.yRot = 0.18238690350445608F;
		this.Tail.zRot = -0.2553416715641412F;
		this.Body.y = -5F;
		this.Body.xRot = -0.03665191262740524F;
		this.Body.yRot = -0.07312929665724782F;
		this.Body.zRot = 1.2407545013269026F;
		this.RightThigh.y = -3.7F;
		this.RightThigh.xRot = 0.4742059590984399F;
		this.RightThigh.zRot = 1.4606660936046318F;
		this.Head.xRot = -0.036477379868653376F;
		this.Tail2.xRot = -0.10943214376714933F;
		this.Tail2.yRot = -0.4010766541188137F;
		this.Tail2.zRot = -0.3282964229790696F;
		this.LeftArm.xRot = 0.3282964229790696F;
		this.LeftArm.yRot = -1.7453292129831807E-4F;
		this.LeftArm.zRot = 0.56477380700891215F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}