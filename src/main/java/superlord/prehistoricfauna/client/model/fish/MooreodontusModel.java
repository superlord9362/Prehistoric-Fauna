package superlord.prehistoricfauna.client.model.fish;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fish.MooreodontusEntity;

/**
 * Mooreodontus - CrimesAgainstArt
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class MooreodontusModel extends EntityModel<MooreodontusEntity> {
    public ModelRenderer Head;
    public ModelRenderer FrontTorso;
    public ModelRenderer SpikeFin;
    public ModelRenderer LeftPectoralFin;
    public ModelRenderer BackTorso;
    public ModelRenderer RightPectoralFin;
    public ModelRenderer LeftPelvicFin;
    public ModelRenderer BackFins;
    public ModelRenderer Tail;
    public ModelRenderer RightPelvicFin;

    public MooreodontusModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.SpikeFin = new ModelRenderer(this, 0, 13);
        this.SpikeFin.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.SpikeFin.addBox(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.BackTorso = new ModelRenderer(this, 0, 8);
        this.BackTorso.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.BackTorso.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 33, -6);
        this.Tail.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.Tail.addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.RightPelvicFin = new ModelRenderer(this, 0, 27);
        this.RightPelvicFin.setRotationPoint(-0.5F, 2.0F, 1.0F);
        this.RightPelvicFin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.FrontTorso = new ModelRenderer(this, 0, 0);
        this.FrontTorso.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FrontTorso.addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 5.0F, 0.01F, 0.01F, 0.01F);
        this.RightPectoralFin = new ModelRenderer(this, 0, 26);
        this.RightPectoralFin.setRotationPoint(-2.0F, 1.0F, 0.0F);
        this.RightPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightPectoralFin, 0.0F, -0.3490658503988659F, 0.0F);
        this.BackFins = new ModelRenderer(this, 0, 17);
        this.BackFins.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.BackFins.addBox(0.0F, -2.0F, 0.0F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftPelvicFin = new ModelRenderer(this, 0, 27);
        this.LeftPelvicFin.setRotationPoint(0.5F, 2.0F, 1.0F);
        this.LeftPelvicFin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftPectoralFin = new ModelRenderer(this, 0, 26);
        this.LeftPectoralFin.setRotationPoint(2.0F, 1.0F, 0.0F);
        this.LeftPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftPectoralFin, 0.0F, 0.3490658503988659F, 0.0F);
        this.Head = new ModelRenderer(this, 18, 0);
        this.Head.setRotationPoint(0.0F, 22.0F, -6.0F);
        this.Head.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.FrontTorso.addChild(this.SpikeFin);
        this.FrontTorso.addChild(this.BackTorso);
        this.BackTorso.addChild(this.Tail);
        this.BackTorso.addChild(this.RightPelvicFin);
        this.Head.addChild(this.FrontTorso);
        this.FrontTorso.addChild(this.RightPectoralFin);
        this.BackTorso.addChild(this.BackFins);
        this.BackTorso.addChild(this.LeftPelvicFin);
        this.FrontTorso.addChild(this.LeftPectoralFin);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(MooreodontusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.BackTorso.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
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
