package superlord.prehistoricfauna.common.entities;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class DidelphodonEntity extends AnimalEntity {
	
	private static final DataParameter<Boolean> IS_PREGNANT = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_READY = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.CRASSOSTREA_OYSTER.asItem());
	private int isReady;
	
	public DidelphodonEntity(EntityType<? extends DidelphodonEntity> type, World world) {
		super(type, world);
	}
	
	public boolean isPregnant() {
		return this.dataManager.get(IS_PREGNANT);
	}
	
	private void setPregnant(boolean isPregnant) {
		this.dataManager.set(IS_PREGNANT, isPregnant);
	}
	
	public boolean isAlbino() {
		return this.dataManager.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.dataManager.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.dataManager.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.dataManager.set(MELANISTIC, isMelanistic);
	}
	
	public boolean isReady() {
		return this.dataManager.get(IS_READY);
	}
	
	private void setReady(boolean isReady) {
		this.isReady = isReady ? 1 : 0;
		this.dataManager.set(IS_READY, isReady);
	}
	
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.CRASSOSTREA_OYSTER.asItem();
	}
	
	public void registerData() {
		super.registerData();
		this.dataManager.register(IS_PREGNANT, false);
		this.dataManager.register(IS_READY, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
	}
	
	public void writeAddition(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsPregnant", this.isPregnant());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setPregnant(compound.getBoolean("IsPregnant"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
	}
	
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(399);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(2, new DidelphodonEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, PlayerEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DakotaraptorEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AllosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CeratosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CamarasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TriceratopsEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, StegosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ThescelosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DryosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HesperornithoidesEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HerrerasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ExaeretodonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(8, new DidelphodonEntity.CarryYoungGoal(this, 1.0D));
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundInit.DIDELPHODON_IDLE;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundInit.DIDELPHODON_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundInit.DIDELPHODON_DEATH;
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		super.handleStatusUpdate(id);
	}
	
	static class MateGoal extends BreedGoal {
		private final DidelphodonEntity didelphodon;
		
		MateGoal(DidelphodonEntity didelphodon, double speed) {
			super(didelphodon, speed);
			this.didelphodon = didelphodon;
		}
		
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.didelphodon.isPregnant();
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
			this.didelphodon.setPregnant(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
		
	}
	
	abstract class PassiveGoal extends Goal {
		private PassiveGoal() {
		}

		public abstract boolean canDidelphodonStart();

		public abstract boolean canDidelphodonContinue();

		public boolean shouldExecute() {
			return this.canDidelphodonStart();
		}
		
		public boolean shouldContinueExecuting() {
			return this.canDidelphodonContinue();
		}
	}
	
	static class CarryYoungGoal extends Goal {
		private final DidelphodonEntity didelphodon;
		
		CarryYoungGoal(DidelphodonEntity didelphodon, double speed) {
			super();
			this.didelphodon = didelphodon;
		}
		
		public boolean shouldExecute() {
			return this.didelphodon.isPregnant();
		}
		
		public boolean shouldContinueExecuting() {
			return this.didelphodon.isPregnant();
		}
		
		public void tick() {
			super.tick();
			if (!this.didelphodon.isInWater()) {
				if (this.didelphodon.isReady < 1) {
					this.didelphodon.setReady(true);
				} else if (this.didelphodon.isReady > 200) {
					World world = this.didelphodon.world;
					AgeableEntity ageable = new DidelphodonEntity(PFEntities.DIDELPHODON_ENTITY, world);
					ageable.setGrowingAge(-24000);
					world.addEntity(ageable);
					this.didelphodon.setPregnant(false);
					this.didelphodon.setReady(false);
					this.didelphodon.setInLove(600);
				}
				if (this.didelphodon.isReady()) {
					this.didelphodon.isReady++;
				}
			}
		}
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		DidelphodonEntity entity = new DidelphodonEntity(PFEntities.DIDELPHODON_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld)this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

}
