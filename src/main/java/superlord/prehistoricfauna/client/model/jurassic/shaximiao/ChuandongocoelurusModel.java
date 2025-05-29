package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Chuandongocoelurus;

public class ChuandongocoelurusModel extends EntityModel<Chuandongocoelurus> {
	private final ModelPart Root;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;

	public ChuandongocoelurusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.Body = this.Root.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Neck = this.Body.getChild("Neck");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 8.5F, 0.5F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, -1.5F, -2.5F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.5F, 2.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 21).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-1.0F, -1.5F, -2.5F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 7.5F, 2.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(29, 0).addBox(-3.0F, -2.5F, -13.5F, 6.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(13, 14).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.5F, -10.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(13, 14).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 3.5F, -10.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, -1.975F, 0.0F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.5F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 3).addBox(-1.5F, -0.95F, 0.0F, 3.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 15.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(24, 36).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 9).addBox(-1.0F, -7.0F, -9.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(31, 0).addBox(-1.5F, -7.0F, -4.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -13.5F));

		PartDefinition cube_r1 = Neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(9, 5).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.5F, -6.75F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 77, 50);
	}




	@Override
	public void setupAnim(Chuandongocoelurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.6646214111173737F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.3848178792724077F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 7.5F, 7.2F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 2.5F, 2.6F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.3979350561389017F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.0781907508222411F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.27366763203903305F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -1.1728612040769677F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.46914448828868976F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.5864306020384839F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 1.3292428222347474F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.7037167490777915F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -1.3264502315156905F);
				this.Body.y = Mth.lerp(sleepProgress, 0, 9);
				this.RightLeg.y = Mth.lerp(sleepProgress, 7.5F, 7.2F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 2.5F, 2.6F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.3979350561389017F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -1.1728612040769677F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.46914448828868976F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0, 10);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0, 10);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.6646214111173737F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.3848178792724077F, 0);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 7.2F, 7.5F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 2.6F, 2.5F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.3979350561389017F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.0781907508222411F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.27366763203903305F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -1.1728612040769677F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.46914448828868976F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.5864306020384839F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 1.3292428222347474F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.7037167490777915F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -1.3264502315156905F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 9, 0);
				this.RightLeg.y = Mth.lerp(sleepProgress, 7.2F, 7.5F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 2.6F, 2.5F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.3979350561389017F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -1.1728612040769677F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.46914448828868976F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 10, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 10, 0);
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
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftLeg.y = 7.5F;
		this.LeftLeg.z = 2.5F;
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
		this.Body.y = 0.0F;
		this.RightLeg.y = 7.5F;
		this.RightLeg.z = 2.5F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.xRot = 0;
		this.RightThigh.y = 0;
		this.LeftThigh.y = 0;
	}

	public void sleepPose() {
		this.Neck.xRot = 0.6646214111173737F;
		this.Neck.yRot = -1.3848178792724077F;
		this.LeftLeg.y = 7.2F;
		this.LeftLeg.z = 2.6F;
		this.LeftLeg.xRot = -0.3979350561389017F;
		this.LeftLeg.yRot = -0.0781907508222411F;
		this.LeftLeg.zRot = -0.27366763203903305F;
		this.RightThigh.xRot = -1.1728612040769677F;
		this.RightThigh.yRot = -0.46914448828868976F;
		this.Tail1.xRot = -0.23457224414434488F;
		this.Tail1.yRot = 0.5864306020384839F;
		this.LeftArm.zRot = 1.3292428222347474F;
		this.Tail2.xRot = 0.11728612207217244F;
		this.Tail2.yRot = 0.7037167490777915F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightArm.zRot = -1.3264502315156905F;
		this.Body.y = 9;
		this.RightLeg.y = 7.2F;
		this.RightLeg.z = 2.6F;
		this.RightLeg.xRot = -0.3979350561389017F;
		this.RightLeg.yRot = 0.0781907508222411F;
		this.RightLeg.zRot = 0.27366763203903305F;
		this.LeftThigh.xRot = -1.1728612040769677F;
		this.LeftThigh.yRot = 0.46914448828868976F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightThigh.y = 10;
		this.LeftThigh.y = 10;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}