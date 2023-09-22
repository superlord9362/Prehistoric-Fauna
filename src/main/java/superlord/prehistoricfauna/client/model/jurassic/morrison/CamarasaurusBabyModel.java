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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;

public class CamarasaurusBabyModel extends EntityModel<Camarasaurus> {
	private final ModelPart Torso;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart RLeg;
	private final ModelPart RLeg2;
	private final ModelPart RFoot;
	private final ModelPart LLeg;
	private final ModelPart LLeg2;
	private final ModelPart LFoot;
	private final ModelPart TailBase;
	private final ModelPart TailTip;
	private final ModelPart Neck;
	private final ModelPart Head;

	public CamarasaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.RForeleg = root.getChild("RForeleg");
		this.LForeleg = root.getChild("LForeleg");
		this.RLeg = root.getChild("RLeg");
		this.RLeg2 = RLeg.getChild("RLeg2");
		this.RFoot = RLeg2.getChild("RFoot");
		this.LLeg = root.getChild("LLeg");
		this.LLeg2 = LLeg.getChild("LLeg2");
		this.LFoot = LLeg2.getChild("LFoot");
		this.TailBase = Torso.getChild("TailBase");
		this.TailTip = TailBase.getChild("TailTip");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createTorsoLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 16.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -14.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, -22.0F, -5.0F, 5.0F, 26.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Spines = Neck.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, -4.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -22.0F, 1.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.1F, -2.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

		PartDefinition Nose = Snout.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(12, 11).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(53, 0).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 27.0F));

		PartDefinition TailTip = TailBase.addOrReplaceChild("TailTip", CubeListBuilder.create().texOffs(99, 0).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 17.0F));

		PartDefinition RForeleg = partdefinition.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(22, 43).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 7.0F, -8.0F));

		PartDefinition LForeleg = partdefinition.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(22, 43).mirror().addBox(-2.0F, -2.0F, -4.0F, 4.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 7.0F, -8.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(40, 43).addBox(-2.0F, -2.0F, -4.0F, 5.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, 2.0F, 6.0F));

		PartDefinition RLeg2 = RLeg.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(66, 43).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -2.0F));

		PartDefinition RFoot = RLeg2.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(84, 43).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 2.0F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(40, 43).mirror().addBox(-3.0F, -2.0F, -4.0F, 5.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, 2.0F, 6.0F));

		PartDefinition LLeg2 = LLeg.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(66, 43).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 11.0F, -2.0F));

		PartDefinition LFoot = LLeg2.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(84, 43).mirror().addBox(-3.0F, 0.0F, -5.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 143, 75);
	}

	@Override
	public void setupAnim(Camarasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		resetModel();
		if (entity.isAsleep()) {
			this.Torso.y = 10F;
			this.Torso.yRot = -0.038920842652368684F;
			this.Torso.zRot = -0.1563815016444822F;
			this.RForeleg.x = 7.5F;
			this.RForeleg.y = 20.0F;
			this.RForeleg.z = -10.0F;
			this.RForeleg.xRot = -1.1405726395466833F;
			this.RForeleg.yRot = -0.039269908169872414F;
			this.RForeleg.zRot = 0.3909537457888271F;
			this.TailBase.y = 3F;
			this.TailBase.z = 27F;
			this.TailBase.xRot = -0.24260075936930908F;
			this.TailBase.yRot = 0.5864306020384839F;
			this.TailBase.zRot = 0.3127630032889644F;
			this.LForeleg.x = -7.5F;
			this.LForeleg.y = 20;
			this.LForeleg.z = -10;
			this.LForeleg.xRot = -1.2189378856769737F;
			this.LForeleg.yRot = -0.43039819087864056F;
			this.LFoot.y = 6.0F;
			this.LFoot.z = 1.0F;
			this.LFoot.xRot = 0.3874631072585466F;
			this.LFoot.zRot = -0.10471975511965977F;
			this.LLeg2.xRot = 1.5707963267948966F;
			this.LLeg2.y = 10.1F;
			this.LLeg2.z = 1;
			this.RFoot.xRot = 0.3490658503988659F;
			this.RFoot.y = 6.5F;
			this.RFoot.z = 1F;
			this.RLeg2.x = 0.5F;
			this.RLeg2.y = 10.2F;
			this.RLeg2.z = 1;
			this.RLeg2.xRot = 1.5707963267948966F;
			this.LLeg.x = -5.5F;
			this.LLeg.y = 18;
			this.LLeg.z = 10;
			this.LLeg.xRot = -1.9198621771937625F;
			this.LLeg.yRot = 0.3839724354387525F;
			this.LLeg.zRot = 0.10471975511965977F;
			this.RLeg.x = 5.5F;
			this.RLeg.y = 18;
			this.RLeg.z = 10;
			this.RLeg.xRot = -1.9198621771937625F;
			this.RLeg.yRot = -0.5082398595386212F;
			this.Neck.x = -3F;
			this.Neck.y = 6F;
			this.Neck.z = 2;
			this.Neck.xRot = 0.9162978572970231F;
			this.Neck.yRot = -1.3294172592861477F;
			this.Neck.zRot = 0.11728612207217244F;
			this.TailTip.xRot = 0.4518657326886875F;
			this.TailTip.yRot = 0.3909537457888271F;
			this.TailTip.zRot = 0.19547687289441354F;
			this.Head.x = 0;
			this.Head.z = -2;
			this.Head.xRot = -0.5269149104981519F;
			this.Head.yRot = 0.03909537541112055F;
			this.Head.zRot = 0.2562143561638466F;
		} else {
			this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Torso.zRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
			this.TailBase.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.TailBase.zRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
			this.TailTip.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F);
			this.TailTip.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + (limbSwing / 3) * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
			this.Neck.yRot = (Mth.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
			this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
			this.RLeg.xRot = Mth.cos((limbSwing / 3) * 0.3F) * 0.5F * limbSwingAmount;
			this.RLeg2.xRot = Mth.cos((limbSwing / 3) * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
			this.RFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount;
			this.LLeg.xRot = Mth.cos(4.0F + (limbSwing / 3) * 0.3F) * 0.5F * limbSwingAmount;
			this.LLeg2.xRot = Mth.cos(4.0F + (limbSwing / 3) * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
			this.LFoot.xRot = Mth.cos(5.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount;
			this.RForeleg.xRot = (Mth.cos(1.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
			this.LForeleg.xRot = (Mth.cos(5.0F + (limbSwing / 3) * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
			this.Torso.xRot = attackProgress * (float)Math.toRadians(-50);
			if (entity.isEating()) {
				this.Neck.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
			}
			if (entity.isInWater()) {
				this.Torso.y = 12;
				this.Torso.xRot = -0.25F;
				this.TailBase.xRot = 0.125F;
				this.TailTip.xRot = 0.125F;
				this.RLeg.y = 8;
				this.LLeg.y = 8;
				this.RLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LForeleg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RForeleg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.LFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Neck.xRot = 0.5F;
				this.TailBase.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.TailTip.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.Torso.y = -5F;
		this.Torso.yRot = 0F;
		this.Torso.zRot = 0F;
		this.RForeleg.x = 5.5F;
		this.RForeleg.y = 7.0F;
		this.RForeleg.z = -8.0F;
		this.RForeleg.xRot = 0F;
		this.RForeleg.yRot = 0F;
		this.RForeleg.zRot = 0F;
		this.TailBase.y = 5F;
		this.TailBase.z = 27F;
		this.TailBase.xRot = 0;
		this.TailBase.yRot = 0;
		this.TailBase.zRot = 0;
		this.LForeleg.x = -6.5F;
		this.LForeleg.y = 7;
		this.LForeleg.z = -8;
		this.LForeleg.xRot = 0F;
		this.LForeleg.yRot = 0F;
		this.LFoot.y = 8.0F;
		this.LFoot.z = 2.0F;
		this.LFoot.xRot = 0;
		this.LFoot.zRot = 0;
		this.LFoot.yRot = 0;
		this.LLeg2.xRot = 0;
		this.LLeg2.y = 11F;
		this.LLeg2.z = -2;
		this.RFoot.xRot = 0;
		this.RFoot.yRot = 0;
		this.RFoot.zRot = 0;
		this.RFoot.y = 8F;
		this.RFoot.z = 2F;
		this.RLeg2.x = 0F;
		this.RLeg2.y = 11F;
		this.RLeg2.z = -2;
		this.RLeg2.xRot = 0;
		this.LLeg.x = -5.5F;
		this.LLeg.y = 2;
		this.LLeg.z = 6;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RLeg.x = 5.5F;
		this.RLeg.y = 2;
		this.RLeg.z = 6;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		//0.0F, -20.1F, -2.0F
		this.Neck.x = 0F;
		this.Neck.y = 6F;
		this.Neck.z = 0;
		this.Neck.xRot = 0.1745F;
		this.Neck.yRot = 0F;
		this.Neck.zRot = 0F;
		this.TailTip.xRot = 0;
		this.TailTip.yRot = 0;
		this.TailTip.zRot = 0F;
		this.Head.x = 0;
		this.Head.z = -2;
		this.Head.xRot = 0F;
		this.Head.yRot = 0F;
		this.Head.zRot = 0F;
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
