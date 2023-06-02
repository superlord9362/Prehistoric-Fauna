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
import superlord.prehistoricfauna.common.entity.fish.Mooreodontus;

public class MooreodontusModel extends EntityModel<Mooreodontus> {
	private final ModelPart Head;
	private final ModelPart FrontTorso;
	private final ModelPart BackTorso;

	public MooreodontusModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.FrontTorso = Head.getChild("FrontTorso");
		this.BackTorso = FrontTorso.getChild("BackTorso");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -6.0F));

		PartDefinition FrontTorso = Head.addOrReplaceChild("FrontTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SpikeFin = FrontTorso.addOrReplaceChild("SpikeFin", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition BackTorso = FrontTorso.addOrReplaceChild("BackTorso", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition Tail = BackTorso.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(33, -6).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition RightPelvicFin = BackTorso.addOrReplaceChild("RightPelvicFin", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 2.0F, 1.0F));

		PartDefinition BackFins = BackTorso.addOrReplaceChild("BackFins", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -2.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition LeftPelvicFin = BackTorso.addOrReplaceChild("LeftPelvicFin", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 1.0F));

		PartDefinition RightPectoralFin = FrontTorso.addOrReplaceChild("RightPectoralFin", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftPectoralFin = FrontTorso.addOrReplaceChild("LeftPectoralFin", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Mooreodontus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
        if (!entity.isInWater()) {
           f = 1.5F;
        }
        this.Head.xRot = headPitch * ((float)Math.PI / 180F);
        this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.BackTorso.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
