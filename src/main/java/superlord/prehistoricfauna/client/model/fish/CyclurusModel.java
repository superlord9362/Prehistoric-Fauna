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
import superlord.prehistoricfauna.common.entity.fish.Cyclurus;

public class CyclurusModel extends EntityModel<Cyclurus> {
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart Tail;

	public CyclurusModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = Head.getChild("Body");
		this.Tail = Body.getChild("Tail");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 20.0F, -8.0F));

		PartDefinition LFin = Head.addOrReplaceChild("LFin", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition RFin = Head.addOrReplaceChild("RFin", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Body = Head.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.5F, 6.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition Bowfin = Body.addOrReplaceChild("Bowfin", CubeListBuilder.create().texOffs(2, 16).addBox(0.0F, -3.5F, -1.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Underfin = Body.addOrReplaceChild("Underfin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 4.0F));

		PartDefinition PelvicFinR = Body.addOrReplaceChild("PelvicFinR", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, 2.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition PelvicFinL = Body.addOrReplaceChild("PelvicFinL", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.5F, 2.0F, 0.0F, 0.0F, -0.4363F));

		return LayerDefinition.create(meshdefinition, 16, 32);
	}

	@Override
	public void setupAnim(Cyclurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
			this.Head.y = 24;
			this.Head.zRot = 1.6F;
		} else {
			this.Head.zRot = 0;
			this.Head.y = 20;
		}
		this.Tail.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
		this.Body.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}	
