package superlord.prehistoricfauna.common.util.trees;

import javax.annotation.Nullable;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.init.PFConfiguredFeatures;

public class PFTreeSpawners {
	
	public static class Araucaria extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.ARAUCARIA_TREE_1;
			} else {
				return PFConfiguredFeatures.ARAUCARIA_TREE_2;
			}
		}

		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_3;
			} else {
				return PFConfiguredFeatures.SMALL_ARAUCARIA_TREE_4;
			}
		}
	}
	
	public static class Agathoxylon extends GiganticTreeSpawner {

		@Override
		protected ResourceKey<ConfiguredFeature<?, ?>> getGiantTreeFeature(RandomSource random) {
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
		protected ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_1;
			} else {
				return PFConfiguredFeatures.MEDIUM_AGATHOXYLON_TREE_2;
			}
		}

		@Override
		protected ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_1;
			} else {
				return PFConfiguredFeatures.SMALL_AGATHOXYLON_TREE_2;
			}		}

	}
	
	public static class Brachyphyllum extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
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
	
	public static class Dryophyllum extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(8);
			if (number == 0) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_4;
			} else if (number == 4) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_5;
			} else if (number == 5) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_6;
			} else if (number == 6) {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_7;
			} else {
				return PFConfiguredFeatures.DRYOPHYLLUM_TREE_8;
			}
		}
	}
	
	public static class Ginkgo extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(8);
			if (number == 0) {
				return PFConfiguredFeatures.GINKGO_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.GINKGO_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.GINKGO_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.GINKGO_TREE_4;
			} else if (number == 4) {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_1;
			} else if (number == 5) {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_2;
			} else if (number == 6) {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_3;
			} else {
				return PFConfiguredFeatures.YELLOW_GINKGO_TREE_4;
			}
		}
		
		@Override
		protected ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			int number = random.nextInt(8);
			if (number == 0) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.BIG_GINKGO_TREE_4;
			} else if (number == 4) {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_1;
			} else if (number == 5) {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_2;
			} else if (number == 6) {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_3;
			} else {
				return PFConfiguredFeatures.YELLOW_BIG_GINKGO_TREE_4;
			}
		}
	}
	
	public static class Taxodium extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(5);
			if (number == 0) {
				return PFConfiguredFeatures.TAXODIUM_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.TAXODIUM_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.TAXODIUM_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.TAXODIUM_TREE_4;
			} else {
				return PFConfiguredFeatures.TAXODIUM_TREE_5;
			}
		}
		
		@Override
		protected ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			return PFConfiguredFeatures.TAXODIUM_TREE_6;
		}
	}
	
	public static class Taxus extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.TAXUS_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.TAXUS_TREE_2;
			} else {
				return PFConfiguredFeatures.TAXUS_TREE_5;
			}
		}
		
		@Override
		protected ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			int number = random.nextInt(5);
			if (number == 0) {
				return PFConfiguredFeatures.TAXUS_TREE_3;
			} else if (number == 1) {
				return PFConfiguredFeatures.TAXUS_TREE_4;
			} else if (number == 2) {
				return PFConfiguredFeatures.TAXUS_TREE_6;
			} else if (number == 3) {
				return PFConfiguredFeatures.TAXUS_TREE_7;
			} else {
				return PFConfiguredFeatures.TAXUS_TREE_8;
			}
		}
	}
	
	public static class Heidiphyllum extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(5);
			if (number == 0) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_4;
			} else {
				return PFConfiguredFeatures.HEIDIPHYLLUM_TREE_5;
			}
		}
	}
	
	public static class Liriodendrites extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
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
	
	public static class Metasequoia extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_1;
			} else {
				return PFConfiguredFeatures.LARGE_METASEQUOIA_TREE_2;
			}
		}

		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_2;
			} else {
				return PFConfiguredFeatures.SMALL_METASEQUOIA_TREE_3;
			}
		}
	}
	
	public static class Protopiceoxylon extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
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
	
	public static class Schilderia extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
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
	
	public static class Trochodendroides extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
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
	
	public static class Podozamites extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(6);
			if (number == 0) {
				return PFConfiguredFeatures.PODOZAMITES_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.PODOZAMITES_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.PODOZAMITES_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.PODOZAMITES_TREE_4;
			} else if (number == 3) {
				return PFConfiguredFeatures.PODOZAMITES_TREE_5;
			} else {
				return PFConfiguredFeatures.PODOZAMITES_TREE_6;
			}
		}
	}
	
	public static class Schizolepidopsis extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(9);
			if (number == 0) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_4;
			} else if (number == 4) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_5;
			} else if (number == 5) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_6;
			} else if (number == 6) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_7;
			} else if (number == 7) {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_8;
			} else {
				return PFConfiguredFeatures.SCHIZOLEPIDOPSIS_TREE_9;
			}
		}
	}
	
	public static class Czekanowskia extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(6);
			if (number == 0) {
				return PFConfiguredFeatures.CZEKANOWSKIA_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.CZEKANOWSKIA_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.CZEKANOWSKIA_TREE_3;
			} else if (number == 3) {
				return PFConfiguredFeatures.CZEKANOWSKIA_TREE_4;
			} else if (number == 3) {
				return PFConfiguredFeatures.CZEKANOWSKIA_TREE_5;
			} else {
				return PFConfiguredFeatures.CZEKANOWSKIA_TREE_6;
			}
		}
	}
	
	public static class Woodworthia extends TreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
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
	
	public static class Protojuniperoxylon extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			int number = random.nextInt(2);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_1;
			} else {
				return PFConfiguredFeatures.LARGE_PROTOJUNIPEROXYLON_TREE_2;
			}
		}

		@Override
		protected ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			return null;
		}
	}
	
	public static class Platanites extends HugeTreeSpawner {
		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getBigTreeFeature(RandomSource random) {
			int number = random.nextInt(3);
			if (number == 0) {
				return PFConfiguredFeatures.LARGE_PLATANITES_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.LARGE_PLATANITES_TREE_2;
			} else {
				return PFConfiguredFeatures.LARGE_PLATANITES_TREE_3;
			}
		}

		@Nullable
		public ResourceKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomSource random) {
			int number = random.nextInt(4);
			if (number == 0) {
				return PFConfiguredFeatures.SMALL_PLATANITES_TREE_1;
			} else if (number == 1) {
				return PFConfiguredFeatures.SMALL_PLATANITES_TREE_2;
			} else if (number == 2) {
				return PFConfiguredFeatures.SMALL_PLATANITES_TREE_3;
			} else {
				return PFConfiguredFeatures.SMALL_PLATANITES_TREE_4;
			}
		}
	}

}
