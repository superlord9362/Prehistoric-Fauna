package superlord.prehistoricfauna.entity.ai;



import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.util.math.AxisAlignedBB;

import net.minecraft.world.EnumDifficulty;
import superlord.prehistoricfauna.entity.EntityPrehistoric;
import superlord.prehistoricfauna.entity.EntityPrehistoricSwimming;
import superlord.prehistoricfauna.entity.FoodHelper;
import superlord.prehistoricfauna.entity.PrehistoricMoodType;

import java.util.function.Predicate;



public class DinoAIHunt<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {

	private final EntityPrehistoric dino;



	public DinoAIHunt(EntityPrehistoric entityIn, Class<T> classTarget, boolean checkSight, Predicate<? super T> targetSelector) {

		super(entityIn, classTarget, 0, checkSight, true, targetSelector::test);

		this.dino = entityIn;

	}



	@Override

	public boolean shouldExecute() {

		if (this.dino.isBeingRidden() || this.dino.isMovementBlocked()) {

			return false;

		}

		if (super.shouldExecute() && this.targetEntity != null && !this.targetEntity.getClass().equals(this.dino.getClass())) {

			if (this.dino.width * dino.getTargetScale() >= this.targetEntity.width || (dino.getMoodFace() == PrehistoricMoodType.ANGRY || dino.getMoodFace() == PrehistoricMoodType.SAD) && this.targetEntity instanceof EntityPlayer) {

				if (this.taskOwner instanceof EntityPrehistoric && !((EntityPrehistoric) this.taskOwner).isMovementBlocked()) {

					EntityPrehistoric prehistoric = (EntityPrehistoric) this.taskOwner;

					if (targetEntity instanceof EntityPlayer && ((EntityPlayer) targetEntity).isCreative()) {

						return false;

					}

					if (targetEntity instanceof EntityPlayer) {

						if (taskOwner.world.getDifficulty() == EnumDifficulty.PEACEFUL) {

							return false;

						}

						if (prehistoric.getMoodFace() == PrehistoricMoodType.ANGRY || prehistoric.getMoodFace() == PrehistoricMoodType.SAD && !prehistoric.isOwner(targetEntity)) {

							return true;

						} else if (prehistoric.getMood() > 25 && prehistoric.getMoodFace() != PrehistoricMoodType.CALM) {

							return false;

						} else {

							return !prehistoric.isOwner(targetEntity) && prehistoric.canDinoHunt(targetEntity, true);

						}

					}



					if (FoodHelper.getMobFoodPoints(targetEntity, dino.type.diet) > 0 || dino.aiResponseType() == PrehistoricEntityTypeAI.Response.AGRESSIVE) {

						return !prehistoric.isOwner(targetEntity) && prehistoric.canDinoHunt(targetEntity, true);

					}

					

				}

			}

		}

		return false;

	}



	@Override

	protected AxisAlignedBB getTargetableArea(double targetDistance){

		return this.taskOwner.getEntityBoundingBox().grow(targetDistance, (dino instanceof EntityPrehistoricSwimming) ? targetDistance : 4.0D, targetDistance);

	}

}