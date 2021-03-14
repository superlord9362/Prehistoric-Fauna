package superlord.prehistoricfauna.world.feature.config;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NoisySphereConfig implements IFeatureConfig {

    //TODO: Re-enable and use this in 1.16+
//    public static final Codec<NoisySphereConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
//        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
//            return config.blockProvider;
//        }), BlockStateProvider.CODEC.fieldOf("top_block_provider").forGetter((config) -> {
//            return config.topBlockProvider;
//        }), Codec.INT.fieldOf("min_stack_height").orElse(1).forGetter((config) -> {
//            return config.minHeight;
//        }), Codec.INT.fieldOf("max_stack_height").orElse(1).forGetter((config) -> {
//            return config.maxHeight;
//        }), Codec.INT.fieldOf("min_x_radius").orElse(11).forGetter((config) -> {
//            return config.minXRadius;
//        }), Codec.INT.fieldOf("max_x_radius").orElse(15).forGetter((config) -> {
//            return config.maxXRadius;
//        }), Codec.INT.fieldOf("min_y_radius").orElse(15).forGetter((config) -> {
//            return config.minYRadius;
//        }), Codec.INT.fieldOf("max_y_radius").orElse(15).forGetter((config) -> {
//            return config.maxYRadius;
//        }), Codec.INT.fieldOf("min_z_radius").orElse(15).forGetter((config) -> {
//            return config.minZRadius;
//        }), Codec.INT.fieldOf("max_z_radius").orElse(15).forGetter((config) -> {
//            return config.maxZRadius;
//        }), Codec.DOUBLE.fieldOf("radius_divisor_per_stack").orElse(1.0).forGetter((config) -> {
//            return config.radiusDivisorPerStack;
//        }), Codec.DOUBLE.fieldOf("noise_frequency").orElse(1.0).forGetter((config) -> {
//            return config.radiusDivisorPerStack;
//        })).apply(codecRecorder, NoisySphereConfig::new);
//    });


    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("block_provider"), this.blockProvider.serialize(ops))
                .put(ops.createString("top_block_provider"), this.topBlockProvider.serialize(ops))
                .put(ops.createString("min_stack_height"), ops.createInt(this.minHeight))
                .put(ops.createString("max_stack_height"), ops.createInt(this.maxHeight))
                .put(ops.createString("min_x_radius"), ops.createInt(this.minXRadius))
                .put(ops.createString("min_y_radius"), ops.createInt(this.minYRadius))
                .put(ops.createString("min_z_radius"), ops.createInt(this.minZRadius))
                .put(ops.createString("max_x_radius"), ops.createInt(this.maxXRadius))
                .put(ops.createString("max_y_radius"), ops.createInt(this.maxYRadius))
                .put(ops.createString("max_z_radius"), ops.createInt(this.maxZRadius))
                .put(ops.createString("radius_divisor_per_stack"), ops.createDouble(this.radiusDivisorPerStack))
                .put(ops.createString("noise_frequency"), ops.createDouble(this.noiseFrequency))
                .put(ops.createString("dimension_whitelist"), ops.createString(this.whitelistedDimensions.stream().map(ResourceLocation::toString).collect(Collectors.joining(","))));
        return new Dynamic<>(ops, ops.createMap(builder.build()));
    }

    @SuppressWarnings("deprecation")
    public static <T> NoisySphereConfig deserialize(Dynamic<T> ops) {
        BlockStateProvider blockProvider = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(ops.get("block_provider").get("type").asString().orElseThrow(RuntimeException::new))).func_227399_a_(ops.get("block_provider").orElseEmptyMap());
        BlockStateProvider topBlockProvider = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(ops.get("top_block_provider").get("type").asString().orElseThrow(RuntimeException::new))).func_227399_a_(ops.get("top_block_provider").orElseEmptyMap());
        int minHeight = ops.get("min_stack_height").asInt(0);
        int maxHeight = ops.get("max_stack_height").asInt(0);
        int minXRadius = ops.get("min_x_radius").asInt(0);
        int maxXRadius = ops.get("min_y_radius").asInt(0);
        int minYRadius = ops.get("min_z_radius").asInt(0);
        int maxYRadius = ops.get("max_x_radius").asInt(0);
        int minZRadius = ops.get("max_y_radius").asInt(0);
        int maxZRadius = ops.get("max_z_radius").asInt(0);
        double radiusDivisorPerStack = ops.get("radius_divisor_per_stack").asDouble(1);
        double noseFreq = ops.get("noise_frequency").asDouble(1);
        Set<ResourceLocation> dimensionWhitelist = Arrays.stream(ops.get("dimension_whitelist").asString("minecraft:overworld").trim().replace(" ", "").split(",")).map(ResourceLocation::new).collect(Collectors.toSet());
        return new NoisySphereConfig(blockProvider, topBlockProvider, minHeight, maxHeight, minXRadius, maxXRadius, minYRadius, maxYRadius, minZRadius, maxZRadius, radiusDivisorPerStack, noseFreq, dimensionWhitelist);
    }

    private final BlockStateProvider blockProvider;
    private final BlockStateProvider topBlockProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int minXRadius;
    private final int maxXRadius;
    private final int minYRadius;
    private final int maxYRadius;
    private final int minZRadius;
    private final int maxZRadius;
    private final double radiusDivisorPerStack;
    private final double noiseFrequency;
    private final Set<ResourceLocation> whitelistedDimensions;

    NoisySphereConfig(BlockStateProvider blockProvider, BlockStateProvider topBlockProvider, int minHeight, int maxHeight, int minXRadius, int maxXRadius, int minYRadius, int maxYRadius, int minZRadius, int maxZRadius, double radiusDivisorPerStack, double noiseFrequency, Set<ResourceLocation> whitelistedDimensions) {
        this.blockProvider = blockProvider;
        this.topBlockProvider = topBlockProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minXRadius = minXRadius;
        this.maxXRadius = maxXRadius;
        this.minYRadius = minYRadius;
        this.maxYRadius = maxYRadius;
        this.minZRadius = minZRadius;
        this.maxZRadius = maxZRadius;
        this.radiusDivisorPerStack = radiusDivisorPerStack;
        this.noiseFrequency = noiseFrequency;
        this.whitelistedDimensions = whitelistedDimensions;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }

    public BlockStateProvider getTopBlockProvider() {
        return topBlockProvider;
    }

    public int getMinHeight() {
        return Math.abs(minHeight);
    }

    public int getMaxHeight() {
        return Math.abs(maxHeight);
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxHeight - minHeight;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue + 1;
    }

    public int getMinXRadius() {
        return Math.abs(minXRadius);
    }

    public int getMaxXRadius() {
        return Math.abs(maxXRadius);
    }

    public int getMinYRadius() {
        return minYRadius;
    }

    public int getMaxYRadius() {
        return maxYRadius;
    }

    public int getMinZRadius() {
        return minZRadius;
    }

    public int getMaxZRadius() {
        return maxZRadius;
    }

    public int getMaxPossibleXRadius() {
        int returnValue = this.maxXRadius - minXRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getMaxPossibleYRadius() {
        int returnValue = this.maxYRadius - minYRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getMaxPossibleZRadius() {
        int returnValue = this.maxZRadius - minZRadius;
        if (returnValue <= 0)
            returnValue = 1;

        return Math.abs(returnValue);
    }

    public int getRandomXRadius(Random rand) {
        return rand.nextInt(maxXRadius) + minXRadius;
    }

    public int getRandomYRadius(Random rand) {
        return rand.nextInt(maxYRadius) + minYRadius;
    }

    public int getRandomZRadius(Random rand) {
        return rand.nextInt(maxZRadius) + minZRadius;
    }

    public double getRadiusDivisorPerStack() {
        return this.radiusDivisorPerStack;
    }

    public double getNoiseFrequency() {
        return noiseFrequency;
    }

    public Set<ResourceLocation> getWhitelistedDimensions() {
        return whitelistedDimensions;
    }

    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private BlockStateProvider topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
        private int minStackHeight = 1;
        private int maxStackHeight = 1;
        private int minXRadius = 1;
        private int maxXRadius = 3;
        private int minYRadius = minXRadius;
        private int maxYRadius = maxXRadius;
        private int minZRadius = minXRadius;
        private int maxZRadius = maxXRadius;
        private double radiusDivisorPerStack = 1.0;
        private double noiseFrequency = 0.045;
        private Set<ResourceLocation> whitelistedDimensions = ImmutableSet.of(new ResourceLocation("minecraft:overworld"));

        public Builder setBlock(Block block) {
            if (block != null)
                blockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            if (state != null)
                blockProvider = new SimpleBlockStateProvider(state);
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setBlock(BlockStateProvider provider) {
            if (provider != null)
                blockProvider = provider;
            else
                blockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setTopBlock(Block block) {
            if (block != null)
                topBlockProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setTopBlock(BlockState state) {
            if (state != null)
                topBlockProvider = new SimpleBlockStateProvider(state);
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setTopBlock(BlockStateProvider provider) {
            if (provider != null)
                topBlockProvider = provider;
            else
                topBlockProvider = new SimpleBlockStateProvider(Blocks.STONE.getDefaultState());
            return this;
        }

        public Builder setMinStackHeight(int minStackHeight) {
            if (minStackHeight <= 0)
                this.minStackHeight = 1;
            else
                this.minStackHeight = minStackHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight <= 0)
                this.maxStackHeight = minStackHeight + 1;
            else
                this.maxStackHeight = maxPossibleHeight;
            return this;
        }

        public Builder setMinXRadius(int minXRadius) {
            if (minXRadius <= 0)
                this.minXRadius = 1;
            else
                this.minXRadius = minXRadius;
            return this;
        }

        public Builder setMinRadius(int minRadius) {
            if (minRadius <= 0) {
                this.minXRadius = 1;
                this.minYRadius = 1;
                this.minZRadius = 1;
            } else {
                this.minXRadius = minRadius;
                this.minYRadius = minRadius;
                this.minZRadius = minRadius;
            }
            return this;
        }

        public Builder setMaxRadius(int maxRadius) {
            if (maxRadius <= 0) {
                this.maxXRadius = 1;
                this.maxYRadius = 1;
                this.maxZRadius = 1;
            } else {
                this.maxXRadius = maxRadius;
                this.maxYRadius = maxRadius;
                this.maxZRadius = maxRadius;
            }
            return this;
        }

        public Builder setMaxXRadius(int maxXRadius) {
            if (maxXRadius <= 0)
                this.maxXRadius = minXRadius + 1;
            else
                this.maxXRadius = maxXRadius;
            return this;
        }

        public Builder setMinYRadius(int minYRadius) {
            this.minYRadius = minYRadius;
            return this;
        }

        public Builder setMaxYRadius(int maxYRadius) {
            this.maxYRadius = maxYRadius;
            return this;
        }

        public Builder setMinZRadius(int minZRadius) {
            this.minZRadius = minZRadius;
            return this;
        }

        public Builder setMaxZRadius(int maxZRadius) {
            this.maxZRadius = maxZRadius;
            return this;
        }

        public Builder setRadiusDivisor(double radiusDivisorPerStack) {
            this.radiusDivisorPerStack = radiusDivisorPerStack;
            return this;
        }

        public Builder setNoiseFrequency(double noiseFrequency) {
            this.noiseFrequency = noiseFrequency;
            return this;
        }

        public Set<ResourceLocation> getWhitelistedDimensions() {
            return whitelistedDimensions;
        }

        public Builder setWhitelistedDimensions(String whitelistedDimensions) {
            this.whitelistedDimensions = Arrays.stream(whitelistedDimensions.trim().replace(" ", "").split(",")).map(ResourceLocation::new).collect(Collectors.toSet());
            return this;
        }

        public Builder setWhitelistedDimensions(Set<String> whitelistedDimensions) {
            this.whitelistedDimensions = whitelistedDimensions.stream().map(ResourceLocation::new).collect(Collectors.toSet());
            return this;
        }

        public Builder setWhitelistedDimensions(DimensionType... whitelistedDimensions) {
            this.whitelistedDimensions = Arrays.stream(whitelistedDimensions).map(Registry.DIMENSION_TYPE::getKey).collect(Collectors.toSet());
            return this;
        }

        public Builder copy(NoisySphereConfig config) {
            this.blockProvider = config.blockProvider;
            this.topBlockProvider = config.topBlockProvider;
            this.minStackHeight = config.minHeight;
            this.maxStackHeight = config.maxHeight;
            this.minXRadius = config.minXRadius;
            this.maxXRadius = config.maxXRadius;
            this.minYRadius = config.minYRadius;
            this.maxYRadius = config.maxYRadius;
            this.minZRadius = config.minZRadius;
            this.maxZRadius = config.maxZRadius;
            this.radiusDivisorPerStack = config.radiusDivisorPerStack;
            this.noiseFrequency = config.noiseFrequency;
            return this;
        }

        public NoisySphereConfig build() {
            return new NoisySphereConfig(this.blockProvider, this.topBlockProvider, this.minStackHeight, this.maxStackHeight, this.minXRadius / 2, this.maxXRadius / 2, minYRadius / 2, maxYRadius / 2, minZRadius / 2, maxZRadius / 2, this.radiusDivisorPerStack, this.noiseFrequency, this.whitelistedDimensions);
        }
    }
}