package superlord.prehistoricfauna.init;

import com.mojang.datafixers.util.Pair;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.HayBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
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
import superlord.prehistoricfauna.common.blocks.AepyornithomimusEggBlock;
import superlord.prehistoricfauna.common.blocks.AlgaeBlock;
import superlord.prehistoricfauna.common.blocks.AllosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteGiantShellBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteLargeShellBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteMediumShellBlock;
import superlord.prehistoricfauna.common.blocks.AmmoniteSmallShellBlock;
import superlord.prehistoricfauna.common.blocks.AnkylosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.BasilemysEggBlock;
import superlord.prehistoricfauna.common.blocks.BigTuberBlock;
import superlord.prehistoricfauna.common.blocks.CalsoyasuchusEggBlock;
import superlord.prehistoricfauna.common.blocks.CamarasaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.CarvedSmallTuberBlock;
import superlord.prehistoricfauna.common.blocks.CarvedTuberBlock;
import superlord.prehistoricfauna.common.blocks.CeratosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.ChromogisaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.CitipatiEggBlock;
import superlord.prehistoricfauna.common.blocks.ClathopterisBlock;
import superlord.prehistoricfauna.common.blocks.CobbaniaBlock;
import superlord.prehistoricfauna.common.blocks.CoelophysisEggBlock;
import superlord.prehistoricfauna.common.blocks.CrassostreaOysterBlock;
import superlord.prehistoricfauna.common.blocks.CrateBlock;
import superlord.prehistoricfauna.common.blocks.CretaceousPortalBlock;
import superlord.prehistoricfauna.common.blocks.CretaceousTimeBlock;
import superlord.prehistoricfauna.common.blocks.DakotaraptorEggBlock;
import superlord.prehistoricfauna.common.blocks.DeadCycadBlock;
import superlord.prehistoricfauna.common.blocks.DesmatosuchusEggBlock;
import superlord.prehistoricfauna.common.blocks.DicroidiumBlock;
import superlord.prehistoricfauna.common.blocks.DilophosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.DryosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.EilenodonEggBlock;
import superlord.prehistoricfauna.common.blocks.ExaeretodonEggBlock;
import superlord.prehistoricfauna.common.blocks.FossilCrateBlock;
import superlord.prehistoricfauna.common.blocks.GrowingPrehistoricPlantBlock;
import superlord.prehistoricfauna.common.blocks.HardenedSiltBlock;
import superlord.prehistoricfauna.common.blocks.HerrerasaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.HesperornithoidesEggBlock;
import superlord.prehistoricfauna.common.blocks.HyperodapedonEggBlock;
import superlord.prehistoricfauna.common.blocks.IschigualastiaEggBlock;
import superlord.prehistoricfauna.common.blocks.JohnstoniaBlock;
import superlord.prehistoricfauna.common.blocks.JurassicPortalBlock;
import superlord.prehistoricfauna.common.blocks.JurassicTimeBlock;
import superlord.prehistoricfauna.common.blocks.KayentatheriumEggBlock;
import superlord.prehistoricfauna.common.blocks.LeafCarpetBlock;
import superlord.prehistoricfauna.common.blocks.LiriodendritesLeavesBlock;
import superlord.prehistoricfauna.common.blocks.MegapnosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.MossBlock;
import superlord.prehistoricfauna.common.blocks.MossyDirtBlock;
import superlord.prehistoricfauna.common.blocks.NeocalamitesBlock;
import superlord.prehistoricfauna.common.blocks.NeocalamitesTopBlock;
import superlord.prehistoricfauna.common.blocks.PFSapling;
import superlord.prehistoricfauna.common.blocks.PFStandingSignBlock;
import superlord.prehistoricfauna.common.blocks.PFWallSignBlock;
import superlord.prehistoricfauna.common.blocks.PaleontologyTableBlock;
import superlord.prehistoricfauna.common.blocks.PaleoscribeBlock;
import superlord.prehistoricfauna.common.blocks.PinacosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.PlaceriasEggBlock;
import superlord.prehistoricfauna.common.blocks.PlantFiberBlock;
import superlord.prehistoricfauna.common.blocks.PlesiohadrosEggBlock;
import superlord.prehistoricfauna.common.blocks.PoposaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.PortalFrameBlock;
import superlord.prehistoricfauna.common.blocks.PostosuchusEggBlock;
import superlord.prehistoricfauna.common.blocks.PrehistoricPlant;
import superlord.prehistoricfauna.common.blocks.PrehistoricPlantBlock;
import superlord.prehistoricfauna.common.blocks.ProtoceratopsEggBlock;
import superlord.prehistoricfauna.common.blocks.PtilophyllumBaseBlock;
import superlord.prehistoricfauna.common.blocks.PtilophyllumBlock;
import superlord.prehistoricfauna.common.blocks.SarahsaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.SaurosuchusEggBlock;
import superlord.prehistoricfauna.common.blocks.ScelidosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.ScutellosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.ShortOsmundacaulisBlock;
import superlord.prehistoricfauna.common.blocks.SillosuchusEggBlock;
import superlord.prehistoricfauna.common.blocks.StegosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.TallHorsetailsBlock;
import superlord.prehistoricfauna.common.blocks.TelmasaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.ThescelosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.TrapBlock;
import superlord.prehistoricfauna.common.blocks.TriassicPortalBlock;
import superlord.prehistoricfauna.common.blocks.TriassicTimeBlock;
import superlord.prehistoricfauna.common.blocks.TriceratopsEggBlock;
import superlord.prehistoricfauna.common.blocks.TrilophosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.TuberBlock;
import superlord.prehistoricfauna.common.blocks.TuberCropBlock;
import superlord.prehistoricfauna.common.blocks.TypothoraxEggBlock;
import superlord.prehistoricfauna.common.blocks.TyrannosaurusEggBlock;
import superlord.prehistoricfauna.common.blocks.VelociraptorEggBlock;
import superlord.prehistoricfauna.common.blocks.VerticalSlabBlock;
import superlord.prehistoricfauna.common.blocks.ZamitesFrondsBlock;
import superlord.prehistoricfauna.common.blocks.ZamitesSaplingBlock;
import superlord.prehistoricfauna.common.blocks.ZamitesTopBlock;
import superlord.prehistoricfauna.common.items.CobbaniaItem;
import superlord.prehistoricfauna.common.util.PFWoodTypes;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.compat.HedgeBlock;
import superlord.prehistoricfauna.compat.PFBeehiveBlock;
import superlord.prehistoricfauna.compat.PFBookshelfBlock;
import superlord.prehistoricfauna.compat.PFChestBlock;
import superlord.prehistoricfauna.compat.PFLadderBlock;
import superlord.prehistoricfauna.compat.PFTrappedChestBlock;
import superlord.prehistoricfauna.compat.WoodPostBlock;
import superlord.prehistoricfauna.world.feature.trees.PFTreeSpawners;
@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Bus.MOD)
public class PFBlocks {

	public static final RegistryHelper HELPER = PrehistoricFauna.REGISTRY_HELPER;
	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, PrehistoricFauna.MOD_ID);

	public static final Block HORSETAIL = new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("horsetail"); //Loot Table done
	public static final Block OSMUNDA = new PrehistoricPlant(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("osmunda"); //Loot table done
	public static final Block TALL_HORSETAIL = new TallHorsetailsBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("tall_horsetail"); //Loot Table done
	public static final Block TALL_OSMUNDA = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("tall_osmunda"); //Loot Table done
	public static final Block CLUBMOSS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("clubmoss"); //Loot Table done
	public static final Block MARCHANTIA = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("marchantia"); //Loot Table done
	public static final Block MOSS_CARPET = new MossBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)).setRegistryName("moss_carpet"); //Loot Table done
	public static final Block METASEQUOIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_planks"); //Loot Table done
	public static final Block METASEQUOIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("metasequoia_log"); //Loot Table done
	public static final Block METASEQUOIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("metasequoia_leaves"); //Loot Table done
	public static final Block METASEQUOIA_SAPLING = new PFSapling(new PFTreeSpawners.Metasequoia(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("metasequoia_sapling"); //Loot Table done
	public static final Block STRIPPED_METASEQUOIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_metasequoia_log");//Loot Table done
	public static final Block METASEQUOIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("metasequoia_wood");//Loot Table done
	public static final Block STRIPPED_METASEQUOIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_metasequoia_wood");//Loot Table done
	public static final Block ARAUCARIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_planks");//Loot Table done
	public static final Block ARAUCARIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("araucaria_log");//Loot Table done
	public static final Block ARAUCARIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("araucaria_leaves");//Loot Table done
	public static final Block ARAUCARIA_SAPLING = new PFSapling(new PFTreeSpawners.Araucaria(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("araucaria_sapling"); //Loot Table done
	public static final Block STRIPPED_ARAUCARIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_araucaria_log");//Loot Table done
	public static final Block ARAUCARIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("araucaria_wood");//Loot Table done
	public static final Block STRIPPED_ARAUCARIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_araucaria_wood");//Loot Table done
	public static final Block METASEQUOIA_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_slab");//Loot Table done
	public static final Block ARAUCARIA_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_slab");//Loot Table done
	public static final Block METASEQUOIA_STAIRS = new StairsBlock(METASEQUOIA_PLANKS.getDefaultState(), Block.Properties.from(METASEQUOIA_PLANKS)).setRegistryName("metasequoia_stairs");//Loot Table done
	public static final Block ARAUCARIA_STAIRS = new StairsBlock(ARAUCARIA_PLANKS.getDefaultState(), Block.Properties.from(ARAUCARIA_PLANKS)).setRegistryName("araucaria_stairs");//Loot Table done
	public static final Block METASEQUOIA_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_fence");//Loot Table done
	public static final Block ARAUCARIA_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_fence");//Loot Table done
	public static final Block METASEQUOIA_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("metasequoia_fence_gate");//Loot Table done
	public static final Block ARAUCARIA_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("araucaria_fence_gate");//Loot Table done
	public static final Block METASEQUOIA_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("metasequoia_button");//Loot Table done
	public static final Block ARAUCARIA_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("araucaria_button");//Loot Table done
	public static final Block METASEQUOIA_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("metasequoia_door");//Loot Table done
	public static final Block ARAUCARIA_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("araucaria_door");//Loot Table done
	public static final Block METASEQUOIA_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("metasequoia_pressure_plate");//Loot Table done
	public static final Block ARAUCARIA_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("araucaria_pressure_plate");//Loot Table done
	public static final Block METASEQUOIA_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("metasequoia_trapdoor");//Loot Table done
	public static final Block ARAUCARIA_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("araucaria_trapdoor");//Loot Table done
	public static final Block POTTED_METASEQUOIA_SAPLING = new FlowerPotBlock(METASEQUOIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_metasequoia_sapling");//Loot Table done
	public static final Block POTTED_ARAUCARIA_SAPLING = new FlowerPotBlock(ARAUCARIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_araucaria_sapling");//Loot Table done
	public static final Block POTTED_HORSETAIL = new FlowerPotBlock(HORSETAIL, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_horsetail"); //Loot Table done
	public static final Block POTTED_OSMUNDA = new FlowerPotBlock(OSMUNDA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_osmunda");//Loot Table done
	public static final Block POTTED_CLUBMOSS = new FlowerPotBlock(CLUBMOSS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_clubmoss"); //Loot Table done
	public static final Block POTTED_MARCHANTIA = new FlowerPotBlock(MARCHANTIA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_marchantia"); //Loot Table done
	public static final Block MOSSY_DIRT = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.6F).sound(SoundType.PLANT).harvestTool(ToolType.SHOVEL)).setRegistryName("mossy_dirt"); //Loot Table done
	public static final Block LOAM = new MossyDirtBlock(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).hardnessAndResistance(0.6F).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL)).setRegistryName("loam");//Loot Table done
	public static final Block PACKED_LOAM = new Block(Block.Properties.create(Material.EARTH, MaterialColor.BROWN).hardnessAndResistance(0.6F).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL)).setRegistryName("packed_loam");
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
	public static final Block PROTOCERATOPS_EGG = new ProtoceratopsEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly()).setRegistryName("protoceratops_egg");
	public static final Block VELOCIRAPTOR_EGG = new VelociraptorEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("velociraptor_egg");
	public static final Block CITIPATI_EGG = new CitipatiEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).tickRandomly().notSolid().sound(SoundType.METAL)).setRegistryName("citipati_egg");
	public static final Block AEPYORNITHOMIMUS_EGG = new AepyornithomimusEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).tickRandomly().notSolid().sound(SoundType.METAL)).setRegistryName("aepyornithomimus_egg");
	public static final Block TELMASAURUS_EGG = new TelmasaurusEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.METAL).notSolid()).setRegistryName("telmasaurus_egg");
	public static final Block PINACOSAURUS_EGG = new PinacosaurusEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.METAL).notSolid()).setRegistryName("pinacosaurus_egg");
	public static final Block PLESIOHADROS_EGG = new PlesiohadrosEggBlock(AbstractBlock.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.METAL).notSolid()).setRegistryName("plesiohadros_egg");
	public static final Block MOSS_BLOCK = new Block(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT)).setRegistryName("moss_block"); //Loot Table done
	public static final Block CONIOPTERIS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("coniopteris");//Loot Table done
	public static final Block TALL_OSMUNDACAULIS = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("tall_osmundacaulis"); //Loot Table done
	public static final Block PROTOPICEOXYLON_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("protopiceoxylon_log");//Loot Table done
	public static final Block PROTOPICEOXYLON_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_planks");//Loot Table done
	public static final Block STRIPPED_PROTOPICEOXYLON_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_protopiceoxylon_log");//Loot Table done
	public static final Block PROTOPICEOXYLON_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("protopiceoxylon_wood");//Loot Table done
	public static final Block STRIPPED_PROTOPICEOXYLON_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_protopiceoxylon_wood");//Loot Table done
	public static final Block PROTOPICEOXYLON_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("protopiceoxylon_leaves");//Loot Table done
	public static final Block PROTOPICEOXYLON_STAIRS = new StairsBlock(PROTOPICEOXYLON_PLANKS.getDefaultState(), Block.Properties.from(PROTOPICEOXYLON_PLANKS)).setRegistryName("protopiceoxylon_stairs");//Loot Table done
	public static final Block PROTOPICEOXYLON_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protopiceoxylon_door");//Loot Table done
	public static final Block PROTOPICEOXYLON_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_pressure_plate");//Loot Table done
	public static final Block PROTOPICEOXYLON_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_fence");//Loot Table done
	public static final Block PROTOPICEOXYLON_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protopiceoxylon_trapdoor");//Loot Table done
	public static final Block PROTOPICEOXYLON_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_fence_gate");//Loot Table done
	public static final Block PROTOPICEOXYLON_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_button");//Loot Table done
	public static final Block PROTOPICEOXYLON_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protopiceoxylon_slab");//Loot Table done
	public static final Block PROTOPICEOXYLON_SAPLING = new PFSapling(new PFTreeSpawners.Protopiceoxylon(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("protopiceoxylon_sapling"); //Loot Table done
	public static final Block POTTED_PROTOPICEOXYLON_SAPLING = new FlowerPotBlock(PROTOPICEOXYLON_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_protopiceoxylon_sapling");//Loot Table done
	public static final Block PTILOPHYLLUM_WOOD = new PtilophyllumBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(0.4F).sound(SoundType.WOOD).notSolid()).setRegistryName("ptilophyllum_wood");//Loot Table done
	public static final Block PTILOPHYLLUM_BASE = new PtilophyllumBaseBlock((PtilophyllumBlock)PTILOPHYLLUM_WOOD, Block.Properties.create(Material.WOOD, MaterialColor.WOOD).tickRandomly().hardnessAndResistance(0.4F).sound(SoundType.WOOD).notSolid()).setRegistryName("ptilophyllum_base");//Loot Table done
	public static final Block ZAMITES_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("zamites_log");//Loot Table done
	public static final Block ZAMITES_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_planks");//Loot Table done
	public static final Block STRIPPED_ZAMITES_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_zamites_log");//Loot Table done
	public static final Block ZAMITES_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("zamites_wood");//Loot Table done
	public static final Block STRIPPED_ZAMITES_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_zamites_wood");//Loot Table done
	public static final Block ZAMITES_LEAVES = new ZamitesTopBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("zamites_leaves");//Loot Table done
	public static final Block ZAMITES_STAIRS = new StairsBlock(ZAMITES_PLANKS.getDefaultState(), Block.Properties.from(ZAMITES_PLANKS)).setRegistryName("zamites_stairs");//Loot Table done
	public static final Block ZAMITES_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("zamites_door");//Loot Table done
	public static final Block ZAMITES_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("zamites_pressure_plate");//Loot Table done
	public static final Block ZAMITES_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_fence");//Loot Table done
	public static final Block ZAMITES_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("zamites_trapdoor");//Loot Table done
	public static final Block ZAMITES_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_fence_gate");//Loot Table done
	public static final Block ZAMITES_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("zamites_button");//Loot Table done
	public static final Block ZAMITES_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("zamites_slab");//Loot Table done
	public static final Block ZAMITES_SAPLING = new ZamitesSaplingBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("zamites_sapling");//Loot Table done
	public static final Block POTTED_ZAMITES_SAPLING = new FlowerPotBlock(ZAMITES_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_zamites_sapling");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("protojuniperoxylon_log");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_planks");//Loot Table done
	public static final Block STRIPPED_PROTOJUNIPEROXYLON_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_protojuniperoxylon_log");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("protojuniperoxylon_wood");//Loot Table done
	public static final Block STRIPPED_PROTOJUNIPEROXYLON_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_protojuniperoxylon_wood");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("protojuniperoxylon_leaves");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_STAIRS = new StairsBlock(PROTOJUNIPEROXYLON_PLANKS.getDefaultState(), Block.Properties.from(PROTOJUNIPEROXYLON_PLANKS)).setRegistryName("protojuniperoxylon_stairs");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protojuniperoxylon_door");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_pressure_plate");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_fence");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("protojuniperoxylon_trapdoor");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_fence_gate");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_button");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protojuniperoxylon_slab");//Loot Table done
	public static final Block PROTOJUNIPEROXYLON_SAPLING = new PFSapling(new PFTreeSpawners.Protojuniperoxylon(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("protojuniperoxylon_sapling");//Loot Table done
	public static final Block POTTED_PROTOJUNIPEROXYLON_SAPLING = new FlowerPotBlock(PROTOJUNIPEROXYLON_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_protojuniperoxylon_sapling");//Loot Table done
	public static final Block DICROIDIUM = new DicroidiumBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("dicroidium");//Loot Table done
	public static final Block JOHNSTONIA = new JohnstoniaBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName("johnstonia");//Loot Table done
	public static final Block SCYTOPHYLLUM = new TallFlowerBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("scytophyllum");//Loot Table done
	public static final Block CLADOPHLEBIS = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("cladophlebis");//Loot Table done
	public static final Block MICHELILLOA = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("michelilloa");
	public static final Block POTTED_CLADOPHLEBIS = new FlowerPotBlock(CLADOPHLEBIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_cladophlebis");//Loot Table done
	public static final Block POTTED_MICHELILLOA = new FlowerPotBlock(MICHELILLOA, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_michelilloa");//Loot Table done
	public static final Block HEIDIPHYLLUM_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("heidiphyllum_log");//Loot Table done
	public static final Block HEIDIPHYLLUM_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_planks");//Loot Table done
	public static final Block STRIPPED_HEIDIPHYLLUM_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_heidiphyllum_log");//Loot Table done
	public static final Block HEIDIPHYLLUM_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("heidiphyllum_wood");//Loot Table done
	public static final Block STRIPPED_HEIDIPHYLLUM_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_heidiphyllum_wood");//Loot Table done
	public static final Block HEIDIPHYLLUM_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("heidiphyllum_leaves");//Loot Table done
	public static final Block HEIDIPHYLLUM_STAIRS = new StairsBlock(HEIDIPHYLLUM_PLANKS.getDefaultState(), Block.Properties.from(HEIDIPHYLLUM_PLANKS)).setRegistryName("heidiphyllum_stairs");//Loot Table done
	public static final Block HEIDIPHYLLUM_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("heidiphyllum_door");//Loot Table done
	public static final Block HEIDIPHYLLUM_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_pressure_plate");//Loot Table done
	public static final Block HEIDIPHYLLUM_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_fence");//Loot Table done
	public static final Block HEIDIPHYLLUM_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("heidiphyllum_trapdoor");//Loot Table done
	public static final Block HEIDIPHYLLUM_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_fence_gate");//Loot Table done
	public static final Block HEIDIPHYLLUM_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_button");//Loot Table done
	public static final Block HEIDIPHYLLUM_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("heidiphyllum_slab");//Loot Table done
	public static final Block HEIDIPHYLLUM_SAPLING = new PFSapling(new PFTreeSpawners.Heidiphyllum(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("heidiphyllum_sapling");//Loot Table done
	public static final Block POTTED_HEIDIPHYLLUM_SAPLING = new FlowerPotBlock(HEIDIPHYLLUM_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_heidiphyllum_sapling");//Loot Table done
	public static final Block OSMUNDACAULIS = new ShortOsmundacaulisBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("osmundacaulis"); //Loot Table done
	public static final Block DEAD_OSMUNDACAULIS = new DeadCycadBlock(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.WOOD).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("dead_osmundacaulis"); //Loot Table done
	public static final Block LIRIODENDRITES_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("liriodendrites_log");//Loot Table done
	public static final Block LIRIODENDRITES_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_planks");//Loot Table done
	public static final Block STRIPPED_LIRIODENDRITES_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_liriodendrites_log");//Loot Table done
	public static final Block LIRIODENDRITES_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("liriodendrites_wood");//Loot Table done
	public static final Block STRIPPED_LIRIODENDRITES_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_liriodendrites_wood");//Loot Table done
	public static final Block LIRIODENDRITES_LEAVES = new LiriodendritesLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("liriodendrites_leaves");//Loot Table done
	public static final Block LIRIODENDRITES_STAIRS = new StairsBlock(LIRIODENDRITES_PLANKS.getDefaultState(), Block.Properties.from(LIRIODENDRITES_PLANKS)).setRegistryName("liriodendrites_stairs");//Loot Table done
	public static final Block LIRIODENDRITES_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("liriodendrites_door");//Loot Table done
	public static final Block LIRIODENDRITES_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_pressure_plate");//Loot Table done
	public static final Block LIRIODENDRITES_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_fence");//Loot Table done
	public static final Block LIRIODENDRITES_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("liriodendrites_trapdoor");//Loot Table done
	public static final Block LIRIODENDRITES_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_fence_gate");//Loot Table done
	public static final Block LIRIODENDRITES_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_button");//Loot Table done
	public static final Block LIRIODENDRITES_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("liriodendrites_slab");//Loot Table done
	public static final Block LIRIODENDRITES_SAPLING = new PFSapling(new PFTreeSpawners.Liriodendrites(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("liriodendrites_sapling"); //Loot Table done
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
	public static final Block SANDSTONE_STAIRS = new StairsBlock(SANDSTONE.getDefaultState(), Block.Properties.from(SANDSTONE)).setRegistryName("sandstone_stairs");//Loot Table done
	public static final Block SANDSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("sandstone_slab");//Loot Table done
	public static final Block POLISHED_SANDSTONE_STAIRS = new StairsBlock(POLISHED_SANDSTONE.getDefaultState(), Block.Properties.from(POLISHED_SANDSTONE)).setRegistryName("polished_sandstone_stairs");//Loot Table done
	public static final Block POLISHED_SANDSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_sandstone_slab");//Loot Table done
	public static final Block SANDSTONE_BRICK_STAIRS = new StairsBlock(SANDSTONE_BRICKS.getDefaultState(), Block.Properties.from(SANDSTONE_BRICKS)).setRegistryName("sandstone_brick_stairs");//Loot Table done
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
	public static final Block SILTSTONE_STAIRS = new StairsBlock(SILTSTONE.getDefaultState(), Block.Properties.from(SILTSTONE)).setRegistryName("siltstone_stairs");//Loot Table done
	public static final Block SILTSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("siltstone_slab");//Loot Table done
	public static final Block SILTSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("siltstone_brick_slab");//Loot Table done
	public static final Block SILTSTONE_BRICK_STAIRS = new StairsBlock(SILTSTONE_BRICKS.getDefaultState(), Block.Properties.from(SILTSTONE_BRICKS)).setRegistryName("siltstone_brick_stairs");//Loot Table done
	public static final Block POLISHED_SILTSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_siltstone_slab");//Loot Table done
	public static final Block POLISHED_SILTSTONE_STAIRS = new StairsBlock(POLISHED_SILTSTONE.getDefaultState(), Block.Properties.from(POLISHED_SILTSTONE)).setRegistryName("polished_siltstone_stairs");//Loot Table done
	public static final Block CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk");//Loot Table done
	public static final Block CHALK_FOSSIL = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestLevel(2).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("chalk_fossil");//Loot Table done
	public static final Block SMOOTH_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("smooth_chalk");//Loot Table done
	public static final Block POLISHED_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_chalk");//Loot Table done
	public static final Block CHALK_BRICKS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk_bricks");//Loot Table done
	public static final Block CHISELED_CHALK = new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chiseled_chalk");//Loot Table done
	public static final Block CHALK_WALL = new WallBlock(Block.Properties.from(CHALK)).setRegistryName("chalk_wall");//Loot Table done
	public static final Block SMOOTH_CHALK_WALL = new WallBlock(Block.Properties.from(SMOOTH_CHALK)).setRegistryName("smooth_chalk_wall");//Loot Table done
	public static final Block CHALK_BRICK_WALL = new WallBlock(Block.Properties.from(CHALK_BRICKS)).setRegistryName("chalk_brick_wall");//Loot Table done
	public static final Block CHALK_STAIRS = new StairsBlock(CHALK.getDefaultState(), Block.Properties.from(CHALK)).setRegistryName("chalk_stairs");//Loot Table done
	public static final Block CHALK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk_slab");//Loot Table done
	public static final Block CHALK_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("chalk_brick_slab");//Loot Table done
	public static final Block CHALK_BRICK_STAIRS = new StairsBlock(CHALK_BRICKS.getDefaultState(), Block.Properties.from(CHALK_BRICKS)).setRegistryName("chalk_brick_stairs");//Loot Table done
	public static final Block POLISHED_CHALK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_chalk_slab");//Loot Table done
	public static final Block POLISHED_CHALK_STAIRS = new StairsBlock(POLISHED_CHALK.getDefaultState(), Block.Properties.from(POLISHED_CHALK)).setRegistryName("polished_chalk_stairs");//Loot Table done
	public static final Block SILLOSUCHUS_EGG = new SillosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("sillosuchus_egg");//Loot Table done
	public static final Block PORTAL_FRAME = new PortalFrameBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).setLightLevel((state) -> {
		return 9;
	})).setRegistryName("portal_frame");//Loot Table done
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
	public static final Block HENOSTONE_STAIRS = new StairsBlock(HENOSTONE.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_stairs");
	public static final Block HENOSTONE_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_slab");
	public static final Block HENOSTONE_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_wall");
	public static final Block HENOSTONE_BRICK_STAIRS = new StairsBlock(HENOSTONE_BRICKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_stairs");
	public static final Block HENOSTONE_BRICK_SLAB = new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_slab");
	public static final Block HENOSTONE_BRICK_WALL = new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("henostone_brick_wall");
	public static final Block DARK_HENOSTONE_BRICK_STAIRS = new StairsBlock(DARK_HENOSTONE_BRICKS.getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("dark_henostone_brick_stairs");
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
	public static final Block PETRIFIED_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("petrified_wood");
	public static final Block POLISHED_PETRIFIED_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE)).setRegistryName("polished_petrified_wood");
	public static final Block SAUROSUCHUS_EGG = new SaurosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("saurosuchus_egg");//Loot Table done
	public static final Block ISCHIGUALASTIA_EGG = new IschigualastiaEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("ischigualastia_egg");
	public static final Block EXAERETODON_EGG = new ExaeretodonEggBlock(Block.Properties.create(Material.DRAGON_EGG, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("exaeretodon_egg");//Loot Table done
	public static final Block PALEONTOLOGY_TABLE = new PaleontologyTableBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("paleontology_table");//Loot Table done
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
	public static final Block SILT = new SandBlock(0x8C603C, Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.SAND).harvestTool(ToolType.SHOVEL)).setRegistryName("silt");
	public static final Block HARDENED_SILT = new HardenedSiltBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.SAND).harvestTool(ToolType.SHOVEL)).setRegistryName("hardened_silt");
	public static final Block PLANT_FIBER_BLOCK = new PlantFiberBlock(AbstractBlock.Properties.create(Material.ORGANIC).hardnessAndResistance(0.5F).sound(SoundType.PLANT)).setRegistryName("plant_fiber_block");
	public static final Block THATCH = new HayBlock(AbstractBlock.Properties.create(Material.ORGANIC).hardnessAndResistance(0.6F).sound(SoundType.PLANT).notSolid()).setRegistryName("thatch");
	public static final Block THATCH_STAIRS = new StairsBlock(THATCH.getDefaultState(), AbstractBlock.Properties.from(THATCH).notSolid()).setRegistryName("thatch_stairs");
	public static final Block THATCH_SLAB = new SlabBlock(AbstractBlock.Properties.from(THATCH).notSolid()).setRegistryName("thatch_slab");
	public static final Block TUBER_CROP = new TuberCropBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)).setRegistryName("tuber_crop");
	public static final Block THATCH_CARPET = new CarpetBlock(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.PLANTS).hardnessAndResistance(0.1F).sound(SoundType.CLOTH)).setRegistryName("thatch_carpet");
	public static final RegistryObject<TriassicPortalBlock> TRIASSIC_PORTAL = REGISTER.register("triassic_portal", () -> new TriassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).noDrops()));
	public static final RegistryObject<JurassicPortalBlock> JURASSIC_PORTAL = REGISTER.register("jurassic_portal", () -> new JurassicPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).noDrops()));
	public static final RegistryObject<CretaceousPortalBlock> CRETACEOUS_PORTAL = REGISTER.register("cretaceous_portal", () -> new CretaceousPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).noDrops()));
	public static final Block GINKGO_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("ginkgo_log");//Loot Table done
	public static final Block GINKGO_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ginkgo_planks");//Loot Table done
	public static final Block STRIPPED_GINKGO_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_ginkgo_log");//Loot Table done
	public static final Block GINKGO_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("ginkgo_wood");//Loot Table done
	public static final Block STRIPPED_GINKGO_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_ginkgo_wood");//Loot Table done
	public static final Block GINKGO_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("ginkgo_leaves");//Loot Table done
	public static final Block GINKGO_STAIRS = new StairsBlock(GINKGO_PLANKS.getDefaultState(), Block.Properties.from(GINKGO_PLANKS)).setRegistryName("ginkgo_stairs");//Loot Table done
	public static final Block GINKGO_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("ginkgo_door");//Loot Table done
	public static final Block GINKGO_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("ginkgo_pressure_plate");//Loot Table done
	public static final Block GINKGO_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ginkgo_fence");//Loot Table done
	public static final Block GINKGO_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("ginkgo_trapdoor");//Loot Table done
	public static final Block GINKGO_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ginkgo_fence_gate");//Loot Table done
	public static final Block GINKGO_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("ginkgo_button");//Loot Table done
	public static final Block GINKGO_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ginkgo_slab");//Loot Table done
	public static final Block GINKGO_SAPLING = new PFSapling(new PFTreeSpawners.Ginkgo(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("ginkgo_sapling");//Loot Table done
	public static final Block POTTED_GINKGO_SAPLING = new FlowerPotBlock(GINKGO_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_ginkgo_sapling");//Loot Table done
	public static final Block GINKGO_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.GINKGO).setRegistryName("ginkgo_sign");
	public static final Block GINKGO_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.GINKGO).setRegistryName("ginkgo_wall_sign");
	public static final Block COBBANIA = new CobbaniaBlock(Block.Properties.create(Material.PLANTS).zeroHardnessAndResistance().sound(SoundType.LILY_PADS).notSolid()).setRegistryName("cobbania");

	public static final Block TROCHODENDROIDES_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("trochodendroides_log");//Loot Table done
	public static final Block TROCHODENDROIDES_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("trochodendroides_planks");//Loot Table done
	public static final Block STRIPPED_TROCHODENDROIDES_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_trochodendroides_log");//Loot Table done
	public static final Block TROCHODENDROIDES_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("trochodendroides_wood");//Loot Table done
	public static final Block STRIPPED_TROCHODENDROIDES_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_trochodendroides_wood");//Loot Table done
	public static final Block TROCHODENDROIDES_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("trochodendroides_leaves");//Loot Table done
	public static final Block TROCHODENDROIDES_STAIRS = new StairsBlock(TROCHODENDROIDES_PLANKS.getDefaultState(), Block.Properties.from(TROCHODENDROIDES_PLANKS)).setRegistryName("trochodendroides_stairs");//Loot Table done
	public static final Block TROCHODENDROIDES_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("trochodendroides_door");//Loot Table done
	public static final Block TROCHODENDROIDES_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("trochodendroides_pressure_plate");//Loot Table done
	public static final Block TROCHODENDROIDES_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("trochodendroides_fence");//Loot Table done
	public static final Block TROCHODENDROIDES_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("trochodendroides_trapdoor");//Loot Table done
	public static final Block TROCHODENDROIDES_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("trochodendroides_fence_gate");//Loot Table done
	public static final Block TROCHODENDROIDES_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("trochodendroides_button");//Loot Table done
	public static final Block TROCHODENDROIDES_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("trochodendroides_slab");//Loot Table done
	public static final Block TROCHODENDROIDES_SAPLING = new PFSapling(new PFTreeSpawners.Trochodendroides(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("trochodendroides_sapling");//Loot Table done
	public static final Block POTTED_TROCHODENDROIDES_SAPLING = new FlowerPotBlock(TROCHODENDROIDES_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_trochodendroides_sapling");//Loot Table done
	public static final Block TROCHODENDROIDES_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.TROCHODENDROIDES).setRegistryName("trochodendroides_sign");
	public static final Block TROCHODENDROIDES_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.TROCHODENDROIDES).setRegistryName("trochodendroides_wall_sign");

	public static final Block BRACHYPHYLLUM_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("brachyphyllum_log");
	public static final Block BRACHYPHYLLUM_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("brachyphyllum_planks");
	public static final Block STRIPPED_BRACHYPHYLLUM_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_brachyphyllum_log");
	public static final Block BRACHYPHYLLUM_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("brachyphyllum_wood");
	public static final Block STRIPPED_BRACHYPHYLLUM_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_brachyphyllum_wood");
	public static final Block BRACHYPHYLLUM_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("brachyphyllum_leaves");
	public static final Block BRACHYPHYLLUM_STAIRS = new StairsBlock(BRACHYPHYLLUM_PLANKS.getDefaultState(), Block.Properties.from(BRACHYPHYLLUM_PLANKS)).setRegistryName("brachyphyllum_stairs");
	public static final Block BRACHYPHYLLUM_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("brachyphyllum_door");
	public static final Block BRACHYPHYLLUM_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("brachyphyllum_pressure_plate");//Loot Table done
	public static final Block BRACHYPHYLLUM_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("brachyphyllum_fence");//Loot Table done
	public static final Block BRACHYPHYLLUM_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("brachyphyllum_trapdoor");//Loot Table done
	public static final Block BRACHYPHYLLUM_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("brachyphyllum_fence_gate");//Loot Table done
	public static final Block BRACHYPHYLLUM_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("brachyphyllum_button");//Loot Table done
	public static final Block BRACHYPHYLLUM_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("brachyphyllum_slab");//Loot Table done
	public static final Block BRACHYPHYLLUM_SAPLING = new PFSapling(new PFTreeSpawners.Brachyphyllum(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("brachyphyllum_sapling");//Loot Table done
	public static final Block POTTED_BRACHYPHYLLUM_SAPLING = new FlowerPotBlock(BRACHYPHYLLUM_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_brachyphyllum_sapling");//Loot Table done
	public static final Block BRACHYPHYLLUM_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.BRACHYPHYLLUM).setRegistryName("brachyphyllum_sign");
	public static final Block BRACHYPHYLLUM_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.TROCHODENDROIDES).setRegistryName("brachyphyllum_wall_sign");
	public static final Block OTOZAMITES = new GrowingPrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("otozamites"); //Loot Table done
	public static final Block TALL_OTOZAMITES = new DoublePlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("tall_otozamites"); //Loot Table done
	public static final Block LAUROZAMITES = new PrehistoricPlantBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("laurozamites");
	public static final Block ZAMITES_FROND = new ZamitesFrondsBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("zamites_fronds");
	public static final Block CLATHOPTERIS = new ClathopterisBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("clathopteris");
	public static final Block DILOPHOSAURUS_EGG = new DilophosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("dilophosaurus_egg");
	public static final Block SARAHSAURUS_EGG = new SarahsaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("sarahsaurus_egg");
	public static final Block SCELIDOSAURUS_EGG = new ScelidosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("scelidosaurus_egg");
	public static final Block SCUTELLOSAURUS_EGG = new ScutellosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("scutellosaurus_egg");
	public static final Block MEGAPNOSAURUS_EGG = new MegapnosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("megapnosaurus_egg");
	public static final Block KAYENTATHERIUM_EGG = new KayentatheriumEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("kayentatherium_egg");
	public static final Block POTTED_LAUROZAMITES = new FlowerPotBlock(LAUROZAMITES, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_laurozamites");
	public static final Block POTTED_OTOZAMITES = new FlowerPotBlock(OTOZAMITES, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_otozamites");
	public static final Block POTTED_CLATHOPTERIS = new FlowerPotBlock(CLATHOPTERIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_clathopteris");
	public static final Block PHLEBOPTERIS = new ClathopterisBlock(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("phlebopteris");
	public static final Block NEOCALAMITES = new NeocalamitesBlock(Block.Properties.create(Material.BAMBOO).hardnessAndResistance(0.5F).tickRandomly().sound(SoundType.PLANT)).setRegistryName("neocalamites");
	public static final Block NEOCALAMITES_TOP = new NeocalamitesTopBlock(Block.Properties.create(Material.BAMBOO).hardnessAndResistance(0.5F).sound(SoundType.PLANT)).setRegistryName("neocalamites_top");
	public static final Block POTTED_PHLEBOPTERIS = new FlowerPotBlock(PHLEBOPTERIS, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_phlebopteris");
	public static final Block POTTED_NEOCALAMITES = new FlowerPotBlock(NEOCALAMITES, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_neocalamites");

	public static final Block AGATHOXYLON_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("agathoxylon_log");//Loot Table done
	public static final Block AGATHOXYLON_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("agathoxylon_planks");//Loot Table done
	public static final Block STRIPPED_AGATHOXYLON_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_agathoxylon_log");//Loot Table done
	public static final Block AGATHOXYLON_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("agathoxylon_wood");//Loot Table done
	public static final Block STRIPPED_AGATHOXYLON_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_agathoxylon_wood");//Loot Table done
	public static final Block AGATHOXYLON_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("agathoxylon_leaves");//Loot Table done
	public static final Block AGATHOXYLON_STAIRS = new StairsBlock(AGATHOXYLON_PLANKS.getDefaultState(), Block.Properties.from(AGATHOXYLON_PLANKS)).setRegistryName("agathoxylon_stairs");//Loot Table done
	public static final Block AGATHOXYLON_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("agathoxylon_door");//Loot Table done
	public static final Block AGATHOXYLON_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("agathoxylon_pressure_plate");//Loot Table done
	public static final Block AGATHOXYLON_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("agathoxylon_fence");//Loot Table done
	public static final Block AGATHOXYLON_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("agathoxylon_trapdoor");//Loot Table done
	public static final Block AGATHOXYLON_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("agathoxylon_fence_gate");//Loot Table done
	public static final Block AGATHOXYLON_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("agathoxylon_button");//Loot Table done
	public static final Block AGATHOXYLON_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("agathoxylon_slab");//Loot Table done
	public static final Block AGATHOXYLON_SAPLING = new PFSapling(new PFTreeSpawners.Agathoxylon(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("agathoxylon_sapling");//Loot Table done
	public static final Block POTTED_AGATHOXYLON_SAPLING = new FlowerPotBlock(AGATHOXYLON_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_agathoxylon_sapling");//Loot Table done
	public static final Block AGATHOXYLON_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.AGATHOXYLON).setRegistryName("agathoxylon_sign");
	public static final Block AGATHOXYLON_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.AGATHOXYLON).setRegistryName("agathoxylon_wall_sign");

	public static final Block WOODWORTHIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("woodworthia_log");//Loot Table done
	public static final Block WOODWORTHIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("woodworthia_planks");//Loot Table done
	public static final Block STRIPPED_WOODWORTHIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_woodworthia_log");//Loot Table done
	public static final Block WOODWORTHIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("woodworthia_wood");//Loot Table done
	public static final Block STRIPPED_WOODWORTHIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_woodworthia_wood");//Loot Table done
	public static final Block WOODWORTHIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("woodworthia_leaves");//Loot Table done
	public static final Block WOODWORTHIA_STAIRS = new StairsBlock(WOODWORTHIA_PLANKS.getDefaultState(), Block.Properties.from(AGATHOXYLON_PLANKS)).setRegistryName("woodworthia_stairs");//Loot Table done
	public static final Block WOODWORTHIA_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("woodworthia_door");//Loot Table done
	public static final Block WOODWORTHIA_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("woodworthia_pressure_plate");//Loot Table done
	public static final Block WOODWORTHIA_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("woodworthia_fence");//Loot Table done
	public static final Block WOODWORTHIA_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("woodworthia_trapdoor");//Loot Table done
	public static final Block WOODWORTHIA_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("woodworthia_fence_gate");//Loot Table done
	public static final Block WOODWORTHIA_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("woodworthia_button");//Loot Table done
	public static final Block WOODWORTHIA_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("woodworthia_slab");//Loot Table done
	public static final Block WOODWORTHIA_SAPLING = new PFSapling(new PFTreeSpawners.Woodworthia(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("woodworthia_sapling");//Loot Table done
	public static final Block POTTED_WOODWORTHIA_SAPLING = new FlowerPotBlock(WOODWORTHIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_woodworthia_sapling");//Loot Table done
	public static final Block WOODWORTHIA_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.WOODWORTHIA).setRegistryName("woodworthia_sign");
	public static final Block WOODWORTHIA_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.WOODWORTHIA).setRegistryName("woodworthia_wall_sign");

	public static final Block SCHILDERIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("schilderia_log");//Loot Table done
	public static final Block SCHILDERIA_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("schilderia_planks");//Loot Table done
	public static final Block STRIPPED_SCHILDERIA_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_schilderia_log");//Loot Table done
	public static final Block SCHILDERIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("schilderia_wood");//Loot Table done
	public static final Block STRIPPED_SCHILDERIA_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.OBSIDIAN).setRegistryName("stripped_schilderia_wood");//Loot Table done
	public static final Block SCHILDERIA_LEAVES = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()).setRegistryName("schilderia_leaves");//Loot Table done
	public static final Block SCHILDERIA_STAIRS = new StairsBlock(SCHILDERIA_PLANKS.getDefaultState(), Block.Properties.from(AGATHOXYLON_PLANKS)).setRegistryName("schilderia_stairs");//Loot Table done
	public static final Block SCHILDERIA_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("schilderia_door");//Loot Table done
	public static final Block SCHILDERIA_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("schilderia_pressure_plate");//Loot Table done
	public static final Block SCHILDERIA_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("schilderia_fence");//Loot Table done
	public static final Block SCHILDERIA_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("schilderia_trapdoor");//Loot Table done
	public static final Block SCHILDERIA_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("schilderia_fence_gate");//Loot Table done
	public static final Block SCHILDERIA_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("schilderia_button");//Loot Table done
	public static final Block SCHILDERIA_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("schilderia_slab");//Loot Table done
	public static final Block SCHILDERIA_SAPLING = new PFSapling(new PFTreeSpawners.Schilderia(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0).sound(SoundType.PLANT)).setRegistryName("schilderia_sapling");//Loot Table done
	public static final Block POTTED_SCHILDERIA_SAPLING = new FlowerPotBlock(SCHILDERIA_SAPLING, Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0).notSolid()).setRegistryName("potted_schilderia_sapling");//Loot Table done
	public static final Block SCHILDERIA_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.SCHILDERIA).setRegistryName("schilderia_sign");
	public static final Block SCHILDERIA_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.SCHILDERIA).setRegistryName("schilderia_wall_sign");

	//Neocalamites Extra Blocks :Allah:
	public static final Block NEOCALAMITES_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("neocalamites_planks");//Loot Table done
	public static final Block NEOCALAMITES_STAIRS = new StairsBlock(NEOCALAMITES_PLANKS.getDefaultState(), Block.Properties.from(NEOCALAMITES_PLANKS)).setRegistryName("neocalamites_stairs");//Loot Table done
	public static final Block NEOCALAMITES_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("neocalamites_door");//Loot Table done
	public static final Block NEOCALAMITES_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("neocalamites_pressure_plate");//Loot Table done
	public static final Block NEOCALAMITES_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("neocalamites_fence");//Loot Table done
	public static final Block NEOCALAMITES_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("neocalamites_trapdoor");//Loot Table done
	public static final Block NEOCALAMITES_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("neocalamites_fence_gate");//Loot Table done
	public static final Block NEOCALAMITES_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName("neocalamites_button");//Loot Table done
	public static final Block NEOCALAMITES_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("neocalamites_slab");//Loot Table done
	public static final Block NEOCALAMITES_SIGN = new PFStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.NEOCALAMITES).setRegistryName("neocalamites_sign");
	public static final Block NEOCALAMITES_WALL_SIGN = new PFWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), PFWoodTypes.NEOCALAMITES).setRegistryName("neocalamites_wall_sign");
	public static final Block NEOCALAMITES_MOSAIC = new Block(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("neocalamites_mosaic");//Loot Table done
	public static final Block NEOCALAMITES_MOSAIC_STAIRS = new StairsBlock(NEOCALAMITES_MOSAIC.getDefaultState(), Block.Properties.from(NEOCALAMITES_MOSAIC)).setRegistryName("neocalamites_mosaic_stairs");//Loot Table done
	public static final Block NEOCALAMITES_MOSAIC_SLAB = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("neocalamites_mosaic_slab");//Loot Table done

	
	//public static final Block MARMARTHIA = new MarmarthiaBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).tickRandomly()).setRegistryName("marmarthia");
	public static final Block FOSSIL_CRATE = new FossilCrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("fossil_crate");
	public static final Block TRILOPHOSAURUS_EGG = new TrilophosaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("trilophosaurus_egg");
	public static final Block PLESIOHADROS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("plesiohadros_crate");
	public static final Block PROTOCERATOPS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("protoceratops_crate");
	public static final Block VELOCIRAPTOR_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("velociraptor_crate");
	public static final Block ANKYLOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ankylosaurus_crate");
	public static final Block TRICERATOPS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("triceratops_crate");
	public static final Block TYRANNOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("tyrannosaurus_crate");
	public static final Block ALLOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("allosaurus_crate");
	public static final Block CERATOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ceratosaurus_crate");
	public static final Block STEGOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("stegosaurus_crate");
	public static final Block HERRERASAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("herrerasaurus_crate");
	public static final Block ISCHIGUALASTIA_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("ischigualastia_crate");
	public static final Block SAUROSUCHUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("saurosuchus_crate");
	public static final Block COELOPHYSIS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("coelophysis_crate");
	public static final Block DESMATOSUCHUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("desmatosuchus_crate");
	public static final Block POSTOSUCHUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("postosuchus_crate");
	public static final Block DILOPHOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("dilophosaurus_crate");
	public static final Block SARAHSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("sarahsaurus_crate");
	public static final Block SCELIDOSAURUS_CRATE = new CrateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName("scelidosaurus_crate");
	public static final Block CALSOYASUCHUS_EGG = new CalsoyasuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("calsoyasuchus_egg");
	public static final Block DESMATOSUCHUS_EGG = new DesmatosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("desmatosuchus_egg");
	public static final Block POSTOSUCHUS_EGG = new PostosuchusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("postosuchus_egg");
	public static final Block PLACERIAS_EGG = new PlaceriasEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("placerias_egg");
	public static final Block COELOPHYSIS_EGG = new CoelophysisEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("coelophysis_egg");
	public static final Block POPOSAURUS_EGG = new PoposaurusEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("poposaurus_egg");
	public static final Block TYPOTHORAX_EGG = new TypothoraxEggBlock(Block.Properties.create(Material.DRAGON_EGG).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.METAL).tickRandomly().notSolid()).setRegistryName("typothorax_egg");
	public static final Block CARVED_TUBER = new CarvedTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD)).setRegistryName("carved_tuber");
	public static final Block CARVED_TUBER_SOUL_LIT = new CarvedTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).setLightLevel((state) -> {
		return 10;
	})).setRegistryName("carved_tuber_soul_lit");
	public static final Block CARVED_TUBER_LIT = new CarvedTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).setLightLevel((state) -> {
		return 15;
	})).setRegistryName("carved_tuber_lit");
	public static final Block CARVED_TUBER_TIME_LIT = new CarvedTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).setLightLevel((state) -> {
		return 7;
	})).setRegistryName("carved_tuber_time_lit");
	public static final Block TUBER_BLOCK = new TuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD)).setRegistryName("tuber_block");
	public static final Block SMALL_CARVED_TUBER = new CarvedSmallTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("big_carved_tuber");
	public static final Block SMALL_CARVED_TUBER_SOUL_LIT = new CarvedSmallTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid().setLightLevel((state) -> {
		return 10;
	})).setRegistryName("big_carved_tuber_soul_lit");
	public static final Block SMALL_CARVED_TUBER_LIT = new CarvedSmallTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid().setLightLevel((state) -> {
		return 15;
	})).setRegistryName("big_carved_tuber_lit");
	public static final Block SMALL_CARVED_TUBER_TIME_LIT = new CarvedSmallTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid().setLightLevel((state) -> {
		return 7;
	})).setRegistryName("big_carved_tuber_time_lit");
	public static final Block SMALL_TUBER_BLOCK = new BigTuberBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()).setRegistryName("big_tuber_block");

	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "metasequoia_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(METASEQUOIA_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "araucaria_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(ARAUCARIA_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "liriodendrites_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(LIRIODENDRITES_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(PROTOPICEOXYLON_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "zamites_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(ZAMITES_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(PROTOJUNIPEROXYLON_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(HEIDIPHYLLUM_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> GINKGO_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "ginkgo_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(GINKGO_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "trochodendroides_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(TROCHODENDROIDES_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "brachyphyllum_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(BRACHYPHYLLUM_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> AGATHOXYLON_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "agathoxylon_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(AGATHOXYLON_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> WOODWORTHIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "woodworthia_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(WOODWORTHIA_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> SCHILDERIA_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "schilderia_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(SCHILDERIA_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> NEOCALAMITES_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "neocalamites_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(NEOCALAMITES_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "sandstone_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(SANDSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_TRIASSIC_SANDSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_sandstone_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(POLISHED_SANDSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> TRIASSIC_SANDSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "sandstone_brick_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(SANDSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "siltstone_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(SILTSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_JURASSIC_SILTSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_siltstone_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(POLISHED_SILTSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> JURASSIC_SILTSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "siltstone_brick_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(SILTSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chalk_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(CHALK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> POLISHED_CRETACEOUS_CHALK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polished_chalk_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(POLISHED_CHALK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> CRETACEOUS_CHALK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chalk_brick_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(CHALK_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(HENOSTONE_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "henostone_brick_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(HENOSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> HENOSTONE_DARK_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "dark_henostone_brick_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(DARK_HENOSTONE_BRICK_SLAB)), PFBuilding.instance);
	public static final RegistryObject<Block> THATCH_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "thatch_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(THATCH_SLAB)), PFBuilding.instance);

	public static final RegistryObject<Block> METASEQUOIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "metasequoia_vertical_planks", () -> new Block(AbstractBlock.Properties.from(METASEQUOIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "araucaria_vertical_planks", () -> new Block(AbstractBlock.Properties.from(ARAUCARIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "liriodendrites_vertical_planks", () -> new Block(AbstractBlock.Properties.from(LIRIODENDRITES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protopiceoxylon_vertical_planks", () -> new Block(AbstractBlock.Properties.from(PROTOPICEOXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "zamites_vertical_planks", () -> new Block(AbstractBlock.Properties.from(ZAMITES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "protojuniperoxylon_vertical_planks", () -> new Block(AbstractBlock.Properties.from(PROTOJUNIPEROXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "heidiphyllum_vertical_planks", () -> new Block(AbstractBlock.Properties.from(HEIDIPHYLLUM_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> GINKGO_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "ginkgo_vertical_planks", () -> new Block(AbstractBlock.Properties.from(GINKGO_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "trochodendroides_vertical_planks", () -> new Block(AbstractBlock.Properties.from(TROCHODENDROIDES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "brachyphyllum_vertical_planks", () -> new Block(AbstractBlock.Properties.from(BRACHYPHYLLUM_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> AGATHOXYLON_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "agathoxylon_vertical_planks", () -> new Block(AbstractBlock.Properties.from(AGATHOXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> WOODWORTHIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "woodworthia_vertical_planks", () -> new Block(AbstractBlock.Properties.from(WOODWORTHIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> SCHILDERIA_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "schilderia_vertical_planks", () -> new Block(AbstractBlock.Properties.from(SCHILDERIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> NEOCALAMITES_VERTICAL_PLANKS = HELPER.createCompatBlock("quark", "neocalamites_vertical_planks", () -> new Block(AbstractBlock.Properties.from(NEOCALAMITES_PLANKS)), PFBuilding.instance);

	public static final RegistryObject<Block> METASEQUOIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "metasequoia_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> ARAUCARIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "araucaria_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LEAF_CARPET = HELPER.createCompatBlock("quark", "liriodendrites_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protopiceoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "protojuniperoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LEAF_CARPET = HELPER.createCompatBlock("quark", "heidiphyllum_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> GINKGO_LEAF_CARPET = HELPER.createCompatBlock("quark", "ginkgo_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_LEAF_CARPET = HELPER.createCompatBlock("quark", "trochodendroides_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_LEAF_CARPET = HELPER.createCompatBlock("quark", "brachyphyllum_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> AGATHOXYLON_LEAF_CARPET = HELPER.createCompatBlock("quark", "agathoxylon_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> WOODWORTHIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "woodworthia_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);
	public static final RegistryObject<Block> SCHILDERIA_LEAF_CARPET = HELPER.createCompatBlock("quark", "schilderia_leaf_carpet", () -> new LeafCarpetBlock(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid()), PFDecoration.instance);

	public static final RegistryObject<Block> METASEQUOIA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "metasequoia_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> ARAUCARIA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "araucaria_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "liriodendrites_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> ZAMITES_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "zamites_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "protopiceoxylon_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "protojuniperoxylon_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "heidiphyllum_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> GINKGO_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "ginkgo_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "trochodendroides_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "brachyphyllum_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> AGATHOXYLON_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "agathoxylon_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> WOODWORTHIA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "woodworthia_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> SCHILDERIA_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "schilderia_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	public static final RegistryObject<Block> NEOCALAMITES_BEEHIVE = HELPER.createCompatBlock("buzzier_bees", "neocalamites_beehive", () -> new PFBeehiveBlock(Properties.from(Blocks.BEEHIVE)), PFDecoration.instance);
	
	public static final RegistryObject<Block> METASEQUOIA_BOOKSHELF = HELPER.createCompatBlock("quark", "metasequoia_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_BOOKSHELF = HELPER.createCompatBlock("quark", "araucaria_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_BOOKSHELF = HELPER.createCompatBlock("quark", "liriodendrites_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_BOOKSHELF = HELPER.createCompatBlock("quark", "zamites_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_BOOKSHELF = HELPER.createCompatBlock("quark", "protopiceoxylon_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_BOOKSHELF = HELPER.createCompatBlock("quark", "protojuniperoxylon_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_BOOKSHELF = HELPER.createCompatBlock("quark", "heidiphyllum_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> GINKGO_BOOKSHELF = HELPER.createCompatBlock("quark", "ginkgo_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_BOOKSHELF = HELPER.createCompatBlock("quark", "trochodendroides_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_BOOKSHELF = HELPER.createCompatBlock("quark", "brachyphyllum_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> AGATHOXYLON_BOOKSHELF = HELPER.createCompatBlock("quark", "agathoxylon_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> WOODWORTHIA_BOOKSHELF = HELPER.createCompatBlock("quark", "woodworthia_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> SCHILDERIA_BOOKSHELF = HELPER.createCompatBlock("quark", "schilderia_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	public static final RegistryObject<Block> NEOCALAMITES_BOOKSHELF = HELPER.createCompatBlock("quark", "neocalamites_bookshelf", () -> new PFBookshelfBlock(Properties.from(Blocks.BOOKSHELF)), PFBuilding.instance);
	
	public static final RegistryObject<Block> METASEQUOIA_LADDER = HELPER.createCompatBlock("quark", "metasequoia_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> ARAUCARIA_LADDER = HELPER.createCompatBlock("quark", "araucaria_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_LADDER = HELPER.createCompatBlock("quark", "liriodendrites_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> ZAMITES_LADDER = HELPER.createCompatBlock("quark", "zamites_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_LADDER = HELPER.createCompatBlock("quark", "protopiceoxylon_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_LADDER = HELPER.createCompatBlock("quark", "protojuniperoxylon_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_LADDER = HELPER.createCompatBlock("quark", "heidiphyllum_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> GINKGO_LADDER = HELPER.createCompatBlock("quark", "ginkgo_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_LADDER = HELPER.createCompatBlock("quark", "trochodendroides_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_LADDER = HELPER.createCompatBlock("quark", "brachyphyllum_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> AGATHOXYLON_LADDER = HELPER.createCompatBlock("quark", "agathoxylon_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> WOODWORTHIA_LADDER = HELPER.createCompatBlock("quark", "woodworthia_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> SCHILDERIA_LADDER = HELPER.createCompatBlock("quark", "schilderia_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);
	public static final RegistryObject<Block> NEOCALAMITES_LADDER = HELPER.createCompatBlock("quark", "neocalamites_ladder", () -> new PFLadderBlock(Properties.from(Blocks.LADDER)), PFDecoration.instance);

	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> METASEQUOIA_CHEST 	= HELPER.createCompatChestBlocks("metasequoia", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> ARAUCARIA_CHEST 	= HELPER.createCompatChestBlocks("araucaria", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> LIRIODENDRITES_CHEST 	= HELPER.createCompatChestBlocks("liriodendrites", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> ZAMITES_CHEST 	= HELPER.createCompatChestBlocks("zamites", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> PROTOPICEOXYLON_CHEST 	= HELPER.createCompatChestBlocks("protopiceoxylon", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> PROTOJUNIPEROXYLON_CHEST 	= HELPER.createCompatChestBlocks("protojuniperoxylon", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> HEIDIPHYLLUM_CHEST 	= HELPER.createCompatChestBlocks("heidiphyllum", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> GINKGO_CHEST 	= HELPER.createCompatChestBlocks("ginkgo", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> TROCHODENDROIDES_CHEST 	= HELPER.createCompatChestBlocks("trochodendroides", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> BRACHYPHYLLUM_CHEST 	= HELPER.createCompatChestBlocks("brachyphyllum", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> AGATHOXYLON_CHEST = HELPER.createCompatChestBlocks("agathoxylon", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> WOODWORTHIA_CHEST = HELPER.createCompatChestBlocks("woodworthia", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> SCHILDERIA_CHEST = HELPER.createCompatChestBlocks("schilderia", MaterialColor.WOOD);
	public static final Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> NEOCALAMITES_CHEST = HELPER.createCompatChestBlocks("neocalamites", MaterialColor.WOOD);

	public static final RegistryObject<Block> CHALK_PAVEMENT = HELPER.createCompatBlock("quark", "chalk_pavement", () -> new Block(AbstractBlock.Properties.from(CHALK_BRICKS)), PFBuilding.instance);
	public static final RegistryObject<Block> CHALK_PILLAR = HELPER.createCompatBlock("quark", "chalk_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(CHALK_BRICKS)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_PAVEMENT = HELPER.createCompatBlock("quark", "siltstone_pavement", () -> new Block(AbstractBlock.Properties.from(CHALK_BRICKS)), PFBuilding.instance);
	public static final RegistryObject<Block> SILTSTONE_PILLAR = HELPER.createCompatBlock("quark", "siltstone_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(CHALK_BRICKS)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_PAVEMENT = HELPER.createCompatBlock("quark", "sandstone_pavement", () -> new Block(AbstractBlock.Properties.from(CHALK_BRICKS)), PFBuilding.instance);
	public static final RegistryObject<Block> SANDSTONE_PILLAR = HELPER.createCompatBlock("quark", "sandstone_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(CHALK_BRICKS)), PFBuilding.instance);

	public static final RegistryObject<Block> METASEQUOIA_POST = HELPER.createCompatBlock("quark", "metasequoia_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_METASEQUOIA_POST = HELPER.createCompatBlock("quark", "stripped_metasequoia_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_POST = HELPER.createCompatBlock("quark", "araucaria_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_ARAUCARIA_POST = HELPER.createCompatBlock("quark", "stripped_araucaria_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_POST = HELPER.createCompatBlock("quark", "liriodendrites_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_LIRIODENDRITES_POST = HELPER.createCompatBlock("quark", "stripped_liriodendrites_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> ZAMITES_POST = HELPER.createCompatBlock("quark", "zamites_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_ZAMITES_POST = HELPER.createCompatBlock("quark", "stripped_zamites_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_POST = HELPER.createCompatBlock("quark", "protopiceoxylon_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_PROTOPICEOXYLON_POST = HELPER.createCompatBlock("quark", "stripped_protopiceoxylon_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_POST = HELPER.createCompatBlock("quark", "protojuniperoxylon_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_PROTOJUNIPEROXYLON_POST = HELPER.createCompatBlock("quark", "stripped_protojuniperoxylon_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_POST = HELPER.createCompatBlock("quark", "heidiphyllum_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_HEIDIPHYLLUM_POST = HELPER.createCompatBlock("quark", "stripped_heidiphyllum_post", () -> new WoodPostBlock(Properties.from(METASEQUOIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> GINKGO_POST = HELPER.createCompatBlock("quark", "ginkgo_post", () -> new WoodPostBlock(Properties.from(GINKGO_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_GINKGO_POST = HELPER.createCompatBlock("quark", "stripped_ginkgo_post", () -> new WoodPostBlock(Properties.from(GINKGO_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_POST = HELPER.createCompatBlock("quark", "trochodendroides_post", () -> new WoodPostBlock(Properties.from(TROCHODENDROIDES_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_TROCHODENDROIDES_POST = HELPER.createCompatBlock("quark", "stripped_trochodendroides_post", () -> new WoodPostBlock(Properties.from(TROCHODENDROIDES_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_POST = HELPER.createCompatBlock("quark", "brachyphyllum_post", () -> new WoodPostBlock(Properties.from(BRACHYPHYLLUM_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_BRACHYPHYLLUM_POST = HELPER.createCompatBlock("quark", "stripped_brachyphyllum_post", () -> new WoodPostBlock(Properties.from(BRACHYPHYLLUM_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> AGATHOXYLON_POST = HELPER.createCompatBlock("quark", "agathoxylon_post", () -> new WoodPostBlock(Properties.from(AGATHOXYLON_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_AGATHOXYLON_POS = HELPER.createCompatBlock("quark", "stripped_agathoxylon_post", () -> new WoodPostBlock(Properties.from(AGATHOXYLON_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> WOODWORTHIA_POST = HELPER.createCompatBlock("quark", "woodworthia_post", () -> new WoodPostBlock(Properties.from(WOODWORTHIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_WOODWORTHIA_POST = HELPER.createCompatBlock("quark", "stripped_woodworthia_post", () -> new WoodPostBlock(Properties.from(WOODWORTHIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> SCHILDERIA_POST = HELPER.createCompatBlock("quark", "schilderia_post", () -> new WoodPostBlock(Properties.from(SCHILDERIA_FENCE)), PFBuilding.instance);
	public static final RegistryObject<Block> STRIPPED_SCHILDERIA_POST = HELPER.createCompatBlock("quark", "stripped_schilderia_post", () -> new WoodPostBlock(Properties.from(SCHILDERIA_FENCE)), PFBuilding.instance);
	
	public static final RegistryObject<Block> METASEQUOIA_HEDGE = HELPER.createCompatBlock("quark", "metasequoia_hedge", () -> new HedgeBlock(Properties.from(METASEQUOIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> ARAUCARIA_HEDGE = HELPER.createCompatBlock("quark", "araucaria_hedge", () -> new HedgeBlock(Properties.from(ARAUCARIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> LIRIODENDRITES_HEDGE = HELPER.createCompatBlock("quark", "liriodendrites_hedge", () -> new HedgeBlock(Properties.from(LIRIODENDRITES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOPICEOXYLON_HEDGE = HELPER.createCompatBlock("quark", "protopiceoxylon_hedge", () -> new HedgeBlock(Properties.from(PROTOPICEOXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> PROTOJUNIPEROXYLON_HEDGE = HELPER.createCompatBlock("quark", "protojuniperoxylon_hedge", () -> new HedgeBlock(Properties.from(PROTOJUNIPEROXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> HEIDIPHYLLUM_HEDGE = HELPER.createCompatBlock("quark", "heidiphyllum_hedge", () -> new HedgeBlock(Properties.from(HEIDIPHYLLUM_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> GINKGO_HEDGE = HELPER.createCompatBlock("quark", "ginkgo_hedge", () -> new HedgeBlock(Properties.from(GINKGO_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> TROCHODENDROIDES_HEDGE = HELPER.createCompatBlock("quark", "trochodendroides_hedge", () -> new HedgeBlock(Properties.from(TROCHODENDROIDES_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> BRACHYPHYLLUM_HEDGE = HELPER.createCompatBlock("quark", "brachyphyllum_hedge", () -> new HedgeBlock(Properties.from(BRACHYPHYLLUM_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> AGATHOXYLON_HEDGE = HELPER.createCompatBlock("quark", "agathoxylon_hedge", () -> new HedgeBlock(Properties.from(AGATHOXYLON_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> WOODWORTHIA_HEDGE = HELPER.createCompatBlock("quark", "woodworthia_hedge", () -> new HedgeBlock(Properties.from(WOODWORTHIA_PLANKS)), PFBuilding.instance);
	public static final RegistryObject<Block> SCHILDERIA_HEDGE = HELPER.createCompatBlock("quark", "schilderia_hedge", () -> new HedgeBlock(Properties.from(SCHILDERIA_PLANKS)), PFBuilding.instance);

	private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
		return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> {
			return state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
		}).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	}

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
		event.getRegistry().register(VELOCIRAPTOR_EGG);
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
		event.getRegistry().register(PLANT_FIBER_BLOCK);
		event.getRegistry().register(THATCH);
		event.getRegistry().register(THATCH_SLAB);
		event.getRegistry().register(THATCH_STAIRS);
		event.getRegistry().register(TUBER_CROP);
		event.getRegistry().register(THATCH_CARPET);
		event.getRegistry().register(PROTOCERATOPS_EGG);
		event.getRegistry().register(CITIPATI_EGG);
		event.getRegistry().register(GINKGO_LOG);
		event.getRegistry().register(GINKGO_BUTTON);
		event.getRegistry().register(GINKGO_DOOR);
		event.getRegistry().register(GINKGO_FENCE);
		event.getRegistry().register(GINKGO_FENCE_GATE);
		event.getRegistry().register(GINKGO_PLANKS);
		event.getRegistry().register(GINKGO_PRESSURE_PLATE);
		event.getRegistry().register(GINKGO_SLAB);
		event.getRegistry().register(GINKGO_STAIRS);
		event.getRegistry().register(GINKGO_TRAPDOOR);
		event.getRegistry().register(GINKGO_WOOD);
		event.getRegistry().register(STRIPPED_GINKGO_LOG);
		event.getRegistry().register(STRIPPED_GINKGO_WOOD);
		event.getRegistry().register(GINKGO_LEAVES);
		event.getRegistry().register(GINKGO_SAPLING);
		event.getRegistry().register(POTTED_GINKGO_SAPLING);
		event.getRegistry().register(GINKGO_SIGN);
		event.getRegistry().register(GINKGO_WALL_SIGN);
		event.getRegistry().register(AEPYORNITHOMIMUS_EGG);
		event.getRegistry().register(TELMASAURUS_EGG);
		event.getRegistry().register(COBBANIA);
		event.getRegistry().register(TROCHODENDROIDES_LOG);
		event.getRegistry().register(TROCHODENDROIDES_BUTTON);
		event.getRegistry().register(TROCHODENDROIDES_DOOR);
		event.getRegistry().register(TROCHODENDROIDES_FENCE);
		event.getRegistry().register(TROCHODENDROIDES_FENCE_GATE);
		event.getRegistry().register(TROCHODENDROIDES_PLANKS);
		event.getRegistry().register(TROCHODENDROIDES_PRESSURE_PLATE);
		event.getRegistry().register(TROCHODENDROIDES_SLAB);
		event.getRegistry().register(TROCHODENDROIDES_STAIRS);
		event.getRegistry().register(TROCHODENDROIDES_TRAPDOOR);
		event.getRegistry().register(TROCHODENDROIDES_WOOD);
		event.getRegistry().register(STRIPPED_TROCHODENDROIDES_LOG);
		event.getRegistry().register(STRIPPED_TROCHODENDROIDES_WOOD);
		event.getRegistry().register(TROCHODENDROIDES_LEAVES);
		event.getRegistry().register(TROCHODENDROIDES_SAPLING);
		event.getRegistry().register(POTTED_TROCHODENDROIDES_SAPLING);
		event.getRegistry().register(TROCHODENDROIDES_SIGN);
		event.getRegistry().register(TROCHODENDROIDES_WALL_SIGN);
		event.getRegistry().register(PLESIOHADROS_EGG);
		event.getRegistry().register(PINACOSAURUS_EGG);
		event.getRegistry().register(BRACHYPHYLLUM_LOG);
		event.getRegistry().register(BRACHYPHYLLUM_BUTTON);
		event.getRegistry().register(BRACHYPHYLLUM_DOOR);
		event.getRegistry().register(BRACHYPHYLLUM_FENCE);
		event.getRegistry().register(BRACHYPHYLLUM_FENCE_GATE);
		event.getRegistry().register(BRACHYPHYLLUM_PLANKS);
		event.getRegistry().register(BRACHYPHYLLUM_PRESSURE_PLATE);
		event.getRegistry().register(BRACHYPHYLLUM_SLAB);
		event.getRegistry().register(BRACHYPHYLLUM_STAIRS);
		event.getRegistry().register(BRACHYPHYLLUM_TRAPDOOR);
		event.getRegistry().register(BRACHYPHYLLUM_WOOD);
		event.getRegistry().register(STRIPPED_BRACHYPHYLLUM_LOG);
		event.getRegistry().register(STRIPPED_BRACHYPHYLLUM_WOOD);
		event.getRegistry().register(BRACHYPHYLLUM_LEAVES);
		event.getRegistry().register(BRACHYPHYLLUM_SAPLING);
		event.getRegistry().register(POTTED_BRACHYPHYLLUM_SAPLING);
		event.getRegistry().register(BRACHYPHYLLUM_SIGN);
		event.getRegistry().register(BRACHYPHYLLUM_WALL_SIGN);
		event.getRegistry().register(OTOZAMITES);
		event.getRegistry().register(LAUROZAMITES);
		event.getRegistry().register(TALL_OTOZAMITES);
		event.getRegistry().register(ZAMITES_FROND);
		event.getRegistry().register(CLATHOPTERIS);
		event.getRegistry().register(DILOPHOSAURUS_EGG);
		event.getRegistry().register(SARAHSAURUS_EGG);
		event.getRegistry().register(SCELIDOSAURUS_EGG);
		event.getRegistry().register(POTTED_CLATHOPTERIS);
		event.getRegistry().register(POTTED_LAUROZAMITES);
		event.getRegistry().register(POTTED_OTOZAMITES);
		event.getRegistry().register(SCUTELLOSAURUS_EGG);
		event.getRegistry().register(MEGAPNOSAURUS_EGG);
		event.getRegistry().register(KAYENTATHERIUM_EGG);
		event.getRegistry().register(PHLEBOPTERIS);
		event.getRegistry().register(NEOCALAMITES);
		event.getRegistry().register(NEOCALAMITES_TOP);
		event.getRegistry().register(AGATHOXYLON_LOG);
		event.getRegistry().register(AGATHOXYLON_BUTTON);
		event.getRegistry().register(AGATHOXYLON_DOOR);
		event.getRegistry().register(AGATHOXYLON_FENCE);
		event.getRegistry().register(AGATHOXYLON_FENCE_GATE);
		event.getRegistry().register(AGATHOXYLON_PLANKS);
		event.getRegistry().register(AGATHOXYLON_PRESSURE_PLATE);
		event.getRegistry().register(AGATHOXYLON_SLAB);
		event.getRegistry().register(AGATHOXYLON_STAIRS);
		event.getRegistry().register(AGATHOXYLON_TRAPDOOR);
		event.getRegistry().register(AGATHOXYLON_WOOD);
		event.getRegistry().register(STRIPPED_AGATHOXYLON_LOG);
		event.getRegistry().register(STRIPPED_AGATHOXYLON_WOOD);
		event.getRegistry().register(AGATHOXYLON_LEAVES);
		event.getRegistry().register(AGATHOXYLON_SAPLING);
		event.getRegistry().register(POTTED_AGATHOXYLON_SAPLING);
		event.getRegistry().register(AGATHOXYLON_SIGN);
		event.getRegistry().register(AGATHOXYLON_WALL_SIGN);
		event.getRegistry().register(WOODWORTHIA_LOG);
		event.getRegistry().register(WOODWORTHIA_BUTTON);
		event.getRegistry().register(WOODWORTHIA_DOOR);
		event.getRegistry().register(WOODWORTHIA_FENCE);
		event.getRegistry().register(WOODWORTHIA_FENCE_GATE);
		event.getRegistry().register(WOODWORTHIA_PLANKS);
		event.getRegistry().register(WOODWORTHIA_PRESSURE_PLATE);
		event.getRegistry().register(WOODWORTHIA_SLAB);
		event.getRegistry().register(WOODWORTHIA_STAIRS);
		event.getRegistry().register(WOODWORTHIA_TRAPDOOR);
		event.getRegistry().register(WOODWORTHIA_WOOD);
		event.getRegistry().register(STRIPPED_WOODWORTHIA_LOG);
		event.getRegistry().register(STRIPPED_WOODWORTHIA_WOOD);
		event.getRegistry().register(WOODWORTHIA_LEAVES);
		event.getRegistry().register(WOODWORTHIA_SAPLING);
		event.getRegistry().register(POTTED_WOODWORTHIA_SAPLING);
		event.getRegistry().register(WOODWORTHIA_SIGN);
		event.getRegistry().register(WOODWORTHIA_WALL_SIGN);
		event.getRegistry().register(SCHILDERIA_LOG);
		event.getRegistry().register(SCHILDERIA_BUTTON);
		event.getRegistry().register(SCHILDERIA_DOOR);
		event.getRegistry().register(SCHILDERIA_FENCE);
		event.getRegistry().register(SCHILDERIA_FENCE_GATE);
		event.getRegistry().register(SCHILDERIA_PLANKS);
		event.getRegistry().register(SCHILDERIA_PRESSURE_PLATE);
		event.getRegistry().register(SCHILDERIA_SLAB);
		event.getRegistry().register(SCHILDERIA_STAIRS);
		event.getRegistry().register(SCHILDERIA_TRAPDOOR);
		event.getRegistry().register(SCHILDERIA_WOOD);
		event.getRegistry().register(STRIPPED_SCHILDERIA_LOG);
		event.getRegistry().register(STRIPPED_SCHILDERIA_WOOD);
		event.getRegistry().register(SCHILDERIA_LEAVES);
		event.getRegistry().register(SCHILDERIA_SAPLING);
		event.getRegistry().register(POTTED_SCHILDERIA_SAPLING);
		event.getRegistry().register(SCHILDERIA_SIGN);
		event.getRegistry().register(SCHILDERIA_WALL_SIGN);
		event.getRegistry().register(POTTED_PHLEBOPTERIS);
		event.getRegistry().register(POTTED_NEOCALAMITES);
		//event.getRegistry().register(MARMARTHIA);
		event.getRegistry().register(FOSSIL_CRATE);
		event.getRegistry().register(PROTOCERATOPS_CRATE);
		event.getRegistry().register(VELOCIRAPTOR_CRATE);
		event.getRegistry().register(ANKYLOSAURUS_CRATE);
		event.getRegistry().register(TRICERATOPS_CRATE);
		event.getRegistry().register(TYRANNOSAURUS_CRATE);
		event.getRegistry().register(ALLOSAURUS_CRATE);
		event.getRegistry().register(CERATOSAURUS_CRATE);
		event.getRegistry().register(STEGOSAURUS_CRATE);
		event.getRegistry().register(HERRERASAURUS_CRATE);
		event.getRegistry().register(ISCHIGUALASTIA_CRATE);
		event.getRegistry().register(SAUROSUCHUS_CRATE);
		event.getRegistry().register(COELOPHYSIS_CRATE);
		event.getRegistry().register(SARAHSAURUS_CRATE);
		event.getRegistry().register(TRILOPHOSAURUS_EGG);
		event.getRegistry().register(CALSOYASUCHUS_EGG);
		event.getRegistry().register(DESMATOSUCHUS_EGG);
		event.getRegistry().register(POSTOSUCHUS_EGG);
		event.getRegistry().register(PLACERIAS_EGG);
		event.getRegistry().register(COELOPHYSIS_EGG);
		event.getRegistry().register(POPOSAURUS_EGG);
		event.getRegistry().register(TYPOTHORAX_EGG);
		event.getRegistry().register(PLESIOHADROS_CRATE);
		event.getRegistry().register(DESMATOSUCHUS_CRATE);
		event.getRegistry().register(POSTOSUCHUS_CRATE);
		event.getRegistry().register(CARVED_TUBER);
		event.getRegistry().register(CARVED_TUBER_LIT);
		event.getRegistry().register(CARVED_TUBER_SOUL_LIT);
		event.getRegistry().register(CARVED_TUBER_TIME_LIT);
		event.getRegistry().register(TUBER_BLOCK);
		event.getRegistry().register(SMALL_CARVED_TUBER);
		event.getRegistry().register(SMALL_CARVED_TUBER_LIT);
		event.getRegistry().register(SMALL_CARVED_TUBER_SOUL_LIT);
		event.getRegistry().register(SMALL_CARVED_TUBER_TIME_LIT);
		event.getRegistry().register(SMALL_TUBER_BLOCK);
		event.getRegistry().register(NEOCALAMITES_BUTTON);
		event.getRegistry().register(NEOCALAMITES_DOOR);
		event.getRegistry().register(NEOCALAMITES_FENCE);
		event.getRegistry().register(NEOCALAMITES_FENCE_GATE);
		event.getRegistry().register(NEOCALAMITES_PLANKS);
		event.getRegistry().register(NEOCALAMITES_PRESSURE_PLATE);
		event.getRegistry().register(NEOCALAMITES_SLAB);
		event.getRegistry().register(NEOCALAMITES_STAIRS);
		event.getRegistry().register(NEOCALAMITES_TRAPDOOR);
		event.getRegistry().register(NEOCALAMITES_SIGN);
		event.getRegistry().register(NEOCALAMITES_WALL_SIGN);
		event.getRegistry().register(NEOCALAMITES_MOSAIC);
		event.getRegistry().register(NEOCALAMITES_MOSAIC_SLAB);
		event.getRegistry().register(NEOCALAMITES_MOSAIC_STAIRS);
		event.getRegistry().register(DILOPHOSAURUS_CRATE);
		event.getRegistry().register(SCELIDOSAURUS_CRATE);
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
			RenderTypeLookup.setRenderLayer(TALL_OTOZAMITES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(OTOZAMITES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LAUROZAMITES, cutoutRenderType);
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
			RenderTypeLookup.setRenderLayer(ZAMITES_FROND, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TUBER_CROP, cutoutRenderType);
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
			RenderTypeLookup.setRenderLayer(GINKGO_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_GINKGO_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(COBBANIA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_TROCHODENDROIDES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_AGATHOXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_WOODWORTHIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_LEAVES, cutoutRenderType);
			//RenderTypeLookup.setRenderLayer(MARMARTHIA, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_BRACHYPHYLLUM_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_LEAVES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_SCHILDERIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_SAPLING, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_TRAPDOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_LAUROZAMITES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_OTOZAMITES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES_DOOR, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES_TRAPDOOR, cutoutRenderType);

			RenderTypeLookup.setRenderLayer(ARAUCARIA_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(ZAMITES_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_LADDER.get(), cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES_LADDER.get(), cutoutRenderType);

			RenderTypeLookup.setRenderLayer(ARAUCARIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_LEAF_CARPET.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_LEAF_CARPET.get(), mippedRenderType);

			RenderTypeLookup.setRenderLayer(ARAUCARIA_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(METASEQUOIA_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(LIRIODENDRITES_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOPICEOXYLON_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(PROTOJUNIPEROXYLON_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(HEIDIPHYLLUM_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_HEDGE.get(), mippedRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_HEDGE.get(), mippedRenderType);

			RenderTypeLookup.setRenderLayer(CLATHOPTERIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_CLATHOPTERIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_PHLEBOPTERIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(POTTED_NEOCALAMITES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(PHLEBOPTERIS, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES_TOP, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SMALL_TUBER_BLOCK, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SMALL_CARVED_TUBER, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SMALL_CARVED_TUBER_TIME_LIT, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SMALL_CARVED_TUBER_SOUL_LIT, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SMALL_CARVED_TUBER_LIT, cutoutRenderType);

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
			RenderTypeLookup.setRenderLayer(GINKGO_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(GINKGO_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(TROCHODENDROIDES_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(BRACHYPHYLLUM_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(AGATHOXYLON_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(WOODWORTHIA_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(SCHILDERIA_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(NEOCALAMITES_WALL_SIGN, cutoutRenderType);
			RenderTypeLookup.setRenderLayer(THATCH, RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(THATCH_STAIRS, mippedRenderType);
			RenderTypeLookup.setRenderLayer(THATCH_SLAB, mippedRenderType);
			RenderTypeLookup.setRenderLayer(THATCH_VERTICAL_SLAB.get(), mippedRenderType);
		}
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		//Log, Stripped Log, Wood, Stripped Wood, Planks, Stairs, Slab, Fence, Fence Gate, Trapdoor, Door, Button, Pressure Plate
		//Metasequoia
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_METASEQUOIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_metasequoia_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_METASEQUOIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_metasequoia_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("metasequoia_slab"));
		//Araucaria
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_ARAUCARIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_araucaria_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_ARAUCARIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_araucaria_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("araucaria_slab"));
		//Liriodendrites
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_LIRIODENDRITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_liriodendrites_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_LIRIODENDRITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_liriodendrites_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("liriodendrites_slab"));
		//Protopiceoxylon
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_PROTOPICEOXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protopiceoxylon_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_PROTOPICEOXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protopiceoxylon_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protopiceoxylon_slab"));
		//Zamites
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_ZAMITES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_zamites_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_ZAMITES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_zamites_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("zamites_slab"));
		//Protojuniperoxylon
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protojuniperoxylon_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_PROTOJUNIPEROXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_protojuniperoxylon_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("protojuniperoxylon_slab"));
		//Heidiphyllum
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_HEIDIPHYLLUM_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_heidiphyllum_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_HEIDIPHYLLUM_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_heidiphyllum_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("heidiphyllum_slab"));
		//Ginkgo
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("ginkgo_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_GINKGO_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_ginkgo_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("ginkgo_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_GINKGO_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_ginkgo_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("ginkgo_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("ginkgo_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("ginkgo_slab"));	
		//Trochodendroides
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("trochodendroides_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_TROCHODENDROIDES_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_trochodendroides_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("trochodendroides_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_TROCHODENDROIDES_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_trochodendroides_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("trochodendroides_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("trochodendroides_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("trochodendroides_slab"));	
		//Brachyphyllum
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("brachyphyllum_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_BRACHYPHYLLUM_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_brachyphyllum_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("brachyphyllum_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_BRACHYPHYLLUM_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_brachyphyllum_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("brachyphyllum_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("brachyphyllum_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("brachyphyllum_slab"));	
		//Agathoxylon
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("agathoxylon_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_AGATHOXYLON_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_agathoxylon_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("agathoxylon_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_AGATHOXYLON_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_agathoxylon_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("agathoxylon_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("agathoxylon_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("agathoxylon_slab"));
		//Woodworthia
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("woodworthia_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_WOODWORTHIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_woodworthia_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("woodworthia_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_WOODWORTHIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_woodworthia_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("woodworthia_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("woodworthia_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("woodworthia_slab"));
		//Schilderia
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("schilderia_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_SCHILDERIA_LOG, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_schilderia_log"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("schilderia_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.STRIPPED_SCHILDERIA_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("stripped_schilderia_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("schilderia_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("schilderia_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("schilderia_slab"));
		//Neocalamites
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_PLANKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("neocalamites_planks"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("neocalamites_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("neocalamites_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_MOSAIC, new Item.Properties().group(PFBuilding.instance)).setRegistryName("neocalamites_mosaic"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_MOSAIC_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("neocalamites_mosaic_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_MOSAIC_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("neocalamites_mosaic_slab"));
		//Sandstone
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_FOSSIL, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_fossil"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMOOTH_SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("smooth_sandstone"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_sandstone"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_SANDSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_sandstone_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_SANDSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_sandstone_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_BRICKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_bricks"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_brick_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("sandstone_brick_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHISELED_SANDSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chiseled_sandstone"));
		//Siltstone
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_FOSSIL, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_fossil"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMOOTH_SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("smooth_siltstone"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_siltstone"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_SILTSTONE_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_siltstone_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_SILTSTONE_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_siltstone_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_BRICKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_bricks"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_brick_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("siltstone_brick_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHISELED_SILTSTONE, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chiseled_siltstone"));

		//Chalk
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_FOSSIL, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_fossil"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMOOTH_CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("smooth_chalk"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_chalk"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_CHALK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_chalk_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_CHALK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_chalk_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_BRICKS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_bricks"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_BRICK_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_brick_slab"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_BRICK_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chalk_brick_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHISELED_CHALK, new Item.Properties().group(PFBuilding.instance)).setRegistryName("chiseled_chalk"));

		//Dirts
		event.getRegistry().register(new BlockItem(PFBlocks.MOSSY_DIRT, new Item.Properties().group(PFBuilding.instance)).setRegistryName("mossy_dirt"));
		event.getRegistry().register(new BlockItem(PFBlocks.LOAM, new Item.Properties().group(PFBuilding.instance)).setRegistryName("loam"));
		event.getRegistry().register(new BlockItem(PFBlocks.PACKED_LOAM, new Item.Properties().group(PFBuilding.instance)).setRegistryName("packed_loam"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILT, new Item.Properties().group(PFBuilding.instance)).setRegistryName("silt"));
		event.getRegistry().register(new BlockItem(PFBlocks.HARDENED_SILT, new Item.Properties().group(PFBuilding.instance)).setRegistryName("hardened_silt"));

		//PlasteredAmmonites,PetrifiedWood
		event.getRegistry().register(new BlockItem(PFBlocks.PLASTERED_AMMONITES, new Item.Properties().group(PFBuilding.instance)).setRegistryName("plastered_ammonites"));
		event.getRegistry().register(new BlockItem(PFBlocks.PETRIFIED_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("petrified_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.POLISHED_PETRIFIED_WOOD, new Item.Properties().group(PFBuilding.instance)).setRegistryName("polished_petrified_wood"));

		//Leaves
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_leaves"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_LEAVES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_leaves"));

		//Saplings
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_sapling"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_SAPLING, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_sapling"));

		//Plants
		event.getRegistry().register(new BlockItem(PFBlocks.HORSETAIL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("horsetail"));
		event.getRegistry().register(new BlockItem(PFBlocks.TALL_HORSETAIL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_horsetail"));
		event.getRegistry().register(new BlockItem(PFBlocks.OSMUNDA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("osmunda"));
		event.getRegistry().register(new BlockItem(PFBlocks.TALL_OSMUNDA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_osmunda"));
		event.getRegistry().register(new BlockItem(PFBlocks.CLUBMOSS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("clubmoss"));
		event.getRegistry().register(new BlockItem(PFBlocks.MARCHANTIA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("marchantia"));
		event.getRegistry().register(new BlockItem(PFBlocks.CONIOPTERIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("coniopteris"));
		event.getRegistry().register(new BlockItem(PFBlocks.OSMUNDACAULIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("osmundacaulis"));
		event.getRegistry().register(new BlockItem(PFBlocks.TALL_OSMUNDACAULIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_osmundacaulis"));
		event.getRegistry().register(new BlockItem(PFBlocks.DICROIDIUM, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dicroidium"));
		event.getRegistry().register(new BlockItem(PFBlocks.JOHNSTONIA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("johnstonia"));
		event.getRegistry().register(new BlockItem(PFBlocks.CLADOPHLEBIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("cladophlebis"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCYTOPHYLLUM, new Item.Properties().group(PFDecoration.instance)).setRegistryName("scytophyllum"));
		event.getRegistry().register(new BlockItem(PFBlocks.MICHELILLOA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("michelilloa"));
		event.getRegistry().register(new BlockItem(PFBlocks.DEAD_OSMUNDACAULIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dead_osmundacaulis"));
		event.getRegistry().register(new CobbaniaItem(PFBlocks.COBBANIA, new Item.Properties().group(PFDecoration.instance)).setRegistryName("cobbania"));
		event.getRegistry().register(new BlockItem(PFBlocks.OTOZAMITES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("otozamites"));
		event.getRegistry().register(new BlockItem(PFBlocks.TALL_OTOZAMITES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tall_otozamites"));
		event.getRegistry().register(new BlockItem(PFBlocks.LAUROZAMITES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("laurozamites"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_FROND, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_fronds"));
		event.getRegistry().register(new BlockItem(PFBlocks.CLATHOPTERIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("clathopteris"));
		event.getRegistry().register(new BlockItem(PFBlocks.PHLEBOPTERIS, new Item.Properties().group(PFDecoration.instance)).setRegistryName("phlebopteris"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites"));

		//Carpets
		event.getRegistry().register(new BlockItem(PFBlocks.MOSS_CARPET, new Item.Properties().group(PFDecoration.instance)).setRegistryName("moss_carpet"));
		event.getRegistry().register(new BlockItem(PFBlocks.ALGAE_CARPET, new Item.Properties().group(PFDecoration.instance)).setRegistryName("algae_carpet"));
		event.getRegistry().register(new BlockItem(PFBlocks.THATCH_CARPET, new Item.Properties().group(PFDecoration.instance)).setRegistryName("thatch_carpet"));

		//Walls
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("sandstone_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMOOTH_SANDSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("smooth_sandstone_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.SANDSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("sandstone_brick_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("siltstone_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMOOTH_SILTSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("smooth_siltstone_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILTSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("siltstone_brick_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("chalk_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMOOTH_CHALK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("smooth_chalk_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.CHALK_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("chalk_brick_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.HENOSTONE_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("henostone_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.HENOSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("henostone_brick_wall"));
		event.getRegistry().register(new BlockItem(PFBlocks.DARK_HENOSTONE_BRICK_WALL, new Item.Properties().group(PFDecoration.instance)).setRegistryName("dark_henostone_brick_wall"));

		//Doors(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_door")); 		
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_door"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_DOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites_door"));

		//Trapdoors(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_trapdoor"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_TRAPDOOR, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites_trapdoor"));

		//Fences(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_fence"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_FENCE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites_fence"));

		//Fencegates(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_fence_gate"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_FENCE_GATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites_fence_gate"));

		//Button(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_button"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_BUTTON, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites_button"));

		//PressurePlates(Metasequoia,Araucarua,Liriodendrites,Protopiceoxylon,Zamites,Protojuniperoxylon,Heidiphyllum)
		event.getRegistry().register(new BlockItem(PFBlocks.METASEQUOIA_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("metasequoia_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.ARAUCARIA_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("araucaria_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.LIRIODENDRITES_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("liriodendrites_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOPICEOXYLON_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protopiceoxylon_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.ZAMITES_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("zamites_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOJUNIPEROXYLON_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("protojuniperoxylon_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.HEIDIPHYLLUM_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("heidiphyllum_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.GINKGO_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ginkgo_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.TROCHODENDROIDES_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("trochodendroides_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.BRACHYPHYLLUM_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("brachyphyllum_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.AGATHOXYLON_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("agathoxylon_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.WOODWORTHIA_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("woodworthia_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCHILDERIA_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("schilderia_pressure_plate"));
		event.getRegistry().register(new BlockItem(PFBlocks.NEOCALAMITES_PRESSURE_PLATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("neocalamites_pressure_plate"));

		//Ptilophyllum
		event.getRegistry().register(new BlockItem(PFBlocks.PTILOPHYLLUM_WOOD, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ptilophyllum_wood"));
		event.getRegistry().register(new BlockItem(PFBlocks.PTILOPHYLLUM_BASE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("ptilophyllum_base"));

		//IDunno
		event.getRegistry().register(new BlockItem(PFBlocks.MOSS_BLOCK, new Item.Properties().group(PFDecoration.instance)).setRegistryName("moss_block"));
		event.getRegistry().register(new BlockItem(PFBlocks.PLANT_FIBER_BLOCK, new Item.Properties().group(PFDecoration.instance)).setRegistryName("plant_fiber_block"));
		event.getRegistry().register(new BlockItem(PFBlocks.THATCH, new Item.Properties().group(PFBuilding.instance)).setRegistryName("thatch"));
		event.getRegistry().register(new BlockItem(PFBlocks.THATCH_STAIRS, new Item.Properties().group(PFBuilding.instance)).setRegistryName("thatch_stairs"));
		event.getRegistry().register(new BlockItem(PFBlocks.THATCH_SLAB, new Item.Properties().group(PFBuilding.instance)).setRegistryName("thatch_slab"));

		event.getRegistry().register(new BlockItem(PFBlocks.PORTAL_FRAME, new Item.Properties().group(PFDecoration.instance)).setRegistryName("portal_frame"));
		event.getRegistry().register(new BlockItem(PFBlocks.HENOSTONE_TRAP, new Item.Properties().group(PFDecoration.instance)).setRegistryName("henostone_trap"));

		event.getRegistry().register(new BlockItem(PFBlocks.PALEONTOLOGY_TABLE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("paleontology_table"));
		event.getRegistry().register(new BlockItem(PFBlocks.PALEOSCRIBE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("paleoscribe"));
		event.getRegistry().register(new BlockItem(PFBlocks.FOSSIL_CRATE, new Item.Properties().group(PFDecoration.instance)).setRegistryName("fossil_crate"));

		event.getRegistry().register(new BlockItem(PFBlocks.GIANT_AMMONITE_SHELL_BB, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_bb"));
		event.getRegistry().register(new BlockItem(PFBlocks.GIANT_AMMONITE_SHELL_BF, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_bf"));
		event.getRegistry().register(new BlockItem(PFBlocks.GIANT_AMMONITE_SHELL_TB, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_tb"));
		event.getRegistry().register(new BlockItem(PFBlocks.GIANT_AMMONITE_SHELL_TF, new Item.Properties().group(PFDecoration.instance)).setRegistryName("giant_ammonite_fossil_piece_tf"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMALL_TUBER_BLOCK, new Item.Properties().group(PFDecoration.instance)).setRegistryName("big_tuber_block"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMALL_CARVED_TUBER, new Item.Properties().group(PFDecoration.instance)).setRegistryName("big_carved_tuber"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMALL_CARVED_TUBER_LIT, new Item.Properties().group(PFDecoration.instance)).setRegistryName("big_carved_tuber_lit"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMALL_CARVED_TUBER_SOUL_LIT, new Item.Properties().group(PFDecoration.instance)).setRegistryName("big_carved_tuber_soul_lit"));
		event.getRegistry().register(new BlockItem(PFBlocks.SMALL_CARVED_TUBER_TIME_LIT, new Item.Properties().group(PFDecoration.instance)).setRegistryName("big_carved_tuber_time_lit"));

		event.getRegistry().register(new BlockItem(PFBlocks.TUBER_BLOCK, new Item.Properties().group(PFDecoration.instance)).setRegistryName("tuber_block"));
		event.getRegistry().register(new BlockItem(PFBlocks.CARVED_TUBER, new Item.Properties().group(PFDecoration.instance)).setRegistryName("carved_tuber"));
		event.getRegistry().register(new BlockItem(PFBlocks.CARVED_TUBER_LIT, new Item.Properties().group(PFDecoration.instance)).setRegistryName("carved_tuber_lit"));
		event.getRegistry().register(new BlockItem(PFBlocks.CARVED_TUBER_SOUL_LIT, new Item.Properties().group(PFDecoration.instance)).setRegistryName("carved_tuber_soul_lit"));
		event.getRegistry().register(new BlockItem(PFBlocks.CARVED_TUBER_TIME_LIT, new Item.Properties().group(PFDecoration.instance)).setRegistryName("carved_tuber_time_lit"));

		//Eggs

		//Aepyornithomimus Citipati Pinacosaurus Plesiohadros Protoceratops Telmasaurus Velociraptor
		//Ankylosaurus Basilemys Cyclurus Dakotaraptor Didelphodon Gar Myledaphus Thescelosaurus Triceratops Tyrannosaurus
		//Dilophosaurus Sarahsaurus Scelidosaurus
		//Allosaurus Camarasaurus Ceratodus Ceratosaurus Dryosaurus Eilenodon Hesperonithoides Potamoceratodus Stegosaurus
		//
		//Chromogisaurus Exaeretodon Herrerasaurus Hyperodapedon Ischigualastia Saurosuchus Sillosuchus
		//Djadochta
		event.getRegistry().register(new BlockItem(PFBlocks.AEPYORNITHOMIMUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("aepyornithomimus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.CITIPATI_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("citipati_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.PINACOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("pinacosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.PLESIOHADROS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("plesiohadros_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.PROTOCERATOPS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("protoceratops_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.TELMASAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("telmasaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.VELOCIRAPTOR_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("velociraptor_egg"));

		//Hell Creek
		event.getRegistry().register(new BlockItem(PFBlocks.ANKYLOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("ankylosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.BASILEMYS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("basilemys_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.DAKOTARAPTOR_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("dakotaraptor_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.THESCELOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("thescelosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.TRICERATOPS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("triceratops_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.TYRANNOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("tyrannosaurus_egg"));

		//Kayenta
		event.getRegistry().register(new BlockItem(PFBlocks.CALSOYASUCHUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("calsoyasuchus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.DILOPHOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("dilophosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.KAYENTATHERIUM_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("kayentatherium_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.MEGAPNOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("megapnosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.SARAHSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("sarahsaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCELIDOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("scelidosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.SCUTELLOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("scutellosaurus_egg"));

		//Morrison
		event.getRegistry().register(new BlockItem(PFBlocks.ALLOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("allosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.CAMARASAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("camarasaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.CERATOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("ceratosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.DRYOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("dryosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.EILENODON_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("eilenodon_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.HESPERORNITHOIDES_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("hesperornithoides_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.STEGOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("stegosaurus_egg"));

		//Chinle
		event.getRegistry().register(new BlockItem(PFBlocks.COELOPHYSIS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("coelophysis_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.DESMATOSUCHUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("desmatosuchus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.PLACERIAS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("placerias_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.POPOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("poposaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.POSTOSUCHUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("postosuchus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.TRILOPHOSAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("trilophosaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.TYPOTHORAX_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("typothorax_egg"));
		//Ischigualasto
		event.getRegistry().register(new BlockItem(PFBlocks.CHROMOGISAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("chromogisaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.EXAERETODON_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("exaeretodon_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.HERRERASAURUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("herrerasaurus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.HYPERODAPEDON_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("hyperodapedon_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.ISCHIGUALASTIA_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("ischigualastia_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.SAUROSUCHUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("saurosuchus_egg"));
		event.getRegistry().register(new BlockItem(PFBlocks.SILLOSUCHUS_EGG, new Item.Properties().group(PFMisc.instance)).setRegistryName("sillosuchus_egg"));

	}

}