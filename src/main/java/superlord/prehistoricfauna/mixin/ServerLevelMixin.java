package superlord.prehistoricfauna.mixin;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.raid.Raids;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraft.world.level.entity.EntityTickList;
import net.minecraft.world.level.entity.PersistentEntitySectionManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.ticks.LevelTicks;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
	@Shadow private boolean handlingTick;
	@Shadow @Final private MinecraftServer server;
	@Shadow @Final private ServerLevelData serverLevelData;
	@Shadow private static IntProvider THUNDER_DURATION;
	@Shadow private static IntProvider THUNDER_DELAY;
	@Shadow private static IntProvider RAIN_DURATION;
	@Shadow private static IntProvider RAIN_DELAY;
	@Shadow @Final private PersistentEntitySectionManager<Entity> entityManager;
	@Shadow @Final private LevelTicks<Block> blockTicks;
	@Shadow @Final private LevelTicks<Fluid> fluidTicks;
	@Shadow @Final private boolean tickTime;
	@Shadow @Final private List<CustomSpawner> customSpawners;
	@Shadow @Final protected Raids raids;
	@Shadow @Final private List<ServerPlayer> players;
	@Shadow private int emptyTime;
	@Shadow private EndDragonFight dragonFight;
	@Shadow @Final EntityTickList entityTickList;
	@Shadow @Final ServerChunkCache chunkSource;
	
	@Shadow abstract void tickTime();
	@Shadow abstract void advanceWeatherCycle();
	@Shadow abstract void tickBlock(BlockPos pos, Block block);
	@Shadow abstract void tickFluid(BlockPos pos, Fluid fluid);
	@Shadow abstract ServerChunkCache getChunkSource();
	@Shadow abstract void runBlockEvents();
	@Shadow abstract void resetEmptyTime();
	@Shadow abstract boolean shouldDiscardEntity(Entity entity);
	@Shadow abstract void tickNonPassenger(Entity entity);
	
	@Overwrite
	public void tick(BooleanSupplier supplier) {
		ProfilerFiller profilerfiller = ((ServerLevel)(Object)this).getProfiler();
		this.handlingTick = true;
		profilerfiller.push("world border");
		((ServerLevel)(Object)this).getWorldBorder().tick();
		profilerfiller.popPush("weather");
		this.advanceWeatherCycle();
		((ServerLevel)(Object)this).updateSkyBrightness();
		this.tickTime();
		profilerfiller.popPush("tickPending");
		if (!((ServerLevel)(Object)this).isDebug()) {
			long k = ((ServerLevel)(Object)this).getGameTime();
			profilerfiller.push("blockTicks");
			this.blockTicks.tick(k, 65536, this::tickBlock);
			profilerfiller.popPush("fluidTicks");
			this.fluidTicks.tick(k, 65536, this::tickFluid);
			profilerfiller.pop();
		}

		profilerfiller.popPush("raid");
		this.raids.tick();
		profilerfiller.popPush("chunkSource");
		this.getChunkSource().tick(supplier, true);
		profilerfiller.popPush("blockEvents");
		this.runBlockEvents();
		this.handlingTick = false;
		profilerfiller.pop();
		boolean flag = !this.players.isEmpty() || net.minecraftforge.common.world.ForgeChunkManager.hasForcedChunks((ServerLevel)(Object)this);
		if (flag) {
			this.resetEmptyTime();
		}

		if (flag || this.emptyTime++ < 300) {
			profilerfiller.push("entities");
			if (this.dragonFight != null) {
				profilerfiller.push("dragonFight");
				this.dragonFight.tick();
				profilerfiller.pop();
			}

			this.entityTickList.forEach((p_184065_) -> {
				if (!p_184065_.isRemoved()) {
					if (this.shouldDiscardEntity(p_184065_)) {
						p_184065_.discard();
					} else {
						profilerfiller.push("checkDespawn");
						p_184065_.checkDespawn();
						profilerfiller.pop();
						if (this.chunkSource.chunkMap.getDistanceManager().inEntityTickingRange(p_184065_.chunkPosition().toLong())) {
							Entity entity = p_184065_.getVehicle();
							if (entity != null) {
								if (!entity.isRemoved() && entity.hasPassenger(p_184065_)) {
									return;
								}

								p_184065_.stopRiding();
							}

							profilerfiller.push("tick");
							if (!p_184065_.isRemoved() && !(p_184065_ instanceof net.minecraftforge.entity.PartEntity)) {
								((ServerLevel)(Object)this).guardEntityTick(this::tickNonPassenger, p_184065_);
							}
							profilerfiller.pop();
						}
					}
				}
			});
			profilerfiller.pop();
			((ServerLevel)(Object)this).tickBlockEntities();
		}

		profilerfiller.push("entityManagement");
		this.entityManager.tick();
		profilerfiller.pop();
	}

}
