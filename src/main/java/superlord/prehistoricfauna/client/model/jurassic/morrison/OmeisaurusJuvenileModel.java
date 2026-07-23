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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Omeisaurus;

public class OmeisaurusJuvenileModel extends EntityModel<Omeisaurus> {
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

	public OmeisaurusJuvenileModel(ModelPart root) {
		this.Root = root.getChild("Root");
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

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, -6.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -10.0F, -22.0F, 10.0F, 17.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.85F, 16.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(66, 68).addBox(-2.5F, -17.0F, -8.0F, 5.0F, 23.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -17.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(74, 0).addBox(-2.0F, -20.0F, -7.025F, 4.0F, 23.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Neck3 = Neck2.addOrReplaceChild("Neck3", CubeListBuilder.create().texOffs(0, 78).addBox(-1.5F, -29.0F, -5.0F, 3.0F, 30.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, -7).addBox(0.0F, -31.0F, -4.0F, 0.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Head = Neck3.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -1.975F, -3.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-1.5F, -1.0F, -6.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.05F, -3.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(36, 44).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 44).addBox(-3.0F, 15.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 3.0F, -18.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(36, 44).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 44).mirror().addBox(2.0F, 15.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 3.0F, -18.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(50, 44).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 4.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 44).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(47, 0).addBox(-2.0F, 0.0F, 28.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 15.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 44).addBox(-4.0F, -2.0F, -3.0F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -11.0F, 16.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(50, 44).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 11.0F, -2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 63).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 3.025F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-1.0F, -2.0F, -3.0F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -11.0F, 16.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(50, 44).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 11.0F, -2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 63).mirror().addBox(-2.5F, -1.0F, -5.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.0F, 3.025F));

		return LayerDefinition.create(meshdefinition, 96, 113);
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
				this.Body.y = Mth.lerp(sleepProgress, -7.85F, 0F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.1745F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.7854F, 0.8162978572970231F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -0.3294172592861477F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.21728612207217244F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.3054F, -0.32775073568927633F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, 0.2510520131558576F);
				this.Neck3.x = Mth.lerp(sleepProgress, 0, -0.25F);
				this.Neck3.y = Mth.lerp(sleepProgress, -20, -19);
				this.Neck3.xRot = Mth.lerp(sleepProgress, -0.1309F, -0.32775073568927633F);
				this.Neck3.yRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck3.zRot = Mth.lerp(sleepProgress, 0, 0.5510520131558576F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0.0873F, -0.34260075936930908F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.2864306020384839F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0873F, 0.2518657326886875F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.1745F, -1.4405726395466833F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.069269908169872414F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.1745F, -1.2189378856769737F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.03039819087864056F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -11, -3.15F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.1531F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -11, -4.15F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.2251F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 0, -7.85F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.1745F);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.8162978572970231F, 0.7854F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -0.3294172592861477F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.21728612207217244F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.32775073568927633F, -0.3054F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0.2510520131558576F, 0);
				this.Neck3.x = Mth.lerp(sleepProgress, -0.25F, 0);
				this.Neck3.y = Mth.lerp(sleepProgress, -19, -20);
				this.Neck3.xRot = Mth.lerp(sleepProgress, -0.32775073568927633F, -0.1309F);
				this.Neck3.yRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck3.zRot = Mth.lerp(sleepProgress, 0.5510520131558576F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.34260075936930908F, 0.0873F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.2864306020384839F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.2518657326886875F, 0.0873F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.4405726395466833F, 0.1745F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.069269908169872414F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.2189378856769737F, 0.1745F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.03039819087864056F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -3.15F, -11);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.1531F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -4.15F, -11);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.2251F, 0);
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
		this.Root.y = 16F;
		this.Body.x = 0;
		this.Body.y = -7.85F;
		this.Body.xRot = -0.1745F;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.Neck1.x = 0F;
		this.Neck1.y = -10F;
		this.Neck1.xRot = 0.7854F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.y = -17;
		this.Neck2.xRot = -0.3054F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Neck3.x = 0;
		this.Neck3.y = -20;
		this.Neck3.xRot = -0.1309F;
		this.Neck3.yRot = 0;
		this.Neck3.zRot = 0;
		this.Head.xRot = -0.1309F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.z = 4;
		this.Tail1.xRot = 0.0873F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0.0873F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = 5;
		this.LeftArm.y = 3;
		this.LeftArm.z = -18;
		this.LeftArm.xRot = 0.1745F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.x = -5F;
		this.RightArm.y = 3F;
		this.RightArm.z = -18F;
		this.RightArm.xRot = 0.1745F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.LeftThigh.x = 6;
		this.LeftThigh.y = -11F;
		this.LeftThigh.z = 16F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.x = -1.5F;
		this.LeftLeg.y = 11F;
		this.LeftLeg.z = -2F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.x = -6;
		this.RightThigh.y = -11F;
		this.RightThigh.z = 16F;
		this.RightThigh.xRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.z = -2F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.RightFoot.y = 7F;
		this.RightFoot.z = 3.025F;
		this.LeftFoot.xRot = 0F;
		this.Root.xRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 0F;
		this.Body.xRot = 0;
		this.Body.yRot = -0.038920842652368684F;
		this.Body.zRot = -0.1563815016444822F;
		this.Neck1.xRot = 0.8162978572970231F;
		this.Neck1.yRot = -0.3294172592861477F;
		this.Neck1.zRot = 0.21728612207217244F;
		this.Neck2.xRot = -0.32775073568927633F;
		this.Neck2.yRot = -0.1563815016444822F;
		this.Neck2.zRot = 0.2510520131558576F;
		this.Neck3.x = -0.25F;
		this.Neck3.y = -19;
		this.Neck3.xRot = -0.32775073568927633F;
		this.Neck3.yRot = -0.1563815016444822F;
		this.Neck3.zRot = 0.5510520131558576F;
		this.Tail1.xRot = -0.34260075936930908F;
		this.Tail1.yRot = 0.2864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.Tail2.xRot = 0.2518657326886875F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Tail2.zRot = 0.19547687289441354F;
		this.RightArm.xRot = -1.4405726395466833F;
		this.RightArm.yRot = 0.069269908169872414F;
		this.LeftArm.xRot = -1.2189378856769737F;
		this.LeftArm.yRot = -0.03039819087864056F;
		this.RightThigh.y = -3.15F;
		this.RightThigh.xRot = 0.6472F;
		this.RightThigh.yRot = -0.0018F;
		this.RightThigh.zRot = 0.1531F;
		this.RightLeg.xRot = 0.9163F;
		this.LeftThigh.y = -4.15F;
		this.LeftThigh.xRot = 0.3748F;
		this.LeftThigh.zRot = -0.2251F;
		this.LeftLeg.xRot = 1.1345F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
