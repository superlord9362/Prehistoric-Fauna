package superlord.prehistoricfauna.util;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public class CommonEvents {

	public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();
	public static Map<Block, Block> ROCK_SMASHING_MAP = new HashMap<>();

	static {
		BLOCK_STRIPPING_MAP.put(BlockInit.METASEQUOIA_LOG, BlockInit.METASEQUOIA_LOG_STRIPPED);
		BLOCK_STRIPPING_MAP.put(BlockInit.METASEQUOIA_WOOD, BlockInit.STRIPPED_METASEQUOIA_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.ARAUCARIA_LOG, BlockInit.STRIPPED_ARAUCARIA_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.ARAUCARIA_WOOD, BlockInit.STRIPPED_ARAUCARIA_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOPICEOXYLON_LOG, BlockInit.STRIPPED_PROTOPICEOXYLON_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOPICEOXYLON_WOOD, BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.ZAMITES_LOG, BlockInit.STRIPPED_ZAMITES_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.ZAMITES_WOOD, BlockInit.STRIPPED_ZAMITES_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOJUNIPER_LOG, BlockInit.STRIPPED_PROTOJUNIPER_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOJUNIPER_WOOD, BlockInit.STRIPPED_PROTOJUNIPER_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.HEIDIPHYLLUM_LOG, BlockInit.STRIPPED_HEIDIPHYLLUM_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.HEIDIPHYLLUM_WOOD, BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.LIRIODENDRITES_LOG, BlockInit.STRIPPED_LIRIODENDRITES_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.LIRIODENDRITES_WOOD, BlockInit.STRIPPED_LIRIODENDRITES_WOOD);
		ROCK_SMASHING_MAP.put(Blocks.STONE, Blocks.COBBLESTONE);
		ROCK_SMASHING_MAP.put(Blocks.COBBLESTONE, Blocks.GRAVEL);
		ROCK_SMASHING_MAP.put(Blocks.SANDSTONE, Blocks.SAND);
		ROCK_SMASHING_MAP.put(Blocks.RED_SANDSTONE, Blocks.RED_SAND);
		//BLOCK_STRIPPING_MAP.put(BlockInit.CYPRESS_LOG, BlockInit.STRIPPED_CYPRESS_LOG);
		//BLOCK_STRIPPING_MAP.put(BlockInit.CYPRESS_WOOD, BlockInit.STRIPPED_CYPRESS_WOOD);
	}

	public static void setup() {
		registerFlammable(BlockInit.ARAUCARIA_PLANKS, 5, 20);
		registerFlammable(BlockInit.METASEQUOIA_PLANKS, 5, 20);
		registerFlammable(BlockInit.ARAUCARIA_SLAB, 5, 20);
		registerFlammable(BlockInit.METASEQUOIA_SLAB, 5, 20);
		registerFlammable(BlockInit.ARAUCARIA_FENCE, 5, 20);
		registerFlammable(BlockInit.METASEQUOIA_FENCE, 5, 20);
		registerFlammable(BlockInit.ARAUCARIA_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.METASEQUOIA_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.ARAUCARIA_STAIRS, 5, 20);
		registerFlammable(BlockInit.METASEQUOIA_STAIRS, 5, 20);
		registerFlammable(BlockInit.PROTOPICEOXYLON_PLANKS, 5, 20);
		registerFlammable(BlockInit.PROTOPICEOXYLON_SLAB, 5, 20);
		registerFlammable(BlockInit.PROTOPICEOXYLON_FENCE, 5, 20);
		registerFlammable(BlockInit.PROTOPICEOXYLON_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.PROTOPICEOXYLON_STAIRS, 5, 20);
		registerFlammable(BlockInit.ZAMITES_PLANKS, 5, 20);
		registerFlammable(BlockInit.ZAMITES_SLAB, 5, 20);
		registerFlammable(BlockInit.ZAMITES_FENCE, 5, 20);
		registerFlammable(BlockInit.ZAMITES_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.ZAMITES_STAIRS, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPER_PLANKS, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPER_SLAB, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPER_FENCE, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPER_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPER_STAIRS, 5, 20);
		registerFlammable(BlockInit.HEIDIPHYLLUM_PLANKS, 5, 20);
		registerFlammable(BlockInit.HEIDIPHYLLUM_SLAB, 5, 20);
		registerFlammable(BlockInit.HEIDIPHYLLUM_FENCE, 5, 20);
		registerFlammable(BlockInit.HEIDIPHYLLUM_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.HEIDIPHYLLUM_STAIRS, 5, 20);
		registerFlammable(BlockInit.LIRIODENDRITES_PLANKS, 5, 20);
		registerFlammable(BlockInit.LIRIODENDRITES_SLAB, 5, 20);
		registerFlammable(BlockInit.LIRIODENDRITES_FENCE, 5, 20);
		registerFlammable(BlockInit.LIRIODENDRITES_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.LIRIODENDRITES_STAIRS, 5, 20);
		//registerFlammable(BlockInit.CYPRESS_PLANKS, 5, 20);
		//registerFlammable(BlockInit.CYPRESS_SLAB, 5, 20);
		//registerFlammable(BlockInit.CYPRESS_FENCE, 5, 20);
		//registerFlammable(BlockInit.CYPRESS_FENCE_GATE, 5, 20);
		//registerFlammable(BlockInit.CYPRESS_STAIRS, 5, 20);
		registerFlammable(BlockInit.ARAUCARIA_LOG, 5, 5);
		registerFlammable(BlockInit.METASEQUOIA_LOG, 5, 5);
		registerFlammable(BlockInit.METASEQUOIA_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_ARAUCARIA_LOG, 5, 5);
		registerFlammable(BlockInit.METASEQUOIA_LOG_STRIPPED, 5, 5);
		registerFlammable(BlockInit.ARAUCARIA_WOOD, 5, 5);
		registerFlammable(BlockInit.METASEQUOIA_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_ARAUCARIA_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_METASEQUOIA_WOOD, 5, 5);
		registerFlammable(BlockInit.PROTOPICEOXYLON_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_PROTOPICEOXYLON_LOG, 5, 5);
		registerFlammable(BlockInit.PROTOPICEOXYLON_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD, 5, 5);
		registerFlammable(BlockInit.ZAMITES_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_ZAMITES_LOG, 5, 5);
		registerFlammable(BlockInit.ZAMITES_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_ZAMITES_WOOD, 5, 5);
		registerFlammable(BlockInit.PROTOJUNIPER_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_PROTOJUNIPER_LOG, 5, 5);
		registerFlammable(BlockInit.PROTOJUNIPER_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_PROTOJUNIPER_WOOD, 5, 5);
		registerFlammable(BlockInit.HEIDIPHYLLUM_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_HEIDIPHYLLUM_LOG, 5, 5);
		registerFlammable(BlockInit.HEIDIPHYLLUM_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD, 5, 5);
		registerFlammable(BlockInit.LIRIODENDRITES_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_LIRIODENDRITES_LOG, 5, 5);
		registerFlammable(BlockInit.LIRIODENDRITES_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_LIRIODENDRITES_WOOD, 5, 5);
		//registerFlammable(BlockInit.CYPRESS_LOG, 5, 5);
		//registerFlammable(BlockInit.STRIPPED_CYPRESS_LOG, 5, 5);
		//registerFlammable(BlockInit.CYPRESS_WOOD, 5, 5);
		//registerFlammable(BlockInit.STRIPPED_CYPRESS_WOOD, 5, 5);
		registerFlammable(BlockInit.ARAUCARIA_LEAVES, 30, 60);
		registerFlammable(BlockInit.METASEQUOIA_LEAVES, 30, 60);
		registerFlammable(BlockInit.PROTOPICEOXYLON_LEAVES, 30, 60);
		registerFlammable(BlockInit.ZAMITES_LEAVES, 30, 60);
		registerFlammable(BlockInit.PROTOJUNIPER_LEAVES, 30, 60);
		registerFlammable(BlockInit.HEIDIPHYLLUM_LEAVES, 30, 60);
		registerFlammable(BlockInit.LIRIODENDRITES_LEAVES, 30, 60);;
		//registerFlammable(BlockInit.CYPRESS_LEAVES, 30, 60);
		registerFlammable(BlockInit.CLUBMOSS, 60, 100);
		registerFlammable(BlockInit.HORSETAIL, 60, 100);
		registerFlammable(BlockInit.OSMUNDA, 60, 100);
		registerFlammable(BlockInit.MARCHANTIA, 60, 100);
		registerFlammable(BlockInit.DOUBLE_HORSETAIL, 60, 100);
		registerFlammable(BlockInit.DOUBLE_OSMUNDA, 60, 100);
		registerFlammable(BlockInit.CONIOPTERIS, 60, 100);
		registerFlammable(BlockInit.OSMUNDACAULIS, 60, 100);
		registerFlammable(BlockInit.MOSS, 60, 20);
		registerFlammable(BlockInit.MOSS_BLOCK, 60, 20);
		registerCompostable(0.3F, BlockInit.ARAUCARIA_LEAVES);
		registerCompostable(0.3F, BlockInit.METASEQUOIA_LEAVES);
		registerCompostable(0.3F, BlockInit.PROTOPICEOXYLON_LEAVES);
		registerCompostable(0.3F, BlockInit.ZAMITES_LEAVES);
		registerCompostable(0.3F, BlockInit.PROTOJUNIPER_LEAVES);
		registerCompostable(0.3F, BlockInit.HEIDIPHYLLUM_LEAVES);
		registerCompostable(0.3F, BlockInit.LIRIODENDRITES_LEAVES);
		//registerCompostable(0.3F, BlockInit.CYPRESS_LEAVES);
		registerCompostable(0.3F, BlockInit.ARAUCARIA_SAPLING);
		registerCompostable(0.3F, BlockInit.METASEQUOIA_SAPLING);
		registerCompostable(0.3F, BlockInit.PROTOPICEOXYLON_SAPLING);
		registerCompostable(0.3F, BlockInit.ZAMITES_SAPLING);
		registerCompostable(0.3F, BlockInit.PROTOJUNIPER_SAPLING);
		registerCompostable(0.3F, BlockInit.HEIDIPHYLLUM_SAPLING);
		registerCompostable(0.3F, BlockInit.LIRIODENDRITES_SAPLING);
		//registerCompostable(0.3F, BlockInit.CYPRESS_SAPLING);
		registerCompostable(0.3F, BlockInit.HORSETAIL);
		registerCompostable(0.3F, BlockInit.OSMUNDA);
		registerCompostable(0.3F, BlockInit.CONIOPTERIS);
		registerCompostable(0.5F, BlockInit.DOUBLE_HORSETAIL);
		registerCompostable(0.5F, BlockInit.DOUBLE_OSMUNDA);
		registerCompostable(0.5F, BlockInit.OSMUNDACAULIS);
		registerCompostable(0.65F, BlockInit.CLUBMOSS);
		registerCompostable(0.65F, BlockInit.MARCHANTIA);
	}

	public static void registerFlammable(Block block, int encouragement, int flammability) {
		FireBlock fireblock = (FireBlock)Blocks.FIRE;
		fireblock.setFireInfo(block, encouragement, flammability);
	}

	public static void registerCompostable(float chance, IItemProvider item) {
		ComposterBlock.CHANCES.put(item.asItem(), chance);
	}

	@SubscribeEvent
	public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
		if(event.getItemStack().getItem() instanceof AxeItem) {
			World world = event.getWorld();
			BlockPos pos = event.getPos();
			BlockState state = world.getBlockState(pos);
			Block block = BLOCK_STRIPPING_MAP.get(state.getBlock());
			if(block != null) {
				PlayerEntity entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
				if(!world.isRemote) {
					world.setBlockState(pos, block.getDefaultState().with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);
					if(entity != null) {
						event.getItemStack().damageItem(1, entity, (p_220040_1_) -> {
							p_220040_1_.sendBreakAnimation(event.getHand());
						});
					}
				}
			}
		}
		if(event.getItemStack().getItem() == ItemInit.GEOLOGY_HAMMER.get() && PrehistoricFaunaConfig.geologyHammerMining == true) {
			World world = event.getWorld();
			BlockPos pos = event.getPos();
			BlockState state = world.getBlockState(pos);
			Block block = ROCK_SMASHING_MAP.get(state.getBlock());
			if(block != null) {
				PlayerEntity entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isRemote) {
					world.setBlockState(pos, block.getDefaultState(), 11);
					if(entity != null) {
						event.getItemStack().damageItem(1, entity, (p_220040_1_) -> {
							p_220040_1_.sendBreakAnimation(event.getHand());
						});
					}
				}
			}
		}
	}

}
