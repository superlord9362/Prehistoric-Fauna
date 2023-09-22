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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TyrannosaurusSkull;

public class TyrannosaurusSkullModel extends EntityModel<TyrannosaurusSkull> {
	private final ModelPart Head1;

	public TyrannosaurusSkullModel(ModelPart root) {
		this.Head1 = root.getChild("Head1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head1 = partdefinition.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 157).addBox(-7.0F, -4.0F, -9.99F, 14.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 10.0F, 6.99F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(0, 186).addBox(-7.0F, -1.01F, -9.99F, 14.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.01F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(4, 211).addBox(-3.0F, -1.01F, -13.99F, 6.0F, 7.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -11.0F));

		PartDefinition Jaw3 = Jaw1.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(47, 181).addBox(-5.5F, 0.99F, -16.99F, 11.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(57, 150).addBox(-3.5F, 0.0F, -14.99F, 7.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition Snout_1 = Snout.addOrReplaceChild("Snout_1", CubeListBuilder.create().texOffs(57, 131).addBox(-3.5F, 0.0F, -14.99F, 7.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(TyrannosaurusSkull entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
