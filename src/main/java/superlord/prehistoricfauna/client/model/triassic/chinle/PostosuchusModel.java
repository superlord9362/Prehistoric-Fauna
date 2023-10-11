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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;

public class PostosuchusModel extends EntityModel<Postosuchus> {
	private final ModelPart Thigh;
	private final ModelPart Calf;
	private final ModelPart Foot;
	private final ModelPart Thigh_1;
	private final ModelPart Calf_1;
	private final ModelPart Foot_1;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart Arm;
	private final ModelPart Arm_1;

	public PostosuchusModel(ModelPart root) {
		this.Thigh = root.getChild("Thigh");
		this.Calf = Thigh.getChild("Calf");
		this.Foot = Calf.getChild("Foot");
		this.Thigh_1 = root.getChild("Thigh_1");
		this.Calf_1 = Thigh_1.getChild("Calf_1");
		this.Foot_1 = Calf_1.getChild("Foot_1");
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.Tail = Body.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.Arm = Body.getChild("Arm");
		this.Arm_1 = Body.getChild("Arm_1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thigh = partdefinition.addOrReplaceChild("Thigh", CubeListBuilder.create().texOffs(79, 1).addBox(-4.0F, 0.0F, -5.0F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 6.0F, 8.0F, -0.35F, 0.1745F, 0.0F));

		PartDefinition Calf = Thigh.addOrReplaceChild("Calf", CubeListBuilder.create().texOffs(82, 23).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 11.0F, -4.0F, 0.35F, 0.0F, 0.0F));

		PartDefinition Foot = Calf.addOrReplaceChild("Foot", CubeListBuilder.create().texOffs(78, 38).addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 2.0F));

		PartDefinition Thigh_1 = partdefinition.addOrReplaceChild("Thigh_1", CubeListBuilder.create().texOffs(79, 1).mirror().addBox(-1.0F, 0.0F, -5.0F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 6.0F, 8.0F, -0.35F, -0.1745F, 0.0F));

		PartDefinition Calf_1 = Thigh_1.addOrReplaceChild("Calf_1", CubeListBuilder.create().texOffs(82, 23).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 11.0F, -4.0F, 0.35F, 0.0F, 0.0F));

		PartDefinition Foot_1 = Calf_1.addOrReplaceChild("Foot_1", CubeListBuilder.create().texOffs(78, 38).mirror().addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.0F, 2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -6.0F, -23.0F, 10.0F, 11.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 5.0F));

		PartDefinition Arm_1 = Body.addOrReplaceChild("Arm_1", CubeListBuilder.create().texOffs(54, 46).mirror().addBox(-1.0F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 2.0F, -19.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(1, 2).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -23.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(107, 3).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(106, 26).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition JawSnout = Jaw.addOrReplaceChild("JawSnout", CubeListBuilder.create().texOffs(131, 24).addBox(-1.5F, -1.0F, -7.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

		PartDefinition JawTeeth = JawSnout.addOrReplaceChild("JawTeeth", CubeListBuilder.create().texOffs(159, 20).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.5F));

		PartDefinition Cheek = Jaw.addOrReplaceChild("Cheek", CubeListBuilder.create().texOffs(108, 16).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(130, 1).addBox(-1.5F, -4.0F, -7.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition SnoutTeeth = Snout.addOrReplaceChild("SnoutTeeth", CubeListBuilder.create().texOffs(156, 6).addBox(-1.0F, -1.01F, -7.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.01F));

		PartDefinition Arm = Body.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(54, 46).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, -19.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 44).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 5.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 80).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 21.0F, 0.1F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(Postosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Head.y = 0.6F;
		    	this.Head.xRot = -0.5235987755982988F;
		    	this.Jaw.xRot = 0.5235987755982988F;
		    	this.Foot.xRot = 0.41887902047863906F;
				this.Tail2.yRot = 0.27366763203903305F;
				this.Tail2.zRot = 0.03909537541112055F;
				this.Arm.xRot = -0.8203047484373349F;
				this.Arm.zRot = 1.5707963267948966F;
				this.Neck.y = -1.0F;
				this.Neck.z = -23.5F;
				this.Neck.xRot = -0.10471975511965977F;
				this.Neck.yRot = -0.3490658503988659F;
				this.Foot_1.xRot = 0.41887902047863906F;
				this.Thigh_1.y = 21.5F;
				this.Thigh_1.z = 7.0F;
				this.Thigh_1.xRot = -1.9198621771937625F;
				this.Thigh_1.yRot = -0.45378560551852565F;
				this.Tail.x = 0.4F;
				this.Tail.y = -4.0F;
				this.Tail.xRot = -0.17453292519943295F;
				this.Tail.yRot = 0.41887902047863906F;
				this.Body.y = 19.0F;
				this.Body.xRot = 0.10471975511965977F;
				this.Arm_1.xRot = -0.8203047484373349F;
				this.Arm_1.zRot = -1.5707963267948966F;
				this.Calf.z = -2.6F;
				this.Calf.xRot = 1.5009831567151235F;
				this.Thigh.x = -2.5F;
				this.Thigh.y = 21.5F;
				this.Thigh.z = 7.0F;
				this.Thigh.xRot = -1.9198621771937625F;
				this.Thigh.yRot = 0.41887902047863906F;
				this.Calf_1.z = -2.6F;
				this.Calf_1.xRot = 1.5009831567151235F;
			}
		}
		if (wakingProgress != 0) {
			//Head
//    		this.Head.y = 0.0F;
    		if (this.Head.y > 0) this.Head.y -= 0.15;
    		if (this.Head.xRot < 0) this.Head.xRot += 0.05;
    		//Jaw
    		if (this.Jaw.xRot > 0) this.Jaw.xRot -= 0.05;
    		//Foot
    		if (this.Foot.xRot > 0) this.Foot.xRot -= 0.05;
    		//Tail2
    		if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
    		if (this.Tail2.zRot > 0) this.Tail2.zRot -= 0.05;
    		//Arm
//    		this.Arm.xRot = 0.3490658503988659F;
    		if (this.Arm.xRot < 0.3490658503988659F) this.Arm.xRot += 0.05;
    		if (this.Arm.zRot > 0) this.Arm.zRot -= 0.05;
    		//Neck
//    		this.Neck.y = -3.0F;
//    		this.Neck.z = -23.0F;
    		if (this.Neck.y > -3) this.Neck.y -= 0.15;
    		if (this.Neck.z < -23) this.Neck.z += 0.15;
    		if (this.Neck.xRot < 0) this.Neck.xRot += 0.05;
    		if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
    		//Foot_1
    		if (this.Foot_1.xRot > 0) this.Foot_1.xRot -= 0.05;
    		//Thigh_1
//    		this.Thigh_1.y = 6.0F;
//    		this.Thigh_1.z = 8.0F;
//    		this.Thigh_1.xRot = -0.3490658503988659F;
//    		this.Thigh_1.yRot = -0.17453292519943295F;
    		if (this.Thigh_1.y > 6) this.Thigh_1.y -= 0.15;
    		if (this.Thigh_1.z < 8) this.Thigh_1.z += 0.15;
    		if (this.Thigh_1.xRot < -0.3490658503988659F) this.Thigh_1.xRot += 0.05;
    		if (this.Thigh_1.yRot < -0.17453292519943295F) this.Thigh_1.yRot += 0.05;
    		//Tail
//    		this.Tail.x = 0.0F;
//    		this.Tail.y = -5.0F;
//    		this.Tail.xRot = -0.15;
    		if (this.Tail.x > 0) this.Tail.x -= 0.15;
    		if (this.Tail.y > -5) this.Tail.y -= 0.15;
    		if (this.Tail.xRot < -0.15) this.Tail.xRot += 0.05;
    		if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
    		//Body
//    		this.Body.y = 9.0F;
    		if (this.Body.y > 9) this.Body.y -= 0.15;
    		if (this.Body.xRot > 0) this.Body.xRot -= 0.05;
    		//Arm_1
//    		this.Arm_1.xRot = 0.3490658503988659F;
    		if (this.Arm_1.xRot < 0.3490658503988659F) this.Arm_1.xRot += 0.05;
    		if (this.Arm_1.zRot < 0) this.Arm_1.zRot += 0.05;
    		//Calf
//    		this.Calf.z = -4.0F;
//    		this.Calf.xRot = 0.3490658503988659F;
    		if (this.Calf.z > -4) this.Calf.z -= 0.15;
    		if (this.Calf.xRot > 0.3490658503988659F) this.Calf.xRot -= 0.05;
    		//Thigh
//    		this.Thigh.x = -2.0F;
//    		this.Thigh.y = 6.0F;
//    		this.Thigh.z = 8.0F;
//    		this.Thigh.xRot = -0.3490658503988659F;
//    		this.Thigh.yRot = 0.17453292519943295F;
    		if (this.Thigh.x < -2) this.Thigh.x += 0.15;
    		if (this.Thigh.y > 6) this.Thigh.y -= 0.15;
    		if (this.Thigh.z < 8) this.Thigh.z += 0.15;
    		if (this.Thigh.xRot < -0.3490658503988659F) this.Thigh.xRot += 0.05;
    		if (this.Thigh.yRot > 0.17453292519943295F) this.Thigh.yRot -= 0.05;
    		//Calf_1
//    		this.Calf_1.z = -4.0F;
//    		this.Calf_1.xRot = 0.3490658503988659F;
    		if (this.Calf_1.z > -4) this.Calf_1.z -= 0.15;
    		if (this.Calf_1.xRot > 0.3490658503988659F) this.Calf_1.xRot -= 0.05;
		}
		if (entity.isAsleep()) {
	    	if (sleepProgress != 0) {
	    		//Head
//	    		this.Head.y = 0.0F;
	    		if (this.Head.y < 0.6) this.Head.y += 0.15;
	    		if (this.Head.xRot > -0.5235987755982988F) this.Head.xRot -= 0.05;
	    		//Jaw
	    		if (this.Jaw.xRot < 0.5235987755982988F) this.Jaw.xRot += 0.05;
	    		//Foot
	    		if (this.Foot.xRot < 0.41887902047863906F) this.Foot.xRot += 0.05;
	    		//Tail2
	    		if (this.Tail2.yRot < 0.27366763203903305F) this.Tail2.yRot += 0.05;
	    		if (this.Tail2.zRot < 0.03909537541112055F) this.Tail2.zRot += 0.05;
	    		//Arm
//	    		this.Arm.xRot = 0.3490658503988659F;
	    		if (this.Arm.xRot > -0.8203047484373349F) this.Arm.xRot -= 0.05;
	    		if (this.Arm.zRot < 1.5707963267948966F) this.Arm.zRot += 0.05;
	    		//Neck
//	    		this.Neck.y = -3.0F;
//	    		this.Neck.z = -23.0F;
	    		if (this.Neck.y < -1) this.Neck.y += 0.15;
	    		if (this.Neck.z > -23.5) this.Neck.z -= 0.15;
	    		if (this.Neck.xRot > -0.10471975511965977F) this.Neck.xRot -= 0.05;
	    		if (this.Neck.yRot > -0.3490658503988659F) this.Neck.yRot -= 0.05;
	    		//Foot_1
	    		if (this.Foot_1.xRot < 0.41887902047863906F) this.Foot_1.xRot += 0.05;
	    		//Thigh_1
//	    		this.Thigh_1.y = 6.0F;
//	    		this.Thigh_1.z = 8.0F;
//	    		this.Thigh_1.xRot = -0.3490658503988659F;
//	    		this.Thigh_1.yRot = -0.17453292519943295F;
	    		if (this.Thigh_1.y < 21.5) this.Thigh_1.y += 0.15;
	    		if (this.Thigh_1.z > 7) this.Thigh_1.z -= 0.15;
	    		if (this.Thigh_1.xRot > -1.9198621771937625F) this.Thigh_1.xRot -= 0.05;
	    		if (this.Thigh_1.yRot > -0.45378560551852565F) this.Thigh_1.yRot -= 0.05;
	    		//Tail
//	    		this.Tail.x = 0.0F;
//	    		this.Tail.y = -5.0F;
//	    		this.Tail.xRot = -0.15;
	    		if (this.Tail.x < 0.4) this.Tail.x += 0.15;
	    		if (this.Tail.y < -4) this.Tail.y += 0.15;
	    		if (this.Tail.xRot > -0.17453292519943295F) this.Tail.xRot -= 0.05;
	    		if (this.Tail.yRot < 0.41887902047863906F) this.Tail.yRot += 0.05;
	    		//Body
//	    		this.Body.y = 9.0F;
	    		if (this.Body.y < 19) this.Body.y += 0.15;
	    		if (this.Body.xRot < 0.10471975511965977F) this.Body.xRot += 0.05;
	    		//Arm_1
//	    		this.Arm_1.xRot = 0.3490658503988659F;
	    		if (this.Arm_1.xRot > -0.8203047484373349F) this.Arm_1.xRot -= 0.05;
	    		if (this.Arm_1.zRot > -1.5707963267948966F) this.Arm_1.zRot -= 0.05;
	    		//Calf
//	    		this.Calf.z = -4.0F;
//	    		this.Calf.xRot = 0.3490658503988659F;
	    		if (this.Calf.z < -2.6) this.Calf.z += 0.15;
	    		if (this.Calf.xRot < 1.5009831567151235F) this.Calf.xRot += 0.05;
	    		//Thigh
//	    		this.Thigh.x = -2.0F;
//	    		this.Thigh.y = 6.0F;
//	    		this.Thigh.z = 8.0F;
//	    		this.Thigh.xRot = -0.3490658503988659F;
//	    		this.Thigh.yRot = 0.17453292519943295F;
	    		if (this.Thigh.x > -2.5) this.Thigh.x -= 0.15;
	    		if (this.Thigh.y < 21.5) this.Thigh.y += 0.15;
	    		if (this.Thigh.z > 7) this.Thigh.z -= 0.15;
	    		if (this.Thigh.xRot > -1.9198621771937625F) this.Thigh.xRot -= 0.05;
	    		if (this.Thigh.yRot < 0.41887902047863906F) this.Thigh.yRot += 0.05;
	    		//Calf_1
//	    		this.Calf_1.z = -4.0F;
//	    		this.Calf_1.xRot = 0.3490658503988659F;
	    		if (this.Calf_1.z < -2.6) this.Calf_1.z += 0.15;
	    		if (this.Calf_1.xRot < 1.5009831567151235F) this.Calf_1.xRot += 0.05;
	    	}
		} else {
			this.Jaw.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) +  attackProgress * (float) Math.toRadians(25F);
			this.Arm_1.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Arm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Body.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.15F * limbSwingAmount;
			this.Neck.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * -0.15F * limbSwingAmount;
			this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
			this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
			this.Thigh_1.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount - 0.35F;
			this.Calf_1.xRot = Math.abs(Mth.cos(limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount) + 0.35F;
			this.Foot_1.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount;
			this.Thigh.xRot = Mth.cos(3.0F + limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount - 0.35F;
			this.Calf.xRot = Math.abs(Mth.cos(3.0F + limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount) + 0.35F;
			this.Foot.xRot = Mth.cos(3.0F + limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount;
			this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(5F);
			if (entity.isInWater()) {
				this.Thigh_1.y = 16;
				this.Thigh.y = 16;
				this.Body.y = 20;
				this.Body.xRot = -0.125F;
				this.Tail.xRot = 0.0625F;
				this.Tail2.xRot = 0.0625F;
				this.Neck.xRot = 0.125F;
				this.Thigh_1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Thigh.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Calf_1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Calf.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Foot_1.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Foot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Arm.xRot = 0.125F;
				this.Arm_1.xRot = 0.125F;
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Head.y = 0.0F;
		this.Head.xRot = 0;
		this.Jaw.xRot = 0;
		this.Foot.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Arm.xRot = 0.3490658503988659F;
		this.Arm.zRot = 0;
		this.Neck.y = -3.0F;
		this.Neck.z = -23.0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Foot_1.xRot = 0;
		this.Thigh_1.y = 6.0F;
		this.Thigh_1.z = 8.0F;
		this.Thigh_1.xRot = -0.3490658503988659F;
		this.Thigh_1.yRot = -0.17453292519943295F;
		this.Tail.x = 0.0F;
		this.Tail.y = -5.0F;
		this.Tail.xRot = -0.15F;
		this.Tail.yRot = 0;
		this.Body.y = 9.0F;
		this.Body.xRot = 0;
		this.Arm_1.xRot = 0.3490658503988659F;
		this.Arm_1.zRot = 0;
		this.Calf.z = -4.0F;
		this.Calf.xRot = 0.3490658503988659F;
		this.Thigh.x = -2.0F;
		this.Thigh.y = 6.0F;
		this.Thigh.z = 8.0F;
		this.Thigh.xRot = -0.3490658503988659F;
		this.Thigh.yRot = 0.17453292519943295F;
		this.Calf_1.z = -4.0F;
		this.Calf_1.xRot = 0.3490658503988659F;
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thigh_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}