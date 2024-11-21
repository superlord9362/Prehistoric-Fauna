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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Zhenyuanlong;

@SuppressWarnings("unused")
public class ZhenyuanlongModel extends EntityModel<Zhenyuanlong> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart FeatherDisplay;
	private final ModelPart Tail;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public ZhenyuanlongModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.FeatherDisplay = this.Head.getChild("FeatherDisplay");
		this.Tail = this.Body.getChild("Tail");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.LeftWing = this.Body.getChild("LeftWing");
		this.RightWing = this.Body.getChild("RightWing");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, -7.5F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.5F, 3.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -7.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 23).addBox(-1.5F, -0.6F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 0.0F));

		PartDefinition FeatherDisplay = Head.addOrReplaceChild("FeatherDisplay", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition feather_display_right_r1 = FeatherDisplay.addOrReplaceChild("feather_display_right_r1", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -0.5F, -2.0F, 0.3054F, -0.2618F, 0.0F));

		PartDefinition feather_display_left_r1 = FeatherDisplay.addOrReplaceChild("feather_display_left_r1", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, -2.0F, 0.3054F, 0.2618F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(27, 5).addBox(-1.0F, -0.99F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-2.0F, -1.0F, 3.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 1.5F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(54, 18).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -1.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(57, 26).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(52, 34).addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(37, 18).addBox(0.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -6.5F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(37, 18).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.5F, -6.5F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(54, 18).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.5F, -1.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(57, 26).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(52, 34).mirror().addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 48);
	}

	@Override
	public void setupAnim(Zhenyuanlong entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0f;
		float degree = 1.0f;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 14.5F, 21.4F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.17463292F);
				this.LeftWing.zRot = Mth.lerp(sleepProgress, 0, -0.9F);
				this.RightWing.zRot = Mth.lerp(sleepProgress, 0, 0.9F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8134F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.2176F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.6F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.13962634F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 1.0471976F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -2.268928F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.83774805F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8134F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2176F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.6F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6F);
			} else sleepPose();
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) - 0.17463292F;
			this.Head.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.RightWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + 0.9F;
			this.LeftWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) - 0.9F;
			this.RightThigh.xRot = -0.8134F - Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.LeftThigh.xRot = -0.8134F - Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 21.4F, 14.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.17463292F, 0);
				this.LeftWing.zRot = Mth.lerp(sleepProgress, -0.9F, 0);
				this.RightWing.zRot = Mth.lerp(sleepProgress, 0.9F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.8134F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.2176F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.6F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.13962634F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 1.0471976F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -2.268928F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.83774805F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.8134F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.2176F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.6F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.6F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.6F, 0);
			} else {
				this.RightThigh.xRot = Mth.sin(0.4F * limbSwing) * 0.25F * limbSwingAmount;
				this.RightLeg.xRot = Mth.sin(limbSwing*0.4F) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.RightFoot.xRot = Mth.sin(limbSwing * 0.4F) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.LeftThigh.xRot = Mth.sin(0.4F * limbSwing + (float)Math.PI) * 0.25F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.sin(limbSwing*0.4F + (float)Math.PI) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
				this.LeftFoot.xRot = Mth.sin(limbSwing * 0.4F + (float)Math.PI) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Neck.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + 0.25F;
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount) - 0.1F;
				this.Tail.yRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount) - 0.1F;
				this.LeftWing.xRot = Mth.sin(limbSwing * 0.4F) * 0.1F * limbSwingAmount + 0.1F;
				this.RightWing.xRot = Mth.sin(limbSwing * 0.4F) * 0.1F * limbSwingAmount + 0.1F;
				this.RightWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				if (entity.isInWater()) {
					this.LeftWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.RightWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Body.y = 20;
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 14.5F;
		this.Body.xRot = 0;
		this.LeftWing.zRot = 0F;
		this.RightWing.zRot = 0F;
		this.RightThigh.xRot = 0F;
		this.RightThigh.yRot = 0F;
		this.RightLeg.xRot = 0F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0F;
		this.Neck.yRot = 0F;
		this.Neck.zRot = 0F;
		this.LeftThigh.xRot = 0F;
		this.LeftThigh.yRot = 0F;
		this.LeftLeg.xRot = 0F;
		this.LeftFoot.xRot = 0F;
		this.RightFoot.xRot = 0F;
		this.Tail.y = -1.35F;
	}

	public void sleepPose() {
		this.Body.y = 21.4F;
		this.Body.xRot = -0.17463292F;
		this.LeftWing.zRot = -0.9F;
		this.RightWing.zRot = 0.9F;
		this.RightThigh.xRot = -0.8134F;
		this.RightThigh.yRot = 0.2176F;
		this.RightLeg.xRot = -0.6F;
		this.Tail.xRot = -0.13962634F;
		this.Tail.yRot = 1.0471976F;
		this.Neck.yRot = -2.268928F;
		this.Neck.zRot = 0.83774805F;
		this.LeftThigh.xRot = -0.8134F;
		this.LeftThigh.yRot = -0.2176F;
		this.LeftLeg.xRot = -0.6F;
		this.LeftFoot.xRot = 1.6F;
		this.RightFoot.xRot = 1.6F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}