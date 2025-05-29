package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Liaoningosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> ASH_DIGGING = SynchedEntityData.defineId(Liaoningosaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 50;

	public Liaoningosaurus(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = this.maxHunger;
	}
	
	public boolean isAshDigging() {
		return this.entityData.get(ASH_DIGGING);
	}

	private void setAshDigging(boolean isAshDigging) {
		this.entityData.set(ASH_DIGGING, isAshDigging);
	}
	
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.EPHEDRA.get().asItem();
	}
	
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Liaoningosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(6, new DiggingGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.LIAONINGOSAURUS_AVOIDING);
		}));
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.LIAONINGOSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.LIAONINGOSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.LIAONINGOSAURUS_DEATH.get();
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ARMOR, 6.0D).add(Attributes.ARMOR_TOUGHNESS, 4.0D).add(Attributes.ATTACK_DAMAGE , 4).add(Attributes.FOLLOW_RANGE, 15);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ASH_DIGGING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("AshDigging", this.isAshDigging());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setAshDigging(compound.getBoolean("AshDigging"));
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.LIAONINGOSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.LIAONINGOSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.liaoningosaurus_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public Item getEggItem() {
		return PFItems.LIAONINGOSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.LIAONINGOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Liaoningosaurus entity = new Liaoningosaurus(PFEntities.LIAONINGOSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.LIAONINGOSAURUS_SPAWN_EGG.get());
	}
	
	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Liaoningosaurus.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse();
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
	
	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/liaoningosaurus_digging");

		private final Liaoningosaurus liaoningosaurus;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Liaoningosaurus entity) {
			this.liaoningosaurus = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			if (liaoningosaurus.getRandom().nextInt(liaoningosaurus.isBaby() ? 100 : 1000) != 0) {
				return false;
			} else {
				BlockPos blockpos = liaoningosaurus.blockPosition();
				BlockState state = liaoningosaurus.level().getBlockState(blockpos);
				if (state.is(PFBlocks.ASH.get())) {
					return true;
				} else {
					return liaoningosaurus.level().getBlockState(blockpos.below()).is(PFBlocks.ASH.get());
				}
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			liaoningosaurus.level().broadcastEntityEvent(liaoningosaurus, (byte) 10);
			liaoningosaurus.setAshDigging(true);
			liaoningosaurus.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
			liaoningosaurus.setAshDigging(false);
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
				BlockPos blockpos = liaoningosaurus.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (liaoningosaurus.level().getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = liaoningosaurus.level().getBlockState(blockpos1);
					liaoningosaurus.level().levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = liaoningosaurus.level().getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootData().getLootTable(DIGGING_LOOT).getRandomItems(new LootParams.Builder((ServerLevel) liaoningosaurus.level()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(liaoningosaurus.level(), blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}

	}

}
