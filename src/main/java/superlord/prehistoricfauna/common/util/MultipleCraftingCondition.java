package superlord.prehistoricfauna.common.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import superlord.prehistoricfauna.PrehistoricFauna;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

import java.util.ArrayList;
import java.util.List;

public final class MultipleCraftingCondition implements ICondition {
	private static final ResourceLocation NAME = new ResourceLocation(PrehistoricFauna.MOD_ID, "multiple");
	private final List<ICondition> children;

	@Deprecated
	public MultipleCraftingCondition(ResourceLocation location, List<ICondition> children) {
		this(children);
	}

	public MultipleCraftingCondition(List<ICondition> children) {
		this.children = children;
	}

	public MultipleCraftingCondition(ICondition... children) {
		this(List.of(children));
	}

	@Override
	public ResourceLocation getID() {
		return NAME;
	}

	@Override
	public boolean test(IContext context) {
		return !this.children.isEmpty();
	}

	public static class Serializer implements IConditionSerializer<MultipleCraftingCondition> {
		@SuppressWarnings("unused")
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(PrehistoricFauna.MOD_ID, "multiple");
		}

		@Override
		public void write(JsonObject json, MultipleCraftingCondition value) {
			JsonArray values = new JsonArray();
			for (ICondition child : value.children) {
				values.add(CraftingHelper.serialize(child));
			}
			json.add("values", values);
		}

		@Override
		public MultipleCraftingCondition read(JsonObject json) {
			List<ICondition> children = new ArrayList<>();
			for (JsonElement elements : GsonHelper.getAsJsonArray(json, "values")) {
				if (!elements.isJsonObject()) {
					throw new JsonSyntaxException("And condition values must be an array of JsonObjects");
				}
				ICondition condition = CraftingHelper.getCondition(elements.getAsJsonObject());
				if (!condition.test(IContext.EMPTY)) {
					children.clear();
					break;
				} else {
					children.add(condition);
				}
			}
			return new MultipleCraftingCondition(children);
		}

		@Override
		public ResourceLocation getID() {
			return NAME;
		}
	}
}