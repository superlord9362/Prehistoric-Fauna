package superlord.prehistoricfauna.common.items;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;

public class PFStewItem extends BowlFoodItem {

	public PFStewItem(Properties p_40682_) {
		super(p_40682_);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void appendHoverText(ItemStack p_260314_, @Nullable Level p_259224_, List<Component> p_259700_, TooltipFlag p_260021_) {
	    super.appendHoverText(p_260314_, p_259224_, p_259700_, p_260021_);
	    List<MobEffectInstance> list = new ArrayList<>();

	    if (list.isEmpty() && this.getFoodProperties() != null) {
	        for (var pair : this.getFoodProperties().getEffects()) {
	            list.add(pair.getFirst());
	        }
	    }

	    PotionUtils.addPotionTooltip(list, p_259700_, 1.0F);
	}

}
