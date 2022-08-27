package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkeletonEntity;

/**
 * ProtoceratopsSkeleton - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ProtoceratopsSkeletonDisplayModel extends EntityModel<ProtoceratopsSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer BLegRight;
    public ModelRenderer FLegRight;
    public ModelRenderer FLegLeft;
    public ModelRenderer Tail;
    public ModelRenderer BLegLeft;
    public ModelRenderer Neck;
    public ModelRenderer BodyVertebrae;
    public ModelRenderer IliumTip;
    public ModelRenderer FeetRight;
    public ModelRenderer Tailtip;
    public ModelRenderer Tail_1;
    public ModelRenderer Tailtip_1;
    public ModelRenderer FeetLeft;
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Crest;

    public ProtoceratopsSkeletonDisplayModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.FLegLeft = new ModelRenderer(this, 0, 0);
        this.FLegLeft.mirror = true;
        this.FLegLeft.setRotationPoint(-1.5F, 4.5F, -2.0F);
        this.FLegLeft.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FLegLeft, -0.4300491170387584F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 34, 0);
        this.Crest.setRotationPoint(0.0F, -2.0F, 0.5F);
        this.Crest.addBox(-5.5F, -7.5F, -1.4F, 11.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.47123889803846897F, 0.0F, 0.0F);
        this.FeetLeft = new ModelRenderer(this, 30, 46);
        this.FeetLeft.setRotationPoint(1.0F, 8.0F, 2.0F);
        this.FeetLeft.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetLeft, 0.27366763203903305F, 0.0F, 0.0F);
        this.FLegRight = new ModelRenderer(this, 0, 0);
        this.FLegRight.setRotationPoint(1.5F, 4.8F, -2.0F);
        this.FLegRight.addBox(0.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FLegRight, 0.11728612207217244F, 0.0F, 0.0F);
        this.IliumTip = new ModelRenderer(this, 29, 12);
        this.IliumTip.setRotationPoint(-2.5F, -2.5F, 2.0F);
        this.IliumTip.addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.FeetRight = new ModelRenderer(this, 30, 46);
        this.FeetRight.mirror = true;
        this.FeetRight.setRotationPoint(-1.0F, 8.0F, 2.0F);
        this.FeetRight.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetRight, -0.1563815016444822F, 0.0F, 0.0F);
        this.BLegLeft = new ModelRenderer(this, 31, 34);
        this.BLegLeft.setRotationPoint(1.5F, -1.0F, 5.0F);
        this.BLegLeft.addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BLegLeft, 0.27366763203903305F, 0.0F, 0.0F);
        this.Tailtip = new ModelRenderer(this, 18, 19);
        this.Tailtip.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tailtip.addBox(0.0F, -1.5F, 0.0F, 0.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tailtip, -0.1563815016444822F, -0.3127630032889644F, 0.0F);
        this.Beak = new ModelRenderer(this, 48, 27);
        this.Beak.setRotationPoint(0.0F, -1.0F, -5.5F);
        this.Beak.addBox(-1.5F, -2.0F, -2.5F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 5, 25);
        this.Tail.setRotationPoint(0.0F, -0.5F, 7.0F);
        this.Tail.addBox(0.0F, -3.5F, -2.0F, 0.0F, 6.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.1563815016444822F, -0.27366763203903305F, 0.0F);
        this.BodyVertebrae = new ModelRenderer(this, 40, 43);
        this.BodyVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyVertebrae.addBox(0.0F, -3.0F, -4.0F, 0.0F, 9.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 39, 12);
        this.Head.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.27366763203903305F, 0.19547687289441354F, -0.23457224414434488F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 13.0F, -2.0F);
        this.Body.addBox(-2.5F, -2.5F, -4.0F, 5.0F, 8.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.27366763203903305F, 0.0F, 0.0F);
        this.BLegRight = new ModelRenderer(this, 31, 34);
        this.BLegRight.mirror = true;
        this.BLegRight.setRotationPoint(-1.5F, 0.7F, 5.0F);
        this.BLegRight.addBox(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BLegRight, -0.11728612207217244F, 0.0F, 0.0F);
        this.Tail_1 = new ModelRenderer(this, -7, 22);
        this.Tail_1.setRotationPoint(0.0F, -0.5F, 1.0F);
        this.Tail_1.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tailtip_1 = new ModelRenderer(this, 1, 24);
        this.Tailtip_1.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.Tailtip_1.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 3, 43);
        this.Neck.setRotationPoint(0.0F, -1.5F, -4.0F);
        this.Neck.addBox(0.0F, -1.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.FLegLeft);
        this.Head.addChild(this.Crest);
        this.BLegLeft.addChild(this.FeetLeft);
        this.Body.addChild(this.FLegRight);
        this.Body.addChild(this.IliumTip);
        this.BLegRight.addChild(this.FeetRight);
        this.Body.addChild(this.BLegLeft);
        this.Tail.addChild(this.Tailtip);
        this.Head.addChild(this.Beak);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.BodyVertebrae);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.BLegRight);
        this.Tail.addChild(this.Tail_1);
        this.Tailtip.addChild(this.Tailtip_1);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ProtoceratopsSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
