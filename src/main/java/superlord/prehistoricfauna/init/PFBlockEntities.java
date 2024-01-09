package superlord.prehistoricfauna.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.compat.PFBeehiveBlock;
import superlord.prehistoricfauna.common.blocks.compat.PFChestBlock;
import superlord.prehistoricfauna.common.blocks.compat.PFTrappedChestBlock;
import superlord.prehistoricfauna.common.entity.block.FeederBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PFSignBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PaleontologyTableBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFBeehiveBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFChestBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFTrappedChestBlockEntity;
import superlord.prehistoricfauna.common.util.BlockEntitySubRegistryHelper;

public class PFBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PrehistoricFauna.MOD_ID);
	public static final BlockEntitySubRegistryHelper HELPER = PrehistoricFauna.REGISTRY_HELPER.getBlockEntitySubHelper();
	
	public static final RegistryObject<BlockEntityType<PFSignBlockEntity>> SIGN = REGISTER.register("sign", () -> BlockEntityType.Builder.of(PFSignBlockEntity::new, 
			PFBlocks.METASEQUOIA_SIGN.get(), PFBlocks.METASEQUOIA_WALL_SIGN.get(),
			PFBlocks.ARAUCARIA_SIGN.get(), PFBlocks.ARAUCARIA_WALL_SIGN.get(),
			PFBlocks.PROTOPICEOXYLON_SIGN.get(), PFBlocks.PROTOPICEOXYLON_WALL_SIGN.get(),
			PFBlocks.ZAMITES_SIGN.get(), PFBlocks.ZAMITES_WALL_SIGN.get(),
			PFBlocks.PROTOJUNIPEROXYLON_SIGN.get(), PFBlocks.PROTOJUNIPEROXYLON_WALL_SIGN.get(),
			PFBlocks.AGATHOXYLON_SIGN.get(), PFBlocks.AGATHOXYLON_WALL_SIGN.get(),
			PFBlocks.HEIDIPHYLLUM_SIGN.get(), PFBlocks.HEIDIPHYLLUM_WALL_SIGN.get(),
			PFBlocks.LIRIODENDRITES_SIGN.get(), PFBlocks.LIRIODENDRITES_WALL_SIGN.get(),
			PFBlocks.GINKGO_SIGN.get(), PFBlocks.GINKGO_WALL_SIGN.get(),
			PFBlocks.TROCHODENDROIDES_SIGN.get(), PFBlocks.TROCHODENDROIDES_WALL_SIGN.get(),
			PFBlocks.BRACHYPHYLLUM_SIGN.get(), PFBlocks.BRACHYPHYLLUM_WALL_SIGN.get(),
			PFBlocks.WOODWORTHIA_SIGN.get(), PFBlocks.WOODWORTHIA_WALL_SIGN.get(),
			PFBlocks.SCHILDERIA_SIGN.get(), PFBlocks.SCHILDERIA_WALL_SIGN.get(),
			PFBlocks.NEOCALAMITES_SIGN.get(), PFBlocks.NEOCALAMITES_WALL_SIGN.get(),
			PFBlocks.DRYOPHYLLUM_SIGN.get(), PFBlocks.DRYOPHYLLUM_WALL_SIGN.get(),
			PFBlocks.TAXODIUM_SIGN.get(), PFBlocks.TAXODIUM_WALL_SIGN.get(),
			PFBlocks.SABALITES_SIGN.get(), PFBlocks.SABALITES_WALL_SIGN.get(),
			PFBlocks.PLATANITES_SIGN.get(), PFBlocks.PLATANITES_WALL_SIGN.get(),
			PFBlocks.TAXUS_SIGN.get(), PFBlocks.TAXUS_WALL_SIGN.get()
			).build(null));
    public static final RegistryObject<BlockEntityType<PaleoscribeBlockEntity>> PALEOSCRIBE = REGISTER.register("paleoscribe", () -> BlockEntityType.Builder.of(PaleoscribeBlockEntity::new, PFBlocks.PALEOSCRIBE.get()).build(null));
    public static final RegistryObject<BlockEntityType<PaleontologyTableBlockEntity>> PALEONTOLOGY_TABLE = REGISTER.register("paleontology_table", () -> BlockEntityType.Builder.of(PaleontologyTableBlockEntity::new, PFBlocks.PALEONTOLOGY_TABLE.get()).build(null));
    public static final RegistryObject<BlockEntityType<PFBeehiveBlockEntity>> BEEHIVE = HELPER.createBlockEntity("beehive", PFBeehiveBlockEntity::new, PFBeehiveBlock.class);
	public static final RegistryObject<BlockEntityType<PFChestBlockEntity>> CHEST = HELPER.createBlockEntity("chest", PFChestBlockEntity::new, PFChestBlock.class);
	public static final RegistryObject<BlockEntityType<PFTrappedChestBlockEntity>> TRAPPED_CHEST = HELPER.createBlockEntity("trapped_chest", PFTrappedChestBlockEntity::new, PFTrappedChestBlock.class);
	public static final RegistryObject<BlockEntityType<FeederBlockEntity>> FEEDER = REGISTER.register("feeder", () -> BlockEntityType.Builder.of(FeederBlockEntity::new, PFBlocks.OAK_FEEDER.get()).build(null));
    
}
