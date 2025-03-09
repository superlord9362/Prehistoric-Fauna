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

@SuppressWarnings("unused")
public class DongbeititanModel  extends EntityModel<Dongbeititan> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
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

	public DongbeititanModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Snout = this.Head.getChild("Snout");
		this.Jaw1 = this.Head.getChild("Jaw1");
		this.Jaw2 = this.Jaw1.getChild("Jaw2");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
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

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(123, 11).addBox(-16.0F, -15.0F, -26.0F, 32.0F, 31.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.25F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(44, 47).addBox(-7.0F, -8.0F, -45.0F, 14.0F, 18.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -26.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -45.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition neck2_r1 = Neck2.addOrReplaceChild("neck2_r1", CubeListBuilder.create().texOffs(46, 23).addBox(-9.0F, -83.0F, -1.0F, 8.0F, 60.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.6527F, 26.9696F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 11).addBox(-3.0F, -5.7223F, -11.1958F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.01F))
				.texOffs(2, 75).addBox(-1.5F, 1.7777F, -13.1958F, 5.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F))
				.texOffs(3, 67).addBox(-2.5F, 1.7777F, -11.1958F, 7.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.0F, -0.3473F, -56.0304F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, -5.1849F, -0.2011F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.4626F, -13.9947F));

		PartDefinition Jaw1 = Head.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(33, 5).addBox(-3.0F, -0.1849F, -12.7011F, 8.0F, 2.0F, 13.0F, new CubeDeformation(0.01F))
				.texOffs(7, 54).addBox(-2.5F, -0.9349F, -12.7011F, 7.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F))
				.texOffs(6, 62).addBox(-1.5F, -0.9349F, -14.7011F, 5.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F))
				.texOffs(1, 34).addBox(-2.0F, -4.1849F, -6.7011F, 6.0F, 4.0F, 7.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 2.4626F, 1.5053F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(21, 1).addBox(-4.0F, -3.1849F, -0.7011F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, -15.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(246, 8).addBox(-7.0F, -8.0F, -3.0F, 14.0F, 18.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 26.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offset(3.0F, 1.0F, 31.0F));

		PartDefinition tail2_r1 = Tail2.addOrReplaceChild("tail2_r1", CubeListBuilder.create().texOffs(258, 63).addBox(-4.0F, -5.1647F, -2.5135F, 8.0F, 9.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(139, 116).addBox(-6.5F, -5.0F, -5.5F, 9.0F, 31.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(15.75F, 9.25F, -16.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(139, 116).mirror().addBox(-2.5F, -5.0F, -5.5F, 9.0F, 31.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-15.75F, 9.25F, -16.5F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(71, 127).addBox(-4.5F, -6.75F, -6.5F, 9.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(13.5F, -11.25F, 14.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(63, 172).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 19.25F, -1.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(63, 194).addBox(-4.0F, 0.0F, -7.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 12.0F, 0.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(71, 127).mirror().addBox(-4.5F, -6.75F, -6.5F, 9.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.5F, -11.25F, 14.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(63, 172).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.25F, 19.25F, -1.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(63, 194).mirror().addBox(-5.0F, 0.0F, -7.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 384, 264);
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
				//-11.25F, 0.0F, 0.0F, 0.0F
				this.Body.y = Mth.lerp(sleepProgress, -11.25F, 8.25F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.1705F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, 0.0376F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 0.215F);
				//-6.0F, -26.0F, -0.1309F, 0.0F, 0.0F
				this.Neck1.y = Mth.lerp(sleepProgress, -6, -4.2F);
				this.Neck1.z = Mth.lerp(sleepProgress, -26, -24.5F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, -0.1309F, 0.5031F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 0.3487F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, -0.02275F);
				//-0.1745F, 0.0F, 0.0F
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.0969F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, 0.3427F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, -0.0839F);
				//0.3054F
				this.Head.xRot = Mth.lerp(sleepProgress, 0.3054F, -0.1309F);
				//-0.2618F, 0.0F, 0.0F
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2618F, -0.0886F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.3537F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.2426F);
				//0.0F, 0.0F, 0.0F
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.1401F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.3778F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.1404F);
				//15.75F, 9.25F, -16.5F, 0.0F, 0.0F, 0.0F
				this.LeftArm.x = Mth.lerp(sleepProgress, 15.75F, 17.95F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 9.25F, 11.45F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -16.5F, -14);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3301F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.2462F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.3503F);
				//-15.75F, 9.25F, 0.0F, 0.0F, 0.0F
				this.RightArm.x = Mth.lerp(sleepProgress, -15.75F, -14.95F);
				this.RightArm.y = Mth.lerp(sleepProgress, 9.25F, 13.65F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.0769F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.0313F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.1938F);
				//13.5F, -11.25F, 14.5F, 0.0F, 0.0F, 0.0F
				this.LeftThigh.x = Mth.lerp(sleepProgress, 13.5F, 14.7F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -11.25F, 14.65F);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 14.5F, 13.75F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.9472F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.1531F);
				//19.25F, 0.0F
				this.LeftLeg.y = Mth.lerp(sleepProgress, 19.25F, 16.55F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				//12.0F, 0.0F, 0.0F
				this.LeftFoot.y = Mth.lerp(sleepProgress, 12, 10.9F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 0, -0.8F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 0.4189F);
				//-11.25F, 14.5F, 0.0F, 0.0F, 0.0F
				this.RightThigh.y = Mth.lerp(sleepProgress, -11.25F, 7.75F);
				this.RightThigh.z = Mth.lerp(sleepProgress, 14.5F, 14.8F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1091F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.5251F);
				//19.25F, -1.5F, 0.0F
				this.RightLeg.y = Mth.lerp(sleepProgress, 19.25F, 15.55F);
				this.RightLeg.z = Mth.lerp(sleepProgress, -1.5F, 0.3F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				//12.0F, 0.0F
				this.RightFoot.y = Mth.lerp(sleepProgress, 12, 10.8F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 0.5411F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//-11.25F, 0.0F, 0.0F, 0.0F
				this.Body.y = Mth.lerp(sleepProgress, 8.25F, -11.25F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.1705F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0.0376F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 0.215F, 0);
				//-6.0F, -26.0F, -0.1309F, 0.0F, 0.0F
				this.Neck1.y = Mth.lerp(sleepProgress, -4.2F, -6);
				this.Neck1.z = Mth.lerp(sleepProgress, -24.5F, -26);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.5031F, -0.1309F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0.3487F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, -0.02275F, 0);
				//-0.1745F, 0.0F, 0.0F
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.0969F, -0.1745F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0.3427F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, -0.0839F, 0);
				//0.3054F
				this.Head.xRot = Mth.lerp(sleepProgress, -0.1309F, 0.3054F);
				//-0.2618F, 0.0F, 0.0F
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0886F, -0.2618F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.3537F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.2426F, 0);
				//0.0F, 0.0F, 0.0F
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1401F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.3778F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.1404F, 0);
				//15.75F, 9.25F, -16.5F, 0.0F, 0.0F, 0.0F
				this.LeftArm.x = Mth.lerp(sleepProgress, 17.95F, 15.75F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 11.45F, 9.25F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -14, -16.5F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3301F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.2462F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.3503F, 0);
				//-15.75F, 9.25F, 0.0F, 0.0F, 0.0F
				this.RightArm.x = Mth.lerp(sleepProgress, -14.95F, -15.75F);
				this.RightArm.y = Mth.lerp(sleepProgress, 13.65F, 9.25F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.0769F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.0313F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.1938F, 0);
				//13.5F, -11.25F, 14.5F, 0.0F, 0.0F, 0.0F
				this.LeftThigh.x = Mth.lerp(sleepProgress, 14.7F, 13.5F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 14.65F, -11.25F);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 13.75F, 14.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.9472F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.1531F, 0);
				//19.25F, 0.0F
				this.LeftLeg.y = Mth.lerp(sleepProgress, 16.55F, 19.25F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				//12.0F, 0.0F, 0.0F
				this.LeftFoot.y = Mth.lerp(sleepProgress, 10.9F, 12);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -0.8F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0.4189F, 0);
				//-11.25F, 14.5F, 0.0F, 0.0F, 0.0F
				this.RightThigh.y = Mth.lerp(sleepProgress, 7.75F, -11.25F);
				this.RightThigh.z = Mth.lerp(sleepProgress, 14.8F, 14.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.1091F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.5251F, 0);
				//19.25F, -1.5F, 0.0F
				this.RightLeg.y = Mth.lerp(sleepProgress, 15.55F, 19.25F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 0.3F, -1.5F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				//12.0F, 0.0F
				this.RightFoot.y = Mth.lerp(sleepProgress, 10.8F, 12);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0.5411F, 0);
			} else {
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (attackProgress * (float)Math.toRadians(-50));
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount) - 0.2618F;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount) + (headPitch * ((float) Math.PI / 270F)) + (attackProgress * (float)Math.toRadians(50)) - 0.1309F;
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 360F));
				this.Neck2.xRot = (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1745F) + (headPitch * ((float) Math.PI / 270F));
				this.Neck2.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 270));
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) + 0.3054F;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftArm.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.RightArm.xRot = (Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.Body.y = 29;
//					this.Body.xRot = -0.15F;
//					this.Tail1.xRot = 0.025F;
//					this.Tail2.xRot = 0.025F;
					this.RightThigh.y = 29F;
					this.LeftThigh.y = 29;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
//					this.Neck1.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = -11.25F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.Neck1.y = -6;
		this.Neck1.z = -26;
		this.Neck1.xRot = -0.1309F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.xRot = -0.1745F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Head.xRot = 0.3054F;
		this.Tail1.xRot = -0.2618F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = 15.75F;
		this.LeftArm.y = 9.25F;
		this.LeftArm.z = -16.5F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.x = -15.75F;
		this.RightArm.y = 9.25F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.LeftThigh.y = -11.25F;
		this.LeftThigh.x = 13.5F;
		this.LeftThigh.y = -11.25F;
		this.LeftThigh.z = 14.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.y = 19.25F;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.y = 12F;
		this.LeftFoot.z = 0;
		this.LeftFoot.xRot = 0;
		this.RightThigh.y = -11.25F;
		this.RightThigh.z = 14.5F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.y = 19.25F;
		this.RightLeg.z = -1.5F;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 12F;
		this.RightFoot.xRot = 0;
	}

	public void sleepPose() {
		//-11.25F, 0.0F, 0.0F, 0.0F
		this.Body.y = 8.25F;
		this.Body.xRot = -0.1705F;
		this.Body.yRot = 0.0376F;
		this.Body.zRot = 0.215F;
		//-6.0F, -26.0F, -0.1309F, 0.0F, 0.0F
		this.Neck1.y = -4.2F;
		this.Neck1.z = -24.5F;
		this.Neck1.xRot = 0.5031F;
		this.Neck1.yRot = 0.3487F;
		this.Neck1.zRot = -0.02275F;
		//-0.1745F, 0.0F, 0.0F
		this.Neck2.xRot = -0.0969F;
		this.Neck2.yRot = 0.3427F;
		this.Neck2.zRot = -0.0839F;
		//0.3054F
		this.Head.xRot = -0.1309F;
		//-0.2618F, 0.0F, 0.0F
		this.Tail1.xRot = -0.0886F;
		this.Tail1.yRot = -0.3537F;
		this.Tail1.zRot = -0.2426F;
		//0.0F, 0.0F, 0.0F
		this.Tail2.xRot = 0.1401F;
		this.Tail2.yRot = -0.3778F;
		this.Tail2.zRot = -0.1404F;
		//15.75F, 9.25F, -16.5F, 0.0F, 0.0F, 0.0F
		this.LeftArm.x = 17.95F;
		this.LeftArm.y = 11.45F;
		this.LeftArm.z = -14;
		this.LeftArm.xRot = -1.3301F;
		this.LeftArm.yRot = 0.2462F;
		this.LeftArm.zRot = -0.3503F;
		//-15.75F, 9.25F, 0.0F, 0.0F, 0.0F
		this.RightArm.x = -14.95F;
		this.RightArm.y = 13.65F;
		this.RightArm.xRot = -1.0769F;
		this.RightArm.yRot = -0.0313F;
		this.RightArm.zRot = -0.1938F;
		//13.5F, -11.25F, 14.5F, 0.0F, 0.0F, 0.0F
		this.LeftThigh.x = 14.7F;
		this.LeftThigh.y = 14.65F;
		this.LeftThigh.z = 13.75F;
		this.LeftThigh.xRot = 0.9472F;
		this.LeftThigh.yRot = -0.0018F;
		this.LeftThigh.zRot = -0.1531F;
		//19.25F, 0.0F
		this.LeftLeg.y = 16.55F;
		this.LeftLeg.xRot = 0.9163F;
		//12.0F, 0.0F, 0.0F
		this.LeftFoot.y = 10.9F;
		this.LeftFoot.z = -0.8F;
		this.LeftFoot.xRot = 0.4189F;
		//-11.25F, 14.5F, 0.0F, 0.0F, 0.0F
		this.RightThigh.y = 7.75F;
		this.RightThigh.z = 14.8F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.yRot = 0.1091F;
		this.RightThigh.zRot = 0.5251F;
		//19.25F, -1.5F, 0.0F
		this.RightLeg.y = 15.55F;
		this.RightLeg.z = 0.3F;
		this.RightLeg.xRot = 1.1345F;
		//12.0F, 0.0F
		this.RightFoot.y = 10.8F;
		this.RightFoot.xRot = 0.5411F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}