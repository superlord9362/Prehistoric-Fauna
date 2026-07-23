package superlord.prehistoricfauna.client.model.henos;

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
import superlord.prehistoricfauna.common.entity.henos.Pyrinos;

@SuppressWarnings("unused")
public class PyrinosModel extends EntityModel<Pyrinos> {
	private final ModelPart Root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart ThingyLeft;
	private final ModelPart ThingyRight;
	private final ModelPart Tail1;
	private final ModelPart ArmRight;
	private final ModelPart WingRight;
	private final ModelPart ArmLeft;
	private final ModelPart WingLeft;
	private final ModelPart ThighLeft;
	private final ModelPart LegLeft;
	private final ModelPart FootLeft;
	private final ModelPart ThighRight;
	private final ModelPart LegRight;
	private final ModelPart FootRight;

	public PyrinosModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Body = this.Root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.ThingyLeft = this.Head.getChild("ThingyLeft");
		this.ThingyRight = this.Head.getChild("ThingyRight");
		this.Tail1 = this.Body.getChild("Tail1");
		this.ArmRight = this.Body.getChild("ArmRight");
		this.WingRight = this.ArmRight.getChild("WingRight");
		this.ArmLeft = this.Body.getChild("ArmLeft");
		this.WingLeft = this.ArmLeft.getChild("WingLeft");
		this.ThighLeft = this.Root.getChild("ThighLeft");
		this.LegLeft = this.ThighLeft.getChild("LegLeft");
		this.FootLeft = this.LegLeft.getChild("FootLeft");
		this.ThighRight = this.Root.getChild("ThighRight");
		this.LegRight = this.ThighRight.getChild("LegRight");
		this.FootRight = this.LegRight.getChild("FootRight");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(46, 68).addBox(-5.0F, -5.0F, -1.0F, 10.0F, 12.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(86, 98).addBox(0.0F, -9.0F, 0.0F, 0.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -32.9572F, -6.3474F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(28, 82).addBox(-2.0F, -7.8915F, -3.9078F, 4.0F, 11.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(86, 119).addBox(-3.0F, -7.0F, -1.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(120, 101).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.01F))
				.texOffs(0, 92).addBox(-2.0F, -6.0F, -6.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.8815F, -3.9178F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(120, 92).addBox(-2.0F, -0.025F, -7.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0F));

		PartDefinition ThingyLeft = Head.addOrReplaceChild("ThingyLeft", CubeListBuilder.create().texOffs(52, 98).addBox(0.0F, -6.0F, -0.5F, 0.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -3.5F));

		PartDefinition ThingyRight = Head.addOrReplaceChild("ThingyRight", CubeListBuilder.create().texOffs(52, 98).mirror().addBox(0.0F, -6.0F, -0.5F, 0.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -5.0F, -3.5F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 98).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 6.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(46, 36).addBox(0.0F, -6.0F, 0.0F, 0.0F, 4.0F, 28.0F, new CubeDeformation(0.0F))
				.texOffs(102, 55).addBox(-1.5F, -2.0F, 18.0F, 3.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.5F, 0.0F, 18.0F, 25.0F, 0.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 17.0F));

		PartDefinition ArmRight = Body.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(102, 36).mirror().addBox(-2.0F, -2.0F, 0.0F, 2.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -2.0F, -1.0F));

		PartDefinition WingRight = ArmRight.addOrReplaceChild("WingRight", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 2.0F, 15.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition cube_r1 = WingRight.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 125).mirror().addBox(0.0F, -0.0872F, -27.9981F, 0.0F, 28.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition ArmLeft = Body.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(102, 36).addBox(0.0F, -2.0F, 0.0F, 2.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, -1.0F));

		PartDefinition WingLeft = ArmLeft.addOrReplaceChild("WingLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 2.0F, 15.0F, 0.0F, -0.0436F, 0.0F));

		PartDefinition cube_r2 = WingLeft.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 125).addBox(0.0F, -0.0872F, -27.9981F, 0.0F, 28.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition ThighLeft = Root.addOrReplaceChild("ThighLeft", CubeListBuilder.create().texOffs(102, 73).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -26.0F, 8.0F));

		PartDefinition LegLeft = ThighLeft.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(110, 119).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 1.0F));

		PartDefinition FootLeft = LegLeft.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(0, 82).addBox(-3.0F, 0.0F, -7.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition ThighRight = Root.addOrReplaceChild("ThighRight", CubeListBuilder.create().texOffs(102, 73).mirror().addBox(-2.0F, -2.0F, -4.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -26.0F, 8.0F));

		PartDefinition LegRight = ThighRight.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(110, 119).mirror().addBox(-1.5F, -1.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 1.0F));

		PartDefinition FootRight = LegRight.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(0, 82).mirror().addBox(-3.0F, 0.0F, -7.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Pyrinos entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isPyrinosFlying()) {
			this.ArmRight.zRot = 1 + Mth.sin(ageInTicks * 0.1F) * 0.5F;
			this.ArmRight.xRot = -1.2F + Mth.sin(ageInTicks * 0.1F) * 0.5F;
			this.WingRight.xRot = 1.2F + Mth.sin(ageInTicks * 0.1F) * 0.5F;
			this.WingRight.zRot = Mth.sin(ageInTicks * 0.1F) * 0.5F;
			this.ArmLeft.zRot = -1 + Mth.sin(ageInTicks * 0.1F) * -0.5F;
			this.ArmLeft.xRot = -1.2F + Mth.sin(ageInTicks * 0.1F) * 0.5F;
			this.WingLeft.xRot = 1.2F + Mth.sin(ageInTicks * 0.1F) * 0.5F;
			this.WingLeft.zRot = Mth.sin(ageInTicks * 0.1F) * -0.5F;
			this.ThighRight.xRot = 0;
			this.LegRight.xRot = 0;
			this.FootRight.xRot = 0;
			this.ThighLeft.xRot = 0;
			this.LegLeft.xRot = 0;
			this.FootLeft.xRot = 0;
		} else {
			this.ArmRight.zRot = (-Mth.cos(0.05F * ageInTicks) * 0.05F) + (Mth.abs(Mth.sin(limbSwing * 0.6F) * 2.25F * limbSwingAmount));
			this.ArmLeft.zRot = (Mth.cos(0.05F * ageInTicks) * 0.05F) + (-Mth.abs(Mth.sin(limbSwing * 0.6F) * 2.25F * limbSwingAmount));
			this.ArmRight.xRot = 0;
			this.WingRight.xRot = 0;
			this.WingRight.zRot = 0;
			this.ArmLeft.xRot = 0;
			this.WingLeft.xRot = 0;
			this.WingLeft.zRot = 0;
			this.ThighRight.xRot = Mth.sin(0.4F * limbSwing) * 0.5F * limbSwingAmount;
			this.LegRight.xRot = Mth.sin(limbSwing * 0.4F) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
			this.FootRight.xRot = Mth.sin(limbSwing * 0.4F) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
			this.ThighLeft.xRot = Mth.sin(0.4F * limbSwing + (float)Math.PI) * 0.5F * limbSwingAmount;
			this.LegLeft.xRot = Mth.sin(limbSwing*0.4F + (float)Math.PI) * 0.65F * limbSwingAmount - (0.25F * limbSwingAmount * 2);
			this.FootLeft.xRot = Mth.sin(limbSwing * 0.4F + (float)Math.PI) * 0.325F * limbSwingAmount + (0.35F * limbSwingAmount * 2);
		}
		this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.sin(limbSwing * 0.6F) * 0.15F * limbSwingAmount) - 0.1F;
		this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
		this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.Neck.xRot = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + 0.2182F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}