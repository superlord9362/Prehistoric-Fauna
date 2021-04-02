package superlord.prehistoricfauna.gui;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.util.EnumPaleoPages;
import superlord.prehistoricfauna.util.StatCollector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
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
        if (!book.isEmpty() && book.getItem() != null && book.getItem() == ItemInit.PALEOPEDIA.get()) {
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
        font = Minecraft.getInstance().fontRenderer;
        return font;
    }

    public void init() {
        super.init();
        int centerX = (this.width - X) / 2;
        int centerY = (this.height - Y) / 2;
        this.addButton(this.previousPage = new ChangePageButton(centerX + 29, centerY + 215, false, bookPages, 0, (p_214132_1_) -> {
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
        this.addButton(this.nextPage = new ChangePageButton(centerX + 328, centerY + 215, true, bookPages, 0, (p_214132_1_) -> {
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
                IndexPageButton button = new IndexPageButton(id, centerX + 15 + (xIndex * 200), centerY + 10 + (yIndex * 20) - (xIndex == 1 ? 20 : 0), StatCollector.translateToLocal("paleopedia." + EnumPaleoPages.values()[allPageTypes.get(i).ordinal()].toString().toLowerCase()), (p_214132_1_) -> {
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
    public void render(int mouseX, int mouseY, float partialTicks) {
        for (Widget button : this.buttons) {
            if (button instanceof IndexPageButton) {
                button.active = index;
                button.visible = index;
            }
        }
        for (int i = 0; i < this.indexButtons.size(); i++) {
            this.indexButtons.get(i).visible = i < 10 * (this.indexPages + 1) && i >= 10 * (this.indexPages) && this.index;
        }
        this.renderBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int cornerX = (this.width - X) / 2;
        int cornerY = (this.height - Y) / 2;
        blit(cornerX, cornerY, 0, 0, X, Y, 390, 390);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.render(mouseX, mouseY, partialTicks);
        RenderHelper.enableStandardItemLighting();
        GL11.glPushMatrix();
        GL11.glTranslatef(cornerX, cornerY, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        if (!index) {
            drawPerPage(bookPages);
            int pageLeft = bookPages * 2 + 1;
            int pageRight = pageLeft + 1;
            font.drawString("" + pageLeft, X / 2.3F, Y - (int) (Y * 0.13), 0X303030);
            font.drawString("" + pageRight, X - (int) (X * 0.45), Y - (int) (Y * 0.13), 0X303030);
        }
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public void drawPerPage(int bookPages) {
        imageFromTxt();
        writeFromTxt();
    }

    @SuppressWarnings({ "unused", "rawtypes", "resource" })
	public void imageFromTxt() {
        String fileName = this.pageType.toString().toLowerCase() + "_" + this.bookPages + ".txt";
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
                        GL11.glPushMatrix();
                        drawImage(resourcelocation, Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Float.parseFloat(split[7]) * 512F);
                        GL11.glPopMatrix();
                    }
                }
                if (line.contains("<item>")) {
                    line = line.substring(7, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawItemStack(new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F);
                }
                if (line.contains("<block>")) {
                    zLevelAdd += 1;
                    line = line.substring(8, line.length() - 1);
                    String[] split = line.split(" ");
                    RenderHelper.enableStandardItemLighting();
                    drawBlockStack(new ItemStack(getItemByRegistryName(split[0]), 1), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]) * 2F, zLevelAdd);
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
                    GL11.glPushMatrix();
                    GL11.glTranslatef(x, y, 0);
                    GL11.glScalef(scale, scale, 0);
                    drawRecipe(result, ingredients);
                    GL11.glPopMatrix();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Item getItemByRegistryName(String registryName) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(registryName));
    }

    private void drawRecipe(ItemStack result, ItemStack[] ingredients) {
        drawItemStack(result, 62, 17, 2F);
        for (int i = 0; i < 9; i++) {
            drawItemStack(ingredients[i], ((i % 3) * 22 + 30), ((i / 3) * 22 + 10), 1.25F);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef(37F, 13, 1F);
        GL11.glScalef(1.5F, 1.5F, 1F);
        drawImage(DRAWINGS_0, 0, 0, 389, 1, 50, 50, 512F);
        GL11.glPopMatrix();

    }

    @SuppressWarnings({ "rawtypes", "resource" })
	public void writeFromTxt() {
        String fileName = this.pageType.toString().toLowerCase() + "_" + this.bookPages + ".txt";
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
                GL11.glPushMatrix();
                if (usingVanillaFont()) {
                    GL11.glScalef(0.945F, 0.945F, 0.945F);
                    GL11.glTranslatef(0, 5.5F, 0);
                }
                if (linenumber <= 19) {
                    font.drawString(line, 20, 20 + linenumber * 10, 0X303030);
                } else {
                    font.drawString(line, 220, (linenumber - 19) * 10, 0X303030);
                }
                linenumber++;
                GL11.glPopMatrix();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GL11.glPushMatrix();
        String s = StatCollector.translateToLocal("paleopedia." + this.pageType.toString().toLowerCase());
        float scale = font.getStringWidth(s) <= 85 ? 2 : font.getStringWidth(s) * 0.019F;
        float scale2 = font.getStringWidth(s) <= 95 ? scale : font.getStringWidth(s) * 0.015F;
        GL11.glScalef(scale2, scale2, scale2);
        font.drawString(s, 15, 5, 0X303030);
        GL11.glPopMatrix();
    }

    @SuppressWarnings("resource")
	private boolean usingVanillaFont() {
        return font == Minecraft.getInstance().fontRenderer;
    }

    public void drawImage(ResourceLocation texture, int x, int y, int u, int v, int width, int height, float scale) {
        RenderSystem.pushMatrix();
        this.minecraft.getTextureManager().bindTexture(texture);
        RenderSystem.scalef(scale / 512F, scale / 512F, scale / 512F);
        blit(x, y, u, v, width, height, 512, 512);
        RenderSystem.popMatrix();
    }

    @SuppressWarnings({ "deprecation", "unused" })
	private void drawItemStack(ItemStack stack, int x, int y, float scale) {
        GL11.glPushMatrix();
        GlStateManager.translatef(0, 0, 32.0F);
        float zLevel = 200.0F;
        this.itemRenderer.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = null;
        if (!stack.isEmpty()) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = getFont();
        GL11.glScalef(scale, scale, scale);
        this.itemRenderer.zLevel = -100;
        this.itemRenderer.renderItemAndEffectIntoGUI(stack, x, y);
        zLevel = 0.0F;
        this.itemRenderer.zLevel = 0.0F;
        GL11.glPopMatrix();
    }

    @SuppressWarnings({ "deprecation", "unused" })
	private void drawBlockStack(ItemStack stack, int x, int y, float scale, int zScale) {
        GL11.glPushMatrix();
        GlStateManager.translatef(0, 0, 32.0F);
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
        GL11.glPopMatrix();
    }
}