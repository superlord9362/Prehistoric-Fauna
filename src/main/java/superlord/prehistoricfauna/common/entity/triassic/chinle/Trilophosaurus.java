package superlord.prehistoricfauna.common.entity.triassic.chinle;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Trilophosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Trilophosaurus.class, EntityDataSerializers.BYTE);
	private int maxHunger = 25;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	@SuppressWarnings("deprecation")
	public Trilophosaurus(EntityType<? extends TamableAnimal> type, Level levelIn) {
		super(type, levelIn);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected PathNavigation createNavigation(Level levelIn) {
		return new WallClimberNavigation(this, levelIn);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.NEOCALAMITES.get().asItem();
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CLIMBING, (byte)0);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.TRILOPHOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TRILOPHOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TRILOPHOSAURUS_DEATH;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setSkittish(true);
		} else {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isBaby()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(5);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
	}

	public void tick() {
		super.tick();
		if (!this.level.isClientSide) {
			if (this.horizontalCollision) {
				Boolean logBlock;
				BlockPos blockpos1 = new BlockPos(this.position().x() + 1, this.position().y() + 1, this.position().z());
				BlockPos blockpos2 = new BlockPos(this.position().x() - 1, this.position().y() + 1, this.position().z());
				BlockPos blockpos3 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() + 1);
				BlockPos blockpos4 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() - 1);
				BlockState blockstate1 = this.level.getBlockState(blockpos1);
				BlockState blockstate2 = this.level.getBlockState(blockpos2);
				BlockState blockstate3 = this.level.getBlockState(blockpos3);
				BlockState blockstate4 = this.level.getBlockState(blockpos4);
				if (blockstate1.is(PFBlocks.NEOCALAMITES.get()) || blockstate1.is(PFBlocks.NEOCALAMITES_TOP.get())|| blockstate2.is(PFBlocks.NEOCALAMITES.get()) || blockstate2.is(PFBlocks.NEOCALAMITES_TOP.get()) || blockstate3.is(PFBlocks.NEOCALAMITES.get()) || blockstate3.is(PFBlocks.NEOCALAMITES_TOP.get()) || blockstate4.is(PFBlocks.NEOCALAMITES.get()) || blockstate4.is(PFBlocks.NEOCALAMITES_TOP.get())) {
					logBlock = true;
					if (climbingTickCooldown == 0 && climbingTicks < 600) {
						this.setBesideClimbableBlock(logBlock);
						climbingTicks++;
					}
					if (climbingTicks >= 599 && climbingTickCooldown <= 300) {
						climbingTickCooldown++;
					}
					if (climbingTickCooldown == 300) {
						climbingTicks = 0;
						climbingTickCooldown = 0;
					}
				}
			}
		}

	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (this.entityData.get(CLIMBING) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.entityData.get(CLIMBING);
		if (climbing) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.entityData.set(CLIMBING, b0);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.23D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Trilophosaurus entity = new Trilophosaurus(PFEntities.TRILOPHOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.TRILOPHOSAURUS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.TRILOPHOSAURUS_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.TRILOPHOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
