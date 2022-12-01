package superlord.prehistoricfauna.common.items.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * AetosaurArmor - Ralof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DesmatosuchusChestplateModel extends BipedModel<LivingEntity> {
    public ModelRenderer Chest;
    public ModelRenderer RArm;
    public ModelRenderer LArm;
    public ModelRenderer backshell;
    public ModelRenderer RArm_spikes;
    public ModelRenderer LArm_spikes;
    public ModelRenderer details;
    public ModelRenderer back_spikes_L;
    public ModelRenderer back_spikes_R;

    public DesmatosuchusChestplateModel(float size) {
    	super(size);
    	this.textureWidth = 64;
        this.textureHeight = 64;
        this.RArm = new ModelRenderer(this, 24, 0);
        this.RArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.01F, 1.01F, 1.01F);
        this.LArm_spikes = new ModelRenderer(this, 16, 30);
        this.LArm_spikes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LArm_spikes.addBox(2.0F, -4.0F, -1.0F, 4.0F, 7.9F, 2.0F, 1.01F, 1.01F, 1.01F);
        this.Chest = new ModelRenderer(this, 0, 0);
        this.Chest.setRotationPoint(-4.0F, 0.0F, -2.0F);
        this.Chest.addBox(0.0F, 0.0F, 0.0F, 8.0F, 11.0F, 4.0F, 1.0F, 1.0F, 1.0F);
        this.LArm = new ModelRenderer(this, 40, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.01F, 1.01F, 1.01F);
        this.RArm_spikes = new ModelRenderer(this, 2, 30);
        this.RArm_spikes.mirror = true;
        this.RArm_spikes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RArm_spikes.addBox(-6.0F, -4.0F, -1.0F, 4.0F, 7.9F, 2.0F, 1.01F, 1.01F, 1.01F);
        this.backshell = new ModelRenderer(this, 2, 18);
        this.backshell.setRotationPoint(4.0F, 0.0F, 4.0F);
        this.backshell.addBox(-4.5F, -1.0F, -0.5F, 9.0F, 11.0F, 1.0F, 1.0F, 1.0F, 1.0F);
        this.details = new ModelRenderer(this, 3, 44);
        this.details.mirror = true;
        this.details.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.details.addBox(-9.5F, -2.7F, 0.5F, 19.0F, 16.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.back_spikes_R = new ModelRenderer(this, 24, 19);
        this.back_spikes_R.mirror = true;
        this.back_spikes_R.setRotationPoint(-6.0F, 0.0F, 2.0F);
        this.back_spikes_R.addBox(0.0F, -1.0F, 0.0F, 5.0F, 11.0F, 0.0F, 1.0F, 1.0F, 0.0F);
        this.setRotateAngle(back_spikes_R, 0.0F, -2.356194490192345F, 0.0F);
        this.back_spikes_L = new ModelRenderer(this, 34, 19);
        this.back_spikes_L.mirror = true;
        this.back_spikes_L.setRotationPoint(6.0F, 0.0F, 2.0F);
        this.back_spikes_L.addBox(0.0F, -1.0F, 0.0F, 5.0F, 11.0F, 0.0F, 1.0F, 1.0F, 0.0F);
        this.setRotateAngle(back_spikes_L, 0.0F, -0.7853981633974483F, 0.0F);
        this.LArm.addChild(this.LArm_spikes);
        this.RArm.addChild(this.RArm_spikes);
        this.Chest.addChild(this.backshell);
        this.backshell.addChild(this.details);
        this.backshell.addChild(this.back_spikes_R);
        this.backshell.addChild(this.back_spikes_L);
        this.bipedBody.addChild(this.Chest);
        this.bipedLeftArm.addChild(this.LArm);
        this.bipedRightArm.addChild(this.RArm);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
    
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
