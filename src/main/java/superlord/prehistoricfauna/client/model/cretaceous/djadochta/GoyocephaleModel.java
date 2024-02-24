package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Goyocephale;

public class GoyocephaleModel extends EntityModel<Goyocephale> {
	private final ModelPart Hip;
	private final ModelPart Tail;
	private final ModelPart Chest;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public GoyocephaleModel(ModelPart root) {
		this.Hip = root.getChild("Hip");
		this.Tail = Hip.getChild("Tail");
		this.Chest = Hip.getChild("Chest");
		this.Neck = Chest.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.LeftArm = Chest.getChild("LeftArm");
		this.RightArm = Chest.getChild("RightArm");
		this.LeftThigh = Hip.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Hip.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hip = partdefinition.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(21, 0).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Chest = Hip.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 2).addBox(-3.0F, -2.0F, -8.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(41, 45).addBox(-1.0F, 3.0F, -8.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(1, 2).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 2.0F, -6.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(1, 2).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 2.0F, -6.0F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(1, 16).addBox(-1.0F, -4.5F, -2.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(14, 15).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -7.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 30).addBox(-1.5F, -1.999F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 25).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, -0.5F));

		PartDefinition LeftThigh = Hip.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(29, 10).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, 2.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(38, 25).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(33, 23).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightThigh = Hip.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(29, 10).mirror().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 0.0F, 2.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(38, 25).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(33, 23).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Tail = Hip.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(12, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(41, 0).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(41, 22).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(41, 11).addBox(1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(41, 33).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 56);
	}

	@Override
	public void setupAnim(Goyocephale entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entity.isAsleep()) {
			sleepPose();
		} else {
			this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.RightArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LeftArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.Hip.y = 10;
				this.Hip.xRot = -0.5F;
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
	}

	public void resetModel() {
		this.LeftLeg.xRot = 0;
		this.LeftThigh.y = 0.0F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.z = -6;
		this.LeftArm.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
		this.Hip.y = 15;
		this.Hip.xRot = 0;
		this.RightThigh.y = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Head.x = 0;
		this.Head.z = -0.5F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightArm.z = -6.0F;
		this.RightArm.xRot = 0;
		this.Tail.x = 0;
		this.Tail.z = 5;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
	}

	public void sleepPose() {
		this.LeftLeg.xRot = -0.45378560551852565F;
		this.LeftThigh.xRot = -0.8726646259971648F;
		this.LeftThigh.yRot = -0.296705972839036F;
		this.LeftThigh.y = 3.2F;
		this.LeftArm.z = 2.5F;
		this.LeftArm.xRot = 0.8726646259971648F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.Hip.y = 12;
		this.Hip.xRot = -0.24434609527920614F;
		this.RightThigh.y = 3.2F;
		this.RightThigh.xRot = -0.8726646259971648F;
		this.RightThigh.yRot = 0.296705972839036F;
		this.Neck.xRot = 0.8726646259971648F;
		this.Neck.yRot = 0.9773843811168246F;
		this.Head.x = 0.5F;
		this.Head.z = -1.5F;
		this.Head.xRot = 0.5585053606381855F;
		this.Head.yRot = 1.3962634015954636F;
		this.RightLeg.xRot = -0.45378560551852565F;
		this.RightArm.xRot = 0.8726646259971648F;
		this.RightArm.z = 2.5F;
		this.Tail.x = 0.7F;
		this.Tail.z = 18;
		this.Tail.xRot = 0.07853981633974483F;
		this.Tail.yRot = -0.593411945678072F;
		this.Tail.zRot = -0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Hip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}