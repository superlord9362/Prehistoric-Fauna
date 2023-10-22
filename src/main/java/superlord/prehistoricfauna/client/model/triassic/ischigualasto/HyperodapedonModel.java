package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;

public class HyperodapedonModel extends EntityModel<Hyperodapedon> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart RLeg;
	private final ModelPart RArm;
	private final ModelPart LLeg;
	private final ModelPart LArm;

	public HyperodapedonModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.RLeg = Body.getChild("RLeg");
		this.RArm = Body.getChild("RArm");
		this.LLeg = Body.getChild("LLeg");
		this.LArm = Body.getChild("LArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -5.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -0.5F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, -4.0F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 3.0F, 1.01F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.0F, 1.01F));

		PartDefinition RLeg = Body.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 2.0F, 8.0F));

		PartDefinition LLeg = Body.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.0F, 8.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Hyperodapedon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Head.xRot = headPitch * ((float)Math.PI / 180F);
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.LLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.RArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				if (entity.isEating()) {
					this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.RLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LLeg.xRot = 0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.LArm.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.RArm.xRot = -0.25F * Mth.sin(0.15F * ageInTicks / 1.5F);
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Body
			//this.Body.x = 0F;
			//this.Body.y = 19.0F;
			if (this.Body.x > 0) this.Body.x -= 0.15;
			if (this.Body.y > 19) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			if (this.Body.yRot < 0) this.Body.yRot += 0.05;
			if (this.Body.zRot < 0) this.Body.zRot += 0.05;
			//RLeg
			//this.RLeg.x = -1.0F;
			//this.RLeg.y = 2.0F;
			if (this.RLeg.x < -1) this.RLeg.x += 0.15;
			if (this.RLeg.y < 2) this.RLeg.y += 0.15;
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot > 0) this.RLeg.yRot -= 0.05;
			if (this.RLeg.zRot < 0) this.RLeg.zRot += 0.05;
			//Head
			//this.Head.y = 1.5F;
			if (this.Head.y > 1.5) this.Head.y -= 0.15;
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0) this.Head.yRot += 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
			//LArm
			//this.LArm.x = 1.0F;
			//this.LArm.z = 1.01F;
			if (this.LArm.x < 1) this.LArm.x += 0.15;
			if (this.LArm.z > 1.01) this.LArm.z -= 0.15;
			if (this.LArm.xRot > 0) this.LArm.xRot -= 0.05;
			if (this.LArm.yRot > 0) this.LArm.yRot -= 0.05;
			if (this.LArm.zRot > 0) this.LArm.zRot -= 0.05;
			//RArm
			//this.RArm.y = 3.0F;
			//this.RArm.z = 1.01F;
			if (this.RArm.y < 3) this.RArm.y += 0.15;
			if (this.RArm.z < 1.01) this.RArm.z += 0.15;
			if (this.RArm.xRot < 0) this.RArm.xRot += 0.05;
			if (this.RArm.yRot < 0) this.RArm.yRot += 0.05;
			if (this.RArm.zRot < 0) this.RArm.zRot += 0.05;
			//Tail
			//this.Tail.y = 2.0F;
			//this.Tail.z = 10.0F;
			if (this.Tail.y < 2) this.Tail.y += 0.15;
			if (this.Tail.z < 10) this.Tail.z += 0.15;
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
			//LLeg
			//this.LLeg.y = 2.0F;
			if (this.LLeg.y > 2) this.LLeg.y -= 0.15;
			//LArm
			if (this.LArm.xRot > 0) this.LArm.xRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Body
			//this.Body.x = 0F;
			//this.Body.y = 19.0F;
			if (this.Body.x < 0.1) this.Body.x += 0.15;
			if (this.Body.y < 21) this.Body.y += 0.15;
			if (this.Body.xRot > -0.036477379868653376F) this.Body.xRot -= 0.05;
			if (this.Body.yRot > -0.036477379868653376F) this.Body.yRot -= 0.05;
			if (this.Body.zRot > -0.8395033435776615F) this.Body.zRot -= 0.05;
			//RLeg
			//this.RLeg.x = -1.0F;
			//this.RLeg.y = 2.0F;
			if (this.RLeg.x > -1.4) this.RLeg.x -= 0.15;
			if (this.RLeg.y > 1.3) this.RLeg.y -= 0.15;
			if (this.RLeg.xRot > -0.07295475973730675F) this.RLeg.xRot -= 0.05;
			if (this.RLeg.yRot < 0.036477379868653376F) this.RLeg.yRot += 0.05;
			if (this.RLeg.zRot > -0.7665485755179764F) this.RLeg.zRot -= 0.05;
			//Head
			//this.Head.y = 1.5F;
			if (this.Head.y < 1.6) this.Head.y += 0.15;
			if (this.Head.xRot < 0.2556907287592666F) this.Head.xRot += 0.05;
			if (this.Head.yRot > -0.3645992700889711F) this.Head.yRot -= 0.05;
			if (this.Head.zRot < 0.6932448001974364F) this.Head.zRot += 0.05;
			//LArm
			//this.LArm.x = 1.0F;
			//this.LArm.z = 1.01F;
			if (this.LArm.x > 0.7) this.LArm.x -= 0.15;
			if (this.LArm.z < 2.41) this.LArm.z += 0.15;
			if (this.LArm.xRot < 0.10943214376714933F) this.LArm.xRot += 0.05;
			if (this.LArm.yRot < 0.0712094321497881F) this.LArm.yRot += 0.05;
			if (this.LArm.zRot < 0.36477380700891215F) this.LArm.zRot += 0.05;
			//RArm
			//this.RArm.y = 3.0F;
			//this.RArm.z = 1.01F;
			if (this.RArm.y > 1.4) this.RArm.y -= 0.15;
			if (this.RArm.z > 0.71) this.RArm.z -= 0.15;
			if (this.RArm.xRot > -0.18256144042439712F) this.RArm.xRot -= 0.05;
			if (this.RArm.yRot > -0.10978120928465304F) this.RArm.yRot -= 0.05;
			if (this.RArm.zRot > -0.6202900321377512F) this.RArm.zRot -= 0.05;
			//Tail
			//this.Tail.y = 2.0F;
			//this.Tail.z = 10.0F;
			if (this.Tail.y > 0.9) this.Tail.y -= 0.15;
			if (this.Tail.z > 9.7) this.Tail.z -= 0.15;
			if (this.Tail.xRot > -0.1459095194746135F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot < 0.9482374145664524F) this.Tail.yRot += 0.05;
			if (this.Tail.zRot < 0.8032005297572737F) this.Tail.zRot += 0.05;
			//LLeg
			//this.LLeg.y = 2.0F;
			if (this.LLeg.y < 3.1) this.LLeg.y += 0.15;
			//LArm
			if (this.LArm.xRot < 0.583638077898454F) this.LArm.xRot += 0.05;
		}
	}

	public void resetModel() {
		this.Body.x = 0F;
		this.Body.y = 19.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RLeg.x = -1.0F;
		this.RLeg.y = 2.0F;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.RLeg.zRot = 0;
		this.Head.y = 1.5F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LArm.x = 1.0F;
		this.LArm.z = 1.01F;
		this.LArm.xRot = 0;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0;
		this.RArm.y = 3.0F;
		this.RArm.z = 1.01F;
		this.RArm.xRot = 0;
		this.RArm.yRot = 0;
		this.RArm.zRot = 0;
		this.Tail.y = 2.0F;
		this.Tail.z = 10.0F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.LLeg.y = 2.0F;
		this.LArm.xRot = 0;
	}

	public void sleepPose() {
		this.Body.x = 0.1F;
		this.Body.y = 21.0F;
		this.Body.xRot = -0.036477379868653376F;
		this.Body.yRot = -0.036477379868653376F;
		this.Body.zRot = -0.8395033435776615F;
		this.RLeg.x = -1.4F;
		this.RLeg.y = 1.3F;
		this.RLeg.xRot = -0.07295475973730675F;
		this.RLeg.yRot = 0.036477379868653376F;
		this.RLeg.zRot = -0.7665485755179764F;
		this.Head.y = 1.6F;
		this.Head.xRot = 0.2556907287592666F;
		this.Head.yRot = -0.3645992700889711F;
		this.Head.zRot = 0.6932448001974364F;
		this.LArm.x = 0.7F;
		this.LArm.z = 2.41F;
		this.LArm.xRot = 0.10943214376714933F;
		this.LArm.yRot = 0.0712094321497881F;
		this.LArm.zRot = 0.36477380700891215F;
		this.RArm.y = 1.4F;
		this.RArm.z = 0.71F;
		this.RArm.xRot = -0.18256144042439712F;
		this.RArm.yRot = -0.10978120928465304F;
		this.RArm.zRot = -0.6202900321377512F;
		this.Tail.y = 0.9F;
		this.Tail.z = 9.7F;
		this.Tail.xRot = -0.1459095194746135F;
		this.Tail.yRot = 0.9482374145664524F;
		this.Tail.zRot = 0.8032005297572737F;
		this.LLeg.y = 3.1F;
		this.LArm.xRot = 0.583638077898454F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}