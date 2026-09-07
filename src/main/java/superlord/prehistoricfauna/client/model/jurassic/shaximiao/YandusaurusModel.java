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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yandusaurus;

public class YandusaurusModel extends EntityModel<Yandusaurus> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public YandusaurusModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Neck = this.Body.getChild("Neck");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 1.5F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(10, 0).addBox(-3.0F, -5.0F, -12.5F, 6.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.95F, 3.5F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(20, 41).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.925F, 14.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -5.0F, -3.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(-1.5F, -5.0F, -4.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.001F))
		.texOffs(0, 6).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.001F))
		.texOffs(10, 0).addBox(-1.0F, -7.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -11.5F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(56, 35).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 28).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, -9.5F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 35).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 28).mirror().addBox(-1.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.0F, -9.5F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -2.0F, -2.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(52, 41).addBox(0.75F, -0.75F, 2.3F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(48, 50).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.0F, 2.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(45, 57).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(48, 0).mirror().addBox(-1.0F, -2.0F, -2.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 41).addBox(-0.75F, -0.75F, 2.3F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(48, 50).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 6.0F, 2.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(45, 57).mirror().addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void setupAnim(Yandusaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.296705972839036F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0, 7.2F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.Body.y = Mth.lerp(sleepProgress, 0, 6.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0, 7.2F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.296705972839036F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.6726646259971648F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.6773843811168246F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.8726646259971648F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, 0.02853981633974483F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.29670597283F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.03853981633974483F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.5082398928281348F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.296705972839036F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 7.2F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 6.5F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 7.2F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.296705972839036F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.6726646259971648F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.6773843811168246F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.7F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.8726646259971648F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0.02853981633974483F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.29670597283F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.03853981633974483F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.5082398928281348F, 0);
			} else {
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
				}
				if (entity.isInWater()) {
					this.Body.y = 0;
					this.LeftThigh.y = -1;
					this.RightThigh.y = -1;
					this.Body.xRot = -0.5F;
					this.Tail1.xRot = 0.25F;
					this.Tail2.xRot = 0.25F;
					this.Neck.xRot = 0.5F;
					this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.5F;
					this.RightArm.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.LeftThigh.y = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.z = -10F;
		this.LeftArm.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Body.y = 0;
		this.Body.xRot = 0;
		this.RightThigh.y = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0.0436F;
		this.Neck.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.z = -10;
		this.RightArm.xRot = 0;
		this.Tail1.x = 0;
		this.Tail1.z = 2;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.xRot = 0;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.7F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = -0.296705972839036F;
		this.LeftThigh.y = 7.2F;
		this.LeftArm.xRot = 0.8726646259971648F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Body.y = 6.5F;
		this.Body.xRot = -0.24434609527920614F;
		this.RightThigh.y = 7.2F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = 0.296705972839036F;
		this.Neck.xRot = 0.6726646259971648F;
		this.Neck.yRot = 0.6773843811168246F;
		this.RightLeg.xRot = -0.7F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.Tail1.xRot = 0.02853981633974483F;
		this.Tail1.yRot = -0.29670597283F;
		this.Tail1.zRot = -0.10471975511965977F;
		this.Tail2.xRot = 0.03853981633974483F;
		this.Tail2.yRot = -0.5082398928281348F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
