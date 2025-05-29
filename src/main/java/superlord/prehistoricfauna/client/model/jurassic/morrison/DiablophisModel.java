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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Diablophis;

@SuppressWarnings("unused")
public class DiablophisModel extends EntityModel<Diablophis> {
	private final ModelPart Hips;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Chest;
	private final ModelPart Head;
	private final ModelPart Tongue;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public DiablophisModel(ModelPart root) {
		this.Hips = root.getChild("Hips");
		this.Tail1 = this.Hips.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightLeg = this.Tail1.getChild("RightLeg");
		this.LeftLeg = this.Tail1.getChild("LeftLeg");
		this.Chest = this.Hips.getChild("Chest");
		this.Head = this.Chest.getChild("Head");
		this.Tongue = this.Head.getChild("Tongue");
		this.RightArm = this.Chest.getChild("RightArm");
		this.LeftArm = this.Chest.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hips = partdefinition.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 23.0F, 1.0F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 5.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 4.0F));

		PartDefinition RightLeg = Tail1.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.5F, 0.75F));

		PartDefinition LeftLeg = Tail1.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.5F, 0.75F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -6.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Chest.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(11, 8).addBox(-1.0F, -1.025F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition Tongue = Head.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.025F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.0F, -4.5F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, -4.5F));

		return LayerDefinition.create(meshdefinition, 24, 15);
	}

	@Override
	public void setupAnim(Diablophis entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLeg.yRot = Mth.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount;
		this.RightLeg.zRot = Mth.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount;
		this.LeftLeg.yRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.LeftLeg.zRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount;
		this.RightArm.yRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount;
		this.RightArm.zRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount + (netHeadYaw * ((float)Math.PI / 180F));
		this.LeftArm.yRot = Mth.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount;
		this.LeftArm.zRot = Mth.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount - (netHeadYaw * ((float)Math.PI / 180F));
		this.Chest.yRot = (Mth.sin(limbSwing * 0.6F) * limbSwingAmount) + (netHeadYaw * ((float)Math.PI / 180F));
		this.Head.yRot = (-Mth.sin(limbSwing * 0.6F) * limbSwingAmount);
		this.Tail1.yRot = Mth.sin(limbSwing * 0.6F) * limbSwingAmount;
		this.Tail2.yRot = -Mth.sin(limbSwing * 0.6F) * limbSwingAmount;
		this.Head.xRot = -(headPitch * ((float)Math.PI / 180F));
		this.Chest.xRot = (headPitch * ((float)Math.PI / 180F));
		if (entity.isInWater()) {
			this.Tail1.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
			this.Tail2.yRot = -0.25F * Mth.sin(0.25F * ageInTicks / 1F);
			this.Chest.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
			this.Head.yRot = -0.25F * Mth.sin(0.25F * ageInTicks / 1F);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Hips.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}