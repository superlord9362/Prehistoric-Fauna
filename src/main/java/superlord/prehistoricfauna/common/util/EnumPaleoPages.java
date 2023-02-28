package superlord.prehistoricfauna.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;

import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import superlord.prehistoricfauna.common.items.PaleopediaItem;

public enum EnumPaleoPages {

	INTRODUCTION(0),
	HELL_CREEK(2),
	TRICERATOPS(1),
	ANKYLOSAURUS(1),
	TYRANNOSAURUS(0),
	THESCELOSAURUS(0),
	BASILEMYS(0),
	DAKOTARAPTOR(0),
	DIDELPHODON(0),
	DJADOCHTA(2),
	AEPYORNITHOMIMUS(0),
	CITIPATI(0),
	PINACOSAURUS(0),
	PLESIOHADROS(0),
	PROTOCERATOPS(0),
	TELMASAURUS(0),
	VELOCIRAPTOR(0),
	MORRISON(2),
	ALLOSAURUS(0),
	CAMARASAURUS(0),
	CERATOSAURUS(0),
	DRYOSAURUS(0),
	EILENODON(0),
	HESPERORNITHOIDES(0),
	STEGOSAURUS(0),
	KAYENTA(2),
	CALSOYASUCHUS(0),
	DILOPHOSAURUS(0),
	KAYENTATHERIUM(0),
	MEGAPNOSAURUS(0),
	SARAHSAURUS(0),
	SCELIDOSAURUS(0),
	SCUTELLOSAURUS(0),
	CHINLE(3),
	COELOPHYSIS(1),
	DESMATOSUCHUS(0),
	PLACERIAS(0),
	POPOSAURUS(0),
	POSTOSUCHUS(0),
	TRILOPHOSAURUS(0),
	TYPOTHORAX(0),
	ISCHIGUALASTO(3),
	HYPERODAPEDON(0),
	ISCHIGUALASTIA(0),
	SAUROSUCHUS(0),
	SILLOSUCHUS(0),
	CHROMOGISAURUS(0),
	EXAERETODON(0),
	HERRERASAURUS(0);

	public static final ImmutableList<EnumPaleoPages> ALL_PAGES = ImmutableList.copyOf(EnumPaleoPages.values());
    public static final ImmutableList<Integer> ALL_INDEXES = ImmutableList
        .copyOf(IntStream.range(0, EnumPaleoPages.values().length).iterator());

    public int pages;

    EnumPaleoPages(int pages) {
        this.pages = pages;
    }

    public static Set<EnumPaleoPages> containedPages(Collection<Integer> pages) {
        return pages.stream().map(ALL_PAGES::get).collect(Collectors.toSet());
    }

    public static boolean hasAllPages(ItemStack book) {
        return Ints.asList(book.getTag().getIntArray("Pages")).containsAll(ALL_INDEXES);
    }

    public static List<Integer> enumToInt(List<EnumPaleoPages> pages) {
        return pages.stream().map(EnumPaleoPages::ordinal).collect(Collectors.toList());
    }

    public static EnumPaleoPages getRand() {
        return EnumPaleoPages.values()[ThreadLocalRandom.current().nextInt(EnumPaleoPages.values().length)];

    }

    public static void addRandomPage(ItemStack book) {
        if (book.getItem() instanceof PaleopediaItem) {
            List<EnumPaleoPages> list = EnumPaleoPages.possiblePages(book);
            if (!list.isEmpty()) {
                addPage(list.get(ThreadLocalRandom.current().nextInt(list.size())), book);
            }
        }
    }

    public static List<EnumPaleoPages> possiblePages(ItemStack book) {
        if (book.getItem() instanceof PaleopediaItem) {
            CompoundTag tag = book.getTag();
            Collection<EnumPaleoPages> containedPages = containedPages(Ints.asList(tag.getIntArray("Pages")));
            List<EnumPaleoPages> possiblePages = new ArrayList<>(ALL_PAGES);
            possiblePages.removeAll(containedPages);
            return possiblePages;
        }
        return Collections.emptyList();
    }


    public static boolean addPage(EnumPaleoPages page, ItemStack book) {
        boolean flag = false;
        if (book.getItem() instanceof PaleopediaItem) {
            CompoundTag tag = book.getTag();
            final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
            if (!already.contains(page.ordinal())) {
                already.add(page.ordinal());
                flag = true;
            }
            tag.putIntArray("Pages", Ints.toArray(already));
        }
        return flag;
    }


    @Nullable
    public static EnumPaleoPages fromInt(int index) {
        if (index < 0) {
            return null;
        }
        int length = values().length;
        return values()[index % length];
    }
}
