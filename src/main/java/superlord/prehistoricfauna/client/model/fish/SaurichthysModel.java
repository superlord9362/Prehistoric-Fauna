package superlord.prehistoricfauna.client.model.fish;

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
import net.minecraft.util.Mth;
import superlord.prehistoricfauna.common.entity.fish.Saurichthys;

public class SaurichthysModel extends EntityModel<Saurichthys> {
	private final ModelPart Body;
	private final ModelPart BodyBack;

	public SaurichthysModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BodyBack = Body.getChild("BodyBack");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -6.0F));

		PartDefinition BodyBack = Body.addOrReplaceChild("BodyBack", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition DorsalAnalfins = BodyBack.addOrReplaceChild("DorsalAnalfins", CubeListBuilder.create().texOffs(23, 3).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition Tailfin = BodyBack.addOrReplaceChild("Tailfin", CubeListBuilder.create().texOffs(23, -5).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition LeftPelvicfin = BodyBack.addOrReplaceChild("LeftPelvicfin", CubeListBuilder.create().texOffs(22, 11).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 2.0F));

		PartDefinition RightPelvicfin = BodyBack.addOrReplaceChild("RightPelvicfin", CubeListBuilder.create().texOffs(22, 11).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, 2.0F));

		PartDefinition LeftPectoralfin = Body.addOrReplaceChild("LeftPectoralfin", CubeListBuilder.create().texOffs(21, 10).addBox(0.0F, 0.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 25).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition RightPectoralFin = Body.addOrReplaceChild("RightPectoralFin", CubeListBuilder.create().texOffs(21, 10).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		return LayerDefinition.create(meshdefinition, 48, 36);
	}

	@Override
	public void setupAnim(Saurichthys entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
			this.Body.y = 23;
			this.Body.zRot = 1.6F;
		} else {
			this.Body.zRot = 0;
			this.Body.y = 23;
		}
        this.Body.xRot = headPitch * ((float)Math.PI / 180F);
        this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.BodyBack.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}