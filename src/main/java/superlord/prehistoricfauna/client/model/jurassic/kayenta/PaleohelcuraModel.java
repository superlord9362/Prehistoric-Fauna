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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Paleohelcura;

public class PaleohelcuraModel<T extends Paleohelcura> extends EntityModel<T> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg4;
	private final ModelPart RightLeg4;
	private final ModelPart LeftLeg2;
	private final ModelPart RightLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart RightLeg3;
	private final ModelPart RightLeg1;
	private final ModelPart LeftLeg1;

	public PaleohelcuraModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftLeg4 = this.Body.getChild("LeftLeg4");
		this.RightLeg4 = this.Body.getChild("RightLeg4");
		this.LeftLeg2 = this.Body.getChild("LeftLeg2");
		this.RightLeg2 = this.Body.getChild("RightLeg2");
		this.LeftLeg3 = this.Body.getChild("LeftLeg3");
		this.RightLeg3 = this.Body.getChild("RightLeg3");
		this.RightLeg1 = this.Body.getChild("RightLeg1");
		this.LeftLeg1 = this.Body.getChild("LeftLeg1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(0.0F, 0.0F, -5.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -1.5F, -6.0F, 0.0F, -0.3491F, 0.3142F));

		PartDefinition LeftClaw = LeftArm.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(2, 12).mirror().addBox(-0.75F, 0.01F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -2.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, 0.0F, -5.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.5F, -6.0F, 0.0F, 0.3491F, -0.3142F));

		PartDefinition RightClaw = RightArm.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(2, 12).addBox(-0.25F, 0.01F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LeftLeg4 = Body.addOrReplaceChild("LeftLeg4", CubeListBuilder.create().texOffs(12, 9).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -2.0F, -2.5F, 0.0F, -1.2217F, 0.0F));

		PartDefinition RightLeg4 = Body.addOrReplaceChild("RightLeg4", CubeListBuilder.create().texOffs(12, 9).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, -2.5F, 0.0F, 1.2217F, 0.0F));

		PartDefinition LeftLeg2 = Body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(12, 13).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -2.0F, -3.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightLeg2 = Body.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(12, 13).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, -3.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftLeg3 = Body.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(12, 9).mirror().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -2.0F, -3.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition RightLeg3 = Body.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(12, 9).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, -3.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition RightLeg1 = Body.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(12, 11).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, -4.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition LeftLeg1 = Body.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(12, 11).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -2.0F, -4.0F, 0.0F, 0.0873F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Paleohelcura entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLeg3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.LeftLeg4.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 20) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.RightLeg4.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 25) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg2.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
		this.LeftLeg4.xRot = -(Mth.cos(limbSwing * walkSpeed + 20) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
		this.RightLeg4.xRot = Mth.cos(limbSwing * walkSpeed + 25) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg1.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftArm.zRot = -0.15F * (Mth.sin(0.075F * ageInTicks)) + 0.3142F;
		this.RightArm.zRot = -0.15F * Mth.sin(0.075F * ageInTicks) - 0.3142F;
		this.Tail.xRot = 0.15F * Mth.sin(0.075F * ageInTicks) + 0.3491F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}