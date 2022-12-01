package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

public class FossilCrateBlock extends Block {
	public FossilCrateBlock(AbstractBlock.Properties properties) {
		super(properties);
	}

	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItem(hand);
		Item item = stack.getItem();
		if (item == PFItems.PROTOCERATOPS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.PROTOCERATOPS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.VELOCIRAPTOR_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.VELOCIRAPTOR_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.ANKYLOSAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.ANKYLOSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.TRICERATOPS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.TRICERATOPS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.TYRANNOSAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.TYRANNOSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.ALLOSAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.ALLOSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.CERATOSAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.CERATOSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.STEGOSAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.STEGOSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.HERRERASAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.HERRERASAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.ISCHIGUALASTIA_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.ISCHIGUALASTIA_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.SAUROSUCHUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.SAUROSUCHUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.COELOPHYSIS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.COELOPHYSIS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.PLESIOHADROS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.PLESIOHADROS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.DESMATOSUCHUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.DESMATOSUCHUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.POSTOSUCHUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.POSTOSUCHUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.SARAHSAURUS_SKULL.get()) {
			world.setBlockState(pos, PFBlocks.SARAHSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else if (item == PFItems.DILOPHOSAURUS_SKELETON.get()) {
			world.setBlockState(pos, PFBlocks.DILOPHOSAURUS_CRATE.getDefaultState());
			if (!player.abilities.isCreativeMode) {
				stack.shrink(1);
			}
			return ActionResultType.func_233537_a_(world.isRemote);
		} else {
			return ActionResultType.PASS;
		}
	}

}
