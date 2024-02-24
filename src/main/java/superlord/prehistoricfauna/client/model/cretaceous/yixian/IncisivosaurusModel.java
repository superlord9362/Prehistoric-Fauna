package superlord.prehistoricfauna.client.model.cretaceous.yixian;

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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Incisivosaurus;

public class IncisivosaurusModel extends EntityModel<Incisivosaurus> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	@SuppressWarnings("unused")
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	@SuppressWarnings("unused")
	private final ModelPart LeftFoot;

	public IncisivosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.RightWing = Body.getChild("RightWing");
		this.LeftWing = Body.getChild("LeftWing");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(15, 7).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 16.0F, -5.0F, 0.0F, 0.0F, -0.0087F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, 7.0F));

		PartDefinition TailFan = Tail1.addOrReplaceChild("TailFan", CubeListBuilder.create().texOffs(2, 7).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.99F, 3.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(18, 2).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.0F, -2.0F));

		PartDefinition Teeth = Snout.addOrReplaceChild("Teeth", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.5F, 0.05F, -0.0017F, 0.0F, 0.0F));

		PartDefinition HeadFeathers = Head.addOrReplaceChild("HeadFeathers", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -0.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.6255F, 0.0F, 0.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(28, 6).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 2.0F, 1.1F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(28, 6).addBox(0.0F, -1.0F, -1.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 1.1F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(16, 7).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 2.0F, 5.9F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(30, 3).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(5, 0).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(16, 7).addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 5.9F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(30, 3).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 1.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 36, 18);
	}

	@Override
	public void setupAnim(Incisivosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//Body
			//this.Body.y = 16;
			if (this.Body.y < 22) this.Body.y += 0.15;
			if (this.Body.zRot > -0.19547687289441354F) this.Body.zRot -= 0.05;
			//LeftLeg
			//this.LeftLeg.x = -0.6F;
			//this.LeftLeg.y = 5.0F;
			//this.LeftLeg.z = 1.0F;
			if (this.LeftLeg.x < -0.5) this.LeftLeg.x += 0.15;
			if (this.LeftLeg.y > 3.6) this.LeftLeg.y -= 0.15;
			if (this.LeftLeg.z > 0.9) this.LeftLeg.z -= 0.15;
			if (this.LeftLeg.xRot < 0.07836527941980377F) this.LeftLeg.xRot += 0.05;
			if (this.LeftLeg.yRot < 0.009250244536227243F) this.LeftLeg.yRot += 0.05;
			//LeftWing
			//this.LeftWing.x = -1.5F;
			//this.LeftWing.y = 1.0F;
			//this.LeftWing.z = -6.0F;
			if (this.LeftWing.x > -2.3) this.LeftLeg.x -= 0.15;
			if (this.LeftWing.y > 0.9) this.LeftWing.y -= 0.15;
			if (this.LeftWing.z < -5) this.LeftWing.z += 0.15;
			if (this.LeftWing.xRot > -1.6030848913251807F) this.LeftWing.xRot -= 0.05;
			if (this.LeftWing.yRot > -0.036477379868653376F) this.LeftWing.yRot -= 0.05;
			if (this.LeftWing.zRot < 0.6003932893176602F) this.LeftWing.zRot += 0.05;
			//LeftThigh
			//this.LeftThigh.y = 15.0F;
			//this.LeftThigh.z = 2.0F;
			if (this.LeftThigh.x < 23) this.LeftThigh.x += 0.15;
			if (this.LeftThigh.y < 5) this.LeftThigh.y += 0.15;
			if (this.LeftThigh.xRot > -1.6041321794238546F) this.LeftThigh.xRot -= 0.05;
			if (this.LeftThigh.yRot < 0.35185837453889574F) this.LeftThigh.yRot += 0.05;
			//RightThigh
			//this.RightThigh.y = 15.0F;
			//this.RightThigh.z = 2.0F;
			if (this.RightThigh.x < 23) this.RightThigh.x += 0.15;
			if (this.RightThigh.y < 5) this.RightThigh.y += 0.15;
			if (this.RightThigh.xRot > -1.5653858487242918F) this.RightThigh.xRot -= 0.05;
			if (this.RightThigh.yRot > -0.3127630032889644F) this.RightThigh.yRot -= 0.05;
			//RightLeg
			//this.RightLeg.x = 0.6F;
			//this.RightLeg.y = 5.0F;
			//this.RightLeg.z = 1.0F;
			if (this.RightLeg.x > 0.5) this.RightLeg.x -= 0.15;
			if (this.RightLeg.y > 3.6) this.RightLeg.y -= 0.15;
			if (this.RightLeg.z > 0.9) this.RightLeg.z -= 0.15;
			if (this.RightLeg.zRot > -0.15620696472454113F) this.RightLeg.zRot -= 0.05;
			//RightWing
			//this.RightWing.x = 1.5F;
			//this.RightWing.y = 1.0F;
			//this.RightWing.z = -6.0F;
			if (this.RightWing.x < 1.9) this.RightWing.x += 0.15;
			if (this.RightWing.y < 1.4) this.RightWing.y += 0.15;
			if (this.RightWing.z < -5.1) this.RightWing.z += 0.15;
			if (this.RightWing.xRot > -1.486671462175092F) this.RightWing.xRot -= 0.05;
			if (this.RightWing.yRot < 0.002617993982021224F) this.RightWing.yRot += 0.05;
			if (this.RightWing.zRot > -0.24015730906916136F) this.RightWing.zRot -= 0.05;
			//Head
			//this.Head.z = -8.0F;
			if (this.Head.z < -7.1) this.Head.z += 0.15;
			if (this.Head.xRot < 0.23177972000431504F) this.Head.xRot += 0.05;
			if (this.Head.yRot > -0.39357173300891585F) this.Head.yRot -= 0.05;
			if (this.Head.zRot < 0.37262780195869205F) this.Head.zRot += 0.05;
			//Tail1
			//this.Tail1.y = -0.9F;
			if (this.Tail1.y < -0.4) this.Tail1.y += 0.15;
			if (this.Tail1.xRot > -0.1563815016444822F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0.3127630032889644F) this.Tail1.yRot += 0.05;
			if (this.Tail1.zRot < 0.11903145798206952F) this.Tail1.zRot += 0.05;
			sleepPose();
		} else {
			this.Head.xRot = headPitch * ((float)Math.PI / 180F);
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.RightWing.zRot = -Mth.cos(0.05F * ageInTicks) * 0.05F;
			this.LeftWing.zRot = Mth.cos(0.05F * ageInTicks) * 0.05F;
			this.Tail1.yRot = -Mth.cos(0.05F * ageInTicks) * 0.05F;
			this.Tail1.xRot = -Mth.cos(0.1F * ageInTicks) * 0.1F;
			if (entity.isEating()) {
				this.Body.xRot = 0.2F;
				this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.RightThigh.y = 20;
				this.LeftThigh.y = 20;
				this.Body.y = 20;
				this.Body.xRot = -0.125F;
				this.Tail1.xRot = 0.125F;
				this.Head.xRot = 0.125F;
				this.RightLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftWing.xRot = 0.25F;
				this.RightWing.xRot = 0.25F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Body
			//this.Body.y = 16;
			if (this.Body.y > 16) this.Body.y -= 0.15;
			if (this.Body.zRot < 0) this.Body.zRot += 0.05;
			//LeftLeg
			//this.LeftLeg.x = -0.6F;
			//this.LeftLeg.y = 5.0F;
			//this.LeftLeg.z = 1.0F;
			if (this.LeftLeg.x > -0.6) this.LeftLeg.x -= 0.15;
			if (this.LeftLeg.y < 5) this.LeftLeg.y += 0.15;
			if (this.LeftLeg.z < 1) this.LeftLeg.z += 0.15;
			if (this.LeftLeg.xRot > 0) this.LeftLeg.xRot -= 0.05;
			if (this.LeftLeg.yRot > 0) this.LeftLeg.yRot -= 0.05;
			//LeftWing
			//this.LeftWing.x = -1.5F;
			//this.LeftWing.y = 1.0F;
			//this.LeftWing.z = -6.0F;
			if (this.LeftWing.x < -1.5) this.LeftLeg.x += 0.15;
			if (this.LeftWing.y < 1) this.LeftWing.y += 0.15;
			if (this.LeftWing.z > -6) this.LeftWing.z -= 0.15;
			if (this.LeftWing.xRot < 0) this.LeftWing.xRot += 0.05;
			if (this.LeftWing.yRot < 0) this.LeftWing.yRot += 0.05;
			if (this.LeftWing.zRot > 0) this.LeftWing.zRot -= 0.05;
			//LeftThigh
			//this.LeftThigh.y = 15.0F;
			//this.LeftThigh.z = 2.0F;
			if (this.LeftThigh.x > 15) this.LeftThigh.x -= 0.15;
			if (this.LeftThigh.y > 2) this.LeftThigh.y -= 0.15;
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot > 0) this.LeftThigh.yRot -= 0.05;
			//RightThigh
			//this.RightThigh.y = 15.0F;
			//this.RightThigh.z = 2.0F;
			if (this.RightThigh.x > 15) this.RightThigh.x -= 0.15;
			if (this.RightThigh.y > 2) this.RightThigh.y -= 0.15;
			if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.yRot < 0) this.RightThigh.yRot += 0.05;
			//RightLeg
			//this.RightLeg.x = 0.6F;
			//this.RightLeg.y = 5.0F;
			//this.RightLeg.z = 1.0F;
			if (this.RightLeg.x < 0.6) this.RightLeg.x += 0.15;
			if (this.RightLeg.y < 5) this.RightLeg.y += 0.15;
			if (this.RightLeg.z < 1) this.RightLeg.z += 0.15;
			if (this.RightLeg.zRot < 0) this.RightLeg.zRot += 0.05;
			//RightWing
			//this.RightWing.x = 1.5F;
			//this.RightWing.y = 1.0F;
			//this.RightWing.z = -6.0F;
			if (this.RightWing.x > 1.5) this.RightWing.x -= 0.15;
			if (this.RightWing.y > 1) this.RightWing.y -= 0.15;
			if (this.RightWing.z > -6) this.RightWing.z -= 0.15;
			if (this.RightWing.xRot < 0) this.RightWing.xRot += 0.05;
			if (this.RightWing.yRot > 0) this.RightWing.yRot -= 0.05;
			if (this.RightWing.zRot < 0) this.RightWing.zRot += 0.05;
			//Head
			//this.Head.z = -8.0F;
			if (this.Head.z > -8) this.Head.z -= 0.15;
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0) this.Head.yRot += 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
			//Tail1
			//this.Tail1.y = -0.9F;
			if (this.Tail1.y > -0.9) this.Tail1.y -= 0.15;
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			if (this.Tail1.zRot > 0) this.Tail1.zRot -= 0.05;
		}
	}

	public void resetModel() {
		this.Body.xRot = 0;
		this.Body.zRot = -0.0087F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftWing.xRot = 0;
		this.LeftWing.yRot = 0;
		this.LeftWing.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.RightWing.xRot = 0;
		this.RightWing.yRot = 0;
		this.RightWing.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Body.y = 16;
		this.LeftThigh.x = 0.0F;
		this.LeftThigh.y = 2.0F;
		this.LeftThigh.z = 5.9F;
		this.LeftLeg.x = 1F;
		this.LeftLeg.y = 3.0F;
		this.LeftLeg.z = 1.0F;
		this.RightThigh.x = -3.0F;
		this.RightThigh.y = 2.0F;
		this.RightThigh.z = 5.9F;
		this.RightLeg.x = 0F;
		this.RightLeg.y = 3.0F;
		this.RightLeg.z = 1.0F;
		this.LeftWing.x = -0.5F;
		this.LeftWing.y = 2.0F;
		this.LeftWing.z = 1.1F;
		this.RightWing.x = -2.5F;
		this.RightWing.y = 2.0F;
		this.RightWing.z = 1.1F;
		this.Head.z = 0F;
		this.Tail1.y = 1.0F;
	}

	public void sleepPose() {
		this.Body.y = 19.5F;
		this.Body.zRot = 0;
		this.LeftLeg.x = 0.5F;
		this.LeftLeg.y = 3.6F;
		this.LeftLeg.z = 0.5F;
		this.LeftLeg.xRot = 0.07836527941980377F;
		this.LeftLeg.zRot = 0.009250244536227243F;
		this.LeftWing.x = 0.5F;
		this.LeftWing.y = 2.0F;
		this.LeftWing.z = 1.1F;
		this.RightWing.x = -0.5F;
		this.RightWing.y = 2.0F;
		this.RightWing.z = 1.1F;
		this.LeftWing.xRot = -1.6030848913251807F;
		this.LeftWing.yRot = -0.036477379868653376F;
		this.LeftWing.zRot = -0.6003932893176602F;
		this.LeftThigh.y = 3.0F;
		this.LeftThigh.z = 5.0F;
		this.LeftThigh.xRot = -1.6041321794238546F;
		this.LeftThigh.yRot = -0.35185837453889574F;
		this.RightThigh.y = 3.0F;
		this.RightThigh.z = 5.0F;
		this.RightThigh.xRot = -1.5653858487242918F;
		this.RightThigh.yRot = 0.3127630032889644F;
		this.RightLeg.x = 0.5F;
		this.RightLeg.y = 3.6F;
		this.RightLeg.z = 0.9F;
		this.RightLeg.zRot = -0.15620696472454113F;
		this.RightWing.x = -3.5F;
		this.RightWing.y = 2F;
		this.RightWing.z = 1.1F;
		this.RightWing.xRot = -1.486671462175092F;
		this.RightWing.yRot = 0.002617993982021224F;
		this.RightWing.zRot = 0.24015730906916136F;
		this.Head.z = -0.1F;
		this.Head.xRot = 0.23177972000431504F;
		this.Head.yRot = -0.39357173300891585F;
		this.Head.zRot = 0.37262780195869205F;
		this.Tail1.y = 0.9F;
		this.Tail1.xRot = -0.1563815016444822F;
		this.Tail1.yRot = 0.3127630032889644F;
		this.Tail1.zRot = 0.11903145798206952F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}