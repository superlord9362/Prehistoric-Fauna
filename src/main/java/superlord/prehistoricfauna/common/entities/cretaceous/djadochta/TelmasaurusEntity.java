package superlord.prehistoricfauna.common.entities.cretaceous.djadochta;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TurtleEggBlock;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class TelmasaurusEntity extends DinosaurEntity {

	public TelmasaurusEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(TelmasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(TelmasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(TelmasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(TelmasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(TelmasaurusEntity.class, DataSerializers.BOOLEAN);
	private int currentHunger;
	private int maxHunger = 15;
	private int lastInLove = 0;
	int hungerTick = 0;
	int timer = 0;
	private int isDigging;
	int loveTick = 0;

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}

	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}

	public boolean isAlbino() {
		return this.dataManager.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.dataManager.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.dataManager.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.dataManager.set(MELANISTIC, isMelanistic);
	}

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return (stack.getItem() == PFBlocks.AEPYORNITHOMIMUS_EGG.asItem() || stack.getItem() == PFBlocks.CITIPATI_EGG.asItem() || stack.getItem() == PFBlocks.PINACOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.PLESIOHADROS_EGG.asItem() || stack.getItem() == PFBlocks.PROTOCERATOPS_EGG.asItem() || stack.getItem() == PFBlocks.VELOCIRAPTOR_EGG.asItem() || stack.getItem() == PFBlocks.ANKYLOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.BASILEMYS_EGG.asItem() || stack.getItem() == PFBlocks.DAKOTARAPTOR_EGG.asItem() || stack.getItem() == PFBlocks.THESCELOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.TRICERATOPS_EGG.asItem() || stack.getItem() == PFBlocks.TYRANNOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.CALSOYASUCHUS_EGG.asItem() || stack.getItem() == PFBlocks.DILOPHOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.KAYENTATHERIUM_EGG.asItem() || stack.getItem() == PFBlocks.MEGAPNOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.SARAHSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.SCELIDOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.SCUTELLOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.ALLOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.CAMARASAURUS_EGG.asItem() || stack.getItem() == PFBlocks.CERATOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.DRYOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.EILENODON_EGG.asItem() || stack.getItem() == PFBlocks.HESPERORNITHOIDES_EGG.asItem() || stack.getItem() == PFBlocks.STEGOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.DESMATOSUCHUS_EGG.asItem() || stack.getItem() == PFBlocks.PLACERIAS_EGG.asItem() || stack.getItem() == PFBlocks.POSTOSUCHUS_EGG.asItem() || stack.getItem() == PFBlocks.TRILOPHOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.CHROMOGISAURUS_EGG.asItem() || stack.getItem() == PFBlocks.EXAERETODON_EGG.asItem() || stack.getItem() == PFBlocks.HERRERASAURUS_EGG.asItem() || stack.getItem() == PFBlocks.HYPERODAPEDON_EGG.asItem() || stack.getItem() == PFBlocks.ISCHIGUALASTIA_EGG.asItem() || stack.getItem() == PFBlocks.SAUROSUCHUS_EGG.asItem() || stack.getItem() == PFBlocks.SILLOSUCHUS_EGG.asItem());
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

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), stack);
		this.world.addEntity(itemEntity);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 0.5F;
	}

	public void livingTick() {
		super.livingTick();
		ItemStack stack = this.getHeldItemMainhand();
		ItemStack newStack = new ItemStack(Items.AIR);
		if (stack.getItem() != Items.AIR) {
			timer++;
			if (timer == 600) {
				if (PrehistoricFaunaConfig.advancedHunger) {
					if (stack.getItem() == PFBlocks.TELMASAURUS_EGG.asItem() || stack.getItem() == PFBlocks.CITIPATI_EGG.asItem() || stack.getItem() == PFBlocks.VELOCIRAPTOR_EGG.asItem() || stack.getItem() == PFBlocks.EXAERETODON_EGG.asItem() || stack.getItem() == PFBlocks.CHROMOGISAURUS_EGG.asItem() || stack.getItem() == PFBlocks.HYPERODAPEDON_EGG.asItem() || stack.getItem() == PFBlocks.HESPERORNITHOIDES_EGG.asItem() || stack.getItem() == PFBlocks.EILENODON_EGG.asItem() || stack.getItem() == PFBlocks.DRYOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.BASILEMYS_EGG.asItem() || stack.getItem() == PFBlocks.THESCELOSAURUS_EGG.asItem()) {
						if (this.getCurrentHunger() + 5 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 5);
						}
					}
					if (stack.getItem() == PFBlocks.HERRERASAURUS_EGG.asItem() || stack.getItem() == PFBlocks.PLESIOHADROS_EGG.asItem() || stack.getItem() == PFBlocks.AEPYORNITHOMIMUS_EGG.asItem() || stack.getItem() == PFBlocks.PROTOCERATOPS_EGG.asItem() || stack.getItem() == PFBlocks.SILLOSUCHUS_EGG.asItem() || stack.getItem() == PFBlocks.CERATOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.ALLOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.DAKOTARAPTOR_EGG.asItem()) {
						if (this.getCurrentHunger() + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 10);
						}
					}
					if (stack.getItem() == PFBlocks.PINACOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.ISCHIGUALASTIA_EGG.asItem() || stack.getItem() == PFBlocks.SAUROSUCHUS_EGG.asItem() || stack.getItem() == PFBlocks.STEGOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.CAMARASAURUS_EGG.asItem() || stack.getItem() == PFBlocks.TYRANNOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.ANKYLOSAURUS_EGG.asItem() || stack.getItem() == PFBlocks.TRICERATOPS_EGG.asItem()) {
						if (this.getCurrentHunger() + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 15);
						}
					}
				}
				this.setHeldItem(Hand.MAIN_HAND, newStack);
			}
			if (this.getRevengeTarget() != null && timer < 600) {
				this.spawnItem(stack);
				this.setHeldItem(Hand.MAIN_HAND, newStack);
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.25F);
		}
		if (!this.isAIDisabled()) {
			List<TelmasaurusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 900 && !this.isChild() || hungerTick == 450 && this.isChild()) {
					hungerTick = 0;
					if (currentHunger != 0 || !this.isAsleep()) {
						this.setHunger(currentHunger - 1);
					}
					if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && this.getHealth() > (this.getMaxHealth() / 2)) {
						this.damageEntity(DamageSource.STARVE, 1);
					}
					if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && world.getDifficulty() == Difficulty.HARD) {
						this.damageEntity(DamageSource.STARVE, 1);
					}
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getAttackTarget() == null && this.getRevengeTarget() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 3) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLove(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				int naturalBreedingChance = rand.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 3) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLove(600);
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
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new TelmasaurusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new TelmasaurusEntity.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new TelmasaurusEntity.HurtByTargetGoal());
		this.goalSelector.addGoal(0, new TelmasaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TelmasaurusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TelmasaurusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new TelmasaurusEntity.EatEggGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new TelmasaurusEntity.HungerEatEggGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<CamarasaurusEntity>(this, CamarasaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<AllosaurusEntity>(this, AllosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<CitipatiEntity>(this, CitipatiEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<TyrannosaurusEntity>(this, TyrannosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<VelociraptorEntity>(this, VelociraptorEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<AepyornithomimusEntity>(this, AepyornithomimusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<ProtoceratopsEntity>(this, ProtoceratopsEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<TriceratopsEntity>(this, TriceratopsEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<ThescelosaurusEntity>(this, ThescelosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<AnkylosaurusEntity>(this, AnkylosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<DakotaraptorEntity>(this, DakotaraptorEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<StegosaurusEntity>(this, StegosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<DryosaurusEntity>(this, DryosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<ExaeretodonEntity>(this, ExaeretodonEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<HerrerasaurusEntity>(this, HerrerasaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<SillosuchusEntity>(this, SillosuchusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<DilophosaurusEntity>(this, DilophosaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<PoposaurusEntity>(this, PoposaurusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<PostosuchusEntity>(this, PostosuchusEntity.class, 10F, 1.75D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<CoelophysisEntity>(this, CoelophysisEntity.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 6.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.25F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.TELMASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.TELMASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.TELMASAURUS_DEATH;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHunger(compound.getInt("MaxHunger"));
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.applyEnchantments(this, entityIn);
			((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 100, 0, false, false));
		}

		return flag;
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(TelmasaurusEntity.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			super.startExecuting();
			if (TelmasaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof AllosaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class EatEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(TelmasaurusEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.timeoutCounter % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			Block eggs = blockstate.getBlock();
			return (blockstate.isIn(Blocks.TURTLE_EGG) && blockstate.get(TurtleEggBlock.EGGS) >= 1) || (eggs instanceof DinosaurEggBlock && blockstate.get(DinosaurEggBlock.EGGS) >= 1 && blockstate.getBlock() != PFBlocks.TELMASAURUS_EGG);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = TelmasaurusEntity.this.getHeldItemMainhand();
			if (this.getIsAboveDestination() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(TelmasaurusEntity.this.world, TelmasaurusEntity.this)) {
				BlockState blockstate = TelmasaurusEntity.this.world.getBlockState(this.destinationBlock);
				world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), destinationBlock.getX(), destinationBlock.getY(), destinationBlock.getZ(), 0.0D, 0.0D, 0.0D);
				if (blockstate.isIn(Blocks.TURTLE_EGG)) {
					int i = blockstate.get(TurtleEggBlock.EGGS);
					blockstate.with(TurtleEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = TelmasaurusEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
					if (itemstack.isEmpty()) {
						TelmasaurusEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.TURTLE_EGG));
					}
					if (i > 1) {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, blockstate.with(TurtleEggBlock.EGGS, i - 1));
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					} else {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, Blocks.AIR.getDefaultState());
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					}
				}
				Block eggs = blockstate.getBlock();
				if (eggs instanceof DinosaurEggBlock) {
					int i = blockstate.get(DinosaurEggBlock.EGGS);
					blockstate.with(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = TelmasaurusEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
					if (itemstack.isEmpty()) {
						TelmasaurusEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(eggs.asItem()));
					}
					if (i > 1) {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, blockstate.with(DinosaurEggBlock.EGGS, i - 1));
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					} else {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, Blocks.AIR.getDefaultState());
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					}
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			ItemStack stack = TelmasaurusEntity.this.getHeldItemMainhand();
			return !TelmasaurusEntity.this.isSleeping() && super.shouldExecute() && stack.getItem() == Items.AIR && !PrehistoricFaunaConfig.advancedHunger;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_220731_g = 0;
			super.startExecuting();
		}


		public boolean shouldContinueExecuting() {
			ItemStack stack = new ItemStack(Items.AIR);
			return TelmasaurusEntity.this.getHeldItemMainhand() == stack;
		}

	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(TelmasaurusEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.func_234040_h_()) {
					this.func_234039_g_();
				}
			} else {
				this.func_234039_g_();
			}

		}

		public boolean shouldContinueExecuting() {
			float f = this.attacker.getBrightness();
			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((LivingEntity)null);
				return false;
			} else {
				return super.shouldContinueExecuting();
			}
		}

		public void resetTask() {
			super.resetTask();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(8.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(TelmasaurusEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !TelmasaurusEntity.this.isChild() && !TelmasaurusEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final TelmasaurusEntity telmasaurus;

		LayEggGoal(TelmasaurusEntity telmasaurus, double speedIn) {
			super(telmasaurus, speedIn, 16);
			this.telmasaurus = telmasaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return this.telmasaurus.hasEgg() ? super.shouldExecute() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.telmasaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.telmasaurus.getPositionVec());
			if (this.getIsAboveDestination()) {
				if (this.telmasaurus.isDigging < 1) {
					this.telmasaurus.setDigging(true);
				} else if (this.telmasaurus.isDigging > 200) {
					World world = this.telmasaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.TELMASAURUS_EGG.getDefaultState().with(DinosaurEggBlock.EGGS, Integer.valueOf(this.telmasaurus.rand.nextInt(4) + 1)), 3);
					this.telmasaurus.setHasEgg(false);
					this.telmasaurus.setDigging(false);
					this.telmasaurus.setInLove(600);
				}

				if (this.telmasaurus.isDigging()) {
					this.telmasaurus.isDigging++;
				}
			}

		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.MOSS_BLOCK || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.SILT || block == PFBlocks.PACKED_LOAM || block == BlockTags.LEAVES;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final TelmasaurusEntity telmasaurus;

		MateGoal(TelmasaurusEntity telmasaurus, double speedIn) {
			super(telmasaurus, speedIn);
			this.telmasaurus = telmasaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.telmasaurus.hasEgg() && !this.telmasaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}

			this.telmasaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final TelmasaurusEntity telmasaurus;

		NaturalMateGoal(TelmasaurusEntity telmasaurus, double speed) {
			super(telmasaurus, speed);
			this.telmasaurus = telmasaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.telmasaurus.hasEgg() && this.telmasaurus.getCurrentHunger() >= this.telmasaurus.getThreeQuartersHunger() && this.telmasaurus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.telmasaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.telmasaurus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.telmasaurus.rand.nextFloat() - this.telmasaurus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.telmasaurus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
					this.telmasaurus.entityDropItem(PFBlocks.TELMASAURUS_EGG.asItem());
				}
			} else {
				this.telmasaurus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		TelmasaurusEntity entity = new TelmasaurusEntity(PFEntities.TELMASAURUS_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	class HungerEatEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HungerEatEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(TelmasaurusEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.timeoutCounter % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			Block eggs = blockstate.getBlock();
			return (blockstate.isIn(Blocks.TURTLE_EGG) && blockstate.get(TurtleEggBlock.EGGS) >= 1) || (eggs instanceof DinosaurEggBlock && blockstate.get(DinosaurEggBlock.EGGS) >= 1 && blockstate.getBlock() != PFBlocks.TELMASAURUS_EGG);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = TelmasaurusEntity.this.getHeldItemMainhand();
			if (this.getIsAboveDestination() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(TelmasaurusEntity.this.world, TelmasaurusEntity.this)) {
				BlockState blockstate = TelmasaurusEntity.this.world.getBlockState(this.destinationBlock);
				world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), destinationBlock.getX(), destinationBlock.getY(), destinationBlock.getZ(), 0.0D, 0.0D, 0.0D);
				if (blockstate.isIn(Blocks.TURTLE_EGG)) {
					int i = blockstate.get(TurtleEggBlock.EGGS);
					blockstate.with(TurtleEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = TelmasaurusEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
					if (itemstack.isEmpty()) {
						TelmasaurusEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.TURTLE_EGG));
					}
					if (i > 1) {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, blockstate.with(TurtleEggBlock.EGGS, i - 1));
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					} else {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, Blocks.AIR.getDefaultState());
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					}
				}
				Block eggs = blockstate.getBlock();
				if (eggs instanceof DinosaurEggBlock) {
					int i = blockstate.get(DinosaurEggBlock.EGGS);
					blockstate.with(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = TelmasaurusEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
					if (itemstack.isEmpty()) {
						TelmasaurusEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(eggs.asItem()));
					}
					if (i > 1) {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, blockstate.with(DinosaurEggBlock.EGGS, i - 1));
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					} else {
						TelmasaurusEntity.this.world.setBlockState(this.destinationBlock, Blocks.AIR.getDefaultState());
						world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.NEUTRAL, 1, 1);
					}
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			ItemStack stack = TelmasaurusEntity.this.getHeldItemMainhand();
			return !TelmasaurusEntity.this.isSleeping() && super.shouldExecute() && stack.getItem() == Items.AIR && PrehistoricFaunaConfig.advancedHunger && TelmasaurusEntity.this.getCurrentHunger() <= TelmasaurusEntity.this.getHalfHunger();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_220731_g = 0;
			super.startExecuting();
		}

		public boolean shouldContinueExecuting() {
			ItemStack stack = new ItemStack(Items.AIR);
			return TelmasaurusEntity.this.getHeldItemMainhand() == stack || TelmasaurusEntity.this.getCurrentHunger() <= TelmasaurusEntity.this.maxHunger;
		}
	}


}
