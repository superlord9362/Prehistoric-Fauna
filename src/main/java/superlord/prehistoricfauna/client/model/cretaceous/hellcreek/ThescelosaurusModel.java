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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;

public class ThescelosaurusModel extends EntityModel<Thescelosaurus> {
	private final ModelPart RightLeg1;
	private final ModelPart LeftLeg1;
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightLeg2;
	private final ModelPart LeftLeg2;
	private final ModelPart Head;
	private final ModelPart Snout;
	
	public ThescelosaurusModel(ModelPart root) {
		this.RightLeg1 = root.getChild("RightLeg1");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.Body = root.getChild("Body");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.Head = Body.getChild("Head");
		this.Snout = Head.getChild("Snout");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(43, 0).addBox(-2.0F, -2.0F, -3.0F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 10.9F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 4.0F));

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(43, 0).addBox(-1.0F, -2.0F, -3.0F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 10.9F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 4.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -12.0F, 6.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9F, 0.0F, 0.0169F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 29).addBox(-2.0F, -8.0F, -4.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -12.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 54).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -4.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.1F, 3.0F, -9.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(3, 30).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 6.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(28, 44).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.1F, 3.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void setupAnim(Thescelosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			this.RightLeg1.xRot = -1.4076080683650378F;
			this.RightLeg1.yRot = 0.27366763203903305F;
			this.Body.xRot = -0.19547687289441354F;
			this.LeftArm.xRot = 0.7688175221876966F;
			this.LeftArm.yRot = 0.004188790111159634F;
			this.LeftLeg2.xRot = 0.03909537541112055F;
			this.LeftLeg2.yRot = 3.141592653589793F;
			this.Snout.xRot = 0.05235987755982988F;
			this.Tail2.xRot = 0.23457224414434488F;
			this.Tail2.yRot = -0.03909537541112055F;
			this.Tail2.zRot = -0.0781907508222411F;
			this.RightLeg2.xRot = 0.07801621390230003F;
			this.RightLeg2.yRot = 3.141592653589793F;
			this.RightArm.xRot = 0.6511823678875341F;
			this.RightArm.yRot = 0.11746065899211351F;
			this.LeftLeg1.xRot = -1.4072589279461283F;
			this.LeftLeg1.yRot = -0.35185837453889574F;
			this.Head.xRot = -0.19547687289441354F;
			this.Head.yRot = 0.7428121536172364F;
			this.Head.zRot = -0.0781907508222411F;
			this.Tail1.xRot = -0.0781907508222411F;
			this.Tail1.yRot = -0.27401668923415834F;
			this.Tail1.zRot = -0.1956514098143546F;
			this.Body.y = 18.9F;
			this.RightLeg1.y = 18.9F;
			this.RightLeg1.z = 3;
			this.RightLeg2.x = 1;
			this.RightLeg2.y = 2.8F;
			this.RightLeg2.z = 3.7F;
			this.LeftLeg1.y = 18.9F;
			this.LeftLeg1.z = 3;
			this.LeftLeg2.x = -1;
			this.LeftLeg2.y = 3;
			this.LeftLeg2.z = 3.7F;
			this.Head.z = -11.4F;
			this.RightArm.x = -3.1F;
			this.RightArm.y = 1;
			this.RightArm.z = -10;
			this.LeftArm.x = 3.1F;
			this.LeftArm.y = 1;
			this.LeftArm.z = -10;
		} else {
			this.Head.yRot = netHeadYaw * ((float) Math.PI / 180F);
			this.RightLeg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftLeg1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Head.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			if (entity.isEating()) {
				this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Body.xRot = 0.2F;
			}
			if (entity.isInWater()) {
				this.LeftLeg1.y = 20;
				this.RightLeg1.y = 20;
				this.Body.y = 20;
				this.Body.xRot = -0.5F;
				this.Tail1.xRot = 0.25F;
				this.Tail2.xRot = 0.25F;
				this.Head.xRot = 0.5F;
				this.LeftLeg1.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg1.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightArm.xRot = 0.5F;
				this.LeftArm.xRot = 0.5F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.Body.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg2.xRot = 0;
		this.LeftLeg2.yRot = 0;
		this.Snout.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightLeg2.xRot = 0;
		this.RightLeg2.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.Head.xRot = 0.13665927909957545F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0F;
		this.Body.y = 10.9F;
		this.RightLeg1.y = 10.9F;
		this.RightLeg1.z = 0;
		this.RightLeg2.x = 0;
		this.RightLeg2.y = 7F;
		this.RightLeg2.z = 4F;
		this.LeftLeg1.y = 10.9F;
		this.LeftLeg1.z = 0;
		this.LeftLeg2.x = 0;
		this.LeftLeg2.y = 7;
		this.LeftLeg2.z = 4;
		this.Head.z = -12;
		this.RightArm.x = 2.1F;
		this.RightArm.y = 3;
		this.RightArm.z = -9;
		this.LeftArm.x = -2.1F;
		this.LeftArm.y = 3;
		this.LeftArm.z = -9;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
