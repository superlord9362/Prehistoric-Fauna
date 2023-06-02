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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;

public class CitipatiModel extends EntityModel<Citipati> {
	private final ModelPart Body;
	private final ModelPart ThighLeft;
	private final ModelPart ThighRight;
	private final ModelPart LegLeft;
	private final ModelPart LegRight;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart WingLeft;
	private final ModelPart WingRight;
	private final ModelPart Tail;
	private final ModelPart TailFan;

	public CitipatiModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.ThighLeft = Body.getChild("ThighLeft");
		this.ThighRight = Body.getChild("ThighRight");
		this.LegLeft = ThighLeft.getChild("LegLeft");
		this.LegRight = ThighRight.getChild("LegRight");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.WingLeft = Body.getChild("WingLeft");
		this.WingRight = Body.getChild("WingRight");
		this.Tail = Body.getChild("Tail");
		this.TailFan = Tail.getChild("TailFan");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -7.0F, 5.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -4.0F));

		PartDefinition WingLeft = Body.addOrReplaceChild("WingLeft", CubeListBuilder.create().texOffs(42, 21).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.9F, -3.0F));

		PartDefinition ThighLeft = Body.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 6.0F));

		PartDefinition LegLeft = ThighLeft.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(-1.0F, 0.0F, -4.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 8.0F, 4.0F));

		PartDefinition ThighRight = Body.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(0.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 1.0F, 6.0F));

		PartDefinition LegRight = ThighRight.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(-2.0F, 0.0F, -4.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 8.0F, 4.0F));

		PartDefinition WingRight = Body.addOrReplaceChild("WingRight", CubeListBuilder.create().texOffs(42, 21).mirror().addBox(0.0F, -1.0F, -2.0F, 2.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 1.0F, -3.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(40, 6).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 12.0F));

		PartDefinition TailFan = Tail.addOrReplaceChild("TailFan", CubeListBuilder.create().texOffs(0, 27).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 7.5F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -11.0F, -2.0F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -7.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(29, 0).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition Crest = Head.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(41, 2).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 80);
	}

	@Override
	public void setupAnim(Citipati entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.ThighLeft.y = 1F;
		this.ThighRight.y = 1F;
		this.Neck.xRot = 0;
		this.Body.xRot = 0;
		this.WingRight.xRot = 0;
		this.WingRight.yRot = 0;
		this.WingRight.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.ThighLeft.xRot = 0;
		this.ThighLeft.yRot = 0;
		this.TailFan.xRot = 0;
		this.TailFan.yRot = 0;
		this.TailFan.zRot = 0;
		this.ThighRight.xRot = 0;
		this.ThighRight.yRot = 0;
		this.WingLeft.xRot = 0;
		this.WingLeft.yRot = 0;
		this.WingLeft.zRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.LegLeft.xRot = 0;
		this.LegLeft.yRot = 0;
		this.LegLeft.zRot = 0;
		this.LegRight.xRot = 0;
		this.LegRight.yRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Body.y = 6;
		if (entity.isAsleep() || entity.isSitting()) {
			this.Body.y = 16.9F;
			this.WingRight.xRot = 0.39025563139857644F;
			this.WingRight.yRot = 0.5866051722479385F;
			this.WingRight.zRot = -0.7428121536172364F;
			this.Head.xRot = 0.9773843811168246F;
			this.Head.yRot = 0.11728612207217244F;
			this.ThighLeft.xRot = -1.0950196019960143F;
			this.ThighLeft.yRot = 0.35185837453889574F;
			this.TailFan.xRot = 0.0781907508222411F;
			this.TailFan.yRot = -0.27366763203903305F;
			this.TailFan.zRot = -0.11728612207217244F;
			this.ThighRight.xRot = -1.1730357742864224F;
			this.ThighRight.yRot = -0.4300491170387584F;
			this.Body.xRot = -0.3909537457888271F;
			this.WingLeft.xRot = 0.15690509575954859F;
			this.WingLeft.yRot = -0.7429866572476639F;
			this.WingLeft.zRot = 0.8990190684075072F;
			this.Neck.xRot = -0.35185837453889574F;
			this.Neck.yRot = 0.23457224414434488F;
			this.Neck.zRot = -0.0781907508222411F;
			this.LegLeft.xRot = 0.16580627893946132F;
			this.LegLeft.yRot = 3.1398472178113552F;
			this.LegLeft.zRot = 0.0607374583022978F;
			this.LegRight.xRot = 0.03874630989361682F;
			this.LegRight.yRot = 3.141592653589793F;
			this.Tail.xRot = 0.23457224414434488F;
			this.Tail.yRot = -0.19547687289441354F;
		} else {
			float partialTick = ageInTicks - entity.tickCount;
			float attackProgress = entity.getMeleeProgress(partialTick);
			this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.ThighRight.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.ThighLeft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.TailFan.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.TailFan.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Head.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.WingLeft.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.WingRight.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			if (entity.isEating()) {
				this.Body.xRot = 0.5F;
				this.ThighLeft.xRot = -0.5F;
				this.ThighRight.xRot = -0.5F;
				this.ThighLeft.y = 4F;
				this.ThighRight.y = 4F;
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.Body.y = 17;
				this.Body.xRot = -0.25F;
				this.Tail.xRot = 0.25F;
				this.Neck.xRot = 0.25F;
				this.WingLeft.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.WingRight.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
				this.ThighLeft.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ThighRight.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.TailFan.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.LegLeft.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LegRight.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
