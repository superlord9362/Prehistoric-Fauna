package superlord.prehistoricfauna.common.items;

import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.init.PFTags;

public class DinosaurEggItem extends BlockItem {

	public DinosaurEggItem(Block p_40565_, Properties p_40566_) {
		super(p_40565_, p_40566_);
	}
	
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		BlockHitResult raytraceresult = rayTrace(world, player, ClipContext.Block.OUTLINE);
		if (world.getBlockState(raytraceresult.getBlockPos()).is(PFTags.NESTS)) {
			return InteractionResultHolder.pass(null);
		}
		return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());
	}
	
	protected static BlockHitResult rayTrace(Level worldIn, Player player, ClipContext.Block blockMode) {
		float f = player.getXRot();
		float f1 = player.getYRot();
		Vec3 vector3d = player.getEyePosition(1.0F);
		float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
		float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.BLOCK_REACH.get()).getValue();;
		Vec3 vector3d1 = vector3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
		return worldIn.clip(new ClipContext(vector3d, vector3d1, blockMode, ClipContext.Fluid.ANY, player));
	}

}
