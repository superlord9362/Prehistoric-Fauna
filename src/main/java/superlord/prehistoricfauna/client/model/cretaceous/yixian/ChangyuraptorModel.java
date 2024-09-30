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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Changyuraptor;

public class ChangyuraptorModel extends EntityModel<Changyuraptor> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail;
	private final ModelPart RightWing;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftWing;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public ChangyuraptorModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Tail = Body.getChild("Tail");
		this.RightWing = Body.getChild("RightWing");
		this.RightLeg = Body.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftWing = Body.getChild("LeftWing");
		this.LeftLeg = Body.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -5.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -5.5F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -5.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, 1.9F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, -1.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(9, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(25, 4).addBox(-2.0F, 0.4F, 4.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.5F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(11, 15).addBox(-0.25F, -0.5F, -0.4F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, -5.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(36, 19).addBox(0.0F, 1.5F, -1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(29, 20).addBox(0.0F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, 0.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(42, 20).addBox(-0.75F, 0.0F, -2.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 5.5F, 0.0F));

		PartDefinition RightSickle = RightFoot.addOrReplaceChild("RightSickle", CubeListBuilder.create().texOffs(45, 22).addBox(-0.75F, 4.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 1.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(11, 15).mirror().addBox(-0.75F, -0.5F, -0.4F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 1.5F, -5.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(36, 19).mirror().addBox(-1.0F, 1.5F, -1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(29, 20).mirror().addBox(-1.0F, -0.5F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 1.5F, 0.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(42, 20).mirror().addBox(-1.25F, 0.0F, -2.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 5.5F, 0.0F));

		PartDefinition LeftSickle = LeftFoot.addOrReplaceChild("LeftSickle", CubeListBuilder.create().texOffs(45, 22).mirror().addBox(0.75F, 4.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -6.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 58, 28);
	}

	@Override
	public void setupAnim(Changyuraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {

			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {

			} else {
				if (entity.getFallingTicks() > 0) {
					this.Body.xRot = -0.2F;
					this.Body.zRot = Mth.sin(ageInTicks * 0.25F) * 0.025F;
					this.Neck.xRot = 0.6F + Mth.sin(ageInTicks * 0.1F) * 0.025F;
					this.Tail.xRot = 0.2F + Mth.sin(ageInTicks * 0.1F) * 0.1F;
					this.RightWing.zRot = -1.6F + Mth.sin(ageInTicks * 0.1F) * 0.15F;
					this.LeftWing.zRot = 1.6F + Mth.sin(ageInTicks * 0.1F) * -0.15F;
					this.RightLeg.xRot = 0.5F;
					this.RightLeg.zRot = Mth.sin(ageInTicks * 0.1F) * 0.1F - 1.35F;
					this.RightFoot.y = 5.51F;
					this.LeftLeg.xRot = 0.5F;
					this.LeftLeg.zRot = Mth.sin(ageInTicks * 0.1F) * -0.1F + 1.35F;
					this.LeftFoot.y = 5.51F;
				} else {
					this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Mth.sin(ageInTicks * 0.15F) * -0.05F) + (Mth.sin(limbSwing * 0.8F) * 0.025F);
					this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
					this.RightWing.zRot = (-Mth.cos(0.05F * ageInTicks) * 0.05F) + (-Mth.abs(Mth.sin(limbSwing * 0.6F) * 2.25F * limbSwingAmount));
					this.LeftWing.zRot = (Mth.cos(0.05F * ageInTicks) * 0.05F) + (Mth.abs(Mth.sin(limbSwing * 0.6F) * 2.25F * limbSwingAmount));
					this.Tail.yRot = (Mth.sin(ageInTicks * 0.15F) * -0.15F) + (Mth.sin(limbSwing * 0.4F) * 0.25F * limbSwingAmount); 
					this.Body.xRot = Mth.sin(limbSwing * 0.6F) * 0.35F * limbSwingAmount;
					this.LeftLeg.xRot = Mth.sin(limbSwing * 0.4F) * 1.25F * limbSwingAmount;
					this.LeftLeg.y = Mth.sin(limbSwing * 0.4F) * 0.25F * limbSwingAmount + 1.5F;
					this.LeftFoot.xRot = Mth.sin(limbSwing * 0.4F) * 0.25F * limbSwingAmount;
					this.RightLeg.xRot = Mth.sin(limbSwing * 0.4F) * -1.25F * limbSwingAmount;
					this.RightLeg.y = Mth.sin(limbSwing * 0.4F) * -0.25F * limbSwingAmount + 1.5F;
					this.RightFoot.xRot = Mth.sin(limbSwing * 0.4F) * -0.25F * limbSwingAmount;
				}
			}
		}
	}

	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.RightLeg.xRot = 0;
		this.Body.zRot = 0;
		this.Neck.yRot = 0;
		this.Tail.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightLeg.y = 1.5F;
		this.LeftLeg.y = 1.5F;
		this.RightFoot.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.xRot = 0;
		this.Tail.zRot = 0;
	}

	public void sleepPose() {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}