package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thoracosaurus;

public class ThoracosaurusModel  extends EntityModel<Thoracosaurus> {
	private final ModelPart root;
	private final ModelPart FLLeg;
	private final ModelPart FRLeg;
	private final ModelPart HindLLeg1;
	private final ModelPart HindLLeg2;
	private final ModelPart HindRLeg1;
	private final ModelPart HindRLeg2;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Mouth;
	private final ModelPart Jaw1;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public ThoracosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.FLLeg = this.root.getChild("FLLeg");
		this.FRLeg = this.root.getChild("FRLeg");
		this.HindLLeg1 = this.root.getChild("HindLLeg1");
		this.HindLLeg2 = HindLLeg1.getChild("HindLLeg2");
		this.HindRLeg1 = this.root.getChild("HindRLeg1");
		this.HindRLeg2 = HindRLeg1.getChild("HindRLeg2");
		this.Body = this.root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Mouth = Neck.getChild("Mouth");
		this.Jaw1 = Mouth.getChild("Jaw1");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(2, 0).addBox(-8.0F, -5.0F, -16.0F, 16.0F, 13.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(68, 0).addBox(-5.0F, -4.0F, -10.0F, 10.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -16.0F));

		PartDefinition Mouth = Neck.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(116, 0).addBox(-5.5F, -4.0F, -9.0F, 11.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -4.0F));

		PartDefinition Head1 = Mouth.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(112, 20).addBox(-6.0F, -3.0F, -11.0F, 12.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Head2 = Head1.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(121, 36).addBox(-2.0F, 0.0F, -28.0F, 4.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition topteeth1 = Head2.addOrReplaceChild("topteeth1", CubeListBuilder.create().texOffs(164, 0).mirror().addBox(0.0F, 0.0F, -28.0F, 1.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.1F, 3.0F, 0.0F));

		PartDefinition topteeth2 = Head2.addOrReplaceChild("topteeth2", CubeListBuilder.create().texOffs(164, 0).mirror().addBox(0.0F, 0.0F, -28.0F, 1.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.1F, 3.0F, 0.0F));

		PartDefinition topteeth3 = Head2.addOrReplaceChild("topteeth3", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -28.1F));

		PartDefinition Eye1 = Head1.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -3.0F, -11.0F));

		PartDefinition Eye2 = Head1.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.0F, -11.0F));

		PartDefinition Jaw1 = Mouth.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(99, 38).addBox(-6.0F, 0.0F, -11.0F, 12.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(121, 69).addBox(-2.0F, 0.0F, -28.0F, 4.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition teeth1 = Jaw2.addOrReplaceChild("teeth1", CubeListBuilder.create().texOffs(164, 41).mirror().addBox(0.0F, -2.0F, -28.0F, 1.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.1F, 0.0F, 0.0F));

		PartDefinition teeth2 = Jaw2.addOrReplaceChild("teeth2", CubeListBuilder.create().texOffs(164, 41).mirror().addBox(0.0F, -2.0F, -28.0F, 1.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.1F, 0.0F, 0.0F));

		PartDefinition teeth3 = Jaw2.addOrReplaceChild("teeth3", CubeListBuilder.create().texOffs(15, 24).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -28.1F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 46).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 16.0F, -0.2276F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 86).addBox(-3.0F, -7.0F, 0.0F, 6.0F, 7.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 27.0F, 0.2276F, 0.0F, 0.0F));

		PartDefinition TailSpikes2 = Tail2.addOrReplaceChild("TailSpikes2", CubeListBuilder.create().texOffs(44, 96).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition TailSpikes1 = Tail1.addOrReplaceChild("TailSpikes1", CubeListBuilder.create().texOffs(55, 46).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FRLeg = root.addOrReplaceChild("FRLeg", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 13.0F, -9.0F));

		PartDefinition FLLeg = root.addOrReplaceChild("FLLeg", CubeListBuilder.create().texOffs(0, 51).mirror().addBox(0.0F, -2.0F, -2.0F, 3.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 13.0F, -9.0F));

		PartDefinition HindLLeg1 = root.addOrReplaceChild("HindLLeg1", CubeListBuilder.create().texOffs(79, 81).mirror().addBox(-4.0F, -3.0F, -10.0F, 4.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 12.0F, 12.0F, 0.7741F, 0.0F, 0.0F));

		PartDefinition HindLLeg2 = HindLLeg1.addOrReplaceChild("HindLLeg2", CubeListBuilder.create().texOffs(2, 0).addBox(-3.0F, 0.0F, -9.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.0F, -8.0F, -0.7741F, 0.0F, 0.0F));

		PartDefinition HindRLeg1 = root.addOrReplaceChild("HindRLeg1", CubeListBuilder.create().texOffs(79, 81).addBox(0.0F, -3.0F, -10.0F, 4.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 12.0F, 12.0F, 0.7741F, 0.0F, 0.0F));

		PartDefinition HindRLeg2 = HindRLeg1.addOrReplaceChild("HindRLeg2", CubeListBuilder.create().texOffs(2, 0).mirror().addBox(-1.0F, 0.0F, -9.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 5.0F, -8.0F, -0.7741F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Thoracosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isInWater()) {
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + ((Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F) / 3);
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + ((Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount) / 3);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + ((Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F) / 3);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + ((Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount) / 3) ;
			this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
			this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
			this.Jaw1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(30F);
			this.FRLeg.xRot = 0.8652F;
			this.FLLeg.xRot = 0.8652F;
			this.Neck.xRot = -(headPitch * ((float)Math.PI / 180F));
			this.HindLLeg1.xRot = 2.1855F + (headPitch * ((float) Math.PI / 180F));
			this.HindRLeg1.xRot = 2.1855F + (headPitch * ((float) Math.PI / 180F));
			this.HindLLeg2.xRot = 0 + (headPitch * ((float) Math.PI / 180F));
			this.HindRLeg2.xRot = 0 + (headPitch * ((float) Math.PI / 180F));
		}
		if (!entity.isAsleep() && !entity.isInWater()) {
			if (entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0) {
				this.Body.y = 16;
				this.FLLeg.y = 21;
				this.FLLeg.z = -9;
				this.FLLeg.xRot = -1.5708F;
				this.FRLeg.y = 21;
				this.FRLeg.z = -9;
				this.FRLeg.xRot = -1.5708F;
				this.HindLLeg1.y = 16;
				this.HindLLeg1.z = 12;
				this.HindLLeg1.xRot = 0;
				this.HindLLeg2.xRot = 0;
				this.HindRLeg1.y = 16;
				this.HindRLeg1.z = 12;
				this.HindRLeg1.xRot = 0;
				this.HindRLeg2.xRot = 0;
			} else {
				this.FLLeg.y = -(Mth.cos(0.8F + limbSwing * speed * 0.25F) * degree * 0.2F * limbSwingAmount) + 13;
				this.FLLeg.z = -(Mth.cos(limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount) - 9;
				this.FLLeg.xRot = Mth.cos(limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount;
				this.FRLeg.y = -(Mth.cos(0.8F + limbSwing * speed * 0.25F) * degree * -0.2F * limbSwingAmount) + 13;
				this.FRLeg.z = -(Mth.cos(limbSwing * speed * 0.25F) * degree * -0.5F * limbSwingAmount) - 9;
				this.FRLeg.xRot = Mth.cos(limbSwing * speed * 0.25F) * degree * -0.5F * limbSwingAmount;
				this.HindLLeg1.y = (Mth.cos(1.0F + limbSwing * speed * 0.25F) * degree * -0.2F * limbSwingAmount) + 12;
				this.HindLLeg1.z = (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * -0.25F * limbSwingAmount) + 12;
				this.HindLLeg1.xRot = (Mth.cos(limbSwing * speed * 0.25F) * degree * -0.5F * limbSwingAmount) + 0.7741F;
				this.HindLLeg2.xRot = (Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount) - 0.7741F;
				this.HindRLeg1.y = (Mth.cos(1.0F + limbSwing * speed * 0.25F) * degree * 0.2F * limbSwingAmount) + 12;
				this.HindRLeg1.z = (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.25F * limbSwingAmount) + 12;
				this.HindRLeg1.xRot = (Mth.cos(limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount) + 0.7741F;
				this.HindRLeg2.xRot = (Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount) - 0.7741F;	
			}
			this.Body.yRot = Mth.cos(limbSwing * speed * 0.25F) * degree * 0.25F * limbSwingAmount;
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.25F) * degree * 0.5F * limbSwingAmount);
			this.Jaw1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(30F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount) + (headPitch * ((float) Math.PI / 180F));
			this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
		}
	}
	
	public void resetModel() {
		this.Body.y = 10;
		this.HindRLeg1.y = 12;
		this.HindRLeg1.z = 12;
		this.HindLLeg1.y = 12;
		this.HindLLeg1.z = 12;
		this.Body.yRot = 0;
		this.Body.xRot = 0;
		this.HindLLeg1.xRot = 0.7741F;
		this.HindRLeg1.xRot = 0.7741F;
		this.FRLeg.y = 13;
		this.FRLeg.z = -9;
		this.FRLeg.xRot = 0;
		this.FLLeg.y = 13;
		this.FLLeg.z = -9;
		this.FLLeg.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
