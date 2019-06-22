package superlord.prehistoricfauna.machines.culturevat;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.blocks.BlockBase;
import superlord.prehistoricfauna.init.ModBlocks;
import superlord.prehistoricfauna.util.BlockEntity;
import superlord.prehistoricfauna.util.DefaultRenderedItem;
import superlord.prehistoricfauna.util.Reference;

import java.util.List;
import java.util.Random;

public class Block_CultureVat extends BlockBase implements DefaultRenderedItem, BlockEntity {

    private static boolean keepInventory = false;

    public Block_CultureVat(boolean isActive) {
    	super((isActive) ? "cultivate_active" : "cultivate", Material.IRON, !isActive);
        this.setSoundType(SoundType.GLASS);
        
		if (isActive) {
			this.setLightLevel(0.9375F);
		}
    }

	public static void setState(boolean isActive, World world, BlockPos pos) {

		TileEntity tile = world.getTileEntity(pos);
		EnumFacing facing = EnumFacing.NORTH;

		if (world.getBlockState(pos).getBlock() instanceof Block_CultureVat) {
			facing = world.getBlockState(pos).getValue(FACING);
		}

		keepInventory = true;

		if (isActive) {
			world.setBlockState(pos, ModBlocks.CULTURE_VAT_ACTIVE.getDefaultState().withProperty(FACING, facing));
		} else {
			world.setBlockState(pos, ModBlocks.CULTURE_VAT.getDefaultState().withProperty(FACING, facing));
		}

		keepInventory = false;
		if (tile != null) {
			tile.validate();
			world.setTileEntity(pos, tile);
		}
	}
	
    public void onBlockRemovalLost(World world, BlockPos pos, boolean isActive) {
        keepInventory = false;

        List<EntityPlayer> nearby = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos.getX() - 50.0, pos.getY() - 50.0, pos.getZ() - 50.0, pos.getX() + 50.0, pos.getY() + 50.0, pos.getZ() + 50.0));
        for (EntityPlayer player : nearby) {
            player.sendStatusMessage(new TextComponentTranslation("cultivate.outBreak"), false);
        }

        this.returnIron(world, pos);
        this.dropInventory(world, pos);
    }

    private void returnIron(World world, BlockPos pos) {
        Random rand = new Random();
        ItemStack stack = new ItemStack(Items.IRON_INGOT, 1 + world.rand.nextInt(2));
        float offsetX = rand.nextFloat() * 0.8F + 0.1F;
        float offsetY = rand.nextFloat() * 0.8F + 0.1F;
        float offsetZ = rand.nextFloat() * 0.8F + 0.1F;
        EntityItem item = new EntityItem(world, (double) ((float) pos.getX() + offsetX), (double) ((float) pos.getY() + offsetY), (double) ((float) pos.getZ() + offsetZ), stack);
        float motionMutlipler = 0.05F;
        item.motionX = (double) ((float) rand.nextGaussian() * motionMutlipler);
        item.motionY = (double) ((float) rand.nextGaussian() * motionMutlipler + 0.2F);
        item.motionZ = (double) ((float) rand.nextGaussian() * motionMutlipler);
        world.spawnEntity(item);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.CULTURE_VAT);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(Main.instance, Reference.GUI_CULTIVATE, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName()) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof TileEntityCultureVat) {
                ((TileEntityCultureVat) tile).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        this.dropInventory(world, pos);
        super.breakBlock(world, pos, state);
    }

    private void dropInventory(World world, BlockPos pos) {
        if (!keepInventory) {
            TileEntity entity = world.getTileEntity(pos);
            if (entity == null) {
                return;
            }

            IItemHandler inventory = entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            if (inventory == null) {
                return;
            }

            for (int i = 0; i < inventory.getSlots(); i++) {
                ItemStack stack = inventory.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                }
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityCultureVat();
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
        return new ItemStack(ModBlocks.CULTURE_VAT);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public Class<? extends TileEntity> getEntity() {
        return TileEntityCultureVat.class;
    }
}
