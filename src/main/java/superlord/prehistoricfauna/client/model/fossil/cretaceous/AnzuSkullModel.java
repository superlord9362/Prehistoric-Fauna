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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnzuSkull;

@SuppressWarnings("unused")
public class AnzuSkullModel extends EntityModel<AnzuSkull> {
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart Jaw;
	private final ModelPart crest;

	public AnzuSkullModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Snout = this.Head.getChild("Snout");
		this.Jaw = this.Head.getChild("Jaw");
		this.crest = this.Head.getChild("crest");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 101).addBox(-1.5F, -1.0F, -6.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 5.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(21, 104).addBox(-1.0F, -37.0F, -39.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(8, 103).addBox(-1.0F, -36.0F, -39.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 39.0F, 29.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(1, 111).addBox(-1.5F, 0.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 3.0F, 0.0F));

		PartDefinition crest = Head.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(38, 95).addBox(0.0F, -44.0F, -38.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 38.0F, 29.0F));

		return LayerDefinition.create(meshdefinition, 150, 124);
	}

	@Override
	public void setupAnim(AnzuSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}