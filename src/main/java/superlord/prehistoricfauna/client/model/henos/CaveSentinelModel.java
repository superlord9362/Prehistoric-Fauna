package superlord.prehistoricfauna.client.model.henos;

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
import superlord.prehistoricfauna.common.entity.henos.CaveSentinel;

public class CaveSentinelModel extends EntityModel<CaveSentinel> {
	private final ModelPart Cephalon;
	private final ModelPart Thorax;
	private final ModelPart Antenna;
	private final ModelPart Antenna2;
	private final ModelPart PleuralSpineLeft;
	private final ModelPart PleuralSpineRight;
	private final ModelPart PleuralSpine2Left;
	private final ModelPart PleuralSpine2Right;
	private final ModelPart PleuralSpine3;
	private final ModelPart PleuralSpine3Right;

	public CaveSentinelModel(ModelPart root) {
		this.Cephalon = root.getChild("Cephalon");
		this.Thorax = Cephalon.getChild("Thorax");
		this.Antenna = Cephalon.getChild("Antenna");
		this.Antenna2 = Cephalon.getChild("Antenna2");
		this.PleuralSpineLeft = Thorax.getChild("PleuralSpineLeft");
		this.PleuralSpineRight = Thorax.getChild("PleuralSpineRight");
		this.PleuralSpine2Left = Thorax.getChild("PleuralSpine2Left");
		this.PleuralSpine2Right = Thorax.getChild("PleuralSpine2Right");
		this.PleuralSpine3 = Thorax.getChild("PleuralSpine3");
		this.PleuralSpine3Right = Thorax.getChild("PleuralSpine3Right");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Cephalon = partdefinition.addOrReplaceChild("Cephalon", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 0.0F, -15.0F, 24.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition Thorax = Cephalon.addOrReplaceChild("Thorax", CubeListBuilder.create().texOffs(105, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition PleuralSpine2Left = Thorax.addOrReplaceChild("PleuralSpine2Left", CubeListBuilder.create().texOffs(20, 19).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 8.0F));

		PartDefinition PleuralSpine3Right = Thorax.addOrReplaceChild("PleuralSpine3Right", CubeListBuilder.create().texOffs(21, 19).mirror().addBox(0.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 0.0F, 13.0F));

		PartDefinition AxialLobe = Thorax.addOrReplaceChild("AxialLobe", CubeListBuilder.create().texOffs(155, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0F));

		PartDefinition PleuralSpineRight = Thorax.addOrReplaceChild("PleuralSpineRight", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, -1.0F, -2.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 0.0F, 3.0F));

		PartDefinition PleuralSpine2Right = Thorax.addOrReplaceChild("PleuralSpine2Right", CubeListBuilder.create().texOffs(20, 19).mirror().addBox(0.0F, -1.0F, -2.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 0.0F, 8.0F));

		PartDefinition PleuralSpineLeft = Thorax.addOrReplaceChild("PleuralSpineLeft", CubeListBuilder.create().texOffs(0, 19).addBox(-6.0F, -1.0F, -2.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 3.0F));

		PartDefinition PleuralSpine3 = Thorax.addOrReplaceChild("PleuralSpine3", CubeListBuilder.create().texOffs(21, 19).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 13.0F));

		PartDefinition Antenna = Cephalon.addOrReplaceChild("Antenna", CubeListBuilder.create().texOffs(-11, 27).addBox(-10.5F, 0.0F, -3.0F, 11.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 3.0F, -15.0F, -0.0123F, 0.0F, 0.0F));

		PartDefinition Cranidium = Cephalon.addOrReplaceChild("Cranidium", CubeListBuilder.create().texOffs(63, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -10.0F));

		PartDefinition Antenna2 = Cephalon.addOrReplaceChild("Antenna2", CubeListBuilder.create().texOffs(-11, 27).addBox(-0.5F, 0.0F, -3.0F, 11.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 3.0F, -15.0F, -0.0123F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(CaveSentinel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
        float walkDegree = 0.5f;
		this.Antenna.xRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.Antenna2.xRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.PleuralSpineLeft.zRot = Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 1F * limbSwingAmount;
		this.PleuralSpineRight.zRot = -(Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 1F * limbSwingAmount);
		this.PleuralSpine2Left.zRot = Mth.cos(limbSwing * walkSpeed * 0.3F + 1) * walkDegree * 1F * limbSwingAmount;
		this.PleuralSpine2Right.zRot = -(Mth.cos(limbSwing * walkSpeed * 0.3F + 1) * walkDegree * 1F * limbSwingAmount);
		this.PleuralSpine3.zRot = Mth.cos(limbSwing * walkSpeed * 0.3F + 2) * walkDegree * 1F * limbSwingAmount;
		this.PleuralSpine3Right.zRot = -(Mth.cos(limbSwing * walkSpeed * 0.3F + 2) * walkDegree * 1F * limbSwingAmount);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Cephalon.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}