package superlord.prehistoricfauna.client.model.fish;

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
import superlord.prehistoricfauna.common.entity.fish.Parapsephurus;

public class ParapsephurusModel extends EntityModel<Parapsephurus> {
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart TailFin;

	public ParapsephurusModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = this.Head.getChild("Body");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.TailFin = this.Tail2.getChild("TailFin");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -3.0F));

		PartDefinition Face = Head.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(11, 20).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.0F));

		PartDefinition Nose = Face.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(2, 26).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition Mouth = Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 21).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -3.0F));

		PartDefinition Gills = Head.addOrReplaceChild("Gills", CubeListBuilder.create().texOffs(1, 30).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Body = Head.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(15, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.2F, 9.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(25, 2).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.3F, 3.0F));

		PartDefinition TailFin = Tail2.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(24, 5).addBox(0.1F, -3.5F, 0.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, 2.0F));

		PartDefinition TailTopFin = Tail1.addOrReplaceChild("TailTopFin", CubeListBuilder.create().texOffs(24, 13).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition TailBottomFin = Tail1.addOrReplaceChild("TailBottomFin", CubeListBuilder.create().texOffs(25, 17).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition LeftFrontFin = Body.addOrReplaceChild("LeftFrontFin", CubeListBuilder.create().texOffs(-2, 0).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 4.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition RightFrontFin = Body.addOrReplaceChild("RightFrontFin", CubeListBuilder.create().texOffs(-2, 3).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 4.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition RightBackFin = Body.addOrReplaceChild("RightBackFin", CubeListBuilder.create().texOffs(-2, 6).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 4.0F, 7.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition LeftBackFin = Body.addOrReplaceChild("LeftBackFin", CubeListBuilder.create().texOffs(3, 6).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 4.0F, 7.0F, 0.0F, 0.0F, -0.8727F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Parapsephurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.Head.y = 22;
			this.Head.zRot = 1.6F;
		} else {
			this.Head.zRot = 0;
			this.Head.y = 20;
		}
        this.Head.xRot = headPitch * ((float)Math.PI / 180F);
        this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Body.yRot = -f * 0.45F * Mth.sin(0.3F * ageInTicks);
        this.Tail1.yRot = -f * 0.35F * Mth.sin(0.3F * ageInTicks);
        this.Tail2.yRot = -f * 0.25F * Mth.sin(0.3F * ageInTicks);
        this.TailFin.yRot = -f * 0.15F * Mth.sin(0.3F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}