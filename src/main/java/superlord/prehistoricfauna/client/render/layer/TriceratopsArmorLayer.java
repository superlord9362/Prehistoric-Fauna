package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.init.PFItems;

@OnlyIn(Dist.CLIENT)
public class TriceratopsArmorLayer extends RenderLayer<Triceratops, EntityModel<Triceratops>> {
	private static final RenderType IRON = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/triceratops/iron_armor.png"));
	private static final RenderType GOLD = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/triceratops/gold_armor.png"));
	private static final RenderType DIAMOND = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/triceratops/diamond_armor.png"));
	private static final RenderType NETHERITE = RenderType.entityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/triceratops/netherite_armor.png"));
	
	private final RenderLayerParent<Triceratops, EntityModel<Triceratops>> triceratopsRenderer;

	public TriceratopsArmorLayer(RenderLayerParent<Triceratops, EntityModel<Triceratops>> triceratopsRenderer) {
		super(triceratopsRenderer);
		this.triceratopsRenderer = triceratopsRenderer;
	}

	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Triceratops triceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(triceratopsRenderer.getModel() instanceof TriceratopsModel)) {
			return;
		}
		if (triceratops.isWearingArmor()) {
			Item item = triceratops.getArmor().getItem();
			RenderType tex = null;
			if (item != null) {
				if (item.equals(PFItems.IRON_TRICERATOPS_ARMOR.get())) tex = IRON;
				if (item.equals(PFItems.GOLD_TRICERATOPS_ARMOR.get())) tex = GOLD;
				if (item.equals(PFItems.DIAMOND_TRICERATOPS_ARMOR.get())) tex = DIAMOND;
				if (item.equals(PFItems.NETHERITE_TRICERATOPS_ARMOR.get())) tex = NETHERITE;
			} else tex = null;
			if(tex != null){
				VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
				this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}