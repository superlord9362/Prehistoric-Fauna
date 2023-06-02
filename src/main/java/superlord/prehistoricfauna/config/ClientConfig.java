package superlord.prehistoricfauna.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
	
	public final ForgeConfigSpec.BooleanValue eyeShine;
	public final ForgeConfigSpec.BooleanValue customMenuBackground;

	public ClientConfig(final ForgeConfigSpec.Builder builder) {
		this.eyeShine = buildBoolean(builder, "Eye Shine", "all", true, "Toggles whether non-diurnal entities have eye-shine. Default is true");
		this.customMenuBackground = buildBoolean(builder, "Custom Menu Background", "all", true, "Toggles whether the Main Menu panorama is the Prehistoric Fauna one or not. Default is true");
	}
	
	private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment){
		return builder.comment(comment).translation(name).define(name, defaultValue);
	}

}
