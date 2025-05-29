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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yandusaurus;

public class YandusaurusModel extends EntityModel<Yandusaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public YandusaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -5.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(3, 0).addBox(-4.0F, -5.0F, -12.0F, 8.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 4.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(20, 25).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(14, 32).mirror().addBox(0.0F, -4.0F, -4.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(35, 5).addBox(-1.5F, -10.0F, -3.975F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(49, 14).addBox(-1.0F, -7.0F, -6.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(49, 19).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -12.0F));

		PartDefinition cube_r1 = Neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(14, 32).mirror().addBox(0.0F, -2.0F, -1.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -1.0F, -3.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition cube_r2 = Neck.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 32).addBox(0.0F, -2.0F, -1.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -3.0F, 0.0F, 0.3054F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(34, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(46, 0).addBox(0.0F, -5.0F, 1.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -0.975F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 12.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 2.0F, -10.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 2.0F, -10.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(34, -3).addBox(1.5F, -2.0F, 3.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -14.0F, 3.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(34, 26).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.0F, 3.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(47, 10).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 8.0F, 0.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(34, -3).mirror().addBox(-1.5F, -2.0F, 3.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -14.0F, 3.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(34, 26).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 6.0F, 3.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(47, 10).mirror().addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 68, 42);
	}

	@Override
	public void setupAnim(Yandusaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.296705972839036F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -14, -6.2F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.Body.y = Mth.lerp(sleepProgress, -13, -4.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -14, -6.2F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.296705972839036F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.9773843811168246F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, 0.02853981633974483F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.29670597283F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.03853981633974483F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.5082398928281348F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.296705972839036F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -6.2F, -14);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -4.5F, -13);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -6.2F, -14);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.296705972839036F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.9773843811168246F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.7F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0.02853981633974483F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.29670597283F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.03853981633974483F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.5082398928281348F, 0);
			} else {
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
				}
				if (entity.isInWater()) {
					this.Body.y = 0;
					this.LeftThigh.y = -1;
					this.RightThigh.y = -1;
					this.Body.xRot = -0.5F;
					this.Tail1.xRot = 0.25F;
					this.Tail2.xRot = 0.25F;
					this.Neck.xRot = 0.5F;
					this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.5F;
					this.RightArm.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.LeftThigh.y = -14F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.z = -10F;
		this.LeftArm.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.y = -13;
		this.Body.xRot = 0;
		this.RightThigh.y = -14;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0.0436F;
		this.Neck.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.z = -10;
		this.RightArm.xRot = 0;
		this.Tail1.x = 0;
		this.Tail1.z = 2;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.xRot = 0;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.7F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = 0.296705972839036F;
		this.LeftThigh.y = -6.2F;
		this.LeftArm.xRot = 0.8726646259971648F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Body.y = -4.5F;
		this.Body.xRot = -0.24434609527920614F;
		this.RightThigh.y = -6.2F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = -0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		this.RightLeg.xRot = -0.7F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.Tail1.xRot = 0.02853981633974483F;
		this.Tail1.yRot = -0.29670597283F;
		this.Tail1.zRot = -0.10471975511965977F;
		this.Tail2.xRot = 0.03853981633974483F;
		this.Tail2.yRot = -0.5082398928281348F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
