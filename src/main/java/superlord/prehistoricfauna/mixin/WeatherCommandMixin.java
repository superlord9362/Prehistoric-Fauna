package superlord.prehistoricfauna.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.commands.WeatherCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;

@Mixin(WeatherCommand.class)
public class WeatherCommandMixin {

	private static int getDuration(CommandSourceStack p_265382_, int p_265171_, IntProvider p_265122_) {
		return p_265171_ == -1 ? p_265122_.sample(p_265382_.getLevel().getRandom()) : p_265171_;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Inject(method = "Lnet/minecraft/server/commands/WeatherCommand;setClear(Lnet/minecraft/commands/CommandSourceStack;I)I", at = @At("HEAD"), cancellable = true)
	private static void setClear(CommandSourceStack p_139173_, int p_139174_, CallbackInfoReturnable cbi) {
		MinecraftServer server = p_139173_.getServer();
		for (ServerLevel serverLevel : server.getAllLevels()) {
			serverLevel.setWeatherParameters(getDuration(p_139173_, p_139174_, ServerLevel.RAIN_DELAY), 0, false, false);
			cbi.setReturnValue(p_139174_);
		}
		p_139173_.sendSuccess(() -> {
			return Component.translatable("commands.weather.set.clear");
		}, true);
		cbi.cancel();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Inject(method = "Lnet/minecraft/server/commands/WeatherCommand;setRain(Lnet/minecraft/commands/CommandSourceStack;I)I", at = @At("HEAD"), cancellable = true)
	private static void setRain(CommandSourceStack p_139173_, int p_139174_, CallbackInfoReturnable cbi) {
		MinecraftServer server = p_139173_.getServer();
		for (ServerLevel serverLevel : server.getAllLevels()) {
			serverLevel.setWeatherParameters(0, getDuration(p_139173_, p_139174_, ServerLevel.RAIN_DURATION), true, false);
			cbi.setReturnValue(p_139174_);
		}
		p_139173_.sendSuccess(() -> {
			return Component.translatable("commands.weather.set.rain");
		}, true);
		cbi.cancel();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Inject(method = "Lnet/minecraft/server/commands/WeatherCommand;setThunder(Lnet/minecraft/commands/CommandSourceStack;I)I", at = @At("HEAD"), cancellable = true)
	private static void setThunder(CommandSourceStack p_139173_, int p_139174_, CallbackInfoReturnable cbi) {
		MinecraftServer server = p_139173_.getServer();
		for (ServerLevel serverLevel : server.getAllLevels()) {
			serverLevel.setWeatherParameters(0, getDuration(p_139173_, p_139174_, ServerLevel.THUNDER_DURATION), true, true);
			cbi.setReturnValue(p_139174_);
		}
		p_139173_.sendSuccess(() -> {
	         return Component.translatable("commands.weather.set.thunder");
		}, true);
		cbi.cancel();
	}
}
