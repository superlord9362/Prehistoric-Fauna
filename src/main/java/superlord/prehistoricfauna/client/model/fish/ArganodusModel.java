package superlord.prehistoricfauna.client.model.fish;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fish.ArganodusEntity;

/**
 * Arganodus - CrimesAgainstArt
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ArganodusModel extends EntityModel<ArganodusEntity> {
    public ModelRenderer FrontTorso;
    public ModelRenderer Face;
    public ModelRenderer LeftFrontFin;
    public ModelRenderer BackTorso;
    public ModelRenderer RightFrontFin;
    public ModelRenderer LeftBackFin;
    public ModelRenderer Tail;
    public ModelRenderer TailFin;
    public ModelRenderer RightBackFin;

    public ArganodusModel() {
        this.textureWidth = 76;
        this.textureHeight = 50;
        this.RightFrontFin = new ModelRenderer(this, 35, 0);
        this.RightFrontFin.mirror = true;
        this.RightFrontFin.setRotationPoint(-2.0F, 1.5F, 3.0F);
        this.RightFrontFin.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFrontFin, 0.0F, 0.0F, -0.3490658503988659F);
        this.TailFin = new ModelRenderer(this, 1, 19);
        this.TailFin.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.TailFin.addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.BackTorso = new ModelRenderer(this, 0, 21);
        this.BackTorso.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.BackTorso.addBox(-1.5F, -2.5F, 0.0F, 3.0F, 5.0F, 7.0F, 0.01F, 0.01F, 0.01F);
        this.LeftBackFin = new ModelRenderer(this, 44, 0);
        this.LeftBackFin.setRotationPoint(1.5F, 1.5F, 2.0F);
        this.LeftBackFin.addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftBackFin, 0.0F, 0.0F, 0.3490658503988659F);
        this.RightBackFin = new ModelRenderer(this, 44, 0);
        this.RightBackFin.mirror = true;
        this.RightBackFin.setRotationPoint(-1.5F, 1.5F, 2.0F);
        this.RightBackFin.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightBackFin, 0.0F, 0.0F, -0.3490658503988659F);
        this.LeftFrontFin = new ModelRenderer(this, 35, 0);
        this.LeftFrontFin.setRotationPoint(2.0F, 1.5F, 3.0F);
        this.LeftFrontFin.addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFrontFin, 0.0F, 0.0F, 0.3490658503988659F);
        this.Tail = new ModelRenderer(this, 19, 18);
        this.Tail.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail.addBox(-1.0F, -1.5F, 0.0F, 2.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Face = new ModelRenderer(this, 22, 0);
        this.Face.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Face.addBox(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.FrontTorso = new ModelRenderer(this, 0, 0);
        this.FrontTorso.setRotationPoint(0.0F, 21.5F, -10.0F);
        this.FrontTorso.addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.FrontTorso.addChild(this.RightFrontFin);
        this.BackTorso.addChild(this.TailFin);
        this.FrontTorso.addChild(this.BackTorso);
        this.BackTorso.addChild(this.LeftBackFin);
        this.BackTorso.addChild(this.RightBackFin);
        this.FrontTorso.addChild(this.LeftFrontFin);
        this.BackTorso.addChild(this.Tail);
        this.FrontTorso.addChild(this.Face);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.FrontTorso).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ArganodusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }
        this.FrontTorso.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.FrontTorso.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
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
