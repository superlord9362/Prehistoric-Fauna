package superlord.prehistoricfauna.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;

@OnlyIn(Dist.CLIENT)
public class SarahsaurusScreen extends AbstractContainerScreen<SarahsaurusMenu> {
	private static final ResourceLocation SARAHSAURUS_INVENTORY_LOCATION = new ResourceLocation("textures/gui/container/horse.png");
	private final Sarahsaurus sarahsaurus;
	private float xMouse;
	private float yMouse;

	public SarahsaurusScreen(SarahsaurusMenu menu, Inventory inventory, Component title) {
	    super(menu, inventory, title);
	    this.sarahsaurus = menu.getSarahsaurus();
	}

	protected void renderBg(GuiGraphics p_282553_, float p_282998_, int p_282929_, int p_283133_) {
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		p_282553_.blit(SARAHSAURUS_INVENTORY_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
		if (this.sarahsaurus instanceof Sarahsaurus) {
			Sarahsaurus abstractchestedsarahsaurus = (Sarahsaurus)this.sarahsaurus;
			if (abstractchestedsarahsaurus.hasChest()) {
				p_282553_.blit(SARAHSAURUS_INVENTORY_LOCATION, i + 79, j + 17, 0, this.imageHeight, abstractchestedsarahsaurus.getInventoryColumns() * 18, 54);
			}
		}
		p_282553_.blit(SARAHSAURUS_INVENTORY_LOCATION, i + 7, j + 17, 36, this.imageHeight + 54, 18, 18);

		InventoryScreen.renderEntityInInventoryFollowsMouse(p_282553_, i + 51, j + 60, 17, (float)(i + 51) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, this.sarahsaurus);
	}

	public void render(GuiGraphics p_281697_, int p_282103_, int p_283529_, float p_283079_) {
		this.renderBackground(p_281697_);
		this.xMouse = (float)p_282103_;
		this.yMouse = (float)p_283529_;
		super.render(p_281697_, p_282103_, p_283529_, p_283079_);
		this.renderTooltip(p_281697_, p_282103_, p_283529_);
	}
}