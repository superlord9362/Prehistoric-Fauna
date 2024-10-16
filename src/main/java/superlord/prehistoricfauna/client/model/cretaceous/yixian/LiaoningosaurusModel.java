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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Liaoningosaurus;

public class LiaoningosaurusModel extends EntityModel<Liaoningosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public LiaoningosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -14.0F, -11.0F, 14.0F, 9.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(19, 30).addBox(-2.5F, -2.5F, -6.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.6F, -11.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 46).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(34, 46).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, -4.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.5F, -1.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -10.5F, 3.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(106, 74).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 7.5F, 5.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(98, 105).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.5F, -1.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -10.5F, 3.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(106, 74).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 7.5F, 5.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(98, 105).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-1.0F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -8.5F, -7.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 30).addBox(-2.0F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -8.5F, -7.5F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(32, 30).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 86).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.5F, 10.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(72, 25).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Liaoningosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//24.0F
				this.Body.y = Mth.lerp(sleepProgress, 24, 29.2F);
				//-11.0F, 0, 0, 0
				this.Neck.z = Mth.lerp(sleepProgress, -11, -9.6F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.6127F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.0715F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -0.0501F);
				//-0.4F, -4.0F, 0, 0, 0
				this.Head.y = Mth.lerp(sleepProgress, -0.4F, 0.4F);
				this.Head.z = Mth.lerp(sleepProgress, -4, -4.8F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.5277F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.0536F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.0815F);
				//3.0F, 0, 0, 0
				this.RightThigh.z = Mth.lerp(sleepProgress, 3, 7);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -1.5601F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.3892F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -0.054F);
				//0
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.0349F);
				//0
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.7017F);
				//3.0F, 0, 0, 0
				this.LeftThigh.z = Mth.lerp(sleepProgress, 3, 7);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -1.513F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.4351F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, 0.074F);
				//0
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.0873F);
				//0
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.7017F);
				//-7.0F, -8.5F, 0, 0, 0
				this.LeftArm.x = Mth.lerp(sleepProgress, -7, -8);
				this.LeftArm.y = Mth.lerp(sleepProgress, -8.5F, -7.5F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3419F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.232F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.1145F);
				//-8.5F, 0, 0, 0
				this.RightArm.y = Mth.lerp(sleepProgress, -8.5F, -7.5F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.2561F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.2252F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 0.0373F);
				//10.0F, 0, 0, 0
				this.Tail1.z = Mth.lerp(sleepProgress, 10, 9.1F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.3079F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.1248F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.0396F);
				//0, 0, 0
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.2256F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.2555F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.0579F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//24.0F
				this.Body.y = Mth.lerp(sleepProgress, 29.2F, 24F);
				//-11.0F, 0, 0, 0
				this.Neck.z = Mth.lerp(sleepProgress, -9.6F, -11);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.6127F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.0715F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -0.0501F, 0);
				//-0.4F, -4.0F, 0, 0, 0
				this.Head.y = Mth.lerp(sleepProgress, 0.4F, -0.4F);
				this.Head.z = Mth.lerp(sleepProgress, -4.8F, -4);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.5277F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.0536F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.0815F, 0);
				//3.0F, 0, 0, 0
				this.RightThigh.z = Mth.lerp(sleepProgress, 7, 3);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -1.5601F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.3892F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -0.054F, 0);
				//0
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.0349F, 0);
				//0
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.7017F, 0);
				//3.0F, 0, 0, 0
				this.LeftThigh.z = Mth.lerp(sleepProgress, 7, 3);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -1.513F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.4351F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0.074F, 0);
				//0
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.0873F, 0);
				//0
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.7017F, 0);
				//-7.0F, -8.5F, 0, 0, 0
				this.LeftArm.x = Mth.lerp(sleepProgress, -8, -7);
				this.LeftArm.y = Mth.lerp(sleepProgress, -7.5F, -8.5F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3419F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.232F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.1145F, 0);
				//-8.5F, 0, 0, 0
				this.RightArm.y = Mth.lerp(sleepProgress, -7.5F, -8.5F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.2561F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.2252F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.0373F, 0);
				//10.0F, 0, 0, 0
				this.Tail1.z = Mth.lerp(sleepProgress, -0.3079F, 10);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.3079F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.1248F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.0396F, 0);
				//0, 0, 0
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.2256F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.2555F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.0579F, 0);
			} else {
				this.LeftArm.xRot = -Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-25);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
				this.Body.yRot = attackProgress * leftOrRight * (float)Math.toRadians(-200);
				this.Tail1.zRot = attackProgress * leftOrRight * (float)Math.toRadians(15);
				if (entity.isEating() || entity.isAshDigging()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.1F;
					this.LeftThigh.xRot = -0.1F;
					this.RightThigh.xRot = -0.1F;
					this.RightArm.xRot = -0.1F;
					this.LeftArm.xRot = -0.1F;
					this.RightArm.zRot = 0.3F;
					this.LeftArm.zRot = -0.3F;
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = 24;
		this.Body.xRot = 0F;
		this.Neck.z = -11F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.y = -0.4F;
		this.Head.z = -4F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.RightThigh.z = 3;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.xRot = 0;
		this.LeftThigh.z = 3;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.xRot = 0F;
		this.LeftArm.x = -7;
		this.LeftArm.y = -8.5F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.Tail1.z = 10F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
	}
	
	public void sleepPose() {
		//24.0F
		this.Body.y = 29.2F;
		//-11.0F, 0, 0, 0
		this.Neck.z = -9.6F;
		this.Neck.xRot = 0.6127F;
		this.Neck.yRot = -0.0715F;
		this.Neck.zRot = -0.0501F;
		//-0.4F, -4.0F, 0, 0, 0
		this.Head.y = 0.4F;
		this.Head.z = -4.8F;
		this.Head.xRot = -0.5277F;
		this.Head.yRot = -0.0536F;
		this.Head.zRot = 0.0815F;
		//3.0F, 0, 0, 0
		this.RightThigh.z = 7;
		this.RightThigh.xRot = -1.5601F;
		this.RightThigh.yRot = -0.3892F;
		this.RightThigh.zRot = -0.054F;
		//0
		this.RightLeg.xRot = -0.0349F;
		//0
		this.RightFoot.xRot = 1.7017F;
		//3.0F, 0, 0, 0
		this.LeftThigh.z = 7;
		this.LeftThigh.xRot = -1.513F;
		this.LeftThigh.yRot = 0.4351F;
		this.LeftThigh.zRot = 0.074F;
		//0
		this.LeftLeg.xRot = -0.0873F;
		//0
		this.LeftFoot.xRot = 1.7017F;
		//-7.0F, -8.5F, 0, 0, 0
		this.LeftArm.x = -8;
		this.LeftArm.y = -7.5F;
		this.LeftArm.xRot = -1.3419F;
		this.LeftArm.yRot = -0.232F;
		this.LeftArm.zRot = -0.1145F;
		//-8.5F, 0, 0, 0
		this.RightArm.y = -7.5F;
		this.RightArm.xRot = -1.2561F;
		this.RightArm.yRot = 0.2252F;
		this.RightArm.zRot = 0.0373F;
		//10.0F, 0, 0, 0
		this.Tail1.z = 9.1F;
		this.Tail1.xRot = -0.3079F;
		this.Tail1.yRot = 0.1248F;
		this.Tail1.zRot = -0.0396F;
		//0, 0, 0
		this.Tail2.xRot = 0.2256F;
		this.Tail2.yRot = 0.2555F;
		this.Tail2.zRot = 0.0579F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}