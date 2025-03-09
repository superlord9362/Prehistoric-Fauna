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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.LiaoningosaurusSkeleton;

@SuppressWarnings("unused")
public class LiaoningosaurusSkeletonClobberModel extends EntityModel<LiaoningosaurusSkeleton> {
	private final ModelPart LeftLeg;
	private final ModelPart bone6;
	private final ModelPart LeftFoot;
	private final ModelPart RightLeg;
	private final ModelPart bone9;
	private final ModelPart RightFoot;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Skull;
	private final ModelPart RightArm;
	private final ModelPart LetArm;
	private final ModelPart TailBase;
	private final ModelPart TailTip;

	public LiaoningosaurusSkeletonClobberModel(ModelPart root) {
		this.LeftLeg = root.getChild("LeftLeg");
		this.bone6 = this.LeftLeg.getChild("bone6");
		this.LeftFoot = this.bone6.getChild("LeftFoot");
		this.RightLeg = root.getChild("RightLeg");
		this.bone9 = this.RightLeg.getChild("bone9");
		this.RightFoot = this.bone9.getChild("RightFoot");
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Skull = this.Neck.getChild("Skull");
		this.RightArm = this.Body.getChild("RightArm");
		this.LetArm = this.Body.getChild("LetArm");
		this.TailBase = this.Body.getChild("TailBase");
		this.TailTip = this.TailBase.getChild("TailTip");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(1, 1).addBox(-3.0F, -1.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 11.5F, 4.5F, 0.5236F, -0.1745F, -0.5236F));

		PartDefinition bone6 = LeftLeg.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(106, 73).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 7.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LeftFoot = bone6.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(98, 105).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-1.0F, -1.0F, -1.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 13.0F, 5.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition bone9 = RightLeg.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(106, 73).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 7.0F, 4.0F));

		PartDefinition RightFoot = bone9.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(98, 105).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -2.0F, -15.0F, 14.0F, 9.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(49, 2).addBox(-7.5F, -2.0F, -15.0F, 15.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(45, 39).addBox(0.0F, -3.0F, -15.0F, 0.0F, 4.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(27, 82).addBox(-8.0F, -2.0F, -15.0F, 16.0F, 3.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(14, 80).addBox(-7.0F, -2.5F, -15.0F, 14.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 4.0F, 0.2618F, 0.0F, -0.2094F));

		PartDefinition RightPelvis_r1 = Body.addOrReplaceChild("RightPelvis_r1", CubeListBuilder.create().texOffs(29, 53).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -2.0F, 1.0F, 0.0F, 0.0F, -0.4189F));

		PartDefinition LeftPelvis_r1 = Body.addOrReplaceChild("LeftPelvis_r1", CubeListBuilder.create().texOffs(29, 53).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -2.0F, 1.0F, 0.0F, 0.0F, 0.4189F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(25, 32).addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 32).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1F, -15.0F, -0.3491F, 0.4363F, 0.0F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(0, 46).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(34, 46).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, -4.0F, 0.2618F, 0.3491F, -0.3491F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-1.0F, 2.0777F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.7347F, -0.3027F, -11.1119F, -0.2739F, -0.2947F, 0.3022F));

		PartDefinition LetArm = Body.addOrReplaceChild("LetArm", CubeListBuilder.create().texOffs(0, 30).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9903F, 3.1344F, -12.036F, -0.915F, 0.0094F, -0.505F));

		PartDefinition TailBase = Body.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(44, 30).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(49, 31).addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 86).addBox(-4.5F, 1.5F, 0.0F, 9.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 6.0F, 0.5236F, -0.1745F, -0.1745F));

		PartDefinition TailTip = TailBase.addOrReplaceChild("TailTip", CubeListBuilder.create().texOffs(72, 25).addBox(-4.5F, 0.5F, 0.0F, 9.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(1, 30).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(3, 30).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 11.0F, 0.4363F, -0.1745F, -0.1745F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(LiaoningosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}