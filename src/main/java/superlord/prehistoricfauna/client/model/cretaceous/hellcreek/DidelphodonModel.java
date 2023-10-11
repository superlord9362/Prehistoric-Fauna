package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;

public class DidelphodonModel extends EntityModel<Didelphodon> implements ArmedModel {
	private final ModelPart Frontlegleft;
	private final ModelPart Hindlegright;
	private final ModelPart Hindlegleft;
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart Frontlegright;

	public DidelphodonModel(ModelPart root) {
		this.Frontlegleft = root.getChild("Frontlegleft");
		this.Hindlegright = root.getChild("Hindlegright");
		this.Hindlegleft = root.getChild("Hindlegleft");
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.Frontlegright = root.getChild("Frontlegright");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Frontlegleft = partdefinition.addOrReplaceChild("Frontlegleft", CubeListBuilder.create().texOffs(16, 8).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, 21.0F, -2.9F));

		PartDefinition Hindlegright = partdefinition.addOrReplaceChild("Hindlegright", CubeListBuilder.create().texOffs(16, 8).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 21.0F, 2.9F));

		PartDefinition Hindlegleft = partdefinition.addOrReplaceChild("Hindlegleft", CubeListBuilder.create().texOffs(16, 8).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, 21.0F, 2.9F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 2.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(9, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(2, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Nose = Snout.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition EarRight = Head.addOrReplaceChild("EarRight", CubeListBuilder.create().texOffs(21, 2).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.0F, -1.0F));

		PartDefinition EarLeft = Head.addOrReplaceChild("EarLeft", CubeListBuilder.create().texOffs(21, 2).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.0F, -1.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.2F, 0.0F, 0.0F));

		PartDefinition Frontlegright = partdefinition.addOrReplaceChild("Frontlegright", CubeListBuilder.create().texOffs(16, 8).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 21.0F, -2.9F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Didelphodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Frontlegright.zRot = -0.8210028961170991F;
				this.Body.zRot = -1.5707963267948966F;
				this.Frontlegleft.xRot = 0.17453292519943295F;
				this.Frontlegleft.zRot = -1.5707963267948966F;
				this.Head.xRot = 0.9075712110370513F;
				this.Head.yRot = -0.5585053606381855F;
				this.Head.zRot = 0.6981317007977318F;
				this.Hindlegleft.xRot = -0.24434609527920614F;
				this.Hindlegleft.zRot = -1.5707963267948966F;
				this.Hindlegright.zRot = -0.7037167490777915F;
				this.Tail.xRot = -0.6283185307179586F;
				this.Tail.yRot = 0.22689280275926282F;
				this.Tail.zRot = 0.5235987755982988F;
				this.Frontlegleft.y = 23;
				this.Frontlegleft.x = 1;
				this.Hindlegright.x = 2;
				this.Hindlegright.y = 20;
				this.Hindlegleft.y = 23;
				this.Hindlegleft.x = 1;
				this.Frontlegright.x = 1.9F;
				this.Frontlegright.y = 20.5F;
				this.Frontlegright.z = -3;
				this.Body.x = -1;
				this.Body.y = 22;
				this.Head.x = 0.4F;
			}
		}
		if (wakingProgress != 0) {
			//Frontlegright
//			this.Frontlegright.x = 0.9F;
//			this.Frontlegright.y = 21;
//			this.Frontlegright.z = -2.9F;
			if (this.Frontlegright.x > 0.9F) this.Frontlegright.x -= 0.15;
			if (this.Frontlegright.y < 21F) this.Frontlegright.y += 0.15;
			if (this.Frontlegright.z < -2.9F) this.Frontlegright.z += 0.15;
			if (this.Frontlegright.zRot < 0) this.Frontlegright.zRot += 0.05;
			//Body
//			this.Body.x = 0;
//			this.Body.y = 19;
			if (this.Body.x < 0F) this.Body.x += 0.15;
			if (this.Body.y > 19F) this.Body.y -= 0.15;
			if (this.Body.zRot < 0) this.Body.zRot += 0.05;
			//Frontlegleft
//			this.Frontlegleft.x = -0.9F;
//			this.Frontlegleft.y = 21;
			if (this.Frontlegleft.x > -0.9F) this.Frontlegleft.x -= 0.15;
			if (this.Frontlegleft.y > 21F) this.Frontlegleft.y -= 0.15;
			if (this.Frontlegleft.xRot > 0) this.Frontlegleft.xRot -= 0.05;
			if (this.Frontlegleft.zRot < 0) this.Frontlegleft.zRot += 0.05;
			//Head
//			this.Head.x = 0;
			if (this.Head.x > 0) this.Head.x -= 0.15;
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			if (this.Head.yRot < -0) this.Head.yRot += 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
			//Hindlegleft
//			this.Hindlegleft.x = -0.9F;
//			this.Hindlegleft.y = 21;
			if (this.Hindlegleft.x > -0.9F) this.Hindlegleft.x -= 0.15;
			if (this.Hindlegleft.y > 21F) this.Hindlegleft.y -= 0.15;
			if (this.Hindlegleft.xRot < 0) this.Hindlegleft.xRot += 0.05;
			if (this.Hindlegleft.zRot < 0) this.Hindlegleft.zRot += 0.05;
			//Hindlegright
//			this.Hindlegright.x = 0.9F;
//			this.Hindlegright.y = 21;
			if (this.Hindlegright.x > 0.9F) this.Hindlegright.x -= 0.15;
			if (this.Hindlegright.y < 21F) this.Hindlegright.y += 0.15;
			if (this.Hindlegright.zRot < 0) this.Hindlegright.zRot += 0.05;
			//Tail
			//this.Tail.xRot = -0.13665927909957545F;
			if (this.Tail.xRot < -0.13665927909957545F) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//Frontlegright
//				this.Frontlegright.x = 0.9F;
//				this.Frontlegright.y = 21;
//				this.Frontlegright.z = -2.9F;
				if (this.Frontlegright.x < 1.9F) this.Frontlegright.x += 0.15;
				if (this.Frontlegright.y > 20F) this.Frontlegright.y -= 0.15;
				if (this.Frontlegright.z > -3F) this.Frontlegright.z -= 0.15;
				if (this.Frontlegright.zRot > -0.8210028961170991F) this.Frontlegright.zRot -= 0.05;
				//Body
//				this.Body.x = 0;
//				this.Body.y = 19;
				if (this.Body.x > -1F) this.Body.x -= 0.15;
				if (this.Body.y < 22F) this.Body.y += 0.15;
				if (this.Body.zRot > -1.5707963267948966F) this.Body.zRot -= 0.05;
				//Frontlegleft
//				this.Frontlegleft.x = -0.9F;
//				this.Frontlegleft.y = 21;
				if (this.Frontlegleft.x < 1F) this.Frontlegleft.x += 0.15;
				if (this.Frontlegleft.y < 23F) this.Frontlegleft.y += 0.15;
				if (this.Frontlegleft.xRot < 0.17453292519943295F) this.Frontlegleft.xRot += 0.05;
				if (this.Frontlegleft.zRot > -1.5707963267948966F) this.Frontlegleft.zRot -= 0.05;
				//Head
//				this.Head.x = 0;
				if (this.Head.x < 0.4F) this.Head.x += 0.15;
				if (this.Head.xRot < 0.9075712110370513F) this.Head.xRot += 0.05;
				if (this.Head.yRot > -0.5585053606381855F) this.Head.yRot -= 0.05;
				if (this.Head.zRot < 0.6981317007977318F) this.Head.zRot += 0.05;
				//Hindlegleft
//				this.Hindlegleft.x = -0.9F;
//				this.Hindlegleft.y = 21;
				if (this.Hindlegleft.x < 1F) this.Hindlegleft.x += 0.15;
				if (this.Hindlegleft.y < 23F) this.Hindlegleft.y += 0.15;
				if (this.Hindlegleft.xRot > -0.24434609527920614F) this.Hindlegleft.xRot -= 0.05;
				if (this.Hindlegleft.zRot > -1.5707963267948966F) this.Hindlegleft.zRot -= 0.05;
				//Hindlegright
//				this.Hindlegright.x = 0.9F;
//				this.Hindlegright.y = 21;
				if (this.Hindlegright.x < 2F) this.Hindlegright.x += 0.15;
				if (this.Hindlegright.y > 20F) this.Hindlegright.y -= 0.15;
				if (this.Hindlegright.zRot > -0.7037167490777915F) this.Hindlegright.zRot -= 0.05;
				//Tail
				//this.Tail.xRot = -0.13665927909957545F;
				if (this.Tail.xRot > -0.6283185307179586F) this.Tail.xRot -= 0.05;
				if (this.Tail.yRot < 0.22689280275926282F) this.Tail.yRot += 0.05;
				if (this.Tail.zRot < 0.5235987755982988F) this.Tail.zRot += 0.05;
			}
		}
		else {
			this.Head.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.Hindlegright.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Hindlegleft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Frontlegright.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Frontlegleft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.25F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) - 0.2F;
			if (entity.isInWater()) {
				this.Frontlegleft.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.Hindlegright.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.Frontlegright.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.Hindlegleft.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.Frontlegright.xRot = 0;
		this.Frontlegright.zRot = 0;
		this.Body.zRot = 0;
		this.Frontlegleft.xRot = 0;
		this.Frontlegleft.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Hindlegleft.xRot = 0;
		this.Hindlegleft.zRot = 0;
		this.Hindlegright.xRot = 0;
		this.Hindlegright.zRot = 0;
		this.Tail.xRot = -0.13665927909957545F;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Frontlegleft.y = 21;
		this.Hindlegright.x = 0.9F;
		this.Hindlegright.y = 21;
		this.Hindlegleft.y = 21;
		this.Body.x = 0;
		this.Body.y = 19;
		this.Head.x = 0;
		this.Frontlegright.x = 0.9F;
		this.Frontlegleft.x = -0.9F;
		this.Hindlegleft.x = -0.9F;
		this.Frontlegright.y = 21;
		this.Frontlegright.z = -2.9F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Frontlegleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Hindlegright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Hindlegleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Frontlegright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	   public void translateToHand(HumanoidArm sideIn, PoseStack matrixStackIn) {
		float f = sideIn == HumanoidArm.RIGHT ? 1.0F : -1.0F;
		ModelPart modelrenderer = this.getArm(sideIn);
		modelrenderer.x += f;
		modelrenderer.translateAndRotate(matrixStackIn);
		modelrenderer.x -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelPart getArm(HumanoidArm side) {
		return side == HumanoidArm.LEFT ? this.Head : this.Head;
	}
}