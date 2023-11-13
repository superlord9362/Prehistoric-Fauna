package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistBabyHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistHuntingGoal;
import superlord.prehistoricfauna.common.entity.goal.OvivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Telmasaurus extends DinosaurEntity {

	@SuppressWarnings("deprecation")
	public Telmasaurus(EntityType<? extends TamableAnimal> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	private int maxHunger = 15;
	int timer = 0;

	public boolean isFood(ItemStack stack) {
		return (stack.is(PFTags.EGGS_5_HUNGER) || stack.is(PFTags.EGGS_10_HUNGER) || stack.is(PFTags.EGGS_15_HUNGER));
	}

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
		this.level.addFreshEntity(itemEntity);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.25F;
		else return 0.5F;
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(3);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6);
		}
	}

	public void aiStep() {
		super.aiStep();
		ItemStack stack = this.getMainHandItem();
		ItemStack newStack = new ItemStack(Items.AIR);
		if (stack.getItem() != Items.AIR) {
			timer++;
			if (timer == 600) {
				if (PrehistoricFaunaConfig.advancedHunger) {
					if (stack.is(PFTags.EGGS_5_HUNGER)) {
						if (this.getCurrentHunger() + 5 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 5);
						}
					}
					if (stack.is(PFTags.EGGS_10_HUNGER)) {
						if (this.getCurrentHunger() + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 10);
						}
					}
					if (stack.is(PFTags.EGGS_15_HUNGER)) {
						if (this.getCurrentHunger() + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 15);
						}
					}
				}
				this.setItemInHand(InteractionHand.MAIN_HAND, newStack);
			}
			if (this.getLastHurtByMob() != null && timer < 600) {
				this.spawnItem(stack);
				this.setItemInHand(InteractionHand.MAIN_HAND, newStack);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Telmasaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(2, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new Telmasaurus.EatEggGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new Telmasaurus.HungerEatEggGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.targetSelector.addGoal(2, new OpportunistAttackGoal(this, Player.class, true));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Citipati.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Velociraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Telmasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Protoceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Thescelosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Dryosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Exaeretodon.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Sillosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new OvivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new OpportunistHuntingGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.TELMASAURUS_HUNTING);
		}));
		this.goalSelector.addGoal(0, new OpportunistBabyHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.TELMASAURUS_BABY_HUNTING);
		}));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.TELMASAURUS_HUNTING);
		}));
		this.goalSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.TELMASAURUS_BABY_HUNTING);
		}));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.TELMASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TELMASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TELMASAURUS_DEATH;
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setOpportunist(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setSkittish(true);
		} else if (temperment >= 95) {
			this.setProtective(true);
		}
		this.setOvivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
			((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0, false, false));
		}

		return flag;
	}

	class EatEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Telmasaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.tryTicks % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			Block eggs = blockstate.getBlock();
			return (blockstate.is(Blocks.TURTLE_EGG) && blockstate.getValue(TurtleEggBlock.EGGS) >= 1) || (eggs instanceof DinosaurEggBlock && blockstate.getValue(DinosaurEggBlock.EGGS) >= 1 && blockstate.getBlock() != PFBlocks.TELMASAURUS_EGG.get());
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			if (this.isReachedTarget() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Telmasaurus.this.level, Telmasaurus.this)) {
				BlockState blockstate = Telmasaurus.this.level.getBlockState(this.blockPos);
				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0D, 0.0D, 0.0D);
				if (blockstate.is(Blocks.TURTLE_EGG)) {
					int i = blockstate.getValue(TurtleEggBlock.EGGS);
					blockstate.setValue(TurtleEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.TURTLE_EGG));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(TurtleEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
				Block eggs = blockstate.getBlock();
				if (eggs instanceof DinosaurEggBlock) {
					int i = blockstate.getValue(DinosaurEggBlock.EGGS);
					blockstate.setValue(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(eggs.asItem()));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(DinosaurEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			return !Telmasaurus.this.isSleeping() && super.canUse() && stack.getItem() == Items.AIR && !PrehistoricFaunaConfig.advancedHunger;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}


		public boolean canContinueToUse() {
			ItemStack stack = new ItemStack(Items.AIR);
			return Telmasaurus.this.getMainHandItem() == stack;
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Telmasaurus.this, 1.25D, true);
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
			return (double)(8.0F + attackTarget.getBbWidth());
		}
	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Telmasaurus entity = new Telmasaurus(PFEntities.TELMASAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class HungerEatEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HungerEatEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Telmasaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.tryTicks % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			Block eggs = blockstate.getBlock();
			return (blockstate.is(Blocks.TURTLE_EGG) && blockstate.getValue(TurtleEggBlock.EGGS) >= 1) || (eggs instanceof DinosaurEggBlock && blockstate.getValue(DinosaurEggBlock.EGGS) >= 1 && blockstate.getBlock() != PFBlocks.TELMASAURUS_EGG.get());
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			if (this.isReachedTarget() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Telmasaurus.this.level, Telmasaurus.this)) {
				BlockState blockstate = Telmasaurus.this.level.getBlockState(this.blockPos);
				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0D, 0.0D, 0.0D);
				if (blockstate.is(Blocks.TURTLE_EGG)) {
					int i = blockstate.getValue(TurtleEggBlock.EGGS);
					blockstate.setValue(TurtleEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.TURTLE_EGG));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(TurtleEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
				Block eggs = blockstate.getBlock();
				if (eggs instanceof DinosaurEggBlock) {
					int i = blockstate.getValue(DinosaurEggBlock.EGGS);
					blockstate.setValue(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(eggs.asItem()));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(DinosaurEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			return !Telmasaurus.this.isSleeping() && super.canUse() && stack.getItem() == Items.AIR && PrehistoricFaunaConfig.advancedHunger && Telmasaurus.this.getCurrentHunger() <= Telmasaurus.this.getHalfHunger();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}

		public boolean canContinueToUse() {
			ItemStack stack = new ItemStack(Items.AIR);
			return Telmasaurus.this.getMainHandItem() == stack || Telmasaurus.this.getCurrentHunger() <= Telmasaurus.this.maxHunger;
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.TELMASAURUS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.TELMASAURUS_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.TELMASAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }


}
