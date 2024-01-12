package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Palaeosaniwa;

public class PalaeosaniwaModel extends EntityModel<Palaeosaniwa> {
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart head;

	public PalaeosaniwaModel(ModelPart root) {
		this.body = root.getChild("body");
		this.body2 = body.getChild("body2");
		this.tail1 = body2.getChild("tail1");
		this.tail2 = tail1.getChild("tail2");
		this.leg1 = body.getChild("leg1");
		this.leg2 = body.getChild("leg2");
		this.leg3 = body2.getChild("leg3");
		this.leg4 = body2.getChild("leg4");
		this.head = body.getChild("head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -5.0F, -5.0F, 7.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -4.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -2.0F, 0.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(-0.01F)), PartPose.offset(-0.5F, -3.0F, 5.0F));

		PartDefinition tail1 = body2.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(16, 21).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, 8.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(26, 45).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition leg3 = body2.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(27, 41).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(33, 0).addBox(-3.5F, 5.0F, -3.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 1.0F, 5.5F));

		PartDefinition leg4 = body2.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(17, 41).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(33, 16).addBox(-1.5F, 5.0F, -3.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 1.0F, 5.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 31).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -5.0F));

		PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(34, 21).addBox(-5.0F, -7.0F, -8.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 3.0F, 0.0F));

		PartDefinition tongue = snout.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(6, 45).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -4.0F, -5.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(27, 41).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(25, 36).addBox(-3.5F, 5.0F, -3.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.0F, -3.25F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(17, 41).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(15, 36).addBox(-1.5F, 5.0F, -3.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.0F, -3.25F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Palaeosaniwa entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			setSleepingPose();
		}
		if (!entity.isAsleep()) {
			float speed = 1.0f;
			float degree = 1.0f;
			this.head.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) +  + (Mth.cos(limbSwing * speed) * degree * 0.1F * limbSwingAmount);
			this.head.yRot = (Mth.cos(limbSwing * speed) * degree * 0.1F * limbSwingAmount);
			this.body2.yRot = (Mth.cos(limbSwing * speed) * degree * 0.1F * limbSwingAmount);
			this.tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + -(Mth.cos(limbSwing * speed) * degree * 0.1F * limbSwingAmount);
			this.tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
			this.leg4.xRot = Mth.cos(limbSwing * speed) * degree * 0.5F * limbSwingAmount;
			this.leg4.zRot = -Math.abs(Mth.cos(limbSwing * speed) * degree * 0.5F * limbSwingAmount);
			this.leg3.xRot = Mth.cos(4.0F + limbSwing * speed) * degree * 0.5F * limbSwingAmount;
			this.leg3.zRot = Math.abs(Mth.cos(4.0F + limbSwing * speed) * degree * 0.5F * limbSwingAmount);
			this.leg2.xRot = Mth.cos(4.0F + limbSwing * speed) * degree * 0.5F * limbSwingAmount;
			this.leg2.zRot = -Math.abs(Mth.cos(4.0F + limbSwing * speed) * degree * 0.5F * limbSwingAmount);
			this.leg1.xRot = Mth.cos(limbSwing * speed) * degree * 0.5F * limbSwingAmount;
			this.leg1.zRot = Math.abs(Mth.cos(limbSwing * speed) * degree * 0.5F * limbSwingAmount);
			if (entity.isInWater()) {
				this.body.y = 17.2F;
				this.leg1.xRot = 1.25F;
				this.leg1.yRot = 0.25F;
				this.leg2.xRot = 1.25F;
				this.leg2.yRot = -0.25F;
				this.leg3.xRot = 1.25F;
				this.leg3.yRot = -0.25F + (0.25F * Mth.sin(0.25F * ageInTicks / 1F));
				this.leg4.xRot = 1.25F;
				this.leg4.yRot = 0.25F + (0.25F * Mth.sin(0.25F * ageInTicks / 1F));
				this.body2.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
				this.tail1.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
				this.tail2.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
			}
		}
	}

	public void resetModel() {
		this.body.y = 21F;
		this.body2.yRot = 0.0F;
		this.body2.zRot = 0.0F;
		this.body2.xRot = 0.0F;
		this.tail1.xRot = -0.3054F;
		this.tail1.yRot = 0.0F;
		this.tail2.xRot = 0.3054F;
		this.tail2.yRot = 0.0F;
		this.leg3.y = 1.0F;
		this.leg3.xRot = 0.0F;
		this.leg3.zRot = 0.0F;
		this.leg4.y = 1.0F;
		this.leg4.xRot = 0.0F;
		this.leg4.zRot = 0.0F;
		this.head.xRot = 0.0F;
		this.head.yRot = 0.0F;
		this.leg1.y = -2.0F;
		this.leg1.xRot = 0.0F;
		this.leg1.zRot = 0.0F;
		this.leg2.y = -2.0F;
		this.leg2.xRot = 0.0F;
		this.leg2.yRot = 0.0F;
		this.leg1.zRot = 0.0F;
		this.leg2.zRot = 0.0F;
		this.leg3.zRot = 0.0F;
		this.leg4.zRot = 0.0F;
	}

	public void setSleepingPose() {
		this.body.y = 23F;
		this.body2.yRot = -0.1309F;
		this.tail1.xRot = 0F;
		this.tail1.yRot = -0.3491F;
		this.tail2.xRot = 0F;
		this.tail2.yRot = -0.3054F;
		this.leg3.y = 3.0F;
		this.leg3.xRot = 0.3054F;
		this.leg3.zRot = 1.5708F;
		this.leg4.y = 3.0F;
		this.leg4.xRot = 0.3054F;
		this.leg4.zRot = -1.5708F;
		this.head.xRot = 0.7418F;
		this.head.yRot = 0.3491F;
		this.leg1.y = 0.0F;
		this.leg1.xRot = -0.3491F;
		this.leg1.zRot = 1.5708F;
		this.leg2.y = 0.0F;
		this.leg2.xRot = -0.3491F;
		this.leg2.zRot = -1.5708F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}