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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;

public class CeratosaurusBabyModel extends EntityModel<Ceratosaurus> {
	private final ModelPart Torso;
	private final ModelPart LLeg;
	private final ModelPart LFoot;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart TailBase;

	public CeratosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.RForeleg = Torso.getChild("RForeleg");
		this.LForeleg = Torso.getChild("LForeleg");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -6.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -6.0F, -3.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(31, 0).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.1F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(30, 8).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Nose = Snout.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(39, 11).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition Brow = Head.addOrReplaceChild("Brow", CubeListBuilder.create().texOffs(39, 8).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.0F, -2.0F));

		PartDefinition Brow_1 = Head.addOrReplaceChild("Brow_1", CubeListBuilder.create().texOffs(39, 8).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.0F, -2.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, 11.0F));

		PartDefinition CaudalOsteoderms = TailBase.addOrReplaceChild("CaudalOsteoderms", CubeListBuilder.create().texOffs(25, 10).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition RForeleg = Torso.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(0, -3).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 2.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition LForeleg = Torso.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition TorsoOsteoderms = Torso.addOrReplaceChild("TorsoOsteoderms", CubeListBuilder.create().texOffs(25, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(17, 17).addBox(-1.5F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 15.5F, 2.0F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.5F, 2.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(17, 17).addBox(-0.5F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 15.5F, 2.0F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 4.5F, 2.0F));

		return LayerDefinition.create(meshdefinition, 47, 33);
	}

	@Override
	public void setupAnim(Ceratosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			this.RForeleg.xRot = 0.8932595164970201F;
			this.RForeleg.yRot = 0.19547687289441354F;
			this.Torso.y = 16.5F;
			this.Torso.xRot = -0.10471975511965977F;
			this.Head.x = 1;
			this.Head.z = -1;
			this.Head.xRot = -0.7864453849170947F;
			this.Head.yRot = 0.6658431362674476F;
			this.Head.zRot = -1.1339404363260046F;
			this.TailBase.z = 11.5F;
			this.TailBase.xRot = -0.24434609527920614F;
			this.TailBase.yRot = -0.3490658503988659F;
			this.RFoot.xRot = -0.8377580409572781F;
			this.LFoot.xRot = -0.8377580409572781F;
			this.Neck.xRot = 1.0929251589567215F;
			this.Neck.yRot = 1.2117821049859852F;
			this.Neck.zRot = 0.2350958549041681F;
			this.LLeg.x = -2;
			this.LLeg.y = 19.7F;
			this.LLeg.z = 2;
			this.LLeg.xRot = -0.7330382858376184F;
			this.LLeg.yRot = 0.24434609527920614F;
			this.RLeg.x = 2;
			this.RLeg.y = 20.7F;
			this.RLeg.xRot = -0.7330382858376184F;
			this.RLeg.yRot = -0.24434609527920614F;
			this.LForeleg.xRot = 0.6066764186984569F;
			this.LForeleg.zRot = 0.10471975511965977F;
		} else {
			this.Neck.xRot = (Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
			this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.TailBase.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.TailBase.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos((limbSwing / 3) * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Head.xRot = Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-25F);
			this.RForeleg.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.LForeleg.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.RLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.RFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.LLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.LFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
			if (entity.isInWater()) {
				this.RLeg.y = 20;
				this.LLeg.y = 20;
				this.Torso.y = 20;
				this.Torso.xRot = -0.25F;
				this.TailBase.xRot = 0.125F;
				this.Neck.xRot = 0.5F;
				this.RLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LForeleg.xRot = 0.25F;
				this.RForeleg.xRot = 0.25F;
				this.TailBase.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.RForeleg.xRot = 0;
		this.LForeleg.yRot = 0;
		this.Torso.y = 13.0F;
		this.Torso.xRot = 0;
		this.Head.x = 0;
		this.Head.z = -1;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.TailBase.z = 11.0F;
		this.TailBase.xRot = 0;
		this.TailBase.yRot = 0;
		this.RFoot.y = 4.3F;
		this.LFoot.y = 4.3F;
		this.RFoot.xRot = 0;
		this.LFoot.xRot = 0;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.LLeg.x = -1.5F;
		this.LLeg.y = 15.5F;
		this.LLeg.z = 2;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.RLeg.x = 1;
		this.RLeg.y = 15.5F;
		this.RLeg.z = 2;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.LForeleg.xRot = 0F;
		this.LForeleg.zRot = 0.1047F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
