package superlord.prehistoricfauna.client.util;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChestManager {
	private static final Map<String, ChestInfo> CHEST_INFO_MAP = new HashMap<>();

	public static synchronized void putChestInfo(String modId, String type, boolean trapped) {
		CHEST_INFO_MAP.put(modId + ":" + type + (trapped ? "_trapped" : ""), new ChestInfo(modId, type, trapped));
	}
	
	@Nullable
	public static ChestInfo getInfoForChest(String chestType) {
		return CHEST_INFO_MAP.get(chestType);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onStitch(TextureStitchEvent.Pre event) {
		if (event.getAtlas().location().equals(Sheets.CHEST_SHEET)) {
			for (ChestInfo chestInfo : CHEST_INFO_MAP.values()) {
				chestInfo.setup(event);
			}
		}
	}

	public static class ChestInfo {
		private final ResourceLocation single, left, right;
		@OnlyIn(Dist.CLIENT)
		private Material singleMaterial, leftMaterial, rightMaterial;

		public ChestInfo(String modId, String type, boolean trapped) {
			String chest = trapped ? "trapped" : "normal";
			this.single = new ResourceLocation(modId, "entity/chest/" + type + "/" + chest);
			this.left = new ResourceLocation(modId, "entity/chest/" + type + "/" + chest + "_left");
			this.right = new ResourceLocation(modId, "entity/chest/" + type + "/" + chest + "_right");
		}

		/**
		 * Adds the internal textures to the stitch event and initializes the {@link Material}s.
		 *
		 * @param event A {@link TextureStitchEvent.Pre} to setup this info from.
		 */
		@OnlyIn(Dist.CLIENT)
		private void setup(TextureStitchEvent.Pre event) {
			event.addSprite(this.single);
			event.addSprite(this.left);
			event.addSprite(this.right);
			this.singleMaterial = new Material(Sheets.CHEST_SHEET, this.single);
			this.leftMaterial = new Material(Sheets.CHEST_SHEET, this.left);
			this.rightMaterial = new Material(Sheets.CHEST_SHEET, this.right);
		}

		/**
		 * Gets this info's default/single {@link Material}.
		 *
		 * @return This info's default/single {@link Material}.
		 */
		@OnlyIn(Dist.CLIENT)
		public Material getSingleMaterial() {
			return this.singleMaterial;
		}

		/**
		 * Gets this info's left {@link Material}.
		 *
		 * @return This info's left {@link Material}.
		 */
		@OnlyIn(Dist.CLIENT)
		public Material getLeftMaterial() {
			return this.leftMaterial;
		}

		/**
		 * Gets this info's right {@link Material}.
		 *
		 * @return This info's right {@link Material}.
		 */
		@OnlyIn(Dist.CLIENT)
		public Material getRightMaterial() {
			return this.rightMaterial;
		}
	}
	
}
