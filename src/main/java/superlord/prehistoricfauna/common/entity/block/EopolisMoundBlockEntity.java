package superlord.prehistoricfauna.common.entity.block;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eopolis;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class EopolisMoundBlockEntity extends BlockEntity {
	public static final String MIN_OCCUPATION_TICKS = "MinOccupationTicks";
	public static final String ENTITY_DATA = "EntityData";
	public static final String TICKS_IN_MOUND = "TicksInMound";
	public static final String EOPOLIS = "Eopolis";
	private static final List<String> IGNORED_EOPOLIS_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain", "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems", "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "NoGravity", "OnGround", "PortalCooldown", "Pos", "Rotation", "CannotEnterHiveTicks", "TicksSincePollination", "CropsGrownSincePollination", "HivePos", "Passengers", "Leash", "UUID");
	public static final int MAX_OCCUPANTS = 5;
	@SuppressWarnings("unused")
	private static final int MIN_TICKS_BEFORE_REENTERING_MOUND = 400;
	private final List<EopolisMoundBlockEntity.EopolisData> stored = Lists.newArrayList();

	public EopolisMoundBlockEntity(BlockPos pos, BlockState state) {
		super(PFBlockEntities.EOPOLIS_MOUND.get(), pos, state);
	}

	public void setChanged() {
		if (this.isFireNearby()) {
			this.emptyAllLivingFromMound((Player)null, this.level.getBlockState(this.getBlockPos()), EopolisMoundBlockEntity.EopolisReleaseStatus.EMERGENCY);
		}
		super.setChanged();
	}

	public boolean isFireNearby() {
		if (this.level == null) {
			return false;
		} else {
			for (BlockPos blockpos : BlockPos.betweenClosed(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1))) {
				if (this.level.getBlockState(blockpos).getBlock() instanceof FireBlock) {
					return true;
				}
			}
			return false;
		}
	}

	public boolean isEmpty() {
		return this.stored.isEmpty();
	}

	public boolean isFull() {
		return this.stored.size() == 5;
	}

	public void emptyAllLivingFromMound(@Nullable Player player, BlockState state, EopolisMoundBlockEntity.EopolisReleaseStatus status) {
		List<Entity> list = this.releaseAllOccupants(state, status);
		if (player != null) {
			for (Entity entity : list) {
				if (entity instanceof Eopolis) {
					Eopolis eopolis = (Eopolis) entity;
					eopolis.setStayOutOfMoundCountdown(400);
				}
			}
		}
	}

	private List<Entity> releaseAllOccupants(BlockState state, EopolisMoundBlockEntity.EopolisReleaseStatus status) {
		List<Entity> list = Lists.newArrayList();
		this.stored.removeIf((p_272556_) -> {
			return releaseOccupant(this.level, this.worldPosition, state, p_272556_, list, status);
		});
		if (!list.isEmpty()) {
			super.setChanged();
		}
		return list;
	}

	public void addOccupant(Entity entity, boolean p_58743_) {
		this.addOccupantWithPresetTicks(entity, p_58743_, 0);
	}

	@VisibleForDebug
	public int getOccupantCount() {
		return this.stored.size();
	}

	public void addOccupantWithPresetTicks(Entity entity, boolean p_58746_, int p_58747_) {
		if (this.stored.size() < 5) {
			entity.stopRiding();
			entity.ejectPassengers();
			CompoundTag compoundtag = new CompoundTag();
			entity.save(compoundtag);
			this.storeEopolis(compoundtag, p_58747_, p_58746_);
			if (this.level != null) {
				BlockPos blockpos = this.getBlockPos();
				this.level.playSound((Player)null, (double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ(), SoundEvents.BEEHIVE_ENTER, SoundSource.BLOCKS, 1.0F, 1.0F);
				this.level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(entity, this.getBlockState()));
			}
			entity.discard();
			super.setChanged();
		}
	}

	public void storeEopolis(CompoundTag p_155158_, int p_155159_, boolean p_155160_) {
		this.stored.add(new EopolisMoundBlockEntity.EopolisData(p_155158_, p_155159_, p_155160_ ? 2400 : 600));
	}
	
	private static boolean releaseOccupant(Level level, BlockPos pos, BlockState state, EopolisMoundBlockEntity.EopolisData eopolisData, @Nullable List<Entity> list, EopolisMoundBlockEntity.EopolisReleaseStatus status) {
		if ((level.isNight() || level.isRaining()) && status != EopolisMoundBlockEntity.EopolisReleaseStatus.EMERGENCY) {
			return false;
		} else {
			CompoundTag tag = eopolisData.entityData.copy();
			tag.put("MoundPos", NbtUtils.writeBlockPos(pos));
			BlockPos blockPos = pos.relative(Direction.UP);
			for (int i = blockPos.getY(); i < blockPos.getY() + 100; i++) {
				BlockPos newPos = new BlockPos(blockPos.getX(), i, blockPos.getZ());
				if (level.getBlockState(newPos).getBlock() == Blocks.AIR) {
					blockPos = newPos;
					break;
				} else continue;
			}
			boolean flag = !level.getBlockState(blockPos).getCollisionShape(level, blockPos).isEmpty();
			if (flag && status != EopolisMoundBlockEntity.EopolisReleaseStatus.EMERGENCY) {
				return false;
			} else {
				Entity entity = EntityType.loadEntityRecursive(tag, level, (p_58740_) -> {
					return p_58740_;
				});
				if (entity != null) {
					if (!(entity instanceof Eopolis)) {
						return false;
					} else {
						if (entity instanceof Eopolis eopolis) {
							setEopolisReleaseData(eopolisData.ticksInMound, eopolis);
							if (list != null) {
								list.add(eopolis);
							}
							float f = entity.getBbWidth();
							double d3 = flag ? 0.0D : 0.55D + (double)(f / 2);
							double d0 = (double)pos.getX() + 0.5D + d3 * (double)1;
							double d1 = (double)pos.getY() + 0.5D - (double)(entity.getBbHeight() / 2);
							double d2 = (double)pos.getZ() + 0.5D + d3 * (double)1;
							entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
						}
						level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, level.getBlockState(pos)));
						return level.addFreshEntity(entity);
					}
				} else {
					return false;
				}
			}
		}
	}

	static void removeIgnoredEopolisTags(CompoundTag tag) {
		for (String s : IGNORED_EOPOLIS_TAGS) {
			tag.remove(s);
		}
	}

	private static void setEopolisReleaseData(int p_58737_, Eopolis eopolis) {
		int i = eopolis.getAge();
		if (i < 0) {
			eopolis.setAge(Math.min(0, i + p_58737_));
		} else if (i > 0) {
			eopolis.setAge(Math.max(0, i - p_58737_));
		}
		eopolis.setInLoveTime(Math.max(0, eopolis.getInLoveTime() - p_58737_));
	}
	
	private static void tickOccupants(Level level, BlockPos pos, BlockState state, List<EopolisMoundBlockEntity.EopolisData> data) {
		boolean flag = false;
		EopolisMoundBlockEntity.EopolisData eopolismoundblockentity$eopolisdata;
		for (Iterator<EopolisMoundBlockEntity.EopolisData> iterator = data.iterator(); iterator.hasNext(); ++eopolismoundblockentity$eopolisdata.ticksInMound) {
			eopolismoundblockentity$eopolisdata = iterator.next();
			if (eopolismoundblockentity$eopolisdata.ticksInMound > eopolismoundblockentity$eopolisdata.minOccupationTicks) {
				EopolisMoundBlockEntity.EopolisReleaseStatus eopolismoundblockentity$eopolisreleasestatus = EopolisMoundBlockEntity.EopolisReleaseStatus.EOPOLIS_RELEASED;
				if (releaseOccupant(level, pos, state, eopolismoundblockentity$eopolisdata, (List<Entity>)null, eopolismoundblockentity$eopolisreleasestatus)) {
					flag = true;
					iterator.remove();
				}
			}
		}
		if (flag) {
			setChanged(level, pos, state);
		}
	}
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, EopolisMoundBlockEntity blockEntity) {
		tickOccupants(level, pos, state, blockEntity.stored);
	}
	
	public void load(CompoundTag tag) {
		super.load(tag);
		this.stored.clear();
		ListTag listtag = tag.getList("Eopolis", 10);
		for (int i = 0; i < listtag.size(); ++i) {
			CompoundTag compoundTag = listtag.getCompound(i);
			EopolisMoundBlockEntity.EopolisData eopolismoundblockentity$eopolisdata = new EopolisMoundBlockEntity.EopolisData(compoundTag.getCompound("EntityData"), compoundTag.getInt("TicksInMound"), compoundTag.getInt("MinOccupationTicks"));
			this.stored.add(eopolismoundblockentity$eopolisdata);
		}
	}
	
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.put("Eopolis", this.writeEopolis());
	}
	
	public ListTag writeEopolis() {
		ListTag listtag = new ListTag();
		for (EopolisMoundBlockEntity.EopolisData eopolismoundblockentity$eopolisdata : this.stored) {
			CompoundTag compoundTag = eopolismoundblockentity$eopolisdata.entityData.copy();
			compoundTag.remove("UUID");
			CompoundTag compoundTag1 = new CompoundTag();
			compoundTag1.put("EntityData", compoundTag);
			compoundTag1.putInt("TicksInMound", eopolismoundblockentity$eopolisdata.ticksInMound);
			compoundTag1.putInt("MinOccupationTicks", eopolismoundblockentity$eopolisdata.minOccupationTicks);
			listtag.add(compoundTag1);
		}
		return listtag;
	}
	
	static class EopolisData {
		final CompoundTag entityData;
		int ticksInMound;
		final int minOccupationTicks;
		
		EopolisData(CompoundTag tag, int ticksInMound, int minOccupationTicks) {
			EopolisMoundBlockEntity.removeIgnoredEopolisTags(tag);
			this.entityData = tag;
			this.ticksInMound = ticksInMound;
			this.minOccupationTicks = minOccupationTicks;
		}
	}
	
	public static enum EopolisReleaseStatus {
		EOPOLIS_RELEASED,
		EMERGENCY;
	}

}
