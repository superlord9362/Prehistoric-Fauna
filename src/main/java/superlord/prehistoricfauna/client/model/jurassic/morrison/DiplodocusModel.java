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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Diplodocus;

@SuppressWarnings("unused")
public class DiplodocusModel extends EntityModel<Diplodocus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart Tail4;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public DiplodocusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Tail3 = this.Tail2.getChild("Tail3");
		this.Tail4 = this.Tail3.getChild("Tail4");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -28.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 158).addBox(0.0F, -30.0F, -50.0F, 0.0F, 8.0F, 63.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-13.5F, -22.0F, -50.0F, 27.0F, 41.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 49.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(240, 166).addBox(-6.0F, -4.0F, -50.0F, 11.0F, 19.0F, 52.0F, new CubeDeformation(0.0F))
				.texOffs(0, 183).addBox(-0.5F, -10.0F, -50.0F, 0.0F, 6.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -14.0F, -50.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(67, 189).addBox(-3.5F, -3.0F, -59.0F, 7.0F, 11.0F, 61.0F, new CubeDeformation(0.0F))
				.texOffs(0, 183).addBox(0.0F, -9.0F, -59.0F, 0.0F, 6.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.0F, -50.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 1).addBox(-2.5F, 0.0F, -8.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(2, 18).addBox(-1.5F, 2.0F, -14.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.75F, -59.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 102).addBox(-7.5F, -4.0F, 0.0F, 15.0F, 22.0F, 61.0F, new CubeDeformation(0.0F))
				.texOffs(0, 147).addBox(0.0F, -11.0F, -1.0F, 0.0F, 7.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 10.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(152, 102).addBox(-4.5F, -2.0F, 0.0F, 9.0F, 14.0F, 61.0F, new CubeDeformation(0.0F))
				.texOffs(0, 140).addBox(0.0F, -9.0F, 1.0F, 0.0F, 7.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 60.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Tail3 = Tail2.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(152, 177).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 8.0F, 61.0F, new CubeDeformation(0.0F))
				.texOffs(0, 132).addBox(0.0F, -8.0F, 1.0F, 0.0F, 6.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 60.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Tail4 = Tail3.addOrReplaceChild("Tail4", CubeListBuilder.create().texOffs(176, 0).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 65.0F, new CubeDeformation(0.0F))
				.texOffs(0, 122).addBox(0.0F, -6.0F, 1.0F, 0.0F, 5.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 60.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(231, 118).mirror().addBox(-4.0F, -4.0F, -4.0F, 7.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(128, 185).addBox(-6.0F, 31.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(12.5F, 14.0F, -41.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(231, 118).addBox(-3.0F, -4.0F, -4.0F, 7.0F, 37.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(128, 185).addBox(4.0F, 31.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.5F, 14.0F, -41.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(245, 71).mirror().addBox(-11.0F, -5.0F, -8.0F, 12.0F, 30.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(15.5F, -21.0F, 47.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(176, 69).mirror().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 25.0F, -6.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(214, 69).mirror().addBox(-5.0F, -1.0F, -11.975F, 10.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, 9.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(245, 71).addBox(-1.0F, -5.0F, -8.0F, 12.0F, 30.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-15.5F, -21.0F, 47.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(176, 69).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 25.0F, -6.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(214, 69).addBox(-5.0F, -1.0F, -11.975F, 10.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 9.0F));

		return LayerDefinition.create(meshdefinition, 366, 261);
	}

	@Override
	public void setupAnim(Diplodocus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -19, 8.25F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.0805F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, 0.0376F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 0.215F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, -0.1309F, 0.5031F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 0.3487F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, -0.02275F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.2182F, -0.0969F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, 0.3427F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, -0.0839F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.3054F, -0.0709F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1309F, -0.0886F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.3537F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.2426F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0436F, 0.1401F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.3778F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.1404F);
				this.Tail3.xRot = Mth.lerp(sleepProgress, 0.0436F, 0.1001F);
				this.Tail3.yRot = Mth.lerp(sleepProgress, 0, -0.3778F);
				this.Tail3.zRot = Mth.lerp(sleepProgress, 0, -0.2404F);
				this.Tail4.xRot = Mth.lerp(sleepProgress, 0.0436F, 0.201F);
				this.Tail4.yRot = Mth.lerp(sleepProgress, 0, -0.3778F);
				this.Tail4.zRot = Mth.lerp(sleepProgress, 0, -0.1404F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3301F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.1462F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.3503F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.0769F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -0.0313F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.1938F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -21, 6.25F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.1531F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -21, 3.25F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1091F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 0.5251F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 8.25F, -19);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.0805F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, 0.0376F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 0.215F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.5031F, -0.1309F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0.3487F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, -0.02275F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.0969F, -0.2182F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0.3427F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, -0.0839F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.0709F, 0.3054F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.0886F, -0.1309F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.3537F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.2426F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1401F, 0.0436F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.3778F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.1404F, 0);
				this.Tail3.xRot = Mth.lerp(sleepProgress, 0.1001F, 0.0436F);
				this.Tail3.yRot = Mth.lerp(sleepProgress, -0.3778F, 0);
				this.Tail3.zRot = Mth.lerp(sleepProgress, -0.2404F, 0);
				this.Tail4.xRot = Mth.lerp(sleepProgress, 0.201F, 0.0436F);
				this.Tail4.yRot = Mth.lerp(sleepProgress, -0.3778F, 0);
				this.Tail4.zRot = Mth.lerp(sleepProgress, -0.1404F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3301F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.1462F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.3503F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.0769F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -0.0313F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.1938F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 6.25F, -21);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.1531F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 3.25F, -21);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.1091F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0.5251F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
			} else {
				this.Body.xRot = (attackProgress * (float)Math.toRadians(-50));
				this.Body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.1309F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.0436F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Tail3.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.0436F);
				this.Tail3.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Tail4.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.0436F);
				this.Tail4.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = 0.05F * Mth.sin(0.1F * ageInTicks / 3) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1809F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.2182F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = -0.025F * Mth.sin(0.1F * ageInTicks / 3) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.3054F);
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
					this.Body.y = 44;
					this.Body.xRot = -0.125F;
					this.Tail2.xRot = 0.125F;
					this.Tail3.xRot = 0.125F;
					this.RightThigh.y = 42;
					this.LeftThigh.y = 42;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.LeftLeg.xRot = 0.15F * Mth.sin(0.2F * ageInTicks / 1.5F) + 0.15F;
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck1.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y =  -19.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightArm.x = -12.5F;
		this.RightArm.y = 14.0F;
		this.RightArm.z = -41.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail1.z = 10;
		this.Tail1.xRot = -0.1309F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftArm.x = 12.5F;
		this.LeftArm.y = 14F;
		this.LeftArm.z = -41F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftFoot.y = 20;
		this.LeftFoot.z = 9;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftLeg.y = 25.0F;
		this.LeftLeg.z = -6;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.Neck2.xRot = -0.2182F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.RightFoot.y = 20;
		this.RightFoot.z = 9;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
		this.RightLeg.y = 25;
		this.RightLeg.z = -6;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftThigh.x = 15.5F;
		this.LeftThigh.y = -21;
		this.LeftThigh.z = 47;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightThigh.x = -15.5F;
		this.RightThigh.y = -21;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Neck1.x = 0.5F;
		this.Neck1.y = -14;
		this.Neck1.z = -50;
		this.Neck1.xRot = -0.1309F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Tail2.xRot = 0.0436F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Tail3.xRot = 0.0436F;
		this.Tail3.yRot = 0;
		this.Tail3.zRot = 0;
		this.Tail4.xRot = 0.0436F;
		this.Tail4.yRot = 0;
		this.Tail4.zRot = 0;
		this.Head.x = 0;
		this.Head.z = -59F;
		this.Head.xRot = 0.3054F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 8.25F;
		this.Body.xRot = -0.0805F;
		this.Body.yRot = 0.0376F;
		this.Body.zRot = 0.215F;
		this.Neck1.xRot = 0.5031F;
		this.Neck1.yRot = 0.3487F;
		this.Neck1.zRot = -0.02275F;
		this.Neck2.xRot = -0.0969F;
		this.Neck2.yRot = 0.3427F;
		this.Neck2.zRot = -0.0839F;
		this.Head.xRot = -0.0709F;
		this.Tail1.xRot = -0.0886F;
		this.Tail1.yRot = -0.3537F;
		this.Tail1.zRot = -0.2426F;
		this.Tail2.xRot = 0.1401F;
		this.Tail2.yRot = -0.3778F;
		this.Tail2.zRot = -0.1404F;
		this.Tail3.xRot = 0.1001F;
		this.Tail3.yRot = -0.3778F;
		this.Tail3.zRot = -0.2404F;
		this.Tail4.xRot = 0.201F;
		this.Tail4.yRot = -0.3778F;
		this.Tail4.zRot = -0.1404F;
		this.LeftArm.xRot = -1.3301F;
		this.LeftArm.yRot = 0.1462F;
		this.LeftArm.zRot = -0.3503F;
		this.RightArm.xRot = -1.0769F;
		this.RightArm.yRot = -0.0313F;
		this.RightArm.zRot = -0.1938F;
		this.LeftThigh.y = 6.25F;
		this.LeftThigh.xRot = 0.6472F;
		this.LeftThigh.yRot = -0.0018F;
		this.LeftThigh.zRot = -0.1531F;
		this.LeftLeg.xRot = 0.9163F;
		this.RightThigh.y = 3.25F;
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