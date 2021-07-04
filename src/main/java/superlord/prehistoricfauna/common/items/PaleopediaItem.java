package superlord.prehistoricfauna.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.PrehistoricFauna.PFMisc;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;

import javax.annotation.Nullable;
import java.util.List;

public class PaleopediaItem extends Item {
	
	public PaleopediaItem() {
		super(new Item.Properties().group(PFMisc.instance).maxStackSize(1).rarity(Rarity.UNCOMMON));
	}
	
	@Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.setTag(new CompoundNBT());
        stack.getTag().putIntArray("Pages", new int[]{0});

    }

    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
            items.add(new ItemStack(this));
            ItemStack stack = new ItemStack(PFItems.PALEOPEDIA.get());
            stack.setTag(new CompoundNBT());
            int[] pages = new int[EnumPaleoPages.values().length];
            for (int i = 0; i < EnumPaleoPages.values().length; i++) {
                pages[i] = i;
            }
            stack.getTag().putIntArray("Pages", pages);
            items.add(stack);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        if (worldIn.isRemote) {
			PrehistoricFauna.PROXY.openPaleopediaGui(itemStackIn);
        }
        return new ActionResult<ItemStack>(ActionResultType.PASS, itemStackIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (stack.getTag() == null) {
            stack.setTag(new CompoundNBT());
            stack.getTag().putIntArray("Pages", new int[]{EnumPaleoPages.INTRODUCTION.ordinal()});

        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (stack.getTag() != null) {
        	if (PrehistoricFauna.PROXY.shouldSeePaleopediaContents()) {
                tooltip.add(new TranslationTextComponent("paleopedia.contains").mergeStyle(TextFormatting.GRAY));
                List<EnumPaleoPages> pages = EnumPaleoPages.containedPages(EnumPaleoPages.toList(stack.getTag().getIntArray("Pages")));
                for (EnumPaleoPages page : pages) {
                    tooltip.add(new StringTextComponent(TextFormatting.WHITE + "-").append(new TranslationTextComponent("paleopedia." + EnumPaleoPages.values()[page.ordinal()].toString().toLowerCase())).mergeStyle(TextFormatting.GRAY));
                }
            } else {
                tooltip.add(new TranslationTextComponent("paleopedia.hold_shift").mergeStyle(TextFormatting.GRAY));
            }

        }
    }

}
