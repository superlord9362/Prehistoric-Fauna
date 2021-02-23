package superlord.prehistoricfauna.entity.tile;

import java.util.function.Supplier;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.util.EnumPaleoPages;

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

    public static MessageUpdatePaleoscribe read(PacketBuffer buf) {
        return new MessageUpdatePaleoscribe(buf.readLong(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readBoolean(), buf.readInt());
    }

    public static void write(MessageUpdatePaleoscribe message, PacketBuffer buf) {
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

        public static void handle(MessageUpdatePaleoscribe message, Supplier<NetworkEvent.Context> context) {
            context.get().setPacketHandled(true);
            PlayerEntity player = context.get().getSender();
            if(context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT){
                player = PrehistoricFauna.PROXY.getClientSidePlayer();
            }
            if (player != null) {
                if (player.world != null) {
                    BlockPos pos = BlockPos.fromLong(message.blockPos);
                    if (player.world.getTileEntity(pos) != null) {
                        if (player.world.getTileEntity(pos) instanceof PaleoscribeTileEntity) {
                        	PaleoscribeTileEntity lectern = (PaleoscribeTileEntity) player.world.getTileEntity(pos);
                            if(message.updateStack){
                                ItemStack bookStack = lectern.getStackInSlot(0);
                                if(bookStack.getItem() == ItemInit.PALEOPEDIA.get()){
                                	EnumPaleoPages.addPage(EnumPaleoPages.fromInt(message.pageOrdinal), bookStack);
                                }
                                lectern.randomizePages(bookStack, lectern.getStackInSlot(1));
                            }else{
                                lectern.selectedPages[0] = EnumPaleoPages.fromInt(message.selectedPages1);
                                lectern.selectedPages[1] = EnumPaleoPages.fromInt(message.selectedPages2);
                                lectern.selectedPages[2] = EnumPaleoPages.fromInt(message.selectedPages3);
                            }

                        }
                    }
                }
            }
        }
    }

}
