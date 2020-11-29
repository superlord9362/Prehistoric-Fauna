package superlord.prehistoricfauna.entity.tile;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import superlord.prehistoricfauna.entity.DidelphodonEntity;
import superlord.prehistoricfauna.init.TileEntityRegistry;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class DidelphodonBurrowTileEntity extends TileEntity implements ITickableTileEntity {
   private final List<DidelphodonBurrowTileEntity.Didelphodon> didelphodon = Lists.newArrayList();
   
   public DidelphodonBurrowTileEntity() {
      super(TileEntityRegistry.DIDELPHODON_BURROW);
   }

   public void markDirty() {
      super.markDirty();
   }

   public boolean hasNoDidelphodons() {
      return this.didelphodon.isEmpty();
   }

   public boolean isFullOfDidelphodons() {
      return this.didelphodon.size() == 3;
   }

   public void tryEnterBurrow(Entity entity) {
      this.tryEnterBurrow(entity, 0);
   }

   public int getBeeCount() {
      return this.didelphodon.size();
   }

   public void tryEnterBurrow(Entity entity, int count) {
      if (this.didelphodon.size() < 3) {
    	  entity.stopRiding();
    	  entity.removePassengers();
    	  CompoundNBT compoundnbt = new CompoundNBT();
    	  entity.writeUnlessPassenger(compoundnbt);
    	  this.didelphodon.add(new DidelphodonBurrowTileEntity.Didelphodon(compoundnbt, count, 600));
    	  if (this.world != null) {
    		  BlockPos blockpos = this.getPos();
    		  this.world.playSound((PlayerEntity)null, (double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ(), SoundEvents.BLOCK_BEEHIVE_ENTER, SoundCategory.BLOCKS, 1.0F, 1.0F);
    	  }
    	  entity.remove();
      }
   }

   private boolean releaseDidelphodon(BlockState state, CompoundNBT compound, @Nullable List<Entity> entities, DidelphodonBurrowTileEntity.State burrowState) {
	   BlockPos blockpos = this.getPos();
	   if ((this.world.isNightTime() || this.world.isRaining()) && burrowState != DidelphodonBurrowTileEntity.State.EMERGENCY) {
		   return false;
	   } else {
		   compound.remove("Passengers");
		   compound.remove("Leash");
		   compound.removeUniqueId("UUID");
		   boolean flag = !this.world.getBlockState(blockpos).getCollisionShape(this.world, blockpos).isEmpty();
		   if (flag && burrowState != DidelphodonBurrowTileEntity.State.EMERGENCY) {
			   return false;
		   } else {
			   Entity entity = EntityType.loadEntityAndExecute(compound, this.world, (p_226960_0_) -> {
				   return p_226960_0_;
			   });
			   if (entity != null) {
				   float f = entity.getWidth();
	               double d0 = flag ? 0.0D : 0.55D + (double)(f / 2.0F);
	               double d1 = (double)blockpos.getX() + 0.5D + d0 * blockpos.getX();
	               double d2 = (double)blockpos.getY() + 0.5D - (double)(entity.getHeight() / 2.0F);
	               double d3 = (double)blockpos.getZ() + 0.5D + d0 * blockpos.getZ();
	               entity.setLocationAndAngles(d1, d2, d3, entity.rotationYaw, entity.rotationPitch);
	               if (entity instanceof DidelphodonEntity) {
	            	   DidelphodonEntity didelphodonentity = (DidelphodonEntity)entity;
	            	   didelphodonentity.stayOutOfBurrowCountdown();
	            	   if (entities != null) {
	            		   entities.add(didelphodonentity);
	            	   }
	               }
	               BlockPos blockpos2 = this.getPos();
	               this.world.playSound((PlayerEntity)null, (double)blockpos2.getX(), (double)blockpos2.getY(), (double)blockpos2.getZ(), SoundEvents.BLOCK_BEEHIVE_EXIT, SoundCategory.BLOCKS, 1.0F, 1.0F);
	               return this.world.addEntity(entity);
			   } else {
				   return false;
			   }
		   }
	   }
   }

   private void tickDidelphodons() {
      Iterator<DidelphodonBurrowTileEntity.Didelphodon> iterator = this.didelphodon.iterator();
      BlockState blockstate = this.getBlockState();

      while(iterator.hasNext()) {
         DidelphodonBurrowTileEntity.Didelphodon didelphodonburrowtileentity$didelphodon = iterator.next();
         if (didelphodonburrowtileentity$didelphodon.ticksInBurrow > didelphodonburrowtileentity$didelphodon.minOccupationTicks) {
            CompoundNBT compoundnbt = didelphodonburrowtileentity$didelphodon.entityData;
            DidelphodonBurrowTileEntity.State didelphodonburrowtileentity$state = DidelphodonBurrowTileEntity.State.DIDELPHODON_RELEASED;
            if (this.releaseDidelphodon(blockstate, compoundnbt, (List<Entity>)null, didelphodonburrowtileentity$state)) {
               iterator.remove();
            }
         } else {
        	 didelphodonburrowtileentity$didelphodon.ticksInBurrow++;
         }
      }

   }
   
   public void angerDidelphodon(@Nullable PlayerEntity player, BlockState blockState, DidelphodonBurrowTileEntity.State burrowState) {
	   List<Entity> list = this.tryReleaseDidelphodon(blockState, burrowState);
	   if (player != null) {
		   for(Entity entity : list) {
			   if (entity instanceof DidelphodonEntity) {
				   DidelphodonEntity didelphodonentity = (DidelphodonEntity)entity;
				   if (player.getPositionVec().squareDistanceTo(entity.getPositionVec()) <= 16.0D) {
					   didelphodonentity.setStayOutOfBurrowCountound(400);
				   }
			   }
		   }
	   }
   }
   
   private List<Entity> tryReleaseDidelphodon(BlockState state, DidelphodonBurrowTileEntity.State burrowState) {
	   List<Entity> list = Lists.newArrayList();
	   this.didelphodon.removeIf((p_226966_4_) -> {
		   return this.releaseDidelphodon(state, p_226966_4_.entityData, list, burrowState);
	   });
	   return list;
   }

   public void tick() {
      if (!this.world.isRemote) {
         this.tickDidelphodons();
         BlockPos blockpos = this.getPos();
         if (this.didelphodon.size() > 0 && this.world.getRandom().nextDouble() < 0.005D) {
            double d0 = (double)blockpos.getX() + 0.5D;
            double d1 = (double)blockpos.getY();
            double d2 = (double)blockpos.getZ() + 0.5D;
            this.world.playSound((PlayerEntity)null, d0, d1, d2, SoundEvents.BLOCK_BEEHIVE_WORK, SoundCategory.BLOCKS, 1.0F, 1.0F);
         }
      }
   }

   public void read(CompoundNBT compound) {
      super.read(compound);
      this.didelphodon.clear();
      ListNBT listnbt = compound.getList("Didelphodons", 10);

      for(int i = 0; i < listnbt.size(); ++i) {
         CompoundNBT compoundnbt = listnbt.getCompound(i);
         DidelphodonBurrowTileEntity.Didelphodon didelphodonburrowtileentity$didelphodon = new DidelphodonBurrowTileEntity.Didelphodon(compoundnbt.getCompound("EntityData"), compoundnbt.getInt("TicksInHive"), compoundnbt.getInt("MinOccupationTicks"));
         this.didelphodon.add(didelphodonburrowtileentity$didelphodon);
      }

   }

   public CompoundNBT write(CompoundNBT compound) {
      super.write(compound);
      compound.put("Didelphodon", this.getDidelphodon());
      return compound;
   }

   public ListNBT getDidelphodon() {
      ListNBT listnbt = new ListNBT();

      for(DidelphodonBurrowTileEntity.Didelphodon didelphodonburrowtileentity$didelphodon : this.didelphodon) {
    	  didelphodonburrowtileentity$didelphodon.entityData.removeUniqueId("UUID");
         CompoundNBT compoundnbt = new CompoundNBT();
         compoundnbt.put("EntityData", didelphodonburrowtileentity$didelphodon.entityData);
         compoundnbt.putInt("TicksInHive", didelphodonburrowtileentity$didelphodon.ticksInBurrow);
         compoundnbt.putInt("MinOccupationTicks", didelphodonburrowtileentity$didelphodon.minOccupationTicks);
         listnbt.add(compoundnbt);
      }

      return listnbt;
   }

   static class Didelphodon {
      private final CompoundNBT entityData;
      private int ticksInBurrow;
      private final int minOccupationTicks;
      
      private Didelphodon(CompoundNBT compound, int burrowTicks, int occupationTicks) {
    	  compound.removeUniqueId("UUID");
    	  this.entityData = compound;
    	  this.ticksInBurrow = burrowTicks;
    	  this.minOccupationTicks = occupationTicks;
      }
   }

   public static enum State {
      DIDELPHODON_RELEASED,
      EMERGENCY;
   }
}