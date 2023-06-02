package superlord.prehistoricfauna.client.model.fossil.jurassic;

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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.DilophosaurusSkeleton;

public class DilophosaurusSkeletonSittingModel extends EntityModel<DilophosaurusSkeleton> {
	private final ModelPart FemurLeft;
	private final ModelPart Ribcage;
	private final ModelPart FemurRight;

	public DilophosaurusSkeletonSittingModel(ModelPart root) {
		this.FemurLeft = root.getChild("FemurLeft");
		this.Ribcage = root.getChild("Ribcage");
		this.FemurRight = root.getChild("FemurRight");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition FemurLeft = partdefinition.addOrReplaceChild("FemurLeft", CubeListBuilder.create().texOffs(72, 51).mirror().addBox(-2.0F, -1.0F, -3.5F, 6.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 12.5F, 6.5F, -0.9599F, 0.3491F, 0.0F));

		PartDefinition Leg2Left = FemurLeft.addOrReplaceChild("Leg2Left", CubeListBuilder.create().texOffs(72, 75).mirror().addBox(-2.0F, -4.0F, 0.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 11.5F, 3.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition FootLeft = Leg2Left.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(72, 94).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Ribcage = partdefinition.addOrReplaceChild("Ribcage", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -27.0F, 8.0F, 13.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 9.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition CervicalRibs = Ribcage.addOrReplaceChild("CervicalRibs", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -13.0F, -6.0F, 4.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -30.1F, -0.6981F, 0.384F, 0.0F));

		PartDefinition CervicalVertebrae = CervicalRibs.addOrReplaceChild("CervicalVertebrae", CubeListBuilder.create().texOffs(35, 58).mirror().addBox(0.0F, -10.0F, -8.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.5F, 3.0F));

		PartDefinition Skull = CervicalRibs.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 70).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, -5.0F, 0.7156F, 0.0F, 0.0F));

		PartDefinition Jaw = Skull.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 105).addBox(-2.0F, 0.0F, -4.99F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.01F, 0.0F));

		PartDefinition Mouth = Jaw.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 93).addBox(-1.0F, -1.0F, -8.99F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Snout = Skull.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 80).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -6.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(0, -1).mirror().addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(0, -1).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Snout_1 = Snout.addOrReplaceChild("Snout_1", CubeListBuilder.create().texOffs(-1, 115).addBox(-1.5F, 0.0F, -8.0F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Head = Skull.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(25, 119).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition CaudalRibs = Ribcage.addOrReplaceChild("CaudalRibs", CubeListBuilder.create().texOffs(50, 4).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 5.0F, -0.1396F, 0.2618F, 0.1396F));

		PartDefinition Tail2 = CaudalRibs.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(95, 3).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 18.0F, 0.2793F, 0.4189F, 0.0F));

		PartDefinition Tail2_1 = Tail2.addOrReplaceChild("Tail2_1", CubeListBuilder.create().texOffs(98, 3).addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -1.0F));

		PartDefinition CaudalVertebrae = CaudalRibs.addOrReplaceChild("CaudalVertebrae", CubeListBuilder.create().texOffs(56, 4).addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ThoracicVertebrae = Ribcage.addOrReplaceChild("ThoracicVertebrae", CubeListBuilder.create().texOffs(100, 48).addBox(0.0F, -4.0F, -27.0F, 0.0F, 15.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ArmLeft = Ribcage.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(41, 46).mirror().addBox(-1.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 6.0F, -23.0F, 1.2217F, -0.1745F, -0.3491F));

		PartDefinition ArmRight = Ribcage.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(41, 46).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 6.0F, -23.0F, 1.2217F, 0.1745F, 0.3491F));

		PartDefinition PectoralGirdle = Ribcage.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(101, 3).addBox(-4.5F, -3.0F, -27.0F, 9.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));

		PartDefinition FemurRight = partdefinition.addOrReplaceChild("FemurRight", CubeListBuilder.create().texOffs(72, 51).addBox(-4.0F, 0.0F, -3.5F, 6.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 12.0F, 6.5F, -0.9599F, -0.3491F, 0.0F));

		PartDefinition Leg2Right = FemurRight.addOrReplaceChild("Leg2Right", CubeListBuilder.create().texOffs(72, 75).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 12.5F, 3.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition FootRight = Leg2Right.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(72, 94).mirror().addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(DilophosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		FemurLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ribcage.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FemurRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
