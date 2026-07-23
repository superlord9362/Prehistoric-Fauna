package superlord.prehistoricfauna.common.entity.fossil.jurassic;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.entity.fossil.FossilEntity;
import superlord.prehistoricfauna.init.PFItems;

public class ChuandongocoelurusSkeleton extends FossilEntity {

	public enum SkeletonPose {
		IDLE, ALERT, EATING, ATTACK, WALKING, RUNNING, SITTING, SLEEPING, DEAD;

		public SkeletonPose next() {
			SkeletonPose[] values = values();
			return values[(this.ordinal() + 1) % values.length];
		}
	}


	@Override
    protected String defaultPoseName() {
        return SkeletonPose.IDLE.name();
    }

    @Override
    protected String nextPoseName(String current) {
        try {
            return SkeletonPose.valueOf(current).next().name();
        } catch (IllegalArgumentException e) {
            return SkeletonPose.IDLE.name();
        }
    }

	public ChuandongocoelurusSkeleton(EntityType<? extends ChuandongocoelurusSkeleton> type, Level worldIn) {
		super(type, worldIn);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
	}

	@Override
	public void spawnFossil(DamageSource source) {
		Block.popResource(this.level(), this.blockPosition(), new ItemStack(PFItems.CHUANDONGOCOELURUS_SKELETON.get()));
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CHUANDONGOCOELURUS_SKELETON.get());
	}
	
}