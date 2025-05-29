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
import superlord.prehistoricfauna.common.entity.fish.Lepidotes;

@SuppressWarnings("unused")
public class LepidotesModel extends EntityModel<Lepidotes> {
	private final ModelPart body;
	private final ModelPart dorsal_f;
	private final ModelPart pectoral_f_l;
	private final ModelPart pectoral_f_r;
	private final ModelPart tail;
	private final ModelPart tail_f;
	private final ModelPart pelvic_f_l;
	private final ModelPart pelvic_f_r;

	public LepidotesModel(ModelPart root) {
		this.body = root.getChild("body");
		this.dorsal_f = this.body.getChild("dorsal_f");
		this.pectoral_f_l = this.body.getChild("pectoral_f_l");
		this.pectoral_f_r = this.body.getChild("pectoral_f_r");
		this.tail = this.body.getChild("tail");
		this.tail_f = this.tail.getChild("tail_f");
		this.pelvic_f_l = this.body.getChild("pelvic_f_l");
		this.pelvic_f_r = this.body.getChild("pelvic_f_r");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(0, 1).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 1).addBox(0.0F, 2.0F, 6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -4.0F));

		PartDefinition dorsal_f = body.addOrReplaceChild("dorsal_f", CubeListBuilder.create().texOffs(28, -2).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 5.0F));

		PartDefinition pectoral_f_l = body.addOrReplaceChild("pectoral_f_l", CubeListBuilder.create().texOffs(14, 17).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition pectoral_f_r = body.addOrReplaceChild("pectoral_f_r", CubeListBuilder.create().texOffs(14, 14).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(13, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition tail_f = tail.addOrReplaceChild("tail_f", CubeListBuilder.create().texOffs(26, 3).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition pelvic_f_l = body.addOrReplaceChild("pelvic_f_l", CubeListBuilder.create().texOffs(29, 12).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, 3.0F, 4.0F));

		PartDefinition pelvic_f_r = body.addOrReplaceChild("pelvic_f_r", CubeListBuilder.create().texOffs(29, 14).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.75F, 3.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Lepidotes entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.body.y = 22;
			this.body.zRot = 1.6F;
		} else {
			this.body.zRot = 0;
			this.body.y = 20;
		}
        this.body.xRot = headPitch * ((float)Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.body.yRot = -f * 0.1F * Mth.sin(0.3F * ageInTicks);
        this.tail.yRot = -f * 0.25F * Mth.sin(0.3F * ageInTicks);
        this.tail_f.yRot = -f * 0.15F * Mth.sin(0.3F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}