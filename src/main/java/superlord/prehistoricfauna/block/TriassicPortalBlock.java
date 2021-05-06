package superlord.prehistoricfauna.block;

import javax.annotation.Nullable;

import com.google.common.cache.LoadingCache;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.DimensionTypeInit;
import superlord.prehistoricfauna.util.TeleporterTriassic;

public class TriassicPortalBlock extends BreakableBlock {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public TriassicPortalBlock(Properties props) {
        super(props);
		this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(AXIS)) {
            case Z:
                return Z_AABB;
            case X:
            default:
                return X_AABB;
        }
    }

    public boolean tryToCreatePortal(World worldIn, BlockPos pos) {
        TriassicPortalBlock.Size gaiaPortalSize = this.isPortal(worldIn, pos);
        if (gaiaPortalSize != null && this.canCreatePortalByWorld(worldIn, pos)) {
            gaiaPortalSize.placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    // This will check for creation conditions in the Overworld or Gaia
    private boolean canCreatePortalByWorld(World world, BlockPos pos) {
        if (world.getDimension().getType() == DimensionType.OVERWORLD) {
            return true;
        } else {
            return world.getDimension().getType() == DimensionTypeInit.TRIASSIC_DIMENSION_TYPE;
        }
    }

    @Nullable
    public TriassicPortalBlock.Size isPortal(IWorld world, BlockPos pos) {
        TriassicPortalBlock.Size gaiaPortalSizeX = new TriassicPortalBlock.Size(world, pos, Direction.Axis.X);
        if (gaiaPortalSizeX.isValid() && gaiaPortalSizeX.portalBlockCount == 0) {
            return gaiaPortalSizeX;
        } else {
            TriassicPortalBlock.Size gaiaPortalSizeZ = new TriassicPortalBlock.Size(world, pos, Direction.Axis.Z);
            return gaiaPortalSizeZ.isValid() && gaiaPortalSizeZ.portalBlockCount == 0 ? gaiaPortalSizeZ : null;
        }
    }

    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis directionAxis = facing.getAxis();
        Direction.Axis directionAxis1 = stateIn.get(AXIS);
        boolean flag = directionAxis1 != directionAxis && directionAxis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new TriassicPortalBlock.Size(worldIn, currentPos, directionAxis1)).canCreatePortal() ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @Deprecated
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entity) {
        if (!entity.isPassenger() && !entity.isBeingRidden() && entity.isNonBoss()) {
            if (entity.timeUntilPortal > 0) {
                entity.timeUntilPortal = entity.getPortalCooldown();
            } else {
                if (!entity.world.isRemote && !pos.equals(entity.lastPortalPos)) {
                    entity.lastPortalPos = new BlockPos(pos);
                    BlockPattern.PatternHelper helper = createPatternHelper(entity.world, entity.lastPortalPos);
                    double axis = helper.getForwards().getAxis() == Direction.Axis.X ? (double)helper.getFrontTopLeft().getZ() : (double)helper.getFrontTopLeft().getX();
                    double x = Math.abs(MathHelper.pct((helper.getForwards().getAxis() == Direction.Axis.X ? entity.getPosZ() : entity.getPosX()) - (double)(helper.getForwards().rotateY().getAxisDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0), axis, axis - (double)helper.getWidth()));
                    double y = MathHelper.pct(entity.getPosY() - 1.0D, (double)helper.getFrontTopLeft().getY(), (double)(helper.getFrontTopLeft().getY() - helper.getHeight()));
                    entity.lastPortalVec = new Vec3d(x, y, 0.0D);
                    entity.teleportDirection = helper.getForwards();
                }

                if (entity.world instanceof ServerWorld) {
                    if (entity.world.getServer().getAllowNether() && !entity.isPassenger()) {
                        entity.timeUntilPortal = entity.getPortalCooldown();
                        DimensionType type = worldIn.dimension.getType() == DimensionTypeInit.TRIASSIC_DIMENSION_TYPE ? DimensionType.OVERWORLD : DimensionTypeInit.TRIASSIC_DIMENSION_TYPE;
                        entity.changeDimension(type, new TeleporterTriassic());
                    }
                }
            }
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

    @SuppressWarnings("deprecation")
	public static BlockPattern.PatternHelper createPatternHelper(IWorld worldIn, BlockPos pos) {
        Direction.Axis axis = Direction.Axis.Z;
        TriassicPortalBlock.Size size = new TriassicPortalBlock.Size(worldIn, pos, Direction.Axis.X);
        LoadingCache<BlockPos, CachedBlockInfo> cache = BlockPattern.createLoadingCache(worldIn, true);
        if (!size.isValid()) {
            axis = Direction.Axis.X;
            size = new TriassicPortalBlock.Size(worldIn, pos, Direction.Axis.Z);
        }

        if (!size.isValid()) {
            return new BlockPattern.PatternHelper(pos, Direction.NORTH, Direction.UP, cache, 1, 1, 1);
        } else {
            int[] axes = new int[Direction.AxisDirection.values().length];
            Direction direction = size.rightDir.rotateYCCW();
            BlockPos blockpos = size.bottomLeft.up(size.getHeight() - 1);

            for(Direction.AxisDirection axisDir : Direction.AxisDirection.values()) {
                BlockPattern.PatternHelper helper = new BlockPattern.PatternHelper(direction.getAxisDirection() == axisDir ? blockpos : blockpos.offset(size.rightDir, size.getWidth() - 1), Direction.getFacingFromAxis(axisDir, axis), Direction.UP, cache, size.getWidth(), size.getHeight(), 1);

                for(int i = 0; i < size.getWidth(); ++i) {
                    for(int j = 0; j < size.getHeight(); ++j) {
                        CachedBlockInfo cacheInfo = helper.translateOffset(i, j, 1);
                        if (!cacheInfo.getBlockState().isAir()) {
                            ++axes[axisDir.ordinal()];
                        }
                    }
                }
            }

            Direction.AxisDirection axisDirPos = Direction.AxisDirection.POSITIVE;

            for(Direction.AxisDirection axisDir : Direction.AxisDirection.values()) {
                if (axes[axisDir.ordinal()] < axes[axisDirPos.ordinal()]) {
                    axisDirPos = axisDir;
                }
            }

            return new BlockPattern.PatternHelper(direction.getAxisDirection() == axisDirPos ? blockpos : blockpos.offset(size.rightDir, size.getWidth() - 1), Direction.getFacingFromAxis(axisDirPos, axis), Direction.UP, cache, size.getWidth(), size.getHeight(), 1);
        }
    }

    //TODO: If ever the portal changes, update this. Hopefully even remove it
    public static class Size {
        private final IWorld world;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;
        private final Block PORTAL_FRAME = BlockInit.PORTAL_FRAME;
        private final Block PORTAL = BlockInit.TRIASSIC_PORTAL.get();

        public Size(IWorld worldIn, BlockPos pos, Direction.Axis facing) {
            world = worldIn;
            axis = facing;

            if (facing == Direction.Axis.X) {
                leftDir = Direction.EAST;
                rightDir = Direction.WEST;
            } else {
                leftDir = Direction.NORTH;
                rightDir = Direction.SOUTH;
            }

            BlockPos blockpos = pos;
            while (pos.getY() > blockpos.getY() - 21 && pos.getY() > 0 && isEmptyBlock(worldIn.getBlockState(pos.down()))) {
                pos = pos.down();
            }

            int i = getDistanceUntilEdge(pos, leftDir) - 1;

            if (i >= 0) {
                bottomLeft = pos.offset(leftDir, i);
                width = this.getDistanceUntilEdge(bottomLeft, rightDir);

                if (width < 3 || width > 21) {
                    bottomLeft = null;
                    width = 0;
                }
            }

            if (this.bottomLeft != null) {
                height = calculatePortalHeight();
            }
        }

        int getDistanceUntilEdge(BlockPos pos, Direction facing) {
            int i;

            for (i = 0; i < 22; ++i) {
                BlockPos blockpos = pos.offset(facing, i);

                if (!isEmptyBlock(world.getBlockState(blockpos)) || world.getBlockState(blockpos.down()) != PORTAL_FRAME.getDefaultState()) {
                    break;
                }
            }

            Block block = world.getBlockState(pos.offset(facing, i)).getBlock();
            return block == PORTAL_FRAME ? i : 0;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        int calculatePortalHeight() {
            label56:

            for (height = 0; height < 21; ++height) {
                for (int i = 0; i < width; ++i) {
                    BlockPos blockpos = bottomLeft.offset(rightDir, i).up(height);
                    BlockState blockstate = world.getBlockState(blockpos);

                    if (!isEmptyBlock(blockstate)) {
                        break label56;
                    }

                    if (blockstate.getBlock() == PORTAL) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        blockstate = world.getBlockState(blockpos.offset(leftDir));

                        if (blockstate != PORTAL_FRAME.getDefaultState()) {
                            break label56;
                        }
                    } else if (i == this.width) {
                        blockstate = world.getBlockState(blockpos.offset(rightDir));

                        if (blockstate != PORTAL_FRAME.getDefaultState()) {
                            break label56;
                        }
                    }
                }
            }

            for (int j = 0; j < width; ++j) {
                if (world.getBlockState(bottomLeft.offset(rightDir, j).up(height)) != PORTAL_FRAME.getDefaultState()) {
                    height = 0;
                    break;
                }
            }

            if (height <= 21 && height >= 3) {
                return height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        @SuppressWarnings("deprecation")
		boolean isEmptyBlock(BlockState state) {
            Block block = state.getBlock();

            return state.isAir() || block == BlockInit.TRIASSIC_TIME_BLOCK || block == PORTAL;
        }

        public boolean isValid() {
            return bottomLeft != null && width >= 3 && width <= 21 && height >= 3 && this.height <= 21;
        }

        void placePortalBlocks() {
            for (int i = 0; i < this.width; ++i) {
                BlockPos blockpos = bottomLeft.offset(rightDir, i);

                for (int j = 0; j < height; ++j) {
                    world.setBlockState(blockpos.up(j), PORTAL.getDefaultState().with(AXIS, axis), 2);
                }
            }
        }

        private boolean isLargeEnough() {
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean canCreatePortal() {
            return this.isValid() && this.isLargeEnough();
        }
    }
/**
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	
	public TriassicPortalBlock(Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch((Direction.Axis)state.get(AXIS)) {
		case Z:
			return Z_AABB;
		case X:
		default:
			return X_AABB;
		}
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

    public boolean trySpawnPortal(World world, BlockPos pos) {
    	TriassicPortalBlock.Size size = new TriassicPortalBlock.Size(world, pos);

        if (size.isValid()) {
            size.placePortalBlocks();
            world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 0.7F, 1.0F);
            return true;
        } else {
        	TriassicPortalBlock.Size size1 = new TriassicPortalBlock.Size(world, pos);

            if (size1.isValid()) {
                size1.placePortalBlocks();
                world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return true;
            } else {
                return false;
            }
        }
    }

	 @Override
	 public void neighborChanged(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull Block neighborBlock, @Nonnull BlockPos neighborPos, boolean isMoving) {
		 Size size = new Size(world, pos);
		 if (neighborBlock == this || size.isPortalFrame(neighborBlock.getDefaultState())) {
			 if (!size.isValid()) {
				 world.setBlockState(pos, Blocks.AIR.getDefaultState());
			 }
		 }
	 }
    
	 @Override
	    @Deprecated
	    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entity) {
	        if (!entity.isPassenger() && !entity.isBeingRidden() && entity.isNonBoss()) {
	            if (entity.timeUntilPortal > 0) {
	                entity.timeUntilPortal = entity.getPortalCooldown();
	            } else {
	                if (!entity.world.isRemote && !pos.equals(entity.lastPortalPos)) {
	                    entity.lastPortalPos = new BlockPos(pos);
	                    BlockPattern.PatternHelper helper = createPatternHelper(entity.world, entity.lastPortalPos);
	                    double axis = helper.getForwards().getAxis() == Direction.Axis.X ? (double)helper.getFrontTopLeft().getZ() : (double)helper.getFrontTopLeft().getX();
	                    double x = Math.abs(MathHelper.pct((helper.getForwards().getAxis() == Direction.Axis.X ? entity.getPosZ() : entity.getPosX()) - (double)(helper.getForwards().rotateY().getAxisDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0), axis, axis - (double)helper.getWidth()));
	                    double y = MathHelper.pct(entity.getPosY() - 1.0D, (double)helper.getFrontTopLeft().getY(), (double)(helper.getFrontTopLeft().getY() - helper.getHeight()));
	                    entity.lastPortalVec = new Vec3d(x, y, 0.0D);
	                    entity.teleportDirection = helper.getForwards();
	                }

	                if (entity.world instanceof ServerWorld) {
	                    if (entity.world.getServer().getAllowNether() && !entity.isPassenger()) {
	                        entity.timeUntilPortal = entity.getPortalCooldown();
	                        DimensionType type = worldIn.dimension.getType() == DimensionTypeInit.TRIASSIC_DIMENSION_TYPE ? DimensionType.OVERWORLD : DimensionTypeInit.TRIASSIC_DIMENSION_TYPE;
	                        entity.changeDimension(type, new TeleporterTriassic());
	                    }
	                }
	            }
	        }
	    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return ItemStack.EMPTY;
    }

    public static BlockPattern.PatternHelper createPatternHelper(IWorld world, BlockPos pos) {
        Size size = new Size(world, pos);
        LoadingCache<BlockPos, CachedBlockInfo> cache = BlockPattern.createLoadingCache(world, true);
        if (!size.isValid()) {
            size = new Size(world, pos);
        }

        if (!size.isValid()) {
            return new BlockPattern.PatternHelper(pos, Direction.NORTH, Direction.SOUTH, cache, 1, 1, 1);
        } else {
            return new BlockPattern.PatternHelper(pos, Direction.NORTH, Direction.EAST, cache, size.width, 4, size.length);
        }
    }

    public static class Size {
        private static final int MAX_SIZE = 5;
        private static final int MIN_SIZE = 5;

        private final IWorld world;
        private boolean valid = false;
        private BlockPos nw;
        private BlockPos se;
        private int width;
        private int length;

        public Size(IWorld world, BlockPos pos) {
            this.world = world;

            int east = getDistanceUntilEdge(pos, Direction.EAST);
            int west = getDistanceUntilEdge(pos, Direction.WEST);
            int north = getDistanceUntilEdge(pos, Direction.NORTH);
            int south = getDistanceUntilEdge(pos, Direction.SOUTH);

            int width = east + west - 1;
            int length = north + south - 1;

            if (width > Size.MAX_SIZE || length > Size.MAX_SIZE) {
                return;
            }
            if (width < Size.MIN_SIZE || length < Size.MIN_SIZE) {
                return;
            }

            BlockPos neCorner = pos.east(east).north(north);
            BlockPos nwCorner = pos.west(west).north(north);
            BlockPos seCorner = pos.east(east).south(south);
            BlockPos swCorner = pos.west(west).south(south);

            this.nw = nwCorner.add(1, 0, 1);
            this.se = seCorner.add(-1, 0, -1);
            int wallWidth = width + 2;
            int wallLength = length + 2;
            this.width = wallWidth;
            this.length = wallLength;

            for (int y = 0; y <= 1; y++) {
                for (int x = 0; x < wallWidth; x++) {
                    for (int z = 0; z < wallLength; z++) {
                        if (y == 0 || x == 0 || z == 0 || x == wallWidth - 1 || z == wallLength - 1) {
                            if (!isPortalFrame(world.getBlockState(nwCorner.down().add(x, y, z)))) {
                                return;
                            }
                        }
                    }
                }
            }

            for (int y = 0; y < 2; y++) {
                if (!isPortalFrame(world.getBlockState(neCorner.add(0, y + 1, 0)))) {
                    return;
                }
                if (!isPortalFrame(world.getBlockState(nwCorner.add(0, y + 1, 0)))) {
                    return;
                }
                if (!isPortalFrame(world.getBlockState(seCorner.add(0, y + 1, 0)))) {
                    return;
                }
                if (!isPortalFrame(world.getBlockState(swCorner.add(0, y + 1, 0)))) {
                    return;
                }
            }
            this.valid = true;
        }

        int getDistanceUntilEdge(BlockPos pos, Direction facing) {
            int i;

            for (i = 0; i < 9; ++i) {
                BlockPos blockpos = pos.offset(facing, i);

                if (!this.isEmptyBlock(this.world.getBlockState(blockpos)) || !isPortalFrame(this.world.getBlockState(blockpos.down()))) {
                    break;
                }
            }

            BlockState state = this.world.getBlockState(pos.offset(facing, i));
            return isPortalFrame(state) ? i : 0;
        }

        boolean isEmptyBlock(BlockState state) {
            return state.getMaterial() == Material.AIR;
        }

        boolean isPortalFrame(BlockState state) {
			return state.getBlock() == BlockInit.PORTAL_FRAME;
        }

        boolean isValid() {
            return this.valid;
        }

        void placePortalBlocks() {
            for (BlockPos portalPos : BlockPos.Mutable.getAllInBoxMutable(nw, se)) {
                this.world.setBlockState(portalPos, BlockInit.TRIASSIC_PORTAL.get().getDefaultState(), 2);
            }
        }
    }*/
}
