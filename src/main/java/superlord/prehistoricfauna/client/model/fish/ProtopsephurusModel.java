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
import superlord.prehistoricfauna.common.entity.fish.Protopsephurus;

public class ProtopsephurusModel extends EntityModel<Protopsephurus> {
	private final ModelPart Head;
	private final ModelPart Belly;
	private final ModelPart Tail;
	private final ModelPart Pectoral_f_l;
	private final ModelPart Pectoral_f_r;

	public ProtopsephurusModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Belly = Head.getChild("Belly");
		this.Tail = Belly.getChild("Tail");
		this.Pectoral_f_l = Head.getChild("Pectoral_f_l");
		this.Pectoral_f_r = Head.getChild("Pectoral_f_r");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -4.0F));

		PartDefinition Belly = Head.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition Tail = Belly.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition Tail_f = Tail.addOrReplaceChild("Tail_f", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.0F));

		PartDefinition Dorsal_f = Tail.addOrReplaceChild("Dorsal_f", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Anal_f = Belly.addOrReplaceChild("Anal_f", CubeListBuilder.create().texOffs(4, 14).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 6.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Pelvic_f = Belly.addOrReplaceChild("Pelvic_f", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 4.0F));

		PartDefinition Paddle_base = Head.addOrReplaceChild("Paddle_base", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Paddle_tip = Paddle_base.addOrReplaceChild("Paddle_tip", CubeListBuilder.create().texOffs(19, 3).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Mouthinside = Head.addOrReplaceChild("Mouthinside", CubeListBuilder.create().texOffs(10, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Gill_plate = Head.addOrReplaceChild("Gill_plate", CubeListBuilder.create().texOffs(20, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition Pectoral_f_l = Head.addOrReplaceChild("Pectoral_f_l", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 3.0F, 2.0F, 0.0F, 0.4363F, -0.7854F));

		PartDefinition Pectoral_f_r = Head.addOrReplaceChild("Pectoral_f_r", CubeListBuilder.create().texOffs(8, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.0F, 2.0F, 0.0F, -0.4363F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Protopsephurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.Head.y = 24;
			this.Head.zRot = 1.6F;
		} else {
			this.Head.zRot = 0;
			this.Head.y = 20;
		}
        this.Head.xRot = headPitch * ((float)Math.PI / 180F);
        this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Belly.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
        this.Tail.yRot = -f * 0.225F * Mth.sin(0.3F * ageInTicks);
		this.Pectoral_f_l.zRot = (-Math.abs(-0.45F * Mth.sin(0.2F * ageInTicks))) - 0.4363F;
		this.Pectoral_f_r.zRot = (Math.abs(-0.45F * Mth.sin(0.2F * ageInTicks))) + 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}