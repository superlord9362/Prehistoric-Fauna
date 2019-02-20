package superlord.prehistoricfauna.blocks;



import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.init.ModBlocks;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.util.IHasModel;


public class Mud extends BlockBase{

	public Mud(String name, Material material) {
		super(name, material);
	}

}