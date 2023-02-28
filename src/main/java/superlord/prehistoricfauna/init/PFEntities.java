package superlord.prehistoricfauna.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.fossil.triassic.HerrerasaurusSkull;

public class PFEntities {
	
	public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<EntityType<HerrerasaurusSkull>> HERRERASAURUS_SKULL = REGISTER.register("herrerasaurus_skull", () -> EntityType.Builder.<HerrerasaurusSkull>of(HerrerasaurusSkull::new, MobCategory.MISC).sized(0.375F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skull").toString()));
	

}
