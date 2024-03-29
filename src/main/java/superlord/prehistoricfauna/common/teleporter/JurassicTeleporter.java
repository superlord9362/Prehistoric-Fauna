package superlord.prehistoricfauna.common.teleporter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

import javax.annotation.Nullable;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.JurassicPortalBlock;
import superlord.prehistoricfauna.common.blocks.PortalFrameBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDimensions;

public class JurassicTeleporter implements ITeleporter {
	private static final Block FRAME = PFBlocks.PORTAL_FRAME.get();
    private final ServerLevel world;
    private static final Method m_getRelativePortalPosition = ObfuscationReflectionHelper.findMethod(Entity.class, "m_7643_", Direction.Axis.class, BlockUtil.FoundRectangle.class);
	
    public JurassicTeleporter(ServerLevel world) {
    	this.world = world;
    }
    
    public Optional<BlockUtil.FoundRectangle> getExistingPortal(BlockPos pos) {
    	PoiManager poiManager = this.world.getPoiManager();
    	int i = 64;
    	poiManager.ensureLoadedAndValid(this.world, pos, i);
    	Optional<PoiRecord> optional = poiManager.getInSquare(poiType ->
    	poiType == PFDimensions.JURASSIC_PORTAL.get(), pos, i, PoiManager.Occupancy.ANY)
    	.sorted(Comparator.comparingDouble((ToDoubleFunction<PoiRecord>) poi ->
    	poi.getPos().distSqr(pos))
    	.thenComparingInt(poi ->
    	poi.getPos().getY()))
    	.filter(poi ->
    	JurassicTeleporter.this.world.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
    	.findFirst();
    	return optional.map((poi) -> {
    		BlockPos blockPos = poi.getPos();
    		this.world.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockPos), 3, blockPos);
    		BlockState blockState = this.world.getBlockState(blockPos);
    		return BlockUtil.getLargestRectangleAround(blockPos, blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) -> this.world.getBlockState(posIn) == blockState);
    	});
    	
    }

    public Optional<BlockUtil.FoundRectangle> makePortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder border = this.world.getWorldBorder();
        int height = this.world.getHeight() - 1;
        BlockPos.MutableBlockPos mutable = pos.mutable();

        for (BlockPos.MutableBlockPos mut : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(height, this.world.getHeight(Heightmap.Types.MOTION_BLOCKING, mut.getX(), mut.getZ()));
            if (border.isWithinBounds(mut) && border.isWithinBounds(mut.move(direction, 1))) {
                mut.move(direction.getOpposite(), 1);

                for(int l = j; l >= 0; --l) {
                    mut.setY(l);
                    if (this.world.isEmptyBlock(mut)) {
                        int i1;
                        for(i1 = l; l > 0 && this.world.isEmptyBlock(mut.move(Direction.DOWN)); --l) {
                        }

                        if (l + 4 <= height) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                mut.setY(l);
                                if (this.checkRegionForPlacement(mut, mutable, direction, 0)) {
                                    double d2 = pos.distSqr(mut);
                                    if (this.checkRegionForPlacement(mut, mutable, direction, -1) && this.checkRegionForPlacement(mut, mutable, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = mut.immutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = mut.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        //Place the frame blocks
        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), Mth.clamp(pos.getY(), 70, world.getHeight() - 10), pos.getZ())).immutable();
            Direction drotated = direction.getClockWise();
            if (!border.isWithinBounds(blockpos)) {
                return Optional.empty();
            }

            for (int fOffset = -1; fOffset < 2; ++fOffset) {
                for (int fWidth = 0; fWidth < 2; ++fWidth) {
                    for (int fHeight = -1; fHeight < 3; ++fHeight) {
                        boolean flag = fHeight < 0;
                        mutable.setWithOffset(blockpos, fWidth * direction.getStepX() + fOffset * drotated.getStepX(), fHeight, fWidth * direction.getStepZ() + fOffset * direction.getStepZ());
                        world.setBlockAndUpdate(mutable, flag ? FRAME.defaultBlockState().setValue(PortalFrameBlock.ACTIVATED, true) : Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }

        for (int fWidth = -1; fWidth < 4; ++fWidth) {
            for (int fHeight = -1; fHeight < 4; ++fHeight) {
                if (fWidth == -1 || fWidth == 3 || fHeight == -1 || fHeight == 3) {
                    mutable.setWithOffset(blockpos, fWidth * direction.getStepX(), fHeight, fWidth * direction.getStepZ());
                    world.setBlockAndUpdate(mutable, FRAME.defaultBlockState().setValue(PortalFrameBlock.ACTIVATED, true));
                }
            }
        }

        //Place the portal blocks
        BlockState portal = PFBlocks.JURASSIC_PORTAL.get().defaultBlockState().setValue(JurassicPortalBlock.AXIS, axis);
        for (int pWidth = 0; pWidth < 3; ++pWidth) {
            for (int pHeight = 0; pHeight < 3; ++pHeight) {
                mutable.setWithOffset(blockpos, pWidth * direction.getStepX(), pHeight, pWidth * direction.getStepZ());
                world.setBlock(mutable, portal, 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
    }
	
	private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for(int i = -1; i < 3; ++i) {
            for(int j = -1; j < 4; ++j) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if (j < 0 && !this.world.getBlockState(offsetPos).getMaterial().isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.world.isEmptyBlock(offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }
	
	@Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        return repositionEntity.apply(false);
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        boolean toJurassic = destWorld.dimension() == PFDimensions.JURASSIC;
        if (entity.level.dimension() != PFDimensions.JURASSIC && !toJurassic) {
            return null;
        } else {
            WorldBorder border = destWorld.getWorldBorder();
            double minX = Math.max(-2.9999872E7D, border.getMinX() + 16.0D);
            double minZ = Math.max(-2.9999872E7D, border.getMinZ() + 16.0D);
            double maxX = Math.min(2.9999872E7D, border.getMaxX() - 16.0D);
            double maxZ = Math.min(2.9999872E7D, border.getMaxZ() - 16.0D);
            double offset = DimensionType.getTeleportationScale(entity.level.dimensionType(), destWorld.dimensionType());
            BlockPos blockpos = new BlockPos(Mth.clamp(entity.getX() * offset, minX, maxX), entity.getY(), Mth.clamp(entity.getZ() * offset, minZ, maxZ));
           return this.getPortalLogic(entity, blockpos).map((portalFoundRectangle) -> {
        	   BlockState blockState = entity.level.getBlockState(entity.portalEntrancePos);
        	   Direction.Axis axis;
        	   Vec3 vector3d;
        	   if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
        		   axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        		   BlockUtil.FoundRectangle result = BlockUtil.getLargestRectangleAround(entity.portalEntrancePos, axis, 21, Direction.Axis.Y, 21, (pos) -> entity.level.getBlockState(pos) == blockState);
        		   try {
        			   vector3d = (Vec3) m_getRelativePortalPosition.invoke(entity, axis, result);
        		   } catch (IllegalAccessException | InvocationTargetException e) {
        			   throw new RuntimeException(e);
        		   }
        	   } else {
        		   axis = Direction.Axis.X;
        		   vector3d = new Vec3(0.5D, 0.0D, 0.0D);
        	   }
        	   return PortalShape.createPortalInfo(destWorld, portalFoundRectangle, axis, vector3d, entity.getDimensions(entity.getPose()), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
           }).orElse(null);
        }
    }

    private Optional<BlockUtil.FoundRectangle> getPortalLogic(Entity entity, BlockPos pos) {
        Optional<BlockUtil.FoundRectangle> existing = this.getExistingPortal(pos);
        if (entity instanceof ServerPlayer) { //ServerPlayerEntity seems to do the portal creation
            if (existing.isPresent()) {
                return existing;
            } else {
                Direction.Axis axis = entity.level.getBlockState(entity.portalEntrancePos).getOptionalValue(JurassicPortalBlock.AXIS).orElse(Direction.Axis.X);
                Optional<BlockUtil.FoundRectangle> portal = this.makePortal(pos, axis);
                if (!portal.isPresent()) {
                    PrehistoricFauna.LOGGER.error("Unable to create a portal, likely target out of worldborder");
                }

                return portal;
            }
        } else { //Otherwise, we don't care about a dimension unless it does exist
            return existing;
        }
    }
}
