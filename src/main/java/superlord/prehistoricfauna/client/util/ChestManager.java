package superlord.prehistoricfauna.client.util;

import com.google.common.base.Suppliers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ChestManager {
	private static final Map<String, Supplier<ChestMaterials>> MATERIALS = new HashMap<>();

	public static synchronized String registerMaterials(String modId, String name, boolean trapped) {
		String chestType = trapped ? "trapped" : "normal";
		String registryName = modId + ":" + name + "_" + chestType;
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			MATERIALS.put(registryName, Suppliers.memoize(() -> {
				Material single = new Material(Sheets.CHEST_SHEET, new ResourceLocation(modId, "entity/chest/" + name + "/" + chestType));
				Material left = new Material(Sheets.CHEST_SHEET, new ResourceLocation(modId, "entity/chest/" + name + "/" + chestType + "_left"));
				Material right = new Material(Sheets.CHEST_SHEET, new ResourceLocation(modId, "entity/chest/" + name + "/" + chestType + "_right"));
				return new ChestMaterials(single, left, right);
			}));
		});
		return registryName;
	}

	@Nullable
	public static ChestMaterials getMaterials(String name) {
		return MATERIALS.get(name).get();
	}

	public record ChestMaterials(Material singleMaterial, Material leftMaterial, Material rightMaterial) {}
}
