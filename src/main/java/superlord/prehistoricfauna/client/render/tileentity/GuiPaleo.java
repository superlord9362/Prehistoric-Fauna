package superlord.prehistoricfauna.client.render.tileentity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.util.StatCollector;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFItems;
import net.minecraft.client.renderer.model.ItemCameraTransforms;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("deprecation")
public class GuiPaleo extends Screen {
	
	protected static final int X = 390;
    protected static final int Y = 245;
    private static final ResourceLocation TEXTURE = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/paleopedia.png");
    private static final ResourceLocation DRAWINGS_0 = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/drawings_0.png");
    private static final Map<String, ResourceLocation> PICTURE_LOCATION_CACHE = Maps.newHashMap();
    public List<EnumPaleoPages> allPageTypes = new ArrayList<EnumPaleoPages>();
    public EnumPaleoPages pageType;
    public List<IndexPageButton> indexButtons = new ArrayList<IndexPageButton>();
    public ChangePageButton previousPage;
    public ChangePageButton nextPage;
    public int bookPages;
    public int bookPagesTotal = 1;
    public int indexPages;
    public int indexPagesTotal = 1;
    protected ItemStack book;
    protected boolean index;
    protected FontRenderer font = getFont();

    public GuiPaleo(ItemStack book) {
        super(new TranslationTextComponent("paleopedia_gui"));
        this.book = book;
        @SuppressWarnings("unused")
		int indexPageTotal = 0;
        if (!book.isEmpty() && book.getItem() != null && book.getItem() == PFItems.PALEOPEDIA.get()) {
            if (book.getTag() != null) {
                List<EnumPaleoPages> pages = EnumPaleoPages.containedPages(EnumPaleoPages.toList(book.getTag().getIntArray("Pages")));
                allPageTypes.addAll(pages);
                indexPagesTotal = (int) Math.ceil(pages.size() / 10D);
            }
        }
        index = true;
    }

    @SuppressWarnings("resource")
	private FontRenderer getFont() {
        FontRenderer font;
        if (!Minecraft.getInstance().gameSettings.language.equalsIgnoreCase("en_us")) {
            font = Minecraft.getInstance().fontRenderer;
        } else {
            font = (FontRenderer) PrehistoricFauna.PROXY.getFontRenderer();
        }
        return font;
    }

    protected void init() {
        super.init();
        int centerX = (width - X) / 2;
        int centerY = (height - Y) / 2;
        this.addButton(this.previousPage = new ChangePageButton(centerX + 15, centerY + 215, false, bookPages, 0, (p_214132_1_) -> {
            if ((this.index ? this.indexPages > 0 : this.pageType != null)) {
                if (this.index) {
                    this.indexPages--;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                } else {
                    if (this.bookPages > 0) {
                        this.bookPages--;
                        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                    } else {
                        this.index = true;
                    }
                }
            }
        }));
        this.addButton(this.nextPage = new ChangePageButton(centerX + 357, centerY + 215, true, bookPages, 0, (p_214132_1_) -> {
            if ((this.index ? this.indexPages < this.indexPagesTotal - 1 : this.pageType != null && this.bookPages < this.pageType.pages)) {
                if (this.index) {
                    this.indexPages++;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                } else {
                    this.bookPages++;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                }
            }
        }));
        if (!allPageTypes.isEmpty()) {
            for (int i = 0; i < allPageTypes.size(); i++) {
                int xIndex = i % -2;
                int yIndex = i % 10;
                int id = 2 + i;
                IndexPageButton button = new IndexPageButton(id, centerX + 15 + (xIndex * 200), centerY + 10 + (yIndex * 20) - (xIndex == 1 ? 20 : 0), new TranslationTextComponent("paleopedia." + EnumPaleoPages.values()[allPageTypes.get(i).ordinal()].toString().toLowerCase()), (p_214132_1_) -> {
                    if (this.indexButtons.get(id - 2) != null && allPageTypes.get(id - 2) != null) {
                        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                        this.index = false;
                        this.bookPages = 0;
                        this.pageType = allPageTypes.get(id - 2);
                    }
                });
                this.indexButtons.add(button);
                this.addButton(button);
            }
        }
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        for (Widget button : this.buttons) {
            if (button instanceof IndexPageButton) {
                button.active = index;
                button.visible = index;
            }
        }
        for (int i = 0; i < this.indexButtons.size(); i++) {
            this.indexButtons.get(i).active = i < 10 * (this.indexPages + 1) && i >= 10 * (this.indexPages) && this.index;
        }
        this.renderBackground(ms);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        blit(ms, cornerX, cornerY, 0, 0, X, Y, 390, 390);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.render(ms, mouseX, mouseY, partialTicks);
        RenderHelper.enableStandardItemLighting();
        ms.push();
        ms.translate(cornerX, cornerY, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int centerX = (width - X) / 2;
        int centerY = (height - Y) / 2;
        if (!index) {
            drawPerPage(ms, bookPages);
            int pageLeft = bookPages * 2 + 1;
            int pageRight = pageLeft + 1;
            font.drawString(ms, "" + pageLeft, centerX, centerY - (int) (Y * 0.13), 0X303030);
            font.drawString(ms, "" + pageRight, centerX, centerY - (int) (Y * 0.13), 0X303030);
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        ms.pop();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    public void drawPerPage(MatrixStack ms, int bookPages) {
        imageFromTxt(ms);
        writeFromTxt(ms);
    }

    @SuppressWarnings({ "resource", "rawtypes", "unused" })
	public void imageFromTxt(MatrixStack ms) {
        String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
        ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + Minecraft.getInstance().gameSettings.language + "_0/" + fileName);
        ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
        IResource resource = null;

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
            Iterator iterator = IOUtils.readLines(resource.getInputStream(), "UTF-8").iterator();
            String line = null;
            int linenumber = 0;
            int zLevelAdd = 0;
            while (iterator.hasNext()) {
                line = ((String) iterator.next()).trim();
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
                        ms.push();
                        drawImage(ms, resourcelocation, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Float.parseFloat(split[7]) * 512F);
                        ms.pop();
                    }
                }
                if (line.contains("<item>")) {
                    line = line.substring(7, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawItemStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F);
                }
                if (line.contains("<block>")) {
                    zLevelAdd += 1;
                    line = line.substring(8, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawBlockStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F, zLevelAdd);
                }
                if (line.contains("<recipe>")) {
                    line = line.substring(9, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
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
                    RenderHelper.enableStandardItemLighting();
                    ms.push();
                    drawRecipe(ms, result, ingredients, x, y, scale);
                    ms.pop();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Item getItemByRegistryName(String registryName) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(registryName));
    }

    private void drawRecipe(MatrixStack ms, ItemStack result, ItemStack[] ingredients, int x, int y, float scale) {
        RenderSystem.pushMatrix();
        RenderSystem.translatef(x, y, 0);
        RenderSystem.scalef(scale, scale, 0);
        drawItemStack(ms, result, 62, 17, 2F);
        for (int i = 0; i < 9; i++) {
            drawItemStack(ms, ingredients[i], ((i % 3) * 22 + 30), ((i / 3) * 22 + 10), 1.25F);
        }
        RenderSystem.popMatrix();
        ms.push();
        ms.translate(x, y, 0);
        ms.scale(scale, scale, 0);
        ms.translate(37F, 13, 1F);
        ms.scale(1.5F, 1.5F, 1F);
        drawImage(ms, DRAWINGS_0, 0, 0, 389, 1, 50, 50, 512F);
        ms.pop();

    }

    @SuppressWarnings({ "rawtypes", "resource" })
	public void writeFromTxt(MatrixStack ms) {
        String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
        ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + Minecraft.getInstance().gameSettings.language + "_0/" + fileName);
        ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
        IResource resource = null;

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
            Iterator iterator = IOUtils.readLines(resource.getInputStream(), "UTF-8").iterator();
            String line = null;
            int linenumber = 0;
            while (iterator.hasNext()) {
                line = ((String) iterator.next()).trim();
                if (line.contains("<") || line.contains(">")) {
                    continue;
                }
                ms.push();
                if (usingVanillaFont()) {
                    ms.scale(0.945F, 0.945F, 0.945F);
                    ms.translate(0, 5.5F, 0);
                }
                if (linenumber <= 19) {
                    font.drawString(ms, line, 15, 20 + linenumber * 10, 0X303030);
                } else {
                    font.drawString(ms, line, 220, (linenumber - 19) * 10, 0X303030);
                }
                linenumber++;
                ms.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ms.push();
        String s = StatCollector.translateToLocal("paleopedia." + this.pageType.toString().toLowerCase(Locale.ROOT));
        float scale = font.getStringWidth(s) <= 100 ? 2 : font.getStringWidth(s) * 0.0125F;
        ms.scale(scale, scale, scale);
        font.drawString(ms, s, 10, 2, 0X7A756A);
        ms.pop();
    }

    @SuppressWarnings("resource")
	private boolean usingVanillaFont() {
        return font == Minecraft.getInstance().fontRenderer;
    }

    public void drawImage(MatrixStack ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
        ms.push();
        this.getMinecraft().getTextureManager().bindTexture(texture);
        ms.scale(scale / 512F, scale / 512F, scale / 512F);
        blit(ms, x, y, u, v, width, height, 512, 512);
        ms.pop();
    }

    @SuppressWarnings("unused")
	private void drawItemStack(MatrixStack ms, ItemStack stack, int x, int y, float scale) {
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        RenderSystem.pushMatrix();
        RenderSystem.translatef(cornerX, cornerY, 32.0F);
        float zLevel = 200.0F;
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        RenderSystem.scalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100;
        RenderSystem.depthMask(true);
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        zLevel = 0.0F;
        this.itemRenderer.zLevel = 0.0F;
        RenderSystem.popMatrix();
    }

    @SuppressWarnings("unused")
	protected void renderItemModelIntoGUI(MatrixStack ms, ItemStack stack, int x, int y, IBakedModel bakedmodel, float scale) {
        int i = (this.width - X) / 2;
        int j = (this.height - Y) / 2;
        RenderSystem.pushMatrix();
        this.getMinecraft().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
        this.getMinecraft().getTextureManager().getTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE).setBlurMipmapDirect(false, false);
        RenderSystem.enableRescaleNormal();
        RenderSystem.enableAlphaTest();
        RenderSystem.defaultAlphaFunc();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.scalef(16.0F * scale, 16.0F * scale, 16.0F * scale);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.translatef((float)x, (float)y , 100.0F + itemRenderer.zLevel);
        RenderSystem.scalef(1.0F, -1.0F, 1.0F);
        MatrixStack matrixstack = new MatrixStack();
        IRenderTypeBuffer.Impl irendertypebuffer$impl = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        boolean flag = !bakedmodel.isSideLit();
        if (flag) {
            RenderHelper.setupGuiFlatDiffuseLighting();
        }

        this.itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.GUI, false, matrixstack, irendertypebuffer$impl, 15728880, OverlayTexture.NO_OVERLAY, bakedmodel);
        irendertypebuffer$impl.finish();
        RenderSystem.enableDepthTest();
        if (flag) {
            RenderHelper.setupGui3DDiffuseLighting();
        }

        RenderSystem.disableAlphaTest();
        RenderSystem.disableRescaleNormal();
        RenderSystem.popMatrix();
    }


    @SuppressWarnings("unused")
	private void drawBlockStack(MatrixStack ms, ItemStack stack, int x, int y, float scale, int zScale) {
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        RenderSystem.pushMatrix();
        RenderSystem.translatef(cornerX, cornerY, 32.0F);
        float zLevel = 200.0F;
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        GL11.glScalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100 + zScale * 10;
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        zLevel = 0.0F;
        this.itemRenderer.zLevel = 0.0F;
        RenderSystem.popMatrix();

    }
}
	/*
	protected static final int X = 390;
    protected static final int Y = 245;
    private static final ResourceLocation TEXTURE = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/paleopedia.png");
    private static final ResourceLocation DRAWINGS_0 = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/drawings_0.png");
    private static final Map<String, ResourceLocation> PICTURE_LOCATION_CACHE = Maps.newHashMap();
    public List<EnumPaleoPages> allPageTypes = new ArrayList<EnumPaleoPages>();
    public EnumPaleoPages pageType;
    public List<IndexPageButton> indexButtons = new ArrayList<IndexPageButton>();
    public ChangePageButton previousPage;
    public ChangePageButton nextPage;
    public int bookPages;
    public int bookPagesTotal = 1;
    public int indexPages;
    public int indexPagesTotal = 1;
    protected ItemStack book;
    protected boolean index;
    protected FontRenderer font = getFont();

	public GuiPaleo(ItemStack book) {
        super(new TranslationTextComponent("paleopedia_gui"));
        this.book = book;
        int indexPageTotal = 0;
        if (!book.isEmpty() && book.getItem() != null && book.getItem() == PFItems.PALEOPEDIA.get()) {
            if (book.getTag() != null) {
                List<EnumPaleoPages> pages = EnumPaleoPages.containedPages(EnumPaleoPages.toList(book.getTag().getIntArray("Pages")));
                allPageTypes.addAll(pages);
                indexPagesTotal = (int) Math.ceil(pages.size() / 10D);
            }
        }
        index = true;
    }

    @SuppressWarnings("resource")
	private FontRenderer getFont() {
        FontRenderer font;
        if (!Minecraft.getInstance().gameSettings.language.equalsIgnoreCase("en_us")) {
            font = Minecraft.getInstance().fontRenderer;
        } else {
            font = (FontRenderer) PrehistoricFauna.PROXY.getFontRenderer();
        }
        return font;
    }

    protected void init() {
        super.init();
        int centerX = (width - X) / 2;
        int centerY = (height - Y) / 2;
        this.addButton(this.previousPage = new ChangePageButton(centerX + 15, centerY + 215, false, bookPages, 0, (p_214132_1_) -> {
            if ((this.index ? this.indexPages > 0 : this.pageType != null)) {
                if (this.index) {
                    this.indexPages--;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                } else {
                    if (this.bookPages > 0) {
                        this.bookPages--;
                        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                    } else {
                        this.index = true;
                    }
                }
            }
        }));
        this.addButton(this.nextPage = new ChangePageButton(centerX + 357, centerY + 215, true, bookPages, 0, (p_214132_1_) -> {
            if ((this.index ? this.indexPages < this.indexPagesTotal - 1 : this.pageType != null && this.bookPages < this.pageType.pages)) {
                if (this.index) {
                    this.indexPages++;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                } else {
                    this.bookPages++;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                }
            }
        }));
        if (!allPageTypes.isEmpty()) {
            for (int i = 0; i < allPageTypes.size(); i++) {
                int xIndex = i % -2;
                int yIndex = i % 10;
                int id = 2 + i;
                IndexPageButton button = new IndexPageButton(id, centerX + 24 + (xIndex * 182), centerY + 20 + (yIndex * 20) - (xIndex == 1 ? 20 : 0), new TranslationTextComponent("paleopedia." + EnumPaleoPages.values()[allPageTypes.get(i).ordinal()].toString().toLowerCase()), (p_214132_1_) -> {
                    if (this.indexButtons.get(id - 2) != null && allPageTypes.get(id - 2) != null) {
                        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                        this.index = false;
                        this.bookPages = 0;
                        this.pageType = allPageTypes.get(id - 2);
                    }
                });
                this.indexButtons.add(button);
                this.addButton(button);
            }
        }
    }
    
    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        for (Widget button : this.buttons) {
            if (button instanceof IndexPageButton) {
                button.active = index;
                button.visible = index;
            }
        }
        for (int i = 0; i < this.indexButtons.size(); i++) {
            this.indexButtons.get(i).active = i < 10 * (this.indexPages + 1) && i >= 10 * (this.indexPages) && this.index;
        }
        this.renderBackground(ms);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        blit(ms, cornerX, cornerY, 0, 0, X, Y, 390, 390);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.render(ms, mouseX, mouseY, partialTicks);
        RenderHelper.enableStandardItemLighting();
        ms.push();
        ms.translate(cornerX, cornerY, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int centerX = (width - X) / 2;
        int centerY = (height - Y) / 2;
        if (!index) {
            drawPerPage(ms, bookPages);
            int pageLeft = bookPages * 2 + 1;
            int pageRight = pageLeft + 1;
            font.drawString(ms, "" + pageLeft, centerX, centerY - (int) (Y * 0.13), 0X303030);
            font.drawString(ms, "" + pageRight, centerX, centerY - (int) (Y * 0.13), 0X303030);
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        ms.pop();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    public void drawPerPage(MatrixStack ms, int bookPages) {
        imageFromTxt(ms);
        writeFromTxt(ms);
    }

    @SuppressWarnings({ "resource", "unused", "rawtypes" })
	public void imageFromTxt(MatrixStack ms) {
        String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
        String languageName = Minecraft.getInstance().gameSettings.language.toLowerCase(Locale.ROOT);
        ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + languageName + "_0/" + fileName);
        ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
        IResource resource = null;

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
            Iterator iterator = IOUtils.readLines(resource.getInputStream(), "UTF-8").iterator();
            String line = null;
            int linenumber = 0;
            int zLevelAdd = 0;
            while (iterator.hasNext()) {
                line = ((String) iterator.next()).trim();
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
                        ms.push();
                        drawImage(ms, resourcelocation, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Float.parseFloat(split[7]) * 512F);
                        ms.pop();
                    }
                }
                if (line.contains("<item>")) {
                    line = line.substring(7, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawItemStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F);
                }
                if (line.contains("<block>")) {
                    zLevelAdd += 1;
                    line = line.substring(8, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawBlockStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F, zLevelAdd);
                }
                if (line.contains("<recipe>")) {
                    line = line.substring(9, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
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
                    RenderHelper.enableStandardItemLighting();
                    ms.push();
                    drawRecipe(ms, result, ingredients, x, y, scale);
                    ms.pop();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Item getItemByRegistryName(String registryName) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(registryName));
    }

    private void drawRecipe(MatrixStack ms, ItemStack result, ItemStack[] ingredients, int x, int y, float scale) {
        RenderSystem.pushMatrix();
        RenderSystem.translatef(x, y, 0);
        RenderSystem.scalef(scale, scale, 0);
        drawItemStack(ms, result, 62, 17, 2F);
        for (int i = 0; i < 9; i++) {
            drawItemStack(ms, ingredients[i], ((i % 3) * 22 + 30), ((i / 3) * 22 + 10), 1.25F);
        }
        RenderSystem.popMatrix();
        ms.push();
        ms.translate(x, y, 0);
        ms.scale(scale, scale, 0);
        ms.translate(37F, 13, 1F);
        ms.scale(1.5F, 1.5F, 1F);
        drawImage(ms, DRAWINGS_0, 0, 0, 389, 1, 50, 50, 512F);
        ms.pop();

    }

    @SuppressWarnings({ "resource", "rawtypes" })
	public void writeFromTxt(MatrixStack ms) {
        String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
        ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + Minecraft.getInstance().gameSettings.language + "_0/" + fileName);
        ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
        IResource resource = null;

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
            Iterator iterator = IOUtils.readLines(resource.getInputStream(), "UTF-8").iterator();
            String line = null;
            int linenumber = 0;
            while (iterator.hasNext()) {
                line = ((String) iterator.next()).trim();
                if (line.contains("<") || line.contains(">")) {
                    continue;
                }
                ms.push();
                if (usingVanillaFont()) {
                    ms.scale(0.945F, 0.945F, 0.945F);
                    ms.translate(0, 5.5F, 0);
                }
                if (linenumber <= 19) {
                    font.drawString(ms, line, 15, 20 + linenumber * 10, 0X303030);
                } else {
                    font.drawString(ms, line, 220, (linenumber - 19) * 10, 0X303030);
                }
                linenumber++;
                ms.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ms.push();
        String s = StatCollector.translateToLocal("paleopedia." + this.pageType.toString().toLowerCase(Locale.ROOT));
        float scale = font.getStringWidth(s) <= 100 ? 2 : font.getStringWidth(s) * 0.0125F;
        ms.scale(scale, scale, scale);
        font.drawString(ms, s, 10, 2, 0X7A756A);
        ms.pop();
    }

    @SuppressWarnings("resource")
	private boolean usingVanillaFont() {
        return font == Minecraft.getInstance().fontRenderer;
    }

    public void drawImage(MatrixStack ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
        ms.push();
        this.getMinecraft().getTextureManager().bindTexture(texture);
        ms.scale(scale / 512F, scale / 512F, scale / 512F);
        blit(ms, x, y, u, v, width, height, 512, 512);
        ms.pop();
    }

    @SuppressWarnings("unused")
	private void drawItemStack(MatrixStack ms, ItemStack stack, int x, int y, float scale) {
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        RenderSystem.pushMatrix();
        RenderSystem.translatef(cornerX, cornerY, 32.0F);
        float zLevel = 200.0F;
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        RenderSystem.scalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100;
        RenderSystem.depthMask(true);
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        zLevel = 0.0F;
        this.itemRenderer.zLevel = 0.0F;
        RenderSystem.popMatrix();
    }

    @SuppressWarnings("unused")
	protected void renderItemModelIntoGUI(MatrixStack ms, ItemStack stack, int x, int y, IBakedModel bakedmodel, float scale) {
        int i = (this.width - X) / 2;
        int j = (this.height - Y) / 2;
        RenderSystem.pushMatrix();
        this.getMinecraft().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
        this.getMinecraft().getTextureManager().getTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE).setBlurMipmapDirect(false, false);
        RenderSystem.enableRescaleNormal();
        RenderSystem.enableAlphaTest();
        RenderSystem.defaultAlphaFunc();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.scalef(16.0F * scale, 16.0F * scale, 16.0F * scale);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.translatef((float)x, (float)y , 100.0F + itemRenderer.zLevel);
        RenderSystem.scalef(1.0F, -1.0F, 1.0F);
        MatrixStack matrixstack = new MatrixStack();
        IRenderTypeBuffer.Impl irendertypebuffer$impl = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        boolean flag = !bakedmodel.isSideLit();
        if (flag) {
            RenderHelper.setupGuiFlatDiffuseLighting();
        }

        this.itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.GUI, false, matrixstack, irendertypebuffer$impl, 15728880, OverlayTexture.NO_OVERLAY, bakedmodel);
        irendertypebuffer$impl.finish();
        RenderSystem.enableDepthTest();
        if (flag) {
            RenderHelper.setupGui3DDiffuseLighting();
        }

        RenderSystem.disableAlphaTest();
        RenderSystem.disableRescaleNormal();
        RenderSystem.popMatrix();
    }


    @SuppressWarnings("unused")
	private void drawBlockStack(MatrixStack ms, ItemStack stack, int x, int y, float scale, int zScale) {
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        RenderSystem.pushMatrix();
        RenderSystem.translatef(cornerX, cornerY, 32.0F);
        float zLevel = 200.0F;
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        GL11.glScalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100 + zScale * 10;
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        zLevel = 0.0F;
        this.itemRenderer.zLevel = 0.0F;
        RenderSystem.popMatrix();

    }
}
	/**protected static final int X = 390;
    protected static final int Y = 245;
    private static final ResourceLocation TEXTURE = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/paleopedia.png");
    private static final ResourceLocation DRAWINGS_0 = new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/drawings_0.png");
    private static final Map<String, ResourceLocation> PICTURE_LOCATION_CACHE = Maps.newHashMap();
    public List<EnumPaleoPages> allPageTypes = new ArrayList<EnumPaleoPages>();
    public EnumPaleoPages pageType;
    public List<IndexPageButton> indexButtons = new ArrayList<IndexPageButton>();
    public ChangePageButton previousPage;
    public ChangePageButton nextPage;
    public int bookPages;
    public int bookPagesTotal = 1;
    public int indexPages;
    public int indexPagesTotal = 1;
    protected ItemStack book;
    protected boolean index;
    protected FontRenderer font = getFont();

    public GuiPaleo(ItemStack book) {
        super(new TranslationTextComponent("paleopedia_gui"));
        this.book = book;
        if (!book.isEmpty() && book.getItem() != null && book.getItem() == PFItems.PALEOPEDIA.get()) {
            if (book.getTag() != null) {
                List<EnumPaleoPages> pages = EnumPaleoPages.containedPages(EnumPaleoPages.toList(book.getTag().getIntArray("Pages")));
                allPageTypes.addAll(pages);
                indexPagesTotal = (int) Math.ceil(pages.size() / 10D);
            }
        }
        index = true;
    }

    @SuppressWarnings("resource")
	private FontRenderer getFont() {
        FontRenderer font;
        if (!Minecraft.getInstance().gameSettings.language.equalsIgnoreCase("en_us")) {
            font = Minecraft.getInstance().fontRenderer;
        } else {
            font = (FontRenderer) PrehistoricFauna.PROXY.getFontRenderer();
        }
        return font;
    }

    protected void init() {
        super.init();
        int centerX = (width - X) / 2;
        int centerY = (height - Y) / 2;
        this.addButton(this.previousPage = new ChangePageButton(centerX + 15, centerY + 215, false, bookPages, 0, (p_214132_1_) -> {
            if ((this.index ? this.indexPages > 0 : this.pageType != null)) {
                if (this.index) {
                    this.indexPages--;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                } else {
                    if (this.bookPages > 0) {
                        this.bookPages--;
                        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                    } else {
                        this.index = true;
                    }
                }
            }
        }));
        this.addButton(this.nextPage = new ChangePageButton(centerX + 357, centerY + 215, true, bookPages, 0, (p_214132_1_) -> {
            if ((this.index ? this.indexPages < this.indexPagesTotal - 1 : this.pageType != null && this.bookPages < this.pageType.pages)) {
                if (this.index) {
                    this.indexPages++;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                } else {
                    this.bookPages++;
                    Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                }
            }
        }));
        if (!allPageTypes.isEmpty()) {
            for (int i = 0; i < allPageTypes.size(); i++) {
                int xIndex = i % -2;
                int yIndex = i % 10;
                int id = 2 + i;
                IndexPageButton button = new IndexPageButton(id, centerX + 15 + (xIndex * 200), centerY + 10 + (yIndex * 20) - (xIndex == 1 ? 20 : 0), new TranslationTextComponent("paleopedia." + EnumPaleoPages.values()[allPageTypes.get(i).ordinal()].toString().toLowerCase()), (p_214132_1_) -> {
                    if (this.indexButtons.get(id - 2) != null && allPageTypes.get(id - 2) != null) {
                        Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.ITEM_BOOK_PAGE_TURN, 1.0F));
                        this.index = false;
                        this.bookPages = 0;
                        this.pageType = allPageTypes.get(id - 2);
                    }
                });
                this.indexButtons.add(button);
                this.addButton(button);
            }
        }
    }

    @Override
    public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        for (Widget button : this.buttons) {
            if (button instanceof IndexPageButton) {
                button.active = index;
                button.visible = index;
            }
        }
        for (int i = 0; i < this.indexButtons.size(); i++) {
            this.indexButtons.get(i).active = i < 10 * (this.indexPages + 1) && i >= 10 * (this.indexPages) && this.index;
        }
        this.renderBackground(ms);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        blit(ms, cornerX, cornerY, 0, 0, X, Y, 390, 390);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.render(ms, mouseX, mouseY, partialTicks);
        RenderHelper.enableStandardItemLighting();
        ms.push();
        ms.translate(cornerX, cornerY, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        int centerX = (width - X) / 2;
        int centerY = (height - Y) / 2;
        if (!index) {
            drawPerPage(ms, bookPages);
            int pageLeft = bookPages * 2 + 1;
            int pageRight = pageLeft + 1;
            font.drawString(ms, "" + pageLeft, centerX, centerY - (int) (Y * 0.13), 0X303030);
            font.drawString(ms, "" + pageRight, centerX, centerY - (int) (Y * 0.13), 0X303030);
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        ms.pop();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    public void drawPerPage(MatrixStack ms, int bookPages) {
        imageFromTxt(ms);
        writeFromTxt(ms);
    }

    @SuppressWarnings({ "rawtypes", "resource" })
	public void imageFromTxt(MatrixStack ms) {
        String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
        ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + Minecraft.getInstance().gameSettings.language + "_0/" + fileName);
        ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
        IResource resource = null;

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
            Iterator iterator = IOUtils.readLines(resource.getInputStream(), "UTF-8").iterator();
            String line = null;
            int zLevelAdd = 0;
            while (iterator.hasNext()) {
                line = ((String) iterator.next()).trim();
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
                        ms.push();
                        drawImage(ms, resourcelocation, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Float.parseFloat(split[7]) * 512F);
                        ms.pop();
                    }
                }
                if (line.contains("<item>")) {
                    line = line.substring(7, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawItemStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F);
                }
                if (line.contains("<block>")) {
                    zLevelAdd += 1;
                    line = line.substring(8, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawBlockStack(ms, new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F, zLevelAdd);
                }
                if (line.contains("<recipe>")) {
                    line = line.substring(9, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
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
                    RenderHelper.enableStandardItemLighting();
                    ms.push();
                    drawRecipe(ms, result, ingredients, x, y, scale);
                    ms.pop();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Item getItemByRegistryName(String registryName) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(registryName));
    }

    private void drawRecipe(MatrixStack ms, ItemStack result, ItemStack[] ingredients, int x, int y, float scale) {
        RenderSystem.pushMatrix();
        RenderSystem.translatef(x, y, 0);
        RenderSystem.scalef(scale, scale, 0);
        drawItemStack(ms, result, 62, 17, 2F);
        for (int i = 0; i < 9; i++) {
            drawItemStack(ms, ingredients[i], ((i % 3) * 22 + 30), ((i / 3) * 22 + 10), 1.25F);
        }
        RenderSystem.popMatrix();
        ms.push();
        ms.translate(x, y, 0);
        ms.scale(scale, scale, 0);
        ms.translate(37F, 13, 1F);
        ms.scale(1.5F, 1.5F, 1F);
        drawImage(ms, DRAWINGS_0, 0, 0, 389, 1, 50, 50, 512F);
        ms.pop();

    }

    @SuppressWarnings({ "rawtypes", "resource" })
	public void writeFromTxt(MatrixStack ms) {
        String fileName = this.pageType.toString().toLowerCase(Locale.ROOT) + "_" + this.bookPages + ".txt";
        ResourceLocation fileLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/" + Minecraft.getInstance().gameSettings.language + "_0/" + fileName);
        ResourceLocation backupLoc = new ResourceLocation("prehistoricfauna:lang/paleopedia/en_us_0/" + fileName);
        IResource resource = null;

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
            Iterator iterator = IOUtils.readLines(resource.getInputStream(), "UTF-8").iterator();
            String line = null;
            int linenumber = 0;
            while (iterator.hasNext()) {
                line = ((String) iterator.next()).trim();
                if (line.contains("<") || line.contains(">")) {
                    continue;
                }
                ms.push();
                if (usingVanillaFont()) {
                    ms.scale(0.945F, 0.945F, 0.945F);
                    ms.translate(0, 5.5F, 0);
                }
                if (linenumber <= 19) {
                    font.drawString(ms, line, 15, 20 + linenumber * 10, 0X303030);
                } else {
                    font.drawString(ms, line, 220, (linenumber - 19) * 10, 0X303030);
                }
                linenumber++;
                ms.pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ms.push();
        String s = StatCollector.translateToLocal("paleopedia." + this.pageType.toString().toLowerCase(Locale.ROOT));
        float scale = font.getStringWidth(s) <= 100 ? 2 : font.getStringWidth(s) * 0.0125F;
        ms.scale(scale, scale, scale);
        font.drawString(ms, s, 10, 2, 0X7A756A);
        ms.pop();
    }

    @SuppressWarnings("resource")
	private boolean usingVanillaFont() {
        return font == Minecraft.getInstance().fontRenderer;
    }

    public void drawImage(MatrixStack ms, ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
        ms.push();
        this.getMinecraft().getTextureManager().bindTexture(texture);
        ms.scale(scale / 512F, scale / 512F, scale / 512F);
        blit(ms, x, y, u, v, width, height, 512, 512);
        ms.pop();
    }

	private void drawItemStack(MatrixStack ms, ItemStack stack, int x, int y, float scale) {
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        RenderSystem.pushMatrix();
        RenderSystem.translatef(cornerX, cornerY, 32.0F);
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        RenderSystem.scalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100;
        RenderSystem.depthMask(true);
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        this.itemRenderer.zLevel = 0.0F;
        RenderSystem.popMatrix();
    }

    protected void renderItemModelIntoGUI(MatrixStack ms, ItemStack stack, int x, int y, IBakedModel bakedmodel, float scale) {
        RenderSystem.pushMatrix();
        this.getMinecraft().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
        this.getMinecraft().getTextureManager().getTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE).setBlurMipmapDirect(false, false);
        RenderSystem.enableRescaleNormal();
        RenderSystem.enableAlphaTest();
        RenderSystem.defaultAlphaFunc();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        RenderSystem.scalef(16.0F * scale, 16.0F * scale, 16.0F * scale);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.translatef((float)x, (float)y , 100.0F + itemRenderer.zLevel);
        RenderSystem.scalef(1.0F, -1.0F, 1.0F);
        MatrixStack matrixstack = new MatrixStack();
        IRenderTypeBuffer.Impl irendertypebuffer$impl = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
        boolean flag = !bakedmodel.isSideLit();
        if (flag) {
            RenderHelper.setupGuiFlatDiffuseLighting();
        }

        this.itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.GUI, false, matrixstack, irendertypebuffer$impl, 15728880, OverlayTexture.NO_OVERLAY, bakedmodel);
        irendertypebuffer$impl.finish();
        RenderSystem.enableDepthTest();
        if (flag) {
            RenderHelper.setupGui3DDiffuseLighting();
        }

        RenderSystem.disableAlphaTest();
        RenderSystem.disableRescaleNormal();
        RenderSystem.popMatrix();
    }


    private void drawBlockStack(MatrixStack ms, ItemStack stack, int x, int y, float scale, int zScale) {
        int cornerX = (width - X) / 2;
        int cornerY = (height - Y) / 2;
        RenderSystem.pushMatrix();
        RenderSystem.translatef(cornerX, cornerY, 32.0F);
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        GL11.glScalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100 + zScale * 10;
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        this.itemRenderer.zLevel = 0.0F;
        RenderSystem.popMatrix();

    }
}*/