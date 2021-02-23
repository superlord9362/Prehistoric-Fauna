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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WallFossilRenderer extends EntityRenderer<WallFossilEntity> {
    private static FossilSpriteUploader spriteUploader;

    public WallFossilRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    public void render(WallFossilEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStack.push();
        matrixStack.rotate(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        WallFossilEntity.Fossil fossil = entityIn.fossil;
        float f = 0.0625F;
        matrixStack.scale(f, f, f);
        FossilSpriteUploader uploader = getSpriteUploader();
        this.addVertices(matrixStack, bufferIn.getBuffer(RenderType.getEntitySolid(this.getEntityTexture(entityIn))), entityIn, fossil.getWidth(), fossil.getHeight(), uploader.getFossilSprite(fossil), uploader.getBackSprite());
        matrixStack.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStack, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getEntityTexture(WallFossilEntity entity) {
        return getSpriteUploader().getBackSprite().getAtlasTexture().getTextureLocation();
    }

    private FossilSpriteUploader getSpriteUploader() {
        if (spriteUploader == null) {
            spriteUploader = new FossilSpriteUploader(renderManager.textureManager);
        }
        return spriteUploader;
    }

    private void addVertices(MatrixStack p_229122_1_, IVertexBuilder buffer, WallFossilEntity fossil, int width, int height, TextureAtlasSprite sprite, TextureAtlasSprite back) {
        MatrixStack.Entry matrixstack$entry = p_229122_1_.getLast();
        Matrix4f matrix4f = matrixstack$entry.getMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormal();
        float f = (float)(-width) / 2.0F;
        float f1 = (float)(-height) / 2.0F;
        float backMinU = back.getMinU();
        float backMaxU = back.getMaxU();
        float backMinV = back.getMinV();
        float backMaxV = back.getMaxV();
        float backInterpolatedU = back.getInterpolatedU(1.0D);
        float backInterpolatedV = back.getInterpolatedV(1.0D);
        int i = width / 16;
        int j = height / 16;
        double d0 = 16.0D / (double)i;
        double d1 = 16.0D / (double)j;

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
                float spriteMinU = sprite.getInterpolatedU(d0 * (double)(i - k));
                float spriteMaxU = sprite.getInterpolatedU(d0 * (double)(i - (k + 1)));
                float spriteMinV = sprite.getInterpolatedV(d1 * (double)(j - l));
                float spriteMaxV = sprite.getInterpolatedV(d1 * (double)(j - (l + 1)));
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vStart, spriteMaxU, spriteMinV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vStart, spriteMinU, spriteMinV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vEnd, spriteMinU, spriteMaxV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vEnd, spriteMaxU, spriteMaxV, -0.5F, 0, 0, -1, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vEnd, backMinU, backMinV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vEnd, backMaxU, backMinV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vStart, backMaxU, backMaxV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vStart, backMinU, backMaxV, 0.5F, 0, 0, 1, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vEnd, backMinU, backMinV, -0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vEnd, backMaxU, backMinV, -0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vEnd, backMaxU, backInterpolatedV, 0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vEnd, backMinU, backInterpolatedV, 0.5F, 0, 1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vStart, backMinU, backMinV, 0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vStart, backMaxU, backMinV, 0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vStart, backMaxU, backInterpolatedV, -0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vStart, backMinU, backInterpolatedV, -0.5F, 0, -1, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vEnd, backInterpolatedU, backMinV, 0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vStart, backInterpolatedU, backMaxV, 0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vStart, backMinU, backMaxV, -0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uEnd, vEnd, backMinU, backMinV, -0.5F, -1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vEnd, backInterpolatedU, backMinV, -0.5F, 1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vStart, backInterpolatedU, backMaxV, -0.5F, 1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vStart, backMinU, backMaxV, 0.5F, 1, 0, 0, light);
                this.vertex(matrix4f, matrix3f, buffer, uStart, vEnd, backMinU, backMinV, 0.5F, 1, 0, 0, light);
            }
        }

    }

    private void vertex(Matrix4f matrix, Matrix3f normal, IVertexBuilder buffer, float x, float y, float u, float v, float z, int normalX, int normalY, int normalZ, int light) {
        buffer.pos(matrix, x, y, z).color(255, 255, 255, 255).tex(u, v).overlay(OverlayTexture.NO_OVERLAY).lightmap(light).normal(normal, (float) normalX, (float) normalY, (float) normalZ).endVertex();
    }

    public static class FossilSpriteUploader extends SpriteUploader {
        private static final Map<WallFossilEntity.Fossil, ResourceLocation> NAMES = new HashMap<>();
        private static final ResourceLocation LOCATION_BACK_SPRITE = new ResourceLocation("back");

        public FossilSpriteUploader(TextureManager textureManagerIn) {
            super(textureManagerIn, new ResourceLocation("textures/atlas/paintings.png"), "fossils");
        }

        protected Stream<ResourceLocation> getResourceLocations() {
            return Stream.concat(Arrays.stream(WallFossilEntity.Fossil.VALUES).map(this::getLocation), Stream.of(LOCATION_BACK_SPRITE));
        }

        public TextureAtlasSprite getFossilSprite(WallFossilEntity.Fossil fossil) {
            return this.getSprite(getLocation(fossil));
        }

        public TextureAtlasSprite getBackSprite() {
            return this.getSprite(LOCATION_BACK_SPRITE);
        }

        private ResourceLocation getLocation(WallFossilEntity.Fossil fossil) {
            return NAMES.computeIfAbsent(fossil, k -> new ResourceLocation(PrehistoricFauna.MODID, k.name().toLowerCase()));
        }
    }
}
