package superlord.prehistoricfauna.common.entity.block.recipe;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;

public class PaleontologyTableResult
{
	private static final Random random = new Random();

	private final NavigableMap<Float, ItemStack> results;
	private final float total;

	private PaleontologyTableResult(NavigableMap<Float, ItemStack> results, float total)
	{
		this.results = results;
		this.total = total;
	}

	public ItemStack next(Random rand)
	{
		return this.results.higherEntry(rand.nextFloat() * this.total).getValue();
	}

	public ItemStack next()
	{
		return this.next(PaleontologyTableResult.random);
	}

	public static PaleontologyTableResult read(FriendlyByteBuf buffer)
	{
		PaleontologyTableResult.Builder builder = new PaleontologyTableResult.Builder();

		int resultListSize = buffer.readInt();
		for (int i = 0; i < resultListSize; ++i)
		{
			ItemStack result = buffer.readItem();
			float weight = buffer.readFloat();
			builder.add(weight, result);
		}

		return builder.build();
	}

	public void write(FriendlyByteBuf buffer)
	{
		buffer.writeInt(this.results.size());

		for (Entry<Float, ItemStack> entry : this.results.entrySet())
		{
			buffer.writeItem(entry.getValue());
			buffer.writeFloat(entry.getKey());
		}
	}

	public static class Builder
	{
		private NavigableMap<Float, ItemStack> results = new TreeMap<Float, ItemStack>();
		private float total = 0.0F;

		public Builder add(float weight, ItemStack result)
		{
			if (weight <= 0)
				return this;

			this.total += weight;
			this.results.put(this.total, result);
			return this;
		}

		public Builder add(ItemStack result)
		{
			return this.add(1.0F, result);
		}

		public PaleontologyTableResult build()
		{
			return new PaleontologyTableResult(this.results, this.total);
		}
	}
}
