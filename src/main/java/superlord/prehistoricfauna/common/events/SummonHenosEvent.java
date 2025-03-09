package superlord.prehistoricfauna.common.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.henos.Henos;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Bus.FORGE)
public class SummonHenosEvent {
	
	@SubscribeEvent
	public void summonHenosEvent(BlockEvent.EntityPlaceEvent event) {
		if (!event.isCanceled() && event.getPlacedBlock().getBlock() == PFBlocks.LARGE_AMMONITE_FOSSIL.get() && event.getLevel() instanceof Level) {
			trySpawnGolem((Level) event.getLevel(), event.getPos());
		}
	}

	public static boolean trySpawnGolem(final Level world, final BlockPos headPos) {
		if (world.isClientSide()) return false;

		final BlockState stateBelow1 = world.getBlockState(headPos.below(1));
		final BlockState stateBelow2 = world.getBlockState(headPos.below(2));
		final BlockState stateArmNorth = world.getBlockState(headPos.below(1).north(1));
		final BlockState stateArmSouth = world.getBlockState(headPos.below(1).south(1));
		final BlockState stateArmEast = world.getBlockState(headPos.below(1).east(1));
		final BlockState stateArmWest = world.getBlockState(headPos.below(1).west(1));

		final double spawnX = headPos.getX() + 0.5D;
		final double spawnY = headPos.getY() - 1.95D;
		final double spawnZ = headPos.getZ() + 0.5D;

		if(stateBelow1 == PFBlocks.TIME_FRAGMENT_BLOCK.get().defaultBlockState() && stateBelow2 == PFBlocks.HENOSTONE.get().defaultBlockState() && stateArmNorth == PFBlocks.HENOSTONE.get().defaultBlockState() && stateArmSouth == PFBlocks.HENOSTONE.get().defaultBlockState()) {
			final Henos timeGuardianEntity = PFEntities.HENOS.get().create(world);
			timeGuardianEntity.setSummoned(true);
			timeGuardianEntity.moveTo(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
			world.addFreshEntity(timeGuardianEntity);
			world.setBlockAndUpdate(headPos.below(1), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos.below(2), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos.below(1).north(1), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos.below(1).south(1), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos, Blocks.AIR.defaultBlockState());
			return true;
		}
		if(stateBelow1 == PFBlocks.TIME_FRAGMENT_BLOCK.get().defaultBlockState() && stateBelow2 == PFBlocks.HENOSTONE.get().defaultBlockState() && stateArmEast == PFBlocks.HENOSTONE.get().defaultBlockState() && stateArmWest == PFBlocks.HENOSTONE.get().defaultBlockState()) {
			final Henos timeGuardianEntity = PFEntities.HENOS.get().create(world);
			timeGuardianEntity.setSummoned(true);
			timeGuardianEntity.moveTo(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
			world.addFreshEntity(timeGuardianEntity);
			world.setBlockAndUpdate(headPos.below(1), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos.below(2), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos.below(1).east(1), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos.below(1).west(1), Blocks.AIR.defaultBlockState());
			world.setBlockAndUpdate(headPos, Blocks.AIR.defaultBlockState());
			return true;
		}
		return false;
	}
}
