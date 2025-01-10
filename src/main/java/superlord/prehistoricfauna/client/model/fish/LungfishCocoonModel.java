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
import net.minecraft.world.entity.Entity;

public class LungfishCocoonModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart cacoon;

	public LungfishCocoonModel(ModelPart root) {
		this.cacoon = root.getChild("cacoon");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cacoon = partdefinition.addOrReplaceChild("cacoon", CubeListBuilder.create().texOffs(1, 0).addBox(-3.5F, -2.5F, -7.0F, 7.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, 0.0F));

		PartDefinition body = cacoon.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -3.0F, 3.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offset(-1.2F, 1.0F, -7.0F));

		PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(26, 30).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition middle = body.addOrReplaceChild("middle", CubeListBuilder.create().texOffs(14, 30).addBox(-0.7F, -3.0F, -1.7F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition fin = middle.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offsetAndRotation(1.2F, -2.0F, 0.3F, 0.0F, 1.2217F, 0.0F));

		PartDefinition cube_r1 = fin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 23).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -2.6382F, 1.2204F, -2.6113F));

		PartDefinition fin2 = middle.addOrReplaceChild("fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.2F, -2.0F, -1.7F, 0.0F, 2.5307F, 0.0F));

		PartDefinition cube_r2 = fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(34, 25).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 2.1817F, 0.0F));

		PartDefinition bone2 = middle.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 29).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 19).addBox(0.0F, -0.6F, 0.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, -2.4F, -1.0F, 3.055F, -0.044F, 3.134F));

		PartDefinition bone3 = body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(34, 19).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.0F, 6.2F, -0.3925F, 1.2393F, -0.4127F));

		PartDefinition bone5 = body.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(34, 21).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 6.3F, -2.0627F, 0.9909F, -1.9922F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cacoon.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}