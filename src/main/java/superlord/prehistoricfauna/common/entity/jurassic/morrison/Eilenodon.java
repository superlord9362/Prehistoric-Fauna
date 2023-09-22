package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.EnumSet;
import java.util.function.Predicate;

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
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.NocturnalSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Eilenodon extends DinosaurEntity {
	private static final EntityDataAccessor<Byte> EILENODON_FLAGS = SynchedEntityData.defineId(Eilenodon.class, EntityDataSerializers.BYTE);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.HORSETAIL.get().asItem());
	private int maxHunger = 10;

	@SuppressWarnings("deprecation")
	public Eilenodon(EntityType<? extends Eilenodon> type, Level level) {
		super(type, level);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.125F;
		else return 0.25F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(EILENODON_FLAGS, (byte)0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Sitting", this.isSitting());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setSitting(compound.getBoolean("Sitting"));
	}

	private void setEilenodonFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.entityData.set(EILENODON_FLAGS, (byte)(this.entityData.get(EILENODON_FLAGS) | p_213505_1_));
		} else {
			this.entityData.set(EILENODON_FLAGS, (byte)(this.entityData.get(EILENODON_FLAGS) & ~p_213505_1_));
		}
	}

	private boolean getEilenodonFlag(int p_213507_1_) {
		return (this.entityData.get(EILENODON_FLAGS) & p_213507_1_) != 0;
	}

	public boolean isSitting() {
		return this.getEilenodonFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setEilenodonFlag(1, p_213466_1_);
	}

	public boolean func_213480_dY() {
		return this.getEilenodonFlag(16);
	}

	public void func_213461_s(boolean p_213461_1_) {
		this.setEilenodonFlag(16, p_213461_1_);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dryosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Hesperornithoides.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Thescelosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Exaeretodon.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new Eilenodon.SitAndLookGoal());
		this.goalSelector.addGoal(1, new NocturnalSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
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

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.EILENODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.EILENODON_DEATH;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isBaby()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
	}

	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof Eilenodon) {
				return false;
			} else if (!(p_test_1_ instanceof Chicken) && !(p_test_1_ instanceof Rabbit) && !(p_test_1_ instanceof Monster)) {
				if (p_test_1_ instanceof TamableAnimal) {
					return !((TamableAnimal)p_test_1_).isTame();
				} else if (!(p_test_1_ instanceof Player) || !p_test_1_.isSpectator() && !((Player)p_test_1_).isCreative()) {
					return !p_test_1_.isSleeping() && !p_test_1_.isDiscrete();
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}

	abstract class BaseGoal extends Goal {
		private final TargetingConditions field_220816_b = TargetingConditions.forCombat().range(12.0D).ignoreLineOfSight().selector(Eilenodon.this.new AlertablePredicate());

		private BaseGoal() {

		}

		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(Eilenodon.this.position());
			return !Eilenodon.this.level.canSeeSky(blockpos) && Eilenodon.this.getWalkTargetValue(blockpos) >= 0.0F;
		}

		protected boolean func_220814_h() {
			return !Eilenodon.this.level.getNearbyEntities(LivingEntity.class, this.field_220816_b, Eilenodon.this, Eilenodon.this.getBoundingBox().inflate(12.0D, 6.0D, 12.0D)).isEmpty();
		}

	}

	class SitAndLookGoal extends Eilenodon.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			return Eilenodon.this.getLastHurtByMob() == null && Eilenodon.this.getRandom().nextFloat() < 0.02F && !Eilenodon.this.isAsleep() && Eilenodon.this.getTarget() == null && Eilenodon.this.getNavigation().isDone() && !this.func_220814_h() && !Eilenodon.this.func_213480_dY() && !Eilenodon.this.isCrouching() && level.getDayTime() <= 10 || Eilenodon.this.getLastHurtByMob() == null && Eilenodon.this.getRandom().nextFloat() < 0.02F && !Eilenodon.this.isSleeping() && Eilenodon.this.getTarget() == null && Eilenodon.this.getNavigation().isDone() && !this.func_220814_h() && !Eilenodon.this.func_213480_dY() && !Eilenodon.this.isCrouching() && level.getDayTime() >= 1110 && level.getDayTime() <= 1310 || Eilenodon.this.getLastHurtByMob() == null && Eilenodon.this.getRandom().nextFloat() < 0.02F && !Eilenodon.this.isSleeping() && Eilenodon.this.getTarget() == null && Eilenodon.this.getNavigation().isDone() && !this.func_220814_h() && !Eilenodon.this.func_213480_dY() && !Eilenodon.this.isCrouching() && level.getDayTime() >= 2210;
		}

		public boolean canContinueToUse() {
			return this.field_220822_f == 4;
		}

		public void startExecuting() {
			this.func_220817_j();
			this.field_220822_f = 2 + Eilenodon.this.getRandom().nextInt(3);
			Eilenodon.this.setSitting(true);
			Eilenodon.this.getNavigation().stop();
		}

		public void resetTask() {
			Eilenodon.this.setSitting(false);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}
			Eilenodon.this.getLookControl().setLookAt(Eilenodon.this.getX() + this.field_220819_c, Eilenodon.this.getEyeY(), Eilenodon.this.getZ() + this.field_220820_d, (float)Eilenodon.this.getMaxHeadYRot(), (float)Eilenodon.this.getMaxHeadXRot());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * Eilenodon.this.getRandom().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + Eilenodon.this.getRandom().nextInt(20);
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Eilenodon entity = new Eilenodon(PFEntities.EILENODON.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.EILENODON_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.EILENODON_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.EILENODON_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
