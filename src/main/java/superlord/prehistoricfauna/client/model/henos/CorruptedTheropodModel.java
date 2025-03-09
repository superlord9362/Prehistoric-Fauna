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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.henos.CorruptedTheropod;

@SuppressWarnings("unused")
public class CorruptedTheropodModel extends EntityModel<CorruptedTheropod> {
	private final ModelPart Body;
	private final ModelPart Gem;
	private final ModelPart Ribs;
	private final ModelPart R_rib;
	private final ModelPart L_rib;
	private final ModelPart HeadandNeck;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Jaw1;
	private final ModelPart Head2;
	private final ModelPart Jaw2;
	private final ModelPart Head3;
	private final ModelPart Jaw3;
	private final ModelPart Head4;
	private final ModelPart Jaw4;
	private final ModelPart Head5;
	private final ModelPart Jaw5;
	private final ModelPart Head6;
	private final ModelPart Jaw6;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public CorruptedTheropodModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Gem = this.Body.getChild("Gem");
		this.Ribs = this.Body.getChild("Ribs");
		this.R_rib = this.Ribs.getChild("R_rib");
		this.L_rib = this.Ribs.getChild("L_rib");
		this.HeadandNeck = this.Body.getChild("HeadandNeck");
		this.Neck = this.HeadandNeck.getChild("Neck");
		this.Head1 = this.HeadandNeck.getChild("Head1");
		this.Jaw1 = this.Head1.getChild("Jaw1");
		this.Head2 = this.HeadandNeck.getChild("Head2");
		this.Jaw2 = this.Head2.getChild("Jaw2");
		this.Head3 = this.HeadandNeck.getChild("Head3");
		this.Jaw3 = this.Head3.getChild("Jaw3");
		this.Head4 = this.HeadandNeck.getChild("Head4");
		this.Jaw4 = this.Head4.getChild("Jaw4");
		this.Head5 = this.HeadandNeck.getChild("Head5");
		this.Jaw5 = this.Head5.getChild("Jaw5");
		this.Head6 = this.HeadandNeck.getChild("Head6");
		this.Jaw6 = this.Head6.getChild("Jaw6");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -18.0F, -45.0F, 26.0F, 32.0F, 63.0F, new CubeDeformation(0.0F))
				.texOffs(0, 96).addBox(-4.0F, -22.0F, -40.0F, 8.0F, 4.0F, 47.0F, new CubeDeformation(0.0F))
				.texOffs(110, 145).addBox(0.0F, -25.0F, -39.0F, 0.0F, 3.0F, 44.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -25.0F, -4.0F));

		PartDefinition Gem = Body.addOrReplaceChild("Gem", CubeListBuilder.create().texOffs(0, 0).addBox(5.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(5.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(1.0F, -4.0F, 0.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(1.0F, 1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 6).addBox(-4.0F, -2.0F, 0.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(-4.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 0).addBox(-8.0F, -1.0F, 0.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 1).addBox(-8.0F, 4.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 12).addBox(-9.0F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, -25.0F, 0.5236F, -1.0472F, 0.0F));

		
		PartDefinition Ribs = Body.addOrReplaceChild("Ribs", CubeListBuilder.create().texOffs(178, 55).addBox(-22.0F, -80.0F, -30.0F, 26.0F, 0.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(156, 240).addBox(-22.0F, -80.0F, -7.0F, 26.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 243).addBox(-22.0F, -80.0F, -30.0F, 26.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(320, 9).addBox(4.0F, -80.0F, -30.0F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(320, 9).mirror().addBox(-22.0F, -80.0F, -30.0F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(108, 310).mirror().addBox(-22.0F, -69.0F, -30.0F, 26.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, 83.0F, -8.0F));

		PartDefinition R_rib = Ribs.addOrReplaceChild("R_rib", CubeListBuilder.create().texOffs(136, 192).mirror().addBox(0.0F, 0.0F, -13.0F, 0.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(-23, 328).mirror().addBox(-13.0F, 12.0F, -13.0F, 13.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -80.0F, -17.0F));

		PartDefinition L_rib = Ribs.addOrReplaceChild("L_rib", CubeListBuilder.create().texOffs(136, 192).addBox(0.0F, 0.0F, -12.0F, 0.0F, 12.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(-23, 328).addBox(0.0F, 12.0F, -12.0F, 13.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(-22.0F, -80.0F, -18.0F));

		PartDefinition HeadandNeck = Body.addOrReplaceChild("HeadandNeck", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -38.0F));

		PartDefinition Neck = HeadandNeck.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(178, 0).addBox(-8.0F, -24.0F, -18.0F, 16.0F, 36.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Head1 = HeadandNeck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(180, 271).addBox(-4.5F, -7.0F, -10.0F, 9.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(232, 98).addBox(-3.5F, -6.0F, -26.0F, 7.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(228, 216).addBox(-3.5F, -2.0F, -26.0F, 7.0F, 5.0F, 16.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-7.5F, -10.0F, -10.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(228, 237).addBox(-3.0F, 5.0F, -26.0F, 7.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(292, 129).addBox(-3.0F, 0.0F, -26.0F, 7.0F, 5.0F, 16.0F, new CubeDeformation(-0.02F))
				.texOffs(82, 265).addBox(-4.0F, 0.0F, -10.0F, 9.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.0F, 0.0F));

		PartDefinition Head2 = HeadandNeck.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(238, 152).addBox(-4.5F, -11.0F, -12.0F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 272).addBox(-2.5F, -11.0F, -23.0F, 5.0F, 9.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(178, 78).addBox(-2.5F, -13.0F, -17.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(178, 86).addBox(-2.5F, -8.0F, -27.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(96, 246).addBox(-2.5F, -2.0F, -27.0F, 5.0F, 2.0F, 17.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(-6.5F, 9.0F, -12.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition Jaw2 = Head2.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(180, 252).addBox(-1.0F, 0.0F, -27.0F, 5.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(42, 263).addBox(-1.0F, -1.0F, -27.0F, 5.0F, 2.0F, 15.0F, new CubeDeformation(-0.02F))
				.texOffs(0, 255).addBox(-3.0F, 0.0F, -12.0F, 9.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.0F, 0.0F));

		PartDefinition Head3 = HeadandNeck.addOrReplaceChild("Head3", CubeListBuilder.create().texOffs(248, 0).addBox(-2.0F, -8.0F, -10.0F, 12.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(230, 176).addBox(0.0F, -6.0F, -24.0F, 8.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(248, 19).addBox(0.0F, 2.0F, -24.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.02F)), PartPose.offset(-1.0F, -4.0F, -18.0F));

		PartDefinition Jaw3 = Head3.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(52, 244).addBox(0.0F, 2.0F, -24.0F, 8.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(250, 78).addBox(0.0F, -1.0F, -24.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(-0.02F))
				.texOffs(248, 36).addBox(-2.0F, 0.0F, -10.0F, 12.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head4 = HeadandNeck.addOrReplaceChild("Head4", CubeListBuilder.create().texOffs(201, 274).addBox(-2.0F, -4.0F, -17.0F, 5.0F, 6.0F, 18.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 11.0F, -13.0F));

		PartDefinition Jaw4 = Head4.addOrReplaceChild("Jaw4", CubeListBuilder.create().texOffs(173, 287).addBox(-6.0F, 0.0F, -21.0F, 5.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 4.0F));

		PartDefinition Head5 = HeadandNeck.addOrReplaceChild("Head5", CubeListBuilder.create().texOffs(220, 255).addBox(-5.0F, -8.0F, -10.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(182, 192).addBox(-5.0F, -8.0F, -24.0F, 10.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(232, 118).addBox(-5.0F, 2.0F, -24.0F, 10.0F, 2.0F, 14.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(8.0F, -5.0F, -9.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Jaw5 = Head5.addOrReplaceChild("Jaw5", CubeListBuilder.create().texOffs(108, 227).addBox(0.0F, 2.0F, -24.0F, 10.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(230, 198).addBox(0.0F, -1.0F, -24.0F, 10.0F, 3.0F, 14.0F, new CubeDeformation(-0.02F))
				.texOffs(260, 255).addBox(0.0F, 0.0F, -10.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition Head6 = HeadandNeck.addOrReplaceChild("Head6", CubeListBuilder.create().texOffs(182, 216).addBox(-1.0F, -4.0F, -18.0F, 5.0F, 6.0F, 18.0F, new CubeDeformation(0.02F)), PartPose.offsetAndRotation(4.0F, 8.0F, -9.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition Jaw6 = Head6.addOrReplaceChild("Jaw6", CubeListBuilder.create().texOffs(62, 222).addBox(-1.0F, 0.0F, -18.0F, 5.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(110, 96).addBox(-2.0F, -8.0F, -3.0F, 12.0F, 16.0F, 33.0F, new CubeDeformation(0.0F))
				.texOffs(62, 192).addBox(-2.0F, 8.0F, 5.0F, 12.0F, 5.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -9.0F, 18.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(198, 176).addBox(-4.0F, 4.0F, 1.0F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 147).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 9.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -1.0F, 30.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(200, 98).addBox(-2.0F, -5.0F, -8.0F, 7.0F, 29.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(53, 350).addBox(-8.0F, 21.0F, -8.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(105, 358).addBox(-8.0F, 18.0F, -8.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 7.0F, -31.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(200, 98).mirror().addBox(-5.0F, -5.0F, -8.0F, 7.0F, 29.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(105, 358).mirror().addBox(5.0F, 18.0F, -8.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(53, 350).mirror().addBox(2.0F, 21.0F, -8.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 7.0F, -31.0F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 192).mirror().addBox(-6.5F, -9.0F, -10.0F, 12.0F, 32.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.5F, -27.0F, -4.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(140, 252).mirror().addBox(-4.5F, 19.0F, -6.0F, 9.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(88, 167).mirror().addBox(-2.5F, 19.0F, -3.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(198, 145).mirror().addBox(-4.5F, -1.0F, -6.0F, 9.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(88, 147).mirror().addBox(1.0F, 23.0F, -6.0F, 0.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(295, -10).mirror().addBox(-2.5F, 7.0F, -16.0F, 0.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(88, 167).mirror().addBox(-2.5F, 19.0F, -3.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(88, 147).mirror().addBox(-2.0F, 23.0F, -6.0F, 0.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 8.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(200, 78).mirror().addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(200, 136).mirror().addBox(-4.5F, 0.0F, -14.0F, 9.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 34.0F, -3.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 192).addBox(-5.5F, -9.0F, -10.0F, 12.0F, 32.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(12.5F, -27.0F, -4.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(88, 147).addBox(2.0F, 23.0F, -6.0F, 0.0F, 9.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(198, 145).addBox(-4.5F, -1.0F, -6.0F, 9.0F, 20.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(140, 252).addBox(-4.5F, 19.0F, -6.0F, 9.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(88, 167).addBox(-2.5F, 19.0F, -3.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(295, -10).addBox(2.5F, 8.0F, -16.0F, 0.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(88, 167).addBox(-2.5F, 19.0F, -3.0F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 147).addBox(-1.0F, 23.0F, -6.0F, 0.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 8.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(200, 78).addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(200, 136).addBox(-4.5F, 0.0F, -14.0F, 9.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 34.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}


	@Override
	public void setupAnim(CorruptedTheropod entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.8f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (!entity.isAwake()) {
			if (sleepProgress != 0 && entity.getEntityData().get(CorruptedTheropod.SLEEP_TICK) > 0) {
				this.HeadandNeck.xRot = Mth.lerp(sleepProgress, 0, 0.8203047484373349F);
				this.HeadandNeck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.HeadandNeck.zRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.04434609527920614F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8726646259971648F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317007977318F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.5235987755982988F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.17453292519943295F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.44434609527920614F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 1.3264502315156905F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 1.0878637547259988F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.296705972839036F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317007977318F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2792526803190927F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);	
				this.Body.y = Mth.lerp(sleepProgress, -25, -1.6F);
				this.RightArm.x = Mth.lerp(sleepProgress, 13, 11);
				this.Tail1.x = Mth.lerp(sleepProgress, -4, -1);
				this.Tail2.z = Mth.lerp(sleepProgress, 30, 28F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -27, 1);
				this.LeftThigh.z = Mth.lerp(sleepProgress, -4, 3);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 13, 22);
				this.RightThigh.x = Mth.lerp(sleepProgress, 12.5F, 7);
				this.RightThigh.y = Mth.lerp(sleepProgress, -27, 1);
				this.RightThigh.z = Mth.lerp(sleepProgress, -4, 2);
				this.RightLeg.y = Mth.lerp(sleepProgress, 13, 22);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(CorruptedTheropod.SLEEP_TICK) > 0) {
				this.HeadandNeck.xRot = Mth.lerp(sleepProgress, 0.8203047484373349F, 0);
				this.HeadandNeck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.HeadandNeck.zRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.04434609527920614F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.8726646259971648F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.6981317007977318F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.5235987755982988F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.17453292519943295F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.44434609527920614F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 1.3264502315156905F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 1.0878637547259988F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.296705972839036F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.6981317007977318F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2792526803190927F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);	
				this.Body.y = Mth.lerp(sleepProgress, -1.6F, -25);
				this.RightArm.x = Mth.lerp(sleepProgress, 11, 13);
				this.Tail1.x = Mth.lerp(sleepProgress, -1, -4);
				this.Tail2.z = Mth.lerp(sleepProgress, 28F, 30);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 1, -27);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 3, -4);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 22, 13);
				this.RightThigh.x = Mth.lerp(sleepProgress, 7, 12.5F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 1, -27);
				this.RightThigh.z = Mth.lerp(sleepProgress, 2, -4);
				this.RightLeg.y = Mth.lerp(sleepProgress, 22, 13);
			} else {
				this.Body.xRot = (Math.abs(-0.025F * Mth.cos(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount);
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = -Mth.abs(Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount) + 0.05F;
				this.LeftFoot.xRot = Mth.abs(Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * -0.8F * limbSwingAmount);
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount - 0.05F;
				this.RightLeg.xRot = -Mth.abs(Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount) + 0.05F;
				this.RightFoot.xRot = Mth.abs(Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.8F * limbSwingAmount);
				this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.RightArm.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.HeadandNeck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(70F);
				this.HeadandNeck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
				if (entity.getFirstPassenger() != null) {
					this.Jaw3.xRot = 0.25F;
				}
				if (entity.isDoingHeadOneAttack() || entity.isDoingAllHeadAttack()) {
					this.Head1.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
					this.Jaw1.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				}
				if (entity.isDoingHeadTwoAttack() || entity.isDoingAllHeadAttack()) {
					this.Head2.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
					this.Jaw2.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				}
				if (entity.isDoingHeadThreeAttack() || entity.isDoingAllHeadAttack()) {
					this.Head3.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
					this.Jaw3.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				}
				if (entity.isDoingHeadFourAttack() || entity.isDoingAllHeadAttack()) {
					this.Head4.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
					this.Jaw4.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				}
				if (entity.isDoingHeadFiveAttack() || entity.isDoingAllHeadAttack()) {
					this.Head5.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
					this.Jaw5.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				}
				if (entity.isDoingHeadSixAttack() || entity.isDoingAllHeadAttack()) {
					this.Head6.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
					this.Jaw6.xRot = -0.025F * Mth.cos(0.15F * ageInTicks / 3) + 0.025F + attackProgress * (float) Math.toRadians(30F);
				}
			}
		}
		this.Gem.y = Mth.sin(0.2F * ageInTicks / 5) + 9;
	}

	public void resetModel() {
		this.Jaw3.xRot = 0;
		this.HeadandNeck.xRot = 0;
		this.HeadandNeck.yRot = -0;
		this.HeadandNeck.zRot = 0;
		this.RightFoot.xRot = 0;
		this.RightLeg.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.Body.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.Body.y = -25F;
		this.RightArm.x = 13;
		this.Tail1.x = -4;
		this.Tail2.z = 30;
		this.LeftThigh.y = -27;
		this.LeftThigh.z = -4;
		this.LeftLeg.y = 13;
		this.RightThigh.x = 12.5F;
		this.RightThigh.y = -27F;
		this.RightThigh.z = -4;
		this.RightLeg.y = 13;
	}

	public void sleepPose() {
		this.HeadandNeck.xRot = 0.8203047484373349F;
		this.HeadandNeck.yRot = -0.3490658503988659F;
		this.HeadandNeck.zRot = -0.10471975511965977F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightLeg.xRot = -0.8726646259971648F;
		this.Tail2.xRot = 0.04434609527920614F;
		this.Tail2.yRot = 0.41887902047863906F;
		this.LeftLeg.xRot = -0.8726646259971648F;
		this.LeftThigh.xRot = -0.6981317007977318F;
		this.LeftThigh.yRot = 0.5235987755982988F;
		this.Body.xRot = -0.17453292519943295F;
		this.Tail1.xRot = -0.44434609527920614F;
		this.Tail1.yRot = 0.593411945678072F;
		this.LeftArm.xRot = 1.3264502315156905F;
		this.LeftArm.yRot = -0.13962634015954636F;
		this.RightArm.xRot = 1.0878637547259988F;
		this.RightArm.yRot = 0.296705972839036F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightThigh.xRot = -0.6981317007977318F;
		this.RightThigh.yRot = -0.2792526803190927F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.Body.y = -1.6F;
		this.RightArm.x = 11;
		this.Tail1.x = -1;
		this.Tail2.z = 28F;
		this.LeftThigh.y = 1;
		this.LeftThigh.z = 3;
		this.LeftLeg.y = 22;
		this.RightThigh.x = 7;
		this.RightThigh.y = 1;
		this.RightThigh.z = 2;
		this.RightLeg.y = 22;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}