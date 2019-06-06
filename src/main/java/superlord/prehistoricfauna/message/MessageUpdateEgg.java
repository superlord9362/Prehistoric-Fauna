package superlord.prehistoricfauna.message;





import io.netty.buffer.ByteBuf;


import net.minecraft.client.Minecraft;

import net.minecraft.entity.Entity;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import net.minecraftforge.fml.relauncher.Side;

import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.entity.EntityDinosaurEgg;
import superlord.prehistoricfauna.entity.EntityType;



public class MessageUpdateEgg implements IMessage {



	public int dinosaurID;

	public int ordinal;



	public MessageUpdateEgg(int dinosaurID, int ordinal) {

		this.dinosaurID = dinosaurID;

		this.ordinal = ordinal;

	}



	public MessageUpdateEgg() {

	}



	@SideOnly(Side.CLIENT)

	public void onClientReceived(Minecraft client, MessageUpdateEgg message, EntityPlayer player, MessageContext messageContext) {

		Entity entity = player.world.getEntityByID(message.dinosaurID);



		if (entity instanceof EntityDinosaurEgg) {

			EntityDinosaurEgg egg = (EntityDinosaurEgg) entity;

			egg.selfType = EntityType.values()[message.ordinal];

		}

	}



	public void onServerReceived(MinecraftServer server, MessageUpdateEgg message, EntityPlayer player, MessageContext messageContext) {

	}



	@Override

	public void fromBytes(ByteBuf buf) {

		dinosaurID = buf.readInt();

		ordinal = buf.readInt();



	}



	@Override

	public void toBytes(ByteBuf buf) {

		buf.writeInt(dinosaurID);

		buf.writeInt(ordinal);

	}

}