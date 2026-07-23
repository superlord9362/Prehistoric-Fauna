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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.YangchuanosaurusSkull;

public class YangchuanosaurusSkullModel extends EntityModel<YangchuanosaurusSkull> {
	private final ModelPart skull;

	public YangchuanosaurusSkullModel(ModelPart root) {
		this.skull = root.getChild("skull");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition skull = partdefinition.addOrReplaceChild("skull", CubeListBuilder.create(), PartPose.offset(0.0F, 12.807F, 6.5F));

		PartDefinition bone19 = skull.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(55, 77).addBox(-4.0F, -9.01F, -7.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(15, 27).addBox(-2.5F, -9.01F, -19.0F, 5.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(81, 67).addBox(-2.5F, -1.01F, -19.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition cube_r1 = bone19.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(86, 36).mirror().addBox(-0.5F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -9.01F, -7.0F, 0.0F, 0.0F, -0.2094F));

		PartDefinition cube_r2 = bone19.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 36).addBox(-1.5F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.01F, -7.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition jaw = skull.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(66, 34).addBox(-3.0F, 0.0F, -6.99F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(134, 38).addBox(-2.0F, -1.0F, -18.99F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 170, 154);
	}

	@Override
	public void setupAnim(YangchuanosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}