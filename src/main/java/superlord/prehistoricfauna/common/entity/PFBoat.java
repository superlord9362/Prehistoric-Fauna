package superlord.prehistoricfauna.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
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

public class PFBoat extends Boat {
	private static final EntityDataAccessor<Integer> BOAT_TYPE = SynchedEntityData.defineId(PFBoat.class, EntityDataSerializers.INT);

	public PFBoat(EntityType<? extends Entity> entityType, Level level) {
		super(PFEntities.BOAT.get(), level);
	}

	public PFBoat(Level level, double positionX, double positionY, double positionZ) {
		super(PFEntities.BOAT.get(), level);
		this.setPos(positionX, positionY, positionZ);
		this.setDeltaMovement(Vec3.ZERO);
		this.xo = positionX;
		this.yo = positionY;
		this.zo = positionZ;
	}

	public PFBoat(PlayMessages.SpawnEntity spawnEntity, Level level) {
		this(PFEntities.BOAT.get(), level);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("WoodType", this.getPFBoatType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("WoodType", 8)) this.setPFBoatType(PFBoatTypes.byName(compound.getString("WoodType")));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(BOAT_TYPE, PFBoatTypes.ARAUCARIA.ordinal());
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void setPFBoatType(PFBoatTypes type) {
		this.entityData.set(BOAT_TYPE, type.ordinal());
	}

	public PFBoatTypes getPFBoatType() {
		return PFBoatTypes.byId(this.entityData.get(BOAT_TYPE));
	}

	@Override
	public Boat.Type getBoatType() {
		return Boat.Type.OAK;
	}

	@Override
	public void setType(Boat.Type boatType) {
	}

	@Override
	public Item getDropItem() {
		switch(this.getPFBoatType()) {
		case ARAUCARIA:
		default:
			return PFItems.ARAUCARIA_BOAT.get();
		case METASEQUOIA:
			return PFItems.METASEQUOIA_BOAT.get();
		case PROTOPICEOXYLON:
			return PFItems.PROTOPICEOXYLON_BOAT.get();
		case HEIDIPHYLLUM:
			return PFItems.HEIDIPHYLLUM_BOAT.get();
		case LIRIODENDRITES:
			return PFItems.LIRIODENDRITES_BOAT.get();
		case ZAMITES:
			return PFItems.ZAMITES_BOAT.get();
		case PROTOJUNIPEROXYLON:
			return PFItems.PROTOJUNIPEROXYLON_BOAT.get();
		case GINKGO:
			return PFItems.GINKGO_BOAT.get();
		case TROCHODENDROIDES:
			return PFItems.TROCHODENDROIDES_BOAT.get();
		case BRACHYPHYLLUM:
			return PFItems.BRACHYPHYLLUM_BOAT.get();
		case AGATHOXYLON:
			return PFItems.AGATHOXYLON_BOAT.get();
		case WOODWORTHIA:
			return PFItems.WOODWORTHIA_BOAT.get();
		case SCHILDERIA:
			return PFItems.SCHILDERIA_BOAT.get();
		case DRYOPHYLLUM:
			return PFItems.DRYOPHYLLUM_BOAT.get();
		case TAXODIUM:
			return PFItems.TAXODIUM_BOAT.get();
		case SABALITES:
			return PFItems.SABALITES_BOAT.get();
		case PLATANITES:
			return PFItems.PLATANITES_BOAT.get();
		case TAXUS:
			return PFItems.TAXUS_BOAT.get();
		}
	}
	
	public enum PFBoatTypes {
		ARAUCARIA(PFBlocks.ARAUCARIA_PLANKS.get(), "araucaria"),
		METASEQUOIA(PFBlocks.METASEQUOIA_PLANKS.get(), "metasequoia"),
		PROTOPICEOXYLON(PFBlocks.PROTOPICEOXYLON_PLANKS.get(), "protopiceoxylon"),
		HEIDIPHYLLUM(PFBlocks.HEIDIPHYLLUM_PLANKS.get(), "heidiphyllum"),
		LIRIODENDRITES(PFBlocks.LIRIODENDRITES_PLANKS.get(), "liriodendrites"),
		ZAMITES(PFBlocks.ZAMITES_PLANKS.get(), "zamites"),
		PROTOJUNIPEROXYLON(PFBlocks.PROTOJUNIPEROXYLON_PLANKS.get(), "protojuniperoxylon"),
		GINKGO(PFBlocks.GINKGO_PLANKS.get(), "ginkgo"),
		TROCHODENDROIDES(PFBlocks.TROCHODENDROIDES_PLANKS.get(), "trochodendroides"),
		BRACHYPHYLLUM(PFBlocks.BRACHYPHYLLUM_PLANKS.get(), "brachyphyllum"),
		AGATHOXYLON(PFBlocks.AGATHOXYLON_PLANKS.get(), "agathoxylon"),
		WOODWORTHIA(PFBlocks.WOODWORTHIA_PLANKS.get(), "woodworthia"),
		SCHILDERIA(PFBlocks.SCHILDERIA_PLANKS.get(), "schilderia"),
		DRYOPHYLLUM(PFBlocks.DRYOPHYLLUM_PLANKS.get(), "dryophyllum"),
		TAXODIUM(PFBlocks.TAXODIUM_PLANKS.get(), "taxodium"),
		SABALITES(PFBlocks.SABALITES_PLANKS.get(), "sabalites"),
		PLATANITES(PFBlocks.PLATANITES_PLANKS.get(), "platanites"),
		TAXUS(PFBlocks.TAXUS_PLANKS.get(), "taxus");
		
		private final String name;
		private final Block planks;
		
		PFBoatTypes(Block planks, String name) {
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
		
		public static PFBoatTypes byId(int id) {
			PFBoatTypes[] boatEntityType = values();
			if (id < 0 || id >= boatEntityType.length) {
				id = 0;
			}
			return boatEntityType[id];
		}
		
		public static PFBoatTypes byName(String name) {
			PFBoatTypes[] boatEntityType = values();
			
			for (int i = 0; i < boatEntityType.length; ++i) {
				if (boatEntityType[i].getName().equals(name)) {
					return boatEntityType[i];
				}
			}
			return boatEntityType[0];
		}
		
	}
	
}
