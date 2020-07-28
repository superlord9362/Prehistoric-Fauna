package superlord.prehistoricfauna.entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageAtNightGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.block.DakotaraptorEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;

public class DakotaraptorEntity extends PrehistoricEntity {
   private static final DataParameter<Integer> FOX_TYPE = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.VARINT);
   private static final DataParameter<Byte> DAKOTARAPTOR_FLAGS = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BYTE);
   private static final DataParameter<Optional<UUID>> TRUSTED_UUID_SECONDARY = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
   private static final DataParameter<Optional<UUID>> TRUSTED_UUID_MAIN = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
   private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BYTE);
   private static final Predicate<ItemEntity> TRUSTED_TARGET_SELECTOR = (p_213489_0_) -> {
      return !p_213489_0_.cannotPickup() && p_213489_0_.isAlive();
   };
   private static final Predicate<Entity> IS_PREY = (p_213498_0_) -> {
      return p_213498_0_ instanceof BasilemysEntity || p_213498_0_ instanceof ThescelosaurusEntity;
   };
   private Goal attackAnimals;
   private float interestedAngle;
   private float interestedAngleO;
   private float crouchAmount;
   private float crouchAmountO;
   private int eatTicks;
   private int isDigging;

   public DakotaraptorEntity(EntityType<? extends DakotaraptorEntity> type, World worldIn) {
      super(type, worldIn);
      this.lookController = new DakotaraptorEntity.LookHelperController();
      this.moveController = new DakotaraptorEntity.MoveHelperController();
      this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
      this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
      this.setCanPickUpLoot(true);
   }
   
   protected PathNavigator createNavigator(World worldIn) {
	   return new ClimberPathNavigator(this, worldIn);
   }
   
   public boolean jumping() {
	   if(this.isJumping) {
		   return true;
	   } else {
		   return false;
	   }
   }
   
   public boolean isOnLadder() {
	   return this.isBesideClimbableBlock();
   }
   
   public boolean isBesideClimbableBlock() {
	   return (this.dataManager.get(CLIMBING) & 1) != 0;
   }
   
   public void setBesideClimbableBlock(boolean climbing) {
	   byte b0 = this.dataManager.get(CLIMBING);
	   if (climbing) {
		   b0 = (byte)(b0 | 1);
	   } else {
		   b0 = (byte)(b0 & -2);
	   }
	   this.dataManager.set(CLIMBING, b0);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(TRUSTED_UUID_SECONDARY, Optional.empty());
      this.dataManager.register(TRUSTED_UUID_MAIN, Optional.empty());
      this.dataManager.register(FOX_TYPE, 0);
      this.dataManager.register(DAKOTARAPTOR_FLAGS, (byte)0);
      this.dataManager.register(HAS_EGG, false);
      this.dataManager.register(IS_DIGGING, false);
      this.dataManager.register(CLIMBING, (byte)0);
   }

   protected void registerGoals() {
      this.attackAnimals = new NearestAttackableTargetGoal<>(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
         return p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof ThescelosaurusEntity;
      });
      this.goalSelector.addGoal(0, new DakotaraptorEntity.SwimGoal());
      this.goalSelector.addGoal(1, new DakotaraptorEntity.JumpGoal());
      this.goalSelector.addGoal(2, new DakotaraptorEntity.PanicGoal());
      this.goalSelector.addGoal(3, new DakotaraptorEntity.MateGoal(this, 1.0D));
      this.goalSelector.addGoal(5, new DakotaraptorEntity.FollowTargetGoal());
      this.goalSelector.addGoal(6, new DakotaraptorEntity.PounceGoal());
      this.goalSelector.addGoal(6, new DakotaraptorEntity.FindShelterGoal(1.25D));
      this.goalSelector.addGoal(7, new DakotaraptorEntity.BiteGoal((double)1.2F, true));
      this.goalSelector.addGoal(7, new DakotaraptorEntity.SleepGoal());
      this.goalSelector.addGoal(8, new DakotaraptorEntity.FollowGoal(this, 1.25D));
      this.goalSelector.addGoal(9, new DakotaraptorEntity.StrollGoal(32, 200));
      this.goalSelector.addGoal(10, new LeapAtTargetGoal(this, 0.4F));
      this.goalSelector.addGoal(11, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(11, new DakotaraptorEntity.FindItemsGoal());
      this.goalSelector.addGoal(12, new DakotaraptorEntity.WatchGoal(this, PlayerEntity.class, 24.0F));
      this.goalSelector.addGoal(13, new DakotaraptorEntity.SitAndLookGoal());
      this.goalSelector.addGoal(4, new DakotaraptorEntity.LayEggGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new DakotaraptorEntity.ProtectBabyGoal());
      this.goalSelector.addGoal(4, new DakotaraptorEntity.TerritoryGoal());
      this.targetSelector.addGoal(1, new DakotaraptorEntity.HurtByTargetGoal());
      this.targetSelector.addGoal(2, new DakotaraptorEntity.AttackPlayerGoal());
   }

   public SoundEvent getEatSound(ItemStack itemStackIn) {
      return null;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
	   super.livingTick();
	   if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
		   ++this.eatTicks;
		   ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
		   if (this.canEatItem(itemstack)) {
			   if (this.eatTicks > 600) {
				   ItemStack itemstack1 = itemstack.onItemUseFinish(this.world, this);
				   if (!itemstack1.isEmpty()) {
					   this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack1);
				   }
				   this.eatTicks = 0;
			   } else if (this.eatTicks > 560 && this.rand.nextFloat() < 0.1F) {
               this.playSound(this.getEatSound(itemstack), 1.0F, 1.0F);
               this.world.setEntityState(this, (byte)45);
			   }
		   }
		   LivingEntity livingentity = this.getAttackTarget();
		   if (livingentity == null || !livingentity.isAlive()) {
			   this.setCrouching(false);
			   this.func_213502_u(false);
		   }
	   }
	   if (this.isSleeping() || this.isMovementBlocked()) {
		   this.isJumping = false;
		   this.moveStrafing = 0.0F;
		   this.moveForward = 0.0F;
	   }
	   super.livingTick();
	   if (this.isDakotaraptorAggroed() && this.rand.nextFloat() < 0.05F) {
		   this.playSound(null, 1.0F, 1.0F);
	   }
   }

   /**
    * Dead and sleeping entities cannot move
    */
   protected boolean isMovementBlocked() {
      return this.getHealth() <= 0.0F && this.isSleeping();
   }

   private boolean canEatItem(ItemStack itemStackIn) {
      return itemStackIn.getItem().isFood() && this.getAttackTarget() == null && this.onGround && !this.isSleeping();
   }

   /**
    * Gives armor or weapon for entity based on given DifficultyInstance
    */


   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 45) {
         ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (!itemstack.isEmpty()) {
            for(int i = 0; i < 8; ++i) {
               Vec3d vec3d = (new Vec3d(((double)this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float)Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float)Math.PI / 180F));
               this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, itemstack), this.getPosX() + this.getLookVec().x / 2.0D, this.getPosY(), this.getPosZ() + this.getLookVec().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
            }
         }
      } else {
         super.handleStatusUpdate(id);
      }

   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
      this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
   }

   public AgeableEntity createChild(AgeableEntity ageable) {
	   DakotaraptorEntity entity = new DakotaraptorEntity(ModEntityTypes.DAKOTARAPTOR_ENTITY, this.world);
	   entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
	   return entity;
   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      Biome biome = worldIn.getBiome(new BlockPos(this));
      DakotaraptorEntity.Type dakotaraptorentity$type = DakotaraptorEntity.Type.getTypeByBiome(biome);
      boolean flag = false;
      if (spawnDataIn instanceof DakotaraptorEntity.DakotaraptorData) {
         dakotaraptorentity$type = ((DakotaraptorEntity.DakotaraptorData)spawnDataIn).field_220366_a;
         if (((DakotaraptorEntity.DakotaraptorData)spawnDataIn).func_226257_a_() >= 2) {
            flag = true;
         }
      } else {
         spawnDataIn = new DakotaraptorEntity.DakotaraptorData(dakotaraptorentity$type);
      }

      this.setVariantType(dakotaraptorentity$type);
      if (flag) {
         this.setGrowingAge(-24000);
      }

      this.setAttackGoals();
      this.setEquipmentBasedOnDifficulty(difficultyIn);
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   private void setAttackGoals() {
      if (this.getVariantType() == DakotaraptorEntity.Type.RED) {
         this.targetSelector.addGoal(4, this.attackAnimals);
      } else {
         this.targetSelector.addGoal(6, this.attackAnimals);
      }

   }

   /**
    * Decreases ItemStack size by one
    */
   protected void consumeItemFromStack(PlayerEntity player, ItemStack stack) {
      if (this.isBreedingItem(stack)) {
         this.playSound(this.getEatSound(stack), 1.0F, 1.0F);
      }

      super.consumeItemFromStack(player, stack);
   }


   public DakotaraptorEntity.Type getVariantType() {
      return DakotaraptorEntity.Type.getTypeByIndex(this.dataManager.get(FOX_TYPE));
   }

   private void setVariantType(DakotaraptorEntity.Type typeIn) {
      this.dataManager.set(FOX_TYPE, typeIn.getIndex());
   }

   private List<UUID> getTrustedUUIDs() {
      List<UUID> list = Lists.newArrayList();
      list.add(this.dataManager.get(TRUSTED_UUID_SECONDARY).orElse((UUID)null));
      list.add(this.dataManager.get(TRUSTED_UUID_MAIN).orElse((UUID)null));
      return list;
   }

   private void addTrustedUUID(@Nullable UUID uuidIn) {
      if (this.dataManager.get(TRUSTED_UUID_SECONDARY).isPresent()) {
         this.dataManager.set(TRUSTED_UUID_MAIN, Optional.ofNullable(uuidIn));
      } else {
         this.dataManager.set(TRUSTED_UUID_SECONDARY, Optional.ofNullable(uuidIn));
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      List<UUID> list = this.getTrustedUUIDs();
      ListNBT listnbt = new ListNBT();

      for(UUID uuid : list) {
         if (uuid != null) {
            listnbt.add(NBTUtil.writeUniqueId(uuid));
         }
      }

      compound.put("TrustedUUIDs", listnbt);
      compound.putBoolean("Sleeping", this.isSleeping());
      compound.putString("Type", this.getVariantType().getName());
      compound.putBoolean("Sitting", this.isSitting());
      compound.putBoolean("HasEgg", this.hasEgg());
      compound.putBoolean("Crouching", this.isCrouching());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      ListNBT listnbt = compound.getList("TrustedUUIDs", 10);

      for(int i = 0; i < listnbt.size(); ++i) {
         this.addTrustedUUID(NBTUtil.readUniqueId(listnbt.getCompound(i)));
      }

      this.setSleeping(compound.getBoolean("Sleeping"));
      this.setVariantType(DakotaraptorEntity.Type.getTypeByName(compound.getString("Type")));
      this.setSitting(compound.getBoolean("Sitting"));
      this.setCrouching(compound.getBoolean("Crouching"));
      this.setHasEgg(compound.getBoolean("HasEgg"));
      this.setAttackGoals();
   }
   
   public boolean isDakotaraptorPouncing() {
 	  return this.getDakotaraptorFlag(256);
   }
   
   private void setDakotaraptorPouncing(boolean p_213482_1_) {
	   this.setDakotaraptorFlag(256, p_213482_1_);
   }


   public boolean isSitting() {
      return this.getDakotaraptorFlag(1);
   }

   public void setSitting(boolean p_213466_1_) {
      this.setDakotaraptorFlag(1, p_213466_1_);
   }

   public boolean isStuck() {
      return this.getDakotaraptorFlag(64);
   }

   private void setStuck(boolean p_213492_1_) {
      this.setDakotaraptorFlag(64, p_213492_1_);
   }

   private boolean isDakotaraptorAggroed() {
      return this.getDakotaraptorFlag(128);
   }

   private void setDakotaraptorAggroed(boolean p_213482_1_) {
      this.setDakotaraptorFlag(128, p_213482_1_);
   }

   /**
    * Returns whether player is sleeping or not
    */
   public boolean isSleeping() {
      return this.getDakotaraptorFlag(32);
   }

   private void setSleeping(boolean p_213485_1_) {
      this.setDakotaraptorFlag(32, p_213485_1_);
   }

   private void setDakotaraptorFlag(int p_213505_1_, boolean p_213505_2_) {
      if (p_213505_2_) {
         this.dataManager.set(DAKOTARAPTOR_FLAGS, (byte)(this.dataManager.get(DAKOTARAPTOR_FLAGS) | p_213505_1_));
      } else {
         this.dataManager.set(DAKOTARAPTOR_FLAGS, (byte)(this.dataManager.get(DAKOTARAPTOR_FLAGS) & ~p_213505_1_));
      }

   }

   private boolean getDakotaraptorFlag(int p_213507_1_) {
      return (this.dataManager.get(DAKOTARAPTOR_FLAGS) & p_213507_1_) != 0;
   }

   public boolean canPickUpItem(ItemStack itemstackIn) {
      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstackIn);
      if (!this.getItemStackFromSlot(equipmentslottype).isEmpty()) {
         return false;
      } else {
         return equipmentslottype == EquipmentSlotType.MAINHAND && super.canPickUpItem(itemstackIn);
      }
   }

   protected boolean canEquipItem(ItemStack stack) {
      Item item = stack.getItem();
      ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      return itemstack.isEmpty() || this.eatTicks > 0 && item.isFood() && !itemstack.getItem().isFood();
   }

   private void spitOutItem(ItemStack stackIn) {
      if (!stackIn.isEmpty() && !this.world.isRemote) {
         ItemEntity itementity = new ItemEntity(this.world, this.getPosX() + this.getLookVec().x, this.getPosY() + 1.0D, this.getPosZ() + this.getLookVec().z, stackIn);
         itementity.setPickupDelay(40);
         itementity.setThrowerId(this.getUniqueID());
         this.playSound(SoundEvents.ENTITY_FOX_SPIT, 1.0F, 1.0F);
         this.world.addEntity(itementity);
      }
   }

   private void spawnItem(ItemStack stackIn) {
      ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), stackIn);
      this.world.addEntity(itementity);
   }

   /**
    * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
    * better.
    */
   protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
      ItemStack itemstack = itemEntity.getItem();
      if (this.canEquipItem(itemstack)) {
         int i = itemstack.getCount();
         if (i > 1) {
            this.spawnItem(itemstack.split(i - 1));
         }

         this.spitOutItem(this.getItemStackFromSlot(EquipmentSlotType.MAINHAND));
         this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack.split(1));
         this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
         this.onItemPickup(itemEntity, itemstack.getCount());
         itemEntity.remove();
         this.eatTicks = 0;
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.isServerWorld()) {
         boolean flag = this.isInWater();
         if (flag || this.getAttackTarget() != null || this.world.isThundering()) {
            this.func_213454_em();
         }

         if (flag || this.isSleeping()) {
            this.setSitting(false);
         }

         if (this.isStuck() && this.world.rand.nextFloat() < 0.2F) {
            BlockPos blockpos = new BlockPos(this);
            BlockState blockstate = this.world.getBlockState(blockpos);
            this.world.playEvent(2001, blockpos, Block.getStateId(blockstate));
         }
      }

      this.interestedAngleO = this.interestedAngle;
      if (this.func_213467_eg()) {
         this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
      } else {
         this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
      }

      this.crouchAmountO = this.crouchAmount;
      if (this.isCrouching()) {
         this.crouchAmount += 0.2F;
         if (this.crouchAmount > 3.0F) {
            this.crouchAmount = 3.0F;
         }
      } else {
         this.crouchAmount = 0.0F;
      }
      
      if (!this.world.isRemote) {
    	  this.setBesideClimbableBlock(this.collidedHorizontally);
      }
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isBreedingItem(ItemStack stack) {
      return stack.getItem() == ItemInit.RAW_THESCELOSAURUS_MEAT.get();
   }

   protected void onChildSpawnFromEgg(PlayerEntity playerIn, AgeableEntity child) {
      ((DakotaraptorEntity)child).addTrustedUUID(playerIn.getUniqueID());
   }

   public boolean func_213480_dY() {
      return this.getDakotaraptorFlag(16);
   }
   
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

   public void func_213461_s(boolean p_213461_1_) {
      this.setDakotaraptorFlag(16, p_213461_1_);
   }

   public boolean func_213490_ee() {
      return this.crouchAmount == 3.0F;
   }

   public void setCrouching(boolean p_213451_1_) {
      this.setDakotaraptorFlag(4, p_213451_1_);
   }

   public boolean isCrouching() {
      return this.getDakotaraptorFlag(4);
   }

   public void func_213502_u(boolean p_213502_1_) {
      this.setDakotaraptorFlag(8, p_213502_1_);
   }

   public boolean func_213467_eg() {
      return this.getDakotaraptorFlag(8);
   }

   @OnlyIn(Dist.CLIENT)
   public float func_213475_v(float p_213475_1_) {
      return MathHelper.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
   }

   @OnlyIn(Dist.CLIENT)
   public float func_213503_w(float p_213503_1_) {
      return MathHelper.lerp(p_213503_1_, this.crouchAmountO, this.crouchAmount);
   }

   /**
    * Sets the active target the Task system uses for tracking
    */
   public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
      if (this.isDakotaraptorAggroed() && entitylivingbaseIn == null) {
         this.setDakotaraptorAggroed(false);
      }

      super.setAttackTarget(entitylivingbaseIn);
   }
   
   public boolean attackEntityAsMob(Entity entityIn) {
	   boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
	   if (flag) {
		   this.applyEnchantments(this, entityIn);
	   }
	   return flag;
   }	


   protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
      return MathHelper.ceil((p_225508_1_ - 5.0F) * p_225508_2_);
   }

   private void func_213454_em() {
      this.setSleeping(false);
   }

   private void func_213499_en() {
      this.func_213502_u(false);
      this.setCrouching(false);
      this.setSitting(false);
      this.setSleeping(false);
      this.setDakotaraptorAggroed(false);
      this.setStuck(false);
   }

   private boolean func_213478_eo() {
      return !this.isSleeping() && !this.isSitting() && !this.isStuck();
   }

   /**
    * Plays living's sound at its position
    */
   public void playAmbientSound() {
      SoundEvent soundevent = this.getAmbientSound();
      if (soundevent == null) {
         this.playSound(soundevent, 2.0F, this.getSoundPitch());
      } else {
         super.playAmbientSound();
      }

   }

   @Nullable
   protected SoundEvent getAmbientSound() {
      if (this.isSleeping()) {
         return null;
      } else {
         if (!this.world.isDaytime() && this.rand.nextFloat() < 0.1F) {
            List<PlayerEntity> list = this.world.getEntitiesWithinAABB(PlayerEntity.class, this.getBoundingBox().grow(16.0D, 16.0D, 16.0D), EntityPredicates.NOT_SPECTATING);
            if (list.isEmpty()) {
               return null;
            }
         }

         return null;
      }
   }

   @Nullable
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return null;
   }

   @Nullable
   protected SoundEvent getDeathSound() {
      return null;
   }

   private boolean isTrustedUUID(UUID p_213468_1_) {
      return this.getTrustedUUIDs().contains(p_213468_1_);
   }

   protected void spawnDrops(DamageSource damageSourceIn) {
      ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      if (!itemstack.isEmpty()) {
         this.entityDropItem(itemstack);
         this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
      }

      super.spawnDrops(damageSourceIn);
   }

   public static boolean func_213481_a(DakotaraptorEntity p_213481_0_, LivingEntity p_213481_1_) {
      double d0 = p_213481_1_.getPosZ() - p_213481_0_.getPosZ();
      double d1 = p_213481_1_.getPosX() - p_213481_0_.getPosX();
      double d2 = d0 / d1;
      for(int j = 0; j < 6; ++j) {
         double d3 = d2 == 0.0D ? 0.0D : d0 * (double)((float)j / 6.0F);
         double d4 = d2 == 0.0D ? d1 * (double)((float)j / 6.0F) : d3 / d2;

         for(int k = 1; k < 4; ++k) {
            if (!p_213481_0_.world.getBlockState(new BlockPos(p_213481_0_.getPosX() + d4, p_213481_0_.getPosY() + (double)k, p_213481_0_.getPosZ() + d3)).getMaterial().isReplaceable()) {
               return false;
            }
         }
      }

      return true;
   }

   public class AlertablePredicate implements Predicate<LivingEntity> {
      public boolean test(LivingEntity p_test_1_) {
         if (p_test_1_ instanceof DakotaraptorEntity) {
            return false;
         } else if (!(p_test_1_ instanceof ChickenEntity) && !(p_test_1_ instanceof RabbitEntity) && !(p_test_1_ instanceof MonsterEntity)) {
            if (p_test_1_ instanceof TameableEntity) {
               return !((TameableEntity)p_test_1_).isTamed();
            } else if (!(p_test_1_ instanceof PlayerEntity) || !p_test_1_.isSpectator() && !((PlayerEntity)p_test_1_).isCreative()) {
               if (DakotaraptorEntity.this.isTrustedUUID(p_test_1_.getUniqueID())) {
                  return false;
               } else {
                  return !p_test_1_.isSleeping() && !p_test_1_.isDiscrete();
               }
            } else {
               return false;
            }
         } else {
            return true;
         }
      }
   }

   abstract class BaseGoal extends Goal {
      private final EntityPredicate field_220816_b = (new EntityPredicate()).setDistance(12.0D).setLineOfSiteRequired().setCustomPredicate(DakotaraptorEntity.this.new AlertablePredicate());

      private BaseGoal() {
      }

      protected boolean func_220813_g() {
         BlockPos blockpos = new BlockPos(DakotaraptorEntity.this);
         return !DakotaraptorEntity.this.world.canSeeSky(blockpos) && DakotaraptorEntity.this.getBlockPathWeight(blockpos) >= 0.0F;
      }

      protected boolean func_220814_h() {
         return !DakotaraptorEntity.this.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.field_220816_b, DakotaraptorEntity.this, DakotaraptorEntity.this.getBoundingBox().grow(12.0D, 6.0D, 12.0D)).isEmpty();
      }
   }

   class BiteGoal extends MeleeAttackGoal {
      public BiteGoal(double p_i50731_2_, boolean p_i50731_4_) {
         super(DakotaraptorEntity.this, p_i50731_2_, p_i50731_4_);
      }

      protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
         double d0 = this.getAttackReachSqr(enemy);
         if (distToEnemySqr <= d0 && this.attackTick <= 0) {
            this.attackTick = 20;
            this.attacker.attackEntityAsMob(enemy);
            DakotaraptorEntity.this.playSound(null, 1.0F, 1.0F);
         }

      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.func_213502_u(false);
         super.startExecuting();
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return !DakotaraptorEntity.this.isSitting() && !DakotaraptorEntity.this.isSleeping() && !DakotaraptorEntity.this.isCrouching() && !DakotaraptorEntity.this.isStuck() && super.shouldExecute();
      }
   }

   class FindItemsGoal extends Goal {
      public FindItemsGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (!DakotaraptorEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            return false;
         } else if (DakotaraptorEntity.this.getAttackTarget() == null && DakotaraptorEntity.this.getRevengeTarget() == null) {
            if (!DakotaraptorEntity.this.func_213478_eo()) {
               return false;
            } else if (DakotaraptorEntity.this.getRNG().nextInt(10) != 0) {
               return false;
            } else {
               List<ItemEntity> list = DakotaraptorEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DakotaraptorEntity.TRUSTED_TARGET_SELECTOR);
               return !list.isEmpty() && DakotaraptorEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
            }
         } else {
            return false;
         }
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         List<ItemEntity> list = DakotaraptorEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DakotaraptorEntity.TRUSTED_TARGET_SELECTOR);
         ItemStack itemstack = DakotaraptorEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (itemstack.isEmpty() && !list.isEmpty()) {
            DakotaraptorEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
         }

      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         List<ItemEntity> list = DakotaraptorEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DakotaraptorEntity.TRUSTED_TARGET_SELECTOR);
         if (!list.isEmpty()) {
            DakotaraptorEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
         }

      }
   }
   
   class DakotaMeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
	   public DakotaMeleeAttackGoal() {
		   super(DakotaraptorEntity.this, 1.25D, true);
	   }

	   protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
		   double d0 = this.getAttackReachSqr(enemy);
		   if (distToEnemySqr <= d0 && this.attackTick <= 0) {
			   this.attackTick = 20;
			   this.attacker.attackEntityAsMob(enemy);
		   } else if (distToEnemySqr <= d0 * 2.0D) {
			   if (this.attackTick <= 0) {
				   this.attackTick = 20;
			   }
			   if (this.attackTick <= 10) {
			   }
		   } else {
			   this.attackTick = 20;
		   }
	   }
	   public void resetTask() {
		   super.resetTask();
	   }

	   protected double getAttackReachSqr(LivingEntity attackTarget) {
		   return (double)(4.0F + attackTarget.getWidth());
	   }
   }

   class FindShelterGoal extends FleeSunGoal {
      private int cooldown = 100;

      public FindShelterGoal(double p_i50724_2_) {
         super(DakotaraptorEntity.this, p_i50724_2_);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (!DakotaraptorEntity.this.isSleeping() && this.creature.getAttackTarget() == null) {
            if (DakotaraptorEntity.this.world.isThundering()) {
               return true;
            } else if (this.cooldown > 0) {
               --this.cooldown;
               return false;
            } else {
               this.cooldown = 100;
               BlockPos blockpos = new BlockPos(this.creature);
               return DakotaraptorEntity.this.world.isDaytime() && DakotaraptorEntity.this.world.canSeeSky(blockpos) && !((ServerWorld)DakotaraptorEntity.this.world).isVillage(blockpos) && this.func_220702_g();
            }
         } else {
            return false;
         }
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.func_213499_en();
         super.startExecuting();
      }
   }

   class FollowGoal extends FollowParentGoal {
      private final DakotaraptorEntity owner;

      public FollowGoal(DakotaraptorEntity p_i50735_2_, double p_i50735_3_) {
         super(p_i50735_2_, p_i50735_3_);
         this.owner = p_i50735_2_;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return !this.owner.isDakotaraptorAggroed() && super.shouldExecute();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return !this.owner.isDakotaraptorAggroed() && super.shouldContinueExecuting();
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.owner.func_213499_en();
         super.startExecuting();
      }
   }

   class FollowTargetGoal extends Goal {
      public FollowTargetGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (DakotaraptorEntity.this.isSleeping()) {
            return false;
         } else {
            LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
            return livingentity != null && livingentity.isAlive() && DakotaraptorEntity.IS_PREY.test(livingentity) && DakotaraptorEntity.this.getDistanceSq(livingentity) > 36.0D && !DakotaraptorEntity.this.isCrouching() && !DakotaraptorEntity.this.func_213467_eg() && !DakotaraptorEntity.this.isJumping;
         }
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.setSitting(false);
         DakotaraptorEntity.this.setStuck(false);
      }
      
      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
         if (livingentity != null && DakotaraptorEntity.func_213481_a(DakotaraptorEntity.this, livingentity)) {
            DakotaraptorEntity.this.func_213502_u(true);
            DakotaraptorEntity.this.setCrouching(true);
            DakotaraptorEntity.this.getNavigator().clearPath();
            DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, (float)DakotaraptorEntity.this.getHorizontalFaceSpeed(), (float)DakotaraptorEntity.this.getVerticalFaceSpeed());
         } else {
            DakotaraptorEntity.this.func_213502_u(false);
            DakotaraptorEntity.this.setCrouching(false);
         }

      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
         DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, (float)DakotaraptorEntity.this.getHorizontalFaceSpeed(), (float)DakotaraptorEntity.this.getVerticalFaceSpeed());
         if (DakotaraptorEntity.this.getDistanceSq(livingentity) <= 36.0D) {
            DakotaraptorEntity.this.func_213502_u(true);
            DakotaraptorEntity.this.setCrouching(true);
            DakotaraptorEntity.this.getNavigator().clearPath();
         } else {
            DakotaraptorEntity.this.getNavigator().tryMoveToEntityLiving(livingentity, 1.5D);
         }

      }
   }

   public static class DakotaraptorData extends AgeableEntity.AgeableData {
      public final DakotaraptorEntity.Type field_220366_a;

      public DakotaraptorData(DakotaraptorEntity.Type p_i50734_1_) {
         this.func_226259_a_(false);
         this.field_220366_a = p_i50734_1_;
      }
   }

   class JumpGoal extends Goal {
      int delay;

      public JumpGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.JUMP, Goal.Flag.MOVE));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return DakotaraptorEntity.this.isStuck();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return this.shouldExecute() && this.delay > 0;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.delay = 40;
         DakotaraptorEntity.this.setDakotaraptorPouncing(true);
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         DakotaraptorEntity.this.setStuck(false);
         DakotaraptorEntity.this.setDakotaraptorPouncing(false);
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         --this.delay;
      }
   }

   public class LookHelperController extends LookController {
      public LookHelperController() {
         super(DakotaraptorEntity.this);
      }

      /**
       * Updates look
       */
      public void tick() {
         if (!DakotaraptorEntity.this.isSleeping()) {
            super.tick();
         }

      }

      protected boolean func_220680_b() {
         return !DakotaraptorEntity.this.func_213480_dY() && !DakotaraptorEntity.this.isCrouching() && !DakotaraptorEntity.this.func_213467_eg() & !DakotaraptorEntity.this.isStuck();
      }
   }

   class MateGoal extends BreedGoal {
	   private final DakotaraptorEntity dakotaraptor;

	   MateGoal(DakotaraptorEntity dakotaraptor, double speedIn) {
		   super(dakotaraptor, speedIn);
		   this.dakotaraptor = dakotaraptor;
	   }

	   public boolean shouldExecute() {
		   return super.shouldExecute() && !this.dakotaraptor.hasEgg();
	   }

	   protected void spawnBaby() {
		   ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
		   if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
			   serverplayerentity = this.targetMate.getLoveCause();
		   }

		   if (serverplayerentity != null) {
			   serverplayerentity.addStat(Stats.ANIMALS_BRED);
			   CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
		   }

		   this.dakotaraptor.setHasEgg(true);
		   this.animal.resetInLove();
		   this.targetMate.resetInLove();
		   Random random = this.animal.getRNG();
		   if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
			   this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
		   }
	   }
   }

   class MoveHelperController extends MovementController {
      public MoveHelperController() {
         super(DakotaraptorEntity.this);
      }

      public void tick() {
         if (DakotaraptorEntity.this.func_213478_eo()) {
            super.tick();
         }

      }
   }

   class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
	   public PanicGoal() {
		   super(DakotaraptorEntity.this, 2.0D);
	   }
	   
	   public boolean shouldExecute() {
		   return !DakotaraptorEntity.this.isChild() && !DakotaraptorEntity.this.isBurning() ? false : super.shouldExecute();
	   }
   }

   public class PounceGoal extends net.minecraft.entity.ai.goal.JumpGoal {
      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (!DakotaraptorEntity.this.func_213490_ee()) {
            return false;
         } else {
            LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
            if (livingentity != null && livingentity.isAlive()) {
               if (livingentity.getAdjustedHorizontalFacing() != livingentity.getHorizontalFacing()) {
                  return false;
               } else {
                  boolean flag = DakotaraptorEntity.func_213481_a(DakotaraptorEntity.this, livingentity);
                  if (!flag) {
                     DakotaraptorEntity.this.getNavigator().getPathToEntity(livingentity, 0);
                     DakotaraptorEntity.this.setCrouching(false);
                     DakotaraptorEntity.this.func_213502_u(false);
                  }

                  return flag;
               }
            } else {
               return false;
            }
         }
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
         if (livingentity != null && livingentity.isAlive()) {
            double d0 = DakotaraptorEntity.this.getMotion().y;
            return (!(d0 * d0 < (double)0.05F) || !(Math.abs(DakotaraptorEntity.this.rotationPitch) < 15.0F) || !DakotaraptorEntity.this.onGround) && !DakotaraptorEntity.this.isStuck();
         } else {
            return false;
         }
      }

      public boolean isPreemptible() {
         return false;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.setJumping(true);
         DakotaraptorEntity.this.func_213461_s(true);
         DakotaraptorEntity.this.func_213502_u(false);
         LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
         DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
         Vec3d vec3d = (new Vec3d(livingentity.getPosX() - DakotaraptorEntity.this.getPosX(), livingentity.getPosY() - DakotaraptorEntity.this.getPosY(), livingentity.getPosZ() - DakotaraptorEntity.this.getPosZ())).normalize();
         DakotaraptorEntity.this.setMotion(DakotaraptorEntity.this.getMotion().add(vec3d.x * 0.8D, 0.9D, vec3d.z * 0.8D));
         DakotaraptorEntity.this.getNavigator().clearPath();
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         DakotaraptorEntity.this.setCrouching(false);
         DakotaraptorEntity.this.crouchAmount = 0.0F;
         DakotaraptorEntity.this.crouchAmountO = 0.0F;
         DakotaraptorEntity.this.func_213502_u(false);
         DakotaraptorEntity.this.func_213461_s(false);
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      @SuppressWarnings("deprecation")
	public void tick() {
         LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
         if (livingentity != null) {
            DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
         }

         if (!DakotaraptorEntity.this.isStuck()) {
            Vec3d vec3d = DakotaraptorEntity.this.getMotion();
            if (vec3d.y * vec3d.y < (double)0.03F && DakotaraptorEntity.this.rotationPitch != 0.0F) {
               DakotaraptorEntity.this.rotationPitch = MathHelper.rotLerp(DakotaraptorEntity.this.rotationPitch, 0.0F, 0.2F);
            } else {
               double d0 = Math.sqrt(Entity.horizontalMag(vec3d));
               double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double)(180F / (float)Math.PI);
               DakotaraptorEntity.this.rotationPitch = (float)d1;
            }
         }

         if (livingentity != null && DakotaraptorEntity.this.getDistance(livingentity) <= 2.0F) {
            DakotaraptorEntity.this.attackEntityAsMob(livingentity);
         } else if (DakotaraptorEntity.this.rotationPitch > 0.0F && DakotaraptorEntity.this.onGround && (float)DakotaraptorEntity.this.getMotion().y != 0.0F && DakotaraptorEntity.this.world.getBlockState(new BlockPos(DakotaraptorEntity.this)).getBlock() == Blocks.SNOW) {
            DakotaraptorEntity.this.rotationPitch = 60.0F;
            DakotaraptorEntity.this.setAttackTarget((LivingEntity)null);
            DakotaraptorEntity.this.setStuck(true);
         }

      }
   }
   
   class TerritoryGoal extends NearestAttackableTargetGoal<PlayerEntity> {
	   public TerritoryGoal() {
		   super(DakotaraptorEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
	   }

	   @SuppressWarnings("unused")
	public boolean shouldExecute() {
		   if (DakotaraptorEntity.this.isChild()) {
			   return false;
		   } else {
			   if (super.shouldExecute()) {
				   for(DakotaraptorEntity dakotaraptor : DakotaraptorEntity.this.world.getEntitiesWithinAABB(DakotaraptorEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(20.0D, 4.0D, 20.0D))) {
					   return true;
				   }
			   }
			   return false;
		   }
	   }
	   
	   public void startExecuting() {
		   DakotaraptorEntity.this.setDakotaraptorAggroed(true);
	   }

	   protected double getTargetDistance() {
		   return super.getTargetDistance() * 0.5D;
	   }
   }
   
   class ProtectBabyGoal extends NearestAttackableTargetGoal<PlayerEntity> {
	   public ProtectBabyGoal() {
		   super(DakotaraptorEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
	   }

	   public boolean shouldExecute() {
		   if (DakotaraptorEntity.this.isChild()) {
			   return false;
		   } else {
			   if (super.shouldExecute()) {
				   for(DakotaraptorEntity dakotaraptor : DakotaraptorEntity.this.world.getEntitiesWithinAABB(DakotaraptorEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
					   if (dakotaraptor.isChild()) {
						   return true;
					   }
				   }
			   }
			   return false;
		   }
	   }
	   
	   public void startExecuting() {
		   DakotaraptorEntity.this.setDakotaraptorAggroed(true);
	   }

	   protected double getTargetDistance() {
		   return super.getTargetDistance() * 0.5D;
	   }
   }

   class RevengeGoal extends NearestAttackableTargetGoal<LivingEntity> {
      @Nullable
      private LivingEntity field_220786_j;
      private LivingEntity field_220787_k;
      private int field_220788_l;

      public RevengeGoal(Class<LivingEntity> p_i50743_2_, boolean p_i50743_3_, boolean p_i50743_4_, @Nullable Predicate<LivingEntity> p_i50743_5_) {
         super(DakotaraptorEntity.this, p_i50743_2_, 10, p_i50743_3_, p_i50743_4_, p_i50743_5_);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (this.targetChance > 0 && this.goalOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
         } else {
            for(UUID uuid : DakotaraptorEntity.this.getTrustedUUIDs()) {
               if (uuid != null && DakotaraptorEntity.this.world instanceof ServerWorld) {
                  Entity entity = ((ServerWorld)DakotaraptorEntity.this.world).getEntityByUuid(uuid);
                  if (entity instanceof LivingEntity) {
                     LivingEntity livingentity = (LivingEntity)entity;
                     this.field_220787_k = livingentity;
                     this.field_220786_j = livingentity.getRevengeTarget();
                     int i = livingentity.getRevengeTimer();
                     return i != this.field_220788_l && this.isSuitableTarget(this.field_220786_j, this.targetEntitySelector);
                  }
               }
            }

            return false;
         }
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.setAttackTarget(this.field_220786_j);
         this.nearestTarget = this.field_220786_j;
         if (this.field_220787_k != null) {
            this.field_220788_l = this.field_220787_k.getRevengeTimer();
         }

         DakotaraptorEntity.this.playSound(null, 1.0F, 1.0F);
         DakotaraptorEntity.this.setDakotaraptorAggroed(true);
         DakotaraptorEntity.this.func_213454_em();
         super.startExecuting();
      }
   }

   class SitAndLookGoal extends DakotaraptorEntity.BaseGoal {
      private double field_220819_c;
      private double field_220820_d;
      private int field_220821_e;
      private int field_220822_f;

      public SitAndLookGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return DakotaraptorEntity.this.getRevengeTarget() == null && DakotaraptorEntity.this.getRNG().nextFloat() < 0.02F && !DakotaraptorEntity.this.isSleeping() && DakotaraptorEntity.this.getAttackTarget() == null && DakotaraptorEntity.this.getNavigator().noPath() && !this.func_220814_h() && !DakotaraptorEntity.this.func_213480_dY() && !DakotaraptorEntity.this.isCrouching();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return this.field_220822_f > 0;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.func_220817_j();
         this.field_220822_f = 2 + DakotaraptorEntity.this.getRNG().nextInt(3);
         DakotaraptorEntity.this.setSitting(true);
         DakotaraptorEntity.this.getNavigator().clearPath();
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         DakotaraptorEntity.this.setSitting(false);
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         --this.field_220821_e;
         if (this.field_220821_e <= 0) {
            --this.field_220822_f;
            this.func_220817_j();
         }

         DakotaraptorEntity.this.getLookController().setLookPosition(DakotaraptorEntity.this.getPosX() + this.field_220819_c, DakotaraptorEntity.this.getPosYEye(), DakotaraptorEntity.this.getPosZ() + this.field_220820_d, (float)DakotaraptorEntity.this.getHorizontalFaceSpeed(), (float)DakotaraptorEntity.this.getVerticalFaceSpeed());
      }

      private void func_220817_j() {
         double d0 = (Math.PI * 2D) * DakotaraptorEntity.this.getRNG().nextDouble();
         this.field_220819_c = Math.cos(d0);
         this.field_220820_d = Math.sin(d0);
         this.field_220821_e = 80 + DakotaraptorEntity.this.getRNG().nextInt(20);
      }
   }

   class SleepGoal extends DakotaraptorEntity.BaseGoal {
      private int field_220825_c = DakotaraptorEntity.this.rand.nextInt(140);

      public SleepGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (DakotaraptorEntity.this.moveStrafing == 0.0F && DakotaraptorEntity.this.moveVertical == 0.0F && DakotaraptorEntity.this.moveForward == 0.0F) {
            return this.func_220823_j() || DakotaraptorEntity.this.isSleeping();
         } else {
            return false;
         }
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return this.func_220823_j();
      }

      private boolean func_220823_j() {
         if (this.field_220825_c > 0) {
            --this.field_220825_c;
            return false;
         } else {
            return DakotaraptorEntity.this.world.isDaytime() && this.func_220813_g() && !this.func_220814_h();
         }
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         this.field_220825_c = DakotaraptorEntity.this.rand.nextInt(140);
         DakotaraptorEntity.this.func_213499_en();
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.setSitting(false);
         DakotaraptorEntity.this.setCrouching(false);
         DakotaraptorEntity.this.func_213502_u(false);
         DakotaraptorEntity.this.setJumping(false);
         DakotaraptorEntity.this.setSleeping(true);
         DakotaraptorEntity.this.getNavigator().clearPath();
         DakotaraptorEntity.this.getMoveHelper().setMoveTo(DakotaraptorEntity.this.getPosX(), DakotaraptorEntity.this.getPosY(), DakotaraptorEntity.this.getPosZ(), 0.0D);
      }
   }
   
   class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
 	  public HurtByTargetGoal() {
 		  super(DakotaraptorEntity.this);
 	  }

 	  public void startExecuting() {
 		  super.startExecuting();
 		  if (DakotaraptorEntity.this.isChild()) {
 			  this.alertOthers();
 			  this.resetTask();
 		  }
 	  }

 	  protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
 		  if (mobIn instanceof DakotaraptorEntity && !mobIn.isChild()) {
 			  super.setAttackTarget(mobIn, targetIn);
 		  }
 	  }
   }
   
   class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
       public AttackPlayerGoal() {
          super(DakotaraptorEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
       }

       public boolean shouldExecute() {
          if (DakotaraptorEntity.this.isChild()) {
             return false;
          } else {
             if (super.shouldExecute()) {
                for(DakotaraptorEntity dakotaraptor : DakotaraptorEntity.this.world.getEntitiesWithinAABB(DakotaraptorEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
                   if (dakotaraptor.isChild()) {
                      return true;
                   }
                }
             }

             return false;
          }
       }

       protected double getTargetDistance() {
          return super.getTargetDistance() * 0.5D;
       }
    }
   
   static class LayEggGoal extends MoveToBlockGoal {
	   private final DakotaraptorEntity dakotaraptor;

	   LayEggGoal(DakotaraptorEntity dakotaraptor, double speedIn) {
		   super(dakotaraptor, speedIn, 16);
		   this.dakotaraptor = dakotaraptor;
	   }

	   public boolean shouldExecute() {
		   return this.dakotaraptor.hasEgg() ? super.shouldExecute() : false;
	   }

	   public boolean shouldContinueExecuting() {
		   return super.shouldContinueExecuting() && this.dakotaraptor.hasEgg();
	   }

	   public void tick() {
		   super.tick();
		   BlockPos blockpos = new BlockPos(this.dakotaraptor);
		   if (!this.dakotaraptor.isInWater() && this.getIsAboveDestination()) {
			   if (this.dakotaraptor.isDigging < 1) {
				   this.dakotaraptor.setDigging(true);
			   } else if (this.dakotaraptor.isDigging > 200) {
				   World world = this.dakotaraptor.world;
				   world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
	               world.setBlockState(this.destinationBlock.up(), BlockInit.DAKOTARAPTOR_EGG.getDefaultState().with(DakotaraptorEggBlock.EGGS, Integer.valueOf(this.dakotaraptor.rand.nextInt(4) + 1)), 3);
	               this.dakotaraptor.setHasEgg(false);
	               this.dakotaraptor.setDigging(false);
	               this.dakotaraptor.setInLove(600);
			   }
			   if (this.dakotaraptor.isDigging()) {
				   this.dakotaraptor.isDigging++;
			   }
		   }
	   }

	   protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
		   if (!worldIn.isAirBlock(pos.up())) {
			   return false;
		   } else {
			   Block block = worldIn.getBlockState(pos).getBlock();
			   return block == Blocks.COARSE_DIRT;
		   }
	   }
   }

   class StrollGoal extends MoveThroughVillageAtNightGoal {
      public StrollGoal(int p_i50726_2_, int p_i50726_3_) {
         super(DakotaraptorEntity.this, p_i50726_3_);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         DakotaraptorEntity.this.func_213499_en();
         super.startExecuting();
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return super.shouldExecute() && this.func_220759_g();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return super.shouldContinueExecuting() && this.func_220759_g();
      }

      private boolean func_220759_g() {
         return !DakotaraptorEntity.this.isSleeping() && !DakotaraptorEntity.this.isSitting() && !DakotaraptorEntity.this.isDakotaraptorAggroed() && DakotaraptorEntity.this.getAttackTarget() == null;
      }
   }

   class SwimGoal extends net.minecraft.entity.ai.goal.SwimGoal {
      public SwimGoal() {
         super(DakotaraptorEntity.this);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         super.startExecuting();
         DakotaraptorEntity.this.func_213499_en();
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return DakotaraptorEntity.this.isInWater() && DakotaraptorEntity.this.getSubmergedHeight() > 0.25D || DakotaraptorEntity.this.isInLava();
      }
   }

   public static enum Type {
      RED(0, "red", Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.TAIGA_MOUNTAINS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.GIANT_SPRUCE_TAIGA_HILLS),
      SNOW(1, "snow", Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS);

      private static final DakotaraptorEntity.Type[] field_221088_c = Arrays.stream(values()).sorted(Comparator.comparingInt(DakotaraptorEntity.Type::getIndex)).toArray((p_221084_0_) -> {
         return new DakotaraptorEntity.Type[p_221084_0_];
      });
      private static final Map<String, DakotaraptorEntity.Type> TYPES_BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(DakotaraptorEntity.Type::getName, (p_221081_0_) -> {
         return p_221081_0_;
      }));
      private final int index;
      private final String name;
      private final List<Biome> spawnBiomes;

      private Type(int indexIn, String nameIn, Biome... spawnBiomesIn) {
         this.index = indexIn;
         this.name = nameIn;
         this.spawnBiomes = Arrays.asList(spawnBiomesIn);
      }

      public String getName() {
         return this.name;
      }

      public List<Biome> getSpawnBiomes() {
         return this.spawnBiomes;
      }

      public int getIndex() {
         return this.index;
      }

      public static DakotaraptorEntity.Type getTypeByName(String nameIn) {
         return TYPES_BY_NAME.getOrDefault(nameIn, RED);
      }

      public static DakotaraptorEntity.Type getTypeByIndex(int indexIn) {
         if (indexIn < 0 || indexIn > field_221088_c.length) {
            indexIn = 0;
         }

         return field_221088_c[indexIn];
      }

      /**
       * Gets the type of fox that can spawn in this biome. The default type is red fox.
       */
      public static DakotaraptorEntity.Type getTypeByBiome(Biome biomeIn) {
         return SNOW.getSpawnBiomes().contains(biomeIn) ? SNOW : RED;
      }
   }

   class WatchGoal extends LookAtGoal {
      public WatchGoal(MobEntity p_i50733_2_, Class<? extends LivingEntity> p_i50733_3_, float p_i50733_4_) {
         super(p_i50733_2_, p_i50733_3_, p_i50733_4_);
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return super.shouldExecute() && !DakotaraptorEntity.this.isStuck() && !DakotaraptorEntity.this.func_213467_eg();
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return super.shouldContinueExecuting() && !DakotaraptorEntity.this.isStuck() && !DakotaraptorEntity.this.func_213467_eg();
      }
   }
}