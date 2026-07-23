package superlord.prehistoricfauna.client.render.cretaceous.hellcreek;

public class ThoracosaurusRenderer {
//	extends MobRenderer<Thoracosaurus, ThoracosaurusModel> {
//}
//	private static final ResourceLocation THORACOSAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/thoracosaurus/thoracosaurus.png");
//	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/thoracosaurus/albino.png");
//	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/thoracosaurus/melanistic.png");
//	private static final ResourceLocation THORACOSAURUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/thoracosaurus/thoracosaurus_sleeping.png");
//	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/thoracosaurus/albino_sleeping.png");
//	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/thoracosaurus/melanistic_sleeping.png");
//
//	public ThoracosaurusRenderer(EntityRendererProvider.Context renderManagerIn) {
//		super(renderManagerIn, new ThoracosaurusModel(renderManagerIn.bakeLayer(ClientEvents.THORACOSAURUS)), 0.25F);
//		if (PrehistoricFaunaConfig.eyeShine) {
//			this.addLayer(new ThoracosaurusEyeLayer(this));
//		}
//	}
//
//	protected void scale(Thoracosaurus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
//		if(thescelosaurus.isBaby()) {
//			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
//		}
//		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
//	}
//
//	@Override
//	public ResourceLocation getTextureLocation(Thoracosaurus entity) {
//		if (entity.isMelanistic()) {
//			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//				return MELANISTIC_SLEEPING;
//			} else return MELANISTIC;
//		} else if (entity.isAlbino()) {
//			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//				return ALBINO_SLEEPING;
//			} else return ALBINO;
//		} else {
//			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//				return THORACOSAURUS_SLEEPING;
//			} else return THORACOSAURUS;
//		}
//	}
}
