package superlord.prehistoricfauna.common.entity.block.messages;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;

public class MessageUpdatePaleoscribe {

    public long blockPos;
    public int selectedPages1;
    public int selectedPages2;
    public int selectedPages3;
    public boolean updateStack;
    public int pageOrdinal;

    public MessageUpdatePaleoscribe(long blockPos, int selectedPages1, int selectedPages2, int selectedPages3, boolean updateStack, int pageOrdinal) {
        this.blockPos = blockPos;
        this.selectedPages1 = selectedPages1;
        this.selectedPages2 = selectedPages2;
        this.selectedPages3 = selectedPages3;
        this.updateStack = updateStack;
        this.pageOrdinal = pageOrdinal;

    }

    public MessageUpdatePaleoscribe() {
    }
    
    public static MessageUpdatePaleoscribe read(FriendlyByteBuf buf) {
        return new MessageUpdatePaleoscribe(buf.readLong(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readBoolean(), buf.readInt());
    }
    
    public static void write(MessageUpdatePaleoscribe message, FriendlyByteBuf buf) {
        buf.writeLong(message.blockPos);
        buf.writeInt(message.selectedPages1);
        buf.writeInt(message.selectedPages2);
        buf.writeInt(message.selectedPages3);
        buf.writeBoolean(message.updateStack);
        buf.writeInt(message.pageOrdinal);
    }

    public static class Handler {
        public Handler() {
        }
        
        public static void handle(MessageUpdatePaleoscribe message, Supplier<NetworkEvent.Context> ctx) {
        	ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER, () -> () -> MessageUpdatePaleoscribe.Handler.handlePacket(message, ctx)));
        	ctx.get().enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> MessageUpdatePaleoscribe.Handler.handlePacket(message, ctx)));
        	ctx.get().setPacketHandled(true);
        }
        
        @SuppressWarnings("deprecation")
		public static void handlePacket(final MessageUpdatePaleoscribe message, final Supplier<NetworkEvent.Context> contextSupplier) {
        	NetworkEvent.Context context = contextSupplier.get();
        	context.enqueueWork(() -> {
        		Player player = context.getSender();
        		if (context.getDirection().getReceptionSide() == LogicalSide.CLIENT) player = PrehistoricFauna.PROXY.getClientSidePlayer();
        		if (player != null) {
        			BlockPos pos = BlockPos.of(message.blockPos);
        			if (player.level().hasChunkAt(pos) && player.level().getBlockEntity(pos) instanceof PaleoscribeBlockEntity paleoscribe) {
        				if (message.updateStack) {
        					ItemStack bookStack = paleoscribe.getItem(0);
        					if (bookStack.getItem() == PFItems.PALEOPEDIA.get()) {
        						EnumPaleoPages.addPage(EnumPaleoPages.fromInt(message.pageOrdinal), bookStack);
        					}
        					paleoscribe.randomizePages(bookStack, paleoscribe.getItem(1));
        				} else {
        					paleoscribe.selectedPages[0] = EnumPaleoPages.fromInt(message.selectedPages1);
        					paleoscribe.selectedPages[1] = EnumPaleoPages.fromInt(message.selectedPages2);
        					paleoscribe.selectedPages[2] = EnumPaleoPages.fromInt(message.selectedPages3);
        				}
        			}
        		}
        	});
        	context.setPacketHandled(true);
        }
    }

}