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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ornithomimus;

public class OrnithomimusModel extends EntityModel<Ornithomimus> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public OrnithomimusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = Body.getChild("Neck1");
		this.Neck2 = Neck1.getChild("Neck2");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LeftWing = Body.getChild("LeftWing");
		this.RightWing = Body.getChild("RightWing");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, -22.0F, -11.0F, 8.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(38, 0).addBox(-2.5F, -0.4F, 2.0F, 5.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.5F, 4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(30, 60).addBox(-1.5F, -1.05F, -1.0F, 3.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, 15.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition TailFan = Tail2.addOrReplaceChild("TailFan", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.05F, 5.0F, 8.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, -2.5F, -4.5F, 4.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -17.5F, 3.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(45, 27).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 7.5F, 1.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(95, 29).mirror().addBox(-2.5F, 0.0F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 63).mirror().addBox(-1.5F, -2.5F, -4.5F, 4.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -17.5F, 3.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(45, 27).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 7.5F, 1.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(95, 29).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -7.75F, -4.75F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.25F, -10.25F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(35, 27).addBox(-1.0F, -10.0F, -2.75F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.75F, 1.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(7, 16).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -0.75F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(38, 0).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck2Feathers = Neck2.addOrReplaceChild("Neck2Feathers", CubeListBuilder.create().texOffs(40, 63).addBox(0.0F, -7.0F, -6.75F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition NeckFeathers = Neck1.addOrReplaceChild("NeckFeathers", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -7.75F, -7.75F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(24, 65).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -16.5F, -9.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(24, 65).mirror().addBox(-2.0F, -0.5F, -1.0F, 2.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -16.5F, -9.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Ornithomimus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			//RightWing
			if (this.RightWing.xRot < 0.8932595164970201F) this.RightWing.xRot += 0.05;
			if (this.RightWing.yRot < 0.19547687289441354F) this.RightWing.yRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.20943951023931953F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > -0.5585053606381855F) this.Tail2.yRot -= 0.05;
			//Body
			//this.Body.y = -1.1F;
			if (this.Body.y < 10.5) this.Body.y += 0.15;
			if (this.Body.xRot > -0.10471975511965977F) this.Body.xRot -= 0.05;
			//LeftFoot
			//this.LeftFoot.z = 0.0F;
			if (this.LeftFoot.z > -1) this.LeftFoot.z -= 0.15;
			if (this.LeftFoot.xRot < 1.5707963267948966F) this.LeftFoot.xRot += 0.05;
			//Neck2
			//this.Neck2.x = 0;
			//this.Neck2.z = -3;
			if (this.Neck2.x < 2) this.Neck2.x += 0.15;
			if (this.Neck2.z > -5) this.Neck2.z -= 0.15;
			if (this.Neck2.xRot > -0.7864453849170947F) this.Neck2.xRot -= 0.05;
			if (this.Neck2.yRot < 0.6658431362674476F) this.Neck2.yRot += 0.05;
			if (this.Neck2.zRot > -1.1339404363260046F) this.Neck2.zRot -= 0.05;
			//Tail1
			//this.Tail1.z = 4.0F;
			if (this.Tail1.z > 1.5) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot > -0.24434609527920614F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot > -0.3490658503988659F) this.Tail1.yRot -= 0.05;
			//RightFoot
			//this.RightFoot.z = 0.0F;
			if (this.RightFoot.z > -1) this.RightFoot.z -= 0.15;
			if (this.RightFoot.xRot < 1.5707963267948966F) this.RightFoot.xRot += 0.05;
			//RightLeg
			if (this.RightLeg.xRot > -0.8377580409572781F) this.RightLeg.xRot -= 0.05;
			//LeftLeg
			if (this.LeftLeg.xRot > -0.8377580409572781F) this.LeftLeg.xRot -= 0.05;
			//Neck1
			if (this.Neck1.xRot < 1.0929251589567215F) this.Neck1.xRot += 0.05;
			if (this.Neck1.yRot < 1.2117821049859852F) this.Neck1.yRot += 0.05;
			if (this.Neck1.zRot < 0.2350958549041681F) this.Neck1.zRot += 0.05;
			//LeftThigh
			//this.LeftThigh.x = -2;
			//this.LeftThigh.y = -1;
			//this.LeftThigh.z = 2;
			if (this.LeftThigh.x > -4) this.LeftThigh.x -= 0.15;
			if (this.LeftThigh.y < 10.7) this.LeftThigh.y += 0.15;
			if (this.LeftThigh.z < 10) this.LeftThigh.z += 0.15;
			if (this.LeftThigh.xRot > -0.7330382858376184F) this.LeftThigh.xRot -= 0.05;
			if (this.LeftThigh.yRot < 0.24434609527920614F) this.LeftThigh.yRot += 0.05;
			//RightThigh
			//this.RightThigh.x = 2;
			//this.RightThigh.y = -1;
			if (this.RightThigh.x < 4) this.RightThigh.x += 0.15;
			if (this.RightThigh.y < 10.7) this.RightThigh.y += 0.15;
			if (this.RightThigh.xRot > -0.7330382858376184F) this.RightThigh.xRot -= 0.05;
			if (this.RightThigh.yRot > -0.24434609527920614F) this.RightThigh.yRot -= 0.05;
			//LeftWing
			if (this.LeftWing.xRot < 0.6066764186984569F) this.LeftWing.xRot += 0.05;
			if (this.LeftWing.yRot < 0.10471975511965977F) this.LeftWing.yRot += 0.05;
			sleepPose();
		} else {
			this.Neck1.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
			this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
			this.Neck2.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-25F);
			this.RightWing.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.LeftWing.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
			this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
			this.Neck1.yRot = netHeadYaw * ((float) Math.PI / 180F);
			if (entity.isInWater()) {
				this.RightThigh.y = 20;
				this.LeftThigh.y = 20;
				this.Body.y = 20;
				this.Body.xRot = -0.25F;
				this.Tail1.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Neck1.xRot = 0.5F;
				this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.LeftWing.xRot = 0.25F;
				this.RightWing.xRot = 0.25F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//RightWing
			if (this.RightWing.xRot > 0) this.RightWing.xRot -= 0.05;
			if (this.RightWing.yRot > 0) this.RightWing.yRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			//Body
			//this.Body.y = -1.1F;
			if (this.Body.y > -1.1) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//LeftFoot
			//this.LeftFoot.z = 0.0F;
			if (this.LeftFoot.z < 0) this.LeftFoot.z += 0.15;
			if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
			//Neck2
			//this.Neck2.x = 0;
			//this.Neck2.z = -3;
			if (this.Neck2.x > 0) this.Neck2.x -= 0.15;
			if (this.Neck2.z < -3) this.Neck2.z += 0.15;
			if (this.Neck2.xRot < 0) this.Neck2.xRot += 0.05;
			if (this.Neck2.yRot > 0) this.Neck2.yRot -= 0.05;
			if (this.Neck2.zRot < 0) this.Neck2.zRot += 0.05;
			//Tail1
			//this.Tail1.z = 4.0F;
			if (this.Tail1.z < 4) this.Tail1.z += 0.15;
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
			//RightFoot
			//this.RightFoot.z = 0.0F;
			if (this.RightFoot.z < -0) this.RightFoot.z += 0.15;
			if (this.RightFoot.xRot > 0) this.RightFoot.xRot -= 0.05;
			//RightLeg
			if (this.RightLeg.xRot < 0) this.RightLeg.xRot += 0.05;
			//LeftLeg
			if (this.LeftLeg.xRot < 0) this.LeftLeg.xRot += 0.05;
			//Neck1
			if (this.Neck1.xRot > 0) this.Neck1.xRot -= 0.05;
			if (this.Neck1.yRot > 0) this.Neck1.yRot -= 0.05;
			if (this.Neck1.zRot > 0) this.Neck1.zRot -= 0.05;
			//LeftThigh
			//this.LeftThigh.x = -2;
			//this.LeftThigh.y = -1;
			//this.LeftThigh.z = 2;
			if (this.LeftThigh.x < -2) this.LeftThigh.x += 0.15;
			if (this.LeftThigh.y > -1) this.LeftThigh.y -= 0.15;
			if (this.LeftThigh.z > 2) this.LeftThigh.z -= 0.15;
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot > 0) this.LeftThigh.yRot -= 0.05;
			//RightThigh
			//this.RightThigh.x = 2;
			//this.RightThigh.y = -1;
			if (this.RightThigh.x > 2) this.RightThigh.x -= 0.15;
			if (this.RightThigh.y > -1) this.RightThigh.y -= 0.15;
			if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.yRot < 0) this.RightThigh.yRot += 0.05;
			//LeftWing
			if (this.LeftWing.xRot > 0) this.LeftWing.xRot -= 0.05;
			if (this.LeftWing.yRot > 0) this.LeftWing.yRot -= 0.05;
		}
	}

	public void resetModel() {
		this.RightWing.xRot = 0;
		this.LeftWing.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Body.y = 24F;
		this.Body.xRot = 0;
		this.LeftFoot.z = 0.0F;
		this.LeftFoot.xRot = 0;
		this.Neck2.x = 0;
		this.Neck2.z = 1;
		this.Neck2.xRot = -0.1309F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Tail1.z = 4.0F;
		this.Tail1.xRot = -0.1309F;
		this.Tail1.yRot = 0;
		this.RightFoot.z = 0.0F;
		this.RightFoot.xRot = 0;
		this.RightLeg.xRot = 0;
		this.LeftLeg.xRot = 0;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.LeftThigh.x = 3.5F;
		this.LeftThigh.y = -17.6F;
		this.LeftThigh.z = 3.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightThigh.x = -3.5F;
		this.RightThigh.y = -17.6F;
		this.RightThigh.z = 3.5F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.LeftWing.xRot = 0F;
		this.LeftWing.zRot = 0F;
		this.Neck1.z = -10.25F;
	}

	public void sleepPose() {
		this.RightWing.xRot = 0.8932595164970201F;
		this.RightWing.yRot = 0.19547687289441354F;
		this.Tail2.xRot = 0.20943951023931953F;
		this.Tail2.yRot = -0.5585053606381855F;
		this.Body.y = 10.5F;
		this.Body.xRot = -0.10471975511965977F;
		this.LeftFoot.z = -1.0F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.Neck2.x = 2;
		this.Neck2.z = -5;
		this.Neck2.xRot = -0.7864453849170947F;
		this.Neck2.yRot = 0.6658431362674476F;
		this.Neck2.zRot = -1.1339404363260046F;
		this.Tail1.z = 1.5F;
		this.Tail1.xRot = -0.24434609527920614F;
		this.Tail1.yRot = -0.3490658503988659F;
		this.RightFoot.z = -1;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightLeg.xRot = -0.8377580409572781F;
		this.LeftLeg.xRot = -0.8377580409572781F;
		this.Neck1.xRot = 1.0929251589567215F;
		this.Neck1.yRot = 1.2117821049859852F;
		this.Neck1.zRot = 0.2350958549041681F;
		this.LeftThigh.x = -4;
		this.LeftThigh.y = 10.7F;
		this.LeftThigh.z = 10;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = 0.24434609527920614F;
		this.RightThigh.x = 4;
		this.RightThigh.y = 10.7F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = -0.24434609527920614F;
		this.LeftWing.xRot = 0.6066764186984569F;
		this.LeftWing.zRot = 0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}