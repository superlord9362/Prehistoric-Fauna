package superlord.prehistoricfauna.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.widget.button.Button.IPressable;

@OnlyIn(Dist.CLIENT)
public class ChangePageButton extends Button {

	private final boolean right;
	public int lastpage = 1;
	private int color;
	
	public ChangePageButton(int x, int y, boolean right, int bookpage, int color, IPressable press) {
		super(x, y, 23, 10, "", press);
		this.right = right;
		this.color = color;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partial) {
		if (this.visible) {
			boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("prehistoricfauna:textures/gui/paleopedia/widgets.png"));
			int i = 0;
			int j = 64;
			if (flag) {
				i += 23;
			}
			if (!this.right) {
				j += 13;
			}
			j += color * 23;
			int k = (int) (this.x / 0.98F);
			this.blit(k - 1, this.y, i, j, width, height);
		}
	}
	
}
