package superlord.prehistoricfauna.world.feature.config;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class JohnstoniaConfig implements IFeatureConfig {
	public static int count;

	@SuppressWarnings("static-access")
	public JohnstoniaConfig(int count) {
		this.count = count;
	}

	public static final Codec<JohnstoniaConfig> field_236558_a_;
	public static final JohnstoniaConfig field_236559_b_ = new JohnstoniaConfig(count);

	static {
		field_236558_a_ = Codec.unit(() -> {
			return field_236559_b_;
		});
	}
}