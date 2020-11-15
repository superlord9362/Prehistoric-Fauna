package superlord.prehistoricfauna.util;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.google.common.collect.Maps;

import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ColumnPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.PointOfInterest;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.common.util.ITeleporter;
import superlord.prehistoricfauna.block.PortalFrameBlock;
import superlord.prehistoricfauna.block.CretaceousPortalBlock;
import superlord.prehistoricfauna.init.BlockInit;

public class TeleporterCretaceous implements ITeleporter {

    protected final Map<ColumnPos, PortalPosition> destinationCoordinateCache = Maps.newHashMapWithExpectedSize(4096);

    public boolean placeInPortal(ServerWorld world, Entity entity, float yaw) {
        Vec3d vec3d = entity.getLastPortalVec();
        Direction direction = entity.getTeleportDirection();
        BlockPattern.PortalInfo pattern = TeleporterCretaceous.placeInExistingPortal(world, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()), entity.getMotion(), direction, vec3d.x, vec3d.y, entity instanceof PlayerEntity);
        if (pattern == null) {
            return false;
        } else {
            Vec3d position = pattern.pos;
            Vec3d motion = pattern.motion;
            entity.setMotion(motion);
            entity.rotationYaw = yaw + (float) pattern.rotation;
            entity.setPositionAndUpdate(position.x, position.y, position.z);
            return true;
        }
    }

    @Nullable
    public static BlockPattern.PortalInfo placeInExistingPortal(ServerWorld world, @Nonnull BlockPos pos, @Nonnull Vec3d portalPos, @Nonnull Direction direction, double d, double d1, boolean b) {
        PointOfInterestManager poiManager = world.getPointOfInterestManager();
        poiManager.ensureLoadedAndValid(world, pos, 128);
        List<PointOfInterest> list = poiManager.getInSquare((poi) -> poi == CretaceousPointOfInterest.PORTAL, pos, 128, PointOfInterestManager.Status.ANY).collect(Collectors.toList());
        Optional<PointOfInterest> optional = list.stream().min(Comparator.<PointOfInterest>comparingDouble((poi) -> poi.getPos().distanceSq(pos)).thenComparingInt((poi) -> poi.getPos().getY()));
        return optional.map((poi) -> {
            BlockPos posPos = poi.getPos();
            world.getChunkProvider().registerTicket(TicketType.PORTAL, new ChunkPos(posPos), 3, posPos);
            BlockPattern.PatternHelper patternHelper = CretaceousPortalBlock.createPatternHelper(world, posPos);
            return patternHelper.getPortalInfo(direction, posPos, d1, portalPos, d);
        }).orElse(null);
    }

    /**
     * Create a portal at the teleport location.
     */
    public void makePortal(ServerWorld world, Entity entity) {
        Random random = new Random(world.getSeed());
        double d0 = -1.0D;
        int entityX = MathHelper.floor(entity.getPosX());
        int entityY = MathHelper.floor(entity.getPosY());
        int entityZ = MathHelper.floor(entity.getPosZ());
        int xPos = entityX;
        int yPos = entityY;
        int zPos = entityZ;
        int baseAxis = 0;
        int randAxis = random.nextInt(4);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int startX = entityX - 16; startX <= entityX + 16; ++startX) {
            double ePosX = (double) startX + 0.5D - entity.getPosX();

            for (int startZ = entityZ - 16; startZ <= entityZ + 16; ++startZ) {
                double ePosZ = (double) startZ + 0.5D - entity.getPosZ();

                searchpos:
                for (int startY = world.getActualHeight() - 1; startY >= 0; --startY) {
                    if (world.isAirBlock(mutable.setPos(startX, startY, startZ))) {
                        while (startY > 0 && world.isAirBlock(mutable.setPos(startX, startY - 1, startZ))) {
                            --startY;
                        }

                        for (int k3 = randAxis; k3 < randAxis + 4; ++k3) {
                            int l3 = k3 % 2;
                            int i4 = 1 - l3;
                            if (k3 % 4 >= 2) {
                                l3 = -l3;
                                i4 = -i4;
                            }

                            for (int j4 = 0; j4 < 3; ++j4) {
                                for (int k4 = 0; k4 < 4; ++k4) {
                                    for (int portalHeight = -1; portalHeight < 4; ++portalHeight) {
                                        int sPosX = startX + (k4 - 1) * l3 + j4 * i4;
                                        int sPosY = startY + portalHeight;
                                        int sPosZ = startZ + (k4 - 1) * i4 - j4 * l3;
                                        mutable.setPos(sPosX, sPosY, sPosZ);
                                        System.out.println(world.getBlockState(mutable));
                                        if (portalHeight < 0 && !world.getBlockState(mutable).getMaterial().isSolid() || portalHeight >= 0 && !world.isAirBlock(mutable)) {
                                            continue searchpos;
                                        }
                                    }
                                }
                            }

                            double ePosY = (double) startY + 0.5D - entity.getPosY();
                            double eArea = ePosX * ePosX + ePosY * ePosY + ePosZ * ePosZ;
                            if (d0 < 0.0D || eArea < d0) {
                                d0 = eArea;
                                xPos = startX;
                                yPos = startY;
                                zPos = startZ;
                                baseAxis = k3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D) {
            for (int startX2 = entityX - 16; startX2 <= entityX + 16; ++startX2) {
                double ePosX2 = (double) startX2 + 0.5D - entity.getPosX();

                for (int startZ2 = entityZ - 16; startZ2 <= entityZ + 16; ++startZ2) {
                    double ePosZ2 = (double) startZ2 + 0.5D - entity.getPosZ();

                    label214:
                    for (int startY2 = world.getActualHeight() - 1; startY2 >= 0; --startY2) {
                        if (world.isAirBlock(mutable.setPos(startX2, startY2, startZ2))) {
                            while (startY2 > 0 && world.isAirBlock(mutable.setPos(startX2, startY2 - 1, startZ2))) {
                                --startY2;
                            }

                            for (int l7 = randAxis; l7 < randAxis + 2; ++l7) {
                                int l8 = l7 % 2;
                                int k9 = 1 - l8;

                                for (int i10 = 0; i10 < 4; ++i10) {
                                    for (int portalHeight2 = -1; portalHeight2 < 4; ++portalHeight2) {
                                        int sPosX2 = startX2 + (i10 - 1) * l8;
                                        int sPosY2 = startY2 + portalHeight2;
                                        int sPosZ2 = startZ2 + (i10 - 1) * k9;
                                        mutable.setPos(sPosX2, sPosY2, sPosZ2);
                                        if (portalHeight2 < 0 && !world.getBlockState(mutable).getMaterial().isSolid() || portalHeight2 >= 0 && !world.isAirBlock(mutable)) {
                                            continue label214;
                                        }
                                    }
                                }

                                double ePosY2 = (double) startY2 + 0.5D - entity.getPosY();
                                double eArea2 = ePosX2 * ePosX2 + ePosY2 * ePosY2 + ePosZ2 * ePosZ2;
                                if (d0 < 0.0D || eArea2 < d0) {
                                    d0 = eArea2;
                                    xPos = startX2;
                                    yPos = startY2;
                                    zPos = startZ2;
                                    baseAxis = l7 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int baseX = xPos;
        int baseY = yPos;
        int baseZ = zPos;
        int xAxis = baseAxis % 2;
        int zAxis = 1 - xAxis;
        if (baseAxis % 4 >= 2) {
            xAxis = -xAxis;
            zAxis = -zAxis;
        }
        
        BlockPos pos = new BlockPos(baseX, baseY, baseZ);
        
        while (pos.getY() > 1 && world.isAirBlock(pos)) {
            pos = pos.down();
        }

        while (!world.isAirBlock(pos.up()) && (world.getBlockState(pos).getBlock() != BlockInit.MOSSY_DIRT && (world.getBlockState(pos).getBlock() != Blocks.COARSE_DIRT) && (world.getBlockState(pos).getBlock() != Blocks.PODZOL) || world.getBlockState(pos).getBlock() != Blocks.GRASS)) {
            pos = pos.up();
        }
        
        //Bottom layer
        world.setBlockState(pos, BlockInit.PORTAL_PROJECTOR.getDefaultState());
        world.setBlockState(pos.east(), BlockInit.PORTAL_FRAME.getDefaultState());
        world.setBlockState(pos.west(), BlockInit.PORTAL_FRAME.getDefaultState());

        //Pillars
        world.setBlockState(pos.east(2).up(), BlockInit.PORTAL_FRAME.getDefaultState().with(PortalFrameBlock.FACING, Direction.WEST));
        world.setBlockState(pos.west(2).up(), BlockInit.PORTAL_FRAME.getDefaultState().with(PortalFrameBlock.FACING, Direction.EAST));
        world.setBlockState(pos.east(2).up(2), BlockInit.PORTAL_PROJECTOR.getDefaultState().with(PortalFrameBlock.FACING, Direction.WEST));
        world.setBlockState(pos.west(2).up(2), BlockInit.PORTAL_PROJECTOR.getDefaultState().with(PortalFrameBlock.FACING, Direction.EAST));
        world.setBlockState(pos.east(2).up(3), BlockInit.PORTAL_FRAME.getDefaultState().with(PortalFrameBlock.FACING, Direction.WEST));
        world.setBlockState(pos.west(2).up(3), BlockInit.PORTAL_FRAME.getDefaultState().with(PortalFrameBlock.FACING, Direction.EAST));

        //Top layer
        world.setBlockState(pos.east(1).up(4), BlockInit.PORTAL_FRAME.getDefaultState().with(PortalFrameBlock.FACING, Direction.DOWN));
        world.setBlockState(pos.up(4), BlockInit.PORTAL_PROJECTOR.getDefaultState().with(PortalFrameBlock.FACING, Direction.DOWN));
        world.setBlockState(pos.west(1).up(4), BlockInit.PORTAL_FRAME.getDefaultState().with(PortalFrameBlock.FACING, Direction.DOWN));
        
        //Portal blocks
        world.setBlockState(pos.up(), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.up(2), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.up(3), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.east().up(), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.east().up(2), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.east().up(3), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.west().up(), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.west().up(2), BlockInit.CRETACEOUS_PORTAL.getDefaultState());
		world.setBlockState(pos.west().up(3), BlockInit.CRETACEOUS_PORTAL.getDefaultState());

    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        Entity newEntity = repositionEntity.apply(false);

        if (!placeInPortal(destWorld, newEntity, newEntity.rotationYaw)) {
            makePortal(destWorld, newEntity);
            placeInPortal(destWorld, newEntity, newEntity.rotationYaw);
        }

        return newEntity;
    }

    static class PortalPosition {
        public final BlockPos pos;
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long time) {
            this.pos = pos;
            this.lastUpdateTime = time;
        }
    }
}