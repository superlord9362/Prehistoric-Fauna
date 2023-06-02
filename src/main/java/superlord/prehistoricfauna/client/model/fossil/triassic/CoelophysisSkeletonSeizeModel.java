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
import superlord.prehistoricfauna.common.entity.fossil.triassic.CoelophysisSkeleton;

public class CoelophysisSkeletonSeizeModel extends EntityModel<CoelophysisSkeleton> {
	private final ModelPart LFemur;
	private final ModelPart RFemur;
	private final ModelPart Body;

	public CoelophysisSkeletonSeizeModel(ModelPart root) {
		this.LFemur = root.getChild("LFemur");
		this.RFemur = root.getChild("RFemur");
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LFemur = partdefinition.addOrReplaceChild("LFemur", CubeListBuilder.create().texOffs(101, 1).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 12.5F, 3.5F, -0.2618F, -0.3491F, 0.0F));

		PartDefinition LLeg = LFemur.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(6, 3).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.5F, 1.5F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition RFemur = partdefinition.addOrReplaceChild("RFemur", CubeListBuilder.create().texOffs(101, 1).mirror().addBox(-1.0F, -0.5F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 12.5F, 3.5F, 0.5236F, 0.0698F, 0.3491F));

		PartDefinition RLeg = RFemur.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.5F, 1.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -12.0F, 3.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 4.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Iliumtip = Body.addOrReplaceChild("Iliumtip", CubeListBuilder.create().texOffs(34, 14).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(82, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.5F, -10.5F, -0.8727F, 0.0F, -0.6981F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -5.5F, -2.5F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -12.7F, 0.6981F, -0.2443F, 0.0F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(55, 10).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.0F, -0.6255F, -0.1745F, 0.0F));

		PartDefinition CervicalVertebrae = Neck.addOrReplaceChild("CervicalVertebrae", CubeListBuilder.create().texOffs(44, -1).addBox(0.0F, -6.5F, -3.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition Vertebrae = Body.addOrReplaceChild("Vertebrae", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -0.5F, 0.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -13.0F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(82, 0).mirror().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 2.5F, -10.5F, -1.0472F, 0.0F, 0.5236F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(13, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.0F, 0.2443F, -0.3491F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.1047F, -0.3491F, 0.0F));

		PartDefinition CaudalVertebrae2 = Tail2.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition CaudalVertebrae = Tail1.addOrReplaceChild("CaudalVertebrae", CubeListBuilder.create().texOffs(54, -8).addBox(0.0F, -0.5F, 0.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Scapulae = Body.addOrReplaceChild("Scapulae", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -0.25F, 0.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -12.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(CoelophysisSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LFemur.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RFemur.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
