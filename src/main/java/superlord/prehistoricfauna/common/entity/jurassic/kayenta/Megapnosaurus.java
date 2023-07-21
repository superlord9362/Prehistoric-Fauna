package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.NocturnalSleepGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Megapnosaurus extends DinosaurEntity {
	private int maxHunger = 15;
	private int warningSoundTicks;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Megapnosaurus(EntityType<? extends Megapnosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.425F;
		else return 0.85F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_THYREOPHORAN_MEAT.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Chromogisaurus || p_213487_0_ instanceof Hyperodapedon || p_213487_0_ instanceof Horse || p_213487_0_ instanceof Donkey || p_213487_0_ instanceof Mule || p_213487_0_ instanceof Sheep || p_213487_0_ instanceof Cow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Player;
		});
		this.goalSelector.addGoal(1, new Megapnosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Megapnosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Megapnosaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Megapnosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Megapnosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Megapnosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Citipati>(this, Citipati.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Pinacosaurus>(this, Pinacosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Plesiohadros>(this, Plesiohadros.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Velociraptor>(this, Velociraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Herrerasaurus>(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ischigualastia>(this, Ischigualastia.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Sillosuchus>(this, Sillosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new NocturnalSleepGoal(this));
		this.targetSelector.addGoal(0, new Megapnosaurus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Parrot || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Fox || p_213487_1_ instanceof Cow || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Pig || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Sarahsaurus || p_213487_1_ instanceof Scelidosaurus || p_213487_1_ instanceof Player;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Scutellosaurus;
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
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.MEGAPNOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.MEGAPNOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.MEGAPNOSAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.MEGAPNOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setAttackGoals();
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Megapnosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Megapnosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Megapnosaurus megapnosaurus : Megapnosaurus.this.level.getEntitiesOfClass(Megapnosaurus.class, Megapnosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (megapnosaurus.isBaby()) {
							return true;
						}
					}
				}
				return false;
			}
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Megapnosaurus.this);
		}

		public void start() {
			super.start();
			if (Megapnosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Megapnosaurus && !mobIn.isBaby() && targetIn.getHealth() <= (targetIn.getMaxHealth() / 2)) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Megapnosaurus.this, 1.25D, true);
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

				if (this.getTicksUntilNextAttack() <= 10) {
					Megapnosaurus.this.playWarningSound();
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
	static class LayEggGoal extends MoveToBlockGoal {
		private final Megapnosaurus megapnosaurus;

		LayEggGoal(Megapnosaurus megapnosaurus, double speedIn) {
			super(megapnosaurus, speedIn, 16);
			this.megapnosaurus = megapnosaurus;
		}

		public boolean canUse() {
			return this.megapnosaurus.hasBaby() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.megapnosaurus.hasBaby();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.megapnosaurus.position());
			if (!this.megapnosaurus.isInWater() && this.isReachedTarget()) {
				if (this.megapnosaurus.isBirthing < 1) {
					this.megapnosaurus.setBirthing(true);
				} else if (this.megapnosaurus.isBirthing > 200) {
					Level world = this.megapnosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.MEGAPNOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.megapnosaurus.random.nextInt(4) + 1)), 3);
					this.megapnosaurus.setHasBaby(false);
					this.megapnosaurus.setBirthing(false);
					this.megapnosaurus.setInLoveTime(600);
				}
				if (this.megapnosaurus.isBirthing()) {
					this.megapnosaurus.isBirthing++;
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
		private final Megapnosaurus megapnosaurus;

		MateGoal(Megapnosaurus megapnosaurus, double speedIn) {
			super(megapnosaurus, speedIn);
			this.megapnosaurus = megapnosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.megapnosaurus.hasBaby() && !this.megapnosaurus.isInLoveNaturally();
		}

		protected void breed() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}
			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}
			this.megapnosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Megapnosaurus megapnosaurus;

		NaturalMateGoal(Megapnosaurus megapnosaurus, double speed) {
			super(megapnosaurus, speed);
			this.megapnosaurus = megapnosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.megapnosaurus.hasBaby() && this.megapnosaurus.getCurrentHunger() >= this.megapnosaurus.getThreeQuartersHunger() && this.megapnosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.megapnosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.megapnosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.megapnosaurus.random.nextFloat() - this.megapnosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.megapnosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
					this.megapnosaurus.spawnAtLocation(PFBlocks.MEGAPNOSAURUS_EGG.get().asItem());
				}
			} else {
				this.megapnosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Megapnosaurus entity = new Megapnosaurus(PFEntities.MEGAPNOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Megapnosaurus.this.getCurrentHunger() <= Megapnosaurus.this.getHalfHunger() && !Megapnosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Megapnosaurus.this) && (target.getHealth() <= (target.getMaxHealth() / 2) || target.getHealth() <= Megapnosaurus.this.getHealth());
		}

		public boolean canContinueToUse() {
			return (Megapnosaurus.this.getCurrentHunger() < Megapnosaurus.this.maxHunger) || super.canContinueToUse()  && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Megapnosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Megapnosaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 3 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 4 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 6 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 10 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 15 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof Player) {
				if (target.getHealth() == 0) {
					if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class BabyCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		@SuppressWarnings("unchecked")
		public BabyCarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Megapnosaurus.this.getCurrentHunger() <= Megapnosaurus.this.getHalfHunger() && Megapnosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Megapnosaurus.this);
		}

		public boolean canContinueToUse() {
			return Megapnosaurus.this.getCurrentHunger() < Megapnosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Megapnosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Megapnosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Megapnosaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 3 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 4 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Megapnosaurus.this.getCurrentHunger() + 6 >= Megapnosaurus.this.maxHunger) {
						Megapnosaurus.this.setHunger(Megapnosaurus.this.maxHunger);
					} else {
						Megapnosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}	
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.MEGAPNOSAURUS_SPAWN_EGG.get());
	}

}
