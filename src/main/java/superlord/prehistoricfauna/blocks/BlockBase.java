package superlord.prehistoricfauna.blocks;

import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.tab.PFTabRegistry;
import superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBase extends BlockContainer implements IHasModel {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockBase(String name, Material material) {
		super(material);
		setHardness(3f);
		setResistance(5f);
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(PFTabRegistry.NORMAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	public BlockBase(String name, Material material, boolean inCreativeTab) {
		super(material);
		setHardness(3f);
		setResistance(5f);
		setRegistryName(name);
		setTranslationKey(name);
		if (inCreativeTab)
			setCreativeTab(PFTabRegistry.NORMAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.byIndex(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	private void setDefaultFacing(World world, BlockPos pos, IBlockState state) {

		if (!world.isRemote) {

			IBlockState north = world.getBlockState(pos.north());

			IBlockState south = world.getBlockState(pos.south());

			IBlockState west = world.getBlockState(pos.west());

			IBlockState east = world.getBlockState(pos.east());

			EnumFacing facing = state.getValue(FACING);

			if (facing == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {

				facing = EnumFacing.SOUTH;

			} else if (facing == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) {

				facing = EnumFacing.NORTH;

			} else if (facing == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {

				facing = EnumFacing.EAST;

			} else if (facing == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {

				facing = EnumFacing.WEST;

			}

			world.setBlockState(pos, state.withProperty(FACING, facing), 2);

		}

	}
}
