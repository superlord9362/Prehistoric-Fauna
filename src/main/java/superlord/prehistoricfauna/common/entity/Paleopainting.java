package superlord.prehistoricfauna.common.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;

public class Paleopainting extends HangingEntity implements IEntityAdditionalSpawnData {
    public PaleopaintingType paleopainting;

    public Paleopainting(EntityType<? extends Paleopainting> type, Level world) {
        super(type, world);
    }

    public Paleopainting(Level world, BlockPos pos, Direction facing) {
        super(PFEntities.PALEOPAINTING.get(), world, pos);
        List<PaleopaintingType> list = new ArrayList<>();
        int i = 0;

        for (PaleopaintingType paleopainting : PaleopaintingType.VALUES) {
            this.paleopainting = paleopainting;
            this.setDirection(facing);
            if (this.survives()) {
                list.add(paleopainting);
                int j = paleopainting.getWidth() * paleopainting.getHeight();
                if (j > i) {
                    i = j;
                }
            }
        }

        if (!list.isEmpty()) {
            Iterator<PaleopaintingType> iterator = list.iterator();

            while (iterator.hasNext()) {
            	PaleopaintingType paleopainting = iterator.next();
                if (paleopainting.getWidth() * paleopainting.getHeight() < i) {
                    iterator.remove();
                }
            }

            this.paleopainting = list.get(this.random.nextInt(list.size()));
        }

        this.setDirection(facing);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Type", paleopainting.ordinal());
        compound.putByte("Facing", (byte)this.direction.get2DDataValue());
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        paleopainting = PaleopaintingType.VALUES[compound.getInt("Type")];
        this.direction = Direction.from2DDataValue(compound.getByte("Facing"));
        super.readAdditionalSaveData(compound);
        this.setDirection(this.direction);
    }

    @Override
    public int getWidth() {
        return this.paleopainting == null ? 1 : this.paleopainting.getWidth();
    }

    @Override
    public int getHeight() {
        return this.paleopainting == null ? 1 : this.paleopainting.getHeight();
    }

    @Override
    public void dropItem(@Nullable Entity brokenEntity) {
        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.PAINTING_BREAK, 1.0F, 1.0F);
            if (brokenEntity instanceof Player) {
            	Player playerentity = (Player) brokenEntity;
                if (playerentity.getAbilities().instabuild) {
                    return;
                }
            }
            this.spawnAtLocation(PFItems.PALEOPAINTING.get());
        }
    }

    @Override
    public void playPlacementSound() {
        this.playSound(SoundEvents.PAINTING_PLACE, 1.0F, 1.0F);
    }

    @Override
    public void moveTo(double x, double y, double z, float yaw, float pitch) {
        this.setPos(x, y, z);
    }

    @Override
    public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        BlockPos blockpos = this.pos;
        this.setPos(blockpos.getX(), blockpos.getY(), blockpos.getZ());
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public enum PaleopaintingType {
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
        BURIAN(64, 48),
        NATURALIST(80, 96),
        GRAY_NATURALIST(80, 96),
        CRICHTONIAN(16, 16);

        public static final PaleopaintingType[] VALUES = values();

        private final int width;
        private final int height;

        PaleopaintingType(int width, int height) {
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
	public ItemStack getPickResult() {
		return new ItemStack(PFItems.PALEOPAINTING.get());
	}

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer) {
		buffer.writeEnum(paleopainting);
        buffer.writeBlockPos(pos);
        if (direction == null) {
            buffer.writeBoolean(false);
        } else {
            buffer.writeBoolean(true);
            buffer.writeEnum(direction);
        }
	}

	@Override
	public void readSpawnData(FriendlyByteBuf additionalData) {
		this.paleopainting = additionalData.readEnum(PaleopaintingType.class);
        this.pos = additionalData.readBlockPos();
        if (additionalData.readBoolean()) {
            this.setDirection(additionalData.readEnum(Direction.class));
        }		
	}
    
}
