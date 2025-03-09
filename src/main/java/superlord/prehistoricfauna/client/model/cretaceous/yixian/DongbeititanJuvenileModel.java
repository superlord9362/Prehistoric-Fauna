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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dongbeititan;

public class DongbeititanJuvenileModel extends EntityModel<Dongbeititan> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public DongbeititanJuvenileModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Head = this.Neck1.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 11.0F, -13.0F, 16.0F, 16.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(44, 42).addBox(-2.0F, -24.0F, -6.0F, 4.0F, 29.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, -12.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Head = Neck1.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 78).addBox(-3.01F, -3.6427F, -6.2296F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.01F, -20.3723F, -4.7804F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(84, 32).addBox(-6.01F, -4.1053F, 6.7651F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.4626F, -13.9947F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(64, 63).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 13.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 66).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(84, 0).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(7.25F, 23.0F, -8.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(-2.0F, -2.0F, -2.5F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.25F, 23.0F, -8.5F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(66, 42).addBox(-3.0F, -2.75F, -3.5F, 6.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 18.75F, 6.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 86).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.25F, 0.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(84, 21).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(66, 42).mirror().addBox(-3.0F, -2.75F, -3.5F, 6.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 18.75F, 6.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 86).mirror().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.25F, 0.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(84, 21).mirror().addBox(-3.0F, 0.0F, -5.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Dongbeititan entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -13, -3F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.8109F, 1.9162978572970231F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -1.3294172592861477F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Head.x = Mth.lerp(sleepProgress, 0.01F, 0);
				this.Head.z = Mth.lerp(sleepProgress, -3.7804F, -2.7804F);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.5927F, -1.7269149104981519F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.2562143561638466F);
				this.Tail1.z = Mth.lerp(sleepProgress, 13, 11F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.24260075936930908F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.5864306020384839F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.Tail2.y = Mth.lerp(sleepProgress, 1, 2);
				this.Tail2.z = Mth.lerp(sleepProgress, 14, 13);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.3518657326886875F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.LeftArm.x = Mth.lerp(sleepProgress, 7.25F, 7.5F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 23, 22.0F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -8.5F, -10.0F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.1405726395466833F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.039269908169872414F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.RightArm.x = Mth.lerp(sleepProgress, -7.25F, -7.5F);
				this.RightArm.y = Mth.lerp(sleepProgress, 23, 21);
				this.RightArm.z = Mth.lerp(sleepProgress, -8.5F, -10);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.2189378856769737F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.43039819087864056F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 18.75F, 20.75F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -1.5198621771937625F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.5082398595386212F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.118920842652368684F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 18.75F, 20.75F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -1.8198621771937625F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.3839724354387525F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 10.25F, 10.2F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.7707963267948966F);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -3, -13F);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 1.9162978572970231F, 0.8109F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -1.3294172592861477F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Head.x = Mth.lerp(sleepProgress, 0, 0.01F);
				this.Head.z = Mth.lerp(sleepProgress, -2.7804F, -3.7804F);
				this.Head.xRot = Mth.lerp(sleepProgress, -1.7269149104981519F, -0.5927F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.2562143561638466F, 0);
				this.Tail1.z = Mth.lerp(sleepProgress, 11, 13F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.24260075936930908F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.5864306020384839F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.Tail2.y = Mth.lerp(sleepProgress, 2, 1);
				this.Tail2.z = Mth.lerp(sleepProgress, 13, 14);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.3518657326886875F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.LeftArm.x = Mth.lerp(sleepProgress, 7.5F, 7.25F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 22, 23.0F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -10.0F, -8.5F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.1405726395466833F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.039269908169872414F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.RightArm.x = Mth.lerp(sleepProgress, -7.5F, -7.25F);
				this.RightArm.y = Mth.lerp(sleepProgress, 21, 23);
				this.RightArm.z = Mth.lerp(sleepProgress, -10F, -8.5F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.2189378856769737F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.43039819087864056F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 20.75F, 18.75F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -1.5198621771937625F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.5082398595386212F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.118920842652368684F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 20.75F, 18.75F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -1.8198621771937625F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.3839724354387525F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.RightLeg.y = Mth.lerp(sleepProgress, 10.2F, 10.25F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.7707963267948966F, 0);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
			} else {
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Body.zRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.8109F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck1.yRot = (Mth.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.5927F);
				this.RightThigh.xRot = Mth.cos((limbSwing / 3) * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos((limbSwing / 3) * 0.3F) * 0.2F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(4.0F + (limbSwing / 3) * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + (limbSwing / 3) * 0.3F) * 0.2F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(5.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount;
				this.RightArm.xRot = (Mth.cos(1.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftArm.xRot = (Mth.cos(5.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.Body.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
				}
				if (entity.isInWater()) {
					this.Body.y = 12;
					this.Body.xRot = -0.25F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.RightThigh.y = 24;
					this.LeftThigh.y = 24;
					this.LeftThigh.z = 3;
					this.RightThigh.z = 3;
					this.LeftArm.y = 25;
					this.LeftArm.z = -10;
					this.RightArm.y = 25;
					this.RightArm.z = -10;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck1.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = -13F;
		this.Body.yRot = 0F;
		this.Body.zRot = 0F;
		this.Neck1.x = 0F;
		this.Neck1.y = 15F;
		this.Neck1.z = -12;
		this.Neck1.xRot = 0.8109F;
		this.Neck1.yRot = 0F;
		this.Neck1.zRot = 0F;
		this.Head.x = 0.01F;
		this.Head.y = -21.3723F;
		this.Head.z = -3.7804F;
		this.Head.xRot = -0.5927F;
		this.Head.yRot = 0F;
		this.Head.zRot = 0F;
		this.Tail1.y = 17F;
		this.Tail1.z = 13F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.y = 1;
		this.Tail2.z = 14;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0F;
		this.LeftArm.x = 7.25F;
		this.LeftArm.y = 23;
		this.LeftArm.z = -8.5F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0F;
		this.LeftArm.zRot = 0F;
		this.RightArm.x = -7.25F;
		this.RightArm.y = 23.0F;
		this.RightArm.z = -8.5F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0F;
		this.RightArm.zRot = 0F;
		this.LeftThigh.x = 7F;
		this.LeftThigh.y = 18.75F;
		this.LeftThigh.z = 6.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.y = 10.25F;
		this.LeftLeg.z = 0.5F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftFoot.y = 5.0F;
		this.LeftFoot.z = 0.0F;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftFoot.yRot = 0;
		this.RightThigh.x = -7;
		this.RightThigh.y = 18.75F;
		this.RightThigh.z = 6.5F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.x = 0F;
		this.RightLeg.y = 10.25F;
		this.RightLeg.z = 0.5F;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 5F;
		this.RightFoot.z = 0F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
	}

	public void sleepPose() {
		this.Body.y = -3F;
		this.Body.yRot = -0.038920842652368684F;
		this.Body.zRot = -0.1563815016444822F;
		this.Neck1.x = 0F;
		this.Neck1.y = 15;
		this.Neck1.z = -12;
		this.Neck1.xRot = 1.9162978572970231F;
		this.Neck1.yRot = -1.3294172592861477F;
		this.Neck1.zRot = 0.11728612207217244F;
		this.Head.x = 0;
		this.Head.y = -21.3723F;
		this.Head.z = -2.7804F;
		this.Head.xRot = -1.7269149104981519F;
		this.Head.yRot = 0.03909537541112055F;
		this.Head.zRot = 0.2562143561638466F;
		this.Tail1.y = 17F;
		this.Tail1.z = 11F;
		this.Tail1.xRot = -0.24260075936930908F;
		this.Tail1.yRot = 0.5864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.Tail2.y = 2;
		this.Tail2.z = 13;
		this.Tail2.xRot = 0.3518657326886875F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Tail2.zRot = 0.19547687289441354F;
		this.LeftArm.x = 7.5F;
		this.LeftArm.y = 22.0F;
		this.LeftArm.z = -10.0F;
		this.LeftArm.xRot = -1.1405726395466833F;
		this.LeftArm.yRot = -0.039269908169872414F;
		this.LeftArm.zRot = 0.3909537457888271F;
		this.RightArm.x = -7.5F;
		this.RightArm.y = 21;
		this.RightArm.z = -10;
		this.RightArm.xRot = -1.2189378856769737F;
		this.RightArm.yRot = -0.43039819087864056F;
		this.LeftThigh.x = 7F;
		this.LeftThigh.y = 20.75F;
		this.LeftThigh.z = 6.5F;
		this.LeftThigh.xRot = -1.5198621771937625F;
		this.LeftThigh.yRot = -0.5082398595386212F;
		this.LeftLeg.x = 0F;
		this.LeftLeg.y = 10.2F;
		this.LeftLeg.z = 0.5F;
		this.LeftLeg.xRot = 1.5707963267948966F;
		this.LeftLeg.yRot = -0.118920842652368684F;
		this.LeftFoot.y = 5F;
		this.LeftFoot.z = 0F;
		this.LeftFoot.xRot = 0;
		this.RightThigh.x = -7F;
		this.RightThigh.y = 20.75F;
		this.RightThigh.z = 6.5F;
		this.RightThigh.xRot = -1.8198621771937625F;
		this.RightThigh.yRot = 0.3839724354387525F;
		this.RightThigh.zRot = 0.10471975511965977F;
		this.RightLeg.y = 10.2F;
		this.RightLeg.z = 0.5F;
		this.RightLeg.xRot = 1.7707963267948966F;
		this.RightFoot.y = 5.0F;
		this.RightFoot.z = 0.0F;
//		this.RightFoot.xRot = 0.3874631072585466F;
		this.RightFoot.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}