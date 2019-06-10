package superlord.prehistoricfauna.blocks;



import net.minecraft.block.material.Material;


public class Mud extends BlockBase{

	public Mud(String name, Material material) {
		super(name, material);
		setHardness(2.0F);
		setResistance(4.0F);
	}

}