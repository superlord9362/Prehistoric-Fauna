package superlord.prehistoricfauna.world.feature.util;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class PHFTreeSpawners {

    public static class MetaSequoia extends HugeTreeSpawner {

        @Nullable
        @Override
        protected ConfiguredFeature<PHFTreeConfig, ?> getBigTreeFeature(Random random) {
            return PHFConfiguredFeatures.METASEQUOIA_TREE1;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }

    public static class ProtoJuniper extends HugeTreeSpawner {

        @Nullable
        @Override
        protected ConfiguredFeature<PHFTreeConfig, ?> getBigTreeFeature(Random random) {
            return PHFConfiguredFeatures.PROTOJUNIPER_TREE;
        }

        @Nullable
        @Override
        protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
            return null;
        }
    }
}
