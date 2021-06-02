package superlord.prehistoricfauna.init;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.PrehistoricFauna.PFBuilding;
import superlord.prehistoricfauna.PrehistoricFauna.PFDecoration;
import superlord.prehistoricfauna.PrehistoricFauna.PFMisc;
import superlord.prehistoricfauna.block.AlgaeBlock;
import superlord.prehistoricfauna.block.AllosaurusEggBlock;
import superlord.prehistoricfauna.block.AmmoniteGiantShellBlock;
import superlord.prehistoricfauna.block.AmmoniteLargeShellBlock;
import superlord.prehistoricfauna.block.AmmoniteMediumShellBlock;
import superlord.prehistoricfauna.block.AmmoniteSmallShellBlock;
import superlord.prehistoricfauna.block.AnkylosaurusEggBlock;
import superlord.prehistoricfauna.block.BasilemysEggBlock;
import superlord.prehistoricfauna.block.CamarasaurusEggBlock;
import superlord.prehistoricfauna.block.CeratosaurusEggBlock;
import superlord.prehistoricfauna.block.ChromogisaurusEggBlock;
import superlord.prehistoricfauna.block.CrassostreaOysterBlock;
import superlord.prehistoricfauna.block.CretaceousPortalBlock;
import superlord.prehistoricfauna.block.CretaceousTimeBlock;
import superlord.prehistoricfauna.block.DakotaraptorEggBlock;
import superlord.prehistoricfauna.block.DeadConiopterisBlock;
import superlord.prehistoricfauna.block.DicroidiumBlock;
//import superlord.prehistoricfauna.block.DidelphodonBurrowBlock;
import superlord.prehistoricfauna.block.DryosaurusEggBlock;
import superlord.prehistoricfauna.block.EilenodonEggBlock;
import superlord.prehistoricfauna.block.ExaeretodonEggBlock;
import superlord.prehistoricfauna.block.HerrerasaurusEggBlock;
import superlord.prehistoricfauna.block.HesperornithoidesEggBlock;
import superlord.prehistoricfauna.block.HyperodapedonEggBlock;
import superlord.prehistoricfauna.block.IschigualastiaEggBlock;
import superlord.prehistoricfauna.block.JohnstoniaBlock;
import superlord.prehistoricfauna.block.JurassicPortalBlock;
import superlord.prehistoricfauna.block.JurassicTimeBlock;
import superlord.prehistoricfauna.block.LeafCarpetBlock;
import superlord.prehistoricfauna.block.LiriodendritesLeavesBlock;
import superlord.prehistoricfauna.block.MossBlock;
import superlord.prehistoricfauna.block.MossyDirtBlock;
import superlord.prehistoricfauna.block.PFStandingSignBlock;
import superlord.prehistoricfauna.block.PFWallSignBlock;
import superlord.prehistoricfauna.block.PHFSapling;
import superlord.prehistoricfauna.block.PaleontologyTableBlock;
import superlord.prehistoricfauna.block.PaleoscribeBlock;
import superlord.prehistoricfauna.block.PrehistoricButtonBlock;
import superlord.prehistoricfauna.block.PrehistoricDoorBlock;
import superlord.prehistoricfauna.block.PrehistoricPlant;
import superlord.prehistoricfauna.block.PrehistoricPlantBlock;
import superlord.prehistoricfauna.block.PrehistoricPressurePlateBlock;
import superlord.prehistoricfauna.block.PrehistoricStairsBlock;
import superlord.prehistoricfauna.block.PrehistoricTrapDoorBlock;
import superlord.prehistoricfauna.block.PtilophyllumBaseBlock;
import superlord.prehistoricfauna.block.PtilophyllumBlock;
import superlord.prehistoricfauna.block.SaurosuchusEggBlock;
import superlord.prehistoricfauna.block.ShortOsmundacaulisBlock;
import superlord.prehistoricfauna.block.SillosuchusEggBlock;
import superlord.prehistoricfauna.block.StegosaurusEggBlock;
import superlord.prehistoricfauna.block.ThescelosaurusEggBlock;
import superlord.prehistoricfauna.block.TrapBlock;
import superlord.prehistoricfauna.block.TriassicPortalBlock;
import superlord.prehistoricfauna.block.TriassicTimeBlock;
import superlord.prehistoricfauna.block.TriceratopsEggBlock;
import superlord.prehistoricfauna.block.TyrannosaurusEggBlock;
import superlord.prehistoricfauna.block.ZamitesSaplingBlock;
import superlord.prehistoricfauna.block.ZamitesTopBlock;
import superlord.prehistoricfauna.compat.block.VerticalSlabBlock;
import superlord.prehistoricfauna.util.PFWoodTypes;
import superlord.prehistoricfauna.util.RegistryHelper;
import superlord.prehistoricfauna.world.feature.util.PHFTreeSpawners;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.MOD)
public class BlockInit {

	public static final RegistryHelper HELPER = PrehistoricFauna.REGISTRY_HELPER;
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, PrehistoricFauna.MODID);
	
	public static final RegistryObject<Block> HORSETAIL = register("horsetail", () -> new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> OSMUNDA = register("osmunda", () -> new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> TALL_HORSETAIL = register("tall_horsetail", () -> new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> TALL_OSMUNDA = register("tall_osmunda", () -> new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> CLUBMOSS = register("clubmoss", () -> new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> MARCHANTIA = register("marchantia", () -> new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> MOSS_CARPET = register("moss_carpet", () -> new MossBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)), PFDecoration.instance);

	public static final RegistryObject<Block> METASEQUOIA_PLANKS = register("metasequoia_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_LOG = register("metasequoia_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_LEAVES = register("metasequoia_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> METASEQUOIA_SAPLING = register("metasequoia_sapling", () -> new PHFSapling(new PHFTreeSpawners.MetaSequoia(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_METASEQUOIA_LOG = register("stripped_metasequoia_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_WOOD = register("metasequoia_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_METASEQUOIA_WOOD = register("stripped_metasequoia_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_SLAB = register("metasequoia_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_STAIRS = register("metasequoia_stairs", () -> new PrehistoricStairsBlock(METASEQUOIA_PLANKS.get().getDefaultState(), Block.Properties.from(METASEQUOIA_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_FENCE = register("metasequoia_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_FENCE_GATE = register("metasequoia_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_BUTTON = register("metasequoia_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_DOOR = register("metasequoia_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_TRAPDOOR = register("metasequoia_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> METASEQUOIA_PRESSURE_PLATE = register("metasequoia_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_METASEQUOIA_SAPLING = BLOCKS.register("potted_metasequoia_sapling", () -> new FlowerPotBlock(METASEQUOIA_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	
	public static final RegistryObject<Block> ARAUCARIA_PLANKS = register("araucaria_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_LOG = register("araucaria_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_LEAVES = register("araucaria_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> ARAUCARIA_SAPLING = register("araucaria_sapling", () -> new PHFSapling(new PHFTreeSpawners.Araucaria(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_LOG = register("stripped_araucaria_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_WOOD = register("araucaria_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_WOOD = register("stripped_araucaria_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_SLAB = register("araucaria_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_STAIRS = register("araucaria_stairs", () -> new PrehistoricStairsBlock(ARAUCARIA_PLANKS.get().getDefaultState(), Block.Properties.from(ARAUCARIA_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_FENCE = register("araucaria_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_FENCE_GATE = register("araucaria_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_BUTTON = register("araucaria_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_DOOR = register("araucaria_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_TRAPDOOR = register("araucaria_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_PRESSURE_PLATE = register("araucaria_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_ARAUCARIA_SAPLING = BLOCKS.register("potted_araucaria_sapling", () -> new FlowerPotBlock(ARAUCARIA_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	
	public static final RegistryObject<Block> LIRIODENDRITES_PLANKS = register("liriodendrites_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LOG = register("liriodendrites_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LEAVES = register("liriodendrites_leaves", () -> new LiriodendritesLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_SAPLING = register("liriodendrites_sapling", () -> new PHFSapling(new PHFTreeSpawners.Liriodendrites(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_LIRIODENDRITES_LOG = register("stripped_liriodendrites_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_WOOD = register("liriodendrites_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_LIRIODENDRITES_WOOD = register("stripped_liriodendrites_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_SLAB = register("liriodendrites_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_STAIRS = register("liriodendrites_stairs", () -> new PrehistoricStairsBlock(LIRIODENDRITES_PLANKS.get().getDefaultState(), Block.Properties.from(LIRIODENDRITES_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_FENCE = register("liriodendrites_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_FENCE_GATE = register("liriodendrites_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_BUTTON = register("liriodendrites_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_DOOR = register("liriodendrites_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_TRAPDOOR = register("liriodendrites_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_PRESSURE_PLATE = register("liriodendrites_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_LIRIODENDRITES_SAPLING = BLOCKS.register("potted_liriodendrites_sapling", () -> new FlowerPotBlock(LIRIODENDRITES_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));

	public static final RegistryObject<Block> PROTOPICEOXYLON_PLANKS = register("protopiceoxylon_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LOG = register("protopiceoxylon_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LEAVES = register("protopiceoxylon_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_SAPLING = register("protopiceoxylon_sapling", () -> new PHFSapling(new PHFTreeSpawners.Protopiceoxylon(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_PROTOPICEOXYLON_LOG = register("stripped_protopiceoxylon_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_WOOD = register("protopiceoxylon_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_PROTOPICEOXYLON_WOOD = register("stripped_protopiceoxylon_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_SLAB = register("protopiceoxylon_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_STAIRS = register("protopiceoxylon_stairs", () -> new PrehistoricStairsBlock(PROTOPICEOXYLON_PLANKS.get().getDefaultState(), Block.Properties.from(PROTOPICEOXYLON_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_FENCE = register("protopiceoxylon_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_FENCE_GATE = register("protopiceoxylon_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_BUTTON = register("protopiceoxylon_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_DOOR = register("protopiceoxylon_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_TRAPDOOR = register("protopiceoxylon_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_PRESSURE_PLATE = register("protopiceoxylon_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_PROTOPICEOXYLON_SAPLING = BLOCKS.register("potted_protopiceoxylon_sapling", () -> new FlowerPotBlock(PROTOPICEOXYLON_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));

	public static final RegistryObject<Block> ZAMITES_PLANKS = register("zamites_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_LOG = register("zamites_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_LEAVES = register("zamites_leaves", () -> new ZamitesTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> ZAMITES_SAPLING = register("zamites_sapling", () -> new ZamitesSaplingBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_ZAMITES_LOG = register("stripped_zamites_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_WOOD = register("zamites_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_ZAMITES_WOOD = register("stripped_zamites_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_SLAB = register("zamites_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_STAIRS = register("zamites_stairs", () -> new PrehistoricStairsBlock(ZAMITES_PLANKS.get().getDefaultState(), Block.Properties.from(ZAMITES_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_FENCE = register("zamites_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_FENCE_GATE = register("zamites_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_BUTTON = register("zamites_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_DOOR = register("zamites_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_TRAPDOOR = register("zamites_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_PRESSURE_PLATE = register("zamites_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_ZAMITES_SAPLING = BLOCKS.register("potted_zamites_sapling", () -> new FlowerPotBlock(ZAMITES_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_PLANKS = register("protojuniperoxylon_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LOG = register("protojuniperoxylon_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LEAVES = register("protojuniperoxylon_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_SAPLING = register("protojuniperoxylon_sapling", () -> new PHFSapling(new PHFTreeSpawners.ProtoJuniper(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_PROTOJUNIPEROXYLON_LOG = register("stripped_protojuniperoxylon_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_WOOD = register("protojuniperoxylon_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_PROTOJUNIPEROXYLON_WOOD = register("stripped_protojuniperoxylon_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_SLAB = register("protojuniperoxylon_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_STAIRS = register("protojuniperoxylon_stairs", () -> new PrehistoricStairsBlock(PROTOJUNIPEROXYLON_PLANKS.get().getDefaultState(), Block.Properties.from(PROTOJUNIPEROXYLON_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_FENCE = register("protojuniperoxylon_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_FENCE_GATE = register("protojuniperoxylon_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_BUTTON = register("protojuniperoxylon_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_DOOR = register("protojuniperoxylon_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_TRAPDOOR = register("protojuniperoxylon_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_PRESSURE_PLATE = register("protojuniperoxylon_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_PROTOJUNIPEROXYLON_SAPLING = BLOCKS.register("potted_protojuniperoxylon_sapling", () -> new FlowerPotBlock(PROTOJUNIPEROXYLON_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));

	public static final RegistryObject<Block> HEIDIPHYLLUM_PLANKS = register("heidiphyllum_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LOG = register("heidiphyllum_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LEAVES = register("heidiphyllum_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_SAPLING = register("heidiphyllum_sapling", () -> new PHFSapling(new PHFTreeSpawners.Heidiphyllum(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> STRIPPED_HEIDIPHYLLUM_LOG = register("stripped_heidiphyllum_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_WOOD = register("heidiphyllum_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_HEIDIPHYLLUM_WOOD = register("stripped_heidiphyllum_wood", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_SLAB = register("heidiphyllum_slab", () -> new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_STAIRS = register("heidiphyllum_stairs", () -> new PrehistoricStairsBlock(HEIDIPHYLLUM_PLANKS.get().getDefaultState(), Block.Properties.from(HEIDIPHYLLUM_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_FENCE = register("heidiphyllum_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_FENCE_GATE = register("heidiphyllum_fence_gate", () -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_BUTTON = register("heidiphyllum_button", () -> new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_DOOR = register("heidiphyllum_door", () -> new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).notSolid().sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_TRAPDOOR = register("heidiphyllum_trapdoor", () -> new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_PRESSURE_PLATE = register("heidiphyllum_pressure_plate", () -> new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)), PFBuilding.instance);
	public static final RegistryObject<Block> POTTED_HEIDIPHYLLUM_SAPLING = BLOCKS.register("potted_heidiphyllum_sapling", () -> new FlowerPotBlock(HEIDIPHYLLUM_SAPLING.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	
	public static final RegistryObject<Block> POTTED_HORSETAIL = BLOCKS.register("potted_horsetail", () -> new FlowerPotBlock(HORSETAIL.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final RegistryObject<Block> POTTED_OSMUNDA = BLOCKS.register("potted_osmunda", () -> new FlowerPotBlock(OSMUNDA.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final RegistryObject<Block> POTTED_CLUBMOSS = BLOCKS.register("potted_clubmoss", () -> new FlowerPotBlock(CLUBMOSS.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final RegistryObject<Block> POTTED_MARCHANTIA = BLOCKS.register("potted_marchantia", () -> new FlowerPotBlock(MARCHANTIA.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));

	public static final RegistryObject<Block> MOSSY_DIRT = register("mossy_dirt", () -> new MossyDirtBlock(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(0.6F).sound(SoundType.PLANT)), PFBuilding.instance);
	public static final RegistryObject<Block> LOAM = register("loam", () -> new Block(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).hardnessAndResistance(0.6F).sound(SoundType.GROUND)), PFBuilding.instance);
	public static final RegistryObject<Block> PACKED_LOAM = register("packed_loam", () -> new Block(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).hardnessAndResistance(0.6F).sound(SoundType.GROUND)), PFBuilding.instance);
	
	public static final RegistryObject<Block> THESCELOSAURUS_EGG = register("thescelosaurus_egg", () -> new ThescelosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> TRICERATOPS_EGG = register("triceratops_egg", () -> new TriceratopsEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> TYRANNOSAURUS_EGG = register("tyrannosaurus_egg", () -> new TyrannosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> DAKOTARAPTOR_EGG = register("dakotaraptor_egg", () -> new DakotaraptorEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> BASILEMYS_EGG = register("basilemys_egg", () -> new BasilemysEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> ANKYLOSAURUS_EGG = register("ankylosaurus_egg", () -> new AnkylosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> CAMARASAURUS_EGG = register("camarasaurus_egg", () -> new CamarasaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> DRYOSAURUS_EGG = register("dryosaurus_egg", () -> new DryosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> ALLOSAURUS_EGG = register("allosaurus_egg", () -> new AllosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> CERATOSAURUS_EGG = register("ceratosaurus_egg", () -> new CeratosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> EILENODON_EGG = register("eilenodon_egg", () -> new EilenodonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> HESPERORNITHOIDES_EGG = register("hesperornithoides_egg", () -> new HesperornithoidesEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> STEGOSAURUS_EGG = register("stegosaurus_egg", () -> new StegosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> HYPERODAPEDON_EGG = register("hyperodapedon_egg", () -> new HyperodapedonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> HERRERASAURUS_EGG = register("herrerasaurus_egg", () -> new HerrerasaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> CHROMOGISAURUS_EGG = register("chromogisaurus_egg", () -> new ChromogisaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> SILLOSUCHUS_EGG = register("sillosuchus_egg", () -> new SillosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> SAUROSUCHUS_EGG = register("saurosuchus_egg", () -> new SaurosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> ISCHIGUALASTIA_EGG = register("ischigualastia_egg", () -> new IschigualastiaEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);
	public static final RegistryObject<Block> EXAERETODON_EGG = register("exaeretodon_egg", () -> new ExaeretodonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()), PFMisc.instance);

	public static final RegistryObject<Block> MOSS_BLOCK = register("moss_block", () -> new Block(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> CONIOPTERIS = register("coniopteris", () -> new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> TALL_OSMUNDACAULIS = register("tall_osmundacaulis", () -> new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> DICROIDIUM = register("dicroidium", () -> new DicroidiumBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> JOHNSTONIA = register("johnstonia", () -> new JohnstoniaBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> SCYTOPHYLLUM = register("scytophyllum", () -> new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> CLADOPHLEBIS = register("cladophlebis", () -> new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> MICHELILLOA = register("michelilloa", () -> new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)), PFDecoration.instance);

	public static final RegistryObject<Block> POTTED_CLADOPHLEBIS = BLOCKS.register("potted_cladophlebis", () -> new FlowerPotBlock(CLADOPHLEBIS.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final RegistryObject<Block> POTTED_MICHELILLOA = BLOCKS.register("potted_michelilloa", () -> new FlowerPotBlock(MICHELILLOA.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final RegistryObject<Block> OSMUNDACAULIS = register("osmundacaulis", () -> new ShortOsmundacaulisBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)), PFDecoration.instance);
	public static final RegistryObject<Block> DEAD_OSMUNDACAULIS = register("dead_osmundacaulis", () -> new DeadConiopterisBlock(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.WOOD).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)), PFDecoration.instance);
	
	public static final RegistryObject<Block> SANDSTONE = register("sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_FOSSIL = register("sandstone_fossil", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)), PFDecoration.instance);
	public static final RegistryObject<Block> SMOOTH_SANDSTONE = register("smooth_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_SANDSTONE = register("polished_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_BRICKS = register("sandstone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHISELED_SANDSTONE = register("chiseled_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_SLAB = register("sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_STAIRS = register("sandstone_stairs", () -> new PrehistoricStairsBlock(SANDSTONE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_WALL = register("sandstone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> SMOOTH_SANDSTONE_WALL = register("smooth_sandstone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> SANDSTONE_BRICK_WALL = register("sandstone_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> POLISHED_SANDSTONE_SLAB = register("polished_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_SANDSTONE_STAIRS = register("polished_sandstone_stairs", () -> new PrehistoricStairsBlock(POLISHED_SANDSTONE.get().getDefaultState(), Block.Properties.from(POLISHED_SANDSTONE.get())), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_BRICK_SLAB = register("sandstone_brick_slab", () -> new SlabBlock(Block.Properties.from(SANDSTONE_BRICKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_BRICK_STAIRS = register("sandstone_brick_stairs", () -> new PrehistoricStairsBlock(SANDSTONE_BRICKS.get().getDefaultState(), Block.Properties.from(SANDSTONE_BRICKS.get())), PFBuilding.instance);
	
	public static final RegistryObject<Block> SILTSTONE = register("siltstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_FOSSIL = register("siltstone_fossil", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)), PFDecoration.instance);
	public static final RegistryObject<Block> SMOOTH_SILTSTONE = register("smooth_siltstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_SILTSTONE = register("polished_siltstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_BRICKS = register("siltstone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHISELED_SILTSTONE = register("chiseled_siltstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_SLAB = register("siltstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_STAIRS = register("siltstone_stairs", () -> new PrehistoricStairsBlock(SILTSTONE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_WALL = register("siltstone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> SMOOTH_SILTSTONE_WALL = register("smooth_siltstone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> SILTSTONE_BRICK_WALL = register("siltstone_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> POLISHED_SILTSTONE_SLAB = register("polished_siltstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_SILTSTONE_STAIRS = register("polished_siltstone_stairs", () -> new PrehistoricStairsBlock(POLISHED_SILTSTONE.get().getDefaultState(), Block.Properties.from(POLISHED_SILTSTONE.get())), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_BRICK_SLAB = register("siltstone_brick_slab", () -> new SlabBlock(Block.Properties.from(SILTSTONE_BRICKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_BRICK_STAIRS = register("siltstone_brick_stairs", () -> new PrehistoricStairsBlock(SILTSTONE_BRICKS.get().getDefaultState(), Block.Properties.from(SILTSTONE_BRICKS.get())), PFBuilding.instance);
	
	public static final RegistryObject<Block> CHALK = register("chalk", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_FOSSIL = register("chalk_fossil", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)), PFDecoration.instance);
	public static final RegistryObject<Block> SMOOTH_CHALK = register("smooth_chalk", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_CHALK = register("polished_chalk", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_BRICKS = register("chalk_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHISELED_CHALK = register("chiseled_chalk", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_SLAB = register("chalk_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_STAIRS = register("chalk_stairs", () -> new PrehistoricStairsBlock(CHALK.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_WALL = register("chalk_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> SMOOTH_CHALK_WALL = register("smooth_chalk_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> CHALK_BRICK_WALL = register("chalk_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> POLISHED_CHALK_SLAB = register("polished_chalk_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_CHALK_STAIRS = register("polished_chalk_stairs", () -> new PrehistoricStairsBlock(POLISHED_CHALK.get().getDefaultState(), Block.Properties.from(POLISHED_CHALK.get())), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_BRICK_SLAB = register("chalk_brick_slab", () -> new SlabBlock(Block.Properties.from(CHALK_BRICKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_BRICK_STAIRS = register("chalk_brick_stairs", () -> new PrehistoricStairsBlock(CHALK_BRICKS.get().getDefaultState(), Block.Properties.from(CHALK_BRICKS.get())), PFBuilding.instance);
	
	public static final RegistryObject<Block> PORTAL_FRAME = register("portal_frame", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).lightValue(9)), PFDecoration.instance);
	
	public static final RegistryObject<Block> TRIASSIC_TIME_BLOCK = BLOCKS.register("triassic_time_block", () -> new TriassicTimeBlock());
	public static final RegistryObject<Block> JURASSIC_TIME_BLOCK = BLOCKS.register("jurassic_time_block", () -> new JurassicTimeBlock());
	public static final RegistryObject<Block> CRETACEOUS_TIME_BLOCK = BLOCKS.register("cretaceous_time_block", () -> new CretaceousTimeBlock());
	
	public static final RegistryObject<Block> CRASSOSTREA_OYSTER = BLOCKS.register("crassostrea_oyster", () -> new CrassostreaOysterBlock(Block.Properties.create(Material.CORAL).doesNotBlockMovement().hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.STONE).harvestLevel(0)));
	
	public static final RegistryObject<Block> HENOSTONE = BLOCKS.register("henostone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CARVED_HENOSTONE = BLOCKS.register("carved_henostone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_BRICKS = BLOCKS.register("henostone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICKS = BLOCKS.register("dark_henostone_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_PILLAR = BLOCKS.register("henostone_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHISELED_HENOSTONE_PILLAR = BLOCKS.register("chiseled_henostone_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_STAIRS = BLOCKS.register("henostone_stairs", () -> new PrehistoricStairsBlock(HENOSTONE.get().getDefaultState(), Block.Properties.from(HENOSTONE.get())));
	public static final RegistryObject<Block> HENOSTONE_SLAB = BLOCKS.register("henostone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_WALL = register("henostone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> HENOSTONE_BRICK_STAIRS = BLOCKS.register("henostone_brick_stairs", () -> new PrehistoricStairsBlock(HENOSTONE_BRICKS.get().getDefaultState(), Block.Properties.from(HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> HENOSTONE_BRICK_SLAB = BLOCKS.register("henostone_brick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> HENOSTONE_BRICK_WALL = register("henostone_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICK_STAIRS = BLOCKS.register("dark_henostone_brick_stairs", () -> new PrehistoricStairsBlock(DARK_HENOSTONE_BRICKS.get().getDefaultState(), Block.Properties.from(DARK_HENOSTONE_BRICKS.get())));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICK_SLAB = BLOCKS.register("dark_henostone_brick_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DARK_HENOSTONE_BRICK_WALL = register("dark_henostone_brick_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> HENOSTONE_TRAP = register("henostone_trap", () -> new TrapBlock(TrapBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	
	public static final RegistryObject<Block> SMALL_AMMONITE_SHELL = BLOCKS.register("small_ammonite_fossil", () -> new AmmoniteSmallShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MEDIUM_AMMONITE_SHELL = BLOCKS.register("medium_ammonite_fossil", () -> new AmmoniteMediumShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LARGE_AMMONITE_SHELL = BLOCKS.register("large_ammonite_fossil", () -> new AmmoniteLargeShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GIANT_AMMONITE_SHELL_BB = register("giant_ammonite_fossil_piece_bb", () -> new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> GIANT_AMMONITE_SHELL_BF = register("giant_ammonite_fossil_piece_bf", () -> new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> GIANT_AMMONITE_SHELL_TB = register("giant_ammonite_fossil_piece_tb", () -> new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> GIANT_AMMONITE_SHELL_TF = register("giant_ammonite_fossil_piece_tf", () -> new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFDecoration.instance);
	public static final RegistryObject<Block> PLASTERED_AMMONITES = register("plastered_ammonites", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> PETRIFIED_WOOD = register("petrified_wood", () -> new LogBlock(MaterialColor.PINK, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_PETRIFIED_WOOD = register("polished_petrified_wood", () -> new LogBlock(MaterialColor.PINK, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)), PFBuilding.instance);
	
	public static final RegistryObject<Block> PALEONTOLOGY_TABLE = register("paleontology_table", () -> new PaleontologyTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)), PFDecoration.instance);
	
	public static final RegistryObject<Block> ALGAE_CARPET = register("algae_carpet", () -> new AlgaeBlock(Block.Properties.create(Material.OCEAN_PLANT).hardnessAndResistance(0.2F).sound(SoundType.SLIME).notSolid()), PFDecoration.instance);
	
	public static final RegistryObject<Block> ARAUCARIA_SIGN = BLOCKS.register("araucaria_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ARAUCARIA));
	public static final RegistryObject<Block> ARAUCARIA_WALL_SIGN = BLOCKS.register("araucaria_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ARAUCARIA));
	public static final RegistryObject<Block> METASEQUOIA_SIGN = BLOCKS.register("metasequoia_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.METASEQUOIA));
	public static final RegistryObject<Block> METASEQUOIA_WALL_SIGN = BLOCKS.register("metasequoia_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.METASEQUOIA));
	public static final RegistryObject<Block> LIRIODENDRITES_SIGN = BLOCKS.register("liriodendrites_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.LIRIODENDRITES));
	public static final RegistryObject<Block> LIRIODENDRITES_WALL_SIGN = BLOCKS.register("liriodendrites_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.LIRIODENDRITES));
	public static final RegistryObject<Block> PROTOPICEOXYLON_SIGN = BLOCKS.register("protopiceoxylon_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOPICEOXYLON));
	public static final RegistryObject<Block> PROTOPICEOXYLON_WALL_SIGN = BLOCKS.register("protopiceoxylon_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOPICEOXYLON));
	public static final RegistryObject<Block> ZAMITES_SIGN = BLOCKS.register("zamites_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ZAMITES));
	public static final RegistryObject<Block> ZAMITES_WALL_SIGN = BLOCKS.register("zamites_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ZAMITES));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_SIGN = BLOCKS.register("protojuniperoxylon_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON));
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_WALL_SIGN = BLOCKS.register("protojuniperoxylon_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON));
	public static final RegistryObject<Block> HEIDIPHYLLUM_SIGN = BLOCKS.register("heidiphyllum_sign", () -> new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.HEIDIPHYLLUM));
	public static final RegistryObject<Block> HEIDIPHYLLUM_WALL_SIGN = BLOCKS.register("heidiphyllum_wall_sign", () -> new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.HEIDIPHYLLUM));
	
	public static final RegistryObject<TriassicPortalBlock> TRIASSIC_PORTAL = BLOCKS.register("triassic_portal", () -> new TriassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));
	public static final RegistryObject<JurassicPortalBlock> JURASSIC_PORTAL = BLOCKS.register("jurassic_portal", () -> new JurassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));
	public static final RegistryObject<CretaceousPortalBlock> CRETACEOUS_PORTAL = BLOCKS.register("cretaceous_portal", () -> new CretaceousPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));

	public static final RegistryObject<Block> PALEOSCRIBE = register("paleoscribe", () -> new PaleoscribeBlock(Block.Properties.create(Material.WOOD).variableOpacity().hardnessAndResistance(2.0F, 5.0F).sound(SoundType.WOOD)), PFDecoration.instance);
	
	public static final RegistryObject<Block> POTTED_DEAD_OSMUNDACAULIS = BLOCKS.register("potted_dead_osmundacaulis", () -> new FlowerPotBlock(DEAD_OSMUNDACAULIS.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()));
	public static final RegistryObject<Block> POTTED_OSMUNDACAULIS = BLOCKS.register("potted_short_osmundacaulis", () -> new FlowerPotBlock(OSMUNDACAULIS.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).notSolid()));
	public static final RegistryObject<Block> POTTED_CONIOPTERIS = BLOCKS.register("potted_coniopteris", () -> new FlowerPotBlock(CONIOPTERIS.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0F).notSolid()));
	
	public static final RegistryObject<Block> SILT = register("silt", () -> new SandBlock(0x8C603C, Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)), PFBuilding.instance);
	public static final RegistryObject<Block> HARDENED_SILT = register("hardened_silt", () -> new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)), PFBuilding.instance);
	
	public static final RegistryObject<Block> PTILOPHYLLUM_WOOD = register("ptilophyllum_wood", () -> new PtilophyllumBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(0.4F).sound(SoundType.WOOD).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PTILOPHYLLUM_BASE = register("ptilophyllum_base", () -> new PtilophyllumBaseBlock((PtilophyllumBlock)PTILOPHYLLUM_WOOD.get(), Block.Properties.create(Material.WOOD, MaterialColor.WOOD).tickRandomly().hardnessAndResistance(0.4F).sound(SoundType.WOOD).notSolid()), PFDecoration.instance);
	
	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "metasequoia_vertical_slab", () -> new VerticalSlabBlock(Properties.from(METASEQUOIA_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "araucaria_vertical_slab", () -> new VerticalSlabBlock(Properties.from(ARAUCARIA_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "liriodendrites_vertical_slab", () -> new VerticalSlabBlock(Properties.from(LIRIODENDRITES_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_slab", () -> new VerticalSlabBlock(Properties.from(PROTOPICEOXYLON_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "zamites_vertical_slab", () -> new VerticalSlabBlock(Properties.from(ZAMITES_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_slab", () -> new VerticalSlabBlock(Properties.from(PROTOJUNIPEROXYLON_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HEIDIPHYLLUM_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "sandstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SANDSTONE_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_sandstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_SANDSTONE_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "sandstone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SANDSTONE_BRICK_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "siltstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SILTSTONE_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_siltstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_SILTSTONE_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "siltstone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SILTSTONE_BRICK_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chalk_vertical_slab", () -> new VerticalSlabBlock(Properties.from(CHALK_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_chalk_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_CHALK_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chalk_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(CHALK_BRICK_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_BRICK_SLAB.get())), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_DARK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "dark_henostone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(DARK_HENOSTONE_BRICK_SLAB.get())), PFBuilding.instance);
	
	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "metasequoia_vertical_planks", () -> new Block(Properties.from(METASEQUOIA_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "araucaria_vertical_planks", () -> new Block(Properties.from(ARAUCARIA_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "liriodendrites_vertical_planks", () -> new Block(Properties.from(LIRIODENDRITES_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_planks", () -> new Block(Properties.from(PROTOPICEOXYLON_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "zamites_vertical_planks", () -> new Block(Properties.from(ZAMITES_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_planks", () -> new Block(Properties.from(PROTOJUNIPEROXYLON_PLANKS.get())), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_planks", () -> new Block(Properties.from(HEIDIPHYLLUM_PLANKS.get())), PFBuilding.instance);

	public static final RegistryObject<Block> METASEQUOIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "metasequoia_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> ARAUCARIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "araucaria_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LEAF_CARPET = HELPER.createCompatBlock("quark", "liriodendrites_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protopiceoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protojuniperoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LEAF_CARPET = HELPER.createCompatBlock("quark", "heidiphyllum_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderType cutoutRenderType = RenderType.getCutout();
			RenderType mippedRenderType = RenderType.getCutoutMipped();
			RenderType translucentRenderType = RenderType.getTranslucent();
			
			RenderTypeLookup.setRenderLayer(HORSETAIL.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(OSMUNDA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TALL_HORSETAIL.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TALL_OSMUNDA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TALL_OSMUNDACAULIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CLUBMOSS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(MARCHANTIA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CONIOPTERIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_LEAVES.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_LEAVES.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_ARAUCARIA_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_METASEQUOIA_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOPICEOXYLON_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CLUBMOSS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_HORSETAIL.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_MARCHANTIA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_OSMUNDA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_LEAVES.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOPICEOXYLON_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PTILOPHYLLUM_BASE.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_LEAVES.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_ZAMITES_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_LEAVES.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOJUNIPEROXYLON_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(DICROIDIUM.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(JOHNSTONIA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCYTOPHYLLUM.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CLADOPHLEBIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(MICHELILLOA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CLADOPHLEBIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_MICHELILLOA.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_LEAVES.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_HEIDIPHYLLUM_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(OSMUNDACAULIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(DEAD_OSMUNDACAULIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LEAVES.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_LIRIODENDRITES_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_SAPLING.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_DOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_TRAPDOOR.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CRASSOSTREA_OYSTER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CRETACEOUS_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(CRETACEOUS_TIME_BLOCK.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(JURASSIC_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(JURASSIC_TIME_BLOCK.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(TRIASSIC_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(TRIASSIC_TIME_BLOCK.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(HENOSTONE_TRAP.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ALGAE_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CONIOPTERIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_DEAD_OSMUNDACAULIS.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_OSMUNDACAULIS.get(), cutoutRenderType);
			
			RenderTypeLookup.setRenderLayer(ARAUCARIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_LEAF_CARPET.get(), mippedRenderType);


			RenderTypeLookup.setRenderLayer(ARAUCARIA_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_WALL_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_WALL_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_WALL_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_WALL_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_WALL_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_WALL_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_SIGN.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_WALL_SIGN.get(), cutoutRenderType);
		}
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, ItemGroup group) {
        return register(name, block, BlockItem::new, new Item.Properties().group(group));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, BiFunction<Block, Item.Properties, BlockItem> item, Item.Properties itemProperties) {
        final RegistryObject<T> registryObject = BLOCKS.register(name, block);
        if (itemProperties != null) ItemInit.ITEMS.register(name, () -> item == null ? new BlockItem(registryObject.get(), itemProperties) : item.apply(registryObject.get(), itemProperties));
        return registryObject;
    }
	
}
