package superlord.prehistoricfauna.common.items;

import javax.annotation.Nullable;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;

public class CustomChestplateItem extends ArmorItem {

	public CustomChestplateItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder) {
		super(materialIn, slot, builder);
	}

	@Override
	public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.IItemRenderProperties> consumer)
	{
		consumer.accept((net.minecraftforge.client.IItemRenderProperties) PrehistoricFauna.PROXY.getArmorRenderProperties());
	}

	@Override
	public void onArmorTick(ItemStack stack, Level world, Player player) {
		if (player.hurtMarked && player.getLastHurtByMob() != null) {
			LivingEntity attacker = player.getLastHurtByMob();
			attacker.hurt(DamageSource.thorns(attacker), 1);
		}
	}

	@Override
	@Nullable
	@OnlyIn(Dist.CLIENT) 
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return "prehistoricfauna:textures/models/armor/aetosaur_chestplate.png";
	}
}
