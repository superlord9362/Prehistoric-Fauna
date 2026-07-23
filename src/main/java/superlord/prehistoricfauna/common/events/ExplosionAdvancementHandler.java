package superlord.prehistoricfauna.common.events;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFTags;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class ExplosionAdvancementHandler {
	@SubscribeEvent
	public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
		Entity exploder = event.getExplosion().getIndirectSourceEntity(); // who's credited
		if (!(exploder instanceof ServerPlayer player)) {
			return;
		}

		DamageSource damageSource = event.getLevel().damageSources().explosion(event.getExplosion());

		for (Entity affected : event.getAffectedEntities()) {
            if (affected.getType().is(PFTags.SKELETAL_MOUNTS)) {
            	CriteriaTriggers.PLAYER_KILLED_ENTITY.trigger(player, affected, damageSource);
			}
		}
	}
}
