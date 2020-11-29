package superlord.prehistoricfauna.item;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import superlord.prehistoricfauna.item.model.AnkyHelmet;

import javax.annotation.Nullable;

public class CustomArmorItem extends ArmorItem {
	
	public CustomArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder) {
		super(materialIn, slot, builder);
	}
	
	@SuppressWarnings("unchecked")
	@Nullable
	@Override
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default)
    {
		AnkyHelmet model = new AnkyHelmet(1F);
		model.bipedHead.showModel = armorSlot == EquipmentSlotType.HEAD;
		
		model.isChild = _default.isChild;
		model.isSneak = _default.isSneak;
		model.isSitting = _default.isSitting;
		model.rightArmPose = _default.rightArmPose;
		model.leftArmPose = _default.leftArmPose;
		
		return (A) model;
    }
	
	@Override
    @Nullable
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
    {
        return "prehistoricfauna:textures/models/armor/ankylosaurus_helmet.png";
    }
	
}
