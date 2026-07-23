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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;

public class SarahsaurusModel extends EntityModel<Sarahsaurus> {
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;

	public SarahsaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 27).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.01F, 4.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(20, 30).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 13.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 48).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 4.0F, 1.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 8.0F, 4.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(30, 0).addBox(-1.6F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(52, 13).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 6.0F, -8.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(22, 52).mirror().addBox(0.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 6.0F, -8.5F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(42, 27).mirror().addBox(-3.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 4.0F, 1.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(51, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 8.0F, 4.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(30, 0).addBox(-1.6F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition Collar = Neck2.addOrReplaceChild("Collar", CubeListBuilder.create().texOffs(22, 27).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(2.0F, -2.0F, -0.5F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition Feathers = Head.addOrReplaceChild("Feathers", CubeListBuilder.create().texOffs(32, 44).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -5.0F, -1.0F));

		PartDefinition satchel = Body.addOrReplaceChild("satchel", CubeListBuilder.create().texOffs(24, 59).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 9.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 2.0F, -11.0F));

		PartDefinition crate = Body.addOrReplaceChild("crate", CubeListBuilder.create().texOffs(0, 71).addBox(-2.0F, -4.0F, -1.25F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(-2.5F, 0.0F, 0.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offset(-1.5F, 0.0F, 1.5F));

		return LayerDefinition.create(meshdefinition, 64, 80);
	}

	@Override
	public void setupAnim(Sarahsaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.8210028961170991F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -1.8374826151943415F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.8210028961170991F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -1.0164797856562695F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.5473352640780661F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.5473352640780661F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, -0.0781907508222411F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, -0.0781907508222411F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -1.0164797856562695F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.23457224414434488F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0, 0.46914448828868976F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -0.4300491170387584F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, 0, 1.3683381601951652F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.Body.y = Mth.lerp(sleepProgress, 6, 15);
				this.Head.z = Mth.lerp(sleepProgress, 0, 3F);
				this.Head.y = Mth.lerp(sleepProgress, -7, -6F);
				this.RightLeg.x = Mth.lerp(sleepProgress, 0.5F, 1.5F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 4, 0.8F);
				this.LeftLeg.x = Mth.lerp(sleepProgress, -0.5F, -1.5F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 4, 0.8F);
				this.RightArm.y = Mth.lerp(sleepProgress, 6, 5.5F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 6, 5.5F);	
				this.Neck2.y = Mth.lerp(sleepProgress, 0, 3F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.8210028961170991F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -1.8374826151943415F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.8210028961170991F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -1.0164797856562695F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.5473352640780661F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.5473352640780661F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, -0.0781907508222411F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, -0.0781907508222411F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -1.0164797856562695F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.23457224414434488F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.46914448828868976F, 0);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -0.4300491170387584F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, 1.3683381601951652F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 15, 6);
				this.Head.z = Mth.lerp(sleepProgress, 3, 0F);
				this.Head.y = Mth.lerp(sleepProgress, -6, -7F);
				this.RightLeg.x = Mth.lerp(sleepProgress, 1.5F, 0.5F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 0.8F, 4);
				this.LeftLeg.x = Mth.lerp(sleepProgress, -1.5F, -0.5F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 0.8F, 4);
				this.RightArm.y = Mth.lerp(sleepProgress, 5.5F, 6);
				this.LeftArm.y = Mth.lerp(sleepProgress, 5.5F, 6F);	
				this.Neck2.y = Mth.lerp(sleepProgress, 3, 0F);
			} else {
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck1.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(45F);
				this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
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
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.Head.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.zRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.y = 6.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.x = -0.5F;
		this.RightLeg.x = 0.5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck2.xRot = 0;
		this.Neck2.y = 0;
		this.LeftFoot.xRot = 0;
		this.Body.y = 6.0F;
		this.Head.z = 0.0F;
		this.Head.y = -7.0F;
		this.RightLeg.z = 4.0F;
		this.LeftLeg.z = 4.0F;
		this.RightArm.y = 6;
		this.LeftArm.y = 6;	
		this.Body.xRot = 0;
	}

	public void sleepPose() {
		this.LeftArm.xRot = -0.23457224414434488F;
		this.LeftArm.zRot = 0.8210028961170991F;
		this.Head.xRot = -1.8374826151943415F;
		this.RightArm.xRot = -0.23457224414434488F;
		this.RightArm.zRot = -0.8210028961170991F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightThigh.xRot = -1.0164797856562695F;
		this.RightThigh.yRot = -0.23457224414434488F;
		this.Tail1.xRot = -0.1563815016444822F;
		this.Tail1.yRot = 0.11728612207217244F;
		this.LeftLeg.xRot = -0.5473352640780661F;
		this.LeftLeg.yRot = 0.0781907508222411F;
		this.LeftLeg.zRot = 0.0781907508222411F;
		this.LeftLeg.x = -1.5F;
		this.RightLeg.xRot = -0.5473352640780661F;
		this.RightLeg.yRot = -0.0781907508222411F;
		this.RightLeg.zRot = -0.0781907508222411F;
		this.RightLeg.x = 1.5F;
		this.LeftThigh.xRot = -1.0164797856562695F;
		this.LeftThigh.yRot = 0.23457224414434488F;
		this.Tail2.xRot = 0.0781907508222411F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Neck1.xRot = 0.46914448828868976F;
		this.Neck1.yRot = -0.4300491170387584F;
		this.Neck2.xRot = 1.3683381601951652F;
		this.Neck2.y = 3F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.Body.y = 15;
		this.Head.z = 3F;
		this.Head.y = -6F;
		this.RightLeg.z = 0.8F;
		this.LeftLeg.z = 0.8F;
		this.RightArm.y = 5.5F;
		this.LeftArm.y = 5.5F;	
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
