package superlord.prehistoricfauna.common.items;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;

public class PaleopediaItem extends Item {
	
	public PaleopediaItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
	
	@Override
    public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
        stack.setTag(new CompoundTag());
        stack.getTag().putIntArray("Pages", new int[]{0});

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemStackIn = playerIn.getItemInHand(handIn);
        if (worldIn.isClientSide) {
			PrehistoricFauna.PROXY.openPaleopediaGui(itemStackIn);
        }
        return InteractionResultHolder.consume(itemStackIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (stack.getTag() == null) {
            stack.setTag(new CompoundTag());
            stack.getTag().putIntArray("Pages", new int[]{EnumPaleoPages.INTRODUCTION.ordinal()});

        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (stack.getTag() != null) {
        	if (PrehistoricFauna.PROXY.shouldSeePaleopediaContents()) {
                tooltip.add(Component.translatable("paleopedia.contains").withStyle(ChatFormatting.GRAY));
                final Set<EnumPaleoPages> pages = EnumPaleoPages.containedPages(Ints.asList(stack.getTag().getIntArray("Pages")));  
                for (EnumPaleoPages page : pages) {
                    tooltip.add(Component.translatable(ChatFormatting.WHITE + "-").append(Component.translatable("paleopedia." + EnumPaleoPages.values()[page.ordinal()].toString().toLowerCase())).withStyle(ChatFormatting.GRAY));
                }
            } else {
                tooltip.add(Component.translatable("paleopedia.hold_shift").withStyle(ChatFormatting.GRAY));
            }

        }
    }

}
