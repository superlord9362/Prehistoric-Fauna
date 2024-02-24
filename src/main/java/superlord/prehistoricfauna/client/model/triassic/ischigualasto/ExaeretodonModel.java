package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;

public class ExaeretodonModel extends EntityModel<Exaeretodon> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Head;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;
	private final ModelPart LeftBackLeg;
	private final ModelPart RightBackLeg;

	public ExaeretodonModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = Body.getChild("Tail");
		this.Head = Body.getChild("Head");
		this.LeftFrontLeg = Body.getChild("LeftFrontLeg");
		this.LeftBackLeg = Body.getChild("LeftBackLeg");
		this.RightBackLeg = Body.getChild("RightBackLeg");
		this.RightFrontLeg = Body.getChild("RightFrontLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -4.0F));

		PartDefinition LeftBackLeg = Body.addOrReplaceChild("LeftBackLeg", CubeListBuilder.create().texOffs(28, 0).mirror().addBox(-3.0F, -1.5F, -1.51F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -1.5F, 8.5F));

		PartDefinition LeftFrontLeg = Body.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(30, 18).mirror().addBox(-3.0F, -1.5F, -1.51F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -0.5F, -0.5F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 18).addBox(-2.5F, -3.0F, -6.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));

		PartDefinition Snoot = Head.addOrReplaceChild("Snoot", CubeListBuilder.create().texOffs(0, 28).addBox(-1.5F, -3.0F, -4.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition RightFrontLeg = Body.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(30, 18).addBox(0.0F, -1.5F, -1.51F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -0.5F, -0.5F));

		PartDefinition RightBackLeg = Body.addOrReplaceChild("RightBackLeg", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, -1.5F, -1.51F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.5F, 8.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(16, 22).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 48, 48);
	}

	@Override
	public void setupAnim(Exaeretodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//LeftBackLeg
			if (this.LeftBackLeg.xRot < 1.6816247076649256F) this.LeftBackLeg.xRot += 0.05;
			if (this.LeftBackLeg.yRot > -0.40125119103875473F) this.LeftBackLeg.yRot -= 0.05;
			//Tail
			//this.Tail.z = 10.0F;
			if (this.Tail.z > 9.1) this.Tail.z -= 0.15;
			if (this.Tail.xRot > -0.07295475973730675F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot < 0.36477380700891215F) this.Tail.yRot += 0.05;
			if (this.Tail.zRot < 0.01902408942930468F) this.Tail.zRot += 0.05;
			//Head
			//this.Head.y = -3.0F;
			//this.Head.z = -2.0F;
			if (this.Head.y < -2.6) this.Head.y += 0.15;
			if (this.Head.z < 0) this.Head.z += 0.15;
			if (this.Head.xRot < 0.3284709598990106F) this.Head.xRot += 0.05;
			if (this.Head.yRot > -0.40194933871851896F) this.Head.yRot -= 0.05;
			if (this.Head.zRot > -0.291819038949227F) this.Head.zRot -= 0.05;
			//Body
			//this.Body.y = 21.0F;
			if (this.Body.y < 23.6) this.Body.y += 0.15;
			if (this.Body.xRot > -0.1459095194746135F) this.Body.xRot -= 0.05;
			//LeftFrontLeg
			//this.LeftFrontLeg.x = -3.0F;
			//this.LeftFrontLeg.y = -0.5F;
			//this.LeftFrontLeg.z = -0.5F;
			if (this.LeftFrontLeg.x < -2.6) this.LeftFrontLeg.x += 0.15;
			if (this.LeftFrontLeg.y < -0.1) this.LeftFrontLeg.y += 0.15;
			if (this.LeftFrontLeg.z > -0.6) this.LeftFrontLeg.z -= 0.15;
			if (this.LeftFrontLeg.xRot > -1.314407417066352F) this.LeftFrontLeg.xRot -= 0.05;
			if (this.LeftFrontLeg.yRot > -1.1299261204568736F) this.LeftFrontLeg.yRot -= 0.05;
			if (this.LeftFrontLeg.zRot > -0.2556907287592666F) this.LeftFrontLeg.zRot -= 0.05;
			//RightBackLeg
			if (this.RightBackLeg.xRot < 1.605702911834783F) this.RightBackLeg.xRot += 0.05;
			if (this.RightBackLeg.yRot < 0.291819038949227F) this.RightBackLeg.yRot += 0.05;
			//RightFrontLeg
			if (this.RightFrontLeg.xRot > -0.8030259595478191F) this.RightFrontLeg.xRot -= 0.05;
			if (this.RightFrontLeg.yRot < 1.1311478456069475F) this.RightFrontLeg.yRot += 0.05;
			if (this.RightFrontLeg.zRot < 0.6201154619282966F) this.RightFrontLeg.zRot += 0.05;
			sleepPose();
		} else {
			this.Head.xRot = headPitch * ((float)Math.PI / 180F);
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LeftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.LeftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.RightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			if (entity.isEating()) {
				this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entity.isInWater()) {
				this.LeftFrontLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.RightFrontLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.LeftBackLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.RightBackLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.xRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.25F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LeftBackLeg
			if (this.LeftBackLeg.xRot > 0) this.LeftBackLeg.xRot -= 0.05;
			if (this.LeftBackLeg.yRot < 0) this.LeftBackLeg.yRot += 0.05;
			//Tail
			//this.Tail.z = 10.0F;
			if (this.Tail.z < 10) this.Tail.z += 0.15;
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
			//Head
			//this.Head.y = -3.0F;
			//this.Head.z = -2.0F;
			if (this.Head.y > -3) this.Head.y -= 0.15;
			if (this.Head.z > -2) this.Head.z -= 0.15;
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0) this.Head.yRot += 0.05;
			if (this.Head.zRot < 0) this.Head.zRot += 0.05;
			//Body
			//this.Body.y = 21.0F;
			if (this.Body.y > 21) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//LeftFrontLeg
			//this.LeftFrontLeg.x = -3.0F;
			//this.LeftFrontLeg.y = -0.5F;
			//this.LeftFrontLeg.z = -0.5F;
			if (this.LeftFrontLeg.x > -3) this.LeftFrontLeg.x -= 0.15;
			if (this.LeftFrontLeg.y > -0.5) this.LeftFrontLeg.y -= 0.15;
			if (this.LeftFrontLeg.z < -0.5) this.LeftFrontLeg.z += 0.15;
			if (this.LeftFrontLeg.xRot < 0) this.LeftFrontLeg.xRot += 0.05;
			if (this.LeftFrontLeg.yRot < 0) this.LeftFrontLeg.yRot += 0.05;
			if (this.LeftFrontLeg.zRot < 0) this.LeftFrontLeg.zRot += 0.05;
			//RightBackLeg
			if (this.RightBackLeg.xRot > 0) this.RightBackLeg.xRot -= 0.05;
			if (this.RightBackLeg.yRot > 0) this.RightBackLeg.yRot -= 0.05;
			//RightFrontLeg
			if (this.RightFrontLeg.xRot < 0) this.RightFrontLeg.xRot += 0.05;
			if (this.RightFrontLeg.yRot > 0) this.RightFrontLeg.yRot -= 0.05;
			if (this.RightFrontLeg.zRot > 0) this.RightFrontLeg.zRot -= 0.05;
		}
	}

	public void resetModel() {
		this.LeftBackLeg.xRot = 0;
		this.LeftBackLeg.yRot = 0;
		this.Tail.z = 10.0F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Head.y = -3.0F;
		this.Head.z = -2.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Body.y = 21.0F;
		this.Body.xRot = 0;
		this.LeftFrontLeg.x = -3.0F;
		this.LeftFrontLeg.y = -0.5F;
		this.LeftFrontLeg.z = -0.5F;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.LeftFrontLeg.zRot = 0;
		this.RightBackLeg.xRot = 0;
		this.RightBackLeg.yRot = 0;
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.RightFrontLeg.zRot = 0;
	}

	public void sleepPose() {
		this.LeftBackLeg.xRot = 1.6816247076649256F;
		this.LeftBackLeg.yRot = -0.40125119103875473F;
		this.Tail.z = 9.1F;
		this.Tail.xRot = -0.07295475973730675F;
		this.Tail.yRot = 0.36477380700891215F;
		this.Tail.zRot = 0.01902408942930468F;
		this.Head.y = -2.6F;
		this.Head.z = 0.0F;
		this.Head.xRot = 0.3284709598990106F;
		this.Head.yRot = -0.40194933871851896F;
		this.Head.zRot = -0.291819038949227F;
		this.Body.y = 23.6F;
		this.Body.xRot = -0.1459095194746135F;
		this.LeftFrontLeg.x = -2.6F;
		this.LeftFrontLeg.y = -0.1F;
		this.LeftFrontLeg.z = -0.6F;
		this.LeftFrontLeg.xRot = -1.314407417066352F;
		this.LeftFrontLeg.yRot = -1.1299261204568736F;
		this.LeftFrontLeg.zRot = -0.2556907287592666F;
		this.RightBackLeg.xRot = 1.605702911834783F;
		this.RightBackLeg.yRot = 0.291819038949227F;
		this.RightFrontLeg.xRot = -0.8030259595478191F;
		this.RightFrontLeg.yRot = 1.1311478456069475F;
		this.RightFrontLeg.zRot = 0.6201154619282966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}