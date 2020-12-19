package superlord.prehistoricfauna.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.ItemInit;

import java.util.function.Supplier;

public enum ArmorMaterialInit implements IArmorMaterial {
	
	ANKYLOSAURUS(PrehistoricFauna.MODID + ":ankylosaurus", 26, new int[] {2, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, () -> {
		return Ingredient.fromItems(ItemInit.ANKYLOSAURUS_SCUTE.get());
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	private ArmorMaterialInit(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}
	
	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}
	
	@Override
	public int getEnchantability() {
		return this.enchantability;
	}
	
	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}
	
	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public float getToughness() {
		return this.toughness;
	}

}
