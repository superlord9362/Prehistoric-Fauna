package superlord.prehistoricfauna.util;

import java.util.Set;
import java.util.stream.Stream;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

public class PFWoodTypes extends WoodType
{
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
	public static final WoodType ARAUCARIA = PFWoodTypes.register(new PFWoodTypes("araucaria"));
	
	private final String name;

	protected PFWoodTypes(String nameIn)
	{
		super(nameIn);
		this.name = nameIn;
	}

	private static WoodType register(WoodType woodTypeIn)
	{
		PFWoodTypes.VALUES.add(woodTypeIn);
		return woodTypeIn;
	}

	public static Stream<WoodType> getValues()
	{
		return PFWoodTypes.VALUES.stream();
	}

	@Override
	public String getName()
	{
		return this.name;
	}
}
