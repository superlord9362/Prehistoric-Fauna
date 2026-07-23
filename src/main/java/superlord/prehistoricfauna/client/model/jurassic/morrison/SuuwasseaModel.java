package superlord.prehistoricfauna.client.model.jurassic.morrison;

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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Suuwassea;

public class SuuwasseaModel extends EntityModel<Suuwassea> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
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

	public SuuwasseaModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -19.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 95).addBox(-9.0F, -13.0F, -37.0F, 18.0F, 30.0F, 51.0F, new CubeDeformation(0.0F))
		.texOffs(100, -47).addBox(0.0F, -14.0F, -35.0F, 0.0F, 1.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 37.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(0, 176).addBox(-4.0F, -3.0F, -23.0F, 8.0F, 11.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -37.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(138, 146).addBox(-2.0F, -2.0F, -28.0F, 4.0F, 7.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -23.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(102, 1).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.01F))
		.texOffs(102, 8).addBox(-1.5F, 0.0F, -5.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, -28.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(138, 95).addBox(-6.0F, -2.0F, -2.0F, 12.0F, 15.0F, 36.0F, new CubeDeformation(0.0F))
		.texOffs(0, -32).addBox(0.0F, -3.0F, 1.0F, 0.0F, 1.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 14.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 7.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 34.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(108, 176).mirror().addBox(-5.0F, -3.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(102, 15).addBox(-7.0F, 23.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 10.0F, -30.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(102, 15).addBox(5.0F, 23.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(108, 176).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 10.0F, -30.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(66, 176).addBox(-7.0F, -4.0F, -6.5F, 8.0F, 25.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -19.0F, 37.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(172, 183).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 21.0F, -5.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(132, 183).addBox(-4.0F, 0.0F, -10.0F, 8.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 6.075F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(66, 176).mirror().addBox(-1.0F, -4.0F, -6.5F, 8.0F, 25.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-10.0F, -19.0F, 37.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(172, 183).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 21.0F, -5.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(132, 183).mirror().addBox(-4.0F, 0.0F, -10.0F, 8.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 6.075F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Suuwassea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -17, 2.25F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.0805F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, 0.0376F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 0.215F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, -0.2182F, 0.6031F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 0.3487F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, -0.02275F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.2182F, -0.2269F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, 0.3427F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, -0.2839F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.7854F, -0.0709F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0873F, -0.1186F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.2537F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.1426F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0873F, 0.0801F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.1778F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.1404F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3301F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.1462F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.3503F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.0769F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.0313F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.1938F);
				this.LeftThigh.x = Mth.lerp(sleepProgress, 10, 13);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -19, 0.25F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.1531F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -19, -2.25F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1091F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.5251F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 2.25F, -17);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.0805F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0.0376F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 0.215F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.6031F, -0.2618F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0.3487F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, -0.02275F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.2269F, -0.3927F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0.3427F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, -0.2839F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.0709F, 0.9163F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1186F, -0.0873F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.2537F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.1426F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0801F, 0.0873F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.1778F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.1404F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3301F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.1462F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.3503F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.0769F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.0313F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.1938F, 0);
				this.LeftThigh.x = Mth.lerp(sleepProgress, 13, 10);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0.25F, -19F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.1531F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -2.25F, -19);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.1091F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.5251F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
			} else {
				this.Body.xRot = (attackProgress * (float)Math.toRadians(-50));
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.0873F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.0873F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = 0.05F * Mth.sin(0.1F * ageInTicks / 3) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.2182F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.2182F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = -0.025F * Mth.sin(0.1F * ageInTicks / 3) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.7854F);
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = -Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.RightArm.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftArm.xRot = -(Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.Body.y = 19;
					this.Body.xRot = -0.05F;
					this.RightThigh.y = 17;
					this.LeftThigh.y = 17;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.LeftLeg.xRot = 0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F)) - 0.15F;
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F)) - 0.15F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y =  -17.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightArm.x = -9F;
		this.RightArm.y = 10.0F;
		this.RightArm.z = -30.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail1.z = 14;
		this.Tail1.xRot = -0.0873F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftArm.x = 9F;
		this.LeftArm.y = 10F;
		this.LeftArm.z = -30F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftFoot.y = 13F;
		this.LeftFoot.z = 6.075F;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftLeg.y = 21F;
		this.LeftLeg.z = -5.5F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.Neck2.xRot = -0.2182F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.RightFoot.y = 13;
		this.RightFoot.z = 6.075F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
		this.RightLeg.y = 21F;
		this.RightLeg.z = -5.5F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftThigh.x = 10F;
		this.LeftThigh.y = -19;
		this.LeftThigh.z = 37.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightThigh.x = -10F;
		this.RightThigh.y = -19;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Neck1.x = 0F;
		this.Neck1.y = -5;
		this.Neck1.z = -37;
		this.Neck1.xRot = -0.2182F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Tail2.xRot = 0.0873F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Head.x = 0;
		this.Head.z = -28F;
		this.Head.xRot = 0.7854F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 2.25F;
		this.Body.xRot = -0.0805F;
		this.Body.yRot = 0.0376F;
		this.Body.zRot = 0.215F;
		this.Neck1.xRot = 0.6031F;
		this.Neck1.yRot = 0.3487F;
		this.Neck1.zRot = -0.02275F;
		this.Neck2.xRot = -0.2269F;
		this.Neck2.yRot = 0.3427F;
		this.Neck2.zRot = -0.2839F;
		this.Head.xRot = -0.0709F;
		this.Tail1.xRot = -0.1186F;
		this.Tail1.yRot = -0.2537F;
		this.Tail1.zRot = -0.1426F;
		this.Tail2.xRot = 0.0801F;
		this.Tail2.yRot = -0.1778F;
		this.Tail2.zRot = -0.1404F;
		this.LeftArm.xRot = -1.3301F;
		this.LeftArm.yRot = 0.1462F;
		this.LeftArm.zRot = -0.3503F;
		this.RightArm.xRot = -1.0769F;
		this.RightArm.yRot = -0.0313F;
		this.RightArm.zRot = -0.1938F;
		this.LeftThigh.x = 13;
		this.LeftThigh.y = 0.25F;
		this.LeftThigh.xRot = 0.6472F;
		this.LeftThigh.yRot = -0.0018F;
		this.LeftThigh.zRot = -0.1531F;
		this.LeftLeg.xRot = 0.9163F;
		this.RightThigh.y = -2.25F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.yRot = 0.1091F;
		this.RightThigh.zRot = 0.5251F;
		this.RightLeg.xRot = 1.1345F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
