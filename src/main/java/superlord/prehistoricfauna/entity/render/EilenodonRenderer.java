package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.EilenodonEntity;
import superlord.prehistoricfauna.entity.model.Eilenodon;
import superlord.prehistoricfauna.entity.model.EilenodonBasking;

public class EilenodonRenderer extends MobRenderer<EilenodonEntity, EntityModel<EilenodonEntity>> {

    private static final ResourceLocation EILENODON = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/eilenodon.png");
    private final static Eilenodon EILENODON_MODEL = new Eilenodon();
    private final static EilenodonBasking EILENODON_BASKING = new EilenodonBasking();
    
    public EilenodonRenderer() {
        super(Minecraft.getInstance().getRenderManager(), EILENODON_MODEL, 0.25F);
    }
    
    public void render(EilenodonEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
    	if (entityIn.isSitting()) {
    		entityModel = EILENODON_BASKING;
    	} else {
    		entityModel = EILENODON_MODEL;
    	}
    	super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    
    protected void preRenderCallback(EilenodonEntity eilenodon, MatrixStack matrixStackIn, float partialTickTime) {
    	if(eilenodon.isChild()) {
    		  matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    	}
    }

    @Override
	public ResourceLocation getEntityTexture(EilenodonEntity entity) {
    	return EILENODON;
    }
}