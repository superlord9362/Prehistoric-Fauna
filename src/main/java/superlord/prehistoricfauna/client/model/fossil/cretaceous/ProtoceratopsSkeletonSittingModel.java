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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.ProtoceratopsSkeleton;

public class ProtoceratopsSkeletonSittingModel extends EntityModel<ProtoceratopsSkeleton> {
	private final ModelPart Body;

	public ProtoceratopsSkeletonSittingModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -4.0F, 5.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.6F, -2.0F, -0.5082F, 0.0F, 0.0F));

		PartDefinition BodyVertebrae = Body.addOrReplaceChild("BodyVertebrae", CubeListBuilder.create().texOffs(40, 43).addBox(0.0F, -3.0F, -4.0F, 0.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition IliumTip = Body.addOrReplaceChild("IliumTip", CubeListBuilder.create().texOffs(29, 12).addBox(-5.0F, 0.0F, 0.0F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -2.5F, 2.0F));

		PartDefinition FLegRight = Body.addOrReplaceChild("FLegRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 5.0F, -2.0F, 0.5084F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(3, 43).addBox(0.0F, -1.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -4.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(39, 12).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, 0.5473F, 0.0F, 0.0F));

		PartDefinition Crest = Head.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(34, 0).addBox(-5.5F, -7.5F, -1.4F, 11.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.4712F, 0.0F, 0.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(48, 27).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.5F));

		PartDefinition FLegLeft = Body.addOrReplaceChild("FLegLeft", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 5.0F, -2.0F, 0.5081F, 0.0F, 0.0F));

		PartDefinition BLegRight = Body.addOrReplaceChild("BLegRight", CubeListBuilder.create().texOffs(31, 34).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, 5.0F, 0.1173F, 0.0F, -0.2346F));

		PartDefinition FeetRight = BLegRight.addOrReplaceChild("FeetRight", CubeListBuilder.create().texOffs(30, 46).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 8.0F, 2.0F, -0.9783F, -0.1564F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(5, 25).addBox(0.0F, -3.5F, -2.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 7.0F, 0.1564F, 0.0F, 0.0F));

		PartDefinition Tailtip = Tail.addOrReplaceChild("Tailtip", CubeListBuilder.create().texOffs(18, 19).addBox(0.0F, -1.5F, 0.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.8F, 0.1173F, 0.0F, 0.0F));

		PartDefinition Tailtip_1 = Tailtip.addOrReplaceChild("Tailtip_1", CubeListBuilder.create().texOffs(1, 24).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition Tail_1 = Tail.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(-7, 22).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 1.0F));

		PartDefinition BLegLeft = Body.addOrReplaceChild("BLegLeft", CubeListBuilder.create().texOffs(31, 34).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -1.0F, 5.0F, 0.1173F, 0.0F, 0.2346F));

		PartDefinition FeetLeft = BLegLeft.addOrReplaceChild("FeetLeft", CubeListBuilder.create().texOffs(30, 46).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 8.0F, 2.0F, -0.9774F, 0.1564F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(ProtoceratopsSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
