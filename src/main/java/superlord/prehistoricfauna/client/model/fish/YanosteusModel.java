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
import superlord.prehistoricfauna.common.entity.fish.Yanosteus;

public class YanosteusModel extends EntityModel<Yanosteus> {
	private final ModelPart head;
	private final ModelPart Back;
	private final ModelPart tail;
	private final ModelPart pectoral_f_l;
	private final ModelPart pectoral_f_r;

	public YanosteusModel(ModelPart root) {
		this.head = root.getChild("head");
		this.Back = head.getChild("Back");
		this.tail = Back.getChild("tail");
		this.pectoral_f_l = head.getChild("pectoral_f_l");
		this.pectoral_f_r = head.getChild("pectoral_f_r");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition snoot = head.addOrReplaceChild("snoot", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition whiskers = snoot.addOrReplaceChild("whiskers", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

		PartDefinition Back = head.addOrReplaceChild("Back", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition tail = Back.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(10, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, 6.0F));

		PartDefinition Tail_f = tail.addOrReplaceChild("Tail_f", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition Dorsal_f = Back.addOrReplaceChild("Dorsal_f", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -2.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pelvic_f_l = Back.addOrReplaceChild("pelvic_f_l", CubeListBuilder.create().texOffs(8, 10).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition pelvic_f_r = Back.addOrReplaceChild("pelvic_f_r", CubeListBuilder.create().texOffs(8, 10).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition pectoral_f_l = head.addOrReplaceChild("pectoral_f_l", CubeListBuilder.create().texOffs(8, 8).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.0F, -3.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition pectoral_f_r = head.addOrReplaceChild("pectoral_f_r", CubeListBuilder.create().texOffs(8, 8).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, -3.0F, 0.0F, 0.0F, 0.3491F));

		return LayerDefinition.create(meshdefinition, 16, 32);
	}

	@Override
	public void setupAnim(Yanosteus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.head.y = 24;
			this.head.zRot = 1.6F;
		} else {
			this.head.zRot = 0;
			this.head.y = 22;
		}
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netheadYaw * ((float)Math.PI / 180F);
        this.Back.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
        this.tail.yRot = -f * 0.225F * Mth.sin(0.3F * ageInTicks);
		this.pectoral_f_l.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + 0.4363F;
		this.pectoral_f_r.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) - 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}