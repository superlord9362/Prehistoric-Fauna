package superlord.prehistoricfauna.client.model.jurassic.kayenta;

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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentachelys;

@SuppressWarnings("unused")
public class KayentachelysModel extends EntityModel<Kayentachelys> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart Scutes;
	private final ModelPart LeftBackLeg;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;
	private final ModelPart RightBackLeg;

	public KayentachelysModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
		this.Scutes = this.Tail.getChild("Scutes");
		this.LeftBackLeg = this.Root.getChild("LeftBackLeg");
		this.LeftFrontLeg = this.Root.getChild("LeftFrontLeg");
		this.RightFrontLeg = this.Root.getChild("RightFrontLeg");
		this.RightBackLeg = this.Root.getChild("RightBackLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.0F, -5.5F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -0.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.3F, -4.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(17, 26).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.8F, -3.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, 4.8F));

		PartDefinition Scutes = Tail.addOrReplaceChild("Scutes", CubeListBuilder.create().texOffs(19, 16).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition LeftBackLeg = Root.addOrReplaceChild("LeftBackLeg", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.9F, 3.0F));

		PartDefinition LeftFrontLeg = Root.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(17, 33).addBox(-1.5F, -0.1F, -1.65F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -1.9F, -4.5F));

		PartDefinition RightFrontLeg = Root.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(30, 33).addBox(-1.5F, -0.1F, -1.65F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -1.9F, -4.5F));

		PartDefinition RightBackLeg = Root.addOrReplaceChild("RightBackLeg", CubeListBuilder.create().texOffs(34, 26).addBox(0.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.9F, 3.0F));

		return LayerDefinition.create(meshdefinition, 46, 46);
	}

	@Override
	public void setupAnim(Kayentachelys entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftBackLeg.xRot = Mth.lerp(sleepProgress, 0, 1.5816247076649256F);
				this.LeftBackLeg.yRot = Mth.lerp(sleepProgress, 0, -0.40125119103875473F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.07295475973730675F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.36477380700891215F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, 0.01902408942930468F);
				this.Head.y = Mth.lerp(sleepProgress, -0.8F, -0.5F);
				this.Head.z = Mth.lerp(sleepProgress, -3, -4F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.3284709598990106F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.40194933871851896F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, -0.291819038949227F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.3F);
				this.Body.y = Mth.lerp(sleepProgress, -4, -3F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.1459095194746135F);
				this.LeftBackLeg.y = Mth.lerp(sleepProgress, -2.9F, 0F);
				this.LeftFrontLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8030259595478191F);
				this.LeftFrontLeg.zRot = Mth.lerp(sleepProgress, 0, 1.401154619282966F);
				this.RightBackLeg.y = Mth.lerp(sleepProgress, -2.9F, 0F);
				this.RightBackLeg.xRot = Mth.lerp(sleepProgress, 0, 1.505702911834783F);
				this.RightBackLeg.yRot = Mth.lerp(sleepProgress, 0, 0.291819038949227F);
				this.RightFrontLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8030259595478191F);
				this.RightFrontLeg.zRot = Mth.lerp(sleepProgress, 0, -1.401154619282966F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LeftBackLeg.xRot = Mth.lerp(sleepProgress, 1.5816247076649256F, 0);
				this.LeftBackLeg.yRot = Mth.lerp(sleepProgress, -0.40125119103875473F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.07295475973730675F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.36477380700891215F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0.01902408942930468F, 0);
				this.Head.y = Mth.lerp(sleepProgress, -0.5F, -0.8F);
				this.Head.z = Mth.lerp(sleepProgress, -4, -3F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.3284709598990106F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.40194933871851896F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, -0.291819038949227F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.3F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -3, -4F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.1459095194746135F, 0);
				this.LeftBackLeg.y = Mth.lerp(sleepProgress, 0, -2.9F);
				this.LeftFrontLeg.xRot = Mth.lerp(sleepProgress, -0.8030259595478191F, 0);
				this.LeftFrontLeg.zRot = Mth.lerp(sleepProgress, 1.401154619282966F, 0);
				this.RightBackLeg.y = Mth.lerp(sleepProgress, 0F, -2.9F);
				this.RightBackLeg.xRot = Mth.lerp(sleepProgress, 1.505702911834783F, 0);
				this.RightBackLeg.yRot = Mth.lerp(sleepProgress, 0.291819038949227F, 0);
				this.RightFrontLeg.xRot = Mth.lerp(sleepProgress, -0.8030259595478191F, 0);
				this.RightFrontLeg.zRot = Mth.lerp(sleepProgress, -1.401154619282966F, 0);
			} else {
				this.Head.xRot = headPitch * ((float)Math.PI / 180F);
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LeftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.RightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				if (entity.isEating()) {
					this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.LeftFrontLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RightFrontLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LeftBackLeg.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RightBackLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tail.xRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.25F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftBackLeg.y = -2.9F;
		this.RightBackLeg.y = -2.9F;
		this.LeftBackLeg.xRot = 0;
		this.LeftBackLeg.yRot = 0;
		this.Tail.z = 4.8F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.Neck.xRot = 0;
		this.Head.y = -0.8F;
		this.Head.z = -3.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Body.y = -4.0F;
		this.Body.xRot = 0;
		this.LeftFrontLeg.x = -4.5F;
		this.LeftFrontLeg.y = -1.9F;
		this.LeftFrontLeg.z = -4.5F;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.LeftFrontLeg.zRot = 0;
		this.RightBackLeg.xRot = 0;
		this.RightBackLeg.yRot = 0;
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.RightFrontLeg.zRot = 0;
	}

	public void sleepPose() {
		this.LeftBackLeg.xRot = 1.5816247076649256F;
		this.LeftBackLeg.yRot = -0.40125119103875473F;
		this.Tail.xRot = -0.07295475973730675F;
		this.Tail.yRot = 0.36477380700891215F;
		this.Tail.zRot = 0.01902408942930468F;
		this.Head.y = -0.5F;
		this.Head.z = -4F;
		this.Head.xRot = 0.3284709598990106F;
		this.Head.yRot = -0.40194933871851896F;
		this.Head.zRot = -0.291819038949227F;
		this.Neck.xRot = 0.3F;
		this.Body.y = -3F;
		this.Body.xRot = -0.1459095194746135F;
		this.LeftBackLeg.y = 0F;
		this.LeftFrontLeg.xRot = -0.8030259595478191F;
		this.LeftFrontLeg.zRot = 1.401154619282966F;
		this.RightBackLeg.y = 0F;
		this.RightBackLeg.xRot = 1.505702911834783F;
		this.RightBackLeg.yRot = 0.291819038949227F;
		this.RightFrontLeg.xRot = -0.8030259595478191F;
		this.RightFrontLeg.zRot = -1.401154619282966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}