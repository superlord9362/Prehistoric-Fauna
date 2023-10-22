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

public class IschigualastiaBabyModel extends EntityModel<Ischigualastia> {
	private final ModelPart Torso;
	private final ModelPart Tail;
	private final ModelPart Neck;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart RLeg;
	private final ModelPart LLeg;

	public IschigualastiaBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Tail = Torso.getChild("Tail");
		this.Neck = Torso.getChild("Neck");
		this.RArm = root.getChild("RArm");
		this.LArm = root.getChild("LArm");
		this.RLeg = root.getChild("RLeg");
		this.LLeg = root.getChild("LLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -4.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -3.0F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(24, 5).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 10.0F));

		PartDefinition RArm = partdefinition.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 21.0F, -1.5F));

		PartDefinition LArm = partdefinition.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 21.0F, -1.5F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(14, 17).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 19.0F, 3.5F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(14, 17).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 19.0F, 3.5F));

		return LayerDefinition.create(meshdefinition, 34, 26);
	}

	@Override
	public void setupAnim(Ischigualastia entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Neck.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.1F) + attackProgress * (float) Math.toRadians(25F);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.RLeg.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
				this.LLeg.xRot = (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
				this.LArm.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
				this.RArm.xRot = (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
				this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.25F;
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.Torso.y = 14;
					this.Torso.xRot = -0.125F;
					this.Tail.xRot = 0.0625F;
					this.LArm.y = 20;
					this.RArm.y = 20;
					this.LArm.z = -2.5F;
					this.RArm.z = -2.5F;
					this.LLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.0625F;
					this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.25F;
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Torso
			//this.Torso.y = 15;
			if (this.Torso.y > 15) this.Torso.y -= 0.15;
			if (this.Torso.zRot < 0) this.Torso.zRot += 0.05;
			//LLeg
			//this.LLeg.x = -3.0F;
			//this.LLeg.y = 19;
			if (this.LLeg.x > -3) this.LLeg.x -= 0.15;
			if (this.LLeg.y < 19) this.LLeg.y += 0.15;
			if (this.LLeg.zRot < 0) this.LLeg.zRot += 0.05;
			//RArm
			//this.RArm.x = 3;
			//this.RArm.y = 21;
			if (this.RArm.x > 3) this.RArm.x -= 0.15;
			if (this.RArm.y > 21) this.RArm.y -= 0.15;
			if (this.RArm.xRot > 0) this.RArm.xRot -= 0.05;
			if (this.RArm.zRot < 0) this.RArm.zRot += 0.05;
			//RLeg
			//this.RLeg.x = 3;
			//this.RLeg.y = 19;
			if (this.RLeg.x > 3) this.RLeg.x -= 0.15;
			if (this.RLeg.y > 19) this.RLeg.y -= 0.15;
			if (this.RLeg.xRot > 0) this.RLeg.xRot -= 0.05;
			if (this.RLeg.zRot < 0) this.RLeg.zRot += 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.05;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot < 0) this.Tail.yRot += 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
			//LArm
			//this.LArm.x = -3.0F;
			//this.LArm.y = 21;
			if (this.LArm.x > -3) this.LArm.x -= 0.15;
			if (this.LArm.y < 21) this.LArm.y += 0.15;
			if (this.LArm.xRot < 0) this.LArm.xRot += 0.05;
			if (this.LArm.yRot < 0) this.LArm.yRot += 0.05;
			if (this.LArm.zRot < 0) this.LArm.zRot += 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Torso
			//this.Torso.y = 15;
			if (this.Torso.y < 20) this.Torso.y += 0.15;
			if (this.Torso.zRot > -1.5707963267948966F) this.Torso.zRot -= 0.05;
			//LLeg
			//this.LLeg.x = -3.0F;
			//this.LLeg.y = 19;
			if (this.LLeg.x < 4.4) this.LLeg.x += 0.15;
			if (this.LLeg.y > 16) this.LLeg.y -= 0.15;
			if (this.LLeg.zRot > -1.04719755118F) this.LLeg.zRot -= 0.05;
			//RArm
			//this.RArm.x = 3;
			//this.RArm.y = 21;
			if (this.RArm.x < 5) this.RArm.x += 0.15;
			if (this.RArm.y < 23) this.RArm.y += 0.15;
			if (this.RArm.xRot < 0.5235987755982988F) this.RArm.xRot += 0.05;
			if (this.RArm.zRot > -1.5707963267948966F) this.RArm.zRot -= 0.05;
			//RLeg
			//this.RLeg.x = 3;
			//this.RLeg.y = 19;
			if (this.RLeg.x < 4) this.RLeg.x += 0.15;
			if (this.RLeg.y < 23) this.RLeg.y += 0.15;
			if (this.RLeg.xRot < 0.41887902047863906F) this.RLeg.xRot += 0.05;
			if (this.RLeg.zRot > -1.5707963267948966F) this.RLeg.zRot -= 0.05;
			//Neck
			if (this.Neck.xRot < 0.593411945678072F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.13962634015954636F) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot < 0.8377580409572781F) this.Neck.zRot += 0.05;
			//Tail
			if (this.Tail.xRot > -0.24434609527920614F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot > -0.10471975511965977F) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot < 0.593411945678072F) this.Tail.zRot += 0.05;
			//LArm
			//this.LArm.x = -3.0F;
			//this.LArm.y = 21;
			if (this.LArm.x < 7) this.LArm.x += 0.15;
			if (this.LArm.y > 17) this.LArm.y -= 0.15;
			if (this.LArm.xRot > -0.45378560551852565F) this.LArm.xRot -= 0.05;
			if (this.LArm.yRot > -0.24434609527920614F) this.LArm.yRot -= 0.05;
			if (this.LArm.zRot > -0.5235987755982988F) this.LArm.zRot -= 0.05;
		}
	}

	public void resetModel() {
		this.Torso.y = 15;
		this.Torso.xRot = 0;
		this.Torso.zRot = 0;
		this.LLeg.x = -3.0F;
		this.LLeg.y = 19;
		this.LLeg.xRot = 0;
		this.LLeg.zRot = 0;
		this.RArm.x = 3;
		this.RArm.y = 21;
		this.RArm.z = -1.5F;
		this.RArm.xRot = 0;
		this.RArm.zRot = 0;
		this.RLeg.x = 3;
		this.RLeg.y = 19;
		this.RLeg.xRot = 0;
		this.RLeg.zRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.LArm.x = -3.0F;
		this.LArm.y = 21;
		this.LArm.z = -1.5F;
		this.LArm.xRot = 0;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0;
	}

	public void sleepPose() {
		this.Torso.y = 20;
		this.Torso.zRot = -1.5707963267948966F;
		this.LLeg.x = 4.4F;
		this.LLeg.y = 16;
		this.LLeg.zRot = -1.04719755118F;
		this.RArm.y = 23;
		this.RArm.x = 5;
		this.RArm.xRot = 0.5235987755982988F;
		this.RArm.zRot = -1.5707963267948966F;
		this.RLeg.x = 4;
		this.RLeg.y = 23;
		this.RLeg.xRot = 0.41887902047863906F;
		this.RLeg.zRot = -1.5707963267948966F;
		this.Neck.xRot = 0.593411945678072F;
		this.Neck.yRot = -0.13962634015954636F;
		this.Neck.zRot = 0.8377580409572781F;
		this.Tail.xRot = -0.24434609527920614F;
		this.Tail.yRot = -0.10471975511965977F;
		this.Tail.zRot = 0.593411945678072F;
		this.LArm.x = 7F;
		this.LArm.y = 17;
		this.LArm.xRot = -0.45378560551852565F;
		this.LArm.yRot = -0.24434609527920614F;
		this.LArm.zRot = -0.5235987755982988F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}