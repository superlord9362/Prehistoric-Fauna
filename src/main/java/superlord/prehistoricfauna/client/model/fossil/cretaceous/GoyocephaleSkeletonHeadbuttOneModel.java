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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.GoyocephaleSkeleton;

@SuppressWarnings("unused")
public class GoyocephaleSkeletonHeadbuttOneModel extends EntityModel<GoyocephaleSkeleton> {
	private final ModelPart Root;
	private final ModelPart Hips;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart Skull;
	private final ModelPart Tail;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public GoyocephaleSkeletonHeadbuttOneModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Hips = this.Root.getChild("Hips");
		this.Body = this.Hips.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Neck = this.Body.getChild("Neck");
		this.Skull = this.Neck.getChild("Skull");
		this.Tail = this.Hips.getChild("Tail");
		this.LeftLeg = this.Root.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightLeg = this.Root.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.5F, 15.0F, 0.0F));

		PartDefinition Hips = Root.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(39, 2).addBox(-0.5F, -2.0F, -1.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(21, 0).addBox(-2.5F, -1.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0388F, -0.0856F, -0.0468F));

		PartDefinition Body = Hips.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 2).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(42, 14).addBox(-3.5F, 0.0F, -7.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(43, -4).addBox(0.0F, -1.0F, -8.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, 0.2376F, 0.0424F, 0.0104F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.75F, 4.0F, -5.0F, 0.609F, 0.0643F, -0.059F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(-0.25F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(3.75F, 4.0F, -5.0F, 0.2169F, -0.0298F, 0.082F));

		PartDefinition LeftArm_r1 = LeftArm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(0, 2).addBox(-0.75F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(2, 14).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.647F, -0.0867F, 0.1075F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(1, 30).addBox(-1.5F, -1.9999F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1, 25).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, 0.3581F, -0.1944F, -0.0146F));

		PartDefinition Tail = Hips.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(15, 19).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(17, 22).addBox(-0.5F, 0.5F, 0.0F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, 5.0F, 0.1047F, -0.0873F, 0.0F));

		PartDefinition LeftLeg = Root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(29, 11).addBox(-0.5F, 0.0F, -2.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 2.0F, -0.7418F, -0.1396F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(30, 23).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, 2.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RightLeg = Root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(29, 11).mirror().addBox(-1.5F, 0.0F, -2.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 0.0F, 2.0F, 0.1745F, 0.1396F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(30, 23).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 5.0F, 2.0F, 0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 56);
	}

	@Override
	public void setupAnim(GoyocephaleSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}