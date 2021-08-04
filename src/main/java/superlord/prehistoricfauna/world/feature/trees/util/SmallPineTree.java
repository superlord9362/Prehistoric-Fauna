package superlord.prehistoricfauna.world.feature.trees.util;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import superlord.prehistoricfauna.PrehistoricFauna;

public class SmallPineTree extends Feature<NoFeatureConfig> {

    public SmallPineTree(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (pos.getX() == -7 && pos.getZ() == -8) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            TemplateManager templatemanager = world.getWorld().getStructureTemplateManager();
            Template template = templatemanager.getTemplate(new ResourceLocation(PrehistoricFauna.MOD_ID + ":features/trees/embur_tree4"));

            if (template == null) {
                PrehistoricFauna.LOGGER.warn("NBT does not exist!");
                return false;
            }

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);
            template.func_237144_a_(world, pos, placementsettings, rand);
            return true;
        }
        return false;
    }
}