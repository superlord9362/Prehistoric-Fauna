package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
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

public class Kayentachelys extends DinosaurEntity {
	private int maxHunger = 20;

	public Kayentachelys(EntityType<? extends Kayentachelys> type, Level level) {
		super(type, level);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.moveControl = new Kayentachelys.KayentachelysMoveControl(this);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
	}

	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			if (this.isEffectiveAi() && this.isInWater()) {
				this.moveRelative(this.getSpeed(), travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
				if (this.getTarget() == null) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
				}
				if (this.getAirSupply() < this.getMaxAirSupply() / 3) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
				}
			} else {
				super.travel(travelVector);
			}
		}
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new Kayentachelys.KayentachelysPanicGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(3, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(2, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.KAYENTACHELYS_AVOIDING);
		}));
		this.goalSelector.addGoal(3, new Kayentachelys.KayentachelysGoToWaterGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(5, new Kayentachelys.KayentachelysRandomStrollGoal(this, 1.0D, 100));
		this.goalSelector.addGoal(3, new Kayentachelys.SwimGoal(this));
		this.goalSelector.addGoal(4, new DiggingGoal(this));
	}

	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public int getMaxAirSupply() {
		return 4800;
	}

	protected int increaseAirSupply(int p_28389_) {
		return this.getMaxAirSupply();
	}

	protected float getWaterSlowDown() {
		return 0.95F;
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.KAYENTACHELYS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.KAYENTACHELYS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.kayentachelys_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.kayentachelys_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.KAYENTACHELYS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.KAYENTACHELYS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.KAYENTACHELYS_DEATH.get();
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.1D).add(Attributes.KNOCKBACK_RESISTANCE, 0.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.ARMOR_TOUGHNESS, 2.0D);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Kayentachelys entity = new Kayentachelys(PFEntities.KAYENTACHELYS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.KAYENTACHELYS_SPAWN_EGG.get());
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setPassive(true);
		} else {
			this.setSkittish(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		this.setAirSupply(this.getMaxAirSupply());
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}


	public Item getEggItem() {
		return PFItems.KAYENTACHELYS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.KAYENTACHELYS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	static class SwimGoal extends RandomSwimmingGoal {

		public SwimGoal(Kayentachelys kayentachelys) {
			super(kayentachelys, 1.0D, 40);
		}

		public boolean canUse() {
			return super.canUse();
		}
	}

	static class KayentachelysGoToWaterGoal extends MoveToBlockGoal {
		private static final int GIVE_UP_TICKS = 1200;
		private final Kayentachelys kayentachelys;

		KayentachelysGoToWaterGoal(Kayentachelys kayentachelys, double speed) {
			super(kayentachelys, kayentachelys.isBaby() ? 2.0D : speed, 24);
			this.kayentachelys = kayentachelys;
			this.verticalSearchStart = -1;
		}

		public boolean canContinueToUse() {
			return !this.kayentachelys.isInWater() && this.tryTicks <= GIVE_UP_TICKS && this.isValidTarget(this.kayentachelys.level(), this.blockPos);
		}

		public boolean canUse() {
			if (this.kayentachelys.isBaby() && !this.kayentachelys.isInWater()) {
				return super.canUse();
			} else return !this.kayentachelys.isInWater() && !this.kayentachelys.hasBaby() ? super.canUse() : false;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 160 == 0;
		}

		protected boolean isValidTarget(LevelReader level, BlockPos pos) {
			return level.getBlockState(pos).is(Blocks.WATER);
		}
	}

	static class KayentachelysPanicGoal extends BabyPanicGoal {
		KayentachelysPanicGoal(Kayentachelys kayentachelys) {
			super(kayentachelys);
		}

		public boolean canUse() {
			if (!this.shouldPanic()) {
				return false;
			} else {
				BlockPos blockpos = this.lookForWater(this.mob.level(), this.mob, 7);
				if (blockpos != null) {
					this.posX = (double)blockpos.getX();
					this.posY = (double)blockpos.getY();
					this.posZ = (double)blockpos.getZ();
					return true;
				} else {
					return this.findRandomPosition();
				}
			}
		}
	}

	static class KayentachelysRandomStrollGoal extends RandomStrollGoal {
		private final Kayentachelys kayentachelys;

		KayentachelysRandomStrollGoal(Kayentachelys kayentachelys, double speed, int interval) {
			super(kayentachelys, speed, interval);
			this.kayentachelys = kayentachelys;
		}

		public boolean canUse() {
			return !this.mob.isInWater() && !this.kayentachelys.hasBaby() ? super.canUse() : false;
		}
	}

	static class KayentachelysPathNavigation extends WaterBoundPathNavigation {
		KayentachelysPathNavigation(Kayentachelys kayentachelys, Level level) {
			super(kayentachelys, level);
		}

		protected boolean canUpdatePath() {
			return true;
		}

		protected PathFinder createPathFinder(int maxNodes) {
			this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
			return new PathFinder(this.nodeEvaluator, maxNodes);
		}

		public boolean isStableDestination(BlockPos pos) {
			return !this.level.getBlockState(pos.below()).isAir();
		}

	}

	static class KayentachelysMoveControl extends MoveControl {
		private final Kayentachelys kayentachelys;

		KayentachelysMoveControl(Kayentachelys kayentachelys) {
			super(kayentachelys);
			this.kayentachelys = kayentachelys;
		}

		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.kayentachelys.getNavigation().isDone()) {
				double d0 = this.wantedX - this.kayentachelys.getX();
				double d1 = this.wantedY - this.kayentachelys.getY();
				double d2 = this.wantedZ - this.kayentachelys.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 *d2);
				d1 /= d3;
				float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.kayentachelys.setYRot(this.rotlerp(this.kayentachelys.getYRot(), f, 90.0F));
				this.kayentachelys.yBodyRot = this.kayentachelys.getYRot();
				float f1 = (float)(this.speedModifier * this.kayentachelys.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.kayentachelys.setSpeed(Mth.lerp(0.125F, this.kayentachelys.getSpeed(), f1));
				this.kayentachelys.setDeltaMovement(this.kayentachelys.getDeltaMovement().add(0.0D, (double)this.kayentachelys.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.kayentachelys.setSpeed(0.0F);
			}
		}

	}

	protected PathNavigation createNavigation(Level level) {
		return new Kayentachelys.KayentachelysPathNavigation(this, level);
	}

	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "gameplay/kayentachelys_digging");

		private final Kayentachelys kayentachelys;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Kayentachelys entity) {
			this.kayentachelys = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			if (kayentachelys.getRandom().nextInt(kayentachelys.isBaby() ? 100 : 1000) != 0) {
				return false;
			} else {
				BlockPos blockpos = kayentachelys.blockPosition();
				BlockState state = kayentachelys.level().getBlockState(blockpos);
				if (state.is(BlockTags.DIRT)) {
					return true;
				} else {
					return kayentachelys.level().getBlockState(blockpos.below()).is(BlockTags.DIRT);
				}
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			kayentachelys.level().broadcastEntityEvent(kayentachelys, (byte) 10);
			kayentachelys.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
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
				BlockPos blockpos = kayentachelys.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (kayentachelys.level().getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = kayentachelys.level().getBlockState(blockpos1);
					kayentachelys.level().levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = kayentachelys.level().getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootData().getLootTable(DIGGING_LOOT).getRandomItems(new LootParams.Builder((ServerLevel) kayentachelys.level()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(kayentachelys.level(), blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
			if (diggingTimer % 10 == 0) {
				double d0 = (double)kayentachelys.blockPosition().getX() + kayentachelys.getRandom().nextDouble();
				double d1 = (double)kayentachelys.blockPosition().getY();
				double d2 = (double)kayentachelys.blockPosition().getZ() + kayentachelys.getRandom().nextDouble();
				kayentachelys.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, kayentachelys.level().getBlockState(kayentachelys.blockPosition().below())), d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}

	}

}
