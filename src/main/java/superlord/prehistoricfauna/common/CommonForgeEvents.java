package superlord.prehistoricfauna.common;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {

	private static final ResourceLocation CUSTOM_FISHING = new ResourceLocation(PrehistoricFauna.MOD_ID, "fishing");
	
	@SubscribeEvent
	public static void onItemFished(ItemFishedEvent event) {
		if (!(event.getEntity().level() instanceof ServerLevel level)) return;
		ResourceLocation dim = level.dimension().location();
		if (dim.equals(new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaceous")) || dim.equals(new ResourceLocation(PrehistoricFauna.MOD_ID, "jurassic")) || dim.equals(new ResourceLocation(PrehistoricFauna.MOD_ID, "triassic"))) {
			event.setCanceled(true);
			event.getDrops().clear();
			LootTable lootTable = level.getServer().getLootData().getLootTable(CUSTOM_FISHING);
			LootParams params = new LootParams.Builder(level).withParameter(LootContextParams.ORIGIN, event.getHookEntity().position()).withParameter(LootContextParams.TOOL, event.getEntity().getMainHandItem()).withParameter(LootContextParams.THIS_ENTITY, event.getEntity()).create(LootContextParamSets.FISHING);
            List<ItemStack> newLoot = lootTable.getRandomItems(params);
            for (ItemStack stack : newLoot) {
            	ItemEntity drop = new ItemEntity(level, event.getHookEntity().getX(), event.getHookEntity().getY(), event.getHookEntity().getZ(), stack);
            	double dx = event.getEntity().getX() - event.getHookEntity().getX();
            	double dy = event.getEntity().getY() + 1D - event.getHookEntity().getY();
            	double dz = event.getEntity().getZ() - event.getHookEntity().getZ();
            	double speed = 0.1D;
            	drop.setDeltaMovement(dx * speed, dy * speed + 0.05D, dz * speed);
            	level.addFreshEntity(drop);
            }
            event.damageRodBy(event.getRodDamage());
            int xp = level.random.nextInt(6) + 1;
            event.getEntity().giveExperiencePoints(xp);
		}
	}
}
