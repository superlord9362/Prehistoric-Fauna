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
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
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
import superlord.prehistoricfauna.PrehistoricFauna.PFBook;
import superlord.prehistoricfauna.PrehistoricFauna.PFEntities;
import superlord.prehistoricfauna.PrehistoricFauna.PFFossil;
import superlord.prehistoricfauna.PrehistoricFauna.PFPlants;
import superlord.prehistoricfauna.PrehistoricFauna.PFStone;
import superlord.prehistoricfauna.PrehistoricFauna.PFWood;
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
import superlord.prehistoricfauna.block.PortalFrameBlock;
import superlord.prehistoricfauna.block.PrehistoricButtonBlock;
import superlord.prehistoricfauna.block.PrehistoricDoorBlock;
import superlord.prehistoricfauna.block.PrehistoricPlant;
import superlord.prehistoricfauna.block.PrehistoricPlantBlock;
import superlord.prehistoricfauna.block.PrehistoricPressurePlateBlock;
import superlord.prehistoricfauna.block.PrehistoricSaplingBlock;
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
import superlord.prehistoricfauna.world.feature.triassic.HeidiphyllumTree;
import superlord.prehistoricfauna.world.feature.util.PHFTreeSpawners;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.MOD)
public class BlockInit {

	public static final RegistryHelper HELPER = PrehistoricFauna.REGISTRY_HELPER;
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, PrehistoricFauna.MODID);
	
	public static final Block HORSETAIL = new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("horsetail"); //Loot Table done
	public static final Block OSMUNDA = new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("osmunda"); //Loot table done
	public static final Block DOUBLE_HORSETAIL = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("double_horsetail"); //Loot Table done
	public static final Block DOUBLE_OSMUNDA = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("double_osmunda"); //Loot Table done
	public static final Block CLUBMOSS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("clubmoss"); //Loot Table done
	public static final Block MARCHANTIA = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("marchantia"); //Loot Table done
	public static final Block MOSS = new MossBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)).setRegistryName("moss"); //Loot Table done
	public static final Block METASEQUOIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_planks"); //Loot Table done
	public static final Block METASEQUOIA_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_log"); //Loot Table done
	public static final Block METASEQUOIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("metasequoia_leaves"); //Loot Table done
	public static final Block METASEQUOIA_SAPLING = new PHFSapling(new PHFTreeSpawners.MetaSequoia(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("metasequoia_sapling"); //Loot Table done
	public static final Block METASEQUOIA_LOG_STRIPPED = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_log_stripped");//Loot Table done
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
	@SuppressWarnings("deprecation")
	public static final Block POTTED_METASEQUOIA_SAPLING = new FlowerPotBlock(METASEQUOIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_metasequoia_sapling");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_ARAUCARIA_SAPLING = new FlowerPotBlock(ARAUCARIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_araucaria_sapling");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_HORSETAIL = new FlowerPotBlock(HORSETAIL, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_horsetail"); //Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_OSMUNDA = new FlowerPotBlock(OSMUNDA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_osmunda");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_CLUBMOSS = new FlowerPotBlock(CLUBMOSS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_clubmoss"); //Loot Table done
	@SuppressWarnings("deprecation")
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
	/**	public static final Block CYPRESS_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("cypress_log");
	public static final Block CYPRESS_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("cypress_planks");
	public static final Block STRIPPED_CYPRESS_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_cypress_log");
	public static final Block CYPRESS_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("cypress_wood");
	public static final Block STRIPPED_CYPRESS_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_cypress_wood");
	public static final Block CYPRESS_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("cypress_leaves");
	public static final Block CYPRESS_STAIRS = new PrehistoricStairsBlock(CYPRESS_PLANKS.getDefaultState(), Block.Properties.from(CYPRESS_PLANKS)).setRegistryName("cypress_stairs");
	public static final Block CYPRESS_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("cypress_door");
	public static final Block CYPRESS_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("cypress_pressure_plate");
	public static final Block CYPRESS_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("cypress_fence");
	public static final Block CYPRESS_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("cypress_trapdoor");
	public static final Block CYPRESS_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("cypress_fence_gate");
	public static final Block CYPRESS_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("cypress_button");
	public static final Block CYPRESS_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("cypress_slab");
	public static final Block CYPRESS_SAPLING = new PrehistoricSaplingBlock(new CypressTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("cypress_sapling");
	@SuppressWarnings("deprecation")
	public static final Block POTTED_CYPRESS_SAPLING = new FlowerPotBlock(CYPRESS_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_cypress_sapling");
*/	public static final Block MOSS_BLOCK = new Block(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)).setRegistryName("moss_block"); //Loot Table done
	public static final Block CONIOPTERIS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("coniopteris");//Loot Table done
	public static final Block OSMUNDACAULIS = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("osmundacaulis"); //Loot Table done
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
	@SuppressWarnings("deprecation")
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
	@SuppressWarnings("deprecation")
	public static final Block POTTED_ZAMITES_SAPLING = new FlowerPotBlock(ZAMITES_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_zamites_sapling");//Loot Table done
	public static final Block PROTOJUNIPER_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("protojuniper_log");//Loot Table done
	public static final Block PROTOJUNIPER_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniper_planks");//Loot Table done
	public static final Block STRIPPED_PROTOJUNIPER_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_protojuniper_log");//Loot Table done
	public static final Block PROTOJUNIPER_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("protojuniper_wood");//Loot Table done
	public static final Block STRIPPED_PROTOJUNIPER_WOOD = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("stripped_protojuniper_wood");//Loot Table done
	public static final Block PROTOJUNIPER_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("protojuniper_leaves");//Loot Table done
	public static final Block PROTOJUNIPER_STAIRS = new PrehistoricStairsBlock(PROTOJUNIPER_PLANKS.getDefaultState(), Block.Properties.from(PROTOJUNIPER_PLANKS)).setRegistryName("protojuniper_stairs");//Loot Table done
	public static final Block PROTOJUNIPER_DOOR = new PrehistoricDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protojuniper_door");//Loot Table done
	public static final Block PROTOJUNIPER_PRESSURE_PLATE = new PrehistoricPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protojuniper_pressure_plate");//Loot Table done
	public static final Block PROTOJUNIPER_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniper_fence");//Loot Table done
	public static final Block PROTOJUNIPER_TRAPDOOR = new PrehistoricTrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protojuniper_trapdoor");//Loot Table done
	public static final Block PROTOJUNIPER_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniper_fence_gate");//Loot Table done
	public static final Block PROTOJUNIPER_BUTTON = new PrehistoricButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protojuniper_button");//Loot Table done
	public static final Block PROTOJUNIPER_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniper_slab");//Loot Table done
	public static final Block PROTOJUNIPER_SAPLING = new PHFSapling(new PHFTreeSpawners.ProtoJuniper(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("protojuniper_sapling");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_PROTOJUNIPER_SAPLING = new FlowerPotBlock(PROTOJUNIPER_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_protojuniper_sapling");//Loot Table done
	public static final Block DICROIDIUM = new DicroidiumBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("dicroidium");//Loot Table done
	public static final Block JOHNSTONIA = new JohnstoniaBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("johnstonia");//Loot Table done
	public static final Block SCYTOPHYLLUM = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("scytophyllum");//Loot Table done
	public static final Block CLADOPHLEBIS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("cladophlebis");//Loot Table done
	public static final Block MICHELILLOA = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("michelilloa");
	@SuppressWarnings("deprecation")
	public static final Block POTTED_CLADOPHLEBIS = new FlowerPotBlock(CLADOPHLEBIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_cladophlebis");//Loot Table done
	@SuppressWarnings("deprecation")
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
	public static final Block HEIDIPHYLLUM_SAPLING = new PrehistoricSaplingBlock(new HeidiphyllumTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("heidiphyllum_sapling");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_HEIDIPHYLLUM_SAPLING = new FlowerPotBlock(HEIDIPHYLLUM_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_heidiphyllum_sapling");//Loot Table done
	public static final Block SHORT_OSMUNDACAULIS = new ShortOsmundacaulisBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("short_osmundacaulis"); //Loot Table done
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
	@SuppressWarnings("deprecation")
	public static final Block POTTED_LIRIODENDRITES_SAPLING = new FlowerPotBlock(LIRIODENDRITES_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_liriodendrites_sapling");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("triassic_sandstone");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("triassic_sandstone_fossil");//Loot Table done
	public static final Block SMOOTH_TRIASSIC_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_triassic_sandstone");//Loot Table done
	public static final Block POLISHED_TRIASSIC_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_triassic_sandstone");//Loot Table done
	public static final Block POLISHED_TRIASSIC_SANDSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_triassic_sandstone_bricks");//Loot Table done
	public static final Block CHISELED_POLISHED_TRIASSIC_SANDSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_polished_triassic_sandstone");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_WALL = new WallBlock(Block.Properties.from(TRIASSIC_SANDSTONE)).setRegistryName("triassic_sandstone_wall");//Loot Table done
	public static final Block SMOOTH_TRIASSIC_SANDSTONE_WALL = new WallBlock(Block.Properties.from(SMOOTH_TRIASSIC_SANDSTONE)).setRegistryName("smooth_triassic_sandstone_wall");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_BRICK_WALL = new WallBlock(Block.Properties.from(POLISHED_TRIASSIC_SANDSTONE_BRICKS)).setRegistryName("triassic_sandstone_brick_wall");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_STAIRS = new PrehistoricStairsBlock(TRIASSIC_SANDSTONE.getDefaultState(), Block.Properties.from(TRIASSIC_SANDSTONE)).setRegistryName("triassic_sandstone_stairs");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("triassic_sandstone_slab");//Loot Table done
	public static final Block POLISHED_TRIASSIC_SANDSTONE_STAIRS = new PrehistoricStairsBlock(POLISHED_TRIASSIC_SANDSTONE.getDefaultState(), Block.Properties.from(POLISHED_TRIASSIC_SANDSTONE)).setRegistryName("polished_triassic_sandstone_stairs");//Loot Table done
	public static final Block POLISHED_TRIASSIC_SANDSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_triassic_sandstone_slab");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(POLISHED_TRIASSIC_SANDSTONE_BRICKS.getDefaultState(), Block.Properties.from(POLISHED_TRIASSIC_SANDSTONE_BRICKS)).setRegistryName("triassic_sandstone_brick_stairs");//Loot Table done
	public static final Block TRIASSIC_SANDSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("triassic_sandstone_brick_slab");//Loot Table done
	public static final Block JURASSIC_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("jurassic_siltstone");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("jurassic_siltstone_fossil");//Loot Table done
	public static final Block SMOOTH_JURASSIC_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_jurassic_siltstone");//Loot Table done
	public static final Block POLISHED_JURASSIC_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_jurassic_siltstone");//Loot Table done
	public static final Block POLISHED_JURASSIC_SILTSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_jurassic_siltstone_bricks");//Loot Table done
	public static final Block CHISELED_POLISHED_JURASSIC_SILTSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_polished_jurassic_siltstone");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_WALL = new WallBlock(Block.Properties.from(JURASSIC_SILTSTONE)).setRegistryName("jurassic_siltstone_wall");//Loot Table done
	public static final Block SMOOTH_JURASSIC_SILTSTONE_WALL = new WallBlock(Block.Properties.from(SMOOTH_JURASSIC_SILTSTONE)).setRegistryName("smooth_jurassic_siltstone_wall");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_BRICK_WALL = new WallBlock(Block.Properties.from(POLISHED_JURASSIC_SILTSTONE_BRICKS)).setRegistryName("jurassic_siltstone_brick_wall");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_STAIRS = new PrehistoricStairsBlock(JURASSIC_SILTSTONE.getDefaultState(), Block.Properties.from(JURASSIC_SILTSTONE)).setRegistryName("jurassic_siltstone_stairs");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("jurassic_siltstone_slab");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("jurassic_siltstone_brick_slab");//Loot Table done
	public static final Block JURASSIC_SILTSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(POLISHED_JURASSIC_SILTSTONE_BRICKS.getDefaultState(), Block.Properties.from(POLISHED_JURASSIC_SILTSTONE_BRICKS)).setRegistryName("jurassic_siltstone_brick_stairs");//Loot Table done
	public static final Block POLISHED_JURASSIC_SILTSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_jurassic_siltstone_slab");//Loot Table done
	public static final Block POLISHED_JURASSIC_SILTSTONE_STAIRS = new PrehistoricStairsBlock(POLISHED_JURASSIC_SILTSTONE.getDefaultState(), Block.Properties.from(POLISHED_JURASSIC_SILTSTONE)).setRegistryName("polished_jurassic_siltstone_stairs");//Loot Table done
	public static final Block CRETACEOUS_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("cretaceous_chalk");//Loot Table done
	public static final Block CRETACEOUS_CHALK_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("cretaceous_chalk_fossil");//Loot Table done
	public static final Block SMOOTH_CRETACEOUS_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_cretaceous_chalk");//Loot Table done
	public static final Block POLISHED_CRETACEOUS_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_cretaceous_chalk");//Loot Table done
	public static final Block POLISHED_CRETACEOUS_CHALK_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_cretaceous_chalk_bricks");//Loot Table done
	public static final Block CHISELED_POLISHED_CRETACEOUS_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_polished_cretaceous_chalk");//Loot Table done
	public static final Block CRETACEOUS_CHALK_WALL = new WallBlock(Block.Properties.from(CRETACEOUS_CHALK)).setRegistryName("cretaceous_chalk_wall");//Loot Table done
	public static final Block SMOOTH_CRETACEOUS_CHALK_WALL = new WallBlock(Block.Properties.from(SMOOTH_CRETACEOUS_CHALK)).setRegistryName("smooth_cretaceous_chalk_wall");//Loot Table done
	public static final Block CRETACEOUS_CHALK_BRICK_WALL = new WallBlock(Block.Properties.from(POLISHED_CRETACEOUS_CHALK_BRICKS)).setRegistryName("cretaceous_chalk_brick_wall");//Loot Table done
	public static final Block CRETACEOUS_CHALK_STAIRS = new PrehistoricStairsBlock(CRETACEOUS_CHALK.getDefaultState(), Block.Properties.from(CRETACEOUS_CHALK)).setRegistryName("cretaceous_chalk_stairs");//Loot Table done
	public static final Block CRETACEOUS_CHALK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("cretaceous_chalk_slab");//Loot Table done
	public static final Block CRETACEOUS_CHALK_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("cretaceous_chalk_brick_slab");//Loot Table done
	public static final Block CRETACEOUS_CHALK_BRICK_STAIRS = new PrehistoricStairsBlock(POLISHED_CRETACEOUS_CHALK_BRICKS.getDefaultState(), Block.Properties.from(POLISHED_CRETACEOUS_CHALK_BRICKS)).setRegistryName("cretaceous_chalk_brick_stairs");//Loot Table done
	public static final Block POLISHED_CRETACEOUS_CHALK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_cretaceous_chalk_slab");//Loot Table done
	public static final Block POLISHED_CRETACEOUS_CHALK_STAIRS = new PrehistoricStairsBlock(POLISHED_CRETACEOUS_CHALK.getDefaultState(), Block.Properties.from(POLISHED_CRETACEOUS_CHALK)).setRegistryName("polished_cretaceous_chalk_stairs");//Loot Table done
	public static final Block SILLOSUCHUS_EGG = new SillosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("sillosuchus_egg");//Loot Table done
	public static final Block PORTAL_FRAME = new PortalFrameBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).lightValue(9)).setRegistryName("portal_frame");//Loot Table done
	public static final Block CRETACEOUS_TIME_BLOCK = new CretaceousTimeBlock();//Loot Table done
	public static final Block JURASSIC_TIME_BLOCK = new JurassicTimeBlock();//Loot Table done
	public static final Block TRIASSIC_TIME_BLOCK = new TriassicTimeBlock();//Loot Table done
	public static final Block CRASSOSTREA_BLOCK = new CrassostreaOysterBlock(Block.Properties.create(Material.CORAL).doesNotBlockMovement().hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.STONE).harvestLevel(0)).setRegistryName("crassostrea_oysters");
	//public static final Block DIDELPHODON_BURROW = new DidelphodonBurrowBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.GROUND)).setRegistryName("didelphodon_burrow");
	public static final Block HENOSTONE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone");
	public static final Block HENOSTONE_CARVED = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_carved");
	public static final Block HENOSTONE_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_bricks");
	public static final Block HENOSTONE_BRICKS_DARK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_bricks_dark");
	public static final Block HENOSTONE_PILLAR = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_pillar");
	public static final Block HENOSTONE_PILLAR_CHISELED = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_pillar_chiseled");
	public static final Block HENOSTONE_STAIRS = new PrehistoricStairsBlock(HENOSTONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_stairs");
	public static final Block HENOSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_slab");
	public static final Block HENOSTONE_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_wall");
	public static final Block HENOSTONE_BRICK_STAIRS = new PrehistoricStairsBlock(HENOSTONE_BRICKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_stairs");
	public static final Block HENOSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_slab");
	public static final Block HENOSTONE_BRICK_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_wall");
	public static final Block HENOSTONE_DARK_BRICK_STAIRS = new PrehistoricStairsBlock(HENOSTONE_BRICKS_DARK.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_dark_brick_stairs");
	public static final Block HENOSTONE_DARK_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_dark_brick_slab");
	public static final Block HENOSTONE_DARK_BRICK_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_dark_brick_wall");
	public static final Block HENOSTONE_TRAP = new TrapBlock(TrapBlock.Sensitivity.MOBS, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_trap");
	public static final Block LARGE_AMMONITE_SHELL = new AmmoniteLargeShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("large_shell");
	public static final Block MEDIUM_AMMONITE_SHELL = new AmmoniteMediumShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("medium_shell");
	public static final Block SMALL_AMMONITE_SHELL = new AmmoniteSmallShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("small_shell");
	public static final Block GIANT_AMMONITE_SHELL_BF = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_shell_bf");
	public static final Block GIANT_AMMONITE_SHELL_BB = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_shell_bb");
	public static final Block GIANT_AMMONITE_SHELL_TF = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_shell_tf");
	public static final Block GIANT_AMMONITE_SHELL_TB = new AmmoniteGiantShellBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("giant_shell_tb");
	public static final Block AMMONITE_BLOCK = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("ammonite_block");
	public static final Block PETRIFIED_WOOD = new LogBlock(MaterialColor.PINK, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("petrified_wood");
	public static final Block POLISHED_PETRIFIED_WOOD = new LogBlock(MaterialColor.PINK, Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_petrified_wood");
	public static final Block SAUROSUCHUS_EGG = new SaurosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("saurosuchus_egg");//Loot Table done
	public static final Block ISCHIGUALASTIA_EGG = new IschigualastiaEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("ischigualastia_egg");
	public static final Block EXAERETODON_EGG = new ExaeretodonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("exaeretodon_egg");//Loot Table done
	public static final Block PALEONTOLOGY_TABLE = new PaleontologyTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)).setRegistryName("paleontology_table");
	public static final Block ALGAE = new AlgaeBlock(Block.Properties.create(Material.OCEAN_PLANT).hardnessAndResistance(0.2F).sound(SoundType.SLIME).notSolid()).setRegistryName("algae_carpet");
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
	public static final Block PROTOJUNIPER_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON).setRegistryName("protojuniperoxylon_sign");
	public static final Block PROTOJUNIPER_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.PROTOJUNIPEROXYLON).setRegistryName("protojuniperoxylon_wall_sign");
	public static final Block PALEOSCRIBE = new PaleoscribeBlock(Block.Properties.create(Material.WOOD).variableOpacity().hardnessAndResistance(2.0F, 5.0F).sound(SoundType.WOOD)).setRegistryName("paleoscribe");
	@SuppressWarnings("deprecation")
	public static final Block POTTED_DEAD_OSMUNDACAULIS = new FlowerPotBlock(DEAD_OSMUNDACAULIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_dead_osmundacaulis");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_SHORT_OSMUNDACAULIS = new FlowerPotBlock(SHORT_OSMUNDACAULIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_short_osmundacaulis");//Loot Table done
	@SuppressWarnings("deprecation")
	public static final Block POTTED_CONIOPTERIS = new FlowerPotBlock(CONIOPTERIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_coniopteris");//Loot Table done
	public static final Block SILT = new SandBlock(0x8C603C, Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)).setRegistryName("silt");
	public static final Block HARDENED_SILT = new Block(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)).setRegistryName("hardened_silt");
	
	public static final RegistryObject<TriassicPortalBlock> TRIASSIC_PORTAL = BLOCKS.register("triassic_portal", () -> new TriassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));
	public static final RegistryObject<JurassicPortalBlock> JURASSIC_PORTAL = BLOCKS.register("jurassic_portal", () -> new JurassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));
	public static final RegistryObject<CretaceousPortalBlock> CRETACEOUS_PORTAL = BLOCKS.register("cretaceous_portal", () -> new CretaceousPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11).noDrops()));

	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "metasequoia_vertical_slab", () -> new VerticalSlabBlock(Properties.from(METASEQUOIA_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "araucaria_vertical_slab", () -> new VerticalSlabBlock(Properties.from(ARAUCARIA_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "liriodendrites_vertical_slab", () -> new VerticalSlabBlock(Properties.from(LIRIODENDRITES_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_slab", () -> new VerticalSlabBlock(Properties.from(PROTOPICEOXYLON_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "zamites_vertical_slab", () -> new VerticalSlabBlock(Properties.from(ZAMITES_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_slab", () -> new VerticalSlabBlock(Properties.from(PROTOJUNIPER_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HEIDIPHYLLUM_SLAB)), PFWood.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "triassic_sandstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(TRIASSIC_SANDSTONE_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> POLISHED_TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_triassic_sandstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_TRIASSIC_SANDSTONE_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "triassic_sandstone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(TRIASSIC_SANDSTONE_BRICK_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "jurassic_siltstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(JURASSIC_SILTSTONE_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> POLISHED_JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_jurassic_siltstone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_JURASSIC_SILTSTONE_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "jurassic_siltstone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(JURASSIC_SILTSTONE_BRICK_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "cretaceous_chalk_vertical_slab", () -> new VerticalSlabBlock(Properties.from(CRETACEOUS_CHALK_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> POLISHED_CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_cretaceous_chalk_vertical_slab", () -> new VerticalSlabBlock(Properties.from(POLISHED_CRETACEOUS_CHALK_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "cretaceous_chalk_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(CRETACEOUS_CHALK_BRICK_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> HENOSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> HENOSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_BRICK_SLAB)), PFStone.instance);
	public static final RegistryObject<Block> HENOSTONE_DARK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_dark_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.from(HENOSTONE_DARK_BRICK_SLAB)), PFStone.instance);

	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "metasequoia_vertical_planks", () -> new Block(Properties.from(METASEQUOIA_PLANKS)), PFWood.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "araucaria_vertical_planks", () -> new Block(Properties.from(ARAUCARIA_PLANKS)), PFWood.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "liriodendrites_vertical_planks", () -> new Block(Properties.from(LIRIODENDRITES_PLANKS)), PFWood.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_planks", () -> new Block(Properties.from(PROTOPICEOXYLON_PLANKS)), PFWood.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "zamites_vertical_planks", () -> new Block(Properties.from(ZAMITES_PLANKS)), PFWood.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_planks", () -> new Block(Properties.from(PROTOJUNIPER_PLANKS)), PFWood.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_planks", () -> new Block(Properties.from(HEIDIPHYLLUM_PLANKS)), PFWood.instance);

	public static final RegistryObject<Block> METASEQUOIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "metasequoia_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFPlants.instance);
	public static final RegistryObject<Block> ARAUCARIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "araucaria_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFPlants.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LEAF_CARPET = HELPER.createCompatBlock("quark", "liriodendrites_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFPlants.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protopiceoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFPlants.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protojuniperoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFPlants.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LEAF_CARPET = HELPER.createCompatBlock("quark", "heidiphyllum_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFPlants.instance);
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(HORSETAIL);
		event.getRegistry().register(OSMUNDA);
		event.getRegistry().register(DOUBLE_HORSETAIL);
		event.getRegistry().register(DOUBLE_OSMUNDA);
		event.getRegistry().register(CLUBMOSS);
		event.getRegistry().register(MARCHANTIA);
		event.getRegistry().register(MOSS);
		event.getRegistry().register(METASEQUOIA_LEAVES);
		event.getRegistry().register(METASEQUOIA_LOG);
		event.getRegistry().register(METASEQUOIA_PLANKS);
		event.getRegistry().register(METASEQUOIA_SAPLING);
		event.getRegistry().register(METASEQUOIA_LOG_STRIPPED);
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
		/**event.getRegistry().register(CYPRESS_LOG);
		event.getRegistry().register(CYPRESS_BUTTON);
		event.getRegistry().register(CYPRESS_DOOR);
		event.getRegistry().register(CYPRESS_FENCE);
		event.getRegistry().register(CYPRESS_FENCE_GATE);
		event.getRegistry().register(CYPRESS_LEAVES);
		event.getRegistry().register(CYPRESS_PLANKS);
		event.getRegistry().register(CYPRESS_PRESSURE_PLATE);
		event.getRegistry().register(CYPRESS_SAPLING);
		event.getRegistry().register(CYPRESS_SLAB);
		event.getRegistry().register(CYPRESS_STAIRS);
		event.getRegistry().register(CYPRESS_TRAPDOOR);
		event.getRegistry().register(CYPRESS_WOOD);
		event.getRegistry().register(STRIPPED_CYPRESS_LOG);
		event.getRegistry().register(STRIPPED_CYPRESS_WOOD);
		event.getRegistry().register(POTTED_CYPRESS_SAPLING);
		*/event.getRegistry().register(MOSS_BLOCK);
		event.getRegistry().register(CONIOPTERIS);
		event.getRegistry().register(OSMUNDACAULIS);
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
		event.getRegistry().register(PROTOJUNIPER_LOG);
		event.getRegistry().register(PROTOJUNIPER_BUTTON);
		event.getRegistry().register(PROTOJUNIPER_DOOR);
		event.getRegistry().register(PROTOJUNIPER_FENCE);
		event.getRegistry().register(PROTOJUNIPER_FENCE_GATE);
		event.getRegistry().register(PROTOJUNIPER_PLANKS);
		event.getRegistry().register(PROTOJUNIPER_PRESSURE_PLATE);
		event.getRegistry().register(PROTOJUNIPER_SLAB);
		event.getRegistry().register(PROTOJUNIPER_STAIRS);
		event.getRegistry().register(PROTOJUNIPER_TRAPDOOR);
		event.getRegistry().register(PROTOJUNIPER_WOOD);
		event.getRegistry().register(STRIPPED_PROTOJUNIPER_LOG);
		event.getRegistry().register(STRIPPED_PROTOJUNIPER_WOOD);
		event.getRegistry().register(PROTOJUNIPER_LEAVES);
		event.getRegistry().register(PROTOJUNIPER_SAPLING);
		event.getRegistry().register(POTTED_PROTOJUNIPER_SAPLING);
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
		event.getRegistry().register(SHORT_OSMUNDACAULIS);
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
		event.getRegistry().register(TRIASSIC_SANDSTONE);
		event.getRegistry().register(TRIASSIC_SANDSTONE_FOSSIL);
		event.getRegistry().register(POLISHED_TRIASSIC_SANDSTONE);
		event.getRegistry().register(SMOOTH_TRIASSIC_SANDSTONE);
		event.getRegistry().register(POLISHED_TRIASSIC_SANDSTONE_BRICKS);
		event.getRegistry().register(CHISELED_POLISHED_TRIASSIC_SANDSTONE);
		event.getRegistry().register(TRIASSIC_SANDSTONE_SLAB);
		event.getRegistry().register(TRIASSIC_SANDSTONE_STAIRS);
		event.getRegistry().register(TRIASSIC_SANDSTONE_WALL);
		event.getRegistry().register(SMOOTH_TRIASSIC_SANDSTONE_WALL);
		event.getRegistry().register(TRIASSIC_SANDSTONE_BRICK_WALL);
		event.getRegistry().register(TRIASSIC_SANDSTONE_BRICK_SLAB);
		event.getRegistry().register(TRIASSIC_SANDSTONE_BRICK_STAIRS);
		event.getRegistry().register(POLISHED_TRIASSIC_SANDSTONE_SLAB);
		event.getRegistry().register(POLISHED_TRIASSIC_SANDSTONE_STAIRS);
		event.getRegistry().register(JURASSIC_SILTSTONE);
		event.getRegistry().register(JURASSIC_SILTSTONE_FOSSIL);
		event.getRegistry().register(POLISHED_JURASSIC_SILTSTONE);
		event.getRegistry().register(SMOOTH_JURASSIC_SILTSTONE);
		event.getRegistry().register(POLISHED_JURASSIC_SILTSTONE_BRICKS);
		event.getRegistry().register(CHISELED_POLISHED_JURASSIC_SILTSTONE);
		event.getRegistry().register(JURASSIC_SILTSTONE_SLAB);
		event.getRegistry().register(JURASSIC_SILTSTONE_WALL);
		event.getRegistry().register(SMOOTH_JURASSIC_SILTSTONE_WALL);
		event.getRegistry().register(JURASSIC_SILTSTONE_BRICK_WALL);
		event.getRegistry().register(JURASSIC_SILTSTONE_STAIRS);
		event.getRegistry().register(JURASSIC_SILTSTONE_BRICK_STAIRS);
		event.getRegistry().register(JURASSIC_SILTSTONE_BRICK_SLAB);
		event.getRegistry().register(POLISHED_JURASSIC_SILTSTONE_SLAB);
		event.getRegistry().register(POLISHED_JURASSIC_SILTSTONE_STAIRS);
		event.getRegistry().register(CRETACEOUS_CHALK);
		event.getRegistry().register(CRETACEOUS_CHALK_FOSSIL);
		event.getRegistry().register(POLISHED_CRETACEOUS_CHALK);
		event.getRegistry().register(SMOOTH_CRETACEOUS_CHALK);
		event.getRegistry().register(POLISHED_CRETACEOUS_CHALK_BRICKS);
		event.getRegistry().register(CHISELED_POLISHED_CRETACEOUS_CHALK);
		event.getRegistry().register(CRETACEOUS_CHALK_SLAB);
		event.getRegistry().register(CRETACEOUS_CHALK_WALL);
		event.getRegistry().register(SMOOTH_CRETACEOUS_CHALK_WALL);
		event.getRegistry().register(CRETACEOUS_CHALK_BRICK_WALL);
		event.getRegistry().register(CRETACEOUS_CHALK_STAIRS);
		event.getRegistry().register(CRETACEOUS_CHALK_BRICK_STAIRS);
		event.getRegistry().register(CRETACEOUS_CHALK_BRICK_SLAB);
		event.getRegistry().register(POLISHED_CRETACEOUS_CHALK_SLAB);
		event.getRegistry().register(POLISHED_CRETACEOUS_CHALK_STAIRS);
		event.getRegistry().register(SILLOSUCHUS_EGG);
		event.getRegistry().register(PORTAL_FRAME);
		event.getRegistry().register(CRETACEOUS_TIME_BLOCK);
		event.getRegistry().register(JURASSIC_TIME_BLOCK);
		event.getRegistry().register(TRIASSIC_TIME_BLOCK);
		event.getRegistry().register(CRASSOSTREA_BLOCK);
		//event.getRegistry().register(DIDELPHODON_BURROW);
		event.getRegistry().register(HENOSTONE);
		event.getRegistry().register(HENOSTONE_CARVED);
		event.getRegistry().register(HENOSTONE_BRICKS);
		event.getRegistry().register(HENOSTONE_BRICKS_DARK);
		event.getRegistry().register(HENOSTONE_PILLAR);
		event.getRegistry().register(HENOSTONE_PILLAR_CHISELED);
		event.getRegistry().register(HENOSTONE_SLAB);
		event.getRegistry().register(HENOSTONE_STAIRS);
		event.getRegistry().register(HENOSTONE_WALL);
		event.getRegistry().register(HENOSTONE_BRICK_SLAB);
		event.getRegistry().register(HENOSTONE_BRICK_STAIRS);
		event.getRegistry().register(HENOSTONE_BRICK_WALL);
		event.getRegistry().register(HENOSTONE_DARK_BRICK_SLAB);
		event.getRegistry().register(HENOSTONE_DARK_BRICK_STAIRS);
		event.getRegistry().register(HENOSTONE_DARK_BRICK_WALL);
		event.getRegistry().register(HENOSTONE_TRAP);
		event.getRegistry().register(LARGE_AMMONITE_SHELL);
		event.getRegistry().register(MEDIUM_AMMONITE_SHELL);
		event.getRegistry().register(SMALL_AMMONITE_SHELL);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_BB);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_BF);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_TB);
		event.getRegistry().register(GIANT_AMMONITE_SHELL_TF);
		event.getRegistry().register(AMMONITE_BLOCK);
		event.getRegistry().register(PETRIFIED_WOOD);
		event.getRegistry().register(POLISHED_PETRIFIED_WOOD);
		event.getRegistry().register(SAUROSUCHUS_EGG);
		event.getRegistry().register(ISCHIGUALASTIA_EGG);
		event.getRegistry().register(EXAERETODON_EGG);
		event.getRegistry().register(PALEONTOLOGY_TABLE);
		event.getRegistry().register(ALGAE);
		event.getRegistry().register(ARAUCARIA_SIGN);
		event.getRegistry().register(ARAUCARIA_WALL_SIGN);
		event.getRegistry().register(METASEQUOIA_SIGN);
		event.getRegistry().register(METASEQUOIA_WALL_SIGN);
		event.getRegistry().register(HEIDIPHYLLUM_SIGN);
		event.getRegistry().register(HEIDIPHYLLUM_WALL_SIGN);
		event.getRegistry().register(LIRIODENDRITES_SIGN);
		event.getRegistry().register(LIRIODENDRITES_WALL_SIGN);
		event.getRegistry().register(PROTOJUNIPER_SIGN);
		event.getRegistry().register(PROTOJUNIPER_WALL_SIGN);
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
			RenderTypeLookup.setRenderLayer(DOUBLE_HORSETAIL, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(DOUBLE_OSMUNDA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(OSMUNDACAULIS, cutoutRenderType);
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
			RenderTypeLookup.setRenderLayer(PROTOJUNIPER_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PROTOJUNIPER_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPER_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPER_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPER_TRAPDOOR, cutoutRenderType);
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
			RenderTypeLookup.setRenderLayer(SHORT_OSMUNDACAULIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(DEAD_OSMUNDACAULIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_LIRIODENDRITES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CRASSOSTREA_BLOCK, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(CRETACEOUS_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(CRETACEOUS_TIME_BLOCK, translucentRenderType);
			RenderTypeLookup.setRenderLayer(JURASSIC_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(JURASSIC_TIME_BLOCK, translucentRenderType);
			RenderTypeLookup.setRenderLayer(TRIASSIC_PORTAL.get(), translucentRenderType);
			RenderTypeLookup.setRenderLayer(TRIASSIC_TIME_BLOCK, translucentRenderType);
			RenderTypeLookup.setRenderLayer(HENOSTONE_TRAP, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ALGAE, mippedRenderType);
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
			RenderTypeLookup.setRenderLayer(PROTOJUNIPER_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPER_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_WALL_SIGN, cutoutRenderType);
		}
	}
	
	@SubscribeEvent
 	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		//Log, Stripped Log, Wood, Stripped Wood, Planks, Stairs, Slab, Fence, Fence Gate, Trapdoor, Door, Button, Pressure Plate
 		event.getRegistry().register(new BlockItem(BlockInit.HORSETAIL, new Item.Properties().group(PFPlants.instance)).setRegistryName("horsetail"));
 		event.getRegistry().register(new BlockItem(BlockInit.OSMUNDA, new Item.Properties().group(PFPlants.instance)).setRegistryName("osmunda"));
 		event.getRegistry().register(new BlockItem(BlockInit.DOUBLE_HORSETAIL, new Item.Properties().group(PFPlants.instance)).setRegistryName("double_horsetail"));
 		event.getRegistry().register(new BlockItem(BlockInit.DOUBLE_OSMUNDA, new Item.Properties().group(PFPlants.instance)).setRegistryName("double_osmunda"));
 		event.getRegistry().register(new BlockItem(BlockInit.CLUBMOSS, new Item.Properties().group(PFPlants.instance)).setRegistryName("clubmoss"));
 		event.getRegistry().register(new BlockItem(BlockInit.MARCHANTIA, new Item.Properties().group(PFPlants.instance)).setRegistryName("marchantia"));
 		event.getRegistry().register(new BlockItem(BlockInit.MOSS, new Item.Properties().group(PFPlants.instance)).setRegistryName("moss"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("metasequoia_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_LOG_STRIPPED, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_log_stripped"));
		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_METASEQUOIA_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_metasequoia_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_door"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("metasequoia_sapling"));
  		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.METASEQUOIA_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("metasequoia_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_METASEQUOIA_SAPLING, new Item.Properties()).setRegistryName("potted_metasequoia_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("araucaria_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ARAUCARIA_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_araucaria_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ARAUCARIA_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_araucaria_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_door"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("araucaria_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.ARAUCARIA_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("araucaria_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_ARAUCARIA_SAPLING, new Item.Properties()).setRegistryName("potted_araucaria_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_LIRIODENDRITES_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_liriodendrites_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_LIRIODENDRITES_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_liriodendrites_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_door"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("liriodendrites_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("liriodendrites_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_LIRIODENDRITES_SAPLING, new Item.Properties()).setRegistryName("potted_liriodendrites_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.LIRIODENDRITES_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("liriodendrites_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_CLUBMOSS, new Item.Properties()).setRegistryName("potted_clubmoss"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_HORSETAIL, new Item.Properties()).setRegistryName("potted_horsetail"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_MARCHANTIA, new Item.Properties()).setRegistryName("potted_marchantia"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_OSMUNDA, new Item.Properties()).setRegistryName("potted_osmunda"));
 		event.getRegistry().register(new BlockItem(BlockInit.MOSSY_DIRT, new Item.Properties().group(PFPlants.instance)).setRegistryName("mossy_dirt"));
 		event.getRegistry().register(new BlockItem(BlockInit.THESCELOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("thescelosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRICERATOPS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("triceratops_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.ANKYLOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("ankylosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.TYRANNOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("tyrannosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.DAKOTARAPTOR_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("dakotaraptor_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.BASILEMYS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("basilemys_egg"));
 		/**event.getRegistry().register(new BlockItem(CYPRESS_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("cypress_leaves"));
 		event.getRegistry().register(new BlockItem(CYPRESS_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_log"));
 		event.getRegistry().register(new BlockItem(CYPRESS_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_planks"));
 		event.getRegistry().register(new BlockItem(CYPRESS_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("cypress_sapling"));
 		event.getRegistry().register(new BlockItem(STRIPPED_CYPRESS_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_cypress_log"));
 		event.getRegistry().register(new BlockItem(CYPRESS_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_wood"));
 		event.getRegistry().register(new BlockItem(STRIPPED_CYPRESS_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_cypress_wood"));
 		event.getRegistry().register(new BlockItem(CYPRESS_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_button"));
 		event.getRegistry().register(new BlockItem(CYPRESS_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_door"));
 		event.getRegistry().register(new BlockItem(CYPRESS_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_fence"));
 		event.getRegistry().register(new BlockItem(CYPRESS_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_fence_gate"));
 		event.getRegistry().register(new BlockItem(CYPRESS_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_pressure_plate"));
 		event.getRegistry().register(new BlockItem(CYPRESS_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_slab"));
 		event.getRegistry().register(new BlockItem(CYPRESS_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_stairs"));
 		event.getRegistry().register(new BlockItem(CYPRESS_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("cypress_trapdoor"));
 		event.getRegistry().register(new BlockItem(POTTED_CYPRESS_SAPLING, new Item.Properties()).setRegistryName("potted_cypress_sapling"));
 		*/event.getRegistry().register(new BlockItem(BlockInit.MOSS_BLOCK, new Item.Properties().group(PFPlants.instance)).setRegistryName("moss_block"));
 		event.getRegistry().register(new BlockItem(BlockInit.CONIOPTERIS, new Item.Properties().group(PFPlants.instance)).setRegistryName("coniopteris"));
 		event.getRegistry().register(new BlockItem(BlockInit.OSMUNDACAULIS, new Item.Properties().group(PFPlants.instance)).setRegistryName("osmundacaulis"));
 		event.getRegistry().register(new BlockItem(BlockInit.LOAM, new Item.Properties().group(PFPlants.instance)).setRegistryName("loam"));
 		event.getRegistry().register(new BlockItem(BlockInit.PACKED_LOAM, new Item.Properties().group(PFPlants.instance)).setRegistryName("packed_loam"));
 		event.getRegistry().register(new BlockItem(BlockInit.PTILOPHYLLUM_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("ptilophyllum_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.PTILOPHYLLUM_BASE, new Item.Properties().group(PFWood.instance)).setRegistryName("ptilophyllum_base"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("protopiceoxylon_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOPICEOXYLON_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_protopiceoxylon_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOPICEOXYLON_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_protopiceoxylon_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_door")); 		
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("protopiceoxylon_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOPICEOXYLON_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("protopiceoxylon_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_PROTOPICEOXYLON_SAPLING, new Item.Properties()).setRegistryName("potted_protopiceoxylon_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ZAMITES_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_zamites_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_ZAMITES_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_zamites_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_door"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("zamites_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.CAMARASAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("camarasaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("zamites_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_ZAMITES_SAPLING, new Item.Properties()).setRegistryName("potted_zamites_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.ZAMITES_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("zamites_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOJUNIPER_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_protojuniper_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_PROTOJUNIPER_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_protojuniper_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_door"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("protojuniper_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("protojuniper_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_PROTOJUNIPER_SAPLING, new Item.Properties()).setRegistryName("potted_protojuniper_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.PROTOJUNIPER_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("protojuniper_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.DICROIDIUM, new Item.Properties().group(PFPlants.instance)).setRegistryName("dicroidium"));
 		event.getRegistry().register(new BlockItem(BlockInit.JOHNSTONIA, new Item.Properties().group(PFPlants.instance)).setRegistryName("johnstonia"));
 		event.getRegistry().register(new BlockItem(BlockInit.CLADOPHLEBIS, new Item.Properties().group(PFPlants.instance)).setRegistryName("cladophlebis"));
 		event.getRegistry().register(new BlockItem(BlockInit.SCYTOPHYLLUM, new Item.Properties().group(PFPlants.instance)).setRegistryName("scytophyllum"));
 		event.getRegistry().register(new BlockItem(BlockInit.MICHELILLOA, new Item.Properties().group(PFPlants.instance)).setRegistryName("michelilloa"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_HEIDIPHYLLUM_LOG, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_heidiphyllum_log"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.STRIPPED_HEIDIPHYLLUM_WOOD, new Item.Properties().group(PFWood.instance)).setRegistryName("stripped_heidiphyllum_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_PLANKS, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_planks"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_STAIRS, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_SLAB, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_FENCE, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_fence"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_FENCE_GATE, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_fence_gate"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_TRAPDOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_trapdoor"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_DOOR, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_door"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_LEAVES, new Item.Properties().group(PFPlants.instance)).setRegistryName("heidiphyllum_leaves"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_SAPLING, new Item.Properties().group(PFPlants.instance)).setRegistryName("heidiphyllum_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.POTTED_HEIDIPHYLLUM_SAPLING, new Item.Properties()).setRegistryName("potted_heidiphyllum_sapling"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_BUTTON, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_button"));
 		event.getRegistry().register(new BlockItem(BlockInit.HEIDIPHYLLUM_PRESSURE_PLATE, new Item.Properties().group(PFWood.instance)).setRegistryName("heidiphyllum_pressure_plate"));
 		event.getRegistry().register(new BlockItem(BlockInit.SHORT_OSMUNDACAULIS, new Item.Properties().group(PFPlants.instance)).setRegistryName("short_osmundacaulis"));
 		event.getRegistry().register(new BlockItem(BlockInit.DEAD_OSMUNDACAULIS, new Item.Properties().group(PFPlants.instance)).setRegistryName("dead_osmundacaulis"));
 		event.getRegistry().register(new BlockItem(BlockInit.DRYOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("dryosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.EILENODON_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("eilenodon_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.ALLOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("allosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.STEGOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("stegosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.CERATOSAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("ceratosaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.HESPERORNITHOIDES_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("hesperornithoides_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.HYPERODAPEDON_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("hyperodapedon_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.HERRERASAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("herrerasaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.CHROMOGISAURUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("chromogisaurus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_FOSSIL, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_fossil"));
 		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_TRIASSIC_SANDSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("smooth_triassic_sandstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_TRIASSIC_SANDSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_triassic_sandstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_TRIASSIC_SANDSTONE_BRICKS, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_triassic_sandstone_bricks"));
 		event.getRegistry().register(new BlockItem(BlockInit.CHISELED_POLISHED_TRIASSIC_SANDSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("chiseled_polished_triassic_sandstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_TRIASSIC_SANDSTONE_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("smooth_triassic_sandstone_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_BRICK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_brick_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_TRIASSIC_SANDSTONE_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_triassic_sandstone_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_TRIASSIC_SANDSTONE_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_triassic_sandstone_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_BRICK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_brick_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.TRIASSIC_SANDSTONE_BRICK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("triassic_sandstone_brick_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_FOSSIL, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_fossil"));
 		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_JURASSIC_SILTSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("smooth_jurassic_siltstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_JURASSIC_SILTSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_jurassic_siltstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_JURASSIC_SILTSTONE_BRICKS, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_jurassic_siltstone_bricks"));
 		event.getRegistry().register(new BlockItem(BlockInit.CHISELED_POLISHED_JURASSIC_SILTSTONE, new Item.Properties().group(PFStone.instance)).setRegistryName("chiseled_polished_jurassic_siltstone"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_JURASSIC_SILTSTONE_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("smooth_jurassic_siltstone_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_BRICK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_brick_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_JURASSIC_SILTSTONE_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_jurassic_siltstone_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_JURASSIC_SILTSTONE_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_jurassic_siltstone_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_BRICK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_brick_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.JURASSIC_SILTSTONE_BRICK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("jurassic_siltstone_brick_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_FOSSIL, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_fossil"));
 		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_CRETACEOUS_CHALK, new Item.Properties().group(PFStone.instance)).setRegistryName("smooth_cretaceous_chalk"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CRETACEOUS_CHALK, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_cretaceous_chalk"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CRETACEOUS_CHALK_BRICKS, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_cretaceous_chalk_bricks"));
 		event.getRegistry().register(new BlockItem(BlockInit.CHISELED_POLISHED_CRETACEOUS_CHALK, new Item.Properties().group(PFStone.instance)).setRegistryName("chiseled_polished_cretaceous_chalk"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.SMOOTH_CRETACEOUS_CHALK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("smooth_cretaceous_chalk_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_BRICK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_brick_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CRETACEOUS_CHALK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_cretaceous_chalk_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_CRETACEOUS_CHALK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("polished_cretaceous_chalk_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_BRICK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_brick_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.CRETACEOUS_CHALK_BRICK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("cretaceous_chalk_brick_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.SILLOSUCHUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("sillosuchus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.PORTAL_FRAME, new Item.Properties().group(PFBook.instance)).setRegistryName("portal_frame"));
 		//event.getRegistry().register(new BlockItem(BlockInit.DIDELPHODON_BURROW, new Item.Properties().group(PFBook.instance)).setRegistryName("didelphodon_burrow"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_CARVED, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_carved"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_BRICKS, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_bricks"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_BRICKS_DARK, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_bricks_dark"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_PILLAR, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_pillar"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_PILLAR_CHISELED, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_pillar_chiseled"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_BRICK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_brick_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_BRICK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_brick_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_BRICK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_brick_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_DARK_BRICK_SLAB, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_dark_brick_slab"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_DARK_BRICK_STAIRS, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_dark_brick_stairs"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_DARK_BRICK_WALL, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_dark_brick_wall"));
 		event.getRegistry().register(new BlockItem(BlockInit.HENOSTONE_TRAP, new Item.Properties().group(PFStone.instance)).setRegistryName("henostone_trap"));
 		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_BB, new Item.Properties().group(PFFossil.instance)).setRegistryName("giant_shell_bb"));
 		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_BF, new Item.Properties().group(PFFossil.instance)).setRegistryName("giant_shell_bf"));
 		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_TB, new Item.Properties().group(PFFossil.instance)).setRegistryName("giant_shell_tb"));
 		event.getRegistry().register(new BlockItem(BlockInit.GIANT_AMMONITE_SHELL_TF, new Item.Properties().group(PFFossil.instance)).setRegistryName("giant_shell_tf"));
 		event.getRegistry().register(new BlockItem(BlockInit.AMMONITE_BLOCK, new Item.Properties().group(PFFossil.instance)).setRegistryName("ammonite_block"));
 		event.getRegistry().register(new BlockItem(BlockInit.PETRIFIED_WOOD, new Item.Properties().group(PFFossil.instance)).setRegistryName("petrified_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.POLISHED_PETRIFIED_WOOD, new Item.Properties().group(PFFossil.instance)).setRegistryName("polished_petrified_wood"));
 		event.getRegistry().register(new BlockItem(BlockInit.SAUROSUCHUS_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("saurosuchus_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.ISCHIGUALASTIA_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("ischigualastia_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.EXAERETODON_EGG, new Item.Properties().group(PFEntities.instance)).setRegistryName("exaeretodon_egg"));
 		event.getRegistry().register(new BlockItem(BlockInit.PALEONTOLOGY_TABLE, new Item.Properties().group(PFBook.instance)).setRegistryName("paleontology_table"));
 		event.getRegistry().register(new BlockItem(BlockInit.ALGAE, new Item.Properties().group(PFPlants.instance)).setRegistryName("algae_carpet"));
 		event.getRegistry().register(new BlockItem(BlockInit.PALEOSCRIBE, new Item.Properties().group(PFBook.instance)).setRegistryName("paleoscribe"));
 		event.getRegistry().register(new BlockItem(BlockInit.SILT, new Item.Properties().group(PFPlants.instance)).setRegistryName("silt"));
 		event.getRegistry().register(new BlockItem(BlockInit.HARDENED_SILT, new Item.Properties().group(PFPlants.instance)).setRegistryName("hardened_silt"));
 	}
	
	public static final Tag<Block> BURROWS = makeWrapperTag("burrows");

	private static Tag<Block> makeWrapperTag(String id) {
		return new BlockTags.Wrapper(new ResourceLocation(id));
	}
	
}
