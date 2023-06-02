package superlord.prehistoricfauna.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import superlord.prehistoricfauna.common.entity.Paleopainting;

public class PaleopaintingItem extends Item {
    public PaleopaintingItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context) {
        Direction direction = context.getClickedFace();
        BlockPos pos = context.getClickedPos().relative(direction);
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        if (player != null && (direction.getAxis().isVertical())) {
            return InteractionResult.FAIL;
        } else {
            Level world = context.getLevel();
            Paleopainting entity = new Paleopainting(world, pos, direction);

            CompoundTag tag = stack.getTag();
            if (tag != null) {
                EntityType.updateCustomEntityTag(world, player, entity, tag);
            }

            if (entity.survives()) {
                if (!world.isClientSide) {
                    entity.playPlacementSound();
                    world.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
                    world.addFreshEntity(entity);
                }

                stack.shrink(1);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }
}
