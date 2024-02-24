package superlord.prehistoricfauna.client.model.jurassic.kayenta;

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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Calsoyasuchus;

public class CalsoyasuchusModel extends EntityModel<Calsoyasuchus> {
	private final ModelPart belly;
	private final ModelPart tail;
	private final ModelPart head;
	private final ModelPart FrontR;
	private final ModelPart hand_1;
	private final ModelPart BackR;
	private final ModelPart feet_1;
	private final ModelPart BackL;
	private final ModelPart feet;
	private final ModelPart FrontL;
	private final ModelPart hand;

	public CalsoyasuchusModel(ModelPart root) {
		this.belly = root.getChild("belly");
		this.tail = belly.getChild("tail");
		this.head = belly.getChild("head");
		this.FrontR = root.getChild("FrontR");
		this.hand_1 = FrontR.getChild("hand_1");
		this.BackR = root.getChild("BackR");
		this.feet_1 = BackR.getChild("feet_1");
		this.BackL = root.getChild("BackL");
		this.feet = BackL.getChild("feet");
		this.FrontL = root.getChild("FrontL");
		this.hand = FrontL.getChild("hand");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition belly = partdefinition.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -1.0F));

		PartDefinition tail = belly.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -0.9F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, 7.0F));

		PartDefinition tailspikes = tail.addOrReplaceChild("tailspikes", CubeListBuilder.create().texOffs(14, 18).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition bodyspikes = belly.addOrReplaceChild("bodyspikes", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition head = belly.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, -3.5F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(47, 1).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition FrontR = partdefinition.addOrReplaceChild("FrontR", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 21.0F, -3.0F));

		PartDefinition hand_1 = FrontR.addOrReplaceChild("hand_1", CubeListBuilder.create().texOffs(19, 51).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 3.0F, -1.0F));

		PartDefinition BackR = partdefinition.addOrReplaceChild("BackR", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 21.0F, 4.0F));

		PartDefinition feet_1 = BackR.addOrReplaceChild("feet_1", CubeListBuilder.create().texOffs(13, 52).mirror().addBox(-1.0F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 3.0F, -1.0F));

		PartDefinition BackL = partdefinition.addOrReplaceChild("BackL", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 21.0F, 4.0F));

		PartDefinition feet = BackL.addOrReplaceChild("feet", CubeListBuilder.create().texOffs(13, 52).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.0F, -1.0F));

		PartDefinition FrontL = partdefinition.addOrReplaceChild("FrontL", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 21.0F, -3.0F));

		PartDefinition hand = FrontL.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(19, 51).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 3.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Calsoyasuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//belly
			//this.belly.y = 20.0F;
			if (this.belly.y < 22) this.belly.y += 0.15;
			//FrontR
			//this.FrontR.y = 21.0F;
			if (this.FrontR.y < 23.3) this.FrontR.y += 0.15;
			if (this.FrontR.zRot > -1.1728612040769677F) this.FrontR.zRot -= 0.05;
			//BackR
			//this.BackR.y = 21.0F;
			if (this.BackR.y < 23) this.BackR.y += 0.15;
			if (this.BackR.zRot > -0.9382889765773795F) this.BackR.zRot -= 0.05;
			//FrontL
			//this.FrontL.y = 21.0F;
			if (this.FrontL.y < 23.3) this.FrontL.y += 0.15;
			if (this.FrontL.zRot < 1.0946705281561322F) this.FrontL.zRot += 0.05;
			//BackL
			//this.BackL.y = 21.0F;
			if (this.FrontL.y < 23) this.FrontL.y += 0.15;
			if (this.FrontL.zRot < 0.9382889765773795F) this.FrontL.zRot += 0.05;
			//tail
			//this.tail.xRot = -0.17453292519943295F;
			if (this.tail.xRot < -0.0572467989660713F) this.tail.xRot += 0.05;
			if (this.tail.yRot < 0.3909537457888271F) this.tail.yRot += 0.05;
			//head
			if (this.head.xRot < 0.11728612207217244F) this.head.xRot += 0.05;
			if (this.head.yRot > -0.3909537457888271F) this.head.yRot -= 0.05;
			//hand_1
			if (this.hand_1.zRot < 1.1728612040769677F) this.hand_1.zRot += 0.05;
			//hand
			if (this.hand.zRot > -1.0946705281561322F) this.hand.zRot -= 0.05;
			//feet_1
			if (this.feet_1.zRot < 0.9382889765773795F) this.feet_1.zRot += 0.05;
			//feet
			if (this.feet.zRot > -0.9382889765773795F) this.feet.zRot -= 0.05;
			sleepPose();
		} else {
			resetModel();
			this.tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.BackR.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FrontL.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.BackL.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FrontR.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.head.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (entity.isInWater()) {
				this.hand.xRot = 1.5707963267948966F;
				this.FrontL.xRot = 0.8726646259971648F;
				this.hand_1.xRot = 1.5707963267948966F;
				this.FrontR.xRot = 0.8726646259971648F;
				this.BackL.xRot = 1.0471975511965976F;
				this.BackR.xRot = 1.0471975511965976F;
				this.feet_1.zRot = 1.5707963267948966F;
				this.feet.zRot = -1.5707963267948966F;
				this.tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
				this.belly.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			}
		}
		if (entity.getWakingTicks() < 31) {
			//belly
			//this.belly.y = 20.0F;
			if (this.belly.y > 20) this.belly.y -= 0.15;
			//FrontR
			//this.FrontR.y = 21.0F;
			if (this.FrontR.y > 21) this.FrontR.y -= 0.15;
			if (this.FrontR.zRot < 0) this.FrontR.zRot += 0.05;
			//BackR
			//this.BackR.y = 21.0F;
			if (this.BackR.y > 21) this.BackR.y -= 0.15;
			if (this.BackR.zRot < 0) this.BackR.zRot += 0.05;
			//FrontL
			//this.FrontL.y = 21.0F;
			if (this.FrontL.y > 21) this.FrontL.y -= 0.15;
			if (this.FrontL.zRot > 0) this.FrontL.zRot -= 0.05;
			//BackL
			//this.BackL.y = 21.0F;
			if (this.FrontL.y > 21) this.FrontL.y -= 0.15;
			if (this.FrontL.zRot > 0) this.FrontL.zRot -= 0.05;
			//tail
			//this.tail.xRot = -0.17453292519943295F;
			if (this.tail.xRot > -0.17453292519943295F) this.tail.xRot -= 0.05;
			if (this.tail.yRot > 0) this.tail.yRot -= 0.05;
			//head
			if (this.head.xRot > 0) this.head.xRot -= 0.05;
			if (this.head.yRot < 0) this.head.yRot += 0.05;
			//hand_1
			if (this.hand_1.zRot > 0) this.hand_1.zRot -= 0.05;
			//hand
			if (this.hand.zRot < 0) this.hand.zRot += 0.05;
			//feet_1
			if (this.feet_1.zRot > 0) this.feet_1.zRot -= 0.05;
			//feet
			if (this.feet.zRot < 0) this.feet.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.tail.xRot = -0.17453292519943295F;
		this.tail.yRot = 0;
		this.FrontL.xRot = 0;
		this.FrontL.zRot = 0;
		this.FrontR.xRot = 0;
		this.head.xRot = 0;
		this.head.yRot = 0;
		this.hand_1.zRot = 0;
		this.hand.xRot = 0;
		this.hand.zRot = 0;
		this.feet_1.zRot = 0;
		this.feet.zRot = 0;
		this.BackL.zRot = 0;
		this.BackR.zRot = 0;
		this.FrontR.zRot = 0;
		this.hand_1.xRot = 0;
		this.BackL.xRot = 0;
		this.BackR.xRot = 0;
		this.feet_1.zRot = 0;
		this.feet.zRot = 0;
		this.FrontR.x = 1.0F;
		this.FrontR.y = 21.0F;
		this.FrontR.z = -3.0F;
		this.BackR.x = 1.0F;
		this.BackR.y = 21.0F;
		this.BackR.z = 4.0F;
		this.FrontL.x = -1.0F;
		this.FrontL.y = 21.0F;
		this.FrontL.z = -3.0F;
		this.belly.x = 0.0F;
		this.belly.y = 20.0F;
		this.belly.z = -1.0F;
		this.belly.xRot = 0;
		this.BackL.x = -1.0F;
		this.BackL.y = 21.0F;
		this.BackL.z = 4.0F;
	}

	public void sleepPose() {
		this.belly.y = 22.0F;
		this.belly.z = -1.0F;
		this.FrontR.x = 1.0F;
		this.FrontR.y = 23.3F;
		this.FrontR.z = -3.0F;
		this.BackR.x = 1.0F;
		this.BackR.y = 23.0F;
		this.BackR.z = 4.0F;
		this.FrontL.x = -1.0F;
		this.FrontL.y = 23.3F;
		this.FrontL.z = -3.0F;
		this.BackL.x = -1.0F;
		this.BackL.y = 23.0F;
		this.BackL.z = 4.0F;
		this.tail.xRot = -0.0572467989660713F;
		this.tail.yRot = 0.3909537457888271F;
		this.FrontL.zRot = 1.0946705281561322F;
		this.head.xRot = 0.11728612207217244F;
		this.head.yRot = -0.3909537457888271F;
		this.hand_1.zRot = 1.1728612040769677F;
		this.hand.zRot = -1.0946705281561322F;
		this.feet_1.zRot = 0.9382889765773795F;
		this.feet.zRot = -0.9382889765773795F;
		this.BackL.zRot = 0.9382889765773795F;
		this.BackR.zRot = -0.9382889765773795F;
		this.FrontR.zRot = -1.1728612040769677F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		belly.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}