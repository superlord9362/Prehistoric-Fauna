package superlord.prehistoricfauna.common.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import superlord.prehistoricfauna.init.PFEffects;

public class HorsetailTeaItem extends Item {

	public HorsetailTeaItem(Item.Properties builder) {
		super(builder);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entityLiving) {
		if (!world.isRemote) {
			entityLiving.removePotionEffect(Effects.POISON);
			entityLiving.removePotionEffect(PFEffects.BLEEDING.get());
		}
		if (entityLiving instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity)entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
			serverPlayer.addStat(Stats.ITEM_USED.get(this));
		}
		if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
			stack.shrink(1);
			float playerHealth = entityLiving.getHealth();
			float playerMaxHealth = entityLiving.getMaxHealth();
			if (playerHealth < playerMaxHealth) {
				entityLiving.heal(1);
			}
		}
		return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		return DrinkHelper.startDrinking(world, player, hand);
	}

	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @javax.annotation.Nullable net.minecraft.nbt.CompoundNBT nbt) {
		return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
	}

}
