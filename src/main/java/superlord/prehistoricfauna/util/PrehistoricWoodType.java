package superlord.prehistoricfauna.util;

import java.util.Set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

public class PrehistoricWoodType extends WoodType {

	private static final Set<WoodType> VALUES = new ObjectArraySet<>();

	
	protected PrehistoricWoodType(String nameIn) {
		super(nameIn);
	}
	
	public static final WoodType METASEQUOIA = register(new PrehistoricWoodType("metasequoia"));
	public static final WoodType ARAUCARIA = register(new PrehistoricWoodType("araucaria"));
	
	private static WoodType register(WoodType woodTypeIn) {
	      VALUES.add(woodTypeIn);
	      return woodTypeIn;
	 }

}
