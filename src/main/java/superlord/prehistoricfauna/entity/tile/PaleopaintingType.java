package superlord.prehistoricfauna.entity.tile;

import superlord.prehistoricfauna.util.PaintingRegistry;

public class PaleopaintingType extends net.minecraftforge.registries.ForgeRegistryEntry<PaleopaintingType> {
   public static final PaleopaintingType CONUNDRUM = register("conundrum", 16, 16);
   public static final PaleopaintingType DYNASTIC = register("dynastic", 16, 16);
   public static final PaleopaintingType FOREIGN_COUPLE = register("foreign_couple", 16, 32);
   public static final PaleopaintingType TALL_BUSTS = register("tall_busts", 16, 32);
   public static final PaleopaintingType ANNING = register("anning", 32, 32);
   public static final PaleopaintingType AMNIOTIC = register("amniotic", 32, 32);
   private final int width;
   private final int height;

   @SuppressWarnings("deprecation")
   private static PaleopaintingType register(String key, int width, int height) {
	   return PaintingRegistry.register(PaintingRegistry.PALEOPAINTING, key, new PaleopaintingType(width, height));
   }

   public PaleopaintingType(int width, int height) {
      this.width = width;
      this.height = height;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }
}
