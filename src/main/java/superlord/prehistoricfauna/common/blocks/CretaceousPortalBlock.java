package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDimensions;
import superlord.prehistoricfauna.init.PFParticles;
import superlord.prehistoricfauna.init.SoundInit;
import superlord.prehistoricfauna.world.dimension.CretaceousTeleporter;

/**
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.cache.LoadingCache;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
 */
public class CretaceousPortalBlock extends BreakableBlock {

	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);


	public CretaceousPortalBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
	}

	@Override
	@Deprecated
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		switch(state.get(AXIS)) {
		case Z:
			return Z_AABB;
		case X:
		default:
			return X_AABB;
		}
	}

	public boolean tryToCreatePortal(World world, BlockPos pos) {
		CretaceousPortalBlock.Size cretaceousPortalSize = this.isPortal(world, pos);
		if (cretaceousPortalSize != null && this.canCreatePortalByWorld(world, pos)) {
			cretaceousPortalSize.placePortalBlocks();
			return true;
		} else {
			return false;
		}
	}

	private boolean canCreatePortalByWorld(World world, BlockPos pos) {
		if (world.getDimensionKey() == World.OVERWORLD) {
			return true;
		} else {
			return world.getDimensionKey() == PFDimensions.CRETACEOUS_WORLD ||world.getDimensionKey() == PFDimensions.JURASSIC_WORLD || world.getDimensionKey() == PFDimensions.TRIASSIC_WORLD;
		}
	}

	@Nullable
	public CretaceousPortalBlock.Size isPortal(IWorld world, BlockPos pos) {
		CretaceousPortalBlock.Size cretaceousPortalSizeX = new CretaceousPortalBlock.Size(world, pos, Direction.Axis.X);
		if (cretaceousPortalSizeX.isValid() && cretaceousPortalSizeX.portalBlockCount == 0) {
			return cretaceousPortalSizeX;
		} else {
			CretaceousPortalBlock.Size cretaceousPortalSizeZ = new CretaceousPortalBlock.Size(world, pos, Direction.Axis.Z);
			return cretaceousPortalSizeZ.isValid() && cretaceousPortalSizeZ.portalBlockCount == 0 ? cretaceousPortalSizeZ : null;
		}
	}

	@Override
	@Deprecated
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		Direction.Axis directionAxis = facing.getAxis();
		Direction.Axis directionAxis1 = state.get(AXIS);
		boolean flag = directionAxis1 != directionAxis && directionAxis.isHorizontal();
		return !flag && facingState.getBlock() != this && !(new CretaceousPortalBlock.Size(world, currentPos, directionAxis1)).canCreatePortal() ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
	}
	
	protected void updateNeighbors(World worldIn, BlockPos pos) {
		worldIn.notifyNeighborsOfStateChange(pos, this);
	}

	@Override
	@Deprecated
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (!entity.isPassenger() && !entity.isBeingRidden() && entity.isNonBoss() ) {
			if (entity.func_242280_ah() ) {
				entity.func_242279_ag();
			} else {
				if (!entity.world.isRemote() && !pos.equals(entity.field_242271_ac)) {
					entity.field_242271_ac = pos.toImmutable();
				}
				if (entity.world instanceof ServerWorld) {
					ServerWorld serverWorld = (ServerWorld)entity.world;
					MinecraftServer minecraftServer = serverWorld.getServer();
					RegistryKey<World> registryKey = entity.world.getDimensionKey() == PFDimensions.CRETACEOUS_WORLD ? World.OVERWORLD : PFDimensions.CRETACEOUS_WORLD;
					ServerWorld serverWorld1 = minecraftServer.getWorld(registryKey);
					if (serverWorld1 != null && !entity.isPassenger()) {
						entity.func_242279_ag();
						entity.changeDimension(serverWorld1, new CretaceousTeleporter(serverWorld1));
					}
				}
			}
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
		if (rand.nextInt(100) == 0) {
			world.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundInit.PORTAL, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
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

	@Override
	@Deprecated
	public BlockState rotate(BlockState state, Rotation rot) {
		switch(rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch(state.get(AXIS)) {
			case Z:
				return state.with(AXIS, Direction.Axis.X);
			case X:
				return state.with(AXIS, Direction.Axis.Z);
			default:
				return state;
			}
		default:
			return state;
		}
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	public static class Size {
		private final IWorld world;
		private final Direction.Axis axis;
		private final Direction rightDir;
		private int portalBlockCount;
		private BlockPos bottomLeft;
		private int height;
		private int width;
		private static final IPositionPredicate FRAME_TEST = (state, reader, pos) -> state.getBlock() == PFBlocks.PORTAL_FRAME;
		private final Block PORTAL = PFBlocks.CRETACEOUS_PORTAL.get();

		public Size(IWorld world, BlockPos pos, Direction.Axis facing) {
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
			while (pos.getY() > i && isEmptyBlock(this.world.getBlockState(pos.down()))) {
				pos = pos.down();
			}
			Direction direction = this.rightDir.getOpposite();
			int j = this.getDistanceUntilEdge(pos, direction) - 1;
			return j < 0 ? null : pos.offset(direction, j);
		}

		private int getDistanceUntilEdge(BlockPos pos, Direction facing) {
			BlockPos.Mutable mutable = new BlockPos.Mutable();
			for (int i = 0; i < 22; ++i) {
				mutable.setPos(pos).move(facing, i);
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
			BlockPos.Mutable mutable = new BlockPos.Mutable();
			int dist = this.getDistanceUntilTop(mutable);
			return dist >= 3 && dist <= 21 && hasTopFrame(mutable, dist) ? dist : 0;
		}

		private int getDistanceUntilTop(BlockPos.Mutable mutable) {
			for (int i = 0; i < 21; ++i) {
				mutable.setPos(bottomLeft).move(Direction.UP, i).move(rightDir, -1);
				if (!FRAME_TEST.test(this.world.getBlockState(mutable), this.world, mutable)) {
					return i;
				}
				mutable.setPos(bottomLeft).move(Direction.UP, i).move(rightDir, width);
				if (!FRAME_TEST.test(this.world.getBlockState(mutable), this.world, mutable)) {
					return i;
				}
				for (int j = 0; j < width; ++j) {
					mutable.setPos(bottomLeft).move(Direction.UP, i).move(rightDir, j);
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

		private boolean hasTopFrame(BlockPos.Mutable mutable, int offset) {
			for (int i = 0; i < this.width; i++) {
				BlockPos.Mutable mutablePos = mutable.setPos(bottomLeft).move(Direction.UP, offset).move(rightDir, i);
				if (!FRAME_TEST.test(this.world.getBlockState(mutablePos), world, mutablePos)) {
					return false;
				}
			}
			return true;
		}

		@SuppressWarnings("deprecation")
		private boolean isEmptyBlock(BlockState state) {
			Block block = state.getBlock();
			return state.isAir() || block == PFBlocks.CRETACEOUS_TIME_BLOCK || block == PORTAL;
		}

		public boolean isValid() {
			return bottomLeft != null && width >= 3 && width <= 21 && height >= 3 && this.height <= 21;
		}

		public void placePortalBlocks() {
			BlockState state = PORTAL.getDefaultState().with(CretaceousPortalBlock.AXIS, this.axis);
			BlockPos.getAllInBoxMutable(bottomLeft, bottomLeft.offset(Direction.UP, height -1).offset(rightDir, width - 1)).forEach((pos) -> {
				this.world.setBlockState(pos, state, 18);
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
