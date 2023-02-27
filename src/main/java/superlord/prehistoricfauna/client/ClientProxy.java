package superlord.prehistoricfauna.client;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.init.PFBlocks;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy { 
	
	private BlockEntity referencedBE = null;

	public void init() {
	}
	
	public static void setupBlockRenders() {
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228064_0_, p_228064_1_, p_228064_2_, p_228064_3_) -> {
			return p_228064_1_ != null && p_228064_2_ != null ? BiomeColors.getAverageGrassColor(p_228064_1_, p_228064_2_) : GrassColor.get(0.5D, 1.0D);
		}, PFBlocks.CONIOPTERIS.get());
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
			return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getAverageFoliageColor(p_228061_1_, p_228061_2_) : FoliageColor.getDefaultColor();
		}, PFBlocks.METASEQUOIA_LEAVES.get(), PFBlocks.PROTOPICEOXYLON_LEAVES.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get());
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
			return 0x45AF45;
		}, PFBlocks.ARAUCARIA_LEAVES.get());
		blockcolors.register((state, reader, pos, color) -> {
			return reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor();
		}, PFBlocks.ARAUCARIA_LEAVES.get(), PFBlocks.METASEQUOIA_LEAVES.get(), PFBlocks.CONIOPTERIS.get(), PFBlocks.PROTOPICEOXYLON_LEAVES.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get(), PFBlocks.AGATHOXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get());
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().defaultBlockState();
			return blockcolors.getColor(blockstate, (BlockAndTintGetter) null, (BlockPos) null, p_210235_2_);
		}, PFBlocks.ARAUCARIA_LEAVES.get(), PFBlocks.METASEQUOIA_LEAVES.get(), PFBlocks.CONIOPTERIS.get(), PFBlocks.PROTOPICEOXYLON_LEAVES.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get(), PFBlocks.AGATHOXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get());

		RenderType cutoutRenderType = RenderType.cutout();
		
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HORSETAIL.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TALL_HORSETAIL.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.OSMUNDA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TALL_OSMUNDA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.CLUBMOSS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.MARCHANTIA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.CONIOPTERIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TALL_OSMUNDACAULIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PTILOPHYLLUM_BASE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DICROIDIUM.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.JOHNSTONIA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCYTOPHYLLUM.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.MICHELILLOA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DEAD_OSMUNDACAULIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.OSMUNDACAULIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.CLADOPHLEBIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HEIDIPHYLLUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HEIDIPHYLLUM_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HEIDIPHYLLUM_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HENOSTONE_TRAP.get(), cutoutRenderType);
	}
	
	@Override
	public void openPaleopediaGui(ItemStack book) {
		Minecraft.getInstance().setScreen(new GuiPaleo(book));
	}

	public boolean shouldSeePaleopediaContents() {
		return InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 340) || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), 344);
	}
	
	public BlockEntity getReferencedBE() {
		return referencedBE;
	}

	public void setReferencedBE(BlockEntity blockEntity) {
		referencedBE = blockEntity;
	}

	@SuppressWarnings("resource")
	public Player getClientSidePlayer() {
		return Minecraft.getInstance().player;
	}


}
