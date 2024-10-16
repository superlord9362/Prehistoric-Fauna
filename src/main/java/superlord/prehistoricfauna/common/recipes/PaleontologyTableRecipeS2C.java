package superlord.prehistoricfauna.common.recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.Item;
import net.minecraftforge.network.NetworkEvent;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PaleontologyTableRecipeS2C {
	
	@SuppressWarnings("deprecation")
	private static final Codec<Map<Item, List<ItemWeightedPairCodec>>> MAPPER = Codec.unboundedMap(
			BuiltInRegistries.ITEM.byNameCodec(),
			ItemWeightedPairCodec.CODEC.listOf()
			).xmap(ItemWeightedPairCodec::convertToMap, ItemWeightedPairCodec::convertFromMap)
			.orElse(e -> {PrehistoricFauna.LOGGER.error("Failed to parse Paleontology Table Entries! Can't send Packet! Due to " + e);},
					new HashMap<>());
	public static Map<Item, List<ItemWeightedPairCodec>> SYNCED_DATA = new HashMap<>();
	private final Map<Item, List<ItemWeightedPairCodec>> map;
	
	public PaleontologyTableRecipeS2C(Map<Item, List<ItemWeightedPairCodec>> map) {
		this.map = map;
	}
	
	public void encode(FriendlyByteBuf buffer) {
        CompoundTag encodedTag = (CompoundTag) (MAPPER.encodeStart(NbtOps.INSTANCE, this.map).result().orElse(new CompoundTag()));
		buffer.writeNbt(encodedTag);
	}
	
	public static PaleontologyTableRecipeS2C decode(FriendlyByteBuf buffer) {
		CompoundTag receivedTag = buffer.readNbt();
		Map<Item, List<ItemWeightedPairCodec>> decodedMap = MAPPER.parse(NbtOps.INSTANCE, receivedTag).result().orElse(new HashMap<>());
		return new PaleontologyTableRecipeS2C(decodedMap);
	}
	
	public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
		NetworkEvent.Context context = contextGetter.get();
		context.enqueueWork(this::handlePacketOnMainThread);
		context.setPacketHandled(true);
	}
	
	private void handlePacketOnMainThread() {
		SYNCED_DATA = this.map;
		PaleontologyTableRecipeJsonManager.setRecipeList(SYNCED_DATA);
	}

}
