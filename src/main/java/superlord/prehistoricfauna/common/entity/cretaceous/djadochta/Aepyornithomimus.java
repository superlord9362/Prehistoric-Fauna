package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
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
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.HerdDinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.FollowHerdLeaderGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Aepyornithomimus extends HerdDinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Aepyornithomimus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Aepyornithomimus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Aepyornithomimus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Aepyornithomimus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(Aepyornithomimus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Aepyornithomimus.class, EntityDataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.COBBANIA.get().asItem());
	private int isDigging;
	private int maxHunger = 25;
	private int lastInLove = 0;
	private int currentHunger = 25;
	int hungerTick = 0;
	private int chewingTick;
	int loveTick = 0;

	@SuppressWarnings("deprecation")
	public Aepyornithomimus(EntityType<? extends Aepyornithomimus> type, Level world) {
		super(type, world);
		this.maxUpStep = 1.0F;
	}

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.entityData.set(HAS_EGG, hasEgg);
	}

	public boolean isEating() {
		return this.entityData.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
	}

	public boolean isDigging() {
		return this.entityData.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.entityData.set(IS_DIGGING, isDigging);
	}

	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveTimeNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
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

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.COBBANIA.get().asItem();
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

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.625F;
		else return 1.25F;
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

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
		this.level.addFreshEntity(itemEntity);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(EATING, false);
		this.entityData.define(NATURAL_LOVE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveTimeNaturally(compound.getBoolean("InNaturalLove"));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new Aepyornithomimus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Aepyornithomimus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new Aepyornithomimus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new FollowHerdLeaderGoal(this));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new Aepyornithomimus.HerbivoreEatGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.5D, 1.75D));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.AEPYORNITHOMIMUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.AEPYORNITHOMIMUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.AEPYORNITHOMIMUS_DEATH;
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.chewingTick == 0 && (item == PFItems.PTILOPHYLLUM_FRONDS.get() || item == PFBlocks.DICROIDIUM.get().asItem() || item == PFBlocks.JOHNSTONIA.get().asItem() || item == PFBlocks.MICHELILLOA.get().asItem() || item == PFBlocks.SCYTOPHYLLUM.get().asItem() || item == PFBlocks.METASEQUOIA_SAPLING.get().asItem() || item == PFBlocks.PROTOPICEOXYLON_SAPLING.get().asItem() || item == PFBlocks.PROTOJUNIPEROXYLON_SAPLING.get().asItem() || item == PFBlocks.HEIDIPHYLLUM_SAPLING.get().asItem())) {
			this.chewingTick = 600;
			if (!p_230254_1_.isCreative()) {
				itemstack.shrink(1);
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
					if (itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
						if (hunger + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 15);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
						if (hunger + 20 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 20);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
						if (hunger + 25 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 25);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
						if (hunger + 30 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 30);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.22D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Aepyornithomimus aepyornithomimus;

		LayEggGoal(Aepyornithomimus aepyornithomimus, double speed) {
			super(aepyornithomimus, speed, 16);
			this.aepyornithomimus = aepyornithomimus;
		}

		public boolean canUse() {
			return this.aepyornithomimus.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.aepyornithomimus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.aepyornithomimus.blockPosition());
			if (this.isReachedTarget()) {
				if (this.aepyornithomimus.isDigging < 1) {
					this.aepyornithomimus.setDigging(true);
				} else if (this.aepyornithomimus.isDigging > 200) {
					Level world = this.aepyornithomimus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.AEPYORNITHOMIMUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.aepyornithomimus.random.nextInt(4) + 1)), 3);
					this.aepyornithomimus.setHasEgg(false);
					this.aepyornithomimus.setDigging(false);
					this.aepyornithomimus.setInLoveTime(600);
				}
				if (this.aepyornithomimus.isDigging()) {
					this.aepyornithomimus.isDigging++;
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

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.chewingTick > 0) {
			--chewingTick;
		}
		if (this.chewingTick == 1) {
			this.spawnItem(PFItems.PLANT_FIBER.get().getDefaultInstance());
			this.spawnItem(PFItems.PLANT_FIBER.get().getDefaultInstance());
			this.spawnItem(PFItems.PLANT_FIBER.get().getDefaultInstance());
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
		if (!this.isNoAi()) {
			List<? extends Aepyornithomimus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0  && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 20) {
						loveTick = 600;
						this.setInLoveTimeNaturally(true);
						this.setInLoveTime(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveTimeNaturally(false);
					}
				}
			} else if ((PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && !PrehistoricFaunaConfig.advancedHunger) {
				int naturalBreedingChance = random.nextInt(1000);

				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 20) {
					loveTick = 600;
					this.setInLoveTimeNaturally(true);
					this.setInLoveTime(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveTimeNaturally(false);
				}
			}
			if (lastInLove != 0) {
				lastInLove--;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final Aepyornithomimus aepyornithomimus;

		MateGoal(Aepyornithomimus aepyornithomimus, double speed) {
			super(aepyornithomimus, speed);
			this.aepyornithomimus = aepyornithomimus;
		}

		public boolean canUse() {
			return super.canUse() && !this.aepyornithomimus.hasEgg() && !this.aepyornithomimus.isInLoveNaturally();
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
			this.aepyornithomimus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random randomom = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), randomom.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Aepyornithomimus aepyornithomimus;

		NaturalMateGoal(Aepyornithomimus aepyornithomimus, double speed) {
			super(aepyornithomimus, speed);
			this.aepyornithomimus = aepyornithomimus;
		}

		public boolean canUse() {
			return super.canUse() && !this.aepyornithomimus.hasEgg() && this.aepyornithomimus.getCurrentHunger() >= this.aepyornithomimus.getThreeQuartersHunger() && this.aepyornithomimus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.aepyornithomimus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.aepyornithomimus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.aepyornithomimus.random.nextFloat() - this.aepyornithomimus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.aepyornithomimus.random.nextInt(4);
				if (eggAmount == 0) {
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
					this.aepyornithomimus.spawnAtLocation(PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem());
				}
			} else {
				this.aepyornithomimus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Aepyornithomimus entity = new Aepyornithomimus(PFEntities.AEPYORNITHOMIMUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Aepyornithomimus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			return blockstate.is(PFTags.PLANTS_2_HUNGER) || blockstate.is(PFTags.PLANTS_4_HUNGER) || blockstate.is(PFTags.PLANTS_6_HUNGER) || blockstate.is(PFTags.PLANTS_8_HUNGER) || blockstate.is(PFTags.PLANTS_10_HUNGER) || blockstate.is(PFTags.PLANTS_12_HUNGER) || blockstate.is(PFTags.PLANTS_15_HUNGER) || blockstate.is(PFTags.PLANTS_20_HUNGER) || blockstate.is(PFTags.PLANTS_25_HUNGER) || blockstate.is(PFTags.PLANTS_30_HUNGER);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					Aepyornithomimus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Aepyornithomimus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Aepyornithomimus.this.getCurrentHunger() >= 13) {
				Aepyornithomimus.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = Aepyornithomimus.this.level.getBlockState(this.blockPos);

			if (blockstate.is(PFTags.PLANTS_2_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 2 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 2);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_4_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 4 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 4);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_6_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 6 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 6);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_8_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 8 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 8);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_10_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 10 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 10);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_12_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 12 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 12);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_15_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 15 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 15);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_20_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 20 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 20);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_25_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 25 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 25);
					Aepyornithomimus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_30_HUNGER)) {
				int hunger = Aepyornithomimus.this.getCurrentHunger();
				if (hunger + 30 >= Aepyornithomimus.this.maxHunger) {
					Aepyornithomimus.this.setHunger(Aepyornithomimus.this.maxHunger);
					Aepyornithomimus.this.setEating(false);
				} else {
					Aepyornithomimus.this.setHunger(hunger + 30);
					Aepyornithomimus.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Aepyornithomimus.this.isAsleep() && super.canUse() && Aepyornithomimus.this.getCurrentHunger() < Aepyornithomimus.this.getHalfHunger();
		}

		public boolean canContinueToUse() {
			if (Aepyornithomimus.this.getCurrentHunger() >= Aepyornithomimus.this.maxHunger || Aepyornithomimus.this.isAsleep()) {
				return false;
			} else return super.canContinueToUse();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.AEPYORNITHOMIMUS_SPAWN_EGG.get());
	}

}
