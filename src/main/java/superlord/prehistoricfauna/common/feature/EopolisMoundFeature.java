package superlord.prehistoricfauna.common.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import superlord.prehistoricfauna.common.entity.block.EopolisMoundBlockEntity;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFTags;

public class EopolisMoundFeature extends Feature<NoneFeatureConfiguration> {

	public EopolisMoundFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean isSoilBlock(BlockPos pos, WorldGenLevel level) {
		return level.getBlockState(pos).is(BlockTags.SAND) || level.getBlockState(pos).is(PFTags.SOIL) || level.getBlockState(pos).is(BlockTags.DIRT);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos origin = context.origin();
		RandomSource random = context.random();
		WorldGenLevel level = context.level();
		boolean flag = false;
		int height1 = random.nextInt(3) + 1;
		int height2 = random.nextInt(3) + 1;
		int height3 = random.nextInt(3) + 1;
		int height4 = random.nextInt(3) + 1;
		if (random.nextInt(45) == 0) {
			int y = origin.getY();
			for (int i = y; i < 320; i++) {
				BlockState state1 = level.getBlockState(new BlockPos(origin.getX(), i, origin.getZ()));
				BlockState state2 = level.getBlockState(new BlockPos(origin.getX() + 1, i, origin.getZ()));
				BlockState state3 = level.getBlockState(new BlockPos(origin.getX(), i, origin.getZ() + 1));
				BlockState state4 = level.getBlockState(new BlockPos(origin.getX() + 1, i, origin.getZ() + 1));
				if (state1.canBeReplaced() && state2.canBeReplaced() && state3.canBeReplaced() && state4.canBeReplaced() && this.isSoilBlock(new BlockPos(origin.getX(), i - 1, origin.getZ()), level)) {
					for (int j = 0; j <= height1; j++) {
						BlockPos pos = new BlockPos(origin.getX(), i + j, origin.getZ());
						level.setBlock(pos, PFBlocks.EOPOLIS_MOUND.get().defaultBlockState(), 2);
						BlockEntity entity = level.getBlockEntity(pos);
						if (entity instanceof EopolisMoundBlockEntity mound) {
							int k = 1 + random.nextInt(5);
							for (int l = 0; l < k; l++) {
								CompoundTag compoundTag = new CompoundTag();
								compoundTag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(PFEntities.EOPOLIS.get()).toString());
								mound.storeEopolis(compoundTag, random.nextInt(599), false);
							}
						}
						if (j == height1) {
							flag = true;
							break;
						}
					}
					for (int j = 0; j <= height2; j++) {
						BlockPos pos = new BlockPos(origin.getX() + 1, i + j, origin.getZ());
						level.setBlock(pos, PFBlocks.EOPOLIS_MOUND.get().defaultBlockState(), 2);
						BlockEntity entity = level.getBlockEntity(pos);
						if (entity instanceof EopolisMoundBlockEntity mound) {
							int k = 1 + random.nextInt(5);
							for (int l = 0; l < k; l++) {
								CompoundTag compoundTag = new CompoundTag();
								compoundTag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(PFEntities.EOPOLIS.get()).toString());
								mound.storeEopolis(compoundTag, random.nextInt(599), false);
							}
						}
						if (j == height2) {
							break;
						}
					}
					for (int j = 0; j <= height3; j++) {
						BlockPos pos = new BlockPos(origin.getX(), i + j, origin.getZ() + 1);
						level.setBlock(pos, PFBlocks.EOPOLIS_MOUND.get().defaultBlockState(), 2);
						BlockEntity entity = level.getBlockEntity(pos);
						if (entity instanceof EopolisMoundBlockEntity mound) {
							int k = 1 + random.nextInt(5);
							for (int l = 0; l < k; l++) {
								CompoundTag compoundTag = new CompoundTag();
								compoundTag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(PFEntities.EOPOLIS.get()).toString());
								mound.storeEopolis(compoundTag, random.nextInt(599), false);
							}
						}
						if (j == height3) {
							break;
						}
					}
					for (int j = 0; j <= height4; j++) {
						BlockPos pos = new BlockPos(origin.getX() + 1, i + j, origin.getZ() + 1);
						level.setBlock(pos, PFBlocks.EOPOLIS_MOUND.get().defaultBlockState(), 2);
						BlockEntity entity = level.getBlockEntity(pos);
						if (entity instanceof EopolisMoundBlockEntity mound) {
							int k = 1 + random.nextInt(5);
							for (int l = 0; l < k; l++) {
								CompoundTag compoundTag = new CompoundTag();
								compoundTag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(PFEntities.EOPOLIS.get()).toString());
								mound.storeEopolis(compoundTag, random.nextInt(599), false);
							}
						}
						if (j == height4) {
							break;
						}
					}
				}
			}
		}
		return flag;
	}

}
