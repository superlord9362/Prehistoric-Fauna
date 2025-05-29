package superlord.prehistoricfauna.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.compat.PFBeehiveBlock;
import superlord.prehistoricfauna.common.blocks.compat.PFChestBlock;
import superlord.prehistoricfauna.common.blocks.compat.PFTrappedChestBlock;
import superlord.prehistoricfauna.common.entity.CretaceousBossBlockEntity;
import superlord.prehistoricfauna.common.entity.block.BurrowBlockEntity;
import superlord.prehistoricfauna.common.entity.block.FeederBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PFHangingSignBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PFSignBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PaleontologyTableBlockEntity;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFBeehiveBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFChestBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFTrappedChestBlockEntity;
import superlord.prehistoricfauna.common.util.BlockEntitySubRegistryHelper;

public class PFBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PrehistoricFauna.MOD_ID);
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
			PFBlocks.TAXUS_SIGN.get(), PFBlocks.TAXUS_WALL_SIGN.get(),
			PFBlocks.CZEKANOWSKIA_SIGN.get(), PFBlocks.CZEKANOWSKIA_WALL_SIGN.get(),
			PFBlocks.SCHIZOLEPIDOPSIS_SIGN.get(), PFBlocks.SCHIZOLEPIDOPSIS_WALL_SIGN.get(),
			PFBlocks.PODOZAMITES_SIGN.get(), PFBlocks.PODOZAMITES_WALL_SIGN.get(),
			PFBlocks.CUPRESSINOCLADUS_SIGN.get(), PFBlocks.CUPRESSINOCLADUS_WALL_SIGN.get(),
			PFBlocks.ELATIDES_SIGN.get(), PFBlocks.ELATIDES_WALL_SIGN.get(),
			PFBlocks.PHOENICOPSIS_SIGN.get(), PFBlocks.PHOENICOPSIS_WALL_SIGN.get(),
			PFBlocks.FRENELOPSIS_SIGN.get(), PFBlocks.FRENELOPSIS_WALL_SIGN.get()
			).build(null));
	public static final RegistryObject<BlockEntityType<PFHangingSignBlockEntity>> HANGING_SIGN = REGISTER.register("hanging_sign", () -> BlockEntityType.Builder.of(PFHangingSignBlockEntity::new, 
			PFBlocks.METASEQUOIA_HANGING_SIGN.get(), PFBlocks.METASEQUOIA_HANGING_WALL_SIGN.get(),
			PFBlocks.ARAUCARIA_HANGING_SIGN.get(), PFBlocks.ARAUCARIA_HANGING_WALL_SIGN.get(),
			PFBlocks.PROTOPICEOXYLON_HANGING_SIGN.get(), PFBlocks.PROTOPICEOXYLON_HANGING_WALL_SIGN.get(),
			PFBlocks.ZAMITES_HANGING_SIGN.get(), PFBlocks.ZAMITES_HANGING_WALL_SIGN.get(),
			PFBlocks.PROTOJUNIPEROXYLON_HANGING_SIGN.get(), PFBlocks.PROTOJUNIPEROXYLON_HANGING_WALL_SIGN.get(),
			PFBlocks.AGATHOXYLON_HANGING_SIGN.get(), PFBlocks.AGATHOXYLON_HANGING_WALL_SIGN.get(),
			PFBlocks.HEIDIPHYLLUM_HANGING_SIGN.get(), PFBlocks.HEIDIPHYLLUM_HANGING_WALL_SIGN.get(),
			PFBlocks.LIRIODENDRITES_HANGING_SIGN.get(), PFBlocks.LIRIODENDRITES_HANGING_WALL_SIGN.get(),
			PFBlocks.GINKGO_HANGING_SIGN.get(), PFBlocks.GINKGO_HANGING_WALL_SIGN.get(),
			PFBlocks.TROCHODENDROIDES_HANGING_SIGN.get(), PFBlocks.TROCHODENDROIDES_HANGING_WALL_SIGN.get(),
			PFBlocks.BRACHYPHYLLUM_HANGING_SIGN.get(), PFBlocks.BRACHYPHYLLUM_HANGING_WALL_SIGN.get(),
			PFBlocks.WOODWORTHIA_HANGING_SIGN.get(), PFBlocks.WOODWORTHIA_HANGING_WALL_SIGN.get(),
			PFBlocks.SCHILDERIA_HANGING_SIGN.get(), PFBlocks.SCHILDERIA_HANGING_WALL_SIGN.get(),
			PFBlocks.NEOCALAMITES_HANGING_SIGN.get(), PFBlocks.NEOCALAMITES_HANGING_WALL_SIGN.get(),
			PFBlocks.DRYOPHYLLUM_HANGING_SIGN.get(), PFBlocks.DRYOPHYLLUM_HANGING_WALL_SIGN.get(),
			PFBlocks.TAXODIUM_HANGING_SIGN.get(), PFBlocks.TAXODIUM_HANGING_WALL_SIGN.get(),
			PFBlocks.SABALITES_HANGING_SIGN.get(), PFBlocks.SABALITES_HANGING_WALL_SIGN.get(),
			PFBlocks.PLATANITES_HANGING_SIGN.get(), PFBlocks.PLATANITES_HANGING_WALL_SIGN.get(),
			PFBlocks.TAXUS_HANGING_SIGN.get(), PFBlocks.TAXUS_HANGING_WALL_SIGN.get(),
			PFBlocks.CZEKANOWSKIA_HANGING_SIGN.get(), PFBlocks.CZEKANOWSKIA_HANGING_WALL_SIGN.get(),
			PFBlocks.SCHIZOLEPIDOPSIS_HANGING_SIGN.get(), PFBlocks.SCHIZOLEPIDOPSIS_HANGING_WALL_SIGN.get(),
			PFBlocks.PODOZAMITES_HANGING_SIGN.get(), PFBlocks.PODOZAMITES_HANGING_WALL_SIGN.get(),
			PFBlocks.CUPRESSINOCLADUS_HANGING_SIGN.get(), PFBlocks.CUPRESSINOCLADUS_HANGING_WALL_SIGN.get(),
			PFBlocks.ELATIDES_HANGING_SIGN.get(), PFBlocks.ELATIDES_HANGING_WALL_SIGN.get(),
			PFBlocks.PHOENICOPSIS_HANGING_SIGN.get(), PFBlocks.PHOENICOPSIS_HANGING_WALL_SIGN.get(),
			PFBlocks.FRENELOPSIS_HANGING_SIGN.get(), PFBlocks.FRENELOPSIS_HANGING_WALL_SIGN.get()
			).build(null));
    public static final RegistryObject<BlockEntityType<PaleoscribeBlockEntity>> PALEOSCRIBE = REGISTER.register("paleoscribe", () -> BlockEntityType.Builder.of(PaleoscribeBlockEntity::new, PFBlocks.PALEOSCRIBE.get()).build(null));
    public static final RegistryObject<BlockEntityType<PaleontologyTableBlockEntity>> PALEONTOLOGY_TABLE = REGISTER.register("paleontology_table", () -> BlockEntityType.Builder.of(PaleontologyTableBlockEntity::new, PFBlocks.PALEONTOLOGY_TABLE.get()).build(null));
    public static final RegistryObject<BlockEntityType<PFBeehiveBlockEntity>> BEEHIVE = HELPER.createBlockEntity("beehive", PFBeehiveBlockEntity::new, PFBeehiveBlock.class);
	public static final RegistryObject<BlockEntityType<PFChestBlockEntity>> CHEST = HELPER.createBlockEntity("chest", PFChestBlockEntity::new, PFChestBlock.class);
	public static final RegistryObject<BlockEntityType<PFTrappedChestBlockEntity>> TRAPPED_CHEST = HELPER.createBlockEntity("trapped_chest", PFTrappedChestBlockEntity::new, PFTrappedChestBlock.class);
	public static final RegistryObject<BlockEntityType<FeederBlockEntity>> FEEDER = REGISTER.register("feeder", () -> BlockEntityType.Builder.of(FeederBlockEntity::new, PFBlocks.OAK_FEEDER.get()).build(null));
	public static final RegistryObject<BlockEntityType<BurrowBlockEntity>> BURROW = REGISTER.register("burrow", () -> BlockEntityType.Builder.of(BurrowBlockEntity::new, PFBlocks.BURROW.get()).build(null));
	public static final RegistryObject<BlockEntityType<CretaceousBossBlockEntity>> CRETACEOUS_BOSS = REGISTER.register("cretaceous_boss", () -> BlockEntityType.Builder.of(CretaceousBossBlockEntity::new, PFBlocks.CRETACEOUS_BOSS_SPAWN.get()).build(null));
    
}
