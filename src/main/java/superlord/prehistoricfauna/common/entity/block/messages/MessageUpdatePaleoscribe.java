package superlord.prehistoricfauna.common.entity.block.messages;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

        public static void handle(MessageUpdatePaleoscribe message, Supplier<NetworkEvent.Context> context) {
            context.get().setPacketHandled(true);
            Player player = context.get().getSender();
            if(context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT){
                player = PrehistoricFauna.PROXY.getClientSidePlayer();
            }
            if (player != null) {
                if (player.level != null) {
                    BlockPos pos = BlockPos.of(message.blockPos);
                    if (player.level.getBlockEntity(pos) != null) {
                        if (player.level.getBlockEntity(pos) instanceof PaleoscribeBlockEntity) {
                        	PaleoscribeBlockEntity paleoscribe = (PaleoscribeBlockEntity) player.level.getBlockEntity(pos);
                            if(message.updateStack){
                                ItemStack bookStack = paleoscribe.getStackInSlot(0);
                                if(bookStack.getItem() == PFItems.PALEOPEDIA.get()){
                                    EnumPaleoPages.addPage(EnumPaleoPages.fromInt(message.pageOrdinal), bookStack);
                                }
                                paleoscribe.randomizePages(bookStack, paleoscribe.getStackInSlot(1));
                            }else{
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

}