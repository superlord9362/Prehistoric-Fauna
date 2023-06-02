package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

public class FossilCrateBlock extends Block {

	public FossilCrateBlock(Properties properties) {
		super(properties);
	}

	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		ItemStack stack = player.getItemInHand(hand);
		Item item = stack.getItem();
		if (item == PFItems.PROTOCERATOPS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.PROTOCERATOPS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.VELOCIRAPTOR_SKULL.get()) {
			world.setBlock(pos, PFBlocks.VELOCIRAPTOR_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.PLESIOHADROS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.PLESIOHADROS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.TRICERATOPS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.TRICERATOPS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.ANKYLOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.ANKYLOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.TYRANNOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.TYRANNOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.ALLOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.ALLOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.STEGOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.STEGOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.CERATOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.CERATOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.DILOPHOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.DILOPHOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.SCELIDOSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.SCELIDOSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.SARAHSAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.SARAHSAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.HERRERASAURUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.HERRERASAURUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.SAUROSUCHUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.SAUROSUCHUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.ISCHIGUALASTIA_SKULL.get()) {
			world.setBlock(pos, PFBlocks.ISCHIGUALASTIA_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.COELOPHYSIS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.COELOPHYSIS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.DESMATOSUCHUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.DESMATOSUCHUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else if (item == PFItems.POSTOSUCHUS_SKULL.get()) {
			world.setBlock(pos, PFBlocks.POSTOSUCHUS_CRATE.get().defaultBlockState(), 2);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		} else {
			return InteractionResult.PASS;
		}
	}

}
