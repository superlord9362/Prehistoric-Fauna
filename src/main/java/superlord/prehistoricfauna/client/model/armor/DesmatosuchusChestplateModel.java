package superlord.prehistoricfauna.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("rawtypes")
@OnlyIn(Dist.CLIENT)
public class DesmatosuchusChestplateModel extends HumanoidModel {
	
	public DesmatosuchusChestplateModel(ModelPart p_170677_) {
		super(p_170677_);
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        
        PartDefinition Chest = body.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 11.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(4.0F, 0.0F, -2.0F));

		PartDefinition backshell = Chest.addOrReplaceChild("backshell", CubeListBuilder.create().texOffs(2, 18).addBox(-4.5F, -1.0F, -0.5F, 9.0F, 11.0F, 1.0F, new CubeDeformation(1.0F)), PartPose.offset(-4.0F, 0.0F, 4.0F));

		PartDefinition details = backshell.addOrReplaceChild("details", CubeListBuilder.create().texOffs(3, 44).mirror().addBox(-9.5F, -2.7F, 0.5F, 19.0F, 16.0F, 0.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition back_spikes_L = backshell.addOrReplaceChild("back_spikes_L", CubeListBuilder.create().texOffs(34, 19).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 2.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition back_spikes_R = backshell.addOrReplaceChild("back_spikes_R", CubeListBuilder.create().texOffs(24, 19).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 2.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition RArm = rightArm.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition RArm_spikes = RArm.addOrReplaceChild("RArm_spikes", CubeListBuilder.create().texOffs(2, 30).mirror().addBox(-5.5F, -5.5F, -1.0F, 4.0F, 7.0F, 2.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LArm = leftArm.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(40, 0).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition LArm_spikes = LArm.addOrReplaceChild("LArm_spikes", CubeListBuilder.create().texOffs(16, 30).addBox(1.25F, -5.35F, -1.0F, 4.0F, 8.0F, 2.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

}
