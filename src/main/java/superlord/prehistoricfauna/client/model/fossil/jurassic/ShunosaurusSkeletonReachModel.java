package superlord.prehistoricfauna.client.model.fossil.jurassic;

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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ShunosaurusSkeleton;

@SuppressWarnings("unused")
public class ShunosaurusSkeletonReachModel extends EntityModel<ShunosaurusSkeleton> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart head;
	private final ModelPart Jaw;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart club;
	private final ModelPart armL;
	private final ModelPart armR;
	private final ModelPart legL;
	private final ModelPart lowerlegL;
	private final ModelPart footL;
	private final ModelPart legR;
	private final ModelPart lowerlegR;
	private final ModelPart footR;

	public ShunosaurusSkeletonReachModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.neck1 = this.body.getChild("neck1");
		this.neck2 = this.neck1.getChild("neck2");
		this.head = this.neck2.getChild("head");
		this.Jaw = this.head.getChild("Jaw");
		this.tail1 = this.body.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.club = this.tail2.getChild("club");
		this.armL = this.body.getChild("armL");
		this.armR = this.body.getChild("armR");
		this.legL = root.getChild("legL");
		this.lowerlegL = this.legL.getChild("lowerlegL");
		this.footL = this.lowerlegL.getChild("footL");
		this.legR = root.getChild("legR");
		this.lowerlegR = this.legR.getChild("lowerlegR");
		this.footR = this.lowerlegR.getChild("footR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -6.8533F, 16.2719F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, -15).mirror().addBox(0.0F, 0.0F, -10.0F, 0.0F, 25.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.625F, -12.1467F, -0.2719F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, -15).addBox(0.0F, 0.0F, -10.0F, 0.0F, 25.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.625F, -12.1467F, -0.2719F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(91, 155).addBox(-11.0F, -22.0F, -1.0F, 22.0F, 22.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-10.0F, -23.0F, -1.0F, 20.0F, 23.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.8533F, -35.2719F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 127).addBox(20.0F, -23.0F, -1.0F, 0.0F, 23.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 6.8533F, -35.2719F, -0.1309F, 0.0F, 0.0F));

		PartDefinition neck1 = body.addOrReplaceChild("neck1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.1467F, -33.5219F, -0.1758F, 0.1294F, -0.0115F));

		PartDefinition cube_r5 = neck1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(18, 108).addBox(21.0F, -22.0F, -1.0F, 0.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, 8.75F, 1.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r6 = neck1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(42, 111).addBox(-4.0F, -22.0F, -1.0F, 8.0F, 22.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.75F, 1.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, -16.25F, -0.2616F, 0.0413F, -0.0301F));

		PartDefinition cube_r7 = neck2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(127, 56).addBox(1.0F, -24.0F, 1.0F, 0.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, 0.5F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r8 = neck2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(126, 37).addBox(-2.5F, -24.0F, 1.0F, 5.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.5F, 1.0036F, 0.0F, 0.0F));

		PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 142).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(56, 154).addBox(-3.0F, 3.0F, -4.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(150, 146).addBox(-1.5F, -1.0F, -8.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(152, 152).addBox(-2.0F, 1.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(152, 163).addBox(-2.0F, 3.0F, -9.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.3533F, -15.7281F, -0.3046F, 0.0852F, 0.0189F));

		PartDefinition Jaw = head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(150, 52).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(150, 138).addBox(-1.5F, 0.0F, -9.99F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 65).addBox(-4.5F, 2.0F, 0.0F, 9.0F, 0.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(9, 65).addBox(0.0F, -3.0F, 0.0F, 0.0F, 12.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6467F, 4.7281F, 0.0865F, -0.1304F, 0.0115F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(99, 73).addBox(0.0F, -1.0F, 0.0F, 0.0F, 6.0F, 25.0F, new CubeDeformation(0.0F))
		.texOffs(92, 70).addBox(-2.5F, 0.0F, 1.0F, 5.0F, 0.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 33.0F, 0.2202F, -0.1678F, -0.0548F));

		PartDefinition club = tail2.addOrReplaceChild("club", CubeListBuilder.create().texOffs(3, 144).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 25.0F, 0.1752F, -0.0859F, -0.0152F));

		PartDefinition armL = body.addOrReplaceChild("armL", CubeListBuilder.create().texOffs(124, 0).addBox(-6.0F, -3.0F, -3.0F, 7.0F, 28.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).mirror().addBox(-8.0F, 23.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 5.8533F, -28.2719F, 0.3054F, 0.0698F, 0.0F));

		PartDefinition armR = body.addOrReplaceChild("armR", CubeListBuilder.create().texOffs(124, 0).mirror().addBox(-1.0F, -3.0F, -3.0F, 7.0F, 28.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(6.0F, 23.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 5.8533F, -28.2719F, 0.6109F, -0.0698F, 0.0F));

		PartDefinition legL = partdefinition.addOrReplaceChild("legL", CubeListBuilder.create().texOffs(152, 96).addBox(-4.0F, -2.1467F, -5.2719F, 8.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -7.8533F, 15.2719F, -0.1745F, -0.2094F, 0.0F));

		PartDefinition lowerlegL = legL.addOrReplaceChild("lowerlegL", CubeListBuilder.create().texOffs(30, 142).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.8533F, -3.2719F, 0.1745F, 0.0F, 0.0F));

		PartDefinition footL = lowerlegL.addOrReplaceChild("footL", CubeListBuilder.create().texOffs(79, 108).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition legR = partdefinition.addOrReplaceChild("legR", CubeListBuilder.create().texOffs(152, 96).mirror().addBox(-4.0F, -2.1467F, -5.2719F, 8.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -8.3533F, 15.2719F, -0.1309F, 0.2094F, 0.0F));

		PartDefinition lowerlegR = legR.addOrReplaceChild("lowerlegR", CubeListBuilder.create().texOffs(30, 142).mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.8533F, -3.2719F, 0.1309F, 0.0F, 0.0F));

		PartDefinition footR = lowerlegR.addOrReplaceChild("footR", CubeListBuilder.create().texOffs(79, 108).mirror().addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 192, 192);
	}

	@Override
	public void setupAnim(ShunosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
