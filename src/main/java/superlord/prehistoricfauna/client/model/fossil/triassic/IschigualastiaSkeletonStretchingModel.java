package superlord.prehistoricfauna.client.model.fossil.triassic;

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
import superlord.prehistoricfauna.common.entity.fossil.triassic.IschigualastiaSkeleton;

public class IschigualastiaSkeletonStretchingModel extends EntityModel<IschigualastiaSkeleton> {
	private final ModelPart Body;

	public IschigualastiaSkeletonStretchingModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -13.0F, -24.0F, 20.0F, 18.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 8.0F, 0.2346F, 0.0F, 0.0F));

		PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(65, 57).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 22.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -10.0F, 5.0F, -0.1955F, 0.0F, 0.0F));

		PartDefinition FootL = LegL.addOrReplaceChild("FootL", CubeListBuilder.create().texOffs(70, 90).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, -5.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(103, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 10.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition part10 = Tail.addOrReplaceChild("part10", CubeListBuilder.create().texOffs(134, 64).addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 64).addBox(-6.0F, -6.0F, -13.0F, 12.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -25.0F, -0.1564F, 0.0F, 0.0F));

		PartDefinition Face = Neck.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(0, 99).addBox(-4.5F, -6.0F, -8.0F, 9.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -13.0F));

		PartDefinition Vertebrae = Body.addOrReplaceChild("Vertebrae", CubeListBuilder.create().texOffs(111, 22).addBox(0.0F, -6.0F, 0.0F, 0.0F, 18.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -25.0F));

		PartDefinition ArmR = Body.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(62, 99).addBox(-2.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -3.0F, -18.0F, -0.43F, 0.0F, -0.43F));

		PartDefinition ArmL = Body.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(62, 99).mirror().addBox(-4.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -3.0F, -18.0F, -0.43F, 0.0F, 0.43F));

		PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(65, 57).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 22.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -10.0F, 5.0F, -0.2346F, 0.0F, 0.0F));

		PartDefinition FootR = LegR.addOrReplaceChild("FootR", CubeListBuilder.create().texOffs(70, 90).mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 22.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(IschigualastiaSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
