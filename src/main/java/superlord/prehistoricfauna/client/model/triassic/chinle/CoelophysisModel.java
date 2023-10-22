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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;

public class CoelophysisModel extends EntityModel<Coelophysis> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LArm;
	private final ModelPart RArm;
	private final ModelPart RThigh;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart LThigh;
	private final ModelPart LLeg;
	private final ModelPart LFoot;

	public CoelophysisModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LArm = Body.getChild("LArm");
		this.RArm = Body.getChild("RArm");
		this.RThigh = Body.getChild("RThigh");
		this.RLeg = RThigh.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.LThigh = Body.getChild("LThigh");
		this.LLeg = LThigh.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -8.0F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(82, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.0F, 3.0F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(82, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 4.0F, 3.0F));

		PartDefinition RThigh = Body.addOrReplaceChild("RThigh", CubeListBuilder.create().texOffs(100, 0).mirror().addBox(-1.5F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 2.5F, 11.0F));

		PartDefinition RLeg = RThigh.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 4.5F, 2.0F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LThigh = Body.addOrReplaceChild("LThigh", CubeListBuilder.create().texOffs(100, 0).addBox(-0.5F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.5F, 11.0F));

		PartDefinition LLeg = LThigh.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(6, 3).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 4.5F, 2.0F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(55, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.6F, 14.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 31).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, 6.4F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(41, 13).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Coelophysis entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.LThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
				this.RArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Head.xRot = attackProgress * (float) Math.toRadians(-15F);
				if (entity.isInWater()) {
					this.Body.y = 14;
					this.Body.xRot = -0.5F;
					this.Tail1.xRot = 0.25F;
					this.Tail2.xRot = 0.25F;
					this.Neck.xRot = 0.5F;
					this.RThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LArm.xRot = 0.5F;
					this.RArm.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Neck
			//this.Neck.yRot = -2;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < -2) this.Neck.yRot += 0.05;
			//RLeg
			//this.RLeg.y = 4.5F;
			//this.RLeg.z = 2;
			if (this.RLeg.y < 4.5) this.RLeg.y += 0.15;
			if (this.RLeg.z < 2) this.RLeg.z += 0.15;
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot < 0) this.RLeg.yRot += 0.05;
			if (this.RLeg.zRot < 0) this.RLeg.zRot += 0.05;
			//LThigh
			if (this.LThigh.xRot < 0) this.LThigh.xRot += 0.05;
			if (this.LThigh.yRot < 0) this.LThigh.yRot += 0.05;
			//Tail1
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//RArm
			if (this.RArm.zRot > 0) this.RArm.zRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//RFoot
			if (this.RFoot.xRot > 0) this.RFoot.xRot -= 0.05;
			//LArm
			if (this.LArm.zRot < 0) this.LArm.zRot += 0.05;
			//Body
			//this.Body.y = 11.0F;
			if (this.Body.y > 11) this.Body.y -= 0.15;
			//LLeg
			//this.LLeg.y = 4.5F;
			//this.LLeg.z = 2;
			if (this.LLeg.y < 4.5) this.LLeg.y += 0.15;
			if (this.LLeg.z < 2) this.LLeg.z += 0.15;
			if (this.LLeg.xRot < 0) this.LLeg.xRot += 0.05;
			if (this.LLeg.yRot > 0) this.LLeg.yRot -= 0.05;
			if (this.LLeg.zRot > 0) this.LLeg.zRot -= 0.05;
			//RThigh
			if (this.RThigh.xRot < 0) this.RThigh.xRot += 0.05;
			if (this.RThigh.yRot > 0) this.RThigh.yRot -= 0.05;
			//LFoot
			if (this.LFoot.xRot > 0) this.LFoot.xRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Neck
			//this.Neck.yRot = -2;
			if (this.Neck.xRot < 0.6646214111173737F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -2.3848178792724077F) this.Neck.yRot -= 0.05;
			//RLeg
			//this.RLeg.y = 4.5F;
			//this.RLeg.z = 2;
			if (this.RLeg.y > 4.2) this.RLeg.y -= 0.15;
			if (this.RLeg.z > 0.9) this.RLeg.z -= 0.15;
			if (this.RLeg.xRot > -0.3979350561389017F) this.RLeg.xRot -= 0.05;
			if (this.RLeg.yRot > -0.0781907508222411F) this.RLeg.yRot -= 0.05;
			if (this.RLeg.zRot > -0.27366763203903305F) this.RLeg.zRot -= 0.05;
			//LThigh
			if (this.LThigh.xRot > -1.1728612040769677F) this.LThigh.xRot -= 0.05;
			if (this.LThigh.yRot > -0.46914448828868976F) this.LThigh.yRot -= 0.05;
			//Tail1
			if (this.Tail1.xRot > -0.23457224414434488F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0.5864306020384839F) this.Tail1.yRot += 0.05;
			//RArm
			if (this.RArm.zRot < 1.3292428222347474F) this.RArm.zRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.11728612207217244F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0.7037167490777915F) this.Tail2.yRot += 0.05;
			//RFoot
			if (this.RFoot.xRot < 1.5707963267948966F) this.RFoot.xRot += 0.05;
			//LArm
			if (this.LArm.zRot > -1.3264502315156905F) this.LArm.zRot -= 0.05;
			//Body
			//this.Body.y = 11.0F;
			if (this.Body.y < 19) this.Body.y += 0.15;
			//LLeg
			//this.LLeg.y = 4.5F;
			//this.LLeg.z = 2;
			if (this.LLeg.y > 4.2) this.LLeg.y -= 0.15;
			if (this.LLeg.z > 0.9) this.LLeg.z -= 0.15;
			if (this.LLeg.xRot > -0.3979350561389017F) this.LLeg.xRot -= 0.05;
			if (this.LLeg.yRot < 0.0781907508222411F) this.LLeg.yRot += 0.05;
			if (this.LLeg.zRot < 0.27366763203903305F) this.LLeg.zRot += 0.05;
			//RThigh
			if (this.RThigh.xRot > -1.1728612040769677F) this.RThigh.xRot -= 0.05;
			if (this.RThigh.yRot < 0.46914448828868976F) this.RThigh.yRot += 0.05;
			//LFoot
			if (this.LFoot.xRot < 1.5707963267948966F) this.LFoot.xRot += 0.05;
		}
	}

	public void resetModel() {
		this.Neck.xRot = 0;
		this.Neck.yRot = -2;
		this.RLeg.y = 4.5F;
		this.RLeg.z = 2;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.RLeg.zRot = 0;
		this.LThigh.xRot = 0;
		this.LThigh.yRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.RArm.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.RFoot.xRot = 0;
		this.LArm.zRot = 0;
		this.Body.y = 11.0F;
		this.LLeg.y = 4.5F;
		this.LLeg.z = 2;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RThigh.xRot = 0;
		this.RThigh.yRot = 0;
		this.LFoot.xRot = 0;
		this.Body.xRot = 0;
	}

	public void sleepPose() {
		this.Neck.xRot = 0.6646214111173737F;
		this.Neck.yRot = -2.3848178792724077F;
		this.RLeg.y = 4.2F;
		this.RLeg.z = 0.9F;
		this.RLeg.xRot = -0.3979350561389017F;
		this.RLeg.yRot = -0.0781907508222411F;
		this.RLeg.zRot = -0.27366763203903305F;
		this.LThigh.xRot = -1.1728612040769677F;
		this.LThigh.yRot = -0.46914448828868976F;
		this.Tail1.xRot = -0.23457224414434488F;
		this.Tail1.yRot = 0.5864306020384839F;
		this.RArm.zRot = 1.3292428222347474F;
		this.Tail2.xRot = 0.11728612207217244F;
		this.Tail2.yRot = 0.7037167490777915F;
		this.RFoot.xRot = 1.5707963267948966F;
		this.LArm.zRot = -1.3264502315156905F;
		this.Body.y = 19;
		this.LLeg.y = 4.2F;
		this.LLeg.z = 0.9F;
		this.LLeg.xRot = -0.3979350561389017F;
		this.LLeg.yRot = 0.0781907508222411F;
		this.LLeg.zRot = 0.27366763203903305F;
		this.RThigh.xRot = -1.1728612040769677F;
		this.RThigh.yRot = 0.46914448828868976F;
		this.LFoot.xRot = 1.5707963267948966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}