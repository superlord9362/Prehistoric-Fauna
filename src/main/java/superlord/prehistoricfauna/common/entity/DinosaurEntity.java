package superlord.prehistoricfauna.common.entity;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

public class DinosaurEntity extends TamableAnimal {
	private static final EntityDataAccessor<Boolean> HAS_BABY = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_BIRTHING = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ATTACK_DIR = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private float sleepProgress = 0.0F;
    private float prevSleepProgress = 0.0F;
    private float meleeProgress = 0.0F;
    private float prevMeleeProgress = 0.0F;
	public int isBirthing;
	int loveTick = 0;
	public int maxHunger;
	private int lastInLove = 0;
	public int currentHunger;
	int hungerTick = 0;
	public Random random = new Random();
	
	protected DinosaurEntity(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
	}
	
	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
        return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
    }

    public boolean isAsleep() {
        return this.entityData.get(ASLEEP);
    }

    public void setAsleep(boolean isAsleep) {
        this.entityData.set(ASLEEP, isAsleep);
    }
    
    public boolean isEating() {
		return this.entityData.get(EATING);
	}

	public void setEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
	}
	
	public boolean isAlbino() {
		return this.entityData.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.entityData.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.entityData.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.entityData.set(MELANISTIC, isMelanistic);
	}
	
	public boolean hasBaby() {
		return this.entityData.get(HAS_BABY);
	}

	public void setHasBaby(boolean hasBaby) {
		this.entityData.set(HAS_BABY, hasBaby);
	}

	public boolean isBirthing() {
		return this.entityData.get(IS_BIRTHING);
	}

	public void setBirthing(boolean isBirthing) {
		this.isBirthing = isBirthing ? 1 : 0;
		this.entityData.set(IS_BIRTHING, isBirthing);
	}
	
	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}

	public void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ASLEEP, false);
        this.entityData.define(ATTACK_TICK, 0);
        this.entityData.define(ATTACK_DIR, false);
        this.entityData.define(EATING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(HAS_BABY, false);
		this.entityData.define(IS_BIRTHING, false);
		this.entityData.define(NATURAL_LOVE, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsAsleep", this.isAsleep());
        compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putBoolean("HasBaby", this.hasBaby());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setAsleep(compound.getBoolean("IsAsleep"));
        this.setEating(compound.getBoolean("IsEating"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHasBaby(compound.getBoolean("HasBaby"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
    }
    
    @Override
	public void aiStep() {
		super.aiStep();
		if (!this.isNoAi()) {
			List<? extends DinosaurEntity> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isBaby() || hungerTick == 300 && this.isBaby()) {
					if (!this.isAsleep()) {
						if (currentHunger != 0) {
							this.setHunger(currentHunger - 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && this.getHealth() > (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && level.getDifficulty() == Difficulty.HARD && this.getHealth() <= (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
					}
					hungerTick = 0;
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0  && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 20) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLoveTime(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if ((PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && !PrehistoricFaunaConfig.advancedHunger) {
				int naturalBreedingChance = random.nextInt(1000);

				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 20) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLoveTime(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveNaturally(false);
				}
			}
			if (lastInLove != 0) {
				lastInLove--;
			}
		}
    }
    
    public void tick() {
        super.tick();
        prevSleepProgress = sleepProgress;
        prevMeleeProgress = meleeProgress;
        if (this.isAsleep() && sleepProgress < 1.0F) {
            sleepProgress = Math.min(sleepProgress + 0.2F, 1.0F);
        }
        if (!this.isAsleep() && sleepProgress > 0.0F) {
            sleepProgress = Math.max(sleepProgress - 0.2F, 0.0F);
        }
        if (this.entityData.get(ATTACK_TICK) > 0) {
            LivingEntity target = this.getTarget();
            if (this.entityData.get(ATTACK_TICK) == 1 && target != null && this.hasLineOfSight(target) && this.distanceTo(target) < this.getMeleeRange() + this.getBbWidth() + target.getBbWidth()) {
                this.onAttackAnimationFinish(target);
            }
            this.entityData.set(ATTACK_TICK, this.entityData.get(ATTACK_TICK) - 1);
            if (meleeProgress < 1.0F) {
                meleeProgress = Math.min(meleeProgress + 0.2F, 1.0F);
            }
        } else {
            if (meleeProgress > 0F) {
                meleeProgress = Math.max(meleeProgress - 0.2F, 0.0F);
            }
        }
    }
    
    //additional melee range, change this for dinosaurs with longer reach
    public float getMeleeRange() {
        return 1.5F;
    }

    //some dinosaurs(ex. ankylosaurus) have alternate attack patterns that have left/right differences. This boolean is true if the current melee attack is coming from the left and false if from the right.
    public boolean getMeleeDirection() {
        return this.entityData.get(ATTACK_DIR);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(this.entityData.get(ATTACK_TICK) == 0){
            this.entityData.set(ATTACK_DIR, random.nextBoolean());
        }
        //now simply starts counting down till the actual damage is done, starts the animation
        this.entityData.set(ATTACK_TICK, 7);
        return true;
    }

    public boolean onAttackAnimationFinish(Entity target) {
        return target.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
    }

    //lerped number from 0.0 - 1.0 that determines where in the sleep animation this entity is
    public float getSleepProgress(float partialTick) {
        return prevSleepProgress + (sleepProgress - prevSleepProgress) * partialTick;
    }

    //lerped number from 0.0 - 1.0 that determines where in the melee animation this entity is
    public float getMeleeProgress(float partialTick) {
        return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
        return null;
    }
    
    @Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Random random = new Random();
		int birthNumber = random.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(maxHunger);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
    
    public Item getEggItem() {
		return null;
	}
    
    public BlockState getEggBlock() {
    	return null;
    }

}
