package superlord.prehistoricfauna.common.entity.jurassic.shaximiao;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
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
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Yandusaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> DIGGING_ROOTS = SynchedEntityData.defineId(Yandusaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 38;

	public Yandusaurus(EntityType<? extends Yandusaurus> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}
	
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.PTEROPHYLLUM.get().asItem();
	}

	public boolean isDiggingForRoots() {
		return this.entityData.get(DIGGING_ROOTS);
	}

	private void setDiggingForRoots(boolean isDiggingForRoots) {
		this.entityData.set(DIGGING_ROOTS, isDiggingForRoots);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.YANDUSAURUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(5, new DiggingGoal(this));
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.YANDUSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.YANDUSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.YANDUSAURUS_DEATH.get();
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
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
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 75) {
			this.setSkittish(true);
		} else {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (item == PFBlocks.TAENIOPTERIS.get().asItem()) {
			if (!p_230254_1_.isCreative()) {
				itemstack.shrink(1);
			}
			this.setDiggingForRoots(true);
			return InteractionResult.SUCCESS;
		}
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
            final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
            if (!already.contains(EnumPaleoPages.YANDUSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.YANDUSAURUS.ordinal()), itemstack);
				p_230254_1_.displayClientMessage(Component.translatable("paleopedia.yandusaurus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				p_230254_1_.displayClientMessage(Component.translatable("paleopedia.yandusaurus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(7);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		}
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.23D);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Yandusaurus entity = new Yandusaurus(PFEntities.YANDUSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.YANDUSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.YANDUSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.YANDUSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}
	
	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/yandusaurus_digging");

		private final Yandusaurus yandusaurus;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Yandusaurus entity) {
			this.yandusaurus = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			BlockPos blockpos = yandusaurus.blockPosition();
			BlockState state = yandusaurus.level().getBlockState(blockpos);
			if (state.is(BlockTags.DIRT) && yandusaurus.isDiggingForRoots()) {
				return true;
			} else {
				return yandusaurus.level().getBlockState(blockpos.below()).is(BlockTags.DIRT)&& yandusaurus.isDiggingForRoots();
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			yandusaurus.level().broadcastEntityEvent(yandusaurus, (byte) 10);
			yandusaurus.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
			yandusaurus.setDiggingForRoots(false);
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
				BlockPos blockpos = yandusaurus.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (yandusaurus.level().getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = yandusaurus.level().getBlockState(blockpos1);
					yandusaurus.level().levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = yandusaurus.level().getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootData().getLootTable(DIGGING_LOOT).getRandomItems(new LootParams.Builder((ServerLevel) yandusaurus.level()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(yandusaurus.level(), blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}
	}

}
