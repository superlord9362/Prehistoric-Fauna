package superlord.prehistoricfauna.world.feature.util;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.PrehistoricFauna;

import java.util.Random;
import java.util.function.Function;

public class SmallPineTree extends Feature<NoFeatureConfig> {

    public SmallPineTree(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {


        if (pos.getX() == -7 && pos.getZ() == -8) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            TemplateManager templatemanager = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager();

            Template template = templatemanager.getTemplate(new ResourceLocation(PrehistoricFauna.MODID + ":features/trees/araucaria_top"));
            if (template == null) {
                PrehistoricFauna.LOGGER.warn("NBT does not exist!");
                return false;
            }
//
//            Template template2 = templatemanager.getTemplate(new ResourceLocation(PrehistoricFauna.MODID + ":features/trees/araucaria_2_top"));
//            if (template2 == null) {
//                PrehistoricFauna.LOGGER.warn("NBT does not exist!");
//                return false;
//            }

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);
            template.addBlocksToWorld(world, pos, placementsettings);
//            template2.addBlocksToWorld(world, pos.up(32), placementsettings);
            return true;
        }
        return false;
    }
}