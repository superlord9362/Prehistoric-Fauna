package superlord.prehistoricfauna.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

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

	public int pages;

    EnumPaleoPages(int pages) {
        this.pages = pages;
    }

    public static List<Integer> toList(int[] containedpages) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int containedpage : containedpages) {
            if (containedpage >= 0 && containedpage < EnumPaleoPages.values().length) {
                intList.add(containedpage);
            }
        }
        return intList;
    }

    public static int[] fromList(List<Integer> containedpages) {
        int[] pages = new int[containedpages.size()];
        for (int i = 0; i < pages.length; i++)
            pages[i] = containedpages.get(i);
        return pages;
    }

    @SuppressWarnings("unused")
	public static List<EnumPaleoPages> containedPages(List<Integer> pages) {
        Iterator<Integer> itr = pages.iterator();
        List<EnumPaleoPages> list = new ArrayList<>();
        for (Integer page : pages) {
            if (page >= 0 && page < EnumPaleoPages.values().length) {
                list.add(EnumPaleoPages.values()[page]);
            }
        }
        return list;
    }

    public static boolean hasAllPages(ItemStack book) {
        List<EnumPaleoPages> allPages = new ArrayList<EnumPaleoPages>();
        for (int i = 0; i < EnumPaleoPages.values().length; i++) {
            allPages.add(EnumPaleoPages.values()[i]);
        }
        List<EnumPaleoPages> pages = containedPages(EnumPaleoPages.toList(book.getTag().getIntArray("Pages")));
        for (EnumPaleoPages page : allPages) {
            return !pages.contains(page);
        }
        return false;
    }

    public static List<Integer> enumToInt(List<EnumPaleoPages> pages) {
        Iterator<superlord.prehistoricfauna.common.util.EnumPaleoPages> itr = pages.iterator();
        List<Integer> list = new ArrayList<Integer>();
        while (itr.hasNext()) {
            list.add(EnumPaleoPages.values()[(itr.next()).ordinal()].ordinal());
        }
        return list;
    }

    public static EnumPaleoPages getRand() {
        return EnumPaleoPages.values()[new Random().nextInt(EnumPaleoPages.values().length)];

    }

    public static void addRandomPage(ItemStack book) {
        if (book.getItem() instanceof PaleopediaItem) {
            List<EnumPaleoPages> list = EnumPaleoPages.possiblePages(book);
            if (list != null && !list.isEmpty()) {
                addPage(list.get(new Random().nextInt(list.size())), book);
            }
        }
    }

    public static List<EnumPaleoPages> possiblePages(ItemStack book) {
        if (book.getItem() instanceof PaleopediaItem) {
        	CompoundTag tag = book.getTag();
            List<EnumPaleoPages> allPages = new ArrayList<EnumPaleoPages>();
            for (EnumPaleoPages page : EnumPaleoPages.values()) {
                allPages.add(page);
            }
            List<EnumPaleoPages> containedPages = containedPages(toList(tag.getIntArray("Pages")));
            List<EnumPaleoPages> possiblePages = new ArrayList<EnumPaleoPages>();
            Iterator<superlord.prehistoricfauna.common.util.EnumPaleoPages> itr = allPages.iterator();
            while (itr.hasNext()) {
                EnumPaleoPages page = itr.next();
                if (!containedPages.contains(page)) {
                    possiblePages.add(page);
                }
            }
            return possiblePages;
        }
        return null;
    }


    public static boolean addPage(EnumPaleoPages page, ItemStack book) {
        boolean flag = false;
        if (book.getItem() instanceof PaleopediaItem) {
            CompoundTag tag = book.getTag();
            List<EnumPaleoPages> enumlist = containedPages(toList(tag.getIntArray("Pages")));
            if (!enumlist.contains(page)) {
                enumlist.add(page);
                flag = true;
            }
            tag.putIntArray("Pages", fromList(enumToInt(enumlist)));
        }
        return flag;
    }


    @Nullable
    public static EnumPaleoPages fromInt(int index) {
        if(index < 0){
            return null;
        }
        int length = values().length;
        return values()[index % length];
    }
}
