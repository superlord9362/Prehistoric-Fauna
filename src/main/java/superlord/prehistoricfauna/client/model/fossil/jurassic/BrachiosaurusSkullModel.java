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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.BrachiosaurusSkull;

public class BrachiosaurusSkullModel extends EntityModel<BrachiosaurusSkull> {
	private final ModelPart skull;

	public BrachiosaurusSkullModel(ModelPart root) {
		this.skull = root.getChild("skull");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition skull = partdefinition.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(146, 227).addBox(-4.5F, -8.05F, -1.0F, 9.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(112, 226).addBox(-3.0F, -2.05F, -12.0F, 6.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(108, 257).addBox(-3.0F, -0.05F, -12.05F, 6.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(146, 255).addBox(-2.0F, -10.05F, -8.0F, 4.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 3.0F));

		PartDefinition jaw = skull.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(146, 243).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(112, 241).addBox(-2.5F, 0.0F, -18.0F, 5.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.025F, 6.1F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(BrachiosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
