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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Typothorax;

public class TypothoraxModel extends EntityModel<Typothorax> {
	private final ModelPart belly;
	private final ModelPart tail_base;
	private final ModelPart tail_tip;
	private final ModelPart armor;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart Leg_R_front;
	private final ModelPart Thigh_R;
	private final ModelPart Leg_R_back;
	private final ModelPart Foot;
	private final ModelPart Thigh_L;
	private final ModelPart Leg_L_back;
	private final ModelPart Foot_L;
	private final ModelPart Leg_L_front;

	public TypothoraxModel(ModelPart root) {
		this.belly = root.getChild("belly");
		this.armor = belly.getChild("armor");
		this.tail_base = armor.getChild("tail_base");
		this.tail_tip = tail_base.getChild("tail_tip");
		this.neck = belly.getChild("neck");
		this.head = neck.getChild("head");
		this.Leg_R_front = root.getChild("Leg_R_front");
		this.Thigh_R = root.getChild("Thigh_R");
		this.Leg_R_back = Thigh_R.getChild("Leg_R_back");
		this.Foot = Leg_R_back.getChild("Foot");
		this.Thigh_L = root.getChild("Thigh_L");
		this.Leg_L_back = Thigh_L.getChild("Leg_L_back");
		this.Foot_L = Leg_L_back.getChild("Foot_L");
		this.Leg_L_front = root.getChild("Leg_L_front");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition belly = partdefinition.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -4.0F));

		PartDefinition Belly_spikes = belly.addOrReplaceChild("Belly_spikes", CubeListBuilder.create().texOffs(63, 10).addBox(-4.5F, 0.0F, -5.0F, 9.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition armor = belly.addOrReplaceChild("armor", CubeListBuilder.create().texOffs(0, 23).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 3.0F));

		PartDefinition tail_base = armor.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(2, 43).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 9.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition tail_tip = tail_base.addOrReplaceChild("tail_tip", CubeListBuilder.create().texOffs(37, 44).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 9.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Spikes_tail_bottom = tail_base.addOrReplaceChild("Spikes_tail_bottom", CubeListBuilder.create().texOffs(70, 41).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 2.0F));

		PartDefinition Tail_spikes = tail_base.addOrReplaceChild("Tail_spikes", CubeListBuilder.create().texOffs(64, 30).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition armor_spikes = armor.addOrReplaceChild("armor_spikes", CubeListBuilder.create().texOffs(59, 19).addBox(-5.5F, 0.0F, 0.0F, 11.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neck = belly.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -4.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition neck_spikes = neck.addOrReplaceChild("neck_spikes", CubeListBuilder.create().texOffs(73, 6).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.5F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 8).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -3.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition snoot = head.addOrReplaceChild("snoot", CubeListBuilder.create().texOffs(3, 14).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, -3.0F));

		PartDefinition Leg_R_front = partdefinition.addOrReplaceChild("Leg_R_front", CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, -7.0F));

		PartDefinition Thigh_R = partdefinition.addOrReplaceChild("Thigh_R", CubeListBuilder.create().texOffs(43, 0).addBox(0.0F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 16.0F, 6.0F));

		PartDefinition Leg_R_back = Thigh_R.addOrReplaceChild("Leg_R_back", CubeListBuilder.create().texOffs(43, 9).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.6F, 4.0F, 0.0F));

		PartDefinition Foot = Leg_R_back.addOrReplaceChild("Foot", CubeListBuilder.create().texOffs(52, 11).addBox(-1.5F, -0.01F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition Thigh_L = partdefinition.addOrReplaceChild("Thigh_L", CubeListBuilder.create().texOffs(43, 0).mirror().addBox(-3.0F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 16.0F, 6.0F));

		PartDefinition Leg_L_back = Thigh_L.addOrReplaceChild("Leg_L_back", CubeListBuilder.create().texOffs(43, 9).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.6F, 4.0F, 0.0F));

		PartDefinition Foot_L = Leg_L_back.addOrReplaceChild("Foot_L", CubeListBuilder.create().texOffs(52, 11).addBox(-1.5F, -0.01F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition Leg_L_front = partdefinition.addOrReplaceChild("Leg_L_front", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 18.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 96, 64);
	}

	@Override
	public void setupAnim(Typothorax entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Thigh_R.xRot = -0F;
				this.Thigh_L.xRot = -0F;
				this.Leg_R_front.xRot = -0F;
				this.Leg_L_front.xRot = -0F;
				this.Leg_R_front.zRot = 0F;
				this.Leg_L_front.zRot = -0F;
				this.Leg_R_front.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.Leg_L_front.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.Thigh_L.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.Leg_L_back.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.Foot_L.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.Thigh_R.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.Leg_R_back.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.Foot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.tail_base.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.tail_tip.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.tail_base.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
				this.tail_tip.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
				this.neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
				this.head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
				if (entity.isEating()) {
					this.neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Thigh_R.xRot = -0.1F;
					this.Thigh_L.xRot = -0.1F;
					this.Leg_L_front.xRot = -0.1F;
					this.Leg_R_front.xRot = -0.1F;
					this.Leg_L_front.zRot = 0.3F;
					this.Leg_R_front.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.belly.y = 15;
					this.belly.xRot = -0.125F;
					this.tail_base.xRot = 0.0625F;
					this.tail_tip.xRot = 0.0625F;
					this.Thigh_R.y = 17.5F;
					this.Thigh_L.y = 17.5F;
					this.Leg_R_front.y = 18;
					this.Leg_L_front.y = 18;
					this.Thigh_R.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Thigh_L.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_L_front.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_R_front.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_R_back.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_L_back.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Foot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Foot_L.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.neck.xRot = 0.0625F;
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//tail_base
			if (this.tail_base.xRot < 0) this.tail_base.xRot += 0.05;
			if (this.tail_base.yRot > 0) this.tail_base.yRot -= 0.05;
			if (this.tail_base.zRot > 0) this.tail_base.zRot -= 0.05;
			//Leg_L_Front
			//this.Leg_L_front.y = 18.0F;
			if (this.Leg_L_front.y > 18) this.Leg_L_front.y -= 0.15;
			if (this.Leg_L_front.xRot < 0) this.Leg_L_front.xRot += 0.05;
			if (this.Leg_L_front.yRot < 0) this.Leg_L_front.yRot += 0.05;
			//armor
			if (this.armor.xRot < 0) this.armor.xRot += 0.05;
			if (this.armor.yRot > 0) this.armor.yRot -= 0.05;
			//Foot
			if (this.Foot.xRot > 0) this.Foot.xRot -= 0.05;
			if (this.Foot.yRot > 0) this.Foot.yRot -= 0.05;
			//neck
			if (this.neck.xRot > 0) this.neck.xRot -= 0.05;
			if (this.neck.yRot < 0) this.neck.yRot += 0.05;
			if (this.neck.zRot < 0) this.neck.zRot += 0.05;
			//Thigh_R
			//this.Thigh_R.x = 2.5F;
			//this.Thigh_R.y = 16.0F;
			if (this.Thigh_R.x > 2.5) this.Thigh_R.x -= 0.15;
			if (this.Thigh_R.y > 16) this.Thigh_R.y -= 0.15;
			if (this.Thigh_R.xRot < 0) this.Thigh_R.xRot += 0.05;
			if (this.Thigh_R.yRot < 0) this.Thigh_R.yRot += 0.05;
			//Leg_L_back
			//this.Leg_L_back.y = 4.0F;
			//this.Leg_L_back.z = 0.0F;
			if (this.Leg_L_back.y < 4) this.Leg_L_back.y += 0.15;
			if (this.Leg_L_back.z > 0) this.Leg_L_back.z -= 0.15;
			if (this.Leg_L_back.xRot < 0) this.Leg_L_back.xRot += 0.05;
			if (this.Leg_L_back.yRot > 0) this.Leg_L_back.yRot -= 0.05;
			if (this.Leg_L_back.zRot > 0) this.Leg_L_back.zRot -= 0.05;
			//Leg_R_front
			//this.Leg_R_front.y = 18.0F;
			if (this.Leg_R_front.y > 18) this.Leg_R_front.y -= 0.15;
			if (this.Leg_R_front.xRot < 0) this.Leg_R_front.xRot += 0.05;
			if (this.Leg_R_front.yRot > 0) this.Leg_R_front.yRot -= 0.05;
			//Thigh_L
			//this.Thigh_L.y = 16.0F;
			if (this.Thigh_L.y > 16) this.Thigh_L.y -= 0.15;
			if (this.Thigh_L.xRot < 0) this.Thigh_L.xRot += 0.05;
			if (this.Thigh_L.yRot > 0) this.Thigh_L.yRot -= 0.05;
			//belly
			//this.belly.y = 15.0F;
			if (this.belly.y > 15) this.belly.y -= 0.15;
			//Leg_R_back
			//this.Leg_R_back.y = 4.0F;
			//this.Leg_R_back.z = 0.0F;
			if (this.Leg_R_back.y < 4) this.Leg_R_back.y += 0.15;
			if (this.Leg_R_back.z > 0) this.Leg_R_back.z -= 0.15;
			if (this.Leg_R_back.xRot < 0) this.Leg_R_back.xRot += 0.05;
			if (this.Leg_R_back.yRot < 0) this.Leg_R_back.yRot += 0.05;
			if (this.Leg_R_back.zRot < 0) this.Leg_R_back.zRot += 0.05;
			//tail_tip
			if (this.tail_tip.xRot > 0) this.tail_tip.xRot -= 0.05;
			if (this.tail_tip.yRot > 0) this.tail_tip.yRot -= 0.05;
			if (this.tail_tip.zRot < 0) this.tail_tip.zRot += 0.05;
			//Foot_L
			if (this.Foot_L.xRot > 0) this.Foot_L.xRot -= 0.05;
			if (this.Foot_L.yRot < 0) this.Foot_L.yRot += 0.05;
			if (this.Foot_L.zRot < 0) this.Foot_L.zRot += 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//tail_base
			if (this.tail_base.xRot > -0.17121680694433672F) this.tail_base.xRot -= 0.05;
			if (this.tail_base.yRot < 0.2932153010192419F) this.tail_base.yRot += 0.05;
			if (this.tail_base.zRot < 0.048869218223603385F) this.tail_base.zRot += 0.05;
			//Leg_L_Front
			//this.Leg_L_front.y = 18.0F;
			if (this.Leg_L_front.y < 22) this.Leg_L_front.y += 0.15;
			if (this.Leg_L_front.xRot > -1.1494738560161097F) this.Leg_L_front.xRot -= 0.05;
			if (this.Leg_L_front.yRot > -0.36634460599886814F) this.Leg_L_front.yRot -= 0.05;
			//armor
			if (this.armor.xRot > -0.07330382525481048F) this.armor.xRot -= 0.05;
			if (this.armor.yRot < 0.09773843644720677F) this.armor.yRot += 0.05;
			//Foot
			if (this.Foot.xRot < 1.7608626716844347F) this.Foot.xRot += 0.05;
			if (this.Foot.yRot < 0.293389837939183F) this.Foot.yRot += 0.05;
			//neck
			if (this.neck.xRot < 0.5133013303483712F) this.neck.xRot += 0.05;
			if (this.neck.yRot > -0.17104227002439565F) this.neck.yRot -= 0.05;
			if (this.neck.zRot > -0.12217304763960307F) this.neck.zRot -= 0.05;
			//Thigh_R
			//this.Thigh_R.x = 2.5F;
			//this.Thigh_R.y = 16.0F;
			if (this.Thigh_R.x < 3.5) this.Thigh_R.x += 0.15;
			if (this.Thigh_R.y < 19.1) this.Thigh_R.y += 0.15;
			if (this.Thigh_R.xRot > -0.7333873596775006F) this.Thigh_R.xRot -= 0.05;
			if (this.Thigh_R.yRot > -0.2200860126843725F) this.Thigh_R.yRot -= 0.05;
			//Leg_L_back
			//this.Leg_L_back.y = 4.0F;
			//this.Leg_L_back.z = 0.0F;
			if (this.Leg_L_back.y > 2) this.Leg_L_back.y -= 0.15;
			if (this.Leg_L_back.z < 2) this.Leg_L_back.z += 0.15;
			if (this.Leg_L_back.xRot > -0.6590362962582867F) this.Leg_L_back.xRot -= 0.05;
			if (this.Leg_L_back.yRot < 0.19547687289441354F) this.Leg_L_back.yRot += 0.05;
			if (this.Leg_L_back.zRot < 0.1464331302344367F) this.Leg_L_back.zRot += 0.05;
			//Leg_R_front
			//this.Leg_R_front.y = 18.0F;
			if (this.Leg_R_front.y < 22) this.Leg_R_front.y += 0.15;
			if (this.Leg_R_front.xRot > -1.07634451774697F) this.Leg_R_front.xRot -= 0.05;
			if (this.Leg_R_front.yRot < 0.2932153010192419F) this.Leg_R_front.yRot += 0.05;
			//Thigh_L
			//this.Thigh_L.y = 16.0F;
			if (this.Thigh_L.y < 19) this.Thigh_L.y += 0.15;
			if (this.Thigh_L.xRot > -0.7087782198875415F) this.Thigh_L.xRot -= 0.05;
			if (this.Thigh_L.yRot < 0.19547687289441354F) this.Thigh_L.yRot += 0.05;
			//belly
			//this.belly.y = 15.0F;
			if (this.belly.y < 19) this.belly.y += 0.15;
			//Leg_R_back
			//this.Leg_R_back.y = 4.0F;
			//this.Leg_R_back.z = 0.0F;
			if (this.Leg_R_back.y > 2) this.Leg_R_back.y -= 0.15;
			if (this.Leg_R_back.z < 2) this.Leg_R_back.z += 0.15;
			if (this.Leg_R_back.xRot > -0.7819074915776542F) this.Leg_R_back.xRot -= 0.05;
			if (this.Leg_R_back.yRot > -0.2200860126843725F) this.Leg_R_back.yRot -= 0.05;
			if (this.Leg_R_back.zRot > -0.2686061778740398F) this.Leg_R_back.zRot -= 0.05;
			//tail_tip
			if (this.tail_tip.xRot < 0.048869218223603385F) this.tail_tip.xRot += 0.05;
			if (this.tail_tip.yRot < 0.24434609527920614F) this.tail_tip.yRot += 0.05;
			if (this.tail_tip.zRot > -0.07330382525481048F) this.tail_tip.zRot -= 0.05;
			//Foot_L
			if (this.Foot_L.xRot < 1.4903366376253135F) this.Foot_L.xRot += 0.05;
			if (this.Foot_L.yRot > -0.024260076353049827F) this.Foot_L.yRot -= 0.05;
			if (this.Foot_L.zRot > -0.048869218223603385F) this.Foot_L.zRot -= 0.05;
		}
	}

	public void resetModel() {
		this.tail_base.xRot = 0;
		this.tail_base.yRot = 0;
		this.tail_base.zRot = 0;
		this.Leg_L_front.y = 18.0F;
		this.Leg_L_front.xRot = 0;
		this.Leg_L_front.yRot = 0;
		this.belly.xRot = 0;
		this.armor.xRot = 0;
		this.armor.yRot = 0;
		this.Foot.xRot = 0;
		this.Foot.zRot = 0;
		this.neck.xRot = 0;
		this.neck.yRot = 0;
		this.neck.zRot = 0;
		this.Thigh_R.x = 2.5F;
		this.Thigh_R.y = 16.0F;
		this.Thigh_R.xRot = 0;
		this.Thigh_R.yRot = 0;
		this.Leg_L_back.y = 4.0F;
		this.Leg_L_back.z = 0.0F;
		this.Leg_L_back.xRot = 0;
		this.Leg_L_back.yRot = 0;
		this.Leg_L_back.zRot = 0;
		this.Leg_R_front.y = 18.0F;
		this.Leg_R_front.xRot = 0;
		this.Leg_R_front.yRot = 0;
		this.Thigh_L.y = 16.0F;
		this.Thigh_L.xRot = 0;
		this.Thigh_L.yRot = 0;
		this.belly.y = 15.0F;
		this.Leg_R_back.y = 4.0F;
		this.Leg_R_back.z = 0.0F;
		this.Leg_R_back.xRot = 0.0F;
		this.Leg_R_back.yRot = 0;
		this.Leg_R_back.zRot = 0;
		this.tail_tip.xRot = 0;
		this.tail_tip.yRot = 0;
		this.tail_tip.zRot = 0;
		this.Foot_L.xRot = 0;
		this.Foot_L.yRot = 0;
		this.Foot_L.zRot = 0;
	}

	public void sleepPose() {
		this.tail_base.xRot = -0.17121680694433672F;
		this.tail_base.yRot = 0.2932153010192419F;
		this.tail_base.zRot = 0.048869218223603385F;
		this.Leg_L_front.y = 22.0F;
		this.Leg_L_front.xRot = -1.1494738560161097F;
		this.Leg_L_front.yRot = -0.36634460599886814F;
		this.armor.xRot = -0.07330382525481048F;
		this.armor.yRot = 0.09773843644720677F;
		this.Foot.xRot = 1.7608626716844347F;
		this.Foot.zRot = 0.293389837939183F;
		this.neck.xRot = 0.5133013303483712F;
		this.neck.yRot = -0.17104227002439565F;
		this.neck.zRot = -0.12217304763960307F;
		this.Thigh_R.x = 3.5F;
		this.Thigh_R.y = 19.1F;
		this.Thigh_R.xRot = -0.7333873596775006F;
		this.Thigh_R.yRot = -0.2200860126843725F;
		this.Leg_L_back.y = 2.0F;
		this.Leg_L_back.z = 2.0F;
		this.Leg_L_back.xRot = -0.6590362962582867F;
		this.Leg_L_back.yRot = 0.19547687289441354F;
		this.Leg_L_back.zRot = 0.1464331302344367F;
		this.Leg_R_front.y = 22.0F;
		this.Leg_R_front.xRot = -1.07634451774697F;
		this.Leg_R_front.yRot = 0.2932153010192419F;
		this.Thigh_L.y = 19.0F;
		this.Thigh_L.xRot = -0.7087782198875415F;
		this.Thigh_L.yRot = 0.19547687289441354F;
		this.belly.y = 19.0F;
		this.Leg_R_back.y = 2.0F;
		this.Leg_R_back.z = 2.0F;
		this.Leg_R_back.xRot = -0.7819074915776542F;
		this.Leg_R_back.yRot = -0.2200860126843725F;
		this.Leg_R_back.zRot = -0.2686061778740398F;
		this.tail_tip.xRot = 0.048869218223603385F;
		this.tail_tip.yRot = 0.24434609527920614F;
		this.tail_tip.zRot = -0.07330382525481048F;
		this.Foot_L.xRot = 1.4903366376253135F;
		this.Foot_L.yRot = -0.024260076353049827F;
		this.Foot_L.zRot = -0.048869218223603385F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		belly.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_R_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thigh_R.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thigh_L.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_L_front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
