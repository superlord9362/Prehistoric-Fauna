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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ShunosaurusSkull;

@SuppressWarnings("unused")
public class ShunosaurusSkullModel extends EntityModel<ShunosaurusSkull> {
	private final ModelPart head;
	private final ModelPart Jaw;

	public ShunosaurusSkullModel(ModelPart root) {
		this.head = root.getChild("head");
		this.Jaw = this.head.getChild("Jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 142).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(56, 154).addBox(-3.0F, 3.0F, -4.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(150, 146).addBox(-1.5F, -1.0F, -8.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(152, 152).addBox(-2.0F, 1.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(152, 163).addBox(-2.0F, 3.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.9757F, 3.1505F));

		PartDefinition Jaw = head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(150, 52).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(150, 138).addBox(-1.5F, 0.0F, -9.99F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 192, 192);
	}

	@Override
	public void setupAnim(ShunosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}