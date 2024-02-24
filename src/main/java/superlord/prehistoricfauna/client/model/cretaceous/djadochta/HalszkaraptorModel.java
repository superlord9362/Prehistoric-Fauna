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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Halszkaraptor;

public class HalszkaraptorModel extends EntityModel<Halszkaraptor> implements ArmedModel {
	private final ModelPart Body;
	private final ModelPart RLeg;
	private final ModelPart LLeg;
	private final ModelPart RWing;
	private final ModelPart LWing;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;

	public HalszkaraptorModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.RLeg = Body.getChild("RLeg");
		this.LLeg = Body.getChild("LLeg");
		this.Tail = Body.getChild("Tail");
		this.RWing = Body.getChild("RWing");
		this.LWing = Body.getChild("LWing");
		this.Head = Neck.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 15).addBox(-2.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 17.0F, -4.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(2, 3).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(12, 2).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition Mouth = Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(22, 3).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.0F, -2.0F));

		PartDefinition LWing = Body.addOrReplaceChild("LWing", CubeListBuilder.create().texOffs(14, 13).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.0F, 2.0F));

		PartDefinition RWing = Body.addOrReplaceChild("RWing", CubeListBuilder.create().texOffs(14, 13).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 1.0F, 2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(16, 21).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 5.0F));

		PartDefinition RLeg = Body.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(3, 25).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 3.0F, 3.0F));

		PartDefinition LLeg = Body.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(3, 25).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Halszkaraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			sleepPose();
		} else {
			this.Neck.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.RWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.LWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.RWing.yRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LWing.yRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			if (entity.isInWater()) {
				this.Body.y = 17;
				this.Body.xRot = -0.25F;
				this.Tail.xRot = 0.25F;
				this.Neck.xRot = 0.25F;
				this.LWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.RWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.RLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
			}
		}
	}

	public void resetModel() {
		this.RLeg.y = 3.0F;
		this.LLeg.y = 3.0F;
		this.RWing.y = 1.0F;
		this.RWing.xRot = 0;
		this.RWing.yRot = 0;
		this.RWing.zRot = 0;
		this.LWing.y = 1.0F;
		this.LWing.xRot = 0;
		this.LWing.yRot = 0;
		this.LWing.zRot = 0;
		this.Neck.y = 0.0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Tail.y = 1;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Body.y = 17.0F;
		this.Body.xRot = 0;
	}

	public void sleepPose() {
		this.RLeg.y = 0;
		this.LLeg.y = 0;
		this.RWing.y = 0.3F;
		this.RWing.xRot = -0.33004175888896664F;
		this.RWing.yRot = -0.21537363235926135F;
		this.LWing.y = 0.3F;
		this.LWing.xRot = -0.33004175888896664F;
		this.LWing.yRot = 0.21537363235926135F;
		this.Neck.y = 2.4F;
		this.Neck.xRot = -0.182212366584515F;
		this.Tail.y = 0.6F;
		this.Tail.xRot = -0.21938788164936507F;
		this.Tail.yRot = -0.1096066806870904F;
		this.Tail.zRot = -0.07295475973730675F;
		this.Body.y = 20.8F;
		this.Body.xRot = 0.07278023113974408F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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