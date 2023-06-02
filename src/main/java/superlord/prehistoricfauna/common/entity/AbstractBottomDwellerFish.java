package superlord.prehistoricfauna.common.entity;

import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public abstract class AbstractBottomDwellerFish extends AbstractFish {

	public AbstractBottomDwellerFish(EntityType<? extends AbstractFish> p_27461_, Level p_27462_) {
		super(p_27461_, p_27462_);
		this.moveControl = new AbstractBottomDwellerFish.MoveHelperController(this);
	}

	static class MoveHelperController extends MoveControl {
		private final AbstractBottomDwellerFish fish;

		MoveHelperController(AbstractBottomDwellerFish fish) {
			super(fish);
			this.fish = fish;
		}

		public void tick() {
			if (this.fish.isEyeInFluid(FluidTags.WATER)) {
				this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}

			if (this.operation == MoveControl.Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
				float f = (float)(this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
				double d0 = this.wantedX - this.fish.getX();
				double d2 = this.wantedZ - this.fish.getZ();
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.fish.setYRot(this.rotlerp(this.fish.getYRot(), f1, 90.0F));
					this.fish.yBodyRot = this.fish.getYRot();
					if (this.fish.horizontalCollision && this.fish.level.getBlockState(this.fish.blockPosition().above()).getBlock() == Blocks.WATER) {
						this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, 0.025D, 0.0D));
					}
				}
			} else {
				this.fish.setSpeed(0.0F);
			}
		}
	}

}
