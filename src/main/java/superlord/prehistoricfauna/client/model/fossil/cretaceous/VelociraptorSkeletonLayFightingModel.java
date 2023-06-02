package superlord.prehistoricfauna.client.model.fossil.cretaceous;

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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.VelociraptorSkeleton;

public class VelociraptorSkeletonLayFightingModel extends EntityModel<VelociraptorSkeleton> {
	private final ModelPart Thighleft;
	private final ModelPart Thighright;
	private final ModelPart Body;

	public VelociraptorSkeletonLayFightingModel(ModelPart root) {
		this.Thighleft = root.getChild("Thighleft");
		this.Thighright = root.getChild("Thighright");
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thighleft = partdefinition.addOrReplaceChild("Thighleft", CubeListBuilder.create().texOffs(46, 0).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 21.0F, 3.0F, -1.0472F, 0.3142F, 1.3963F));

		PartDefinition Legleft = Thighleft.addOrReplaceChild("Legleft", CubeListBuilder.create().texOffs(55, 11).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 5.0F, 1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Footleft = Legleft.addOrReplaceChild("Footleft", CubeListBuilder.create().texOffs(46, 10).mirror().addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 0.0F, 2.3038F, 0.0F, 0.0F));

		PartDefinition Thighright = partdefinition.addOrReplaceChild("Thighright", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 2.5F, -0.6632F, 0.0F, 1.5708F));

		PartDefinition Legright = Thighright.addOrReplaceChild("Legright", CubeListBuilder.create().texOffs(55, 11).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 5.0F, 1.5F, -0.4887F, 0.0F, 0.0F));

		PartDefinition Footright = Legright.addOrReplaceChild("Footright", CubeListBuilder.create().texOffs(46, 10).addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.1519F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.5F, -5.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 0.0F, -0.4189F, 0.1745F, 1.2217F));

		PartDefinition Vertebrae = Body.addOrReplaceChild("Vertebrae", CubeListBuilder.create().texOffs(13, 9).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(1, 0).addBox(-0.5F, -4.0F, -3.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -5.0F, 0.6981F, 0.384F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(16, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition Mouth = Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(31, 1).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -4.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 5.0F, 1.0472F, 0.0F, 0.1396F));

		PartDefinition Tailribs = Tail.addOrReplaceChild("Tailribs", CubeListBuilder.create().texOffs(33, 17).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition Wingright = Body.addOrReplaceChild("Wingright", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, -3.0F, -1.5708F, 0.7418F, -2.8798F));

		PartDefinition Wingleft = Body.addOrReplaceChild("Wingleft", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.5F, -4.0F, 0.4189F, 0.0F, 0.0F));

		PartDefinition Iliumtip = Body.addOrReplaceChild("Iliumtip", CubeListBuilder.create().texOffs(26, 10).addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(VelociraptorSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thighleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thighright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
