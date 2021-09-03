package superlord.prehistoricfauna.world.structure;

import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFLootTables;
import superlord.prehistoricfauna.init.PFStructures;

public class PortalChamberStructure extends Structure<NoFeatureConfig> {

	public PortalChamberStructure(Codec<NoFeatureConfig> codec) {
		super(codec);
		this.setRegistryName(PrehistoricFauna.MOD_ID + ":portal_chamber");
	}

	public String getStructureName() {
		return PrehistoricFauna.MOD_ID + ":portal_chamber";
	}

	@Override
	public GenerationStage.Decoration getDecorationStage() {
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}

	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return PortalChamberStructure.Start::new;
	}

	public static class Start extends StructureStart<NoFeatureConfig> {
		public Start(Structure<NoFeatureConfig> structure, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int reference, long seed) {
			super(structure, chunkX, chunkZ, mutableBoundingBox, reference, seed);
		}

		@Override
		public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biome, NoFeatureConfig config) {
			Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;
			int surfaceY = Math.max(generator.getNoiseHeight(x + 12, z + 12, Heightmap.Type.WORLD_SURFACE_WG) - 1, generator.getGroundHeight() - 1);
			int belowGround = rand.nextInt(40) + 20;
			if (surfaceY - belowGround < 0) {
				belowGround = rand.nextInt(20) + 10;
			}
			BlockPos blockpos = new BlockPos(x, surfaceY - belowGround, z);
			Piece.start(templateManager, blockpos, rotation, this.components, this.rand);
			this.recalculateStructureSize();
		}
	}

	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;
		private static final BlockPos OFFSET = new BlockPos(0, 1, 0);

		public Piece(TemplateManager templateManager, ResourceLocation resourceLocation, BlockPos pos, Rotation rotation) {
			super(PFStructures.PORTAL_CHAMBER_PIECE_TYPE, 0);
			this.resourceLocation = resourceLocation;
            BlockPos blockpos = OFFSET;
            this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			this.rotation = rotation;
			this.setupPiece(templateManager);
		}

		public Piece(TemplateManager templateManager, CompoundNBT compound) {
			super(PFStructures.PORTAL_CHAMBER_PIECE_TYPE, compound);
			this.resourceLocation = new ResourceLocation(compound.getString("Template"));
			this.rotation = Rotation.valueOf(compound.getString("Rot"));
			this.setupPiece(templateManager);
		}

		public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
			int x = pos.getX();
			int z = pos.getZ();
            BlockPos blockpos = OFFSET;
			BlockPos rotationOffset = blockpos.rotate(rotation);
			BlockPos blockPos = rotationOffset.add(x, pos.getY(), z);
			pieceList.add(new Piece(templateManager, new ResourceLocation(PrehistoricFauna.MOD_ID, "portal_chamber"), blockPos, rotation));
		}

		private void setupPiece(TemplateManager templateManager) {
			Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
			PlacementSettings placementSettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
			this.setup(template, this.templatePosition, placementSettings);
		}

		@Override
		protected void readAdditional(CompoundNBT compound) {
			super.readAdditional(compound);
			compound.putString("Template", this.resourceLocation.toString());
			compound.putString("Rot", this.rotation.name());
		}

		@Override
		public boolean func_230383_a_(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random random, MutableBoundingBox structureBoundingBox, ChunkPos chunkPos, BlockPos blockPos) {
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
			BlockPos blockpos = OFFSET;
			this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
			return super.func_230383_a_(seedReader, structureManager, chunkGenerator, random, structureBoundingBox, chunkPos, blockPos);
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IServerWorld world, Random rand, MutableBoundingBox sbb) {
			if (function.startsWith("Chest")) {
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
				BlockPos blockpos = pos.down();
				if (sbb.isVecInside(blockpos)) {
					LockableLootTileEntity.setLootTable(world, rand, blockpos, PFLootTables.HELL_CREEK_LOOT_TABLE);
				}
			}
			if (function.startsWith("barrel")) {
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
				BlockPos blockpos = pos.down();
				if (sbb.isVecInside(blockpos)) {
					LockableLootTileEntity.setLootTable(world, rand, blockpos, PFLootTables.TIME_TEMPLE_LOOT_TABLE);
				}
			}
		}
	}

}
