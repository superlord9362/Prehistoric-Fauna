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

public class WallFossil extends HangingEntity implements IEntityAdditionalSpawnData {
    public WallFossilType wallfossil;

    public WallFossil(EntityType<? extends WallFossil> type, Level world) {
        super(type, world);
    }

    public WallFossil(Level world, BlockPos pos, Direction facing) {
        super(PFEntities.WALL_FOSSIL.get(), world, pos);
        List<WallFossilType> list = new ArrayList<>();
        int i = 0;

        for (WallFossilType wallfossil : WallFossilType.VALUES) {
            this.wallfossil = wallfossil;
            this.setDirection(facing);
            if (this.survives()) {
                list.add(wallfossil);
                int j = wallfossil.getWidth() * wallfossil.getHeight();
                if (j > i) {
                    i = j;
                }
            }
        }

        if (!list.isEmpty()) {
            Iterator<WallFossilType> iterator = list.iterator();

            while (iterator.hasNext()) {
            	WallFossilType wallfossil = iterator.next();
                if (wallfossil.getWidth() * wallfossil.getHeight() < i) {
                    iterator.remove();
                }
            }

            this.wallfossil = list.get(this.random.nextInt(list.size()));
        }

        this.setDirection(facing);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Type", wallfossil.ordinal());
        compound.putByte("Facing", (byte)this.direction.get2DDataValue());
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
    	wallfossil = WallFossilType.VALUES[compound.getInt("Type")];
        this.direction = Direction.from2DDataValue(compound.getByte("Facing"));
        super.readAdditionalSaveData(compound);
        this.setDirection(this.direction);
    }

    @Override
    public int getWidth() {
        return this.wallfossil == null ? 1 : this.wallfossil.getWidth();
    }

    @Override
    public int getHeight() {
        return this.wallfossil == null ? 1 : this.wallfossil.getHeight();
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
            this.spawnAtLocation(PFItems.WALL_FOSSIL.get());
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

    public enum WallFossilType {
    	 ARCHAEOPTERYX(32, 32),
         CLAMS(16, 16),
         CRAB(16, 16),
         DINOSAUR(48, 32),
         ICHTHYOSAUR(64, 32),
         JAW(32, 16),
         LEAVES(16, 32),
         LONG_FISH(32, 16),
         LOTS_OF_FISH(32, 32),
         PTEROSAUR(48, 32),
         SHELLS(48, 32),
         SMALL_AMMONITE(16, 16),
         SMALL_FISH(16, 16),
         TRILOBITE(16, 16),
         XIPHACTINUS(96, 32),
         HORSESHOE(32, 16),
         LONGISQUAMA(32, 32),
         HYPHALOSAURUS(16, 32),
         TULLIMONSTRUM(32, 16);

        public static final WallFossilType[] VALUES = values();

        private final int width;
        private final int height;

        WallFossilType(int width, int height) {
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
		return new ItemStack(PFItems.WALL_FOSSIL.get());
	}

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer) {
		buffer.writeEnum(wallfossil);
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
		this.wallfossil = additionalData.readEnum(WallFossilType.class);
        this.pos = additionalData.readBlockPos();
        if (additionalData.readBoolean()) {
            this.setDirection(additionalData.readEnum(Direction.class));
        }		
	}
    
}
