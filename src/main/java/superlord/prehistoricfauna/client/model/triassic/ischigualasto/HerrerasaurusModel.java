package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;

public class HerrerasaurusModel extends EntityModel<Herrerasaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart RThigh;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart LThigh;
	private final ModelPart LLeg;
	private final ModelPart LFoot;

	public HerrerasaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.RArm = Body.getChild("RArm");
		this.LArm = Body.getChild("LArm");
		this.RThigh = Body.getChild("RThigh");
		this.RLeg = RThigh.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.LThigh = Body.getChild("LThigh");
		this.LLeg = LThigh.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -15.0F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(82, 0).addBox(0.0F, -2.0F, -1.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 7.0F, 3.0F));

		PartDefinition LThigh = Body.addOrReplaceChild("LThigh", CubeListBuilder.create().texOffs(100, 0).addBox(-2.0F, -2.0F, -3.5F, 3.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 4.0F, 15.5F));

		PartDefinition LLeg = LThigh.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(10, 5).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 10.0F, 3.5F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, -8.0F, -5.0F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -5.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition RThigh = Body.addOrReplaceChild("RThigh", CubeListBuilder.create().texOffs(100, 0).mirror().addBox(-1.0F, -2.0F, -3.5F, 3.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 4.0F, 15.5F));

		PartDefinition RLeg = RThigh.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(10, 5).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 10.0F, 3.5F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition BodySpikes = Body.addOrReplaceChild("BodySpikes", CubeListBuilder.create().texOffs(0, 36).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(82, 0).mirror().addBox(-2.0F, -2.0F, -1.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 7.0F, 3.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 22.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 18.0F));

		PartDefinition Tail2Spikes = Tail2.addOrReplaceChild("Tail2Spikes", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Tail1Spikes = Tail1.addOrReplaceChild("Tail1Spikes", CubeListBuilder.create().texOffs(0, 39).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Herrerasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			//LLeg
			if (this.LLeg.xRot > -0.6981317007977318F) this.LLeg.xRot -= 0.05;
			//Body
			//this.Body.y = 2.0F;
			if (this.Body.y < 7) this.Body.y += 0.15;
			if (this.Body.xRot > -0.3490658503988659F) this.Body.xRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.13962634015954636F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > -0.593411945678072F) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > -0.10471975511965977F) this.Tail2.zRot -= 0.05;
			//RArm
			if (this.RArm.xRot < 0.8726646259971648F) this.RArm.xRot += 0.05;
			//LThigh
			//this.LThigh.y = 4.0F;
			//this.LThigh.z = 15.5F;
			if (this.LThigh.y > 1.7) this.LThigh.y -= 0.15;
			if (this.LThigh.z < 18.5) this.LThigh.z += 0.15;
			if (this.LThigh.xRot > -0.5235987755982988F) this.LThigh.xRot -= 0.05;
			if (this.LThigh.yRot > -0.296705972839036F) this.LThigh.yRot -= 0.05;
			if (this.LThigh.zRot > -0.12217304763960307F) this.LThigh.zRot -= 0.05;
			//LFoot
			if (this.LFoot.xRot < 1.5707963267948966F) this.LFoot.xRot += 0.05;
			//RLeg
			if (this.RLeg.xRot > -0.6981317007977318F) this.RLeg.xRot -= 0.05;
			//LArm
			if (this.LArm.xRot < 0.8726646259971648F) this.LArm.xRot += 0.05;
			//RThigh
			//this.RThigh.y = 4.0F;
			//this.RThigh.z = 15.5F;
			if (this.RThigh.y > 1.7) this.RThigh.y -= 0.15;
			if (this.RThigh.z < 18.5) this.RThigh.z += 0.15;
			if (this.RThigh.xRot > -0.5235987755982988F) this.RThigh.xRot -= 0.05;
			if (this.RThigh.yRot < 0.296705972839036F) this.RThigh.yRot += 0.05;
			if (this.RThigh.zRot < 0.12217304763960307F) this.RThigh.zRot += 0.05;
			//RFoot
			if (this.RFoot.xRot < 1.5707963267948966F) this.RFoot.xRot += 0.05;
			//Tail1
			if (this.Tail1.xRot < 0.06981317007977318F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > -0.593411945678072F) this.Tail1.yRot -= 0.05;
			if (this.Tail1.zRot > -0.03490658503988659F) this.Tail1.zRot -= 0.05;
			//Neck
			//this.Neck.x = 0.0F;
			//this.Neck.y = 4.0F;
			//this.Neck.z = 1.0F;
			if (this.Neck.x > -0.3) this.Neck.x -= 0.15;
			if (this.Neck.y > 2.5) this.Neck.y -= 0.15;
			if (this.Neck.z > 0) this.Neck.z -= 0.15;
			if (this.Neck.xRot < 0.5585053606381855F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 1.3387411976724017F) this.Neck.yRot += 0.05;
			if (this.Neck.zRot < 0.03490658503988659F) this.Neck.zRot += 0.05;
			sleepPose();
		} else {
			this.LThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.RArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.Head.xRot = attackProgress * (float) Math.toRadians(-15F);
			if (entity.isInWater()) {
				this.RThigh.y = 4;
				this.LThigh.y = 4;
				this.Body.y = 10;
				this.Body.xRot = -0.25F;
				this.Tail1.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Neck.xRot = 0.25F;
				this.RThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LArm.xRot = 0.25F;
				this.RArm.xRot = 0.25F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LLeg
			if (this.LLeg.xRot < 0) this.LLeg.xRot += 0.05;
			//Body
			//this.Body.y = 2.0F;
			if (this.Body.y > 2) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot < 0) this.Tail2.zRot += 0.05;
			//RArm
			if (this.RArm.xRot > 0) this.RArm.xRot -= 0.05;
			//LThigh
			//this.LThigh.y = 4.0F;
			//this.LThigh.z = 15.5F;
			if (this.LThigh.y < 4) this.LThigh.y += 0.15;
			if (this.LThigh.z > 15.5) this.LThigh.z -= 0.15;
			if (this.LThigh.xRot < 0) this.LThigh.xRot += 0.05;
			if (this.LThigh.yRot < 0) this.LThigh.yRot += 0.05;
			if (this.LThigh.zRot < 0) this.LThigh.zRot += 0.05;
			//LFoot
			if (this.LFoot.xRot > 0) this.LFoot.xRot -= 0.05;
			//RLeg
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			//LArm
			if (this.LArm.xRot > 0) this.LArm.xRot -= 0.05;
			//RThigh
			//this.RThigh.y = 4.0F;
			//this.RThigh.z = 15.5F;
			if (this.RThigh.y < 4) this.RThigh.y += 0.15;
			if (this.RThigh.z > 15.5) this.RThigh.z -= 0.15;
			if (this.RThigh.xRot < 0) this.RThigh.xRot += 0.05;
			if (this.RThigh.yRot > 0) this.RThigh.yRot -= 0.05;
			if (this.RThigh.zRot > 0) this.RThigh.zRot -= 0.05;
			//RFoot
			if (this.RFoot.xRot > 0) this.RFoot.xRot -= 0.05;
			//Tail1
			if (this.Tail1.xRot > 0) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
			if (this.Tail1.zRot < 0) this.Tail1.zRot += 0.05;
			//Neck
			//this.Neck.x = 0.0F;
			//this.Neck.y = 4.0F;
			//this.Neck.z = 1.0F;
			if (this.Neck.x < 0) this.Neck.x += 0.15;
			if (this.Neck.y < 4) this.Neck.y += 0.15;
			if (this.Neck.z < 1) this.Neck.z += 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.05;
		}
	}

	public void resetModel() {
		this.LLeg.xRot = 0;
		this.Body.y = 2.0F;
		this.Body.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RArm.xRot = 0;
		this.LThigh.y = 4.0F;
		this.LThigh.z = 15.5F;
		this.LThigh.xRot = 0;
		this.LThigh.yRot = 0;
		this.LThigh.zRot = 0;
		this.LFoot.xRot = 0;
		this.RLeg.xRot = 0;
		this.LArm.xRot = 0;
		this.RThigh.y = 4.0F;
		this.RThigh.z = 15.5F;
		this.RThigh.xRot = 0;
		this.RThigh.yRot = 0;
		this.RThigh.zRot = 0;
		this.RFoot.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 4.0F;
		this.Neck.z = 1.0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
	}

	public void sleepPose() {
		this.LLeg.xRot = -0.6981317007977318F;
		this.Body.y = 7.0F;
		this.Body.xRot = -0.3490658503988659F;
		this.Tail2.xRot = 0.13962634015954636F;
		this.Tail2.yRot = -0.593411945678072F;
		this.Tail2.zRot = -0.10471975511965977F;
		this.RArm.xRot = 0.8726646259971648F;
		this.LThigh.y = 1.7F;
		this.LThigh.z = 18.5F;
		this.LThigh.xRot = -0.5235987755982988F;
		this.LThigh.yRot = -0.296705972839036F;
		this.LThigh.zRot = -0.12217304763960307F;
		this.LFoot.xRot = 1.5707963267948966F;
		this.RLeg.xRot = -0.6981317007977318F;
		this.LArm.xRot = 0.8726646259971648F;
		this.RThigh.y = 1.7F;
		this.RThigh.z = 18.5F;
		this.RThigh.xRot = -0.5235987755982988F;
		this.RThigh.yRot = 0.296705972839036F;
		this.RThigh.zRot = 0.12217304763960307F;
		this.RFoot.xRot = 1.5707963267948966F;
		this.Tail1.xRot = 0.06981317007977318F;
		this.Tail1.yRot = -0.593411945678072F;
		this.Tail1.zRot = -0.03490658503988659F;
		this.Neck.x = -0.3F;
		this.Neck.y = 2.5F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 0.5585053606381855F;
		this.Neck.yRot = 2.3387411976724017F;
		this.Neck.zRot = 0.03490658503988659F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}