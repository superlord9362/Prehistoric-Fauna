package superlord.prehistoricfauna.common.items;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;

public class PFBucketItem extends MobBucketItem {

	public PFBucketItem(Supplier<? extends EntityType<?>> entitySupplier, Supplier<? extends Fluid> fluidSupplier, Supplier<? extends SoundEvent> soundSupplier, Properties properties) {
		super(entitySupplier, fluidSupplier, soundSupplier, properties);
		this.entityTypeSupplier = entitySupplier;
	}

	private final Supplier<? extends EntityType<?>> entityTypeSupplier;
	protected EntityType<?> getEntityType() {
		return entityTypeSupplier.get();
	}

	public PFBucketItem(Supplier<? extends EntityType<?>> entitySupplier, Fluid p_151138_, SoundEvent p_151139_, Item.Properties p_151140_) {
		this(entitySupplier, () -> p_151138_, () -> p_151139_, p_151140_);
	}

}
