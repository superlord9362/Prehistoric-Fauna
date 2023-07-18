package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Hesperornithoides extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DUST_BATH = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Hesperornithoides.class, EntityDataSerializers.BYTE);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFItems.RAW_SMALL_REPTILE_MEAT.get());
	private int currentHunger = 10;
	private int maxHunger = 10;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int isDigging;
	private Goal attackAnimals;
	int loveTick = 0;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	@SuppressWarnings("deprecation")
	public Hesperornithoides(EntityType<? extends Hesperornithoides> type, Level level) {
		super(type, level);
		this.maxUpStep = 1.0F;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.275F;
		else return 0.55F;
	}

	public boolean isDigging() {
		return this.entityData.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.entityData.set(IS_DIGGING, isDigging);
	}

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.entityData.set(HAS_EGG, hasEgg);
	}

	public boolean isAlbino() {
		return this.entityData.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.entityData.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.entityData.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.entityData.set(MELANISTIC, isMelanistic);
	}

	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_REPTILE_MEAT.get();
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}

	private void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
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
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER);
		});
		this.goalSelector.addGoal(1, new Hesperornithoides.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new Hesperornithoides.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Hesperornithoides.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Player.class, 10F, 1.5D, 1.75D));
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
		this.goalSelector.addGoal(0, new Hesperornithoides.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(1, new Hesperornithoides.DustBathGoal(this));
		this.targetSelector.addGoal(0, new Hesperornithoides.CarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, 1.75D, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER);
		}));
	}
	
	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		if (PrehistoricFaunaConfig.advancedHunger) {
			int hunger = this.getCurrentHunger();
			if (hunger < this.maxHunger) {
				if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
					this.setInLove(p_230254_1_);
					itemstack.shrink(1);
				} else {
					if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		}
		if (!this.isNoAi()) {
			List<? extends Hesperornithoides> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isBaby() || hungerTick == 300 && this.isBaby()) {
					if (!this.isAsleep()) {
						if (currentHunger != 0) {
							this.setHunger(currentHunger - 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && this.getHealth() > (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && level.getDifficulty() == Difficulty.HARD && this.getHealth() <= (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
					}
					hungerTick = 0;
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 4) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLoveTime(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				int naturalBreedingChance = random.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 4) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLoveTime(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveNaturally(false);
				}
			}
			if (lastInLove != 0) {
				lastInLove--;
			}
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
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(NATURAL_LOVE, false);
		this.entityData.define(DUST_BATH, false);
		this.entityData.define(CLIMBING, (byte)0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("hasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putBoolean("DustBath", this.isDustBathing());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("hasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setAttackGoals();
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.setDustBathing(compound.getBoolean("DustBath"));
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Random random = new Random();
		int birthNumber = random.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
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

	class LayEggGoal extends MoveToBlockGoal {
		private final Hesperornithoides hesperornithoides;

		public LayEggGoal(Hesperornithoides hesperornithoides, double speed) {
			super(hesperornithoides, speed, 16);
			this.hesperornithoides = hesperornithoides;
		}

		public boolean canUse() {
			return this.hesperornithoides.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.hesperornithoides.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.hesperornithoides.position());
			if (!this.hesperornithoides.isInWater() && this.isReachedTarget()) {
				if(this.hesperornithoides.isDigging < 1) {
					this.hesperornithoides.setDigging(true);
				} else if (this.hesperornithoides.isDigging > 200) {
					Level level = this.hesperornithoides.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.HESPERORNITHOIDES_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.hesperornithoides.random.nextInt(4) + 1)), 3);
					this.hesperornithoides.setHasEgg(false);
					this.hesperornithoides.setDigging(false);
					this.hesperornithoides.setInLoveTime(600);
				}
				if(this.hesperornithoides.isDigging()) {
					this.hesperornithoides.isDigging++;
				}
			}
		}

		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			if (!worldIn.isEmptyBlock(pos.above())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				BlockState state = worldIn.getBlockState(pos);
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT.get() || block == PFBlocks.MOSS_BLOCK.get() || block == PFBlocks.LOAM.get() || block == PFBlocks.PACKED_LOAM.get() || block == PFBlocks.SILT.get() || block == PFBlocks.PACKED_LOAM.get() || state.is(BlockTags.LEAVES);
			}
		}

	}

	static class MateGoal extends BreedGoal {
		private final Hesperornithoides hesperornithoides;

		public MateGoal(Hesperornithoides hesperornithoides, double speed) {
			super(hesperornithoides, speed);
			this.hesperornithoides = hesperornithoides;
		}

		public boolean canUse() {
			return super.canUse() && !this.hesperornithoides.hasEgg() && !this.hesperornithoides.isInLoveNaturally();
		}

		protected void breed() {
			ServerPlayer serverPlayer = this.animal.getLoveCause();
			if (serverPlayer == null && this.partner.getLoveCause() != null) {
				serverPlayer = this.partner.getLoveCause();
			}
			if (serverPlayer != null) {
				serverPlayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayer, this.animal, this.partner, (AgeableMob)null);
			}
			this.hesperornithoides.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Hesperornithoides hesperornithoides;

		NaturalMateGoal(Hesperornithoides hesperornithoides, double speed) {
			super(hesperornithoides, speed);
			this.hesperornithoides = hesperornithoides;
		}

		public boolean canUse() {
			return super.canUse() && !this.hesperornithoides.hasEgg() && this.hesperornithoides.getCurrentHunger() >= this.hesperornithoides.getThreeQuartersHunger() && this.hesperornithoides.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.hesperornithoides.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.hesperornithoides.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.hesperornithoides.random.nextFloat() - this.hesperornithoides.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.hesperornithoides.random.nextInt(4);
				if (eggAmount == 0) {
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
					this.hesperornithoides.spawnAtLocation(PFBlocks.HESPERORNITHOIDES_EGG.get().asItem());
				}
			} else {
				this.hesperornithoides.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Hesperornithoides entity = new Hesperornithoides(PFEntities.HESPERORNITHOIDES.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, double huntSpeed, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Hesperornithoides.this.getCurrentHunger() <= Hesperornithoides.this.getHalfHunger() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Hesperornithoides.this);
		}

		public boolean canContinueToUse() {
			return Hesperornithoides.this.getCurrentHunger() < Hesperornithoides.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Hesperornithoides.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Hesperornithoides.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Hesperornithoides.this.getCurrentHunger() + 3 >= Hesperornithoides.this.maxHunger) {
						Hesperornithoides.this.setHunger(Hesperornithoides.this.maxHunger);
					} else {
						Hesperornithoides.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Hesperornithoides.this.getCurrentHunger() + 4 >= Hesperornithoides.this.maxHunger) {
						Hesperornithoides.this.setHunger(Hesperornithoides.this.maxHunger);
					} else {
						Hesperornithoides.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Hesperornithoides.this.getCurrentHunger() + 6 >= Hesperornithoides.this.maxHunger) {
						Hesperornithoides.this.setHunger(Hesperornithoides.this.maxHunger);
					} else {
						Hesperornithoides.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

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

}
