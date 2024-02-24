package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class AraucariaConeBlock extends Block implements Fallable {

	public AraucariaConeBlock(BlockBehaviour.Properties p_53205_) {
		super(p_53205_);
	}

	public void onPlace(BlockState p_53233_, Level p_53234_, BlockPos p_53235_, BlockState p_53236_, boolean p_53237_) {
		p_53234_.scheduleTick(p_53235_, this, this.getDelayAfterPlace());
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState p_53226_, Direction p_53227_, BlockState p_53228_, LevelAccessor p_53229_, BlockPos p_53230_, BlockPos p_53231_) {
		p_53229_.scheduleTick(p_53230_, this, this.getDelayAfterPlace());
		return super.updateShape(p_53226_, p_53227_, p_53228_, p_53229_, p_53230_, p_53231_);
	}

	public void tick(BlockState p_53216_, ServerLevel p_53217_, BlockPos p_53218_, Random p_53219_) {
		if (isFree(p_53217_.getBlockState(p_53218_.below())) && p_53218_.getY() >= p_53217_.getMinBuildHeight()) {
			FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(p_53217_, p_53218_, p_53216_);
			this.falling(fallingblockentity);
		}
	}

	protected void falling(FallingBlockEntity p_53206_) {
		p_53206_.setHurtsEntities(1.0F, 40);
	}

	protected int getDelayAfterPlace() {
		return 2;
	}

	public static boolean isFree(BlockState p_53242_) {
		Material material = p_53242_.getMaterial();
		return p_53242_.isAir() || p_53242_.is(BlockTags.FIRE) || material.isLiquid() || material.isReplaceable();
	}

}
