package superlord.prehistoricfauna.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFEntities;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaleopaintingEntity extends HangingEntity implements IEntityAdditionalSpawnData {
    public Paleopainting paleopainting;

    public PaleopaintingEntity(EntityType<? extends PaleopaintingEntity> type, World world) {
        super(type, world);
    }

    public PaleopaintingEntity(World world, BlockPos pos, Direction facing) {
        super(PFEntities.PALEOPAINTING, world, pos);
        List<Paleopainting> list = new ArrayList<>();
        int i = 0;

        for (Paleopainting paleopainting : Paleopainting.VALUES) {
            this.paleopainting = paleopainting;
            this.updateFacingWithBoundingBox(facing);
            if (this.onValidSurface()) {
                list.add(paleopainting);
                int j = paleopainting.getWidth() * paleopainting.getHeight();
                if (j > i) {
                    i = j;
                }
            }
        }

        if (!list.isEmpty()) {
            Iterator<Paleopainting> iterator = list.iterator();

            while (iterator.hasNext()) {
                Paleopainting paleopainting = iterator.next();
                if (paleopainting.getWidth() * paleopainting.getHeight() < i) {
                    iterator.remove();
                }
            }

            this.paleopainting = list.get(this.rand.nextInt(list.size()));
        }

        this.updateFacingWithBoundingBox(facing);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putInt("Type", paleopainting.ordinal());
        compound.putByte("Facing", (byte)this.facingDirection.getHorizontalIndex());
        super.writeAdditional(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        paleopainting = Paleopainting.VALUES[compound.getInt("Type")];
        this.facingDirection = Direction.byHorizontalIndex(compound.getByte("Facing"));
        super.readAdditional(compound);
        this.updateFacingWithBoundingBox(this.facingDirection);
    }

    @Override
    public int getWidthPixels() {
        return this.paleopainting == null ? 1 : this.paleopainting.getWidth();
    }

    @Override
    public int getHeightPixels() {
        return this.paleopainting == null ? 1 : this.paleopainting.getHeight();
    }

    @Override
    public void onBroken(@Nullable Entity brokenEntity) {
        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
            this.playSound(SoundEvents.ENTITY_PAINTING_BREAK, 1.0F, 1.0F);
            if (brokenEntity instanceof PlayerEntity) {
                PlayerEntity playerentity = (PlayerEntity) brokenEntity;
                if (playerentity.abilities.isCreativeMode) {
                    return;
                }
            }

            this.entityDropItem(PFItems.PALEOPAINTING.get());
        }
    }

    @Override
    public void playPlaceSound() {
        this.playSound(SoundEvents.ENTITY_PAINTING_PLACE, 1.0F, 1.0F);
    }

    @Override
    public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
        this.setPosition(x, y, z);
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        BlockPos blockpos = this.hangingPosition;
        this.setPosition(blockpos.getX(), blockpos.getY(), blockpos.getZ());
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeEnumValue(paleopainting);
        buffer.writeBlockPos(hangingPosition);
        if (facingDirection == null) {
            buffer.writeBoolean(false);
        } else {
            buffer.writeBoolean(true);
            buffer.writeEnumValue(facingDirection);
        }
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {
        this.paleopainting = additionalData.readEnumValue(Paleopainting.class);
        this.hangingPosition = additionalData.readBlockPos();
        if (additionalData.readBoolean()) {
            this.updateFacingWithBoundingBox(additionalData.readEnumValue(Direction.class));
        }
    }

    public enum Paleopainting {
        AMNIOTIC(32, 32),
        ANNING(32, 32),
        NIGHTSTAND(32, 16),
        DYNASTIC(16, 16),
        TALL_BUSTS(16, 32),
        BOLIDE(16, 32),
        NEIGHBOR(48, 16),
        CUBE(32, 32),
        SERENITY(64, 48),
        LAELAPS(64, 48),
        CRYOGENIAN(64, 32),
        ELECTROCUTION(64, 48),
        LIFEBLOOD(16, 16),
        DUEL_OF_TIME(48, 48),
        CHRONOSTRATIGRAPHIC(16, 32),
        BURIAN(64, 48);

        public static final Paleopainting[] VALUES = values();

        private final int width;
        private final int height;

        Paleopainting(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
    
    @Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(PFItems.PALEOPAINTING.get());
	}
    
}
