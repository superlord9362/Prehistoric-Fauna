package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Byronosaurus;

@SuppressWarnings("unused")
public class ByronosaurusModel extends EntityModel<Byronosaurus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightToe;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftToe;

	public ByronosaurusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
		this.LeftWing = this.Body.getChild("LeftWing");
		this.RightWing = this.Body.getChild("RightWing");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.RightToe = this.RightFoot.getChild("RightToe");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.LeftToe = this.LeftFoot.getChild("LeftToe");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 16).addBox(-2.0F, -1.0F, -5.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(15, 45).addBox(-1.0F, -6.3333F, -2.307F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.3333F, -4.693F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(22, 4).addBox(-0.5F, 0.475F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(42, 7).addBox(-1.5F, 1.975F, -3.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 0).addBox(-1.5F, -1.025F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(45, 53).addBox(-1.5F, -1.025F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.3333F, -0.307F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(49, 16).mirror().addBox(0.0F, -1.525F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 0.5F, -3.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(49, 16).addBox(-1.0F, -1.525F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.5F, -3.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.5F, 2.0F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(18, 16).mirror().addBox(-1.0F, 0.0F, -1.5F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 1.0F, -2.5F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(18, 16).addBox(0.0F, 0.0F, -1.5F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 1.0F, -2.5F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -8.5F, 1.7F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(12, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.5F, 1.3F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightToe = RightFoot.addOrReplaceChild("RightToe", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, -0.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -8.5F, 1.7F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(12, 3).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 4.5F, 1.3F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-1.5F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftToe = LeftFoot.addOrReplaceChild("LeftToe", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Byronosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Root.y = Mth.lerp(sleepProgress, 24, 28);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.17463292F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981316F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.2443461F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.87266463F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.13962634F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 1.0471976F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -2.268928F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.83774805F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2443461F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.87266463F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.LeftFoot.zRot = Mth.lerp(sleepProgress, 0, 0.24609143118910318F);
			} else sleepPose();
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) - 0.17463292F;
			this.Head.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.LeftWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.RightWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Root.y = Mth.lerp(sleepProgress, 28, 24);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.17463292F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.6981316F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.2443461F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.87266463F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.13962634F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 1.0471976F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -2.268928F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.83774805F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.6981317F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2443461F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.87266463F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.LeftFoot.zRot = Mth.lerp(sleepProgress, 0.24609143118910318F, 0);
			} else {
				this.Neck.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
				this.RightWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
				this.LeftWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.RightThigh.xRot = Mth.sin(0.4F * limbSwing) * 0.25F * limbSwingAmount;
				this.RightLeg.xRot = Mth.sin(limbSwing*0.4F) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.RightFoot.xRot = Mth.sin(limbSwing * 0.4F) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.LeftThigh.xRot = Mth.sin(0.4F * limbSwing + (float)Math.PI) * 0.25F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.sin(limbSwing*0.4F + (float)Math.PI) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.LeftFoot.xRot = Mth.sin(limbSwing * 0.4F + (float)Math.PI) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.RightWing.yRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftWing.yRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				if (entity.isInWater()) {
					this.RightWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.LeftThigh.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Root.y = 26;
				}
			}
		}
	}
	
	public void resetModel() {
		this.Root.y = 24;
		this.Body.xRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.zRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.zRot = 0;
	}
	
	public void sleepPose() {
		this.Body.xRot = -0.17463292F;
		this.LeftLeg.xRot = -0.87266463F;
		this.LeftThigh.xRot = -0.6981316F;
		this.LeftThigh.yRot = 0.2443461F;
		this.Tail.xRot = -0.13962634F;
		this.Tail.yRot = 1.0471976F;
		this.Neck.yRot = -2.268928F;
		this.Neck.zRot = 0.83774805F;
		this.RightThigh.xRot = -0.6981317F;
		this.RightThigh.yRot = -0.2443461F;
		this.RightLeg.xRot = -0.87266463F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightFoot.zRot = -0.24434609527920614F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.LeftFoot.zRot = 0.24609143118910318F;
		this.Root.y = 28F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}