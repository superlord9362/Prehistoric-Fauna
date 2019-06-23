
package superlord.prehistoricfauna.blocks;



import net.minecraft.block.Block;

import net.minecraft.block.BlockFenceGate;

import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;

import net.minecraft.block.state.BlockFaceShape;

import net.minecraft.block.state.BlockStateContainer;

import net.minecraft.block.state.IBlockState;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.util.EnumFacing;

import net.minecraft.util.math.AxisAlignedBB;

import net.minecraft.util.math.BlockPos;

import net.minecraft.world.IBlockAccess;

import net.minecraftforge.fml.relauncher.Side;

import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.util.IHasModel;



import javax.annotation.Nullable;



public class BlockModWall extends BlockBase implements IHasModel {


    protected static final AxisAlignedBB[] AABB_BY_INDEX = new AxisAlignedBB[]{new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D), new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 1.0D, 0.875D, 0.6875D), new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};

    protected static final AxisAlignedBB[] CLIP_AABB_BY_INDEX = new AxisAlignedBB[]{AABB_BY_INDEX[0].setMaxY(1.5D), AABB_BY_INDEX[1].setMaxY(1.5D), AABB_BY_INDEX[2].setMaxY(1.5D), AABB_BY_INDEX[3].setMaxY(1.5D), AABB_BY_INDEX[4].setMaxY(1.5D), AABB_BY_INDEX[5].setMaxY(1.5D), AABB_BY_INDEX[6].setMaxY(1.5D), AABB_BY_INDEX[7].setMaxY(1.5D), AABB_BY_INDEX[8].setMaxY(1.5D), AABB_BY_INDEX[9].setMaxY(1.5D), AABB_BY_INDEX[10].setMaxY(1.5D), AABB_BY_INDEX[11].setMaxY(1.5D), AABB_BY_INDEX[12].setMaxY(1.5D), AABB_BY_INDEX[13].setMaxY(1.5D), AABB_BY_INDEX[14].setMaxY(1.5D), AABB_BY_INDEX[15].setMaxY(1.5D)};



    public BlockModWall(String name, Material material) {
        super(name, material);

        setCreativeTab(CreativeTabs.DECORATIONS);
    }





    public static void initWall(Block base, int meta, Block block) {
    
    }


    @Override

    public boolean isFullCube(IBlockState state) {

        return false;

    }



    @Override

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {

        return false;

    }



    @Override

    public boolean isOpaqueCube(IBlockState state) {

        return false;

    }



    private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {

        IBlockState iblockstate = worldIn.getBlockState(pos);

        Block block = iblockstate.getBlock();

        BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, pos, facing);

        boolean flag = blockfaceshape == BlockFaceShape.MIDDLE_POLE_THICK || blockfaceshape == BlockFaceShape.MIDDLE_POLE && (block instanceof BlockFenceGate);

        return flag;
    }



    @SuppressWarnings("deprecation")
	@Override

    @SideOnly(Side.CLIENT)

    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {

        return side != EnumFacing.DOWN || super.shouldSideBeRendered(blockState, blockAccess, pos, side);

    }

    @Override

    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {

        return true;

    }



    @Override

    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing) {

        return facing != EnumFacing.UP && facing != EnumFacing.DOWN ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;

    }





    /* ======================================== FORGE START ======================================== */



    @Override

    public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {

        Block connector = world.getBlockState(pos.offset(facing)).getBlock();

        return connector instanceof BlockWall || connector instanceof BlockFenceGate || connector instanceof BlockModWall;

    }



    private boolean canWallConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {

        BlockPos other = pos.offset(facing);

        Block block = world.getBlockState(other).getBlock();

        return block.canBeConnectedTo(world, other, facing.getOpposite()) || canConnectTo(world, other, facing.getOpposite());

    }



}