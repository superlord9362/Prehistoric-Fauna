package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

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
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import superlord.prehistoricfauna.client.gui.CamptosaurusMenu;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
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

public class Camptosaurus extends DinosaurEntity implements ContainerListener, HasCustomInventoryScreen {
	private static final EntityDataAccessor<Boolean> DATA_ID_CHEST = SynchedEntityData.defineId(Camptosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Camptosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> BOOST_TIME = SynchedEntityData.defineId(Camptosaurus.class, EntityDataSerializers.INT);
	public static final int EQUIPMENT_SLOT_OFFSET = 400;
	public static final int CHEST_SLOT_OFFSET = 499;
	public static final int INVENTORY_SLOT_OFFSET = 500;
	public static final int INV_CHEST_COUNT = 15;
	public static final int INV_SLOT_SADDLE = 0;
	public SimpleContainer inventory;
	private int warningSoundTicks = 200;
	private int maxHunger = 100;
	@Nullable
	private Camptosaurus caravanHead;
	@Nullable
	private Camptosaurus caravanTail;
	public float ridingXZ;
	public float ridingY = 1F;

	public Camptosaurus(EntityType<? extends Camptosaurus> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
		this.createInventory();
	}



	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_CHEST, false);
		this.entityData.define(SADDLED, false);
		this.entityData.define(BOOST_TIME, 0);
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

	public boolean isSaddled() {
		return this.entityData.get(SADDLED);
	}

	private void setSaddled(boolean isSaddled) {
		this.entityData.set(SADDLED, isSaddled);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLADOPHLEBIS.get().asItem();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Camptosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.GARGOYLEOSAURUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new CamptosaurusFollowCaravanGoal(this, (double)2.1F));
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

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40);
		}
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();

		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.CAMPTOSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.CAMPTOSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.camptosaurus_added"), true);
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.camptosaurus_already_added"), true);
			}
			return InteractionResult.SUCCESS;
		}

		if (!this.isTame()) {
			if (item == PFBlocks.CLADOPHLEBIS.get().asItem()) {
				if (!player.getAbilities().instabuild) itemstack.shrink(1);
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
						if (!player.getAbilities().instabuild) itemstack.shrink(1);
						this.setSaddled(true);
						this.inventory.setItem(0, new ItemStack(Items.SADDLE));
						this.level().playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.PIG_SADDLE, SoundSource.NEUTRAL, 0.5F, 1.0F);
						return InteractionResult.SUCCESS;
					}
					if (!this.hasChest() && item == Items.CHEST) {
						this.equipChest(player, itemstack);
						return InteractionResult.SUCCESS;
					}
					if (!this.isVehicle() && this.isSaddled()) {
						player.startRiding(this);
						return InteractionResult.SUCCESS;
					}
				}
			}
		}

		return super.mobInteract(player, hand);
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

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CAMPTOSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CAMPTOSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CAMPTOSAURUS_DEATH.get();
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
		this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
	}

	public void openCustomInventoryScreen(Player player) {
		if (!this.level().isClientSide() && player instanceof ServerPlayer serverPlayer) {
			NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider((id, playerInventory, p) -> new CamptosaurusMenu(id, playerInventory, this.inventory, this), this.hasCustomName() ? this.getCustomName() : Component.translatable("entity.prehistoricfauna.camptosaurus")), buf -> buf.writeInt(this.getId()));
		}
	}

	public void leaveCaravan() {
		if (this.caravanHead != null) {
			this.caravanHead.caravanTail = null;
		}

		this.caravanHead = null;
	}

	public void joinCaravan(Camptosaurus p_30767_) {
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
	public Camptosaurus getCaravanHead() {
		return this.caravanHead;
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



	@Nullable
	public LivingEntity getControllingPassenger() {
	    Entity entity = this.getFirstPassenger();
	    if (entity instanceof Mob mob) return mob;
	    if (this.isSaddled() && entity instanceof Player player) return player;
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
	public void positionRider(Entity passenger, Entity.MoveFunction p_289531_) {
	    super.positionRider(passenger, p_289531_);
	    Player ridingPlayer = this.getRidingPlayer();
	    if (ridingPlayer == null) return;

	    float radius = ridingXZ * 0.7F * -3;
	    float angle = (0.01745329251F * this.yBodyRotO);
	    double extraX = radius * Mth.sin((float) (Math.PI + angle));
	    double extraZ = radius * Mth.cos(angle);
	    double extraY = this.isInWater() ? ridingY * 3 : ridingY * 4.4F;
	    ridingPlayer.setPos(this.getX() + extraX, this.getY() + extraY - 2.75F, this.getZ() + extraZ);
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

		for(Pose pose : p_234236_2_.getDismountPoses()) {
			blockpos$mutable.set(d0, d1, d2);
			double d3 = this.getBoundingBox().maxY + 0.75D;

			while(true) {
				double d4 = this.level().getBlockFloorHeight(blockpos$mutable);
				if ((double)blockpos$mutable.getY() + d4 > d3) {
					break;
				}

				if (DismountHelper.isBlockFloorValid(d4)) {
					AABB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vec3 vector3d = new Vec3(d0, (double)blockpos$mutable.getY() + d4, d2);
					if (DismountHelper.canDismountTo(this.level(), p_234236_2_, axisalignedbb.move(vector3d))) {
						p_234236_2_.setPose(pose);
						return vector3d;
					}
				}

				blockpos$mutable.move(Direction.UP);
				if (!((double)blockpos$mutable.getY() < d3)) {
					break;
				}
			}
		}

		return null;
	}

	public Vec3 getDismountLocationForPassenger(LivingEntity living) {
		Vec3 vector3d = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F));
		Vec3 vector3d1 = this.func_234236_a_(vector3d, living);
		if (vector3d1 != null) {
			return vector3d1;
		} else {
			Vec3 vector3d2 = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F));
			Vec3 vector3d3 = this.func_234236_a_(vector3d2, living);
			return vector3d3 != null ? vector3d3 : this.position();
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
		p_30496_.putBoolean("IsSaddled", this.isSaddled());

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
		this.setSaddled(p_30488_.getBoolean("IsSaddled"));
	}

	public SlotAccess getSlot(int p_149479_) {
		return p_149479_ == 499 ? new SlotAccess() {
			public ItemStack get() {
				return Camptosaurus.this.hasChest() ? new ItemStack(Items.CHEST) : ItemStack.EMPTY;
			}

			public boolean set(ItemStack p_149485_) {
				if (p_149485_.isEmpty()) {
					if (Camptosaurus.this.hasChest()) {
						Camptosaurus.this.setChest(false);
						Camptosaurus.this.createInventory();
					}

					return true;
				} else if (p_149485_.is(Items.CHEST)) {
					if (!Camptosaurus.this.hasChest()) {
						Camptosaurus.this.setChest(true);
						Camptosaurus.this.createInventory();
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

	@SuppressWarnings("deprecation")
	protected void playStepSound(BlockPos pos, BlockState state) {
		if (this.isBaby()) {
			if (!state.liquid()) {
				BlockState blockstate = this.level().getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level(), pos, this) : state.getSoundType(level(), pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CAMPTOSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
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
			super(Camptosaurus.this, 1.25D, true);
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
					Camptosaurus.this.playWarningSound();
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

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CAMPTOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.CAMPTOSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.CAMPTOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Camptosaurus entity = new Camptosaurus(PFEntities.CAMPTOSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public class CamptosaurusFollowCaravanGoal extends Goal {
		public final Camptosaurus camptosaurus;
		private double speedModifier;
		@SuppressWarnings("unused")
		private static final int CARAVAN_LIMIT = 8;
		private int distCheckCounter;

		public CamptosaurusFollowCaravanGoal(Camptosaurus p_25501_, double p_25502_) {
			this.camptosaurus = p_25501_;
			this.speedModifier = p_25502_;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (!this.camptosaurus.hasControllingPassenger() && !this.camptosaurus.inCaravan() && this.camptosaurus.isTame()) {
				List<Entity> list = this.camptosaurus.level().getEntities(this.camptosaurus, this.camptosaurus.getBoundingBox().inflate(9.0D, 4.0D, 9.0D), (p_25505_) -> {
					EntityType<?> entitytype = p_25505_.getType();
					return entitytype == PFEntities.CAMPTOSAURUS.get();
				});
				Camptosaurus camptosaurus = null;
				double d0 = Double.MAX_VALUE;

				for(Entity entity : list) {
					Camptosaurus camptosaurus1 = (Camptosaurus)entity;
					if (camptosaurus1.inCaravan() && !camptosaurus1.hasCaravanTail()) {
						double d1 = this.camptosaurus.distanceToSqr(camptosaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							camptosaurus = camptosaurus1;
						}
					}
				}

				if (camptosaurus == null) {
					for(Entity entity1 : list) {
						Camptosaurus camptosaurus2 = (Camptosaurus)entity1;
						if (camptosaurus2.hasControllingPassenger() && !camptosaurus2.hasCaravanTail()) {
							double d2 = this.camptosaurus.distanceToSqr(camptosaurus2);
							if (!(d2 > d0)) {
								d0 = d2;
								camptosaurus = camptosaurus2;
							}
						}
					}
				}

				if (camptosaurus == null) {
					return false;
				} else if (d0 < 4.0D) {
					return false;
				} else if (!camptosaurus.hasControllingPassenger() && !this.firstIsRidden(camptosaurus, 1)) {
					return false;
				} else {
					this.camptosaurus.joinCaravan(camptosaurus);
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (this.camptosaurus.inCaravan() && this.camptosaurus.getCaravanHead().isAlive() && this.firstIsRidden(this.camptosaurus, 0)) {
				double d0 = this.camptosaurus.distanceToSqr(this.camptosaurus.getCaravanHead());
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
			this.camptosaurus.leaveCaravan();
			this.speedModifier = 2.1D;
		}

		public void tick() {
			if (this.camptosaurus.inCaravan()) {
				Camptosaurus camptosaurus = this.camptosaurus.getCaravanHead();
				double d0 = (double)this.camptosaurus.distanceTo(camptosaurus);
				Vec3 vec3 = (new Vec3(camptosaurus.getX() - this.camptosaurus.getX(), camptosaurus.getY() - this.camptosaurus.getY(), camptosaurus.getZ() - this.camptosaurus.getZ())).normalize().scale(Math.max(d0 - 2.0D, 0.0D));
				this.camptosaurus.getNavigation().moveTo(this.camptosaurus.getX() + vec3.x, this.camptosaurus.getY() + vec3.y, this.camptosaurus.getZ() + vec3.z, this.speedModifier);
			}
		}

		private boolean firstIsRidden(Camptosaurus p_25507_, int p_25508_) {
			if (p_25508_ > 8) {
				return false;
			} else if (p_25507_.inCaravan()) {
				if (p_25507_.getCaravanHead().hasControllingPassenger()) {
					return true;
				} else {
					Camptosaurus camptosaurus = p_25507_.getCaravanHead();
					++p_25508_;
					return this.firstIsRidden(camptosaurus, p_25508_);
				}
			} else {
				return false;
			}
		}
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

}
