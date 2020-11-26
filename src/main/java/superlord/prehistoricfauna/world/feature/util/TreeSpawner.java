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

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class TreeSpawner {
    @Nullable
    protected abstract ConfiguredFeature<PHFTreeConfig, ?> getTreeFeature(Random random);

    public boolean spawn(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        ConfiguredFeature<PHFTreeConfig, ?> configuredTreeFeature = this.getTreeFeature(random);
        if (configuredTreeFeature == null) {
            return false;
        } else {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            configuredTreeFeature.config.forcePlacement();
            if (configuredTreeFeature.place(worldIn, chunkGenerator, random, pos)) {
                return true;
            } else {
                worldIn.setBlockState(pos, blockUnder, 4);
                return false;
            }
        }
    }
}