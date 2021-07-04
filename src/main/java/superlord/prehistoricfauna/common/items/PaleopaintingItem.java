package superlord.prehistoricfauna.common.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import superlord.prehistoricfauna.common.entities.PaleopaintingEntity;

public class PaleopaintingItem extends Item {
    public PaleopaintingItem(Item.Properties properties) {
        super(properties);
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        Direction direction = context.getFace();
        BlockPos pos = context.getPos().offset(direction);
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItem();
        if (player != null && (direction.getAxis().isVertical() || !player.canPlayerEdit(pos, direction, stack))) {
            return ActionResultType.FAIL;
        } else {
            World world = context.getWorld();
            PaleopaintingEntity entity = new PaleopaintingEntity(world, pos, direction);

            CompoundNBT tag = stack.getTag();
            if (tag != null) {
                EntityType.applyItemNBT(world, player, entity, tag);
            }

            if (entity.onValidSurface()) {
                if (!world.isRemote) {
                    entity.playPlaceSound();
                    world.addEntity(entity);
                }

                stack.shrink(1);
                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.CONSUME;
            }
        }
    }
}
