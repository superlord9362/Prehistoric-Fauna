package superlord.prehistoricfauna.world.feature.generator;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import superlord.prehistoricfauna.init.BlockInit;

public class PrehistoricGiantTreeFeatureConfig extends BaseTreeFeatureConfig {

	public final int heightInterval;
	   public final int crownHeight;

	   protected PrehistoricGiantTreeFeatureConfig(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn, List<TreeDecorator> decoratorsIn, int baseHeightIn, int heightIntervalIn, int crownHeightIn) {
	      super(trunkProviderIn, leavesProviderIn, decoratorsIn, baseHeightIn);
	      this.heightInterval = heightIntervalIn;
	      this.crownHeight = crownHeightIn;
	   }

	   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
	      Dynamic<T> dynamic = new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("height_interval"), ops.createInt(this.heightInterval), ops.createString("crown_height"), ops.createInt(this.crownHeight))));
	      return dynamic.merge(super.serialize(ops));
	   }

	   @Override
	   protected PrehistoricGiantTreeFeatureConfig setSapling(net.minecraftforge.common.IPlantable value) {
	      super.setSapling(value);
	      return this;
	   }

	   public static <T> PrehistoricGiantTreeFeatureConfig func_227277_a_(Dynamic<T> p_227277_0_) {
	      BaseTreeFeatureConfig basetreefeatureconfig = BaseTreeFeatureConfig.deserialize(p_227277_0_);
	      return new PrehistoricGiantTreeFeatureConfig(basetreefeatureconfig.trunkProvider, basetreefeatureconfig.leavesProvider, basetreefeatureconfig.decorators, basetreefeatureconfig.baseHeight, p_227277_0_.get("height_interval").asInt(0), p_227277_0_.get("crown_height").asInt(0));
	   }

	   public static <T> PrehistoricGiantTreeFeatureConfig deserializeMetasequoia(Dynamic<T> data) {
	      return func_227277_a_(data).setSapling((net.minecraftforge.common.IPlantable)BlockInit.METASEQUOIA_SAPLING);
	   }
	   
	   public static <T> PrehistoricGiantTreeFeatureConfig deserializeAraucaria(Dynamic<T> data) {
		   return func_227277_a_(data).setSapling((net.minecraftforge.common.IPlantable)BlockInit.ARAUCARIA_SAPLING);
	   }
	   
	   //public static <T> PrehistoricGiantTreeFeatureConfig deserializeCypress(Dynamic<T> data) {
		 //  return func_227277_a_(data).setSapling((net.minecraftforge.common.IPlantable)BlockInit.CYPRESS_SAPLING);
	   //}

	   public static class Builder extends BaseTreeFeatureConfig.Builder {
	      private List<TreeDecorator> decorators = ImmutableList.of();
	      private int baseHeight;
	      private int heightInterval;
	      private int crownHeight;

	      public Builder(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn) {
	         super(trunkProviderIn, leavesProviderIn);
	      }

	      public PrehistoricGiantTreeFeatureConfig.Builder decorators(List<TreeDecorator> p_227282_1_) {
	         this.decorators = p_227282_1_;
	         return this;
	      }

	      public PrehistoricGiantTreeFeatureConfig.Builder baseHeight(int baseHeightIn) {
	         this.baseHeight = baseHeightIn;
	         return this;
	      }

	      public PrehistoricGiantTreeFeatureConfig.Builder heightInterval(int heightIntervalIn) {
	         this.heightInterval = heightIntervalIn;
	         return this;
	      }

	      public PrehistoricGiantTreeFeatureConfig.Builder crownHeight(int crownHeightIn) {
	         this.crownHeight = crownHeightIn;
	         return this;
	      }

	      @Override
	      public PrehistoricGiantTreeFeatureConfig.Builder setSapling(net.minecraftforge.common.IPlantable value) {
	         super.setSapling(value);
	         return this;
	      }

	      public PrehistoricGiantTreeFeatureConfig build() {
	         return new PrehistoricGiantTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.decorators, this.baseHeight, this.heightInterval, this.crownHeight).setSapling(this.sapling);
	      }
	   }

}
