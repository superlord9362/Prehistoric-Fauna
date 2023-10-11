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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;

public class KayentatheriumModel extends EntityModel<Kayentatherium> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	
	public KayentatheriumModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.RightLeg = Body.getChild("RightLeg");
		this.LeftLeg = Body.getChild("LeftLeg");
		this.RightArm = Body.getChild("RightArm");
		this.LeftArm = Body.getChild("LeftArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 8).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -7.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(10, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-0.99F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 3.0F, 2.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(25, 5).addBox(-1.01F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 3.0F, 10.5F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(25, 5).mirror().addBox(-0.99F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 3.0F, 10.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(1, 24).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 11.75F, -0.25F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(27, 0).addBox(-1.01F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 3.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 35, 50);
	}

	@Override
	public void setupAnim(Kayentatherium entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Body.y = 20;
				this.Body.z = -6.0F;
				this.Head.xRot = 0.46931902520863084F;
				this.LeftLeg.xRot = 1.602910321115726F;
				this.LeftLeg.yRot = 0.3909537457888271F;
				this.Tail.xRot = -0.23457224414434488F;
				this.LeftArm.xRot = -1.0164797856562695F;
				this.LeftArm.yRot = -0.8991936386169619F;
				this.RightArm.xRot = -1.0164797856562695F;
				this.RightArm.yRot = 0.8991936386169619F;
				this.RightLeg.xRot = 1.6030848913251807F;
				this.RightLeg.yRot = -0.3909537457888271F;
			}
		}
		if (wakingProgress != 0) {
			//Body
//			this.Body.y = 18.0F;
//			this.Body.z = -7.0F;
			if (this.Body.y > 18) this.Body.y -= 0.15;
			if (this.Body.z > -7) this.Body.z -= 0.15;
			//Head
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			//LeftLeg
			if (this.LeftLeg.xRot > 0) this.LeftLeg.xRot -= 0.05;
			if (this.LeftLeg.yRot > 0) this.LeftLeg.yRot -= 0.05;
			//Tail
//			this.Tail.xRot = -0.25F;
			if (this.Head.xRot > -0.25) this.Head.xRot -= 0.05;
			//LeftArm
			if (this.LeftArm.xRot < 0) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot < 0) this.LeftArm.yRot += 0.05;
			//RightArm
			if (this.RightArm.xRot < 0) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot > 0) this.RightArm.yRot -= 0.05;
			//RightLeg
			if (this.RightLeg.xRot > 0) this.RightLeg.xRot -= 0.05;
			if (this.RightLeg.yRot < 0) this.RightLeg.yRot += 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//Body
//				this.Body.y = 18.0F;
//				this.Body.z = -7.0F;
				if (this.Body.y < 20) this.Body.y += 0.15;
				if (this.Body.z < -6) this.Body.z += 0.15;
				//Head
				if (this.Head.xRot < 0.46931902520863084F) this.Head.xRot += 0.05;
				//LeftLeg
				if (this.LeftLeg.xRot < 1.602910321115726F) this.LeftLeg.xRot += 0.05;
				if (this.LeftLeg.yRot < 0.3909537457888271F) this.LeftLeg.yRot += 0.05;
				//Tail
//				this.Tail.xRot = -0.25F;
				if (this.Head.xRot < -0.23457224414434488F) this.Head.xRot += 0.05;
				//LeftArm
				if (this.LeftArm.xRot > -1.0164797856562695F) this.LeftArm.xRot -= 0.05;
				if (this.LeftArm.yRot > -0.8991936386169619F) this.LeftArm.yRot -= 0.05;
				//RightArm
				if (this.RightArm.xRot > -1.0164797856562695F) this.RightArm.xRot -= 0.05;
				if (this.RightArm.yRot < 0.8991936386169619F) this.RightArm.yRot += 0.05;
				//RightLeg
				if (this.RightLeg.xRot < 1.602910321115726F) this.RightLeg.xRot += 0.05;
				if (this.RightLeg.yRot > -0.3909537457888271F) this.RightLeg.yRot -= 0.05;
			}
		} else {
			this.Head.xRot = headPitch * ((float)Math.PI / 180F);
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
	
	public void resetModel() {
		this.Body.y = 18.0F;
		this.Body.z = -7.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.Tail.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.Tail.xRot = -0.25F;
		this.Tail.z = 11.75F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
