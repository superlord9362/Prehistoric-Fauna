package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;

/**
 * ProtoceratopsModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ProtoceratopsSleepingModel extends EntityModel<ProtoceratopsEntity> {
    public ModelRenderer Body;
    public ModelRenderer BLegRight;
    public ModelRenderer FLegRight;
    public ModelRenderer FLegLeft;
    public ModelRenderer Tail;
    public ModelRenderer BLegLeft;
    public ModelRenderer Neck;
    public ModelRenderer FeetRight;
    public ModelRenderer Tailtip;
    public ModelRenderer FeetLeft;
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Crest;

    public ProtoceratopsSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 39, 12);
        this.Head.setRotationPoint(0.4F, 2.0F, -4.2F);
        this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.14556046227948816F, -0.5473352640780661F, 0.9121090377974647F);
        this.FLegRight = new ModelRenderer(this, 0, 0);
        this.FLegRight.setRotationPoint(1.5F, 5.0F, -2.0F);
        this.FLegRight.addBox(0.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FLegRight, 0.037175515064850034F, 0.07278023113974408F, 1.2039281766152325F);
        this.FeetRight = new ModelRenderer(this, 30, 46);
        this.FeetRight.mirror = true;
        this.FeetRight.setRotationPoint(-1.0F, 5.0F, 3.0F);
        this.FeetRight.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetRight, -0.291993575869168F, 3.141592653589793F, -1.7453292129831807E-4F);
        this.Crest = new ModelRenderer(this, 34, 0);
        this.Crest.setRotationPoint(0.0F, -2.0F, 0.5F);
        this.Crest.addBox(-5.5F, -7.5F, -1.4F, 11.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.47123889803846897F, 0.0F, 0.0F);
        this.BLegLeft = new ModelRenderer(this, 30, 35);
        this.BLegLeft.setRotationPoint(2.2F, 3.8F, 4.1F);
        this.BLegLeft.addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BLegLeft, -0.1090830782496456F, 0.03630284710990151F, 0.8389797661073521F);
        this.BLegRight = new ModelRenderer(this, 30, 35);
        this.BLegRight.mirror = true;
        this.BLegRight.setRotationPoint(-1.2F, 1.0F, 4.3F);
        this.BLegRight.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BLegRight, 0.7298966878577064F, -0.055326938619800786F, 0.12740903872453743F);
        this.Beak = new ModelRenderer(this, 48, 27);
        this.Beak.setRotationPoint(0.0F, -1.0F, -5.5F);
        this.Beak.addBox(-1.5F, -2.0F, -2.5F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.FLegLeft = new ModelRenderer(this, 0, 0);
        this.FLegLeft.mirror = true;
        this.FLegLeft.setRotationPoint(-1.4F, 2.0F, -1.2F);
        this.FLegLeft.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FLegLeft, -0.9861110273767961F, 0.07312929665724782F, 0.1090830782496456F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-1.1F, 21.1F, 0.0F);
        this.Body.addBox(-2.5F, -3.0F, -4.0F, 5.0F, 9.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -1.7453292129831807E-4F, -0.0015707963892127347F, -1.680228412305397F);
        this.FeetLeft = new ModelRenderer(this, 30, 46);
        this.FeetLeft.setRotationPoint(1.0F, 5.0F, 3.0F);
        this.FeetLeft.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetLeft, 0.8402014912574258F, 3.141592653589793F, 0.0F);
        this.Tailtip = new ModelRenderer(this, 20, 22);
        this.Tailtip.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.Tailtip.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tailtip, -0.36477380700891215F, 0.07295475973730675F, -0.1096066806870904F);
        this.Tail = new ModelRenderer(this, 0, 22);
        this.Tail.setRotationPoint(0.0F, 0.5F, 6.0F);
        this.Tail.addBox(-1.5F, -5.0F, -1.0F, 3.0F, 7.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, 0.291819038949227F, -0.18256144042439712F, 0.2183406934192323F);
        this.Neck = new ModelRenderer(this, 0, 43);
        this.Neck.setRotationPoint(0.4F, -1.0F, -4.0F);
        this.Neck.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.18238690350445608F, 0.1096066806870904F, 0.3281218860591285F);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.FLegRight);
        this.BLegRight.addChild(this.FeetRight);
        this.Head.addChild(this.Crest);
        this.Body.addChild(this.BLegLeft);
        this.Body.addChild(this.BLegRight);
        this.Head.addChild(this.Beak);
        this.Body.addChild(this.FLegLeft);
        this.BLegLeft.addChild(this.FeetLeft);
        this.Tail.addChild(this.Tailtip);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ProtoceratopsEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
