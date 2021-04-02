package superlord.prehistoricfauna.entity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

import javax.annotation.Nullable;
import java.util.Random;

public class DidelphodonEntity extends PrehistoricEntity {
	
	private static final DataParameter<Boolean> IS_PREGNANT = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_READY = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(BlockInit.CRASSOSTREA_BLOCK.asItem());
	private int isReady;
	public int stayOutOfBurrowCountdown;
	//private int remainingCooldownBeforeLocatingNewBurrow = 0;
	@Nullable
	private BlockPos burrowPos = null;
	//private DidelphodonEntity.FindBurrowGoal findBurrowGoal;
	
	public DidelphodonEntity(EntityType<? extends DidelphodonEntity> type, World world) {
		super(type, world);
	}
	
	public boolean isPregnant() {
		return this.dataManager.get(IS_PREGNANT);
	}
	
	private void setPregnant(boolean isPregnant) {
		this.dataManager.set(IS_PREGNANT, isPregnant);
	}
	
	public boolean isReady() {
		return this.dataManager.get(IS_READY);
	}
	
	private void setReady(boolean isReady) {
		this.isReady = isReady ? 1 : 0;
		this.dataManager.set(IS_READY, isReady);
	}
	
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == BlockInit.CRASSOSTREA_BLOCK.asItem();
	}
	
	//private boolean isTooFar(BlockPos pos) {
		//return !this.isWithinDistance(pos, 48);
	//}
	
	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		DidelphodonEntity entity = new DidelphodonEntity(ModEntityTypes.DIDELPHODON_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	public void registerData() {
		super.registerData();
		this.dataManager.register(IS_PREGNANT, false);
		this.dataManager.register(IS_READY, false);
	}
	
	public void writeAddition(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsPregnant", this.isPregnant());
		//if (this.hasBurrow()) {
			//compound.put("BurrowPos",  NBTUtil.writeBlockPos(this.getBurrowPos()));
		//}
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setPregnant(compound.getBoolean("IsPregnant"));
		//this.burrowPos = null;
		//if (compound.contains("BurrowPos")) {
			//this.burrowPos = NBTUtil.readBlockPos(compound.getCompound("BurrowPos"));
		//}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		//this.goalSelector.addGoal(1, new DidelphodonEntity.EnterBurrowGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(2, new DidelphodonEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		//this.goalSelector.addGoal(5, new DidelphodonEntity.UpdateBurrowGoal());
		//this.findBurrowGoal = new DidelphodonEntity.FindBurrowGoal();
		//this.goalSelector.addGoal(5, this.findBurrowGoal);
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, PlayerEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DakotaraptorEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AllosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CeratosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CamarasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TriceratopsEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, StegosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ThescelosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DryosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HesperornithoidesEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HerrerasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ExaeretodonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(8, new DidelphodonEntity.CarryYoungGoal(this, 1.0D));
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundHandler.DIDELPHODON_IDLE;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundHandler.DIDELPHODON_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundHandler.DIDELPHODON_DEATH;
	}
	
	/**private void startMovingTo(BlockPos pos) {
		Vec3d vec3d = new Vec3d(pos);
		int i = 0;
		BlockPos blockpos = new BlockPos(this);
		int j = (int)vec3d.y - blockpos.getY();
		if (j > 2) {
			i = 4;
		} else if (j < -2) {
			i = -4;
		}
		int k = 6;
		int l = 8;
		int i1 = blockpos.manhattanDistance(pos);
		if (i1 < 15) {
			k = i1 / 2;
			l = i1 / 2;
		}

		Vec3d vec3d1 = RandomPositionGenerator.func_226344_b_(this, k, l, i, vec3d, (double)((float)Math.PI / 10F));
		if (vec3d1 != null) {
			this.navigator.setRangeMultiplier(0.5F);
			this.navigator.tryMoveToXYZ(vec3d1.x, vec3d1.y, vec3d1.z, 1.0D);
		}
	}*/

	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	/**@Override
	public void livingTick() {
		super.livingTick();
		if (!this.world.isRemote) {
			if (this.stayOutOfBurrowCountdown > 0) {
				--this.stayOutOfBurrowCountdown;
			}
			if (this.remainingCooldownBeforeLocatingNewBurrow > 0) {
				--this.remainingCooldownBeforeLocatingNewBurrow;
			}
			if (this.ticksExisted % 20 == 0 && !this.isBurrowValid()) {
				this.burrowPos = null;
			}
		}
	}
	
	private boolean isBurrowValid() {
		if (!this.hasBurrow()) {
			return false;
		} else {
			TileEntity tileentity = this.world.getTileEntity(this.burrowPos);
			return tileentity instanceof DidelphodonBurrowTileEntity;
		}
	}*/
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		super.handleStatusUpdate(id);
	}
	
	/**
	private boolean canEnterBurrow() {
		if (this.stayOutOfBurrowCountdown <= 0) {
			boolean flag = this.world.isRaining() || this.world.isNightTime();
			return flag;
		} else {
			return false;
		}
	}
	
	public void stayOutOfBurrowCountdown() {
		this.stayOutOfBurrowCountdown = 400;
	}
	
	public void setStayOutOfBurrowCountound(int ticks) {
		this.stayOutOfBurrowCountdown = ticks;
	}
	
	private boolean doesBurrowHaveSpace(BlockPos pos) {
		TileEntity tileentity = this.world.getTileEntity(pos);
		if (tileentity instanceof DidelphodonBurrowTileEntity) {
			return !((DidelphodonBurrowTileEntity)tileentity).isFullOfDidelphodons();
		} else {
			return false;
		}
	}

	public boolean hasBurrow() {
		return this.burrowPos != null;
	}
	
	@Nullable
	public BlockPos getBurrowPos() {
		return this.burrowPos;
	}
	*/
	
	static class MateGoal extends BreedGoal {
		private final DidelphodonEntity didelphodon;
		
		MateGoal(DidelphodonEntity didelphodon, double speed) {
			super(didelphodon, speed);
			this.didelphodon = didelphodon;
		}
		
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.didelphodon.isPregnant();
		}
		
		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}
			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}
			this.didelphodon.setPregnant(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
		
	}
	
	abstract class PassiveGoal extends Goal {
		private PassiveGoal() {
		}

		public abstract boolean canDidelphodonStart();

		public abstract boolean canDidelphodonContinue();

		public boolean shouldExecute() {
			return this.canDidelphodonStart();
		}
		
		public boolean shouldContinueExecuting() {
			return this.canDidelphodonContinue();
		}
	}
	/**
	private boolean isWithinDistance(BlockPos pos, int distance) {
		return pos.withinDistance(new BlockPos(this), (double)distance);
	}
	
	public class FindBurrowGoal extends DidelphodonEntity.PassiveGoal {
		private int ticks = DidelphodonEntity.this.world.rand.nextInt(10);
		private List<BlockPos> possibleBurrows = Lists.newArrayList();
		@Nullable
		private Path path = null;

		FindBurrowGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canDidelphodonStart() {
			return DidelphodonEntity.this.burrowPos != null && !DidelphodonEntity.this.detachHome() && DidelphodonEntity.this.canEnterBurrow() && !this.isCloseEnough(DidelphodonEntity.this.burrowPos) && DidelphodonEntity.this.world.getBlockState(DidelphodonEntity.this.burrowPos).isIn(BlockInit.BURROWS);
		}

		public boolean canDidelphodonContinue() {
			return this.canDidelphodonStart();
		}

		public void startExecuting() {
			this.ticks = 0;
			super.startExecuting();
		}

		public void resetTask() {
			this.ticks = 0;
			DidelphodonEntity.this.navigator.clearPath();
			DidelphodonEntity.this.navigator.resetRangeMultiplier();
		}

		public void tick() {
			if (DidelphodonEntity.this.burrowPos != null) {
				++this.ticks;
				if (this.ticks > 600) {
	            	this.makeChosenHivePossibleBurrow();
				} else if (!DidelphodonEntity.this.navigator.hasActivePath()) {
					if (!DidelphodonEntity.this.isWithinDistance(DidelphodonEntity.this.burrowPos, 16)) {
						if (DidelphodonEntity.this.isTooFar(DidelphodonEntity.this.burrowPos)) {
							this.reset();
						} else {
							DidelphodonEntity.this.startMovingTo(DidelphodonEntity.this.burrowPos);
						}
					} else {
						boolean flag = this.startMovingToFar(DidelphodonEntity.this.burrowPos);
						if (!flag) {
							this.makeChosenHivePossibleBurrow();
						} else if (this.path != null && DidelphodonEntity.this.navigator.getPath().isSamePath(this.path)) {
							this.reset();
						} else {
							this.path = DidelphodonEntity.this.navigator.getPath();
						}
					}
				}
			}
		}

		private boolean startMovingToFar(BlockPos pos) {
			DidelphodonEntity.this.navigator.setRangeMultiplier(10.0F);
			DidelphodonEntity.this.navigator.tryMoveToXYZ((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 1.0D);
			return DidelphodonEntity.this.navigator.getPath() != null && DidelphodonEntity.this.navigator.getPath().reachesTarget();
		}

		private boolean isPossibleBurrow(BlockPos pos) {
			return this.possibleBurrows.contains(pos);
		}

		private void addPossibleBurrow(BlockPos pos) {
			this.possibleBurrows.add(pos);
			while(this.possibleBurrows.size() > 3) {
				this.possibleBurrows.remove(0);
			}
		}

		private void clearPossibleBurrow() {
			this.possibleBurrows.clear();
		}

		private void makeChosenHivePossibleBurrow() {
			if (DidelphodonEntity.this.burrowPos != null) {
				this.addPossibleBurrow(DidelphodonEntity.this.burrowPos);
			}
			this.reset();
		}
		
		private void reset() {
			DidelphodonEntity.this.burrowPos = null;
			DidelphodonEntity.this.remainingCooldownBeforeLocatingNewBurrow = 200;
		}
		
		private boolean isCloseEnough(BlockPos pos) {
			if (DidelphodonEntity.this.isWithinDistance(pos, 2)) {
	            return true;
			} else {
				Path path = DidelphodonEntity.this.navigator.getPath();
				return path != null && path.getTarget().equals(pos) && path.reachesTarget() && path.isFinished();
			}
		}
	}
	
	class EnterBurrowGoal extends DidelphodonEntity.PassiveGoal {
		private EnterBurrowGoal() {
		}

		public boolean canDidelphodonStart() {
			if (DidelphodonEntity.this.hasBurrow() && DidelphodonEntity.this.canEnterBurrow() && DidelphodonEntity.this.burrowPos.withinDistance(DidelphodonEntity.this.getPositionVec(), 2.0D)) {
				TileEntity tileentity = DidelphodonEntity.this.world.getTileEntity(DidelphodonEntity.this.burrowPos);
				if (tileentity instanceof DidelphodonBurrowTileEntity) {
					DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)tileentity;
					if (!didelphodonburrowtileentity.isFullOfDidelphodons()) {
						return true;
					}
					DidelphodonEntity.this.burrowPos = null;
				}
			}
			return false;
		}

		public boolean canDidelphodonContinue() {
			return false;
		}

		public void startExecuting() {
			TileEntity tileentity = DidelphodonEntity.this.world.getTileEntity(DidelphodonEntity.this.burrowPos);
			if (tileentity instanceof DidelphodonBurrowTileEntity) {
				DidelphodonBurrowTileEntity didelphodonburrowtileentity = (DidelphodonBurrowTileEntity)tileentity;
				didelphodonburrowtileentity.tryEnterBurrow(DidelphodonEntity.this);
			}
		}
	}
	*/
	
	static class CarryYoungGoal extends Goal {
		private final DidelphodonEntity didelphodon;
		
		CarryYoungGoal(DidelphodonEntity didelphodon, double speed) {
			super();
			this.didelphodon = didelphodon;
		}
		
		public boolean shouldExecute() {
			return this.didelphodon.isPregnant();
		}
		
		public boolean shouldContinueExecuting() {
			return this.didelphodon.isPregnant();
		}
		
		public void tick() {
			super.tick();
			if (!this.didelphodon.isInWater()) {
				if (this.didelphodon.isReady < 1) {
					this.didelphodon.setReady(true);
				} else if (this.didelphodon.isReady > 200) {
					World world = this.didelphodon.world;
					AgeableEntity ageable = new DidelphodonEntity(ModEntityTypes.DIDELPHODON_ENTITY, world);
					ageable.setGrowingAge(-24000);
					world.addEntity(ageable);
					this.didelphodon.setPregnant(false);
					this.didelphodon.setReady(false);
					this.didelphodon.setInLove(600);
				}
				if (this.didelphodon.isReady()) {
					this.didelphodon.isReady++;
				}
			}
		}
	}
	
	/**
	class UpdateBurrowGoal extends DidelphodonEntity.PassiveGoal {
		private UpdateBurrowGoal() {
		}

		public boolean canDidelphodonStart() {
			return DidelphodonEntity.this.remainingCooldownBeforeLocatingNewBurrow == 0 && !DidelphodonEntity.this.hasBurrow() && DidelphodonEntity.this.canEnterBurrow();
		}

		public boolean canDidelphodonContinue() {
			return false;
		}

		public void startExecuting() {
			DidelphodonEntity.this.remainingCooldownBeforeLocatingNewBurrow = 200;
			List<BlockPos> list = this.getNearbyFreeBurrows();
			if (!list.isEmpty()) {
				for(BlockPos blockpos : list) {
					if (!DidelphodonEntity.this.findBurrowGoal.isPossibleBurrow(blockpos)) {
						DidelphodonEntity.this.burrowPos = blockpos;
						return;
					}
				}
				DidelphodonEntity.this.findBurrowGoal.clearPossibleBurrow();
				DidelphodonEntity.this.burrowPos = list.get(0);
			}
		}

		private List<BlockPos> getNearbyFreeBurrows() {
			BlockPos blockpos = new BlockPos(DidelphodonEntity.this);
			PointOfInterestManager pointofinterestmanager = ((ServerWorld)DidelphodonEntity.this.world).getPointOfInterestManager();
			Stream<PointOfInterest> stream = pointofinterestmanager.func_219146_b((p_226486_0_) -> {
				return p_226486_0_ == PrehistoricPointofInterest.BURROWS;
			}, blockpos, 20, PointOfInterestManager.Status.ANY);
			return stream.map(PointOfInterest::getPos).filter((p_226487_1_) -> {
				return DidelphodonEntity.this.doesBurrowHaveSpace(p_226487_1_);
			}).sorted(Comparator.comparingDouble((p_226488_1_) -> {
				return p_226488_1_.distanceSq(blockpos);
			})).collect(Collectors.toList());
		}
	}
*/
}
