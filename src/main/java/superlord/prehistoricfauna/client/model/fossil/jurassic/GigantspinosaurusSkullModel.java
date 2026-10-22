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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.GigantspinosaurusSkull;

@SuppressWarnings("unused")
public class GigantspinosaurusSkullModel extends EntityModel<GigantspinosaurusSkull> {
	private final ModelPart root;
	private final ModelPart Head;

	public GigantspinosaurusSkullModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Head = this.root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.25F, 9.0F));

		PartDefinition Head = root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(112, 91).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(112, 84).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -3.25F, -5.5F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(GigantspinosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
