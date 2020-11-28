package superlord.prehistoricfauna.server.command.debug.worldgen;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraftforge.fml.loading.FMLPaths;
import superlord.prehistoricfauna.world.dimension.triassic.TriassicBiomeProvider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetRiverSkyView {
    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("triassic")
                        .then(Commands.argument("radius", IntegerArgumentType.integer(500, Integer.MAX_VALUE))
                                .then(Commands.argument("seed", LongArgumentType.longArg(0, Long.MAX_VALUE))
                                        .executes((cs) -> test(cs.getArgument("radius", Integer.class), cs.getArgument("seed", Long.class)))));
    }


    public static int test(int range, long seed) {
        TriassicBiomeProvider biomeProvider = new TriassicBiomeProvider(Registry.BIOME, seed);
        execute(biomeProvider, range);
        return 1;
    }

    public static void execute(BiomeProvider biomeProvider, int range) {
        int xRange = range;
        int zRange = range;
        BufferedImage img = new BufferedImage(xRange, zRange, BufferedImage.TYPE_INT_RGB);
        //file object
        String pathLocation = FMLPaths.GAMEDIR.get().resolve("river-preview.png").toString();
        File file = new File(pathLocation);
        if (file.exists())
            file.delete();

        for (int x = 0; x < xRange; x++) {
            for (int z = 0; z < zRange; z++) {
                img.setRGB(x, z, getColorFromBiome(biomeProvider.getNoiseBiome(x, 0, z)).getRGB());
            }
        }
        try {
            file = new File(pathLocation);
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static Color getColorFromBiome(Biome biome) {
        if (biome == Biomes.RIVER)
            return new Color(0, 55, 255);//Blue
        else
            return new Color(0, 255, 0); //Green
    }
}