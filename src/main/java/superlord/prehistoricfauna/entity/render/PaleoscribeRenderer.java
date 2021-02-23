package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.model.BookModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.block.PaleoscribeBlock;
import superlord.prehistoricfauna.entity.tile.PaleoscribeTileEntity;

public class PaleoscribeRenderer extends TileEntityRenderer<PaleoscribeTileEntity> {
	private static final RenderType ENCHANTMENT_TABLE_BOOK_TEXTURE = RenderType.getEntityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MODID, "textures/models/paleoscribe_book.png"));
	private final BookModel book = new BookModel();

	public PaleoscribeRenderer(TileEntityRendererDispatcher p_i226011_1_) {
		super(p_i226011_1_);
	}


    @Override
    public void render(PaleoscribeTileEntity entity, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
    	PaleoscribeTileEntity lectern = entity;
        matrixStackIn.push();
        matrixStackIn.translate(0.5F, 1.1F, 0.5F);
        matrixStackIn.scale(0.8F, 0.8F, 0.8F);
        matrixStackIn.rotate(new Quaternion(Vector3f.YP, this.getRotation(lectern), true));
        matrixStackIn.rotate(new Quaternion(Vector3f.XP, 112, true));
        matrixStackIn.rotate(new Quaternion(Vector3f.YP, 90, true));
        float f4 = lectern.pageFlipPrev + (lectern.pageFlip - lectern.pageFlipPrev) * partialTicks + 0.25F;
        float f5 = lectern.pageFlipPrev + (lectern.pageFlip - lectern.pageFlipPrev) * partialTicks + 0.75F;
        f4 = (f4 - MathHelper.fastFloor(f4)) * 1.6F - 0.3F;
        f5 = (f5 - MathHelper.fastFloor(f5)) * 1.6F - 0.3F;

        if (f4 < 0.0F) {
            f4 = 0.0F;
        }

        if (f5 < 0.0F) {
            f5 = 0.0F;
        }

        if (f4 > 1.0F) {
            f4 = 1.0F;
        }

        if (f5 > 1.0F) {
            f5 = 1.0F;
        }
        float f6 = 1.29F;

        this.book.setBookState(partialTicks, MathHelper.clamp(f4, 0.0F, 1.0F), MathHelper.clamp(f5, 0.0F, 1.0F), f6);
        this.book.render(matrixStackIn, bufferIn.getBuffer(ENCHANTMENT_TABLE_BOOK_TEXTURE), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        matrixStackIn.pop();
    }

    private float getRotation(PaleoscribeTileEntity lectern) {
        switch (lectern.getBlockState().get(PaleoscribeBlock.FACING)) {
            default:
                return 180;
            case EAST:
                return 90;
            case WEST:
                return -90;
            case SOUTH:
                return 0;

        }
    }

}