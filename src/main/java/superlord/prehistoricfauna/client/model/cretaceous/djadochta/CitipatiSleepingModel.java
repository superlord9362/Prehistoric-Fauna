package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;

/**
 * CitipatiModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CitipatiSleepingModel extends EntityModel<CitipatiEntity> {
    public ModelRenderer Body;
    public ModelRenderer ThighLeft;
    public ModelRenderer Tail;
    public ModelRenderer WingLeft;
    public ModelRenderer ThighRight;
    public ModelRenderer Neck;
    public ModelRenderer WingRight;
    public ModelRenderer LegLeft;
    public ModelRenderer TailFan;
    public ModelRenderer LegRight;
    public ModelRenderer Head;
    public ModelRenderer Crest;

    public CitipatiSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 80;
        this.WingRight = new ModelRenderer(this, 42, 21);
        this.WingRight.setRotationPoint(-2.0F, 4.0F, -3.0F);
        this.WingRight.addBox(-2.0F, -1.0F, -2.0F, 2.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(WingRight, 0.39025563139857644F, -0.5866051722479385F, 0.7428121536172364F);
        this.Head = new ModelRenderer(this, 29, 0);
        this.Head.setRotationPoint(0.0F, -10.0F, -1.0F);
        this.Head.addBox(-1.0F, -2.0F, -6.0F, 2.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.9773843811168246F, 0.11728612207217244F, 0.0F);
        this.ThighLeft = new ModelRenderer(this, 0, 44);
        this.ThighLeft.mirror = true;
        this.ThighLeft.setRotationPoint(1.0F, -0.4F, 8.9F);
        this.ThighLeft.addBox(0.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ThighLeft, -1.0950196019960143F, -0.35185837453889574F, 0.0F);
        this.TailFan = new ModelRenderer(this, 0, 27);
        this.TailFan.setRotationPoint(0.0F, -0.5F, 7.5F);
        this.TailFan.addBox(-2.5F, -1.0F, -1.0F, 5.0F, 3.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailFan, 0.0781907508222411F, -0.27366763203903305F, -0.11728612207217244F);
        this.ThighRight = new ModelRenderer(this, 0, 44);
        this.ThighRight.setRotationPoint(-1.0F, -0.4F, 8.9F);
        this.ThighRight.addBox(-3.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ThighRight, -1.1730357742864224F, 0.4300491170387584F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 16.9F, -4.0F);
        this.Body.addBox(-2.5F, -3.0F, -7.0F, 5.0F, 8.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.3909537457888271F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 41, 2);
        this.Crest.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.Crest.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.WingLeft = new ModelRenderer(this, 42, 21);
        this.WingLeft.mirror = true;
        this.WingLeft.setRotationPoint(2.0F, 3.9F, -3.0F);
        this.WingLeft.addBox(0.0F, -1.0F, -2.0F, 2.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(WingLeft, 0.15690509575954859F, 0.7429866572476639F, -0.8990190684075072F);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(0.0F, 1.1F, -7.7F);
        this.Neck.addBox(-1.5F, -11.0F, -2.0F, 3.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, -0.35185837453889574F, 0.23457224414434488F, -0.0781907508222411F);
        this.LegLeft = new ModelRenderer(this, 0, 60);
        this.LegLeft.setRotationPoint(1.5F, -0.3F, 3.6F);
        this.LegLeft.addBox(-2.0F, 0.0F, -4.0F, 3.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegLeft, 0.16580627893946132F, 3.1398472178113552F, 0.0607374583022978F);
        this.LegRight = new ModelRenderer(this, 0, 60);
        this.LegRight.mirror = true;
        this.LegRight.setRotationPoint(-1.5F, 0.0F, 3.5F);
        this.LegRight.addBox(-1.0F, 0.0F, -4.0F, 3.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegRight, 0.03874630989361682F, 3.141592653589793F, 0.0F);
        this.Tail = new ModelRenderer(this, 40, 6);
        this.Tail.setRotationPoint(0.0F, -0.5F, 12.0F);
        this.Tail.addBox(-2.0F, -2.0F, -1.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, 0.23457224414434488F, -0.19547687289441354F, 0.0F);
        this.Body.addChild(this.WingRight);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.ThighLeft);
        this.Tail.addChild(this.TailFan);
        this.Body.addChild(this.ThighRight);
        this.Head.addChild(this.Crest);
        this.Body.addChild(this.WingLeft);
        this.Body.addChild(this.Neck);
        this.ThighLeft.addChild(this.LegLeft);
        this.ThighRight.addChild(this.LegRight);
        this.Body.addChild(this.Tail);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CitipatiEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
