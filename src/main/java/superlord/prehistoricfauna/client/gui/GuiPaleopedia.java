package superlord.prehistoricfauna.client.gui;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;

public class GuiPaleopedia extends Screen {
	protected static final int X = 390;
	protected static final int Y = 245;
	private static final ResourceLocation TEXTURE = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/paleopedia.png");
	private static final ResourceLocation DRAWINGS_0 = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/drawings_0.png");
	private static final Map<String, ResourceLocation> PICTURE_LOCATION_CACHE = Maps.newHashMap();
	public List<EnumPaleoPages> allPageTypes = new ArrayList<>();
	public EnumPaleoPages pageType;
	public List<IndexPageButton> indexButtons = new ArrayList<>();
	public ChangePageButton previousPage;
	public ChangePageButton nextPage;
	public int bookPages;
	public int bookPagesTotal = 1;
	public int indexPages;
	public int indexPagesTotal = 1;
	protected ItemStack book;
	protected boolean index;
	protected Font font = getFont();

	public GuiPaleopedia(ItemStack book) {
		super(Component.translatable("paleopedia_gui"));
		this.book = book;
		if (!book.isEmpty() && book.getItem() != null && book.getItem() == PFItems.PALEOPEDIA.get()) {
			if (book.getTag() != null) {
				Set<EnumPaleoPages> pages = EnumPaleoPages.containedPages(Ints.asList(book.getTag().getIntArray("Pages")));
				allPageTypes.addAll(pages);
				// Make sure the pages are sorted according to the enum
				allPageTypes.sort(Comparator.comparingInt(Enum::ordinal));
				indexPagesTotal = (int) Math.ceil(pages.size() / 10D);
			}
		}
		index = true;
	}

	@SuppressWarnings("resource")
	private static Font getFont() {
		return Minecraft.getInstance().font;
	}

	private static Item getItemByRegistryName(String registryName) {
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(registryName));
	}

	@Override
	protected void init() {
		super.init();
		int centerX = (width - X) / 2;
		int centerY = (height - Y) / 2;
		this.previousPage = new ChangePageButton(centerX + 25, centerY + 215, false, 0, (p_214132_1_) -> {
			if ((this.index ? this.indexPages > 0 : this.pageType != null)) {
				if (this.index) {
					this.indexPages--;
					Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
				} else {
					if (this.bookPages > 0) {
						this.bookPages--;
						Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
					} else {
						this.index = true;
					}
				}
			}
		});
		this.addRenderableWidget(previousPage);
		this.nextPage = new ChangePageButton(centerX + 347, centerY + 215, true, 0, (p_214132_1_) -> {
			if ((this.index ? this.indexPages < this.indexPagesTotal - 1 : this.pageType != null && this.bookPages < this.pageType.pages)) {
				if (this.index) {
					this.indexPages++;
					Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
				} else {
					this.bookPages++;
					Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
				}
			}
		});
		this.addRenderableWidget(this.nextPage);
		if (!allPageTypes.isEmpty()) {
			for (int i = 0; i < allPageTypes.size(); i++) {
				int xIndex = i % -2;
				int yIndex = i % 10;
				int id = 2 + i;
				IndexPageButton button = new IndexPageButton(centerX + 15 + (xIndex * 200),
						centerY + 10 + (yIndex * 20) - (xIndex == 1 ? 20 : 0),
						Component.translatable("paleopedia."
								+ EnumPaleoPages.values()[allPageTypes.get(i).ordinal()].toString().toLowerCase()),
						(p_214132_1_) -> {
							if (this.indexButtons.get(id - 2) != null && allPageTypes.get(id - 2) != null) {
								Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));
								this.index = false;
								this.bookPages = 0;
								this.pageType = allPageTypes.get(id - 2);
							}
						});
				this.indexButtons.add(button);
				this.addRenderableWidget(button);
			}
		}
	}

	@Override
	public void render(@NotNull GuiGraphics ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		for (Renderable widget : this.renderables) {
			if (widget instanceof IndexPageButton) {
				IndexPageButton button = (IndexPageButton) widget;
				button.active = index;
				button.visible = index;
			}

		}
		for (int i = 0; i < this.indexButtons.size(); i++) {
			this.indexButtons.get(i).active = i < 10 * (this.indexPages + 1) && i >= 10 * (this.indexPages) && this.index;
		}
		RenderSystem.setShaderTexture(0, TEXTURE);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		int cornerX = (width - X) / 2;
		int cornerY = (height - Y) / 2;
		ms.blit(TEXTURE, cornerX, cornerY, 0, 0, X, Y, 390, 390);
		RenderSystem.disableDepthTest();
		super.render(ms, mouseX, mouseY, partialTicks);
		ms.pose().pushPose();
		ms.pose().translate(cornerX, cornerY, 0.0F);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		int centerX = (width - X) / 2;
		int centerY = (height - Y) / 2;
		if (!index) {
			drawPerPage(ms, bookPages);
			int pageLeft = bookPages * 2 + 1;
			int pageRight = pageLeft + 1;
			font.drawInBatch("" + pageLeft, centerX, centerY - (int) (Y * 0.13), 0X303030, false, ms.pose().last().pose(), ms.bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
			font.drawInBatch("" + pageRight, centerX, centerY - (int) (Y * 0.13), 0X303030, false, ms.pose().last().pose(), ms.bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
		}
		ms.pose().popPose();
		this.renderables.forEach((widget -> widget.render(ms, mouseX, mouseY, partialTicks)));
		RenderSystem.enableDepthTest();
	}

	public void drawPerPage(GuiGraphics ms, int bookPages) {
		imageFromTxt(ms);
		writeFromTxt(ms);
	}

	@SuppressWarnings("resource")
	public void imageFromTxt(GuiGraphics ms) {
		String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
		String languageName = Minecraft.getInstance().options.languageCode.toLowerCase(Locale.ROOT);
		ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + languageName + "_0/" + fileName);
		ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
		Optional<Resource> resource;

		resource = Minecraft.getInstance().getResourceManager().getResource(fileLoc);
		if (resource.isEmpty()) {
			resource = Minecraft.getInstance().getResourceManager().getResource(backupLoc);
		}
		try {
			if (resource.isPresent()) {
				final List<String> lines = IOUtils.readLines(resource.get().open(), StandardCharsets.UTF_8);
				int zLevelAdd = 0;
				for (String line : lines) {
					line = line.trim();
					if (line.contains("<") || line.contains(">")) {
						if (line.contains("<image>")) {
							line = line.substring(8, line.length() - 1);
							String[] split = line.split(" ");
							String texture = "prehistoricfauna:textures/gui/paleopedia/" + split[0];
							ResourceLocation resourcelocation = PICTURE_LOCATION_CACHE.get(texture);
							if (resourcelocation == null) {
								resourcelocation = new ResourceLocation(texture);
								PICTURE_LOCATION_CACHE.put(texture, resourcelocation);
							}
							ms.pose().pushPose();
							drawImage(ms, resourcelocation, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Float.parseFloat(split[7]) * 512F);
							ms.pose().popPose();
						}
					}
					if (line.contains("<item>")) {
						line = line.substring(7, line.length() - 1);
						String[] split = line.split(" ");
						RenderSystem.enableDepthTest();
						drawItemStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F);
					}
					if (line.contains("<block>")) {
						zLevelAdd += 1;
						line = line.substring(8, line.length() - 1);
						String[] split = line.split(" ");
						RenderSystem.enableDepthTest();
						drawBlockStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F, zLevelAdd);
					}
					if (line.contains("<recipe>")) {
						line = line.substring(9, line.length() - 1);
						String[] split = line.split(" ");
						RenderSystem.enableDepthTest();
						float scale = Float.parseFloat(split[split.length - 1]);
						int x = Integer.parseInt(split[split.length - 3]);
						int y = Integer.parseInt(split[split.length - 2]);
						ItemStack result = new ItemStack(getItemByRegistryName(split[0]), 1);
						ItemStack[] ingredients = new ItemStack[]{ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};
						int j = 8;
						for (int i = split.length - 5; i >= 2; i -= 2) {
							ingredients[j] = new ItemStack(getItemByRegistryName(split[i]), 1);
							j--;
						}
						RenderSystem.enableDepthTest();
						ms.pose().pushPose();
						drawRecipe(ms, result, ingredients, x, y, scale);
						ms.pose().popPose();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void drawRecipe(GuiGraphics ms, ItemStack result, ItemStack[] ingredients, int x, int y, float scale) {
		ms.pose().pushPose();
		ms.pose().translate(x, y, 0.0D);
		ms.pose().scale(scale, scale, scale);
		ms.pose().popPose();
		for (int i = 0; i < 9; i++) {
			ms.pose().pushPose();
			ms.pose().translate(44, 20, 32.0D);
			ms.pose().translate(((x + (i % 3 * 22) * scale)), ((y + (i / 3 * 22) * scale)), 0.0D);
			ms.pose().scale(scale, scale, scale);
			ms.renderItem(ingredients[i], 0, 0);
			ms.pose().popPose();
		}
		ms.pose().pushPose();
		ms.pose().translate(40, 20, 32.0D);
		float finScale = scale * 1.5F;
		ms.pose().translate((x + 70.0F * finScale), (y + 10.0F * finScale), 0.0D);
		ms.pose().scale(finScale, finScale, finScale);
		ms.renderItem(result, 0, 0);
		ms.pose().popPose();

		ms.pose().pushPose();
		ms.pose().translate(x, y, 0);
		ms.pose().scale(scale, scale, 0);
		ms.pose().translate(37F, 13, 1F);
		ms.pose().scale(1.5F, 1.5F, 1F);
		drawImage(ms, DRAWINGS_0, 0, 0, 389, 1, 50, 50, 512F);
		ms.pose().popPose();
	}

	@SuppressWarnings("resource")
	public void writeFromTxt(GuiGraphics ms) {
		String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
		String languageName = Minecraft.getInstance().options.languageCode.toLowerCase(Locale.ROOT);
		ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + languageName + "_0/" + fileName);
		ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
		Optional<Resource> resource;

		resource = Minecraft.getInstance().getResourceManager().getResource(fileLoc);
		if (resource.isEmpty()) {
			resource = Minecraft.getInstance().getResourceManager().getResource(backupLoc);
		}
		try {
            final List<String> lines = IOUtils.readLines(resource.get().open(), "UTF-8");
			int linenumber = 0;
			for (String line : lines) {
				line = line.trim();
				if (line.contains("<") || line.contains(">")) {
					continue;
				}
				ms.pose().pushPose();
				if (usingVanillaFont()) {
					ms.pose().scale(0.945F, 0.945F, 0.945F);
					ms.pose().translate(0, 5.5F, 0);
				}
				if (linenumber <= 19) {
					font.drawInBatch(line, 23, 20 + linenumber * 10, 0X303030, false, ms.pose().last().pose(), ms.bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
				} else {
					font.drawInBatch(line, 220, (linenumber - 19) * 10, 0X303030, false, ms.pose().last().pose(), ms.bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
				}
				linenumber++;
				ms.pose().popPose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ms.pose().pushPose();
		String s = StatCollector.translateToLocal("paleopedia." + this.pageType.toString().toLowerCase(Locale.ROOT));
		float scale = font.width(s) <= 100 ? 1.5F : font.width(s) * 0.0125F;
		ms.pose().scale(scale, scale, scale);
		font.drawInBatch(s, 25, 7, 0X7A756A, false, ms.pose().last().pose(), ms.bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
		ms.pose().popPose();
	}

	@SuppressWarnings("resource")
	private boolean usingVanillaFont() {
		return font == Minecraft.getInstance().font;
	}

	public void drawImage(GuiGraphics ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
		ms.pose().pushPose();
		RenderSystem.setShaderTexture(0, texture);
		ms.pose().scale(scale / 512F, scale / 512F, scale / 512F);
		ms.blit(texture, x, y, u, v, width, height, 512, 512);
		ms.pose().popPose();
	}

	private void drawItemStack(GuiGraphics ms, ItemStack stack, int x, int y, float scale) {
		 ms.pose().pushPose();
	        ms.pose().scale(scale, scale, scale);
	        ms.renderItem(stack, x, y);
	        ms.pose().popPose();
	}

	private void drawBlockStack(GuiGraphics ms, ItemStack stack, int x, int y, float scale, int zScale) {
		ms.pose().pushPose();
        ms.pose().scale(scale, scale, scale);
        ms.pose().translate(0, 0, zScale * 10);
        ms.renderItem(stack, x, y);
        ms.pose().popPose();
	}

	public class StatCollector {

		public static String translateToLocal(String s) {
			return I18n.get(s);
		}
	}

}
