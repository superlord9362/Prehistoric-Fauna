package superlord.prehistoricfauna.client.model.fish;

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
import superlord.prehistoricfauna.common.entity.fish.Lonchidion;

public class LonchidionModel extends EntityModel<Lonchidion> {
	private final ModelPart Belly;
	private final ModelPart Belly_2;
	private final ModelPart Tail;
	private final ModelPart Tail_f;
	private final ModelPart Pectoral_f;
	private final ModelPart Pectoral_f_1;

	public LonchidionModel(ModelPart root) {
		this.Belly = root.getChild("Belly");
		this.Belly_2 = Belly.getChild("Belly_2");
		this.Tail = Belly_2.getChild("Tail");
		this.Tail_f = Tail.getChild("Tail_f");
		this.Pectoral_f = Belly.getChild("Pectoral_f");
		this.Pectoral_f_1 = Belly.getChild("Pectoral_f_1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Belly = partdefinition.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, -3.0F, 0.0F, 0.0F, 0.0017F));

		PartDefinition head = Belly.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition JawV = head.addOrReplaceChild("JawV", CubeListBuilder.create().texOffs(10, 11).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Belly_2 = Belly.addOrReplaceChild("Belly_2", CubeListBuilder.create().texOffs(16, 2).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition Tail = Belly_2.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(13, 1).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition Tail_f = Tail.addOrReplaceChild("Tail_f", CubeListBuilder.create().texOffs(24, 5).addBox(0.0F, -3.0F, -0.5F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition Dorsal_f_2 = Belly_2.addOrReplaceChild("Dorsal_f_2", CubeListBuilder.create().texOffs(28, 2).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Anal_f = Belly_2.addOrReplaceChild("Anal_f", CubeListBuilder.create().texOffs(29, 6).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Dorsal_f = Belly.addOrReplaceChild("Dorsal_f", CubeListBuilder.create().texOffs(26, -3).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Pectoral_f = Belly.addOrReplaceChild("Pectoral_f", CubeListBuilder.create().texOffs(8, 9).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.5F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Pectoral_f_1 = Belly.addOrReplaceChild("Pectoral_f_1", CubeListBuilder.create().texOffs(8, 9).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.5F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Pelvic_f = Belly.addOrReplaceChild("Pelvic_f", CubeListBuilder.create().texOffs(14, 9).mirror().addBox(-2.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 3.0F, 4.0F, 0.0F, 0.3491F, -0.2618F));

		PartDefinition Pelvic_f_1 = Belly.addOrReplaceChild("Pelvic_f_1", CubeListBuilder.create().texOffs(14, 9).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.0F, 4.0F, 0.0F, -0.3491F, 0.2618F));

		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void setupAnim(Lonchidion entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.Belly.y = 24;
			this.Belly.zRot = 1.6F;
		} else {
			this.Belly.zRot = 0;
			this.Belly.y = 22;
		}
        this.Belly.xRot = headPitch * ((float)Math.PI / 180F);
        this.Belly.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Belly_2.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
        this.Tail.yRot = -f * 0.225F * Mth.sin(0.3F * ageInTicks);
        this.Tail_f.yRot = -f * 0.1125F * Mth.sin(0.15F * ageInTicks);
		this.Pectoral_f_1.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + 0.4363F;
		this.Pectoral_f.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) - 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Belly.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
