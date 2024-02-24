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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;

public class ScutellosaurusModel extends EntityModel<Scutellosaurus> {
	private final ModelPart Leg;
	private final ModelPart Leg2;
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart ArmLeft;
	private final ModelPart ArmRight;
	private final ModelPart Leg_1;
	private final ModelPart Leg2_1;

	public ScutellosaurusModel(ModelPart root) {
		this.Leg = root.getChild("Leg");
		this.Leg2 = Leg.getChild("Leg2");
		this.Body = root.getChild("Body");
		this.Tail = Body.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.ArmLeft = Body.getChild("ArmLeft");
		this.ArmRight = Body.getChild("ArmRight");
		this.Leg_1 = root.getChild("Leg_1");
		this.Leg2_1 = Leg_1.getChild("Leg2_1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Leg = partdefinition.addOrReplaceChild("Leg", CubeListBuilder.create().texOffs(7, 20).mirror().addBox(-1.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.4F, 17.0F, 3.0F));

		PartDefinition Leg2 = Leg.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(14, 21).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.4F, 4.0F));

		PartDefinition ArmRight = Body.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -7.0F, 0.0F, 0.0F, 0.05F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(21, 0).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8F, 0.0F, -0.025F, 0.0F, 0.0F));

		PartDefinition TailOsteoderms = Tail.addOrReplaceChild("TailOsteoderms", CubeListBuilder.create().texOffs(21, 9).addBox(-1.0F, 0.0F, 0.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2F, -0.1F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(31, -12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition Tail2Osteoderms = Tail2.addOrReplaceChild("Tail2Osteoderms", CubeListBuilder.create().texOffs(25, 4).addBox(-0.5F, 0.0F, -7.9F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 5.9F));

		PartDefinition part6 = Body.addOrReplaceChild("part6", CubeListBuilder.create().texOffs(32, 4).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.9F, -8.0F));

		PartDefinition part6_1 = Body.addOrReplaceChild("part6_1", CubeListBuilder.create().texOffs(42, 5).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.9F, -6.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, -1.5F, -2.8F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.3F, -8.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(12, 13).addBox(-0.5F, -1.5F, -3.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -0.1F, -2.5F));

		PartDefinition ArmLeft = Body.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -7.0F, 0.0F, 0.0F, -0.05F));

		PartDefinition Leg_1 = partdefinition.addOrReplaceChild("Leg_1", CubeListBuilder.create().texOffs(7, 20).addBox(0.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6F, 17.0F, 3.0F));

		PartDefinition Leg2_1 = Leg_1.addOrReplaceChild("Leg2_1", CubeListBuilder.create().texOffs(14, 21).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 70, 45);
	}

	@Override
	public void setupAnim(Scutellosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//Leg
			//this.Leg.y = 17.0F;
			if (this.Leg.y < 20.3) this.Leg.y += 0.15;
			if (this.Leg.xRot > -0.5082398928281348F) this.Leg.xRot -= 0.05;
			if (this.Leg.yRot < 0.4300491170387584F) this.Leg.yRot += 0.05;
			//Tail
			if (this.Tail.xRot > -0.3125884663690233F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot < 0.27366763203903305F) this.Tail.yRot += 0.05;
			if (this.Tail.zRot > -0.1563815016444822F) this.Tail.zRot -= 0.05;
			//Leg_1
			//this.Leg_1.y = 17;
			//this.Leg_1.z = 3;
			if (this.Leg_1.y < 20) this.Leg_1.y += 0.15;
			if (this.Leg_1.z < 3.6) this.Leg_1.z += 0.15;
			if (this.Leg_1.xRot > -0.3914773565486503F) this.Leg_1.xRot -= 0.05;
			if (this.Leg_1.yRot > -0.46914448828868976F) this.Leg_1.yRot -= 0.05;
			//Body
			//this.Body.y = 18.4F;
			if (this.Body.y < 21.7) this.Body.y += 0.15;
			//ArmRight
			if (this.ArmRight.xRot < 1.2510520131558576F) this.ArmRight.xRot += 0.05;
			if (this.ArmRight.yRot > -0.6257005102083563F) this.ArmRight.yRot -= 0.05;
			//Leg2_1
			//this.Leg2_1.y = 4.0F;
			//this.Leg2_1.z = 0;
			if (this.Leg2_1.y > 1.5) this.Leg2_1.y -= 0.15;
			if (this.Leg2_1.z > -1) this.Leg2_1.z -= 0.15;
			if (this.Leg2_1.xRot < 0.35185837453889574F) this.Leg2_1.xRot += 0.05;
			//Tail2
			//this.Tail2.y = 0.0F;
			if (this.Tail2.y < 0.2) this.Tail2.y += 0.15;
			if (this.Tail2.xRot > -0.03909537541112055F) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0.46914448828868976F) this.Tail2.yRot += 0.05;
			//ArmLeft
			if (this.ArmLeft.xRot < 1.1728612040769677F) this.ArmLeft.xRot += 0.05;
			if (this.ArmLeft.yRot < 0.5473352640780661F) this.ArmLeft.yRot += 0.05;
			//Head
			if (this.Head.xRot > -0.19547687289441354F) this.Head.xRot -= 0.05;
			//Leg2
			//this.Leg2.y = 4.0F;
			//this.Leg2.z = 0.0F;
			if (this.Leg2_1.y > 1) this.Leg2_1.y -= 0.15;
			if (this.Leg2_1.z > -0.5) this.Leg2_1.z -= 0.15;
			if (this.Leg2_1.xRot < 0.5473352640780661F) this.Leg2_1.xRot += 0.05;
			if (this.Leg2_1.yRot < 0.3127630032889644F) this.Leg2_1.yRot += 0.05;
			if (this.Leg2_1.zRot < 0.19547687289441354F) this.Leg2_1.zRot += 0.05;
			//Neck
			//this.Neck.y =  -0.3F;
			if (this.Neck.y < 0.2) this.Neck.y += 0.15;
			if (this.Neck.xRot < 0.46914448828868976F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.3909537457888271F) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot > -0.03909537541112055F) this.Neck.zRot -= 0.05;
			sleepPose();
		} else {
			resetModel();
			this.Body.xRot = 0;
			this.Neck.xRot = headPitch * ((float)Math.PI / 180F);
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.Leg_1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Leg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.ArmRight.zRot = Mth.cos(0.05F * ageInTicks) * 0.05F;
			this.ArmLeft.zRot = -Mth.cos(0.05F * ageInTicks) * 0.05F;
			this.Tail.yRot = -Mth.cos(0.1F * ageInTicks) * 0.1F;
			this.Tail.xRot = -Mth.cos(0.025F * ageInTicks) * 0.025F;
			if (entity.isEating()) {
				this.Body.xRot = 0.2F;
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.Leg_1.y = 20;
				this.Leg.y = 20;
				this.Body.y = 20;
				this.Body.xRot = -0.25F;
				this.Tail.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Head.xRot = 0.25F;
				this.Leg_1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ArmLeft.xRot = 0.25F;
				this.ArmRight.xRot = 0.25F;
				this.Leg2_1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Leg
			//this.Leg.y = 17.0F;
			if (this.Leg.y > 17) this.Leg.y -= 0.15;
			if (this.Leg.xRot < 0) this.Leg.xRot += 0.05;
			if (this.Leg.yRot > 0) this.Leg.yRot -= 0.05;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot < 0) this.Tail.zRot += 0.05;
			//Leg_1
			//this.Leg_1.y = 17;
			//this.Leg_1.z = 3;
			if (this.Leg_1.y > 17) this.Leg_1.y -= 0.15;
			if (this.Leg_1.z > 3) this.Leg_1.z -= 0.15;
			if (this.Leg_1.xRot < 0) this.Leg_1.xRot += 0.05;
			if (this.Leg_1.yRot < 0) this.Leg_1.yRot += 0.05;
			//Body
			//this.Body.y = 18.4F;
			if (this.Body.y > 18.4) this.Body.y -= 0.15;
			//ArmRight
			if (this.ArmRight.xRot > 0) this.ArmRight.xRot -= 0.05;
			if (this.ArmRight.yRot < 0) this.ArmRight.yRot += 0.05;
			//Leg2_1
			//this.Leg2_1.y = 4.0F;
			//this.Leg2_1.z = 0;
			if (this.Leg2_1.y < 4) this.Leg2_1.y += 0.15;
			if (this.Leg2_1.z < 0) this.Leg2_1.z += 0.15;
			if (this.Leg2_1.xRot > 0) this.Leg2_1.xRot -= 0.05;
			//Tail2
			//this.Tail2.y = 0.0F;
			if (this.Tail2.y > 0) this.Tail2.y -= 0.15;
			if (this.Tail2.xRot < 0) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//ArmLeft
			if (this.ArmLeft.xRot > 0) this.ArmLeft.xRot -= 0.05;
			if (this.ArmLeft.yRot > 0) this.ArmLeft.yRot -= 0.05;
			//Head
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			//Leg2
			//this.Leg2.y = 4.0F;
			//this.Leg2.z = 0.0F;
			if (this.Leg2_1.y < 4) this.Leg2_1.y += 0.15;
			if (this.Leg2_1.z < 0) this.Leg2_1.z += 0.15;
			if (this.Leg2_1.xRot > 0) this.Leg2_1.xRot -= 0.05;
			if (this.Leg2_1.yRot > 0) this.Leg2_1.yRot -= 0.05;
			if (this.Leg2_1.zRot > 0) this.Leg2_1.zRot -= 0.05;
			//Neck
			//this.Neck.y =  -0.3F;
			if (this.Neck.y > -0.3) this.Neck.y -= 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			if (this.Neck.zRot < 0) this.Neck.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Leg.y = 17.0F;
		this.Leg.xRot = 0;
		this.Leg.yRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Leg_1.y = 17;
		this.Leg_1.z = 3;
		this.Leg_1.xRot = 0;
		this.Leg_1.yRot = 0;
		this.Body.y = 18.4F;
		this.ArmRight.xRot = 0;
		this.ArmRight.yRot = 0;
		this.Leg2_1.y = 4.0F;
		this.Leg2_1.z = 0;
		this.Leg2_1.xRot = 0;
		this.Tail2.y = 0.0F;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.ArmLeft.xRot = 0;
		this.ArmLeft.yRot = 0;
		this.Head.xRot = 0;
		this.Leg2.y = 4.0F;
		this.Leg2.z = 0.0F;
		this.Leg2.xRot = 0.0F;
		this.Leg2.yRot = 0;
		this.Leg2.zRot = 0;
		this.Neck.y =  -0.3F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
	}

	public void sleepPose() {
		this.Leg.y = 20.3F;
		this.Leg.xRot = -0.5082398928281348F;
		this.Leg.yRot = 0.4300491170387584F;
		this.Tail.xRot = -0.3125884663690233F;
		this.Tail.yRot = 0.27366763203903305F;
		this.Tail.zRot = -0.1563815016444822F;
		this.Leg_1.y = 20;
		this.Leg_1.z = 3.6F;
		this.Leg_1.xRot = -0.3914773565486503F;
		this.Leg_1.yRot = -0.46914448828868976F;
		this.Body.y = 21.7F;
		this.ArmRight.xRot = 1.2510520131558576F;
		this.ArmRight.yRot = -0.6257005102083563F;
		this.Leg2_1.y = 1.5F;
		this.Leg2_1.z = -1;
		this.Leg2_1.xRot = 0.35185837453889574F;
		this.Tail2.y = 0.2F;
		this.Tail2.xRot = -0.03909537541112055F;
		this.Tail2.yRot = 0.46914448828868976F;
		this.ArmLeft.xRot = 1.1728612040769677F;
		this.ArmLeft.yRot = 0.5473352640780661F;
		this.Head.xRot = -0.19547687289441354F;
		this.Leg2.y = 1.0F;
		this.Leg2.z = -0.5F;
		this.Leg2.xRot = 0.5473352640780661F;
		this.Leg2.yRot = 0.3127630032889644F;
		this.Leg2.zRot = 0.19547687289441354F;
		this.Neck.y =  0.2F;
		this.Neck.xRot = 0.46914448828868976F;
		this.Neck.yRot = -0.3909537457888271F;
		this.Neck.zRot = -0.03909537541112055F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}