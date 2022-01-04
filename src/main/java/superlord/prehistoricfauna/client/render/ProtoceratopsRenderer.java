package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.ProtoceratopsModel;
import superlord.prehistoricfauna.common.entities.ProtoceratopsEntity;

public class ProtoceratopsRenderer extends MobRenderer<ProtoceratopsEntity, ProtoceratopsModel> {

	private static final ResourceLocation PROTOCERATOPS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops.png");
	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/albino.png");
	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/melanistic.png");

	public ProtoceratopsRenderer(EntityRendererManager rm) {
		super(rm, new ProtoceratopsModel(), 0.25F);
	}

	protected void preRenderCallback(ProtoceratopsEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public ResourceLocation getEntityTexture(ProtoceratopsEntity entity) {
		if (entity.isAlbino()) {
			return ALBINO;
		} else if (entity.isMelanistic()) {
			return MELANISTIC;
		} else {
			return PROTOCERATOPS;
		}
	}

}
