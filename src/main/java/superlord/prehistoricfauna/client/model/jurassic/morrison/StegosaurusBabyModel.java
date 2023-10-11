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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;

public class StegosaurusBabyModel extends EntityModel<Stegosaurus> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart RLeg;
	private final ModelPart LLeg;
	

	public StegosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.RForeleg = root.getChild("RForeleg");
		this.LForeleg = root.getChild("LForeleg");
		this.RLeg = root.getChild("RLeg");
		this.LLeg = root.getChild("LLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -5.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(16, 17).addBox(-1.0F, -1.5F, -6.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.6F, -4.0F));

		PartDefinition part7 = Neck.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -4.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(1, 17).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 10.0F));

		PartDefinition Spines_1 = TailBase.addOrReplaceChild("Spines_1", CubeListBuilder.create().texOffs(12, 31).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition part6 = TailBase.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(10, 41).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 7.0F));

		PartDefinition Spines = Torso.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RForeleg = partdefinition.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 20.0F, -3.0F));

		PartDefinition LForeleg = partdefinition.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 20.0F, -3.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-1.5F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 18.0F, 2.5F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0F, 2.5F));

		return LayerDefinition.create(meshdefinition, 36, 52);
	}

	@Override
	public void setupAnim(Stegosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Neck.x = 0;
				this.Neck.y = 3;
				this.Neck.z = -0.5F;
				this.Neck.xRot = 0.8025023820775095F;
				this.Neck.yRot = -0.03665191262740524F;
				this.LLeg.x = -1;
				this.LLeg.y = 18.5F;
				this.LLeg.z = 2;
				this.LLeg.xRot = -0.14608405639455457F;
				this.LLeg.yRot = -0.14625859331449564F;
				this.LLeg.zRot = 0.6932448001974364F;
				this.RForeleg.y = 24.2F;
				this.RForeleg.xRot = -0.21868975061435758F;
				this.RForeleg.yRot = -0.036477379868653376F;
				this.RForeleg.zRot = 1.460491523395177F;
				this.TailBase.y = 3F;
				this.TailBase.z = 10;
				this.TailBase.xRot = -0.4782202083885436F;
				this.TailBase.yRot = 0.18238690350445608F;
				this.TailBase.zRot = -0.2553416715641412F;
				this.Torso.x = 5;
				this.Torso.y = 20F;
				this.Torso.xRot = -0.03665191262740524F;
				this.Torso.yRot = -0.07312929665724782F;
				this.Torso.zRot = 1.2407545013269026F;
				this.RLeg.y = 23.7F;
				this.RLeg.xRot = 0.4742059590984399F;
				this.RLeg.zRot = 1.4606660936046318F;
				this.Head.xRot = -0.036477379868653376F;
				this.LForeleg.y = 19.0F;
				this.LForeleg.xRot = 0.3282964229790696F;
				this.LForeleg.yRot = -1.7453292129831807E-4F;
				this.LForeleg.zRot = 0.36477380700891215F;
			}
		}
		if (wakingProgress != 0) {
			//Neck
//			this.Neck.x = 0;
//			this.Neck.y = 10;
//			this.Neck.z = 0;
			if (this.Neck.x > 0) this.Neck.x -= 0.15;
			if (this.Neck.y > 2.5) this.Neck.y -= 0.15;
			if (this.Neck.z > 0) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0.0698F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//LLeg
//			this.LLeg.x = -8;
//			this.LLeg.y = -8;
//			this.LLeg.z = 15;
			if (this.LLeg.x > -2.5) this.LLeg.x -= 0.15;
			if (this.LLeg.y > 18) this.LLeg.y -= 0.15;
			if (this.LLeg.z < 2.5) this.LLeg.z += 0.15;
			if (this.LLeg.xRot < 0) this.LLeg.xRot += 0.05;
			if (this.LLeg.yRot < 0) this.LLeg.yRot += 0.05;
			if (this.LLeg.zRot > 0) this.LLeg.zRot -= 0.05;
			//RForeleg
//			this.RForeleg.y = 1.0F;
			if (this.RForeleg.y > 20) this.RForeleg.y -= 0.15;
			if (this.RForeleg.xRot < 0) this.RForeleg.xRot += 0.05;
			if (this.RForeleg.yRot < 0) this.RForeleg.yRot += 0.05;
			if (this.RForeleg.zRot > 0) this.RForeleg.zRot -= 0.05;
			//TailBase
//			this.TailBase.y = 7.0F;
//			this.TailBase.z = 44;
			if (this.TailBase.y > 2) this.TailBase.y -= 0.15;
			if (this.TailBase.z < 10) this.TailBase.z += 0.15;
			if (this.TailBase.xRot < 0) this.TailBase.xRot += 0.05;
			if (this.TailBase.yRot > 0) this.TailBase.yRot -= 0.05;
			if (this.TailBase.zRot < 0) this.TailBase.zRot += 0.05;
			//Torso
//			this.Torso.x = 0;
//			this.Torso.y = -18;
			if (this.Torso.x > 0) this.Torso.x -= 0.15;
			if (this.Torso.y > 14) this.Torso.y -= 0.15;
			if (this.Torso.xRot < 0) this.Torso.xRot += 0.05;
			if (this.Torso.yRot < 0) this.Torso.yRot += 0.05;
			if (this.Torso.zRot > 0) this.Torso.zRot -= 0.05;
			//RLeg
//			this.RLeg.y = -8.0F;
			if (this.RLeg.y > 18) this.RLeg.y -= 0.15;
			if (this.RLeg.xRot > 0) this.RLeg.xRot -= 0.05;
			if (this.RLeg.zRot > 0) this.RLeg.zRot -= 0.05;
			//Head
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			//LForeleg
//			this.LForeleg.y = 1.0F;
			if (this.LForeleg.y > 20) this.LForeleg.y -= 0.15;
			if (this.LForeleg.xRot > 0) this.LForeleg.xRot -= 0.05;
			if (this.LForeleg.yRot < 0) this.LForeleg.yRot += 0.05;
			if (this.LForeleg.zRot > 0) this.LForeleg.zRot -= 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//Neck
//				this.Neck.x = 0;
//				this.Neck.y = 3;
//				this.Neck.z = -0.5F;
				if (this.Neck.x < 3) this.Neck.x += 0.15;
				if (this.Neck.y < 11) this.Neck.y += 0.15;
				if (this.Neck.z < 2) this.Neck.z += 0.15;
				if (this.Neck.xRot < 0.8025023820775095F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -0.03665191262740524F) this.Neck.yRot -= 0.05;
				//LLeg
//				this.LLeg.x = -1;
//				this.LLeg.y = 18.5F;
//				this.LLeg.z = 2;
				if (this.LLeg.x < -1) this.LLeg.x += 0.15;
				if (this.LLeg.y < 18.5) this.LLeg.y += 0.15;
				if (this.LLeg.z > 2) this.LLeg.z -= 0.15;
				if (this.LLeg.xRot > -0.14608405639455457F) this.LLeg.xRot -= 0.05;
				if (this.LLeg.yRot > -0.14625859331449564F) this.LLeg.yRot -= 0.05;
				if (this.LLeg.zRot < 0.6932448001974364F) this.LLeg.zRot += 0.05;
				//RForeleg
//				this.RForeleg.y = 24.2F;
				if (this.RForeleg.y < 24.2) this.RForeleg.y += 0.15;
				if (this.RForeleg.xRot > -0.21868975061435758F) this.RForeleg.xRot -= 0.05;
				if (this.RForeleg.yRot > -0.036477379868653376F) this.RForeleg.yRot -= 0.05;
				if (this.RForeleg.zRot < 1.460491523395177F) this.RForeleg.zRot += 0.05;
				//TailBase
//				this.TailBase.y = 3F;
//				this.TailBase.z = 10;
				if (this.TailBase.y < 3) this.TailBase.y += 0.15;
				if (this.TailBase.z > 10) this.TailBase.z -= 0.15;
				if (this.TailBase.xRot > -0.4782202083885436F) this.TailBase.xRot -= 0.05;
				if (this.TailBase.yRot < 0.18238690350445608F) this.TailBase.yRot += 0.05;
				if (this.TailBase.zRot > -0.2553416715641412F) this.TailBase.zRot -= 0.05;
				//Torso
//				this.Torso.x = 5;
//				this.Torso.y = 20F;
				if (this.Torso.x < 5) this.Torso.x += 0.15;
				if (this.Torso.y < 20) this.Torso.y += 0.15;
				if (this.Torso.xRot > -0.03665191262740524F) this.Torso.xRot -= 0.05;
				if (this.Torso.yRot > -0.07312929665724782F) this.Torso.yRot -= 0.05;
				if (this.Torso.zRot < 1.2407545013269026F) this.Torso.zRot += 0.05;
				//RLeg
//				this.RLeg.y = 23.7F;
				if (this.RLeg.y < 23.7) this.RLeg.y += 0.15;
				if (this.RLeg.xRot < 0.4742059590984399F) this.RLeg.xRot += 0.05;
				if (this.RLeg.zRot < 1.4606660936046318F) this.RLeg.zRot += 0.05;
				//Head
				if (this.Head.xRot > -0.036477379868653376F) this.Head.xRot -= 0.05;
				//LForeleg
//				this.LForeleg.y = 19.0F;
				if (this.LForeleg.y < 19) this.LForeleg.y += 0.15;
				if (this.LForeleg.xRot < 0.3282964229790696F) this.LForeleg.xRot += 0.05;
				if (this.LForeleg.yRot > -1.7453292129831807E-4F) this.LForeleg.yRot -= 0.05;
				if (this.LForeleg.zRot < 0.36477380700891215F) this.LForeleg.zRot += 0.05;
			}
		} else {
			this.RForeleg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.LForeleg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.RLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.LLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
			this.TailBase.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
			this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
			this.Torso.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
			this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Torso.xRot = 0.2F;
				this.LForeleg.zRot = 0.3F;
				this.RForeleg.zRot = -0.3F;
			}
			if (entity.isInWater()) {
				this.Torso.y = 3;
				this.Torso.xRot = -0.125F;
				this.TailBase.xRot = 0.0625F;
				this.RLeg.y = 19;
				this.LLeg.y = 19;
				this.RForeleg.y = 23;
				this.LForeleg.y = 23;
				this.RLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LForeleg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RForeleg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = 0.125F;
				this.TailBase.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		//Neck
		this.Neck.x = 0;
		this.Neck.y = 2.5F;
		this.Neck.z = 0;
		this.Neck.xRot = 0.0698F;
		this.Neck.yRot = 0;
		//LLeg
		this.LLeg.x = -2.5F;
		this.LLeg.y = 18;
		this.LLeg.z = 2.5F;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		//RForeleg
		this.RForeleg.y = 20.0F;
		this.RForeleg.xRot = 0;
		this.RForeleg.yRot = 0;
		this.RForeleg.zRot = 0;
		//TailBase
		this.TailBase.y = 2.0F;
		this.TailBase.z = 10;
		this.TailBase.xRot = 0;
		this.TailBase.yRot = 0;
		this.TailBase.zRot = 0;
		//Torso
		this.Torso.x = 0;
		this.Torso.y = 14;
		this.Torso.xRot = 0;
		this.Torso.yRot = 0;
		this.Torso.zRot = 0;
		//RLeg
		this.RLeg.y = 18;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.RLeg.zRot = 0;
		//Head
		this.Head.xRot = 0;
		//LForeleg
		this.LForeleg.y = 20.0F;
		this.LForeleg.xRot = 0;
		this.LForeleg.yRot = 0;
		this.LForeleg.zRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}