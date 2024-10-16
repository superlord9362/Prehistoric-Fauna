package superlord.prehistoricfauna.common.structure.piece;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
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
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFStructures.PFStructurePieceType;

public class YixianHutPieces {
	static final BlockPos PIVOT = new BlockPos(4, 0, 15);
	private static final ResourceLocation LOCATION = new ResourceLocation(PrehistoricFauna.MOD_ID, "yixian_hut");

	public static void addPieces(StructureTemplateManager p_229346_, BlockPos p_229347_, Rotation p_229348_, StructurePieceAccessor p_229349_, RandomSource p_229350_) {
		p_229349_.addPiece(new YixianHutPieces.YixianHutPiece(p_229346_, LOCATION, p_229347_, p_229348_));
	}

	public static class YixianHutPiece extends TemplateStructurePiece {
		public YixianHutPiece(StructureTemplateManager p_229354_, ResourceLocation p_229355_, BlockPos p_229356_, Rotation p_229357_) {
			super(PFStructurePieceType.YIXIAN_HUT.get(), 0, p_229354_, p_229355_, p_229355_.toString(), makeSettings(p_229357_), p_229356_);
		}

		public YixianHutPiece(StructureTemplateManager p_229360_, CompoundTag p_229361_) {
			super(PFStructurePieceType.YIXIAN_HUT.get(), p_229361_, p_229360_, (p_229383_) -> {
				return makeSettings(Rotation.valueOf(p_229361_.getString("Rot")));
			});
		}

		protected void addAdditionalSaveData(StructurePieceSerializationContext p_229373_, CompoundTag p_229374_) {
			super.addAdditionalSaveData(p_229373_, p_229374_);
			p_229374_.putString("Rot", this.placeSettings.getRotation().name());
		}

		private static StructurePlaceSettings makeSettings(Rotation p_229371_) {
			return (new StructurePlaceSettings()).setRotation(p_229371_).setMirror(Mirror.NONE).setRotationPivot(YixianHutPieces.PIVOT).addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
		}

		public void postProcess(WorldGenLevel p_229363_, StructureManager p_229364_, ChunkGenerator p_229365_, RandomSource p_229366_, BoundingBox p_229367_, ChunkPos p_229368_, BlockPos p_229369_) {
			int i = p_229363_.getMaxBuildHeight();
			int j = 0;
			Vec3i vec3i = this.template.getSize();
			int k = vec3i.getX() * vec3i.getZ();
			if (k == 0) {
				j = p_229363_.getHeight(Heightmap.Types.WORLD_SURFACE_WG, this.templatePosition.getX(), this.templatePosition.getZ());
			} else {
				BlockPos blockpos = this.templatePosition.offset(vec3i.getX() - 1, 0, vec3i.getZ() - 1);

				for(BlockPos blockpos1 : BlockPos.betweenClosed(this.templatePosition, blockpos)) {
					int l = p_229363_.getHeight(Heightmap.Types.WORLD_SURFACE_WG, blockpos1.getX(), blockpos1.getZ());
					j += l;
					i = Math.min(i, l);
				}

				j /= k;
			}

			this.templatePosition = new BlockPos(this.templatePosition.getX(), j, this.templatePosition.getZ());
			super.postProcess(p_229363_, p_229364_, p_229365_, p_229366_, p_229367_, p_229368_, p_229369_);
		}

		@Override
		protected void handleDataMarker(String p_226906_, BlockPos p_226907_, ServerLevelAccessor p_226908_, RandomSource p_226909_, BoundingBox p_226910_) {
			
		}
	}
}
