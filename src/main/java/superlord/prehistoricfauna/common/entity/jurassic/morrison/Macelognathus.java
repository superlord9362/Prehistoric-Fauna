package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Macelognathus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Macelognathus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Macelognathus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(Macelognathus.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> SIT_TICK = SynchedEntityData.defineId(Macelognathus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> ARMORED = SynchedEntityData.defineId(Macelognathus.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> ARMOR_DAMAGE = SynchedEntityData.defineId(Macelognathus.class, EntityDataSerializers.INT);
	private int maxHunger = 10;
	private float sitProgress = 0.0F;
	private float prevSitProgress = 0.0F;

	public Macelognathus(EntityType<? extends Macelognathus> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.CONIOPTERIS.get();
	}

	public boolean isTameSitting() {
		return this.entityData.get(TAME_SIT);
	}

	private void setTameSitting(boolean isTameSitting) {
		this.entityData.set(SIT_TICK, 15);
		this.entityData.set(TAME_SIT, isTameSitting);
	}

	public boolean isSitting() {
		return this.entityData.get(SITTING);
	}

	private void setSitting(boolean isSitting) {
		this.entityData.set(SIT_TICK, 15);
		this.entityData.set(SITTING, isSitting);
	}

	public boolean isTameWandering() {
		return this.entityData.get(TAME_WANDER);
	}

	private void setTameWandering(boolean isTameWandering) {
		this.entityData.set(TAME_WANDER, isTameWandering);
	}

	public boolean isArmored() {
		return this.entityData.get(ARMORED);
	}

	private void setArmored(boolean isArmored) {
		this.entityData.set(ARMORED, isArmored);
	}

	public int getArmorDamage() {
		return this.entityData.get(ARMOR_DAMAGE);
	}

	private void setArmorDamage(int armorDamage) {
		this.entityData.set(ARMOR_DAMAGE, armorDamage);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new MacelognathusWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.MACELOGNATHUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.targetSelector.addGoal(0, new MacelognathusRelaxOnOwnerGoal(this));
		this.targetSelector.addGoal(0, new MacelognathusSitOnBedGoal(this, 1.1D, 8));
		this.goalSelector.addGoal(0, new MacelognathusFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, true));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setSkittish(true);
		} else {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		this.setCathemeral(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@SuppressWarnings("deprecation")
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.MACELOGNATHUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.MACELOGNATHUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.macelognathus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.macelognathus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.level().isClientSide()) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.getOwner() == player) {
					if (this.isFood(itemstack)) {
						if (this.getHealth() < this.getMaxHealth()) {
							if (!player.getAbilities().instabuild) {
								itemstack.shrink(1);
							}
							this.heal((float)item.getFoodProperties().getNutrition());
							return InteractionResult.SUCCESS;
						} else {
							if (this.canFallInLove()) {
								this.setInLove(player);
								if (!player.isCreative()) {
									itemstack.shrink(1);
								}
							}
						}
					} else if (!this.isArmored() && item == PFItems.SMALL_DINOSAUR_ARMOR.get()) {
						this.setArmored(true);
						this.setArmorDamage(itemstack.getMaxDamage() - itemstack.getDamageValue());
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					} else if (this.isArmored() && item == Items.SHEARS) {
						this.setArmored(false);
						ItemStack armorStack = new ItemStack(PFItems.SMALL_DINOSAUR_ARMOR.get());
						armorStack.setDamageValue(armorStack.getMaxDamage() - this.getArmorDamage());
						this.spawnAtLocation(armorStack);
						if (!player.isCreative()) {
							itemstack.hurtAndBreak(1, player, (p_41007_) -> {
								p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
							});
						}
					} else {
						if (this.isTameSitting()) {
							this.setTameSitting(false);
							this.setTameWandering(true);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.wandering"), true);
						} else if(this.isTameWandering()) {
							this.setTameWandering(false);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.following"), true);
						} else {
							this.setTameSitting(true);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.sitting"), true);
						}
					}
				} else if ((itemstack.is(PFTags.MEATS_2_HUNGER) || itemstack.is(PFTags.MEATS_4_HUNGER) || itemstack.is(PFTags.MEATS_6_HUNGER) || itemstack.is(PFTags.MEATS_8_HUNGER) || itemstack.is(PFTags.MEATS_10_HUNGER) || itemstack.is(PFTags.MEATS_12_HUNGER))) {
					if (this.getCurrentHunger() < this.maxHunger) {
						if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
							if (this.getCurrentHunger() + 2 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 2);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
							if (this.getCurrentHunger() + 4 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 4);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
							if (this.getCurrentHunger() + 6 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 6);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
							if (this.getCurrentHunger() + 8 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 8);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
							if (this.getCurrentHunger() + 10 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 10);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
							if (this.getCurrentHunger() + 12 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 12);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						}
					} else {
						player.displayClientMessage(Component.translatable("entity.prehistoricfauna.fullHunger"), true);
					} 
				}
			} else {
				if (this.isFood(itemstack)) {
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
						this.tame(player);
						this.navigation.stop();
						this.setTarget((LivingEntity)null);
						this.setTameSitting(true);
						this.level().broadcastEntityEvent(this, (byte)7);
					} else {
						this.level().broadcastEntityEvent(this, (byte)6);
					}

					return InteractionResult.SUCCESS;
				}
			}
		}
		return super.mobInteract(player, hand);
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

	protected void dropEquipment() {
		super.dropEquipment();
		if (this.isArmored()) {
			if (!this.level().isClientSide()) {
				ItemStack armorStack = new ItemStack(PFItems.SMALL_DINOSAUR_ARMOR.get());
				armorStack.setDamageValue(armorStack.getMaxDamage() - this.getArmorDamage());
				this.spawnAtLocation(armorStack);
			}
		}
	}

	@Override	
	public boolean hurt(DamageSource dmg, float i) {
		if (this.isArmored()) {
			if (dmg.is(DamageTypes.DROWN) || dmg.is(DamageTypes.FREEZE) || dmg.is(DamageTypes.IN_WALL) || dmg.is(DamageTypes.MAGIC) || dmg.is(DamageTypes.INDIRECT_MAGIC) || dmg.is(DamageTypes.THORNS) || dmg.is(DamageTypes.WITHER) || dmg.is(DamageTypes.FELL_OUT_OF_WORLD) || dmg.is(DamageTypes.CRAMMING)) {
				return super.hurt(dmg, i);
			} else {
				if (this.getArmorDamage() - i <= 0) {
					this.setArmored(false); 
				}
				else this.setArmorDamage(this.getArmorDamage() - (int) i);
				return super.hurt(dmg, 0);
			}
		}
		return super.hurt(dmg, i);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsTamedSitting", this.isTameSitting());
		compound.putBoolean("IsTamedWander", this.isTameWandering());
		compound.putBoolean("IsSitting", this.isSitting());
		compound.putBoolean("IsArmored", this.isArmored());
		compound.putInt("ArmorDamage", this.getArmorDamage());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
		this.setTameWandering(compound.getBoolean("IsTamedWander"));
		this.setSitting(compound.getBoolean("IsSitting"));
		this.setArmored(compound.getBoolean("IsArmored"));
		this.setArmorDamage(compound.getInt("ArmorDamage"));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TAME_SIT, false);
		this.entityData.define(TAME_WANDER, false);
		this.entityData.define(SITTING, false);
		this.entityData.define(SIT_TICK, 0);
		this.entityData.define(ARMORED, false);
		this.entityData.define(ARMOR_DAMAGE, 64);
	}

	public void tick() {
		super.tick();
		prevSitProgress = sitProgress;
		if (this.entityData.get(SIT_TICK) > 0) {
			this.entityData.set(SIT_TICK, this.entityData.get(SIT_TICK) - 1);
			if (sitProgress < 1.0F) {
				sitProgress = Math.min(sitProgress + 0.1F, 1.0F);
			}
		} else {
			if (sitProgress > 0F) {
				sitProgress = Math.max(sitProgress - 0.2F, 0.0F);
			}
		}
	}

	public float getSitProgress(float partialTick) {
		return prevSitProgress + (sitProgress - prevSitProgress) * partialTick;
	}

	public void aiStep() {
		super.aiStep();
		if (this.isSitting() || this.isTameSitting()) {
			this.getNavigation().stop();
		}
	}

	public class MacelognathusFollowOwnerGoal extends FollowOwnerGoal {

		public MacelognathusFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
			super(tameable, speed, minDist, maxDist, teleportToLeaves);
		}

		public boolean canUse() {
			return super.canUse() && !Macelognathus.this.isTameSitting() && !Macelognathus.this.isTameWandering();
		}

	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.MACELOGNATHUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.MACELOGNATHUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.MACELOGNATHUS_DEATH.get();
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Macelognathus entity = new Macelognathus(PFEntities.MACELOGNATHUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.MACELOGNATHUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.MACELOGNATHUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.MACELOGNATHUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	class MacelognathusSitOnBedGoal extends MoveToBlockGoal {
		private final Macelognathus macelognathus;

		public MacelognathusSitOnBedGoal(Macelognathus macelognathus, double p_25136_, int p_25137_) {
			super(macelognathus, p_25136_, p_25137_, 6);
			this.macelognathus = macelognathus;
			this.verticalSearchStart = -2;
			this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return this.macelognathus.isTame() && !this.macelognathus.isOrderedToSit() && super.canUse();
		}

		public void start() {
			super.start();
			this.macelognathus.setInSittingPose(false);
		}

		protected int nextStartTick(PathfinderMob p_25140_) {
			return 40;
		}

		public void stop() {
			super.stop();
			this.macelognathus.setSitting(false);
		}

		public void tick() {
			super.tick();
			this.macelognathus.setInSittingPose(false);
			if (!this.isReachedTarget()) {
				this.macelognathus.setSitting(false);
			} else if (!this.macelognathus.isSitting()) {
				this.macelognathus.setSitting(true);
			}

		}

		protected boolean isValidTarget(LevelReader p_25142_, BlockPos p_25143_) {
			return p_25142_.isEmptyBlock(p_25143_.above()) && p_25142_.getBlockState(p_25143_).is(BlockTags.BEDS);
		}
	}

	static class MacelognathusRelaxOnOwnerGoal extends Goal {
		private static final ResourceLocation GIFT_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "gameplay/macelognathus_gift");
		private final Macelognathus macelognathus;
		@Nullable
		private Player ownerPlayer;
		@Nullable
		private BlockPos goalPos;
		private int onBedTicks;

		public MacelognathusRelaxOnOwnerGoal(Macelognathus macelognathus) {
			this.macelognathus = macelognathus;
		}

		public boolean canUse() {
			if (!this.macelognathus.isTame()) {
				return false;
			} else if (this.macelognathus.isOrderedToSit()) {
				return false;
			} else {
				LivingEntity livingentity = this.macelognathus.getOwner();
				if (livingentity instanceof Player) {
					this.ownerPlayer = (Player)livingentity;
					if (!livingentity.isSleeping()) {
						return false;
					}

					if (this.macelognathus.distanceToSqr(this.ownerPlayer) > 100.0D) {
						return false;
					}

					BlockPos blockpos = this.ownerPlayer.blockPosition();
					BlockState blockstate = this.macelognathus.level().getBlockState(blockpos);
					if (blockstate.is(BlockTags.BEDS)) {
						this.goalPos = blockstate.getOptionalValue(BedBlock.FACING).map((p_28209_) -> {
							return blockpos.relative(p_28209_.getOpposite());
						}).orElseGet(() -> {
							return new BlockPos(blockpos);
						});
						return !this.spaceIsOccupied();
					}
				}

				return false;
			}
		}

		@SuppressWarnings("resource")
		private boolean spaceIsOccupied() {
			for(Macelognathus macelognathus : this.macelognathus.level().getEntitiesOfClass(Macelognathus.class, (new AABB(this.goalPos)).inflate(2.0D))) {
				if (macelognathus != this.macelognathus && (macelognathus.isSitting())) {
					return true;
				}
			}

			return false;
		}

		public boolean canContinueToUse() {
			return this.macelognathus.isTame() && !this.macelognathus.isOrderedToSit() && this.ownerPlayer != null && this.ownerPlayer.isSleeping() && this.goalPos != null && !this.spaceIsOccupied();
		}

		public void start() {
			if (this.goalPos != null) {
				this.macelognathus.setInSittingPose(false);
				this.macelognathus.getNavigation().moveTo((double)this.goalPos.getX(), (double)this.goalPos.getY(), (double)this.goalPos.getZ(), (double)1.1F);
			}

		}

		public void stop() {
			this.macelognathus.setSitting(false);
			float f = this.macelognathus.level().getTimeOfDay(1.0F);
			if (this.ownerPlayer.getSleepTimer() >= 100 && (double)f > 0.77D && (double)f < 0.8D && (double)this.macelognathus.level().getRandom().nextFloat() < 0.7D) {
				this.giveMorningGift();
			}

			this.onBedTicks = 0;
			this.macelognathus.getNavigation().stop();
		}

		private void giveMorningGift() {
			RandomSource randomsource = this.macelognathus.getRandom();
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
			blockpos$mutableblockpos.set(this.macelognathus.isLeashed() ? this.macelognathus.getLeashHolder().blockPosition() : this.macelognathus.blockPosition());
			this.macelognathus.randomTeleport((double)(blockpos$mutableblockpos.getX() + randomsource.nextInt(11) - 5), (double)(blockpos$mutableblockpos.getY() + randomsource.nextInt(5) - 2), (double)(blockpos$mutableblockpos.getZ() + randomsource.nextInt(11) - 5), false);
			blockpos$mutableblockpos.set(this.macelognathus.blockPosition());
			LootTable loottable = this.macelognathus.level().getServer().getLootData().getLootTable(GIFT_LOOT);
			LootParams lootparams = (new LootParams.Builder((ServerLevel)this.macelognathus.level())).withParameter(LootContextParams.ORIGIN, this.macelognathus.position()).withParameter(LootContextParams.THIS_ENTITY, this.macelognathus).create(LootContextParamSets.GIFT);

			for(ItemStack itemstack : loottable.getRandomItems(lootparams)) {
				this.macelognathus.level().addFreshEntity(new ItemEntity(this.macelognathus.level(), (double)blockpos$mutableblockpos.getX() - (double)Mth.sin(this.macelognathus.yBodyRot * ((float)Math.PI / 180F)), (double)blockpos$mutableblockpos.getY(), (double)blockpos$mutableblockpos.getZ() + (double)Mth.cos(this.macelognathus.yBodyRot * ((float)Math.PI / 180F)), itemstack));
			}

		}

		public void tick() {
			if (this.ownerPlayer != null && this.goalPos != null) {
				this.macelognathus.setInSittingPose(false);
				this.macelognathus.getNavigation().moveTo((double)this.goalPos.getX(), (double)this.goalPos.getY(), (double)this.goalPos.getZ(), (double)1.1F);
				if (this.macelognathus.distanceToSqr(this.ownerPlayer) < 2.5D) {
					++this.onBedTicks;
					if (this.onBedTicks > this.adjustedTickDelay(16)) {
						this.macelognathus.setSitting(true);
					} else {
						this.macelognathus.lookAt(this.ownerPlayer, 45.0F, 45.0F);
					}
				} else {
					this.macelognathus.setSitting(false);
				}
			}

		}
	}

	public class MacelognathusWaterAvoidingRandomStrollGoal extends DinosaurWaterAvoidingRandomStrollGoal {
		Macelognathus dinosaur;

		public MacelognathusWaterAvoidingRandomStrollGoal(Macelognathus p_25987_, double p_25988_) {
			super(p_25987_, p_25988_);
			this.dinosaur = p_25987_;
		}

		public boolean canUse() {
			return super.canUse() && !(dinosaur.isTameSitting());
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !(dinosaur.isTameSitting());
		}

		public void tick() {
			super.tick();
			if (dinosaur.isTameSitting()) stop();
		}
	}

}
