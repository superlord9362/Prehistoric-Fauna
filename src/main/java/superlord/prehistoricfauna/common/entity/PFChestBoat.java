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
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import superlord.prehistoricfauna.common.entity.PFBoat.PFBoatTypes;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;

public class PFChestBoat extends ChestBoat {

	private static final EntityDataAccessor<Integer> CHEST_BOAT_TYPE = SynchedEntityData.defineId(PFChestBoat.class, EntityDataSerializers.INT);

	public PFChestBoat(EntityType<? extends Entity> entityType, Level world) {
		super(PFEntities.CHEST_BOAT.get(), world);
	}

	public PFChestBoat(Level world, double positionX, double positionY, double positionZ) {
		super(PFEntities.CHEST_BOAT.get(), world);
		this.setPos(positionX, positionY, positionZ);
		this.setDeltaMovement(Vec3.ZERO);
		this.xo = positionX;
		this.yo = positionY;
		this.zo = positionZ;
	}

	public PFChestBoat(PlayMessages.SpawnEntity spawnEntity, Level world) {
		this(PFEntities.CHEST_BOAT.get(), world);
	}

	public double getPassengersRidingOffset() {
		return this.getPFChestBoatType() == PFBoatTypes.NEOCALAMITES ? 0.25D : -0.1D;
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("WoodType", this.getPFChestBoatType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("WoodType", 8)) this.setPFChestBoatType(PFBoatTypes.byName(compound.getString("WoodType")));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CHEST_BOAT_TYPE, PFBoatTypes.ARAUCARIA.ordinal());
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public void setPFChestBoatType(PFBoatTypes type) {
		this.entityData.set(CHEST_BOAT_TYPE, type.ordinal());
	}

	public PFBoatTypes getPFChestBoatType() {
		return PFBoatTypes.byId(this.entityData.get(CHEST_BOAT_TYPE));
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
		switch(this.getPFChestBoatType()) {
		case ARAUCARIA:
		default:
			return PFItems.ARAUCARIA_CHEST_BOAT.get();
		case METASEQUOIA:
			return PFItems.METASEQUOIA_CHEST_BOAT.get();
		case PROTOPICEOXYLON:
			return PFItems.PROTOPICEOXYLON_CHEST_BOAT.get();
		case HEIDIPHYLLUM:
			return PFItems.HEIDIPHYLLUM_CHEST_BOAT.get();
		case LIRIODENDRITES:
			return PFItems.LIRIODENDRITES_CHEST_BOAT.get();
		case ZAMITES:
			return PFItems.MONANTHESIA_CHEST_BOAT.get();
		case PROTOJUNIPEROXYLON:
			return PFItems.PROTOJUNIPEROXYLON_CHEST_BOAT.get();
		case GINKGO:
			return PFItems.GINKGO_CHEST_BOAT.get();
		case TROCHODENDROIDES:
			return PFItems.TROCHODENDROIDES_CHEST_BOAT.get();
		case BRACHYPHYLLUM:
			return PFItems.BRACHYPHYLLUM_CHEST_BOAT.get();
		case AGATHOXYLON:
			return PFItems.AGATHOXYLON_CHEST_BOAT.get();
		case WOODWORTHIA:
			return PFItems.WOODWORTHIA_CHEST_BOAT.get();
		case SCHILDERIA:
			return PFItems.SCHILDERIA_CHEST_BOAT.get();
		case DRYOPHYLLUM:
			return PFItems.DRYOPHYLLUM_CHEST_BOAT.get();
		case TAXODIUM:
			return PFItems.TAXODIUM_CHEST_BOAT.get();
		case SABALITES:
			return PFItems.SABALITES_CHEST_BOAT.get();
		case PLATANITES:
			return PFItems.PLATANITES_CHEST_BOAT.get();
		case TAXUS:
			return PFItems.TAXUS_CHEST_BOAT.get();
		case CZEKANOWSKIA:
			return PFItems.CZEKANOWSKIA_CHEST_BOAT.get();
		case SCHIZOLEPIDOPSIS:
			return PFItems.SCHIZOLEPIDOPSIS_CHEST_BOAT.get();
		case PODOZAMITES:
			return PFItems.PODOZAMITES_CHEST_BOAT.get();
		case NEOCALAMITES:
			return PFItems.NEOCALAMITES_CHEST_BOAT.get();
		}
	}

}

