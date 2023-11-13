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
import superlord.prehistoricfauna.common.entity.fish.Acipenser;

public class AcipenserModel extends EntityModel<Acipenser> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart TailFin;
	private final ModelPart FinR;
	private final ModelPart FinL;

	public AcipenserModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.FinR = Body.getChild("FinR");
		this.FinL = Body.getChild("FinL");
		this.Tail = Body.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.TailFin = Tail2.getChild("TailFin");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -9.0F));

		PartDefinition Nose = Body.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(3, 25).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Whiskers = Nose.addOrReplaceChild("Whiskers", CubeListBuilder.create().texOffs(0, 2).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 8.0F));

		PartDefinition TailFin = Tail2.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition Dorsal = Tail2.addOrReplaceChild("Dorsal", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition AnalFins = Tail.addOrReplaceChild("AnalFins", CubeListBuilder.create().texOffs(13, 26).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 2.0F));

		PartDefinition FinR = Body.addOrReplaceChild("FinR", CubeListBuilder.create().texOffs(-2, 0).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 3.0F, 3.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition FinL = Body.addOrReplaceChild("FinL", CubeListBuilder.create().texOffs(-2, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.0F, 3.0F, 0.0F, 0.0F, 0.3491F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Acipenser entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.Body.y = 24;
			this.Body.zRot = 1.6F;
		} else {
			this.Body.zRot = 0;
			this.Body.y = 22;
		}
        this.Body.xRot = headPitch * ((float)Math.PI / 180F);
        this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Tail.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
        this.Tail2.yRot = -f * 0.225F * Mth.sin(0.3F * ageInTicks);
        this.TailFin.yRot = -f * 0.1125F * Mth.sin(0.15F * ageInTicks);
		this.FinL.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + 0.4363F;
		this.FinR.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) - 0.4363F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}