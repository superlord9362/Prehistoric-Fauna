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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;

public class HesperornithoidesModel extends EntityModel<Hesperornithoides> {
	private final ModelPart Body;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart Head;
	private final ModelPart Fluff;
	private final ModelPart Tail;

	public HesperornithoidesModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightLeg = Body.getChild("RightLeg");
		this.LeftLeg = Body.getChild("LeftLeg");
		this.Head = Body.getChild("Head");
		this.Fluff = Head.getChild("Fluff");
		this.Tail = Body.getChild("Tail");
		this.LeftWing = Body.getChild("LeftWing");
		this.RightWing = Body.getChild("RightWing");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 8).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -2.5F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(13, 5).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 1.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(13, 5).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 0.0F, 1.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(17, 16).addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 3.0F, 4.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 17).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Fluff = Head.addOrReplaceChild("Fluff", CubeListBuilder.create().texOffs(10, 18).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -1.0F));

		PartDefinition Snoot = Head.addOrReplaceChild("Snoot", CubeListBuilder.create().texOffs(1, 24).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -1.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(17, 16).mirror().addBox(-1.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.25F, 3.0F, 4.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(19, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Hesperornithoides entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			this.RightLeg.y = 0;
			this.LeftLeg.y = 0;
			this.RightWing.y = 0.3F;
			this.RightWing.xRot = -0.33004175888896664F;
			this.RightWing.yRot = -0.21537363235926135F;
			this.LeftWing.y = 0.3F;
			this.LeftWing.xRot = -0.33004175888896664F;
			this.LeftWing.yRot = 0.21537363235926135F;
			this.Head.y = 2.4F;
			this.Head.xRot = -0.182212366584515F;
			this.Tail.y = 0.6F;
			this.Tail.xRot = -0.21938788164936507F;
			this.Tail.yRot = -0.1096066806870904F;
			this.Tail.zRot = -0.07295475973730675F;
			this.Body.y = 20.8F;
			this.Body.xRot = 0.07278023113974408F;
			this.Fluff.xRot = -1.058367647756717F;
			this.Fluff.y = -4.5F;
			this.Fluff.z = -0.1F;
		} else {
			this.Head.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.RightWing.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.LeftWing.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			this.Fluff.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 3));
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.RightWing.yRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LeftWing.yRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			if (entity.isDustBathing()) {
				this.RightWing.yRot = Math.abs(-0.25F * Mth.sin(0.3F * ageInTicks));
				this.LeftWing.yRot = -Math.abs(-0.25F * Mth.sin(0.3F * ageInTicks));
				this.RightWing.zRot = -Math.abs(-0.5F * Mth.sin(0.3F * ageInTicks));
				this.LeftWing.zRot = Math.abs(-0.5F * Mth.sin(0.3F * ageInTicks));
			}
			if (entity.isInWater()) {
				this.Body.y = 17;
				this.Body.xRot = -0.25F;
				this.Tail.xRot = 0.25F;
				this.Head.xRot = 0.25F;
				this.RightWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.LeftWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.RightLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
			}
		}
	}

	public void resetModel() {
		this.RightLeg.y = 3.0F;
		this.LeftLeg.y = 3.0F;
		this.RightWing.y = 0.0F;
		this.RightWing.xRot = 0;
		this.RightWing.yRot = 0;
		this.RightWing.zRot = 0;
		this.LeftWing.y = 0.0F;
		this.LeftWing.xRot = 0;
		this.LeftWing.yRot = 0;
		this.LeftWing.zRot = 0;
		this.Head.y = 2.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Tail.y = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Body.y = 17.0F;
		this.Body.xRot = 0;
		this.Fluff.y = -4;
		this.Fluff.z = -1;
		this.Fluff.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}