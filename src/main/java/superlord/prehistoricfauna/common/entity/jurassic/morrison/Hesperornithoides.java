package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Hesperornithoides extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> DUST_BATH = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BYTE);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFItems.RAW_SMALL_REPTILE_MEAT.get());
	private int maxHunger = 10;
	private Goal attackAnimals;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	@SuppressWarnings("deprecation")
	public Hesperornithoides(EntityType<? extends Hesperornithoides> type, Level level) {
		super(type, level);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.275F;
		else return 0.55F;
	}
	
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_REPTILE_MEAT.get();
	}

	public boolean isDustBathing() {
		return this.entityData.get(DUST_BATH);
	}

	private void setDustBathing(boolean isDustBathing) {
		this.entityData.set(DUST_BATH, isDustBathing);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.HESPERORNITHOIDES_HUNTING);
		});
		this.goalSelector.addGoal(1, new Hesperornithoides.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Exaeretodon.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new Hesperornithoides.DustBathGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.HESPERORNITHOIDES_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.HESPERORNITHOIDES_BABY_HUNTING);
		}));
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setSkittish(true);
		} else {
			this.setPassive(true);
		}
		this.setCarnivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
		}
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep() || this.getWakingTicks() != 0) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		}
		if (random.nextInt(1000) == 0 && !this.isDustBathing() && !this.isAsleep() && (this.level.getBlockState(this.blockPosition().below()).getBlock() == Blocks.SAND || this.level.getBlockState(this.blockPosition().below()).getBlock() == Blocks.RED_SAND || this.level.getBlockState(this.blockPosition().below()).getBlock() == PFBlocks.HARDENED_SILT.get())) {
			this.setDustBathing(true);
		}

		if (this.isDustBathing()) {
			double d0 = (double)this.blockPosition().getX() + random.nextDouble();
			double d1 = (double)this.blockPosition().getY() + 0.5F;
			double d2 = (double)this.blockPosition().getZ() + random.nextDouble();
			this.level.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, this.level.getBlockState(this.blockPosition().below())), d0, d1, d2, 0.0D, 0.0D, 0.0D);

		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.26D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.HESPERORNITHOIDES_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.HESPERORNITHOIDES_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HESPERORNITHOIDES_DEATH;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DUST_BATH, false);
		this.entityData.define(CLIMBING, (byte)0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("DustBath", this.isDustBathing());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setAttackGoals();
		this.setDustBathing(compound.getBoolean("DustBath"));
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	public void tick() {
		super.tick();
		if (!this.level.isClientSide) {
			if (this.horizontalCollision) {
				if (this.horizontalCollision) {
					Boolean logBlock;
					BlockPos blockpos1 = new BlockPos(this.position().x() + 1, this.position().y() + 1, this.position().z());
					BlockPos blockpos2 = new BlockPos(this.position().x() - 1, this.position().y() + 1, this.position().z());
					BlockPos blockpos3 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() + 1);
					BlockPos blockpos4 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() - 1);
					BlockState blockstate1 = this.level.getBlockState(blockpos1);
					BlockState blockstate2 = this.level.getBlockState(blockpos2);
					BlockState blockstate3 = this.level.getBlockState(blockpos3);
					BlockState blockstate4 = this.level.getBlockState(blockpos4);
					if (blockstate1.is(BlockTags.LOGS) || blockstate1.is(BlockTags.PLANKS) || blockstate1.is(BlockTags.WOODEN_DOORS) || blockstate1.is(BlockTags.WOODEN_FENCES) || blockstate1.is(BlockTags.WOODEN_SLABS) || blockstate1.is(BlockTags.WOODEN_STAIRS) || blockstate2.is(BlockTags.LOGS) || blockstate2.is(BlockTags.PLANKS) || blockstate2.is(BlockTags.WOODEN_DOORS) || blockstate2.is(BlockTags.WOODEN_FENCES) || blockstate2.is(BlockTags.WOODEN_SLABS) || blockstate2.is(BlockTags.WOODEN_STAIRS)  || blockstate3.is(BlockTags.LOGS) || blockstate3.is(BlockTags.PLANKS) || blockstate3.is(BlockTags.WOODEN_DOORS) || blockstate3.is(BlockTags.WOODEN_FENCES) || blockstate3.is(BlockTags.WOODEN_SLABS) || blockstate3.is(BlockTags.WOODEN_STAIRS) || blockstate4.is(BlockTags.LOGS) || blockstate4.is(BlockTags.PLANKS) || blockstate4.is(BlockTags.WOODEN_DOORS) || blockstate4.is(BlockTags.WOODEN_FENCES) || blockstate4.is(BlockTags.WOODEN_SLABS) || blockstate4.is(BlockTags.WOODEN_STAIRS)) {
						logBlock = true;
						if (climbingTickCooldown == 0 && climbingTicks < 600) {
							this.setBesideClimbableBlock(logBlock);
							climbingTicks++;
						}
						if (climbingTicks >= 599 && climbingTickCooldown <= 300) {
							climbingTickCooldown++;
						}
						if (climbingTickCooldown == 300) {
							climbingTicks = 0;
							climbingTickCooldown = 0;
						}
					}
				}
			}
		}
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (this.entityData.get(CLIMBING) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.entityData.get(CLIMBING);
		if (climbing) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.entityData.set(CLIMBING, b0);
	}

	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Hesperornithoides.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getBbWidth());
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Hesperornithoides entity = new Hesperornithoides(PFEntities.HESPERORNITHOIDES.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class DustBathGoal extends Goal {

		Hesperornithoides hesperornithoides;
		int tick = 0;

		public DustBathGoal(Hesperornithoides hesperornithoides) {
			this.hesperornithoides = hesperornithoides;
		}

		@Override
		public boolean canUse() {
			return hesperornithoides.isDustBathing();
		}

		private void spawnItem(ItemStack stack) {
			ItemEntity item = new ItemEntity(Hesperornithoides.this.level, Hesperornithoides.this.getX(), Hesperornithoides.this.getY(), Hesperornithoides.this.getZ(), stack);
			Hesperornithoides.this.level.addFreshEntity(item);
		}

		public void tick() {
			tick++;
			if (tick == 100) {
				this.spawnItem(new ItemStack(Items.FEATHER));
				stop();
			}
			super.tick();
		}

		public void stop() {
			tick = 0;
			hesperornithoides.setDustBathing(false);
			super.stop();
		}

	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.HESPERORNITHOIDES_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.HESPERORNITHOIDES_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.HESPERORNITHOIDES_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
