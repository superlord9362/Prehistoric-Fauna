package superlord.prehistoricfauna.common.entity.jurassic.shaximiao;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
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

public class Chuandongocoelurus extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> TRACKING = SynchedEntityData.defineId(Chuandongocoelurus.class, EntityDataSerializers.BOOLEAN);

	private int maxHunger = 38;
	private int warningSoundTicks;

	@Nullable private ItemStack scentItem = null;
	@Nullable private UUID trackingOwnerUUID = null;

	public Chuandongocoelurus(EntityType<? extends Chuandongocoelurus> type, Level levelIn) {
		super(type, levelIn);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TRACKING, false);
	}

	public boolean isTracking() { return this.entityData.get(TRACKING); }
	private void setTracking(boolean value) { this.entityData.set(TRACKING, value); }

	@Nullable
	private Player resolveOwner() {
		if (trackingOwnerUUID == null) return null;
		if (!(this.level() instanceof ServerLevel serverLevel)) return null;
		return serverLevel.getPlayerByUUID(trackingOwnerUUID);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		if (scentItem != null && !scentItem.isEmpty()) {
			compound.put("ScentItem", scentItem.save(new CompoundTag()));
		}
		if (trackingOwnerUUID != null) {
			compound.putUUID("TrackingOwnerUUID", trackingOwnerUUID);
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("ScentItem")) {
			scentItem = ItemStack.of(compound.getCompound("ScentItem"));
		}
		if (compound.hasUUID("TrackingOwnerUUID")) {
			trackingOwnerUUID = compound.getUUID("TrackingOwnerUUID");
		}
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_ORNITHISCHIAN_MEAT.get();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.targetSelector.addGoal(4, new HuntGoal(this, LivingEntity.class, 10, false, false, (e) -> e.getType().is(PFTags.CHUANDONGOCOELURUS_HUNTING)));
		this.goalSelector.addGoal(1, new TrackingGoal());
		this.goalSelector.addGoal(1, new Chuandongocoelurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (e) -> e.getType().is(PFTags.CHUANDONGOCOELURUS_AVOIDING)));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (e) -> e.getType().is(PFTags.CHUANDONGOCOELURUS_HUNTING)));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (e) -> e.getType().is(PFTags.CHUANDONGOCOELURUS_BABY_HUNTING)));
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.CHUANDONGOCOELURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.CHUANDONGOCOELURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.chuandongocoelurus_added"), true);
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.chuandongocoelurus_already_added"), true);
			}
			return InteractionResult.SUCCESS;
		}

		if (!this.level().isClientSide()) {
			if (isTracking() && itemstack.isEmpty() && player.isShiftKeyDown() && player.getUUID().equals(trackingOwnerUUID)) {
				returnScentItem(player);
				return InteractionResult.SUCCESS;
			}

			if (!itemstack.isEmpty() && !isFood(itemstack) && !isTracking()) {
				if (!this.level().isClientSide()) {
					scentItem = itemstack.copy();
					scentItem.setCount(1);

					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					trackingOwnerUUID = player.getUUID();
					setTracking(true);

				}

				return InteractionResult.sidedSuccess(this.level().isClientSide());
			}
		}

		return super.mobInteract(player, hand);
	}

	private void returnScentItem(@Nullable Player player) {
		if (scentItem == null || scentItem.isEmpty()) { clearTracking(); return; }
		if (player != null) {
			if (!player.getInventory().add(scentItem)) this.spawnAtLocation(scentItem);
		} else {
			this.spawnAtLocation(scentItem);
		}
		clearTracking();
	}

	private void clearTracking() {
		scentItem = null;
		trackingOwnerUUID = null;
		setTracking(false);
	}

	private boolean entityCanDropItem(LivingEntity candidate, Item scentedItem) {
		if (!(this.level() instanceof ServerLevel serverLevel)) return false;
		ResourceLocation lootTableId = candidate.getLootTable();
		if (lootTableId == null) return false;
		LootTable table = serverLevel.getServer().getLootData().getLootTable(lootTableId);
		if (table == null) return false;
		try {
			LootParams params = new LootParams.Builder(serverLevel)
					.withParameter(LootContextParams.THIS_ENTITY, candidate)
					.withParameter(LootContextParams.ORIGIN, candidate.position())
					.withParameter(LootContextParams.DAMAGE_SOURCE, serverLevel.damageSources().generic())
					.create(LootContextParamSets.ENTITY);
			for (ItemStack drop : table.getRandomItems(params)) {
				if (drop.getItem() == scentedItem) return true;
			}
		} catch (Exception ignored) {}
		return false;
	}

	class TrackingGoal extends Goal {

		private enum Phase { SEARCHING, LEADING, ARRIVED }

		private static final double SCAN_RADIUS = 128.0;
		private static final int SCAN_INTERVAL = 40;
		private static final int GIVE_UP_TICKS = 200;
		private static final double ARRIVE_DIST = 6.0;
		private static final double LEAD_SPEED = 1.15;
		private static final int POINT_INTERVAL = 80;
		private static final int POINT_HOLD = 20;
		private static final double MAX_OWNER_DIST = 20.0;

		private Phase phase = Phase.SEARCHING;
		private int timer = 0;
		private int scanTimer = 0;
		private int pointTimer = 0;
		@Nullable private LivingEntity quarry = null;

		TrackingGoal() { 
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK)); 
		}

		@Override
		public boolean canUse() { 
			return isTracking() && scentItem != null && !scentItem.isEmpty(); 
		}

		@Override
		public boolean canContinueToUse() { 
			return isTracking() && scentItem != null && !scentItem.isEmpty(); 
		}

		@Override
		public void start() {
			phase = Phase.SEARCHING;
			timer = 0; 
			scanTimer = 0; 
			pointTimer = 0;
			quarry = null;
		}

		@Override
		public void stop() {
			Chuandongocoelurus.this.getNavigation().stop();
			quarry = null;
		}

		@Override
		public void tick() {
			switch (phase) {
			case SEARCHING -> tickSearching();
			case LEADING -> tickLeading();
			case ARRIVED -> tickArrived();
			}
		}

		private void tickSearching() {
			timer++;
			scanTimer++;

			if (timer % 20 == 0) {
				Player owner = resolveOwner();
				if (owner != null) Chuandongocoelurus.this.getLookControl().setLookAt(owner, 20.0F, 20.0F);
			}

			if (scanTimer >= SCAN_INTERVAL) {
				scanTimer = 0;
				LivingEntity found = scanForQuarry();
				if (found != null) {
					quarry = found;
					phase = Phase.LEADING;
					timer = 0; 
					pointTimer = 0;
					return;
				}
			}

			if (timer >= GIVE_UP_TICKS) {
				returnScentItem(resolveOwner());
			}
		}

		private void tickLeading() {
			if (quarry == null || !quarry.isAlive()) {
				quarry = null;
				phase = Phase.SEARCHING;
				timer = 0; scanTimer = 0;
				return;
			}

			timer++; pointTimer++; scanTimer++;

			if (scanTimer >= SCAN_INTERVAL * 3) {
				scanTimer = 0;
				LivingEntity closer = scanForQuarry();
				if (closer != null && closer != quarry) quarry = closer;
			}

			double dist = Chuandongocoelurus.this.distanceTo(quarry);
			if (dist <= ARRIVE_DIST) {
				phase = Phase.ARRIVED;
				timer = 0; pointTimer = 0;
				Chuandongocoelurus.this.getNavigation().stop();
				return;
			}

			if (pointTimer >= POINT_INTERVAL && pointTimer < POINT_INTERVAL + POINT_HOLD) {
				Chuandongocoelurus.this.getNavigation().stop();
				Player owner = resolveOwner();
				if (owner != null) Chuandongocoelurus.this.getLookControl().setLookAt(owner, 30.0F, 30.0F);
			} else {
				if (pointTimer >= POINT_INTERVAL + POINT_HOLD) pointTimer = 0;

				Player owner = resolveOwner();
				if (owner != null && Chuandongocoelurus.this.distanceTo(owner) > MAX_OWNER_DIST) {
					Chuandongocoelurus.this.getNavigation().stop();
					Chuandongocoelurus.this.getLookControl().setLookAt(owner, 30.0F, 30.0F);
				} else {
					Chuandongocoelurus.this.getLookControl().setLookAt(quarry, 30.0F, 30.0F);
					Chuandongocoelurus.this.getNavigation().moveTo(quarry, LEAD_SPEED);
				}
			}
		}

		private void tickArrived() {
			if (quarry == null || !quarry.isAlive()) {
				quarry = null;
				phase = Phase.SEARCHING;
				timer = 0; scanTimer = 0;
				return;
			}

			timer++;

			if (timer % 40 < 20) {
				Chuandongocoelurus.this.getLookControl().setLookAt(quarry, 30.0F, 30.0F);
			} else {
				Player owner = resolveOwner();
				if (owner != null) Chuandongocoelurus.this.getLookControl().setLookAt(owner, 30.0F, 30.0F);
			}

			if (timer % 60 == 0) Chuandongocoelurus.this.playWarningSound();
		}

		@Nullable
		private LivingEntity scanForQuarry() {
			if (scentItem == null || scentItem.isEmpty()) return null;
			Item scentedItem = scentItem.getItem();
			AABB box = Chuandongocoelurus.this.getBoundingBox().inflate(SCAN_RADIUS);
			List<LivingEntity> candidates = Chuandongocoelurus.this.level().getEntitiesOfClass(LivingEntity.class, box, (e) -> e != Chuandongocoelurus.this && e.isAlive() && !(e instanceof Player));

			LivingEntity best = null;
			double bestDist = Double.MAX_VALUE;
			for (LivingEntity candidate : candidates) {
				if (entityCanDropItem(candidate, scentedItem)) {
					double d = Chuandongocoelurus.this.distanceToSqr(candidate);
					if (d < bestDist) { bestDist = d; best = candidate; }
				}
			}
			return best;
		}
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) { 
			this.setProtective(true); 
		} else { 
			this.setTerritorial(true); 
		}
		this.setCarnivorous(true);
		this.setCrepuscular(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) { this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(7); }
		else if (this.getAge() >= 0) { this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15); }
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	@Override protected SoundEvent getAmbientSound() { 
		return this.isAsleep() ? null : PFSounds.CHUANDONGOCOELURUS_IDLE.get(); 
	}

	@Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) { 
		return PFSounds.CHUANDONGOCOELURUS_HURT.get(); 
	}

	@Override protected SoundEvent getDeathSound() { 
		return PFSounds.CHUANDONGOCOELURUS_DEATH.get(); 
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CHUANDONGOCOELURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) --this.warningSoundTicks;
	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) this.doEnchantDamageEffects(this, entity);
		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() { super(Chuandongocoelurus.this, 1.25D, true); }

		@Override
		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) this.resetAttackCooldown();
				if (this.getTicksUntilNextAttack() <= 10) Chuandongocoelurus.this.playWarningSound();
			} else {
				this.resetAttackCooldown();
			}
		}

		@Override public boolean canContinueToUse() { 
			return super.canContinueToUse(); 
		}

		@Override public void stop() { 
			super.stop(); 
		}

		@Override protected double getAttackReachSqr(LivingEntity attackTarget) { 
			return (double)(4.0F + attackTarget.getBbWidth()); 
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Chuandongocoelurus entity = new Chuandongocoelurus(PFEntities.CHUANDONGOCOELURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override public ItemStack getPickedResult(HitResult target) { 
		return new ItemStack(PFItems.CHUANDONGOCOELURUS_SPAWN_EGG.get()); 
	}

	@Override public Item getEggItem() { 
		return PFItems.CHUANDONGOCOELURUS_EGG.get(); 
	}

	@Override public BlockState getEggBlock(Level world, BlockPos pos) { 
		return PFBlocks.CHUANDONGOCOELURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)); 
	}
}