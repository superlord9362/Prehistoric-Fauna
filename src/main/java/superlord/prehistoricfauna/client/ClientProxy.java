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
import superlord.prehistoricfauna.client.gui.GuiPaleopedia;
import superlord.prehistoricfauna.client.render.item.AnkylosaurusHelmetRenderProperties;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.init.PFBlocks;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy { 

	private BlockEntity referencedBE = null;

	public void init() {
	}

	public static int getDryophyllumColor() {
		return 0x5C843B;
	}

	public static void setupBlockRenders() {
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228064_0_, p_228064_1_, p_228064_2_, p_228064_3_) -> {
			return getDryophyllumColor();
		}, PFBlocks.DRYOPHYLLUM_LEAVES.get(), PFBlocks.DRYOPHYLLUM_LEAF_CARPET.get(), PFBlocks.DRYOPHYLLUM_HEDGE.get());
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			return getDryophyllumColor();
		}, PFBlocks.DRYOPHYLLUM_LEAVES.get(), PFBlocks.DRYOPHYLLUM_LEAF_CARPET.get(), PFBlocks.DRYOPHYLLUM_HEDGE.get());
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
		}, PFBlocks.ARAUCARIA_LEAVES.get(), PFBlocks.METASEQUOIA_LEAVES.get(), PFBlocks.CONIOPTERIS.get(), PFBlocks.PROTOPICEOXYLON_LEAVES.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get(), PFBlocks.AGATHOXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get(), PFBlocks.TAXODIUM_LEAVES.get(), PFBlocks.TAXODIUM_LEAF_CARPET.get(), PFBlocks.TAXODIUM_HEDGE.get());
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().defaultBlockState();
			return blockcolors.getColor(blockstate, (BlockAndTintGetter) null, (BlockPos) null, p_210235_2_);
		}, PFBlocks.ARAUCARIA_LEAVES.get(), PFBlocks.METASEQUOIA_LEAVES.get(), PFBlocks.CONIOPTERIS.get(), PFBlocks.PROTOPICEOXYLON_LEAVES.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get(), PFBlocks.AGATHOXYLON_LEAVES.get(), PFBlocks.CLADOPHLEBIS.get(), PFBlocks.TAXODIUM_LEAVES.get(), PFBlocks.TAXODIUM_LEAF_CARPET.get(), PFBlocks.TAXODIUM_HEDGE.get());

		RenderType cutoutRenderType = RenderType.cutout();
		RenderType translucentRenderType = RenderType.translucent();

		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HORSETAIL.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.COBBANIA.get(), cutoutRenderType);
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
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.METASEQUOIA_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ARAUCARIA_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOPICEOXYLON_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PROTOJUNIPEROXYLON_HEDGE.get(), cutoutRenderType);
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
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HEIDIPHYLLUM_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HEIDIPHYLLUM_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HEIDIPHYLLUM_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LIRIODENDRITES_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HENOSTONE_TRAP.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TUBER_CROP.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.THATCH.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.THATCH_SLAB.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ALGAE_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.AGATHOXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.AGATHOXYLON_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.AGATHOXYLON_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.AGATHOXYLON_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.GINKGO_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.GINKGO_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.GINKGO_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.YELLOW_GINKGO_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.YELLOW_GINKGO_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.GINKGO_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.GINKGO_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TROCHODENDROIDES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TROCHODENDROIDES_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TROCHODENDROIDES_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TROCHODENDROIDES_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.WOODWORTHIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.WOODWORTHIA_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.WOODWORTHIA_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.WOODWORTHIA_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.WOODWORTHIA_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCHILDERIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCHILDERIA_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCHILDERIA_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCHILDERIA_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCHILDERIA_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SCHILDERIA_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.BRACHYPHYLLUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.BRACHYPHYLLUM_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.BRACHYPHYLLUM_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.BRACHYPHYLLUM_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.YELLOW_GINKGO_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.NEOCALAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.OTOZAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TALL_OTOZAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.LAUROZAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.CLATHOPTERIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.MARMARTHIA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.PHLEBOPTERIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.CRASSOSTREA_OYSTER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.ZAMITES_FROND.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_HORSRTAIL.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_OSMUNDA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_MARCHANTIA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_CLUBMOSS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_CONIOPTERIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_CLADOPHLEBIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_MICHELILLOA.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_OSMUNDACAULIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_DEAD_CYCAD.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_ARAUCARIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_METASEQUOIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_PROTOPICEOXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_ZAMITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_PROTOJUNIPEROXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_HEIDIPHYLLUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_LIRIODENDRITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_AGATHOXYLON_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_GINKGO_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_TROCHODENDROIDES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_WOODWORTHIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_SCHILDERIA_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_BRACHYPHYLLUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_OTOZAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_LAUROZAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_NEOCALAMITES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_PHLEBOPTERIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_CLATHOPTERIS.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.NEOCALAMITES_TOP.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SMALL_TUBER_BLOCK.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SMALL_CARVED_TUBER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SMALL_CARVED_TUBER_LIT.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SMALL_CARVED_TUBER_SOUL_LIT.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SMALL_CARVED_TUBER_TIME_LIT.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.NEOCALAMITES_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.NEOCALAMITES_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.NEOCALAMITES_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TRIASSIC_PORTAL.get(), translucentRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TRIASSIC_TIME_BLOCK.get(), translucentRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_DRYOPHYLLUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.DRYOPHYLLUM_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_TAXODIUM_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_LEAF_CARPET.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.TAXODIUM_HEDGE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.POTTED_SABALITES_SAPLING.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_DOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_TRAPDOOR.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_LADDER.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_GRASSY_LOG.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_DIAGONAL_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.SABALITES_TOP_LEAVES.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(PFBlocks.HUMULUS.get(), cutoutRenderType);
	}

	@Override
	public void openPaleopediaGui(ItemStack book) {
		Minecraft.getInstance().setScreen(new GuiPaleopedia(book));
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

	@Override
	public Object getArmorRenderProperties() {
		return new AnkylosaurusHelmetRenderProperties();
	}

}
