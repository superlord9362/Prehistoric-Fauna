package superlord.prehistoricfauna.common.entity.henos;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class LandSentinel extends Monster {

	@SuppressWarnings("deprecation")
	public LandSentinel(EntityType<? extends Monster> type, Level world) {
		super(type, world);
		this.maxUpStep = 1.0F;
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

	public static boolean isValidLightLevel(ServerLevelAccessor worldIn, BlockPos pos, Random randomIn) {
		if (worldIn.getBrightness(LightLayer.SKY, pos) > randomIn.nextInt(32)) {
			return false;
		} else {
			int i = worldIn.getLevel().isThundering() ? worldIn.getMaxLocalRawBrightness(pos, 10) : worldIn.getMaxLocalRawBrightness(pos);
			return i <= randomIn.nextInt(8);
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean canSpawn(EntityType<LandSentinel> batIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random randomIn) {
		if (pos.getY() <= worldIn.getSeaLevel()) {  
			return worldIn.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(worldIn, pos, randomIn) && checkMobSpawnRules(batIn, worldIn, reason, pos, randomIn) && worldIn.getLevel().isNight();
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

		public boolean canContinueToUse() {
			float f = this.mob.getBrightness();
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

}
