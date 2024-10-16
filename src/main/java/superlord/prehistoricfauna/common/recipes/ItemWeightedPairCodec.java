package superlord.prehistoricfauna.common.recipes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class ItemWeightedPairCodec {

	@SuppressWarnings("deprecation")
	public static Codec<ItemWeightedPairCodec> CODEC = RecordCodecBuilder.create(inst -> inst.group(
			BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(i -> i.item),
			Codec.INT.fieldOf("weight").forGetter(w -> w.weight),
			Codec.INT.optionalFieldOf("amount", 1).forGetter(a -> a.amount)
			).apply(inst, ItemWeightedPairCodec::new));

	private Item item;
	private int weight;
	private int amount;

	public ItemWeightedPairCodec(Item item, int weight, int amount) {
		this.item = item;
		this.weight = weight;
		this.amount = amount;
	}

	public int getWeight() {
		return weight;
	}

	public Item getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}

	public static <T> Map<T, List<ItemWeightedPairCodec>> convertToMap(Map<T, List<ItemWeightedPairCodec>> map) {
		return map.entrySet().stream().collect(Collectors.toMap(
				Map.Entry::getKey,
				entry -> entry.getValue().stream()
				.map(itemWeightedPairCodec -> new ItemWeightedPairCodec(
						itemWeightedPairCodec.getItem(),
						itemWeightedPairCodec.getWeight(),
						itemWeightedPairCodec.getAmount()
						)).collect(Collectors.toList())
				));
	}

	public static <T> Map<T, List<ItemWeightedPairCodec>> convertFromMap(Map<T, List<ItemWeightedPairCodec>> map) {
		return map.entrySet().stream().collect(Collectors.toMap(
				Map.Entry::getKey, 
				entry -> entry.getValue().stream()
				.map(itemWeightedPair -> new ItemWeightedPairCodec(
						itemWeightedPair.getItem(),
						itemWeightedPair.getWeight(),
						itemWeightedPair.getAmount()
						)).collect(Collectors.toList())
				));
	}
}
