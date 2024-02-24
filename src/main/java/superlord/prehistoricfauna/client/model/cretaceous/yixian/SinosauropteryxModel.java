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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Sinosauropteryx;

public class SinosauropteryxModel extends EntityModel<Sinosauropteryx> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Tail;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public SinosauropteryxModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Tail = Body.getChild("Tail");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightArm = Body.getChild("RightArm");
		this.LeftArm = Body.getChild("LeftArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, -4.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 19.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(13, 0).addBox(-0.5F, -2.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.5F, -4.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(21, 0).addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -1.0F));

		PartDefinition Tongue = Head.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(28, 12).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -1.6F, -0.5F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.7F, 2.5F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, -0.6F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 0.6F, 1.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(7, 13).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.4F, 0.8F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -0.6F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.6F, 1.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(7, 13).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.4F, 0.8F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 1.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Sinosauropteryx entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		resetModel();
			if (entity.isAsleep()) {
				//Neck
				//this.Neck.yRot = -2;
				if (this.Neck.xRot < 0.6646214111173737F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -2.3848178792724077F) this.Neck.yRot -= 0.05;
				//RightLeg
				//this.RightLeg.y = 4.5F;
				//this.RightLeg.z = 2;
				if (this.RightLeg.y > 4.2) this.RightLeg.y -= 0.15;
				if (this.RightLeg.z > 0.9) this.RightLeg.z -= 0.15;
				if (this.RightLeg.xRot > -0.3979350561389017F) this.RightLeg.xRot -= 0.05;
				if (this.RightLeg.yRot > -0.0781907508222411F) this.RightLeg.yRot -= 0.05;
				if (this.RightLeg.zRot > -0.27366763203903305F) this.RightLeg.zRot -= 0.05;
				//LeftThigh
				if (this.LeftThigh.xRot > -1.1728612040769677F) this.LeftThigh.xRot -= 0.05;
				if (this.LeftThigh.yRot > -0.46914448828868976F) this.LeftThigh.yRot -= 0.05;
				//Tail
				if (this.Tail.xRot > -0.23457224414434488F) this.Tail.xRot -= 0.05;
				if (this.Tail.yRot < 0.5864306020384839F) this.Tail.yRot += 0.05;
				//RightArm
				if (this.RightArm.zRot < 1.3292428222347474F) this.RightArm.zRot += 0.05;
				//LeftArm
				if (this.LeftArm.zRot > -1.3264502315156905F) this.LeftArm.zRot -= 0.05;
				//Body
				//this.Body.y = 11.0F;
				if (this.Body.y < 19) this.Body.y += 0.15;
				//LeftLeg
				//this.LeftLeg.y = 4.5F;
				//this.LeftLeg.z = 2;
				if (this.LeftLeg.y > 4.2) this.LeftLeg.y -= 0.15;
				if (this.LeftLeg.z > 0.9) this.LeftLeg.z -= 0.15;
				if (this.LeftLeg.xRot > -0.3979350561389017F) this.LeftLeg.xRot -= 0.05;
				if (this.LeftLeg.yRot < 0.0781907508222411F) this.LeftLeg.yRot += 0.05;
				if (this.LeftLeg.zRot < 0.27366763203903305F) this.LeftLeg.zRot += 0.05;
				//RightThigh
				if (this.RightThigh.xRot > -1.1728612040769677F) this.RightThigh.xRot -= 0.05;
				if (this.RightThigh.yRot < 0.46914448828868976F) this.RightThigh.yRot += 0.05;
				sleepPose();
			} else {
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
				this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isInWater()) {
					this.Body.y = 14;
					this.Body.xRot = -0.5F;
					this.Tail.xRot = 0.25F;
					this.Neck.xRot = 0.5F;
					this.RightThigh.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.5F;
					this.RightArm.xRot = 0.5F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		if (entity.getWakingTicks() < 31) {
			//Neck
			//this.Neck.yRot = -2;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < -2) this.Neck.yRot += 0.05;
			//RightLeg
			//this.RightLeg.y = 4.5F;
			//this.RightLeg.z = 2;
			if (this.RightLeg.y < 4.5) this.RightLeg.y += 0.15;
			if (this.RightLeg.z < 2) this.RightLeg.z += 0.15;
			if (this.RightLeg.xRot < 0) this.RightLeg.xRot += 0.05;
			if (this.RightLeg.yRot < 0) this.RightLeg.yRot += 0.05;
			if (this.RightLeg.zRot < 0) this.RightLeg.zRot += 0.05;
			//LeftThigh
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot < 0) this.LeftThigh.yRot += 0.05;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			//RightArm
			if (this.RightArm.zRot > 0) this.RightArm.zRot -= 0.05;
			//LeftArm
			if (this.LeftArm.zRot < 0) this.LeftArm.zRot += 0.05;
			//Body
			//this.Body.y = 11.0F;
			if (this.Body.y > 11) this.Body.y -= 0.15;
			//LeftLeg
			//this.LeftLeg.y = 4.5F;
			//this.LeftLeg.z = 2;
			if (this.LeftLeg.y < 4.5) this.LeftLeg.y += 0.15;
			if (this.LeftLeg.z < 2) this.LeftLeg.z += 0.15;
			if (this.LeftLeg.xRot < 0) this.LeftLeg.xRot += 0.05;
			if (this.LeftLeg.yRot > 0) this.LeftLeg.yRot -= 0.05;
			if (this.LeftLeg.zRot > 0) this.LeftLeg.zRot -= 0.05;
			//RightThigh
			if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.yRot > 0) this.RightThigh.yRot -= 0.05;
		}
	}

	public void resetModel() {
		this.Body.y = 19.0F;
		this.LeftLeg.y = 2.4F;
		this.LeftLeg.z = 0.8F;
		this.RightLeg.y = 2.4F;
		this.RightLeg.z = 0.8F;
		this.Neck.xRot = 0;
		this.Neck.yRot = -2;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.RightArm.zRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Body.xRot = 0;
	}

	public void sleepPose() {
		this.Neck.xRot = 0.6646214111173737F;
		this.Neck.yRot = -2.3848178792724077F;
		this.RightLeg.y = 2.3F;
		this.RightLeg.z = 0.9F;
		this.RightLeg.xRot = -0.3979350561389017F;
		this.RightLeg.yRot = -0.0781907508222411F;
		this.RightLeg.zRot = -0.27366763203903305F;
		this.LeftThigh.xRot = -1.1728612040769677F;
		this.LeftThigh.yRot = -0.46914448828868976F;
		this.Tail.xRot = -0.23457224414434488F;
		this.Tail.yRot = 0.5864306020384839F;
		this.RightArm.zRot = 1.3292428222347474F;
		this.LeftArm.zRot = -1.3264502315156905F;
		this.Body.y = 22;
		this.LeftLeg.y = 2.3F;
		this.LeftLeg.z = 0.9F;
		this.LeftLeg.xRot = -0.3979350561389017F;
		this.LeftLeg.yRot = 0.0781907508222411F;
		this.LeftLeg.zRot = 0.27366763203903305F;
		this.RightThigh.xRot = -1.1728612040769677F;
		this.RightThigh.yRot = 0.46914448828868976F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}