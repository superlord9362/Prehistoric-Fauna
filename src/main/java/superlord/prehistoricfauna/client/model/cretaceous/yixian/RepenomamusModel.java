package superlord.prehistoricfauna.client.model.cretaceous.yixian;

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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Repenomamus;

public class RepenomamusModel extends EntityModel<Repenomamus> {
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Tail;
	private final ModelPart Head;

	public RepenomamusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.RightLeg = this.Body.getChild("RightLeg");
		this.LeftLeg = this.Body.getChild("LeftLeg");
		this.Tail = this.Body.getChild("Tail");
		this.Head = this.Body.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -6.0F, -6.0F, 5.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 14).addBox(-0.99F, -1.0F, -0.99F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -2.0F, -5.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 14).addBox(-1.01F, -1.0F, -0.99F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -2.0F, -5.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -1.0F, -0.99F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, 3.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -0.99F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.0F, 3.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(13, 14).addBox(-1.0F, -0.99F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 22).addBox(-1.0F, 1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 4.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(9, 27).addBox(-1.5F, -1.01F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 14).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 22).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Repenomamus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 24, 26);
				this.Tail.y = Mth.lerp(sleepProgress, -4.85F, -4.8F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.46931902520863084F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.602910321115726F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.5164797856562695F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.8991936386169619F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.5164797856562695F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.8991936386169619F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.6030848913251807F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 26, 24);
				this.Tail.y = Mth.lerp(sleepProgress, -4.8F, -4.85F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.46931902520863084F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.602910321115726F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.5164797856562695F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.8991936386169619F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.5164797856562695F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.8991936386169619F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 1.6030848913251807F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
			} else {
				this.Head.xRot = headPitch * ((float)Math.PI / 180F);
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount) - 0.1F;
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				if (entity.isEating()) {
					this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.LeftArm.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RightArm.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tail.xRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.25F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = 24;
		this.Tail.y = -4.85F;
		this.Head.xRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.Tail.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
	}
	
	public void sleepPose() {
		this.Body.y = 26;
		this.Tail.y = -4.8F;
		this.Head.xRot = 0.46931902520863084F;
		this.RightLeg.xRot = 1.602910321115726F;
		this.RightLeg.yRot = 0.3909537457888271F;
		this.Tail.xRot = -0.23457224414434488F;
		this.RightArm.xRot = -1.5164797856562695F;
		this.RightArm.yRot = -0.8991936386169619F;
		this.LeftArm.xRot = -1.5164797856562695F;
		this.LeftArm.yRot = 0.8991936386169619F;
		this.LeftLeg.xRot = 1.6030848913251807F;
		this.LeftLeg.yRot = -0.3909537457888271F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
