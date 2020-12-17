package superlord.prehistoricfauna.util;

import java.io.IOException;
import java.util.UUID;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.tile.PaleopaintingEntity;
import superlord.prehistoricfauna.entity.tile.PaleopaintingType;

public class SSpawnPaleoPaintingPacket implements IPacket<IPFClientPlayNetHandler> {
   private int entityID;
   private UUID uniqueId;
   private BlockPos position;
   private Direction facing;
   private int title;

   public SSpawnPaleoPaintingPacket() {
   }

   @SuppressWarnings("deprecation")
public SSpawnPaleoPaintingPacket(PaleopaintingEntity painting) {
      this.entityID = painting.getEntityId();
      this.uniqueId = painting.getUniqueID();
      this.position = painting.getHangingPosition();
      this.facing = painting.getHorizontalFacing();
      this.title = PaintingRegistry.PALEOPAINTING.getId(painting.art);
   }

   /**
    * Reads the raw packet data from the data stream.
    */
   public void readPacketData(PacketBuffer buf) throws IOException {
      this.entityID = buf.readVarInt();
      this.uniqueId = buf.readUniqueId();
      this.title = buf.readVarInt();
      this.position = buf.readBlockPos();
      this.facing = Direction.byHorizontalIndex(buf.readUnsignedByte());
   }

   /**
    * Writes the raw packet data to the data stream.
    */
   public void writePacketData(PacketBuffer buf) throws IOException {
      buf.writeVarInt(this.entityID);
      buf.writeUniqueId(this.uniqueId);
      buf.writeVarInt(this.title);
      buf.writeBlockPos(this.position);
      buf.writeByte(this.facing.getHorizontalIndex());
   }

   /**
    * Passes this Packet on to the NetHandler for processing.
    */
   public void processPacket(IPFClientPlayNetHandler handler) {
      handler.handleSpawnPainting(this);
   }

   @OnlyIn(Dist.CLIENT)
   public int getEntityID() {
      return this.entityID;
   }

   @OnlyIn(Dist.CLIENT)
   public UUID getUniqueId() {
      return this.uniqueId;
   }

   @OnlyIn(Dist.CLIENT)
   public BlockPos getPosition() {
      return this.position;
   }

   @OnlyIn(Dist.CLIENT)
   public Direction getFacing() {
      return this.facing;
   }

   @SuppressWarnings("deprecation")
   @OnlyIn(Dist.CLIENT)
   public PaleopaintingType getType() {
      return PaintingRegistry.PALEOPAINTING.getByValue(this.title);
   }
}
