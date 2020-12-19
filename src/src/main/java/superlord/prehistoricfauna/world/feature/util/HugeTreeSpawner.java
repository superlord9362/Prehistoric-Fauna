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

package superlord.prehistoricfauna.world.feature.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class HugeTreeSpawner extends TreeSpawner {
    public static boolean canBigTreeSpawnAt(BlockState blockUnder, IBlockReader worldIn, BlockPos pos, int xOffset, int zOffset) {
        Block block = blockUnder.getBlock();
        return block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset + 1)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset + 1)).getBlock();
    }

    public boolean spawn(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        for (int i = 0; i >= -1; --i) {
            for (int j = 0; j >= -1; --j) {
                if (canBigTreeSpawnAt(blockUnder, worldIn, pos, i, j)) {
                    return this.bigTree(worldIn, chunkGenerator, pos, blockUnder, random, i, j);
                }
            }
        }

        return super.spawn(worldIn, chunkGenerator, pos, blockUnder, random);
    }

    @Nullable
    protected abstract ConfiguredFeature<PHFTreeConfig, ?> getBigTreeFeature(Random random);

    public boolean bigTree(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> chunkGenerator, BlockPos pos, BlockState blockUnder, Random random, int xOffset, int zOffset) {
        ConfiguredFeature<PHFTreeConfig, ?> configuredTreeFeature = this.getBigTreeFeature(random);
        if (configuredTreeFeature == null) {
            return false;
        } else {
            BlockState blockstate = Blocks.AIR.getDefaultState();
            worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockstate, 4);
            worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockstate, 4);
            worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockstate, 4);
            worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockstate, 4);

            configuredTreeFeature.config.forcePlacement();
            if (configuredTreeFeature.place(worldIn, chunkGenerator, random, pos.add(xOffset, 0, zOffset))) {
                return true;
            } else {
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset), blockUnder, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset), blockUnder, 4);
                worldIn.setBlockState(pos.add(xOffset, 0, zOffset + 1), blockUnder, 4);
                worldIn.setBlockState(pos.add(xOffset + 1, 0, zOffset + 1), blockUnder, 4);
                return false;
            }
        }
    }
}