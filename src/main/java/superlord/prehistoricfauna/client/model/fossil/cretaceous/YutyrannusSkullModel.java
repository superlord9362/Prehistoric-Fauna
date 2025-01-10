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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.YutyrannusSkull;

public class YutyrannusSkullModel extends EntityModel<YutyrannusSkull> {
	private final ModelPart Skull;

	public YutyrannusSkullModel(ModelPart root) {
		this.Skull = root.getChild("Skull");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Skull = partdefinition.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(111, 15).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(111, 30).addBox(-3.0F, 5.0F, -5.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 7.5F));

		PartDefinition Jaw1 = Skull.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(111, 39).addBox(-2.5F, 0.01F, -4.9F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(135, 33).addBox(-1.5F, -0.99F, -14.9F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Snout = Skull.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(135, 6).addBox(-2.0F, -1.0F, -10.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -5.0F));

		PartDefinition NasalCrest = Snout.addOrReplaceChild("NasalCrest", CubeListBuilder.create().texOffs(160, 6).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(161, 35).addBox(-2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -12.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(111, 52).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(111, 52).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(YutyrannusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}