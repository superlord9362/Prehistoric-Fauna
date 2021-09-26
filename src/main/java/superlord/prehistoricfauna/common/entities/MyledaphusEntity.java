package superlord.prehistoricfauna.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class MyledaphusEntity extends AbstractBottomDwellerFishEntity {
   public MyledaphusEntity(EntityType<? extends MyledaphusEntity> p_i50279_1_, World p_i50279_2_) {
      super(p_i50279_1_, p_i50279_2_);
   }
   
   public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 3.0D);
	}

   protected ItemStack getFishBucket() {
      return new ItemStack(PFItems.MYLEDAPHUS_BUCKET.get());
   }

   protected SoundEvent getDeathSound() {
      return SoundInit.MYLEDAPHUS_DEATH;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundInit.MYLEDAPHUS_HURT;
   }

   protected SoundEvent getFlopSound() {
      return SoundInit.FISH_FLOP;
   }
}
