package superlord.prehistoricfauna.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;

public class PrehistoricBoatEntity extends BoatEntity {
    private static final DataParameter<Integer> PF_BOAT_TYPE = EntityDataManager.createKey(PrehistoricBoatEntity.class, DataSerializers.VARINT);
    private BoatEntity.Status status;
    @SuppressWarnings("unused")
	private double lastYd;

    public PrehistoricBoatEntity(World worldIn, double x, double y, double z) {
        this(ModEntityTypes.BOAT, worldIn);
        this.setPosition(x, y, z);
        this.setMotion(Vec3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    public PrehistoricBoatEntity(EntityType<? extends BoatEntity> boatEntityType, World worldType) {
        super(boatEntityType, worldType);
    }

    public PrehistoricBoatEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        super(ModEntityTypes.BOAT, world);
    }


    @Override
    public Item getItemBoat() {
        switch (this.getPFBoatType()) {
            default:
                return ItemInit.ARAUCARIA_BOAT.get();
            case METASEQUOIA:
                return ItemInit.METASEQUOIA_BOAT.get();
            case PROTOPICEOXYLON:
                return ItemInit.PROTOPICEOXYLON_BOAT.get();
            case ZAMITES:
                return ItemInit.ZAMITES_BOAT.get();
            case PROTOJUNIPER:
            	return ItemInit.PROTOJUNIPER_BOAT.get();
            case HEIDIPHYLLUM:
            	return ItemInit.HEIDIPHYLLUM_BOAT.get();
            case LIRIODENDRITES:
            	return ItemInit.LIRIODENDRITES_BOAT.get();
        }
    }

    public Block getPlanks() {
        switch (this.getPFBoatType()) {
            default:
                return BlockInit.ARAUCARIA_PLANKS.get();
            case METASEQUOIA:
                return BlockInit.METASEQUOIA_PLANKS.get();
            case PROTOPICEOXYLON:
                return BlockInit.PROTOPICEOXYLON_PLANKS.get();
            case ZAMITES:
                return BlockInit.ZAMITES_PLANKS.get();
            case PROTOJUNIPER:
            	return BlockInit.PROTOJUNIPEROXYLON_PLANKS.get();
            case HEIDIPHYLLUM:
            	return BlockInit.HEIDIPHYLLUM_PLANKS.get();
            case LIRIODENDRITES:
            	return BlockInit.LIRIODENDRITES_PLANKS.get();
        }
    }

    public PFType getPFBoatType() {
        return PFType.byId(this.dataManager.get(PF_BOAT_TYPE));
    }

    public void setPFBoatType(PFType boatPFType) {
        this.dataManager.set(PF_BOAT_TYPE, boatPFType.ordinal());
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(PF_BOAT_TYPE, PFType.ARAUCARIA.ordinal());
    }


    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putString("PFType", this.getPFBoatType().getName());
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        if (compound.contains("PFType", 8)) {
            this.setPFBoatType(PFType.getTypeFromString(compound.getString("PFType")));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0F);
    }


    @SuppressWarnings("deprecation")
	@Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        this.lastYd = this.getMotion().y;
        if (!this.isPassenger()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != BoatEntity.Status.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.onLivingFall(this.fallDistance, 1.0F);
                    if (!this.world.isRemote && !this.removed) {
                        this.remove();
                        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.entityDropItem(this.getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.entityDropItem(Items.STICK);
                            }

                            this.entityDropItem(Blocks.AIR);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.world.getFluidState((new BlockPos(this)).down()).isTagged(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }

        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.world.isRemote && !this.removed) {
            if (source instanceof IndirectEntityDamageSource && source.getTrueSource() != null && this.isPassenger(source.getTrueSource())) {
                return false;
            } else {
                this.setForwardDirection(-this.getForwardDirection());
                this.setTimeSinceHit(10);
                this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
                this.markVelocityChanged();
                boolean flag = source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity) source.getTrueSource()).abilities.isCreativeMode;
                if (flag || this.getDamageTaken() > 40.0F) {
                    if (!flag && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                        this.entityDropItem(this.getItemBoat());
                    }

                    this.remove();
                }

                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

	public enum PFType {
        ARAUCARIA("araucaria"),
        METASEQUOIA("metasequoia"),
        PROTOPICEOXYLON("protopiceoxylon"),
        ZAMITES("zamites"),
        PROTOJUNIPER("protojuniper"),
        HEIDIPHYLLUM("heidiphyllum"),
        LIRIODENDRITES("liriodendrites");


        private final String name;

        PFType(String string) {
            this.name = string;
        }

        public static PFType byId(int id) {
            PFType[] aPFBoatEntity$PFType = values();
            if (id < 0 || id >= aPFBoatEntity$PFType.length) {
                id = 0;
            }

            return aPFBoatEntity$PFType[id];
        }

        public static PFType getTypeFromString(String nameIn) {
            PFType[] aPFBoatEntity$PFType = values();

            for (PFType PFType : aPFBoatEntity$PFType) {
                if (PFType.getName().equals(nameIn)) {
                    return PFType;
                }
            }

            return aPFBoatEntity$PFType[0];
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }
}