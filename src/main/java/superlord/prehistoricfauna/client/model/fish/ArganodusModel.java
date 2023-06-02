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
import superlord.prehistoricfauna.common.entity.fish.Arganodus;

public class ArganodusModel extends EntityModel<Arganodus> {
	private final ModelPart FrontTorso;
	private final ModelPart BackTorso;

	public ArganodusModel(ModelPart root) {
		this.FrontTorso = root.getChild("FrontTorso");
		this.BackTorso = FrontTorso.getChild("BackTorso");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition FrontTorso = partdefinition.addOrReplaceChild("FrontTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, -10.0F));

		PartDefinition RightFrontFin = FrontTorso.addOrReplaceChild("RightFrontFin", CubeListBuilder.create().texOffs(35, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.5F, 3.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BackTorso = FrontTorso.addOrReplaceChild("BackTorso", CubeListBuilder.create().texOffs(0, 21).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition TailFin = BackTorso.addOrReplaceChild("TailFin", CubeListBuilder.create().texOffs(1, 19).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition LeftBackFin = BackTorso.addOrReplaceChild("LeftBackFin", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.5F, 2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition RightBackFin = BackTorso.addOrReplaceChild("RightBackFin", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 2.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition Tail = BackTorso.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(19, 18).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition LeftFrontFin = FrontTorso.addOrReplaceChild("LeftFrontFin", CubeListBuilder.create().texOffs(35, 0).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.5F, 3.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Face = FrontTorso.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 76, 50);
	}

	@Override
	public void setupAnim(Arganodus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entity.isInWater()) {
           f = 1.5F;
        }
        this.FrontTorso.xRot = headPitch * ((float)Math.PI / 180F);
        this.FrontTorso.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.BackTorso.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		FrontTorso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
