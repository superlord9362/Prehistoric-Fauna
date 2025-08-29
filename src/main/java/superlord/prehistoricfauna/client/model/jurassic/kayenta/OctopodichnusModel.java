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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Octopodichnus;

public class OctopodichnusModel<T extends Octopodichnus> extends EntityModel<T> {
	private final ModelPart Cephalothorax;
	private final ModelPart LeftPedipalp;
	private final ModelPart RightPedipalp;
	private final ModelPart LeftLeg1;
	private final ModelPart RightLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart RightLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart RightLeg3;
	private final ModelPart LeftLeg4;
	private final ModelPart RightLeg4;
	private final ModelPart Abdomen;

	public OctopodichnusModel(ModelPart root) {
		this.Cephalothorax = root.getChild("Cephalothorax");
		this.LeftPedipalp = this.Cephalothorax.getChild("LeftPedipalp");
		this.RightPedipalp = this.Cephalothorax.getChild("RightPedipalp");
		this.LeftLeg1 = this.Cephalothorax.getChild("LeftLeg1");
		this.RightLeg1 = this.Cephalothorax.getChild("RightLeg1");
		this.LeftLeg2 = this.Cephalothorax.getChild("LeftLeg2");
		this.RightLeg2 = this.Cephalothorax.getChild("RightLeg2");
		this.LeftLeg3 = this.Cephalothorax.getChild("LeftLeg3");
		this.RightLeg3 = this.Cephalothorax.getChild("RightLeg3");
		this.LeftLeg4 = this.Cephalothorax.getChild("LeftLeg4");
		this.RightLeg4 = this.Cephalothorax.getChild("RightLeg4");
		this.Abdomen = this.Cephalothorax.getChild("Abdomen");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Cephalothorax = partdefinition.addOrReplaceChild("Cephalothorax", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.75F, -1.9996F));

		PartDefinition LeftChelicerae = Cephalothorax.addOrReplaceChild("LeftChelicerae", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, -1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition RightChelicerae = Cephalothorax.addOrReplaceChild("RightChelicerae", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.75F, -1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition LeftPedipalp = Cephalothorax.addOrReplaceChild("LeftPedipalp", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -0.5F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, -1.0F));

		PartDefinition RightPedipalp = Cephalothorax.addOrReplaceChild("RightPedipalp", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(0.0F, -0.5F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 0.0F, -1.0F));

		PartDefinition LeftLeg1 = Cephalothorax.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(18, 2).addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.75F, -0.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightLeg1 = Cephalothorax.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(18, 2).mirror().addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.75F, -0.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LeftLeg2 = Cephalothorax.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(18, 2).addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.75F, 0.25F, 0.0F, -1.1345F, 0.0F));

		PartDefinition RightLeg2 = Cephalothorax.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(18, 2).mirror().addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.75F, 0.25F, 0.0F, 1.1345F, 0.0F));

		PartDefinition LeftLeg3 = Cephalothorax.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(18, 2).addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.75F, 0.75F, 0.0F, -2.0508F, 0.0F));

		PartDefinition RightLeg3 = Cephalothorax.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(18, 2).mirror().addBox(0.0F, -3.0F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.25F, 0.75F, 0.0F, 2.0508F, 0.0F));

		PartDefinition LeftLeg4 = Cephalothorax.addOrReplaceChild("LeftLeg4", CubeListBuilder.create().texOffs(18, 2).addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.75F, 1.5F, 0.0F, -2.618F, 0.0F));

		PartDefinition RightLeg4 = Cephalothorax.addOrReplaceChild("RightLeg4", CubeListBuilder.create().texOffs(18, 2).mirror().addBox(0.0F, -3.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.75F, 1.5F, 0.0F, 2.618F, 0.0F));

		PartDefinition Abdomen = Cephalothorax.addOrReplaceChild("Abdomen", CubeListBuilder.create().texOffs(1, 0).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 2.0F));

		PartDefinition cube_r1 = Abdomen.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(17, 0).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.25F, 4.75F, -0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void setupAnim(Octopodichnus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLeg3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount));
		this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount));
		this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount));
		this.LeftLeg4.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 20) * walkDegree * 0.5F * limbSwingAmount));
		this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount));
		this.RightLeg4.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 25) * walkDegree * 0.5F * limbSwingAmount));
		this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount));
		this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount));
		this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg2.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
		this.LeftLeg4.xRot = -(Mth.cos(limbSwing * walkSpeed + 20) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
		this.RightLeg4.xRot = Mth.cos(limbSwing * walkSpeed + 25) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg1.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount;
		this.RightPedipalp.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.LeftPedipalp.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
		this.Abdomen.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Cephalothorax.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}