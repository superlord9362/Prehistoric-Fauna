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
import superlord.prehistoricfauna.common.entity.fish.Melvius;

public class MelviusModel extends EntityModel<Melvius> {
	private final ModelPart Body;
	private final ModelPart Body_back;

	public MelviusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Body_back = Body.getChild("Body_back");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -5.0F));

		PartDefinition Body_back = Body.addOrReplaceChild("Body_back", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition Tail = Body_back.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition Tail_f = Tail.addOrReplaceChild("Tail_f", CubeListBuilder.create().texOffs(25, 18).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Dorsal_f = Body_back.addOrReplaceChild("Dorsal_f", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Pelvic_f = Body_back.addOrReplaceChild("Pelvic_f", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(15, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition Jaw = head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(30, 2).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition whiskers = head.addOrReplaceChild("whiskers", CubeListBuilder.create().texOffs(0, 1).addBox(-1.4F, 0.0F, -1.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Pectoral_f = Body.addOrReplaceChild("Pectoral_f", CubeListBuilder.create().texOffs(23, 6).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.0F, -2.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Pectoral_f_1 = Body.addOrReplaceChild("Pectoral_f_1", CubeListBuilder.create().texOffs(30, 6).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 1.0F, -2.0F, 0.0F, 0.4363F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Melvius entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
			this.Body.y = 24;
			this.Body.zRot = 1.6F;
		} else {
			this.Body.zRot = 0;
			this.Body.y = 20;
		}
        this.Body.xRot = headPitch * ((float)Math.PI / 180F);
        this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Body_back.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}