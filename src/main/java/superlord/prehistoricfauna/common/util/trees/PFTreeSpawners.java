package superlord.prehistoricfauna.common.util.trees;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.init.PFConfiguredFeatures;

public class PFTreeSpawners {
	
	public static class Araucaria extends HugeTreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.ARAUCARIA_TREE_1.get();
			} else {
				return PFConfiguredFeatures.ARAUCARIA_TREE_2.get();
			}
		}

		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_3.get();
			} else {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_4.get();
			}
		}
	}
	
	public static class Agathoxylon extends GiganticTreeSpawner {

		@Override
		protected ConfiguredFeature<?, ?> getGiantTreeFeature(Random random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_2.get();
			} else {
				return PFConfiguredFeatures.LARGE_AGATHOXYLON_TREE_3.get();
			}
		}

		@Override
		protected ConfiguredFeature<?, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_1.get();
			} else {
				return PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_2.get();
			}
		}

		@Override
		protected ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_1.get();
			} else {
				return PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_2.get();
			}		}

	}
	
	public static class Brachyphyllum extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_3.get();
			} else {
				return PFConfiguredFeatures.BRACHYPHYLLUM_TREE_4.get();
			}
		}
	}
	
	public static class Dryophyllum extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(8);
			if (number == 0) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_3.get();
			} else if (number == 3) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_4.get();
			} else if (number == 4) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_5.get();
			} else if (number == 5) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_6.get();
			} else if (number == 6) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_7.get();
			} else {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_8.get();
			}
		}
	}
	
	public static class Ginkgo extends HugeTreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(8);
			if (number == 0) {
				return PFConfiguredFeatures.GINKGO_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.GINKGO_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.GINKGO_TREE_3.get();
			} else if (number == 3) {
				return PFConfiguredFeatures.GINKGO_TREE_4.get();
			} else if (number == 4) {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_1.get();
			} else if (number == 5) {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_2.get();
			} else if (number == 6) {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_3.get();
			} else {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_4.get();
			}
		}
		
		@Override
		protected ConfiguredFeature<?, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(8);
			if (number == 0) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_3.get();
			} else if (number == 3) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_4.get();
			} else if (number == 4) {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_1.get();
			} else if (number == 5) {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_2.get();
			} else if (number == 6) {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_3.get();
			} else {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_4.get();
			}
		}
	}
	
	public static class Taxodium extends HugeTreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(5);
			if (number == 0) {
				return PFConfiguredFeatures.TAXODIUM_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.TAXODIUM_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.TAXODIUM_TREE_3.get();
			} else if (number == 3) {
				return PFConfiguredFeatures.TAXODIUM_TREE_4.get();
			} else {
				return PFConfiguredFeatures.TAXODIUM_TREE_5.get();
			}
		}
		
		@Override
		protected ConfiguredFeature<?, ?> getBigTreeFeature(Random random) {
			return PFConfiguredFeatures.TAXODIUM_TREE_6.get();
		}
	}
	
	public static class Heidiphyllum extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(5);
			if (number == 0) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_3.get();
			} else if (number == 3) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_4.get();
			} else {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_5.get();
			}
		}
	}
	
	public static class Liriodendrites extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_3.get();
			} else {
				return PFConfiguredFeatures.LIRIODENDRITES_TREE_4.get();
			}
		}
	}
	
	public static class Metasequoia extends HugeTreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_1.get();
			} else {
				return PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_2.get();
			}
		}

		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_2.get();
			} else {
				return PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_3.get();
			}
		}
	}
	
	public static class Protopiceoxylon extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(7);
			if (number == 0) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_3.get();
			} else if (number == 3) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_4.get();
			} else if (number == 4) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_5.get();
			} else if (number == 5) {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_6.get();
			} else {
				return PFConfiguredFeatures.PROTOPICEOXYLON_TREE_7.get();
			}
		}
	}
	
	public static class Schilderia extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.SCHILDERIA_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.SCHILDERIA_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.SCHILDERIA_TREE_3.get();
			} else {
				return PFConfiguredFeatures.SCHILDERIA_TREE_4.get();
			}
		}
	}
	
	public static class Trochodendroides extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_3.get();
			} else {
				return PFConfiguredFeatures.TROCHODENDROIDES_TREE_4.get();
			}
		}
	}
	
	public static class Woodworthia extends TreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_1.get();
			} else if (number == 1) {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_2.get();
			} else if (number == 2) {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_3.get();
			} else {
				return PFConfiguredFeatures.WOODWORTHIA_TREE_4.get();
			}
		}
	}
	
	public static class Protojuniperoxylon extends HugeTreeSpawner {
		@Nullable
		public ConfiguredFeature<?, ?> getBigTreeFeature(Random random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_1.get();
			} else {
				return PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_2.get();
			}
		}

		@Override
		protected ConfiguredFeature<?, ?> getTreeFeature(Random random) {
			return null;
		}
	}

}
