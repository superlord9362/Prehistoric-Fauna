package superlord.prehistoricfauna.common.entities.fish;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class CeratodusEntity extends AbstractFishEntity {

	public CeratodusEntity(EntityType<? extends AbstractFishEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveController = new MoveHelperController(this);
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 3.0D);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NOT_SPECTATING::test));
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 1));
	}

	public void travel(Vector3d travelVector) {
		if (this.isServerWorld() && this.isInWater()) {
			this.moveRelative(this.getAIMoveSpeed(), travelVector);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale(0.9D));
			if (this.getAttackTarget() == null) {
				this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
			}
		} else {
			super.travel(travelVector);
		}
	}

	static class MoveHelperController extends MovementController {
		private final CeratodusEntity ceratodus;

		public MoveHelperController(CeratodusEntity ceratodus) {
			super(ceratodus);
			this.ceratodus = ceratodus;
		}

		public void tick() {
			if (this.ceratodus.isInWater()) {
				this.ceratodus.setMotion(this.ceratodus.getMotion().add(0.0D, 0.005D, 0.0D));
			}

			if (this.action == MovementController.Action.MOVE_TO && !this.ceratodus.getNavigator().noPath()) {
				double d0 = this.posX - this.ceratodus.getPosX();
				double d1 = this.posY - this.ceratodus.getPosY();
				double d2 = this.posZ - this.ceratodus.getPosZ();
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				if (d3 < (double)2.5000003E-7F) {
					this.mob.setMoveForward(0.0F);
				} else {
					float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.ceratodus.rotationYaw = this.limitAngle(this.ceratodus.rotationYaw, f, 10.0F);
					this.ceratodus.renderYawOffset = this.ceratodus.rotationYaw;
					this.ceratodus.rotationYawHead = this.ceratodus.rotationYaw;
					float f1 = (float)(this.speed * this.ceratodus.getAttributeValue(Attributes.MOVEMENT_SPEED));
					if (this.ceratodus.isInWater()) {
						this.ceratodus.setAIMoveSpeed(f1 * 0.02F);
						float f2 = -((float)(MathHelper.atan2(d1, (double)MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double)(180F / (float)Math.PI)));
						f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
						this.ceratodus.rotationPitch = this.limitAngle(this.ceratodus.rotationPitch, f2, 5.0F);
						float f3 = MathHelper.cos(this.ceratodus.rotationPitch * ((float)Math.PI / 180F));
						float f4 = MathHelper.sin(this.ceratodus.rotationPitch * ((float)Math.PI / 180F));
						this.ceratodus.moveForward = f3 * f1;
						this.ceratodus.moveVertical = -f4 * f1;
					} else {
						this.ceratodus.setAIMoveSpeed(f1 * 0.1F);
					}

				}
			} else {
				this.ceratodus.setAIMoveSpeed(0.0F);
				this.ceratodus.setMoveStrafing(0.0F);
				this.ceratodus.setMoveVertical(0.0F);
				this.ceratodus.setMoveForward(0.0F);
			}
		}
	}

	protected ItemStack getFishBucket() {
		return new ItemStack(PFItems.CERATODUS_BUCKET.get());
	}

	public static boolean func_223363_b(EntityType<? extends AbstractFishEntity> type, IWorld worldIn, SpawnReason reason, BlockPos p_223363_3_, Random randomIn) {
		return worldIn.getBlockState(p_223363_3_).isIn(Blocks.WATER);
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.CERATODUS_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.CERATODUS_HURT;
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundInit.FISH_FLOP;
	}

}
