package superlord.prehistoricfauna.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFBlocks;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class CommonProxy {

	public void init() {
	}

	public void openPaleopediaGui(ItemStack book) {

	}
	
	public boolean shouldSeePaleopediaContents() {
		return true;
	}
	
	public BlockEntity getReferencedBE() {
		return null;
	}
	
	public void setReferencedBE(BlockEntity tileentity) {
		
	}
	
	public Player getClientSidePlayer() {
		return null;
	}
	
	public Object getArmorRenderProperties() {
        return null;
    }
	
	@SubscribeEvent
	public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
		if (event.getItemStack().getItem() == Items.BONE_MEAL) {
			boolean flag = false;
			Level world = event.getWorld();
			BlockPos pos = event.getPos();
			BlockState state = event.getWorld().getBlockState(event.getPos());
			Player player = event.getPlayer();
			if (state.getBlock() == Blocks.DIRT && world.getBlockState(pos.above()).getBlock() == Blocks.AIR) {
				for(BlockPos blockpos : BlockPos.betweenClosed(event.getPos().offset(-1, -1, -1), event.getPos().offset(1, 1, 1))) {
					BlockState blockstate = event.getWorld().getBlockState(blockpos);
					if (blockstate.is(PFBlocks.MOSSY_DIRT.get())) {
						flag = true;
					}
				}
				if (flag) {
					event.getWorld().setBlock(event.getPos(), PFBlocks.MOSSY_DIRT.get().defaultBlockState(), 3);
					double d0 = (double)pos.getX() + 0.5D;
					double d1 = (double)pos.getY() + 1.7D;
					double d2 = (double)pos.getZ() + 0.5D;
					world.addParticle(ParticleTypes.HAPPY_VILLAGER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
					if (!player.isCreative()) {
						event.getItemStack().shrink(1);
					}
				}
			}
		}
	}

}
