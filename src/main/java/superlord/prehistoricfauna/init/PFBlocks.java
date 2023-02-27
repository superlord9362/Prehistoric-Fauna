package superlord.prehistoricfauna.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.AlgaeBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteGiantShellBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteLargeShellBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteMediumShellBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteSmallShellBlock;
import superlord.prehistoricfauna.common.blocks.AncientPlantBlock;
import superlord.prehistoricfauna.common.blocks.CrassostreaOysterBlock;
import superlord.prehistoricfauna.common.blocks.DeadCycadBlock;
import superlord.prehistoricfauna.common.blocks.DicroidiumBlock;
import superlord.prehistoricfauna.common.blocks.HardenedSiltBlock;
import superlord.prehistoricfauna.common.blocks.JohnstoniaBlock;
import superlord.prehistoricfauna.common.blocks.LiriodendritesLeavesBlock;
import superlord.prehistoricfauna.common.blocks.MetasequoiaSaplingBlock;
import superlord.prehistoricfauna.common.blocks.MossBlock;
import superlord.prehistoricfauna.common.blocks.PFStandingSignBlock;
import superlord.prehistoricfauna.common.blocks.PFWallSignBlock;
import superlord.prehistoricfauna.common.blocks.PrehistoricPlantBlock;
import superlord.prehistoricfauna.common.blocks.PtilophyllumBaseBlock;
import superlord.prehistoricfauna.common.blocks.PtilophyllumBlock;
import superlord.prehistoricfauna.common.blocks.TallHorsetailBlock;
import superlord.prehistoricfauna.common.blocks.TrapBlock;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Bus.MOD)
@SuppressWarnings("deprecation")
public class PFBlocks {
	
	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<Block> HORSETAIL = REGISTER.register("horsetail", () -> new PrehistoricPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> OSMUNDA = REGISTER.register("osmunda", () -> new PrehistoricPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_HORSETAIL = REGISTER.register("tall_horsetail", () -> new TallHorsetailBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_OSMUNDA = REGISTER.register("tall_osmunda", () -> new DoublePlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> CLUBMOSS = REGISTER.register("clubmoss", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> MARCHANTIA = REGISTER.register("marchantia", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> MOSS_CARPET = REGISTER.register("moss_carpet", () -> new MossBlock(Block.Properties.of(Material.PLANT).strength(0.2F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CONIOPTERIS = REGISTER.register("coniopteris", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> OSMUNDACAULIS = REGISTER.register("osmundacaulis", () -> new PrehistoricPlantBlock(Block.Properties.of(Material.PLANT).strength(0.2F).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> TALL_OSMUNDACAULIS = REGISTER.register("tall_osmundacaulis", () -> new DoublePlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> CLADOPHLEBIS = REGISTER.register("cladophlebis", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> SCYTOPHYLLUM = REGISTER.register("scytophyllum", () -> new TallFlowerBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> MICHELILLOA = REGISTER.register("michelilloa", () -> new AncientPlantBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> DEAD_OSMUNDACAULIS = REGISTER.register("dead_osmundacaulis", () -> new DeadCycadBlock(Block.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
	public static final RegistryObject<Block> CRASSOSTREA_OYSTER = REGISTER.register("crassostrea_oyster", () -> new CrassostreaOysterBlock(Block.Properties.of(Material.STONE).noCollission().strength(0.5F).randomTicks()));
	public static final RegistryObject<Block> ALGAE_CARPET = REGISTER.register("algae_carpet", () -> new AlgaeBlock(Properties.of(Material.WATER_PLANT).strength(0.2F).sound(SoundType.SLIME_BLOCK).noOcclusion()));
	
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
	public static final RegistryObject<Block> METASEQUOIA_TRAPDOOR = REGISTER.register("metasequoia_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).noOcclusion().strength(3.0F).sound(SoundType.WOOD).isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> METASEQUOIA_FENCE_GATE = REGISTER.register("metasequoia_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, METASEQUOIA_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_BUTTON = REGISTER.register("metasequoia_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_SLAB = REGISTER.register("metasequoia_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> METASEQUOIA_STAIRS = REGISTER.register("metasequoia_stairs", () -> new StairBlock(METASEQUOIA_PLANKS.get().defaultBlockState(), Block.Properties.copy(METASEQUOIA_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> METASEQUOIA_SIGN = REGISTER.register("metasequoia_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.METASEQUOIA));
	public static final RegistryObject<PFWallSignBlock> METASEQUOIA_WALL_SIGN = REGISTER.register("metasequoia_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(METASEQUOIA_SIGN.get()), PFWoodTypes.METASEQUOIA));
	
	public static final RegistryObject<Block> ARAUCARIA_PLANKS = REGISTER.register("araucaria_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_LOG = REGISTER.register("araucaria_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_LOG = REGISTER.register("stripped_araucaria_log", () -> createLog());
	public static final RegistryObject<Block> ARAUCARIA_WOOD = REGISTER.register("araucaria_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_WOOD = REGISTER.register("stripped_araucaria_wood", () -> createLog());
	public static final RegistryObject<Block> ARAUCARIA_LEAVES = REGISTER.register("araucaria_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> ARAUCARIA_SAPLING = REGISTER.register("araucaria_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ARAUCARIA_DOOR = REGISTER.register("araucaria_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> ARAUCARIA_PRESSURE_PLATE = REGISTER.register("araucaria_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_FENCE = REGISTER.register("araucaria_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, ARAUCARIA_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_TRAPDOOR = REGISTER.register("araucaria_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> ARAUCARIA_FENCE_GATE = REGISTER.register("araucaria_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, ARAUCARIA_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_BUTTON = REGISTER.register("araucaria_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_SLAB = REGISTER.register("araucaria_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ARAUCARIA_STAIRS = REGISTER.register("araucaria_stairs", () -> new StairBlock(ARAUCARIA_PLANKS.get().defaultBlockState(), Block.Properties.copy(ARAUCARIA_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> ARAUCARIA_SIGN = REGISTER.register("araucaria_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.ARAUCARIA));
	public static final RegistryObject<PFWallSignBlock> ARAUCARIA_WALL_SIGN = REGISTER.register("araucaria_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(ARAUCARIA_SIGN.get()), PFWoodTypes.ARAUCARIA));

	public static final RegistryObject<Block> PROTOPICEOXYLON_PLANKS = REGISTER.register("protopiceoxylon_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_LOG = REGISTER.register("protopiceoxylon_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_PROTOPICEOXYLON_LOG = REGISTER.register("stripped_protopiceoxylon_log", () -> createLog());
	public static final RegistryObject<Block> PROTOPICEOXYLON_WOOD = REGISTER.register("protopiceoxylon_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_PROTOPICEOXYLON_WOOD = REGISTER.register("stripped_protopiceoxylon_wood", () -> createLog());
	public static final RegistryObject<Block> PROTOPICEOXYLON_LEAVES = REGISTER.register("protopiceoxylon_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> PROTOPICEOXYLON_SAPLING = REGISTER.register("protopiceoxylon_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_DOOR = REGISTER.register("protopiceoxylon_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> PROTOPICEOXYLON_PRESSURE_PLATE = REGISTER.register("protopiceoxylon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_FENCE = REGISTER.register("protopiceoxylon_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, PROTOPICEOXYLON_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_TRAPDOOR = REGISTER.register("protopiceoxylon_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_FENCE_GATE = REGISTER.register("protopiceoxylon_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, PROTOPICEOXYLON_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_BUTTON = REGISTER.register("protopiceoxylon_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_SLAB = REGISTER.register("protopiceoxylon_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOPICEOXYLON_STAIRS = REGISTER.register("protopiceoxylon_stairs", () -> new StairBlock(PROTOPICEOXYLON_PLANKS.get().defaultBlockState(), Block.Properties.copy(PROTOPICEOXYLON_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> PROTOPICEOXYLON_SIGN = REGISTER.register("protopiceoxylon_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOPICEOXYLON));
	public static final RegistryObject<PFWallSignBlock> PROTOPICEOXYLON_WALL_SIGN = REGISTER.register("protopiceoxylon_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(PROTOPICEOXYLON_SIGN.get()), PFWoodTypes.PROTOPICEOXYLON));

	public static final RegistryObject<Block> ZAMITES_PLANKS = REGISTER.register("zamites_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZAMITES_LOG = REGISTER.register("zamites_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_ZAMITES_LOG = REGISTER.register("stripped_zamites_log", () -> createLog());
	public static final RegistryObject<Block> ZAMITES_WOOD = REGISTER.register("zamites_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_ZAMITES_WOOD = REGISTER.register("stripped_zamites_wood", () -> createLog());
	public static final RegistryObject<Block> ZAMITES_LEAVES = REGISTER.register("zamites_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> ZAMITES_SAPLING = REGISTER.register("zamites_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ZAMITES_DOOR = REGISTER.register("zamites_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> ZAMITES_PRESSURE_PLATE = REGISTER.register("zamites_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZAMITES_FENCE = REGISTER.register("zamites_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, ZAMITES_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZAMITES_TRAPDOOR = REGISTER.register("zamites_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> ZAMITES_FENCE_GATE = REGISTER.register("zamites_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, ZAMITES_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZAMITES_BUTTON = REGISTER.register("zamites_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZAMITES_SLAB = REGISTER.register("zamites_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZAMITES_STAIRS = REGISTER.register("zamites_stairs", () -> new StairBlock(ZAMITES_PLANKS.get().defaultBlockState(), Block.Properties.copy(ZAMITES_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> ZAMITES_SIGN = REGISTER.register("zamites_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.ZAMITES));
	public static final RegistryObject<PFWallSignBlock> ZAMITES_WALL_SIGN = REGISTER.register("zamites_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(ZAMITES_SIGN.get()), PFWoodTypes.ZAMITES));

	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_PLANKS = REGISTER.register("protojuniperoxylon_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LOG = REGISTER.register("protojuniperoxylon_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_PROTOJUNIPEROXYLON_LOG = REGISTER.register("stripped_protojuniperoxylon_log", () -> createLog());
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_WOOD = REGISTER.register("protojuniperoxylon_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_PROTOJUNIPEROXYLON_WOOD = REGISTER.register("stripped_protojuniperoxylon_wood", () -> createLog());
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LEAVES = REGISTER.register("protojuniperoxylon_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_SAPLING = REGISTER.register("protojuniperoxylon_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_DOOR = REGISTER.register("protojuniperoxylon_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_PRESSURE_PLATE = REGISTER.register("protojuniperoxylon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_FENCE = REGISTER.register("protojuniperoxylon_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, PROTOJUNIPEROXYLON_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_TRAPDOOR = REGISTER.register("protojuniperoxylon_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_FENCE_GATE = REGISTER.register("protojuniperoxylon_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, PROTOJUNIPEROXYLON_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_BUTTON = REGISTER.register("protojuniperoxylon_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_SLAB = REGISTER.register("protojuniperoxylon_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_STAIRS = REGISTER.register("protojuniperoxylon_stairs", () -> new StairBlock(PROTOJUNIPEROXYLON_PLANKS.get().defaultBlockState(), Block.Properties.copy(PROTOJUNIPEROXYLON_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> PROTOJUNIPEROXYLON_SIGN = REGISTER.register("protojuniperoxylon_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON));
	public static final RegistryObject<PFWallSignBlock> PROTOJUNIPEROXYLON_WALL_SIGN = REGISTER.register("protojuniperoxylon_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(PROTOJUNIPEROXYLON_SIGN.get()), PFWoodTypes.PROTOJUNIPEROXYLON));

	public static final RegistryObject<Block> AGATHOXYLON_PLANKS = REGISTER.register("agathoxylon_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> AGATHOXYLON_LOG = REGISTER.register("agathoxylon_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_AGATHOXYLON_LOG = REGISTER.register("stripped_agathoxylon_log", () -> createLog());
	public static final RegistryObject<Block> AGATHOXYLON_WOOD = REGISTER.register("agathoxylon_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_AGATHOXYLON_WOOD = REGISTER.register("stripped_agathoxylon_wood", () -> createLog());
	public static final RegistryObject<Block> AGATHOXYLON_LEAVES = REGISTER.register("agathoxylon_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> AGATHOXYLON_SAPLING = REGISTER.register("agathoxylon_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> AGATHOXYLON_DOOR = REGISTER.register("agathoxylon_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> AGATHOXYLON_PRESSURE_PLATE = REGISTER.register("agathoxylon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> AGATHOXYLON_FENCE = REGISTER.register("agathoxylon_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, AGATHOXYLON_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> AGATHOXYLON_TRAPDOOR = REGISTER.register("agathoxylon_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> AGATHOXYLON_FENCE_GATE = REGISTER.register("agathoxylon_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, AGATHOXYLON_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> AGATHOXYLON_BUTTON = REGISTER.register("agathoxylon_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> AGATHOXYLON_SLAB = REGISTER.register("agathoxylon_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> AGATHOXYLON_STAIRS = REGISTER.register("agathoxylon_stairs", () -> new StairBlock(AGATHOXYLON_PLANKS.get().defaultBlockState(), Block.Properties.copy(AGATHOXYLON_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> AGATHOXYLON_SIGN = REGISTER.register("agathoxylon_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.AGATHOXYLON));
	public static final RegistryObject<PFWallSignBlock> AGATHOXYLON_WALL_SIGN = REGISTER.register("agathoxylon_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(AGATHOXYLON_SIGN.get()), PFWoodTypes.AGATHOXYLON));

	public static final RegistryObject<Block> HEIDIPHYLLUM_PLANKS = REGISTER.register("heidiphyllum_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_LOG = REGISTER.register("heidiphyllum_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_HEIDIPHYLLUM_LOG = REGISTER.register("stripped_heidiphyllum_log", () -> createLog());
	public static final RegistryObject<Block> HEIDIPHYLLUM_WOOD = REGISTER.register("heidiphyllum_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_HEIDIPHYLLUM_WOOD = REGISTER.register("stripped_heidiphyllum_wood", () -> createLog());
	public static final RegistryObject<Block> HEIDIPHYLLUM_LEAVES = REGISTER.register("heidiphyllum_leaves", () -> leaves(SoundType.GRASS));
	public static final RegistryObject<Block> HEIDIPHYLLUM_SAPLING = REGISTER.register("heidiphyllum_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_DOOR = REGISTER.register("heidiphyllum_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> HEIDIPHYLLUM_PRESSURE_PLATE = REGISTER.register("heidiphyllum_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_FENCE = REGISTER.register("heidiphyllum_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, HEIDIPHYLLUM_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_TRAPDOOR = REGISTER.register("heidiphyllum_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_FENCE_GATE = REGISTER.register("heidiphyllum_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, HEIDIPHYLLUM_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_BUTTON = REGISTER.register("heidiphyllum_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_SLAB = REGISTER.register("heidiphyllum_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> HEIDIPHYLLUM_STAIRS = REGISTER.register("heidiphyllum_stairs", () -> new StairBlock(HEIDIPHYLLUM_PLANKS.get().defaultBlockState(), Block.Properties.copy(HEIDIPHYLLUM_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> HEIDIPHYLLUM_SIGN = REGISTER.register("heidiphyllum_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.HEIDIPHYLLUM));
	public static final RegistryObject<PFWallSignBlock> HEIDIPHYLLUM_WALL_SIGN = REGISTER.register("heidiphyllum_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(HEIDIPHYLLUM_SIGN.get()), PFWoodTypes.HEIDIPHYLLUM));

	public static final RegistryObject<Block> LIRIODENDRITES_PLANKS = REGISTER.register("liriodendrites_planks", () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIRIODENDRITES_LOG = REGISTER.register("liriodendrites_log", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_LIRIODENDRITES_LOG = REGISTER.register("stripped_liriodendrites_log", () -> createLog());
	public static final RegistryObject<Block> LIRIODENDRITES_WOOD = REGISTER.register("liriodendrites_wood", () -> createLog());
	public static final RegistryObject<Block> STRIPPED_LIRIODENDRITES_WOOD = REGISTER.register("stripped_liriodendrites_wood", () -> createLog());
	public static final RegistryObject<Block> LIRIODENDRITES_LEAVES = REGISTER.register("liriodendrites_leaves", () -> new LiriodendritesLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).randomTicks().noOcclusion().isValidSpawn(PFBlocks::allowsSpawnOnLeaves).isSuffocating(PFBlocks::never).isViewBlocking(PFBlocks::never)));
	public static final RegistryObject<Block> LIRIODENDRITES_SAPLING = REGISTER.register("liriodendrites_sapling", () -> new MetasequoiaSaplingBlock(Block.Properties.of(Material.PLANT).noCollission().randomTicks().strength(0F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LIRIODENDRITES_DOOR = REGISTER.register("liriodendrites_door", () -> new DoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> LIRIODENDRITES_PRESSURE_PLATE = REGISTER.register("liriodendrites_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIRIODENDRITES_FENCE = REGISTER.register("liriodendrites_fence", () -> new FenceBlock(Block.Properties.of(Material.WOOD, LIRIODENDRITES_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIRIODENDRITES_TRAPDOOR = REGISTER.register("liriodendrites_trapdoor", () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(PFBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> LIRIODENDRITES_FENCE_GATE = REGISTER.register("liriodendrites_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.WOOD, LIRIODENDRITES_PLANKS.get().defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIRIODENDRITES_BUTTON = REGISTER.register("liriodendrites_button", () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIRIODENDRITES_SLAB = REGISTER.register("liriodendrites_slab", () -> new SlabBlock(Block.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> LIRIODENDRITES_STAIRS = REGISTER.register("liriodendrites_stairs", () -> new StairBlock(LIRIODENDRITES_PLANKS.get().defaultBlockState(), Block.Properties.copy(LIRIODENDRITES_PLANKS.get())));
	public static final RegistryObject<PFStandingSignBlock> LIRIODENDRITES_SIGN = REGISTER.register("liriodendrites_sign", () -> new PFStandingSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), PFWoodTypes.LIRIODENDRITES));
	public static final RegistryObject<PFWallSignBlock> LIRIODENDRITES_WALL_SIGN = REGISTER.register("liriodendrites_wall_sign", () -> new PFWallSignBlock(Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(LIRIODENDRITES_SIGN.get()), PFWoodTypes.LIRIODENDRITES));

	public static final RegistryObject<Block> POTTED_METASEQUOIA_SAPLING = REGISTER.register("potted_metasequoia_sapling", () -> new FlowerPotBlock(METASEQUOIA_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_ARAUCARIA_SAPLING = REGISTER.register("potted_araucaria_sapling", () -> new FlowerPotBlock(ARAUCARIA_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_HORSRTAIL = REGISTER.register("potted_horsetail", () -> new FlowerPotBlock(HORSETAIL.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_OSMUNDA = REGISTER.register("potted_osmunda", () -> new FlowerPotBlock(OSMUNDA.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_CLUBMOSS = REGISTER.register("potted_clubmoss", () -> new FlowerPotBlock(CLUBMOSS.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_MARCHANTIA = REGISTER.register("potted_marchantia", () -> new FlowerPotBlock(MARCHANTIA.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_PROTOPICEOXYLON_SAPLING = REGISTER.register("potted_protopiceoxylon_sapling", () -> new FlowerPotBlock(PROTOPICEOXYLON_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_ZAMITES_SAPLING = REGISTER.register("potted_zamites_sapling", () -> new FlowerPotBlock(ZAMITES_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_PROTOJUNIPEROXYLON_SAPLING = REGISTER.register("potted_protojuniperoxylon_sapling", () -> new FlowerPotBlock(PROTOJUNIPEROXYLON_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_AGATHOXYLON_SAPLING = REGISTER.register("potted_agathoxylon_sapling", () -> new FlowerPotBlock(AGATHOXYLON_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_CLADOPHLEBIS = REGISTER.register("potted_cladophlebis", () -> new FlowerPotBlock(CLADOPHLEBIS.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_CONIOPTERIS = REGISTER.register("potted_coniopteris", () -> new FlowerPotBlock(CONIOPTERIS.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_MICHELILLOA = REGISTER.register("potted_michelilloa", () -> new FlowerPotBlock(MICHELILLOA.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_HEIDIPHYLLUM_SAPLING = REGISTER.register("potted_heidiphyllum_sapling", () -> new FlowerPotBlock(HEIDIPHYLLUM_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));
	public static final RegistryObject<Block> POTTED_LIRIODENDRITES_SAPLING = REGISTER.register("potted_liriodendrites_sapling", () -> new FlowerPotBlock(LIRIODENDRITES_SAPLING.get(), Block.Properties.of(Material.DECORATION).strength(0).noOcclusion()));

	public static final RegistryObject<Block> MOSSY_DIRT = REGISTER.register("mossy_dirt", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.6F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LOAM = REGISTER.register("loam", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.6F).sound(SoundType.ROOTED_DIRT)));
	public static final RegistryObject<Block> PACKED_LOAM = REGISTER.register("packed_loam", () -> new Block(Block.Properties.of(Material.DIRT).strength(0.6F).sound(SoundType.ROOTED_DIRT)));
	public static final RegistryObject<Block> MOSS_BLOCK = REGISTER.register("moss_block", () -> new Block(Block.Properties.of(Material.PLANT).strength(0.2F).sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SILT = REGISTER.register("silt", () -> new SandBlock(0x8C603C, Block.Properties.of(Material.SAND).strength(0.5F).sound(SoundType.SAND)));
	public static final RegistryObject<Block> HARDENED_SILT = REGISTER.register("hardened_silt", () -> new HardenedSiltBlock(Block.Properties.of(Material.DIRT).strength(0.5F).sound(SoundType.ROOTED_DIRT)));
	
	public static final RegistryObject<PtilophyllumBlock> PTILOPHYLLUM_WOOD = REGISTER.register("ptilophyllum_wood", () -> new PtilophyllumBlock(Block.Properties.of(Material.WOOD).strength(0.4F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> PTILOPHYLLUM_BASE = REGISTER.register("ptilophyllum_base", () -> new PtilophyllumBaseBlock(PTILOPHYLLUM_WOOD.get(), Block.Properties.of(Material.WOOD).strength(0.4F).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> DICROIDIUM = REGISTER.register("dicroidium", () -> new DicroidiumBlock(Block.Properties.of(Material.PLANT).strength(0.5F).noCollission().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> JOHNSTONIA = REGISTER.register("johnstonia", () -> new JohnstoniaBlock(Block.Properties.of(Material.PLANT).strength(0.5F).noCollission().sound(SoundType.GRASS)));

	public static final RegistryObject<Block> SANDSTONE = REGISTER.register("sandstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SANDSTONE_FOSSIL = REGISTER.register("sandstone_fossil", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTH_SANDSTONE = REGISTER.register("smooth_sandstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_SANDSTONE = REGISTER.register("polished_sandstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SANDSTONE_BRICKS = REGISTER.register("sandstone_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_SANDSTONE = REGISTER.register("chiseled_sandstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SANDSTONE_WALL = REGISTER.register("sandstone_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_WALL = REGISTER.register("smooth_sandstone_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SANDSTONE_BRICK_WALL = REGISTER.register("sandstone_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SANDSTONE_STAIRS = REGISTER.register("sandstone_stairs", () -> new StairBlock(SANDSTONE.get().defaultBlockState(), Block.Properties.copy(SANDSTONE.get())));
	public static final RegistryObject<Block> SANDSTONE_SLAB = REGISTER.register("sandstone_slab", () -> new SlabBlock(Block.Properties.copy(SANDSTONE.get())));
	public static final RegistryObject<Block> POLISHED_SANDSTONE_STAIRS = REGISTER.register("polished_sandstone_stairs", () -> new StairBlock(POLISHED_SANDSTONE.get().defaultBlockState(), Block.Properties.copy(POLISHED_SANDSTONE.get())));
	public static final RegistryObject<Block> POLISHED_SANDSTONE_SLAB = REGISTER.register("polished_sandstone_slab", () -> new SlabBlock(Block.Properties.copy(POLISHED_SANDSTONE.get())));
	public static final RegistryObject<Block> SANDSTONE_BRICK_STAIRS = REGISTER.register("sandstone_brick_stairs", () -> new StairBlock(SANDSTONE_BRICKS.get().defaultBlockState(), Block.Properties.copy(SANDSTONE_BRICKS.get())));
	public static final RegistryObject<Block> SANDSTONE_BRICK_SLAB = REGISTER.register("sandstone_brick_slab", () -> new SlabBlock(Block.Properties.copy(SANDSTONE_BRICKS.get())));
	
	public static final RegistryObject<Block> SILTSTONE = REGISTER.register("siltstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILTSTONE_FOSSIL = REGISTER.register("siltstone_fossil", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTH_SILTSTONE = REGISTER.register("smooth_siltstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_SILTSTONE = REGISTER.register("polished_siltstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILTSTONE_BRICKS = REGISTER.register("siltstone_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_SILTSTONE = REGISTER.register("chiseled_siltstone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILTSTONE_WALL = REGISTER.register("siltstone_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTH_SILTSTONE_WALL = REGISTER.register("smooth_siltstone_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILTSTONE_BRICK_WALL = REGISTER.register("siltstone_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SILTSTONE_STAIRS = REGISTER.register("siltstone_stairs", () -> new StairBlock(SILTSTONE.get().defaultBlockState(), Block.Properties.copy(SILTSTONE.get())));
	public static final RegistryObject<Block> SILTSTONE_SLAB = REGISTER.register("siltstone_slab", () -> new SlabBlock(Block.Properties.copy(SILTSTONE.get())));
	public static final RegistryObject<Block> POLISHED_SILTSTONE_STAIRS = REGISTER.register("polished_siltstone_stairs", () -> new StairBlock(POLISHED_SILTSTONE.get().defaultBlockState(), Block.Properties.copy(POLISHED_SILTSTONE.get())));
	public static final RegistryObject<Block> POLISHED_SILTSTONE_SLAB = REGISTER.register("polished_siltstone_slab", () -> new SlabBlock(Block.Properties.copy(POLISHED_SILTSTONE.get())));
	public static final RegistryObject<Block> SILTSTONE_BRICK_STAIRS = REGISTER.register("siltstone_brick_stairs", () -> new StairBlock(SILTSTONE_BRICKS.get().defaultBlockState(), Block.Properties.copy(SILTSTONE_BRICKS.get())));
	public static final RegistryObject<Block> SILTSTONE_BRICK_SLAB = REGISTER.register("siltstone_brick_slab", () -> new SlabBlock(Block.Properties.copy(SILTSTONE_BRICKS.get())));

	public static final RegistryObject<Block> CHALK = REGISTER.register("chalk", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHALK_FOSSIL = REGISTER.register("chalk_fossil", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTH_CHALK = REGISTER.register("smooth_chalk", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_CHALK = REGISTER.register("polished_chalk", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHALK_BRICKS = REGISTER.register("chalk_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_CHALK = REGISTER.register("chiseled_chalk", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHALK_WALL = REGISTER.register("chalk_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMOOTH_CHALK_WALL = REGISTER.register("smooth_chalk_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHALK_BRICK_WALL = REGISTER.register("chalk_brick_wall", () -> new WallBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHALK_STAIRS = REGISTER.register("chalk_stairs", () -> new StairBlock(CHALK.get().defaultBlockState(), Block.Properties.copy(CHALK.get())));
	public static final RegistryObject<Block> CHALK_SLAB = REGISTER.register("chalk_slab", () -> new SlabBlock(Block.Properties.copy(CHALK.get())));
	public static final RegistryObject<Block> POLISHED_CHALK_STAIRS = REGISTER.register("polished_chalk_stairs", () -> new StairBlock(POLISHED_CHALK.get().defaultBlockState(), Block.Properties.copy(POLISHED_CHALK.get())));
	public static final RegistryObject<Block> POLISHED_CHALK_SLAB = REGISTER.register("polished_chalk_slab", () -> new SlabBlock(Block.Properties.copy(POLISHED_CHALK.get())));
	public static final RegistryObject<Block> CHALK_BRICK_STAIRS = REGISTER.register("chalk_brick_stairs", () -> new StairBlock(CHALK_BRICKS.get().defaultBlockState(), Block.Properties.copy(CHALK_BRICKS.get())));
	public static final RegistryObject<Block> CHALK_BRICK_SLAB = REGISTER.register("chalk_brick_slab", () -> new SlabBlock(Block.Properties.copy(CHALK_BRICKS.get())));
	
	public static final RegistryObject<Block> HENOSTONE = REGISTER.register("henostone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CARVED_HENOSTONE = REGISTER.register("carved_henostone", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_BRICKS = REGISTER.register("henostone_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICKS = REGISTER.register("dark_henostone_bricks", () -> new Block(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_PILLAR = REGISTER.register("henostone_pillar", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_HENOSTONE_PILLAR = REGISTER.register("chiseled_henostone_pillar", () -> new RotatedPillarBlock(Block.Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_STAIRS = REGISTER.register("henostone_stairs", () -> new StairBlock(HENOSTONE.get().defaultBlockState(), Block.Properties.copy(HENOSTONE.get())));
	public static final RegistryObject<Block> HENOSTONE_SLAB = REGISTER.register("henostone_slab", () -> new SlabBlock(Block.Properties.copy(HENOSTONE.get())));
	public static final RegistryObject<Block> HENOSTONE_WALL = REGISTER.register("henostone_wall", () -> new WallBlock(Block.Properties.copy(HENOSTONE.get())));
	public static final RegistryObject<Block> HENOSTONE_BRICK_STAIRS = REGISTER.register("henostone_brick_stairs", () -> new StairBlock(HENOSTONE_BRICKS.get().defaultBlockState(), Properties.copy(HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> HENOSTONE_BRICK_SLAB = REGISTER.register("henostone_brick_slab", () -> new SlabBlock(Properties.copy(HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> HENOSTONE_BRICK_WALL = REGISTER.register("henostone_brick_wall", () -> new WallBlock(Properties.copy(HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICK_STAIRS = REGISTER.register("dark_henostone_brick_stairs", () -> new StairBlock(DARK_HENOSTONE_BRICKS.get().defaultBlockState(), Properties.copy(DARK_HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICK_SLAB = REGISTER.register("dark_henostone_brick_slab", () -> new SlabBlock(Properties.copy(DARK_HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICK_WALL = REGISTER.register("dark_henostone_brick_wall", () -> new WallBlock(Properties.copy(DARK_HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> HENOSTONE_TRAP = REGISTER.register("henostone_trap", () -> new TrapBlock(TrapBlock.Sensitivity.MOBS, Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> LARGE_AMMONITE_FOSSIL = REGISTER.register("large_ammonite_fossil", () -> new AmmoniteLargeShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MEDIUM_AMMONITE_FOSSIL = REGISTER.register("medium_ammonite_fossil", () -> new AmmoniteMediumShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SMALL_AMMONITE_FOSSIL = REGISTER.register("small_ammonite_fossil", () -> new AmmoniteSmallShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GIANT_AMMONITE_FOSSIL_PIECE_BF = REGISTER.register("giant_ammonite_fossil_piece_bf", () -> new AmmoniteGiantShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GIANT_AMMONITE_FOSSIL_PIECE_BB = REGISTER.register("giant_ammonite_fossil_piece_bb", () -> new AmmoniteGiantShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GIANT_AMMONITE_FOSSIL_PIECE_TF = REGISTER.register("giant_ammonite_fossil_piece_tf", () -> new AmmoniteGiantShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GIANT_AMMONITE_FOSSIL_PIECE_TB = REGISTER.register("giant_ammonite_fossil_piece_tb", () -> new AmmoniteGiantShellBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PLASTERED_AMMONITES = REGISTER.register("plastered_ammonites", () -> new Block(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PETRIFIED_WOOD = REGISTER.register("petrified_wood", () -> new RotatedPillarBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD = REGISTER.register("polished_petrified_wood", () -> new RotatedPillarBlock(Properties.of(Material.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
	
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
