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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Macelognathus;

@SuppressWarnings("unused")
public class MacelognathusModel extends EntityModel<Macelognathus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightArm;
	private final ModelPart RightHand;
	private final ModelPart LeftArm;
	private final ModelPart LeftHand;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public MacelognathusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightLeg = this.Root.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.RightArm = this.Root.getChild("RightArm");
		this.RightHand = this.RightArm.getChild("RightHand");
		this.LeftArm = this.Root.getChild("LeftArm");
		this.LeftHand = this.LeftArm.getChild("LeftHand");
		this.LeftLeg = this.Root.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(19, 3).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(10, 1).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 4).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 12).addBox(-0.5F, -1.0F, -5.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(22, 14).addBox(-0.5F, -1.075F, 0.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, 5.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(22, 16).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 8.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightLeg = Root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(19, 14).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 2.75F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(17, 20).addBox(-0.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightArm = Root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(14, 14).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -4.0F, -3.0F));

		PartDefinition RightHand = RightArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(12, 18).addBox(-0.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftLeg = Root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(19, 14).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -5.0F, 2.75F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(17, 20).mirror().addBox(-1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition LeftArm = Root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(14, 14).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -4.0F, -3.0F));

		PartDefinition LeftHand = LeftArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 48, 48);
	}

	@Override
	public void setupAnim(Macelognathus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		float sitProgress = entity.getSitProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -5.5F, -1.5F);
				this.RightLeg.y = Mth.lerp(sleepProgress, -5, 0);
				this.LeftLeg.y = Mth.lerp(sleepProgress, -5, 0);
				this.LeftArm.y = Mth.lerp(sleepProgress, -4, 0);
				this.RightArm.y = Mth.lerp(sleepProgress, -4, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.1745F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, -0.1745F, 0.1309F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.0873F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.3054F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.2618F, 0.0436F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.2618F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, -0.48F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, 0.48F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.4363F);
				this.LeftHand.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.4363F);
				this.RightHand.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
			} else sleepPose();
		} else if (entity.isSitting() || entity.isTameSitting()) {
			if (sitProgress != 0 && entity.getEntityData().get(Macelognathus.SIT_TICK) > 0) {
				this.Body.y = Mth.lerp(sitProgress, -5.5F, -1.5F);
				this.RightLeg.y = Mth.lerp(sitProgress, -5, 0);
				this.LeftLeg.y = Mth.lerp(sitProgress, -5, 0);
				this.LeftArm.y = Mth.lerp(sitProgress, -4, 0);
				this.RightArm.y = Mth.lerp(sitProgress, -4, 0);
				this.Body.xRot = Mth.lerp(sitProgress, 0.1745F, 0);
				this.Neck.xRot = Mth.lerp(sitProgress, -0.1745F, 0);
				this.RightLeg.xRot = Mth.lerp(sitProgress, 0, -1.5708F);
				this.RightLeg.yRot = Mth.lerp(sitProgress, 0, -0.48F);
				this.RightFoot.xRot = Mth.lerp(sitProgress, 0, 1.5708F);
				this.LeftLeg.xRot = Mth.lerp(sitProgress, 0, -1.5708F);
				this.LeftLeg.yRot = Mth.lerp(sitProgress, 0, 0.48F);
				this.LeftFoot.xRot = Mth.lerp(sitProgress, 0, 1.5708F);
				this.LeftArm.xRot = Mth.lerp(sitProgress, 0, -1.5708F);
				this.LeftArm.yRot = Mth.lerp(sitProgress, 0, 0.4363F);
				this.LeftHand.xRot = Mth.lerp(sitProgress, 0, 1.5708F);
				this.RightArm.xRot = Mth.lerp(sitProgress, 0, -1.5708F);
				this.RightArm.yRot = Mth.lerp(sitProgress, 0, -0.4363F);
				this.RightHand.xRot = Mth.lerp(sitProgress, 0, 1.5708F);
			} else  {
				sitPose();
				this.Neck.xRot = headPitch * ((float)Math.PI / 180F);
			}
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)));
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.2618F;
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -1.5F, -5.5F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 0, -5);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 0, -5);
				this.LeftArm.y = Mth.lerp(sleepProgress, 0, -4);
				this.RightArm.y = Mth.lerp(sleepProgress, 0, -4);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.1745F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.1309F, -0.1745F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0873F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.3054F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0436F, -0.2618F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.2618F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, -0.48F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0.48F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.4363F, 0);
				this.LeftHand.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.4363F, 0);
				this.RightHand.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
			} else if (sitProgress != 0 && entity.getEntityData().get(Macelognathus.SIT_TICK) > 0) {
				this.Body.y = Mth.lerp(sitProgress, -1.5F, -5.5F);
				this.RightLeg.y = Mth.lerp(sitProgress, 0, -5);
				this.LeftLeg.y = Mth.lerp(sitProgress, 0, -5);
				this.LeftArm.y = Mth.lerp(sitProgress, 0, -4);
				this.RightArm.y = Mth.lerp(sitProgress, 0, -4);
				this.Body.xRot = Mth.lerp(sitProgress, 0, 0.1745F);
				this.Neck.xRot = Mth.lerp(sitProgress, 0, -0.1745F);
				this.RightLeg.xRot = Mth.lerp(sitProgress, -1.5708F, 0);
				this.RightLeg.yRot = Mth.lerp(sitProgress, -0.48F, 0);
				this.RightFoot.xRot = Mth.lerp(sitProgress, 1.5708F, 0);
				this.LeftLeg.xRot = Mth.lerp(sitProgress, -1.5708F, 0);
				this.LeftLeg.yRot = Mth.lerp(sitProgress, 0.48F, 0);
				this.LeftFoot.xRot = Mth.lerp(sitProgress, 1.5708F, 0);
				this.LeftArm.xRot = Mth.lerp(sitProgress, -1.5708F, 0);
				this.LeftArm.yRot = Mth.lerp(sitProgress, 0.4363F, 0);
				this.LeftHand.xRot = Mth.lerp(sitProgress, 1.5708F, 0);
				this.RightArm.xRot = Mth.lerp(sitProgress, -1.5708F, 0);
				this.RightArm.yRot = Mth.lerp(sitProgress, -0.4363F, 0);
				this.RightHand.xRot = Mth.lerp(sitProgress, 1.5708F, 0);
				this.Neck.xRot = headPitch * ((float)Math.PI / 180F) - 0.1745F;
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)));
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.2618F;
			} else {
				this.Neck.xRot = headPitch * ((float)Math.PI / 180F) - 0.1745F;
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) - 0.2618F;
				if (entity.isInWater()) {
					this.RightArm.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = -5.5F;
		this.RightLeg.y = -5;
		this.LeftLeg.y = -5;
		this.LeftArm.y = -4;
		this.RightArm.y = -4;
		this.Body.xRot = 0.1745F;
		this.Neck.xRot = -0.1745F;
		this.Neck.yRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail2.xRot = -0.2618F;
		this.Tail2.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightFoot.xRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftHand.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightHand.xRot = 0;
	}

	public void sleepPose() {
		this.Body.y = -1.5F;
		this.RightLeg.y = 0;
		this.LeftLeg.y = 0;
		this.LeftArm.y = 0;
		this.RightArm.y = 0;
		this.Body.xRot = 0;
		this.Neck.xRot = 0.1309F;
		this.Neck.yRot = 0.2618F;
		this.Tail1.xRot = -0.0873F;
		this.Tail1.yRot = -0.3054F;
		this.Tail2.xRot = 0.0436F;
		this.Tail2.yRot = -0.2618F;
		this.RightLeg.xRot = -1.5708F;
		this.RightLeg.yRot = -0.48F;
		this.RightFoot.xRot = 1.5708F;
		this.LeftLeg.xRot = -1.5708F;
		this.LeftLeg.yRot = 0.48F;
		this.LeftFoot.xRot = 1.5708F;
		this.LeftArm.xRot = -1.5708F;
		this.LeftArm.yRot = 0.4363F;
		this.LeftHand.xRot = 1.5708F;
		this.RightArm.xRot = -1.5708F;
		this.RightArm.yRot = -0.4363F;
		this.RightHand.xRot = 1.5708F;
	}
	
	public void sitPose() {
		this.Body.y = -1.5F;
		this.RightLeg.y = 0;
		this.LeftLeg.y = 0;
		this.LeftArm.y = 0;
		this.RightArm.y = 0;
		this.Body.xRot = 0;
		this.RightLeg.xRot = -1.5708F;
		this.RightLeg.yRot = -0.48F;
		this.RightFoot.xRot = 1.5708F;
		this.LeftLeg.xRot = -1.5708F;
		this.LeftLeg.yRot = 0.48F;
		this.LeftFoot.xRot = 1.5708F;
		this.LeftArm.xRot = -1.5708F;
		this.LeftArm.yRot = 0.4363F;
		this.LeftHand.xRot = 1.5708F;
		this.RightArm.xRot = -1.5708F;
		this.RightArm.yRot = -0.4363F;
		this.RightHand.xRot = 1.5708F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}