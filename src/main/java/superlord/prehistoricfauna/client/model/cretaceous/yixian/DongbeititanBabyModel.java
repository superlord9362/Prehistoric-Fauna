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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dongbeititan;

public class DongbeititanBabyModel extends EntityModel<Dongbeititan> {
	private final ModelPart Torso;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart RLeg;
	private final ModelPart LLeg;
	private final ModelPart TailBase;
	private final ModelPart Neck;
	private final ModelPart Head;

	public DongbeititanBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.RForeleg = root.getChild("RForeleg");
		this.LForeleg = root.getChild("LForeleg");
		this.RLeg = root.getChild("RLeg");
		this.LLeg = root.getChild("LLeg");
		this.TailBase = Torso.getChild("TailBase");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -7.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -10.0F, -3.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Spines = Neck.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(49, -4).addBox(0.0F, -1.0F, -3.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 1.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -8.1F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(28, 7).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, -3.0F));

		PartDefinition Nose = Snout.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(42, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(29, 9).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 14.0F, -0.1047F, 0.0F, 0.0F));

		PartDefinition RForeleg = partdefinition.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 17.0F, -4.5F));

		PartDefinition LForeleg = partdefinition.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 17.0F, -4.5F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(14, 22).addBox(-1.5F, -2.0F, -2.5F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 15.0F, 3.5F));

		PartDefinition RLeg2 = RLeg.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(43, 32).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 7.0F, -2.5F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(14, 22).mirror().addBox(-2.5F, -2.0F, -2.5F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 15.0F, 3.5F));

		PartDefinition LLeg2 = LLeg.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(43, 32).mirror().addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 7.0F, -2.5F));

		return LayerDefinition.create(meshdefinition, 62, 39);
	}

	@Override
	public void setupAnim(Dongbeititan entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Torso.y = Mth.lerp(sleepProgress, 11, 16F);
				this.Torso.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Torso.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.RForeleg.x = Mth.lerp(sleepProgress, 2.5F, 3.5F);
				this.RForeleg.y = Mth.lerp(sleepProgress, 17, 20.0F);
				this.RForeleg.z = -Mth.lerp(sleepProgress, -4.5F, 4.0F);
				this.RForeleg.xRot = Mth.lerp(sleepProgress, 0, -1.1405726395466833F);
				this.RForeleg.yRot = Mth.lerp(sleepProgress, 0, -0.039269908169872414F);
				this.RForeleg.zRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.TailBase.y = Mth.lerp(sleepProgress, 3, 3F);
				this.TailBase.z = Mth.lerp(sleepProgress, 14, 13F);
				this.TailBase.xRot = Mth.lerp(sleepProgress, -0.1047F, -0.24260075936930908F);
				this.TailBase.yRot = Mth.lerp(sleepProgress, 0, 0.5864306020384839F);
				this.TailBase.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.LForeleg.x = Mth.lerp(sleepProgress, -2.5F, -3.5F);
				this.LForeleg.y = Mth.lerp(sleepProgress, 17, 21);
				this.LForeleg.z = Mth.lerp(sleepProgress, -4.5F, -4);
				this.LForeleg.xRot = Mth.lerp(sleepProgress, 0, -1.2189378856769737F);
				this.LForeleg.yRot = Mth.lerp(sleepProgress, 0, -0.43039819087864056F);
				this.LLeg.x = Mth.lerp(sleepProgress, -3, -3.5F);
				this.LLeg.y = Mth.lerp(sleepProgress, 15, 20);
				this.LLeg.z = Mth.lerp(sleepProgress, 3.5F, 4);
				this.LLeg.xRot = Mth.lerp(sleepProgress, 0, -1.2F);
				this.LLeg.yRot = Mth.lerp(sleepProgress, 0, 0.3839724354387525F);
				this.LLeg.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.RLeg.x = Mth.lerp(sleepProgress, 3, 3.5F);
				this.RLeg.y = Mth.lerp(sleepProgress, 15, 20);
				this.RLeg.z = Mth.lerp(sleepProgress, 3.5F, 4);
				this.RLeg.xRot = Mth.lerp(sleepProgress, 0, -1.2F);
				this.RLeg.yRot = Mth.lerp(sleepProgress, 0, -0.5082398595386212F);
				this.Neck.x = Mth.lerp(sleepProgress, 0, 0F);
				this.Neck.y = Mth.lerp(sleepProgress, 4, 3F);
				this.Neck.z = Mth.lerp(sleepProgress, 0, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.1745F, 0.9162978572970231F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.3294172592861477F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Head.x = Mth.lerp(sleepProgress, -1, -1);
				this.Head.z = Mth.lerp(sleepProgress, -1, -2);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.5269149104981519F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.2562143561638466F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Torso.y = Mth.lerp(sleepProgress, 16, 11F);
				this.Torso.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Torso.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.RForeleg.x = Mth.lerp(sleepProgress, 3.5F, 2.5F);
				this.RForeleg.y = Mth.lerp(sleepProgress, 20, 17.0F);
				this.RForeleg.z = -Mth.lerp(sleepProgress, 4F, -4.5F);
				this.RForeleg.xRot = Mth.lerp(sleepProgress, -1.1405726395466833F, 0);
				this.RForeleg.yRot = Mth.lerp(sleepProgress, -0.039269908169872414F, 0);
				this.RForeleg.zRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.TailBase.y = Mth.lerp(sleepProgress, 3, 3F);
				this.TailBase.z = Mth.lerp(sleepProgress, 13, 14F);
				this.TailBase.xRot = Mth.lerp(sleepProgress, -0.24260075936930908F, -0.1047F);
				this.TailBase.yRot = Mth.lerp(sleepProgress, 0.5864306020384839F, 0);
				this.TailBase.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.LForeleg.x = Mth.lerp(sleepProgress, -3.5F, -2.5F);
				this.LForeleg.y = Mth.lerp(sleepProgress, 21, 17);
				this.LForeleg.z = Mth.lerp(sleepProgress, -4, -4.5F);
				this.LForeleg.xRot = Mth.lerp(sleepProgress, -1.2189378856769737F, 0);
				this.LForeleg.yRot = Mth.lerp(sleepProgress, -0.43039819087864056F, 0);
				this.LLeg.x = Mth.lerp(sleepProgress, -3.5F, -3);
				this.LLeg.y = Mth.lerp(sleepProgress, 20, 15);
				this.LLeg.z = Mth.lerp(sleepProgress, 4F, 3.5F);
				this.LLeg.xRot = Mth.lerp(sleepProgress, -1.2F, 0);
				this.LLeg.yRot = Mth.lerp(sleepProgress, 0.3839724354387525F, 0);
				this.LLeg.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.RLeg.x = Mth.lerp(sleepProgress, 3.5F, 3);
				this.RLeg.y = Mth.lerp(sleepProgress, 20, 15);
				this.RLeg.z = Mth.lerp(sleepProgress, 4F, 3.5F);
				this.RLeg.xRot = Mth.lerp(sleepProgress, -1.2F, 0F);
				this.RLeg.yRot = Mth.lerp(sleepProgress, -0.5082398595386212F, 0);
				this.Neck.x = Mth.lerp(sleepProgress, 0, 0F);
				this.Neck.y = Mth.lerp(sleepProgress, 3, 4F);
				this.Neck.z = Mth.lerp(sleepProgress, 0, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.9162978572970231F, 0.1745F);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.3294172592861477F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Head.x = Mth.lerp(sleepProgress, -1, -1);
				this.Head.z = Mth.lerp(sleepProgress, -2, -1);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.5269149104981519F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.2562143561638466F, 0);
			} else {
				this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2));
				this.Torso.zRot = Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + (limbSwing / 2) * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
				this.TailBase.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 2) * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.TailBase.zRot = Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck.yRot = (Mth.cos((limbSwing / 2) * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
				this.RLeg.xRot = Mth.cos((limbSwing / 2) * 0.3F) * 0.5F * limbSwingAmount;
				this.LLeg.xRot = Mth.cos(4.0F + (limbSwing / 2) * 0.3F) * 0.5F * limbSwingAmount;
				this.RForeleg.xRot = (Mth.cos(1.0F + (limbSwing / 2) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LForeleg.xRot = (Mth.cos(5.0F + (limbSwing / 2) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.Torso.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
				}
				if (entity.isInWater()) {
					this.Torso.y = 12;
					this.Torso.xRot = -0.25F;
					this.TailBase.xRot = 0.125F;
					this.RLeg.y = 18;
					this.LLeg.y = 18;
					this.LLeg.z = 2.5F;
					this.RLeg.z = 2.5F;
					this.LForeleg.z = -5.5F;
					this.RForeleg.z = -5.5F;
					this.RLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LForeleg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RForeleg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.5F;
					this.TailBase.yRot = (Mth.cos((limbSwing / 2) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Torso.y = 11F;
		this.Torso.yRot = 0F;
		this.Torso.zRot = 0F;
		this.RForeleg.x = 2.5F;
		this.RForeleg.y = 17.0F;
		this.RForeleg.z = -4.5F;
		this.RForeleg.xRot = 0F;
		this.RForeleg.yRot = 0F;
		this.RForeleg.zRot = 0F;
		this.TailBase.y = 3F;
		this.TailBase.z = 14F;
		this.TailBase.xRot = -0.1047F;
		this.TailBase.yRot = 0;
		this.TailBase.zRot = 0;
		this.LForeleg.x = -2.5F;
		this.LForeleg.y = 17;
		this.LForeleg.z = -4.5F;
		this.LForeleg.xRot = 0F;
		this.LForeleg.yRot = 0F;
		this.LLeg.x = -3.0F;
		this.LLeg.y = 15;
		this.LLeg.z = 3.5F;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RLeg.x = 3.0F;
		this.RLeg.y = 15;
		this.RLeg.z = 3.5F;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.Neck.x = 0F;
		this.Neck.y = 4F;
		this.Neck.z = 0;
		this.Neck.xRot = 0.1745F;
		this.Neck.yRot = 0F;
		this.Neck.zRot = 0F;
		this.Head.x = -1;
		this.Head.z = -1;
		this.Head.xRot = 0F;
		this.Head.yRot = 0F;
		this.Head.zRot = 0F;
	}

	public void sleepPose() {
		this.Torso.y = 16F;
		this.Torso.yRot = -0.038920842652368684F;
		this.Torso.zRot = -0.1563815016444822F;
		this.RForeleg.x = 3.5F;
		this.RForeleg.y = 20.0F;
		this.RForeleg.z = -4.0F;
		this.RForeleg.xRot = -1.1405726395466833F;
		this.RForeleg.yRot = -0.039269908169872414F;
		this.RForeleg.zRot = 0.3909537457888271F;
		this.TailBase.y = 3F;
		this.TailBase.z = 13F;
		this.TailBase.xRot = -0.24260075936930908F;
		this.TailBase.yRot = 0.5864306020384839F;
		this.TailBase.zRot = 0.3127630032889644F;
		this.LForeleg.x = -3.5F;
		this.LForeleg.y = 21;
		this.LForeleg.z = -4;
		this.LForeleg.xRot = -1.2189378856769737F;
		this.LForeleg.yRot = -0.43039819087864056F;
		this.LLeg.x = -3.5F;
		this.LLeg.y = 20;
		this.LLeg.z = 4;
		this.LLeg.xRot = -1.2F;
		this.LLeg.yRot = 0.3839724354387525F;
		this.LLeg.zRot = 0.10471975511965977F;
		this.RLeg.x = 3.5F;
		this.RLeg.y = 20;
		this.RLeg.z = 4;
		this.RLeg.xRot = -1.2F;
		this.RLeg.yRot = -0.5082398595386212F;
		this.Neck.x = 0F;
		this.Neck.y = 3F;
		this.Neck.z = 0;
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
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
