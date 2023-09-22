package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Scutellosaurus extends DinosaurEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.CLATHOPTERIS.get().asItem());
	private int maxHunger = 10;

	@SuppressWarnings("deprecation")
	public Scutellosaurus(EntityType<? extends Scutellosaurus> type, Level world) {
		super(type, world);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLATHOPTERIS.get().asItem();
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.25F;
		else return 0.5F;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.10F));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Citipati>(this, Citipati.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Telmasaurus>(this, Telmasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Velociraptor>(this, Velociraptor.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Hesperornithoides>(this, Hesperornithoides.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Herrerasaurus>(this, Herrerasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ischigualastia>(this, Ischigualastia.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Ankylosaurus.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Pinacosaurus.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Plesiohadros.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Stegosaurus.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Sillosuchus.class, this));
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

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.SCUTELLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SCUTELLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SCUTELLOSAURUS_DEATH;
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
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
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ARMOR, 3);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Scutellosaurus entity = new Scutellosaurus(PFEntities.SCUTELLOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public class FollowHerbivoreGoal extends Goal {
		private final Class<? extends DinosaurEntity> followCreature;
		private final Scutellosaurus scutellosaurus;

		public FollowHerbivoreGoal(Class<? extends DinosaurEntity> followCreature, Scutellosaurus scutellosaurus) {
			this.followCreature = followCreature;
			this.scutellosaurus = scutellosaurus;
		}


		public boolean canUse() {
			List<DinosaurEntity> list = this.scutellosaurus.level.getEntitiesOfClass(DinosaurEntity.class, this.scutellosaurus.getBoundingBox().inflate(10.0D));
			boolean flag = false;
			for (DinosaurEntity dinosaur : list) {
				if (dinosaur.getClass() == this.followCreature) {
					if (dinosaur.getBbWidth() >= 1.5F) {
						flag = true;
						break;
					}
				}
			}
			return flag;
		}

		public boolean isPreemptible() {
			return true;
		}

		public boolean canContinueToUse() {
			return scutellosaurus.getLastHurtByMob() != null;
		}

		public void startExecuting() {

		}

		public void tick() {
			List<DinosaurEntity> list = this.scutellosaurus.level.getEntitiesOfClass(DinosaurEntity.class, this.scutellosaurus.getBoundingBox().inflate(10.0D));
			for (DinosaurEntity dinosaur : list) {
				this.scutellosaurus.getNavigation().moveTo(dinosaur, 1.0D);
			}
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SCUTELLOSAURUS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.SCUTELLOSAURUS_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.SCUTELLOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
