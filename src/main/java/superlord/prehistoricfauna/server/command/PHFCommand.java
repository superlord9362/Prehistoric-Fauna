package superlord.prehistoricfauna.server.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.server.command.debug.worldgen.GetRiverSkyView;

public class PHFCommand {
    static String shortMODID = "phf";


    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        PrehistoricFauna.LOGGER.debug("Registering Prehistoric Fauna commands...");
        LiteralCommandNode<CommandSource> source = dispatcher.register(
                Commands.literal(shortMODID)
                .then(LocateBiome.register(dispatcher))
        );
        LiteralCommandNode<CommandSource> source1 = dispatcher.register(
                Commands.literal(shortMODID).then(Commands.argument("debug", StringArgumentType.string()))
                        .then(GetRiverSkyView.register(dispatcher))
        );

        dispatcher.register(Commands.literal(shortMODID).redirect(source));
        dispatcher.register(Commands.literal(shortMODID).redirect(source1));
        PrehistoricFauna.LOGGER.debug("Registered Prehistoric Fauna Commands!");
    }
}