package superlord.prehistoricfauna.client.render.cretaceous.djadochta;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsSleepingModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;

public class ProtoceratopsRenderer extends MobRenderer<ProtoceratopsEntity, EntityModel<ProtoceratopsEntity>> {

	private static final ResourceLocation PROTOCERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic.png");
	private static final ResourceLocation PROTOCERATOPS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops_sleeping.png");
	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino_sleeping.png");
	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic_sleeping.png");
	private static final ProtoceratopsModel PROTOCERATOPS_MODEL = new ProtoceratopsModel();
	private static final ProtoceratopsSleepingModel PROTOCERATOPS_SLEEPING_MODEL = new ProtoceratopsSleepingModel();

	public ProtoceratopsRenderer(EntityRendererManager rm) {
		super(rm, PROTOCERATOPS_MODEL, 0.25F);
	}

	protected void preRenderCallback(ProtoceratopsEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	public void render(ProtoceratopsEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		if (entityIn.isAsleep()) {
			entityModel = PROTOCERATOPS_SLEEPING_MODEL;
		} else {
			entityModel = PROTOCERATOPS_MODEL;
		}
    	super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

	@Override
	public ResourceLocation getEntityTexture(ProtoceratopsEntity entity) {
		if (entity.isAlbino()) {
			if (entity.isAsleep()) {
				return ALBINO_SLEEPING;
			} else return ALBINO;
		} else if (entity.isMelanistic()) {
			if (entity.isAsleep()) {
				return MELANISTIC_SLEEPING;
			} else return MELANISTIC;
		} else {
			if (entity.isAsleep()) {
				return PROTOCERATOPS_SLEEPING;
			} else return PROTOCERATOPS;
		}
	}

}
