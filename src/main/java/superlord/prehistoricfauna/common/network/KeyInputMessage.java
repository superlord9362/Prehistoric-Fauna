package superlord.prehistoricfauna.common.network;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thoracosaurus;

public class KeyInputMessage {
	
	public int key;
	
	public KeyInputMessage(int key) {
		this.key = key;
	}
	
	public static void encode(KeyInputMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.key);
	}
	
	public static KeyInputMessage decode(FriendlyByteBuf buffer) {
		return new KeyInputMessage(buffer.readInt());
	}
	
	public static void handle(KeyInputMessage messatge, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player player = context.getSender();
			Entity vehicle = player.getVehicle();
			if (vehicle instanceof Thoracosaurus thoracosaurus) {
				if (thoracosaurus.isInWater() && thoracosaurus.isTame() && thoracosaurus.getControllingPassenger() == player) {
					thoracosaurus.setDeltaMovement(thoracosaurus.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
				}
			}
		});
		context.setPacketHandled(true);
	}

}
