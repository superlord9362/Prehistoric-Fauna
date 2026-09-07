package superlord.prehistoricfauna.client.model.henos;

import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import superlord.prehistoricfauna.common.entity.henos.Pyrinos;

@SuppressWarnings("unused")
public class PyrinosModel extends HierarchicalModel<Pyrinos> {
	private final ModelPart pyrothos;
	private final ModelPart rightleg;
	private final ModelPart rightfoot;
	private final ModelPart righttoecontrol;
	private final ModelPart righttoe1;
	private final ModelPart righttoe2;
	private final ModelPart righttoe3;
	private final ModelPart leftleg;
	private final ModelPart leftfoot;
	private final ModelPart lefttoecontrol;
	private final ModelPart lefttoe1;
	private final ModelPart lefttoe2;
	private final ModelPart lefttoe3;
	private final ModelPart topbody;
	private final ModelPart neck;
	private final ModelPart neckcontrol;
	private final ModelPart head;
	private final ModelPart throat;
	private final ModelPart throattop;
	private final ModelPart throatbottom;
	private final ModelPart head2;
	private final ModelPart jaw;
	private final ModelPart rear;
	private final ModelPart pole;
	private final ModelPart tailcontrol;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart wingcontrol;
	private final ModelPart rightwing;
	private final ModelPart righthand;
	private final ModelPart leftwing;
	private final ModelPart lefthand;

	public PyrinosModel(ModelPart root) {
		this.pyrothos = root.getChild("pyrothos");
		this.rightleg = this.pyrothos.getChild("rightleg");
		this.rightfoot = this.rightleg.getChild("rightfoot");
		this.righttoecontrol = this.rightfoot.getChild("righttoecontrol");
		this.righttoe1 = this.righttoecontrol.getChild("righttoe1");
		this.righttoe2 = this.righttoecontrol.getChild("righttoe2");
		this.righttoe3 = this.righttoecontrol.getChild("righttoe3");
		this.leftleg = this.pyrothos.getChild("leftleg");
		this.leftfoot = this.leftleg.getChild("leftfoot");
		this.lefttoecontrol = this.leftfoot.getChild("lefttoecontrol");
		this.lefttoe1 = this.lefttoecontrol.getChild("lefttoe1");
		this.lefttoe2 = this.lefttoecontrol.getChild("lefttoe2");
		this.lefttoe3 = this.lefttoecontrol.getChild("lefttoe3");
		this.topbody = this.pyrothos.getChild("topbody");
		this.neck = this.topbody.getChild("neck");
		this.neckcontrol = this.neck.getChild("neckcontrol");
		this.head = this.neck.getChild("head");
		this.throat = this.head.getChild("throat");
		this.throattop = this.throat.getChild("throattop");
		this.throatbottom = this.throat.getChild("throatbottom");
		this.head2 = this.head.getChild("head2");
		this.jaw = this.head2.getChild("jaw");
		this.rear = this.topbody.getChild("rear");
		this.pole = this.rear.getChild("pole");
		this.tailcontrol = this.rear.getChild("tailcontrol");
		this.tail1 = this.tailcontrol.getChild("tail1");
		this.tail2 = this.tailcontrol.getChild("tail2");
		this.tail3 = this.tailcontrol.getChild("tail3");
		this.tail4 = this.tailcontrol.getChild("tail4");
		this.wingcontrol = this.topbody.getChild("wingcontrol");
		this.rightwing = this.wingcontrol.getChild("rightwing");
		this.righthand = this.rightwing.getChild("righthand");
		this.leftwing = this.wingcontrol.getChild("leftwing");
		this.lefthand = this.leftwing.getChild("lefthand");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition pyrothos = partdefinition.addOrReplaceChild("pyrothos", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0F, 8.0F));

		PartDefinition rightleg = pyrothos.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 162).addBox(-7.0F, -5.0F, -7.0F, 14.0F, 30.0F, 14.0F, new CubeDeformation(0.02F)), PartPose.offset(-11.0F, -1.0F, 1.0F));

		PartDefinition rightfoot = rightleg.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(56, 186).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.02F))
				.texOffs(64, 132).addBox(4.0F, 13.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 22.0F, 5.0F));

		PartDefinition righttoecontrol = rightfoot.addOrReplaceChild("righttoecontrol", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition righttoe1 = righttoecontrol.addOrReplaceChild("righttoe1", CubeListBuilder.create().texOffs(0, 206).addBox(-14.0F, 3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.02F))
				.texOffs(196, 20).addBox(-14.0F, -3.0F, -2.0F, 14.0F, 6.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition righttoe2 = righttoecontrol.addOrReplaceChild("righttoe2", CubeListBuilder.create().texOffs(194, 36).addBox(-2.0F, -3.0F, -14.0F, 4.0F, 6.0F, 14.0F, new CubeDeformation(0.02F))
				.texOffs(196, 30).addBox(-2.0F, 3.0F, -14.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition righttoe3 = righttoecontrol.addOrReplaceChild("righttoe3", CubeListBuilder.create().texOffs(196, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 14.0F, new CubeDeformation(0.02F))
				.texOffs(102, 205).addBox(-2.0F, 3.0F, 10.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition leftleg = pyrothos.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 162).addBox(-7.0F, -5.0F, -7.0F, 14.0F, 30.0F, 14.0F, new CubeDeformation(0.02F)), PartPose.offset(11.0F, -1.0F, 1.0F));

		PartDefinition leftfoot = leftleg.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(56, 186).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.02F))
				.texOffs(64, 132).mirror().addBox(-7.0F, 13.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.02F)).mirror(false), PartPose.offset(0.0F, 22.0F, 5.0F));

		PartDefinition lefttoecontrol = leftfoot.addOrReplaceChild("lefttoecontrol", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition lefttoe1 = lefttoecontrol.addOrReplaceChild("lefttoe1", CubeListBuilder.create().texOffs(0, 206).mirror().addBox(10.0F, 3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.02F)).mirror(false)
				.texOffs(196, 20).addBox(0.0F, -3.0F, -2.0F, 14.0F, 6.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition lefttoe2 = lefttoecontrol.addOrReplaceChild("lefttoe2", CubeListBuilder.create().texOffs(194, 36).addBox(-2.0F, -3.0F, -14.0F, 4.0F, 6.0F, 14.0F, new CubeDeformation(0.02F))
				.texOffs(196, 30).addBox(-2.0F, 3.0F, -14.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition lefttoe3 = lefttoecontrol.addOrReplaceChild("lefttoe3", CubeListBuilder.create().texOffs(196, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 14.0F, new CubeDeformation(0.02F))
				.texOffs(102, 205).addBox(-2.0F, 3.0F, 10.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition topbody = pyrothos.addOrReplaceChild("topbody", CubeListBuilder.create().texOffs(0, 114).addBox(-17.0F, -34.0F, -11.5F, 9.0F, 25.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(64, 146).addBox(-8.0F, -31.0F, -6.5F, 16.0F, 22.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 114).mirror().addBox(8.0F, -34.0F, -11.5F, 9.0F, 25.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, 0.5F));

		PartDefinition neck = topbody.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -30.0F, 2.5F));

		PartDefinition neckcontrol = neck.addOrReplaceChild("neckcontrol", CubeListBuilder.create().texOffs(132, 182).addBox(-6.0F, -7.0F, -6.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(176, 73).addBox(-5.0F, -4.0F, -18.0F, 10.0F, 7.0F, 24.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, -22.0F, 0.0F));

		PartDefinition throat = head.addOrReplaceChild("throat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition throattop = throat.addOrReplaceChild("throattop", CubeListBuilder.create().texOffs(90, 76).addBox(-8.0F, -9.0F, -21.0F, 16.0F, 9.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(64, 114).addBox(-5.0F, 0.0F, 3.0F, 10.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(194, 68).addBox(-2.0F, -11.0F, -13.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(194, 68).addBox(-2.0F, -11.0F, -9.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(194, 68).addBox(-2.0F, -11.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(194, 68).addBox(-2.0F, -11.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(194, 68).addBox(-2.0F, -11.0F, -17.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(204, 172).addBox(-8.0F, 0.0F, -2.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(204, 172).addBox(-8.0F, 0.0F, -18.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(204, 172).addBox(-8.0F, 0.0F, -10.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(204, 172).addBox(5.0F, 0.0F, -2.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(204, 172).addBox(5.0F, 0.0F, -18.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(204, 172).addBox(5.0F, 0.0F, -10.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition throatbottom = throat.addOrReplaceChild("throatbottom", CubeListBuilder.create().texOffs(90, 112).addBox(-19.0F, -3.0F, -23.0F, 16.0F, 7.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-6.0F, -5.0F, -15.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-19.0F, -5.0F, -7.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-19.0F, -5.0F, 1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-19.0F, -5.0F, -23.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-19.0F, -5.0F, -15.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-6.0F, -5.0F, -7.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-6.0F, -5.0F, 1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(78, 141).addBox(-6.0F, -5.0F, -23.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 5.0F, 11.0F));

		PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(180, 202).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(180, 182).addBox(-5.0F, -7.0F, -16.0F, 10.0F, 9.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(88, 186).addBox(-2.0F, -10.0F, -20.0F, 4.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(64, 119).addBox(-2.0F, -7.0F, -20.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(78, 132).addBox(-2.0F, -1.0F, -22.0F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -19.0F));

		PartDefinition jaw = head2.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(176, 129).addBox(-5.0F, 0.0F, -11.0F, 10.0F, 5.0F, 11.0F, new CubeDeformation(0.025F))
				.texOffs(204, 154).addBox(-2.0F, 0.0F, -15.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -5.0F));

		PartDefinition rear = topbody.addOrReplaceChild("rear", CubeListBuilder.create().texOffs(0, 76).addBox(-11.0F, 0.0F, 0.0F, 22.0F, 15.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -11.5F));

		PartDefinition pole = rear.addOrReplaceChild("pole", CubeListBuilder.create().texOffs(5, 85).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 12.0F));

		PartDefinition tailcontrol = rear.addOrReplaceChild("tailcontrol", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 12.0F));

		PartDefinition tail1 = tailcontrol.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(54, 1).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 0.0F, 72.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, 0.0F));

		PartDefinition tail2 = tailcontrol.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, 0.0F));

		PartDefinition tail3 = tailcontrol.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(44, 14).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 0.0F, 59.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail4 = tailcontrol.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(117, 38).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wingcontrol = topbody.addOrReplaceChild("wingcontrol", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 0.0F));

		PartDefinition rightwing = wingcontrol.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(132, 154).mirror().addBox(-32.0F, -4.0F, -2.0F, 32.0F, 24.0F, 4.0F, new CubeDeformation(0.025F)).mirror(false)
				.texOffs(194, 56).mirror().addBox(-22.0F, 15.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-17.0F, 0.0F, 0.0F));

		PartDefinition righthand = rightwing.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(0, 48).mirror().addBox(-47.0F, 0.0F, 0.0F, 47.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(88, 205).addBox(-47.0F, 28.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(118, 205).mirror().addBox(-50.0F, 0.0F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(132, 146).mirror().addBox(-47.0F, 24.0F, 0.0F, 44.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(204, 162).mirror().addBox(-3.0F, 24.0F, 0.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-32.0F, -4.0F, -2.0F));

		PartDefinition leftwing = wingcontrol.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(132, 154).addBox(0.0F, -5.0F, -2.0F, 32.0F, 24.0F, 4.0F, new CubeDeformation(0.025F))
				.texOffs(194, 56).addBox(10.0F, 14.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(17.0F, 1.0F, 0.0F));

		PartDefinition lefthand = leftwing.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(0, 48).addBox(0.0F, 0.0F, 0.0F, 47.0F, 24.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(118, 205).addBox(47.0F, 0.0F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(204, 162).addBox(0.0F, 24.0F, 0.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(132, 146).addBox(3.0F, 24.0F, 0.0F, 44.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(88, 205).addBox(44.0F, 28.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(32.0F, -5.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Pyrinos entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.pyrothos.getAllParts().forEach(ModelPart::resetPose);

		entity.idleAnimationState.updateTime(ageInTicks, 1.0F);
		if (entity.isPyrinosFlying()) {
			entity.idleAnimationState.ifStarted(state ->
				KeyframeAnimations.animate(this, PyrinosAnimation1.fly, state.getAccumulatedTime(), 1.0F, new Vector3f(1.0F, 1.0F, 1.0F))
			);
		} else {
			float walkWeight = Math.min(limbSwingAmount * 1.0F, 1.0F);
			float idleWeight = 1.0F - walkWeight;

			entity.idleAnimationState.ifStarted(state ->
				KeyframeAnimations.animate(this, PyrinosAnimation1.idle, state.getAccumulatedTime(), idleWeight, new Vector3f(1.0F, 1.0F, 1.0F))
			);
			this.animateWalk(PyrinosAnimation1.walk, limbSwing, limbSwingAmount, 4F, 1.0F);
		}

		this.animate(entity.flystartAnimationState, PyrinosAnimation1.flystart, ageInTicks, 1.0F);
		this.animate(entity.flystopAnimationState, PyrinosAnimations2.flystop, ageInTicks, 1.0F);

		this.animate(entity.flyflapAnimationState, PyrinosAnimations2.flyflap_blend, ageInTicks, 1.0F);

		this.animate(entity.flappingAnimationState, PyrinosAnimation1.flapping, ageInTicks, 1.0F);
		this.animate(entity.meleeAttackAnimationState, PyrinosAnimation1.meleeAttack, ageInTicks, 1.0F);
		this.animate(entity.shootAnimationState, PyrinosAnimation1.shoot_blend, ageInTicks, 1.0F);
		this.animate(entity.inhaleAnimationState, PyrinosAnimation1.inhale_blend, ageInTicks, 1.0F);
		this.animate(entity.blastAnimationState, PyrinosAnimation1.blast, ageInTicks, 1.0F);

		this.animate(entity.grabstartAnimationState, PyrinosAnimations2.grabstart_blend, ageInTicks, 1.0F);
		this.animate(entity.grabAnimationState, PyrinosAnimations2.grab_blend, ageInTicks, 1.0F);
		this.animate(entity.grabendAnimationState, PyrinosAnimations2.grabend_blend, ageInTicks, 1.0F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		pyrothos.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public class PyrinosAnimation1 {
		public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(8.0F).looping()
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-48.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-51.89F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(-48.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -69.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, -60.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -12.35F, 7.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 69.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, 60.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.54F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-5.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.125F, KeyframeAnimations.degreeVec(4.98F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(3.54F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(5.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-4.98F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(5.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-4.98F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(4.98F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.54F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(4.25F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.125F, KeyframeAnimations.degreeVec(-4.98F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.degreeVec(3.54F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.build();

		public static final AnimationDefinition walk = AnimationDefinition.Builder.withLength(2.0F).looping()
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(62.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(58.07F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(61.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(58.07F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(62.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -3.41F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -0.59F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -3.41F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, -0.07F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -3.41F, 3.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-51.41F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-48.07F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-51.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-48.07F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-51.41F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, -63.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, -66.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -63.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -66.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-1.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-1.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.93F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -12.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -12.0F, 8.93F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -12.0F, 5.07F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -12.0F, 8.93F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -12.0F, 5.07F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -12.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 63.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 66.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 63.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 66.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -1.21F, 3.42F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.19F, 4.1F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 2.75F, -6.55F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.SCALE, 
						new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.scaleVec(1.018F, 1.018F, 1.018F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0833F, KeyframeAnimations.scaleVec(0.9814F, 0.9814F, 0.9814F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0115F, 1.0115F, 1.0115F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.scaleVec(0.9962F, 0.9962F, 0.9962F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, -13.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, -16.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -13.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, -16.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 13.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 16.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 13.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.0F, 16.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -48.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -48.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 48.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 40.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 48.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -26.25F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(26.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(-26.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoecontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 4.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.19F, 4.1F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 2.75F, -6.55F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -5.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -0.23F, 0.14F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 4.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.SCALE, 
						new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9167F, KeyframeAnimations.scaleVec(1.0115F, 1.0115F, 1.0115F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.scaleVec(0.985F, 0.985F, 0.985F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.scaleVec(1.0192F, 1.0192F, 1.0192F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.scaleVec(0.9808F, 0.9808F, 0.9808F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.scaleVec(1.0115F, 1.0115F, 1.0115F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.scaleVec(0.9962F, 0.9962F, 0.9962F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoecontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 26.25F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(26.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(-26.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.build();
		public static final AnimationDefinition flapping = AnimationDefinition.Builder.withLength(2.0F)
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(2.9F, 4.27F, -7.22F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(11.68F, 16.4F, -31.08F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(16.8F, 24.37F, -42.71F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(21.91F, 33.68F, -50.8F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(26.63F, 44.39F, -52.85F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(29.99F, 53.83F, -49.63F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(34.0F, 66.16F, -43.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(46.63F, 109.0F, -11.83F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(49.97F, 121.42F, -0.75F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(52.33F, 131.01F, 9.15F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(53.4F, 136.62F, 16.93F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(52.84F, 137.09F, 21.69F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(50.15F, 131.2F, 23.38F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(45.39F, 119.44F, 22.92F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(31.88F, 84.4F, 17.46F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.degreeVec(13.05F, 34.55F, 7.13F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.99F, 10.48F, 1.99F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, -0.58F, -10.83F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, -1.85F, -26.67F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, -3.7F, -63.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, -2.89F, -79.17F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 9.67F, -96.05F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 38.89F, -93.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 48.56F, -90.49F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 50.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 48.56F, -90.49F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 38.89F, -93.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 16.67F, -96.67F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 3.91F, -93.95F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, -2.19F, -83.46F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, -3.7F, -63.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, -0.96F, -15.68F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, -0.27F, -6.54F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(2.9F, -4.27F, 7.22F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(11.68F, -16.4F, 31.08F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(16.8F, -24.37F, 42.71F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(21.91F, -33.68F, 50.8F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(26.63F, -44.39F, 52.85F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(29.99F, -53.83F, 49.63F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(34.0F, -66.16F, 43.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(46.63F, -109.0F, 11.83F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(49.97F, -121.43F, 0.75F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(52.33F, -131.01F, -9.15F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(53.4F, -136.62F, -16.93F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(52.84F, -137.09F, -21.69F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(50.15F, -131.2F, -23.38F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(45.39F, -119.44F, -22.92F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(31.88F, -84.4F, -17.46F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.degreeVec(13.05F, -34.55F, -7.13F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(3.99F, -10.48F, -1.99F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.58F, 10.83F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 1.85F, 26.67F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 3.7F, 63.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, 2.89F, 79.17F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, -9.67F, 96.05F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -38.89F, 93.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -48.56F, 90.49F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, -50.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, -48.56F, 90.49F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -38.89F, 93.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -16.67F, 96.67F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -3.91F, 93.95F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 2.19F, 83.46F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 3.7F, 63.33F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.0F, 0.96F, 15.68F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 0.27F, 6.54F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("wingcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-7.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-52.78F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-66.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-66.67F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(-47.81F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(-12.19F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.build();
		public static final AnimationDefinition fly = AnimationDefinition.Builder.withLength(4.0F).looping()
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-0.87F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.87F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, -3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-0.87F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.87F, -4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.87F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.87F, -4.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.87F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.87F, -4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.87F, -3.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-0.87F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.87F, -1.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-0.87F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.87F, 0.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-0.87F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.87F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.87F, 3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-0.87F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.87F, 4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-0.87F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.87F, 4.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-0.87F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.87F, 4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.87F, 3.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-0.87F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.87F, 1.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-0.87F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.0F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.0F, 4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-1.0F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(-1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.0F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-1.0F, -4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(1.0F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-1.0F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(1.0F, -4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-1.0F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(-1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(-1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(-1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(1.0F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-1.0F, 4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(1.0F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-0.87F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.87F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, 3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-0.87F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.87F, 4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.87F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.87F, 4.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.87F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.87F, 4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.87F, 3.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-0.87F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.87F, 1.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-0.87F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.87F, -0.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-0.87F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.87F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.87F, -3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-0.87F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.87F, -4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-0.87F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.87F, -4.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-0.87F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.87F, -4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.87F, -3.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-0.87F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.87F, -1.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-0.87F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.0F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.0F, -4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-1.0F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(-1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.0F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-1.0F, 4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(1.0F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-1.0F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(1.0F, 4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-1.0F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(-1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(-1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(-1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(1.0F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-1.0F, -4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(1.0F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("pyrothos", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, -0.26F, -0.97F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-0.87F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.1667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.6667F, KeyframeAnimations.degreeVec(0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9167F, KeyframeAnimations.degreeVec(-0.87F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-1.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-1.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("righttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("lefttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
						))
				.build();
		public static final AnimationDefinition meleeAttack = AnimationDefinition.Builder.withLength(2.0F).looping()
				.addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-23.19F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(24.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(25.81F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(28.43F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(24.85F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(25.42F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(23.13F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(24.87F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(23.13F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(22.37F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -6.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, 14.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 12.42F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, -4.49F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, -11.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -10.1F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, -14.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -9.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -13.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -8.27F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, -10.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, -4.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 10.72F, 4.47F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 12.0F, -7.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 12.44F, -2.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 12.0F, -4.16F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE, 
					new Keyframe(0.375F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.scaleVec(1.0096F, 1.0096F, 1.0096F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.scaleVec(0.9711F, 0.9711F, 0.9711F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0463F, 1.0463F, 1.0463F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.scaleVec(0.9519F, 0.9519F, 0.9519F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.scaleVec(1.0481F, 1.0481F, 1.0481F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.scaleVec(0.9537F, 0.9537F, 0.9537F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.scaleVec(1.0376F, 1.0376F, 1.0376F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.scaleVec(0.9711F, 0.9711F, 0.9711F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.scaleVec(1.0096F, 1.0096F, 1.0096F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.scaleVec(0.9973F, 0.9973F, 0.9973F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, -14.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, -12.42F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 4.49F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 11.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 10.1F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 14.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 9.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, 13.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 8.27F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 10.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 4.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("bone17", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.38F, 0.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-1.15F, -1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(1.86F, 1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-1.8F, -1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(1.75F, 1.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-1.8F, -1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(1.86F, 1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.83F, -1.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.5F, 1.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-1.15F, -1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("bone18", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-0.38F, -0.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.15F, 1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.86F, -1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(1.8F, 1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.75F, -1.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(1.8F, 1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-1.86F, -1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(1.83F, 1.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-1.5F, -1.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(1.15F, 1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("bone11", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.38F, 0.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-1.15F, -1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(1.86F, 1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-1.8F, -1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(1.75F, 1.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-1.8F, -1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(1.86F, 1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.83F, -1.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.5F, 1.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-1.15F, -1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("bone16", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-0.38F, -0.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.15F, 1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.86F, -1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(1.8F, 1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-1.73F, -1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.73F, 1.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.75F, -1.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(1.8F, 1.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-1.86F, -1.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(1.83F, 1.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-1.5F, -1.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(1.15F, 1.15F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-7.8498F, -2.6602F, -6.2594F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(-25.3498F, -2.6602F, -6.2594F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(9.6502F, -2.6602F, -6.2594F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

		public static final AnimationDefinition shoot_blend = AnimationDefinition.Builder.withLength(1.0F).looping()
				.addAnimation("throattop", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -10.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

			public static final AnimationDefinition inhale_blend = AnimationDefinition.Builder.withLength(2.0F).looping()
				.addAnimation("throattop", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

			public static final AnimationDefinition blast = AnimationDefinition.Builder.withLength(9.0F).looping()
				.addAnimation("throattop", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("throatbottom", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.4583F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.4583F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.4583F, KeyframeAnimations.degreeVec(80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -2.0F, 9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.posVec(0.0F, -2.0F, 9.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.posVec(0.0F, -2.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(6.33F, -52.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(3.15F, -47.67F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-18.28F, -34.29F, -0.15F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-54.32F, -17.33F, 2.57F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-71.72F, -9.17F, -0.44F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-96.33F, 4.6F, -7.36F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-96.67F, 6.3F, -4.44F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-96.38F, 5.99F, 2.46F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-95.63F, 2.81F, 7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.56F, -1.99F, 3.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-93.33F, -5.37F, -10.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-92.11F, -4.58F, -28.86F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(-91.04F, 0.52F, -39.58F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-90.29F, 6.85F, -34.35F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-90.0F, 7.32F, 6.43F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.87F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-90.0F, -7.57F, 6.65F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-90.0F, -10.74F, -16.11F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-90.0F, -7.57F, -38.78F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -47.81F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-90.0F, 7.43F, -38.05F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-90.0F, 10.37F, -15.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-90.0F, 7.24F, 6.36F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.17F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-90.0F, -7.09F, 6.23F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.125F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.25F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.375F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.6667F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.75F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.875F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9167F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0833F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.125F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.25F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.3333F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.375F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5833F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.6667F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7917F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.875F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.9583F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.0417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.125F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2917F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.375F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.4583F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.625F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7917F, KeyframeAnimations.degreeVec(-90.0F, 7.09F, 6.23F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.875F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.17F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.9583F, KeyframeAnimations.degreeVec(-90.0F, -7.24F, 6.36F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0417F, KeyframeAnimations.degreeVec(-90.0F, -10.37F, -15.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.125F, KeyframeAnimations.degreeVec(-90.0F, -7.43F, -38.05F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -47.81F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-90.0F, 7.57F, -38.78F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.375F, KeyframeAnimations.degreeVec(-90.0F, 10.74F, -16.11F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-90.0F, 7.57F, 6.65F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.5417F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 15.87F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.625F, KeyframeAnimations.degreeVec(-90.0F, -7.32F, 6.43F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 85.46F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 72.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 49.72F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, -5.93F, 20.83F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, -0.41F, 3.68F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.6F, -2.54F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 4.81F, -4.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 23.7F, -5.37F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, 27.07F, -5.14F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, 20.0F, -4.53F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 7.07F, -3.67F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.69F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 9.34F, -1.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 35.19F, -0.84F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, 64.77F, -0.23F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 70.68F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, 12.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, 12.55F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 71.74F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 82.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, 69.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, 11.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2083F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.6667F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9167F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0833F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.1667F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2083F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.25F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.3333F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4167F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5417F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5833F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.9583F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.125F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2917F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, 11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.625F, KeyframeAnimations.degreeVec(0.0F, 68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7083F, KeyframeAnimations.degreeVec(0.0F, 80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7917F, KeyframeAnimations.degreeVec(0.0F, 68.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.9583F, KeyframeAnimations.degreeVec(0.0F, 11.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, 12.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.0F, 73.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.375F, KeyframeAnimations.degreeVec(0.0F, 85.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.4583F, KeyframeAnimations.degreeVec(0.0F, 73.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.625F, KeyframeAnimations.degreeVec(0.0F, 12.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 72.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -12.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.posVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.posVec(0.0F, -12.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(6.33F, 52.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(3.15F, 47.67F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-18.28F, 34.29F, 0.15F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-54.32F, 17.33F, -2.57F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-71.72F, 9.17F, 0.44F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-96.33F, -4.6F, 7.36F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-96.67F, -6.3F, 4.44F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-96.38F, -5.99F, -2.46F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-95.63F, -2.81F, -7.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-94.56F, 1.99F, -3.75F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-93.33F, 5.37F, 10.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-92.11F, 4.58F, 28.86F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(-91.04F, -0.52F, 39.58F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-90.29F, -6.85F, 34.35F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(-90.0F, -7.32F, -6.43F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.87F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-90.0F, 7.57F, -6.65F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(-90.0F, 10.74F, 16.11F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-90.0F, 7.57F, 38.78F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 47.81F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(-90.0F, -7.43F, 38.05F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-90.0F, -10.37F, 15.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(-90.0F, -7.24F, -6.36F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.17F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-90.0F, 7.09F, -6.23F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.125F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.25F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.375F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.6667F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.75F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.875F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9167F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0417F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0833F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.125F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.25F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.3333F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.375F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5833F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.625F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.6667F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7917F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.875F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.9583F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.0417F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.125F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2917F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, -6.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.375F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.4583F, KeyframeAnimations.degreeVec(-90.0F, 7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.625F, KeyframeAnimations.degreeVec(-90.0F, -7.07F, 36.21F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7083F, KeyframeAnimations.degreeVec(-90.0F, -10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7917F, KeyframeAnimations.degreeVec(-90.0F, -7.09F, -6.23F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.875F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.17F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.9583F, KeyframeAnimations.degreeVec(-90.0F, 7.24F, -6.36F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0417F, KeyframeAnimations.degreeVec(-90.0F, 10.37F, 15.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.125F, KeyframeAnimations.degreeVec(-90.0F, 7.43F, 38.05F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2083F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 47.81F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-90.0F, -7.57F, 38.78F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.375F, KeyframeAnimations.degreeVec(-90.0F, -10.74F, 16.11F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-90.0F, -7.57F, -6.65F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.5417F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, -15.87F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.625F, KeyframeAnimations.degreeVec(-90.0F, 7.32F, -6.43F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-90.0F, 10.0F, 15.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -85.46F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -72.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -49.72F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 5.93F, -20.83F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 0.41F, -3.68F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -0.6F, 2.54F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, -4.81F, 4.2F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -23.7F, 5.37F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0.0F, -27.07F, 5.14F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.9583F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 4.53F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -7.07F, 3.67F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.69F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -9.34F, 1.7F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, -35.19F, 0.84F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(0.0F, -64.77F, 0.23F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -70.68F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, -12.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, -12.55F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -71.74F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, -82.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -69.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.degreeVec(0.0F, -11.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5833F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2083F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4167F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5417F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.6667F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.75F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.875F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9167F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0833F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.1667F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2083F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.25F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.3333F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4167F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5417F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5833F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.6667F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.9583F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.0417F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.125F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2917F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.375F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.4583F, KeyframeAnimations.degreeVec(0.0F, -11.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.625F, KeyframeAnimations.degreeVec(0.0F, -68.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7083F, KeyframeAnimations.degreeVec(0.0F, -80.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7917F, KeyframeAnimations.degreeVec(0.0F, -68.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.9583F, KeyframeAnimations.degreeVec(0.0F, -11.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.125F, KeyframeAnimations.degreeVec(0.0F, -12.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.0F, -73.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.375F, KeyframeAnimations.degreeVec(0.0F, -85.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.4583F, KeyframeAnimations.degreeVec(0.0F, -73.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.625F, KeyframeAnimations.degreeVec(0.0F, -12.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -72.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.54F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(9.0F, KeyframeAnimations.degreeVec(3.54F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 60.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 60.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.54F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(9.0F, KeyframeAnimations.degreeVec(3.54F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rear", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.7083F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.7083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("pole", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("throat", new AnimationChannel(AnimationChannel.Targets.SCALE, 
					new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.125F, KeyframeAnimations.scaleVec(1.0161F, 1.0161F, 1.0161F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.1667F, KeyframeAnimations.scaleVec(0.9832F, 0.9832F, 0.9832F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.25F, KeyframeAnimations.scaleVec(1.0179F, 1.0179F, 1.0179F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.2917F, KeyframeAnimations.scaleVec(0.9817F, 0.9817F, 0.9817F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.375F, KeyframeAnimations.scaleVec(1.0186F, 1.0186F, 1.0186F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.4167F, KeyframeAnimations.scaleVec(0.9815F, 0.9815F, 0.9815F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5F, KeyframeAnimations.scaleVec(1.0182F, 1.0182F, 1.0182F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.5417F, KeyframeAnimations.scaleVec(0.982F, 0.982F, 0.982F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.625F, KeyframeAnimations.scaleVec(1.0175F, 1.0175F, 1.0175F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.6667F, KeyframeAnimations.scaleVec(0.9826F, 0.9826F, 0.9826F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.75F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.7917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.875F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.9167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.0417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.125F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.1667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.25F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.2917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.375F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.4167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.5417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.625F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.6667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.75F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.7917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.875F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(2.9167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.0417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.125F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.1667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.25F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.2917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.375F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.4167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.5417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.625F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.6667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.75F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.7917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.875F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(3.9167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.0417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.125F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.1667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.25F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.2917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.375F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.4167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.5417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.625F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.6667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.75F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.7917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.875F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(4.9167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.0F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.0417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.125F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.1667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.25F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.2917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.375F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.4167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.5F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.5417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.625F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.6667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.75F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.7917F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.875F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(5.9167F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.0417F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.125F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.1667F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.25F, KeyframeAnimations.scaleVec(1.0174F, 1.0174F, 1.0174F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.2917F, KeyframeAnimations.scaleVec(0.9825F, 0.9825F, 0.9825F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.375F, KeyframeAnimations.scaleVec(1.018F, 1.018F, 1.018F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.4167F, KeyframeAnimations.scaleVec(0.9818F, 0.9818F, 0.9818F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.5F, KeyframeAnimations.scaleVec(1.0185F, 1.0185F, 1.0185F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.5417F, KeyframeAnimations.scaleVec(0.9814F, 0.9814F, 0.9814F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.625F, KeyframeAnimations.scaleVec(1.0183F, 1.0183F, 1.0183F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(6.7083F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("neckcontrol", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(7.2083F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(8.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

			public static final AnimationDefinition flystart = AnimationDefinition.Builder.withLength(1.5F)
					.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(44.2F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(49.55F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 4.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -61.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-0.17F, -50.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.26F, -36.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-0.31F, -35.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -45.49F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -42.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.63F, 84.57F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-0.17F, -9.97F, 75.04F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.22F, -9.92F, 70.57F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-0.27F, -2.8F, 65.81F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 24.66F, 53.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 21.61F, 47.68F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, -36.49F, 31.76F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -12.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 61.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-0.17F, 50.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.26F, 36.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-0.31F, 35.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 45.49F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 42.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, -0.63F, -84.57F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-0.17F, 9.97F, -75.04F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.22F, 9.92F, -70.57F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-0.27F, 2.8F, -65.81F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -24.66F, -53.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, -21.61F, -47.68F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.0F, 36.49F, -31.76F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, -6.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 26.67F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 79.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 96.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 8.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 7.78F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("pyrothos", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -4.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 6.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -26.67F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -79.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -96.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, 6.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, -26.67F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, -79.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, -96.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 8.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 7.78F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, -6.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 26.67F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0.0F, 79.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(0.0F, 96.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("wingcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.build();

				public static final AnimationDefinition flyblast = AnimationDefinition.Builder.withLength(9.0F).looping()
					.addAnimation("throattop", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("throatbottom", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("head2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.degreeVec(80.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.87F, -0.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-0.87F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.87F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, -3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-0.87F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.87F, -4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.87F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.87F, -4.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.87F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.87F, -4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -3.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(1.32F, -1.22F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-2.97F, -3.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-19.67F, -8.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-26.85F, -13.81F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-36.71F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-42.14F, -15.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(-31.96F, -13.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-40.44F, -11.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-30.01F, -10.58F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(-39.92F, -9.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-30.21F, -8.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5F, KeyframeAnimations.degreeVec(-33.29F, -7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-39.59F, -7.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-37.24F, -7.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(-30.67F, -6.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-32.25F, -6.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-39.01F, -6.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(-38.21F, -5.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-31.36F, -5.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-31.36F, -5.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(-38.21F, -5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-39.01F, -5.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-32.25F, -5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0F, KeyframeAnimations.degreeVec(-30.67F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-37.24F, -5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-39.59F, -5.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(-33.29F, -5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-30.21F, -5.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.25F, KeyframeAnimations.degreeVec(-39.92F, -5.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-30.01F, -6.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-39.99F, -7.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5F, KeyframeAnimations.degreeVec(-30.08F, -7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-39.79F, -8.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(-36.71F, -9.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.6667F, KeyframeAnimations.degreeVec(-30.41F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-32.76F, -10.58F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.75F, KeyframeAnimations.degreeVec(-39.33F, -11.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-37.75F, -11.79F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-30.99F, -12.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-31.79F, -13.05F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9167F, KeyframeAnimations.degreeVec(-38.64F, -13.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-38.64F, -14.35F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(-31.79F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0417F, KeyframeAnimations.degreeVec(-30.99F, -15.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0833F, KeyframeAnimations.degreeVec(-37.75F, -16.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.125F, KeyframeAnimations.degreeVec(-39.33F, -16.95F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-32.76F, -17.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-30.41F, -18.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.25F, KeyframeAnimations.degreeVec(-36.71F, -18.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-39.79F, -19.42F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.375F, KeyframeAnimations.degreeVec(-30.08F, -20.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-39.99F, -21.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-30.01F, -22.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.625F, KeyframeAnimations.degreeVec(-39.92F, -23.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-30.21F, -23.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.75F, KeyframeAnimations.degreeVec(-33.29F, -24.24F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7917F, KeyframeAnimations.degreeVec(-39.59F, -24.47F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.8333F, KeyframeAnimations.degreeVec(-37.24F, -24.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.875F, KeyframeAnimations.degreeVec(-30.67F, -24.81F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-32.25F, -24.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9583F, KeyframeAnimations.degreeVec(-39.01F, -24.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0F, KeyframeAnimations.degreeVec(-38.21F, -25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0417F, KeyframeAnimations.degreeVec(-31.36F, -24.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0833F, KeyframeAnimations.degreeVec(-31.36F, -24.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.125F, KeyframeAnimations.degreeVec(-38.21F, -24.81F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.1667F, KeyframeAnimations.degreeVec(-39.01F, -24.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-32.25F, -24.47F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.25F, KeyframeAnimations.degreeVec(-30.67F, -24.24F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2917F, KeyframeAnimations.degreeVec(-37.24F, -23.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.3333F, KeyframeAnimations.degreeVec(-39.59F, -23.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.375F, KeyframeAnimations.degreeVec(-33.29F, -23.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4167F, KeyframeAnimations.degreeVec(-30.21F, -22.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5F, KeyframeAnimations.degreeVec(-39.92F, -22.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5833F, KeyframeAnimations.degreeVec(-30.01F, -21.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.6667F, KeyframeAnimations.degreeVec(-39.99F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.75F, KeyframeAnimations.degreeVec(-30.08F, -18.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.8333F, KeyframeAnimations.degreeVec(-39.79F, -17.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.875F, KeyframeAnimations.degreeVec(-36.71F, -16.95F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9167F, KeyframeAnimations.degreeVec(-30.41F, -16.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9583F, KeyframeAnimations.degreeVec(-32.76F, -15.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(-39.33F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0417F, KeyframeAnimations.degreeVec(-37.75F, -14.35F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0833F, KeyframeAnimations.degreeVec(-30.99F, -13.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(-31.79F, -13.05F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.1667F, KeyframeAnimations.degreeVec(-38.64F, -12.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2083F, KeyframeAnimations.degreeVec(-38.64F, -11.79F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.25F, KeyframeAnimations.degreeVec(-31.79F, -11.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-30.99F, -10.58F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.3333F, KeyframeAnimations.degreeVec(-37.75F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.375F, KeyframeAnimations.degreeVec(-39.33F, -9.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4167F, KeyframeAnimations.degreeVec(-32.76F, -8.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-30.41F, -8.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5F, KeyframeAnimations.degreeVec(-36.71F, -7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5417F, KeyframeAnimations.degreeVec(-39.79F, -7.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.625F, KeyframeAnimations.degreeVec(-30.08F, -6.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-39.99F, -6.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7917F, KeyframeAnimations.degreeVec(-30.01F, -5.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.875F, KeyframeAnimations.degreeVec(-39.92F, -5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9583F, KeyframeAnimations.degreeVec(-30.21F, -5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0F, KeyframeAnimations.degreeVec(-33.29F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0417F, KeyframeAnimations.degreeVec(-39.59F, -5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0833F, KeyframeAnimations.degreeVec(-37.24F, -5.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.125F, KeyframeAnimations.degreeVec(-30.67F, -5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.1667F, KeyframeAnimations.degreeVec(-32.25F, -5.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.degreeVec(-39.01F, -5.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.25F, KeyframeAnimations.degreeVec(-38.21F, -5.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2917F, KeyframeAnimations.degreeVec(-31.36F, -6.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.3333F, KeyframeAnimations.degreeVec(-31.36F, -6.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.375F, KeyframeAnimations.degreeVec(-38.21F, -6.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4167F, KeyframeAnimations.degreeVec(-39.01F, -7.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4583F, KeyframeAnimations.degreeVec(-32.25F, -7.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5F, KeyframeAnimations.degreeVec(-30.67F, -7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5417F, KeyframeAnimations.degreeVec(-37.69F, -8.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5833F, KeyframeAnimations.degreeVec(-41.09F, -9.36F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.625F, KeyframeAnimations.degreeVec(-35.37F, -10.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.6667F, KeyframeAnimations.degreeVec(-32.38F, -10.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7083F, KeyframeAnimations.degreeVec(-38.2F, -11.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.degreeVec(-39.92F, -11.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.8333F, KeyframeAnimations.degreeVec(-20.86F, -8.35F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.9167F, KeyframeAnimations.degreeVec(-12.46F, -3.6F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.9583F, KeyframeAnimations.degreeVec(-5.04F, -1.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0417F, KeyframeAnimations.degreeVec(2.87F, 0.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.2083F, KeyframeAnimations.degreeVec(-0.5F, -1.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.3333F, KeyframeAnimations.degreeVec(0.87F, -2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5833F, KeyframeAnimations.degreeVec(0.87F, -3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-0.87F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.8333F, KeyframeAnimations.degreeVec(0.87F, -4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.9583F, KeyframeAnimations.degreeVec(-0.87F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.0F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.0F, 4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-1.0F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(-1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-0.97F, -3.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.22F, -3.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.33F, -3.71F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.95F, -9.12F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-3.0F, -12.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9167F, KeyframeAnimations.degreeVec(2.26F, -15.42F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.88F, -18.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-4.33F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(5.03F, -20.82F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-1.84F, -20.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(-2.72F, -20.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.1667F, KeyframeAnimations.degreeVec(5.11F, -19.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-3.86F, -19.1F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(3.83F, -17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-4.92F, -17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(2.5F, -16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4167F, KeyframeAnimations.degreeVec(1.71F, -15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-4.7F, -15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5F, KeyframeAnimations.degreeVec(4.33F, -14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-0.87F, -13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-3.21F, -12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(5.0F, -11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-3.21F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-0.87F, -8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(4.33F, -7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-4.7F, -6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(1.71F, -5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(2.5F, -3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-4.92F, -2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(3.83F, -1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-3.83F, 1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(4.92F, 2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(-2.5F, 3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-1.71F, 5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(4.7F, 6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.25F, KeyframeAnimations.degreeVec(-4.33F, 7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.87F, 8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(3.21F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(-5.0F, 11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4167F, KeyframeAnimations.degreeVec(3.21F, 12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.87F, 13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5F, KeyframeAnimations.degreeVec(-4.33F, 14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(4.7F, 15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-1.71F, 15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(-2.5F, 16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.6667F, KeyframeAnimations.degreeVec(4.92F, 17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-3.83F, 17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(3.83F, 18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-4.92F, 19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(2.5F, 19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9167F, KeyframeAnimations.degreeVec(1.71F, 19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-4.7F, 19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(4.33F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0417F, KeyframeAnimations.degreeVec(-0.87F, 19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0833F, KeyframeAnimations.degreeVec(-3.21F, 19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.125F, KeyframeAnimations.degreeVec(5.0F, 19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-3.21F, 19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-0.87F, 18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.25F, KeyframeAnimations.degreeVec(4.33F, 18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-4.7F, 17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.3333F, KeyframeAnimations.degreeVec(1.71F, 17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.375F, KeyframeAnimations.degreeVec(2.5F, 16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-4.92F, 15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4583F, KeyframeAnimations.degreeVec(3.83F, 15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-3.83F, 13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5833F, KeyframeAnimations.degreeVec(4.92F, 12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.625F, KeyframeAnimations.degreeVec(-2.5F, 11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.6667F, KeyframeAnimations.degreeVec(-1.71F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7083F, KeyframeAnimations.degreeVec(4.7F, 8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.75F, KeyframeAnimations.degreeVec(-4.33F, 7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.87F, 6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.8333F, KeyframeAnimations.degreeVec(3.21F, 5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.875F, KeyframeAnimations.degreeVec(-5.0F, 3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9167F, KeyframeAnimations.degreeVec(3.21F, 2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9583F, KeyframeAnimations.degreeVec(0.87F, 1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0F, KeyframeAnimations.degreeVec(-4.33F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0417F, KeyframeAnimations.degreeVec(4.7F, -1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0833F, KeyframeAnimations.degreeVec(-1.71F, -2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.125F, KeyframeAnimations.degreeVec(-2.5F, -3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.1667F, KeyframeAnimations.degreeVec(4.92F, -5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-3.83F, -6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2917F, KeyframeAnimations.degreeVec(3.83F, -8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.3333F, KeyframeAnimations.degreeVec(-4.92F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.375F, KeyframeAnimations.degreeVec(2.5F, -11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4167F, KeyframeAnimations.degreeVec(1.71F, -12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4583F, KeyframeAnimations.degreeVec(-4.7F, -13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5F, KeyframeAnimations.degreeVec(4.33F, -14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-0.87F, -15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5833F, KeyframeAnimations.degreeVec(-3.21F, -15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.625F, KeyframeAnimations.degreeVec(5.0F, -16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.6667F, KeyframeAnimations.degreeVec(-3.21F, -17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.7083F, KeyframeAnimations.degreeVec(-0.87F, -17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.75F, KeyframeAnimations.degreeVec(4.33F, -18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.7917F, KeyframeAnimations.degreeVec(-4.7F, -18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.8333F, KeyframeAnimations.degreeVec(1.71F, -19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.875F, KeyframeAnimations.degreeVec(2.5F, -19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9167F, KeyframeAnimations.degreeVec(-4.92F, -19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9583F, KeyframeAnimations.degreeVec(3.83F, -19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0417F, KeyframeAnimations.degreeVec(-3.83F, -19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0833F, KeyframeAnimations.degreeVec(4.92F, -19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(-2.5F, -19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.1667F, KeyframeAnimations.degreeVec(-1.71F, -19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2083F, KeyframeAnimations.degreeVec(4.7F, -18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.25F, KeyframeAnimations.degreeVec(-4.33F, -18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.87F, -17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.3333F, KeyframeAnimations.degreeVec(3.21F, -17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.375F, KeyframeAnimations.degreeVec(-5.0F, -16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4167F, KeyframeAnimations.degreeVec(3.21F, -15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4583F, KeyframeAnimations.degreeVec(0.87F, -15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5F, KeyframeAnimations.degreeVec(-4.33F, -14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5417F, KeyframeAnimations.degreeVec(4.7F, -13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5833F, KeyframeAnimations.degreeVec(-1.71F, -12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.625F, KeyframeAnimations.degreeVec(-2.5F, -11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.6667F, KeyframeAnimations.degreeVec(4.92F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-3.83F, -8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7917F, KeyframeAnimations.degreeVec(3.83F, -6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.8333F, KeyframeAnimations.degreeVec(-4.92F, -5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.875F, KeyframeAnimations.degreeVec(2.5F, -3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9167F, KeyframeAnimations.degreeVec(1.71F, -2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9583F, KeyframeAnimations.degreeVec(-4.7F, -1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0F, KeyframeAnimations.degreeVec(4.33F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0417F, KeyframeAnimations.degreeVec(-0.87F, 1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0833F, KeyframeAnimations.degreeVec(-3.21F, 2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.125F, KeyframeAnimations.degreeVec(5.0F, 3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.1667F, KeyframeAnimations.degreeVec(-3.21F, 5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.degreeVec(-0.87F, 6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.25F, KeyframeAnimations.degreeVec(4.33F, 7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2917F, KeyframeAnimations.degreeVec(-4.7F, 8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.3333F, KeyframeAnimations.degreeVec(1.71F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.375F, KeyframeAnimations.degreeVec(2.5F, 11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4167F, KeyframeAnimations.degreeVec(-4.92F, 12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4583F, KeyframeAnimations.degreeVec(3.83F, 13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5417F, KeyframeAnimations.degreeVec(-3.86F, 15.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5833F, KeyframeAnimations.degreeVec(5.11F, 16.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.625F, KeyframeAnimations.degreeVec(-2.72F, 17.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.6667F, KeyframeAnimations.degreeVec(-1.84F, 18.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7083F, KeyframeAnimations.degreeVec(5.03F, 18.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.degreeVec(-4.33F, 18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7917F, KeyframeAnimations.degreeVec(0.88F, 17.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.8333F, KeyframeAnimations.degreeVec(2.26F, 15.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.875F, KeyframeAnimations.degreeVec(-3.0F, 12.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.9167F, KeyframeAnimations.degreeVec(0.95F, 9.36F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0417F, KeyframeAnimations.degreeVec(-1.33F, 4.12F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.125F, KeyframeAnimations.degreeVec(1.22F, 3.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.2083F, KeyframeAnimations.degreeVec(-0.97F, 4.57F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.2917F, KeyframeAnimations.degreeVec(1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.375F, KeyframeAnimations.degreeVec(-1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.4583F, KeyframeAnimations.degreeVec(1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.625F, KeyframeAnimations.degreeVec(1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7917F, KeyframeAnimations.degreeVec(1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.875F, KeyframeAnimations.degreeVec(-1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.9583F, KeyframeAnimations.degreeVec(1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.87F, 0.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-0.87F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.87F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, 3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-0.87F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.87F, 4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.87F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0.87F, 4.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.87F, 4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.87F, 4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 3.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(1.32F, 1.22F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(-2.97F, 3.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-19.67F, 8.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-26.85F, 13.81F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-36.71F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-42.14F, 15.2F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(-31.96F, 13.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-40.44F, 11.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(-30.01F, 10.58F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(-39.92F, 9.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-30.21F, 8.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5F, KeyframeAnimations.degreeVec(-33.29F, 7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-39.59F, 7.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-37.24F, 7.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(-30.67F, 6.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-32.25F, 6.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-39.01F, 6.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(-38.21F, 5.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-31.36F, 5.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(-31.36F, 5.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(-38.21F, 5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-39.01F, 5.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-32.25F, 5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0F, KeyframeAnimations.degreeVec(-30.67F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-37.24F, 5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(-39.59F, 5.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(-33.29F, 5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-30.21F, 5.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.25F, KeyframeAnimations.degreeVec(-39.92F, 5.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(-30.01F, 6.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4167F, KeyframeAnimations.degreeVec(-39.99F, 7.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5F, KeyframeAnimations.degreeVec(-30.08F, 7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-39.79F, 8.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(-36.71F, 9.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.6667F, KeyframeAnimations.degreeVec(-30.41F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-32.76F, 10.58F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.75F, KeyframeAnimations.degreeVec(-39.33F, 11.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(-37.75F, 11.79F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-30.99F, 12.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-31.79F, 13.05F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9167F, KeyframeAnimations.degreeVec(-38.64F, 13.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-38.64F, 14.35F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(-31.79F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0417F, KeyframeAnimations.degreeVec(-30.99F, 15.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0833F, KeyframeAnimations.degreeVec(-37.75F, 16.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.125F, KeyframeAnimations.degreeVec(-39.33F, 16.95F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-32.76F, 17.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-30.41F, 18.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.25F, KeyframeAnimations.degreeVec(-36.71F, 18.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-39.79F, 19.42F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.375F, KeyframeAnimations.degreeVec(-30.08F, 20.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4583F, KeyframeAnimations.degreeVec(-39.99F, 21.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-30.01F, 22.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.625F, KeyframeAnimations.degreeVec(-39.92F, 23.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7083F, KeyframeAnimations.degreeVec(-30.21F, 23.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.75F, KeyframeAnimations.degreeVec(-33.29F, 24.24F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7917F, KeyframeAnimations.degreeVec(-39.59F, 24.47F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.8333F, KeyframeAnimations.degreeVec(-37.24F, 24.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.875F, KeyframeAnimations.degreeVec(-30.67F, 24.81F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9167F, KeyframeAnimations.degreeVec(-32.25F, 24.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9583F, KeyframeAnimations.degreeVec(-39.01F, 24.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0F, KeyframeAnimations.degreeVec(-38.21F, 25.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0417F, KeyframeAnimations.degreeVec(-31.36F, 24.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0833F, KeyframeAnimations.degreeVec(-31.36F, 24.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.125F, KeyframeAnimations.degreeVec(-38.21F, 24.81F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.1667F, KeyframeAnimations.degreeVec(-39.01F, 24.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-32.25F, 24.47F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.25F, KeyframeAnimations.degreeVec(-30.67F, 24.24F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2917F, KeyframeAnimations.degreeVec(-37.24F, 23.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.3333F, KeyframeAnimations.degreeVec(-39.59F, 23.66F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.375F, KeyframeAnimations.degreeVec(-33.29F, 23.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4167F, KeyframeAnimations.degreeVec(-30.21F, 22.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5F, KeyframeAnimations.degreeVec(-39.92F, 22.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5833F, KeyframeAnimations.degreeVec(-30.01F, 21.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.6667F, KeyframeAnimations.degreeVec(-39.99F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.75F, KeyframeAnimations.degreeVec(-30.08F, 18.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.8333F, KeyframeAnimations.degreeVec(-39.79F, 17.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.875F, KeyframeAnimations.degreeVec(-36.71F, 16.95F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9167F, KeyframeAnimations.degreeVec(-30.41F, 16.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9583F, KeyframeAnimations.degreeVec(-32.76F, 15.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(-39.33F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0417F, KeyframeAnimations.degreeVec(-37.75F, 14.35F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0833F, KeyframeAnimations.degreeVec(-30.99F, 13.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(-31.79F, 13.05F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.1667F, KeyframeAnimations.degreeVec(-38.64F, 12.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2083F, KeyframeAnimations.degreeVec(-38.64F, 11.79F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.25F, KeyframeAnimations.degreeVec(-31.79F, 11.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2917F, KeyframeAnimations.degreeVec(-30.99F, 10.58F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.3333F, KeyframeAnimations.degreeVec(-37.75F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.375F, KeyframeAnimations.degreeVec(-39.33F, 9.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4167F, KeyframeAnimations.degreeVec(-32.76F, 8.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4583F, KeyframeAnimations.degreeVec(-30.41F, 8.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5F, KeyframeAnimations.degreeVec(-36.71F, 7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5417F, KeyframeAnimations.degreeVec(-39.79F, 7.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.625F, KeyframeAnimations.degreeVec(-30.08F, 6.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-39.99F, 6.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7917F, KeyframeAnimations.degreeVec(-30.01F, 5.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.875F, KeyframeAnimations.degreeVec(-39.92F, 5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9583F, KeyframeAnimations.degreeVec(-30.21F, 5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0F, KeyframeAnimations.degreeVec(-33.29F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0417F, KeyframeAnimations.degreeVec(-39.59F, 5.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0833F, KeyframeAnimations.degreeVec(-37.24F, 5.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.125F, KeyframeAnimations.degreeVec(-30.67F, 5.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.1667F, KeyframeAnimations.degreeVec(-32.25F, 5.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.degreeVec(-39.01F, 5.53F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.25F, KeyframeAnimations.degreeVec(-38.21F, 5.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2917F, KeyframeAnimations.degreeVec(-31.36F, 6.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.3333F, KeyframeAnimations.degreeVec(-31.36F, 6.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.375F, KeyframeAnimations.degreeVec(-38.21F, 6.69F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4167F, KeyframeAnimations.degreeVec(-39.01F, 7.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4583F, KeyframeAnimations.degreeVec(-32.25F, 7.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5F, KeyframeAnimations.degreeVec(-30.67F, 7.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5417F, KeyframeAnimations.degreeVec(-37.69F, 8.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5833F, KeyframeAnimations.degreeVec(-41.09F, 9.36F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.625F, KeyframeAnimations.degreeVec(-35.37F, 10.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.6667F, KeyframeAnimations.degreeVec(-32.38F, 10.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7083F, KeyframeAnimations.degreeVec(-38.2F, 11.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.degreeVec(-39.92F, 11.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.8333F, KeyframeAnimations.degreeVec(-20.86F, 8.35F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.9167F, KeyframeAnimations.degreeVec(-12.46F, 3.6F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.9583F, KeyframeAnimations.degreeVec(-5.04F, 1.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0417F, KeyframeAnimations.degreeVec(2.87F, -0.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.2083F, KeyframeAnimations.degreeVec(-0.5F, 1.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.3333F, KeyframeAnimations.degreeVec(0.87F, 2.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5833F, KeyframeAnimations.degreeVec(0.87F, 3.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-0.87F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.8333F, KeyframeAnimations.degreeVec(0.87F, 4.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.9583F, KeyframeAnimations.degreeVec(-0.87F, 4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.0F, -4.99F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.0F, -4.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-1.0F, -4.73F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.0F, 0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, 0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.0F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(-1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-0.97F, 3.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.22F, 3.38F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.33F, 3.71F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0.95F, 9.12F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-3.0F, 12.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9167F, KeyframeAnimations.degreeVec(2.26F, 15.42F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(0.88F, 18.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(-4.33F, 20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(5.03F, 20.82F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-1.84F, 20.93F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(-2.72F, 20.54F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.1667F, KeyframeAnimations.degreeVec(5.11F, 19.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-3.86F, 19.1F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(3.83F, 17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(-4.92F, 17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(2.5F, 16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4167F, KeyframeAnimations.degreeVec(1.71F, 15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(-4.7F, 15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5F, KeyframeAnimations.degreeVec(4.33F, 14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-0.87F, 13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.degreeVec(-3.21F, 12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(5.0F, 11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-3.21F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-0.87F, 8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.75F, KeyframeAnimations.degreeVec(4.33F, 7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(-4.7F, 6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(1.71F, 5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(2.5F, 3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9167F, KeyframeAnimations.degreeVec(-4.92F, 2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(3.83F, 1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-3.83F, -1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(4.92F, -2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(-2.5F, -3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.1667F, KeyframeAnimations.degreeVec(-1.71F, -5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(4.7F, -6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.25F, KeyframeAnimations.degreeVec(-4.33F, -7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(0.87F, -8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(3.21F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(-5.0F, -11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4167F, KeyframeAnimations.degreeVec(3.21F, -12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(0.87F, -13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5F, KeyframeAnimations.degreeVec(-4.33F, -14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(4.7F, -15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(-1.71F, -15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(-2.5F, -16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.6667F, KeyframeAnimations.degreeVec(4.92F, -17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-3.83F, -17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(3.83F, -18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(-4.92F, -19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(2.5F, -19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9167F, KeyframeAnimations.degreeVec(1.71F, -19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-4.7F, -19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(4.33F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0417F, KeyframeAnimations.degreeVec(-0.87F, -19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0833F, KeyframeAnimations.degreeVec(-3.21F, -19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.125F, KeyframeAnimations.degreeVec(5.0F, -19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.1667F, KeyframeAnimations.degreeVec(-3.21F, -19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2083F, KeyframeAnimations.degreeVec(-0.87F, -18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.25F, KeyframeAnimations.degreeVec(4.33F, -18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2917F, KeyframeAnimations.degreeVec(-4.7F, -17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.3333F, KeyframeAnimations.degreeVec(1.71F, -17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.375F, KeyframeAnimations.degreeVec(2.5F, -16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4167F, KeyframeAnimations.degreeVec(-4.92F, -15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4583F, KeyframeAnimations.degreeVec(3.83F, -15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5417F, KeyframeAnimations.degreeVec(-3.83F, -13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5833F, KeyframeAnimations.degreeVec(4.92F, -12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.625F, KeyframeAnimations.degreeVec(-2.5F, -11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.6667F, KeyframeAnimations.degreeVec(-1.71F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7083F, KeyframeAnimations.degreeVec(4.7F, -8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.75F, KeyframeAnimations.degreeVec(-4.33F, -7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7917F, KeyframeAnimations.degreeVec(0.87F, -6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.8333F, KeyframeAnimations.degreeVec(3.21F, -5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.875F, KeyframeAnimations.degreeVec(-5.0F, -3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9167F, KeyframeAnimations.degreeVec(3.21F, -2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9583F, KeyframeAnimations.degreeVec(0.87F, -1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0F, KeyframeAnimations.degreeVec(-4.33F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0417F, KeyframeAnimations.degreeVec(4.7F, 1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0833F, KeyframeAnimations.degreeVec(-1.71F, 2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.125F, KeyframeAnimations.degreeVec(-2.5F, 3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.1667F, KeyframeAnimations.degreeVec(4.92F, 5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2083F, KeyframeAnimations.degreeVec(-3.83F, 6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2917F, KeyframeAnimations.degreeVec(3.83F, 8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.3333F, KeyframeAnimations.degreeVec(-4.92F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.375F, KeyframeAnimations.degreeVec(2.5F, 11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4167F, KeyframeAnimations.degreeVec(1.71F, 12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4583F, KeyframeAnimations.degreeVec(-4.7F, 13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5F, KeyframeAnimations.degreeVec(4.33F, 14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5417F, KeyframeAnimations.degreeVec(-0.87F, 15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5833F, KeyframeAnimations.degreeVec(-3.21F, 15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.625F, KeyframeAnimations.degreeVec(5.0F, 16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.6667F, KeyframeAnimations.degreeVec(-3.21F, 17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.7083F, KeyframeAnimations.degreeVec(-0.87F, 17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.75F, KeyframeAnimations.degreeVec(4.33F, 18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.7917F, KeyframeAnimations.degreeVec(-4.7F, 18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.8333F, KeyframeAnimations.degreeVec(1.71F, 19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.875F, KeyframeAnimations.degreeVec(2.5F, 19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9167F, KeyframeAnimations.degreeVec(-4.92F, 19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9583F, KeyframeAnimations.degreeVec(3.83F, 19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0417F, KeyframeAnimations.degreeVec(-3.83F, 19.96F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0833F, KeyframeAnimations.degreeVec(4.92F, 19.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.125F, KeyframeAnimations.degreeVec(-2.5F, 19.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.1667F, KeyframeAnimations.degreeVec(-1.71F, 19.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2083F, KeyframeAnimations.degreeVec(4.7F, 18.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.25F, KeyframeAnimations.degreeVec(-4.33F, 18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2917F, KeyframeAnimations.degreeVec(0.87F, 17.94F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.3333F, KeyframeAnimations.degreeVec(3.21F, 17.32F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.375F, KeyframeAnimations.degreeVec(-5.0F, 16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4167F, KeyframeAnimations.degreeVec(3.21F, 15.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4583F, KeyframeAnimations.degreeVec(0.87F, 15.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5F, KeyframeAnimations.degreeVec(-4.33F, 14.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5417F, KeyframeAnimations.degreeVec(4.7F, 13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5833F, KeyframeAnimations.degreeVec(-1.71F, 12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.625F, KeyframeAnimations.degreeVec(-2.5F, 11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.6667F, KeyframeAnimations.degreeVec(4.92F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7083F, KeyframeAnimations.degreeVec(-3.83F, 8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7917F, KeyframeAnimations.degreeVec(3.83F, 6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.8333F, KeyframeAnimations.degreeVec(-4.92F, 5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.875F, KeyframeAnimations.degreeVec(2.5F, 3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9167F, KeyframeAnimations.degreeVec(1.71F, 2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9583F, KeyframeAnimations.degreeVec(-4.7F, 1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0F, KeyframeAnimations.degreeVec(4.33F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0417F, KeyframeAnimations.degreeVec(-0.87F, -1.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0833F, KeyframeAnimations.degreeVec(-3.21F, -2.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.125F, KeyframeAnimations.degreeVec(5.0F, -3.9F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.1667F, KeyframeAnimations.degreeVec(-3.21F, -5.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.degreeVec(-0.87F, -6.43F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.25F, KeyframeAnimations.degreeVec(4.33F, -7.65F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2917F, KeyframeAnimations.degreeVec(-4.7F, -8.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.3333F, KeyframeAnimations.degreeVec(1.71F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.375F, KeyframeAnimations.degreeVec(2.5F, -11.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4167F, KeyframeAnimations.degreeVec(-4.92F, -12.18F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4583F, KeyframeAnimations.degreeVec(3.83F, -13.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5417F, KeyframeAnimations.degreeVec(-3.86F, -15.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5833F, KeyframeAnimations.degreeVec(5.11F, -16.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.625F, KeyframeAnimations.degreeVec(-2.72F, -17.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.6667F, KeyframeAnimations.degreeVec(-1.84F, -18.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7083F, KeyframeAnimations.degreeVec(5.03F, -18.72F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.75F, KeyframeAnimations.degreeVec(-4.33F, -18.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7917F, KeyframeAnimations.degreeVec(0.88F, -17.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.8333F, KeyframeAnimations.degreeVec(2.26F, -15.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.875F, KeyframeAnimations.degreeVec(-3.0F, -12.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.9167F, KeyframeAnimations.degreeVec(0.95F, -9.36F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0417F, KeyframeAnimations.degreeVec(-1.33F, -4.12F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.125F, KeyframeAnimations.degreeVec(1.22F, -3.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.2083F, KeyframeAnimations.degreeVec(-0.97F, -4.57F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.2917F, KeyframeAnimations.degreeVec(1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.375F, KeyframeAnimations.degreeVec(-1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.4583F, KeyframeAnimations.degreeVec(1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.625F, KeyframeAnimations.degreeVec(1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7917F, KeyframeAnimations.degreeVec(1.0F, -1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.875F, KeyframeAnimations.degreeVec(-1.0F, -0.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.9583F, KeyframeAnimations.degreeVec(1.0F, -0.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 60.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, 60.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7083F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("pole", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.75F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(9.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("throat", new AnimationChannel(AnimationChannel.Targets.SCALE, 
						new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4167F, KeyframeAnimations.scaleVec(1.0161F, 1.0161F, 1.0161F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.scaleVec(0.9832F, 0.9832F, 0.9832F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.scaleVec(1.0183F, 1.0183F, 1.0183F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5833F, KeyframeAnimations.scaleVec(0.9814F, 0.9814F, 0.9814F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.6667F, KeyframeAnimations.scaleVec(1.018F, 1.018F, 1.018F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.scaleVec(0.9825F, 0.9825F, 0.9825F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.8333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.1667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.1667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.6667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.1667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.2917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.3333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.4583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.5833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.6667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.7917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.8333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.9583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.0833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.1667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.2917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.3333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.4583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.5833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.6667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.7083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.7917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.8333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(5.9583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.0833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.1667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.2917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.3333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.4583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.5833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.6667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.7917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.8333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(6.9583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0417F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.0833F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.1667F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2083F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.2917F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.3333F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4167F, KeyframeAnimations.scaleVec(1.0173F, 1.0173F, 1.0173F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.4583F, KeyframeAnimations.scaleVec(0.9827F, 0.9827F, 0.9827F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5417F, KeyframeAnimations.scaleVec(1.0175F, 1.0175F, 1.0175F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5833F, KeyframeAnimations.scaleVec(0.982F, 0.982F, 0.982F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.6667F, KeyframeAnimations.scaleVec(1.0186F, 1.0186F, 1.0186F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.7083F, KeyframeAnimations.scaleVec(0.9817F, 0.9817F, 0.9817F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("neckcontrol", new AnimationChannel(AnimationChannel.Targets.POSITION, 
						new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(7.5F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.build();

				
	}
	
	public class PyrinosAnimations2 {
		public static final AnimationDefinition flystop = AnimationDefinition.Builder.withLength(1.0F)
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("topbody", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -2.0F, 3.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 90.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -12.0F, 7.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 65.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 6.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("pyrothos", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -4.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 10.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -4.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail4", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -90.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 6.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 4.0F, -2.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe3", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("tailcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(1.0F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("wingcontrol", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

			public static final AnimationDefinition grabstart_blend = AnimationDefinition.Builder.withLength(0.5F)
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("rightfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftfoot", new AnimationChannel(AnimationChannel.Targets.POSITION, 
					new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 36.56F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

			public static final AnimationDefinition grab_blend = AnimationDefinition.Builder.withLength(0.5F)
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 36.56F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

			public static final AnimationDefinition grabend_blend = AnimationDefinition.Builder.withLength(0.5F)
				.addAnimation("rightleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("righttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("leftleg", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe1", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 36.56F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.addAnimation("lefttoe2", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
				))
				.build();

				public static final AnimationDefinition flyflap_blend = AnimationDefinition.Builder.withLength(3.9583F)
					.addAnimation("leftwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -6.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-0.48F, -4.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, 16.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-0.29F, 12.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-0.87F, -28.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.86F, -28.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.87F, -19.57F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-0.96F, 21.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.99F, 33.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-0.87F, 22.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(-0.04F, -28.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-0.93F, -32.55F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-0.91F, -32.37F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.89F, -20.74F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 25.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.87F, 28.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, 23.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.87F, -12.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, -16.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-0.87F, -16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, -11.22F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-0.87F, 6.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.87F, 7.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-0.87F, 5.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.87F, 6.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-0.87F, 5.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.87F, 4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-0.87F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.87F, 3.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-0.87F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.87F, 2.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-0.87F, 2.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("lefthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.0F, 6.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.0F, 7.01F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-1.0F, 2.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(1.0F, -8.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.0F, -18.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.0F, -18.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, -4.27F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(1.0F, 20.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, 42.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, 47.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-1.0F, 27.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.0F, -10.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.0F, -46.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, -63.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.0F, -49.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.0F, -11.27F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(-1.0F, 33.84F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.0F, 63.79F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.0F, 63.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.0F, 34.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.0F, -11.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.0F, -49.36F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-1.0F, -63.01F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(1.0F, -46.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-1.0F, -10.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(1.0F, 27.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-1.0F, 46.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(1.0F, 41.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(-1.0F, 18.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(1.0F, -7.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-1.0F, -22.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(1.0F, -22.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-1.0F, -13.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(1.0F, -3.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(-1.0F, 1.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(1.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-1.0F, -2.92F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(1.0F, -0.84F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-1.0F, 1.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(1.0F, 2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(-1.0F, 2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(1.0F, 3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-1.0F, 3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(1.0F, 4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-1.0F, 4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(1.0F, 4.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-1.0F, 3.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(1.0F, 5.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("rightwing", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.87F, 1.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-0.87F, 6.08F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.87F, 6.46F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 1.82F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.87F, -16.26F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-0.87F, -12.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9167F, KeyframeAnimations.degreeVec(-0.87F, 28.28F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(-0.87F, 28.97F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.87F, 19.57F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -28.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(0.87F, -33.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.87F, -33.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4167F, KeyframeAnimations.degreeVec(-0.87F, -22.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 28.7F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-0.87F, 32.55F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-0.87F, 32.37F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(0.87F, 20.74F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -25.98F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.87F, -28.86F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(0.0F, -23.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.3333F, KeyframeAnimations.degreeVec(0.87F, 12.83F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(0.0F, 16.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4167F, KeyframeAnimations.degreeVec(-0.87F, 16.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 11.22F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.6667F, KeyframeAnimations.degreeVec(-0.87F, -6.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.8333F, KeyframeAnimations.degreeVec(0.87F, -7.8F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(-0.87F, -5.11F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0833F, KeyframeAnimations.degreeVec(0.87F, -6.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-0.87F, -5.13F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.3333F, KeyframeAnimations.degreeVec(0.87F, -4.33F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(-0.87F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5833F, KeyframeAnimations.degreeVec(0.87F, -3.04F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-0.87F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.8333F, KeyframeAnimations.degreeVec(0.87F, -2.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(-0.87F, -2.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.addAnimation("righthand", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.0F, -6.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.125F, KeyframeAnimations.degreeVec(1.0F, -7.01F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-1.0F, -2.31F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.2917F, KeyframeAnimations.degreeVec(1.0F, 8.06F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.375F, KeyframeAnimations.degreeVec(-1.0F, 18.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.4583F, KeyframeAnimations.degreeVec(1.0F, 18.52F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-1.0F, 4.27F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.625F, KeyframeAnimations.degreeVec(1.0F, -20.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-1.0F, -42.91F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.7917F, KeyframeAnimations.degreeVec(1.0F, -47.61F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.875F, KeyframeAnimations.degreeVec(-1.0F, -27.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(0.9583F, KeyframeAnimations.degreeVec(1.0F, 10.17F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-1.0F, 46.87F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.125F, KeyframeAnimations.degreeVec(1.0F, 63.23F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2083F, KeyframeAnimations.degreeVec(-1.0F, 49.62F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.2917F, KeyframeAnimations.degreeVec(1.0F, 11.27F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.375F, KeyframeAnimations.degreeVec(-1.0F, -33.84F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.4583F, KeyframeAnimations.degreeVec(1.0F, -63.79F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.5417F, KeyframeAnimations.degreeVec(-1.0F, -63.85F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.625F, KeyframeAnimations.degreeVec(1.0F, -34.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7083F, KeyframeAnimations.degreeVec(-1.0F, 11.03F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.7917F, KeyframeAnimations.degreeVec(1.0F, 49.36F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.875F, KeyframeAnimations.degreeVec(-1.0F, 63.01F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(1.9583F, KeyframeAnimations.degreeVec(1.0F, 46.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.0417F, KeyframeAnimations.degreeVec(-1.0F, 10.29F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.125F, KeyframeAnimations.degreeVec(1.0F, -27.07F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2083F, KeyframeAnimations.degreeVec(-1.0F, -46.59F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.2917F, KeyframeAnimations.degreeVec(1.0F, -41.25F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.375F, KeyframeAnimations.degreeVec(-1.0F, -18.19F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.4583F, KeyframeAnimations.degreeVec(1.0F, 7.44F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.5417F, KeyframeAnimations.degreeVec(-1.0F, 22.41F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.625F, KeyframeAnimations.degreeVec(1.0F, 22.56F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7083F, KeyframeAnimations.degreeVec(-1.0F, 13.09F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.7917F, KeyframeAnimations.degreeVec(1.0F, 3.02F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.875F, KeyframeAnimations.degreeVec(-1.0F, -1.63F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(2.9583F, KeyframeAnimations.degreeVec(1.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.0417F, KeyframeAnimations.degreeVec(-1.0F, 2.92F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.125F, KeyframeAnimations.degreeVec(1.0F, 0.84F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2083F, KeyframeAnimations.degreeVec(-1.0F, -1.75F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.2917F, KeyframeAnimations.degreeVec(1.0F, -2.21F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.375F, KeyframeAnimations.degreeVec(-1.0F, -2.78F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.4583F, KeyframeAnimations.degreeVec(1.0F, -3.3F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.5417F, KeyframeAnimations.degreeVec(-1.0F, -3.76F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.625F, KeyframeAnimations.degreeVec(1.0F, -4.16F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7083F, KeyframeAnimations.degreeVec(-1.0F, -4.48F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.7917F, KeyframeAnimations.degreeVec(1.0F, -4.14F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.875F, KeyframeAnimations.degreeVec(-1.0F, -3.34F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(3.9583F, KeyframeAnimations.degreeVec(1.0F, -5.88F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
						new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
					))
					.build();

	}

	@Override
	public ModelPart root() {
		return this.pyrothos;
	}
}