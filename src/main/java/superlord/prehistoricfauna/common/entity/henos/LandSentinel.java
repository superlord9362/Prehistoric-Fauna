package superlord.prehistoricfauna.common.entity.henos;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.init.PFItems;

public class LandSentinel extends Monster {

	public LandSentinel(EntityType<? extends Monster> type, Level world) {
		super(type, world);
		this.setMaxUpStep(1);
	}
	
	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.FALL) || source.is(DamageTypes.DROWN) || source.is(DamageTypes.FIREBALL) || source.is(DamageTypes.UNATTRIBUTED_FIREBALL) || source.is(DamageTypes.SWEET_BERRY_BUSH) || source.is(DamageTypes.CACTUS) || source.is(DamageTypes.FALLING_ANVIL) || source.is(DamageTypes.FALLING_BLOCK) || source.is(DamageTypes.FALLING_STALACTITE) || source.is(DamageTypes.FREEZE) || source.is(DamageTypes.HOT_FLOOR) || source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.LAVA) || source.is(DamageTypes.LIGHTNING_BOLT) || source.is(DamageTypes.MAGIC) || source.is(DamageTypes.STALAGMITE)) {
			return false;
		} else return super.hurt(source, amount);
	}

	@Override
	protected void registerGoals() {
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new MeleeAttackGoal());
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 5.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
	}

	public static boolean isValidLightLevel(ServerLevelAccessor worldIn, BlockPos pos, RandomSource randomIn) {
		if (worldIn.getBrightness(LightLayer.SKY, pos) > randomIn.nextInt(32)) {
			return false;
		} else {
			int i = worldIn.getLevel().isThundering() ? worldIn.getMaxLocalRawBrightness(pos, 10) : worldIn.getMaxLocalRawBrightness(pos);
			return i <= randomIn.nextInt(8);
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean canSpawn(EntityType<LandSentinel> batIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		if (pos.getY() >= worldIn.getSeaLevel()) {  
			return worldIn.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(worldIn, pos, randomIn) && checkMobSpawnRules(batIn, worldIn, reason, pos, randomIn) && worldIn.getLevel().isNight() && randomIn.nextFloat() > 0.95F;
		} else {
			return false;
		}
	}
	
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.STONE_STEP, 0.15F, 1.0F);
	}
	
	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(LandSentinel.this, 1.25D, true);
		}

		@SuppressWarnings("deprecation")
		public boolean canContinueToUse() {
			float f = this.mob.getLightLevelDependentMagicValue();
			if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
				this.mob.setTarget((LivingEntity)null);
				return false;
			} else {
				return super.canContinueToUse();
			}
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(6F + attackTarget.getBbWidth());
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.LAND_SENTINEL_SPAWN_EGG.get());
	}

}
