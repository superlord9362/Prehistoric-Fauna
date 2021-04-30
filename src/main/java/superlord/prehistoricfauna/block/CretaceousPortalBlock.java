package superlord.prehistoricfauna.block;

import com.google.common.cache.LoadingCache;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
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
import superlord.prehistoricfauna.util.TeleporterCretaceous;

import javax.annotation.Nonnull;

public class CretaceousPortalBlock extends Block {

	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);


	public CretaceousPortalBlock(Properties builder) {
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
		CretaceousPortalBlock.Size size = new CretaceousPortalBlock.Size(world, pos);
		if (size.isValid()) {
			size.placePortalBlocks();
			world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 0.7F, 1.0F);
			return true;
		} else {
			CretaceousPortalBlock.Size size1 = new CretaceousPortalBlock.Size(world, pos);
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
						DimensionType type = worldIn.dimension.getType() == DimensionTypeInit.CRETACEOUS_DIMENSION_TYPE ? DimensionType.OVERWORLD : DimensionTypeInit.CRETACEOUS_DIMENSION_TYPE;
						entity.changeDimension(type, new TeleporterCretaceous());
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
			return state.getBlock() == BlockInit.PORTAL_FRAME || state.getBlock() == BlockInit.PORTAL_PROJECTOR;
		}

		boolean isValid() {
			return this.valid;
		}

		void placePortalBlocks() {
			for (BlockPos portalPos : BlockPos.Mutable.getAllInBoxMutable(nw, se)) {
				this.world.setBlockState(portalPos, BlockInit.CRETACEOUS_PORTAL.getDefaultState(), 2);
			}
		}
	}

}
