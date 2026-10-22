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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.GigantspinosaurusSkeleton;

@SuppressWarnings("unused")
public class GigantspinosaurusSkeletonRunningModel extends EntityModel<GigantspinosaurusSkeleton> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart ShoulderSpikeRight;
	private final ModelPart ShoulderSpikeLeft;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public GigantspinosaurusSkeletonRunningModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.ShoulderSpikeRight = this.Body.getChild("ShoulderSpikeRight");
		this.ShoulderSpikeLeft = this.Body.getChild("ShoulderSpikeLeft");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightArm = this.root.getChild("RightArm");
		this.LeftArm = this.root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.25F, 9.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 29).addBox(-5.0F, -7.25F, -15.0F, 10.0F, 15.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(94, 100).addBox(-5.5F, -7.25F, -16.0F, 11.0F, 15.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -8.25F, -3.0F, 14.0F, 16.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(31, -6).addBox(0.0F, -10.25F, -3.0F, 0.0F, 6.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(0.0F, -9.25F, -15.0F, 0.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, -6.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Box_r1 = Body.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(32, -11).mirror().addBox(0.0F, -0.25F, -8.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -4.0F, 8.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Box_r2 = Body.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(32, -11).addBox(0.0F, -0.25F, -8.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, 8.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition Box_r3 = Body.addOrReplaceChild("Box_r3", CubeListBuilder.create().texOffs(90, 38).mirror().addBox(0.0F, -4.25F, -7.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -7.0F, -8.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r4 = Body.addOrReplaceChild("Box_r4", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(0.0F, -5.25F, -9.0F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -8.0F, 6.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r5 = Body.addOrReplaceChild("Box_r5", CubeListBuilder.create().texOffs(0, 60).addBox(0.0F, -5.25F, -9.0F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.0F, 6.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Box_r6 = Body.addOrReplaceChild("Box_r6", CubeListBuilder.create().texOffs(90, 38).addBox(0.0F, -4.25F, -7.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.0F, -8.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(96, 0).addBox(-2.0F, 1.0F, -8.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(0.0F, 0.0F, -8.0F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.25F, -15.0F, 0.0447F, -0.218F, -0.0097F));

		PartDefinition Box_r7 = Neck.addOrReplaceChild("Box_r7", CubeListBuilder.create().texOffs(80, 112).mirror().addBox(0.0F, -3.25F, -9.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.25F, 1.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r8 = Neck.addOrReplaceChild("Box_r8", CubeListBuilder.create().texOffs(80, 112).addBox(0.0F, -3.25F, -9.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.25F, 1.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(112, 91).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(112, 84).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(44, 33).addBox(-4.0F, 0.025F, 1.0F, 8.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(129, 90).addBox(0.0F, -0.975F, 2.0F, 0.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.25F, 11.0F, -0.2678F, -0.2577F, 0.0465F));

		PartDefinition Box_r9 = Tail1.addOrReplaceChild("Box_r9", CubeListBuilder.create().texOffs(0, 82).mirror().addBox(0.0F, -5.25F, -9.0F, 0.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.25F, 12.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r10 = Tail1.addOrReplaceChild("Box_r10", CubeListBuilder.create().texOffs(0, 82).addBox(0.0F, -5.25F, -9.0F, 0.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.25F, 12.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(44, 55).addBox(-2.0F, -0.975F, -3.0F, 4.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(129, 85).addBox(0.0F, -1.975F, 0.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 17.0F, -0.0436F, -0.3491F, 0.0F));

		PartDefinition Box_r11 = Tail2.addOrReplaceChild("Box_r11", CubeListBuilder.create().texOffs(64, 102).mirror().addBox(0.0F, -3.275F, -9.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.75F, 8.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r12 = Tail2.addOrReplaceChild("Box_r12", CubeListBuilder.create().texOffs(64, 102).addBox(0.0F, -3.275F, -9.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.75F, 8.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r1 = Tail2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 102).mirror().addBox(0.0F, -7.275F, -4.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5009F, -0.6996F, 12.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = Tail2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 102).addBox(0.0F, -7.275F, -4.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5009F, -0.6996F, 12.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition ShoulderSpikeRight = Body.addOrReplaceChild("ShoulderSpikeRight", CubeListBuilder.create().texOffs(112, 47).addBox(-3.0F, 0.75F, 0.0F, 3.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(133, 51).addBox(-3.0F, 7.75F, 7.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6768F, -0.5402F, -12.8456F, 0.3648F, 0.524F, -0.925F));

		PartDefinition ShoulderSpikeLeft = Body.addOrReplaceChild("ShoulderSpikeLeft", CubeListBuilder.create().texOffs(112, 47).mirror().addBox(0.0F, 0.75F, 0.0F, 3.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(133, 51).mirror().addBox(0.0F, 7.75F, 7.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.6768F, -0.5402F, -12.8456F, 0.3648F, -0.524F, 0.925F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(34, 77).addBox(-2.0F, -3.0F, -3.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0891F, -20.8405F, 0.4948F, -0.3491F, -0.1745F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 100).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 12.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(62, 22).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 3.1F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(34, 77).mirror().addBox(-3.0F, -3.0F, -3.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -22.25F, 1.0F, 0.5236F, 0.1745F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 100).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 12.0F, -2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(62, 22).mirror().addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 3.1F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightArm = root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(94, 73).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -14.25F, -16.5F, 0.4363F, 0.1745F, 0.0F));

		PartDefinition LeftArm = root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(94, 73).mirror().addBox(-2.0F, -1.0F, -2.5F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -14.25F, -16.5F, -0.4363F, -0.1745F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(GigantspinosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
