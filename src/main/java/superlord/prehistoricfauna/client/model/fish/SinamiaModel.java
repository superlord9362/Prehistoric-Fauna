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
import superlord.prehistoricfauna.common.entity.fish.Sinamia;

public class SinamiaModel extends EntityModel<Sinamia> {
	private final ModelPart Head;
	private final ModelPart Back;
	private final ModelPart Pectoral_f_l;
	private final ModelPart Pectoral_f_r;

	public SinamiaModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Back = Head.getChild("Back");
		this.Pectoral_f_l = Head.getChild("Pectoral_f_l");
		this.Pectoral_f_r = Head.getChild("Pectoral_f_r");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -3.0F));

		PartDefinition Back = Head.addOrReplaceChild("Back", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition part3 = Back.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 5.0F));

		PartDefinition Pelvic_f = Back.addOrReplaceChild("Pelvic_f", CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition part6 = Back.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(8, -4).addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Pectoral_f_l = Head.addOrReplaceChild("Pectoral_f_l", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(-1.5F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.0F, 1.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Pectoral_f_r = Head.addOrReplaceChild("Pectoral_f_r", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.4363F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Sinamia entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.Head.y = 24;
			this.Head.zRot = 1.6F;
		} else {
			this.Head.zRot = 0;
			this.Head.y = 22;
		}
        this.Head.xRot = headPitch * ((float)Math.PI / 180F);
        this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Back.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
		this.Pectoral_f_l.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + 0.4363F;
		this.Pectoral_f_r.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) - 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
