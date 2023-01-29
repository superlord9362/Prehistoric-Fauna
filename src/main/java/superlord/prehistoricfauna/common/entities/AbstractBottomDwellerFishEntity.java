package superlord.prehistoricfauna.common.entities;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class AbstractBottomDwellerFishEntity extends AbstractFishEntity {

	public AbstractBottomDwellerFishEntity(EntityType<? extends AbstractBottomDwellerFishEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveController = new AbstractBottomDwellerFishEntity.MoveHelperController(this);
	}

	public static boolean canSpawn(EntityType<? extends AbstractBottomDwellerFishEntity> type, IWorld worldIn, SpawnReason reason, BlockPos p_223363_3_, Random randomIn) {
		return worldIn.getBlockState(p_223363_3_).isIn(Blocks.WATER) && worldIn.getBlockState(p_223363_3_.up()).isIn(Blocks.WATER);
	}

	static class MoveHelperController extends MovementController {
		private final AbstractBottomDwellerFishEntity fish;

		MoveHelperController(AbstractBottomDwellerFishEntity fish) {
			super(fish);
			this.fish = fish;
		}

		public void tick() {
			if (this.fish.areEyesInFluid(FluidTags.WATER)) {
				this.fish.setMotion(this.fish.getMotion().add(0.0D, -0.005D, 0.0D));
			}

			if (this.action == MovementController.Action.MOVE_TO && !this.fish.getNavigator().noPath()) {
				float f = (float)(this.speed * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.fish.setAIMoveSpeed(MathHelper.lerp(0.125F, this.fish.getAIMoveSpeed(), f));
				double d0 = this.posX - this.fish.getPosX();
				double d2 = this.posZ - this.fish.getPosZ();
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.fish.rotationYaw = this.limitAngle(this.fish.rotationYaw, f1, 90.0F);
					this.fish.renderYawOffset = this.fish.rotationYaw;
					if (this.fish.collidedHorizontally && this.fish.world.getBlockState(this.fish.getPosition().up()).getBlock() == Blocks.WATER) {
						this.fish.setMotion(this.fish.getMotion().add(0.0D, 0.025D, 0.0D));
					}
				}
			} else {
				this.fish.setAIMoveSpeed(0.0F);
			}
		}
	}
}

