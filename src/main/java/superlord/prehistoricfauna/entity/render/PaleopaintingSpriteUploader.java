package superlord.prehistoricfauna.entity.render;

import java.util.stream.Stream;

import net.minecraft.client.renderer.texture.SpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.PaleopaintingType;
import superlord.prehistoricfauna.util.PaintingRegistry;

@OnlyIn(Dist.CLIENT)
public class PaleopaintingSpriteUploader extends SpriteUploader {
   private static final ResourceLocation LOCATION_BACK_SPRITE = new ResourceLocation("back");

   public PaleopaintingSpriteUploader(TextureManager textureManagerIn) {
      super(textureManagerIn, new ResourceLocation(PrehistoricFauna.MODID + "textures/atlas/paintings.png"), PrehistoricFauna.MODID + "painting");
   }

   protected Stream<ResourceLocation> getResourceLocations() {
      return Stream.concat(PaintingRegistry.PALEOPAINTING.keySet().stream(), Stream.of(LOCATION_BACK_SPRITE));
   }

   /**
    * Gets the sprite used for a specific painting type.
    */
   public TextureAtlasSprite getSpriteForPainting(PaleopaintingType paintingTypeIn) {
      return this.getSprite(PaintingRegistry.PALEOPAINTING.getKey(paintingTypeIn));
   }

   public TextureAtlasSprite getBackSprite() {
      return this.getSprite(LOCATION_BACK_SPRITE);
   }
}
