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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;

public class TriceratopsJuvenileModel extends EntityModel<Triceratops> {
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;
	private final ModelPart RightHindLeg1;
	private final ModelPart RightHindLeg2;
	private final ModelPart RightHindLeg3;
	private final ModelPart LeftHindLeg1;
	private final ModelPart LeftHindLeg2;
	private final ModelPart LeftHindLeg3;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public TriceratopsJuvenileModel(ModelPart root) {
		this.LeftFrontLeg = root.getChild("LeftFrontLeg");
		this.RightFrontLeg = root.getChild("RightFrontLeg");
		this.RightHindLeg1 = root.getChild("RightHindLeg1");
		this.RightHindLeg2 = RightHindLeg1.getChild("RightHindLeg2");
		this.RightHindLeg3 = RightHindLeg2.getChild("RightHindLeg3");
		this.LeftHindLeg1 = root.getChild("LeftHindLeg1");
		this.LeftHindLeg2 = LeftHindLeg1.getChild("LeftHindLeg2");
		this.LeftHindLeg3 = LeftHindLeg2.getChild("LeftHindLeg3");
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftFrontLeg = partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(96, 79).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 7.0F, -8.0F));

		PartDefinition RightFrontLeg = partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(96, 79).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 7.0F, -8.0F));

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(92, 0).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 3.0F, 5.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(100, 28).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 3.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(98, 61).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(92, 0).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 3.0F, 5.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(100, 28).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 3.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(98, 61).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -8.0F, -12.0F, 14.0F, 17.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(58, 0).addBox(-3.0F, -5.0F, -10.0F, 6.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, 0.0936F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 79).addBox(-4.0F, -3.0F, -9.0F, 8.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -10.0F, 0.5F, 0.0F, 0.0F));

		PartDefinition horn1_1 = Head1.addOrReplaceChild("horn1_1", CubeListBuilder.create().texOffs(10, 111).addBox(-0.8499F, -2.4911F, -10.1419F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9F, -1.0F, -9.0F, -1.1212F, -0.182F, 0.0F));

		PartDefinition Crest = Head1.addOrReplaceChild("Crest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, -3.0F, -0.9561F, 0.0F, 0.0F));

		PartDefinition Box_r1 = Crest.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(90, 112).addBox(-8.0243F, -6.3596F, -1.1469F, 16.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0243F, -4.0F, -1.0F, 0.2166F, 0.0F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(37, 88).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -9.0F));

		PartDefinition nasalhorn = Snout.addOrReplaceChild("nasalhorn", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -4.5F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -5.0F, 0.6374F, 0.0F, 0.0F));

		PartDefinition Beak = Snout.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(0, 106).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -7.0F));

		PartDefinition horn1 = Head1.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(10, 111).addBox(-1.1501F, -2.4911F, -10.1419F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9F, -1.0F, -9.0F, -1.1212F, 0.182F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 48).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(41, 109).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 12.0F, -0.3F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(66, 37).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 12.0F, 0.15F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Triceratops entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int sleepProgress = entity.getSleepingTicks();
		int wakingProgress = entity.getWakingUpTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isSleeping()) {
				resetModel();
			} else {
				this.Tail1.xRot = -0.43598323915870024F;
				this.Tail1.yRot = 0.11728612207217244F;
				this.RightHindLeg2.xRot = 2.5413739344815873F;
				this.RightHindLeg2.zRot = -0.3127630032889644F;
				this.RightHindLeg1.xRot = -1.13376586611655F;
				this.RightHindLeg1.yRot = 0.19547687289441354F;
				this.LeftFrontLeg.xRot = -1.2119566751954398F;
				this.LeftFrontLeg.yRot = -0.27366763203903305F;
				this.Neck.xRot = 0.1563815016444822F;
				this.Neck.yRot = -0.46914448828868976F;
				this.Head1.xRot = 0.14905111745452548F;
				this.Head1.yRot = -0.1563815016444822F;
				this.RightFrontLeg.xRot = -1.291369076266349F;
				this.RightFrontLeg.yRot = -0.23457224414434488F;
				this.LeftHindLeg1.xRot = -1.13376586611655F;
				this.LeftHindLeg1.yRot = -0.19547687289441354F;
				this.Tail2.xRot = 0.13020156286456727F;
				this.Tail2.yRot = 0.3127630032889644F;
				this.LeftHindLeg2.xRot = 2.5411994974301875F;
				this.LeftHindLeg2.zRot = 0.3127630032889644F;
				this.Body.y = 13;
				this.LeftFrontLeg.y = 19;
				this.RightFrontLeg.y = 19;
				this.LeftHindLeg1.y = 15;
				this.RightHindLeg1.y = 15;
			}
		}
		if (wakingProgress != 0) {
			//Tail1
//			this.Tail1.xRot = -0.3186971254089062F;
			if (this.Tail1.xRot < -0.3186971254089062F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//RightHindLeg2
			if (this.RightHindLeg2.xRot > 0) this.RightHindLeg2.xRot -= 0.05;
			if (this.RightHindLeg2.zRot < 0) this.RightHindLeg2.zRot += 0.05;
			//RightHindLeg1
//			this.RightHindLeg1.y = 3;
			if (this.RightHindLeg1.y > 3) this.RightHindLeg1.y -= 0.15;
			if (this.RightHindLeg1.xRot < 0) this.RightHindLeg1.xRot += 0.05;
			if (this.RightHindLeg1.yRot > 0) this.RightHindLeg1.yRot -= 0.05;
			//LeftFrontLeg
//			this.LeftFrontLeg.y = 7;
			if (this.LeftFrontLeg.y > 7) this.LeftFrontLeg.y -= 0.15;
			if (this.LeftFrontLeg.xRot < 0) this.LeftFrontLeg.xRot += 0.05;
			if (this.LeftFrontLeg.yRot < 0) this.LeftFrontLeg.yRot += 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//Head1
//			this.Head1.xRot = 0.500909508638178F;
			if (this.Head1.xRot < 0.500909508638178F) this.Head1.xRot += 0.05;
			if (this.Head1.yRot < 0) this.Head1.yRot += 0.05;
			//RightFrontLeg
//			this.RightFrontLeg.y = 7;
			if (this.RightFrontLeg.y > 7) this.RightFrontLeg.y -= 0.15;
			if (this.RightFrontLeg.xRot < 0) this.RightFrontLeg.xRot += 0.05;
			if (this.RightFrontLeg.yRot < 0) this.RightFrontLeg.yRot += 0.05;
			//LeftHindLeg1
//			this.LeftHindLeg1.y = 3;
			if (this.LeftHindLeg1.y > 3) this.LeftHindLeg1.y -= 0.15;
			if (this.LeftHindLeg1.xRot < 0) this.LeftHindLeg1.xRot += 0.05;
			if (this.LeftHindLeg1.yRot < 0) this.LeftHindLeg1.yRot += 0.05;
			//Tail2
//			this.Tail2.xRot = 0.0911061832922575F;
			if (this.Tail2.xRot > 0.0911061832922575F) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//LeftHindLeg2
			if (this.LeftHindLeg2.xRot > 0) this.LeftHindLeg2.xRot -= 0.05;
			if (this.LeftHindLeg2.zRot > 0) this.LeftHindLeg2.zRot -= 0.05;
			//Body
//			this.Body.y = 3;
			if (this.Body.y > 3) this.Body.y -= 0.15;
		}
		if (entity.isSleeping()) {
			if (sleepProgress != 0) {
				//Tail1
//				this.Tail1.xRot = -0.3186971254089062F;
				if (this.Tail1.xRot > -0.43598323915870024F) this.Tail1.xRot -= 0.05;
				if (this.Tail1.yRot < 0.11728612207217244F) this.Tail1.yRot += 0.05;
				//RightHindLeg2
				if (this.RightHindLeg2.xRot < 2.5413739344815873F) this.RightHindLeg2.xRot += 0.05;
				if (this.RightHindLeg2.zRot > -0.3127630032889644F) this.RightHindLeg2.zRot -= 0.05;
				//RightHindLeg1
//				this.RightHindLeg1.y = 3;
				if (this.RightHindLeg1.y < 15) this.RightHindLeg1.y += 0.15;
				if (this.RightHindLeg1.xRot > -1.13376586611655F) this.RightHindLeg1.xRot -= 0.05;
				if (this.RightHindLeg1.yRot < 0.19547687289441354F) this.RightHindLeg1.yRot += 0.05;
				//LeftFrontLeg
//				this.LeftFrontLeg.y = 7;
				if (this.LeftFrontLeg.y < 19) this.LeftFrontLeg.y += 0.15;
				if (this.LeftFrontLeg.xRot > -1.2119566751954398F) this.LeftFrontLeg.xRot -= 0.05;
				if (this.LeftFrontLeg.yRot > -0.27366763203903305F) this.LeftFrontLeg.yRot -= 0.05;
				//Neck
				if (this.Neck.xRot < 0.1563815016444822F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -0.46914448828868976F) this.Neck.yRot -= 0.05;
				//Head1
//				this.Head1.xRot = 0.500909508638178F;
				if (this.Head1.xRot > 0.14905111745452548F) this.Head1.xRot -= 0.05;
				if (this.Head1.yRot > -0.1563815016444822F) this.Head1.yRot -= 0.05;
				//RightFrontLeg
//				this.RightFrontLeg.y = 7;
				if (this.RightFrontLeg.y < 19) this.RightFrontLeg.y += 0.15;
				if (this.RightFrontLeg.xRot > -1.291369076266349F) this.RightFrontLeg.xRot -= 0.05;
				if (this.RightFrontLeg.yRot > -0.23457224414434488F) this.RightFrontLeg.yRot -= 0.05;
				//LeftHindLeg1
//				this.LeftHindLeg1.y = 3;
				if (this.LeftHindLeg1.y < 15) this.LeftHindLeg1.y += 0.15;
				if (this.LeftHindLeg1.xRot > -1.13376586611655F) this.LeftHindLeg1.xRot -= 0.05;
				if (this.LeftHindLeg1.yRot > -0.19547687289441354F) this.LeftHindLeg1.yRot -= 0.05;
				//Tail2
//				this.Tail2.xRot = 0.0911061832922575F;
				if (this.Tail2.xRot < 0.13020156286456727F) this.Tail2.xRot += 0.05;
				if (this.Tail2.yRot < 0.3127630032889644F) this.Tail2.yRot += 0.05;
				//LeftHindLeg2
				if (this.LeftHindLeg2.xRot < 2.5411994974301875F) this.LeftHindLeg2.xRot += 0.05;
				if (this.LeftHindLeg2.zRot < 0.3127630032889644F) this.LeftHindLeg2.zRot += 0.05;
				//Body
//				this.Body.y = 3;
				if (this.Body.y < 13) this.Body.y += 0.15;
			}
		} else {
			if (entity.isJuvenile()) {
				float speed = 1.0f;
				float degree = 1.0f;
				this.Body.y = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 3.0F;
				this.Neck.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.05F;
				this.Head1.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.5F;
				this.LeftFrontLeg.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightFrontLeg.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LeftHindLeg1.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LeftHindLeg2.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.LeftHindLeg3.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.RightHindLeg1.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.RightHindLeg2.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.RightHindLeg3.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.3F;
				this.Tail1.yRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.05F * limbSwingAmount;
				this.Tail2.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F;
				this.Tail2.yRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.15F * limbSwingAmount;
				if (entity.isInWater()) {
					this.Body.y = 8;
					this.Body.xRot = -0.25F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.LeftHindLeg1.y = 8;
					this.RightHindLeg1.y = 8;
					this.LeftFrontLeg.y = 10;
					this.RightFrontLeg.y = 10;
					this.LeftHindLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFrontLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFrontLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg3.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightHindLeg3.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck.xRot = 0.0625F;
					this.Tail1.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			} else {
				float speed = 1.0f;
				float degree = 1.0f;
				this.Body.y = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 3.0F;
				this.Neck.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.05F;
				this.Head1.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.5F;
				this.LeftFrontLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightFrontLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LeftHindLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LeftHindLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.LeftHindLeg3.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.RightHindLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.RightHindLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.RightHindLeg3.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.3F;
				this.Tail1.yRot = Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.05F * limbSwingAmount;
				this.Tail2.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F;
				this.Tail2.yRot = Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.15F * limbSwingAmount;
				if (entity.isInWater()) {
					this.Body.y = 8;
					this.LeftHindLeg1.y = 12;
					this.RightHindLeg1.y = 12;
					this.LeftFrontLeg.y = 19;
					this.RightFrontLeg.y = 19;
					this.LeftHindLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFrontLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFrontLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg3.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightHindLeg3.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck.xRot = -0.35F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.25F) + 0.15F;
				this.Body.xRot = 0.1F;
			}
		}
	}
	
	public void resetModel() {
		this.Tail1.xRot = -0.3186971254089062F;
		this.Tail1.yRot = 0;
		this.RightHindLeg2.xRot = 0;
		this.RightHindLeg2.zRot = 0;
		this.RightHindLeg1.xRot = 0;
		this.RightHindLeg1.yRot = 0;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Head1.xRot = 0.500909508638178F;
		this.Head1.yRot = 0;
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.LeftHindLeg1.xRot = 0;
		this.LeftHindLeg1.yRot = 0;
		this.Tail2.xRot = 0.0911061832922575F;
		this.Tail2.yRot = 0;
		this.LeftHindLeg2.xRot = 0;
		this.LeftHindLeg2.zRot = 0;
		this.Body.y = 3;
		this.LeftFrontLeg.y = 7;
		this.RightFrontLeg.y = 7;
		this.LeftHindLeg1.y = 3;
		this.RightHindLeg1.y = 3;
		this.Body.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}