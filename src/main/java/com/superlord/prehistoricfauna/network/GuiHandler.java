package com.superlord.prehistoricfauna.network;

import com.superlord.prehistoricfauna.blocks.tile.TileEntityEggIncubator;
import com.superlord.prehistoricfauna.client.gui.GuiEggIncubator;
import com.superlord.prehistoricfauna.inventory.ContainerEggIncubator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

import static com.superlord.prehistoricfauna.Main.LOGGER;

public class GuiHandler implements IGuiHandler {
    public static final int EGG_INCUBATOR = 0;

    @Override
    @Nullable
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case EGG_INCUBATOR:
                TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityEggIncubator) {
                    return new ContainerEggIncubator(player.inventory, (TileEntityEggIncubator) tile);
                }
                break;
            default:
                LOGGER.warn("Invalid gui id, received : " + ID);
        }
        return null;
    }

    @Override
    @Nullable
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case EGG_INCUBATOR:
                TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityEggIncubator) {
                    return new GuiEggIncubator(player.inventory, (TileEntityEggIncubator) tile);
                }
                break;
            default:
                LOGGER.warn("Invalid gui id, received : " + ID);
        }
        return null;
    }
}
