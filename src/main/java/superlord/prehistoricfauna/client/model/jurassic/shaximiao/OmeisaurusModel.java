package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Omeisaurus;

public class OmeisaurusModel extends EntityModel<Omeisaurus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Neck3;
	private final ModelPart Head;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public OmeisaurusModel(ModelPart Root) {
		this.Root = Root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Neck3 = this.Neck2.getChild("Neck3");
		this.Head = this.Neck3.getChild("Head");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
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

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -23.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -13.0F, -42.0F, 20.0F, 34.0F, 55.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 41.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(156, 70).addBox(-5.0F, -34.0F, -12.0F, 10.0F, 46.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -35.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(0, 89).addBox(-3.0F, -39.0F, -12.0F, 6.0F, 43.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -34.0F, 2.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Neck3 = Neck2.addOrReplaceChild("Neck3", CubeListBuilder.create().texOffs(150, 0).addBox(-2.0F, -58.0F, -9.0F, 4.0F, 60.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(182, -13).addBox(0.0F, -62.0F, -7.0F, 0.0F, 19.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Head = Neck3.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(72, 89).addBox(-2.5F, -1.0F, -6.0F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(72, 105).addBox(-2.0F, 1.0F, -11.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -57.05F, -5.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -4.0F, 7.0F, 36.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(22, 0).mirror().addBox(-7.0F, 31.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 12.0F, -34.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -3.0F, -4.0F, 7.0F, 36.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 0).addBox(2.0F, 31.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 12.0F, -34.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(72, 89).addBox(-5.0F, -3.0F, 1.0F, 10.0F, 16.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 10.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 89).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 7.0F, 60.0F, new CubeDeformation(0.0F))
		.texOffs(27, 43).addBox(-3.5F, -1.0F, 54.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 33.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(95, 0).addBox(-7.0F, -5.0F, -6.5F, 10.0F, 26.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -18.0F, 43.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(124, 89).addBox(-4.0F, -0.025F, 0.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(-0.01F)), PartPose.offset(-2.0F, 21.0F, -4.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(95, 39).addBox(-5.0F, 0.0F, -11.0F, 10.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 8.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(95, 0).mirror().addBox(-7.0F, -5.0F, -6.5F, 10.0F, 26.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -18.0F, 43.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(124, 89).mirror().addBox(-4.0F, -0.025F, 0.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offset(-2.0F, 21.0F, -4.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(95, 39).mirror().addBox(-5.0F, 0.0F, -11.0F, 10.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 8.0F));

		return LayerDefinition.create(meshdefinition, 208, 156);
	}

	@Override
	public void setupAnim(Omeisaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -21, -4.8F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.1745F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck1.x = Mth.lerp(sleepProgress, 0, 4F);
				this.Neck1.y = Mth.lerp(sleepProgress, -11, -9);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.7854F, 1.2162978572970231F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -0.3294172592861477F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.51728612207217244F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.3054F, -0.42775073568927633F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, 0.7510520131558576F);
				this.Neck3.xRot = Mth.lerp(sleepProgress, -0.1309F, -0.32775073568927633F);
				this.Neck3.yRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck3.zRot = Mth.lerp(sleepProgress, 0, 0.5510520131558576F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0.0873F, -0.34260075936930908F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.2864306020384839F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0873F, 0.2518657326886875F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.RightArm.y = Mth.lerp(sleepProgress, 12, 17.0F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.4405726395466833F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.069269908169872414F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.2189378856769737F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.03039819087864056F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -18, 0.25F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.1531F);
				this.RightLeg.z = Mth.lerp(sleepProgress, -4.5F, -7F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -18F, -4.25F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.2251F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, -4.5F, -5);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -4.8F, -21);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.1745F);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck1.x = Mth.lerp(sleepProgress, 4, 0F);
				this.Neck1.y = Mth.lerp(sleepProgress, -9, -11);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 1.2162978572970231F, 0.7854F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -0.3294172592861477F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.51728612207217244F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.42775073568927633F, -0.3054F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0.7510520131558576F, 0);
				this.Neck3.xRot = Mth.lerp(sleepProgress, -0.32775073568927633F, -0.1309F);
				this.Neck3.yRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck3.zRot = Mth.lerp(sleepProgress, 0.5510520131558576F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.34260075936930908F, 0.0873F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.2864306020384839F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.2518657326886875F, 0.0873F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.RightArm.y = Mth.lerp(sleepProgress, 17, 12.0F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.4405726395466833F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.069269908169872414F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.2189378856769737F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.03039819087864056F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0.25F, -18);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.1531F, 0);
				this.RightLeg.z = Mth.lerp(sleepProgress, -7F, -4.5F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -4.25F, -18);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.2251F, 0);
				this.LeftLeg.z = Mth.lerp(sleepProgress, -5, -4.5F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
			} else {
				this.Body.xRot = (attackProgress * (float)Math.toRadians(-50)) - 0.1745F;
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount) + 0.0873F;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount) + 0.0873F;
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + (headPitch * ((float) Math.PI / 270F)) + (attackProgress * (float)Math.toRadians(50)) + 0.7854F;
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 360F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + (headPitch * ((float) Math.PI / 270F)) - 0.3054F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) - (headPitch * ((float) Math.PI / 270F)) - 0.1309F; 
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftArm.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40)) + 0.1745F;
				this.RightArm.xRot = (Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60)) + 0.1745F;
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.Root.y = 70;
					this.Root.xRot = 0.19F;
					this.Tail1.xRot = -0.125F;
					this.Tail2.xRot = -0.125F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck1.xRot = 0.4F;
					this.Head.xRot = -0.1F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Root.y = 6F;
		this.Body.x = 0;
		this.Body.y = -21;
		this.Body.xRot = -0.1745F;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.Neck1.x = 0F;
		this.Neck1.y = -11F;
		this.Neck1.xRot = 0.7854F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.y = -34;
		this.Neck2.xRot = -0.3054F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Neck3.xRot = -0.1309F;
		this.Neck3.yRot = 0;
		this.Neck3.zRot = 0;
		this.Head.xRot = -0.1309F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.z = 10;
		this.Tail1.xRot = 0.0873F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0.0873F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = 10;
		this.LeftArm.y = 12;
		this.LeftArm.z = -34;
		this.LeftArm.xRot = 0.1745F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.x = -7F;
		this.RightArm.y = 12F;
		this.RightArm.z = -34F;
		this.RightArm.xRot = 0.1745F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.LeftThigh.x = 10;
		this.LeftThigh.y = -18F;
		this.LeftThigh.z = 43.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.x = -6;
		this.RightThigh.y = -18F;
		this.RightThigh.z = 43.5F;
		this.RightThigh.xRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.z = -4.5F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.RightFoot.y = 12F;
		this.RightFoot.z = 8F;
		this.LeftFoot.xRot = 0F;
		this.Root.xRot = 0;
	}

	public void sleepPose() {
		this.Body.y = -4.8F;
		this.Body.xRot = 0;
		this.Body.yRot = -0.038920842652368684F;
		this.Body.zRot = -0.1563815016444822F;
		this.Neck1.x = 4F;
		this.Neck1.y = -9;
		this.Neck1.xRot = 1.2162978572970231F;
		this.Neck1.yRot = -0.3294172592861477F;
		this.Neck1.zRot = 0.51728612207217244F;
		this.Neck2.xRot = -0.42775073568927633F;
		this.Neck2.yRot = -0.1563815016444822F;
		this.Neck2.zRot = 0.7510520131558576F;
		this.Neck3.xRot = -0.32775073568927633F;
		this.Neck3.yRot = -0.1563815016444822F;
		this.Neck3.zRot = 0.5510520131558576F;
		this.Tail1.xRot = -0.34260075936930908F;
		this.Tail1.yRot = 0.2864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.Tail2.xRot = 0.2518657326886875F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Tail2.zRot = 0.19547687289441354F;
		this.RightArm.y = 17.0F;
		this.RightArm.xRot = -1.4405726395466833F;
		this.RightArm.yRot = 0.069269908169872414F;
		this.LeftArm.xRot = -1.2189378856769737F;
		this.LeftArm.yRot = -0.03039819087864056F;
		this.RightThigh.y = 0.25F;
		this.RightThigh.xRot = 0.6472F;
		this.RightThigh.yRot = -0.0018F;
		this.RightThigh.zRot = 0.1531F;
		this.RightLeg.z = -7F;
		this.RightLeg.xRot = 0.9163F;
		this.LeftThigh.y = -4.25F;
		this.LeftThigh.xRot = 0.3748F;
		this.LeftThigh.zRot = -0.2251F;
		this.LeftLeg.z = -5;
		this.LeftLeg.xRot = 1.1345F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
