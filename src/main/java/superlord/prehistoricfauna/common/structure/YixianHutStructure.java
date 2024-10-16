package superlord.prehistoricfauna.common.structure;

import java.util.Optional;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import superlord.prehistoricfauna.common.structure.piece.YixianHutPieces;
import superlord.prehistoricfauna.init.PFStructures.PFStructureType;

public class YixianHutStructure extends Structure {

	public static final Codec<YixianHutStructure> CODEC = simpleCodec(YixianHutStructure::new);

	public YixianHutStructure(Structure.StructureSettings p_229388_) {
		super(p_229388_);
	}

	public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext p_229391_) {
		return onTopOfChunkCenter(p_229391_, Types.WORLD_SURFACE_WG, (p_229394_) -> {
			this.generatePieces(p_229394_, p_229391_);
		});
	}

	private void generatePieces(StructurePiecesBuilder p_229396_, Structure.GenerationContext p_229397_) {
		Rotation rotation = Rotation.getRandom(p_229397_.random());
		BlockPos blockpos = new BlockPos(p_229397_.chunkPos().getMinBlockX(), 90, p_229397_.chunkPos().getMinBlockZ());
		YixianHutPieces.addPieces(p_229397_.structureTemplateManager(), blockpos, rotation, p_229396_, p_229397_.random());
	}

	public StructureType<?> type() {
		return PFStructureType.YIXIAN_HUT.get();
	}

}
