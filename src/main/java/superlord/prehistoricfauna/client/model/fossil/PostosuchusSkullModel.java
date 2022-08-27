package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkullEntity;

/**
 * Postosuchus Skull - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PostosuchusSkullModel extends EntityModel<PostosuchusSkullEntity> {
	public ModelRenderer Head;
	public ModelRenderer Snout;
	public ModelRenderer Jaw;
	public ModelRenderer SnoutTeeth;
	public ModelRenderer JawSnout;
	public ModelRenderer JawTeeth;

	public PostosuchusSkullModel() {
		this.textureWidth = 100;
		this.textureHeight = 100;
		this.JawTeeth = new ModelRenderer(this, 57, 0);
		this.JawTeeth.setRotationPoint(-0.5F, -1.0F, 0.01F);
		this.JawTeeth.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Jaw = new ModelRenderer(this, 77, 0);
		this.Jaw.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.Jaw.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.JawSnout = new ModelRenderer(this, 80, 8);
		this.JawSnout.setRotationPoint(0.5F, 0.0F, -4.99F);
		this.JawSnout.addBox(-1.5F, -1.0F, -7.0F, 2.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 24, 0);
		this.Head.setRotationPoint(0.0F, 21.0F, 6.0F);
		this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 44, 0);
		this.Snout.setRotationPoint(0.0F, -4.0F, -5.0F);
		this.Snout.addBox(-1.5F, 0.0F, -7.0F, 3.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.SnoutTeeth = new ModelRenderer(this, 64, 2);
		this.SnoutTeeth.setRotationPoint(-0.5F, 4.0F, 0.0F);
		this.SnoutTeeth.addBox(-1.0F, 0.0F, -7.0F, 3.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.JawSnout.addChild(this.JawTeeth);
		this.Head.addChild(this.Jaw);
		this.Jaw.addChild(this.JawSnout);
		this.Head.addChild(this.Snout);
		this.Snout.addChild(this.SnoutTeeth);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(PostosuchusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
