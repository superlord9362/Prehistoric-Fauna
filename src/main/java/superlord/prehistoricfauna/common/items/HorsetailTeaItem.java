package superlord.prehistoricfauna.common.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.init.PFEffects;

public class HorsetailTeaItem extends Item {

	public HorsetailTeaItem(Item.Properties p_42921_) {
		super(p_42921_);
	}

	public ItemStack finishUsingItem(ItemStack p_42923_, Level p_42924_, LivingEntity p_42925_) {
		if (!p_42924_.isClientSide) {
			p_42925_.removeEffect(MobEffects.POISON);
			p_42925_.removeEffect(PFEffects.BLEEDING.get());
		}
		if (p_42925_ instanceof ServerPlayer) {
			ServerPlayer serverplayer = (ServerPlayer)p_42925_;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_42923_);
			serverplayer.awardStat(Stats.ITEM_USED.get(this));
		}

		if (p_42925_ instanceof Player && !((Player)p_42925_).getAbilities().instabuild) {
			p_42923_.shrink(1);
			float playerHealth = p_42925_.getHealth();
			float playerMaxHealth = p_42925_.getMaxHealth();
			if (playerHealth < playerMaxHealth) {
				p_42925_.heal(1);
			}
		}

		return p_42923_.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : p_42923_;
	}

	public int getUseDuration(ItemStack p_42933_) {
		return 32;
	}

	public UseAnim getUseAnimation(ItemStack p_42931_) {
		return UseAnim.DRINK;
	}

	public InteractionResultHolder<ItemStack> use(Level p_42927_, Player p_42928_, InteractionHand p_42929_) {
		return ItemUtils.startUsingInstantly(p_42927_, p_42928_, p_42929_);
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @javax.annotation.Nullable net.minecraft.nbt.CompoundTag nbt) {
		return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
	}

}
