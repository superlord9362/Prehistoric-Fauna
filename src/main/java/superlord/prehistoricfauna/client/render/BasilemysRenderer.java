package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.BasilemysModel;
import superlord.prehistoricfauna.client.model.BasilemysHidingModel;
import superlord.prehistoricfauna.common.entities.BasilemysEntity;

public class BasilemysRenderer extends MobRenderer<BasilemysEntity,  EntityModel<BasilemysEntity>> {

	private static final ResourceLocation BASILEMYS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/basilemys.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/basilemys/melanistic.png");
	private static final BasilemysModel BASILEMYS_MODEL = new BasilemysModel();
	private static final BasilemysHidingModel BASILEMYS_HIDING_MODEL = new BasilemysHidingModel();
	
	public BasilemysRenderer() {
		super(Minecraft.getInstance().getRenderManager(), BASILEMYS_MODEL, 0.75F);
	}
	
	public void render(BasilemysEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
    	if (entityIn.isPanicing()) {
    		entityModel = BASILEMYS_HIDING_MODEL;
    	} else {
            entityModel = BASILEMYS_MODEL;
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	
	 protected void preRenderCallback(BasilemysEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		 if(entity.isChild()) {
			 matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		 }
	 }
	
	@Override
	public ResourceLocation getEntityTexture(BasilemysEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return BASILEMYS;
		}
	}
	
}
