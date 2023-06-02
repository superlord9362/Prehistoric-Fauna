package superlord.prehistoricfauna.client.render;

import java.util.HashMap;
import java.util.Map;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.Paleopainting;

public class PaleopaintingRenderer extends EntityRenderer<Paleopainting> {
    private static final ResourceLocation BACK = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/painting/back.png");
    private static final Map<Paleopainting.PaleopaintingType, ResourceLocation> PALEOPAINTINGS = new HashMap<>();

    public PaleopaintingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }

    public void render(Paleopainting entityIn, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLightIn) {
        matrixStack.pushPose();
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        Paleopainting.PaleopaintingType painting = entityIn.paleopainting;
        float f = 0.0625F;
        matrixStack.scale(f, f, f);
        this.renderPainting(matrixStack, buffer, entityIn, painting.getWidth(), painting.getHeight());
        matrixStack.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStack, buffer, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(Paleopainting entity) {
        return PALEOPAINTINGS.computeIfAbsent(entity.paleopainting, k -> new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/painting/" + k.name().toLowerCase() + ".png"));
    }

    private void renderPainting(PoseStack p_229122_1_, MultiBufferSource vertexProvider, Paleopainting painting, int width, int height) {
    	PoseStack.Pose matrixstack$entry = p_229122_1_.last();
        Matrix4f matrix4f = matrixstack$entry.pose();
        Matrix3f matrix3f = matrixstack$entry.normal();
        float f = (float)(-width) / 2.0F;
        float f1 = (float)(-height) / 2.0F;
        float backMinU = 0;
        float backMaxU = 1;
        float backMinV = 0;
        float backMaxV = 1;
        float backInterpolatedU = 0.0625f;
        float backInterpolatedV = 0.0625f;
        int i = width / 16;
        int j = height / 16;
        float d0 = 16f / i;
        float d1 = 16f / j;

        for(int k = 0; k < i; ++k) {
            for(int l = 0; l < j; ++l) {
                float uStart = f + (float)(k * 16);
                float uEnd = f + (float)((k + 1) * 16);
                float vStart = f1 + (float)(l * 16);
                float vEnd = f1 + (float)((l + 1) * 16);
                int x = Mth.floor(painting.getBlockX());
                int y = Mth.floor(painting.getY() + (double)((vEnd + vStart) / 2.0F / 16.0F));
                int z = Mth.floor(painting.getBlockZ());
                Direction direction = painting.getDirection();
                switch (direction) {
                    case NORTH:
                        x = Mth.floor(painting.getBlockX() + (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                    case WEST:
                        z = Mth.floor(painting.getBlockZ() - (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                    case SOUTH:
                        x = Mth.floor(painting.getBlockX() - (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                    case EAST:
                        z = Mth.floor(painting.getBlockZ() + (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
				default:
                    x = Mth.floor(painting.getBlockX() + (double) ((uEnd + uStart) / 2.0F / 16.0F));
					break;
                }

                int light = LevelRenderer.getLightColor(painting.level, new BlockPos(x, y, z));
                float spriteMinU = (d0 * (i - k)) / 16f;
                float spriteMaxU = (d0 * (i - (k + 1))) / 16f;
                float spriteMinV = (d1 * (j - l)) / 16f;
                float spriteMaxV = (d1 * (j - (l + 1))) / 16f;
                VertexConsumer paintingBuffer = vertexProvider.getBuffer(RenderType.entitySolid(this.getTextureLocation(painting)));
                this.vertex(matrix4f, matrix3f, paintingBuffer, uEnd, vStart, spriteMaxU, spriteMinV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, paintingBuffer, uStart, vStart, spriteMinU, spriteMinV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, paintingBuffer, uStart, vEnd, spriteMinU, spriteMaxV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, paintingBuffer, uEnd, vEnd, spriteMaxU, spriteMaxV, -0.5F, 0, 0, -1, light);
                VertexConsumer backBuffer = vertexProvider.getBuffer(RenderType.entitySolid(BACK));
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vEnd, backMinU, backMinV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vEnd, backMaxU, backMinV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vStart, backMaxU, backMaxV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vStart, backMinU, backMaxV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vEnd, backMinU, backMinV, -0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vEnd, backMaxU, backMinV, -0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vEnd, backMaxU, backInterpolatedV, 0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vEnd, backMinU, backInterpolatedV, 0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vStart, backMinU, backMinV, 0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vStart, backMaxU, backMinV, 0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vStart, backMaxU, backInterpolatedV, -0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vStart, backMinU, backInterpolatedV, -0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vEnd, backInterpolatedU, backMinV, 0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vStart, backInterpolatedU, backMaxV, 0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vStart, backMinU, backMaxV, -0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uEnd, vEnd, backMinU, backMinV, -0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vEnd, backInterpolatedU, backMinV, -0.5F, 1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vStart, backInterpolatedU, backMaxV, -0.5F, 1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vStart, backMinU, backMaxV, 0.5F, 1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, backBuffer, uStart, vEnd, backMinU, backMinV, 0.5F, 1, 0, 0, light);
            }
        }
    }

    private void vertex(Matrix4f matrix, Matrix3f normal, VertexConsumer buffer, float x, float y, float u, float v, float z, int normalX, int normalY, int normalZ, int light) {
        buffer.vertex(matrix, x, y, z).color(255, 255, 255, 255).uv(u, v).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(normal, (float) normalX, (float) normalY, (float) normalZ).endVertex();
    }
}