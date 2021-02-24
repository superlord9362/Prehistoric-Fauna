package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.WallFossilEntity;

import java.util.HashMap;
import java.util.Map;

public class WallFossilRenderer extends EntityRenderer<WallFossilEntity> {
    private static final ResourceLocation BACK = new ResourceLocation(PrehistoricFauna.MODID, "textures/fossils/back.png");
    private static final Map<WallFossilEntity.Fossil, ResourceLocation> FOSSILS = new HashMap<>();

    public WallFossilRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(WallFossilEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLightIn) {
        matrixStack.push();
        matrixStack.rotate(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        WallFossilEntity.Fossil fossil = entityIn.fossil;
        float f = 0.0625F;
        matrixStack.scale(f, f, f);
        this.addVertices(matrixStack, buffer, entityIn, fossil.getWidth(), fossil.getHeight());
        matrixStack.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStack, buffer, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(WallFossilEntity entity) {
        return FOSSILS.computeIfAbsent(entity.fossil, k -> new ResourceLocation(PrehistoricFauna.MODID, "textures/fossils/" + k.name().toLowerCase() + ".png"));
    }

    private void addVertices(MatrixStack p_229122_1_, IRenderTypeBuffer vertexProvider, WallFossilEntity fossil, int width, int height) {
        MatrixStack.Entry matrixstack$entry = p_229122_1_.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
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
                int x = MathHelper.floor(fossil.getPosX());
                int y = MathHelper.floor(fossil.getPosY() + (double)((vEnd + vStart) / 2.0F / 16.0F));
                int z = MathHelper.floor(fossil.getPosZ());
                Direction direction = fossil.getHorizontalFacing();
                switch (direction) {
                    case NORTH:
                        x = MathHelper.floor(fossil.getPosX() + (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                    case WEST:
                        z = MathHelper.floor(fossil.getPosZ() - (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                    case SOUTH:
                        x = MathHelper.floor(fossil.getPosX() - (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                    case EAST:
                        z = MathHelper.floor(fossil.getPosZ() + (double) ((uEnd + uStart) / 2.0F / 16.0F));
                        break;
                }

                int light = WorldRenderer.getCombinedLight(fossil.world, new BlockPos(x, y, z));
                float spriteMinU = 0f;//(d0 * (i - k)) / 16f;
                float spriteMaxU = 1f;//(d0 * (i - (k + 1))) / 16f;
                float spriteMinV = 0f;//(d1 * (j - l)) / 16f;
                float spriteMaxV = 1f;//(d1 * (j - (l + 1))) / 16f;
                IVertexBuilder fossilBuffer = vertexProvider.getBuffer(RenderType.getEntitySolid(this.getEntityTexture(fossil)));
                this.vertex(matrix4f, matrix3f, fossilBuffer, uEnd, vStart, spriteMaxU, spriteMinV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, fossilBuffer, uStart, vStart, spriteMinU, spriteMinV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, fossilBuffer, uStart, vEnd, spriteMinU, spriteMaxV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, fossilBuffer, uEnd, vEnd, spriteMaxU, spriteMaxV, -0.5F, 0, 0, -1, light);
                IVertexBuilder backBuffer = vertexProvider.getBuffer(RenderType.getEntitySolid(BACK));
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

    private void vertex(Matrix4f matrix, Matrix3f normal, IVertexBuilder buffer, float x, float y, float u, float v, float z, int normalX, int normalY, int normalZ, int light) {
        buffer.pos(matrix, x, y, z).color(255, 255, 255, 255).tex(u, v).overlay(OverlayTexture.NO_OVERLAY).lightmap(light).normal(normal, (float) normalX, (float) normalY, (float) normalZ).endVertex();
    }
}
