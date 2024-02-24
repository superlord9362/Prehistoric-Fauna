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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;

public class TyrannosaurusJuvenileModel extends EntityModel<Tyrannosaurus> {
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftFeet;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightFeet;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;

	public TyrannosaurusJuvenileModel(ModelPart root) {
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.LeftFeet = LeftLeg2.getChild("LeftFeet");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.RightFeet = RightLeg2.getChild("RightFeet");
		this.Body1 = root.getChild("Body1");
		this.Body2 = Body1.getChild("Body2");
		this.Neck = Body2.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Tail1 = Body1.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LeftArm = Body2.getChild("LeftArm");
		this.RightArm = Body2.getChild("RightArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(0, 43).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, -1.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(42, 38).mirror().addBox(-2.0F, -4.0F, -1.0F, 4.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 14.0F, 5.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition LeftFeet = LeftLeg2.addOrReplaceChild("LeftFeet", CubeListBuilder.create().texOffs(69, 41).addBox(-3.0F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 2.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(0, 43).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -7.0F, -1.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(42, 38).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 5.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition RightFeet = RightLeg2.addOrReplaceChild("RightFeet", CubeListBuilder.create().texOffs(69, 41).addBox(-3.0F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 2.0F));

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -11.0F, 8.0F, 17.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -1.0F, 0.0F, -0.0063F, 0.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(8, 69).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 11.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 6.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(56, 61).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 33.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(63, 0).addBox(-5.0F, -5.0F, -19.0F, 10.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.0F));

		PartDefinition Neck = Body2.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(104, 59).addBox(-2.0F, -15.0F, -7.0F, 4.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -17.0F, 0.25F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 81).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.1F, -4.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(58, 67).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -8.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(59, 0).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1F, 8.0F, -14.0F, 0.25F, 0.0F, 0.0F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(59, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, 8.0F, -14.0F, 0.25F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Tyrannosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			//LeftLeg2
			if (this.LeftLeg2.xRot > -0.8761552978169589F) this.LeftLeg2.xRot -= 0.05;
			//LeftFeet
			//this.LeftFeet.z = 2;
			if (this.LeftLeg2.z > 1) this.LeftLeg2.z -= 0.15;
			if (this.LeftLeg2.xRot < 1.5707963267948966F) this.LeftLeg2.xRot += 0.05;
			//RightFeet
			//this.RightFeet.z = 2;
			if (this.RightFeet.z > 1) this.RightFeet.z -= 0.15;
			if (this.RightFeet.xRot < 1.5707963267948966F) this.RightFeet.xRot += 0.05;
			//Head1
			//this.Head1.x = 0;
			//this.Head1.y = -11.1F;
			//this.Head1.z = -4F;
			if (this.Head1.x > -2) this.Head1.x -= 0.15;
			if (this.Head1.y < -11) this.Head1.y += 0.15;
			if (this.Head1.z > -6.7) this.Head1.z -= 0.15;
			if (this.Head1.xRot < 0.41887902047863906F) this.Head1.xRot += 0.05;
			if (this.Head1.yRot > -1.0471975511965976F) this.Head1.yRot -= 0.05;
			//RightLeg2
			//this.RightLeg2.z = 5;
			if (this.RightLeg2.z > 4) this.RightLeg2.z -= 0.15;
			if (this.RightLeg2.xRot > -0.8639379797371932F) this.RightLeg2.xRot -= 0.05;
			if (this.RightLeg2.yRot > -0.17453292519943295F) this.RightLeg2.yRot -= 0.05;
			if (this.RightLeg2.zRot > -0.17453292519943295F) this.RightLeg2.zRot -= 0.05;
			//Neck
			//this.Neck.x = 0;
			//this.Neck.xRot = 0.2275909337942703F;
			if (this.Neck.x > -2) this.Head1.x -= 0.15;
			if (this.Neck.xRot < 0.41887902047863906F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -1.0471975511965976F) this.Neck.yRot -= 0.05;
			//RightLeg1
			//this.RightLeg1.x = -4;
			//this.RightLeg1.y = -7;
			if (this.RightLeg1.x > -6) this.RightLeg1.x -= 0.15;
			if (this.RightLeg1.y < 8.8) this.RightLeg1.y += 0.15;
			if (this.RightLeg1.xRot > -0.6981317007977318F) this.RightLeg1.xRot -= 0.05;
			if (this.RightLeg1.yRot < 0.3490658503988659F) this.RightLeg1.yRot += 0.05;
			//Body2
			//this.Body2.x = 0;
			//this.Body2.y = -1;
			//this.Body2.z = -5;
			if (this.Body2.x > -2) this.Body2.x -= 0.15;
			if (this.Body2.y > -3) this.Body2.y -= 0.15;
			if (this.Body2.z > -6) this.Body2.z -= 0.15;
			if (this.Body2.xRot < 0.17453292519943295F) this.Body2.xRot += 0.05;
			if (this.Body2.yRot > -0.5235987755982988F) this.Body2.yRot -= 0.05;
			//Body1
			//this.Body1.y = -10;
			if (this.Body1.y < 12.6) this.Body1.y += 0.15;
			if (this.Body1.xRot > -0.17453292519943295F) this.Body1.xRot -= 0.05;
			//Tail2
			//this.Tail2.x = 0;
			if (this.Tail2.x > -1) this.Tail2.x -= 0.15;
			if (this.Tail2.xRot < 0.24434609527920614F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0.41887902047863906F) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot < 0.17453292519943295F) this.Tail2.zRot += 0.05;
			//LeftLeg1
			//this.LeftLeg1.x = 4;
			//this.LeftLeg1.y = -7F;
			if (this.LeftLeg1.x < 6) this.LeftLeg1.x += 0.15;
			if (this.LeftLeg1.y < 8.8) this.LeftLeg1.y += 0.15;
			if (this.LeftLeg1.xRot > -0.6981317007977318F) this.LeftLeg1.xRot -= 0.05;
			if (this.LeftLeg1.yRot > -0.5235987755982988F) this.LeftLeg1.yRot -= 0.05;
			//RightArm
			//this.RightArm.x = -4.1F;
			//this.RightArm.z = -14F;
			//this.RightArm.xRot = 0.27314402127920984F;
			if (this.RightArm.x > -5) this.Tail2.x -= 0.15;
			if (this.RightArm.z > -14.5) this.Tail2.z -= 0.15;
			if (this.RightArm.xRot < 0.7330382858376184F) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot < 0.24434609527920614F) this.RightArm.yRot += 0.05;
			if (this.RightArm.zRot < 0.24434609527920614F) this.RightArm.zRot += 0.05;
			//Tail1
			//this.Tail1.xRot = -0.04555309164612875F;
			if (this.Tail1.xRot > -0.17453292519943295F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0.593411945678072F) this.Tail1.yRot += 0.05;
			//LeftArm
			//this.LeftArm.x = 4.1F;
			if (this.LeftLeg1.x < 4.5) this.LeftLeg1.x += 0.15;
			if (this.RightArm.zRot > -0.24434609527920614F) this.RightArm.zRot -= 0.05;
			sleepPose();
		} else {
			resetModel();
			float speed = 0.8f;
			float degree = 1.0f;
			this.Neck.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F;
			this.Body2.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
			this.Body1.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.Tail1.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
			this.Tail2.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F;
			this.Tail1.yRot = Mth.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
			this.Tail2.yRot = Mth.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
			this.Head1.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F;
			this.LeftArm.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.RightArm.xRot = Mth.cos(2.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.LeftLeg1.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
			this.LeftLeg2.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
			this.LeftFeet.xRot = Mth.cos(2.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.RightLeg1.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
			this.RightLeg2.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
			this.RightFeet.xRot = Mth.cos(2.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			if (entity.isInWater()) {
				this.LeftLeg1.y = 20;
				this.RightLeg1.y = 20;
				this.Body1.y = 20;
				this.Body1.xRot = -0.25F;
				this.Tail1.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Neck.xRot = 0.25F;
				this.LeftLeg1.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.RightLeg1.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
				this.RightArm.xRot = 0.25F;
				this.LeftArm.xRot = 0.25F;
				this.Tail1.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.LeftLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFeet.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightFeet.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LeftLeg2
			if (this.LeftLeg2.xRot < 0) this.LeftLeg2.xRot += 0.05;
			//LeftFeet
			//this.LeftFeet.z = 2;
			if (this.LeftLeg2.z < 2) this.LeftLeg2.z += 0.15;
			if (this.LeftLeg2.xRot > 0) this.LeftLeg2.xRot -= 0.05;
			//RightFeet
			//this.RightFeet.z = 2;
			if (this.RightFeet.z < 2) this.RightFeet.z += 0.15;
			if (this.RightFeet.xRot > 0) this.RightFeet.xRot -= 0.05;
			//Head1
			//this.Head1.x = 0;
			//this.Head1.y = -11.1F;
			//this.Head1.z = -4F;
			if (this.Head1.x < 0) this.Head1.x += 0.15;
			if (this.Head1.y > -11.1) this.Head1.y -= 0.15;
			if (this.Head1.z < -4) this.Head1.z += 0.15;
			if (this.Head1.xRot > 0) this.Head1.xRot -= 0.05;
			if (this.Head1.yRot < 0) this.Head1.yRot += 0.05;
			//RightLeg2
			//this.RightLeg2.z = 5;
			if (this.RightLeg2.z < 5) this.RightLeg2.z += 0.15;
			if (this.RightLeg2.xRot < 0) this.RightLeg2.xRot += 0.05;
			if (this.RightLeg2.yRot < 0) this.RightLeg2.yRot += 0.05;
			if (this.RightLeg2.zRot < 0) this.RightLeg2.zRot += 0.05;
			//Neck
			//this.Neck.x = 0;
			//this.Neck.xRot = 0.2275909337942703F;
			if (this.Neck.x < 0) this.Head1.x += 0.15;
			if (this.Neck.xRot > 0.2275909337942703F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//RightLeg1
			//this.RightLeg1.x = -4;
			//this.RightLeg1.y = -7;
			if (this.RightLeg1.x < -4) this.RightLeg1.x += 0.15;
			if (this.RightLeg1.y > -7) this.RightLeg1.y -= 0.15;
			if (this.RightLeg1.xRot < -0) this.RightLeg1.xRot += 0.05;
			if (this.RightLeg1.yRot > 0) this.RightLeg1.yRot -= 0.05;
			//Body2
			//this.Body2.x = 0;
			//this.Body2.y = -1;
			//this.Body2.z = -5;
			if (this.Body2.x < 0) this.Body2.x += 0.15;
			if (this.Body2.y < -1) this.Body2.y += 0.15;
			if (this.Body2.z < -5) this.Body2.z += 0.15;
			if (this.Body2.xRot > 0) this.Body2.xRot -= 0.05;
			if (this.Body2.yRot < 0) this.Body2.yRot += 0.05;
			//Body1
			//this.Body1.y = -10;
			if (this.Body1.y > -10) this.Body1.y -= 0.15;
			if (this.Body1.xRot < -0) this.Body1.xRot += 0.05;
			//Tail2
			//this.Tail2.x = 0;
			if (this.Tail2.x < 0) this.Tail2.x += 0.15;
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > 0) this.Tail2.zRot -= 0.05;
			//LeftLeg1
			//this.LeftLeg1.x = 4;
			//this.LeftLeg1.y = -7F;
			if (this.LeftLeg1.x > 4) this.LeftLeg1.x -= 0.15;
			if (this.LeftLeg1.y > -7) this.LeftLeg1.y -= 0.15;
			if (this.LeftLeg1.xRot < 0) this.LeftLeg1.xRot += 0.05;
			if (this.LeftLeg1.yRot < 0) this.LeftLeg1.yRot += 0.05;
			//RightArm
			//this.RightArm.x = -4.1F;
			//this.RightArm.z = -14F;
			//this.RightArm.xRot = 0.27314402127920984F;
			if (this.RightArm.x < -4.1) this.Tail2.x += 0.15;
			if (this.RightArm.z < -14) this.Tail2.z += 0.15;
			if (this.RightArm.xRot > 0.27314402127920984F) this.RightArm.xRot -= 0.05;
			if (this.RightArm.yRot > 0) this.RightArm.yRot -= 0.05;
			if (this.RightArm.zRot > 0) this.RightArm.zRot += 0.05;
			//Tail1
			//this.Tail1.xRot = -0.04555309164612875F;
			if (this.Tail1.xRot < -0.04555309164612875F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//LeftArm
			//this.LeftArm.x = 4.1F;
			if (this.LeftLeg1.x > 4.1) this.LeftLeg1.x -= 0.15;
			if (this.RightArm.zRot < 0) this.RightArm.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.LeftLeg2.xRot = 0;
		this.LeftFeet.xRot = 0;
		this.RightFeet.xRot = 0;
		this.Head1.xRot = 0;
		this.Head1.yRot = 0;
		this.RightLeg2.xRot = 0;
		this.RightLeg2.yRot = 0;
		this.RightLeg2.zRot = -0;
		this.Neck.xRot = 0.2275909337942703F;
		this.Neck.yRot = 0;
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.Body2.xRot = 0;
		this.Body2.yRot = 0;
		this.Body1.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.RightArm.xRot = 0.27314402127920984F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail1.xRot = -0.04555309164612875F;
		this.Tail1.yRot = 0;
		this.LeftArm.xRot = 0.6283185307179586F;
		this.LeftArm.zRot = 0;
		this.Body1.y = -10;
		this.Tail2.x = 0;
		this.Body2.x = 0;
		this.Body2.y = -1;
		this.Body2.z = -5;
		this.Neck.x = 0;
		this.Head1.x = 0;
		this.Head1.y = -11.1F;
		this.Head1.z = -4F;
		this.LeftArm.x = 4.1F;
		this.RightArm.x = -4.1F;
		this.RightArm.z = -14F;
		this.LeftLeg1.x = 4;
		this.LeftLeg1.y = -7F;
		this.LeftLeg2.z = 5;
		this.LeftFeet.z = 2;
		this.RightLeg1.x = -4;
		this.RightLeg1.y = -7;
		this.RightLeg2.z = 5;
		this.RightFeet.z = 2;
	}

	public void sleepPose() {
		this.LeftLeg2.xRot = -0.8761552978169589F;
		this.LeftFeet.xRot = 1.5707963267948966F;
		this.RightFeet.xRot = 1.5707963267948966F;
		this.Head1.xRot = 0.41887902047863906F;
		this.Head1.yRot = -1.0471975511965976F;
		this.RightLeg2.xRot = -0.8639379797371932F;
		this.RightLeg2.yRot = -0.17453292519943295F;
		this.RightLeg2.zRot = -0.17453292519943295F;
		this.Neck.xRot = 0.41887902047863906F;
		this.Neck.yRot = -1.0471975511965976F;
		this.RightLeg1.xRot = -0.6981317007977318F;
		this.RightLeg1.yRot = 0.3490658503988659F;
		this.Body2.xRot = 0.17453292519943295F;
		this.Body2.yRot = -0.5235987755982988F;
		this.Body1.xRot = -0.17453292519943295F;
		this.Tail2.xRot = 0.24434609527920614F;
		this.Tail2.yRot = 0.41887902047863906F;
		this.Tail2.zRot = 0.17453292519943295F;
		this.LeftLeg1.xRot = -0.6981317007977318F;
		this.LeftLeg1.yRot = -0.5235987755982988F;
		this.RightArm.xRot = 0.7330382858376184F;
		this.RightArm.yRot = 0.24434609527920614F;
		this.RightArm.zRot = 0.24434609527920614F;
		this.Tail1.xRot = -0.17453292519943295F;
		this.Tail1.yRot = 0.593411945678072F;
		this.LeftArm.xRot = 0.6283185307179586F;
		this.LeftArm.zRot = -0.24434609527920614F;
		this.Body1.y = 12.6F;
		this.Tail2.x = -1;
		this.Body2.x = -2;
		this.Body2.y = -3;
		this.Body2.z = -6;
		this.Neck.x = -2;
		this.Head1.x = -2;
		this.Head1.y = -11;
		this.Head1.z = -6.7F;
		this.LeftArm.x = 4.5F;
		this.RightArm.x = -5F;
		this.RightArm.z = -14.5F;
		this.LeftLeg1.x = 6;
		this.LeftLeg1.y = 8.8F;
		this.LeftLeg2.z = 4;
		this.LeftFeet.z = 1;
		this.RightLeg1.x = -6;
		this.RightLeg1.y = 8.8F;
		this.RightLeg2.z = 4;
		this.RightFeet.z = 1;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}