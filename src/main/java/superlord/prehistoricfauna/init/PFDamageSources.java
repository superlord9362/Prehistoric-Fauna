package superlord.prehistoricfauna.init;

import org.antlr.v4.runtime.misc.NotNull;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFDamageSources {
	
    public static final ResourceKey<DamageType> TRAP = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, "trap"));
    public static final ResourceKey<DamageType> SAUROPOD_TRAMPLING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, "trample"));
    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(PrehistoricFauna.MOD_ID, "bleeding"));
    
    static class DamageCustomDeathMessage extends DamageSource {

        public DamageCustomDeathMessage(Holder.Reference<DamageType> message) {
            super(message);
        }

        public DamageCustomDeathMessage(Holder.Reference<DamageType> message, Entity source) {
            super(message, source);
        }
    	
		@Override
    	public @NotNull Component getLocalizedDeathMessage(LivingEntity entityLivingBase) {
			int type = entityLivingBase.getRandom().nextInt(3);
			String s = "death,attack." + this.getMsgId() + "_" + type;
			Entity entity = this.getDirectEntity() == null ? this.getEntity() : this.getDirectEntity();
			if (entity != null) {
				return Component.translatable(s + ".entity", entityLivingBase.getDisplayName(), entity.getDisplayName());
			} else {
				return Component.translatable(s, entityLivingBase.getDisplayName());
			}
    	}
    }
    
    public static DamageSource causeHenostoneTrapDamage(RegistryAccess registryAccess) {
        return new DamageCustomDeathMessage(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(TRAP));
    }
    
    public static DamageSource causeSauropodTramplingDamage(RegistryAccess registryAccess, Entity source) {
        return new DamageCustomDeathMessage(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(SAUROPOD_TRAMPLING), source);
    }
    
    public static DamageSource causeBleedingDamage(RegistryAccess registryAccess) {
        return new DamageCustomDeathMessage(registryAccess.registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(BLEEDING));
    }
	
}
