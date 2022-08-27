package superlord.prehistoricfauna.world.feature.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.common.world.PFConfiguredFeatures;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;
import superlord.prehistoricfauna.world.feature.trees.util.GiganticTreeSpawner;
import superlord.prehistoricfauna.world.feature.trees.util.HugeTreeSpawner;
import superlord.prehistoricfauna.world.feature.trees.util.TreeSpawner;

public class PFTreeSpawners {

	public static class Metasequoia extends HugeTreeSpawner {

		@Nullable
		public ConfiguredFeature<PFTreeConfig, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.METASEQUOIA_TREE_1;
			} else {
				return PFConfiguredFeatures.METASEQUOIA_TREE_2;
			}
		}

		@Nullable
		public ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.METASEQUOIA_SMALL_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.METASEQUOIA_SMALL_TREE_2;
			} else {
				return PFConfiguredFeatures.METASEQUOIA_SMALL_TREE_3;
			}
		}
	}

	public static class Araucaria extends HugeTreeSpawner {
		@Nullable
		public ConfiguredFeature<PFTreeConfig, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.ARAUCARIA_TREE_1;
			} else {
				return PFConfiguredFeatures.ARAUCARIA_TREE_2;
			}
		}

		@Nullable
		public ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.ARAUCARIA_SMALL_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.ARAUCARIA_SMALL_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.ARAUCARIA_SMALL_TREE_3;
			} else {
				return PFConfiguredFeatures.ARAUCARIA_SMALL_TREE_4;
			}
		}
	}

	public static class Protopiceoxylon extends TreeSpawner {

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(7);
			if (number == 0) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_4;
			} else if (number == 4) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_5;
			} else if (number == 5) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_6;
			} else {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_7;
			}
		}

	}

	public static class Protojuniperoxylon extends HugeTreeSpawner {

		@Nullable
		public ConfiguredFeature<PFTreeConfig, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.PROTOJUNIPEROXYLON_TREE_1;
			} else {
				return PFConfiguredFeatures.PROTOJUNIPEROXYLON_TREE_2;
			}
		}

		@Nullable
		public ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			return null;
		}
	}

	public static class Heidiphyllum extends TreeSpawner {

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_4;
			}  else {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_5;
			}
		}

	}

	public static class Ginkgo extends TreeSpawner {

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.GINKGO_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.GINKGO_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.GINKGO_TREE_3;
			} else {
				return PFConfiguredFeatures.GINKGO_TREE_4;
			}
		}

	}

	public static class Trochodendroides extends TreeSpawner {

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_3;
			} else {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_4;
			}
		}

	}

	public static class Brachyphyllum extends TreeSpawner { 

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_3;
			} else {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_4;
			}
		}
	}

	public static class Liriodendrites extends TreeSpawner {

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_3;
			} else {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_4;
			}
		}

	}

	public static class Schilderia extends TreeSpawner {
		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.SCHILDERIA_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.SCHILDERIA_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.SCHILDERIA_TREE_3;
			} else {
				return PFConfiguredFeatures.SCHILDERIA_TREE_4;
			}
		}
	}

	public static class Woodworthia extends TreeSpawner {
		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_3;
			} else {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_4;
			}
		}
	}

	public static class Agathoxylon extends GiganticTreeSpawner {

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getGiantTreeFeature(Random random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_2;
			} else {
				return PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_3;
			}
		}

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_1;
			} else {
				return PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_2;
			}
		}

		@Override
		protected ConfiguredFeature<PFTreeConfig, ?> getTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_1;
			} else {
				return PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_2;
			}		}

	}


}
