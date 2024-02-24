package superlord.prehistoricfauna.client.model.jurassic.kayenta;

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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;

public class SarahsaurusModel extends EntityModel<Sarahsaurus> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LArm;
	private final ModelPart RArm;
	private final ModelPart LLeg1;
	private final ModelPart LLeg2;
	private final ModelPart LFoot;
	private final ModelPart RLeg1;
	private final ModelPart RLeg2;
	private final ModelPart RFoot;

	public SarahsaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = Body.getChild("Neck1");
		this.Neck2 = Neck1.getChild("Neck2");
		this.Head = Neck2.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LArm = Body.getChild("LArm");
		this.RArm = Body.getChild("RArm");
		this.LLeg1 = Body.getChild("LLeg1");
		this.LLeg2 = LLeg1.getChild("LLeg2");
		this.LFoot = LLeg2.getChild("LFoot");
		this.RLeg1 = Body.getChild("RLeg1");
		this.RLeg2 = RLeg1.getChild("RLeg2");
		this.RFoot = RLeg2.getChild("RFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 3.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 27).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.01F, 4.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(18, 30).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 13.0F));

		PartDefinition RLeg1 = Body.addOrReplaceChild("RLeg1", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 4.0F, 1.0F));

		PartDefinition RLeg2 = RLeg1.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(8, 31).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 8.0F, 4.0F));

		PartDefinition RFoot = RLeg2.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(-1.6F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(52, 13).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 6.0F, -8.5F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(22, 52).mirror().addBox(0.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 6.0F, -8.5F));

		PartDefinition LLeg1 = Body.addOrReplaceChild("LLeg1", CubeListBuilder.create().texOffs(40, 27).mirror().addBox(-3.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 4.0F, 1.0F));

		PartDefinition LLeg2 = LLeg1.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(8, 31).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 8.0F, 4.0F));

		PartDefinition LFoot = LLeg2.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(-1.6F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition Collar = Neck2.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(32, 67).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.0F, -0.5F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition Feathers = Head.addOrReplaceChild("Feathers", CubeListBuilder.create().texOffs(37, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 80);
	}

	@Override
	public void setupAnim(Sarahsaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			//LArm
			//this.LArm.y = 6;	
			if (this.LArm.y > 5.5) this.LArm.y -= 0.15;
			if (this.LArm.xRot > -0.23457224414434488F) this.LArm.xRot -= 0.05;
			if (this.LArm.zRot < 0.8210028961170991F) this.LArm.zRot += 0.05;
			//Head
			//this.Head.y = -7.0F;
			//this.Head.z = 0.0F;
			if (this.Head.y < -6) this.Head.y += 0.15;
			if (this.Head.z < 3) this.Head.z += 0.15;
			if (this.Head.xRot > -1.8374826151943415F) this.LArm.xRot -= 0.05;
			//RArm
			//this.RArm.y = 6;
			if (this.RArm.y > 5.5) this.RArm.y -= 0.15;
			if (this.RArm.xRot > -0.23457224414434488F) this.RArm.xRot -= 0.05;
			if (this.RArm.zRot > -0.8210028961170991F) this.RArm.zRot -= 0.05;
			//RFoot
			if (this.RFoot.xRot < 1.5707963267948966F) this.RFoot.xRot += 0.05;
			//RLeg1
			if (this.RLeg1.xRot > -1.0164797856562695F) this.RLeg1.xRot -= 0.05;
			if (this.RLeg1.yRot > -0.23457224414434488F) this.RLeg1.yRot -= 0.05;
			//Tail1
			if (this.Tail1.xRot > -0.1563815016444822F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0.11728612207217244F) this.Tail1.yRot += 0.05;
			//LLeg2
			//this.LLeg2.x = -0.5F;
			//this.LLeg2.z = 4.0F;
			if (this.LLeg2.x > -1.5) this.LLeg2.x -= 0.15;
			if (this.LLeg2.z > 0.8) this.LLeg2.z -= 0.15;
			if (this.LLeg2.xRot > -0.5473352640780661F) this.LLeg2.xRot -= 0.05;
			if (this.LLeg2.yRot < 0.0781907508222411F) this.LLeg2.yRot += 0.05;
			if (this.LLeg2.zRot < 0.0781907508222411F) this.LLeg2.zRot += 0.05;
			//RLeg2
			//this.RLeg2.x = 0.5F;
			//this.RLeg2.z = 4.0F;
			if (this.RLeg2.x < 1.5) this.RLeg2.x += 0.15;
			if (this.RLeg2.z > 0.8) this.RLeg2.z -= 0.15;
			if (this.RLeg2.xRot > -0.5473352640780661F) this.RLeg2.xRot -= 0.05;
			if (this.RLeg2.yRot > -0.0781907508222411F) this.RLeg2.yRot -= 0.05;
			if (this.RLeg2.zRot > -0.0781907508222411F) this.RLeg2.zRot -= 0.05;
			//LLeg1
			if (this.LLeg1.xRot > -1.0164797856562695F) this.LLeg1.xRot -= 0.05;
			if (this.LLeg1.yRot < 0.23457224414434488F) this.LLeg1.yRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.0781907508222411F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0.3909537457888271F) this.Tail2.yRot += 0.05;
			//Neck1
			if (this.Neck1.xRot < 0.46914448828868976F) this.Neck1.xRot += 0.05;
			if (this.Neck1.yRot > -0.4300491170387584F) this.Neck1.yRot -= 0.05;
			//Neck2
			//this.Neck2.y = 0;
			if (this.Neck2.y < 3) this.Neck2.y += 0.15;
			if (this.Neck2.xRot < 1.3683381601951652F) this.Neck2.xRot += 0.05;
			//LFoot
			if (this.LFoot.xRot < 1.5707963267948966F) this.LFoot.xRot += 0.05;
			//Body
			//this.Body.y = 6.0F;
			if (this.Body.y < 15) this.Body.y += 0.15;
			sleepPose();
		} else {
			this.LLeg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RLeg1.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck1.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(45F);
			this.RArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Neck1.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.Head.xRot = attackProgress * (float) Math.toRadians(-15F);
			if (entity.isEating()) {
				this.Neck1.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 1.2F;
			}
			if (entity.isInWater()) {
				this.Body.y = 15;
				this.Body.xRot = -0.25F;
				this.Tail1.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Neck1.xRot = 0.25F;
				this.RLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LArm.xRot = 0.25F;
				this.RArm.xRot = 0.25F;
				this.RLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//LArm
			//this.LArm.y = 6;	
			if (this.LArm.y < 6) this.LArm.y += 0.15;
			if (this.LArm.xRot < 0) this.LArm.xRot += 0.05;
			if (this.LArm.zRot > 0) this.LArm.zRot -= 0.05;
			//Head
			//this.Head.y = -7.0F;
			//this.Head.z = 0.0F;
			if (this.Head.y > -7) this.Head.y -= 0.15;
			if (this.Head.z > 0) this.Head.z -= 0.15;
			if (this.Head.xRot < 0) this.LArm.xRot += 0.05;
			//RArm
			//this.RArm.y = 6;
			if (this.RArm.y < 6) this.RArm.y += 0.15;
			if (this.RArm.xRot < 0) this.RArm.xRot += 0.05;
			if (this.RArm.zRot < 0) this.RArm.zRot += 0.05;
			//RFoot
			if (this.RFoot.xRot > 0) this.RFoot.xRot -= 0.05;
			//RLeg1
			if (this.RLeg1.xRot < 0) this.RLeg1.xRot += 0.05;
			if (this.RLeg1.yRot < 0) this.RLeg1.yRot += 0.05;
			//Tail1
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//LLeg2
			//this.LLeg2.x = -0.5F;
			//this.LLeg2.z = 4.0F;
			if (this.LLeg2.x < -0.5) this.LLeg2.x += 0.15;
			if (this.LLeg2.z < 4) this.LLeg2.z += 0.15;
			if (this.LLeg2.xRot < 0) this.LLeg2.xRot += 0.05;
			if (this.LLeg2.yRot > 0) this.LLeg2.yRot -= 0.05;
			if (this.LLeg2.zRot > 0) this.LLeg2.zRot -= 0.05;
			//RLeg2
			//this.RLeg2.x = 0.5F;
			//this.RLeg2.z = 4.0F;
			if (this.RLeg2.x > 0.5) this.RLeg2.x -= 0.15;
			if (this.RLeg2.z < 4) this.RLeg2.z += 0.15;
			if (this.RLeg2.xRot < 0) this.RLeg2.xRot += 0.05;
			if (this.RLeg2.yRot < 0) this.RLeg2.yRot += 0.05;
			if (this.RLeg2.zRot < 0) this.RLeg2.zRot += 0.05;
			//LLeg1
			if (this.LLeg1.xRot < 0) this.LLeg1.xRot += 0.05;
			if (this.LLeg1.yRot > 0) this.LLeg1.yRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//Neck1
			if (this.Neck1.xRot > 0) this.Neck1.xRot -= 0.05;
			if (this.Neck1.yRot < 0) this.Neck1.yRot += 0.05;
			//Neck2
			//this.Neck2.y = 0;
			if (this.Neck2.y > 0) this.Neck2.y -= 0.15;
			if (this.Neck2.xRot > 0) this.Neck2.xRot -= 0.05;
			//LFoot
			if (this.LFoot.xRot > 0) this.LFoot.xRot -= 0.05;
			//Body
			//this.Body.y = 6.0F;
			if (this.Body.y > 6) this.Body.y -= 0.15;
		}
	}

	public void resetModel() {
		this.LArm.xRot = 0;
		this.LArm.zRot = 0;
		this.Head.xRot = 0;
		this.RArm.xRot = 0;
		this.RArm.zRot = 0;
		this.RFoot.xRot = 0;
		this.RFoot.y = 6.0F;
		this.RLeg1.xRot = 0;
		this.RLeg1.yRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.LLeg2.xRot = 0;
		this.LLeg2.yRot = 0;
		this.LLeg2.zRot = 0;
		this.RLeg2.xRot = 0;
		this.RLeg2.yRot = 0;
		this.RLeg2.zRot = 0;
		this.LLeg2.x = -0.5F;
		this.RLeg2.x = 0.5F;
		this.LLeg1.xRot = 0;
		this.LLeg1.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck2.xRot = 0;
		this.Neck2.y = 0;
		this.LFoot.xRot = 0;
		this.Body.y = 6.0F;
		this.Head.z = 0.0F;
		this.Head.y = -7.0F;
		this.RLeg2.z = 4.0F;
		this.LLeg2.z = 4.0F;
		this.RArm.y = 6;
		this.LArm.y = 6;	
		this.Body.xRot = 0;
	}

	public void sleepPose() {
		this.LArm.xRot = -0.23457224414434488F;
		this.LArm.zRot = 0.8210028961170991F;
		this.Head.xRot = -1.8374826151943415F;
		this.RArm.xRot = -0.23457224414434488F;
		this.RArm.zRot = -0.8210028961170991F;
		this.RFoot.xRot = 1.5707963267948966F;
		this.RLeg1.xRot = -1.0164797856562695F;
		this.RLeg1.yRot = -0.23457224414434488F;
		this.Tail1.xRot = -0.1563815016444822F;
		this.Tail1.yRot = 0.11728612207217244F;
		this.LLeg2.xRot = -0.5473352640780661F;
		this.LLeg2.yRot = 0.0781907508222411F;
		this.LLeg2.zRot = 0.0781907508222411F;
		this.LLeg2.x = -1.5F;
		this.RLeg2.xRot = -0.5473352640780661F;
		this.RLeg2.yRot = -0.0781907508222411F;
		this.RLeg2.zRot = -0.0781907508222411F;
		this.RLeg2.x = 1.5F;
		this.LLeg1.xRot = -1.0164797856562695F;
		this.LLeg1.yRot = 0.23457224414434488F;
		this.Tail2.xRot = 0.0781907508222411F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Neck1.xRot = 0.46914448828868976F;
		this.Neck1.yRot = -0.4300491170387584F;
		this.Neck2.xRot = 1.3683381601951652F;
		this.Neck2.y = 3F;
		this.LFoot.xRot = 1.5707963267948966F;
		this.Body.y = 15;
		this.Head.z = 3F;
		this.Head.y = -6F;
		this.RLeg2.z = 0.8F;
		this.LLeg2.z = 0.8F;
		this.RArm.y = 5.5F;
		this.LArm.y = 5.5F;	
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
