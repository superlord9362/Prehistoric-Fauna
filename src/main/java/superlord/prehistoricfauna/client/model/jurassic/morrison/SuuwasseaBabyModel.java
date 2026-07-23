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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Suuwassea;

public class SuuwasseaBabyModel extends EntityModel<Suuwassea> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;

	public SuuwasseaBabyModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Tail1 = this.Body.getChild("Tail1");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, -4.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -1.0F, 6.0F, 7.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(0.0F, -6.0F, 0.0F, 0.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(24, 2).addBox(-1.0F, 0.0F, -13.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(2, 12).addBox(0.0F, -2.0F, 2.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.975F, 10.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 28).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 28).mirror().addBox(-0.5F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 1.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(51, 0).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -2.0F, 8.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.0F, -1.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(51, 0).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -2.0F, 8.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 6.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 66, 43);
	}

	@Override
	public void setupAnim(Suuwassea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 0, 8F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.4189378856769737F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.23039819087864056F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1047F, -0.04260075936930908F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.5864306020384839F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.4405726395466833F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.039269908169872414F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -2, 6F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -1.2F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.5082398595386212F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -2, 6F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -1.2F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.3839724354387525F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.2162978572970231F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.8294172592861477F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 8, 0F);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.4189378856769737F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.23039819087864056F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.04260075936930908F, -0.1047F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.5864306020384839F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.4405726395466833F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.039269908169872414F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 6F, -2);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -1.2F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.5082398595386212F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 6F, -2);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -1.2F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.3839724354387525F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.2162978572970231F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.8294172592861477F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
			} else {
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2));
				this.Body.zRot = Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = 0.025F * Mth.sin(0.05F * ageInTicks / 5) + (Mth.cos(1.0F + (limbSwing / 2) * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.1F) - 0.025F;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 2) * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Neck.xRot = -0.0125F * Mth.sin(0.1F * ageInTicks / 2) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50)) + 0.0125F;
				this.Neck.yRot = (Mth.cos((limbSwing / 2) * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.RightLeg.xRot = Mth.cos((limbSwing / 2) * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + (limbSwing / 2) * 0.3F) * 0.5F * limbSwingAmount;
				this.RightArm.xRot = (Mth.cos(1.0F + (limbSwing / 2) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftArm.xRot = (Mth.cos(5.0F + (limbSwing / 2) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.Body.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 2))) + (Mth.cos((limbSwing / 2) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
				}
				if (entity.isInWater()) {
					this.Body.y = 5;
					this.RightThigh.y = 3;
					this.LeftThigh.y = 3;
					this.Body.xRot = -0.15F;
					this.Tail1.xRot = 0.125F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.125F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.125F;
					this.LeftLeg.xRot = 0.125F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.125F;
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.15F;
					this.Tail1.yRot = (Mth.cos((limbSwing / 2) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 0F;
		this.Body.yRot = 0F;
		this.Body.zRot = 0F;
		this.RightArm.x = -3F;
		this.RightArm.y = 0.0F;
		this.RightArm.z = 1F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0F;
		this.RightArm.zRot = 0F;
		this.Tail1.y = -2.975F;
		this.Tail1.z = 10;
		this.Tail1.xRot = -0.1047F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftArm.x = 3F;
		this.LeftArm.y = 0;
		this.LeftArm.z = 1F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0F;
		this.LeftArm.zRot = 0F;
		this.LeftThigh.y = -2F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.x = -0.5F;
		this.LeftLeg.y = 6;
		this.LeftLeg.z = -1F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.y = -2F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.x = 0.5F;
		this.RightLeg.y = 6;
		this.RightLeg.z = -1F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.Neck.x = 0F;
		this.Neck.y = -3F;
		this.Neck.z = -1;
		this.Neck.xRot = 0F;
		this.Neck.yRot = 0F;
		this.Neck.zRot = 0F;
	}

	public void sleepPose() {
		this.Body.y = 8F;
		this.Body.yRot = -0.038920842652368684F;
		this.Body.zRot = -0.1563815016444822F;
		this.RightArm.xRot = -1.4189378856769737F;
		this.RightArm.yRot = -0.23039819087864056F;
		this.Tail1.xRot = -0.04260075936930908F;
		this.Tail1.yRot = 0.5864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.LeftArm.xRot = -1.4405726395466833F;
		this.LeftArm.yRot = -0.039269908169872414F;
		this.LeftArm.zRot = 0.3909537457888271F;
		this.LeftThigh.y = 6F;
		this.LeftThigh.xRot = -1.2F;
		this.LeftThigh.yRot = -0.5082398595386212F;
		this.RightThigh.y = 6F;
		this.RightThigh.xRot = -1.2F;
		this.RightThigh.yRot = 0.3839724354387525F;
		this.RightThigh.zRot = 0.10471975511965977F;
		this.Neck.xRot = 0.2162978572970231F;
		this.Neck.yRot = -0.8294172592861477F;
		this.Neck.zRot = 0.11728612207217244F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}