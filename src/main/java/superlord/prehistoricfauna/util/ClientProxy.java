package superlord.prehistoricfauna.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.fonts.Font;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.gui.GuiPaleo;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy extends CommonProxy {

	private TileEntity referencedTE = null;

	@SuppressWarnings("unused")
	private FontRenderer paleoFontRenderer;

	@SuppressWarnings("resource")
	@OnlyIn(Dist.CLIENT)
	@Override
	public void init() {
		try {
			Font font = new Font(Minecraft.getInstance().textureManager, new ResourceLocation("prehistoricfauna:textures/font/paleopediea.png"));
			this.paleoFontRenderer = new FontRenderer(Minecraft.getInstance().textureManager, font);
		} catch (Exception e) {
			this.paleoFontRenderer = Minecraft.getInstance().fontRenderer;
		}
	}

	@OnlyIn(Dist.CLIENT)
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
