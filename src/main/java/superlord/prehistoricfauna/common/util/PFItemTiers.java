package superlord.prehistoricfauna.common.util;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import superlord.prehistoricfauna.init.PFItems;

public enum PFItemTiers implements IItemTier {
	ANKYLOSAURUS(2, 25, 6.0F, 1.5F, 14, () -> {
		return Ingredient.fromItems(PFItems.TAIL_CLUB.get());
	}),
	TYRANNOSAURUS(2, 250, 6.0F, 2.5F, 14, () -> {
		return Ingredient.fromItems(PFItems.TYRANNOSAUR_TOOTH.get());
	}),
	DAKOTARAPTOR(2, 178, 6.0F, 5.0F, 14, () -> {
		return Ingredient.fromItems(PFItems.DROMAEOSAUR_CLAW.get());
	}),
	THAGOMIZER(2, 200, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(PFItems.THAGOMIZERS.get());
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private PFItemTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

}
