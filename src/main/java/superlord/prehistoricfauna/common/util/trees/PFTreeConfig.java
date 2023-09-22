package superlord.prehistoricfauna.common.util.trees;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class PFTreeConfig implements FeatureConfiguration {
	
	public static final Codec<PFTreeConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
		return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").orElse(SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState())).forGetter((config) -> {
			return config.trunkProvider;
		}), BlockStateProvider.CODEC.fieldOf("leaves_provider").orElse(SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState())).forGetter((config) -> {
			return config.leavesProvider;
		}), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
			return config.minHeight;
		}), Codec.INT.fieldOf("max_height").orElse(15).forGetter((config) -> {
			return config.maxHeight;
		})).apply(codecRecorder, PFTreeConfig::new);
	});
	private boolean forcedPlacement = false;
	
	private final BlockStateProvider trunkProvider;
	private final BlockStateProvider leavesProvider;
	private final int minHeight;
	private final int maxHeight;
	
	public PFTreeConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, int minHeight, int maxHeight) {
		this.trunkProvider = trunkProvider;
		this.leavesProvider = leavesProvider;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
	
	public void forcePlacement() {
		forcedPlacement = true;
	}
	
	public BlockStateProvider getTrunkProvider() {
		return this.trunkProvider;
	}
	
	public BlockStateProvider getLeavesProvider() {
		return this.leavesProvider;
	}
	
	public int getMinHeight() {
		return this.minHeight;
	}
	
	public int getMaxHeight() {
		return this.maxHeight;
	}
	
	public int getMaxPossibleHeight() {
		int returnValue = this.maxHeight - minHeight;
		if (returnValue <= 0) returnValue = 1;
		return returnValue;
	}
	
	private Rotation rotation = Rotation.NONE;
	private Mirror mirror = Mirror.NONE;
	
	public void setRotationAndMirror(Rotation rotation, Mirror mirror) {
		this.rotation = rotation;
		this.mirror = mirror;
	}
	
	public Rotation getRotation() {
		return rotation;
	}
	
	public Mirror getMirror() {
		return mirror;
	}
	
	public boolean isPlacementForced() {
		return forcedPlacement;
	}

	
	public static class Builder {
		private BlockStateProvider trunkProvider = SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState());
		private BlockStateProvider leavesProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());
		private int minHeight = 15;
		private int maxPossibleHeight = 1;
		
		public Builder setTrunkBlock(Block block) {
			if (block != null) trunkProvider = SimpleStateProvider.simple(block.defaultBlockState());
			else trunkProvider = SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState());
			return this;
		}
		
		public Builder setTrunkBlock(BlockState state) {
			if (state != null) trunkProvider= SimpleStateProvider.simple(state);
			else trunkProvider = SimpleStateProvider.simple(Blocks.OAK_LOG.defaultBlockState());
			return this;
		}
		
		public Builder setLeavesBlock(Block block) {
            if (block != null) leavesProvider = SimpleStateProvider.simple(block.defaultBlockState());
            else leavesProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());
            return this;
        }

        public Builder setLeavesBlock(BlockState state) {
            if (state != null) leavesProvider = SimpleStateProvider.simple(state);
            else leavesProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());
            return this;
        }

        public Builder setLeavesBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null) leavesProvider = stateProvider;
            else leavesProvider = SimpleStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState());
            return this;
        }
        
        public Builder setMinHeight(int minHeight) {
        	this.minHeight = minHeight;
        	return this;
        }
        
        public Builder setMaxHeight(int maxPossibleHeight) {
        	if (maxPossibleHeight != 0) this.maxPossibleHeight = maxPossibleHeight + 1;
        	else this.maxPossibleHeight = 1;
        	return this;
        }
        
        public Builder copy(PFTreeConfig config) {
        	this.trunkProvider = config.trunkProvider;
        	this.leavesProvider = config.leavesProvider;
        	this.maxPossibleHeight = config.maxHeight;
        	this.minHeight = config.minHeight;
        	return this;
        }
        
        public PFTreeConfig build() {
        	return new PFTreeConfig(this.trunkProvider, this.leavesProvider, this.minHeight, this.maxPossibleHeight);
        }

	}

}
