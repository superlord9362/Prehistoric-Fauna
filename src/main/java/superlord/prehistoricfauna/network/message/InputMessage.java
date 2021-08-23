package superlord.prehistoricfauna.network.message;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.network.NetworkEvent;
import superlord.prehistoricfauna.common.entities.TriceratopsEntity;
import superlord.prehistoricfauna.init.SoundInit;

import java.util.function.Supplier;

public class InputMessage {
	public int key;

	public InputMessage(int key) {
		this.key = key;
	}

	public static void encode(InputMessage message, PacketBuffer buffer) {
		buffer.writeInt(message.key);
	}

	public static InputMessage decode(PacketBuffer buffer) {
		return new InputMessage(buffer.readInt());
	}

	public static void handle(InputMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			PlayerEntity player = context.getSender();
			Entity vehicle = player.getRidingEntity();
			if (vehicle instanceof TriceratopsEntity) {
				TriceratopsEntity triceratops = ((TriceratopsEntity) vehicle);
				if (triceratops.isTame() && triceratops.getControllingPassenger() == player) {
					if (triceratops.attackTick == 0) {
						triceratops.attackTick = 30;
						triceratops.world.setEntityState(triceratops, (byte) 4);
						triceratops.playSound(SoundInit.TRICERATOPS_WARN, 1.0F, 1.0F);
						for (Entity entity : triceratops.world.getEntitiesWithinAABB(LivingEntity.class, triceratops.getBoundingBox().grow(4.0D))) {
							if (!(entity instanceof TriceratopsEntity) && !(entity instanceof PlayerEntity)) {
								entity.attackEntityFrom(DamageSource.causeMobDamage(triceratops), (float) 10.0D);
							}
						}
					}
				}
			}
		});
		context.setPacketHandled(true);
	}

}
