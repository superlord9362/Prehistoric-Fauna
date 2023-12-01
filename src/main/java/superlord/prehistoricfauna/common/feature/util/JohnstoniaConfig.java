package superlord.prehistoricfauna.common.feature.util;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class JohnstoniaConfig implements FeatureConfiguration {
	public static int count;

	@SuppressWarnings("static-access")
	public JohnstoniaConfig(int count) {
		this.count = count;
	}

	public static final Codec<JohnstoniaConfig> CODEC;
	public static final JohnstoniaConfig field_236559_b_ = new JohnstoniaConfig(count);

	static {
		CODEC = Codec.unit(() -> {
			return field_236559_b_;
		});
	}
}