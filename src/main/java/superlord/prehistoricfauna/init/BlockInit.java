package superlord.prehistoricfauna.init;

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

	public static final Block HORSETAIL = new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("horsetail"); //Loot Table done
	public static final Block OSMUNDA = new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("osmunda"); //Loot table done
	public static final Block TALL_HORSETAIL = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("tall_horsetail"); //Loot Table done
	public static final Block TALL_OSMUNDA = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("tall_osmunda"); //Loot Table done
	public static final Block CLUBMOSS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("clubmoss"); //Loot Table done
	public static final Block MARCHANTIA = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("marchantia"); //Loot Table done
	public static final Block MOSS_CARPET = new MossBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)).setRegistryName("moss_carpet"); //Loot Table done
	public static final Block METASEQUOIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_planks"); //Loot Table done
	public static final Block METASEQUOIA_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_log"); //Loot Table done
	public static final Block METASEQUOIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("metasequoia_leaves"); //Loot Table done
	public static final Block METASEQUOIA_SAPLING = new PHFSapling(new PHFTreeSpawners.MetaSequoia(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("metasequoia_sapling"); //Loot Table done
	public static final Block STRIPPED_METASEQUOIA_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_metasequoia_log");//Loot Table done
	public static final Block METASEQUOIA_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_wood");//Loot Table done
	public static final Block STRIPPED_METASEQUOIA_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_metasequoia_wood");//Loot Table done
	public static final Block ARAUCARIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_planks");//Loot Table done
	public static final Block ARAUCARIA_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_log");//Loot Table done
	public static final Block ARAUCARIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("araucaria_leaves");//Loot Table done
	public static final Block ARAUCARIA_SAPLING = new PHFSapling(new PHFTreeSpawners.Araucaria(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("araucaria_sapling"); //Loot Table done
	public static final Block STRIPPED_ARAUCARIA_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_araucaria_log");//Loot Table done
	public static final Block ARAUCARIA_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_wood");//Loot Table done
	public static final Block STRIPPED_ARAUCARIA_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_araucaria_wood");//Loot Table done
	public static final Block METASEQUOIA_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_slab");//Loot Table done
	public static final Block ARAUCARIA_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_slab");//Loot Table done
	public static final Block METASEQUOIA_STAIRS = new PrehistoricStairsBlock(METASEQUOIA_PLANKS.getDefaultState(), Block.Properties.from(METASEQUOIA_PLANKS)).setRegistryName("metasequoia_stairs");//Loot Table done
	public static final Block ARAUCARIA_STAIRS = new PrehistoricStairsBlock(ARAUCARIA_PLANKS.getDefaultState(), Block.Properties.from(ARAUCARIA_PLANKS)).setRegistryName("araucaria_stairs");//Loot Table done
	public static final Block METASEQUOIA_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_fence");//Loot Table done
	public static final Block ARAUCARIA_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_fence");//Loot Table done
	public static final Block METASEQUOIA_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_fence_gate");//Loot Table done
	public static final Block ARAUCARIA_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_fence_gate");//Loot Table done
	public static final Block METASEQUOIA_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("metasequoia_button");//Loot Table done
	public static final Block ARAUCARIA_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("araucaria_button");//Loot Table done
	public static final Block METASEQUOIA_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("metasequoia_door");//Loot Table done
	public static final Block ARAUCARIA_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("araucaria_door");//Loot Table done
	public static final Block METASEQUOIA_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("metasequoia_pressure_plate");//Loot Table done
	public static final Block ARAUCARIA_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("araucaria_pressure_plate");//Loot Table done
	public static final Block METASEQUOIA_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("metasequoia_trapdoor");//Loot Table done
	public static final Block ARAUCARIA_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("araucaria_trapdoor");//Loot Table done
	public static final Block POTTED_METASEQUOIA_SAPLING = new FlowerPotBlock(METASEQUOIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_metasequoia_sapling");//Loot Table done
	public static final Block POTTED_ARAUCARIA_SAPLING = new FlowerPotBlock(ARAUCARIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_araucaria_sapling");//Loot Table done
	public static final Block POTTED_HORSETAIL = new FlowerPotBlock(HORSETAIL, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_horsetail"); //Loot Table done
	public static final Block POTTED_OSMUNDA = new FlowerPotBlock(OSMUNDA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_osmunda");//Loot Table done
	public static final Block POTTED_CLUBMOSS = new FlowerPotBlock(CLUBMOSS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_clubmoss"); //Loot Table done
	public static final Block POTTED_MARCHANTIA = new FlowerPotBlock(MARCHANTIA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_marchantia"); //Loot Table done
	public static final Block MOSSY_DIRT = new MossyDirtBlock(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(0.6F).sound(SoundType.PLANT)).setRegistryName("mossy_dirt"); //Loot Table done
	public static final Block LOAM = new MossyDirtBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).hardnessAndResistance(0.6F).sound(SoundType.GROUND)).setRegistryName("loam");//Loot Table done
	public static final Block PACKED_LOAM = new Block(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).hardnessAndResistance(0.6F).sound(SoundType.GROUND)).setRegistryName("packed_loam");
	public static final Block THESCELOSAURUS_EGG = new ThescelosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("thescelosaurus_egg");//Loot Table done
	public static final Block TRICERATOPS_EGG = new TriceratopsEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("triceratops_egg");//Loot Table done
	public static final Block ANKYLOSAURUS_EGG = new AnkylosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("ankylosaurus_egg");//Loot Table done
	public static final Block TYRANNOSAURUS_EGG = new TyrannosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("tyrannosaurus_egg");//Loot Table done
	public static final Block DAKOTARAPTOR_EGG = new DakotaraptorEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("dakotaraptor_egg");//Loot Table done
	public static final Block BASILEMYS_EGG = new BasilemysEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("basilemys_egg");//Loot Table done
	public static final Block CAMARASAURUS_EGG = new CamarasaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("camarasaurus_egg");//Loot Table done
	public static final Block ALLOSAURUS_EGG = new AllosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("allosaurus_egg");//Loot Table done
	public static final Block CERATOSAURUS_EGG = new CeratosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("ceratosaurus_egg");//Loot Table done
	public static final Block CHROMOGISAURUS_EGG = new ChromogisaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("chromogisaurus_egg");//Loot Table done
	public static final Block DRYOSAURUS_EGG = new DryosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("dryosaurus_egg");//Loot Table done
	public static final Block EILENODON_EGG = new EilenodonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("eilenodon_egg");//Loot Table done
	public static final Block HERRERASAURUS_EGG = new HerrerasaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("herrerasaurus_egg");//Loot Table done
	public static final Block HESPERORNITHOIDES_EGG = new HesperornithoidesEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("hesperornithoides_egg");//Loot Table done
	public static final Block HYPERODAPEDON_EGG = new HyperodapedonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("hyperodapedon_egg");//Loot Table done
	public static final Block STEGOSAURUS_EGG = new StegosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("stegosaurus_egg");//Loot Table done
	public static final Block MOSS_BLOCK = new Block(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)).setRegistryName("moss_block"); //Loot Table done
	public static final Block CONIOPTERIS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("coniopteris");//Loot Table done
	public static final Block TALL_OSMUNDACAULIS = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("tall_osmundacaulis"); //Loot Table done
	public static final Block PROTOPICEOXYLON_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_log");//Loot Table done
	public static final Block PROTOPICEOXYLON_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_planks");//Loot Table done
	public static final Block STRIPPED_PROTOPICEOXYLON_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_protopiceoxylon_log");//Loot Table done
	public static final Block PROTOPICEOXYLON_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_wood");//Loot Table done
	public static final Block STRIPPED_PROTOPICEOXYLON_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_protopiceoxylon_wood");//Loot Table done
	public static final Block PROTOPICEOXYLON_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("protopiceoxylon_leaves");//Loot Table done
	public static final Block PROTOPICEOXYLON_STAIRS = new PrehistoricStairsBlock(PROTOPICEOXYLON_PLANKS.getDefaultState(), Block.Properties.from(PROTOPICEOXYLON_PLANKS)).setRegistryName("protopiceoxylon_stairs");//Loot Table done
	public static final Block PROTOPICEOXYLON_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protopiceoxylon_door");//Loot Table done
	public static final Block PROTOPICEOXYLON_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_pressure_plate");//Loot Table done
	public static final Block PROTOPICEOXYLON_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_fence");//Loot Table done
	public static final Block PROTOPICEOXYLON_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protopiceoxylon_trapdoor");//Loot Table done
	public static final Block PROTOPICEOXYLON_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_fence_gate");//Loot Table done
	public static final Block PROTOPICEOXYLON_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_button");//Loot Table done
	public static final Block PROTOPICEOXYLON_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_slab");//Loot Table done
	public static final Block PROTOPICEOXYLON_SAPLING = new PHFSapling(new PHFTreeSpawners.Protopiceoxylon(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("protopiceoxylon_sapling"); //Loot Table done
	public static final Block POTTED_PROTOPICEOXYLON_SAPLING = new FlowerPotBlock(PROTOPICEOXYLON_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_protopiceoxylon_sapling");//Loot Table done
	public static final Block PTILOPHYLLUM_WOOD = new PtilophyllumBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(0.4F).sound(SoundType.WOOD).notSolid()).setRegistryName("ptilophyllum_wood");//Loot Table done
	public static final Block PTILOPHYLLUM_BASE = new PtilophyllumBaseBlock((PtilophyllumBlock)PTILOPHYLLUM_WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).tickRandomly().hardnessAndResistance(0.4F).sound(SoundType.WOOD).notSolid()).setRegistryName("ptilophyllum_base");//Loot Table done
	public static final Block ZAMITES_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("zamites_log");//Loot Table done
	public static final Block ZAMITES_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_planks");//Loot Table done
	public static final Block STRIPPED_ZAMITES_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_zamites_log");//Loot Table done
	public static final Block ZAMITES_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("zamites_wood");//Loot Table done
	public static final Block STRIPPED_ZAMITES_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_zamites_wood");//Loot Table done
	public static final Block ZAMITES_LEAVES = new ZamitesTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("zamites_leaves");//Loot Table done
	public static final Block ZAMITES_STAIRS = new PrehistoricStairsBlock(ZAMITES_PLANKS.getDefaultState(), Block.Properties.from(ZAMITES_PLANKS)).setRegistryName("zamites_stairs");//Loot Table done
	public static final Block ZAMITES_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("zamites_door");//Loot Table done
	public static final Block ZAMITES_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("zamites_pressure_plate");//Loot Table done
	public static final Block ZAMITES_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_fence");//Loot Table done
	public static final Block ZAMITES_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("zamites_trapdoor");//Loot Table done
	public static final Block ZAMITES_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_fence_gate");//Loot Table done
	public static final Block ZAMITES_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("zamites_button");//Loot Table done
	public static final Block ZAMITES_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_slab");//Loot Table done
	public static final Block ZAMITES_SAPLING = new ZamitesSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("zamites_sapling");//Loot Table done
	public static final Block POTTED_ZAMITES_SAPLING = new FlowerPotBlock(ZAMITES_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_zamites_sapling");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_log");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_planks");//Loot Table done
	public static final Block STRIPPED_PROTOJUNIPEROXYLON_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_protojuniperoxylon_log");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_wood");//Loot Table done
	public static final Block STRIPPED_PROTOJUNIPEROXYLON_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_protojuniperoxylon_wood");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("protojuniperoxylon_leaves");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_STAIRS = new PrehistoricStairsBlock(PROTOJUNIPEROXYLON_PLANKS.getDefaultState(), Block.Properties.from(PROTOJUNIPEROXYLON_PLANKS)).setRegistryName("protojuniperoxylon_stairs");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protojuniperoxylon_door");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_pressure_plate");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_fence");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protojuniperoxylon_trapdoor");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_fence_gate");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_button");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_slab");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_SAPLING = new PHFSapling(new PHFTreeSpawners.ProtoJuniper(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("protojuniperoxylon_sapling");//Loot Table done
	public static final Block POTTED_PROTOJUNIPEROXYLON_SAPLING = new FlowerPotBlock(PROTOJUNIPEROXYLON_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_protojuniperoxylon_sapling");//Loot Table done
	public static final Block DICROIDIUM = new DicroidiumBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("dicroidium");//Loot Table done
	public static final Block JOHNSTONIA = new JohnstoniaBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("johnstonia");//Loot Table done
	public static final Block SCYTOPHYLLUM = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("scytophyllum");//Loot Table done
	public static final Block CLADOPHLEBIS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("cladophlebis");//Loot Table done
	public static final Block MICHELILLOA = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("michelilloa");
	public static final Block POTTED_CLADOPHLEBIS = new FlowerPotBlock(CLADOPHLEBIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_cladophlebis");//Loot Table done
	public static final Block POTTED_MICHELILLOA = new FlowerPotBlock(MICHELILLOA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_michelilloa");//Loot Table done
	public static final Block HEIDIPHYLLUM_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_log");//Loot Table done
	public static final Block HEIDIPHYLLUM_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_planks");//Loot Table done
	public static final Block STRIPPED_HEIDIPHYLLUM_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_heidiphyllum_log");//Loot Table done
	public static final Block HEIDIPHYLLUM_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_wood");//Loot Table done
	public static final Block STRIPPED_HEIDIPHYLLUM_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_heidiphyllum_wood");//Loot Table done
	public static final Block HEIDIPHYLLUM_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("heidiphyllum_leaves");//Loot Table done
	public static final Block HEIDIPHYLLUM_STAIRS = new PrehistoricStairsBlock(HEIDIPHYLLUM_PLANKS.getDefaultState(), Block.Properties.from(HEIDIPHYLLUM_PLANKS)).setRegistryName("heidiphyllum_stairs");//Loot Table done
	public static final Block HEIDIPHYLLUM_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("heidiphyllum_door");//Loot Table done
	public static final Block HEIDIPHYLLUM_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_pressure_plate");//Loot Table done
	public static final Block HEIDIPHYLLUM_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_fence");//Loot Table done
	public static final Block HEIDIPHYLLUM_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("heidiphyllum_trapdoor");//Loot Table done
	public static final Block HEIDIPHYLLUM_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_fence_gate");//Loot Table done
	public static final Block HEIDIPHYLLUM_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_button");//Loot Table done
	public static final Block HEIDIPHYLLUM_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_slab");//Loot Table done
	public static final Block HEIDIPHYLLUM_SAPLING = new PHFSapling(new PHFTreeSpawners.Heidiphyllum(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("heidiphyllum_sapling");//Loot Table done
	public static final Block POTTED_HEIDIPHYLLUM_SAPLING = new FlowerPotBlock(HEIDIPHYLLUM_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_heidiphyllum_sapling");//Loot Table done
	public static final Block OSMUNDACAULIS = new ShortOsmundacaulisBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("osmundacaulis"); //Loot Table done
	public static final Block DEAD_OSMUNDACAULIS = new DeadConiopterisBlock(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.WOOD).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("dead_osmundacaulis"); //Loot Table done
	public static final Block LIRIODENDRITES_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_log");//Loot Table done
	public static final Block LIRIODENDRITES_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_planks");//Loot Table done
	public static final Block STRIPPED_LIRIODENDRITES_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_liriodendrites_log");//Loot Table done
	public static final Block LIRIODENDRITES_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_wood");//Loot Table done
	public static final Block STRIPPED_LIRIODENDRITES_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_liriodendrites_wood");//Loot Table done
	public static final Block LIRIODENDRITES_LEAVES = new LiriodendritesLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("liriodendrites_leaves");//Loot Table done
	public static final Block LIRIODENDRITES_STAIRS = new PrehistoricStairsBlock(LIRIODENDRITES_PLANKS.getDefaultState(), Block.Properties.from(LIRIODENDRITES_PLANKS)).setRegistryName("liriodendrites_stairs");//Loot Table done
	public static final Block LIRIODENDRITES_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("liriodendrites_door");//Loot Table done
	public static final Block LIRIODENDRITES_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_pressure_plate");//Loot Table done
	public static final Block LIRIODENDRITES_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_fence");//Loot Table done
	public static final Block LIRIODENDRITES_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("liriodendrites_trapdoor");//Loot Table done
	public static final Block LIRIODENDRITES_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_fence_gate");//Loot Table done
	public static final Block LIRIODENDRITES_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_button");//Loot Table done
	public static final Block LIRIODENDRITES_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_slab");//Loot Table done
	public static final Block LIRIODENDRITES_SAPLING = new PHFSapling(new PHFTreeSpawners.Liriodendrites(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("liriodendrites_sapling"); //Loot Table done
	public static final Block POTTED_LIRIODENDRITES_SAPLING = new FlowerPotBlock(LIRIODENDRITES_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_liriodendrites_sapling");//Loot Table done
	public static final Block SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("sandstone");//Loot Table done
	public static final Block SANDSTONE_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("sandstone_fossil");//Loot Table done
	public static final Block SMOOTH_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_sandstone");//Loot Table done
	public static final Block POLISHED_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_sandstone");//Loot Table done
	public static final Block SANDSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("sandstone_bricks");//Loot Table done
	public static final Block CHISELED_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_sandstone");//Loot Table done
	public static final Block SANDSTONE_WALL = new WallBlock(Block.Properties.from(SANDSTONE)).setRegistryName("sandstone_wall");//Loot Table done
	public static final Block SMOOTH_SANDSTONE_WALL = new WallBlock(Block.Properties.from(SMOOTH_SANDSTONE)).setRegistryName("smooth_sandstone_wall");//Loot Table done
	public static final Block SANDSTONE_BRICK_WALL = new WallBlock(Block.Properties.from(SANDSTONE_BRICKS)).setRegistryName("sandstone_brick_wall");//Loot Table done
	public static final Block SANDSTONE_STAIRS = new PrehistoricStairsBlock(SANDSTONE.getDefaultState(), Block.Properties.from(SANDSTONE)).setRegistryName("sandstone_stairs");//Loot Table done
	public static final Block SANDSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("sandstone_slab");//Loot Table done
	public static final Block POLISHED_SANDSTONE_STAIRS = new PrehistoricStairsBlock(POLISHED_SANDSTONE.getDefaultState(), Block.Properties.from(POLISHED_SANDSTONE)).setRegistryName("polished_sandstone_stairs");//Loot Table done
	public static final Block POLISHED_SANDSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_sandstone_slab");//Loot Table done
	public static final Block SANDSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(SANDSTONE_BRICKS.getDefaultState(), Block.Properties.from(SANDSTONE_BRICKS)).setRegistryName("sandstone_brick_stairs");//Loot Table done
	public static final Block SANDSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("sandstone_brick_slab");//Loot Table done
	public static final Block SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("siltstone");//Loot Table done
	public static final Block SILTSTONE_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("siltstone_fossil");//Loot Table done
	public static final Block SMOOTH_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_siltstone");//Loot Table done
	public static final Block POLISHED_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_siltstone");//Loot Table done
	public static final Block SILTSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("siltstone_bricks");//Loot Table done
	public static final Block CHISELED_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_siltstone");//Loot Table done
	public static final Block SILTSTONE_WALL = new WallBlock(Block.Properties.from(SILTSTONE)).setRegistryName("siltstone_wall");//Loot Table done
	public static final Block SMOOTH_SILTSTONE_WALL = new WallBlock(Block.Properties.from(SMOOTH_SILTSTONE)).setRegistryName("smooth_siltstone_wall");//Loot Table done
	public static final Block SILTSTONE_BRICK_WALL = new WallBlock(Block.Properties.from(SILTSTONE_BRICKS)).setRegistryName("siltstone_brick_wall");//Loot Table done
	public static final Block SILTSTONE_STAIRS = new PrehistoricStairsBlock(SILTSTONE.getDefaultState(), Block.Properties.from(SILTSTONE)).setRegistryName("siltstone_stairs");//Loot Table done
	public static final Block SILTSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("siltstone_slab");//Loot Table done
	public static final Block SILTSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("siltstone_brick_slab");//Loot Table done
	public static final Block SILTSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(SILTSTONE_BRICKS.getDefaultState(), Block.Properties.from(SILTSTONE_BRICKS)).setRegistryName("siltstone_brick_stairs");//Loot Table done
	public static final Block POLISHED_SILTSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_siltstone_slab");//Loot Table done
	public static final Block POLISHED_SILTSTONE_STAIRS = new PrehistoricStairsBlock(POLISHED_SILTSTONE.getDefaultState(), Block.Properties.from(POLISHED_SILTSTONE)).setRegistryName("polished_siltstone_stairs");//Loot Table done
	public static final Block CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk");//Loot Table done
	public static final Block CHALK_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("chalk_fossil");//Loot Table done
	public static final Block SMOOTH_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_chalk");//Loot Table done
	public static final Block POLISHED_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_chalk");//Loot Table done
	public static final Block CHALK_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk_bricks");//Loot Table done
	public static final Block CHISELED_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_chalk");//Loot Table done
	public static final Block CHALK_WALL = new WallBlock(Block.Properties.from(CHALK)).setRegistryName("chalk_wall");//Loot Table done
	public static final Block SMOOTH_CHALK_WALL = new WallBlock(Block.Properties.from(SMOOTH_CHALK)).setRegistryName("smooth_chalk_wall");//Loot Table done
	public static final Block CHALK_BRICK_WALL = new WallBlock(Block.Properties.from(CHALK_BRICKS)).setRegistryName("chalk_brick_wall");//Loot Table done
	public static final Block CHALK_STAIRS = new PrehistoricStairsBlock(CHALK.getDefaultState(), Block.Properties.from(CHALK)).setRegistryName("chalk_stairs");//Loot Table done
	public static final Block CHALK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk_slab");//Loot Table done
	public static final Block CHALK_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk_brick_slab");//Loot Table done
	public static final Block CHALK_BRICK_STAIRS = new PrehistoricStairsBlock(CHALK_BRICKS.getDefaultState(), Block.Properties.from(CHALK_BRICKS)).setRegistryName("chalk_brick_stairs");//Loot Table done
	public static final Block POLISHED_CHALK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_chalk_slab");//Loot Table done
	public static final Block POLISHED_CHALK_STAIRS = new PrehistoricStairsBlock(POLISHED_CHALK.getDefaultState(), Block.Properties.from(POLISHED_CHALK)).setRegistryName("polished_chalk_stairs");//Loot Table done
	public static final Block SILLOSUCHUS_EGG = new SillosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("sillosuchus_egg");//Loot Table done
	public static final Block PORTAL_FRAME = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).lightValue(9)).setRegistryName("portal_frame");//Loot Table done
	public static final Block CRETACEOUS_TIME_BLOCK = new CretaceousTimeBlock().setRegistryName("cretaceous_time_block");//Loot Table done
	public static final Block JURASSIC_TIME_BLOCK = new JurassicTimeBlock().setRegistryName("jurassic_time_block");//Loot Table done
	public static final Block TRIASSIC_TIME_BLOCK = new TriassicTimeBlock().setRegistryName("triassic_time_block");//Loot Table done
	public static final Block CRASSOSTREA_OYSTER = new CrassostreaOysterBlock(Block.Properties.create(Material.CORAL).doesNotBlockMovement().hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.STONE).harvestLevel(0)).setRegistryName("crassostrea_oyster");
	//public static final Block DIDELPHODON_BURROW = new DidelphodonBurrowBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.GROUND)).setRegistryName("didelphodon_burrow");
	public static final Block HENOSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone");
	public static final Block CARVED_HENOSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("carved_henostone");
	public static final Block HENOSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_bricks");
	public static final Block DARK_HENOSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("dark_henostone_bricks");
	public static final Block HENOSTONE_PILLAR = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_pillar");
	public static final Block CHISELED_HENOSTONE_PILLAR = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_henostone_pillar");
	public static final Block HENOSTONE_STAIRS = new PrehistoricStairsBlock(HENOSTONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_stairs");
	public static final Block HENOSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_slab");
	public static final Block HENOSTONE_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_wall");
	public static final Block HENOSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(HENOSTONE_BRICKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_stairs");
	public static final Block HENOSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_slab");
	public static final Block HENOSTONE_BRICK_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_wall");
	public static final Block DARK_HENOSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(DARK_HENOSTONE_BRICKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("dark_henostone_brick_stairs");
	public static final Block DARK_HENOSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("dark_henostone_brick_slab");
	public static final Block DARK_HENOSTONE_BRICK_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("dark_henostone_brick_wall");
	public static final Block HENOSTONE_TRAP = new TrapBlock(TrapBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_trap");
	public static final Block LARGE_AMMONITE_FOSSIL = new AmmoniteLargeShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("large_ammonite_fossil");
	public static final Block MEDIUM_AMMONITE_FOSSIL = new AmmoniteMediumShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("medium_ammonite_fossil");
	public static final Block SMALL_AMMONITE_FOSSIL = new AmmoniteSmallShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("small_ammonite_fossil");
	public static final Block GIANT_AMMONITE_SHELL_BF = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_ammonite_fossil_piece_bf");
	public static final Block GIANT_AMMONITE_SHELL_BB = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_ammonite_fossil_piece_bb");
	public static final Block GIANT_AMMONITE_SHELL_TF = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_ammonite_fossil_piece_tf");
	public static final Block GIANT_AMMONITE_SHELL_TB = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_ammonite_fossil_piece_tb");
	public static final Block PLASTERED_AMMONITES = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("plastered_ammonites");
	public static final Block PETRIFIED_WOOD = new LogBlock(MaterialColor.PINK, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("petrified_wood");
	public static final Block POLISHED_PETRIFIED_WOOD = new LogBlock(MaterialColor.PINK, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_petrified_wood");
	public static final Block SAUROSUCHUS_EGG = new SaurosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("saurosuchus_egg");//Loot Table done
	public static final Block ISCHIGUALASTIA_EGG = new IschigualastiaEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("ischigualastia_egg");
	public static final Block EXAERETODON_EGG = new ExaeretodonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("exaeretodon_egg");//Loot Table done
	public static final Block PALEONTOLOGY_TABLE = new PaleontologyTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)).setRegistryName("paleontology_table");
	public static final Block ALGAE_CARPET = new AlgaeBlock(Block.Properties.create(Material.OCEAN_PLANT).hardnessAndResistance(0.2F).sound(SoundType.SLIME).notSolid()).setRegistryName("algae_carpet");
	public static final Block ARAUCARIA_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ARAUCARIA).setRegistryName("araucaria_sign");
	public static final Block ARAUCARIA_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ARAUCARIA).setRegistryName("araucaria_wall_sign");
	public static final Block METASEQUOIA_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.METASEQUOIA).setRegistryName("metasequoia_sign");
	public static final Block METASEQUOIA_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.METASEQUOIA).setRegistryName("metasequoia_wall_sign");
	public static final Block HEIDIPHYLLUM_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.HEIDIPHYLLUM).setRegistryName("heidiphyllum_sign");
	public static final Block HEIDIPHYLLUM_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.HEIDIPHYLLUM).setRegistryName("heidiphyllum_wall_sign");
	public static final Block LIRIODENDRITES_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.LIRIODENDRITES).setRegistryName("liriodendrites_sign");
	public static final Block LIRIODENDRITES_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.LIRIODENDRITES).setRegistryName("liriodendrites_wall_sign");
	public static final Block PROTOPICEOXYLON_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOPICEOXYLON).setRegistryName("protopiceoxylon_sign");
	public static final Block PROTOPICEOXYLON_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOPICEOXYLON).setRegistryName("protopiceoxylon_wall_sign");
	public static final Block ZAMITES_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ZAMITES).setRegistryName("zamites_sign");
	public static final Block ZAMITES_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.ZAMITES).setRegistryName("zamites_wall_sign");
	public static final Block PROTOJUNIPEROXYLON_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON).setRegistryName("protojuniperoxylon_sign");
	public static final Block PROTOJUNIPEROXYLON_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON).setRegistryName("protojuniperoxylon_wall_sign");
	public static final Block PALEOSCRIBE = new PaleoscribeBlock(Block.Properties.create(Material.WOOD).variableOpacity().hardnessAndResistance(2.0F, 5.0F).sound(SoundType.WOOD)).setRegistryName("paleoscribe");
	public static final Block POTTED_DEAD_OSMUNDACAULIS = new FlowerPotBlock(DEAD_OSMUNDACAULIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_dead_osmundacaulis");//Loot Table done
	public static final Block POTTED_SHORT_OSMUNDACAULIS = new FlowerPotBlock(OSMUNDACAULIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_short_osmundacaulis");//Loot Table done
	public static final Block POTTED_CONIOPTERIS = new FlowerPotBlock(CONIOPTERIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_coniopteris");//Loot Table done
	public static final Block SILT = new SandBlock(0x8C603C, Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)).setRegistryName("silt");
	public static final Block HARDENED_SILT = new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)).setRegistryName("hardened_silt");

	public static final RegistryObject<TriassicPortalBlock> TRIASSIC_PORTAL = BLOCKS.register("triassic_portal", () -> new TriassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));
	public static final RegistryObject<JurassicPortalBlock> JURASSIC_PORTAL = BLOCKS.register("jurassic_portal", () -> new JurassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));
	public static final RegistryObject<CretaceousPortalBlock> CRETACEOUS_PORTAL = BLOCKS.register("cretaceous_portal", () -> new CretaceousPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));

	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "metasequoia_vertical_slab", () -> new VerticalSlabBlock(Properties.from(METASEQUOIA_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "araucaria_vertical_slab", () -> new VerticalSlabBlock(Properties.from(ARAUCARIA_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "liriodendrites_vertical_slab", () -> new VerticalSlabBlock(Properties.from(LIRIODENDRITES_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_slab", () -> new VerticalSlabBlock(Properties.from(PROTOPICEOXYLON_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "zamites_vertical_slab", () -> new VerticalSlabBlock(Properties.from(ZAMITES_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_slab", () -> new VerticalSlabBlock(Properties.from(PROTOJUNIPEROXYLON_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HEIDIPHYLLUM_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "sandstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SANDSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_sandstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_SANDSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "sandstone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SANDSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "siltstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SILTSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_siltstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_SILTSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "siltstone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(SILTSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chalk_vertical_slab", () -> new VerticalSlabBlock(Properties.from(CHALK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_chalk_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_CHALK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chalk_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(CHALK_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_DARK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "dark_henostone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(DARK_HENOSTONE_BRICK_SLAB)), PFBuilding.instance);

	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "metasequoia_vertical_planks", () -> new Block(Properties.from(METASEQUOIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "araucaria_vertical_planks", () -> new Block(Properties.from(ARAUCARIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "liriodendrites_vertical_planks", () -> new Block(Properties.from(LIRIODENDRITES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_planks", () -> new Block(Properties.from(PROTOPICEOXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "zamites_vertical_planks", () -> new Block(Properties.from(ZAMITES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_planks", () -> new Block(Properties.from(PROTOJUNIPEROXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_planks", () -> new Block(Properties.from(HEIDIPHYLLUM_PLANKS)), PFBuilding.instance);

	public static final RegistryObject<Block> METASEQUOIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "metasequoia_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> ARAUCARIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "araucaria_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LEAF_CARPET = HELPER.createCompatBlock("quark", "liriodendrites_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protopiceoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protojuniperoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LEAF_CARPET = HELPER.createCompatBlock("quark", "heidiphyllum_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(HORSETAIL);
		event.getRegistry().register(OSMUNDA);
		event.getRegistry().register(TALL_HORSETAIL);
		event.getRegistry().register(TALL_OSMUNDA);
		event.getRegistry().register(CLUBMOSS);
		event.getRegistry().register(MARCHANTIA);
		event.getRegistry().register(MOSS_CARPET);
		event.getRegistry().register(METASEQUOIA_LEAVES);
		event.getRegistry().register(METASEQUOIA_LOG);
		event.getRegistry().register(METASEQUOIA_PLANKS);
		event.getRegistry().register(METASEQUOIA_SAPLING);
		event.getRegistry().register(STRIPPED_METASEQUOIA_LOG);
		event.getRegistry().register(METASEQUOIA_WOOD);
		event.getRegistry().register(STRIPPED_METASEQUOIA_WOOD);
		event.getRegistry().register(ARAUCARIA_LEAVES);
		event.getRegistry().register(ARAUCARIA_LOG);
		event.getRegistry().register(ARAUCARIA_PLANKS);
		event.getRegistry().register(ARAUCARIA_SAPLING);
		event.getRegistry().register(STRIPPED_ARAUCARIA_LOG);
		event.getRegistry().register(ARAUCARIA_WOOD);
		event.getRegistry().register(STRIPPED_ARAUCARIA_WOOD);
		event.getRegistry().register(ARAUCARIA_BUTTON);
		event.getRegistry().register(ARAUCARIA_DOOR);
		event.getRegistry().register(ARAUCARIA_FENCE);
		event.getRegistry().register(ARAUCARIA_FENCE_GATE);
		event.getRegistry().register(ARAUCARIA_PRESSURE_PLATE);
		event.getRegistry().register(ARAUCARIA_SLAB);
		event.getRegistry().register(ARAUCARIA_STAIRS);
		event.getRegistry().register(ARAUCARIA_TRAPDOOR);
		event.getRegistry().register(METASEQUOIA_BUTTON);
		event.getRegistry().register(METASEQUOIA_DOOR);
		event.getRegistry().register(METASEQUOIA_FENCE);
		event.getRegistry().register(METASEQUOIA_FENCE_GATE);
		event.getRegistry().register(METASEQUOIA_PRESSURE_PLATE);
		event.getRegistry().register(METASEQUOIA_SLAB);
		event.getRegistry().register(METASEQUOIA_STAIRS);
		event.getRegistry().register(METASEQUOIA_TRAPDOOR);
		event.getRegistry().register(POTTED_ARAUCARIA_SAPLING);
		event.getRegistry().register(POTTED_METASEQUOIA_SAPLING);
		event.getRegistry().register(POTTED_CLUBMOSS);
		event.getRegistry().register(POTTED_HORSETAIL);
		event.getRegistry().register(POTTED_MARCHANTIA);
		event.getRegistry().register(POTTED_OSMUNDA);
		event.getRegistry().register(MOSSY_DIRT);
		event.getRegistry().register(THESCELOSAURUS_EGG);
		event.getRegistry().register(TRICERATOPS_EGG);
		event.getRegistry().register(TYRANNOSAURUS_EGG);
		event.getRegistry().register(ANKYLOSAURUS_EGG);
		event.getRegistry().register(DAKOTARAPTOR_EGG);
		event.getRegistry().register(BASILEMYS_EGG);
		event.getRegistry().register(LOAM);
		event.getRegistry().register(PACKED_LOAM);
		event.getRegistry().register(CAMARASAURUS_EGG);
		event.getRegistry().register(MOSS_BLOCK);
		event.getRegistry().register(CONIOPTERIS);
		event.getRegistry().register(TALL_OSMUNDACAULIS);
		event.getRegistry().register(PROTOPICEOXYLON_LOG);
		event.getRegistry().register(PROTOPICEOXYLON_BUTTON);
		event.getRegistry().register(PROTOPICEOXYLON_DOOR);
		event.getRegistry().register(PROTOPICEOXYLON_FENCE);
		event.getRegistry().register(PROTOPICEOXYLON_FENCE_GATE);
		event.getRegistry().register(PROTOPICEOXYLON_LEAVES);
		event.getRegistry().register(PROTOPICEOXYLON_PLANKS);
		event.getRegistry().register(PROTOPICEOXYLON_PRESSURE_PLATE);
		event.getRegistry().register(PROTOPICEOXYLON_SAPLING);
		event.getRegistry().register(PROTOPICEOXYLON_SLAB);
		event.getRegistry().register(PROTOPICEOXYLON_STAIRS);
		event.getRegistry().register(PROTOPICEOXYLON_TRAPDOOR);
		event.getRegistry().register(PROTOPICEOXYLON_WOOD);
		event.getRegistry().register(STRIPPED_PROTOPICEOXYLON_LOG);
		event.getRegistry().register(STRIPPED_PROTOPICEOXYLON_WOOD);
		event.getRegistry().register(PTILOPHYLLUM_WOOD);
		event.getRegistry().register(PTILOPHYLLUM_BASE);
		event.getRegistry().register(POTTED_PROTOPICEOXYLON_SAPLING);
		event.getRegistry().register(ZAMITES_LOG);
		event.getRegistry().register(ZAMITES_BUTTON);
		event.getRegistry().register(ZAMITES_DOOR);
		event.getRegistry().register(ZAMITES_FENCE);
		event.getRegistry().register(ZAMITES_FENCE_GATE);
		event.getRegistry().register(ZAMITES_PLANKS);
		event.getRegistry().register(ZAMITES_PRESSURE_PLATE);
		event.getRegistry().register(ZAMITES_SLAB);
		event.getRegistry().register(ZAMITES_STAIRS);
		event.getRegistry().register(ZAMITES_TRAPDOOR);
		event.getRegistry().register(ZAMITES_WOOD);
		event.getRegistry().register(STRIPPED_ZAMITES_LOG);
		event.getRegistry().register(STRIPPED_ZAMITES_WOOD);
		event.getRegistry().register(ZAMITES_LEAVES);
		event.getRegistry().register(ZAMITES_SAPLING);
		event.getRegistry().register(POTTED_ZAMITES_SAPLING);
		event.getRegistry().register(PROTOJUNIPEROXYLON_LOG);
		event.getRegistry().register(PROTOJUNIPEROXYLON_BUTTON);
		event.getRegistry().register(PROTOJUNIPEROXYLON_DOOR);
		event.getRegistry().register(PROTOJUNIPEROXYLON_FENCE);
		event.getRegistry().register(PROTOJUNIPEROXYLON_FENCE_GATE);
		event.getRegistry().register(PROTOJUNIPEROXYLON_PLANKS);
		event.getRegistry().register(PROTOJUNIPEROXYLON_PRESSURE_PLATE);
		event.getRegistry().register(PROTOJUNIPEROXYLON_SLAB);
		event.getRegistry().register(PROTOJUNIPEROXYLON_STAIRS);
		event.getRegistry().register(PROTOJUNIPEROXYLON_TRAPDOOR);
		event.getRegistry().register(PROTOJUNIPEROXYLON_WOOD);
		event.getRegistry().register(STRIPPED_PROTOJUNIPEROXYLON_LOG);
		event.getRegistry().register(STRIPPED_PROTOJUNIPEROXYLON_WOOD);
		event.getRegistry().register(PROTOJUNIPEROXYLON_LEAVES);
		event.getRegistry().register(PROTOJUNIPEROXYLON_SAPLING);
		event.getRegistry().register(POTTED_PROTOJUNIPEROXYLON_SAPLING);
		event.getRegistry().register(DICROIDIUM);
		event.getRegistry().register(JOHNSTONIA);
		event.getRegistry().register(CLADOPHLEBIS);
		event.getRegistry().register(SCYTOPHYLLUM);
		event.getRegistry().register(MICHELILLOA);
		event.getRegistry().register(POTTED_CLADOPHLEBIS);
		event.getRegistry().register(POTTED_MICHELILLOA);
		event.getRegistry().register(HEIDIPHYLLUM_LOG);
		event.getRegistry().register(HEIDIPHYLLUM_BUTTON);
		event.getRegistry().register(HEIDIPHYLLUM_DOOR);
		event.getRegistry().register(HEIDIPHYLLUM_FENCE);
		event.getRegistry().register(HEIDIPHYLLUM_FENCE_GATE);
		event.getRegistry().register(HEIDIPHYLLUM_PLANKS);
		event.getRegistry().register(HEIDIPHYLLUM_PRESSURE_PLATE);
		event.getRegistry().register(HEIDIPHYLLUM_SLAB);
		event.getRegistry().register(HEIDIPHYLLUM_STAIRS);
		event.getRegistry().register(HEIDIPHYLLUM_TRAPDOOR);
		event.getRegistry().register(HEIDIPHYLLUM_WOOD);
		event.getRegistry().register(STRIPPED_HEIDIPHYLLUM_LOG);
		event.getRegistry().register(STRIPPED_HEIDIPHYLLUM_WOOD);
		event.getRegistry().register(HEIDIPHYLLUM_LEAVES);
		event.getRegistry().register(HEIDIPHYLLUM_SAPLING);
		event.getRegistry().register(POTTED_HEIDIPHYLLUM_SAPLING);
		event.getRegistry().register(OSMUNDACAULIS);
		event.getRegistry().register(DEAD_OSMUNDACAULIS);
		event.getRegistry().register(ALLOSAURUS_EGG);
		event.getRegistry().register(CERATOSAURUS_EGG);
		event.getRegistry().register(CHROMOGISAURUS_EGG);
		event.getRegistry().register(DRYOSAURUS_EGG);
		event.getRegistry().register(EILENODON_EGG);
		event.getRegistry().register(HERRERASAURUS_EGG);
		event.getRegistry().register(HESPERORNITHOIDES_EGG);
		event.getRegistry().register(HYPERODAPEDON_EGG);
		event.getRegistry().register(STEGOSAURUS_EGG);
		event.getRegistry().register(LIRIODENDRITES_LOG);
		event.getRegistry().register(LIRIODENDRITES_BUTTON);
		event.getRegistry().register(LIRIODENDRITES_DOOR);
		event.getRegistry().register(LIRIODENDRITES_FENCE);
		event.getRegistry().register(LIRIODENDRITES_FENCE_GATE);
		event.getRegistry().register(LIRIODENDRITES_PLANKS);
		event.getRegistry().register(LIRIODENDRITES_PRESSURE_PLATE);
		event.getRegistry().register(LIRIODENDRITES_SLAB);
		event.getRegistry().register(LIRIODENDRITES_STAIRS);
		event.getRegistry().register(LIRIODENDRITES_TRAPDOOR);
		event.getRegistry().register(LIRIODENDRITES_WOOD);
		event.getRegistry().register(STRIPPED_LIRIODENDRITES_LOG);
		event.getRegistry().register(STRIPPED_LIRIODENDRITES_WOOD);
		event.getRegistry().register(LIRIODENDRITES_LEAVES);
		event.getRegistry().register(LIRIODENDRITES_SAPLING);
		event.getRegistry().register(POTTED_LIRIODENDRITES_SAPLING);
		event.getRegistry().register(SANDSTONE);
		event.getRegistry().register(SANDSTONE_FOSSIL);
		event.getRegistry().register(POLISHED_SANDSTONE);
		event.getRegistry().register(SMOOTH_SANDSTONE);
		event.getRegistry().register(SANDSTONE_BRICKS);
		event.getRegistry().register(CHISELED_SANDSTONE);
		event.getRegistry().register(SANDSTONE_SLAB);
		event.getRegistry().register(SANDSTONE_STAIRS);
		event.getRegistry().register(SANDSTONE_WALL);
		event.getRegistry().register(SMOOTH_SANDSTONE_WALL);
		event.getRegistry().register(SANDSTONE_BRICK_WALL);
		event.getRegistry().register(SANDSTONE_BRICK_SLAB);
		event.getRegistry().register(SANDSTONE_BRICK_STAIRS);
		event.getRegistry().register(POLISHED_SANDSTONE_SLAB);
		event.getRegistry().register(POLISHED_SANDSTONE_STAIRS);
		event.getRegistry().register(SILTSTONE);
		event.getRegistry().register(SILTSTONE_FOSSIL);
		event.getRegistry().register(POLISHED_SILTSTONE);
		event.getRegistry().register(SMOOTH_SILTSTONE);
		event.getRegistry().register(SILTSTONE_BRICKS);
		event.getRegistry().register(CHISELED_SILTSTONE);
		event.getRegistry().register(SILTSTONE_SLAB);
		event.getRegistry().register(SILTSTONE_WALL);
		event.getRegistry().register(SMOOTH_SILTSTONE_WALL);
		event.getRegistry().register(SILTSTONE_BRICK_WALL);
		event.getRegistry().register(SILTSTONE_STAIRS);
		event.getRegistry().register(SILTSTONE_BRICK_STAIRS);
		event.getRegistry().register(SILTSTONE_BRICK_SLAB);
		event.getRegistry().register(POLISHED_SILTSTONE_SLAB);
		event.getRegistry().register(POLISHED_SILTSTONE_STAIRS);
		event.getRegistry().register(CHALK);
		event.getRegistry().register(CHALK_FOSSIL);
		event.getRegistry().register(POLISHED_CHALK);
		event.getRegistry().register(SMOOTH_CHALK);
		event.getRegistry().register(CHALK_BRICKS);
		event.getRegistry().register(CHISELED_CHALK);
		event.getRegistry().register(CHALK_SLAB);
		event.getRegistry().register(CHALK_WALL);
		event.getRegistry().register(SMOOTH_CHALK_WALL);
		event.getRegistry().register(CHALK_BRICK_WALL);
		event.getRegistry().register(CHALK_STAIRS);
		event.getRegistry().register(CHALK_BRICK_STAIRS);
		event.getRegistry().register(CHALK_BRICK_SLAB);
		event.getRegistry().register(POLISHED_CHALK_SLAB);
		event.getRegistry().register(POLISHED_CHALK_STAIRS);
		event.getRegistry().register(SILLOSUCHUS_EGG);
		event.getRegistry().register(PORTAL_FRAME);
		event.getRegistry().register(CRETACEOUS_TIME_BLOCK);
		event.getRegistry().register(JURASSIC_TIME_BLOCK);
		event.getRegistry().register(TRIASSIC_TIME_BLOCK);
		event.getRegistry().register(CRASSOSTREA_OYSTER);
		event.getRegistry().register(HENOSTONE);
		event.getRegistry().register(CARVED_HENOSTONE);
		event.getRegistry().register(HENOSTONE_BRICKS);
		event.getRegistry().register(DARK_HENOSTONE_BRICKS);
		event.getRegistry().register(HENOSTONE_PILLAR);
		event.getRegistry().register(CHISELED_HENOSTONE_PILLAR);
		event.getRegistry().register(HENOSTONE_SLAB);
		event.getRegistry().register(HENOSTONE_STAIRS);
		event.getRegistry().register(HENOSTONE_WALL);
		event.getRegistry().register(HENOSTONE_BRICK_SLAB);
		event.getRegistry().register(HENOSTONE_BRICK_STAIRS);
		event.getRegistry().register(HENOSTONE_BRICK_WALL);
		event.getRegistry().register(DARK_HENOSTONE_BRICK_SLAB);
		event.getRegistry().register(DARK_HENOSTONE_BRICK_STAIRS);
		event.getRegistry().register(DARK_HENOSTONE_BRICK_WALL);
		event.getRegistry().register(HENOSTONE_TRAP);
		event.getRegistry().register(LARGE_AMMONITE_FOSSIL);
		event.getRegistry().register(MEDIUM_AMMONITE_FOSSIL);
		event.getRegistry().register(SMALL_AMMONITE_FOSSIL);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_BB);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_BF);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_TB);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_TF);
		event.getRegistry().register(PLASTERED_AMMONITES);
		event.getRegistry().register(PETRIFIED_WOOD);
		event.getRegistry().register(POLISHED_PETRIFIED_WOOD);
		event.getRegistry().register(SAUROSUCHUS_EGG);
		event.getRegistry().register(ISCHIGUALASTIA_EGG);
		event.getRegistry().register(EXAERETODON_EGG);
		event.getRegistry().register(PALEONTOLOGY_TABLE);
		event.getRegistry().register(ALGAE_CARPET);
		event.getRegistry().register(ARAUCARIA_SIGN);
		event.getRegistry().register(ARAUCARIA_WALL_SIGN);
		event.getRegistry().register(METASEQUOIA_SIGN);
		event.getRegistry().register(METASEQUOIA_WALL_SIGN);
		event.getRegistry().register(HEIDIPHYLLUM_SIGN);
		event.getRegistry().register(HEIDIPHYLLUM_WALL_SIGN);
		event.getRegistry().register(LIRIODENDRITES_SIGN);
		event.getRegistry().register(LIRIODENDRITES_WALL_SIGN);
		event.getRegistry().register(PROTOJUNIPEROXYLON_SIGN);
		event.getRegistry().register(PROTOJUNIPEROXYLON_WALL_SIGN);
		event.getRegistry().register(PROTOPICEOXYLON_SIGN);
		event.getRegistry().register(PROTOPICEOXYLON_WALL_SIGN);
		event.getRegistry().register(ZAMITES_SIGN);
		event.getRegistry().register(ZAMITES_WALL_SIGN);
		event.getRegistry().register(PALEOSCRIBE);
		event.getRegistry().register(POTTED_DEAD_OSMUNDACAULIS);
		event.getRegistry().register(POTTED_SHORT_OSMUNDACAULIS);
		event.getRegistry().register(POTTED_CONIOPTERIS);
		event.getRegistry().register(SILT);
		event.getRegistry().register(HARDENED_SILT);
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderType cutoutRenderType = RenderType.getCutout();
			RenderType mippedRenderType = RenderType.getCutoutMipped();
			RenderType translucentRenderType = RenderType.getTranslucent();

			RenderTypeLookup.setRenderLayer(HORSETAIL, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(OSMUNDA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TALL_HORSETAIL, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TALL_OSMUNDA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TALL_OSMUNDACAULIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CLUBMOSS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(MARCHANTIA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CONIOPTERIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_LEAVES, mippedRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_LEAVES, mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_ARAUCARIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_METASEQUOIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOPICEOXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CLUBMOSS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_HORSETAIL, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_MARCHANTIA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_OSMUNDA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_TRAPDOOR, cutoutRenderType);
			/**RenderTypeLookup.setRenderLayer(CYPRESS_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CYPRESS_LEAVES, mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CYPRESS_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CYPRESS_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CYPRESS_TRAPDOOR, cutoutRenderType);*/
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_LEAVES, mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOPICEOXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PTILOPHYLLUM_BASE, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_ZAMITES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOJUNIPEROXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(DICROIDIUM, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(JOHNSTONIA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCYTOPHYLLUM, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CLADOPHLEBIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(MICHELILLOA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CLADOPHLEBIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_MICHELILLOA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_HEIDIPHYLLUM_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(OSMUNDACAULIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(DEAD_OSMUNDACAULIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_LIRIODENDRITES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CRASSOSTREA_OYSTER, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CRETACEOUS_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(CRETACEOUS_TIME_BLOCK, translucentRenderType);
			RenderTypeLookup.setRenderLayer(JURASSIC_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(JURASSIC_TIME_BLOCK, translucentRenderType);
			RenderTypeLookup.setRenderLayer(TRIASSIC_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(TRIASSIC_TIME_BLOCK, translucentRenderType);
			RenderTypeLookup.setRenderLayer(HENOSTONE_TRAP, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ALGAE_CARPET, mippedRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CONIOPTERIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_DEAD_OSMUNDACAULIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_SHORT_OSMUNDACAULIS, cutoutRenderType);

			RenderTypeLookup.setRenderLayer(ARAUCARIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_LEAF_CARPET.get(), mippedRenderType);


			RenderTypeLookup.setRenderLayer(ARAUCARIA_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ARAUCARIA_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_WALL_SIGN, cutoutRenderType);
		}
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		//Log, Stripped Log, Wood, Stripped Wood, Planks, Stairs, Slab, Fence, Fence Gate, Trapdoor, Door, Button, Pressure Plate
		//Metasequoia
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_METASEQUOIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_metasequoia_log"));
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_METASEQUOIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_metasequoia_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_slab"));
		//Araucaria
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ARAUCARIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_araucaria_log"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ARAUCARIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_araucaria_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_slab"));
		//Liriodendrites
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_LIRIODENDRITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_liriodendrites_log"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_LIRIODENDRITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_liriodendrites_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_slab"));
		//Protopiceoxylon
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOPICEOXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protopiceoxylon_log"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protopiceoxylon_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_slab"));
		//Zamites
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ZAMITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_zamites_log"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ZAMITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_zamites_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_slab"));
		//Protojuniperoxylon
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOJUNIPEROXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protojuniperoxylon_log"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOJUNIPEROXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protojuniperoxylon_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_slab"));
		//Heidiphyllum
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_log"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_HEIDIPHYLLUM_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_heidiphyllum_log"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_heidiphyllum_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_planks"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_slab"));
		//Sandstone
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_FOSSIL, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_fossil"));
		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("smooth_sandstone"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_sandstone"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_SANDSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_sandstone_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_SANDSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_sandstone_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_BRICKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_bricks"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_brick_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_brick_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.CHISELED_SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chiseled_sandstone"));
		//Siltstone
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_FOSSIL, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_fossil"));
		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("smooth_siltstone"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_siltstone"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_SILTSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_siltstone_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_SILTSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_siltstone_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_BRICKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_bricks"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_brick_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_brick_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.CHISELED_SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chiseled_siltstone"));

		//Chalk
		event.getRegistry().register(new BlockItem(BlockInit.CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_FOSSIL, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_fossil"));
		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("smooth_chalk"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_chalk"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CHALK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_chalk_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CHALK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_chalk_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_BRICKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_bricks"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_brick_slab"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_brick_stairs"));
		event.getRegistry().register(new BlockItem(BlockInit.CHISELED_CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chiseled_chalk"));

		//Dirts
		event.getRegistry().register(new BlockItem(BlockInit.MOSSY_DIRT, new Item.Properties().group(PFBuilding.instance)).setRegistryName("mossy_dirt"));
		event.getRegistry().register(new BlockItem(BlockInit.LOAM, new Item.Properties().group(PFBuilding.instance)).setRegistryName("loam"));
		event.getRegistry().register(new BlockItem(BlockInit.PACKED_LOAM, new Item.Properties().group(PFBuilding.instance)).setRegistryName("packed_loam"));
		event.getRegistry().register(new BlockItem(BlockInit.SILT, new Item.Properties().group(PFBuilding.instance)).setRegistryName("silt"));
		event.getRegistry().register(new BlockItem(BlockInit.HARDENED_SILT, new Item.Properties().group(PFBuilding.instance)).setRegistryName("hardened_silt"));

		//PlasteredAmmonites,PetrifiedWood
		event.getRegistry().register(new BlockItem(BlockInit.PLASTERED_AMMONITES, new Item.Properties().group(PFBuilding.instance)).setRegistryName("plastered_ammonites"));
		event.getRegistry().register(new BlockItem(BlockInit.PETRIFIED_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("petrified_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_PETRIFIED_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_petrified_wood"));

		//Leaves
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_leaves"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_leaves"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_leaves"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_leaves"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_leaves"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_leaves"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_leaves"));

		//Saplings
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_sapling"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_sapling"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_sapling"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_sapling"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_sapling"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_sapling"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_sapling"));

		//Plants
		event.getRegistry().register(new BlockItem(BlockInit.HORSETAIL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("horsetail"));
		event.getRegistry().register(new BlockItem(BlockInit.TALL_HORSETAIL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_horsetail"));
		event.getRegistry().register(new BlockItem(BlockInit.OSMUNDA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("osmunda"));
		event.getRegistry().register(new BlockItem(BlockInit.TALL_OSMUNDA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_osmunda"));
		event.getRegistry().register(new BlockItem(BlockInit.CLUBMOSS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("clubmoss"));
		event.getRegistry().register(new BlockItem(BlockInit.MARCHANTIA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("marchantia"));
		event.getRegistry().register(new BlockItem(BlockInit.CONIOPTERIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("coniopteris"));
		event.getRegistry().register(new BlockItem(BlockInit.OSMUNDACAULIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("osmundacaulis"));
		event.getRegistry().register(new BlockItem(BlockInit.TALL_OSMUNDACAULIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_osmundacaulis"));
		event.getRegistry().register(new BlockItem(BlockInit.DICROIDIUM, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dicroidium"));
		event.getRegistry().register(new BlockItem(BlockInit.JOHNSTONIA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("johnstonia"));
		event.getRegistry().register(new BlockItem(BlockInit.CLADOPHLEBIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("cladophlebis"));
		event.getRegistry().register(new BlockItem(BlockInit.SCYTOPHYLLUM, new Item.Properties().group(PFDecoration.instance)).setRegistryName("scytophyllum"));
		event.getRegistry().register(new BlockItem(BlockInit.MICHELILLOA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("michelilloa"));
		event.getRegistry().register(new BlockItem(BlockInit.DEAD_OSMUNDACAULIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dead_osmundacaulis"));

		//Carpets
		event.getRegistry().register(new BlockItem(BlockInit.MOSS_CARPET, new Item.Properties().group(PFDecoration.instance)).setRegistryName("moss_carpet"));
		event.getRegistry().register(new BlockItem(BlockInit.ALGAE_CARPET, new Item.Properties().group(PFDecoration.instance)).setRegistryName("algae_carpet"));

		//Walls
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("sandstone_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_SANDSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("smooth_sandstone_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.SANDSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("sandstone_brick_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("siltstone_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_SILTSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("smooth_siltstone_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.SILTSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("siltstone_brick_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("chalk_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_CHALK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("smooth_chalk_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.CHALK_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("chalk_brick_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("henostone_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("henostone_brick_wall"));
		event.getRegistry().register(new BlockItem(BlockInit.DARK_HENOSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dark_henostone_brick_wall"));

		//Doors(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_door"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_door"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_door"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_door")); 		
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_door"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_door"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_door"));

		//Trapdoors(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_trapdoor"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_trapdoor"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_trapdoor"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_trapdoor"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_trapdoor"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_trapdoor"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_trapdoor"));

		//Fences(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_fence"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_fence"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_fence"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_fence"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_fence"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_fence"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_fence"));

		//Fencegates(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_fence_gate"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_fence_gate"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_fence_gate"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_fence_gate"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_fence_gate"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_fence_gate"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_fence_gate"));

		//Button(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_button"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_button"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_button"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_button"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_button"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_button"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_button"));

		//PressurePlates(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_pressure_plate"));
		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_pressure_plate"));
		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_pressure_plate"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_pressure_plate"));
		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_pressure_plate"));
		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPEROXYLON_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_pressure_plate"));
		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_pressure_plate"));

		//Ptilophyllum
		event.getRegistry().register(new BlockItem(BlockInit.PTILOPHYLLUM_WOOD, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ptilophyllum_wood"));
		event.getRegistry().register(new BlockItem(BlockInit.PTILOPHYLLUM_BASE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ptilophyllum_base"));
		
		//IDunno
		event.getRegistry().register(new BlockItem(BlockInit.MOSS_BLOCK, new Item.Properties().group(PFDecoration.instance)).setRegistryName("moss_block"));
		
		event.getRegistry().register(new BlockItem(BlockInit.PORTAL_FRAME, new Item.Properties().group(PFDecoration.instance)).setRegistryName("portal_frame"));
		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_TRAP, new Item.Properties().group(PFDecoration.instance)).setRegistryName("henostone_trap"));

		event.getRegistry().register(new BlockItem(BlockInit.PALEONTOLOGY_TABLE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("paleontology_table"));
		event.getRegistry().register(new BlockItem(BlockInit.PALEOSCRIBE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("paleoscribe"));

		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_BB, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_bb"));
		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_BF, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_bf"));
		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_TB, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_tb"));
		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_TF, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_tf"));


		//Eggs
		event.getRegistry().register(new BlockItem(BlockInit.THESCELOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("thescelosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.TRICERATOPS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("triceratops_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.ANKYLOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ankylosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.TYRANNOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tyrannosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.DAKOTARAPTOR_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dakotaraptor_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.BASILEMYS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("basilemys_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.CAMARASAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("camarasaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.DRYOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dryosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.EILENODON_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("eilenodon_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.ALLOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("allosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.STEGOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("stegosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.CERATOSAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ceratosaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.HESPERORNITHOIDES_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("hesperornithoides_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.HYPERODAPEDON_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("hyperodapedon_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.HERRERASAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("herrerasaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.CHROMOGISAURUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("chromogisaurus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.SILLOSUCHUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("sillosuchus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.SAUROSUCHUS_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("saurosuchus_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.ISCHIGUALASTIA_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ischigualastia_egg"));
		event.getRegistry().register(new BlockItem(BlockInit.EXAERETODON_EGG, new Item.Properties().group(PFDecoration.instance)).setRegistryName("exaeretodon_egg"));

		
	}

	/**
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
	 */

}
