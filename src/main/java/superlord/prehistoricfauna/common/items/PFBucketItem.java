package superlord.prehistoricfauna.common.items;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.fish.Lonchidion;

public class PFBucketItem extends MobBucketItem {

	public PFBucketItem(Supplier<? extends EntityType<?>> entitySupplier, Supplier<? extends Fluid> fluidSupplier, Supplier<? extends SoundEvent> soundSupplier, Properties properties) {
		super(entitySupplier, fluidSupplier, soundSupplier, properties);
		this.entityTypeSupplier = entitySupplier;
        DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> PrehistoricFauna.CALLBACKS.add(() -> ItemProperties.register(this, new ResourceLocation(PrehistoricFauna.MOD_ID, "chinle_variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getTag().getInt("chinle_variant") : 0)));
	}

	private final Supplier<? extends EntityType<?>> entityTypeSupplier;
	protected EntityType<?> getEntityType() {
		return entityTypeSupplier.get();
	}

	public PFBucketItem(Supplier<? extends EntityType<?>> entitySupplier, Fluid p_151138_, SoundEvent p_151139_, Item.Properties p_151140_) {
		this(entitySupplier, () -> p_151138_, () -> p_151139_, p_151140_);
	}

	public void checkExtraContent(@Nullable Player player, Level world, ItemStack stack, BlockPos pos) {
		System.out.println(stack.getTag());
		if (world instanceof ServerLevel) {
			this.spawn((ServerLevel) world, stack, pos);
			world.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (stack.hasTag()) {
			if (stack.getTag().getInt("chinle_variant") == 1) {
				tooltip.add(Component.translatable("chinle_variant").withStyle(ChatFormatting.GRAY));
			} else if (stack.getTag().getInt("chinle_variant") == 0) {
				tooltip.add(Component.translatable("hell_creek_variant").withStyle(ChatFormatting.GRAY));
			}
		}
	}

	private void spawn(ServerLevel world, ItemStack stack, BlockPos pos) {
		Entity entity = getFishType().spawn(world, stack, (Player)null, pos, MobSpawnType.BUCKET, true, false);
		if (entity instanceof Bucketable bucketable) {
			bucketable.loadFromBucketTag(stack.getOrCreateTag());
			bucketable.setFromBucket(true);
		}
		if (stack.hasCustomHoverName()) entity.setCustomName(stack.getHoverName());
		if (entity instanceof Lonchidion) {
			if (stack.hasTag()) {
				if (stack.getTag().getInt("chinle_variant") == 1) {
					((Lonchidion)entity).setFromChinle(true);
				} else if (stack.getTag().getInt("chinle_variant") == 0) {
					((Lonchidion)entity).setFromChinle(false);
				}
			}
		}

	}

}
