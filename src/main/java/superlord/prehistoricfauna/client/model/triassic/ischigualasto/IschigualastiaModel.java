package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;

public class IschigualastiaModel extends EntityModel<Ischigualastia> {
	private final ModelPart Body;
	private final ModelPart LegL;
	private final ModelPart LegR;
	private final ModelPart ArmL;
	private final ModelPart ArmR;
	private final ModelPart Tail;
	private final ModelPart Neck;

	public IschigualastiaModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Tail = Body.getChild("Tail");
		this.ArmL = Body.getChild("ArmL");
		this.ArmR = Body.getChild("ArmR");
		this.LegL = Body.getChild("LegL");
		this.LegR = Body.getChild("LegR");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -16.0F, -24.0F, 20.0F, 22.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 8.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 64).addBox(-6.0F, -6.0F, -13.0F, 12.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -23.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition Face = Neck.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(0, 99).addBox(-4.5F, -6.0F, -8.0F, 9.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -13.0F));

		PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(62, 63).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -2.0F, 3.0F));

		PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(62, 63).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -2.0F, 3.0F));

		PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(62, 99).addBox(-2.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -2.0F, -18.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(100, 0).addBox(-4.5F, -3.0F, 0.0F, 9.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 9.0F, -0.25F, 0.0F, 0.0F));

		PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(62, 99).addBox(-4.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -2.0F, -18.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(Ischigualastia entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Body.y = 14;
				this.Body.zRot = -1.5707963267948966F;
				this.LegL.x = 10.4F;
				this.LegL.zRot = 0.5235987755982988F;
				this.ArmR.xRot = 0.5235987755982988F;
				this.LegR.xRot = 0.41887902047863906F;
				this.Neck.xRot = 0.593411945678072F;
				this.Neck.yRot = -0.13962634015954636F;
				this.Neck.zRot = 0.8377580409572781F;
				this.Tail.xRot = -0.24434609527920614F;
				this.Tail.yRot = -0.10471975511965977F;
				this.Tail.zRot = 0.593411945678072F;
				this.ArmL.x = 11.0F;
				this.ArmL.xRot = 0.45378560551852565F;
				this.ArmL.yRot = 0.24434609527920614F;
				this.ArmL.zRot = 0.5235987755982988F;
			}
		}
		if (wakingProgress != 0) {
			//Body
//			this.Body.y = 9;
			if (this.Body.y > 9) this.Body.y -= 0.15;
			if (this.Body.zRot < 0) this.Body.zRot += 0.05;
			//LegL
//			this.LegL.x = 7.0F;
			if (this.LegL.x > 7) this.LegL.x -= 0.15;
			if (this.LegL.zRot > 0) this.LegL.zRot -= 0.05;
			//ArmR
			if (this.ArmR.xRot > 0) this.ArmR.xRot -= 0.05;
			//LegR
			if (this.LegR.xRot > 0) this.LegR.xRot -= 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.05;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot < 0) this.Tail.yRot += 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
			//ArmL
//			this.ArmL.x = 7.0F;
			if (this.ArmL.x > 7) this.ArmL.x -= 0.15;
			if (this.ArmL.xRot > 0) this.ArmL.xRot -= 0.05;
			if (this.ArmL.yRot > 0) this.ArmL.yRot -= 0.05;
			if (this.ArmL.zRot > 0) this.ArmL.zRot -= 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//Body
//				this.Body.y = 9;
				if (this.Body.y < 14) this.Body.y += 0.15;
				if (this.Body.zRot > -1.5707963267948966F) this.Body.zRot -= 0.05;
				//LegL
//				this.LegL.x = 7.0F;
				if (this.LegL.x < 10.4) this.LegL.x += 0.15;
				if (this.LegL.zRot < 0.5235987755982988F) this.LegL.zRot += 0.05;
				//ArmR
				if (this.ArmR.xRot < 0.5235987755982988F) this.ArmR.xRot += 0.05;
				//LegR
				if (this.LegR.xRot < 0.41887902047863906F) this.LegR.xRot += 0.05;
				//Neck
				if (this.Neck.xRot < 0.593411945678072F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -0.13962634015954636F) this.Neck.yRot -= 0.05;
				if (this.Neck.zRot < 0.8377580409572781F) this.Neck.zRot += 0.05;
				//Tail
				if (this.Tail.xRot > -0.24434609527920614F) this.Tail.xRot -= 0.05;
				if (this.Tail.yRot > -0.10471975511965977F) this.Tail.yRot -= 0.05;
				if (this.Tail.zRot < 0.593411945678072F) this.Tail.zRot += 0.05;
				//ArmL
//				this.ArmL.x = 7.0F;
				if (this.ArmL.x < 11) this.ArmL.x += 0.15;
				if (this.ArmL.xRot < 0.45378560551852565F) this.ArmL.xRot += 0.05;
				if (this.ArmL.yRot < 0.24434609527920614F) this.ArmL.yRot += 0.05;
				if (this.ArmL.zRot < 0.5235987755982988F) this.ArmL.zRot += 0.05;
			}
		} else {
			this.Neck.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.1F) + attackProgress * (float) Math.toRadians(25F);
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LegR.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.LegL.xRot = (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
			this.ArmL.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.ArmR.xRot = (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
			this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
			this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.25F;
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entity.isInWater()) {
				this.Body.y = 20;
				this.Body.xRot = -0.125F;
				this.Tail.xRot = 0.0625F;
				this.LegL.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LegR.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ArmR.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ArmL.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = 0.0625F;
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.25F;
			}
		}
	}

	public void resetModel() {
		this.Body.y = 9;
		this.Body.xRot = 0;
		this.Body.zRot = 0;
		this.LegL.x = 7.0F;
		this.LegL.xRot = 0;
		this.LegL.zRot = 0;
		this.ArmR.xRot = 0;
		this.LegR.xRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.ArmL.x = 7.0F;
		this.ArmL.xRot = 0;
		this.ArmL.yRot = 0;
		this.ArmL.zRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}