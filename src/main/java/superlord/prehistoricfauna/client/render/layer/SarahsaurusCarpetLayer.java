package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;

@OnlyIn(Dist.CLIENT)
public class SarahsaurusCarpetLayer extends RenderLayer<Sarahsaurus, SarahsaurusModel> {
	private static final RenderType BLACK = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/black.png"));
	private static final RenderType BLUE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/blue.png"));
	private static final RenderType BROWN = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/brown.png"));
	private static final RenderType CYAN = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/cyan.png"));
	private static final RenderType GRAY = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/gray.png"));
	private static final RenderType GREEN = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/green.png"));
	private static final RenderType LIGHT_BLUE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/light_blue.png"));
	private static final RenderType LIGHT_GRAY = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/light_gray.png"));
	private static final RenderType LIME = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/lime.png"));
	private static final RenderType MAGENTA = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/magenta.png"));
	private static final RenderType ORANGE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/orange.png"));
	private static final RenderType PINK = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/pink.png"));
	private static final RenderType PURPLE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/purple.png"));
	private static final RenderType RED = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/red.png"));
	private static final RenderType WHITE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/white.png"));
	private static final RenderType YELLOW = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/sarahsaurus/decor/yellow.png"));

	private final RenderLayerParent<Sarahsaurus, SarahsaurusModel> sarahsaurusRenderer;

	public SarahsaurusCarpetLayer(RenderLayerParent<Sarahsaurus, SarahsaurusModel> sarahsaurusRenderer) {
		super(sarahsaurusRenderer);
		this.sarahsaurusRenderer = sarahsaurusRenderer;
	}

	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Sarahsaurus sarahsaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(sarahsaurusRenderer.getModel() instanceof SarahsaurusModel)) {
			return;
		}
		if (sarahsaurus.isWearingCarpet()) {
			DyeColor dyecolor = sarahsaurus.getSwag();
			RenderType tex = null;
			if (dyecolor != null) {
				if (dyecolor.equals(DyeColor.BLACK)) tex = BLACK;
				if (dyecolor.equals(DyeColor.BLUE)) tex = BLUE;
				if (dyecolor.equals(DyeColor.BROWN)) tex = BROWN;
				if (dyecolor.equals(DyeColor.CYAN)) tex = CYAN;
				if (dyecolor.equals(DyeColor.GRAY)) tex = GRAY;
				if (dyecolor.equals(DyeColor.GREEN)) tex = GREEN;
				if (dyecolor.equals(DyeColor.LIGHT_BLUE)) tex = LIGHT_BLUE;
				if (dyecolor.equals(DyeColor.LIGHT_GRAY)) tex = LIGHT_GRAY;
				if (dyecolor.equals(DyeColor.LIME)) tex = LIME;
				if (dyecolor.equals(DyeColor.MAGENTA)) tex = MAGENTA;
				if (dyecolor.equals(DyeColor.ORANGE)) tex = ORANGE;
				if (dyecolor.equals(DyeColor.PINK)) tex = PINK;
				if (dyecolor.equals(DyeColor.PURPLE)) tex = PURPLE;
				if (dyecolor.equals(DyeColor.RED)) tex = RED;
				if (dyecolor.equals(DyeColor.WHITE)) tex = WHITE;
				if (dyecolor.equals(DyeColor.YELLOW)) tex = YELLOW;
			}
			if(tex != null){
				VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
				this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}