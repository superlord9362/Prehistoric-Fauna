package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;

/**
 * Telmasaurus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TelmasaurusSleepingModel extends EntityModel<TelmasaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Frontlegright;
    public ModelRenderer Frontlegleft;
    public ModelRenderer Backlegright;
    public ModelRenderer Backlegleft;
    public ModelRenderer Head;
    public ModelRenderer Tail;
    public ModelRenderer Tongue;
    public ModelRenderer Frontfootright;
    public ModelRenderer Frontfootleft;
    public ModelRenderer Backfootright;
    public ModelRenderer Backfootleft;

    public TelmasaurusSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Frontfootleft = new ModelRenderer(this, 0, 0);
        this.Frontfootleft.setRotationPoint(1.0F, 3.29F, 1.0F);
        this.Frontfootleft.setTextureOffset(17, 26).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Frontfootleft, 0.0F, -0.7853981633974483F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 21.7F, -2.0F);
        this.Body.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 22);
        this.Tail.setRotationPoint(0.0F, 0.8F, 9.0F);
        this.Tail.addBox(-1.0F, -1.2F, -0.4F, 2.0F, 2.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.01762782527869516F, 0.583638077898454F, 0.0F);
        this.Frontlegright = new ModelRenderer(this, 0, 20);
        this.Frontlegright.setRotationPoint(-1.0F, 23.7F, -4.0F);
        this.Frontlegright.addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Frontlegright, -0.6215117572878252F, -0.2546435405291338F, 1.4978415587352114F);
        this.Backlegleft = new ModelRenderer(this, 0, 28);
        this.Backlegleft.setRotationPoint(1.0F, 23.7F, 4.0F);
        this.Backlegleft.addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Backlegleft, 0.6557201946479475F, -6.981316851932723E-4F, -1.459793375715413F);
        this.Tongue = new ModelRenderer(this, 32, 9);
        this.Tongue.setRotationPoint(0.0F, 0.0F, -5.8F);
        this.Tongue.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tongue, 0.11623892551966127F, 0.0F, 0.0F);
        this.Frontfootright = new ModelRenderer(this, 0, 0);
        this.Frontfootright.mirror = true;
        this.Frontfootright.setRotationPoint(-1.0F, 3.29F, 1.0F);
        this.Frontfootright.setTextureOffset(17, 26).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Frontfootright, 0.0F, 0.7853981633974483F, 0.0F);
        this.Frontlegleft = new ModelRenderer(this, 0, 20);
        this.Frontlegleft.setRotationPoint(1.0F, 23.7F, -4.0F);
        this.Frontlegleft.addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Frontlegleft, -0.5478588415483757F, 0.182212366584515F, -1.3870131778651824F);
        this.Backfootright = new ModelRenderer(this, 0, 0);
        this.Backfootright.mirror = true;
        this.Backfootright.setRotationPoint(0.0F, 3.29F, 0.0F);
        this.Backfootright.setTextureOffset(16, 30).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Backfootleft = new ModelRenderer(this, 0, 0);
        this.Backfootleft.setRotationPoint(0.0F, 3.29F, 0.0F);
        this.Backfootleft.setTextureOffset(16, 30).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 29, 0);
        this.Head.setRotationPoint(0.0F, 0.7F, -4.2F);
        this.Head.addBox(-1.0F, -1.0F, -5.8F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.009424778335276407F, -0.40125119103875473F, 0.0F);
        this.Backlegright = new ModelRenderer(this, 0, 28);
        this.Backlegright.setRotationPoint(-1.0F, 23.7F, 4.0F);
        this.Backlegright.addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Backlegright, 0.7668976493578585F, 0.11013027480215679F, 1.4606660936046318F);
        this.Frontlegleft.addChild(this.Frontfootleft);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.Tongue);
        this.Frontlegright.addChild(this.Frontfootright);
        this.Backlegright.addChild(this.Backfootright);
        this.Backlegleft.addChild(this.Backfootleft);
        this.Body.addChild(this.Head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body, this.Frontlegright, this.Backlegleft, this.Frontlegleft, this.Backlegright).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TelmasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
