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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.KayentavenatorSkull;

public class KayentavenatorSkullModel extends EntityModel<KayentavenatorSkull> {
	private final ModelPart Head;

	public KayentavenatorSkullModel(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 63).addBox(-1.5F, -0.9882F, -10.0019F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(20, 72).addBox(-1.5F, 2.0118F, -10.0019F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.001F))
				.texOffs(2, 54).addBox(-2.0F, -0.9882F, -3.0019F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 5.0009F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(19, 56).addBox(-2.0F, 2.649F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.1372F, -6.7519F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(27, 82).addBox(-1.5F, -1.001F, -32.2509F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(1, 85).addBox(-2.5F, -0.001F, -25.2509F, 4.0F, 2.0F, 3.0F, new CubeDeformation(-0.001F))
				.texOffs(1, 75).addBox(-1.5F, -0.001F, -32.2509F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.0128F, 22.2491F));

		return LayerDefinition.create(meshdefinition, 104, 90);
	}

	@Override
	public void setupAnim(KayentavenatorSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
