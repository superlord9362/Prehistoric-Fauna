package superlord.prehistoricfauna.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
	
	public final ForgeConfigSpec.BooleanValue eyeShine;
	public final ForgeConfigSpec.BooleanValue customMenuBackground;
	
	public final ForgeConfigSpec.BooleanValue tyrannosaurusFeathersOrScaled;
	public final ForgeConfigSpec.BooleanValue thescelosaurusFeathersOrScaled;
//	public final ForgeConfigSpec.BooleanValue dryosaurusFeathersOrScaled;
//	public final ForgeConfigSpec.BooleanValue dilophosaurusFeathersOrScaled;
	public final ForgeConfigSpec.BooleanValue megapnosaurusFeathersOrScaled;
	public final ForgeConfigSpec.BooleanValue coelophysisFeathersOrScaled;
//	public final ForgeConfigSpec.BooleanValue chromogisaurusFeathersOrScaled;
//	public final ForgeConfigSpec.BooleanValue herrerasaurusFeathersOrScaled;
	public final ForgeConfigSpec.BooleanValue protoceratopsFeathersOrScaled;
//	public final ForgeConfigSpec.BooleanValue sarahsaurusFeathersOrScaled;
//	public final ForgeConfigSpec.BooleanValue jinzhousaurusFeathersOrScaled;

	public ClientConfig(final ForgeConfigSpec.Builder builder) {
		builder.push("Misc");
		this.eyeShine = buildBoolean(builder, "Eye Shine", "all", true, "Toggles whether non-diurnal entities have eye-shine. Default is true");
		this.customMenuBackground = buildBoolean(builder, "Custom Menu Background", "all", true, "Toggles whether the Main Menu panorama is the Prehistoric Fauna one or not. Default is true");
		builder.pop();
		builder.push("Scaly and Feathered Configs");
		builder.push("Djadochta");
		this.protoceratopsFeathersOrScaled = buildBoolean(builder, "Protoceratops Scaled Texture", "all", true, "Toggles whether Protoceratops is scaley or feathered. False is feathered, true is scaley. Default is true");
		builder.pop();
		builder.push("Hell Creek");
		this.thescelosaurusFeathersOrScaled = buildBoolean(builder, "Thescelosaurus Scaled Texture", "all", false, "Toggles whether Thescelosaurus is scaley or feathered. False is feathered, true is scaley. Default is false");
		this.tyrannosaurusFeathersOrScaled = buildBoolean(builder, "Tyrannosaurus Scaled Texture", "all", true, "Toggles whether Tyrannosaurus is scaley or feathered. Only affects babies. False is feathered, true is scaley. Default is true");
		builder.pop();
		builder.push("Yixian");
//		this.jinzhousaurusFeathersOrScaled = buildBoolean(builder, "Jinzhousaurus Scaled Texture", "all", true, "Toggles whether Jinzhousaurus is scaley or feathered. False is feathered, true is scaley. Default is true");
		builder.pop();
		builder.push("Kayenta");
//		this.dilophosaurusFeathersOrScaled = buildBoolean(builder, "Dilophosaurus Scaled Texture", "all", true, "Toggles whether Dilophosaurus is scaley or feathered. False is feathered, true is scaley. Default is true");
		this.megapnosaurusFeathersOrScaled = buildBoolean(builder, "Megapnosaurus Scaled Texture", "all", false, "Toggles whether Megapnosaurus is scaley or feathered. False is feathered, true is scaley. Default is false");
//		this.sarahsaurusFeathersOrScaled = buildBoolean(builder, "Sarahsaurus Scaled Texture", "all", true, "Toggles whether Sarahsaurus is scaley or feathered. False is feathered, true is scaley. Default is true");
		builder.pop();
		builder.push("Morrison");
//		this.dryosaurusFeathersOrScaled = buildBoolean(builder, "Dryosaurus Scaled Texture", "all", true, "Toggles whether Dryosaurus is scaley or feathered. False is feathered, true is scaley. Default is true");
		builder.pop();
		builder.push("Chinle");
		this.coelophysisFeathersOrScaled = buildBoolean(builder, "Coelophysis Scaled Texture", "all", false, "Toggles whether Coelophysis is scaley or feathered. False is feathered, true is scaley. Default is false");
		builder.pop();
		builder.push("Ischigualasto");
//		this.chromogisaurusFeathersOrScaled = buildBoolean(builder, "Chromogisaurus Scaled Texture", "all", false, "Toggles whether Chromogisaurus is scaley or feathered. False is feathered, true is scaley. Default is false");
//		this.herrerasaurusFeathersOrScaled = buildBoolean(builder, "Herrerasaurus Scaled Texture", "all", true, "Toggles whether Herrerasaurus is scaley or feathered. False is feathered, true is scaley. Default is true");
		builder.pop(2);
	}
	
	private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment){
		return builder.comment(comment).translation(name).define(name, defaultValue);
	}

}
