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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Alcovasaurus;

public class AlcovasaurusBabyModel extends EntityModel<Alcovasaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart LeftArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightArm;
	private final ModelPart RightLeg;

	public AlcovasaurusBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.LeftLeg = this.Body.getChild("LeftLeg");
		this.RightArm = this.Body.getChild("RightArm");
		this.RightLeg = this.Body.getChild("RightLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(30, 15).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -3.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(30, 28).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(24, 37).addBox(-0.5F, -3.0F, -3.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(16, 43).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 37).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(30, 0).addBox(-1.0F, -4.0F, 1.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 7.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 3.0F, 0.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 1.0F, 5.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(8, 43).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 3.0F, 0.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(12, 32).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 1.0F, 5.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Alcovasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.8025023820775095F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.03665191262740524F);
				this.LeftLeg.x = Mth.lerp(sleepProgress, 2.5F, 3);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.14608405639455457F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, 0.2932448001974364F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -0.21868975061435758F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.460491523395177F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.4782202083885436F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.18238690350445608F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, -0.2553416715641412F);
				this.Body.y = Mth.lerp(sleepProgress, 16, 20F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.03665191262740524F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.07312929665724782F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 1.2407545013269026F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.2742059590984399F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, -0.2606660936046318F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.3282964229790696F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -1.7453292129831807E-4F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.36477380700891215F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.8025023820775095F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.03665191262740524F, 0);
				this.LeftLeg.x = Mth.lerp(sleepProgress, 3, 2.5F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.14608405639455457F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0.2932448001974364F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.21868975061435758F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.460491523395177F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.4782202083885436F, -0.1745F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.18238690350445608F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, -0.2553416715641412F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 20F, 16);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.03665191262740524F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.07312929665724782F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 1.2407545013269026F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.2742059590984399F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, -0.2606660936046318F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.3282964229790696F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -1.7453292129831807E-4F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.36477380700891215F, 0);
			} else {
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
//				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = 0.3F;
					this.RightArm.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.Body.y = 17;
					this.Body.xRot = -0.125F;
					this.Tail.xRot = 0.0625F;
					this.RightLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.125F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		//Neck
		this.Neck.x = 0;
		this.Neck.y = 0F;
		this.Neck.z = -2;
		this.Neck.xRot = 0F;
		this.Neck.yRot = 0;
		//LeftLeg
		this.LeftLeg.x = 2.5F;
		this.LeftLeg.y = 1;
		this.LeftLeg.z = 5.5F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		//RightArm
		this.RightArm.y = 3.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		//Tail
		this.Tail.y = -0.5F;
		this.Tail.z = 7;
		this.Tail.xRot = -0.1745F;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		//Body
		this.Body.x = 0;
		this.Body.y = 16;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		//RightLeg
		this.RightLeg.y = 1;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		//Head
		this.Head.xRot = 0;
		//LeftArm
		this.LeftArm.y = 3.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
	}

	public void sleepPose() {
		this.Neck.xRot = 0.8025023820775095F;
		this.Neck.yRot = -0.03665191262740524F;
		this.LeftLeg.x = 3;
		this.LeftLeg.xRot = -0.14608405639455457F;
		this.LeftLeg.zRot = 0.2932448001974364F;
		this.RightArm.xRot = -0.21868975061435758F;
		this.RightArm.yRot = -0.036477379868653376F;
		this.RightArm.zRot = -0.460491523395177F;
		this.Tail.xRot = -0.4782202083885436F;
		this.Tail.yRot = 0.18238690350445608F;
		this.Tail.zRot = -0.2553416715641412F;
		this.Body.y = 20F;
		this.Body.xRot = -0.03665191262740524F;
		this.Body.yRot = -0.07312929665724782F;
		this.Body.zRot = 1.2407545013269026F;
		this.RightLeg.xRot = 0.2742059590984399F;
		this.RightLeg.zRot = -0.2606660936046318F;
		this.Head.xRot = -0.036477379868653376F;
		this.LeftArm.xRot = 0.3282964229790696F;
		this.LeftArm.yRot = -1.7453292129831807E-4F;
		this.LeftArm.zRot = 0.36477380700891215F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
