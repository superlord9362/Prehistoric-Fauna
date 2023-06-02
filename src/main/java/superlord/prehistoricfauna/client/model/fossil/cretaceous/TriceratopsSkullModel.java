package superlord.prehistoricfauna.client.model.fossil.cretaceous;

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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TriceratopsSkull;

public class TriceratopsSkullModel extends EntityModel<TriceratopsSkull> {
	private final ModelPart Head1;

	public TriceratopsSkullModel(ModelPart root) {
		this.Head1 = root.getChild("Head1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head1 = partdefinition.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 130).addBox(-6.0F, -3.0F, -12.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 8.0F));

		PartDefinition horn1 = Head1.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(60, 165).addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -1.0F, -12.0F, -0.7285F, 0.182F, 0.0F));

		PartDefinition horn1_1 = Head1.addOrReplaceChild("horn1_1", CubeListBuilder.create().texOffs(60, 165).addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9F, -1.0F, -12.0F, -0.7285F, -0.182F, 0.0F));

		PartDefinition Crest = Head1.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(58, 127).addBox(-14.0F, -23.0F, -5.0F, 28.0F, 25.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -3.0F, -0.5918F, 0.0F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 169).addBox(-4.0F, 0.0F, -14.0F, 8.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -12.0F));

		PartDefinition nasalhorn = Snout.addOrReplaceChild("nasalhorn", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -12.0F, 0.6374F, 0.0F, 0.0F));

		PartDefinition Beak = Snout.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(0, 204).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -14.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(TriceratopsSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
