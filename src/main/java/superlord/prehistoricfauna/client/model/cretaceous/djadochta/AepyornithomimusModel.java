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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;

public class AepyornithomimusModel extends EntityModel<Aepyornithomimus> {
	private final ModelPart Thighleft;
	private final ModelPart Thighleft_1;
	private final ModelPart Body;
	private final ModelPart Wingright;
	private final ModelPart Wingleft;
	private final ModelPart Tailbase;
	private final ModelPart Tailtip;
	private final ModelPart HeadNeck;
	private final ModelPart legleft;
	private final ModelPart legleft_1;

	public AepyornithomimusModel(ModelPart root) {
		this.Thighleft = root.getChild("Thighleft");
		this.Thighleft_1 = root.getChild("Thighleft_1");
		this.Body = root.getChild("Body");
		this.Wingleft = Body.getChild("Wingleft");
		this.Wingright = Body.getChild("Wingright");
		this.HeadNeck = Body.getChild("HeadNeck");
		this.Tailbase = Body.getChild("Tailbase");
		this.Tailtip = Tailbase.getChild("Tailtip");
		this.legleft = Thighleft.getChild("legleft");
		this.legleft_1 = Thighleft_1.getChild("legleft_1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thighleft = partdefinition.addOrReplaceChild("Thighleft", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 12.0F, 1.0F));

		PartDefinition legleft = Thighleft.addOrReplaceChild("legleft", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 5.0F, 2.0F));

		PartDefinition Thighleft_1 = partdefinition.addOrReplaceChild("Thighleft_1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-0.5F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 12.0F, 1.0F));

		PartDefinition legleft_1 = Thighleft_1.addOrReplaceChild("legleft_1", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 5.0F, 2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -10.0F, 4.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition Wingright = Body.addOrReplaceChild("Wingright", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.8F, 2.0F, -8.0F));

		PartDefinition Tailbase = Body.addOrReplaceChild("Tailbase", CubeListBuilder.create().texOffs(26, 10).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 4.5F));

		PartDefinition Tailtip = Tailbase.addOrReplaceChild("Tailtip", CubeListBuilder.create().texOffs(30, 25).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition part7 = Tailtip.addOrReplaceChild("part7", CubeListBuilder.create().texOffs(0, 20).addBox(-2.0F, 0.0F, 0.5F, 4.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadNeck = Body.addOrReplaceChild("HeadNeck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -2.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -10.0F));

		PartDefinition Beak = HeadNeck.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -2.5F));

		PartDefinition Crest = HeadNeck.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(23, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.5F));

		PartDefinition Wingleft = Body.addOrReplaceChild("Wingleft", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8F, 2.0F, -8.0F, 0.0F, -0.0787F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Aepyornithomimus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				setSleepingPose();
			} else {
				resetModel();
				this.Thighleft_1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.Thighleft.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tailbase.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tailtip.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tailbase.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tailtip.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.HeadNeck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Wingleft.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Wingright.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.HeadNeck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				if (entity.isEating()) {
					this.HeadNeck.xRot = Math.abs(Mth.sin(0.15F * ageInTicks) * 0.75F) + 1.5F;
				}
				if (entity.isInWater()) {
					this.Thighleft.y = 19;
					this.Thighleft_1.y = 19;
					this.Body.y = 19;
					this.Body.xRot = -0.5F;
					this.Tailbase.xRot = 0.25F;
					this.Tailtip.xRot = 0.25F;
					this.HeadNeck.xRot = 0.5F;
					this.Wingleft.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.2F * ageInTicks / 2));
					this.Wingright.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.2F * ageInTicks / 2));
					this.Thighleft.xRot = -0.5F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Thighleft_1.xRot = 0.5F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tailbase.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.Tailtip.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
					this.legleft_1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.legleft.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Thighleft_1
			if (this.Thighleft_1.y > 12) this.Thighleft_1.y -= 0.15F;
			if (this.Thighleft_1.xRot < 0) this.Thighleft_1.xRot += 0.05;
			if (this.Thighleft_1.yRot > 0) this.Thighleft_1.yRot -= 0.05;
			//Wingright
			if (this.Wingright.xRot > 0) this.Wingright.xRot -= 0.05;
			if (this.Wingright.zRot < 0) this.Wingright.zRot += 0.05;
			//Tailbase
			if (this.Tailbase.xRot < 0) this.Tailbase.xRot += 0.05;
			if (this.Tailbase.yRot > 0) this.Tailbase.yRot -= 0.05;
			//Wingleft
			if (this.Wingleft.xRot > 0) this.Wingleft.xRot -= 0.05;
			if (this.Wingleft.zRot > 0) this.Wingleft.zRot -= 0.05;
			//HeadNeck
			if (this.HeadNeck.xRot > 0) this.HeadNeck.xRot -= 0.05;
			if (this.HeadNeck.yRot < 0) this.HeadNeck.yRot += 0.05;
			if (this.HeadNeck.zRot > 0) this.HeadNeck.zRot -= 0.05;
			//Tailtip
			if (this.Tailtip.yRot > 0) this.Tailtip.yRot -= 0.05;
			//Thighleft
			if (this.Thighleft.y > 12) this.Thighleft.y -= 0.15F;
			if (this.Thighleft.xRot < 0) this.Thighleft.xRot += 0.05;
			if (this.Thighleft.yRot < 0) this.Thighleft.yRot += 0.05;
			//Body
			if (this.Body.y > 12) this.Body.y -= 0.15F;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Thighleft_1
			if (this.Thighleft_1.y < 21) this.Thighleft_1.y += 0.15F;
			if (this.Thighleft_1.xRot > -0.46931902520863084F) this.Thighleft_1.xRot -= 0.05;
			if (this.Thighleft_1.yRot < 0.03909537541112055F) this.Thighleft_1.yRot += 0.05;
			//Wingright
			if (this.Wingright.xRot < 0.35185837453889574F) this.Wingright.xRot += 0.05;
			if (this.Wingright.zRot > -1.2892747663851107F) this.Wingright.zRot -= 0.05;
			//Tailbase
			if (this.Wingleft.xRot > -0.1563815016444822F) this.Tailbase.xRot -= 0.05;
			if (this.Wingleft.yRot < 0.4300491170387584F) this.Tailbase.yRot += 0.05;
			//Wingleft
			if (this.Wingleft.xRot < 0.35185837453889574F) this.Wingleft.xRot += 0.05;
			if (this.Wingleft.zRot < 1.2892747663851107F) this.Wingleft.zRot += 0.05;
			//HeadNeck
			if (this.HeadNeck.xRot < 0.5864306020384839F) this.HeadNeck.xRot += 0.05;
			if (this.HeadNeck.yRot > -1.759291939273506F) this.HeadNeck.yRot -= 0.05;
			if (this.HeadNeck.zRot < 0.3127630032889644F) this.HeadNeck.zRot += 0.05;
			//Tailtip
			if (this.Tailtip.yRot < 0.5082398928281348F) this.Tailtip.yRot += 0.05;
			//Thighleft
			if (this.Thighleft.y < 21) this.Thighleft.y += 0.15F;
			if (this.Thighleft.xRot > -0.46931902520863084F) this.Thighleft.xRot -= 0.05;
			if (this.Thighleft.yRot > -0.03909537541112055F) this.Thighleft.yRot -= 0.05;
			//Body
			if (this.Body.y < 21) this.Body.y += 0.15F;
		}
	}

	public void resetModel() {
		this.Thighleft_1.xRot = 0;
		this.Thighleft_1.yRot = 0;
		this.Wingright.xRot = 0;
		this.Wingright.zRot = 0;
		this.Tailbase.xRot = 0;
		this.Tailbase.yRot = 0;
		this.Wingleft.xRot = 0;
		this.Wingleft.zRot = 0;
		this.HeadNeck.xRot = 0;
		this.HeadNeck.yRot = 0;
		this.HeadNeck.zRot = 0;
		this.Tailtip.yRot = 0;
		this.Tailtip.xRot = 0;
		this.Thighleft.xRot = 0;
		this.Thighleft.zRot = 0;
		this.Thighleft.yRot = 0;
		this.Body.y = 12;
		this.Thighleft.y = 12;
		this.Thighleft_1.y = 12;
		this.Body.xRot = 0;
		this.legleft.xRot = 0;
		this.legleft_1.xRot = 0;
	}

	public void setSleepingPose() {
		this.Body.y = 21;
		this.Thighleft.y = 21;
		this.Thighleft_1.y = 21;
		this.Thighleft_1.xRot = -0.46931902520863084F;
		this.Thighleft_1.yRot = 0.03909537541112055F;
		this.Wingright.xRot = 0.35185837453889574F;
		this.Wingright.zRot = -1.2892747663851107F;
		this.Tailbase.xRot = -0.1563815016444822F;
		this.Tailbase.yRot = 0.4300491170387584F;
		this.Wingleft.xRot = 0.35185837453889574F;
		this.Wingleft.zRot = 1.2901473511162753F;
		this.HeadNeck.xRot = 0.5864306020384839F;
		this.HeadNeck.yRot = -1.759291939273506F;
		this.HeadNeck.zRot = 0.3127630032889644F;
		this.Tailtip.yRot = 0.5082398928281348F;
		this.Thighleft.xRot = -0.46914448828868976F;
		this.Thighleft.yRot = -0.03909537541112055F;
	}
	
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thighleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thighleft_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
