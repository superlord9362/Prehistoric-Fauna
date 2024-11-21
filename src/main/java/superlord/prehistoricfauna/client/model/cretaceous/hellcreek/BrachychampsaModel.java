package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Brachychampsa;

@SuppressWarnings("unused")
public class BrachychampsaModel extends EntityModel<Brachychampsa> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public BrachychampsaModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightLeg = this.Body.getChild("RightLeg");
		this.LeftLeg = this.Body.getChild("LeftLeg");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 7).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(17, -11).addBox(3.0F, -4.0F, -3.0F, 0.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(17, -11).addBox(-3.0F, -4.0F, -3.0F, 0.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -2.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(2, 29).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -3.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(22, 61).addBox(-1.5F, 0.5F, -8.025F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(1, 50).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 44).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 56).addBox(-2.0F, -0.5F, -8.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(22, 39).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -1.025F, -3.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(23, 45).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.01F))
				.texOffs(1, 38).addBox(-2.5F, 2.0F, -4.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.01F))
				.texOffs(18, 52).addBox(-2.0F, 1.0F, -8.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.5F, 0.0F, -7.9F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(67, 13).addBox(1.0F, 2.98F, -2.5F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(71, 5).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, -0.5F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(67, 13).mirror().addBox(-4.0F, 2.98F, -2.5F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(71, 5).mirror().addBox(-2.0F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 3.0F, -0.5F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(84, 5).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 15).addBox(-1.0F, 4.98F, -5.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 1.0F, 9.5F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(80, 15).mirror().addBox(-4.0F, 4.98F, -5.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(84, 5).mirror().addBox(-2.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 1.0F, 9.5F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(35, 4).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(36, -6).addBox(1.0F, -3.0F, 1.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(36, -6).addBox(-1.0F, -3.0F, 1.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(52, 7).addBox(-1.0F, -1.7F, -0.5F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(53, -11).addBox(0.0F, -3.7F, 1.5F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 8.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 64);
	}

	@Override
	public void setupAnim(Brachychampsa entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float NeckPitch) {
		float speed = 1f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 18, 22.0F);
				this.RightArm.y = Mth.lerp(sleepProgress, 3, 1F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 3, 1F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2618F, -0.0572467989660713F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1745F, -0.0572467989660713F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 1.0946705281561322F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, 0.9382889765773795F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, -0.9382889765773795F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -1.1728612040769677F);
			} else sleepPose();
//			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) - 0.0572467989660713F;
//			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount) + 0.3909537457888271F;
//			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + 0.0572467989660713F;
//			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount) + 0.3909537457888271F;
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 22, 18.0F);
				this.RightArm.y = Mth.lerp(sleepProgress, 1, 3F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 1, 3F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0572467989660713F, -0.2618F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.0572467989660713F, 0.1745F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 1.0946705281561322F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0.9382889765773795F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, -0.9382889765773795F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -1.1728612040769677F, 0);
			} else {
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.5F) * degree * 0.75F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.5F) * degree * -0.75F * limbSwingAmount;
				this.LeftLeg.xRot = (Mth.cos(limbSwing * speed * 0.5F) * degree * -0.75F * limbSwingAmount);
				this.RightLeg.xRot = (Mth.cos(limbSwing * speed * 0.5F) * degree * 0.75F * limbSwingAmount);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) - 0.1818F;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + 0.1245F;
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount);
				if (entity.isInWater()) {
					this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 2))) + ((Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F));
					this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 2)) + ((Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount));
					this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 2))) + ((Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F));
					this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 2)) + ((Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount)) ;
					this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (NeckPitch * ((float) Math.PI / 180F));
					this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
					this.Jaw.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(30F);
					this.RightArm.xRot = 0.8652F;
					this.LeftArm.xRot = 0.8652F;
					this.Neck.xRot = -(NeckPitch * ((float)Math.PI / 180F));
					this.LeftLeg.xRot = 1.1855F + (NeckPitch * ((float) Math.PI / 180F));
					this.RightLeg.xRot = 1.1855F + (NeckPitch * ((float) Math.PI / 180F));
				}
			}
			this.Body.yRot = Mth.cos(limbSwing * speed * 0.25F) * degree * 0.25F * limbSwingAmount;
			this.Jaw.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(30F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) + (NeckPitch * ((float) Math.PI / 180F));
			this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
		}
	}

	public void resetModel() {
		this.Body.y = 18;
		this.Body.xRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		//-1.25F, 9.5F
		this.LeftArm.y = 3;
		this.LeftArm.z = -0.5F;
		this.RightArm.y = 3;
		this.RightArm.z = -0.5F;
		this.RightLeg.y = 1;
		this.RightLeg.z = 9.5F;
		this.LeftLeg.y = 1;
		this.LeftLeg.z = 9.5F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
	}

	private void sleepPose() {
		this.Body.y = 22.0F;
		this.RightArm.y = 1F;
		this.LeftArm.y = 1F;
		this.Tail1.xRot = -0.0572467989660713F;
		this.Tail1.yRot = 0.3909537457888271F;
		this.Tail2.xRot = -0.0572467989660713F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.LeftArm.zRot = 1.0946705281561322F;
		this.Neck.xRot = 0.11728612207217244F;
		this.Neck.yRot = -0.3909537457888271F;
		this.LeftLeg.zRot = 0.9382889765773795F;
		this.RightLeg.zRot = -0.9382889765773795F;
		this.RightArm.zRot = -1.1728612040769677F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
