package superlord.prehistoricfauna.common;

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
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.ParrotEntity;
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
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFProfessions;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Bus.FORGE)
public class CommonEvents {
	
	public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();
	public static Map<Block, Block> ROCK_SMASHING_MAP = new HashMap<>();
	public static Map<Block, Block> VANILLA_ROCK_SMASHING_MAP = new HashMap<>();

	public static void registerFlammable(Block block, int encouragement, int flammability) {
		FireBlock fire = (FireBlock) Blocks.FIRE;
		fire.setFireInfo(block, encouragement, flammability);
	}
	
	public static void registerCompostable(float chance, IItemProvider item) {
		ComposterBlock.CHANCES.put(item.asItem(), chance);
	}
	
	public static void setup() {
		registerFlammable(PFBlocks.ARAUCARIA_PLANKS, 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_PLANKS, 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_SLAB, 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_SLAB, 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_FENCE, 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_FENCE, 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_STAIRS, 5, 20);
		registerFlammable(PFBlocks.METASEQUOIA_STAIRS, 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_PLANKS, 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_SLAB, 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_FENCE, 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_STAIRS, 5, 20);
		registerFlammable(PFBlocks.ZAMITES_PLANKS, 5, 20);
		registerFlammable(PFBlocks.ZAMITES_SLAB, 5, 20);
		registerFlammable(PFBlocks.ZAMITES_FENCE, 5, 20);
		registerFlammable(PFBlocks.ZAMITES_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.ZAMITES_STAIRS, 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_PLANKS, 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_SLAB, 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_FENCE, 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_STAIRS, 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_PLANKS, 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_SLAB, 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_FENCE, 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_STAIRS, 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_PLANKS, 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_SLAB, 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_FENCE, 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_FENCE_GATE, 5, 20);
		registerFlammable(PFBlocks.LIRIODENDRITES_STAIRS, 5, 20);
		registerFlammable(PFBlocks.ARAUCARIA_LOG, 5, 5);
		registerFlammable(PFBlocks.METASEQUOIA_LOG, 5, 5);
		registerFlammable(PFBlocks.METASEQUOIA_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ARAUCARIA_LOG, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_METASEQUOIA_LOG, 5, 5);
		registerFlammable(PFBlocks.ARAUCARIA_WOOD, 5, 5);
		registerFlammable(PFBlocks.METASEQUOIA_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ARAUCARIA_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_METASEQUOIA_WOOD, 5, 5);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_LOG, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOPICEOXYLON_LOG, 5, 5);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOPICEOXYLON_WOOD, 5, 5);
		registerFlammable(PFBlocks.ZAMITES_LOG, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ZAMITES_LOG, 5, 5);
		registerFlammable(PFBlocks.ZAMITES_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_ZAMITES_WOOD, 5, 5);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_LOG, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_LOG, 5, 5);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_WOOD, 5, 5);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_LOG, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_HEIDIPHYLLUM_LOG, 5, 5);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_HEIDIPHYLLUM_WOOD, 5, 5);
		registerFlammable(PFBlocks.LIRIODENDRITES_LOG, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_LIRIODENDRITES_LOG, 5, 5);
		registerFlammable(PFBlocks.LIRIODENDRITES_WOOD, 5, 5);
		registerFlammable(PFBlocks.STRIPPED_LIRIODENDRITES_WOOD, 5, 5);
		//registerFlammable(PFBlocks.CYPRESS_LOG, 5, 5);
		//registerFlammable(PFBlocks.STRIPPED_CYPRESS_LOG, 5, 5);
		//registerFlammable(PFBlocks.CYPRESS_WOOD, 5, 5);
		//registerFlammable(PFBlocks.STRIPPED_CYPRESS_WOOD, 5, 5);
		registerFlammable(PFBlocks.ARAUCARIA_LEAVES, 30, 60);
		registerFlammable(PFBlocks.METASEQUOIA_LEAVES, 30, 60);
		registerFlammable(PFBlocks.PROTOPICEOXYLON_LEAVES, 30, 60);
		registerFlammable(PFBlocks.ZAMITES_LEAVES, 30, 60);
		registerFlammable(PFBlocks.PROTOJUNIPEROXYLON_LEAVES, 30, 60);
		registerFlammable(PFBlocks.HEIDIPHYLLUM_LEAVES, 30, 60);
		registerFlammable(PFBlocks.LIRIODENDRITES_LEAVES, 30, 60);;
		//registerFlammable(PFBlocks.CYPRESS_LEAVES, 30, 60);
		registerFlammable(PFBlocks.CLUBMOSS, 60, 100);
		registerFlammable(PFBlocks.HORSETAIL, 60, 100);
		registerFlammable(PFBlocks.OSMUNDA, 60, 100);
		registerFlammable(PFBlocks.OSMUNDACAULIS, 60, 100);
		registerFlammable(PFBlocks.DEAD_OSMUNDACAULIS, 60, 100);
		registerFlammable(PFBlocks.MARCHANTIA, 60, 100);
		registerFlammable(PFBlocks.TALL_HORSETAIL, 60, 100);
		registerFlammable(PFBlocks.TALL_OSMUNDA, 60, 100);
		registerFlammable(PFBlocks.CONIOPTERIS, 60, 100);
		registerFlammable(PFBlocks.TALL_OSMUNDACAULIS, 60, 100);
		registerFlammable(PFBlocks.MOSS_CARPET, 60, 20);
		registerFlammable(PFBlocks.MOSS_BLOCK, 60, 20);
		registerCompostable(0.3F, PFBlocks.ARAUCARIA_LEAVES);
		registerCompostable(0.3F, PFBlocks.METASEQUOIA_LEAVES);
		registerCompostable(0.3F, PFBlocks.PROTOPICEOXYLON_LEAVES);
		registerCompostable(0.3F, PFBlocks.ZAMITES_LEAVES);
		registerCompostable(0.3F, PFBlocks.PROTOJUNIPEROXYLON_LEAVES);
		registerCompostable(0.3F, PFBlocks.HEIDIPHYLLUM_LEAVES);
		registerCompostable(0.3F, PFBlocks.LIRIODENDRITES_LEAVES);
		//registerCompostable(0.3F, PFBlocks.CYPRESS_LEAVES);
		registerCompostable(0.3F, PFBlocks.ARAUCARIA_SAPLING);
		registerCompostable(0.3F, PFBlocks.METASEQUOIA_SAPLING);
		registerCompostable(0.3F, PFBlocks.PROTOPICEOXYLON_SAPLING);
		registerCompostable(0.3F, PFBlocks.ZAMITES_SAPLING);
		registerCompostable(0.3F, PFBlocks.PROTOJUNIPEROXYLON_SAPLING);
		registerCompostable(0.3F, PFBlocks.HEIDIPHYLLUM_SAPLING);
		registerCompostable(0.3F, PFBlocks.LIRIODENDRITES_SAPLING);
		//registerCompostable(0.3F, PFBlocks.CYPRESS_SAPLING);
		registerCompostable(0.3F, PFBlocks.HORSETAIL);
		registerCompostable(0.3F, PFBlocks.OSMUNDA);
		registerCompostable(0.3F, PFBlocks.CLADOPHLEBIS);
		registerCompostable(0.3F, PFItems.MOSS_BALL.get());
		registerCompostable(0.3F, PFItems.PTILOPHYLLUM_FRONDS.get());
		registerCompostable(0.3F, PFBlocks.MICHELILLOA);
		registerCompostable(0.3F, PFBlocks.ALGAE_CARPET);
		registerCompostable(0.3F, PFBlocks.MOSS_CARPET);
		registerCompostable(0.3F, PFBlocks.CONIOPTERIS);
		registerCompostable(0.3F, PFBlocks.OSMUNDACAULIS);
		registerCompostable(0.5F, PFBlocks.TALL_HORSETAIL);
		registerCompostable(0.5F, PFBlocks.MOSS_BLOCK);
		registerCompostable(0.5F, PFBlocks.SCYTOPHYLLUM);
		registerCompostable(0.5F, PFBlocks.TALL_OSMUNDA);
		registerCompostable(0.5F, PFBlocks.TALL_OSMUNDACAULIS);
		registerCompostable(0.65F, PFBlocks.JOHNSTONIA);
		registerCompostable(0.75F, PFBlocks.DICROIDIUM);
		registerCompostable(0.65F, PFBlocks.CLUBMOSS);
		registerCompostable(0.65F, PFBlocks.MARCHANTIA);
	}

	static {
		BLOCK_STRIPPING_MAP.put(PFBlocks.METASEQUOIA_LOG, PFBlocks.STRIPPED_METASEQUOIA_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.METASEQUOIA_WOOD, PFBlocks.STRIPPED_METASEQUOIA_WOOD);
		BLOCK_STRIPPING_MAP.put(PFBlocks.ARAUCARIA_LOG, PFBlocks.STRIPPED_ARAUCARIA_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.ARAUCARIA_WOOD, PFBlocks.STRIPPED_ARAUCARIA_WOOD);
		BLOCK_STRIPPING_MAP.put(PFBlocks.PROTOPICEOXYLON_LOG, PFBlocks.STRIPPED_PROTOPICEOXYLON_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.PROTOPICEOXYLON_WOOD, PFBlocks.STRIPPED_PROTOPICEOXYLON_WOOD);
		BLOCK_STRIPPING_MAP.put(PFBlocks.ZAMITES_LOG, PFBlocks.STRIPPED_ZAMITES_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.ZAMITES_WOOD, PFBlocks.STRIPPED_ZAMITES_WOOD);
		BLOCK_STRIPPING_MAP.put(PFBlocks.PROTOJUNIPEROXYLON_LOG, PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.PROTOJUNIPEROXYLON_WOOD, PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_WOOD);
		BLOCK_STRIPPING_MAP.put(PFBlocks.HEIDIPHYLLUM_LOG, PFBlocks.STRIPPED_HEIDIPHYLLUM_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.HEIDIPHYLLUM_WOOD, PFBlocks.STRIPPED_HEIDIPHYLLUM_WOOD);
		BLOCK_STRIPPING_MAP.put(PFBlocks.LIRIODENDRITES_LOG, PFBlocks.STRIPPED_LIRIODENDRITES_LOG);
		BLOCK_STRIPPING_MAP.put(PFBlocks.LIRIODENDRITES_WOOD, PFBlocks.STRIPPED_LIRIODENDRITES_WOOD);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.STONE, Blocks.COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.COBBLESTONE, Blocks.GRAVEL);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SANDSTONE, Blocks.SAND);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.RED_SANDSTONE, Blocks.RED_SAND);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_RED_SANDSTONE, Blocks.RED_SANDSTONE);
		ROCK_SMASHING_MAP.put(PFBlocks.SMOOTH_CHALK, PFBlocks.CHALK);
		ROCK_SMASHING_MAP.put(PFBlocks.SMOOTH_SILTSTONE, PFBlocks.SILTSTONE);
		ROCK_SMASHING_MAP.put(PFBlocks.SMOOTH_SANDSTONE, PFBlocks.SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.SMOOTH_SANDSTONE, Blocks.SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CRACKED_STONE_BRICKS, Blocks.COBBLESTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE);
		VANILLA_ROCK_SMASHING_MAP.put(Blocks.CUT_SANDSTONE, Blocks.SANDSTONE);
		ROCK_SMASHING_MAP.put(PFBlocks.POLISHED_CHALK, PFBlocks.CHALK);
		ROCK_SMASHING_MAP.put(PFBlocks.POLISHED_SILTSTONE, PFBlocks.SILTSTONE);
		ROCK_SMASHING_MAP.put(PFBlocks.POLISHED_SANDSTONE, PFBlocks.SANDSTONE);
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
		//BLOCK_STRIPPING_MAP.put(PFBlocks.CYPRESS_LOG, PFBlocks.STRIPPED_CYPRESS_LOG);
		//BLOCK_STRIPPING_MAP.put(PFBlocks.CYPRESS_WOOD, PFBlocks.STRIPPED_CYPRESS_WOOD);
	}
	
	@SubscribeEvent
	public void onVillagerTrades(VillagerTradesEvent event) {
		if (event.getType() == PFProfessions.GEOLOGIST) {
			PFProfessions.addGeologistTrades(event.getTrades());
		}
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
		if(event.getItemStack().getItem() == PFItems.GEOLOGY_HAMMER.get() && PrehistoricFaunaConfig.geologyHammerMining == true) {
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


		if(stateBelow1 == Blocks.EMERALD_BLOCK.getDefaultState() && stateBelow2 == PFBlocks.HENOSTONE.getDefaultState() && stateArmNorth == PFBlocks.HENOSTONE.getDefaultState() && stateArmSouth == PFBlocks.HENOSTONE.getDefaultState()) {
			final TimeGuardianEntity timeGuardianEntity = PFEntities.TIME_GUARDIAN_ENTITY.create(world);
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
		if(stateBelow1 == Blocks.EMERALD_BLOCK.getDefaultState() && stateBelow2 == PFBlocks.HENOSTONE.getDefaultState() && stateArmEast == PFBlocks.HENOSTONE.getDefaultState() && stateArmWest == PFBlocks.HENOSTONE.getDefaultState()) {
			final TimeGuardianEntity timeGuardianEntity = PFEntities.TIME_GUARDIAN_ENTITY.create(world);
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
	
	public static void init() {
		if (PrehistoricFaunaConfig.geologyHammerMining == true) {
			DispenserBlock.registerDispenseBehavior(PFItems.GEOLOGY_HAMMER.get().asItem(), new OptionalDispenseBehavior() {
				protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
					World world = source.getWorld();
					if (!world.isRemote()) {
						this.setSuccessful(false);
						BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
						if (!this.isSuccessful()) {
							BlockState blockstate = world.getBlockState(blockpos);
							if (blockstate.getBlock() == Blocks.STONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.COBBLESTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.COBBLESTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.GRAVEL.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.SAND.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.RED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_SAND.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.SMOOTH_RED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_SANDSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.SMOOTH_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.SANDSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.STONE_BRICKS) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.CRACKED_STONE_BRICKS.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.CRACKED_STONE_BRICKS) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.COBBLESTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.CUT_RED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_SANDSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.CUT_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.SANDSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.BLACK_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.BLUE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BLUE_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.BROWN_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BROWN_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.CYAN_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.CYAN_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.GRAY_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.GRAY_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.GREEN_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.GREEN_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.LIGHT_BLUE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.LIGHT_GRAY_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.LIGHT_GRAY_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.LIME_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.LIME_CONCRETE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.MAGENTA_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.ORANGE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.ORANGE_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.PINK_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.PINK_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.PURPLE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.PURPLE_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.RED_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.RED_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.WHITE_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.WHITE_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == Blocks.BLACK_CONCRETE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == PFBlocks.POLISHED_CHALK) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, PFBlocks.CHALK.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == PFBlocks.POLISHED_SILTSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, PFBlocks.SILTSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == PFBlocks.POLISHED_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, PFBlocks.SANDSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == PFBlocks.SMOOTH_CHALK) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, PFBlocks.CHALK.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == PFBlocks.SMOOTH_SILTSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, PFBlocks.SILTSTONE.getDefaultState());
								this.setSuccessful(true);
							}
							if (blockstate.getBlock() == PFBlocks.SMOOTH_SANDSTONE) {
								if (stack.attemptDamageItem(1, world.rand, (ServerPlayerEntity)null)) {
									stack.setCount(0);
								}
								world.setBlockState(blockpos, PFBlocks.SANDSTONE.getDefaultState());
								this.setSuccessful(true);
							}
						}
					}

					return stack;
				}
			});
		}
	}

	@SubscribeEvent
	public void summonHenosEvent(BlockEvent.EntityPlaceEvent event) {
		if (!event.isCanceled() && event.getPlacedBlock().getBlock() == PFBlocks.LARGE_AMMONITE_FOSSIL && event.getWorld() instanceof World) {
			trySpawnGolem((World) event.getWorld(), event.getPos());
		}
	}
	
	public boolean deadBirds = false;

	@SubscribeEvent
	public void spaceTimeContinuumWarping(LivingDeathEvent event) {
		if (PrehistoricFaunaConfig.spaceTimeContinuumWarping) {
			if (event.getEntity() instanceof HesperornithoidesEntity) {
				if (event.getSource().getTrueSource() instanceof PlayerEntity) {
					this.deadBirds = true;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void killChickensFromSpaceTimeWarping(EntityJoinWorldEvent event) {
		if (this.deadBirds == true) {
			Entity entity = event.getEntity();
			if (event.getEntity() instanceof ChickenEntity || event.getEntity() instanceof ParrotEntity) {
				entity.remove();
			}
		}
	}

}
