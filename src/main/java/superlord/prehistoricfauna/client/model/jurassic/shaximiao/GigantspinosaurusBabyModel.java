package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Gigantspinosaurus;

@SuppressWarnings("unused")
public class GigantspinosaurusBabyModel extends EntityModel<Gigantspinosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public GigantspinosaurusBabyModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Head = this.Body.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.25F, -4.0F, -6.0F, 5.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(1, 17).addBox(-1.25F, -6.0F, -6.0F, 3.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, -7.5F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(53, 24).mirror().addBox(-4.0F, -1.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -2.0F, -4.25F, 0.0F, 0.7418F, 0.1745F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(53, 24).addBox(0.0F, -1.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, -4.25F, 0.0F, -0.7418F, -0.1745F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(30, 21).addBox(-1.5F, -1.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 1.5F, -4.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(30, 21).mirror().addBox(-0.5F, -1.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 1.5F, -4.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 30).addBox(-1.5F, -1.5F, -9.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(16, 30).addBox(-1.0F, -3.5F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -1.25F, -6.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(25, 10).addBox(-1.5F, -0.975F, 0.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(28, 4).addBox(-1.0F, -1.975F, 2.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -3.0F, 3.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(38, 0).addBox(-1.0F, -0.475F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(45, 13).addBox(-0.5F, -2.475F, 2.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.475F, 5.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(41, 24).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -9.0F, 2.975F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(45, 34).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(29, 34).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(41, 24).mirror().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.75F, -9.0F, 2.975F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(45, 34).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(29, 34).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 44);
	}

	@Override
	public void setupAnim(Gigantspinosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.8025023820775095F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.03665191262740524F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -9, -7.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.14608405639455457F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.14625859331449564F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, 0.6932448001974364F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -0.21868975061435758F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.036477379868653376F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.360491523395177F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.15F, -0.4782202083885436F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.18238690350445608F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.2553416715641412F);
				this.Body.y = Mth.lerp(sleepProgress, -7.5F, -5.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.03665191262740524F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.07312929665724782F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, 1.2407545013269026F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -9, -3.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.4742059590984399F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, 1.4606660936046318F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.3282964229790696F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, -1.7453292129831807E-4F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 0.36477380700891215F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Head.xRot = Mth.lerp(sleepProgress, 0.8025023820775095F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.03665191262740524F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -7.5F, -9);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.14608405639455457F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.14625859331449564F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0.6932448001974364F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -0.21868975061435758F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.036477379868653376F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.360491523395177F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.4782202083885436F, -0.15F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.18238690350445608F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.2553416715641412F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -5.5F, -7.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.03665191262740524F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.07312929665724782F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, 1.2407545013269026F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -3.5F, -9);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.4742059590984399F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 1.4606660936046318F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.3282964229790696F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, -1.7453292129831807E-4F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.36477380700891215F, 0);
			} else {
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Head.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
				this.Head.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = 0.3F;
					this.RightArm.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.Body.y = -7;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.RightThigh.y = -8.5F;
					this.LeftThigh.y = -8.5F;
					this.RightArm.y = 1F;
					this.LeftArm.y = 1F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Head.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		//Head
		this.Head.x = 0.25F;
		this.Head.y = -1.25F;
		this.Head.z = -6;
		this.Head.xRot = 0.0698F;
		this.Head.yRot = 0;
		//LeftThigh
		this.LeftThigh.x = -1.75F;
		this.LeftThigh.y = -9;
		this.LeftThigh.z = 2.975F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		//RightArm
		this.RightArm.y = 1.5F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		//Tail1
		this.Tail1.y = -3.0F;
		this.Tail1.z = 3;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		//Body
		this.Body.x = -0.25F;
		this.Body.y = -7.5F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		//RightThigh
		this.RightThigh.y = -9;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		//LeftArm
		this.LeftArm.y = 1.5F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
	}

	public void sleepPose() {
		this.Head.xRot = 0.8025023820775095F;
		this.Head.yRot = -0.03665191262740524F;
		this.LeftThigh.y = -7.5F;
		this.LeftThigh.xRot = -0.14608405639455457F;
		this.LeftThigh.yRot = -0.14625859331449564F;
		this.LeftThigh.zRot = 0.6932448001974364F;
		this.LeftArm.xRot = -0.21868975061435758F;
		this.LeftArm.yRot = -0.036477379868653376F;
		this.LeftArm.zRot = -0.360491523395177F;
		this.Tail1.xRot = -0.4782202083885436F;
		this.Tail1.yRot = 0.18238690350445608F;
		this.Tail1.zRot = -0.2553416715641412F;
		this.Body.y = -5.5F;
		this.Body.xRot = -0.03665191262740524F;
		this.Body.yRot = -0.07312929665724782F;
		this.Body.zRot = 1.2407545013269026F;
		this.RightThigh.y = -3.5F;
		this.RightThigh.xRot = 0.4742059590984399F;
		this.RightThigh.zRot = 1.4606660936046318F;
		this.RightArm.xRot = 0.3282964229790696F;
		this.RightArm.yRot = -1.7453292129831807E-4F;
		this.RightArm.zRot = 0.36477380700891215F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
