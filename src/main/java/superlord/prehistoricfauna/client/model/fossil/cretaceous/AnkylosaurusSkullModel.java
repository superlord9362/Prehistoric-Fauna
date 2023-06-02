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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnkylosaurusSkull;

public class AnkylosaurusSkullModel extends EntityModel<AnkylosaurusSkull> {
	private final ModelPart Head1;

	public AnkylosaurusSkullModel(ModelPart root) {
		this.Head1 = root.getChild("Head1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head1 = partdefinition.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(152, 97).addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 4.0F));

		PartDefinition Head2 = Head1.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(200, 93).addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition Spike4 = Head1.addOrReplaceChild("Spike4", CubeListBuilder.create().texOffs(29, 32).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, -2.0F, 0.0F, 0.9105F, 0.0F));

		PartDefinition Spike1 = Head1.addOrReplaceChild("Spike1", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -3.0F, 0.0F, 0.0911F, -0.2731F, 0.0F));

		PartDefinition Spike3 = Head1.addOrReplaceChild("Spike3", CubeListBuilder.create().texOffs(29, 32).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 2.0F, -2.0F, 0.0F, -0.9105F, 0.0F));

		PartDefinition Spike1_1 = Head1.addOrReplaceChild("Spike1_1", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -3.0F, 0.0F, 0.0911F, 0.2731F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(AnkylosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
