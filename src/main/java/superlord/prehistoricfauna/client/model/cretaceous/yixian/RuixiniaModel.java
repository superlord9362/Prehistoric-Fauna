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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Ruixinia;

@SuppressWarnings("unused")
public class RuixiniaModel extends EntityModel<Ruixinia> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Snout1;
	private final ModelPart Snout2;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
	private final ModelPart Jaw3;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart TailClub;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public RuixiniaModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Snout1 = this.Head.getChild("Snout1");
		this.Snout2 = this.Snout1.getChild("Snout2");
		this.Jaw1 = this.Head.getChild("Jaw1");
		this.Jaw2 = this.Jaw1.getChild("Jaw2");
		this.Jaw3 = this.Jaw2.getChild("Jaw3");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.TailClub = this.Tail2.getChild("TailClub");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 26.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, -15.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(80, 30).addBox(-5.0F, -10.0F, -30.0F, 10.0F, 15.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 3.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(64, 77).addBox(-3.0F, -2.0F, -33.0F, 6.0F, 10.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -30.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(100, 18).addBox(-3.9F, -0.7444F, -3.6504F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.2F, -32.8F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Snout1 = Head.addOrReplaceChild("Snout1", CubeListBuilder.create().texOffs(140, 99).addBox(-3.1F, -3.0F, -2.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.1F, 1.2556F, -3.4504F));

		PartDefinition Snout2 = Snout1.addOrReplaceChild("Snout2", CubeListBuilder.create().texOffs(114, 97).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(-0.1F, 0.0F, -2.0F));

		PartDefinition Jaw1 = Head.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(127, 23).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.1F, 4.2556F, 0.3496F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(114, 88).addBox(-3.1F, 1.0F, -5.8F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Jaw3 = Jaw2.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(148, 88).addBox(-3.1F, -1.0F, 0.2F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 1.0F, -2.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 112).addBox(-5.0F, -4.0F, -3.0F, 10.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 36.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 62).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 19.0F, 0.1396F, 0.0F, 0.0F));

		PartDefinition TailClub = Tail2.addOrReplaceChild("TailClub", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -1.0F, -1.0F, 0.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 27.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(55, 62).mirror().addBox(-4.0F, -2.75F, -3.0F, 6.0F, 23.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 23.0F, 6.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(55, 62).addBox(-2.0F, -2.75F, -3.0F, 6.0F, 23.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 23.0F, 6.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -3.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -4.0F, 9.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(100, 0).mirror().addBox(-3.0F, -2.0F, -1.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 15.0F, -2.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 90).mirror().addBox(-4.0F, 0.0F, -8.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 4.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -5.0F, 8.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -4.0F, 9.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(100, 0).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 15.0F, -3.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 90).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Ruixinia entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//0.0F, -20.0F, -0.1745F, 0.0F, 0.0F
				this.Body.x =  Mth.lerp(sleepProgress, 0, -14.75F);
				this.Body.y = Mth.lerp(sleepProgress, -20, 11.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.0522F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, 0.0079F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -1.2701F);
				//10.0F, -0.4363F, 0.0F, 0.0F
				this.Neck1.y = Mth.lerp(sleepProgress, 10, 10.6F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, -4.363F, 0.4171F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 0.0232F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.0561F);
				//-7.0F, -0.0873F, 0.0F, 0.0F
				this.Neck2.y = Mth.lerp(sleepProgress, -7, -6.5F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.873F, 0.2676F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, -0.4596F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, 0.4181F);
				//0.7418F, 0.0F, 0.0F
				this.Head.xRot = Mth.lerp(sleepProgress, 0.7418F, 0.4331F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.0552F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.1188F);
				//-0.0698F, 0.0F, 0.0F
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0698F, -0.4152F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.3151F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.206F);
				//0.1396F, 0.0F, 0.0F
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1396F, -0.1642F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.2591F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.0235F);
				//-7.0F, 23.0F, 6.0F, 0.1745F, 0.0F
				this.LeftArm.x = Mth.lerp(sleepProgress, -7, -7.25F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 23, 10.25F);
				this.LeftArm.z = Mth.lerp(sleepProgress, 6, 2.5F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.1745F, -0.2443F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.1571F);
				//7.0F, 23.0F, 6.0F, 0.1745F, 0.0F
				this.RightArm.x = Mth.lerp(sleepProgress, 7, 9.05F);
				this.RightArm.y = Mth.lerp(sleepProgress, 23, 20.5F);
				this.RightArm.z = Mth.lerp(sleepProgress, 6, 4.5F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.1745F, -0.1745F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 0.5672F);
				//-7.0F, -4.0F, 0.0F, 0.0F, 0.0F
				this.LeftThigh.x = Mth.lerp(sleepProgress, -7, -3);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -4, 24);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.1737F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0166F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -1.5344F);
				//0.0F, 0.0F, 0.0F
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.5206F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, 0.05F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.121F);
				//-4.0F, 9.0F, 0.0F, 0.0F
				this.RightThigh.y = Mth.lerp(sleepProgress, -4, 6.75F);
				this.RightThigh.z = Mth.lerp(sleepProgress, 9, 10.75F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.0436F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -0.829F);
				//0.0F
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 0.3926F);
				//10.0F, 4.0F, 0.0F
				this.RightFoot.y = Mth.lerp(sleepProgress, 10, 8.1F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 4, 3.4F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 0.3491F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//0.0F, -20.0F, -0.1745F, 0.0F, 0.0F
				this.Body.x =  Mth.lerp(sleepProgress, -14.75F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 11.5F, -20);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.0522F, -0.1745F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0.0079F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -1.2701F, 0);
				//10.0F, -0.4363F, 0.0F, 0.0F
				this.Neck1.y = Mth.lerp(sleepProgress, 10.6F, 10);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.4171F, -4.363F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0.0232F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.0561F, 0);
				//-7.0F, -0.0873F, 0.0F, 0.0F
				this.Neck2.y = Mth.lerp(sleepProgress, -6.5F, -7);
				this.Neck2.xRot = Mth.lerp(sleepProgress, 0.2676F, -0.873F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, -0.4596F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0.4181F, 0);
				//0.7418F, 0.0F, 0.0F
				this.Head.xRot = Mth.lerp(sleepProgress, 0.4331F, 0.7418F);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.0552F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.1188F, 0);
				//-0.0698F, 0.0F, 0.0F
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.4152F, -0.0698F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.3151F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.206F, 0);
				//0.1396F, 0.0F, 0.0F
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.1642F, 0.1396F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.2591F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.0235F, 0);
				//-7.0F, 23.0F, 6.0F, 0.1745F, 0.0F
				this.LeftArm.x = Mth.lerp(sleepProgress, -7.25F, -7);
				this.LeftArm.y = Mth.lerp(sleepProgress, 10.25F, 23);
				this.LeftArm.z = Mth.lerp(sleepProgress, 2.5F, 6);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -0.2443F, 0.1745F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.1571F, 0);
				//7.0F, 23.0F, 6.0F, 0.1745F, 0.0F
				this.RightArm.x = Mth.lerp(sleepProgress, 9.05F, 7);
				this.RightArm.y = Mth.lerp(sleepProgress, 20.5F, 23F);
				this.RightArm.z = Mth.lerp(sleepProgress, 4.5F, 6);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.1745F, 0.1745F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.5672F, 0);
				//-7.0F, -4.0F, 0.0F, 0.0F, 0.0F
				this.LeftThigh.x = Mth.lerp(sleepProgress, -3, -7);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 24, -4);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.1737F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.0166F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -1.5344F, 0);
				//0.0F, 0.0F, 0.0F
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.5206F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0.05F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.121F, 0);
				//-4.0F, 9.0F, 0.0F, 0.0F
				this.RightThigh.y = Mth.lerp(sleepProgress, 6.75F, -4);
				this.RightThigh.z = Mth.lerp(sleepProgress, 10.75F, 9);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.0436F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -0.829F, 0);
				//0.0F
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.3926F, 0);
				//10.0F, 4.0F, 0.0F
				this.RightFoot.y = Mth.lerp(sleepProgress, 8.1F, 10);
				this.RightFoot.z = Mth.lerp(sleepProgress, 3.4F, 4);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0.3491F, 0);
			} else {
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))-0.1745F) + (attackProgress * (float)Math.toRadians(-50));
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount)-0.0698F;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount) + 0.1396F;
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + (headPitch * ((float) Math.PI / 270F)) + (attackProgress * (float)Math.toRadians(50))-0.4363F;
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount -0.0873F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) + 0.7418F;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftArm.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40)) + 0.1745F - ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))));
				this.RightArm.xRot = (Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60)) + 0.1745F;
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.Body.y = 8;
					this.Body.xRot = -0.25F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.RightThigh.y = 14;
					this.LeftThigh.y = 14;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck1.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.x = 0;
		this.Body.y = -20;
		this.Body.xRot = -0.1745F;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.Neck1.y = 10;
		this.Neck1.xRot = -0.4363F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.y = -7;
		this.Neck2.xRot = -0.0873F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Head.xRot = 0.7418F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.xRot = -0.0698F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0.1396F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = -7;
		this.LeftArm.y = 23F;
		this.LeftArm.z = 6;
		this.LeftArm.xRot = 0.1745F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.x = 7F;
		this.RightArm.y = 23F;
		this.RightArm.z = 6F;
		this.RightArm.xRot = 0.1745F;
		this.RightArm.zRot = 0;
		this.LeftThigh.x = -7;
		this.LeftThigh.y = -4;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.y = -4;
		this.RightThigh.z = 9F;
		this.RightThigh.xRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 10F;
		this.RightFoot.z = 4F;
		this.RightFoot.xRot = 0F;
	}

	public void sleepPose() {
		//0.0F, -20.0F, -0.1745F, 0.0F, 0.0F
		this.Body.x = -14.75F;
		this.Body.y = 11.5F;
		this.Body.xRot = -0.0522F;
		this.Body.yRot = 0.0079F;
		this.Body.zRot = -1.2701F;
		//10.0F, -0.4363F, 0.0F, 0.0F
		this.Neck1.y = 10.6F;
		this.Neck1.xRot = 0.4171F;
		this.Neck1.yRot = 0.0232F;
		this.Neck1.zRot = 0.0561F;
		//-7.0F, -0.0873F, 0.0F, 0.0F
		this.Neck2.y = -6.5F;
		this.Neck2.xRot = 0.2676F;
		this.Neck2.yRot = -0.4596F;
		this.Neck2.zRot = 0.4181F;
		//0.7418F, 0.0F, 0.0F
		this.Head.xRot = 0.4331F;
		this.Head.yRot = -0.0552F;
		this.Head.zRot = 0.1188F;
		//-0.0698F, 0.0F, 0.0F
		this.Tail1.xRot = -0.4152F;
		this.Tail1.yRot = -0.3151F;
		this.Tail1.zRot = -0.206F;
		//0.1396F, 0.0F, 0.0F
		this.Tail2.xRot = -0.1642F;
		this.Tail2.yRot = 0.2591F;
		this.Tail2.zRot = 0.0235F;
		//-7.0F, 23.0F, 6.0F, 0.1745F, 0.0F
		this.LeftArm.x = -7.25F;
		this.LeftArm.y = 10.25F;
		this.LeftArm.z = 2.5F;
		this.LeftArm.xRot = -0.2443F;
		this.LeftArm.zRot = -0.1571F;
		//7.0F, 23.0F, 6.0F, 0.1745F, 0.0F
		this.RightArm.x = 9.05F;
		this.RightArm.y = 20.5F;
		this.RightArm.z = 4.5F;
		this.RightArm.xRot = -0.1745F;
		this.RightArm.zRot = 0.5672F;
		//-7.0F, -4.0F, 0.0F, 0.0F, 0.0F
		this.LeftThigh.x = -3;
		this.LeftThigh.y = 24;
		this.LeftThigh.xRot = -0.1737F;
		this.LeftThigh.yRot = -0.0166F;
		this.LeftThigh.zRot = -1.5344F;
		//0.0F, 0.0F, 0.0F
		this.LeftLeg.xRot = 0.5206F;
		this.LeftLeg.yRot = 0.05F;
		this.LeftLeg.zRot = -0.121F;
		//-4.0F, 9.0F, 0.0F, 0.0F
		this.RightThigh.y = 6.75F;
		this.RightThigh.z = 10.75F;
		this.RightThigh.xRot = 0.0436F;
		this.RightThigh.zRot = -0.829F;
		//0.0F
		this.RightLeg.xRot = 0.3926F;
		//10.0F, 4.0F, 0.0F
		this.RightFoot.y = 8.1F;
		this.RightFoot.z = 3.4F;
		this.RightFoot.xRot = 0.3491F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}