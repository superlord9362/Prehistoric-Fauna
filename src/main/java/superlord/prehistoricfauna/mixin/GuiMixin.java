package superlord.prehistoricfauna.mixin;

import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.world.entity.player.Player;
import superlord.prehistoricfauna.client.render.BleedingHeartType;
import superlord.prehistoricfauna.init.PFEffects;

@Mixin(Gui.class)
public class GuiMixin extends GuiComponent
{
        //custom logic for when your hearts take priority, my heart types are ordered above Poison and Withering but below Frozen, also never override Absorb hearts
	private static boolean drawForHeartType(Gui.HeartType type)
	{
		if (type == Gui.HeartType.CONTAINER || type == Gui.HeartType.ABSORBING || type == Gui.HeartType.FROZEN)
		{
			return false;
		}
		return true;
	}
	
        //quick check for multiple effects, if you have only one you dont need this and can just do a player.hasEffect check
	private static boolean hasAnyCustomJurassicHearts(Player player)
	{
		if (player.hasEffect(PFEffects.BLEEDING.get()))
		{
			return true;
		}
		return false;
	}
	
        //I hate unmapped long methods so I mapped it for myself here
	private static void mappedBlit(PoseStack poseStack, int posX, int posY, float textureX, float textureY, int u, int v, int atlasWidth, int atlasHeight)
	{
		blit(poseStack, posX, posY, 0, textureX, textureY, u, v, atlasWidth, atlasHeight);
	}
	
	@Inject(method = "renderHeart()V", at = @At("HEAD"), cancellable = true)
	private void renderHeart(PoseStack stack, Gui.HeartType __, int x, int y, int v, boolean blinking, boolean halfHeart, CallbackInfo cbi)
	{
		if (!blinking && drawForHeartType(__) && Minecraft.getInstance().cameraEntity instanceof Player player && hasAnyCustomJurassicHearts(player))
		{
			BleedingHeartType type = BleedingHeartType.getType(player);
			if (type != null)
			{
				boolean hardcore = player.level.getLevelData().isHardcore();
				Pair<Integer, Integer> pos = type.getHeartPos(hardcore);
				if (halfHeart)
				{
					pos = type.getHalfHeartPos(hardcore);
				}
				
				RenderSystem.setShaderTexture(0, BleedingHeartType.ATLAS);
				mappedBlit(stack, x, y, pos.getLeft(), pos.getRight(), 9, 9, BleedingHeartType.ATLAS_W, BleedingHeartType.ATLAS_H);
				RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
				
				cbi.cancel();
			}
		}
	}
}