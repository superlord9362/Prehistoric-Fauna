package superlord.prehistoricfauna.message;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.TileEntityPaleoscribe;
import superlord.prehistoricfauna.util.EnumPaleoPages;

import java.util.function.Supplier;

public class MessageUpdatePaleoscribe {
	
	public long blockPos;
	public int selectedPages1;
	public int selectedPages2;
	public int selectedPages3;
	
	public MessageUpdatePaleoscribe(long blockPos, int selectedPages1, int selectedPages2, int selectedPages3) {
		this.blockPos = blockPos;
		this.selectedPages1 = selectedPages1;
		this.selectedPages2 = selectedPages2;
		this.selectedPages3 = selectedPages3;
	}
	
	public MessageUpdatePaleoscribe() {
		
	}
	
	public static MessageUpdatePaleoscribe read(PacketBuffer buf) {
		return new MessageUpdatePaleoscribe(buf.readLong(), buf.readInt(), buf.readInt(), buf.readInt());
	}
	
	public static void write(MessageUpdatePaleoscribe message, PacketBuffer buf) {
		buf.writeLong(message.blockPos);
		buf.writeInt(message.selectedPages1);
		buf.writeInt(message.selectedPages2);
		buf.writeInt(message.selectedPages3);
	}
	
	public static class Handler {
		public Handler() {
			
		}
		
		public static void handle(MessageUpdatePaleoscribe message, Supplier<NetworkEvent.Context> context) {
			context.get().setPacketHandled(true);
			PlayerEntity player = context.get().getSender();
			if(context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
				player = PrehistoricFauna.PROXY.getClientSidePlayer();
			}
			if (player != null) {
				if (player.world != null) {
					BlockPos pos = BlockPos.fromLong(message.blockPos);
					if (player.world.getTileEntity(pos) != null) {
						if (player.world.getTileEntity(pos) instanceof TileEntityPaleoscribe) {
							TileEntityPaleoscribe paleoscribe = (TileEntityPaleoscribe) player.world.getTileEntity(pos);
							paleoscribe.selectedPages[0] = EnumPaleoPages.fromInt(message.selectedPages1);
							paleoscribe.selectedPages[1] = EnumPaleoPages.fromInt(message.selectedPages2);
							paleoscribe.selectedPages[2] = EnumPaleoPages.fromInt(message.selectedPages3);
						}
					}
				}
			}
		}
	}

}
