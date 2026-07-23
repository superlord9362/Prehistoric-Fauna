package superlord.prehistoricfauna.common.items;

import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFSounds;

public class DilophosaurusCrestItem extends Item {

	public DilophosaurusCrestItem(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}

	public InteractionResultHolder<ItemStack> use(Level p_220123_, Player p_220124_, InteractionHand p_220125_) {
		ItemStack itemstack = p_220124_.getItemInHand(p_220125_);
		p_220124_.startUsingItem(p_220125_);
		play(p_220123_, p_220124_);
		p_220124_.getCooldowns().addCooldown(this, 140);
		p_220124_.awardStat(Stats.ITEM_USED.get(this));
		return InteractionResultHolder.consume(itemstack);
	}

	public int getUseDuration(ItemStack p_220131_) {
		return 140;
	}

	public UseAnim getUseAnimation(ItemStack p_220133_) {
		return UseAnim.TOOT_HORN;
	}

	private static void play(Level p_220127_, Player p_220128_) {
		p_220127_.playSound(p_220128_, p_220128_, PFSounds.DILOPHOSAURUS_CONCH.get(), SoundSource.RECORDS, 16, 1.0F);
		p_220127_.gameEvent(GameEvent.INSTRUMENT_PLAY, p_220128_.position(), GameEvent.Context.of(p_220128_));
		for (LivingEntity entity : p_220127_.getEntitiesOfClass(LivingEntity.class, p_220128_.getBoundingBox().inflate(16, 16, 16))) {
			if (!(entity instanceof Player)) entity.addEffect(new MobEffectInstance(PFEffects.HEARD_DILOPHOSAURUS.get(), 200, 0, true, false, false));
		}
	}

}
