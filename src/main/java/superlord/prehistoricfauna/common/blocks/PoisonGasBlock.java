package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class PoisonGasBlock extends Block {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;
	public static final int MAX_AGE = 15;

	public PoisonGasBlock(Properties p_48756_) {
		super(p_48756_);
	}

	public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity livingEntity) {
			int age = state.getValue(AGE);
			if (pos.getY() == livingEntity.eyeBlockPosition().getY()) {
				if (livingEntity instanceof Player player) {
					if (!player.getAbilities().instabuild) {
						if (age < 3) {
							livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30));
						}
						if (age < 6 && age >= 3) {
							livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 30));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30));
						}
						if (age < 9 && age >= 6) {
							livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 1));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 30, 1));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30, 1));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 1));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 30, 1));
						}
						if (age >= 9) {
							livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 2));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 2));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 30, 2));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30, 2));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 2));
							livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 30, 2));
							livingEntity.hurt(DamageSource.IN_WALL, 1.0F);
						}
					}
				} else {
					if (age < 3) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30));
					}
					if (age < 6 && age >= 3) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 30));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30));
					}
					if (age < 9 && age >= 6) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 1));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 30, 1));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30, 1));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 1));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 30, 1));
					}
					if (age >= 9) {
						livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 2));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 2));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 30, 2));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 30, 2));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 2));
						livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 30, 2));
						livingEntity.hurt(DamageSource.IN_WALL, 1.0F);
					}
				}
			}
		}
	}

	protected int getNumGasBlocksBelow(BlockGetter worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 4 && worldIn.getBlockState(pos.below(i + 1)).is(this); ++i) {
		}
		return i;
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if (!world.isAreaLoaded(pos, 1)) return;
		if (!world.getBlockState(pos.below()).isSolidRender(world, pos.below()) || !world.getBlockState(pos.below()).is(this) || !world.getBlockState(pos.below()).is(Blocks.WATER)) {
			world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		}
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
		BlockPos abovePos = pos.above();
		BlockPos northPos = pos.north();
		BlockPos southPos = pos.south();
		BlockPos eastPos = pos.east();
		BlockPos westPos = pos.west();
		int expandOrDelete = level.random.nextInt(82);
		int age = state.getValue(AGE);
		if (!level.isAreaLoaded(pos, 1)) return;
		else {
			if (age < MAX_AGE) {
				if (level.isEmptyBlock(abovePos) && (expandOrDelete < 3) && getNumGasBlocksBelow(level, pos) <= 3) {
					level.setBlockAndUpdate(abovePos, state.setValue(AGE, Math.min(random.nextInt(MAX_AGE), MAX_AGE)));
				}
				if (level.isEmptyBlock(northPos) && (level.getBlockState(northPos.below()).isSolidRender(level, northPos.below()) || level.getBlockState(northPos.below()).is(this) || level.getBlockState(northPos.below()).is(Blocks.WATER)) && expandOrDelete >= 3 && expandOrDelete < 23) {
					level.setBlockAndUpdate(northPos, state.setValue(AGE, Math.min(random.nextInt(MAX_AGE), MAX_AGE)));
				}
				if (level.isEmptyBlock(southPos) && (level.getBlockState(southPos.below()).isSolidRender(level, southPos.below()) || level.getBlockState(southPos.below()).is(this) || level.getBlockState(southPos.below()).is(Blocks.WATER)) && expandOrDelete >= 23 && expandOrDelete < 43) {
					level.setBlockAndUpdate(southPos, state.setValue(AGE, Math.min(random.nextInt(MAX_AGE), MAX_AGE)));
				}
				if (level.isEmptyBlock(eastPos) && (level.getBlockState(eastPos.below()).isSolidRender(level, eastPos.below()) || level.getBlockState(eastPos.below()).is(this) || level.getBlockState(eastPos.below()).is(Blocks.WATER)) && expandOrDelete >= 43 && expandOrDelete < 63) {
					level.setBlockAndUpdate(eastPos, state.setValue(AGE, Math.min(random.nextInt(MAX_AGE), MAX_AGE)));
				}
				if (level.isEmptyBlock(westPos) && (level.getBlockState(westPos.below()).isSolidRender(level, westPos.below()) || level.getBlockState(westPos.below()).is(this) || level.getBlockState(westPos.below()).is(Blocks.WATER)) && expandOrDelete >= 63 && expandOrDelete < 83) {
					level.setBlockAndUpdate(westPos, state.setValue(AGE, Math.min(random.nextInt(MAX_AGE), MAX_AGE)));
				}
			}
			if (age < MAX_AGE) {
				level.setBlockAndUpdate(pos, state.setValue(AGE, Math.min(age + random.nextInt(MAX_AGE), MAX_AGE)));
			}
			if (age == MAX_AGE) {
				level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
			}
		}
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
		state.add(AGE);
	}

	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType pathType) {
		return false;
	}

	public VoxelShape getShape(BlockState p_48760_, BlockGetter p_48761_, BlockPos p_48762_, CollisionContext p_48763_) {
		return Shapes.empty();
	}

}
