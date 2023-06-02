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
import superlord.prehistoricfauna.common.entity.fish.Ceratodus;

public class CeratodusModel extends EntityModel<Ceratodus> {
	private final ModelPart Torso;
	private final ModelPart Hip;

	public CeratodusModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Hip = Torso.getChild("Hip");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -11.0F));

		PartDefinition LPectoral = Torso.addOrReplaceChild("LPectoral", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 3.0F, 2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Snoot = Torso.addOrReplaceChild("Snoot", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition RPectoral = Torso.addOrReplaceChild("RPectoral", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 3.0F, 2.0F, 0.0F, 0.0F, -2.7925F));

		PartDefinition Hip = Torso.addOrReplaceChild("Hip", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 12.0F));

		PartDefinition LPelvic = Hip.addOrReplaceChild("LPelvic", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.0F, 4.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition RPelvic = Hip.addOrReplaceChild("RPelvic", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 1.0F, 4.0F, 0.0F, 0.0F, -2.618F));

		PartDefinition Tailstock = Hip.addOrReplaceChild("Tailstock", CubeListBuilder.create().texOffs(19, 17).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition Caudal = Tailstock.addOrReplaceChild("Caudal", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -2.0F, 0.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 76, 50);
	}

	@Override
	public void setupAnim(Ceratodus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entity.isInWater()) {
           f = 1.5F;
        }
        this.Torso.xRot = headPitch * ((float)Math.PI / 180F);
        this.Torso.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.Hip.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
