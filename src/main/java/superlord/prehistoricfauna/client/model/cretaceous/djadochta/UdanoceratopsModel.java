package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Udanoceratops;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class UdanoceratopsModel extends EntityModel<Udanoceratops> {
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public UdanoceratopsModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 13.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, -11.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(46, 0).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 5.0F, 0.0F));

		PartDefinition HeadTop = Neck.addOrReplaceChild("HeadTop", CubeListBuilder.create().texOffs(0, 39).addBox(-3.5F, -3.0F, -6.0F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

		PartDefinition HeadBottom = HeadTop.addOrReplaceChild("HeadBottom", CubeListBuilder.create().texOffs(26, 39).addBox(-3.5F, 0.0F, -6.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.0F));

		PartDefinition SnoutBottom = HeadBottom.addOrReplaceChild("SnoutBottom", CubeListBuilder.create().texOffs(46, 17).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -6.0F));

		PartDefinition Cheeks = HeadBottom.addOrReplaceChild("Cheeks", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.01F));

		PartDefinition HeadSpikes = HeadBottom.addOrReplaceChild("HeadSpikes", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -5.0F));

		PartDefinition SnoutTop = HeadTop.addOrReplaceChild("SnoutTop", CubeListBuilder.create().texOffs(70, 0).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

		PartDefinition JugalHorns = HeadTop.addOrReplaceChild("JugalHorns", CubeListBuilder.create().texOffs(46, 39).addBox(-4.5F, -1.5F, -1.5F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.49F, -0.51F));

		PartDefinition Crest = HeadTop.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(22, 50).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition NeckSpikes = Neck.addOrReplaceChild("NeckSpikes", CubeListBuilder.create().texOffs(54, 11).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -6.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(38, 45).addBox(-3.0F, -5.0F, -1.0F, 6.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 5.01F, 26.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(64, 34).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 13.0F));

		PartDefinition Tail2Spikes = Tail2.addOrReplaceChild("Tail2Spikes", CubeListBuilder.create().texOffs(0, -3).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition Tail1Spikes = Tail1.addOrReplaceChild("Tail1Spikes", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 1.0F));

		PartDefinition BodySpikes = Body.addOrReplaceChild("BodySpikes", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 20.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(72, 16).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -8.0F));

		PartDefinition LeftHand = LeftArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(62, 51).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 11.0F, -2.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(72, 16).addBox(0.0F, -2.0F, -2.0F, 3.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -8.0F));

		PartDefinition RightHand = RightArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(62, 51).mirror().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 11.0F, -2.0F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(86, 0).addBox(-5.0F, -3.0F, -5.0F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 9.0F, 9.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(83, 30).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(88, 58).mirror().addBox(-4.0F, 8.0F, -2.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(86, 0).addBox(-5.0F, -3.0F, -5.0F, 5.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 9.0F, 9.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(83, 30).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(88, 58).addBox(-4.0F, 8.0F, -2.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 114, 69);
	}

	@Override
	public void setupAnim(Udanoceratops entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 2, 10);
				this.RightThigh.y = Mth.lerp(sleepProgress, 9, 15);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 9, 15);
				this.LeftArm.y = Mth.lerp(sleepProgress, 13, 21);
				this.RightArm.y = Mth.lerp(sleepProgress, 13, 21);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 21, 8F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 21, 8F);
				this.Tail1.z = Mth.lerp(sleepProgress, 26, 23);
				this.Tail2.y = Mth.lerp(sleepProgress, 1, 0);
				this.Neck.z = Mth.lerp(sleepProgress, 0, 1.5F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.15235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.1091F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.2330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.3962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.057453292519943295F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.5585053606381855F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1091F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 10, 2);
				this.RightThigh.y = Mth.lerp(sleepProgress, 15, 9);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 15, 9);
				this.LeftArm.y = Mth.lerp(sleepProgress, 21, 13);
				this.RightArm.y = Mth.lerp(sleepProgress, 21, 13);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 8, 21);
				this.RightLeg.y = Mth.lerp(sleepProgress, 8F, 21);
				this.Tail1.z = Mth.lerp(sleepProgress, 23, 26);
				this.Tail2.y = Mth.lerp(sleepProgress, 0, 1);
				this.Neck.z = Mth.lerp(sleepProgress, 1.5F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.15235987755982988F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.1091F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.2330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.3962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.057453292519943295F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.5585053606381855F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.1091F, 0);
			} else {
				this.Neck.xRot = 0;
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Neck.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount) + attackProgress * (float) Math.toRadians(25F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.Body.y = 9;
					this.LeftArm.y = 20;
					this.RightArm.y = 20;
					this.RightThigh.y = 19;
					this.LeftThigh.y = 19;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 2;
		this.RightThigh.x = 7;
		this.RightThigh.y = 9;
		this.RightThigh.z = 9;
		this.LeftThigh.x = -2;
		this.LeftThigh.y = 9;
		this.LeftThigh.z = 9;
		this.LeftArm.y = 13;
		this.RightArm.y = 13;
		this.LeftLeg.y = 5F;
		this.RightLeg.y = 5F;
		this.LeftFoot.z = 0F;
		this.RightFoot.z = 0F;
		this.Tail1.z = 26;
		this.Tail2.y = 1;
		this.Neck.z = 0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.Body.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 10;
		this.RightThigh.y = 15;
		this.LeftThigh.y = 15;
		this.LeftArm.y = 21;
		this.RightArm.y = 21;
		this.LeftLeg.y = 8F;
		this.RightLeg.y = 8F;
		this.Tail1.z = 23;
		this.Tail2.y = 0;
		this.Neck.z = 1.5F;
		this.Neck.xRot = 0.15235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.LeftThigh.xRot = 0.3748F;
		this.LeftThigh.yRot = -0.1091F;
		this.LeftArm.xRot = -1.2330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		this.LeftLeg.xRot = 1.1345F;
		this.RightArm.xRot = -1.3962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = 1.1345F;
		this.Body.xRot = 0.057453292519943295F;
		this.Tail1.xRot = -0.5585053606381855F;
		this.Tail1.yRot = 0.41887902047863906F;
		this.Tail2.xRot = 0.41887902047863906F;
		this.Tail2.yRot = 0.593411945678072F;
		this.Tail2.zRot = 0.10471975511965977F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.yRot = 0.1091F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}