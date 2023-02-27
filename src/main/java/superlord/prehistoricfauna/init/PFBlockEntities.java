package superlord.prehistoricfauna.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.PFSignBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;

public class PFBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<BlockEntityType<PFSignBlockEntity>> SIGN = REGISTER.register("sign", () -> BlockEntityType.Builder.of(PFSignBlockEntity::new, 
			PFBlocks.METASEQUOIA_SIGN.get(), PFBlocks.METASEQUOIA_WALL_SIGN.get(),
			PFBlocks.ARAUCARIA_SIGN.get(), PFBlocks.ARAUCARIA_WALL_SIGN.get(),
			PFBlocks.PROTOPICEOXYLON_SIGN.get(), PFBlocks.PROTOPICEOXYLON_WALL_SIGN.get(),
			PFBlocks.ZAMITES_SIGN.get(), PFBlocks.ZAMITES_WALL_SIGN.get(),
			PFBlocks.PROTOJUNIPEROXYLON_SIGN.get(), PFBlocks.PROTOJUNIPEROXYLON_WALL_SIGN.get(),
			PFBlocks.AGATHOXYLON_SIGN.get(), PFBlocks.AGATHOXYLON_WALL_SIGN.get(),
			PFBlocks.HEIDIPHYLLUM_SIGN.get(), PFBlocks.HEIDIPHYLLUM_WALL_SIGN.get(),
			PFBlocks.LIRIODENDRITES_SIGN.get(), PFBlocks.LIRIODENDRITES_WALL_SIGN.get()
			).build(null));
	public static final RegistryObject<BlockEntityType<PaleoscribeBlockEntity>> PALEOSCRIBE = REGISTER.register("paleoscribe", () -> BlockEntityType.Builder.of(PaleoscribeBlockEntity::new, PFBlocks.PALEOSCRIBE.get()).build(null)); 

}
