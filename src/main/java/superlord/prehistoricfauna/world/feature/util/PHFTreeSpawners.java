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
			int selector = random.nextInt(1);
			if (selector == 0) {
				return PHFConfiguredFeatures.METASEQUOIA_TREE1;
			} else {
				return PHFConfiguredFeatures.METASEQUOIA_TREE2;
			}
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
			int selector = random.nextInt(1);
			if (selector == 0) {
				return PHFConfiguredFeatures.PROTOJUNIPEROXYLON_TREE1;
			} else {
				return PHFConfiguredFeatures.PROTOJUNIPEROXYLON_TREE2;
			}
		}

		@Nullable
		@Override
		protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
			return null;
		}
	}

	public static class Araucaria extends HugeTreeSpawner {

		@Nullable
		@Override
		protected ConfiguredFeature<PHFTreeConfig, ?> getBigTreeFeature(Random random) {
			int selector = random.nextInt(1);
			if (selector == 0) {
				return PHFConfiguredFeatures.ARAUCARIA_TREE1;
			} else {
				return PHFConfiguredFeatures.ARAUCARIA_TREE2;
			}
		}

		@Nullable
		@Override
		protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
			int selector = random.nextInt(3);
			if (selector == 0) {
				return PHFConfiguredFeatures.ARAUCARIA_SMALL_TREE1;
			} else if (selector == 1) {
				return PHFConfiguredFeatures.ARAUCARIA_SMALL_TREE2;
			} else if (selector == 2) {
				return PHFConfiguredFeatures.ARAUCARIA_SMALL_TREE3;
			} else {
				return PHFConfiguredFeatures.ARAUCARIA_SMALL_TREE4;
			}
		}
	}

	public static class Liriodendrites extends TreeSpawner {
		@Nullable
		@Override
		protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
			int selector = random.nextInt(3);
			if (selector == 0) {
				return PHFConfiguredFeatures.LIRIODENDRITES_TREE1;
			} else if (selector == 1) {
				return PHFConfiguredFeatures.LIRIODENDRITES_TREE2;
			} else if (selector == 2) {
				return PHFConfiguredFeatures.LIRIODENDRITES_TREE3;
			} else {
				return PHFConfiguredFeatures.LIRIODENDRITES_TREE4;
			}
		}
	}

	public static class Protopiceoxylon extends TreeSpawner {
		@Nullable
		@Override
		protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
			int selector = random.nextInt(6);
			if (selector == 0) {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE1;
			} else if (selector == 1) {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE2;
			} else if (selector == 2) {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE3;
			} else if (selector == 3) {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE4;
			} else if (selector == 4) {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE5;
			} else if (selector == 5) {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE6;
			} else {
				return PHFConfiguredFeatures.PROTOPICEOXYLON_TREE7;
			}
		}
	}

	public static class Heidiphyllum extends TreeSpawner {
		@Nullable
		@Override
		protected ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random) {
			int selector = random.nextInt(4);
			if (selector == 0) {
				return PHFConfiguredFeatures.HEIDIPHYLLUM_TREE1;
			} else if (selector == 1) {
				return PHFConfiguredFeatures.HEIDIPHYLLUM_TREE2;
			} else if (selector == 2) {
				return PHFConfiguredFeatures.HEIDIPHYLLUM_TREE3;
			} else if (selector == 3) {
				return PHFConfiguredFeatures.HEIDIPHYLLUM_TREE4;
			} else {
				return PHFConfiguredFeatures.HEIDIPHYLLUM_TREE5;
			}
		}
	}

}
