package superlord.prehistoricfauna.init;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class PFRenderTypes extends RenderType {

	protected static final TransparencyStateShard GHOST_TRANSPARANCY = new TransparencyStateShard("translucent_ghost_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });
	
	public PFRenderTypes(String nameIn, VertexFormat formatIn, Mode drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }
	
    public static RenderType getBossGlint() {
        return create("henos_glint", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setTextureState(new TextureStateShard(new ResourceLocation("prehistoricfauna:textures/entities/henos/henos_healing.png"), true, false)).setWriteMaskState(COLOR_DEPTH_WRITE).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setCullState(CULL).setShaderState(RENDERTYPE_ARMOR_ENTITY_GLINT_SHADER).setOverlayState(OVERLAY).createCompositeState(false));
    }
    public static RenderType getBossBeam(ResourceLocation locationIn) {
    	TextureStateShard lvt_1_1_ = new TextureStateShard(locationIn, false, false);
        return create("boss_beam", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 262144, false, true, RenderType.CompositeState.builder().setTextureState(lvt_1_1_).setWriteMaskState(COLOR_DEPTH_WRITE).setDepthTestState(LEQUAL_DEPTH_TEST).setShaderState(RENDERTYPE_ENTITY_ALPHA_SHADER).setLightmapState(NO_LIGHTMAP).setOverlayState(OVERLAY).setTransparencyState(GHOST_TRANSPARANCY).setCullState(NO_CULL).createCompositeState(true));
    }
	
}
