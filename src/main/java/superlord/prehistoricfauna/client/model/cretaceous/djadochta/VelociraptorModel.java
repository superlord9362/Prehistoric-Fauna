package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;

/**
 * Velociraptor - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class VelociraptorModel extends EntityModel<VelociraptorEntity> {
    public ModelRenderer Body;
    public ModelRenderer Thighleft;
    public ModelRenderer Thighright;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer Wingleft;
    public ModelRenderer Wingright;
    public ModelRenderer Head;
    public ModelRenderer Mouth;
    public ModelRenderer Tailfan;
    public ModelRenderer Legleft;
    public ModelRenderer Legright;

    public VelociraptorModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Mouth = new ModelRenderer(this, 31, 1);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Mouth.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Tailfan = new ModelRenderer(this, 0, 15);
        this.Tailfan.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tailfan.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Thighright = new ModelRenderer(this, 46, 0);
        this.Thighright.mirror = true;
        this.Thighright.setRotationPoint(-0.5F, 16.0F, 2.0F);
        this.Thighright.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Legright = new ModelRenderer(this, 46, 8);
        this.Legright.mirror = true;
        this.Legright.setRotationPoint(-1.0F, 4.0F, 2.0F);
        this.Legright.addBox(-1.5F, 0.0F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Thighleft = new ModelRenderer(this, 46, 0);
        this.Thighleft.setRotationPoint(0.5F, 16.0F, 2.0F);
        this.Thighleft.addBox(0.0F, -1.0F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Wingleft = new ModelRenderer(this, 0, 15);
        this.Wingleft.setRotationPoint(1.5F, 1.0F, -3.0F);
        this.Wingleft.addBox(0.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 23, 7);
        this.Tail.setRotationPoint(0.0F, -0.5F, 5.0F);
        this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Wingright = new ModelRenderer(this, 0, 15);
        this.Wingright.mirror = true;
        this.Wingright.setRotationPoint(-1.5F, 1.0F, -3.0F);
        this.Wingright.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 16, 0);
        this.Head.setRotationPoint(0.1F, -4.3F, -2.0F);
        this.Head.addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Legleft = new ModelRenderer(this, 46, 8);
        this.Legleft.setRotationPoint(1.0F, 4.0F, 2.0F);
        this.Legleft.addBox(-0.5F, 0.0F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.Body.addBox(-1.5F, -2.0F, -5.0F, 3.0F, 5.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.Neck.addBox(-1.0F, -6.0F, -3.0F, 2.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Mouth);
        this.Tail.addChild(this.Tailfan);
        this.Thighright.addChild(this.Legright);
        this.Body.addChild(this.Wingleft);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Wingright);
        this.Neck.addChild(this.Head);
        this.Thighleft.addChild(this.Legleft);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thighright, this.Thighleft, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(VelociraptorEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.Thighright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Thighleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		this.Head.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
		this.Wingleft.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.Wingright.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
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
