package com.superlord.prehistoricfauna.blocks;

import com.superlord.prehistoricfauna.Main;
import com.superlord.prehistoricfauna.init.ModBlocks;
import com.superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class DNAExtractor extends BlockContainer implements IHasModel {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    private static boolean keepInventory = false;

    public DNAExtractor(String name, Material material) {

        super(Material.IRON);

        this.setHardness(3.0F);

        this.setSoundType(SoundType.METAL);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public static void setState(boolean isActive, World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        keepInventory = true;
        world.setBlockState(pos, ModBlocks.DNA_EXTRACTOR.getDefaultState());
        keepInventory = false;
        if (tile != null) {
            tile.validate();
            world.setTileEntity(pos, tile);
        }
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.DNA_EXTRACTOR);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        super.onBlockAdded(world, pos, state);
        this.setDefaultFacing(world, pos, state);
    }

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

    @Override

    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if (stack.hasDisplayName()) {

            TileEntity tile = world.getTileEntity(pos);
        }
    }

    @Override

    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
    }

    @Override

    public boolean hasComparatorInputOverride(IBlockState state) {

        return true;
    }

    @Override

    public int getComparatorInputOverride(IBlockState state, World world, BlockPos pos) {

        return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
    }

    @Override

    @SideOnly(Side.CLIENT)

    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

        return new ItemStack(ModBlocks.DNA_EXTRACTOR);
    }

    @Override

    public IBlockState getStateFromMeta(int meta) {

        EnumFacing facing = EnumFacing.byIndex(meta);

        if (facing.getAxis() == EnumFacing.Axis.Y) {

            facing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override

    public int getMetaFromState(IBlockState state) {

        return state.getValue(FACING).getIndex();
    }

    @Override

    public IBlockState withRotation(IBlockState state, Rotation rotation) {

        return state.withProperty(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override

    public IBlockState withMirror(IBlockState state, Mirror mirror) {

        return state.withRotation(mirror.toRotation(state.getValue(FACING)));
    }

    @Override

    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, FACING);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}