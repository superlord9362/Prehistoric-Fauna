package superlord.prehistoricfauna.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;

public class PFRaft extends Boat {
	private static final EntityDataAccessor<Integer> RAFT_TYPE = SynchedEntityData.defineId(PFRaft.class, EntityDataSerializers.INT);

	public PFRaft(EntityType<? extends Entity> entityType, Level level) {
		super(PFEntities.RAFT.get(), level);
	}

	public PFRaft(Level level, double positionX, double positionY, double positionZ) {
		super(PFEntities.RAFT.get(), level);
		this.setPos(positionX, positionY, positionZ);
		this.setDeltaMovement(Vec3.ZERO);
		this.xo = positionX;
		this.yo = positionY;
		this.zo = positionZ;
	}

	public PFRaft(PlayMessages.SpawnEntity spawnEntity, Level level) {
		this(PFEntities.RAFT.get(), level);
	}

	public double getPassengersRidingOffset() {
		return (this.getPFRaftType() == PFRaftTypes.NEOCALAMITES || this.getPFRaftType() == PFRaftTypes.BAIERA) ? 0.25D : -0.1D;
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("WoodType", this.getPFRaftType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("WoodType", 8)) this.setPFRaftType(PFRaftTypes.byName(compound.getString("WoodType")));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(RAFT_TYPE, PFRaftTypes.NEOCALAMITES.ordinal());
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void setPFRaftType(PFRaftTypes type) {
		this.entityData.set(RAFT_TYPE, type.ordinal());
	}

	public PFRaftTypes getPFRaftType() {
		return PFRaftTypes.byId(this.entityData.get(RAFT_TYPE));
	}

	@Override
	public Boat.Type getVariant() {
		return Boat.Type.OAK;
	}

	@Override
	public void setVariant(Boat.Type boatType) {
	}

	@Override
	public Item getDropItem() {
		switch(this.getPFRaftType()) {
		case NEOCALAMITES:
		default:
			return PFItems.NEOCALAMITES_BOAT.get();
		case BAIERA:
			return PFItems.BAIERA_BOAT.get();
		}
	}

	public enum PFRaftTypes {
		NEOCALAMITES(PFBlocks.NEOCALAMITES_PLANKS.get(), "neocalamites"),
		BAIERA(PFBlocks.BAIERA_PLANKS.get(), "baiera");

		private final String name;
		private final Block planks;

		PFRaftTypes(Block planks, String name) {
			this.name = name;
			this.planks = planks;
		}

		public String getName() {
			return this.name;
		}

		public Block getPlanks() {
			return this.planks;
		}

		public String toString() {
			return this.name;
		}

		public static PFRaftTypes byId(int id) {
			PFRaftTypes[] boatEntityType = values();
			if (id < 0 || id >= boatEntityType.length) {
				id = 0;
			}
			return boatEntityType[id];
		}

		public static PFRaftTypes byName(String name) {
			PFRaftTypes[] boatEntityType = values();

			for (int i = 0; i < boatEntityType.length; ++i) {
				if (boatEntityType[i].getName().equals(name)) {
					return boatEntityType[i];
				}
			}
			return boatEntityType[0];
		}

	}

}
