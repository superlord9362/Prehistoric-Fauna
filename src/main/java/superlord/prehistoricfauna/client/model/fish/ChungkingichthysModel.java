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
import superlord.prehistoricfauna.common.entity.fish.Chungkingichthys;

@SuppressWarnings("unused")
public class ChungkingichthysModel extends EntityModel<Chungkingichthys> {
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart dorsal_f;
	private final ModelPart anal_f;
	private final ModelPart pelvic_f;
	private final ModelPart pectoral_f;
	private final ModelPart pectoral_f2;

	public ChungkingichthysModel(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = this.body.getChild("tail");
		this.dorsal_f = this.body.getChild("dorsal_f");
		this.anal_f = this.body.getChild("anal_f");
		this.pelvic_f = this.body.getChild("pelvic_f");
		this.pectoral_f = this.body.getChild("pectoral_f");
		this.pectoral_f2 = this.body.getChild("pectoral_f2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -3.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(13, -3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 6.0F));

		PartDefinition dorsal_f = body.addOrReplaceChild("dorsal_f", CubeListBuilder.create().texOffs(14, 2).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 4.0F));

		PartDefinition anal_f = body.addOrReplaceChild("anal_f", CubeListBuilder.create().texOffs(15, 6).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 5.0F));

		PartDefinition pelvic_f = body.addOrReplaceChild("pelvic_f", CubeListBuilder.create().texOffs(20, 1).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition pectoral_f = body.addOrReplaceChild("pectoral_f", CubeListBuilder.create().texOffs(1, 1).addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.5F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition pectoral_f2 = body.addOrReplaceChild("pectoral_f2", CubeListBuilder.create().texOffs(1, 3).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, 1.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 16);
	}

	@Override
	public void setupAnim(Chungkingichthys entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
    	if (!entity.isInWater()) {
			f = 1.5F;
			this.body.y = 22;
			this.body.zRot = 1.6F;
		} else {
			this.body.zRot = 0;
			this.body.y = 20;
		}
        this.body.xRot = headPitch * ((float)Math.PI / 180F);
        this.body.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.body.yRot = -f * 0.1F * Mth.sin(0.3F * ageInTicks);
        this.tail.yRot = -f * 0.25F * Mth.sin(0.3F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}