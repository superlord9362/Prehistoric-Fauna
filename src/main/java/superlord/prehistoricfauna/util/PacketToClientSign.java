package superlord.prehistoricfauna.util;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.PacketDistributor;
import superlord.prehistoricfauna.entity.render.PFEditSignScreen;
import superlord.prehistoricfauna.entity.tile.PFSignTileEntity;

public class PacketToClientSign
{
	private boolean messageIsValid;
	private BlockPos pos;

	public PacketToClientSign(BlockPos pos)
	{
		this.pos = pos;
		this.messageIsValid = true;
	}

	public PacketToClientSign(PacketBuffer packetBuffer)
	{
		this.pos = packetBuffer.readBlockPos();
		this.messageIsValid = packetBuffer.readBoolean();
	}

	public PacketToClientSign()
	{

	}

	public void encode(PacketBuffer packetBuffer)
	{
		packetBuffer.writeBlockPos(this.pos);
		packetBuffer.writeBoolean(this.messageIsValid);
	}

	public static PacketToClientSign decoder(PacketBuffer packetBuffer)
	{
		PacketToClientSign packet = new PacketToClientSign();
		packet.pos = packetBuffer.readBlockPos();
		packet.messageIsValid = packetBuffer.readBoolean();
		return packet;
	}

	public static void handle(PacketToClientSign packet, Supplier<NetworkEvent.Context> supplier)
	{
		Context context = supplier.get();
		if (context != null)
		{
			if (packet != null && packet.messageIsValid)
			{
				context.enqueueWork(() -> PacketToClientSign.handleOnClient(packet));
				context.setPacketHandled(true);
			}
			else
				context.setPacketHandled(false);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static void handleOnClient(PacketToClientSign packet)
	{
		if (Minecraft.getInstance().world != null)
		{
			TileEntity tileEntity = Minecraft.getInstance().world.getTileEntity(packet.pos);
			if (tileEntity instanceof PFSignTileEntity)
			{
				PFSignTileEntity signTileEntity = (PFSignTileEntity) tileEntity;
				Minecraft.getInstance().displayGuiScreen(new PFEditSignScreen(signTileEntity));
			}
		}
	}

	public static void sendMessage(ServerPlayerEntity player, BlockPos pos)
	{
		PFPacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new PacketToClientSign(pos));
	}
}
