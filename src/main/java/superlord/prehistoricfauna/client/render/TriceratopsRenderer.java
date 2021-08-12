package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Triceratops;
import superlord.prehistoricfauna.client.model.TriceratopsJuvenile;
import superlord.prehistoricfauna.common.entities.TriceratopsEntity;

public class TriceratopsRenderer extends MobRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> {
	
	private static final ResourceLocation TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops.png");
	private static final ResourceLocation BABY_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_baby.png");
	private static final ResourceLocation JUVENILE_TRICERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_juvenile.png");
	private static final ResourceLocation SADDLED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_saddled.png");
	private static final ResourceLocation CHESTED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_chested.png");
	private static final ResourceLocation SADDLED_CHESTED = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_saddled_chested.png");
	
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino.png");
	private static final ResourceLocation BABY_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_juv.png");
	private static final ResourceLocation SADDLED_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_saddled.png");
	private static final ResourceLocation CHESTED_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_chested.png");
	private static final ResourceLocation SADDLED_CHESTED_ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/albino_saddled_chested.png");
	
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic.png");
	private static final ResourceLocation BABY_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_juv.png");
	private static final ResourceLocation SADDLED_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_saddled.png");
	private static final ResourceLocation CHESTED_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_chested.png");
	private static final ResourceLocation SADDLED_CHESTED_MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/melanistic_saddled_chested.png");
	
	private static final Triceratops TRICERATOPS_MODEL = new Triceratops();
	private static final TriceratopsJuvenile BABY_TRICERATOPS_MODEL = new TriceratopsJuvenile();
	
	public TriceratopsRenderer() {
		super(Minecraft.getInstance().getRenderManager(), TRICERATOPS_MODEL, 2F);
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
		if(triceratops.isChild() && !triceratops.isJuvenile()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(TriceratopsEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isChild()) {
				return BABY_ALBINO;
			} else if (entity.hasChest() && !entity.isHorseSaddled()) {
				return CHESTED_ALBINO;
			} else if (entity.isHorseSaddled() && !entity.hasChest()) {
				return SADDLED_ALBINO;
			} else if (entity.isHorseSaddled() && entity.hasChest()) {
				return SADDLED_CHESTED_ALBINO;
			} else {
				return ALBINO;
			}
		} else if (entity.isMelanistic()) {
			if (entity.isChild()) {
				return BABY_MELANISTIC;
			} else if (entity.hasChest() && !entity.isHorseSaddled()) {
				return CHESTED_MELANISTIC;
			} else if (entity.isHorseSaddled() && !entity.hasChest()) {
				return SADDLED_MELANISTIC;
			} else if (entity.isHorseSaddled() && entity.hasChest()) {
				return SADDLED_CHESTED_MELANISTIC;
			} else {
				return MELANISTIC;
			}
		}
		if(entity.isChild() && !entity.isJuvenile()) {
			return BABY_TRICERATOPS;
		} else if (entity.isJuvenile()) {
			return JUVENILE_TRICERATOPS;
		}else if(entity.isHorseSaddled() && !entity.hasChest()) {
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
