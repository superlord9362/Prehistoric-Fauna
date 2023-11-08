package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.models.blockstates.VariantProperties.Rotation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.teleporter.JurassicTeleporter;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDimensions;
import superlord.prehistoricfauna.init.PFParticles;
import superlord.prehistoricfauna.init.PFSounds;

public class JurassicPortalBlock extends Block {

	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);


	public JurassicPortalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}
	
	protected void updateNeighbors(Level worldIn, BlockPos pos) {
		worldIn.updateNeighborsAt(pos, this);
	}

	@Override
	@Deprecated
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(AXIS) == Direction.Axis.Z ? Z_AABB : X_AABB;
	}

	public boolean tryToCreatePortal(Level world, BlockPos pos) {
		JurassicPortalBlock.Size jurassicPortalSize = this.isPortal(world, pos);
		if (jurassicPortalSize != null && this.canCreatePortalByWorld(world, pos)) {
			jurassicPortalSize.placePortalBlocks();
			return true;
		} else {
			return false;
		}
	}

	private boolean canCreatePortalByWorld(Level world, BlockPos pos) {
		if (world.dimension() == Level.OVERWORLD) {
			return true;
		} else {
			return world.dimension() == PFDimensions.JURASSIC;
		}
	}

	@Nullable
	public JurassicPortalBlock.Size isPortal(LevelAccessor world, BlockPos pos) {
		JurassicPortalBlock.Size jurassicPortalSizeX = new JurassicPortalBlock.Size(world, pos, Direction.Axis.X);
		if (jurassicPortalSizeX.isValid() && jurassicPortalSizeX.portalBlockCount == 0) {
			return jurassicPortalSizeX;
		} else {
			JurassicPortalBlock.Size jurassicPortalSizeZ = new JurassicPortalBlock.Size(world, pos, Direction.Axis.Z);
			return jurassicPortalSizeZ.isValid() && jurassicPortalSizeZ.portalBlockCount == 0 ? jurassicPortalSizeZ : null;
		}
	}

	@Override
	@Deprecated
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		Direction.Axis directionAxis = facing.getAxis();
		Direction.Axis directionAxis1 = stateIn.getValue(AXIS);
		boolean flag = directionAxis1 != directionAxis && directionAxis.isHorizontal();
		return !flag && facingState.getBlock() != this && !(new JurassicPortalBlock.Size(worldIn, currentPos, directionAxis1)).canCreatePortal() ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	@Deprecated
	public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
		if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() ) {
			if (entity.isOnPortalCooldown() ) {
				entity.setPortalCooldown();
			} else {
				if (!entity.level.isClientSide() && !pos.equals(entity.portalEntrancePos)) {
					entity.portalEntrancePos  = pos.immutable();
				}
				if (entity.level instanceof ServerLevel) {
					ServerLevel serverWorld = (ServerLevel)entity.level;
					MinecraftServer minecraftServer = serverWorld.getServer();
					ResourceKey<Level> registryKey = entity.level.dimension() == PFDimensions.JURASSIC ? Level.OVERWORLD : PFDimensions.JURASSIC;
					ServerLevel serverWorld1 = minecraftServer.getLevel(registryKey);
					if (serverWorld1 != null && !entity.isPassenger()) {
						entity.setPortalCooldown();
						entity.changeDimension(serverWorld1, new JurassicTeleporter(serverWorld1));
					}
				}
			}
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
		if (rand.nextInt(100) == 0) {
			world.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, PFSounds.PORTAL, SoundSource.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int i = 0; i < 2; ++i) {
			double x = (float)pos.getX() + rand.nextFloat();
			double y = (float)pos.getY() + rand.nextFloat();
			double z = (float)pos.getZ() + rand.nextFloat();
			double sX = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			double sY = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			double sZ = ((double)rand.nextFloat() - 0.5D) * 0.5D;
			int mul = rand.nextInt(2) * 2 - 1;
			if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
				x = (double)pos.getX() + 0.5D + 0.25D * (double)mul;
				sX = rand.nextFloat() * 2.0F * (float)mul;
			} else {
				z = (double)pos.getZ() + 0.5D + 0.25D * (double)mul;
				sZ = rand.nextFloat() * 2.0F * (float)mul;
			}
			world.addParticle(PFParticles.PORTAL_PARTICLE, x, y, z, sX, sY, sZ);
		}
	}

	@Deprecated
    public BlockState rotate(BlockState state, Rotation rot) {
		return switch (rot) {
        case R270, R90 -> switch (state.getValue(AXIS)) {
            case Z -> state.setValue(AXIS, Direction.Axis.X);
            case X -> state.setValue(AXIS, Direction.Axis.Z);
            default -> state;
        };
        default -> state;
    };
	}

	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	public static class Size {
		private final LevelAccessor world;
		private final Direction.Axis axis;
		private final Direction rightDir;
		private int portalBlockCount;
		private BlockPos bottomLeft;
		private int height;
		private int width;
		private static final StatePredicate FRAME_TEST = (state, reader, pos) -> state.getBlock() == PFBlocks.PORTAL_FRAME.get();
		private final Block PORTAL = PFBlocks.JURASSIC_PORTAL.get();

		public Size(LevelAccessor world, BlockPos pos, Direction.Axis facing) {
			this.world = world;
			axis = facing;
			rightDir = facing == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
			bottomLeft = calculateBottomLeft(pos);
			if (bottomLeft == null) {
				bottomLeft = pos;
				width = 1;
				height = 1;
			} else {
				width = calculatePortalWidth();
				if (width > 0) {
					height = calculatePortalHeight();
				}
			}
		}

		@Nullable
		private BlockPos calculateBottomLeft(BlockPos pos) {
			int i = Math.max(0, pos.getY() - 21);
			while (pos.getY() > i && isEmptyBlock(this.world.getBlockState(pos.below()))) {
				pos = pos.below();
			}
			Direction direction = this.rightDir.getOpposite();
			int j = this.getDistanceUntilEdge(pos, direction) - 1;
			return j < 0 ? null : pos.relative(direction, j);
		}

		private int getDistanceUntilEdge(BlockPos pos, Direction facing) {
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
			for (int i = 0; i < 22; ++i) {
				mutable.set(pos).move(facing, i);
				BlockState state = this.world.getBlockState(mutable);
				if (!isEmptyBlock(state)) {
					if (FRAME_TEST.test(state, world, mutable)) {
						return i;
					}
					break;
				}
				BlockState state1 = this.world.getBlockState(mutable.move(Direction.DOWN));
				if (!FRAME_TEST.test(state1, world, mutable)) {
					break;
				}
			}
			return 0;
		}

		private int calculatePortalWidth() {
			int dist = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
			return dist >= 3 && dist <= 21 ? dist : 0;
		}

		private int calculatePortalHeight() {
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
			int dist = this.getDistanceUntilTop(mutable);
			return dist >= 3 && dist <= 21 && hasTopFrame(mutable, dist) ? dist : 0;
		}

		private int getDistanceUntilTop(BlockPos.MutableBlockPos mutable) {
			for (int i = 0; i < 21; ++i) {
				mutable.set(bottomLeft).move(Direction.UP, i).move(rightDir, -1);
				if (!FRAME_TEST.test(this.world.getBlockState(mutable), this.world, mutable)) {
					return i;
				}
				mutable.set(bottomLeft).move(Direction.UP, i).move(rightDir, width);
				if (!FRAME_TEST.test(this.world.getBlockState(mutable), this.world, mutable)) {
					return i;
				}
				for (int j = 0; j < width; ++j) {
					mutable.set(bottomLeft).move(Direction.UP, i).move(rightDir, j);
					BlockState blockstate = world.getBlockState(mutable);
					if (!isEmptyBlock(blockstate)) {
						return i;
					}
					if (blockstate.getBlock() == PORTAL) {
						++this.portalBlockCount;
					}
				}
			}
			return 21;
		}

		private boolean hasTopFrame(BlockPos.MutableBlockPos mutable, int offset) {
			for (int i = 0; i < this.width; i++) {
				BlockPos.MutableBlockPos mutablePos = mutable.set(bottomLeft).move(Direction.UP, offset).move(rightDir, i);
				if (!FRAME_TEST.test(this.world.getBlockState(mutablePos), world, mutablePos)) {
					return false;
				}
			}
			return true;
		}

		private boolean isEmptyBlock(BlockState state) {
			Block block = state.getBlock();
			return state.isAir() || block == PFBlocks.JURASSIC_TIME_BLOCK.get() || block == PORTAL;
		}

		public boolean isValid() {
			return bottomLeft != null && width >= 3 && width <= 21 && height >= 3 && this.height <= 21;
		}

		public void placePortalBlocks() {
			BlockState state = PORTAL.defaultBlockState().setValue(JurassicPortalBlock.AXIS, this.axis);
			BlockPos.betweenClosed(bottomLeft, bottomLeft.relative(Direction.UP, height -1).relative(rightDir, width - 1)).forEach((pos) -> {
				this.world.setBlock(pos, state, 18);
			});
		}

		public boolean canCreatePortal() {
			return this.isValid() && this.isLargeEnough();
		}

		private boolean isLargeEnough() {
			return this.portalBlockCount == this.width * this.height;
		}

	}

}
