package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TriceratopsEntity;
import superlord.prehistoricfauna.entity.model.Triceratops;
import superlord.prehistoricfauna.entity.model.TriceratopsJuvenile;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> {
	
	private static final ResourceLocation TRICERATOPS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/triceratops.png");
	private static final ResourceLocation BABY_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/triceratops_juvenile.png");
	private static final ResourceLocation SADDLED = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/triceratops_saddled.png");
	private static final ResourceLocation CHESTED = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/triceratops_chested.png");
	private static final ResourceLocation SADDLED_CHESTED = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/triceratops_saddled_chested.png");
	private static final Triceratops TRICERATOPS_MODEL = new Triceratops();
	private static final TriceratopsJuvenile BABY_TRICERATOPS_MODEL = new TriceratopsJuvenile();
	
	public TriceratopsRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TRICERATOPS_MODEL, 0.5F);
	}
	
	public void render(TriceratopsEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isChild()) {
			entityModel = BABY_TRICERATOPS_MODEL;
		} else {
			entityModel = TRICERATOPS_MODEL;
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallback(TriceratopsEntity triceratops, MatrixStack matrixStackIn, float partialTickTime) {
		if(triceratops.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(TriceratopsEntity entity) {
		if(entity.isChild()) {
			return BABY_TRICERATOPS;
		} else if(entity.isHorseSaddled() && !entity.hasChest()) {
			return SADDLED;
		} else if(entity.hasChest() && !entity.isHorseSaddled()) {
			return CHESTED;
		} else if(entity.hasChest() && entity.isHorseSaddled()) {
			return SADDLED_CHESTED;
		} else {
	        return TRICERATOPS;
		}
	}

}
