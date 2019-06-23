package superlord.prehistoricfauna.machines.combiner;

import java.util.Random;

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
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.blocks.BlockBase;
import superlord.prehistoricfauna.init.ModBlocks;
import superlord.prehistoricfauna.util.BlockEntity;
import superlord.prehistoricfauna.util.DefaultRenderedItem;
import superlord.prehistoricfauna.util.Reference;

public class Block_DNACombiner extends BlockBase implements DefaultRenderedItem, BlockEntity {

	private static boolean keepInventory = false;

	public Block_DNACombiner(boolean isActive) {
		super((isActive) ? "dna_combiner_on" : "dna_combiner", Material.IRON, !isActive);
		this.setSoundType(SoundType.METAL);

		if (isActive) {
			this.setLightLevel(0.9375F);
		}
	}

	public static void setState(boolean isActive, World world, BlockPos pos) {

		TileEntity tile = world.getTileEntity(pos);
		EnumFacing facing = EnumFacing.NORTH;

		if (world.getBlockState(pos).getBlock() instanceof Block_DNACombiner) {
			facing = world.getBlockState(pos).getValue(FACING);
		}

		keepInventory = true;

		if (isActive) {
			world.setBlockState(pos, ModBlocks.COMBINER_ACTIVE.getDefaultState().withProperty(FACING, facing));
		} else {
			world.setBlockState(pos, ModBlocks.COMBINER.getDefaultState().withProperty(FACING, facing));
		}

		keepInventory = false;
		if (tile != null) {
			tile.validate();
			world.setTileEntity(pos, tile);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return Item.getItemFromBlock(ModBlocks.COMBINER);
	}

	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {

		if (!world.isRemote) {

			player.openGui(Main.instance, Reference.GUI_DNA_COMBINER, world, pos.getX(), pos.getY(), pos.getZ());

		}

		return true;

	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {

		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {

			TileEntity tile = world.getTileEntity(pos);

			if (tile instanceof TileEntity_DNACombiner) {

				((TileEntity_DNACombiner) tile).setCustomName(stack.getDisplayName());

			}

		}

	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {

		this.dropInventory(world, pos);

		super.breakBlock(world, pos, state);

	}

	private void dropInventory(World world, BlockPos pos) {

		if (!keepInventory || !(world.getBlockState(pos).getBlock() instanceof Block_DNACombiner)) {

			TileEntity entity = world.getTileEntity(pos);

			if (entity == null) {

				return;

			}

			if (entity instanceof TileEntity_DNACombiner) {

				TileEntity_DNACombiner analyzer = (TileEntity_DNACombiner) entity;

				for (int i = 0; i < analyzer.getSizeInventory(); i++) {

					ItemStack stack = analyzer.getStackInSlot(i);

					if (!stack.isEmpty()) {

						InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);

					}

				}

			}

		}

	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {

		return new TileEntity_DNACombiner();

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
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {

		return new ItemStack(ModBlocks.COMBINER);

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
	public Class<? extends TileEntity> getEntity() {

		return TileEntity_DNACombiner.class;

	}
}
