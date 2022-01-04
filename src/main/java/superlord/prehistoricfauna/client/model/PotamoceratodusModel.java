package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.PotamoceratodusEntity;

/**
 * Potamoceratodus - Seally+Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PotamoceratodusModel extends EntityModel<PotamoceratodusEntity> {
    public ModelRenderer Torso;
    public ModelRenderer Hip;
    public ModelRenderer LPectoral;
    public ModelRenderer RPectoral;
    public ModelRenderer Snoot;
    public ModelRenderer Tailstock;
    public ModelRenderer LPelvic;
    public ModelRenderer RPelvic;
    public ModelRenderer Caudal;

    public PotamoceratodusModel() {
        this.textureWidth = 76;
        this.textureHeight = 50;
        this.Snoot = new ModelRenderer(this, 24, 0);
        this.Snoot.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Snoot.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tailstock = new ModelRenderer(this, 19, 17);
        this.Tailstock.setRotationPoint(0.0F, -0.5F, 9.0F);
        this.Tailstock.addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LPelvic = new ModelRenderer(this, 42, 0);
        this.LPelvic.setRotationPoint(1.5F, 0.5F, 4.0F);
        this.LPelvic.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LPelvic, 0.0F, 0.0F, 0.5235987755982988F);
        this.Caudal = new ModelRenderer(this, 2, 17);
        this.Caudal.setRotationPoint(0.0F, -1.0F, -6.0F);
        this.Caudal.addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Hip = new ModelRenderer(this, 0, 18);
        this.Hip.setRotationPoint(0.0F, 1.5F, 10.0F);
        this.Hip.addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.RPelvic = new ModelRenderer(this, 42, 0);
        this.RPelvic.setRotationPoint(-1.5F, 0.5F, 4.0F);
        this.RPelvic.addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RPelvic, 0.0F, 0.0F, 2.6179938779914944F);
        this.Torso = new ModelRenderer(this, 0, 0);
        this.Torso.setRotationPoint(0.0F, 21.0F, -10.0F);
        this.Torso.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.RPectoral = new ModelRenderer(this, 32, 0);
        this.RPectoral.setRotationPoint(-1.5F, 2.0F, 3.0F);
        this.RPectoral.addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RPectoral, 0.0F, 0.0F, 2.792526803190927F);
        this.LPectoral = new ModelRenderer(this, 32, 0);
        this.LPectoral.setRotationPoint(1.5F, 2.0F, 3.0F);
        this.LPectoral.addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LPectoral, 0.0F, 0.0F, 0.3490658503988659F);
        this.Torso.addChild(this.Snoot);
        this.Hip.addChild(this.Tailstock);
        this.Hip.addChild(this.LPelvic);
        this.Tailstock.addChild(this.Caudal);
        this.Torso.addChild(this.Hip);
        this.Hip.addChild(this.RPelvic);
        this.Torso.addChild(this.RPectoral);
        this.Torso.addChild(this.LPectoral);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Torso).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PotamoceratodusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }
        this.Torso.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Torso.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.Hip.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
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
