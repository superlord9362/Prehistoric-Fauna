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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Alcovasaurus;

public class AlcovasaurusModel extends EntityModel<Alcovasaurus> {
	private final ModelPart Body;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head;

	public AlcovasaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -12.0F, -18.0F, 16.0F, 21.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -13.0F, -18.0F, 0.0F, 13.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -12.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, -13.0F, -18.0F, 0.0F, 13.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -12.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(52, 69).addBox(-5.0F, -5.0F, -7.0F, 8.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -1.0F, 10.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(67, 0).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 11.0F, -3.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(91, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 3.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(52, 69).mirror().addBox(-3.0F, -5.0F, -7.0F, 8.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -1.0F, 10.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(67, 0).mirror().addBox(-3.0F, 0.0F, -1.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 11.0F, -3.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(91, 0).mirror().addBox(-4.0F, 0.0F, -6.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, 3.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(13, 5).addBox(-3.0F, -2.0F, -3.0F, 5.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 4.0F, -11.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(13, 5).mirror().addBox(-2.0F, -2.0F, -3.0F, 5.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 4.0F, -11.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 69).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 17.0F));

		PartDefinition cube_r3 = Tail1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(143, -4).mirror().addBox(0.0F, -13.0F, -10.0F, 0.0F, 13.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -2.0F, 10.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r4 = Tail1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(143, -4).addBox(0.0F, -13.0F, -10.0F, 0.0F, 13.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.0F, 10.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(106, 54).addBox(-1.5F, -3.025F, -1.0F, 5.0F, 6.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.0F, 17.0F));

		PartDefinition cube_r5 = Tail2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(102, 5).mirror().addBox(0.0F, -12.025F, -4.0F, 0.0F, 18.0F, 31.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r6 = Tail2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(102, 5).addBox(0.0F, -12.025F, -4.0F, 0.0F, 18.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, 4.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(74, 29).addBox(1.0F, -8.0F, -27.0F, 0.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(102, 0).addBox(-3.0F, -3.0F, -27.0F, 6.0F, 8.0F, 28.0F, new CubeDeformation(0.0F))
				.texOffs(74, 29).mirror().addBox(-1.0F, -8.0F, -27.0F, 0.0F, 5.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -7.0F, -18.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -9.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 10).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -27.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Alcovasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.3025023820775095F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.28665191262740524F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 0.18256144042439712F);
				this.RightFoot.yRot = Mth.lerp(sleepProgress, 0, 0.18256144042439712F);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.14608405639455457F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.1932448001974364F);
				this.LeftArm.x = Mth.lerp(sleepProgress, -7, -8.0F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -0.21868975061435758F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.360491523395177F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.1459095194746135F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.17278023113974408F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.4782202083885436F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.18238690350445608F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.2553416715641412F);
				this.Body.y = Mth.lerp(sleepProgress, -2, 13F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 1.2407545013269026F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.1742059590984399F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.1606660936046318F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, -0.10943214376714933F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.4010766541188137F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.3282964229790696F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.2282964229790696F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -1.7453292129831807E-4F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 0.16477380700891215F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.3025023820775095F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.28665191262740524F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0.18256144042439712F, 0);
				this.RightFoot.yRot = Mth.lerp(sleepProgress, 0.18256144042439712F, 0);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.14608405639455457F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.1932448001974364F, 0);
				this.LeftArm.x = Mth.lerp(sleepProgress, -8.0F, -7);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -0.21868975061435758F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.360491523395177F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.1459095194746135F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.17278023113974408F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.4782202083885436F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.18238690350445608F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.2553416715641412F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 13F, -2);
				this.Body.zRot = Mth.lerp(sleepProgress, 1.2407545013269026F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.1742059590984399F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.1606660936046318F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.10943214376714933F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.4010766541188137F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.3282964229790696F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.2282964229790696F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -1.7453292129831807E-4F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.16477380700891215F, 0);
			} else {
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount);
				this.Tail2.zRot = attackProgress * leftOrRight * (float)Math.toRadians(30F);
//				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = 0.3F;
					this.RightArm.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.Body.y = 3;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.RightThigh.y = 19;
					this.LeftThigh.y = 19;
					this.RightArm.y = 23;
					this.LeftArm.y = 23;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Neck.x = 0;
		this.Neck.y = -7;
		this.Neck.z = -18;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
		this.LeftThigh.x = -7;
		this.LeftThigh.y = -1;
		this.LeftThigh.z = 10;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.y = 4.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.zRot = 0;
		this.Tail1.y = -7.0F;
		this.Tail1.z = 17;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Body.x = 0;
		this.Body.y = -2;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightThigh.y = -1.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Head.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.y = 4.0F;
		this.LeftArm.x = -7.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
	}

	public void sleepPose() {
		this.Neck.xRot = 0.3025023820775095F;
		this.Neck.yRot = -0.28665191262740524F;
		this.RightFoot.xRot = 0.18256144042439712F;
		this.RightFoot.yRot = 0.18256144042439712F;
		this.RightFoot.zRot = -0.036477379868653376F;
		this.RightThigh.xRot = -0.14608405639455457F;
		this.RightThigh.zRot = 0.1932448001974364F;
		this.LeftArm.x = -8.0F;
		this.LeftArm.xRot = -0.21868975061435758F;
		this.LeftArm.yRot = -0.036477379868653376F;
		this.LeftArm.zRot = -0.360491523395177F;
		this.LeftLeg.xRot = 0.1459095194746135F;
		this.LeftLeg.zRot = -0.17278023113974408F;
		this.Tail1.xRot = -0.4782202083885436F;
		this.Tail1.yRot = 0.18238690350445608F;
		this.Tail1.zRot = -0.2553416715641412F;
		this.Body.y = 13F;
		this.Body.zRot = 1.2407545013269026F;
		this.LeftThigh.xRot = 0.1742059590984399F;
		this.LeftThigh.zRot = -0.1606660936046318F;
		this.Head.xRot = -0.036477379868653376F;
		this.Tail2.xRot = -0.10943214376714933F;
		this.Tail2.yRot = -0.4010766541188137F;
		this.Tail2.zRot = -0.3282964229790696F;
		this.RightArm.xRot = 0.2282964229790696F;
		this.RightArm.yRot = -1.7453292129831807E-4F;
		this.RightArm.zRot = 0.16477380700891215F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
