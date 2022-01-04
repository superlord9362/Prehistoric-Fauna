package superlord.prehistoricfauna.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.render.tileentity.gui.GuiPaleo;
import superlord.prehistoricfauna.common.CommonProxy;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {

	private TileEntity referencedTE = null;

	@SuppressWarnings("unused")
	private FontRenderer paleoFontRenderer;

	@SuppressWarnings("resource")
	@Override
	public void init() {
        this.paleoFontRenderer = Minecraft.getInstance().fontRenderer;
	}

	@Override
	public void openPaleopediaGui(ItemStack book) {
		Minecraft.getInstance().displayGuiScreen(new GuiPaleo(book));
	}

	public boolean shouldSeePaleopediaContents() {
		return InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), 340) || InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), 344);
	}

	@SuppressWarnings("resource")
	public Object getFontRenderer() {
		return Minecraft.getInstance().fontRenderer;
	}

	public TileEntity getReferencedTE() {
		return referencedTE;
	}

	public void setReferencedTE(TileEntity tileEntity) {
		referencedTE = tileEntity;
	}

	@SuppressWarnings("resource")
	public PlayerEntity getClientSidePlayer() {
		return Minecraft.getInstance().player;
	}

}
