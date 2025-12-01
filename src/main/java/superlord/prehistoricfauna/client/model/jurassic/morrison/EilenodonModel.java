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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;

public class EilenodonModel extends EntityModel<Eilenodon> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart ArmL;
	private final ModelPart ArmR;
	private final ModelPart LegL;
	private final ModelPart LegR;

	public EilenodonModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.ArmL = this.Body.getChild("ArmL");
		this.ArmR = this.Body.getChild("ArmR");
		this.LegL = this.Body.getChild("LegL");
		this.LegR = this.Body.getChild("LegR");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(20, 20).addBox(0.0F, -3.0F, -2.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(10, 24).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 27).addBox(0.0F, -3.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 27).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 30).addBox(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(20, 12).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(0.0F, -2.0F, 1.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(1, 37).addBox(0.0F, -2.5F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 6.0F));

		PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(10, 29).addBox(0.0F, -0.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-1.0F, 2.5F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 0.5F, -3.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -0.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 3).addBox(-2.0F, 2.5F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 0.5F, -3.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(16, 31).addBox(0.0F, -0.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(0.0F, 2.5F, -2.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 0.5F, 3.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(16, 31).mirror().addBox(-1.0F, -0.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 0).mirror().addBox(-4.0F, 2.5F, -2.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.75F, 0.5F, 3.0F, 0.0F, 0.2618F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void setupAnim(Eilenodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 22, 23);
				this.LegR.y = Mth.lerp(sleepProgress, -1, 1);
				this.LegR.zRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.ArmR.y = Mth.lerp(sleepProgress, -1, 1);
				this.ArmR.zRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.LegL.y = Mth.lerp(sleepProgress, -1, 1);
				this.LegL.zRot = Mth.lerp(sleepProgress, 0, -1.5707963267948966F);
				this.ArmL.y = Mth.lerp(sleepProgress, -1, 1);
				this.ArmL.zRot = Mth.lerp(sleepProgress, 0, -1.5707963267948966F);
				this.Neck.z = Mth.lerp(sleepProgress, -5, -4.8F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -1.2901473511162753F);
				this.ArmR.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.LegR.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.ArmL.yRot = Mth.lerp(sleepProgress, -0.2618F, 0);
				this.LegL.yRot = Mth.lerp(sleepProgress, -0.2618F, 0);
			} else sleepPose();
		} else if (entity.isSitting() && !entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				Body.y = Mth.lerp(sleepProgress, 22, 23);
				LegR.y = Mth.lerp(sleepProgress, -1, 1);
				LegR.zRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				ArmR.y = Mth.lerp(sleepProgress, -1, 1);
				ArmR.zRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				LegL.y = Mth.lerp(sleepProgress, -1, 1);
				LegL.zRot = Mth.lerp(sleepProgress, 0, -1.5707963267948966F);
				ArmL.y = Mth.lerp(sleepProgress, -1, 1);
				ArmL.zRot = Mth.lerp(sleepProgress, 0, -1.5707963267948966F);
				this.ArmR.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.LegR.yRot = Mth.lerp(sleepProgress, 0.2618F, 0);
				this.ArmL.yRot = Mth.lerp(sleepProgress, -0.2618F, 0);
				this.LegL.yRot = Mth.lerp(sleepProgress, -0.2618F, 0);
			} else sittingPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 23, 22);
				this.LegR.y = Mth.lerp(sleepProgress, 1, -1);
				this.LegR.zRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.ArmR.y = Mth.lerp(sleepProgress, 1, -1);
				this.ArmR.zRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.LegL.y = Mth.lerp(sleepProgress, 1, -1);
				this.LegL.zRot = Mth.lerp(sleepProgress, -1.5707963267948966F, 0);
				this.ArmL.y = Mth.lerp(sleepProgress, 1, -1);
				this.ArmL.zRot = Mth.lerp(sleepProgress, -1.5707963267948966F, 0);
				this.Neck.z = Mth.lerp(sleepProgress, -4.8F, -5F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -1.2901473511162753F, 0);
				this.ArmR.yRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.LegR.yRot = Mth.lerp(sleepProgress, 0, 0.2618F);
				this.ArmL.yRot = Mth.lerp(sleepProgress, 0, -0.2618F);
				this.LegL.yRot = Mth.lerp(sleepProgress, 0, -0.2618F);
			} else {
				this.Neck.xRot = headPitch * ((float)Math.PI / 180F);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LegL.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.LegR.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.ArmL.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.ArmR.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.5F;
				}
				if (entity.isInWater()) {
					this.ArmR.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.ArmL.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LegL.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LegR.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 22;
		this.LegR.y = -1.0F;
		this.LegR.zRot = 0;
		this.LegR.xRot = 0;
		this.LegR.yRot = 0.2618F;
		this.ArmR.y = -1.0F;
		this.ArmR.zRot = 0;
		this.ArmR.xRot = 0;
		this.ArmR.yRot = 0.2618F;
		this.LegL.y = -1.0F;
		this.LegL.zRot = 0;
		this.LegL.xRot = 0;
		this.LegL.yRot = -0.2618F;
		this.ArmL.y = -1.0F;
		this.ArmL.zRot = 0;
		this.ArmL.xRot = 0;
		this.ArmL.yRot = -0.2618F;
		this.Neck.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Neck.z = -5.0F;
	}

	public void sleepPose() {
		this.Body.y = 23;
		this.LegR.y = 1;
		this.LegR.zRot = 1.5707963267948966F;
		this.ArmR.y = 1;
		this.ArmR.zRot = 1.5707963267948966F;
		this.LegL.y = 1;
		this.LegL.zRot = -1.5707963267948966F;
		this.ArmL.y = 1;
		this.ArmL.zRot = -1.5707963267948966F;
		this.Neck.z = -4.8F;
		this.Neck.xRot = 0.19547687289441354F;
		this.Neck.yRot = 0.27366763203903305F;
		this.Neck.zRot = -1.2901473511162753F;
		this.ArmL.yRot = 0;
		this.ArmR.yRot = 0;
		this.LegL.yRot = 0;
		this.LegR.yRot = 0;
	}

	public void sittingPose () {
		Body.y = 23;
		LegR.y = 1;
		LegR.zRot = 1.5707963267948966F;
		ArmR.y = 1;
		ArmR.zRot = 1.5707963267948966F;
		LegL.y = 1;
		LegL.zRot = -1.5707963267948966F;
		ArmL.y = 1;
		ArmL.zRot = -1.5707963267948966F;
		this.ArmL.yRot = 0;
		this.ArmR.yRot = 0;
		this.LegL.yRot = 0;
		this.LegR.yRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}