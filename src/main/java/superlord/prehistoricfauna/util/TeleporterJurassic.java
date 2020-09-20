package superlord.prehistoricfauna.util;

import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.PointOfInterest;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.common.util.ITeleporter;
import superlord.prehistoricfauna.block.JurassicPortalBlock;
import superlord.prehistoricfauna.block.PortalFrameBlock;
import superlord.prehistoricfauna.init.BlockInit;

public class TeleporterJurassic implements ITeleporter {

	@Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (!placeInPortal(destWorld, entity, yaw)) {
            makePortal(destWorld, entity);
            placeInPortal(destWorld, entity, yaw);
            return repositionEntity.apply(false);
        } else {
            placeInPortal(destWorld, entity, yaw);
            return repositionEntity.apply(false);
        }
    }

    public static boolean placeInPortal(ServerWorld world, Entity entity, float yaw) {
        Vec3d lastPortalVec = entity.getLastPortalVec();
        Direction direction = entity.getTeleportDirection();
        BlockPattern.PortalInfo portalInfo = placeInExistingPortal(world, new BlockPos(entity), entity.getMotion(), direction, lastPortalVec.x, lastPortalVec.y, entity instanceof PlayerEntity);
        if (portalInfo == null) {
            return false;
        } else {
            Vec3d vec3d1 = portalInfo.pos;
            Vec3d vec3d2 = portalInfo.motion;
            entity.setMotion(vec3d2);
            entity.rotationYaw = yaw + (float) portalInfo.rotation;
            entity.moveForced(vec3d1.x, vec3d1.y, vec3d1.z);
            return true;
        }
    }

    @Nullable
    public static BlockPattern.PortalInfo placeInExistingPortal(ServerWorld world, @Nonnull BlockPos pos, @Nonnull Vec3d portalPos, @Nonnull Direction direction, double d, double d1, boolean b) {
        PointOfInterestManager poiManager = world.getPointOfInterestManager();
        poiManager.ensureLoadedAndValid(world, pos, 128);
        List<PointOfInterest> list = poiManager.getInSquare((poi) -> poi == JurassicPointOfInterest.JURASSIC_PORTAL, pos, 128, PointOfInterestManager.Status.ANY).collect(Collectors.toList());
        Optional<PointOfInterest> optional = list.stream().min(Comparator.<PointOfInterest>comparingDouble((poi) -> poi.getPos().distanceSq(pos)).thenComparingInt((poi) -> poi.getPos().getY()));
        return optional.map((poi) -> {
            BlockPos posPos = poi.getPos();
            world.getChunkProvider().registerTicket(TicketType.PORTAL, new ChunkPos(posPos), 3, posPos);
            BlockPattern.PatternHelper patternHelper = JurassicPortalBlock.createPatternHelper(world, posPos);
            return patternHelper.getPortalInfo(direction, posPos, d1, portalPos, d);
        }).orElse(null);
    }

    public static void makePortal(ServerWorld world, @Nonnull Entity entity) {
        createPortal(world, new BlockPos(MathHelper.floor(entity.getPosX()), MathHelper.floor(entity.getPosY()), MathHelper.floor(entity.getPosZ())), entity);
    }

    public static void createPortal(World world, BlockPos pos, @Nullable Entity entity) {
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
        world.setBlockState(pos.up(), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.up(2), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.up(3), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.east().up(), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.east().up(2), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.east().up(3), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.west().up(), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.west().up(2), BlockInit.JURASSIC_PORTAL.getDefaultState());
		world.setBlockState(pos.west().up(3), BlockInit.JURASSIC_PORTAL.getDefaultState());
    }
	
}
