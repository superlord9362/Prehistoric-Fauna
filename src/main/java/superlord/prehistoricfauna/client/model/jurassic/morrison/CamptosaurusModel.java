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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camptosaurus;

public class CamptosaurusModel extends EntityModel<Camptosaurus> {
	private final ModelPart Hips;
	private final ModelPart Chest;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public CamptosaurusModel(ModelPart root) {
		this.Hips = root.getChild("Hips");
		this.Chest = this.Hips.getChild("Chest");
		this.Neck = this.Chest.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.RightArm = this.Chest.getChild("RightArm");
		this.LeftArm = this.Chest.getChild("LeftArm");
		this.RightThigh = this.Hips.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Hips.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.Tail1 = this.Hips.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hips = partdefinition.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(64, 0).addBox(-9.0F, -11.0F, -1.0F, 10.0F, 20.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(83, 34).addBox(-4.0F, -12.0F, -1.0F, 0.0F, 1.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -8.0F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -7.0F, -16.0F, 14.0F, 17.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(83, 35).addBox(0.0F, -8.0F, -16.0F, 0.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.0F, -1.0F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 36).addBox(-2.0F, -11.0F, -7.0F, 4.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -16.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(103, 7).addBox(-2.5F, -1.01F, -6.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(46, 0).addBox(-1.5F, -0.01F, -11.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -5.0F));
		
		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 7.0F, -10.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-1.0F, -1.0F, -3.0F, 3.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 6.0F, -9.0F));

		PartDefinition RightThigh = Hips.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(22, 35).addBox(0.0F, -5.0F, -6.0F, 6.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, 9.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(58, 39).addBox(-1.5F, -6.0F, -3.0F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 16.0F, 6.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(76, 39).addBox(-2.0F, -2.0F, -7.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition LeftThigh = Hips.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(22, 35).mirror().addBox(-2.0F, -5.0F, -6.0F, 6.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, -4.0F, 9.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(58, 39).mirror().addBox(-1.5F, -6.0F, -3.0F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 16.0F, 6.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(76, 39).mirror().addBox(-2.0F, -2.0F, -7.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 68).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 10.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(83, 34).addBox(0.0F, -5.0F, 0.0F, 0.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -6.0F, 18.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(51, 50).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 6.0F, 25.0F, new CubeDeformation(0.0F))
		.texOffs(51, 58).addBox(0.0F, -4.0F, 0.0F, 0.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 21.0F));

		return LayerDefinition.create(meshdefinition, 125, 100);
	}

	@Override
	public void setupAnim(Camptosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.45378560551852565F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.296705972839036F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -4F, -3F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.Hips.y = Mth.lerp(sleepProgress, 0, 11.5F);
				this.Hips.xRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -4F, -3F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.296705972839036F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.9773843811168246F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.2962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.45378560551852565F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Tail1.z = Mth.lerp(sleepProgress, 18, 17F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.07853981633974483F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.593411945678072F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.45378560551852565F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.296705972839036F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -3F, -4F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.Hips.y = Mth.lerp(sleepProgress, 11.5F, 0);
				this.Hips.xRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -3F, -4F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.296705972839036F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.9773843811168246F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.2962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.45378560551852565F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Tail1.z = Mth.lerp(sleepProgress, 17, 18F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.07853981633974483F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.593411945678072F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
			} else {
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
				}
				if (entity.isInWater()) {
					this.Hips.y = 10;
					this.Hips.xRot = -0.5F;
					this.Tail1.xRot = 0.25F;
					this.Tail2.xRot = 0.25F;
					this.Neck.xRot = 0.5F;
					this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.5F;
					this.RightArm.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Hips.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftThigh.y = -4.0F;
		this.LeftArm.z = -9;
		this.Hips.y = 0;
		this.Tail2.x = 0.0F;
		this.Tail2.z = 21;
		this.RightThigh.y = -4;
		this.Head.x = 0;
		this.Head.z = -5;
		this.RightArm.z = -10.0F;
		this.Tail1.x = -4;
		this.Tail1.z = 18;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.45378560551852565F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = 0.296705972839036F;
		this.LeftThigh.y = -3F;
		this.LeftArm.xRot = 0.8726646259971648F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Hips.y = 11.5F;
		this.Hips.xRot = -0.24434609527920614F;
		this.Tail2.xRot = 0.13962634015954636F;
		this.Tail2.yRot = -0.593411945678072F;
		this.Tail2.zRot = -0.10471975511965977F;
		this.RightThigh.y = -3F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = -0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		this.Head.yRot = 0.2962634015954636F;
		this.RightLeg.xRot = -0.45378560551852565F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.Tail1.z = 17F;
		this.Tail1.xRot = -0.07853981633974483F;
		this.Tail1.yRot = -0.593411945678072F;
		this.Tail1.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Hips.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}