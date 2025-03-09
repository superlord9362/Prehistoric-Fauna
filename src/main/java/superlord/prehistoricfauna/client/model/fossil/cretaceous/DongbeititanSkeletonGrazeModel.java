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
public class DongbeititanSkeletonGrazeModel extends EntityModel<DongbeititanSkeleton> {
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

	public DongbeititanSkeletonGrazeModel(ModelPart root) {
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
		.texOffs(212, 170).addBox(-17.0F, -11.0F, -26.0F, 34.0F, 27.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.25F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(120, 168).mirror().addBox(0.15F, 0.0F, -11.0F, 0.0F, 30.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, -15.0F, 14.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(120, 168).addBox(-0.15F, 0.0F, -11.0F, 0.0F, 30.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -15.0F, 14.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(58, 55).addBox(0.75F, -8.7F, -44.0F, 0.0F, 11.0F, 49.0F, new CubeDeformation(0.0F))
		.texOffs(48, 46).addBox(-4.25F, -3.7F, -44.0F, 10.0F, 9.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -26.0F, 0.3475F, 0.2956F, -0.0578F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, -45.0F, -0.178F, 0.3378F, -0.0384F));

		PartDefinition neck3_r1 = Neck2.addOrReplaceChild("neck3_r1", CubeListBuilder.create().texOffs(55, 24).addBox(-10.05F, -83.4F, 4.0F, 8.0F, 61.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 9.6527F, 29.9696F, 1.5708F, 0.0F, 0.0F));

		PartDefinition neck2_r1 = Neck2.addOrReplaceChild("neck2_r1", CubeListBuilder.create().texOffs(21, 25).addBox(-2.05F, -59.4F, -4.0F, 0.0F, 60.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.3473F, 3.9696F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 11).addBox(-4.05F, -5.1223F, -10.1958F, 8.0F, 7.0F, 13.0F, new CubeDeformation(0.01F))
		.texOffs(21, 7).addBox(-3.05F, 1.8777F, -13.1958F, 6.0F, 1.0F, 3.0F, new CubeDeformation(-0.01F))
		.texOffs(10, 31).addBox(-4.05F, 1.8777F, -10.1958F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.0F, -0.3473F, -56.0304F, 0.9114F, 0.0295F, 0.1785F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(1, 1).addBox(-5.05F, -4.5849F, 0.7989F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.4626F, -13.9947F));

		PartDefinition Jaw1 = Head.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(33, 4).addBox(-4.05F, -0.5849F, -11.7011F, 7.0F, 4.0F, 13.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, 1.4626F, 1.5053F, 0.2356F, 0.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(21, 0).addBox(-5.05F, -3.5849F, 0.2989F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, -15.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(249, 7).addBox(-2.9F, -5.25F, -3.0F, 7.0F, 0.0F, 35.0F, new CubeDeformation(0.0F))
		.texOffs(253, 3).addBox(0.6F, -9.25F, -6.0F, 0.0F, 18.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 26.0F, -0.1376F, 0.1512F, -0.0438F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(272, 65).addBox(0.6436F, -6.25F, 0.0004F, 0.0F, 11.0F, 46.0F, new CubeDeformation(0.0F))
		.texOffs(303, 102).addBox(-1.8564F, -4.25F, 1.0004F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(303, 90).addBox(-1.8564F, -3.25F, 13.0004F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(307, 82).addBox(-1.8564F, -2.25F, 25.0004F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 32.0F, 0.3104F, 0.1858F, 0.0399F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(139, 121).addBox(-5.5F, 0.0F, -5.5F, 9.0F, 26.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.75F, 9.25F, -16.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(139, 121).mirror().addBox(-3.5F, 0.0F, -5.5F, 9.0F, 26.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.75F, 9.25F, -16.5F, 0.0F, -0.2793F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(71, 127).addBox(-4.5F, -2.5F, -5.0F, 9.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, -4.25F, 13.0F, -0.0873F, -0.3491F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(63, 172).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 23.5F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(63, 194).addBox(-4.0F, 0.0F, -3.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 13.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(71, 127).mirror().addBox(-4.5F, -2.5F, -5.0F, 9.0F, 26.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.5F, -4.25F, 13.0F, -0.0873F, 0.3491F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(63, 172).mirror().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 23.5F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(63, 194).mirror().addBox(-5.0F, 0.0F, -3.0F, 9.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 13.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

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
