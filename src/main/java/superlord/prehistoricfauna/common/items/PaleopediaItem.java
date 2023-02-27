package superlord.prehistoricfauna.common.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;

public class PaleopediaItem extends Item {
	
	public PaleopediaItem() {
		super(new Item.Properties().tab(PrehistoricFauna.PF_MISC).stacksTo(1).rarity(Rarity.UNCOMMON));
	}
	
	@Override
    public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
        stack.setTag(new CompoundTag());
        stack.getTag().putIntArray("Pages", new int[]{0});

    }

    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (this.allowdedIn(group)) {
            items.add(new ItemStack(this));
            ItemStack stack = new ItemStack(PFItems.PALEOPEDIA.get());
            stack.setTag(new CompoundTag());
            int[] pages = new int[EnumPaleoPages.values().length];
            for (int i = 0; i < EnumPaleoPages.values().length; i++) {
                pages[i] = i;
            }
            stack.getTag().putIntArray("Pages", pages);
            items.add(stack);
        }
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
                tooltip.add(new TranslatableComponent("paleopedia.contains").withStyle(ChatFormatting.GRAY));
                List<EnumPaleoPages> pages = EnumPaleoPages.containedPages(EnumPaleoPages.toList(stack.getTag().getIntArray("Pages")));
                for (EnumPaleoPages page : pages) {
                    tooltip.add(new TranslatableComponent(ChatFormatting.WHITE + "-").append(new TranslatableComponent("paleopedia." + EnumPaleoPages.values()[page.ordinal()].toString().toLowerCase())).withStyle(ChatFormatting.GRAY));
                }
            } else {
                tooltip.add(new TranslatableComponent("paleopedia.hold_shift").withStyle(ChatFormatting.GRAY));
            }

        }
    }

}
