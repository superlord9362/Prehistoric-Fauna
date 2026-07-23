package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import superlord.prehistoricfauna.client.gui.SarahsaurusMenu;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
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

public class Sarahsaurus extends DinosaurEntity implements ContainerListener, HasCustomInventoryScreen {
	private static final EntityDataAccessor<Boolean> DATA_ID_CHEST = SynchedEntityData.defineId(Sarahsaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_SWAG_ID = SynchedEntityData.defineId(Sarahsaurus.class, EntityDataSerializers.INT);
	public static final int EQUIPMENT_SLOT_OFFSET = 400;
	public static final int CHEST_SLOT_OFFSET = 499;
	public static final int INVENTORY_SLOT_OFFSET = 500;
	public static final int INV_CHEST_COUNT = 15;
	public static final int INV_SLOT_CARPET = 0;
	private int maxHunger = 38;
	public SimpleContainer inventory;
	private int warningSoundTicks;
	@Nullable
	private Sarahsaurus caravanHead;
	@Nullable
	private Sarahsaurus caravanTail;

	public Sarahsaurus(EntityType<? extends Sarahsaurus> type, Level worldIn) {
		super(type, worldIn);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
		this.createInventory();
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_CHEST, false);
		this.entityData.define(DATA_SWAG_ID, -1);
	}

	public boolean hasChest() {
		return this.entityData.get(DATA_ID_CHEST);
	}

	public void setChest(boolean p_30505_) {
		this.entityData.set(DATA_ID_CHEST, p_30505_);
	}

	protected int getInventorySize() {
		return this.hasChest() ? 2 + 3 * this.getInventoryColumns() : 1;
	}

	public boolean isWearingCarpet() {
		return !this.inventory.getItem(0).isEmpty();
	}

	public boolean isCarpet(ItemStack p_30834_) {
		return p_30834_.is(ItemTags.WOOL_CARPETS);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.725F;
		else return 1.45F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.OTOZAMITES.get().asItem();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new BabyPanicGoal(this));
		this.goalSelector.addGoal(1, new Sarahsaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SARAHSAURUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new SarahsaurusFollowCaravanGoal(this, (double)2.1F));
	}

	@SuppressWarnings("deprecation")
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.SARAHSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.SARAHSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.sarahsaurus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.sarahsaurus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.level().isClientSide()) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.getOwner() == player) {
				if (this.isTame()) {
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
					} 
					if (item.equals(Items.AIR)) this.openCustomInventoryScreen(player);
					if (!this.hasChest() && itemstack.is(Items.CHEST)) {
						this.equipChest(player, itemstack);
						return InteractionResult.sidedSuccess(this.level().isClientSide());
					}
					if (this.isCarpet(itemstack) && !this.isWearingCarpet()) {
						this.equipCarpet(player, itemstack);
						return InteractionResult.sidedSuccess(this.level().isClientSide());
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

	public void equipCarpet(Player p_251330_, ItemStack p_248855_) {
		if (this.isCarpet(p_248855_)) {
			this.inventory.setItem(0, p_248855_.copyWithCount(1));
			if (!p_251330_.getAbilities().instabuild) {
				p_248855_.shrink(1);
			}
			if (p_248855_.getItem() instanceof BlockItem blockItem) {
				if (blockItem.getBlock() instanceof WoolCarpetBlock carpet) {
					this.setSwag(carpet.getColor());
				}
			}
		}

	}

	private void equipChest(Player p_250937_, ItemStack p_251558_) {
		this.setChest(true);
		this.playChestEquipsSound();
		if (!p_250937_.getAbilities().instabuild) {
			p_251558_.shrink(1);
		}

		this.createInventory();
	}

	protected void playChestEquipsSound() {
		this.playSound(SoundEvents.DONKEY_CHEST, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
	}

	public int getInventoryColumns() {
		return 5;
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(true);
		this.setCathemeral(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.SARAHSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SARAHSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SARAHSAURUS_DEATH.get();
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.SARAHSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}	

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.FOLLOW_RANGE, 15).add(Attributes.ATTACK_DAMAGE, 4);
	}

	@SuppressWarnings("static-access")
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		if (this.isWearingCarpet()) {
			if (this.getSwag() != this.getDyeColor(this.inventory.getItem(0))) {
				if (this.inventory.getItem(0).getItem() instanceof BlockItem blockItem) {
					if (blockItem.getBlock() instanceof WoolCarpetBlock carpet) {
						this.setSwag(carpet.getColor());
					}
				}
			}
		}
	}

	protected void createInventory() {
		SimpleContainer simplecontainer = this.inventory;
		this.inventory = new SimpleContainer(this.getInventorySize());
		if (simplecontainer != null) {
			simplecontainer.removeListener(this);
			int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

			for(int j = 0; j < i; ++j) {
				ItemStack itemstack = simplecontainer.getItem(j);
				if (!itemstack.isEmpty()) {
					this.inventory.setItem(j, itemstack.copy());
				}
			}
		}

		this.inventory.addListener(this);
		this.updateContainerEquipment();
		this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
	}

	protected void updateContainerEquipment() {
		this.setSwag(getDyeColor(this.inventory.getItem(0)));
	}

	public void containerChanged(Container p_30548_) {
	    DyeColor dyecolor = this.getSwag();
	    this.updateContainerEquipment();
	    DyeColor dyecolor1 = this.getSwag();
	    if (this.tickCount > 20 && dyecolor1 != null && dyecolor1 != dyecolor) {
	        this.playSound(SoundEvents.LLAMA_SWAG, 0.5F, 1.0F);
	    }
	}

	private void setSwag(@Nullable DyeColor p_30772_) {
		this.entityData.set(DATA_SWAG_ID, p_30772_ == null ? -1 : p_30772_.getId());
	}

	@Nullable
	private static DyeColor getDyeColor(ItemStack p_30836_) {
		Block block = Block.byItem(p_30836_.getItem());
		return block instanceof WoolCarpetBlock ? ((WoolCarpetBlock)block).getColor() : null;
	}

	@Nullable
	public DyeColor getSwag() {
		int i = this.entityData.get(DATA_SWAG_ID);
		return i == -1 ? null : DyeColor.byId(i);
	}

	public void openCustomInventoryScreen(Player player) {
		if (!this.level().isClientSide() && player instanceof ServerPlayer serverPlayer) {
			NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider((id, playerInventory, p) -> new SarahsaurusMenu(id, playerInventory, this.inventory, this), this.hasCustomName() ? this.getCustomName() : Component.translatable("entity.prehistoricfauna.sarahsaurus")), buf -> buf.writeInt(this.getId()));
		}
	}

	public void leaveCaravan() {
		if (this.caravanHead != null) {
			this.caravanHead.caravanTail = null;
		}

		this.caravanHead = null;
	}

	public void joinCaravan(Sarahsaurus p_30767_) {
		this.caravanHead = p_30767_;
		this.caravanHead.caravanTail = this;
	}

	public boolean hasCaravanTail() {
		return this.caravanTail != null;
	}

	public boolean inCaravan() {
		return this.caravanHead != null;
	}

	@Nullable
	public Sarahsaurus getCaravanHead() {
		return this.caravanHead;
	}

	protected double followLeashSpeed() {
		return 2.0D;
	}

	protected void dropEquipment() {
		super.dropEquipment();
		if (this.inventory != null) {
			for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
				ItemStack itemstack = this.inventory.getItem(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.spawnAtLocation(itemstack);
				}
			}

		}
		if (this.hasChest()) {
			if (!this.level().isClientSide()) {
				this.spawnAtLocation(Blocks.CHEST);
			}

			this.setChest(false);
		}
	}

	public void addAdditionalSaveData(CompoundTag p_30496_) {
		super.addAdditionalSaveData(p_30496_);
		p_30496_.putBoolean("ChestedHorse", this.hasChest());
		if (this.hasChest()) {
			ListTag listtag = new ListTag();

			for(int i = 2; i < this.inventory.getContainerSize(); ++i) {
				ItemStack itemstack = this.inventory.getItem(i);
				if (!itemstack.isEmpty()) {
					CompoundTag compoundtag = new CompoundTag();
					compoundtag.putByte("Slot", (byte)i);
					itemstack.save(compoundtag);
					listtag.add(compoundtag);
				}
			}

			p_30496_.put("Items", listtag);
		}
		if (!this.inventory.getItem(0).isEmpty()) {
			p_30496_.put("DecorItem", this.inventory.getItem(0).save(new CompoundTag()));
		}

	}

	public void readAdditionalSaveData(CompoundTag p_30488_) {
		super.readAdditionalSaveData(p_30488_);
		this.setChest(p_30488_.getBoolean("ChestedHorse"));
		this.createInventory();
		if (this.hasChest()) {
			ListTag listtag = p_30488_.getList("Items", 10);

			for(int i = 0; i < listtag.size(); ++i) {
				CompoundTag compoundtag = listtag.getCompound(i);
				int j = compoundtag.getByte("Slot") & 255;
				if (j >= 2 && j < this.inventory.getContainerSize()) {
					this.inventory.setItem(j, ItemStack.of(compoundtag));
				}
			}
		}
		if (p_30488_.contains("DecorItem", 10)) {
			this.inventory.setItem(0, ItemStack.of(p_30488_.getCompound("DecorItem")));
		}
		this.updateContainerEquipment();
	}

	public SlotAccess getSlot(int p_149479_) {
		return p_149479_ == 499 ? new SlotAccess() {
			public ItemStack get() {
				return Sarahsaurus.this.hasChest() ? new ItemStack(Items.CHEST) : ItemStack.EMPTY;
			}

			public boolean set(ItemStack p_149485_) {
				if (p_149485_.isEmpty()) {
					if (Sarahsaurus.this.hasChest()) {
						Sarahsaurus.this.setChest(false);
						Sarahsaurus.this.createInventory();
					}

					return true;
				} else if (p_149485_.is(Items.CHEST)) {
					if (!Sarahsaurus.this.hasChest()) {
						Sarahsaurus.this.setChest(true);
						Sarahsaurus.this.createInventory();
					}

					return true;
				} else {
					return false;
				}
			}
		} : super.getSlot(p_149479_);
	}

	private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.core.Direction facing) {
		if (this.isAlive() && capability == net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER && itemHandler != null)
			return itemHandler.cast();
		return super.getCapability(capability, facing);
	}

	public boolean hasInventoryChanged(Container p_149512_) {
		return this.inventory != p_149512_;
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Sarahsaurus entity = new Sarahsaurus(PFEntities.SARAHSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Sarahsaurus.this, 1.25D, true);
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
					Sarahsaurus.this.playWarningSound();
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

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Sarahsaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		@SuppressWarnings("resource")
		public boolean canUse() {
			if (Sarahsaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Sarahsaurus sarahsaurus : Sarahsaurus.this.level().getEntitiesOfClass(Sarahsaurus.class, Sarahsaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (sarahsaurus.isBaby()) {
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

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SARAHSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.SARAHSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.SARAHSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	public class SarahsaurusFollowCaravanGoal extends Goal {
		public final Sarahsaurus sarahsaurus;
		private double speedModifier;
		@SuppressWarnings("unused")
		private static final int CARAVAN_LIMIT = 8;
		private int distCheckCounter;

		public SarahsaurusFollowCaravanGoal(Sarahsaurus p_25501_, double p_25502_) {
			this.sarahsaurus = p_25501_;
			this.speedModifier = p_25502_;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (!this.sarahsaurus.isLeashed() && !this.sarahsaurus.inCaravan() && this.sarahsaurus.isTame()) {
				List<Entity> list = this.sarahsaurus.level().getEntities(this.sarahsaurus, this.sarahsaurus.getBoundingBox().inflate(9.0D, 4.0D, 9.0D), (p_25505_) -> {
					EntityType<?> entitytype = p_25505_.getType();
					return entitytype == PFEntities.SARAHSAURUS.get();
				});
				Sarahsaurus sarahsaurus = null;
				double d0 = Double.MAX_VALUE;

				for(Entity entity : list) {
					Sarahsaurus sarahsaurus1 = (Sarahsaurus)entity;
					if (sarahsaurus1.inCaravan() && !sarahsaurus1.hasCaravanTail()) {
						double d1 = this.sarahsaurus.distanceToSqr(sarahsaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							sarahsaurus = sarahsaurus1;
						}
					}
				}

				if (sarahsaurus == null) {
					for(Entity entity1 : list) {
						Sarahsaurus sarahsaurus2 = (Sarahsaurus)entity1;
						if (sarahsaurus2.isLeashed() && !sarahsaurus2.hasCaravanTail()) {
							double d2 = this.sarahsaurus.distanceToSqr(sarahsaurus2);
							if (!(d2 > d0)) {
								d0 = d2;
								sarahsaurus = sarahsaurus2;
							}
						}
					}
				}

				if (sarahsaurus == null) {
					return false;
				} else if (d0 < 4.0D) {
					return false;
				} else if (!sarahsaurus.isLeashed() && !this.firstIsLeashed(sarahsaurus, 1)) {
					return false;
				} else {
					this.sarahsaurus.joinCaravan(sarahsaurus);
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (this.sarahsaurus.inCaravan() && this.sarahsaurus.getCaravanHead().isAlive() && this.firstIsLeashed(this.sarahsaurus, 0)) {
				double d0 = this.sarahsaurus.distanceToSqr(this.sarahsaurus.getCaravanHead());
				if (d0 > 676.0D) {
					if (this.speedModifier <= 3.0D) {
						this.speedModifier *= 1.2D;
						this.distCheckCounter = reducedTickDelay(40);
						return true;
					}

					if (this.distCheckCounter == 0) {
						return false;
					}
				}

				if (this.distCheckCounter > 0) {
					--this.distCheckCounter;
				}

				return true;
			} else {
				return false;
			}
		}

		public void stop() {
			this.sarahsaurus.leaveCaravan();
			this.speedModifier = 2.1D;
		}

		public void tick() {
			if (this.sarahsaurus.inCaravan()) {
				if (!(this.sarahsaurus.getLeashHolder() instanceof LeashFenceKnotEntity)) {
					Sarahsaurus sarahsaurus = this.sarahsaurus.getCaravanHead();
					double d0 = (double)this.sarahsaurus.distanceTo(sarahsaurus);
					Vec3 vec3 = (new Vec3(sarahsaurus.getX() - this.sarahsaurus.getX(), sarahsaurus.getY() - this.sarahsaurus.getY(), sarahsaurus.getZ() - this.sarahsaurus.getZ())).normalize().scale(Math.max(d0 - 2.0D, 0.0D));
					this.sarahsaurus.getNavigation().moveTo(this.sarahsaurus.getX() + vec3.x, this.sarahsaurus.getY() + vec3.y, this.sarahsaurus.getZ() + vec3.z, this.speedModifier);
				}
			}
		}

		private boolean firstIsLeashed(Sarahsaurus p_25507_, int p_25508_) {
			if (p_25508_ > 8) {
				return false;
			} else if (p_25507_.inCaravan()) {
				if (p_25507_.getCaravanHead().isLeashed()) {
					return true;
				} else {
					Sarahsaurus sarahsaurus = p_25507_.getCaravanHead();
					++p_25508_;
					return this.firstIsLeashed(sarahsaurus, p_25508_);
				}
			} else {
				return false;
			}
		}
	}

}
