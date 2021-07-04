package superlord.prehistoricfauna.client.util;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFPacketHandler
{
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(PrehistoricFauna.MOD_ID, "network"), () -> PFPacketHandler.PROTOCOL_VERSION, PFPacketHandler.PROTOCOL_VERSION::equals, PFPacketHandler.PROTOCOL_VERSION::equals);
	private static final String PROTOCOL_VERSION = "1";
	private static int ID = 0;

	public static void registerPackets()
	{
		PFPacketHandler.CHANNEL.messageBuilder(PacketToClientSign.class, PFPacketHandler.ID++).decoder(PacketToClientSign::decoder).encoder(PacketToClientSign::encode).consumer(PacketToClientSign::handle).add();
	}
}
