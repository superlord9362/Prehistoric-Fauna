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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;

public class TyrannosaurusModel extends EntityModel<Tyrannosaurus> {
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftFeet;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightFeet;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Jaw1;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;

	public TyrannosaurusModel(ModelPart root) {
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.LeftFeet = LeftLeg2.getChild("LeftFeet");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.RightFeet = RightLeg2.getChild("RightFeet");
		this.Body1 = root.getChild("Body1");
		this.Body2 = Body1.getChild("Body2");
		this.Tail1 = Body1.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.Neck = Body2.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Jaw1 = Head1.getChild("Jaw1");
		this.LeftArm = Body2.getChild("LeftArm");
		this.RightArm = Body2.getChild("RightArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(0, 69).addBox(-7.0F, -6.0F, -9.0F, 10.0F, 34.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -26.0F, -1.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(96, 72).mirror().addBox(-3.0F, -8.0F, -1.0F, 6.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 26.0F, 9.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition LeftFeet = LeftLeg2.addOrReplaceChild("LeftFeet", CubeListBuilder.create().texOffs(98, 50).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 5.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(0, 69).addBox(-3.0F, -6.0F, -9.0F, 10.0F, 34.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -26.0F, -1.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(96, 72).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 26.0F, 9.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition RightFeet = RightLeg2.addOrReplaceChild("RightFeet", CubeListBuilder.create().texOffs(98, 50).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 5.0F));

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -10.0F, -16.0F, 15.0F, 33.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, 0.0F, 0.0F, -0.0063F, 0.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(8, 69).addBox(-5.0F, -5.0F, -8.0F, 10.0F, 18.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 17.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(92, 61).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 11.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 50.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(146, 0).addBox(-11.0F, -5.0F, -23.0F, 22.0F, 28.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -16.0F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(69, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1F, 19.0F, -13.0F, 0.25F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(69, 0).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.1F, 19.0F, -13.0F, 0.25F, 0.0F, 0.0F));

		PartDefinition Neck = Body2.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(167, 66).addBox(-5.0F, -21.0F, -13.0F, 10.0F, 29.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -22.0F, 0.25F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 157).addBox(-7.0F, -4.0F, -11.0F, 14.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.1F, -7.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(57, 150).addBox(-4.0F, 0.0F, -16.0F, 8.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(106, 150).addBox(-3.5F, 0.0F, -15.99F, 7.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(0, 186).addBox(-7.0F, 0.0F, -11.0F, 14.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition Jaw3 = Jaw1.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(47, 181).addBox(-5.5F, -5.0F, 0.0F, 11.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(5, 212).addBox(-4.0F, 0.0F, -16.0F, 8.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition LowerTeeth = Jaw2.addOrReplaceChild("LowerTeeth", CubeListBuilder.create().texOffs(45, 201).addBox(-3.0F, -3.0F, -15.0F, 6.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Tyrannosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.8f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			this.Body2.xRot = 0.41887902047863906F;
			this.Body2.yRot = -0.5235987755982988F;
			this.Neck.xRot = 0.8203047484373349F;
			this.Neck.yRot = -0.3490658503988659F;
			this.Neck.zRot = -0.10471975511965977F;
			this.RightFeet.xRot = 1.5707963267948966F;
			this.RightLeg2.xRot = -0.8726646259971648F;
			this.Tail2.xRot = 0.24434609527920614F;
			this.Tail2.yRot = 0.41887902047863906F;
			this.LeftLeg2.xRot = -0.8726646259971648F;
			this.LeftLeg1.xRot = -0.6981317007977318F;
			this.LeftLeg1.yRot = 0.5235987755982988F;
			this.Body1.xRot = -0.17453292519943295F;
			this.Tail1.xRot = -0.24434609527920614F;
			this.Tail1.yRot = 0.593411945678072F;
			this.Head1.xRot = -0.9075712110370513F;
			this.Head1.yRot = -0.06981317007977318F;
			this.Head1.zRot = 0.3490658503988659F;
			this.LeftArm.xRot = 1.3264502315156905F;
			this.LeftArm.yRot = -0.13962634015954636F;
			this.RightArm.xRot = 1.0878637547259988F;
			this.RightArm.yRot = 0.296705972839036F;
			this.RightArm.zRot = -0.13962634015954636F;
			this.RightLeg1.xRot = -0.6981317007977318F;
			this.RightLeg1.yRot = -0.2792526803190927F;
			this.LeftFeet.xRot = 1.5707963267948966F;
			this.Body1.y = -1.6F;
			this.Body2.x = 4;
			this.Body2.y = -1;
			this.Body2.z = -20;
			this.RightArm.x = 11;
			this.RightArm.z = -14;
			this.Neck.y = 10;
			this.Neck.z = -20;
			this.Head1.x = -1;
			this.Head1.y = -15;
			this.Head1.z = -6;
			this.Tail1.x = 3;
			this.Tail1.z = 19.5F;
			this.Tail2.x = 0.6F;
			this.LeftLeg1.y = -5;
			this.LeftLeg1.z = 3;
			this.LeftLeg2.y = 22;
			this.LeftLeg2.z = 8;
			this.RightLeg1.x = 7;
			this.RightLeg1.y = -5;
			this.RightLeg1.z = 2;
			this.RightLeg2.y = 22;
			this.RightLeg2.z = 8;
		} else {
			this.LeftLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
			this.LeftLeg2.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
			this.LeftFeet.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.RightLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
			this.RightLeg2.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
			this.RightFeet.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
			this.Body1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(70F);
			this.Head1.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
			this.Jaw1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(30F);
			this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.RightArm.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
			this.Body2.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
			this.Head1.y = -17.1F + attackProgress * -3;
			this.Head1.z = -7F + attackProgress * 5;
			if (entity.attackTick < 0) {
				this.Body1.xRot = Math.abs(-0.25F * Mth.sin(0.15F * ageInTicks));
				this.Tail1.xRot = -Math.abs(-0.2F * Mth.sin(0.15F * ageInTicks));
				this.Neck.xRot = Math.abs(-0.25F * Mth.sin(0.15F * ageInTicks));
				this.Jaw1.xRot = Math.abs(-0.45F * Mth.sin(0.15F * ageInTicks));
				this.LeftArm.xRot = Math.abs(-0.35F * Mth.sin(0.15F * ageInTicks));
				this.RightArm.xRot = Math.abs(-0.35F * Mth.sin(0.15F * ageInTicks));
			}
			if (entity.isInWater()) {
				this.LeftLeg1.y = 20;
				this.RightLeg1.y = 20;
				this.Body1.y = 20;
				this.Body1.xRot = -0.125F;
				this.Tail1.xRot = 0.0625F;
				this.Tail2.xRot = 0.06125F;
				this.Neck.xRot = 0.125F;
				this.LeftLeg1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg1.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFeet.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightFeet.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightArm.xRot = 0.125F;
				this.LeftArm.xRot = 0.125F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.Body2.xRot = 0;
		this.Body2.yRot = 0;
		this.Neck.xRot = 0.2275909337942703F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.RightFeet.xRot = 0;
		this.RightLeg2.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.LeftLeg2.xRot = 0;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.Body1.xRot = -0;
		this.Tail1.xRot = -0.04555309164612875F;
		this.Tail1.yRot = 0;
		this.Head1.xRot = 0;
		this.Head1.yRot = 0;
		this.Head1.zRot = 0;
		this.LeftArm.xRot = 0.27314402127920984F;
		this.LeftArm.yRot = 0;
		this.RightArm.xRot = 0.27314402127920984F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.LeftFeet.xRot = 0;
		this.Body1.y = -29F;
		this.Body2.x = 0;
		this.Body2.y = -3;
		this.Body2.z = -16;
		this.RightArm.x = 10.1F;
		this.RightArm.z = -13;
		this.Neck.y = 6;
		this.Neck.z = -22;
		this.Head1.x = 0;
		this.Head1.y = -17.1F;
		this.Head1.z = -7;
		this.Tail1.x = 0;
		this.Tail1.z = 17F;
		this.Tail2.x = 0F;
		this.LeftLeg1.y = -26;
		this.LeftLeg1.z = -1;
		this.LeftLeg2.y = 26;
		this.LeftLeg2.z = 9;
		this.RightLeg1.x = 6;
		this.RightLeg1.y = -26;
		this.RightLeg1.z = -1;
		this.RightLeg2.y = 26;
		this.RightLeg2.z = 9;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
