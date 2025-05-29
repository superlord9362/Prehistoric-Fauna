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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Tanycolagreus;

public class TanycolagreusModel extends EntityModel<Tanycolagreus> {
	private final ModelPart Root;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public TanycolagreusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.Body = this.Root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(10, 20).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(22, 2).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(-1.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 7.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(22, 2).mirror().addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -9.0F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -6.0F, -3.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 6).addBox(-1.0F, -6.0F, -8.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition cube_r1 = Neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, -1).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -6.0F, -3.0F, -0.9163F, 0.0F, 0.3491F));

		PartDefinition cube_r2 = Neck.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, -1).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -6.0F, -3.0F, -0.9163F, 0.0F, -0.3491F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(20, 20).addBox(-1.5F, -0.975F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 4.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -0.975F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(20, 21).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 24).addBox(0.5F, -1.0F, 2.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.0F, -7.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(20, 21).mirror().addBox(-0.5F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 24).mirror().addBox(-0.5F, -1.0F, 2.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 3.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 50, 38);
	}

	@Override
	public void setupAnim(Tanycolagreus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 0, 10);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0, 10.9F);
				this.RightThigh.z = Mth.lerp(sleepProgress, 0, 1);
				this.RightLeg.y = Mth.lerp(sleepProgress, 7, 6.8F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 2, 1.6F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0, 10.9F);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 0, 1);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 7, 6.8F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 2, 1.6F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.6646214111173737F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.3848178792724077F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.3979350561389017F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.0781907508222411F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.27366763203903305F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -1.1728612040769677F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.46914448828868976F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.5864306020384839F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 1.3292428222347474F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.01728612207217244F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.7037167490777915F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -1.3264502315156905F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.3979350561389017F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -1.1728612040769677F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.46914448828868976F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 10, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 10.9F, 0);
				this.RightThigh.z = Mth.lerp(sleepProgress, 1, 0);
				this.RightLeg.y = Mth.lerp(sleepProgress, 6.8F, 7);
				this.RightLeg.z = Mth.lerp(sleepProgress, 1.6F, 2);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 10.9F, 0);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 1, 0);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 6.8F, 7);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 1.6F, 2);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.6646214111173737F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.3848178792724077F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.3979350561389017F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.0781907508222411F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.27366763203903305F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -1.1728612040769677F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.46914448828868976F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.5864306020384839F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 1.3292428222347474F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.01728612207217244F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.7037167490777915F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -1.3264502315156905F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.3979350561389017F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -1.1728612040769677F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.46914448828868976F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
			} else {
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
				this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isInWater()) {
					this.Body.y = 14;
					this.LeftThigh.y = 14;
					this.RightThigh.y = 14;
					this.Body.xRot = -0.5F;
					this.Tail1.xRot = 0.25F;
					this.Tail2.xRot = 0.25F;
					this.Neck.xRot = 0.5F;
					this.LeftThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.5F;
					this.LeftArm.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.RightThigh.y = 0;
		this.RightThigh.z = 0;
		this.LeftThigh.y = 0;
		this.LeftThigh.z = 0;
		this.LeftLeg.y = 7F;
		this.LeftLeg.z = 2F;
		this.Body.y = 0.0F;
		this.RightLeg.y = 7F;
		this.RightLeg.z = 2F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.LeftArm.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.xRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 10;
		this.RightThigh.y = 10.9F;
		this.RightThigh.z = 1;
		this.RightLeg.y = 6.8F;
		this.RightLeg.z = 1.6F;
		this.LeftThigh.y = 10.9F;
		this.LeftThigh.z = 1;
		this.LeftLeg.y = 6.8F;
		this.LeftLeg.z = 1.6F;
		this.Neck.xRot = 0.6646214111173737F;
		this.Neck.yRot = -1.3848178792724077F;
		this.LeftLeg.xRot = -0.3979350561389017F;
		this.LeftLeg.yRot = -0.0781907508222411F;
		this.LeftLeg.zRot = -0.27366763203903305F;
		this.RightThigh.xRot = -1.1728612040769677F;
		this.RightThigh.yRot = -0.46914448828868976F;
		this.Tail1.xRot = -0.23457224414434488F;
		this.Tail1.yRot = 0.5864306020384839F;
		this.LeftArm.zRot = 1.3292428222347474F;
		this.Tail2.xRot = 0.01728612207217244F;
		this.Tail2.yRot = 0.7037167490777915F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightArm.zRot = -1.3264502315156905F;
		this.RightLeg.xRot = -0.3979350561389017F;
		this.RightLeg.yRot = 0.0781907508222411F;
		this.RightLeg.zRot = 0.27366763203903305F;
		this.LeftThigh.xRot = -1.1728612040769677F;
		this.LeftThigh.yRot = 0.46914448828868976F;
		this.RightFoot.xRot = 1.5707963267948966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
