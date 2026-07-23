package superlord.prehistoricfauna.common.entity.jurassic.shaximiao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import com.google.common.primitives.Ints;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import superlord.prehistoricfauna.client.gui.ShunosaurusMenu;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.AgedHerdDinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AgedFollowHerdLeaderGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;
public class Shunosaurus extends AgedHerdDinosaurEntity implements ContainerListener, HasCustomInventoryScreen {
	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Shunosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_ID_CHEST_COUNT = SynchedEntityData.defineId(Shunosaurus.class, EntityDataSerializers.INT);
	public static final int EQUIPMENT_SLOT_OFFSET = 400;
	public static final int CHEST_SLOT_OFFSET = 499;
	public static final int CHEST_SLOT_OFFSET_2 = 498;
	public static final int INVENTORY_SLOT_OFFSET = 500;
	public static final int INV_CHEST_COUNT = 15;
	public static final int INV_SLOT_SADDLE = 0;
	public static final int MAX_RIDERS = 4;
	public SimpleContainer inventory;
	private int maxHunger = 150;
	private int warningSoundTicks;
	private int crushTicks = 0;
	public float ridingXZ;
	public float ridingY = 1F;
	
	public Shunosaurus(EntityType<? extends AgedHerdDinosaurEntity> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
		this.createInventory();
	}
	
	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.CUPRESSINOCLADUS_LEAVES.get();
	}
	
	@Override
	public void playAmbientSound() {
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null) {
			if (!this.isAsleep() && !this.isBaby())
				this.playSound(soundevent, this.getSoundVolume() * 2, this.getVoicePitch());
			else
				this.playSound(soundevent, this.getSoundVolume(), this.getVoicePitch());
		}
	}
	
	@Override
	public double moveToRange() {
		return 10;
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Shunosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new AgedFollowHerdLeaderGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new Shunosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Shunosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> { return p_213487_0_.getType().is(PFTags.SHUNOSAURUS_AVOIDING); }));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double) 1.2F, 12, 2));
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.SHUNOSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.SHUNOSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.shunosaurus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.shunosaurus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		if (!this.isTame()) {
			if (item == PFBlocks.CUPRESSINOCLADUS_LEAVES.get().asItem()) {
				if (!player.getAbilities().instabuild)
					itemstack.shrink(1);
				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
					this.tame(player);
					this.navigation.stop();
					this.setTarget((LivingEntity) null);
					this.setOrderedToSit(true);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				return InteractionResult.SUCCESS;
			}
			return InteractionResult.PASS;
		} else {
			if (!this.isBaby()) {
				if (player.isShiftKeyDown()) {
					this.openCustomInventoryScreen(player);
					return InteractionResult.SUCCESS;
				} else {
					if (!this.isSaddled() && item == Items.SADDLE) {
						if (!player.getAbilities().instabuild)
							itemstack.shrink(1);
						this.setSaddled(true);
						this.inventory.setItem(0, new ItemStack(Items.SADDLE));
						this.level().playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.PIG_SADDLE, SoundSource.NEUTRAL, 0.5F, 1.0F);
						return InteractionResult.SUCCESS;
					}
					if (this.getChestCount() < 2 && item == Items.CHEST) {
						this.equipChest(player, itemstack);
						return InteractionResult.SUCCESS;
					}
					if (this.isSaddled() && this.getPassengers().size() < this.getMaxRiders()) {
						player.startRiding(this);
						return InteractionResult.SUCCESS;
					}
				}
			}
		}
		return super.mobInteract(player, hand);
	}
	
	private void equipChest(Player p_250937_, ItemStack p_251558_) {
		this.setChestCount(this.getChestCount() + 1);
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
	
	public int getMaxRiders() {
		return MAX_RIDERS - this.getChestCount();
	}
	
	protected void createInventory() {
		SimpleContainer simplecontainer = this.inventory;
		this.inventory = new SimpleContainer(this.getInventorySize());
		if (simplecontainer != null) {
			simplecontainer.removeListener(this);
			int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());
			for (int j = 0; j < i; ++j) {
				ItemStack itemstack = simplecontainer.getItem(j);
				if (!itemstack.isEmpty()) {
					this.inventory.setItem(j, itemstack.copy());
				}
			}
		}
		this.inventory.addListener(this);
		this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
	}
	
	public void openCustomInventoryScreen(Player player) {
		if (!this.level().isClientSide() && player instanceof ServerPlayer serverPlayer) {
			NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider((id, playerInventory, p) -> new ShunosaurusMenu(id, playerInventory, this.inventory, this), this.hasCustomName() ? this.getCustomName() : Component.translatable("entity.prehistoricfauna.shunosaurus")), buf -> {
				buf.writeInt(this.getId());
				buf.writeInt(this.getChestCount());
			});
		}
	}
	
	protected void dropEquipment() {
		super.dropEquipment();
		if (this.inventory != null) {
			for (int i = 0; i < this.inventory.getContainerSize(); ++i) {
				ItemStack itemstack = this.inventory.getItem(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.spawnAtLocation(itemstack);
				}
			}
		}
		if (this.hasChest()) {
			for (int i = 0; i < this.getChestCount(); i++) {
				if (!this.level().isClientSide()) {
					this.spawnAtLocation(Blocks.CHEST);
				}
			}
			this.setChestCount(0);
		}
	}
	
	public void setChestCountClient(int count) {
		this.entityData.set(DATA_ID_CHEST_COUNT, count);
		this.createInventory();
	}
	
	@Nullable
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		if (entity instanceof Mob mob)
			return mob;
		if (this.isSaddled() && entity instanceof Player player)
			return player;
		return null;
	}
	
	public boolean canBeControlledByRider() {
		return this.isSaddled() && this.getControllingPassenger() instanceof LivingEntity;
	}
	
	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			if (this.isVehicle() && this.isSaddled() && this.canBeControlledByRider()) {
				LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
				this.setYRot(livingentity.getYRot());
				this.yRotO = this.getYRot();
				this.setXRot(livingentity.getXRot() * 0.5F);
				this.setRot(this.getYRot(), this.getXRot());
				this.yBodyRot = this.getYRot();
				this.yHeadRot = this.yBodyRot;
				float f = livingentity.xxa * 0.5F;
				float f1 = livingentity.zza;
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
				super.travel(new Vec3((double) f, travelVector.y, (double) f1));
				this.calculateEntityAnimation(false);
			} else {
				super.travel(travelVector);
			}
		}
	}
	
	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
		super.onSyncedDataUpdated(data);
		if (DATA_ID_CHEST_COUNT.equals(data)) {
			this.createInventory();
		}
	}
	
	@Override
	public boolean canAddPassenger(Entity passenger) {
		return this.getPassengers().size() < this.getMaxRiders();
	}
	
	private static final double SEAT_HEIGHT = 2.55D;
	private static final double SEAT_FORWARD_FRONT = 0.4D;
	private static final double SEAT_FORWARD_BACK = -0.4D;
	private static final double SEAT_SIDE_OFFSET = 0.4D;
	
	@Override
	public void positionRider(Entity passenger, Entity.MoveFunction p_289531_) {
		super.positionRider(passenger, p_289531_);
		if (!(passenger instanceof Player ridingPlayer))
			return;
		int seatIndex = this.getPassengers().indexOf(passenger);
		if (seatIndex < 0)
			seatIndex = 0;
		float angle = (0.01745329251F * this.yBodyRotO);
		boolean rightSide = (seatIndex % 2) == 1;
		boolean backRow = (seatIndex / 2) == 1;
		double seatForward = backRow ? SEAT_FORWARD_BACK : SEAT_FORWARD_FRONT;
		double seatSide = rightSide ? -SEAT_SIDE_OFFSET : SEAT_SIDE_OFFSET;
		double extraX = -seatForward * Mth.sin(angle) + seatSide * Mth.cos(angle);
		double extraZ = seatForward * Mth.cos(angle) + seatSide * Mth.sin(angle);
		double extraY = this.isInWater() ? SEAT_HEIGHT - 0.6D : SEAT_HEIGHT;
		ridingPlayer.setPos(this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ);
	}
	
	protected void func_230273_eI_() {
		
	}
	
	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}
	
	@Nullable
	private Vec3 func_234236_a_(Vec3 p_234236_1_, LivingEntity p_234236_2_) {
		double d0 = this.getX() + p_234236_1_.x;
		double d1 = this.getBoundingBox().minY;
		double d2 = this.getZ() + p_234236_1_.z;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
		for (Pose pose : p_234236_2_.getDismountPoses()) {
			blockpos$mutable.set(d0, d1, d2);
			double d3 = this.getBoundingBox().maxY + 0.75D;
			while (true) {
				double d4 = this.level().getBlockFloorHeight(blockpos$mutable);
				if ((double) blockpos$mutable.getY() + d4 > d3) {
					break;
				}
				if (DismountHelper.isBlockFloorValid(d4)) {
					AABB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vec3 vector3d = new Vec3(d0, (double) blockpos$mutable.getY() + d4, d2);
					if (DismountHelper.canDismountTo(this.level(), p_234236_2_, axisalignedbb.move(vector3d))) {
						p_234236_2_.setPose(pose);
						return vector3d;
					}
				}
				blockpos$mutable.move(Direction.UP);
				if (!((double) blockpos$mutable.getY() < d3)) {
					break;
				}
			}
		}
		return null;
	}
	
	public Vec3 getDismountLocationForPassenger(LivingEntity living) {
		Vec3 vector3d = getCollisionHorizontalEscapeVector((double) this.getBbWidth(), (double) living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F));
		Vec3 vector3d1 = this.func_234236_a_(vector3d, living);
		if (vector3d1 != null) {
			return vector3d1;
		} else {
			Vec3 vector3d2 = getCollisionHorizontalEscapeVector((double) this.getBbWidth(), (double) living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F));
			Vec3 vector3d3 = this.func_234236_a_(vector3d2, living);
			return vector3d3 != null ? vector3d3 : this.position();
		}
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.SHUNOSAURUS_SNORES.get() : PFSounds.SHUNOSAURUS_IDLE.get();
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SHUNOSAURUS_HURT.get();
	}
	
	protected SoundEvent getDeathSound() {
		return PFSounds.SHUNOSAURUS_DEATH.get();
	}
	
	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.SHUNOSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_CHEST_COUNT, 0);
		this.entityData.define(SADDLED, false);
	}
	
	public boolean hasChest() {
		return this.getChestCount() > 0;
	}
	
	public int getChestCount() {
		return this.entityData.get(DATA_ID_CHEST_COUNT);
	}
	
	public void setChestCount(int count) {
		this.entityData.set(DATA_ID_CHEST_COUNT, count);
	}
	
	protected int getInventorySize() {
	    return 1 + (this.hasChest() ? 3 * this.getInventoryColumns() * this.getChestCount() : 0);
	}
	
	public boolean isSaddled() {
		return this.entityData.get(SADDLED);
	}
	
	private void setSaddled(boolean isSaddled) {
		this.entityData.set(SADDLED, isSaddled);
	}
	
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putInt("ChestCount", this.getChestCount());
		if (this.hasChest()) {
			ListTag listtag = new ListTag();
			for (int i = 1; i < this.inventory.getContainerSize(); ++i) {
				ItemStack itemstack = this.inventory.getItem(i);
				if (!itemstack.isEmpty()) {
					CompoundTag compoundtag = new CompoundTag();
					compoundtag.putByte("Slot", (byte) i);
					itemstack.save(compoundtag);
					listtag.add(compoundtag);
				}
			}
			compound.put("Items", listtag);
		}
		compound.putBoolean("IsSaddled", this.isSaddled());
	}
	
	public void readAdditionalSaveData(CompoundTag compound) {
	    super.readAdditionalSaveData(compound);

	    this.setChestCount(compound.contains("ChestCount") ? compound.getInt("ChestCount") : (compound.getBoolean("ChestedHorse") ? 1 : 0));
	    this.createInventory();

	    if (this.hasChest()) {
	        ListTag listtag = compound.getList("Items", 10);
	        for (int i = 0; i < listtag.size(); ++i) {
	            CompoundTag compoundtag = listtag.getCompound(i);
	            int j = compoundtag.getByte("Slot") & 255;
	            if (j >= 1 && j < this.inventory.getContainerSize()) {
	                this.inventory.setItem(j, ItemStack.of(compoundtag));
	            }
	        }
	    }

	    this.setSaddled(compound.getBoolean("IsSaddled"));
	    if (this.isSaddled()) {
	        this.inventory.setItem(INV_SLOT_SADDLE, new ItemStack(Items.SADDLE));
	    }
	}
	
	public SlotAccess getSlot(int p_149479_) {
		if (p_149479_ == CHEST_SLOT_OFFSET) {
			return new SlotAccess() {
				public ItemStack get() {
					return Shunosaurus.this.getChestCount() >= 1 ? new ItemStack(Items.CHEST) : ItemStack.EMPTY;
				}
				public boolean set(ItemStack p_149485_) {
					if (p_149485_.isEmpty()) {
						if (Shunosaurus.this.getChestCount() >= 1) {
							Shunosaurus.this.setChestCount(Shunosaurus.this.getChestCount() - 1);
							Shunosaurus.this.createInventory();
						}
						return true;
					} else if (p_149485_.is(Items.CHEST)) {
						if (Shunosaurus.this.getChestCount() < 2) {
							Shunosaurus.this.setChestCount(Shunosaurus.this.getChestCount() + 1);
							Shunosaurus.this.createInventory();
						}
						return true;
					} else {
						return false;
					}
				}
			};
		}
		if (p_149479_ == CHEST_SLOT_OFFSET_2) {
			return new SlotAccess() {
				public ItemStack get() {
					return Shunosaurus.this.getChestCount() >= 2 ? new ItemStack(Items.CHEST) : ItemStack.EMPTY;
				}
				public boolean set(ItemStack p_149485_) {
					if (p_149485_.isEmpty()) {
						if (Shunosaurus.this.getChestCount() >= 2) {
							Shunosaurus.this.setChestCount(Shunosaurus.this.getChestCount() - 1);
							Shunosaurus.this.createInventory();
						}
						return true;
					} else if (p_149485_.is(Items.CHEST)) {
						if (Shunosaurus.this.getChestCount() == 1) {
							Shunosaurus.this.setChestCount(2);
							Shunosaurus.this.createInventory();
						}
						return true;
					} else {
						return false;
					}
				}
			};
		}
		return super.getSlot(p_149479_);
	}
	
	@Override
	public void containerChanged(Container container) {
		boolean hasSaddleInSlot = this.inventory.getItem(0).is(Items.SADDLE);
		if (hasSaddleInSlot != this.isSaddled()) {
			this.setSaddled(hasSaddleInSlot);
			if (hasSaddleInSlot) {
				this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.PIG_SADDLE, SoundSource.NEUTRAL, 0.5F, 1.0F);
			}
		}
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
	
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0D);
		} else if (this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60.0D);
		}
	}
	
	@Override
	public void aiStep() {
	    super.aiStep();

	    if (!this.isBaby() && this.getDeltaMovement().lengthSqr() > 0.0D) {
	        if (crushTicks < 1200) {
	            crushTicks++;
	        } else {
	            crushTicks = 0;
	        }

	        if (crushTicks == 1200) {
	            for (ItemEntity entity : this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(1, 0, 1))) {
	                if (entity.getItem().is(PFItems.HENOSTONE.get())) {
	                    if (this.random.nextInt(100) < 5) {
	                        this.level().addFreshEntity(new ItemEntity(
	                            this.level(),
	                            entity.getX(), entity.getY(), entity.getZ(),
	                            new ItemStack(PFItems.TIME_GEM_SHARD.get())
	                        ));
	                    }
	                    entity.discard();
	                }
	            }
	        }
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
			super(Shunosaurus.this, 1.25D, true);
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
					Shunosaurus.this.playWarningSound();
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
			return (double) (15.0F + attackTarget.getBbWidth());
		}
	}
	
	static class MateGoal extends BreedGoal {
		private final Shunosaurus shunosaurus;
		private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
		private int breedDelay;
		private final double moveSpeed;
		
		MateGoal(Shunosaurus shunosaurus, double speed) {
			super(shunosaurus, speed);
			this.shunosaurus = shunosaurus;
			this.moveSpeed = speed;
		}
		
		@Nullable
		private Animal getNearbyMate() {
			List<Shunosaurus> list = this.level.getNearbyEntities(Shunosaurus.class, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(24.0D));
			double d0 = Double.MAX_VALUE;
			Animal animalentity = null;
			for (Animal animalentity1 : list) {
				if (this.animal.canMate(animalentity1) && this.animal.distanceToSqr(animalentity1) < d0) {
					animalentity = animalentity1;
					d0 = this.animal.distanceToSqr(animalentity1);
				}
			}
			return animalentity;
		}
		
		public boolean canUse() {
			return super.canUse() && !this.shunosaurus.hasBaby() && !this.shunosaurus.isInLoveNaturally();
		}
		
		public void stop() {
			this.partner = null;
			this.breedDelay = 0;
		}
		
		public void tick() {
			super.tick();
			this.animal.getLookControl().setLookAt(this.partner, 10.0F, (float) this.animal.getMaxHeadXRot());
			this.animal.getNavigation().moveTo(this.partner, this.moveSpeed);
			++this.breedDelay;
			if (this.breedDelay >= 60 && this.animal.distanceToSqr(this.partner) < 20.0D) {
				this.breed();
			}
		}
		
		protected void breed() {
			ServerPlayer serverPlayer = this.animal.getLoveCause();
			if (serverPlayer == null && this.partner.getLoveCause() != null) {
				serverPlayer = this.partner.getLoveCause();
			}
			if (serverPlayer != null) {
				serverPlayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayer, this.animal, this.partner, (AgeableMob) null);
			}
			this.shunosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			RandomSource random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}
	
	static class NaturalMateGoal extends BreedGoal {
		private final Shunosaurus shunosaurus;
		
		NaturalMateGoal(Shunosaurus shunosaurus, double speed) {
			super(shunosaurus, speed);
			this.shunosaurus = shunosaurus;
		}
		
		public boolean canUse() {
			return super.canUse() && !this.shunosaurus.hasBaby() && this.shunosaurus.getCurrentHunger() >= this.shunosaurus.getThreeQuartersHunger() && this.shunosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.shunosaurus.isInLoveNaturally();
		}
		
		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.shunosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.shunosaurus.random.nextFloat() - this.shunosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.shunosaurus.random.nextInt(4);
				for (int i = 0; i <= eggAmount; i++) {
					this.shunosaurus.spawnAtLocation(PFBlocks.SHUNOSAURUS_EGG.get().asItem());
				}
			} else {
				this.shunosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Shunosaurus entity = new Shunosaurus(PFEntities.SHUNOSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData) null, (CompoundTag) null);
		entity.setAge(-72000);
		return entity;
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	class ShunosaurusFollowParentGoal extends Goal {
		private final Shunosaurus babyShunosaurus;
		private Shunosaurus parentShunosaurus;
		private final double moveSpeed;
		private int delayCounter;
		
		public ShunosaurusFollowParentGoal(Shunosaurus shunosaurus, double speed) {
			this.babyShunosaurus = shunosaurus;
			this.moveSpeed = speed;
		}
		
		public boolean canUse() {
			if (this.babyShunosaurus.isBaby()) {
				List<? extends Shunosaurus> list = this.babyShunosaurus.level().getEntitiesOfClass(this.babyShunosaurus.getClass(), this.babyShunosaurus.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
				Shunosaurus shunosaurus = null;
				double d0 = Double.MAX_VALUE;
				for (Shunosaurus tyrannosaurus1 : list) {
					if (!tyrannosaurus1.isBaby()) {
						double d1 = this.babyShunosaurus.distanceToSqr(tyrannosaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							shunosaurus = tyrannosaurus1;
						}
					}
				}
				if (shunosaurus == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentShunosaurus = shunosaurus;
					return true;
				}
			} else {
				return false;
			}
		}
		
		public boolean canContinueToUse() {
			if (!this.babyShunosaurus.isBaby()) {
				return false;
			} else if (!this.parentShunosaurus.isAlive()) {
				return false;
			} else if (this.babyShunosaurus.isBaby()) {
				double d0 = this.babyShunosaurus.distanceToSqr(this.parentShunosaurus);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}
		
		public void start() {
			this.delayCounter = 0;
		}
		
		public void stop() {
			this.parentShunosaurus = null;
		}
		
		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyShunosaurus.getNavigation().moveTo(this.parentShunosaurus, this.moveSpeed);
			}
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SHUNOSAURUS_SPAWN_EGG.get());
	}
	
	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.SHUNOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}
	
	public Item getEggItem() {
		return PFItems.SHUNOSAURUS_EGG.get();
	}
}