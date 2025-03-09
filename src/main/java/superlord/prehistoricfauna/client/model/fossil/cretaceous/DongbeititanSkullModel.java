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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.DongbeititanSkull;

@SuppressWarnings("unused")
public class DongbeititanSkullModel extends EntityModel<DongbeititanSkull> {
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;

	public DongbeititanSkullModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Snout = this.Head.getChild("Snout");
		this.Jaw1 = this.Head.getChild("Jaw1");
		this.Jaw2 = this.Jaw1.getChild("Jaw2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 11).addBox(-3.0F, -5.7223F, -11.1958F, 8.0F, 7.0F, 13.0F, new CubeDeformation(0.01F))
		.texOffs(21, 7).addBox(-2.0F, 1.2777F, -14.1958F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.01F))
		.texOffs(10, 31).addBox(-3.0F, 1.2777F, -11.1958F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(-1.0F, 19.4027F, 6.1958F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, -5.1849F, -0.2011F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.4626F, -13.9947F));

		PartDefinition Jaw1 = Head.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(33, 4).addBox(-3.0F, -1.1849F, -12.7011F, 7.0F, 4.0F, 13.0F, new CubeDeformation(0.01F)), PartPose.offset(0.5F, 1.4626F, 1.5053F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(21, 0).addBox(-4.0F, -4.1849F, -0.7011F, 5.0F, 4.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offset(2.0F, 3.0F, -15.0F));

		return LayerDefinition.create(meshdefinition, 384, 264);
	}

	@Override
	public void setupAnim(DongbeititanSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
