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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Polistodon;

public class PolistodonModel extends EntityModel<Polistodon> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Head;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;

	public PolistodonModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.Head = this.Body.getChild("Head");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftLeg = this.Root.getChild("LeftLeg");
		this.RightLeg = this.Root.getChild("RightLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(14, 9).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 15).addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, 0.025F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.475F, 0.0F, -5.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, 0.025F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.475F, 0.0F, -5.0F));

		PartDefinition LeftLeg = Root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.475F, -2.0F, 2.975F));

		PartDefinition RightLeg = Root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.475F, -2.0F, 2.975F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Polistodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.y = Mth.lerp(sleepProgress, -2, 0F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.6109F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.3927F, -0.4618F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, -0.5F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.Body.y = Mth.lerp(sleepProgress, -2, -1F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.4363F);
				this.RightLeg.y = Mth.lerp(sleepProgress, -2, 0F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.6109F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.4363F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.y = Mth.lerp(sleepProgress, 0, -2F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.6109F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.4618F, -0.3927F);
				this.Tail.yRot = Mth.lerp(sleepProgress, -0.5F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -1, -2F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.4363F, 0);
				this.RightLeg.y = Mth.lerp(sleepProgress, 0, -2F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.6109F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.4363F, 0);
			} else {
				this.Head.xRot = headPitch * ((float)Math.PI / 180F) + (-0.0125F * Mth.sin(0.1F * ageInTicks / 3)) + 0.0125F;
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.Tail.yRot = -0.25F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) - 0.3927F;
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
		this.LeftLeg.y = -2F;
		this.LeftLeg.xRot = 0F;
		this.LeftLeg.yRot = 0F;
		this.Tail.xRot = -0.2F;
		this.Tail.yRot = 0F;
		this.Head.xRot = 0.0125F;
		this.Head.yRot = 0;
		this.Body.y = -2F;
		this.LeftArm.y = 0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0F;
		this.RightLeg.y = -2F;
		this.RightLeg.xRot = 0F;
		this.RightLeg.yRot = 0F;
		this.RightArm.y = 0F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0F;
	}

	public void sleepPose() {
		this.LeftLeg.y = 0F;
		this.LeftLeg.xRot = -1.5708F;
		this.LeftLeg.yRot = -0.6109F;
		this.Tail.xRot = -0.4618F;
		this.Tail.yRot = -0.5F;
		this.Head.xRot = 0.2618F;
		this.Head.yRot = 0.2618F;
		this.Body.y = -1F;
		this.LeftArm.xRot = -1.5708F;
		this.LeftArm.yRot = -0.4363F;
		this.RightLeg.y = 0F;
		this.RightLeg.xRot = -1.5708F;
		this.RightLeg.yRot = 0.6109F;
		this.RightArm.xRot = -1.5708F;
		this.RightArm.yRot = 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
