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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Agilisaurus;

public class AgilisaurusModel extends EntityModel<Agilisaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public AgilisaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Neck = this.Body.getChild("Neck");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
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

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(12, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 1.0F, -3.5F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 1.0F, -3.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 12).addBox(-0.5F, -3.99F, -2.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, -0.975F, 0.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.475F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.475F, 8.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(19, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -7.0F, -0.025F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(8, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(2, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(19, 15).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.75F, -7.0F, -0.025F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(8, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(2, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 22);
	}

	@Override
	public void setupAnim(Agilisaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.296705972839036F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -7, -2.7F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.Body.y = Mth.lerp(sleepProgress, -6.5F, -2.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.24962634015954636F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -7, -2.7F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.296705972839036F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.9773843811168246F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.07853981633974483F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.593411945678072F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.7F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.296705972839036F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -2.7F, -7F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -2.5F, -6.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.24962634015954636F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -2.7F, -7);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.296705972839036F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.9773843811168246F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.07853981633974483F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.593411945678072F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
			} else {
				this.Neck.xRot = headPitch * ((float)Math.PI / 180F);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.RightArm.zRot = Mth.cos(0.05F * ageInTicks) * 0.05F;
				this.LeftArm.zRot = -Mth.cos(0.05F * ageInTicks) * 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				if (entity.isEating()) {
					this.Body.xRot = 0.2F;
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
				}
				if (entity.isInWater()) {
					this.RightThigh.y = -5;
					this.LeftThigh.y = -5.5F;
					this.Body.y = -5.5F;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.125F;
					this.Neck.xRot = 0.125F;
					this.LeftLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = -6.5F;
		this.LeftThigh.y = -7.0F;
		this.RightThigh.y = -7;
		this.LeftArm.z = -3.5F;
		this.RightArm.z = -3.5F;
		this.Tail1.x = 0;
		this.Tail1.z = 0;
		this.Tail2.x = 0.0F;
		this.Tail2.z = 9;
		this.LeftLeg.xRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
	}

	public void sleepPose() {
		this.RightLeg.xRot = -0.7F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = -0.296705972839036F;
		this.RightThigh.y = -2.7F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.Body.y = -2.5F;
		this.Body.xRot = -0.24434609527920614F;
		this.Tail2.xRot = 0.24962634015954636F;
		this.Tail2.yRot = -0.593411945678072F;
		this.Tail2.zRot = -0.10471975511965977F;
		this.LeftThigh.y = -2.7F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = 0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		this.LeftLeg.xRot = -0.7F;
		this.LeftArm.xRot = 0.8726646259971648F;
		this.Tail1.xRot = -0.07853981633974483F;
		this.Tail1.yRot = -0.593411945678072F;
		this.Tail1.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}