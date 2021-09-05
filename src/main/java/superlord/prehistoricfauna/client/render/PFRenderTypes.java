package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;

public class PFRenderTypes extends RenderType {

    protected static final RenderState.TransparencyState GHOST_TRANSPARANCY = new RenderState.TransparencyState("translucent_ghost_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public PFRenderTypes(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }

    public static RenderType getBossGlint() {
        return makeType("henos_glint", DefaultVertexFormats.ENTITY, 7, 256, RenderType.State.getBuilder().texture(new RenderState.TextureState(new ResourceLocation("prehistoricfauna:textures/entities/henos_healing.png"), true, false)).writeMask(COLOR_DEPTH_WRITE).transparency(TRANSLUCENT_TRANSPARENCY).alpha(DEFAULT_ALPHA).cull(CULL_ENABLED).texturing(ENTITY_GLINT_TEXTURING).overlay(OVERLAY_ENABLED).build(false));
    }
    public static RenderType getBossBeam(ResourceLocation locationIn) {
        TextureState lvt_1_1_ = new TextureState(locationIn, false, false);
        return makeType("boss_beam", DefaultVertexFormats.ENTITY, 7, 262144, false, true, RenderType.State.getBuilder().texture(lvt_1_1_).writeMask(COLOR_DEPTH_WRITE).depthTest(DEPTH_LEQUAL).alpha(DEFAULT_ALPHA).diffuseLighting(RenderState.DIFFUSE_LIGHTING_DISABLED).lightmap(LIGHTMAP_DISABLED).overlay(OVERLAY_ENABLED).transparency(GHOST_TRANSPARANCY).fog(FOG).cull(RenderState.CULL_DISABLED).build(true));
    }
}
