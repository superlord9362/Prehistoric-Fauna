package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.entity.WallClimbingBug;
import superlord.prehistoricfauna.common.entity.goal.BugAvoidGoal;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class DermestidBeetle extends WallClimbingBug {
	
	public DermestidBeetle(EntityType<?> type, Level world) {
		super(type, world);
	}

	protected void registerGoals() {
	    super.registerGoals();
	    this.goalSelector.addGoal(1, new BugAvoidGoal(this, 7F, 1.5D, 1.75D, PFTags.DERMESTID_AVOIDING));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item == Items.GLASS_BOTTLE) {
			if (!player.isCreative()) {
				itemstack.shrink(1);
			}
			player.addItem(new ItemStack(PFItems.BOTTLED_DERMESTID_BEETLE.get()));
			this.discard();
		}
		return super.mobInteract(player, hand);
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.DERMESTID_BEETLE_SPAWN_EGG.get());
	}
	
}

