/*
Copyright (C) 2020 Corgi Taco

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 3 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program; if not, write to the Free Software Foundation,
Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

package superlord.prehistoricfauna.world.feature.config;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PHFTreeConfig implements IFeatureConfig {

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("trunk_provider"), this.trunkProvider.serialize(ops))
                .put(ops.createString("leaves_provider"), this.leavesProvider.serialize(ops))
                .put(ops.createString("ground_replacement_provider"), this.groundReplacementProvider.serialize(ops))
                .put(ops.createString("disk_provider"), this.diskProvider.serialize(ops))
                .put(ops.createString("min_height"), ops.createInt(this.minHeight))
                .put(ops.createString("max_height"), ops.createInt(this.maxHeight))
                .put(ops.createString("disk_radius"), ops.createInt(this.diskRadius))
                .put(ops.createString("whitelist"), ops.createList(this.whitelist.stream().map(block -> BlockState.serialize(ops, block.getDefaultState()).getValue())));
        return new Dynamic<>(ops, ops.createMap(builder.build()));
    }

    @SuppressWarnings("deprecation")
    public static <T> PHFTreeConfig deserialize(Dynamic<T> ops) {
        BlockStateProvider trunkProvider = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(ops.get("trunk_provider").get("type").asString().orElseThrow(RuntimeException::new))).func_227399_a_(ops.get("trunk_provider").orElseEmptyMap());
        BlockStateProvider leavesProvider = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(ops.get("leaves_provider").get("type").asString().orElseThrow(RuntimeException::new))).func_227399_a_(ops.get("leaves_provider").orElseEmptyMap());
        BlockStateProvider groundReplacementProvider = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(ops.get("ground_replacement_provider").get("type").asString().orElseThrow(RuntimeException::new))).func_227399_a_(ops.get("ground_replacement_provider").orElseEmptyMap());
        BlockStateProvider diskProvider = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(ops.get("disk_provider").get("type").asString().orElseThrow(RuntimeException::new))).func_227399_a_(ops.get("disk_provider").orElseEmptyMap());
        int minHeight = ops.get("min_height").asInt(0);
        int maxHeight = ops.get("max_height").asInt(0);
        int diskRadius = ops.get("disk_radius").asInt(0);
        List<BlockState> whitelist = new ArrayList<>(ops.get("whitelist").asList(BlockState::deserialize));
        return new PHFTreeConfig(trunkProvider, leavesProvider, groundReplacementProvider, diskProvider, minHeight, maxHeight, diskRadius, whitelist);
    }

//For usage in 1.16.2+
//    public static final Codec<PHFTreeConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
//        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").orElse(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState())).forGetter((config) -> {
//            return config.trunkProvider;
//        }), BlockStateProvider.CODEC.fieldOf("leaves_provider").orElse(new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState())).forGetter((config) -> {
//            return config.leavesProvider;
//        }), BlockStateProvider.CODEC.fieldOf("ground_replacement_provider").orElse(new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState())).forGetter((config) -> {
//            return config.groundReplacementProvider;
//        }), BlockStateProvider.CODEC.fieldOf("disk_provider").orElse(new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState())).forGetter((config) -> {
//            return config.diskProvider;
//        }), Codec.INT.fieldOf("min_height").orElse(15).forGetter((config) -> {
//            return config.minHeight;
//        }), Codec.INT.fieldOf("max_height").orElse(15).forGetter((config) -> {
//            return config.maxHeight;
//        }), Codec.INT.fieldOf("disk_radius").orElse(0).forGetter((config) -> {
//            return config.diskRadius;
//        }), BlockState.CODEC.listOf().fieldOf("whitelist").forGetter((config) -> {
//            return config.whitelist.stream().map(Block::getDefaultState).collect(Collectors.toList());
//        })).apply(codecRecorder, PHFTreeConfig::new);
//    });


    private final BlockStateProvider trunkProvider;
    private final BlockStateProvider leavesProvider;
    private final BlockStateProvider groundReplacementProvider;
    private final BlockStateProvider diskProvider;
    private final int minHeight;
    private final int maxHeight;
    private final int diskRadius;
    private final Set<Block> whitelist;
    private boolean forcedPlacement = false;

    PHFTreeConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, BlockStateProvider groundReplacementProvider, BlockStateProvider diskProvider, int minHeight, int maxHeight, int diskRadius, List<BlockState> whitelist) {
        this.trunkProvider = trunkProvider;
        this.leavesProvider = leavesProvider;
        this.groundReplacementProvider = groundReplacementProvider;
        this.diskProvider = diskProvider;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.diskRadius = diskRadius;
        this.whitelist = whitelist.stream().map(BlockState::getBlock).collect(Collectors.toSet());
    }

    /**
     * Used to generate trees from saplings
     */
    public void forcePlacement() {
        forcedPlacement = true;
    }


    public BlockStateProvider getTrunkProvider() {
        return this.trunkProvider;
    }

    public BlockStateProvider getLeavesProvider() {
        return this.leavesProvider;
    }

    public BlockStateProvider getGroundReplacementProvider() {
        return groundReplacementProvider;
    }

    public BlockStateProvider getDiskProvider() {
        return this.diskProvider;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getDiskRadius() {
        return diskRadius;
    }

    public Set<Block> getWhitelist() {
        return whitelist;
    }

    public int getMaxPossibleHeight() {
        int returnValue = this.maxHeight - minHeight;
        if (returnValue <= 0)
            returnValue = 1;

        return returnValue;
    }

    public boolean isPlacementForced() {
        return forcedPlacement;
    }

    public static class Builder {
        private BlockStateProvider trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());
        private BlockStateProvider leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());
        private BlockStateProvider groundReplacementProvider = new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState());
        private BlockStateProvider diskProvider = new SimpleBlockStateProvider(Blocks.PODZOL.getDefaultState());
        private List<Block> whitelist = ImmutableList.of(Blocks.GRASS_BLOCK);
        private int minHeight = 15;
        private int maxPossibleHeight = 1;
        private int diskRadius = 0;

        public Builder setTrunkBlock(Block block) {
            if (block != null)
                trunkProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());

            return this;
        }

        public Builder setTrunkBlock(BlockState state) {
            if (state != null)
                trunkProvider = new SimpleBlockStateProvider(state);
            else
                trunkProvider = new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState());

            return this;
        }

        public Builder setLeavesBlock(Block block) {
            if (block != null)
                leavesProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }

        public Builder setLeavesBlock(BlockState state) {
            if (state != null)
                leavesProvider = new SimpleBlockStateProvider(state);
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }

        public Builder setLeavesBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                leavesProvider = stateProvider;
            else
                leavesProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }


        public Builder setGroundReplacementBlock(Block block) {
            if (block != null)
                groundReplacementProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                groundReplacementProvider = new SimpleBlockStateProvider(Blocks.DIRT.getDefaultState());

            return this;
        }

        public Builder setGroundReplacementBlock(BlockState state) {
            if (state != null)
                groundReplacementProvider = new SimpleBlockStateProvider(state);
            else
                groundReplacementProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());

            return this;
        }

        public Builder setGroundReplacementBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                groundReplacementProvider = stateProvider;
            else
                groundReplacementProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }


        public Builder setDiskBlock(Block block) {
            if (block != null)
                diskProvider = new SimpleBlockStateProvider(block.getDefaultState());
            else
                diskProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());

            return this;
        }

        public Builder setDiskBlock(BlockState state) {
            if (state != null)
                diskProvider = new SimpleBlockStateProvider(state);
            else
                diskProvider = new SimpleBlockStateProvider(Blocks.AIR.getDefaultState());

            return this;
        }

        public Builder setDiskBlock(BlockStateProvider stateProvider) {
            if (stateProvider != null)
                diskProvider = stateProvider;
            else
                diskProvider = new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState());

            return this;
        }

        public Builder setMinHeight(int minHeight) {
            this.minHeight = minHeight;
            return this;
        }

        public Builder setMaxHeight(int maxPossibleHeight) {
            if (maxPossibleHeight != 0)
                this.maxPossibleHeight = maxPossibleHeight + 1;
            else
                this.maxPossibleHeight = 1;
            return this;
        }

        public Builder setDiskRadius(int diskRadius) {
            this.diskRadius = Math.abs(diskRadius);
            return this;
        }

        public Builder setWhitelist(ImmutableList<Block> whitelist) {
            this.whitelist = whitelist;
            return this;
        }

        public Builder copy(PHFTreeConfig config) {
            this.trunkProvider = config.trunkProvider;
            this.leavesProvider = config.leavesProvider;
            this.groundReplacementProvider = config.groundReplacementProvider;
            this.diskProvider = config.diskProvider;
            this.maxPossibleHeight = config.maxHeight;
            this.minHeight = config.minHeight;
            this.diskRadius = config.diskRadius;
            this.whitelist = ImmutableList.copyOf(config.whitelist);
            return this;
        }

        public PHFTreeConfig build() {
            return new PHFTreeConfig(this.trunkProvider, this.leavesProvider, this.groundReplacementProvider, this.diskProvider, this.minHeight, this.maxPossibleHeight, this.diskRadius, this.whitelist.stream().map(Block::getDefaultState).collect(Collectors.toList()));
        }
    }
}
