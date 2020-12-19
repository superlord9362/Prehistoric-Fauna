package superlord.prehistoricfauna.entity.tile;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PaleopaintingType extends net.minecraftforge.registries.ForgeRegistryEntry<PaleopaintingType> {
	
	static final DeferredRegister<PaintingType> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, PrehistoricFauna.MODID);

	public static final RegistryObject<PaintingType> CONUNDRUM = PAINTINGS.register("conundrum", () -> new PaintingType(16, 16));
	public static final RegistryObject<PaintingType> DYNASTIC = PAINTINGS.register("conundrum", () -> new PaintingType(16, 16));
	public static final RegistryObject<PaintingType> FOREIGN_COUPLE = PAINTINGS.register("conundrum", () -> new PaintingType(16, 32));
	public static final RegistryObject<PaintingType> TALL_BUSTS = PAINTINGS.register("conundrum", () -> new PaintingType(16, 32));
	public static final RegistryObject<PaintingType> ANNING = PAINTINGS.register("conundrum", () -> new PaintingType(32, 32));
	public static final RegistryObject<PaintingType> AMNIOTIC = PAINTINGS.register("conundrum", () -> new PaintingType(32, 32));

   private final int width;
   private final int height;

   

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
