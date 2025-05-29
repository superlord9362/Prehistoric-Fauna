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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Calsoyasuchus;

@SuppressWarnings("unused")
public class CalsoyasuchusModel extends EntityModel<Calsoyasuchus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Tailspikes;
	private final ModelPart BodySpines;
	private final ModelPart Head;
	private final ModelPart Eyes;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightArm;
	private final ModelPart RightHand;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftArm;
	private final ModelPart LeftHand;

	public CalsoyasuchusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.Tailspikes = this.Tail.getChild("Tailspikes");
		this.BodySpines = this.Body.getChild("BodySpines");
		this.Head = this.Body.getChild("Head");
		this.Eyes = this.Head.getChild("Eyes");
		this.RightLeg = this.Root.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.RightArm = this.Root.getChild("RightArm");
		this.RightHand = this.RightArm.getChild("RightHand");
		this.LeftLeg = this.Root.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.LeftArm = this.Root.getChild("LeftArm");
		this.LeftHand = this.LeftArm.getChild("LeftHand");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -3.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -7.0F, 5.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(43, 0).addBox(-1.5F, -0.9F, -1.0F, 3.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.9F, 9.0F));

		PartDefinition Tailspikes = Tail.addOrReplaceChild("Tailspikes", CubeListBuilder.create().texOffs(70, 6).addBox(-1.0F, -0.25F, 0.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition BodySpines = Body.addOrReplaceChild("BodySpines", CubeListBuilder.create().texOffs(33, 24).addBox(-1.0F, -0.5F, -7.0F, 2.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -0.9F, -9.2F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -7.0F));

		PartDefinition Eyes = Head.addOrReplaceChild("Eyes", CubeListBuilder.create().texOffs(0, 36).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, -3.2F));

		PartDefinition RightLeg = Root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(38, 24).mirror().addBox(-2.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 1.0F, 7.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(35, 33).mirror().addBox(-3.0F, 0.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 3.0F, -1.5F));

		PartDefinition RightArm = Root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(27, 24).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 1.0F, -1.5F));

		PartDefinition RightHand = RightArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(25, 32).mirror().addBox(-2.5F, 0.0F, -2.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 3.0F, -1.5F));

		PartDefinition LeftLeg = Root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(38, 24).addBox(0.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 1.0F, 7.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(35, 33).addBox(-1.0F, 0.0F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, -1.5F));

		PartDefinition LeftArm = Root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(27, 24).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 1.0F, -1.5F));

		PartDefinition LeftHand = LeftArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(25, 32).addBox(-1.5F, 0.0F, -2.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 116, 64);
	}


	@Override
	public void setupAnim(Calsoyasuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 0, 2.0F);
				this.RightArm.y = Mth.lerp(sleepProgress, 1, 2.5F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 1, 3.5F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 1, 2.5F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 1, 3.5F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.17453292519943295F, -0.0572467989660713F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -1.0946705281561322F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.9382889765773795F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.9382889765773795F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 1.1728612040769677F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 2, 0F);
				this.RightArm.y = Mth.lerp(sleepProgress, 2.5F, 1F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 3.5F, 1F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 2.5F, 1F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 3.5F, 1F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.0572467989660713F, -0.17453292519943295F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -1.0946705281561322F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.9382889765773795F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.9382889765773795F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 1.1728612040769677F, 0);
			} else {
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Head.xRot = (HeadPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isInWater()) {
					this.RightHand.xRot = 1.5707963267948966F;
					this.LeftArm.xRot = 0.8726646259971648F;
					this.LeftHand.xRot = 1.5707963267948966F;
					this.RightArm.xRot = 0.8726646259971648F;
					this.LeftLeg.xRot = 1.0471975511965976F;
					this.RightLeg.xRot = 1.0471975511965976F;
					this.LeftFoot.zRot = 1.5707963267948966F;
					this.RightFoot.zRot = -1.5707963267948966F;
					this.RightFoot.y = 2F;
					this.RightFoot.z = -1.5F;
					this.LeftFoot.y = 2F;
					this.LeftFoot.z = -1.5F;
					this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
					this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
					this.Body.xRot = (HeadPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
					this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				}
			}
		}
	}

	public void resetModel() {
		this.Tail.xRot = -0.17453292519943295F;
		this.Tail.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.xRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.LeftHand.zRot = 0;
		this.RightHand.xRot = 0;
		this.RightHand.zRot = 0;
		this.LeftFoot.zRot = 0;
		this.RightFoot.zRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightLeg.zRot = 0;
		this.RightArm.zRot = 0;
		this.LeftHand.xRot = 0;
		this.LeftLeg.xRot = 0;
		this.RightLeg.xRot = 0;
		this.LeftFoot.zRot = 0;
		this.RightFoot.zRot = 0;
		this.RightArm.x = -2.5F;
		this.RightArm.y = 1.0F;
		this.RightArm.z = -1.5F;
		this.RightLeg.x = -2.0F;
		this.RightLeg.y = 1.0F;
		this.RightLeg.z = 7.5F;
		this.LeftArm.x = 2.5F;
		this.LeftArm.y = 1.0F;
		this.LeftArm.z = -1.5F;
		this.Body.x = 0.0F;
		this.Body.y = 0.0F;
		this.Body.z = 2.0F;
		this.Body.xRot = 0;
		this.LeftLeg.x = 2.0F;
		this.LeftLeg.y = 1.0F;
		this.LeftLeg.z = 7.5F;
		this.RightFoot.y = 3F;
		this.RightFoot.z = -1.5F;
		this.LeftFoot.y = 3F;
		this.LeftFoot.z = -1.5F;
	}

	public void sleepPose() {
		this.Body.y = 2.0F;
		this.RightArm.y = 2.5F;
		this.RightLeg.y = 3.5F;
		this.LeftArm.y = 2.5F;
		this.LeftLeg.y = 3.5F;
		this.Tail.xRot = -0.0572467989660713F;
		this.Tail.yRot = 0.3909537457888271F;
		this.LeftArm.zRot = -1.0946705281561322F;
		this.Head.xRot = 0.11728612207217244F;
		this.Head.yRot = -0.3909537457888271F;
		this.LeftLeg.zRot = -0.9382889765773795F;
		this.RightLeg.zRot = 0.9382889765773795F;
		this.RightArm.zRot = 1.1728612040769677F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}