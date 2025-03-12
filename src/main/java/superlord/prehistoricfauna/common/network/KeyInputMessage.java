package superlord.prehistoricfauna.common.network;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.init.PFSounds;

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
			if (player.getVehicle() != null) {
				Entity vehicle = player.getVehicle();
				if (vehicle instanceof Triceratops) {
					Triceratops triceratops = ((Triceratops) vehicle);
					if (triceratops.isTamed() && triceratops.getControllingPassenger() == player) {
						if (triceratops.attackTick == 0) {
							triceratops.attackTick = 30;
							triceratops.level().broadcastEntityEvent(triceratops, (byte) 4);
							triceratops.playSound(PFSounds.TRICERATOPS_WARN.get(), 1.0F, 1.0F);
							triceratops.entityData.set(Triceratops.ATTACK_TICK, 7);
							for (Entity entity : triceratops.level().getEntitiesOfClass(LivingEntity.class, triceratops.getBoundingBox().inflate(4.0D))) {
								if (!(entity instanceof Triceratops) && !(entity instanceof Player)) {
									entity.hurt(entity.damageSources().mobAttack(triceratops), (float) 10.0D);
								}
							}
						}
					}
				}
			}
		});
		context.setPacketHandled(true);
	}

}
