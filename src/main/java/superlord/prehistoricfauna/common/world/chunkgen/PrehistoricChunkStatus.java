package superlord.prehistoricfauna.common.world.chunkgen;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.Util;
import net.minecraft.server.level.ChunkHolder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ThreadedLevelLightEngine;
import net.minecraft.util.profiling.jfr.JvmProfiler;
import net.minecraft.util.profiling.jfr.callback.ProfiledDuration;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import superlord.prehistoricfauna.init.PFDimensions;

public class PrehistoricChunkStatus extends ChunkStatus {

	private static String name;
	   private static int index;
	   private static ChunkStatus parent;
	   private static ChunkStatus.GenerationTask generationTask;
	   private static ChunkStatus.LoadingTask loadingTask;
	   private static ChunkStatus.ChunkType chunkType;
	   private static EnumSet<Heightmap.Types> heightmapsAfter;
	
	public PrehistoricChunkStatus(String p_62342_, ChunkStatus p_62343_, int p_62344_, EnumSet<Types> p_62345_, ChunkType p_62346_, GenerationTask p_62347_, LoadingTask p_62348_) {
		super(p_62342_, p_62343_, p_62344_, p_62345_, p_62346_, p_62347_, p_62348_);
		this.name = p_62342_;
		this.parent = p_62343_;
		this.index = p_62344_;
		this.heightmapsAfter = p_62345_;
		this.chunkType = p_62346_;
		this.generationTask = p_62347_;
		this.loadingTask = p_62348_;
	}

	public PrehistoricChunkStatus() {
		this(name, parent, index, heightmapsAfter, chunkType, generationTask, loadingTask);
	}

	@Override
	public CompletableFuture<Either<ChunkAccess, ChunkHolder.ChunkLoadingFailure>> generate(Executor p_187789_, ServerLevel p_187790_, ChunkGenerator p_187791_, StructureManager p_187792_, ThreadedLevelLightEngine p_187793_, Function<ChunkAccess, CompletableFuture<Either<ChunkAccess, ChunkHolder.ChunkLoadingFailure>>> p_187794_, List<ChunkAccess> p_187795_, boolean p_187796_) {
		ChunkAccess chunkaccess = p_187795_.get(p_187795_.size() / 2);
		if (p_187790_.dimension() == PFDimensions.TRIASSIC) {
			this.STATUS_BY_RANGE = ImmutableList.of(BIOMES, FULL, FEATURES, LIQUID_CARVERS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS);
			ProfiledDuration profiledduration = JvmProfiler.INSTANCE.onChunkGenerate(chunkaccess.getPos(), PFDimensions.TRIASSIC, this.getName());
			CompletableFuture<Either<ChunkAccess, ChunkHolder.ChunkLoadingFailure>> completablefuture = this.generationTask.doWork(this, p_187789_, p_187790_, p_187791_, p_187792_, p_187793_, p_187794_, p_187795_, chunkaccess, p_187796_);
			return profiledduration != null ? completablefuture.thenApply((p_196756_) -> {
				profiledduration.finish();
				return p_196756_;
			}) : completablefuture;  
		} else {
			ProfiledDuration profiledduration = JvmProfiler.INSTANCE.onChunkGenerate(chunkaccess.getPos(), p_187790_.dimension(), this.getName());
			CompletableFuture<Either<ChunkAccess, ChunkHolder.ChunkLoadingFailure>> completablefuture = this.generationTask.doWork(this, p_187789_, p_187790_, p_187791_, p_187792_, p_187793_, p_187794_, p_187795_, chunkaccess, p_187796_);
			return profiledduration != null ? completablefuture.thenApply((p_196756_) -> {
				profiledduration.finish();
				return p_196756_;
			}) : completablefuture;  
		}
	}

}
