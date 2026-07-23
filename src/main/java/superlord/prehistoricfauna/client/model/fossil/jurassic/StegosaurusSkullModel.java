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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.StegosaurusSkull;

@SuppressWarnings("unused")
public class StegosaurusSkullModel extends EntityModel<StegosaurusSkull> {
	private final ModelPart Head;
	private final ModelPart Jaw;

	public StegosaurusSkullModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(91, 0).addBox(-3.5F, -1.5F, -9.0F, 7.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(98, 0).addBox(-3.5F, 2.5F, -9.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(91, 14).addBox(-2.0F, -1.5F, -15.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.5F, 6.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(91, 24).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(91, 36).addBox(-2.0F, 0.0F, -14.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -1.0F));

		return LayerDefinition.create(meshdefinition, 256, 148);
	}

	@Override
	public void setupAnim(StegosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
