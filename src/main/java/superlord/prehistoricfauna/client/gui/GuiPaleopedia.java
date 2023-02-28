package superlord.prehistoricfauna.client.gui;

import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;

import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
		super(new TranslatableComponent("paleopedia_gui"));
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
						new TranslatableComponent("paleopedia."
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
	public void render(@NotNull PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		for (Widget widget : this.renderables) {
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
		blit(ms, cornerX, cornerY, 0, 0, X, Y, 390, 390);
		RenderSystem.disableDepthTest();
		super.render(ms, mouseX, mouseY, partialTicks);
		ms.pushPose();
		ms.translate(cornerX, cornerY, 0.0F);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		int centerX = (width - X) / 2;
		int centerY = (height - Y) / 2;
		if (!index) {
			drawPerPage(ms, bookPages);
			int pageLeft = bookPages * 2 + 1;
			int pageRight = pageLeft + 1;
			font.draw(ms, "" + pageLeft, centerX, centerY - (int) (Y * 0.13), 0X303030);
			font.draw(ms, "" + pageRight, centerX, centerY - (int) (Y * 0.13), 0X303030);
		}
		ms.popPose();
		this.renderables.forEach((widget -> widget.render(ms, mouseX, mouseY, partialTicks)));
		RenderSystem.enableDepthTest();
	}

	public void drawPerPage(PoseStack ms, int bookPages) {
		imageFromTxt(ms);
		writeFromTxt(ms);
	}

	@SuppressWarnings("resource")
	public void imageFromTxt(PoseStack ms) {
		String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
		String languageName = Minecraft.getInstance().options.languageCode.toLowerCase(Locale.ROOT);
		ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + languageName + "_0/" + fileName);
		ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
		Resource resource = null;

		try {
			resource = Minecraft.getInstance().getResourceManager().getResource(fileLoc);
		} catch (IOException e) {
			try {
				resource = Minecraft.getInstance().getResourceManager().getResource(backupLoc);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			final List<String> lines = IOUtils.readLines(resource.getInputStream(), StandardCharsets.UTF_8);
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
						ms.pushPose();
						drawImage(ms, resourcelocation, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Float.parseFloat(split[7]) * 512F);
						ms.popPose();
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
					ms.pushPose();
					drawRecipe(ms, result, ingredients, x, y, scale);
					ms.popPose();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void drawRecipe(PoseStack ms, ItemStack result, ItemStack[] ingredients, int x, int y, float scale) {
		// Code snippet based on Citadels GuiBasicBook
		int k = (this.width - X + 84) / 2;
		int l = (this.height - Y + 40) / 2;
		ms.pushPose();
		ms.translate(k + x, l + y, 0.0D);
		ms.scale(scale, scale, scale);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		ms.popPose();
		PoseStack poseStack = RenderSystem.getModelViewStack();
		for (int i = 0; i < 9; i++) {
			poseStack.pushPose();
			poseStack.translate(k, l, 32.0D);
			poseStack.translate(((x + (i % 3 * 22) * scale)), ((y + (i / 3 * 22) * scale)), 0.0D);
			poseStack.scale(scale, scale, scale);
			this.itemRenderer.blitOffset = 100.0F;
			this.itemRenderer.renderAndDecorateItem(ingredients[i], 0, 0);
			this.itemRenderer.blitOffset = 0.0F;
			poseStack.popPose();
		}
		poseStack.pushPose();
		poseStack.translate(k, l, 32.0D);
		float finScale = scale * 1.5F;
		poseStack.translate((x + 70.0F * finScale), (y + 10.0F * finScale), 0.0D);
		poseStack.scale(finScale, finScale, finScale);
		this.itemRenderer.blitOffset = 100.0F;
		this.itemRenderer.renderAndDecorateItem(result, 0, 0);
		this.itemRenderer.blitOffset = 0.0F;
		poseStack.popPose();
		RenderSystem.applyModelViewMatrix();
		ms.pushPose();
		ms.translate(x, y, 0);
		ms.scale(scale, scale, 0);
		ms.translate(37F, 13, 1F);
		ms.scale(1.5F, 1.5F, 1F);
		drawImage(ms, DRAWINGS_0, 0, 0, 389, 1, 50, 50, 512F);
		ms.popPose();
	}

	@SuppressWarnings("resource")
	public void writeFromTxt(PoseStack ms) {
		String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
		String languageName = Minecraft.getInstance().options.languageCode.toLowerCase(Locale.ROOT);
		ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + languageName + "_0/" + fileName);
		ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
		Resource resource = null;

		try {
			resource = Minecraft.getInstance().getResourceManager().getResource(fileLoc);
		} catch (IOException e) {
			try {
				resource = Minecraft.getInstance().getResourceManager().getResource(backupLoc);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			final List<String> lines = IOUtils.readLines(resource.getInputStream(), "UTF-8");
			int linenumber = 0;
			for (String line : lines) {
				line = line.trim();
				if (line.contains("<") || line.contains(">")) {
					continue;
				}
				ms.pushPose();
				if (usingVanillaFont()) {
					ms.scale(0.945F, 0.945F, 0.945F);
					ms.translate(0, 5.5F, 0);
				}
				if (linenumber <= 19) {
					font.draw(ms, line, 23, 20 + linenumber * 10, 0X303030);
				} else {
					font.draw(ms, line, 220, (linenumber - 19) * 10, 0X303030);
				}
				linenumber++;
				ms.popPose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ms.pushPose();
		String s = StatCollector.translateToLocal("paleopedia." + this.pageType.toString().toLowerCase(Locale.ROOT));
		float scale = font.width(s) <= 100 ? 1.5F : font.width(s) * 0.0125F;
		ms.scale(scale, scale, scale);
		font.draw(ms, s, 25, 7, 0X7A756A);
		ms.popPose();
	}

	@SuppressWarnings("resource")
	private boolean usingVanillaFont() {
		return font == Minecraft.getInstance().font;
	}

	public void drawImage(PoseStack ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
		ms.pushPose();
		RenderSystem.setShaderTexture(0, texture);
		ms.scale(scale / 512F, scale / 512F, scale / 512F);
		blit(ms, x, y, u, v, width, height, 512, 512);
		ms.popPose();
	}

	private void drawItemStack(PoseStack ms, ItemStack stack, int x, int y, float scale) {
		// Code snippet based on Citadels GuiBasicBook
		int cornerX = (width - X) / 2;
		int cornerY = (height - Y) / 2;

		this.itemRenderer.blitOffset = 100.0F;
		ms.pushPose();
		PoseStack poseStack = RenderSystem.getModelViewStack();
		poseStack.pushPose();
		poseStack.translate(cornerX, cornerY, 0.0D);
		poseStack.scale(scale, scale, scale);
		this.itemRenderer.renderAndDecorateItem(stack, x, y);
		this.itemRenderer.blitOffset = 0.0F;
		poseStack.popPose();
		ms.popPose();
		RenderSystem.applyModelViewMatrix();

	}

	/*protected void renderItemModelIntoGUI(PoseStack ms, ItemStack stack, int x, int y, BakedModel bakedmodel, float scale) {
        ms.pushPose();
        // PlayerContainer.LOCATION_BLOCKS_TEXTURE is equivalent to
        // AtlasTexture.LOCATION_BLOCKS_TEXTURE, but the latter is deprecated
        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
        this.getMinecraft().getTextureManager().getTexture(InventoryMenu.BLOCK_ATLAS)
            .setFilter(false, false);
        RenderSystem.enableRescaleNormal();
        RenderSystem.enableAlphaTest();
        RenderSystem.defaultAlphaFunc();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        ms.scale(16.0F * scale, 16.0F * scale, 16.0F * scale);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        ms.translate(x, y, 100.0F + itemRenderer.blitOffset);
        ms.scale(1.0F, -1.0F, 1.0F);
        PoseStack matrixstack = new PoseStack();
        MultiBufferSource.BufferSource irendertypebuffer$impl = Minecraft.getInstance().renderBuffers().bufferSource();
        boolean flag = !bakedmodel.usesBlockLight();
        if (flag) {
            Lighting.setupForFlatItems();
        }
        this.itemRenderer.render(stack, ItemTransforms.TransformType.GUI, false, matrixstack, irendertypebuffer$impl, 15728880, OverlayTexture.NO_OVERLAY, bakedmodel);
        irendertypebuffer$impl.endBatch();
        RenderSystem.enableDepthTest();
        if (flag) {
            Lighting.setupFor3DItems();
        }
        RenderSystem.disableAlphaTest();
        RenderSystem.disableRescaleNormal();
        ms.popPose();
    }*/

	private void drawBlockStack(PoseStack ms, ItemStack stack, int x, int y, float scale, int zScale) {
		int cornerX = (width - X) / 2;
		int cornerY = (height - Y) / 2;

		this.itemRenderer.blitOffset = 100.0F;
		ms.pushPose();
		PoseStack poseStack = RenderSystem.getModelViewStack();
		poseStack.pushPose();
		poseStack.translate(cornerX, cornerY, 0.0D);
		poseStack.scale(scale, scale, scale);
		this.itemRenderer.blitOffset = -100 + zScale * 10;
		this.itemRenderer.renderAndDecorateItem(stack, x, y);
		this.itemRenderer.blitOffset = 0.0F;
		poseStack.popPose();
		ms.popPose();
		RenderSystem.applyModelViewMatrix();

	}
	
	public class StatCollector {

	    public static String translateToLocal(String s) {
	        return I18n.get(s);
	    }
	}
	
}
