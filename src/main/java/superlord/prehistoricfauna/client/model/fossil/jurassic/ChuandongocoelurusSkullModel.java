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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ChuandongocoelurusSkull;

public class ChuandongocoelurusSkullModel extends EntityModel<ChuandongocoelurusSkull> {
	private final ModelPart Head;

	public ChuandongocoelurusSkullModel(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(63, 39).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(61, 27).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(63, 52).addBox(-1.0F, 3.0F, -7.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 19.0F, 1.75F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(63, 46).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(39, 25).addBox(-1.0F, 0.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(24, 29).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 3.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 79, 62);
	}

	@Override
	public void setupAnim(ChuandongocoelurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}