package superlord.prehistoricfauna.common.feature.util;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class CrassostreaOystersConfig implements FeatureConfiguration {
	public static int count;

	@SuppressWarnings("static-access")
	public CrassostreaOystersConfig(int count) {
		this.count = count;
	}

	public static final Codec<CrassostreaOystersConfig> CODEC;
	public static final CrassostreaOystersConfig field_236559_b_ = new CrassostreaOystersConfig(count);

	static {
		CODEC = Codec.unit(() -> {
			return field_236559_b_;
		});
	}
}