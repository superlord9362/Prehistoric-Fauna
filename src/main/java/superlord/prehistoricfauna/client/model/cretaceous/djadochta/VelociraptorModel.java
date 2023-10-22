package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;

public class VelociraptorModel extends EntityModel<Velociraptor> {
	private final ModelPart ThighLeft;
	private final ModelPart LegLeft;
	private final ModelPart FootLeft;
	private final ModelPart ThighRight;
	private final ModelPart LegRight;
	private final ModelPart FootRight;
	private final ModelPart Body;
	private final ModelPart WingLeft;
	private final ModelPart WingRight;
	private final ModelPart Tail;
	private final ModelPart Neck;
	private final ModelPart Head;

	public VelociraptorModel(ModelPart root) {
		this.ThighLeft = root.getChild("ThighLeft");
		this.LegLeft = ThighLeft.getChild("LegLeft");
		this.FootLeft = LegLeft.getChild("FootLeft");
		this.ThighRight = root.getChild("ThighRight");
		this.LegRight = ThighRight.getChild("LegRight");
		this.FootRight = LegRight.getChild("FootRight");
		this.Body = root.getChild("Body");
		this.WingLeft = Body.getChild("WingLeft");
		this.WingRight = Body.getChild("WingRight");
		this.Tail = Body.getChild("Tail");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ThighLeft = partdefinition.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 15.75F, 2.0F));

		PartDefinition LegLeft = ThighLeft.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(55, 11).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.0F, 2.0F));

		PartDefinition FootLeft = LegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(46, 10).mirror().addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition ThighRight = partdefinition.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(46, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 15.75F, 2.0F));

		PartDefinition LegRight = ThighRight.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(55, 11).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 4.0F, 2.0F));

		PartDefinition FootRight = LegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(46, 10).addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.75F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -3.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.5F, 0.1F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(16, 0).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, -4.3F, -2.0F));

		PartDefinition Mouth = Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(31, 1).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(23, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 5.0F));

		PartDefinition TailFan = Tail.addOrReplaceChild("TailFan", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition WingLeft = Body.addOrReplaceChild("WingLeft", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 1.0F, -3.0F));

		PartDefinition WingRight = Body.addOrReplaceChild("WingRight", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Velociraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0f;
		float degree = 1.0f;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31 && entity.getSittingTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
				this.WingLeft.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + 0.87266463F;
				this.WingRight.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) - 0.86266464F;
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) - 0.41887903F;
				this.Head.xRot = 0.5934119F + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			} else if (!entity.isAsleep() && (entity.isSitting() || entity.isTameSitting())) {
				sittingPose();
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Head.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.WingLeft.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.WingRight.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			} else {
				resetModel();
				//Idle/Walking Animations
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.ThighLeft.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
				this.ThighRight.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
				this.Head.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.WingLeft.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
				this.WingRight.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
				if (entity.isInWater()) {
					this.Body.y = 17;
					this.ThighLeft.y = 17F;
					this.ThighRight.y = 17F;
					this.Body.xRot = -0.25F;
					this.Tail.xRot = 0.25F;
					this.Neck.xRot = 0.25F;
					this.WingLeft.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.WingRight.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.ThighLeft.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.ThighRight.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.LegLeft.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LegRight.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Neck
			if (this.Neck.xRot < 0) this.Neck.xRot += 0.05F;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05F;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.15F;
			//Body
			if (this.Body.y > 15.75F) this.Body.y -= 0.15F;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05F;
			//LegLeft
			if (this.LegLeft.xRot < 0) this.LegLeft.xRot += 0.05F;
			//LegRight
			if (this.LegRight.xRot < 0) this.LegRight.xRot += 0.05F;
			//ThighLeft
			if (this.ThighLeft.y > 15.75F) this.ThighLeft.y -= 0.15F;
			if (this.ThighLeft.xRot < 0) this.ThighLeft.xRot += 0.05F;
			if (this.ThighLeft.yRot > 0) this.ThighLeft.yRot -= 0.05F;
			//ThighRight
			if (this.ThighRight.y > 15.75F) this.ThighRight.y -= 0.15F;
			if (this.ThighRight.xRot < 0F) this.ThighRight.xRot += 0.05F;
			if (this.ThighRight.yRot < 0F) this.ThighRight.yRot += 0.05F;
			//WingLeft
			if (this.WingLeft.zRot > 0) this.WingLeft.zRot -= 0.05F;
			//WingRight
			if (this.WingRight.zRot < 0) this.WingRight.zRot += 0.05F;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05F;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05F;
			//Head
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05F;
			//FootRight
			if (this.FootRight.xRot > 0F) this.FootRight.xRot -= 0.05F;
			if (this.FootRight.zRot < 0F) this.FootRight.zRot += 0.05F;
			//FootLeft
			if (this.FootLeft.xRot > 0F) this.FootLeft.xRot -= 0.05F;
			if (this.FootLeft.zRot > 0F) this.FootLeft.zRot -= 0.05F;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Neck
			if (this.Neck.xRot > -0.41887903F) this.Neck.xRot -= 0.05F;
			if (this.Neck.yRot > -2.268928F) this.Neck.yRot -= 0.05F;
			if (this.Neck.zRot < 0.83774805F) this.Neck.zRot += 0.15F;
			//Body
			if (this.Body.y < 19.5F) this.Body.y += 0.15F;
			if (this.Body.xRot > -0.17463292F) this.Body.xRot -= 0.05F;
			//LegLeft
			if (this.LegLeft.xRot > -0.87266463F) this.LegLeft.xRot -= 0.05F;
			//LegRight
			if (this.LegRight.xRot > -0.87266463F) this.LegRight.xRot -= 0.05F;
			//ThighLeft
			if (this.ThighLeft.y < 19.5F) this.ThighLeft.y += 0.15F;
			if (this.ThighLeft.xRot > -0.6981316F) this.ThighLeft.xRot -= 0.05F;
			if (this.ThighLeft.yRot < 0.2443461F) this.ThighLeft.yRot += 0.05F;
			//ThighRight
			if (this.ThighRight.y < 19.5F) this.ThighRight.y += 0.15F;
			if (this.ThighRight.xRot > -0.6981317F) this.ThighRight.xRot -= 0.05F;
			if (this.ThighRight.yRot > -0.2443461F) this.ThighRight.yRot -= 0.05F;
			//WingLeft
			if (this.WingLeft.zRot < 0.87266463F) this.WingLeft.zRot += 0.05F;
			//WingRight
			if (this.WingRight.zRot > -0.87266463F) this.WingRight.zRot -= 0.05F;
			//Tail
			if (this.Tail.xRot > -0.13962634F) this.Tail.xRot -= 0.05F;
			if (this.Tail.yRot < 1.0471976F) this.Tail.yRot += 0.05F;
			//Head
			if (this.Head.xRot < 0.5934119F) this.Head.xRot += 0.05F;
			//FootRight
			if (this.FootRight.xRot < 1.5707963267948966F) this.FootRight.xRot += 0.05F;
			if (this.FootRight.zRot > -0.24434609527920614F) this.FootRight.zRot -= 0.05F;
			//FootLeft
			if (this.FootLeft.xRot < 1.5707963267948966F) this.FootLeft.xRot += 0.05F;
			if (this.FootLeft.zRot < 0.24434609527920614F) this.FootLeft.zRot += 0.05F;
		}
		if (entity.getSittingTicks() < 31 && !entity.isAsleep()) {
			//Body
			if (this.Body.y < 19.5) this.Body.y += 0.15;
			//ThighLeft
			if (this.ThighLeft.y < 19.5) this.ThighLeft.y += 0.15;
			if (this.ThighLeft.xRot > -0.6981317007977318F) this.ThighLeft.xRot -= 0.05;
			//ThighRight
			if (this.ThighRight.y < 19.5) this.ThighRight.y += 0.15;
			if (this.ThighRight.xRot > -0.6981317007977318F) this.ThighRight.xRot -= 0.05;
			//Tail
			if (this.Tail.xRot > -0.17453292519943295F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot > -0.12) this.Tail.yRot -= 0.05;
		}
	}

	public void resetModel() {
		this.Body.y = 15.75F;
		this.ThighLeft.y = 15.75F;
		this.ThighRight.y = 15.75F;
		this.Body.xRot = 0;
		this.LegLeft.xRot = 0;
		this.WingLeft.zRot = 0;
		this.WingRight.zRot = 0;
		this.WingLeft.xRot = 0;
		this.WingRight.xRot = 0;
		this.WingLeft.yRot = 0;
		this.WingRight.yRot = 0;
		this.ThighLeft.xRot = 0;
		this.ThighLeft.yRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.ThighRight.xRot = 0;
		this.ThighRight.yRot = 0;
		this.LegRight.xRot = 0;
		this.FootRight.xRot = 0;
		this.FootRight.zRot = 0;
		this.FootLeft.xRot = 0;
		this.FootLeft.zRot = 0;
	}
	
	public void sleepPose() {
		this.Body.xRot = -0.17463292F;
		this.LegLeft.xRot = -0.87266463F;
		this.ThighLeft.xRot = -0.6981316F;
		this.ThighLeft.yRot = 0.2443461F;
		this.Tail.xRot = -0.13962634F;
		this.Tail.yRot = 1.0471976F;
		this.Neck.yRot = -2.268928F;
		this.Neck.zRot = 0.83774805F;
		this.ThighRight.xRot = -0.6981317F;
		this.ThighRight.yRot = -0.2443461F;
		this.LegRight.xRot = -0.87266463F;
		this.FootRight.xRot = 1.5707963267948966F;
		this.FootRight.zRot = -0.24434609527920614F;
		this.FootLeft.xRot = 1.5707963267948966F;
		this.FootLeft.zRot = 0.24609143118910318F;
		this.Body.y = 19.5F;
		this.ThighLeft.y = 19.5F;
		this.ThighRight.y = 19.5F;
	}
	
	public void sittingPose() {
		this.Body.y = 19.5F;
		this.ThighLeft.y = 19.5F;
		this.ThighRight.y = 19.5F;
		//Animation
		this.ThighRight.xRot = -0.6981317007977318F;
		this.ThighLeft.xRot = -0.6981317007977318F;
		this.WingLeft.xRot = 0.4363323129985824F;
		this.WingLeft.zRot = -1.0471975511965976F;
		this.Tail.xRot = -0.17453292519943295F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		ThighLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ThighRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
