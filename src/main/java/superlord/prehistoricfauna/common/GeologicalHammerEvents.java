package superlord.prehistoricfauna.common;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.items.PFSpawnEggItem;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class GeologicalHammerEvents {
	
	public static Map<Block, Block> VANILLA_ROCK_SMASHING_MAP = new HashMap<>();

	static {
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.STONE, Blocks.COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.COBBLESTONE, Blocks.GRAVEL);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SANDSTONE, Blocks.SAND);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.RED_SANDSTONE, Blocks.RED_SAND);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_RED_SANDSTONE, Blocks.RED_SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_SANDSTONE, Blocks.SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE);
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
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.END_STONE_BRICKS, Blocks.END_STONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.PRISMARINE_BRICKS, Blocks.PRISMARINE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_DIORITE, Blocks.DIORITE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_ANDESITE, Blocks.ANDESITE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_GRANITE, Blocks.GRANITE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_BLACKSTONE, Blocks.BLACKSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.BLACKSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.MOSSY_STONE_BRICKS, Blocks.MOSSY_COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_BASALT, Blocks.BASALT);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.COBBLED_DEEPSLATE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_BASALT, Blocks.BASALT);
	}
	
	@SubscribeEvent
	public static void onBlockClicked(RightClickBlock event) {
		if (event.getItemStack().getItem() == Items.BONE_MEAL) {
			boolean flag = false;
			Level world = event.getWorld();
			BlockPos pos = event.getPos();
			BlockState state = event.getWorld().getBlockState(event.getPos());
			Player player = event.getPlayer();
			if (state.getBlock() == Blocks.DIRT && world.getBlockState(pos.above()).getBlock() == Blocks.AIR) {
				for(BlockPos blockpos : BlockPos.betweenClosed(event.getPos().offset(-1, -1, -1), event.getPos().offset(1, 1, 1))) {
					BlockState blockstate = event.getWorld().getBlockState(blockpos);
					if (blockstate.is(PFBlocks.MOSSY_DIRT.get())) {
						flag = true;
					}
				}
				if (flag) {
					event.getWorld().setBlock(event.getPos(), PFBlocks.MOSSY_DIRT.get().defaultBlockState(), 3);
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 1.7D;
					double d2 = (double)pos.getZ() + 0.5D;
					world.addParticle(ParticleTypes.HAPPY_VILLAGER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					if (!player.isCreative()) {
						event.getItemStack().shrink(1);
					}
				}
			}
		}
		if(event.getItemStack().getItem() == PFItems.GEOLOGY_HAMMER.get() && PrehistoricFaunaConfig.geologyHammerMining == true) {
			Level world = event.getWorld();
			BlockPos pos = event.getPos();
			BlockState state = world.getBlockState(pos);
			Block block3 = VANILLA_ROCK_SMASHING_MAP.get(state.getBlock());
			if (state.getBlock() == PFBlocks.SMOOTH_CHALK.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.CHALK.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if (state.getBlock() == PFBlocks.POLISHED_CHALK.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.CHALK.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if (state.getBlock() == PFBlocks.SMOOTH_SILTSTONE.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.SILTSTONE.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if (state.getBlock() == PFBlocks.POLISHED_SILTSTONE.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.SILTSTONE.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if (state.getBlock() == PFBlocks.SMOOTH_SANDSTONE.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.SANDSTONE.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if (state.getBlock() == PFBlocks.POLISHED_SANDSTONE.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.SANDSTONE.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if (state.getBlock() == PFBlocks.HENOSTONE_BRICKS.get()) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, PFBlocks.HENOSTONE.get().defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
			if(block3 != null) {
				Player entity = event.getPlayer();
				world.playSound(entity, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
				double d0 = (double)pos.getX() + 0.5D;
				double d1 = (double)pos.getY() + 0.7D;
				double d2 = (double)pos.getZ() + 0.5D;
				world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				if(!world.isClientSide) {
					world.setBlock(pos, block3.defaultBlockState(), 11);
					if(entity != null) {
						event.getItemStack().hurtAndBreak(1, entity, (p_220040_1_) -> {
							p_220040_1_.broadcastBreakEvent(event.getHand());
						});
					}
				}
			}
		}
	}

	public static void init() {
		PFSpawnEggItem.initSpawnEggs();
		if (PrehistoricFaunaConfig.geologyHammerMining == true) {
			DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior() {
				@Override
				protected ItemStack execute(BlockSource source, ItemStack stack) {
					Level world = source.getLevel();
					if (stack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
						BlockPos blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
						BlockState blockstate = world.getBlockState(blockpos);
						Block block3 = VANILLA_ROCK_SMASHING_MAP.get(blockstate.getBlock());
						if(block3 != null) {
							double d0 = (double)blockpos.getX() + 0.5D;
							double d1 = (double)blockpos.getY() + 0.7D;
							double d2 = (double)blockpos.getZ() + 0.5D;
							world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							if(!world.isClientSide) {
								world.setBlock(blockpos, block3.defaultBlockState(), 11);
							}
						}
						if (blockstate.getBlock() == PFBlocks.POLISHED_CHALK.get()) {
							if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							world.setBlockAndUpdate(blockpos, PFBlocks.CHALK.get().defaultBlockState());

						}
						if (blockstate.getBlock() == PFBlocks.POLISHED_SILTSTONE.get()) {
							if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							world.setBlockAndUpdate(blockpos, PFBlocks.SILTSTONE.get().defaultBlockState());

						}
						if (blockstate.getBlock() == PFBlocks.POLISHED_SANDSTONE.get()) {
							if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							world.setBlockAndUpdate(blockpos, PFBlocks.SANDSTONE.get().defaultBlockState());

						}
						if (blockstate.getBlock() == PFBlocks.SMOOTH_CHALK.get()) {
							if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							world.setBlockAndUpdate(blockpos, PFBlocks.CHALK.get().defaultBlockState());

						}
						if (blockstate.getBlock() == PFBlocks.SMOOTH_SILTSTONE.get()) {
							if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							world.setBlockAndUpdate(blockpos, PFBlocks.SILTSTONE.get().defaultBlockState());

						}
						if (blockstate.getBlock() == PFBlocks.SMOOTH_SANDSTONE.get()) {
							if (stack.hurt(1, world.random, (ServerPlayer)null)) {
								stack.setCount(0);
							}
							world.setBlockAndUpdate(blockpos, PFBlocks.SANDSTONE.get().defaultBlockState());

						}
					}
					return stack;
				}
			};
			DispenserBlock.registerBehavior(PFItems.GEOLOGY_HAMMER.get().asItem(), dispenseBehaviour);
		}
	}

}
