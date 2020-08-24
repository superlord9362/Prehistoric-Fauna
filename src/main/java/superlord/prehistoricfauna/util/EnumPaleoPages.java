package superlord.prehistoricfauna.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import superlord.prehistoricfauna.item.PaleopediaItem;

public enum EnumPaleoPages {
	
	INTRODUCTION(2),
	TRICERATOPS(4),
	ANKYLOSAURUS(1),
	TYRANNOSAURUS(4),
	THESCELOSAURUS(1),
	BASILEMYS(3),
	DAKOTARAPTOR(2),
	ALLOSAURUS(1),
	CAMARASAURUS(3),
	CERATOSAURUS(0),
	DRYOSAURUS(1),
	EILENODON(1),
	HESPERORNITHOIDES(1),
	STEGOSAURUS(2);
	
	public int pages;
	
	EnumPaleoPages(int pages) {
		this.pages = pages;
	}
	
	public static List<Integer> toList(int[] containedPages) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int containedpage : containedPages) {
			if(containedpage >= 0 && containedpage < EnumPaleoPages.values().length) {
				intList.add(containedpage);
			}
		}
		return intList;
	}
	
	public static int[] fromList(List<Integer> containedpages) {
		int[] pages = new int[containedpages.size()];
		for (int i = 0; i < pages.length; i++) pages[i] = containedpages.get(i);
		return pages;
	}
	
	public static List<EnumPaleoPages> containedPages(List<Integer> pages) {
		List<EnumPaleoPages> list = new ArrayList<>();
		for(Integer page : pages) {
			if(page >= 0 && page < EnumPaleoPages.values().length) {
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
		for(EnumPaleoPages page : pages) {
			return !pages.contains(page);
		}
		return false;
	}
	
	public static List<Integer> enumToInt(List<EnumPaleoPages> pages) {
		Iterator<superlord.prehistoricfauna.util.EnumPaleoPages> itr = pages.iterator();
		List<Integer> list = new ArrayList<Integer>();
		while(itr.hasNext())  {
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
			CompoundNBT tag = book.getTag();
			List<EnumPaleoPages> allPages = new ArrayList<EnumPaleoPages>();
			for (EnumPaleoPages page : EnumPaleoPages.values()) {
				allPages.add(page);
			}
			List<EnumPaleoPages> containedPages = containedPages(toList(tag.getIntArray("Pages")));
			List<EnumPaleoPages> possiblePages = new ArrayList<EnumPaleoPages>();
			Iterator<superlord.prehistoricfauna.util.EnumPaleoPages> itr = allPages.iterator();
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
			CompoundNBT tag = book.getTag();
			List<EnumPaleoPages> enumList = containedPages(toList(tag.getIntArray("Pages")));
			if(!enumList.contains(page)) {
				enumList.add(page);
				flag = true;
			}
			tag.putIntArray("Pages", fromList(enumToInt(enumList)));
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
