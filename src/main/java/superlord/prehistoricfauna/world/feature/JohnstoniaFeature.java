package superlord.prehistoricfauna.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import superlord.prehistoricfauna.block.JohnstoniaBlock;
import superlord.prehistoricfauna.init.BlockInit;

public class JohnstoniaFeature extends Feature<NoFeatureConfig> {
	
	
	public JohnstoniaFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if (worldIn.isAirBlock(pos.up()) && worldIn.isAirBlock(pos.up(2))) {
			JohnstoniaBlock johnstonia = new JohnstoniaBlock(Block.Properties.from(BlockInit.JOHNSTONIA));
			johnstonia.placeAt(worldIn, pos, 2);
			return true;
		} else {
			return false;
		}
	}

}
