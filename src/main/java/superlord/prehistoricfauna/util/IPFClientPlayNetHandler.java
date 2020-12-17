package superlord.prehistoricfauna.util;

import net.minecraft.client.network.play.IClientPlayNetHandler;

public interface IPFClientPlayNetHandler extends IClientPlayNetHandler {
	
	void handleSpawnPainting(SSpawnPaleoPaintingPacket packetIn);

}
