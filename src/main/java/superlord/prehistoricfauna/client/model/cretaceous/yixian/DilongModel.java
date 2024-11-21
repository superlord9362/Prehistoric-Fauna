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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Dilong;

@SuppressWarnings("unused")
public class DilongModel extends EntityModel<Dilong> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public DilongModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -3.0F, -7.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 2.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(30, 2).addBox(-1.0721F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0721F, -2.0F, -7.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(38, 11).addBox(-1.0721F, -4.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 21).addBox(-0.5721F, -4.0F, -5.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 36).addBox(0.1601F, -1.5698F, -0.3154F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6221F, -4.125F, -3.425F, -1.3549F, -0.1337F, -0.2258F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 21).addBox(0.7093F, -1.7272F, -0.4872F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4221F, -4.125F, -3.425F, -1.3549F, 0.1337F, 0.2258F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 11).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5721F, -4.0F, 1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(-1.0F, 1.0F, 1.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(1.5F, -0.75F, -5.25F));

		PartDefinition cube_r4 = RightArm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 26).addBox(1.25F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.25F, -0.25F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(-1.5F, -0.75F, -5.25F));

		PartDefinition cube_r5 = LeftArm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(34, 31).addBox(-2.25F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.25F, -0.25F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(24, 27).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.0F, -0.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(30, 35).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(30, 7).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(28, 13).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.0F, -0.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 35).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(30, 9).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void setupAnim(Dilong entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0f;
		float degree = 1.0f;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//17, 0
				this.Body.y = Mth.lerp(sleepProgress, 17, 22.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.48F);
				//0, 1.5, -5, 0, 0, 0
				this.Neck.x = Mth.lerp(sleepProgress, 0.0721F, 0.25F);
				this.Neck.y = Mth.lerp(sleepProgress, -2, -1.5F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 2.8105F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.3047F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -2.3237F);
				//-1.0F, 1.5F, 0, 0, 0
				this.Tail.y = Mth.lerp(sleepProgress, -2, -1.5F);
				this.Tail.z = Mth.lerp(sleepProgress, 2, 1.25F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, 0.4901F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.285F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, 0.0978F);
				//1.5F, 1.5F, -5.0F, 0, 0, 0
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 1.0698F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.4863F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.4571F);
				//1.5F, 0.5F, 0, 0, 0
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8134F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2176F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -0.0878F);
				//0.0F, 4.0F, 1.5F
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.3F);
				//0.0F, 4.0F, 0.0F
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6F);
				//-1.5F, 1.5F, -5.0F, 0, 0, 0
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.5089F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.1455F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.3385F);
				//1.5F, 0.5F, 0, 0, 0
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.79F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1571F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, 0.0926F);
				//0.0F, 4.0F, 1.5F
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.3F);
				//0.0F, 4.0F, 0.0F
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//17, 0
				this.Body.y = Mth.lerp(sleepProgress, 22.5F, 17);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.48F, 0);
				//0, 1.5, -5, 0, 0, 0
				this.Neck.x = Mth.lerp(sleepProgress, 0.25F, 0.0721F);
				this.Neck.y = Mth.lerp(sleepProgress, -1.5F, -2);
				this.Neck.xRot = Mth.lerp(sleepProgress, 2.8105F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.3047F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -2.3237F, 0);
				//-1.0F, 1.5F, 0, 0, 0
				this.Tail.y = Mth.lerp(sleepProgress, -1.5F, -2);
				this.Tail.z = Mth.lerp(sleepProgress, 1.25F, 2);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0.4901F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.285F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0.0978F, 0);
				//1.5F, 1.5F, -5.0F, 0, 0, 0
				this.RightArm.xRot = Mth.lerp(sleepProgress, 1.0698F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.4863F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.4571F, 0);
				//1.5F, 0.5F, 0, 0, 0
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.8134F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2176F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -0.0878F, 0);
				//0.0F, 4.0F, 1.5F
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.3F, 0);
				//0.0F, 4.0F, 0.0F
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.6F, 0);
				//-1.5F, 1.5F, -5.0F, 0, 0, 0
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.5089F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.1455F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.3385F, 0);
				//1.5F, 0.5F, 0, 0, 0
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.79F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.1571F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0.0926F, 0);
				//0.0F, 4.0F, 1.5F
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.3F, 0);
				//0.0F, 4.0F, 0.0F
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.6F, 0);
			} else {
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftThigh.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F) - (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.RightThigh.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F) - (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
				//				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.LeftArm.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
				this.RightArm.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
				if (entity.isInWater()) {
					this.Body.y = 17;
					this.LeftThigh.y = 17F;
					this.RightThigh.y = 17F;
					this.Body.xRot = -0.25F;
					this.Tail.xRot = 0.25F;
					this.Neck.xRot = 0.25F;
					this.LeftArm.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.RightArm.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 17.0F;
		this.Body.xRot = 0;
		//0.0721F, -2.0F, -7.0F
		this.Neck.x = 0.0721F;
		this.Neck.y = -2;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		//0.0F, -2.0F, 2.0F
		this.Tail.y = -2;
		this.Tail.z = 2;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		//
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		//
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		//
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		//
		this.RightFoot.xRot = 0;
		//
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		//
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		//
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		//
		this.LeftFoot.xRot = 0;
	}

	public void sleepPose() {
		//17, 0
		this.Body.y = 22.5F;
		this.Body.xRot = -0.48F;
		//0, 1.5, -5, 0, 0, 0
		this.Neck.x = 0.25F;
		this.Neck.y = -1.5F;
		this.Neck.xRot = 2.8105F;
		this.Neck.yRot = -1.3047F;
		this.Neck.zRot = -2.3237F;
		//-1.0F, 1.5F, 0, 0, 0
		this.Tail.y = -1.5F;
		this.Tail.z = 1.25F;
		this.Tail.xRot = 0.4901F;
		this.Tail.yRot = 0.285F;
		this.Tail.zRot = 0.0978F;
		//1.5F, 1.5F, -5.0F, 0, 0, 0
		this.RightArm.xRot = 1.0698F;
		this.RightArm.yRot = 0.4863F;
		this.RightArm.zRot = -0.4571F;
		//1.5F, 0.5F, 0, 0, 0
		this.RightThigh.xRot = -0.8134F;
		this.RightThigh.yRot = -0.2176F;
		this.RightThigh.zRot = -0.0878F;
		//0.0F, 4.0F, 1.5F
		this.RightLeg.xRot = -0.3F;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		//0.0F, 4.0F, 0.0F
		this.RightFoot.xRot = 1.6F;
		//-1.5F, 1.5F, -5.0F, 0, 0, 0
		this.LeftArm.xRot = 0.5089F;
		this.LeftArm.yRot = -0.1455F;
		this.LeftArm.zRot =0.3385F;
		//1.5F, 0.5F, 0, 0, 0
		this.LeftThigh.xRot = -0.79F;
		this.LeftThigh.yRot = 0.1571F;
		this.LeftThigh.zRot = 0.0926F;
		//0.0F, 4.0F, 1.5F
		this.LeftLeg.xRot = -0.3F;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		//0.0F, 4.0F, 0.0F
		this.LeftFoot.xRot = 1.6F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}