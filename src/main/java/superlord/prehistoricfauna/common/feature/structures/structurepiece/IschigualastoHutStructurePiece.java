package superlord.prehistoricfauna.common.feature.structures.structurepiece;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFStructures;

public class IschigualastoHutStructurePiece {

	private static final ResourceLocation ischigualastoHut_Template = new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualasto_hut");

	private static final Map<ResourceLocation, BlockPos> structurePos = ImmutableMap.of(ischigualastoHut_Template, BlockPos.ZERO);

	static final BlockPos PIVOT = new BlockPos(9, 0, 9);

	public static void addStructure(StructureManager manager, BlockPos pos, Rotation rotation, StructurePieceAccessor accessor, Random random) {
		accessor.addPiece(new Piece(manager, ischigualastoHut_Template, pos, rotation, 0));
	}

	public static class Piece extends TemplateStructurePiece {
		public Piece(StructureManager manager, ResourceLocation location, BlockPos pos, Rotation rotation, int position) {
			super(PFStructures.ISCHIGUALASTO_HUT_PIECE, 0, manager, location, location.toString(), makeSettings(rotation), makePosition(location, pos, position));
		}

		public Piece(StructureManager manager, CompoundTag tag) {
			super(PFStructures.ISCHIGUALASTO_HUT_PIECE, tag, manager, (position) -> {
				return makeSettings(Rotation.valueOf(tag.getString("Rot")));
			});
		}

		private static StructurePlaceSettings makeSettings(Rotation p_163156_) {
			BlockIgnoreProcessor blockignoreprocessor = BlockIgnoreProcessor.STRUCTURE_BLOCK;

			StructurePlaceSettings structureplacesettings = (new StructurePlaceSettings()).setRotation(p_163156_).setMirror(Mirror.NONE).setRotationPivot(PIVOT).addProcessor(blockignoreprocessor).addProcessor(new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE));


			return structureplacesettings;
		}

		private static BlockPos makePosition(ResourceLocation p_162453_, BlockPos p_162454_, int p_162455_) {
			return p_162454_.offset(structurePos.get(p_162453_)).below(p_162455_);
		}

		protected void addAdditionalSaveData(StructurePieceSerializationContext p_162444_, CompoundTag p_162445_) {
			super.addAdditionalSaveData(p_162444_, p_162445_);
			p_162445_.putString("Rot", this.placeSettings.getRotation().name());
		}

		public void postProcess(WorldGenLevel worldIn, StructureFeatureManager p_230383_2_, ChunkGenerator p_230383_3_, Random p_230383_4_, BoundingBox p_230383_5_, ChunkPos p_230383_6_, BlockPos p_230383_7_) {
			BlockPos blockpos1 = this.templatePosition.offset(this.placeSettings.getRotationPivot());
			int i = worldIn.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blockpos1.getX(), blockpos1.getZ());
			BlockPos blockpos2 = this.templatePosition;
			this.templatePosition = this.templatePosition.offset(0, i - 90 - 2, 0);
			super.postProcess(worldIn, p_230383_2_, p_230383_3_, p_230383_4_, p_230383_5_, p_230383_6_, p_230383_7_);
			this.templatePosition = blockpos2;
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, ServerLevelAccessor world, Random rand, BoundingBox sbb) {
		}

	}

}
