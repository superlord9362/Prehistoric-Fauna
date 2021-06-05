package superlord.prehistoricfauna.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.entity.TimeGuardianEntity;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.init.PrehistoricProfessionInit;
import superlord.prehistoricfauna.PrehistoricFauna;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.FORGE)
public class CommonEvents {
	public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();
	public static Map<Block, Block> ROCK_SMASHING_MAP = new HashMap<>();
	public static Map<Block, Block> VANILLA_ROCK_SMASHING_MAP = new HashMap<>();


	static {
		BLOCK_STRIPPING_MAP.put(BlockInit.METASEQUOIA_LOG, BlockInit.STRIPPED_METASEQUOIA_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.METASEQUOIA_WOOD, BlockInit.STRIPPED_METASEQUOIA_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.ARAUCARIA_LOG, BlockInit.STRIPPED_ARAUCARIA_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.ARAUCARIA_WOOD, BlockInit.STRIPPED_ARAUCARIA_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOPICEOXYLON_LOG, BlockInit.STRIPPED_PROTOPICEOXYLON_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOPICEOXYLON_WOOD, BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.ZAMITES_LOG, BlockInit.STRIPPED_ZAMITES_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.ZAMITES_WOOD, BlockInit.STRIPPED_ZAMITES_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOJUNIPEROXYLON_LOG, BlockInit.STRIPPED_PROTOJUNIPEROXYLON_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.PROTOJUNIPEROXYLON_WOOD, BlockInit.STRIPPED_PROTOJUNIPEROXYLON_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.HEIDIPHYLLUM_LOG, BlockInit.STRIPPED_HEIDIPHYLLUM_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.HEIDIPHYLLUM_WOOD, BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD);
		BLOCK_STRIPPING_MAP.put(BlockInit.LIRIODENDRITES_LOG, BlockInit.STRIPPED_LIRIODENDRITES_LOG);
		BLOCK_STRIPPING_MAP.put(BlockInit.LIRIODENDRITES_WOOD, BlockInit.STRIPPED_LIRIODENDRITES_WOOD);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.STONE, Blocks.COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.COBBLESTONE, Blocks.GRAVEL);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SANDSTONE, Blocks.SAND);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.RED_SANDSTONE, Blocks.RED_SAND);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_RED_SANDSTONE, Blocks.RED_SANDSTONE);
		ROCK_SMASHING_MAP.put(BlockInit.SMOOTH_CHALK, BlockInit.CHALK);
		ROCK_SMASHING_MAP.put(BlockInit.SMOOTH_SILTSTONE, BlockInit.SILTSTONE);
		ROCK_SMASHING_MAP.put(BlockInit.SMOOTH_SANDSTONE, BlockInit.SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_SANDSTONE, Blocks.SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE);
		ROCK_SMASHING_MAP.put(BlockInit.POLISHED_CHALK, BlockInit.CHALK);
		ROCK_SMASHING_MAP.put(BlockInit.POLISHED_SILTSTONE, BlockInit.SILTSTONE);
		ROCK_SMASHING_MAP.put(BlockInit.POLISHED_SANDSTONE, BlockInit.SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.BLACK_CONCRETE, Blocks.BLACK_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.BLUE_CONCRETE, Blocks.BLUE_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.BROWN_CONCRETE, Blocks.BROWN_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CYAN_CONCRETE, Blocks.CYAN_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.GRAY_CONCRETE, Blocks.GRAY_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.GREEN_CONCRETE, Blocks.GREEN_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.LIME_CONCRETE, Blocks.LIME_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.PINK_CONCRETE, Blocks.PINK_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.RED_CONCRETE, Blocks.RED_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.WHITE_CONCRETE, Blocks.WHITE_CONCRETE_POWDER);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE_POWDER);
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
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_PLANKS, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_SLAB, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_FENCE, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_FENCE_GATE, 5, 20);
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_STAIRS, 5, 20);
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
		registerFlammable(BlockInit.ARAUCARIA_LOG, 5, 5);
		registerFlammable(BlockInit.METASEQUOIA_LOG, 5, 5);
		registerFlammable(BlockInit.METASEQUOIA_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_ARAUCARIA_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_METASEQUOIA_LOG, 5, 5);
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
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_LOG, 5, 5);
		registerFlammable(BlockInit.STRIPPED_PROTOJUNIPEROXYLON_LOG, 5, 5);
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_WOOD, 5, 5);
		registerFlammable(BlockInit.STRIPPED_PROTOJUNIPEROXYLON_WOOD, 5, 5);
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
		registerFlammable(BlockInit.PROTOJUNIPEROXYLON_LEAVES, 30, 60);
		registerFlammable(BlockInit.HEIDIPHYLLUM_LEAVES, 30, 60);
		registerFlammable(BlockInit.LIRIODENDRITES_LEAVES, 30, 60);;
		//registerFlammable(BlockInit.CYPRESS_LEAVES, 30, 60);
		registerFlammable(BlockInit.CLUBMOSS, 60, 100);
		registerFlammable(BlockInit.HORSETAIL, 60, 100);
		registerFlammable(BlockInit.OSMUNDA, 60, 100);
		registerFlammable(BlockInit.OSMUNDACAULIS, 60, 100);
		registerFlammable(BlockInit.DEAD_OSMUNDACAULIS, 60, 100);
		registerFlammable(BlockInit.MARCHANTIA, 60, 100);
		registerFlammable(BlockInit.TALL_HORSETAIL, 60, 100);
		registerFlammable(BlockInit.TALL_OSMUNDA, 60, 100);
		registerFlammable(BlockInit.CONIOPTERIS, 60, 100);
		registerFlammable(BlockInit.TALL_OSMUNDACAULIS, 60, 100);
		registerFlammable(BlockInit.MOSS_CARPET, 60, 20);
		registerFlammable(BlockInit.MOSS_BLOCK, 60, 20);
		registerCompostable(0.3F, BlockInit.ARAUCARIA_LEAVES);
		registerCompostable(0.3F, BlockInit.METASEQUOIA_LEAVES);
		registerCompostable(0.3F, BlockInit.PROTOPICEOXYLON_LEAVES);
		registerCompostable(0.3F, BlockInit.ZAMITES_LEAVES);
		registerCompostable(0.3F, BlockInit.PROTOJUNIPEROXYLON_LEAVES);
		registerCompostable(0.3F, BlockInit.HEIDIPHYLLUM_LEAVES);
		registerCompostable(0.3F, BlockInit.LIRIODENDRITES_LEAVES);
		//registerCompostable(0.3F, BlockInit.CYPRESS_LEAVES);
		registerCompostable(0.3F, BlockInit.ARAUCARIA_SAPLING);
		registerCompostable(0.3F, BlockInit.METASEQUOIA_SAPLING);
		registerCompostable(0.3F, BlockInit.PROTOPICEOXYLON_SAPLING);
		registerCompostable(0.3F, BlockInit.ZAMITES_SAPLING);
		registerCompostable(0.3F, BlockInit.PROTOJUNIPEROXYLON_SAPLING);
		registerCompostable(0.3F, BlockInit.HEIDIPHYLLUM_SAPLING);
		registerCompostable(0.3F, BlockInit.LIRIODENDRITES_SAPLING);
		//registerCompostable(0.3F, BlockInit.CYPRESS_SAPLING);
		registerCompostable(0.3F, BlockInit.HORSETAIL);
		registerCompostable(0.3F, BlockInit.OSMUNDA);
		registerCompostable(0.3F, BlockInit.CONIOPTERIS);
		registerCompostable(0.3F, BlockInit.OSMUNDACAULIS);
		registerCompostable(0.5F, BlockInit.TALL_HORSETAIL);
		registerCompostable(0.5F, BlockInit.TALL_OSMUNDA);
		registerCompostable(0.5F, BlockInit.TALL_OSMUNDACAULIS);
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
			Block block2 = ROCK_SMASHING_MAP.get(state.getBlock());
			Block block3 = VANILLA_ROCK_SMASHING_MAP.get(state.getBlock());
			if(block2 != null) {
				PlayerEntity entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isRemote) {
					world.setBlockState(pos, block2.getDefaultState(), 11);
					if(entity != null) {
						event.getItemStack().damageItem(1, entity, (p_220040_1_) -> {
							p_220040_1_.sendBreakAnimation(event.getHand());
						});
					}
				}
			}
			if(block3 != null) {
				PlayerEntity entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.BLOCK_STONE_HIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isRemote) {
					world.setBlockState(pos, block3.getDefaultState(), 11);
					if(entity != null) {
						event.getItemStack().damageItem(1, entity, (p_220040_1_) -> {
							p_220040_1_.sendBreakAnimation(event.getHand());
						});
					}
				}
			}
		}
	}

	public static void init() {
		if (PrehistoricFaunaConfig.geologyHammerMining == true) {
			DispenserBlock.registerDispenseBehavior(ItemInit.GEOLOGY_HAMMER.get().asItem(), new OptionalDispenseBehavior() {
				protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
					World world = source.getWorld();
					if (!world.isRemote()) {
						this.successful = false;
						BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
						if (!this.successful) {
							BlockState blockstate = world.getBlockState(blockpos);
							if (blockstate.getBlock() == Blocks.STONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.COBBLESTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.COBBLESTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.GRAVEL.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.SAND.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.RED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_SAND.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.SMOOTH_RED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_SANDSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.SMOOTH_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.SANDSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.STONE_BRICKS) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.CRACKED_STONE_BRICKS.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.CRACKED_STONE_BRICKS) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.COBBLESTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.CUT_RED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_SANDSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.CUT_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.SANDSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.BLACK_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.BLUE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BLUE_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.BROWN_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BROWN_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.CYAN_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.CYAN_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.GRAY_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.GRAY_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.GREEN_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.GREEN_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.LIGHT_BLUE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.LIGHT_GRAY_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.LIGHT_GRAY_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.LIME_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.LIME_CONCRETE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.MAGENTA_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.ORANGE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.ORANGE_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.PINK_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.PINK_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.PURPLE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.PURPLE_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.RED_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.WHITE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.WHITE_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == Blocks.BLACK_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == BlockInit.POLISHED_CHALK) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, BlockInit.CHALK.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == BlockInit.POLISHED_SILTSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, BlockInit.SILTSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == BlockInit.POLISHED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, BlockInit.SANDSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == BlockInit.SMOOTH_CHALK) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, BlockInit.CHALK.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == BlockInit.SMOOTH_SILTSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, BlockInit.SILTSTONE.getDefaultState());
								this.successful = true;
							}
							if (blockstate.getBlock() == BlockInit.SMOOTH_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, BlockInit.SANDSTONE.getDefaultState());
								this.successful = true;
							}
						}
					}

					return stack;
				}
			});
		}
	}

	@SubscribeEvent
	public void onVillagerTrades(VillagerTradesEvent event) {
		if (event.getType() == PrehistoricProfessionInit.GEOLOGIST) {
			PrehistoricProfessionInit.addGeologistTrades(event.getTrades());
		}
	}

	public static boolean trySpawnGolem(final World world, final BlockPos headPos) {
		if (world.isRemote) {
			return false;
		}
		final BlockState stateBelow1 = world.getBlockState(headPos.down(1));
		final BlockState stateBelow2 = world.getBlockState(headPos.down(2));
		final BlockState stateArmNorth = world.getBlockState(headPos.down(1).north(1));
		final BlockState stateArmSouth = world.getBlockState(headPos.down(1).south(1));
		final BlockState stateArmEast = world.getBlockState(headPos.down(1).east(1));
		final BlockState stateArmWest = world.getBlockState(headPos.down(1).west(1));

		final double spawnX = headPos.getX() + 0.5D;
		final double spawnY = headPos.getY() - 1.95D;
		final double spawnZ = headPos.getZ() + 0.5D;


		if(stateBelow1 == Blocks.EMERALD_BLOCK.getDefaultState() && stateBelow2 == BlockInit.HENOSTONE.getDefaultState() && stateArmNorth == BlockInit.HENOSTONE.getDefaultState() && stateArmSouth == BlockInit.HENOSTONE.getDefaultState()) {
			final TimeGuardianEntity timeGuardianEntity = ModEntityTypes.TIME_GUARDIAN_ENTITY.create(world);
			timeGuardianEntity.setSummoned(true);
			timeGuardianEntity.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
			world.addEntity(timeGuardianEntity);
			world.setBlockState(headPos.down(1), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos.down(2), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos.down(1).north(1), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos.down(1).south(1), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos, Blocks.AIR.getDefaultState());
			return true;
		}
		if(stateBelow1 == Blocks.EMERALD_BLOCK.getDefaultState() && stateBelow2 == BlockInit.HENOSTONE.getDefaultState() && stateArmEast == BlockInit.HENOSTONE.getDefaultState() && stateArmWest == BlockInit.HENOSTONE.getDefaultState()) {
			final TimeGuardianEntity timeGuardianEntity = ModEntityTypes.TIME_GUARDIAN_ENTITY.create(world);
			timeGuardianEntity.setSummoned(true);
			timeGuardianEntity.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
			world.addEntity(timeGuardianEntity);
			world.setBlockState(headPos.down(1), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos.down(2), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos.down(1).east(1), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos.down(1).west(1), Blocks.AIR.getDefaultState());
			world.setBlockState(headPos, Blocks.AIR.getDefaultState());
			return true;
		}
		return false;
	}

	@SubscribeEvent
	public void summonHenosEvent(BlockEvent.EntityPlaceEvent event) {
		if (!event.isCanceled() && event.getPlacedBlock().getBlock() == BlockInit.LARGE_AMMONITE_FOSSIL && event.getWorld() instanceof World) {
			trySpawnGolem((World) event.getWorld(), event.getPos());
		}
	}

}