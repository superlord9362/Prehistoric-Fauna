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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Ruixinia;

public class RuixiniaBabyModel extends EntityModel<Ruixinia> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Tail;

	public RuixiniaBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightLeg = this.Body.getChild("RightLeg");
		this.LeftLeg = this.Body.getChild("LeftLeg");
		this.Tail = this.Body.getChild("Tail");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -9.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(23, 42).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(12, 38).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 4.0F, -3.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(20, 38).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 4.0F, -3.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(30, 30).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 2.0F, 2.5F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 2.0F, 2.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Ruixinia entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 15, 18F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.RightArm.x = Mth.lerp(sleepProgress, -2.5F, -3F);
				this.RightArm.z = Mth.lerp(sleepProgress, -3, -4.0F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.2189378856769737F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.43039819087864056F);
				this.Tail.y = Mth.lerp(sleepProgress, 1.5F, 2F);
				this.Tail.z = Mth.lerp(sleepProgress, 5, 4F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.1047F, -0.24260075936930908F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.5864306020384839F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.LeftArm.x = Mth.lerp(sleepProgress, 2.5F, 3F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -3, -4);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.1405726395466833F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.039269908169872414F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.LeftLeg.x = Mth.lerp(sleepProgress, 2.5F, 3.5F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 2, 3.5F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -1.2F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.5082398595386212F);
				this.RightLeg.x = Mth.lerp(sleepProgress, -2.5F, -3.5F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 2, 2.5F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.2F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.3839724354387525F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.1745F, 0.9162978572970231F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.3294172592861477F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Head.x = Mth.lerp(sleepProgress, 0, -1);
				this.Head.z = Mth.lerp(sleepProgress, -1, -2);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.5269149104981519F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.2562143561638466F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 18, 15F);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.RightArm.x = Mth.lerp(sleepProgress, -3F, -2.5F);
				this.RightArm.z = Mth.lerp(sleepProgress, -4, -3.0F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.2189378856769737F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.43039819087864056F, 0);
				this.Tail.y = Mth.lerp(sleepProgress, 2, 1.5F);
				this.Tail.z = Mth.lerp(sleepProgress, 4, 5F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.24260075936930908F, -0.1047F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.5864306020384839F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.LeftArm.x = Mth.lerp(sleepProgress, 3, 2.5F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -4, -3);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.1405726395466833F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.039269908169872414F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.LeftLeg.x = Mth.lerp(sleepProgress, 3.5F, 2.5F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 3.5F, 2);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.2F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.5082398595386212F, 0);
				this.RightLeg.x = Mth.lerp(sleepProgress, -3.5F, -2.5F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 2.5F, 2);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.2F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.3839724354387525F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.9162978572970231F, 0.1745F);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.3294172592861477F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Head.x = Mth.lerp(sleepProgress, -1, 0);
				this.Head.z = Mth.lerp(sleepProgress, -2, -1);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.5269149104981519F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.2562143561638466F, 0);
			} else {
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2));
				this.Body.zRot = Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + (limbSwing / 2) * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
				this.Tail.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 2) * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail.zRot = Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck.yRot = (Mth.cos((limbSwing / 2) * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
				this.RightLeg.xRot = Mth.cos((limbSwing / 2) * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + (limbSwing / 2) * 0.3F) * 0.5F * limbSwingAmount;
				this.RightArm.xRot = (Mth.cos(1.0F + (limbSwing / 2) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftArm.xRot = (Mth.cos(5.0F + (limbSwing / 2) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.Body.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
				}
				if (entity.isInWater()) {
					this.Body.y = 20;
					this.Body.xRot = -0.25F;
					this.Tail.xRot = 0.125F;
//					this.RightLeg.y = 18;
//					this.LeftLeg.y = 18;
//					this.LeftLeg.z = 2.5F;
//					this.RightLeg.z = 2.5F;
//					this.LeftArm.z = -5.5F;
//					this.RightArm.z = -5.5F;
					this.RightLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.5F;
					this.Tail.yRot = (Mth.cos((limbSwing / 2) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 15F;
		this.Body.yRot = 0F;
		this.Body.zRot = 0F;
		this.RightArm.x = -2.5F;
		this.RightArm.y = 4.0F;
		this.RightArm.z = -3F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0F;
		this.RightArm.zRot = 0F;
		this.Tail.y = 1.5F;
		this.Tail.z = 5;
		this.Tail.xRot = -0.1047F;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.LeftArm.x = 2.5F;
		this.LeftArm.y = 4;
		this.LeftArm.z = -3F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0F;
		this.LeftArm.zRot = 0F;
		this.LeftLeg.x = 2.5F;
		this.LeftLeg.y = 2;
		this.LeftLeg.z = 2.5F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightLeg.x = -2.5F;
		this.RightLeg.y = 2;
		this.RightLeg.z = 2.5F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.Neck.x = 0F;
		this.Neck.y = 0F;
		this.Neck.z = -5;
		this.Neck.xRot = 0.1745F;
		this.Neck.yRot = 0F;
		this.Neck.zRot = 0F;
		this.Head.x = 0;
		this.Head.z = -1;
		this.Head.xRot = 0F;
		this.Head.yRot = 0F;
		this.Head.zRot = 0F;
	}

	public void sleepPose() {
		this.Body.y = 18F;
		this.Body.yRot = -0.038920842652368684F;
		this.Body.zRot = -0.1563815016444822F;
		this.RightArm.x = -3F;
		this.RightArm.y = 4F;
		this.RightArm.z = -4.0F;
		this.RightArm.xRot = -1.2189378856769737F;
		this.RightArm.yRot = -0.43039819087864056F;
		this.Tail.y = 2F;
		this.Tail.z = 4F;
		this.Tail.xRot = -0.24260075936930908F;
		this.Tail.yRot = 0.5864306020384839F;
		this.Tail.zRot = 0.3127630032889644F;
		this.LeftArm.x = 3F;
		this.LeftArm.y = 4;
		this.LeftArm.z = -4;
		this.LeftArm.xRot = -1.1405726395466833F;
		this.LeftArm.yRot = -0.039269908169872414F;
		this.LeftArm.zRot = 0.3909537457888271F;
		this.LeftLeg.x = 3.5F;
		this.LeftLeg.y = 3.5F;
		this.LeftLeg.z = 2.5F;
		this.LeftLeg.xRot = -1.2F;
		this.LeftLeg.yRot = -0.5082398595386212F;
		this.RightLeg.x = -3.5F;
		this.RightLeg.y = 2.5F;
		this.RightLeg.z = 2.5F;
		this.RightLeg.xRot = -1.2F;
		this.RightLeg.yRot = 0.3839724354387525F;
		this.RightLeg.zRot = 0.10471975511965977F;
		this.Neck.x = 0F;
		this.Neck.y = 0F;
		this.Neck.z = -5;
		this.Neck.xRot = 0.9162978572970231F;
		this.Neck.yRot = -1.3294172592861477F;
		this.Neck.zRot = 0.11728612207217244F;
		this.Head.x = -1;
		this.Head.z = -2;
		this.Head.xRot = -0.5269149104981519F;
		this.Head.yRot = 0.03909537541112055F;
		this.Head.zRot = 0.2562143561638466F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}