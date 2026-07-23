package superlord.prehistoricfauna.client.gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Shunosaurus;
@OnlyIn(Dist.CLIENT)
public class ShunosaurusScreen extends AbstractContainerScreen<ShunosaurusMenu> {
	private static final ResourceLocation SHUNOSAURUS_INVENTORY_LOCATION = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/gui/container/shunosaurus.png");
	private static final ResourceLocation SCROLLESS_INVENTORY_LOCATION = new ResourceLocation("textures/gui/container/horse.png");
	private static final ResourceLocation SCROLLER_LOCATION = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
	private static final int SCROLLER_U = 232;
	private static final int SCROLLER_V = 0;
	private static final int SCROLLBAR_TRACK_HEIGHT = ShunosaurusMenu.VISIBLE_ROWS * 18;
	private static final int SCROLLBAR_HANDLE_WIDTH = 12;
	private static final int SCROLLBAR_HANDLE_HEIGHT = 15;
	private final Shunosaurus shunosaurus;
	private float xMouse;
	private float yMouse;
	private boolean draggingScrollbar;

	public ShunosaurusScreen(ShunosaurusMenu menu, Inventory inventory, Component title) {
		super(menu, inventory, title);
		this.shunosaurus = menu.getShunosaurus();
	}

	protected void renderBg(GuiGraphics p_282553_, float p_282998_, int p_282929_, int p_283133_) {
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		if (this.shunosaurus instanceof Shunosaurus) {
			Shunosaurus abstractchestedshunosaurus = (Shunosaurus) this.shunosaurus;
		ResourceLocation location = abstractchestedshunosaurus.getChestCount() == 2 ? SHUNOSAURUS_INVENTORY_LOCATION : SCROLLESS_INVENTORY_LOCATION;
					p_282553_.blit(location, i, j, 0, 0, this.imageWidth + 20, this.imageHeight);
			if (abstractchestedshunosaurus.hasChest()) {
				p_282553_.blit(location, i + 79, j + 17, 0, this.imageHeight, abstractchestedshunosaurus.getInventoryColumns() * 18, 54);
			}
		}
		p_282553_.blit(SHUNOSAURUS_INVENTORY_LOCATION, i + 7, j + 17, 36, this.imageHeight + 54, 18, 18);
		InventoryScreen.renderEntityInInventoryFollowsMouse(p_282553_, i + 51, j + 60, 10, (float) (i + 51) - this.xMouse, (float) (j + 75 - 50) - this.yMouse, this.shunosaurus);
		if (this.hasScrollbar()) {
			this.renderScrollbar(p_282553_, i, j);
		}
	}

	private boolean hasScrollbar() {
		return this.menu.getTotalChestRows() > ShunosaurusMenu.VISIBLE_ROWS;
	}

	private void requestScroll(int rows) {
		int maxScroll = Math.max(0, this.menu.getTotalChestRows() - ShunosaurusMenu.VISIBLE_ROWS);
		int clamped = Math.max(0, Math.min(rows, maxScroll));
		this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, clamped);
	}

	private int getScrollbarX() {
		int i = (this.width - this.imageWidth) / 2;
		return i + 80 + this.menu.getChestColumns() * 18 + 2;
	}

	private int getScrollbarTrackY() {
		int j = (this.height - this.imageHeight) / 2;
		return j + 18;
	}

	private int getScrollbarHandleY() {
		int maxScroll = Math.max(1, this.menu.getTotalChestRows() - ShunosaurusMenu.VISIBLE_ROWS);
		int travel = SCROLLBAR_TRACK_HEIGHT - SCROLLBAR_HANDLE_HEIGHT;
		int offset = maxScroll <= 0 ? 0 : this.menu.getScrollRows() * travel / maxScroll;
		return this.getScrollbarTrackY() + offset;
	}

	private void renderScrollbar(GuiGraphics graphics, int leftPos, int topPos) {
		int x = this.getScrollbarX();
		//	    int trackY = this.getScrollbarTrackY();
		//	    graphics.fill(x, trackY, x + SCROLLBAR_HANDLE_WIDTH, trackY + SCROLLBAR_TRACK_HEIGHT, 0xFF8B8B8B);
		//	    graphics.fill(x + 1, trackY + 1, x + SCROLLBAR_HANDLE_WIDTH - 1, trackY + SCROLLBAR_TRACK_HEIGHT - 1, 0xFF373737);

		int handleY = this.getScrollbarHandleY();
		graphics.blit(SCROLLER_LOCATION, x, handleY, SCROLLER_U, SCROLLER_V, SCROLLBAR_HANDLE_WIDTH, SCROLLBAR_HANDLE_HEIGHT);
	}

	private void setScrollFromMouseY(double mouseY) {
		int maxScroll = this.menu.getTotalChestRows() - ShunosaurusMenu.VISIBLE_ROWS;
		if (maxScroll <= 0) {
			return;
		}
		int trackY = this.getScrollbarTrackY();
		int travel = SCROLLBAR_TRACK_HEIGHT - SCROLLBAR_HANDLE_HEIGHT;
		double relative = (mouseY - trackY - (double) SCROLLBAR_HANDLE_HEIGHT / 2.0D) / (double) travel;
		int row = (int) Math.round(relative * maxScroll);
		this.menu.setScrollRows(row);
		this.requestScroll(row);
	}

	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		if (this.hasScrollbar() && button == 0) {
			int x = this.getScrollbarX();
			int handleY = this.getScrollbarHandleY();
			if (mouseX >= x && mouseX < x + SCROLLBAR_HANDLE_WIDTH && mouseY >= handleY && mouseY < handleY + SCROLLBAR_HANDLE_HEIGHT) {
				this.draggingScrollbar = true;
				return true;
			}
			int trackY = this.getScrollbarTrackY();
			if (mouseX >= x && mouseX < x + SCROLLBAR_HANDLE_WIDTH && mouseY >= trackY && mouseY < trackY + SCROLLBAR_TRACK_HEIGHT) {
				this.draggingScrollbar = true;
				this.setScrollFromMouseY(mouseY);
				return true;
			}
		}
		return super.mouseClicked(mouseX, mouseY, button);
	}

	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		if (this.draggingScrollbar) {
			this.setScrollFromMouseY(mouseY);
			return true;
		}
		return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	public boolean mouseReleased(double mouseX, double mouseY, int button) {
		if (button == 0 && this.draggingScrollbar) {
			this.draggingScrollbar = false;
			return true;
		}
		return super.mouseReleased(mouseX, mouseY, button);
	}

	public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
		if (this.hasScrollbar()) {
			int direction = delta > 0 ? -1 : 1;
			int newRow = this.menu.getScrollRows() + direction;
			this.menu.setScrollRows(newRow);
			this.requestScroll(newRow);
			return true;
		}
		return super.mouseScrolled(mouseX, mouseY, delta);
	}

	public void render(GuiGraphics p_281697_, int p_282103_, int p_283529_, float p_283079_) {
		this.renderBackground(p_281697_);
		this.xMouse = (float) p_282103_;
		this.yMouse = (float) p_283529_;
		super.render(p_281697_, p_282103_, p_283529_, p_283079_);
		this.renderTooltip(p_281697_, p_282103_, p_283529_);
	}

}