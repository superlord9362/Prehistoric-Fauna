package superlord.prehistoricfauna.common.entity.block;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import superlord.prehistoricfauna.common.entity.BurrowingDinosaur;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFTags;

public class BurrowBlockEntity extends BlockEntity {
	public static final String MIN_OCCUPATION_TICKS = "MinOccupationTicks";
	public static final String ENTITY_DATA = "EntityData";
	public static final String TICKS_IN_BURROW = "TicksInBurrow";
	public static final String BURROWERS = "Burrowers";
	public static final int MAX_OCCUPANTS = 3;
	@SuppressWarnings("unused")
	private static final int MIN_TICKS_BEFORE_REENTERING_BURROW = 400;
	private final List<BurrowBlockEntity.BurrowerData> stored = Lists.newArrayList();

	public BurrowBlockEntity(BlockPos p_155134_, BlockState p_155135_) {
		super(PFBlockEntities.BURROW.get(), p_155134_, p_155135_);
	}

	public void setChanged() {
		if (this.isFireNearby()) {
			this.emptyAllLivingFromBurrow((Player)null, this.level.getBlockState(this.getBlockPos()), BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
		}
		super.setChanged();
	}

	public boolean isFireNearby() {
		if (this.level == null) {
			return false;
		} else {
			for(BlockPos blockpos : BlockPos.betweenClosed(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1))) {
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
		return this.stored.size() == 3;
	}

	public void emptyAllLivingFromBurrow(@Nullable Player p_58749_, BlockState p_58750_, BurrowBlockEntity.BurrowerReleaseStatus p_58751_) {
		List<Entity> list = this.releaseAllOccupants(p_58750_, p_58751_);
		if (p_58749_ != null) {
			for(Entity entity : list) {
				if (entity instanceof BurrowingDinosaur) {
					BurrowingDinosaur burrower = (BurrowingDinosaur)entity;
					if (p_58749_.position().distanceToSqr(entity.position()) <= 16.0D) {
						burrower.setStayOutOfBurrowCountdown(400);
					}
				}
			}
		}

	}

	private List<Entity> releaseAllOccupants(BlockState p_58760_, BurrowBlockEntity.BurrowerReleaseStatus p_58761_) {
		List<Entity> list = Lists.newArrayList();
		this.stored.removeIf((p_272556_) -> {
			return releaseOccupant(this.level, this.worldPosition, p_58760_, p_272556_, list, p_58761_);
		});
		if (!list.isEmpty()) {
			super.setChanged();
		}

		return list;
	}

	public void addOccupant(Entity p_58742_) {
		this.addOccupantWithPresetTicks(p_58742_, 0);
	}

	@VisibleForDebug
	public int getOccupantCount() {
		return this.stored.size();
	}

	public void addOccupantWithPresetTicks(Entity p_58745_, int p_58747_) {
		if (this.stored.size() < 3) {
			p_58745_.stopRiding();
			p_58745_.ejectPassengers();
			CompoundTag compoundtag = new CompoundTag();
			p_58745_.save(compoundtag);
			this.storeBurrower(compoundtag, p_58747_);
			if (this.level != null) {
				BlockPos blockpos = this.getBlockPos();
//				this.level.playSound((Player)null, (double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ(), SoundEvents.BEEHIVE_ENTER, SoundSource.BLOCKS, 1.0F, 1.0F);
				this.level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(p_58745_, this.getBlockState()));
			}

			p_58745_.discard();
			super.setChanged();
		}
	}

	public void storeBurrower(CompoundTag p_155158_, int p_155159_) {
		this.stored.add(new BurrowBlockEntity.BurrowerData(p_155158_, p_155159_, 600));
	}

	private static boolean releaseOccupant(Level p_155137_, BlockPos p_155138_, BlockState p_155139_, BurrowBlockEntity.BurrowerData p_155140_, @Nullable List<Entity> p_155141_, BurrowBlockEntity.BurrowerReleaseStatus p_155142_) {
		if ((p_155137_.isNight() || p_155137_.isRaining()) && p_155142_ != BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY) {
			return false;
		} else {
			CompoundTag compoundtag = p_155140_.entityData.copy();
			compoundtag.put("BurrowPos", NbtUtils.writeBlockPos(p_155138_));
			//			Direction direction = p_155139_.getValue(BurrowBlock.PROPERTY_BY_DIRECTION);
			BlockPos blockpos = p_155138_.relative(Direction.UP);
			boolean flag = !p_155137_.getBlockState(blockpos).getCollisionShape(p_155137_, blockpos).isEmpty();
			if (flag && p_155142_ != BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY) {
				return false;
			} else {
				Entity entity = EntityType.loadEntityRecursive(compoundtag, p_155137_, (p_58740_) -> {
					return p_58740_;
				});
				if (entity != null) {
					if (!entity.getType().is(PFTags.BURROWERS)) {
						return false;
					} else {
						if (entity instanceof BurrowingDinosaur) {
							BurrowingDinosaur burrower = (BurrowingDinosaur)entity;
							setBurrowerReleaseData(p_155140_.ticksInBurrow, burrower);
							if (p_155141_ != null) {
								p_155141_.add(burrower);
							}

							float f = entity.getBbWidth();
							double d3 = flag ? 0.0D : 0.55D + (double)(f / 2.0F);
							double d0 = (double)p_155138_.getX() + 0.5D + d3 * (double)1;
							double d1 = (double)p_155138_.getY() + 0.5D - (double)(entity.getBbHeight() / 2.0F);
							double d2 = (double)p_155138_.getZ() + 0.5D + d3 * (double)1;
							entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
						}

//						p_155137_.playSound((Player)null, p_155138_, SoundEvents.BEEHIVE_EXIT, SoundSource.BLOCKS, 1.0F, 1.0F);
						p_155137_.gameEvent(GameEvent.BLOCK_CHANGE, p_155138_, GameEvent.Context.of(entity, p_155137_.getBlockState(p_155138_)));
						return p_155137_.addFreshEntity(entity);
					}
				} else {
					return false;
				}
			}
		}
	}

	private static void setBurrowerReleaseData(int p_58737_, BurrowingDinosaur p_58738_) {
		int i = p_58738_.getAge();
		if (i < 0) {
			p_58738_.setAge(Math.min(0, i + p_58737_));
		} else if (i > 0) {
			p_58738_.setAge(Math.max(0, i - p_58737_));
		}

		p_58738_.setInLoveTime(Math.max(0, p_58738_.getInLoveTime() - p_58737_));
	}

	private static void tickOccupants(Level p_155150_, BlockPos p_155151_, BlockState p_155152_, List<BurrowBlockEntity.BurrowerData> p_155153_) {
		boolean flag = false;

		BurrowBlockEntity.BurrowerData burrowblockentity$burrowerdata;
		for(Iterator<BurrowBlockEntity.BurrowerData> iterator = p_155153_.iterator(); iterator.hasNext(); ++burrowblockentity$burrowerdata.ticksInBurrow) {
			burrowblockentity$burrowerdata = iterator.next();
			if (burrowblockentity$burrowerdata.ticksInBurrow > burrowblockentity$burrowerdata.minOccupationTicks) {
				BurrowBlockEntity.BurrowerReleaseStatus burrowblockentity$burrowerreleasestatus = BurrowBlockEntity.BurrowerReleaseStatus.BURROWER_RELEASED;
				if (releaseOccupant(p_155150_, p_155151_, p_155152_, burrowblockentity$burrowerdata, (List<Entity>)null, burrowblockentity$burrowerreleasestatus)) {
					flag = true;
					iterator.remove();
				}
			}
		}

		if (flag) {
			setChanged(p_155150_, p_155151_, p_155152_);
		}

	}

	public static void serverTick(Level p_155145_, BlockPos p_155146_, BlockState p_155147_, BurrowBlockEntity p_155148_) {
		tickOccupants(p_155145_, p_155146_, p_155147_, p_155148_.stored);
	}

	public void load(CompoundTag p_155156_) {
		super.load(p_155156_);
		this.stored.clear();
		ListTag listtag = p_155156_.getList("Burrowers", 10);

		for(int i = 0; i < listtag.size(); ++i) {
			CompoundTag compoundtag = listtag.getCompound(i);
			BurrowBlockEntity.BurrowerData burrowblockentity$burrowerdata = new BurrowBlockEntity.BurrowerData(compoundtag.getCompound("EntityData"), compoundtag.getInt("TicksInBurrow"), compoundtag.getInt("MinOccupationTicks"));
			this.stored.add(burrowblockentity$burrowerdata);
		}

	}

	protected void saveAdditional(CompoundTag p_187467_) {
		super.saveAdditional(p_187467_);
		p_187467_.put("Burrowers", this.writeBurrowers());
	}

	public ListTag writeBurrowers() {
		ListTag listtag = new ListTag();

		for(BurrowBlockEntity.BurrowerData burrowblockentity$burrowerdata : this.stored) {
			CompoundTag compoundtag = burrowblockentity$burrowerdata.entityData.copy();
			compoundtag.remove("UUID");
			CompoundTag compoundtag1 = new CompoundTag();
			compoundtag1.put("EntityData", compoundtag);
			compoundtag1.putInt("TicksInBurrow", burrowblockentity$burrowerdata.ticksInBurrow);
			compoundtag1.putInt("MinOccupationTicks", burrowblockentity$burrowerdata.minOccupationTicks);
			listtag.add(compoundtag1);
		}

		return listtag;
	}

	static class BurrowerData {
		final CompoundTag entityData;
		int ticksInBurrow;
		final int minOccupationTicks;

		BurrowerData(CompoundTag p_58786_, int p_58787_, int p_58788_) {
			this.entityData = p_58786_;
			this.ticksInBurrow = p_58787_;
			this.minOccupationTicks = p_58788_;
		}
	}

	public static enum BurrowerReleaseStatus {
		BURROWER_RELEASED,
		EMERGENCY;
	}

}