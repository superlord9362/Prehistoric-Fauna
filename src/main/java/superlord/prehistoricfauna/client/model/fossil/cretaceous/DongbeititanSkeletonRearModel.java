package superlord.prehistoricfauna.client.model.fossil.cretaceous;

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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.DongbeititanSkeleton;

@SuppressWarnings("unused")
public class DongbeititanSkeletonRearModel extends EntityModel<DongbeititanSkeleton> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public DongbeititanSkeletonRearModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = this.Body.getChild("Neck1");
		this.Neck2 = this.Neck1.getChild("Neck2");
		this.Head = this.Neck2.getChild("Head");
		this.Snout = this.Head.getChild("Snout");
		this.Jaw1 = this.Head.getChild("Jaw1");
		this.Jaw2 = this.Jaw1.getChild("Jaw2");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
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

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(123, 11).addBox(-16.0F, -12.0F, -26.0F, 32.0F, 28.0F, 52.0F, new CubeDeformation(0.0F))
		.texOffs(156, 105).addBox(0.0F, -15.0F, -29.0F, 0.0F, 11.0F, 51.0F, new CubeDeformation(0.0F))
		.texOffs(212, 170).addBox(-17.0F, -11.0F, -26.0F, 34.0F, 27.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.25F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(120, 168).mirror().addBox(-0.35F, 0.0F, -11.0F, 0.0F, 30.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -15.0F, 14.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(120, 168).addBox(-0.15F, 0.0F, -11.0F, 0.0F, 30.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -15.0F, 14.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(58, 55).addBox(0.0F, -8.0F, -45.0F, 0.0F, 11.0F, 49.0F, new CubeDeformation(0.0F))
		.texOffs(48, 46).addBox(-5.0F, -3.0F, -45.0F, 10.0F, 9.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -26.0F, -0.0873F, 0.0F, -0.1047F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, -45.0F, -0.48F, 0.0F, -0.1134F));

		PartDefinition neck3_r1 = Neck2.addOrReplaceChild("neck3_r1", CubeListBuilder.create().texOffs(55, 24).addBox(-9.0F, -84.0F, 4.0F, 8.0F, 61.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 9.6527F, 29.9696F, 1.5708F, 0.0F, 0.0F));

		PartDefinition neck2_r1 = Neck2.addOrReplaceChild("neck2_r1", CubeListBuilder.create().texOffs(21, 25).addBox(-1.0F, -60.0F, -4.0F, 0.0F, 60.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.3473F, 3.9696F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 11).addBox(-2.55F, -5.7223F, -10.1958F, 8.0F, 7.0F, 13.0F, new CubeDeformation(0.01F))
		.texOffs(21, 7).addBox(-1.55F, 1.2777F, -13.1958F, 6.0F, 1.0F, 3.0F, new CubeDeformation(-0.01F))
		.texOffs(10, 31).addBox(-2.55F, 1.2777F, -10.1958F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.0F, 1.6527F, -53.0304F, 1.7453F, 0.0F, -0.1745F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(1, 1).addBox(-3.55F, -5.1849F, 0.7989F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.4626F, -13.9947F));

		PartDefinition Jaw1 = Head.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(33, 4).addBox(-2.55F, -1.1849F, -11.7011F, 7.0F, 4.0F, 13.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, 1.4626F, 1.5053F, 0.5411F, 0.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(21, 0).addBox(-3.55F, -4.1849F, 0.2989F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, -15.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(249, 7).addBox(-4.0F, -7.0F, 0.0F, 7.0F, 0.0F, 35.0F, new CubeDeformation(0.0F))
		.texOffs(253, 3).addBox(-0.5F, -11.0F, -3.0F, 0.0F, 18.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 26.0F, 0.2646F, -0.1439F, -0.0341F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(272, 65).addBox(-0.5564F, -6.75F, 3.7004F, 0.0F, 11.0F, 46.0F, new CubeDeformation(0.0F))
		.texOffs(303, 102).addBox(-3.0564F, -4.75F, 4.7004F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(303, 90).addBox(-3.0564F, -3.75F, 16.7004F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(307, 82).addBox(-3.0564F, -2.75F, 28.7004F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 32.0F, 0.3524F, -0.1587F, 0.0469F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(139, 121).addBox(-6.5F, 0.0F, -5.5F, 9.0F, 26.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.75F, 9.25F, -16.5F, 0.3011F, 0.0522F, -0.1666F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(139, 121).mirror().addBox(-2.5F, 0.0F, -5.5F, 9.0F, 26.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.75F, 9.25F, -16.5F, -0.5133F, 0.1084F, 0.1897F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(71, 127).addBox(-4.5F, -2.5F, -5.0F, 9.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, -3.75F, 13.0F, 0.1271F, -0.1183F, -0.1091F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(63, 172).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 23.5F, -4.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(63, 194).addBox(-4.0F, 0.0F, -3.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 13.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(71, 127).mirror().addBox(-4.5F, -2.5F, -5.0F, 9.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.5F, -4.25F, 11.75F, 0.8391F, 0.2266F, 0.1884F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(63, 172).mirror().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 23.5F, -4.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(63, 194).mirror().addBox(-5.0F, 0.0F, -3.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 11.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 384, 264);
	}

	@Override
	public void setupAnim(DongbeititanSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}