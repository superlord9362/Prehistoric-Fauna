package superlord.prehistoricfauna.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.armor.AnkylosaurusHelmetModel;
import superlord.prehistoricfauna.client.model.armor.DesmatosuchusChestplateModel;
import superlord.prehistoricfauna.init.PFItems;

public class AnkylosaurusHelmetRenderProperties implements IItemRenderProperties {
	
	private static boolean init;
	
	public static AnkylosaurusHelmetModel ANKYLOSAURUS_HELMET_MODEL;
	public static DesmatosuchusChestplateModel DESMATOSUCHUS_CHESTPLATE_MODEL;
	
	public static void initializeModels() {
		init = true;
		ANKYLOSAURUS_HELMET_MODEL = new AnkylosaurusHelmetModel(Minecraft.getInstance().getEntityModels().bakeLayer(ClientEvents.ANKYLOSAURUS_HELMET));
		DESMATOSUCHUS_CHESTPLATE_MODEL = new DesmatosuchusChestplateModel(Minecraft.getInstance().getEntityModels().bakeLayer(ClientEvents.DESMATOSUCHUS_CHESTPLATE));
	}
	
	public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
		if (!init) {
			initializeModels();
		}
		if (itemStack.getItem() == PFItems.ANKYLOSAURUS_HELMET.get()) {
			return ANKYLOSAURUS_HELMET_MODEL;
		}
		if (itemStack.getItem() == PFItems.DESMATOSUCHUS_CHESTPLACE.get()) {
			return DESMATOSUCHUS_CHESTPLATE_MODEL;
		}
		return _default;
	}

}
