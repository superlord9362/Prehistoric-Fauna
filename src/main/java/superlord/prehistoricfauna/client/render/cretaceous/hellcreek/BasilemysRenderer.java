package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.BasilemysModel;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;

public class BasilemysRenderer extends MobRenderer<Basilemys, BasilemysModel> {
	private static final ResourceLocation BASILEMYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/basilemys.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/melanistic.png");
	private static final ResourceLocation BASILEMYS_SHELL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/basilemys_shell.png");
	private static final ResourceLocation ALBINO_SHELL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/albino_shell.png");
	private static final ResourceLocation MELANISTIC_SHELL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/melanistic_shell.png");

	public BasilemysRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BasilemysModel(renderManagerIn.bakeLayer(ClientEvents.BASILEMYS)), 0.75F);
	}

	protected void scale(Basilemys thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
		if(thescelosaurus.isBaby()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
	}

	@Override
	public ResourceLocation getTextureLocation(Basilemys entity) {
		if (entity.isPanicing() || entity.isAsleep()) {
			if (entity.isAlbino()) {
				return ALBINO_SHELL;
			} else if (entity.isMelanistic()) {
				return MELANISTIC_SHELL;
			} else {
				return BASILEMYS_SHELL;
			}
		} else {
			if (entity.isAlbino()) {
				return ALBINO;
			} else if (entity.isMelanistic()) {
				return MELANISTIC;
			} else {
				return BASILEMYS;
			}
		}
	}
}
