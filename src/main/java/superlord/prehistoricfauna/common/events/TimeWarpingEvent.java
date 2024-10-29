package superlord.prehistoricfauna.common.events;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class TimeWarpingEvent {

	public boolean deadBirds = false;
	public boolean deadSauropods = false;
	public boolean deadMammals = false;

	@SubscribeEvent
	public void spaceTimeContinuumWarping(LivingDeathEvent event) {
		if (PrehistoricFaunaConfig.spaceTimeContinuumWarping) {
			if (event.getEntity() instanceof Hesperornithoides) {
				if (event.getSource().getDirectEntity() instanceof Player) {
					this.deadBirds = true;
				}
			}
			if (event.getEntity() instanceof Didelphodon) {
				if (event.getSource().getDirectEntity() instanceof Player) {
					this.deadMammals = true;
				}
			}
			if (event.getEntity() instanceof Chromogisaurus) {
				if (event.getSource().getDirectEntity() instanceof Player) {
					this.deadSauropods = true;
				}
			}
		}
	}

	@SubscribeEvent
	public void killChickensFromSpaceTimeWarping(EntityJoinLevelEvent event) {
		if (this.deadBirds == true) {
			Entity entity = event.getEntity();
			if (event.getEntity() instanceof Chicken || event.getEntity() instanceof Parrot) {
				entity.remove(RemovalReason.KILLED);
			}
		}
		if (this.deadMammals == true) {
			Entity entity = event.getEntity();
			if (event.getEntity() instanceof Horse || event.getEntity() instanceof Mule || event.getEntity() instanceof Donkey || event.getEntity() instanceof Cow || event.getEntity() instanceof Wolf || event.getEntity() instanceof AbstractVillager || event.getEntity() instanceof AbstractIllager || event.getEntity() instanceof Ocelot || event.getEntity() instanceof Cat || event.getEntity() instanceof Pig || event.getEntity() instanceof Bat || event.getEntity() instanceof Rabbit || event.getEntity() instanceof Fox || event.getEntity() instanceof Sheep || event.getEntity() instanceof PolarBear || event.getEntity() instanceof Panda || event.getEntity() instanceof MushroomCow || event.getEntity() instanceof Llama || event.getEntity() instanceof Dolphin) {
				entity.remove(RemovalReason.KILLED);
			}
		}
		if (this.deadSauropods == true) {
			Entity entity = event.getEntity();
			if (event.getEntity() instanceof Camarasaurus) {
				entity.remove(RemovalReason.KILLED);
			}
		}
	}

}
