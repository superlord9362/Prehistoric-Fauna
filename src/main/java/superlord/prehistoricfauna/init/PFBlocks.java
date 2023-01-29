package superlord.prehistoricfauna.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.AncientPlantBlock;
import superlord.prehistoricfauna.common.blocks.MetasequoiaSaplingBlock;
import superlord.prehistoricfauna.common.blocks.MossBlock;
import superlord.prehistoricfauna.common.blocks.PrehistoricPlantBlock;
import superlord.prehistoricfauna.common.blocks.TallHorsetailBlock;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Bus.MOD)
public class PFBlocks {
	
	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<Block> HORSETAIL = REGISTER.register("horsetail", () -> new PrehistoricPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> OSMUNDA = REGISTER.register("osmunda", () -> new PrehistoricPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_HORSETAIL = REGISTER.register("tall_horsetail", () -> new TallHorsetailBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_OSMUNDA = REGISTER.register("tall_osmunda", () -> new DoublePlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> CLUBMOSS = REGISTER.register("clubmoss", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> MARCHANTIA = REGISTER.register("marchantia", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> MOSS_CARPET = REGISTER.register("moss_carpet", () -> new MossBlock(Block.Properties.of(Material.PLANT).strength(0.2F).sound(SoundType.GRASS)));
	
	public static final RegistryObject<Block> METASEQUOIA_PLANKS = REGISTER.register("metasequoia_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_LOG = REGISTER.register("metasequoia_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_METASEQUOIA_LOG = REGISTER.register("stripped_metasequoia_log", () -> createLog());
	public static final RegistryObject<Block> METASEQUOIA_WOOD = REGISTER.register("metasequoia_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_METASEQUOIA_WOOD = REGISTER.register("stripped_metasequoia_wood", () -> createLog());
	public static final RegistryObject<Block> METASEQUOIA_LEAVES = REGISTER.register("metasequoia_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> METASEQUOIA_SAPLING = REGISTER.register("metasequoia_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> METASEQUOIA_DOOR = REGISTER.register("metasequoia_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> METASEQUOIA_PRESSURE_PLATE = REGISTER.register("metasequoia_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_FENCE = REGISTER.register("metasequoia_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, METASEQUOIA_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_TRAPDOOR = REGISTER.register("metasequoia_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> METASEQUOIA_FENCE_GATE = REGISTER.register("metasequoia_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, METASEQUOIA_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_BUTTON = REGISTER.register("metasequoia_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_SLAB = REGISTER.register("metasequoia_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> ARAUCARIA_LOG = REGISTER.register("araucaria_log", () -> createLog());

	
	private static RotatedPillarBlock createLog() {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).sound(SoundType.WOOD));
	}
	
	private static LeavesBlock leaves(SoundType p_152615_) {
		return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(PFBlocks::allowsSpawnOnLeaves).isSuffocating(PFBlocks::never).isViewBlocking(PFBlocks::never));
	}
	
	private static Boolean allowsSpawnOnLeaves(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}

	private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
		return false;
	}

	private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}
	
}
