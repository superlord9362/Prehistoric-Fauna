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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;

public class DakotaraptorModel extends EntityModel<Dakotaraptor> {
	private final ModelPart LeftLeg1;
	private final ModelPart RightLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart RightLeg2;
	private final ModelPart Body;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Feathers;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Snout;

	public DakotaraptorModel(ModelPart root) {
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.Body = root.getChild("Body");
		this.RightWing = Body.getChild("RightWing");
		this.LeftWing = Body.getChild("LeftWing");
		this.Neck = Body.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.Feathers = Tail2.getChild("Feathers");
		this.Snout = Head1.getChild("Snout");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(94, 71).mirror().addBox(-2.0F, -3.0F, -4.0F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 3.9F, 1.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(70, 71).mirror().addBox(-3.0F, 0.0F, -6.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 9.0F, 5.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(94, 71).mirror().addBox(-3.0F, -3.0F, -4.0F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 3.9F, 1.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(70, 71).addBox(-2.0F, 0.0F, -6.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, 5.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(3, 2).addBox(-5.0F, -7.0F, -16.0F, 10.0F, 14.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.9F, 1.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 84).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -14.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(30, 77).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 1.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 102).addBox(-2.0F, 0.0F, -10.0F, 4.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -9.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 1.0F, -14.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.0F, -14.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 5.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(73, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 5.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 23.0F));

		PartDefinition Feathers = Tail2.addOrReplaceChild("Feathers", CubeListBuilder.create().texOffs(55, 30).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Dakotaraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31 && entity.getCrouchingTicks() >= 31 && entity.getSittingTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
				this.RightLeg1.xRot = -1.5707963267948966F + (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
				this.RightWing.zRot = -1.092750655326294F + (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
			} else if (entity.isCrouching()) {
				this.Body.xRot =  0.39269908169872414F;
				this.LeftWing.zRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount + 0.4F;
		    	this.RightWing.zRot = Mth.cos(3.0F + limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount - 0.4F;
		    	this.Body.xRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.2F * limbSwingAmount + 0.5F;
		    	this.RightLeg1.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
		    	this.RightLeg2.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
		    	this.LeftLeg1.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
		    	this.LeftLeg2.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
		    	this.Tail1.xRot = -0.08464846705724931F + (Mth.cos(limbSwing * speed * 0.05F) * degree * 0.3F * limbSwingAmount - 0.3F);
		    	this.Tail2.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.1F;
		    	this.Tail2.zRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.4F * limbSwingAmount;
			} else if (entity.isSitting()) {
				this.Tail2.xRot = 0.13665927909957545F;
				this.LeftWing.xRot = 0.7740534966278743F;
				this.LeftWing.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
				this.Neck.xRot = 0.6829473549475088F;
				this.RightWing.xRot = 0.7740534966278743F;
				this.RightWing.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
				this.Body.xRot = -0.6373942508178124F;
				this.RightLeg1.xRot = -1.5707963267948966F;
				this.RightLeg1.yRot = -0.18203784630933073F;
				this.LeftLeg1.xRot = -1.5707963267948966F;
				this.LeftLeg1.yRot = 0.18203784630933073F;
				this.Tail1.xRot = 0.500909508638178F;
				this.Body.y = 14.9F;
				this.RightLeg1.y = 18.9F;
				this.RightLeg1.z = 3;
				this.RightLeg2.y = 7;
				this.LeftLeg2.y = 7;
				this.LeftLeg1.y = 18.9F;
				this.LeftLeg1.z = 3;
				this.Neck.y = -4;
				this.Neck.z = -16;
				this.Head1.z = 0;
				this.Tail1.z = 3;
			} else {
				resetModel();
				this.RightLeg1.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
				this.LeftLeg1.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.2F) * degree * 0.05F * limbSwingAmount + 0.05F) + attackProgress * (float) Math.toRadians(25F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.05F);
				this.Tail2.zRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount;
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
				this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
				this.Head1.xRot = -Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.RightWing.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
				this.LeftWing.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
				this.RightWing.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
				this.LeftWing.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
			}
			if (entity.isInWater()) {
				this.RightLeg1.y = 20;
				this.LeftLeg1.y = 20;
				this.Body.y = 16;
				this.Body.xRot = -0.5F;
				this.Tail1.xRot = 0.25F;
				this.Tail2.xRot = 0.25F;
				this.Neck.xRot = 0.5F;
				this.RightWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.LeftWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.RightLeg1.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg1.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail1.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.Tail2.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.RightLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LeftWing
			if (this.LeftWing.xRot > 0) this.LeftWing.xRot -= 0.05;
			if (this.LeftWing.zRot > 0) this.LeftWing.zRot -= 0.05;
			//LeftLeg1
//			this.LeftLeg1.y = 3.9F;
//			this.LeftLeg1.z = 1;
			if (this.LeftLeg1.y > 3.9F) this.LeftLeg1.y -= 0.15;
			if (this.LeftLeg1.z > 1F) this.LeftLeg1.z -= 0.15;
			if (this.LeftLeg1.xRot < 0) this.LeftLeg1.xRot += 0.05;
			if (this.LeftLeg1.yRot > 0) this.LeftLeg1.yRot -= 0.05;
			//RightLeg1
//			this.RightLeg1.y = 3.9F;
//			this.RightLeg1.z = 1;
			if (this.RightLeg1.y > 3.9F) this.RightLeg1.y -= 0.15;
			if (this.RightLeg1.z > 1F) this.RightLeg1.z -= 0.15;
			if (this.RightLeg1.xRot < 0) this.RightLeg1.xRot += 0.05;
			if (this.RightLeg1.yRot < 0) this.RightLeg1.yRot += 0.05;
			//RightWing
			if (this.RightWing.xRot > 0) this.RightWing.xRot -= 0.05;
			if (this.RightWing.zRot < 0) this.RightWing.zRot += 0.05;
			//Neck
//			this.Neck.y = -6;
//			this.Neck.z = -14;
			if (this.Neck.y > -6) this.Neck.y -= 0.15;
			if (this.Neck.z < -14F) this.Neck.z += 0.15;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			//Tail1
//			this.Tail1.x = 0;
//			this.Tail1.xRot = -0.04555309164612875F;
			if (this.Tail1.x < 0) this.Tail1.x += 0.15;
			if (this.Tail1.z < 5) this.Tail1.z += 0.15;
			if (this.Tail1.xRot < -0.04555309164612875F) this.Tail1.xRot += 0.05;
			if (this.Tail1.xRot > -0.04555309164612875F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot < 0) this.Tail2.xRot += 0.05;
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//Body
//			this.Body.y = 3.9F;
//			this.Body.z = 1;
			if (this.Body.y > 3.9F) this.Body.x -= 0.15;
			if (this.Body.z > 1F) this.Body.z -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//RightLeg2
//			this.RightLeg2.y = 9;
			if (this.RightLeg2.y < 9F) this.RightLeg2.x += 0.15;
			//LeftLeg2
//			this.LeftLeg2.y = 9;
			if (this.LeftLeg2.y < 9F) this.LeftLeg2.x += 0.15;
			//Head1
//			this.Head1.z = 1;
			if (this.Head1.z < 1F) this.Head1.z += 0.15;
		}
		if (entity.getCrouchingTicks() < 31) {
			if (this.Body.xRot < 0.39269908169872414F) this.Body.xRot += 0.05;
			if (this.Tail1.xRot > -0.08464846705724931F) this.Tail1.xRot -= 0.05;
		}
		if (entity.getSittingTicks() < 31) {
			//Tail2
			if (this.Tail2.xRot < 0.13665927909957545F) this.Tail2.xRot += 0.05;
			//LeftWing
			if (this.LeftWing.xRot < 0.7740534966278743F) this.LeftWing.xRot += 0.05;
			//Neck
			if (this.Neck.y < -4) this.Neck.y += 0.15;
			if (this.Neck.z > -16) this.Neck.z -= 0.15;
			if (this.Neck.xRot < 0.6829473549475088F) this.Neck.xRot += 0.05;
			//RightWing
			if (this.RightWing.xRot < 0.7740534966278743F) this.RightWing.xRot += 0.05;
			//Body
			if (this.Body.y < 14.9) this.Body.y += 0.15;
			if (this.Body.xRot > -0.6373942508178124F) this.Body.xRot -= 0.05;
			//RightLeg1
			if (this.RightLeg1.y < 18.9) this.RightLeg1.y += 0.15;
			if (this.RightLeg1.z < 3) this.RightLeg1.z += 0.15;
			if (this.RightLeg1.xRot > -1.5707963267948966F) this.RightLeg1.xRot -= 0.05;
			if (this.RightLeg1.yRot > -0.18203784630933073F) this.RightLeg1.yRot -= 0.05;
			//LeftLeg1
			if (this.LeftLeg1.y < 18.9) this.LeftLeg1.y += 0.15;
			if (this.LeftLeg1.z < 3) this.LeftLeg1.z += 0.15;
			if (this.LeftLeg1.xRot > -1.5707963267948966F) this.LeftLeg1.xRot -= 0.05;
			if (this.LeftLeg1.yRot < 0.18203784630933073F) this.LeftLeg1.yRot += 0.05;
			//Tail1
			if (this.Tail1.z > 3) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot < 0.500909508638178F) this.Tail1.xRot += 0.05;
			//RightLeg2
			if (this.RightLeg2.y > 7) this.RightLeg2.y -= 0.15;
			//LeftLeg2
			if (this.LeftLeg2.y > 7) this.LeftLeg2.y -= 0.15;
			//Head1
			if (this.Head1.z > 0) this.Head1.z -= 0.15;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//LeftWing
			if (this.LeftWing.zRot < 1.092750655326294F) this.LeftWing.zRot += 0.05;
			//LeftLeg1
			//this.LeftLeg1.y = 3.9F;
			//this.LeftLeg1.z = 1;
			if (this.LeftLeg1.y < 18.9F) this.LeftLeg1.y += 0.15;
			if (this.LeftLeg1.z < 6F) this.LeftLeg1.z += 0.15;
			if (this.LeftLeg1.xRot > -1.5707963267948966F) this.LeftLeg1.xRot -= 0.05;
			//RightLeg1
			//this.RightLeg1.y = 3.9F;
			//this.RightLeg1.z = 1;
			if (this.RightLeg1.y < 18.9F) this.RightLeg1.y += 0.15;
			if (this.RightLeg1.z < 6F) this.RightLeg1.z += 0.15;
			if (this.RightLeg1.xRot > -1.5707963267948966F) this.RightLeg1.xRot -= 0.05;
			//RightWing
			if (this.RightWing.zRot > -1.092750655326294F) this.RightWing.zRot -= 0.05;
			//Neck
			//this.Neck.y = -6;
			//this.Neck.z = -14;
			if (this.Neck.y < 1) this.Neck.y += 0.15;
			if (this.Neck.z > -16F) this.Neck.z -= 0.15;
			if (this.Neck.yRot > -1.4570009181544104F) this.Neck.yRot -= 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.xRot = -0.04555309164612875F;
			if (this.Tail1.x > -3) this.Tail1.x -= 0.15;
			if (this.Tail1.xRot > -0.2275909337942703F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 1.5707963267948966F) this.Tail1.yRot += 0.05;
			//Tail2
			if (this.Tail2.xRot > -0.04555309164612875F) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 1.8668041519541685F) this.Tail2.yRot += 0.05;
			//Body
			//this.Body.y = 3.9F;
			//this.Body.z = 1;
			if (this.Body.y < 16.9F) this.Body.x += 0.15;
			if (this.Body.z < 5F) this.Body.z += 0.15;
			//RightLeg2
			//this.RightLeg2.y = 9;
			if (this.RightLeg2.y > 2F) this.RightLeg2.x -= 0.15;
			//LeftLeg2
			//this.LeftLeg2.y = 9;
			if (this.LeftLeg2.y > 2F) this.LeftLeg2.x -= 0.15;
			//Head1
			//this.Head1.z = 1;
			if (this.Head1.z > 0F) this.Head1.z -= 0.15;
		}
	}
	
	public void resetModel() {
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.RightLeg1.zRot = 0;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.LeftLeg1.zRot = 0;
		this.RightLeg2.xRot = 0;
		this.RightLeg2.yRot = 0;
		this.RightLeg2.zRot = 0;
		this.LeftLeg2.xRot = 0;
		this.LeftLeg2.yRot = 0;
		this.LeftLeg2.zRot = 0;
		this.LeftWing.xRot = 0;
		this.LeftWing.yRot = 0;
		this.LeftWing.zRot = 0;
		this.RightWing.xRot = 0;
		this.RightWing.yRot = 0;
		this.RightWing.zRot = 0;
		this.Tail1.xRot = -0.04555309164612875F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Neck.xRot = 0.13962634015954636F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Feathers.xRot = 0;
		this.Feathers.yRot = 0;
		this.Feathers.zRot = 0;
		this.Head1.xRot = 0;
		this.Head1.yRot = 0;
		this.Head1.zRot = 0;
		this.Snout.xRot = 0;
		this.Snout.yRot = 0;
		this.Snout.zRot = 0;
		this.Body.x = 0;
		this.Body.y = 3.9F;
		this.Body.z = 1;
		this.Neck.x = 0;
		this.Neck.y = -6;
		this.Neck.z = -14;
		this.Head1.x = 0;
		this.Head1.y = -8;
		this.Head1.z = 1;
		this.RightWing.x = 5;
		this.RightWing.y = 1;
		this.RightWing.z = -14;
		this.LeftWing.x = -5;
		this.LeftWing.y = 1;
		this.LeftWing.z = -14;
		this.Tail1.x = 0;
		this.Tail1.y = -4;
		this.Tail1.z = 5;
		this.Tail2.x = 0;
		this.Tail2.y = 0;
		this.Tail2.z = 23;
		this.RightLeg1.x = 5;
		this.RightLeg1.y = 3.9F;
		this.RightLeg1.z = 1;
		this.RightLeg2.x = -1;
		this.RightLeg2.y = 9;
		this.RightLeg2.z = 5;
		this.LeftLeg1.x = -5;
		this.LeftLeg1.y = 3.9F;
		this.LeftLeg1.z = 1;
		this.LeftLeg2.x = 1;
		this.LeftLeg2.y = 9;
		this.LeftLeg2.z = 5;
	}
	
	public void sleepPose() {
		this.LeftWing.zRot = 1.092750655326294F;
		this.LeftLeg1.xRot = -1.5707963267948966F;
		this.Neck.xRot = 0.13665927909957545F;
		this.Neck.yRot = -1.4570009181544104F;
		this.Tail1.xRot = -0.2275909337942703F;
		this.Tail1.yRot = 1.5707963267948966F;
		this.Tail2.xRot = -0.04555309164612875F;
		this.Tail2.yRot = 1.8668041519541685F;
		this.Body.y = 16.9F;
		this.Body.z = 5;
		this.RightLeg1.x = 5;
		this.RightLeg1.y = 18.9F;
		this.RightLeg1.z = 6;
		this.RightLeg2.y = 2;
		this.LeftLeg1.x = -5;
		this.LeftLeg1.y = 18.9F;
		this.LeftLeg1.z = 6;
		this.LeftLeg2.y = 2;
		this.Neck.y = 1;
		this.Neck.z = -16;
		this.Head1.z = 0;
		this.Tail1.x = -3;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
