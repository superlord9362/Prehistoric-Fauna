package superlord.prehistoricfauna.client.model.triassic.chinle;

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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Placerias;

public class PlaceriasModel extends EntityModel<Placerias> {
	private final ModelPart Leg_front_left;
	private final ModelPart Leg_back_right_1;
	private final ModelPart Leg_front_right;
	private final ModelPart Leg_back_right;
	private final ModelPart Body;
	private final ModelPart neck;
	private final ModelPart tail;

	public PlaceriasModel(ModelPart root) {
		this.Leg_front_left = root.getChild("Leg_front_left");
		this.Leg_back_right_1 = root.getChild("Leg_back_right_1");
		this.Leg_front_right = root.getChild("Leg_front_right");
		this.Leg_back_right = root.getChild("Leg_back_right");
		this.Body = root.getChild("Body");
		this.neck = Body.getChild("neck");
		this.tail = Body.getChild("tail");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Leg_front_left = partdefinition.addOrReplaceChild("Leg_front_left", CubeListBuilder.create().texOffs(14, 55).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, 12.0F, -9.0F));

		PartDefinition Leg_back_right_1 = partdefinition.addOrReplaceChild("Leg_back_right_1", CubeListBuilder.create().texOffs(34, 54).addBox(0.0F, 0.0F, -2.0F, 3.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 10.0F, 5.0F));

		PartDefinition Leg_front_right = partdefinition.addOrReplaceChild("Leg_front_right", CubeListBuilder.create().texOffs(14, 55).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 12.0F, -9.0F));

		PartDefinition Leg_back_right = partdefinition.addOrReplaceChild("Leg_back_right", CubeListBuilder.create().texOffs(34, 54).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 12.0F, 5.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 17).addBox(-4.6F, -5.0F, -9.0F, 9.0F, 13.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -3.0F));

		PartDefinition neck = Body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(50, 0).addBox(-2.5F, -3.5F, -5.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -9.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition beak = head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -3.5F));

		PartDefinition tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(64, 36).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 13.0F, -0.25F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 160);
	}

	@Override
	public void setupAnim(Placerias entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.neck.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.1F) + attackProgress * (float) Math.toRadians(25F);
				this.neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Leg_back_right_1.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
				this.Leg_back_right.xRot = (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
				this.Leg_front_right.xRot = (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
				this.Leg_front_left.xRot = (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
				this.tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
				this.tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.25F;
				if (entity.isEating()) {
					this.neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.Body.y = 10;
					this.Body.xRot = -0.125F;
					this.tail.xRot = 0.0625F;
					this.Leg_back_right.y = 13;
					this.Leg_back_right_1.y = 13;
					this.Leg_front_right.y = 13;
					this.Leg_front_left.y = 13;
					this.Leg_back_right.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_back_right_1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_front_left.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_front_right.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.neck.xRot = 0.25F;
					this.tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) - 0.25F;
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Leg_back_right
			//this.Leg_back_right.y = 10.0F;
			if (this.Leg_back_right.y > 10) this.Leg_back_right.y -= 0.15;
			if (this.Leg_back_right.xRot > 0) this.Leg_back_right.xRot -= 0.05;
			if (this.Leg_back_right.yRot < 0) this.Leg_back_right.yRot += 0.05;
			if (this.Leg_back_right.zRot > 0) this.Leg_back_right.zRot -= 0.05;
			//Body
			//this.Body.y = 8.0F;
			//this.Body.z = -3.0F;
			if (this.Body.y > 8) this.Body.y -= 0.15;
			if (this.Body.z > -3) this.Body.z -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//Leg_front_right
			//this.Leg_front_right.x = -3.5F;
			//this.Leg_front_right.y = 12;
			//this.Leg_front_right.z = -9;
			if (this.Leg_front_right.x < -3.5) this.Leg_front_right.x += 0.15;
			if (this.Leg_front_right.y > 12) this.Leg_front_right.y -= 0.15;
			if (this.Leg_front_right.z > -9) this.Leg_front_right.z -= 0.15;
			if (this.Leg_front_right.xRot < 0) this.Leg_front_right.xRot += 0.05;
			if (this.Leg_front_right.yRot < 0) this.Leg_front_right.yRot += 0.05;
			if (this.Leg_front_right.zRot < 0) this.Leg_front_right.zRot += 0.05;
			//Leg_back_right_1
			//this.Leg_back_right_1.x = 3.5F;
			//this.Leg_back_right_1.y = 12;
			if (this.Leg_back_right_1.x < 3.5) this.Leg_back_right_1.x += 0.15;
			if (this.Leg_back_right_1.y > 12) this.Leg_back_right_1.y -= 0.15;
			if (this.Leg_back_right_1.xRot > 0) this.Leg_back_right_1.xRot -= 0.05;
			if (this.Leg_back_right_1.yRot > 0) this.Leg_back_right_1.yRot -= 0.05;
			if (this.Leg_back_right_1.zRot < 0) this.Leg_back_right_1.zRot += 0.05;
			//neck
			if (this.neck.xRot > 0) this.neck.xRot -= 0.05;
			if (this.neck.yRot > 0) this.neck.yRot -= 0.05;
			if (this.neck.zRot < 0) this.neck.zRot += 0.05;
			//tail
			//this.tail.xRot = -0.4305727277985816F;
			if (this.tail.xRot > -0.4305727277985816F) this.tail.xRot -= 0.05;
			if (this.tail.yRot < 0) this.tail.yRot += 0.05;
			if (this.tail.zRot > 0) this.tail.zRot -= 0.05;
			//Leg_front_left
			//this.Leg_front_left.x = 3.5F;
			//this.Leg_front_left.y = 12;
			//this.Leg_front_left.z = -9;
			if (this.Leg_front_left.x > 3.5) this.Leg_front_left.x -= 0.15;
			if (this.Leg_front_left.y > 12) this.Leg_front_left.y -= 0.15;
			if (this.Leg_front_left.z > -9) this.Leg_front_left.z -= 0.15;
			if (this.Leg_front_left.xRot < 0) this.Leg_front_left.xRot += 0.05;
			if (this.Leg_front_left.yRot > 0) this.Leg_front_left.yRot -= 0.05;
			if (this.Leg_front_left.zRot > 0) this.Leg_front_left.zRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Leg_back_right
			//this.Leg_back_right.y = 10.0F;
			if (this.Leg_back_right.y < 20) this.Leg_back_right.y += 0.15;
			if (this.Leg_back_right.xRot < 1.2906709285865847F) this.Leg_back_right.xRot += 0.05;
			if (this.Leg_back_right.yRot > -0.03909537541112055F) this.Leg_back_right.yRot -= 0.05;
			if (this.Leg_back_right.zRot < 0.1563815016444822F) this.Leg_back_right.zRot += 0.05;
			//Body
			//this.Body.y = 8.0F;
			//this.Body.z = -3.0F;
			if (this.Body.y < 16.1) this.Body.y += 0.15;
			if (this.Body.z < 0) this.Body.z += 0.15;
			if (this.Body.xRot > -0.03909537541112055F) this.Body.xRot -= 0.05;
			//Leg_front_right
			//this.Leg_front_right.x = -3.5F;
			//this.Leg_front_right.y = 12;
			//this.Leg_front_right.z = -9;
			if (this.Leg_front_right.x > -3.8) this.Leg_front_right.x -= 0.15;
			if (this.Leg_front_right.y < 19.6) this.Leg_front_right.y += 0.15;
			if (this.Leg_front_right.z < -6) this.Leg_front_right.z += 0.15;
			if (this.Leg_front_right.xRot > -1.1344640137963142F) this.Leg_front_right.xRot -= 0.05;
			if (this.Leg_front_right.yRot > -0.4300491170387584F) this.Leg_front_right.yRot -= 0.05;
			if (this.Leg_front_right.zRot > -0.1563815016444822F) this.Leg_front_right.zRot -= 0.05;
			//Leg_back_right_1
			//this.Leg_back_right_1.x = 3.5F;
			//this.Leg_back_right_1.y = 12;
			if (this.Leg_back_right_1.x > 3) this.Leg_back_right_1.x -= 0.15;
			if (this.Leg_back_right_1.y < 21) this.Leg_back_right_1.y += 0.15;
			if (this.Leg_back_right_1.xRot < 1.3685127304046198F) this.Leg_back_right_1.xRot += 0.05;
			if (this.Leg_back_right_1.yRot < 0.03909537541112055F) this.Leg_back_right_1.yRot += 0.05;
			if (this.Leg_back_right_1.zRot > -0.19547687289441354F) this.Leg_back_right_1.zRot -= 0.05;
			//neck
			if (this.neck.xRot < 0.03909537541112055F) this.neck.xRot += 0.05;
			if (this.neck.yRot < 0.35185837453889574F) this.neck.yRot += 0.05;
			if (this.neck.zRot > -0.4300491170387584F) this.neck.zRot -= 0.05;
			//tail
			//this.tail.xRot = -0.4305727277985816F;
			if (this.tail.xRot < -0.3522074483787779F) this.tail.xRot += 0.05;
			if (this.tail.yRot > -0.0781907508222411F) this.tail.yRot -= 0.05;
			if (this.tail.zRot < 0.11728612207217244F) this.tail.zRot += 0.05;
			//Leg_front_left
			//this.Leg_front_left.x = 3.5F;
			//this.Leg_front_left.y = 12;
			//this.Leg_front_left.z = -9;
			if (this.Leg_front_left.x < 4.3) this.Leg_front_left.x += 0.15;
			if (this.Leg_front_left.y < 18) this.Leg_front_left.y += 0.15;
			if (this.Leg_front_left.z < -6) this.Leg_front_left.z += 0.15;
			if (this.Leg_front_left.xRot > -1.1728612040769677F) this.Leg_front_left.xRot -= 0.05;
			if (this.Leg_front_left.yRot < 0.1563815016444822F) this.Leg_front_left.yRot += 0.05;
			if (this.Leg_front_left.zRot < 0.038920842652368684F) this.Leg_front_left.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Leg_back_right.y = 10.0F;
		this.Leg_back_right.xRot = 0;
		this.Leg_back_right.yRot = 0;
		this.Leg_back_right.zRot = 0;
		this.Body.y = 8.0F;
		this.Body.z = -3.0F;
		this.Body.xRot = 0;
		this.Leg_front_right.x = -3.5F;
		this.Leg_front_right.y = 12;
		this.Leg_front_right.z = -9;
		this.Leg_front_right.xRot = 0;
		this.Leg_front_right.yRot = 0;
		this.Leg_front_right.zRot = 0;
		this.Leg_back_right_1.x = 3.5F;
		this.Leg_back_right_1.y = 12;
		this.Leg_back_right_1.z = 5;
		this.Leg_back_right_1.xRot = 0;
		this.Leg_back_right_1.yRot = 0;
		this.Leg_back_right_1.zRot = 0;
		this.neck.xRot = 0;
		this.neck.yRot = 0;
		this.neck.zRot = 0;
		this.tail.xRot = -0.4305727277985816F;
		this.tail.yRot = 0;
		this.tail.zRot = 0;
		this.Leg_front_left.x = 3.5F;
		this.Leg_front_left.y = 12;
		this.Leg_front_left.z = -9;
		this.Leg_front_left.xRot = 0;
		this.Leg_front_left.yRot = 0;
		this.Leg_front_left.zRot = 0;
	}

	public void sleepPose() {
		this.Leg_back_right.y = 20.0F;
		this.Leg_back_right.xRot = 1.2906709285865847F;
		this.Leg_back_right.yRot = -0.03909537541112055F;
		this.Leg_back_right.zRot = 0.1563815016444822F;
		this.Body.y = 16.1F;
		this.Body.z = 0.0F;
		this.Body.xRot = -0.03909537541112055F;
		this.Leg_front_right.x = -3.8F;
		this.Leg_front_right.y = 19.6F;
		this.Leg_front_right.z = -6;
		this.Leg_front_right.xRot = -1.1344640137963142F;
		this.Leg_front_right.yRot = -0.4300491170387584F;
		this.Leg_front_right.zRot = -0.1563815016444822F;
		this.Leg_back_right_1.x = 3F;
		this.Leg_back_right_1.y = 21;
		this.Leg_back_right_1.z = 5;
		this.Leg_back_right_1.xRot = 1.3685127304046198F;
		this.Leg_back_right_1.yRot = 0.03909537541112055F;
		this.Leg_back_right_1.zRot = -0.19547687289441354F;
		this.neck.xRot = 0.03909537541112055F;
		this.neck.yRot = 0.35185837453889574F;
		this.neck.zRot = -0.4300491170387584F;
		this.tail.xRot = -0.3522074483787779F;
		this.tail.yRot = -0.0781907508222411F;
		this.tail.zRot = 0.11728612207217244F;
		this.Leg_front_left.x = 4.3F;
		this.Leg_front_left.y = 18;
		this.Leg_front_left.z = -6;
		this.Leg_front_left.xRot = -1.1728612040769677F;
		this.Leg_front_left.yRot = 0.1563815016444822F;
		this.Leg_front_left.zRot = 0.038920842652368684F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Leg_front_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_back_right_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_front_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_back_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}