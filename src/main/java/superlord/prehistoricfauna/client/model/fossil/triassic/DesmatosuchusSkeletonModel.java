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
import superlord.prehistoricfauna.common.entity.fossil.triassic.DesmatosuchusSkeleton;

public class DesmatosuchusSkeletonModel extends EntityModel<DesmatosuchusSkeleton> {
	private final ModelPart Arm_L;
	private final ModelPart Arm_R;
	private final ModelPart Leg_L_1_1;
	private final ModelPart ASS;
	private final ModelPart Leg_L_1;

	public DesmatosuchusSkeletonModel(ModelPart root) {
		this.Arm_L = root.getChild("Arm_L");
		this.Arm_R = root.getChild("Arm_R");
		this.Leg_L_1_1 = root.getChild("Leg_L_1_1");
		this.ASS = root.getChild("ASS");
		this.Leg_L_1 = root.getChild("Leg_L_1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Arm_L = partdefinition.addOrReplaceChild("Arm_L", CubeListBuilder.create().texOffs(44, 32).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 11.0F, -7.5F));

		PartDefinition Arm_R = partdefinition.addOrReplaceChild("Arm_R", CubeListBuilder.create().texOffs(44, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 11.0F, -7.5F));

		PartDefinition Leg_L_1_1 = partdefinition.addOrReplaceChild("Leg_L_1_1", CubeListBuilder.create().texOffs(2, 48).addBox(0.0F, 0.0F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 9.0F, 10.0F));

		PartDefinition Leg_L_2_1 = Leg_L_1_1.addOrReplaceChild("Leg_L_2_1", CubeListBuilder.create().texOffs(24, 51).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.9F, 8.0F, 1.0F));

		PartDefinition Feet_L_1 = Leg_L_2_1.addOrReplaceChild("Feet_L_1", CubeListBuilder.create().texOffs(0, 61).mirror().addBox(-2.2F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.4F, 5.0F, 0.0F));

		PartDefinition ASS = partdefinition.addOrReplaceChild("ASS", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.0F, 0.0F, 12.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition TailCarapace = ASS.addOrReplaceChild("TailCarapace", CubeListBuilder.create().texOffs(84, 77).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 12.0F, -0.1499F, 0.0F, 0.0F));

		PartDefinition Tail_tip = TailCarapace.addOrReplaceChild("Tail_tip", CubeListBuilder.create().texOffs(87, 105).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 15.0F, 0.1499F, 0.0F, 0.0F));

		PartDefinition Tail_tip_1 = Tail_tip.addOrReplaceChild("Tail_tip_1", CubeListBuilder.create().texOffs(0, 102).addBox(0.0F, -1.0F, -3.0F, 0.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail_tip_2 = Tail_tip_1.addOrReplaceChild("Tail_tip_2", CubeListBuilder.create().texOffs(3, 105).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Tail_base = TailCarapace.addOrReplaceChild("Tail_base", CubeListBuilder.create().texOffs(0, 77).addBox(-3.5F, 0.0F, -1.0F, 7.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail_base_1 = Tail_base.addOrReplaceChild("Tail_base_1", CubeListBuilder.create().texOffs(8, 77).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition Back_spikes = ASS.addOrReplaceChild("Back_spikes", CubeListBuilder.create().texOffs(40, 64).addBox(-8.5F, 0.0F, -0.5F, 16.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 1.0F));

		PartDefinition Belly = ASS.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -2.5F, -10.0F, 8.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -1.0F));

		PartDefinition Belly_spikes = Belly.addOrReplaceChild("Belly_spikes", CubeListBuilder.create().texOffs(31, 53).addBox(-9.5F, -2.5F, -11.0F, 19.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition Belly_1 = Belly.addOrReplaceChild("Belly_1", CubeListBuilder.create().texOffs(86, 51).addBox(-4.5F, 0.0F, -6.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition Neck = Belly.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(47, 1).addBox(0.0F, -0.5F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -9.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition NeckCarapace = Neck.addOrReplaceChild("NeckCarapace", CubeListBuilder.create().texOffs(127, 1).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck_spikes = Neck.addOrReplaceChild("Neck_spikes", CubeListBuilder.create().texOffs(55, 48).addBox(-4.5F, 0.0F, -4.0F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -2.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(65, 11).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(67, 1).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition Head_1 = Head.addOrReplaceChild("Head_1", CubeListBuilder.create().texOffs(66, 26).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Dentary = Head_1.addOrReplaceChild("Dentary", CubeListBuilder.create().texOffs(69, 20).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -0.0017F, 0.0F));

		PartDefinition Thoracic_Carapace = Belly.addOrReplaceChild("Thoracic_Carapace", CubeListBuilder.create().texOffs(84, 25).addBox(-4.5F, 0.0F, -11.0F, 9.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 1.0F));

		PartDefinition Sacral_Carapace = ASS.addOrReplaceChild("Sacral_Carapace", CubeListBuilder.create().texOffs(84, 0).addBox(-6.5F, -4.0F, 0.0F, 13.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Vertebrae = ASS.addOrReplaceChild("Vertebrae", CubeListBuilder.create().texOffs(102, 23).addBox(0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Leg_L_1 = partdefinition.addOrReplaceChild("Leg_L_1", CubeListBuilder.create().texOffs(2, 48).mirror().addBox(-5.0F, 0.0F, -2.0F, 5.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 9.0F, 10.0F));

		PartDefinition Leg_L_2 = Leg_L_1.addOrReplaceChild("Leg_L_2", CubeListBuilder.create().texOffs(24, 51).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.9F, 8.0F, 1.0F));

		PartDefinition Feet_L = Leg_L_2.addOrReplaceChild("Feet_L", CubeListBuilder.create().texOffs(0, 61).addBox(-2.2F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 160, 160);
	}

	@Override
	public void setupAnim(DesmatosuchusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Arm_L.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_R.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_L_1_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ASS.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_L_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}