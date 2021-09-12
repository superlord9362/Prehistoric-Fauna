package superlord.prehistoricfauna.common.entities;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class LandSentinelEntity extends MonsterEntity {

	public LandSentinelEntity(EntityType<? extends MonsterEntity> type, World world) {
		super(type, world);
	}

	@Override
	protected void registerGoals() {
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25D, true));
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.ARMOR, 5.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 25.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
	}

	public static boolean isValidLightLevel(IServerWorld worldIn, BlockPos pos, Random randomIn) {
		if (worldIn.getLightFor(LightType.SKY, pos) > randomIn.nextInt(32)) {
			return false;
		} else {
			int i = worldIn.getWorld().isThundering() ? worldIn.getNeighborAwareLightSubtracted(pos, 10) : worldIn.getLight(pos);
			return i <= randomIn.nextInt(8);
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean canSpawn(EntityType<? extends MonsterEntity> type, IServerWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
		if (pos.getY() <= worldIn.getSeaLevel()) {  
			return worldIn.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(worldIn, pos, randomIn) && canSpawnOn(type, worldIn, reason, pos, randomIn);
		} else {
			return false;
		}
	}
	
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.BLOCK_STONE_STEP, 0.15F, 1.0F);
	}

}
