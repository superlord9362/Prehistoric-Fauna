package superlord.prehistoricfauna.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class CeratodusEntity extends AbstractFishEntity {

	public CeratodusEntity(EntityType<? extends AbstractFishEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 3.0D);
	}

   protected ItemStack getFishBucket() {
      return new ItemStack(PFItems.CERATODUS_BUCKET.get());
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
