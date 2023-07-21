package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.CrassostreaOysterBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;
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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Didelphodon extends DinosaurEntity {

	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.CRASSOSTREA_OYSTER.get().asItem());
	private int maxHunger = 10;
	public int eatTicks;
	private float interestedAngle;
	private float interestedAngleO;

	@SuppressWarnings("deprecation")
	public Didelphodon(EntityType<? extends Didelphodon> type, Level level) {
		super(type, level);
		this.setCanPickUpLoot(true);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	private void spawnItem(ItemStack stack) {
		ItemEntity item = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
		this.level.addFreshEntity(item);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.175F;
		else return 0.35F;
	}

	protected void updateEquipmentIfNeeded(ItemEntity item) {
		ItemStack itemstack = item.getItem();
		if (this.canEquipItem(itemstack)) {
			int i = itemstack.getCount();
			if (i > 1) {
				this.spawnItem(itemstack.split(i - 1));
			}
			this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
			this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
			this.take(item, itemstack.getCount());
			item.remove(RemovalReason.DISCARDED);
			this.eatTicks = 0;
		}
	}

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(p_230254_1_) || this.isTame() || item == Items.BONE && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (!this.isTame()) {
				if (item == PFItems.CRASSOSTREA_OYSTER.get()) {
					if (!p_230254_1_.getAbilities().instabuild) {
						itemstack.shrink(1);
					}
					if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
						this.tame(p_230254_1_);
						this.navigation.stop();
						this.setTarget((LivingEntity)null);
						this.setOrderedToSit(true);
						this.level.broadcastEntityEvent(this, (byte)7);
					} else {
						this.level.broadcastEntityEvent(this, (byte)6);
					}
				}
				return InteractionResult.SUCCESS;
			}
			if (PrehistoricFaunaConfig.advancedHunger) {
				int hunger = this.getCurrentHunger();
				if (hunger < this.maxHunger) {
					if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
						this.setInLove(p_230254_1_);
						itemstack.shrink(1);
					} else {
						if (itemstack.is(PFTags.SHELLFISH_3_HUNGER)) {
							if (hunger + 3 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 3);
							}
							itemstack.shrink(1);
						}	
					}
				}
				else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
			}
			return super.mobInteract(p_230254_1_, p_230254_2_);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float func_213475_v(float p_213475_1_) {
		return Mth.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
	}

	public void aiStep() {
		if (!this.level.isClientSide && this.isAlive() && this.isEffectiveAi()) {
			++this.eatTicks;
			ItemStack stack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (this.canEatItem(stack)) {
				if (this.eatTicks > 100) {
					if (this.isTame()) {
						ItemStack itemStack = stack.finishUsingItem(level, this);
						ItemStack openedStack = PFItems.RAW_OYSTER.get().getDefaultInstance();
						if (!itemStack.isEmpty()) {
							this.setItemSlot(EquipmentSlot.MAINHAND, itemStack);
						}
						this.eatTicks = 0;
						Random random = new Random();
						int dropChance = random.nextInt(99);
						if (dropChance >=24) {
							this.spawnItem(openedStack);
						} else {
							if (PrehistoricFaunaConfig.advancedHunger) {
								if (this.getCurrentHunger() + 5 >= this.maxHunger) {
									this.setHunger(this.maxHunger);
								} else {
									this.setHunger(currentHunger + 5);
								}
							}
						}
						itemStack.shrink(1);
					} else {
						ItemStack itemStack = stack.finishUsingItem(level, this);
						if (PrehistoricFaunaConfig.advancedHunger) {
							if (this.getCurrentHunger() + 5 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(currentHunger + 5);
							}
						}
						if (!itemStack.isEmpty()) {
							this.setItemSlot(EquipmentSlot.MAINHAND, itemStack);
						}
						itemStack.shrink(1);
					}
				}
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
		super.aiStep();
	}

	public boolean canEatItem(ItemStack stack) {
		return stack.is(PFTags.SHELLFISH_3_HUNGER);
	}

	public boolean canEquipItem(ItemStack stack) {
		if (this.canEatItem(stack)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}


	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CRASSOSTREA_OYSTER.get().asItem();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new Didelphodon.SwimGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new Didelphodon.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Didelphodon.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new Didelphodon.MeleeAttackGoal());
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(10, new EatBerriesGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Thescelosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dryosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Hesperornithoides.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Exaeretodon.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(0, new Didelphodon.CarryYoungGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.targetSelector.addGoal(0, new Didelphodon.CarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, 1.75D, (p_213487_1_) -> {
			return p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Scutellosaurus;
		}));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.DIDELPHODON_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return PFSounds.DIDELPHODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.DIDELPHODON_DEATH;
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.MOVEMENT_SPEED, 0.23D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 45) {
			ItemStack itemStack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (!itemStack.isEmpty()) {
				for (int i = 0; i < 8; i++) {
					Vec3 vector3d = (new Vec3(((double)this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.xRot * ((float)Math.PI / 180F)).yRot(-this.yRot * ((float)Math.PI / 180F));
					this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemStack), this.getX() + this.getLookAngle().x / 2.0D,  this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vector3d.x, vector3d.y + 0.05D, vector3d.z);
				}
			}
		} else {
			super.handleEntityEvent(id);
		}
	}

	public void tick() {
		super.tick();
		this.interestedAngleO = this.interestedAngle;
		this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
	}

	static class MateGoal extends BreedGoal {
		private final Didelphodon didelphodon;

		MateGoal(Didelphodon didelphodon, double speed) {
			super(didelphodon, speed);
			this.didelphodon = didelphodon;
		}

		public boolean canUse() {
			return super.canUse() && !this.didelphodon.hasBaby() && !this.didelphodon.isInLoveNaturally();
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
			this.didelphodon.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Didelphodon didelphodon;

		NaturalMateGoal(Didelphodon didelphodon, double speed) {
			super(didelphodon, speed);
			this.didelphodon = didelphodon;
		}

		public boolean canUse() {
			return super.canUse() && !this.didelphodon.hasBaby() && this.didelphodon.getCurrentHunger() >= this.didelphodon.getThreeQuartersHunger() && this.didelphodon.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.didelphodon.isInLoveNaturally();
		}

		protected void breed() {
			this.didelphodon.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	abstract class PassiveGoal extends Goal {
		private PassiveGoal() {
		}

		public abstract boolean canDidelphodonStart();

		public abstract boolean canDidelphodonContinue();

		public boolean canUse() {
			return this.canDidelphodonStart();
		}

		public boolean canContinueToUse() {
			return this.canDidelphodonContinue();
		}
	}

	static class CarryYoungGoal extends MoveToBlockGoal {
		private final Didelphodon didelphodon;

		CarryYoungGoal(Didelphodon ankylosaurus, double speedIn) {
			super(ankylosaurus, speedIn, 16);
			this.didelphodon = ankylosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.didelphodon.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.didelphodon.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			if (!this.didelphodon.isInWater() && this.isReachedTarget()) {
				if (this.didelphodon.isBirthing < 1) {
					this.didelphodon.setBirthing(true);
				} else if (this.didelphodon.isBirthing > 200) {
					Level level = this.didelphodon.level;
					int amount = level.random.nextInt(4) + 1;
					for (int i = 0; i < amount; i++) {
						Didelphodon baby = new Didelphodon(PFEntities.DIDELPHODON.get(), level);
						baby.setAge(-24000);
						baby.setPos(didelphodon.getX(), didelphodon.getY(), didelphodon.getZ());
						level.addFreshEntity(baby);
					}
					this.didelphodon.setHasBaby(false);
					this.didelphodon.setBirthing(false);
					this.didelphodon.setInLoveTime(600);
				}

				if (this.didelphodon.isBirthing()) {
					this.didelphodon.isBirthing++;
				}
			}

		}

		/**
		 * Return true to set given position as destination
		 */
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Didelphodon entity = new Didelphodon(PFEntities.DIDELPHODON.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class SwimGoal extends net.minecraft.world.entity.ai.goal.FloatGoal {
		public SwimGoal() {
			super(Didelphodon.this);
		}

		public void start() {
			super.start();
		}

		public boolean canUse() {
			return Didelphodon.this.isInWater() && Didelphodon.this.getFluidHeight(FluidTags.WATER) > 0.25D || Didelphodon.this.isInLava();
		}
	}

	public class EatBerriesGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatBerriesGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Didelphodon.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			return blockstate.is(PFBlocks.CRASSOSTREA_OYSTER.get()) && blockstate.getValue(CrassostreaOysterBlock.AGE) >= 2;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 40) {
					this.eatOyster();
				} else {
					++this.field_220731_g;
				}
			} else if (!this.isReachedTarget() && Didelphodon.this.random.nextFloat() < 0.05F) {
			}

			super.tick();
		}

		protected void eatOyster() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Didelphodon.this.level, Didelphodon.this)) {
				BlockState blockstate = Didelphodon.this.level.getBlockState(this.blockPos);
				if (blockstate.is(PFBlocks.CRASSOSTREA_OYSTER.get())) {
					int i = blockstate.getValue(CrassostreaOysterBlock.AGE);
					blockstate.setValue(CrassostreaOysterBlock.AGE, Integer.valueOf(0));
					int j = 1 + Didelphodon.this.level.random.nextInt(2) + (i == 3 ? 1 : 0);
					ItemStack itemstack = Didelphodon.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Didelphodon.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(PFItems.CRASSOSTREA_OYSTER.get()));
						--j;
					}

					if (j > 0) {
						Block.popResource(Didelphodon.this.level, this.blockPos, new ItemStack(PFItems.CRASSOSTREA_OYSTER.get(), j));
					}
					Didelphodon.this.level.setBlock(this.blockPos, blockstate.setValue(CrassostreaOysterBlock.AGE, Integer.valueOf(0)), 2);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Didelphodon.this.isSleeping() && super.canUse();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}
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
			return super.canUse() && Didelphodon.this.getCurrentHunger() <= Didelphodon.this.getHalfHunger() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Didelphodon.this);
		}

		public boolean canContinueToUse() {
			return Didelphodon.this.getCurrentHunger() < Didelphodon.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Didelphodon.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Didelphodon.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Didelphodon.this.getCurrentHunger() + 3 >= Didelphodon.this.maxHunger) {
						Didelphodon.this.setHunger(Didelphodon.this.maxHunger);
					} else {
						Didelphodon.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Didelphodon.this.getCurrentHunger() + 4 >= Didelphodon.this.maxHunger) {
						Didelphodon.this.setHunger(Didelphodon.this.maxHunger);
					} else {
						Didelphodon.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Didelphodon.this.getCurrentHunger() + 6 >= Didelphodon.this.maxHunger) {
						Didelphodon.this.setHunger(Didelphodon.this.maxHunger);
					} else {
						Didelphodon.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Didelphodon.this, 1.25D, true);
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
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.DIDELPHODON_SPAWN_EGG.get());
	}
}
