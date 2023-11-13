package superlord.prehistoricfauna.common.entity.triassic.ischigualasto;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.NocturnalSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Exaeretodon extends DinosaurEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.CLADOPHLEBIS.get().asItem());
	private static final EntityDataAccessor<Boolean> DIGGING_ROOTS = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 20;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Exaeretodon(EntityType<? extends Exaeretodon> type, Level levelIn) {
		super(type, levelIn);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isDiggingForRoots() {
		return this.entityData.get(DIGGING_ROOTS);
	}

	private void setDiggingForRoots(boolean isDiggingForRoots) {
		this.entityData.set(DIGGING_ROOTS, isDiggingForRoots);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLADOPHLEBIS.get().asItem();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Exaeretodon.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new SkittishFleeGoal(this, Player.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new NocturnalSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(5, new Exaeretodon.DiggingGoal(this));
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.FOLLOW_RANGE, 15).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.EXAERETODON_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.EXAERETODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.EXAERETODON_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.EXAERETODON_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DIGGING_ROOTS, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("DiggingRoots", this.isDiggingForRoots());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setDiggingForRoots(compound.getBoolean("DiggingRoots"));
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (level.isClientSide) {
			return InteractionResult.PASS;
		} else {
			ItemStack stack = player.getItemInHand(hand);
			Item item = stack.getItem();
			if (item == PFBlocks.MICHELILLOA.get().asItem()) {
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				this.setDiggingForRoots(true);
				return InteractionResult.SUCCESS;
			}
			return super.mobInteract(player, hand);
		}
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

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Exaeretodon.this, 1.25D, true);
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
					Exaeretodon.this.playWarningSound();
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

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setTerritorial(true);
		} else if (temperment >= 95) {
			this.setSkittish(true);
		}
		this.setHerbivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Exaeretodon entity = new Exaeretodon(PFEntities.EXAERETODON.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/exaeretodon_digging");

		private final Exaeretodon exaeretodon;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Exaeretodon entity) {
			this.exaeretodon = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			BlockPos blockpos = exaeretodon.blockPosition();
			BlockState state = exaeretodon.level.getBlockState(blockpos);
			if (state.is(BlockTags.DIRT) && exaeretodon.isDiggingForRoots()) {
				return true;
			} else {
				return exaeretodon.level.getBlockState(blockpos.below()).is(BlockTags.DIRT)&& exaeretodon.isDiggingForRoots();
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			exaeretodon.level.broadcastEntityEvent(exaeretodon, (byte) 10);
			exaeretodon.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
			exaeretodon.setDiggingForRoots(false);
		}

		@Override
		public boolean canContinueToUse() {
			return diggingTimer > 0;
		}

		@Override
		public void tick() {
			if (digTimer2 > 0) {
				--digTimer2;
			}
			if (diggingTimer > 0) {
				--diggingTimer;
			}
			if (diggingTimer == 25) {
				BlockPos blockpos = exaeretodon.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (exaeretodon.level.getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = exaeretodon.level.getBlockState(blockpos1);
					exaeretodon.level.levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = exaeretodon.level.getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootTables().get(DIGGING_LOOT).getRandomItems(new LootContext.Builder((ServerLevel) exaeretodon.level).withRandom(exaeretodon.getRandom()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(exaeretodon.level, blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.EXAERETODON_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.EXAERETODON_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.EXAERETODON_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
