package superlord.prehistoricfauna.init;

import net.minecraft.world.level.saveddata.maps.MapDecoration;

public class PFMapTypes {
	
	public static final MapDecoration.Type TIME_TEMPLE = MapDecoration.Type.valueOf("PF_TIME_TEMPLE");

    public static byte getMapIconRenderOrdinal(MapDecoration.Type type) {
        return (byte) (type == TIME_TEMPLE ? 0 : -1);
    }

}
