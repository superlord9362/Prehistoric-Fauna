package superlord.prehistoricfauna.client.model.jurassic.kayenta;

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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentasuchus;

@SuppressWarnings("unused")
public class KayentasuchusModel extends EntityModel<Kayentasuchus> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart LeftArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightArm;
	private final ModelPart RightLeg;

	public KayentasuchusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.Head = this.Body.getChild("Head");
		this.Snout = this.Head.getChild("Snout");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightArm = root.getChild("RightArm");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -7.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, 3.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(13, 1).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 19).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(13, 16).addBox(0.0F, -1.0F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.0F, -3.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(20, 16).addBox(0.0F, -1.0F, -0.75F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, 3.5F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(13, 16).mirror().addBox(-1.0F, -1.0F, -0.75F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 20.0F, -3.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(20, 16).mirror().addBox(-1.0F, -1.0F, -0.75F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 19.0F, 3.5F));

		return LayerDefinition.create(meshdefinition, 42, 32);
	}

	@Override
	public void setupAnim(Kayentasuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 18F, 22F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 19, 23);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 19, 23);
				this.LeftArm.y = Mth.lerp(sleepProgress, 20, 23);
				this.RightArm.y = Mth.lerp(sleepProgress, 20, 23);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.1745F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.1745F, 0.1309F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.0873F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, -0.3054F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.48F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.48F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.4363F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.5708F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.4363F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 22, 18);
				this.RightLeg.y = Mth.lerp(sleepProgress, 23, 19);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 23, 19);
				this.LeftArm.y = Mth.lerp(sleepProgress, 23, 20);
				this.RightArm.y = Mth.lerp(sleepProgress, 23, 20);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.1745F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.1309F, -0.1745F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.0873F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, -0.3054F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.48F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.48F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.4363F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.5708F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.4363F, 0);

			} else {
				this.Head.xRot = headPitch * ((float)Math.PI / 180F) - 0.0873F;
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) - 0.0873F;
				if (entity.isInWater()) {
					this.RightArm.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 18F;
		this.RightLeg.y = 19;
		this.LeftLeg.y = 19;
		this.LeftArm.y = 20;
		this.RightArm.y = 20;
		this.Body.xRot = 0.0873F;
		this.Head.xRot = -0.0873F;
		this.Head.yRot = 0;
		this.Tail.xRot = -0.0873F;
		this.Tail.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 22F;
		this.RightLeg.y = 23;
		this.LeftLeg.y = 23;
		this.LeftArm.y = 23;
		this.RightArm.y = 23;
		this.Body.xRot = 0;
		this.Head.xRot = 0.1309F;
		this.Head.yRot = 0.2618F;
		this.Tail.xRot = -0.0873F;
		this.Tail.yRot = -0.3054F;
		this.RightLeg.xRot = -1.5708F;
		this.RightLeg.yRot = 0.48F;
		this.LeftLeg.xRot = -1.5708F;
		this.LeftLeg.yRot = -0.48F;
		this.LeftArm.xRot = -1.5708F;
		this.LeftArm.yRot = -0.4363F;
		this.RightArm.xRot = -1.5708F;
		this.RightArm.yRot = 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}