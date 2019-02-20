package superlord.prehistoricfauna.blocks;

import net.minecraft.block.material.Material;

public class BlockLamp extends BlockBase {

	public BlockLamp(String name, Material material) {
		super(name, material);
		this.setLightLevel(1.0F);
		setHardness(1.5f);
		setResistance(3F);
	}

}
