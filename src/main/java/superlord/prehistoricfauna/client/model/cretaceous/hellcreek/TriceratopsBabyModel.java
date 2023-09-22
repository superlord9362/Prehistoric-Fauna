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

public class TriceratopsBabyModel extends EntityModel<Triceratops> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart RLeg;
	private final ModelPart RLeg2;
	private final ModelPart LLeg;
	private final ModelPart LLeg2;

	public TriceratopsBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.RForeleg = root.getChild("RForeleg");
		this.LForeleg = root.getChild("LForeleg");
		this.RLeg = root.getChild("RLeg");
		this.RLeg2 = RLeg.getChild("RLeg2");
		this.LLeg = root.getChild("LLeg");
		this.LLeg2 = LLeg.getChild("LLeg2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -5.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(28, 18).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 26).addBox(-2.5F, -1.0F, -4.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -3.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 18).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 2.0F));

		PartDefinition Nose = Snout.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -6.0F));

		PartDefinition NoseHorn = Nose.addOrReplaceChild("NoseHorn", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition RBrowHorn = Snout.addOrReplaceChild("RBrowHorn", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -4.0F));

		PartDefinition LBrowHorn = Snout.addOrReplaceChild("LBrowHorn", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -4.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(10, 21).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 11.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition RForeleg = partdefinition.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 18.0F, -3.0F));

		PartDefinition LForeleg = partdefinition.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 18.0F, -3.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-1.5F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 16.0F, 3.0F));

		PartDefinition RLeg2 = RLeg.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(28, 26).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 2.0F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(25, 0).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 16.0F, 3.0F));

		PartDefinition LLeg2 = LLeg.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(28, 26).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 42, 38);
	}

	@Override
	public void setupAnim(Triceratops entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetModel();
		if (entity.isSleeping()) {
			this.TailBase.xRot = -0.43598323915870024F;
			this.TailBase.yRot = 0.11728612207217244F;
			this.RLeg2.xRot = 2.5413739344815873F;
			this.RLeg2.zRot = -0.3127630032889644F;
			this.RLeg.xRot = -1.13376586611655F;
			this.RLeg.yRot = 0.19547687289441354F;
			this.LForeleg.xRot = -1.2119566751954398F;
			this.LForeleg.yRot = -0.27366763203903305F;
			this.Neck.xRot = 0.1563815016444822F;
			this.Neck.yRot = -0.46914448828868976F;
			this.Head.xRot = 0.14905111745452548F;
			this.Head.yRot = -0.1563815016444822F;
			this.RForeleg.xRot = -1.291369076266349F;
			this.RForeleg.yRot = -0.23457224414434488F;
			this.LLeg.xRot = -1.13376586611655F;
			this.LLeg.yRot = -0.19547687289441354F;
			this.LLeg2.xRot = 2.5411994974301875F;
			this.LLeg2.zRot = 0.3127630032889644F;
			this.Torso.y = 16;
			this.LForeleg.y = 22;
			this.RForeleg.y = 22;
			this.LLeg.y = 20;
			this.RLeg.y = 20;
		} else {
			if (entity.isJuvenile()) {
				float speed = 1.0f;
				float degree = 1.0f;
				this.Torso.y = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 3.0F;
				this.Neck.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.05F;
				this.Head.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.5F;
				this.LForeleg.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RForeleg.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LLeg2.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.RLeg2.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.TailBase.xRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.3F;
				this.TailBase.yRot = Mth.cos(-1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.05F * limbSwingAmount;
				if (entity.isInWater()) {
					this.Torso.y = 8;
					this.Torso.xRot = -0.25F;
					this.TailBase.xRot = 0.125F;
					this.LLeg.y = 8;
					this.RLeg.y = 8;
					this.LForeleg.y = 10;
					this.RForeleg.y = 10;
					this.LLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RForeleg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LForeleg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.0625F;
					this.TailBase.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			} else {
				float speed = 1.0f;
				float degree = 1.0f;
				this.Neck.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.05F;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.5F;
				this.LForeleg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RForeleg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.RLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.TailBase.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.3F;
				this.TailBase.yRot = Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.05F * limbSwingAmount;
				if (entity.isInWater()) {
					this.Torso.y = 8;
					this.LLeg.y = 12;
					this.RLeg.y = 12;
					this.LForeleg.y = 19;
					this.RForeleg.y = 19;
					this.LLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RForeleg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LForeleg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.35F;
					this.TailBase.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.25F) + 0.15F;
				this.Torso.xRot = 0.1F;
			}
		}
	}
	
	public void resetModel() {
		this.TailBase.xRot = -0.3186971254089062F;
		this.TailBase.yRot = 0;
		this.RLeg2.xRot = 0;
		this.RLeg2.zRot = 0;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.LForeleg.xRot = 0;
		this.LForeleg.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Head.xRot = 0.500909508638178F;
		this.Head.yRot = 0;
		this.RForeleg.xRot = 0;
		this.RForeleg.yRot = 0;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg2.xRot = 0;
		this.LLeg2.zRot = 0;
		this.Torso.y = 12;
		this.LForeleg.y = 18;
		this.RForeleg.y = 18;
		this.LLeg.y = 16;
		this.RLeg.y = 16;
		this.Torso.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}