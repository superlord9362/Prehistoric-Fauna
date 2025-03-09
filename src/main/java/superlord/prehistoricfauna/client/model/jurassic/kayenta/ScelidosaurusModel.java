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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;

public class ScelidosaurusModel extends EntityModel<Scelidosaurus> {
	private final ModelPart LegRight;
	private final ModelPart Leg2Right;
	private final ModelPart FootRight;
	private final ModelPart LegLeft;
	private final ModelPart Leg2Left;
	private final ModelPart FootLeft;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart ArmRight;
	private final ModelPart ArmLeft;
	private final ModelPart Tail;
	private final ModelPart Tail2;

	public ScelidosaurusModel(ModelPart root) {
		this.LegRight = root.getChild("LegRight");
		this.Leg2Right = LegRight.getChild("Leg2Right");
		this.FootRight = Leg2Right.getChild("FootRight");
		this.LegLeft = root.getChild("LegLeft");
		this.Leg2Left = LegLeft.getChild("Leg2Left");
		this.FootLeft = Leg2Left.getChild("FootLeft");
		this.Body = root.getChild("Body");
		this.ArmRight = Body.getChild("ArmRight");
		this.ArmLeft = Body.getChild("ArmLeft");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LegRight = partdefinition.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(44, 33).mirror().addBox(-4.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 11.0F, 5.9F));

		PartDefinition Leg2Right = LegRight.addOrReplaceChild("Leg2Right", CubeListBuilder.create().texOffs(44, 47).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.3F, 6.5F, 1.9F));

		PartDefinition FootRight = Leg2Right.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(43, 57).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.5F, 0.5F));

		PartDefinition LegLeft = partdefinition.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(44, 33).addBox(0.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 11.0F, 6.0F));

		PartDefinition Leg2Left = LegLeft.addOrReplaceChild("Leg2Left", CubeListBuilder.create().texOffs(44, 47).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.3F, 6.5F, 1.9F));

		PartDefinition FootLeft = Leg2Left.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(43, 57).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.5F, 0.5F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -4.0F, -19.0F, 9.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 8.0F));

		PartDefinition ArmLeft = Body.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(28, 34).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 2.0F, -16.0F));

		PartDefinition BodyOsteoderms = Body.addOrReplaceChild("BodyOsteoderms", CubeListBuilder.create().texOffs(71, 0).addBox(-8.0F, 0.0F, -19.0F, 16.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition BodyOsteoderms_1 = BodyOsteoderms.addOrReplaceChild("BodyOsteoderms_1", CubeListBuilder.create().texOffs(111, 40).addBox(-1.0F, 0.0F, -18.0F, 2.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0017F));

		PartDefinition ArmRight = Body.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(28, 34).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 2.0F, -16.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -19.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -5.0F, 0.25F, 0.0F, 0.0F));

		PartDefinition part21 = Head.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(15, 49).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 52).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(41, 2).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 3.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(64, 4).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 10.0F));

		PartDefinition Tail2Osteoderms = Tail2.addOrReplaceChild("Tail2Osteoderms", CubeListBuilder.create().texOffs(67, 35).addBox(-6.0F, 0.0F, -8.0F, 12.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 6.0F));

		PartDefinition BodyOsteoderms_1_2 = Tail2Osteoderms.addOrReplaceChild("BodyOsteoderms_1_2", CubeListBuilder.create().texOffs(122, 20).addBox(-1.0F, 0.0F, -18.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 13.0F, 0.0F, 0.0F, -0.0017F));

		PartDefinition TailOsteoderms = Tail.addOrReplaceChild("TailOsteoderms", CubeListBuilder.create().texOffs(104, 24).addBox(-6.0F, 0.0F, -8.0F, 12.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 8.0F));

		PartDefinition BodyOsteoderms_1_1 = TailOsteoderms.addOrReplaceChild("BodyOsteoderms_1_1", CubeListBuilder.create().texOffs(127, 6).addBox(-1.0F, -0.5F, -10.0F, 2.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 2.0F, 0.0F, 0.0F, -0.0017F));

		return LayerDefinition.create(meshdefinition, 160, 75);
	}

	@Override
	public void setupAnim(Scelidosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		float bipedalProgress = entity.getBipedalProgress(partialTick);
		float speed = 1.0f;
		float degree = 1.0f;
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LegLeft.x = Mth.lerp(sleepProgress, 1.5F, 1.0F);
				this.LegLeft.y = Mth.lerp(sleepProgress, 11, 15.5F);
				this.LegLeft.z = Mth.lerp(sleepProgress, 5.9F, 7.0F);
				this.LegLeft.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.LegLeft.zRot = Mth.lerp(sleepProgress, 0, -0.27366763203903305F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.1563815016444822F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.35185837453889574F);
				this.Leg2Left.y = Mth.lerp(sleepProgress, 6.5F, 7);
				this.Leg2Left.xRot = Mth.lerp(sleepProgress, 0, -0.9782570324270162F);
				this.ArmRight.x = Mth.lerp(sleepProgress, -2.5F, -4.0F);
				this.ArmRight.y = Mth.lerp(sleepProgress, 2, 3.0F);
				this.ArmRight.xRot = Mth.lerp(sleepProgress, 0, -1.407433498155583F);
				this.ArmRight.yRot = Mth.lerp(sleepProgress, 0, -0.5082398928281348F);
				this.ArmRight.zRot = Mth.lerp(sleepProgress, 0, 0.1563815016444822F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.35185837453889574F);
				this.LegRight.x = Mth.lerp(sleepProgress, -1.5F, -1.0F);
				this.LegRight.y = Mth.lerp(sleepProgress, 11, 15.5F);
				this.LegRight.z = Mth.lerp(sleepProgress, 6, 7.0F);
				this.LegRight.yRot = Mth.lerp(sleepProgress, 0, -0.03909537541112055F);
				this.LegRight.zRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.ArmLeft.x = Mth.lerp(sleepProgress, 4.5F, 4.7F);
				this.ArmLeft.y = Mth.lerp(sleepProgress, 2, 3.0F);
				this.ArmLeft.xRot = Mth.lerp(sleepProgress, 0, -1.2906709285865847F);
				this.ArmLeft.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.FootRight.x = Mth.lerp(sleepProgress, 0, -0.5F);
				this.FootRight.y = Mth.lerp(sleepProgress, 5.5F, 3.5F);
				this.FootRight.z = Mth.lerp(sleepProgress, 0.5F, -0.3F);
				this.FootRight.xRot = Mth.lerp(sleepProgress, 0, 1.0555751236166873F);
				this.FootRight.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.FootRight.zRot = Mth.lerp(sleepProgress, 0, 0.1558579075294158F);
				this.Body.y = Mth.lerp(sleepProgress, 12, 17.3F);
				this.Leg2Right.y = Mth.lerp(sleepProgress, 6.5F, 7F);
				this.Leg2Right.xRot = Mth.lerp(sleepProgress, 0, -0.9782570324270162F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.35185837453889574F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.19547687289441354F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.FootLeft.x = Mth.lerp(sleepProgress, 0, 0.5F);
				this.FootLeft.y =Mth.lerp(sleepProgress, 5.5F,  3.5F);
				this.FootLeft.z = Mth.lerp(sleepProgress, 0.5F, -0.3F);
				this.FootLeft.xRot = Mth.lerp(sleepProgress, 0, 1.0555751236166873F);
				this.FootLeft.yRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
				this.FootLeft.zRot = Mth.lerp(sleepProgress, 0, -0.1558579075294158F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LegLeft.x = Mth.lerp(sleepProgress, 1F, 1.5F);
				this.LegLeft.y = Mth.lerp(sleepProgress, 15.5F, 11F);
				this.LegLeft.z = Mth.lerp(sleepProgress, 7F, 5.9F);
				this.LegLeft.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.LegLeft.zRot = Mth.lerp(sleepProgress, -0.27366763203903305F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1563815016444822F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.35185837453889574F, 0);
				this.Leg2Left.y = Mth.lerp(sleepProgress, 7F, 6.5F);
				this.Leg2Left.xRot = Mth.lerp(sleepProgress, -0.9782570324270162F, 0);
				this.ArmRight.x = Mth.lerp(sleepProgress, -4.0F, -2.5F);
				this.ArmRight.y = Mth.lerp(sleepProgress, 3, 2.0F);
				this.ArmRight.xRot = Mth.lerp(sleepProgress, -1.407433498155583F, 0);
				this.ArmRight.yRot = Mth.lerp(sleepProgress, -0.5082398928281348F, 0);
				this.ArmRight.zRot = Mth.lerp(sleepProgress, 0.1563815016444822F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.35185837453889574F, 0);
				this.LegRight.x = Mth.lerp(sleepProgress, -1.F, -1.5F);
				this.LegRight.y = Mth.lerp(sleepProgress, 15.5F, 11F);
				this.LegRight.z = Mth.lerp(sleepProgress, 7, 6.0F);
				this.LegRight.yRot = Mth.lerp(sleepProgress, -0.03909537541112055F, 0);
				this.LegRight.zRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.ArmLeft.x = Mth.lerp(sleepProgress, 4.7F, 4.5F);
				this.ArmLeft.y = Mth.lerp(sleepProgress, 3, 2.0F);
				this.ArmLeft.xRot = Mth.lerp(sleepProgress, -1.2906709285865847F, 0);
				this.ArmLeft.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.FootRight.x = Mth.lerp(sleepProgress, -0.5F, 0);
				this.FootRight.y = Mth.lerp(sleepProgress, 3.5F, 5.5F);
				this.FootRight.z = Mth.lerp(sleepProgress, -0.3F, 0.5F);
				this.FootRight.xRot = Mth.lerp(sleepProgress, 1.0555751236166873F, 0);
				this.FootRight.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.FootRight.zRot = Mth.lerp(sleepProgress, 0.1558579075294158F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 17.3F, 12F);
				this.Leg2Right.y = Mth.lerp(sleepProgress, 7F, 6.5F);
				this.Leg2Right.xRot = Mth.lerp(sleepProgress, -0.9782570324270162F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.35185837453889574F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.19547687289441354F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.FootLeft.x = Mth.lerp(sleepProgress, 0.5F, 0);
				this.FootLeft.y =Mth.lerp(sleepProgress, 3.5F,  5.5F);
				this.FootLeft.z = Mth.lerp(sleepProgress, -0.3F, 0.5F);
				this.FootLeft.xRot = Mth.lerp(sleepProgress, 1.0555751236166873F, 0);
				this.FootLeft.yRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
				this.FootLeft.zRot = Mth.lerp(sleepProgress, -0.1558579075294158F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
			} else {
				if (entity.isBipedal()) {
					if (bipedalProgress != 0 && entity.getEntityData().get(Scelidosaurus.BIPEDAL_TICK) > 0) {
						this.Body.xRot = Mth.lerp(bipedalProgress, 0, -0.3F);
						this.ArmRight.xRot = Mth.lerp(bipedalProgress, 0, 0.3F);
						this.ArmLeft.xRot = Mth.lerp(bipedalProgress, 0, 0.3F);
						this.Head.xRot = Mth.lerp(bipedalProgress, 0.25F, 0.3F);
						this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
						this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
					} else crouchPose();
					this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + 0.15F;
					this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + 0.15F;
					this.LegLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
					this.LegRight.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
					this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
					this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				} else {
					if (bipedalProgress != 0 && entity.getEntityData().get(Scelidosaurus.BIPEDAL_TICK) > 0) {
						this.Body.xRot = Mth.lerp(bipedalProgress, -0.3F, 0);
						this.ArmRight.xRot = Mth.lerp(bipedalProgress, 0.3F, 0);
						this.ArmLeft.xRot = Mth.lerp(bipedalProgress, 0.3F, 0);
						this.Head.xRot = Mth.lerp(bipedalProgress, 0.3F, 0.25F);
						this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
						this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
						this.LegLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
						this.LegRight.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
					} else {
						this.Body.xRot = 0;
						this.ArmRight.xRot = -0F;
						this.ArmLeft.xRot = -0F;
						this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
						this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
						this.ArmRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
						this.ArmLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
						this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.25F) + attackProgress * (float) Math.toRadians(25F);
						this.Body.z = 8F + attackProgress * -10F;
						this.LegLeft.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
						this.LegRight.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
						this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
						this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
						this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
						this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
						if (entity.isEating()) {
							this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
						}
						if (entity.isInWater()) {
							this.Body.y = 18;
							this.Body.xRot = -0.125F;
							this.Tail.xRot = 0.0625F;
							this.Tail2.xRot = 0.0625F;
							this.LegRight.y = 17;
							this.LegLeft.y = 17;
							this.LegRight.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
							this.LegLeft.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
							this.ArmLeft.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
							this.ArmRight.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
							this.Neck.xRot = 0.0625F;
							this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
							this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
						}
					}
				}
			}
		}

	}

	public void resetModel() {
		this.LegLeft.x = 1.5F;
		this.LegLeft.y = 11.0F;
		this.LegLeft.z = 5.9F;
		this.LegLeft.xRot = 0;
		this.LegLeft.yRot = 0;
		this.LegLeft.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Leg2Left.y = 6.5F;
		this.Leg2Left.xRot = 0;
		this.ArmRight.x = -2.5F;
		this.ArmRight.y = 2.0F;
		this.ArmRight.xRot = 0;
		this.ArmRight.yRot = 0;
		this.ArmRight.zRot = 0;
		this.Head.xRot = 0.2500000029182012F;
		this.LegRight.x = -1.5F;
		this.LegRight.y = 11.0F;
		this.LegRight.z = 6.0F;
		this.LegRight.xRot = 0;
		this.LegRight.yRot = 0;
		this.LegRight.zRot = 0;
		this.ArmLeft.x = 4.5F;
		this.ArmLeft.y = 2.0F;
		this.ArmLeft.xRot = 0;
		this.ArmLeft.yRot = 0;
		this.FootRight.x = 0.0F;
		this.FootRight.y = 5.5F;
		this.FootRight.z = 0.5F;
		this.FootRight.xRot = 0;
		this.FootRight.yRot = 0;
		this.FootRight.zRot = 0;
		this.Body.y = 12;
		this.Leg2Right.y = 6.5F;
		this.Leg2Right.xRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.FootLeft.x = 0.0F;
		this.FootLeft.y = 5.5F;
		this.FootLeft.z = 0.5F;
		this.FootLeft.xRot = 0;
		this.FootLeft.yRot = 0;
		this.FootLeft.zRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
	}

	public void sleepPose() {
		this.LegLeft.x = 1.0F;
		this.LegLeft.y = 15.5F;
		this.LegLeft.z = 7.0F;
		this.LegLeft.yRot = 0.03909537541112055F;
		this.LegLeft.zRot = -0.27366763203903305F;
		this.Tail2.xRot = 0.1563815016444822F;
		this.Tail2.yRot = 0.35185837453889574F;
		this.Leg2Left.y = 7;
		this.Leg2Left.xRot = -0.9782570324270162F;
		this.ArmRight.x = -4.0F;
		this.ArmRight.y = 3.0F;
		this.ArmRight.xRot = -1.407433498155583F;
		this.ArmRight.yRot = -0.5082398928281348F;
		this.ArmRight.zRot = 0.1563815016444822F;
		this.Head.xRot = 0.35185837453889574F;
		this.LegRight.x = -1.0F;
		this.LegRight.y = 15.5F;
		this.LegRight.z = 7.0F;
		this.LegRight.yRot = -0.03909537541112055F;
		this.LegRight.zRot = 0.27366763203903305F;
		this.ArmLeft.x = 4.7F;
		this.ArmLeft.y = 3.0F;
		this.ArmLeft.xRot = -1.2906709285865847F;
		this.ArmLeft.yRot = 0.19547687289441354F;
		this.FootRight.x = -0.5F;
		this.FootRight.y = 3.5F;
		this.FootRight.z = -0.3F;
		this.FootRight.xRot = 1.0555751236166873F;
		this.FootRight.yRot = 0.3909537457888271F;
		this.FootRight.zRot = 0.1558579075294158F;
		this.Body.y = 17.3F;
		this.Leg2Right.y = 7F;
		this.Leg2Right.xRot = -0.9782570324270162F;
		this.Neck.xRot = 0.35185837453889574F;
		this.Neck.yRot = -0.19547687289441354F;
		this.Neck.zRot = 0.3127630032889644F;
		this.FootLeft.x = 0.5F;
		this.FootLeft.y = 3.5F;
		this.FootLeft.z = -0.3F;
		this.FootLeft.xRot = 1.0555751236166873F;
		this.FootLeft.yRot = -0.3909537457888271F;
		this.FootLeft.zRot = -0.1558579075294158F;
		this.Tail.xRot = -0.3909537457888271F;
		this.Tail.yRot = 0.19547687289441354F;
		this.Tail.zRot = 0.03909537541112055F;
	}

	public void crouchPose() {
		this.Body.xRot = -0.3F;
		this.ArmRight.xRot = 0.3F;
		this.ArmLeft.xRot = 0.3F;
		this.Head.xRot = 0.3F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LegRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
