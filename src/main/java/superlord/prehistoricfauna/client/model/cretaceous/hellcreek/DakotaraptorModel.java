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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;

@SuppressWarnings("unused")
public class DakotaraptorModel extends EntityModel<Dakotaraptor> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightClaw;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftClaw;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public DakotaraptorModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.RightClaw = this.RightFoot.getChild("RightClaw");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.LeftClaw = this.LeftFoot.getChild("LeftClaw");
		this.RightWing = this.Body.getChild("RightWing");
		this.LeftWing = this.Body.getChild("LeftWing");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -17.0F, 8.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.95F, 3.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(62, 39).addBox(-2.0F, -11.0F, -4.0F, 4.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -16.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(62, 27).addBox(-3.5F, -3.0F, -5.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(76, 30).addBox(-2.5F, -2.0F, -14.0F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, -1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(42, 64).addBox(-3.0F, -2.0F, -4.0F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 1.0F, -2.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(52, 34).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 10.0F, 5.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(38, 34).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 11.0F, 0.0F));

		PartDefinition RightClaw = RightFoot.addOrReplaceChild("RightClaw", CubeListBuilder.create().texOffs(34, 29).addBox(-2.0F, -4.0F, -5.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(42, 64).mirror().addBox(-2.0F, -2.0F, -4.0F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 1.0F, -2.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(52, 34).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 10.0F, 5.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(38, 34).mirror().addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 11.0F, 0.0F));

		PartDefinition LeftClaw = LeftFoot.addOrReplaceChild("LeftClaw", CubeListBuilder.create().texOffs(34, 29).mirror().addBox(2.0F, -4.0F, -5.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(62, 5).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 3.0F, -13.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(62, 5).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 3.0F, -13.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, -3.475F, -1.0F, 4.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.25F, 4.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(20, 21).addBox(-1.0F, -2.25F, -1.0F, 2.0F, 5.0F, 38.0F, new CubeDeformation(0.0F))
				.texOffs(0, 64).addBox(-4.0F, -1.25F, 15.0F, 8.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 17.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(Dakotaraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		float sitProgress = entity.getSitProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftWing.zRot = Mth.lerp(sleepProgress, 0, 1.092750655326294F);
				this.RightWing.zRot = Mth.lerp(sleepProgress, 0, -1.092750655326294F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.9F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.2F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, 0.05F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.45F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.1F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.2F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.9F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -0.05F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.45F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.1F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.2F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.3054F, 0.13665927909957545F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.8570009181544104F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.4570009181544104F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.2275909337942703F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.707963267948966F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1745F, -0.04555309164612875F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 1.2668041519541685F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.2F);
				this.Body.y = Mth.lerp(sleepProgress, 1.95F, 14.3F);
			} else sleepPose();
		} else if (entity.isSitting()) {
			if (sitProgress != 0 && entity.getEntityData().get(Dakotaraptor.SIT_TICK) > 0) {
				this.Tail2.xRot = Mth.lerp(sitProgress, 0.1745F, 0.13665927909957545F);
				this.LeftWing.xRot = Mth.lerp(sitProgress, 0, 0.7740534966278743F);
				this.LeftWing.yRot = Mth.lerp(sitProgress, 0, -1);
				this.Neck.xRot = Mth.lerp(sitProgress, 0.3054F, 0.8829473549475088F);
				this.RightWing.xRot = Mth.lerp(sitProgress, 0, 0.7740534966278743F);
				this.RightWing.yRot = Mth.lerp(sitProgress, 0, 1);
				this.Body.xRot = Mth.lerp(sitProgress, 0, -0.65F);
				this.RightThigh.xRot = Mth.lerp(sitProgress, 0, -0.9F);
				this.RightThigh.yRot = Mth.lerp(sitProgress, 0, -0.2F);
				this.RightThigh.zRot = Mth.lerp(sitProgress, 0, -0.15F);
				this.RightLeg.zRot = Mth.lerp(sitProgress, 0, 0.2F);
				this.RightFoot.xRot = Mth.lerp(sitProgress, 0, 1.56F);
				this.LeftThigh.xRot = Mth.lerp(sitProgress, 0, -0.9F);
				this.LeftThigh.yRot = Mth.lerp(sitProgress, 0, 0.2F);
				this.LeftThigh.zRot = Mth.lerp(sitProgress, 0, 0.15F);
				this.LeftLeg.zRot = Mth.lerp(sitProgress, 0, -0.2F);
				this.LeftFoot.xRot = Mth.lerp(sitProgress, 0, 1.56F);
				this.Tail1.xRot = Mth.lerp(sitProgress, -0.1745F, 0.500909508638178F);
				this.Body.y = Mth.lerp(sitProgress, 1.95F, 19.3F);
			} else {
				sittingPose();
				this.RightWing.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
				this.LeftWing.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + 0.500909508638178F;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + 0.13665927909957545F;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5));
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);				
				this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (headPitch * ((float) Math.PI / 180F)) + 0.8829473549475088F;
			}
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftWing.zRot = Mth.lerp(sleepProgress, 1.092750655326294F, 0);
				this.RightWing.zRot = Mth.lerp(sleepProgress, -1.092750655326294F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.9F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.2F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0.05F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.45F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.1F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.2F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.9F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -0.05F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.45F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.1F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.2F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.13665927909957545F, 0.3054F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.8570009181544104F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.4570009181544104F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2275909337942703F, -0.1745F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.707963267948966F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.04555309164612875F, 0.1745F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 1.2668041519541685F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.2F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 14.3F, 1.95F);
			} else if (sitProgress != 0 && entity.getEntityData().get(Dakotaraptor.SIT_TICK ) > 0){
				this.Tail2.xRot = Mth.lerp(sitProgress, 0.13665927909957545F, 0.1745F);
				this.LeftWing.xRot = Mth.lerp(sitProgress, 0.7740534966278743F, 0);
				this.LeftWing.yRot = Mth.lerp(sitProgress, -1, 0);
				this.Neck.xRot = Mth.lerp(sitProgress, 0.8829473549475088F, 0.3054F);
				this.RightWing.xRot = Mth.lerp(sitProgress, 0.7740534966278743F, 0);
				this.RightWing.yRot = Mth.lerp(sitProgress, 1, 0);
				this.Body.xRot = Mth.lerp(sitProgress, -0.65F, 0);
				this.RightThigh.xRot = Mth.lerp(sitProgress, -0.9F, 0);
				this.RightThigh.yRot = Mth.lerp(sitProgress, -0.2F, 0);
				this.RightThigh.zRot = Mth.lerp(sitProgress, -0.15F, 0);
				this.RightLeg.zRot = Mth.lerp(sitProgress, 0.2F, 0);
				this.RightFoot.xRot = Mth.lerp(sitProgress, 1.56F, 0);
				this.LeftThigh.xRot = Mth.lerp(sitProgress, -0.9F, 0);
				this.LeftThigh.yRot = Mth.lerp(sitProgress, 0.2F, 0);
				this.LeftThigh.zRot = Mth.lerp(sitProgress, 0.15F, 0);
				this.LeftLeg.zRot = Mth.lerp(sitProgress, -0.2F, 0);
				this.LeftFoot.xRot = Mth.lerp(sitProgress, 1.56F, 0);
				this.Tail1.xRot = Mth.lerp(sitProgress, 0.500909508638178F, -0.1745F);
				this.Body.y = Mth.lerp(sitProgress, 19.3F, 1.95F);
			} else {
				if (entity.isCrouching()) {
					this.Body.xRot =  0.39269908169872414F;
					this.LeftWing.zRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount + 0.4F;
					this.RightWing.zRot = Mth.cos(3.0F + limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount - 0.4F;
					this.Body.xRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.2F * limbSwingAmount + 0.5F;
					this.RightThigh.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
					this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
					this.LeftThigh.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
					this.LeftLeg.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
					this.Tail1.xRot = -0.08464846705724931F + (Mth.cos(limbSwing * speed * 0.05F) * degree * 0.3F * limbSwingAmount - 0.3F);
					this.Tail2.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.1F;
					this.Tail2.zRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.4F * limbSwingAmount;
				}
				this.RightThigh.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F) - (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.LeftThigh.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F) - (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.2F) * degree * 0.05F * limbSwingAmount + 0.05F) + attackProgress * (float) Math.toRadians(25F) - 0.1745F;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.05F) + 0.1745F;
				this.Tail2.zRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount;
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
				this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F) + 0.3054F;
				this.RightWing.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
				this.LeftWing.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
				if (entity.isInWater()) {
					this.Body.y = 20;
					this.Body.xRot = -0.5F;
					this.Tail1.xRot = 0.25F;
					this.Tail2.xRot = 0.25F;
					this.Neck.xRot = 0.8F;
					this.RightWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail1.yRot = Mth.cos(limbSwing * 0.26662F) * 0.7F * limbSwingAmount;
					this.Tail2.yRot = Mth.cos(limbSwing * 0.26662F) * 0.7F * limbSwingAmount;
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = -0.45F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.45F;
					this.LeftFoot.xRot = 0.45F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.45F;
				}
			}
		}
	}

	public void resetModel() {
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftWing.xRot = 0;
		this.LeftWing.yRot = 0;
		this.LeftWing.zRot = 0;
		this.RightWing.xRot = 0;
		this.RightWing.yRot = 0;
		this.RightWing.zRot = 0;
		this.Tail1.xRot = -0.1745F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Neck.xRot = 0.3054F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail2.xRot = 0.1745F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Body.x = 0;
		this.Body.y = 1.95F;
		this.Body.z = 3;
		this.Neck.x = 0;
		this.Neck.y = -1;
		this.Neck.z = -16;
		this.RightWing.x = 4;
		this.RightWing.y = 3;
		this.RightWing.z = -13;
		this.LeftWing.x = -4;
		this.LeftWing.y = 3;
		this.LeftWing.z = -13;
		this.Tail1.x = 0;
		this.Tail1.y = -2.25F;
		this.Tail1.z = 4;
		this.Tail2.x = 0;
		this.Tail2.y = -1;
		this.Tail2.z = 17;
		this.RightThigh.x = 4;
		this.RightThigh.y = 1F;
		this.RightThigh.z = -2;
		this.RightLeg.x = -0.5F;
		this.RightLeg.y = 10;
		this.RightLeg.z = 5;
		this.LeftThigh.x = -4;
		this.LeftThigh.y = 1F;
		this.LeftThigh.z = -2;
		this.LeftLeg.x = 0.5F;
		this.LeftLeg.y = 10;
		this.LeftLeg.z = 5;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
	}

	public void sleepPose() {
		this.LeftWing.zRot = 1.092750655326294F;
		this.RightWing.zRot = -1.092750655326294F;
		this.LeftThigh.xRot = -0.9F;
		this.LeftThigh.yRot = 0.2F;
		this.LeftThigh.zRot = 0.05F;
		this.LeftLeg.xRot = -0.45F;
		this.LeftLeg.yRot = -0.1F;
		this.LeftLeg.zRot = -0.2F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightThigh.xRot = -0.9F;
		this.RightThigh.yRot = -0.2F;
		this.RightThigh.zRot = -0.05F;
		this.RightLeg.xRot = -0.45F;
		this.RightLeg.yRot = 0.1F;
		this.RightLeg.zRot = 0.2F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Neck.xRot = 0.13665927909957545F;
		this.Neck.xRot = 0.8570009181544104F;
		this.Neck.yRot = -1.4570009181544104F;
		this.Tail1.xRot = -0.2275909337942703F;
		this.Tail1.yRot = 0.707963267948966F;
		this.Tail2.xRot = -0.04555309164612875F;
		this.Tail2.yRot = 1.2668041519541685F;
		this.Body.xRot = -0.2F;
		this.Body.y = 14.3F;
	}

	public void sittingPose() {
		this.Tail2.xRot = 0.13665927909957545F;
		this.LeftWing.xRot = 0.7740534966278743F;
		this.LeftWing.yRot = -1;
		this.Neck.xRot = 0.8829473549475088F;
		this.RightWing.xRot = 0.7740534966278743F;
		this.RightWing.yRot = 1;
		this.Body.xRot = -0.65F;
		this.RightThigh.xRot = -0.9F;
		this.RightThigh.yRot = -0.2F;
		this.RightThigh.zRot = -0.15F;
		this.RightLeg.zRot = 0.2F;
		this.RightFoot.xRot = 1.56F;
		this.LeftThigh.xRot = -0.9F;
		this.LeftThigh.yRot = 0.2F;
		this.LeftThigh.zRot = 0.15F;
		this.LeftLeg.zRot = -0.2F;
		this.LeftFoot.xRot = 1.56F;
		this.Tail1.xRot = 0.500909508638178F;
		this.Body.y = 19.3F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
