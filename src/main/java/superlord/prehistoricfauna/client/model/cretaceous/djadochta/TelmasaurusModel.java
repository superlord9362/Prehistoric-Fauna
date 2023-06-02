package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;

public class TelmasaurusModel extends EntityModel<Telmasaurus> implements ArmedModel {
	private final ModelPart Backlegright;
	private final ModelPart Frontlegleft;
	private final ModelPart Backlegleft;
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Head;
	private final ModelPart Frontlegright;
	private final ModelPart Frontfootright;
	private final ModelPart Frontfootleft;
	private final ModelPart Backfootright;
	private final ModelPart Backfootleft;

	public TelmasaurusModel(ModelPart root) {
		this.Backlegright = root.getChild("Backlegright");
		this.Backfootright = Backlegright.getChild("Backfootright");
		this.Frontlegleft = root.getChild("Frontlegleft");
		this.Frontfootleft = Frontlegleft.getChild("Frontfootleft");
		this.Backlegleft = root.getChild("Backlegleft");
		this.Backfootleft = Backlegleft.getChild("Backfootleft");
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.Frontlegright = root.getChild("Frontlegright");
		this.Frontfootright = Frontlegright.getChild("Frontfootright");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Backlegright = partdefinition.addOrReplaceChild("Backlegright", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.7F, 4.0F));

		PartDefinition Backfootright = Backlegright.addOrReplaceChild("Backfootright", CubeListBuilder.create().texOffs(16, 30).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.29F, 0.0F));

		PartDefinition Frontlegleft = partdefinition.addOrReplaceChild("Frontlegleft", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 20.7F, -4.0F));

		PartDefinition Frontfootleft = Frontlegleft.addOrReplaceChild("Frontfootleft", CubeListBuilder.create().texOffs(17, 26).mirror().addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 3.29F, 1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Backlegleft = partdefinition.addOrReplaceChild("Backlegleft", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 20.7F, 4.0F));

		PartDefinition Backfootleft = Backlegleft.addOrReplaceChild("Backfootleft", CubeListBuilder.create().texOffs(16, 30).mirror().addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.29F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.7F, -2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.2F, -0.4F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 9.0F, -0.2F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(29, 0).addBox(-1.0F, -1.0F, -5.8F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.2F));

		PartDefinition Tongue = Head.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(32, 9).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.8F, 0.1162F, 0.0F, 0.0F));

		PartDefinition Frontlegright = partdefinition.addOrReplaceChild("Frontlegright", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 20.7F, -4.0F));

		PartDefinition Frontfootright = Frontlegright.addOrReplaceChild("Frontfootright", CubeListBuilder.create().texOffs(17, 26).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.29F, 1.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Telmasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Frontlegright.xRot = 0;
		this.Frontlegright.yRot = 0;
		this.Frontlegright.zRot = 0;
		this.Backlegleft.xRot = 0;
		this.Backlegleft.yRot = 0;
		this.Backlegleft.zRot = 0;
		this.Frontfootright.yRot = -0.7853981633974483F;
		this.Frontlegleft.xRot = 0;
		this.Frontlegleft.yRot = 0;
		this.Frontlegleft.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Backlegright.xRot = 0;
		this.Backlegright.yRot = 0;
		this.Backlegright.zRot = 0;
		this.Body.xRot = 0;
		this.Body.zRot = 0;
		this.Tail.zRot = 0;
		this.Body.y = 19.7F;
		this.Backlegleft.y = 20.7F;
		this.Backlegright.y = 20.7F;
		this.Frontlegleft.y = 20.7F;
		this.Frontlegright.y = 20.7F;
		this.Frontfootleft.zRot =  0;
		this.Frontfootright.zRot = 0;
		this.Backfootleft.xRot = 0;
		this.Backfootleft.yRot = 0;
		this.Backfootleft.zRot = 0;
		this.Backfootright.xRot = 0;
		this.Backfootright.yRot = 0;
		this.Backfootright.zRot = 0;
		if (entity.isAsleep()) {
			this.Body.y = 22.2F;
			this.Backlegright.y = 23.7F;
			this.Backlegleft.y = 23.7F;
			this.Frontlegright.y = 23.7F;
			this.Frontlegleft.y = 23.7F;
			this.Tail.xRot = -0.01762782527869516F;
			this.Tail.yRot = 0.583638077898454F;
			this.Frontlegleft.xRot = -0.6215117572878252F;
			this.Frontlegleft.yRot = -0.2546435405291338F;
			this.Frontlegleft.zRot = 1.4978415587352114F;
			this.Backlegright.xRot = 0.6557201946479475F;
			this.Backlegright.yRot = -6.981316851932723E-4F;
			this.Backlegright.zRot = -1.459793375715413F;
			this.Frontfootleft.yRot = 0.7853981633974483F;
			this.Frontlegright.xRot = -0.5478588415483757F;
			this.Frontlegright.yRot = 0.182212366584515F;
			this.Frontlegright.zRot = -1.3870131778651824F;
			this.Head.xRot = 0.009424778335276407F;
			this.Head.yRot = -0.40125119103875473F;
			this.Backlegleft.xRot = 0.7668976493578585F;
			this.Backlegleft.yRot = 0.11013027480215679F;
			this.Backlegleft.zRot = 1.4606660936046318F;
		} else {
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
			this.Tail.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.Tail.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
			this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
			this.Backlegleft.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.Backlegright.xRot = Mth.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.Frontlegleft.xRot = Mth.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.Frontlegright.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			if (entity.isInWater()) {
				this.Body.y = 17.2F;
				this.Backlegright.y  =  18.7F;
				this.Backlegleft.y = 18.7F;
				this.Frontlegright.y = 18.7F;
				this.Frontlegleft.y = 18.7F;
				this.Frontlegright.xRot = 1.25F;
				this.Frontlegright.yRot = 0.25F;
				this.Frontlegleft.xRot = 1.25F;
				this.Frontlegleft.yRot = -0.25F;
				this.Backlegleft.xRot = 1.25F;
				this.Backlegleft.yRot = -0.25F + (0.25F * Mth.sin(0.25F * ageInTicks / 1F));
				this.Backlegright.xRot = 1.25F;
				this.Backlegright.yRot = 0.25F + (0.25F * Mth.sin(0.25F * ageInTicks / 1F));
				this.Tail.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
				this.Frontfootright.zRot =  1.3688617376654748F;
				this.Frontfootleft.zRot = -1.3683381601951652F;
				this.Backfootright.xRot = -0.11728612207217244F;
				this.Backfootright.yRot = 0.03909537541112055F;
				this.Backfootright.zRot = 1.2510520131558576F;
				this.Backfootleft.xRot = -0.11728612207217244F;
				this.Backfootleft.yRot = 0.03909537541112055F;
				this.Backfootleft.zRot = -1.2510520131558576F;
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Backlegright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Frontlegleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Backlegleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Frontlegright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	public void translateToHand(HumanoidArm sideIn, PoseStack matrixStackIn) {
		float f = sideIn == HumanoidArm.RIGHT ? 1.0F : -1.0F;
		ModelPart modelrenderer = this.getArmForSide(sideIn);
		modelrenderer.x += f;
		modelrenderer.translateAndRotate(matrixStackIn);
		modelrenderer.x -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelPart getArmForSide(HumanoidArm side) {
		return side == HumanoidArm.LEFT ? this.Head : this.Head;
	}
}