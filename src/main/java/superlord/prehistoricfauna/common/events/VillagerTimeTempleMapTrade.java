package superlord.prehistoricfauna.common.events;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import superlord.prehistoricfauna.init.PFMapTypes;
import superlord.prehistoricfauna.init.PFTags;

public class VillagerTimeTempleMapTrade implements VillagerTrades.ItemListing {
    private final int emeraldCost;
    private final int maxUses;
    private final int villagerXp;

    public VillagerTimeTempleMapTrade(int emeraldCost, int maxUses, int villagerXp) {
        this.emeraldCost = emeraldCost;
        this.maxUses = maxUses;
        this.villagerXp = villagerXp;
    }

    @Nullable
    public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
        if (!(entity.level() instanceof ServerLevel)) {
            return null;
        } else {
            ServerLevel serverlevel = (ServerLevel)entity.level();
            BlockPos blockpos = serverlevel.findNearestMapStructure(PFTags.ON_TIME_TEMPLE_MAPS, entity.blockPosition(), 100, true);
            if (blockpos != null) {
                ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
                MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", PFMapTypes.TIME_TEMPLE);
                itemstack.setHoverName(Component.translatable("item.prehistoricfauna.time_temple_map"));
                return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(Items.COMPASS), itemstack, this.maxUses, this.villagerXp, 0.2F);
            } else {
                return null;
            }
        }
    }
}