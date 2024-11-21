package superlord.prehistoricfauna.init;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.PFEntitySpawns;

public class PFMobSpawnsModifier implements BiomeModifier {
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(PrehistoricFauna.MOD_ID, "pf_entity_spawns"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, PrehistoricFauna.MOD_ID);

    public PFMobSpawnsModifier() {
    }

    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            PFEntitySpawns.addBiomeSpawns(biome, builder);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Codec<? extends BiomeModifier> codec() {
        return (Codec)SERIALIZER.get();
    }

    public static Codec<PFMobSpawnsModifier> makeCodec() {
        return Codec.unit(PFMobSpawnsModifier::new);
    }
}
