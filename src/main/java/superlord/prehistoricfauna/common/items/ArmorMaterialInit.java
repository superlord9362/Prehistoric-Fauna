package superlord.prehistoricfauna.common.items;

import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.PFItems;

@SuppressWarnings("deprecation")
public enum ArmorMaterialInit implements StringRepresentable, ArmorMaterial {

	ANKYLOSAURUS(PrehistoricFauna.MOD_ID + ":ankylosaurus", 26, Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
		armor.put(ArmorItem.Type.BOOTS, 2);
		armor.put(ArmorItem.Type.LEGGINGS, 6);
		armor.put(ArmorItem.Type.CHESTPLATE, 7);
		armor.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> {
		return Ingredient.of(PFItems.ANKYLOSAURUS_SCUTE.get());
	}),
	DESMATOSUCHUS(PrehistoricFauna.MOD_ID + ":desmatosuchus", 26,  Util.make(new EnumMap<>(ArmorItem.Type.class), (armor) -> {
		armor.put(ArmorItem.Type.BOOTS, 2);
		armor.put(ArmorItem.Type.LEGGINGS, 6);
		armor.put(ArmorItem.Type.CHESTPLATE, 7);
		armor.put(ArmorItem.Type.HELMET, 3);
	}), 10, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> {
		return Ingredient.of(PFItems.THYREOPHORAN_SCUTE.get());
	});

	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
		p_266653_.put(ArmorItem.Type.BOOTS, 13);
		p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
		p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
		p_266653_.put(ArmorItem.Type.HELMET, 11);
	});
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final String name;
	private final int durabilityMultiplier;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private ArmorMaterialInit(String p_268171_, int p_268303_, EnumMap<ArmorItem.Type, Integer> p_267941_, int p_268086_, SoundEvent p_268145_, float p_268058_, float p_268180_, Supplier<Ingredient> p_268256_) {
		this.name = p_268171_;
		this.durabilityMultiplier = p_268303_;
		this.protectionFunctionForType = p_267941_;
		this.enchantmentValue = p_268086_;
		this.sound = p_268145_;
		this.toughness = p_268058_;
		this.knockbackResistance = p_268180_;
		this.repairIngredient = new LazyLoadedValue<>(p_268256_);
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getSerializedName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public int getDurabilityForType(Type p_266807_) {
		return HEALTH_FUNCTION_FOR_TYPE.get(p_266807_) * this.durabilityMultiplier;

	}

	@Override
	public int getDefenseForType(Type p_267168_) {
		return this.protectionFunctionForType.get(p_267168_);

	}

	@Override
	public String getName() {
		return this.name;
	}

}
