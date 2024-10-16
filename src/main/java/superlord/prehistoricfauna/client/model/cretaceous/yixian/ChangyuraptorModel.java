package superlord.prehistoricfauna.client.model.cretaceous.yixian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Changyuraptor;

public class ChangyuraptorModel extends EntityModel<Changyuraptor> implements ArmedModel {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail;
	private final ModelPart RightWing;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftWing;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Head;

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
		this.Head = Neck.getChild("Head");
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
				//17, 0
				this.Body.y = Mth.lerp(sleepProgress, 17, 21);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.48F);
				//0, 1.5, -5, 0, 0, 0
				this.Neck.x = Mth.lerp(sleepProgress, 0, 0.25F);
				this.Neck.y = Mth.lerp(sleepProgress, 1.5F, 2.6F);
				this.Neck.z = Mth.lerp(sleepProgress, -5, -5.35F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 2.8105F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.3047F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -2.3237F);
				//-1.0F, 1.5F, 0, 0, 0
				this.Tail.y = Mth.lerp(sleepProgress, -1, -0.75F);
				this.Tail.z = Mth.lerp(sleepProgress, 1.5F, 0.9F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, 0.4901F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.285F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, 0.0978F);
				//1.5F, 1.5F, -5.0F, 0, 0, 0
				this.RightWing.x = Mth.lerp(sleepProgress, 1.5F, 1.8F);
				this.RightWing.y = Mth.lerp(sleepProgress, 1.5F, 1.9F);
				this.RightWing.z = Mth.lerp(sleepProgress, -5, -3.6F);
				this.RightWing.xRot = Mth.lerp(sleepProgress, 0, 1.0698F);
				this.RightWing.yRot = Mth.lerp(sleepProgress, 0, 0.4863F);
				this.RightWing.zRot = Mth.lerp(sleepProgress, 0, -0.4571F);
				//1.5F, 0.5F, 0, 0, 0
				this.RightLeg.y = Mth.lerp(sleepProgress, 1.5F, 0.4F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 0.5F, 0.25F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8134F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, -0.2176F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, -0.0878F);
				//0.0F, 0
				this.RightFoot.z = Mth.lerp(sleepProgress, 0, 1);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.309F);
				//-1.5F, 1.5F, -5.0F, 0, 0, 0
				this.LeftWing.x = Mth.lerp(sleepProgress, -1.5F, -1.65F);
				this.LeftWing.y = Mth.lerp(sleepProgress, 1.5F, 1.05F);
				this.LeftWing.z = Mth.lerp(sleepProgress, -5, -4.45F);
				this.LeftWing.xRot = Mth.lerp(sleepProgress, 0, 0.5089F);
				this.LeftWing.yRot = Mth.lerp(sleepProgress, 0, -0.1455F);
				this.LeftWing.zRot = Mth.lerp(sleepProgress, 0, 0.3385F);
				//1.5F, 0.5F, 0, 0, 0
				this.LeftLeg.y = Mth.lerp(sleepProgress, 1.5F, 0.25F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 0.5F, 0.4F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.79F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, 0.1571F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, 0.0926F);
				//0.0F, 0
				this.LeftFoot.z = Mth.lerp(sleepProgress, 0, 1);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.2654F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//17, 0
				this.Body.y = Mth.lerp(sleepProgress, 21, 17);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.48F, 0);
				//0, 1.5, -5, 0, 0, 0
				this.Neck.x = Mth.lerp(sleepProgress, 0.25F, 0);
				this.Neck.y = Mth.lerp(sleepProgress, 2.6F, 1.5F);
				this.Neck.z = Mth.lerp(sleepProgress, -5.35F, -5);
				this.Neck.xRot = Mth.lerp(sleepProgress, 2.8105F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.3047F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -2.3237F, 0);
				//-1.0F, 1.5F, 0, 0, 0
				this.Tail.y = Mth.lerp(sleepProgress, -0.75F, -1F);
				this.Tail.z = Mth.lerp(sleepProgress, 0.9F, 1.5F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0.4901F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.285F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0.0978F, 0);
				//1.5F, 1.5F, -5.0F, 0, 0, 0
				this.RightWing.x = Mth.lerp(sleepProgress, 1.8F, 1.5F);
				this.RightWing.y = Mth.lerp(sleepProgress, 1.9F, 1.5F);
				this.RightWing.z = Mth.lerp(sleepProgress, -3.6F, -5);
				this.RightWing.xRot = Mth.lerp(sleepProgress, 1.0698F, 0);
				this.RightWing.yRot = Mth.lerp(sleepProgress, 0.4863F, 0);
				this.RightWing.zRot = Mth.lerp(sleepProgress, -0.4571F, 0);
				//1.5F, 0.5F, 0, 0, 0
				this.RightLeg.y = Mth.lerp(sleepProgress, 0.4F, 1.5F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 0.25F, 0.5F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8134F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, -0.2176F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, -0.0878F, 0);
				//0.0F, 0
				this.RightFoot.z = Mth.lerp(sleepProgress, 1, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.309F, 0);
				//-1.5F, 1.5F, -5.0F, 0, 0, 0
				this.LeftWing.x = Mth.lerp(sleepProgress, -1.65F, -1.5F);
				this.LeftWing.y = Mth.lerp(sleepProgress, 1.05F, 1.5F);
				this.LeftWing.z = Mth.lerp(sleepProgress, -4.45F, -5F);
				this.LeftWing.xRot = Mth.lerp(sleepProgress, 0.5089F, 0);
				this.LeftWing.yRot = Mth.lerp(sleepProgress, -0.1455F, 0);
				this.LeftWing.zRot = Mth.lerp(sleepProgress, 0.3385F, 0);
				//1.5F, 0.5F, 0, 0, 0
				this.LeftLeg.y = Mth.lerp(sleepProgress, 0.25F, 1.5F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 0.4F, 0.5F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.79F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0.1571F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0.0926F, 0);
				//0.0F, 0
				this.LeftFoot.z = Mth.lerp(sleepProgress, 1, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.2654F, 0);
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
		this.Body.y = 17;
		this.Neck.x = 0F;
		this.Neck.y = 1.5F;
		this.Neck.z = -5F;
		this.Tail.y = -1F;
		this.Tail.z = 1.5F;
		this.RightWing.x = 1.5F;
		this.RightWing.y = 1.5F;
		this.RightWing.z = -5F;
		this.RightLeg.y = 1.5F;
		this.RightLeg.z = 0.5F;
		this.LeftLeg.y = 1.5F;
		this.RightFoot.z = 0;
		this.LeftWing.x = -1.5F;
		this.LeftWing.y = 1.5F;
		this.LeftWing.z = -5F;
		this.LeftLeg.y = 1.5F;
		this.LeftLeg.z = 0.5F;
		this.LeftFoot.z = 0;
		this.Body.xRot = 0;
		this.Body.zRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.RightWing.xRot = 0;
		this.RightWing.yRot = 0;
		this.RightWing.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.RightFoot.xRot = 0;
		this.LeftWing.xRot = 0F;
		this.LeftWing.yRot = 0F;
		this.LeftWing.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftFoot.xRot = 0;
	}

	public void sleepPose() {
		//17, 0
		this.Body.y = 21;
		this.Body.xRot = -0.48F;
		//0, 1.5, -5, 0, 0, 0
		this.Neck.x = 0.25F;
		this.Neck.y = 2.6F;
		this.Neck.z = -5.35F;
		this.Neck.xRot = 2.8105F;
		this.Neck.yRot = -1.3047F;
		this.Neck.zRot = -2.3237F;
		//-1.0F, 1.5F, 0, 0, 0
		this.Tail.y = -0.75F;
		this.Tail.z = 0.9F;
		this.Tail.xRot = 0.4901F;
		this.Tail.yRot = 0.285F;
		this.Tail.zRot = 0.0978F;
		//1.5F, 1.5F, -5.0F, 0, 0, 0
		this.RightWing.x = 1.8F;
		this.RightWing.y = 1.9F;
		this.RightWing.z = -3.6F;
		this.RightWing.xRot = 1.0698F;
		this.RightWing.yRot = 0.4863F;
		this.RightWing.zRot = -0.4571F;
		//1.5F, 0.5F, 0, 0, 0
		this.RightLeg.y = 0.4F;
		this.RightLeg.z = 0.25F;
		this.RightLeg.xRot = -0.8134F;
		this.RightLeg.yRot = -0.2176F;
		this.RightLeg.zRot = -0.0878F;
		//0.0F, 0
		this.RightFoot.z = 1;
		this.RightFoot.xRot = 1.309F;
		//-1.5F, 1.5F, -5.0F, 0, 0, 0
		this.LeftWing.x = -1.65F;
		this.LeftWing.y = 1.05F;
		this.LeftWing.z = -4.45F;
		this.LeftWing.xRot = 0.5089F;
		this.LeftWing.yRot = -0.1455F;
		this.LeftWing.zRot =0.3385F;
		//1.5F, 0.5F, 0, 0, 0
		this.LeftLeg.y = 0.25F;
		this.LeftLeg.z = 0.4F;
		this.LeftLeg.xRot = -0.79F;
		this.LeftLeg.yRot = 0.1571F;
		this.LeftLeg.zRot = 0.0926F;
		//0.0F, 0
		this.LeftFoot.z = 1;
		this.LeftFoot.xRot = 1.2654F;
	}
	
	public void translateToHand(HumanoidArm sideIn, PoseStack matrixStackIn) {
		float f = sideIn == HumanoidArm.RIGHT ? 1.0F : -1.0F;
		ModelPart modelrenderer = this.getArmForSide(sideIn);
		modelrenderer.x += f;
		modelrenderer.translateAndRotate(matrixStackIn);
		modelrenderer.x -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelPart getArmForSide(HumanoidArm side) {
		return side == HumanoidArm.LEFT ? this.Head : this.Head;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}