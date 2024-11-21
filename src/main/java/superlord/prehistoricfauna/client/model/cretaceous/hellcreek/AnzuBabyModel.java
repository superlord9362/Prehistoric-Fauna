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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Anzu;

@SuppressWarnings("unused")
public class AnzuBabyModel extends EntityModel<Anzu> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public AnzuBabyModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
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

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.5F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(8, 22).mirror().addBox(0.0F, -0.5F, -1.5F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.1F, 0.5F, -4.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(8, 22).addBox(0.0F, -0.5F, -1.5F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.1F, 0.5F, -4.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -5.9F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1F, -5.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 12).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 4).addBox(-1.5F, 0.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 2).addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, -2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 2.5F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(18, 18).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(14, 21).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 1.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(23, 7).mirror().addBox(-0.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(18, 18).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(14, 21).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(23, 7).addBox(-1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Anzu entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				
			} else setSleepingPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				
			} else {
				this.RightThigh.xRot = Mth.sin(0.4F * limbSwing) * 0.25F * limbSwingAmount;
				this.RightLeg.xRot = Mth.sin(limbSwing*0.4F) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.RightFoot.xRot = Mth.sin(limbSwing * 0.4F) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.LeftThigh.xRot = Mth.sin(0.4F * limbSwing + (float)Math.PI) * 0.25F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.sin(limbSwing*0.4F + (float)Math.PI) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.LeftFoot.xRot = Mth.sin(limbSwing * 0.4F + (float)Math.PI) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount) - 0.1F;
				this.RightArm.xRot = Mth.sin(limbSwing * 0.4F) * 0.1F * limbSwingAmount + 0.1F;
				this.LeftArm.xRot = Mth.sin(limbSwing * 0.4F) * 0.1F * limbSwingAmount + 0.1F;
				this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.xRot = Mth.abs(Mth.sin(limbSwing * 0.2F) * 0.25F * limbSwingAmount) + (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				if (entity.isInWater()) {
					this.RightArm.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftArm.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Body.y = 34;
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.Neck.z = -5.5F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.z = -2F;
		this.Head.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail.y = -1.5F;
		this.Tail.z = 2.5F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.RightThigh.y = -0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.y = 5F;
		this.RightFoot.xRot = 0F;
		this.LeftThigh.y = -0F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.y = 5F;
		this.LeftFoot.xRot = 0;
	}
	
	public void setSleepingPose() {
		this.Body.y = 4.6F;
		this.LeftArm.xRot = 1.0337F;
		this.LeftArm.yRot = -0.2446F;
		this.LeftArm.zRot = 0.0358F;
		this.Neck.z = -4.9F;
		this.Neck.xRot = 0.1587F;
		this.Neck.yRot = -0.6506F;
		this.Neck.zRot = 0.1293F;
		this.Head.z = -2.15F;
		this.Head.xRot = 0.5672F;
		this.RightArm.xRot = 0.914F;
		this.RightArm.yRot = 0.3535F;
		this.RightArm.zRot = -0.2613F;
		this.Tail.xRot = -0.3103F;
		this.Tail.yRot = 0.1494F;
		this.Tail.zRot = 0.0281F;
		this.RightThigh.y = 4.9F;
		this.RightThigh.xRot = -0.0452F;
		this.RightThigh.yRot = -0.2615F;
		this.RightThigh.zRot = 0.0117F;
		this.RightLeg.xRot = -1.5272F;
		this.RightFoot.xRot = 1.5581F;
		this.LeftThigh.y = 4.9F;
		this.LeftThigh.xRot = -0.0457F;
		this.LeftThigh.yRot = 0.3051F;
		this.LeftThigh.zRot = -0.0138F;
		this.LeftLeg.xRot = -1.5272F;
		this.LeftFoot.xRot = 1.5144F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
