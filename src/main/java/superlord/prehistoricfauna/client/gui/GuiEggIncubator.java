package superlord.prehistoricfauna.client.gui;

import superlord.prehistoricfauna.blocks.tile.TileEntityEggIncubator;
import superlord.prehistoricfauna.inventory.ContainerEggIncubator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import static superlord.prehistoricfauna.util.Reference.MOD_ID;

public class GuiEggIncubator extends GuiContainer {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/egg_incubator.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityEggIncubator tile;

    public GuiEggIncubator(InventoryPlayer playerInventory, TileEntityEggIncubator tile) {
        super(new ContainerEggIncubator(playerInventory, tile));
        this.playerInventory = playerInventory;
        this.tile = tile;
    }

    public void initGui() {
        super.initGui();
        this.mc.player.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1f, 1f, 1f, 1f);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
