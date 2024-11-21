package superlord.prehistoricfauna.mixin;

import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(MapDecoration.Type.class)
@Unique
public class MapDecorationTypeMixin {

    @Shadow
    @Final
    @Mutable
    private static MapDecoration.Type[] $VALUES;

    @SuppressWarnings("unused")
	private static final MapDecoration.Type TIME_TEMPLE = pf_addType("PF_TIME_TEMPLE", true, 0X6B6B6B, false);

    @Invoker("<init>")
    public static MapDecoration.Type pf_invokeInit(String internalName, int internalId, boolean renderOnFrame, int mapColor, boolean trpfkCount) {
        throw new AssertionError();
    }

    private static MapDecoration.Type pf_addType(String internalName, boolean renderOnFrame, int mapColor, boolean trpfkCount) {
        ArrayList<MapDecoration.Type> variants = new ArrayList<MapDecoration.Type>(Arrays.asList($VALUES));
        MapDecoration.Type instrument = pf_invokeInit(internalName, variants.get(variants.size() - 1).ordinal() + 1, renderOnFrame, mapColor, trpfkCount);
        variants.add(instrument);
        MapDecorationTypeMixin.$VALUES = variants.toArray(new MapDecoration.Type[0]);
        return instrument;
    }
}