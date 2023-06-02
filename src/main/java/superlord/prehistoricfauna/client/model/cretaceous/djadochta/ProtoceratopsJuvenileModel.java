package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;

public class ProtoceratopsJuvenileModel extends EntityModel<Protoceratops> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Tailtip;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart FLegRight;
	private final ModelPart FLegLeft;
	private final ModelPart BLegLeft;
	private final ModelPart BLegRight;
	private final ModelPart FeetRight;
	private final ModelPart FeetLeft;
	
	public ProtoceratopsJuvenileModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = Body.getChild("Tail");
		this.Tailtip = Tail.getChild("Tailtip");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.FLegLeft = Body.getChild("FLegLeft");
		this.FLegRight = Body.getChild("FLegRight");
		this.BLegLeft = Body.getChild("BLegLeft");
		this.BLegRight = Body.getChild("BLegRight");
		this.FeetLeft = BLegLeft.getChild("FeetLeft");
		this.FeetRight = BLegRight.getChild("FeetRight");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(3, 27).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 6.0F));

		PartDefinition Tailtip = Tail.addOrReplaceChild("Tailtip", CubeListBuilder.create().texOffs(21, 23).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition BLegLeft = Body.addOrReplaceChild("BLegLeft", CubeListBuilder.create().texOffs(30, 35).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 2.0F, 4.0F));

		PartDefinition FeetLeft = BLegLeft.addOrReplaceChild("FeetLeft", CubeListBuilder.create().texOffs(30, 46).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 5.0F, 3.0F));

		PartDefinition BLegRight = Body.addOrReplaceChild("BLegRight", CubeListBuilder.create().texOffs(30, 35).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.0F, 4.0F));

		PartDefinition FeetRight = BLegRight.addOrReplaceChild("FeetRight", CubeListBuilder.create().texOffs(30, 46).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 5.0F, 3.0F));

		PartDefinition FLegLeft = Body.addOrReplaceChild("FLegLeft", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 5.0F, -2.0F));

		PartDefinition FLegRight = Body.addOrReplaceChild("FLegRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 5.0F, -2.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -4.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(39, 12).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -2.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(48, 27).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.5F));

		PartDefinition Crest = Head.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(36, 4).addBox(-3.5F, -5.0F, -1.5F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, -1.0472F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Protoceratops entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		resetModel();
		if (entity.isAsleep()) {
			this.Tail.xRot = 0.291819038949227F;
			this.Tail.yRot = -0.18256144042439712F;
			this.Tail.zRot = 0.2183406934192323F;
			this.FeetRight.xRot = -0.291993575869168F;
			this.FeetRight.yRot = 3.141592653589793F;
			this.FeetRight.zRot = -1.7453292129831807E-4F;
			this.BLegLeft.x = 2.2F;
			this.BLegLeft.y = 3.8F;
			this.BLegLeft.z = 4.1F;
			this.BLegLeft.xRot = -0.1090830782496456F;
			this.BLegLeft.yRot = 0.03630284710990151F;
			this.BLegLeft.zRot = 0.8389797661073521F;
			this.BLegRight.x = -1.2F;
			this.BLegRight.y = 1.0F;
			this.BLegRight.z = 4.3F;
			this.BLegRight.xRot = 0.7298966878577064F;
			this.BLegRight.yRot = -0.055326938619800786F;
			this.BLegRight.zRot = 0.12740903872453743F;
			this.Head.x = 0.4F;
			this.Head.y = 2.0F;
			this.Head.z = -4.2F;
			this.Head.xRot = 0.14556046227948816F;
			this.Head.yRot = -0.5473352640780661F;
			this.Head.zRot = 0.9121090377974647F;
			this.Body.x = -1.1F;
			this.Body.y = 21.1F;
			this.Body.z = 0.0F;
			this.Body.xRot = -1.7453292129831807E-4F;
			this.Body.yRot = -0.0015707963892127347F;
			this.Body.zRot = -1.680228412305397F;
			this.FLegLeft.x = -1.4F;
			this.FLegLeft.y = 2.0F;
			this.FLegLeft.z = -1.2F;
			this.FLegLeft.xRot = -0.9861110273767961F;
			this.FLegLeft.yRot = 0.07312929665724782F;
			this.FLegLeft.zRot = 0.1090830782496456F;
			this.FLegRight.x = 1.5F;
			this.FLegRight.y = 5.0F;
			this.FLegRight.z = -2.0F;
			this.FLegRight.xRot = 0.037175515064850034F;
			this.FLegRight.yRot = 0.07278023113974408F;
			this.FLegRight.zRot = 1.2039281766152325F;
			this.FeetLeft.xRot = 0.8402014912574258F;
			this.FeetLeft.yRot = 3.141592653589793F;
			this.Tailtip.xRot = -0.36477380700891215F;
			this.Tailtip.yRot = 0.07295475973730675F;
			this.Tailtip.zRot = -0.1096066806870904F;
			this.Neck.x = 0.4F;
			this.Neck.y = -1.0F;
			this.Neck.z = -4.0F;
			this.Neck.xRot = 0.18238690350445608F;
			this.Neck.yRot = 0.1096066806870904F;
			this.Neck.zRot = 0.3281218860591285F;
		} else {
			this.Neck.xRot = 0;
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.BLegRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.BLegLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.FLegRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FLegLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tailtip.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Tailtip.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount) + attackProgress * (float) Math.toRadians(25F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entity.isInWater()) {
				this.Body.y = 9;
				this.Body.xRot = -0.125F;
				this.Tail.xRot = 0.0625F;
				this.Tailtip.xRot = 0.0625F;
				this.BLegLeft.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.BLegRight.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.FLegLeft.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.FLegRight.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.FeetLeft.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.FeetRight.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = 0.125F;
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tailtip.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.FeetRight.xRot = 0;
		this.FeetRight.yRot = 0;
		this.FeetRight.zRot = 0;
		this.BLegLeft.xRot = 0;
		this.BLegLeft.yRot = 0;
		this.BLegLeft.zRot = 0;
		this.BLegRight.xRot = 0;
		this.BLegRight.yRot = 0;
		this.BLegRight.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.FLegLeft.xRot = 0;
		this.FLegLeft.yRot = 0;
		this.FLegLeft.zRot = 0;
		this.FLegRight.xRot = 0.0F;
		this.FLegRight.yRot = 0.0F;
		this.FLegRight.zRot = 0.0F;
		this.FeetLeft.xRot = 0.0F;
		this.FeetLeft.yRot = 0.0F;
		this.Tailtip.xRot = 0;
		this.Tailtip.yRot = 0;
		this.Tailtip.zRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.BLegLeft.x = 1.5F;
		this.BLegLeft.y  = 2.0F;
		this.BLegLeft.z = 4.0F;
		this.BLegRight.x = -1.5F;
		this.BLegRight.y = 2.0F;
		this.BLegRight.z = 4.0F;
		this.Head.x = 0.0F;
		this.Head.y = 1.5F;
		this.Head.z = -2.0F;
		this.Body.x = 0.0F;
		this.Body.y = 13.0F;
		this.Body.z = 0.0F;
		this.FLegLeft.x  = -1.5F;
		this.FLegLeft.y = 5.0F;
		this.FLegLeft.z = -2.0F;
		this.FLegRight.x = 1.5F;
		this.FLegRight.y = 5.0F;
		this.FLegRight.z = -2.0F;
		this.Neck.x = 0.0F;
		this.Neck.y  = -1.5F;
		this.Neck.z = -4.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
