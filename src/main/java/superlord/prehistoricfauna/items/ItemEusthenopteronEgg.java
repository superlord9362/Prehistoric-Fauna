package superlord.prehistoricfauna.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.entity.egg.EntityEusthenopteronEgg;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.tab.PFTabRegistry;
import superlord.prehistoricfauna.util.IHasModel;

public class ItemEusthenopteronEgg extends Item implements IHasModel
{
    public ItemEusthenopteronEgg(String name)
    {
        this.maxStackSize = 16;
        this.setCreativeTab(PFTabRegistry.EGG);
        ModItems.ITEMS.add(this);
        setTranslationKey(name);
        setRegistryName(name);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode)
        {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityEusthenopteronEgg entityegg = new EntityEusthenopteronEgg(worldIn, playerIn);
            entityegg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityegg);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

	@Override
	public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");		
	}
}