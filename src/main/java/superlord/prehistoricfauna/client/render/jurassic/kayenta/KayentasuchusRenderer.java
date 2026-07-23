package superlord.prehistoricfauna.client.render.jurassic.kayenta;


public class KayentasuchusRenderer {
//	extends MobRenderer<Kayentasuchus, KayentasuchusModel> {
//		
//	
//	private static final ResourceLocation KAYENTASUCHUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/kayentasuchus.png");
//	private static final ResourceLocation ALBINO = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/albino.png");
//	private static final ResourceLocation MELANISTIC = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/melanistic.png");
//	private static final ResourceLocation KAYENTASUCHUS_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/kayentasuchus_sleeping.png");
//	private static final ResourceLocation ALBINO_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/albino_sleeping.png");
//	private static final ResourceLocation MELANISTIC_SLEEPING = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/melanistic_sleeping.png");
//
//	public KayentasuchusRenderer(EntityRendererProvider.Context renderManagerIn) {
//		super(renderManagerIn, new KayentasuchusModel(renderManagerIn.bakeLayer(ClientEvents.KAYENTASUCHUS)), 0.5F);
//		if (PrehistoricFaunaConfig.eyeShine) {
//			this.addLayer(new KayentasuchusEyeLayer(this));
//		}
//	}
//
//	protected void scale(Kayentasuchus thescelosaurus, PoseStack matrixStackIn, float partialTickTime) {
//		if(thescelosaurus.isBaby()) {
//			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
//		}
//		super.scale(thescelosaurus, matrixStackIn, partialTickTime);
//	}
//
//	@Override
//	public ResourceLocation getTextureLocation(Kayentasuchus entity) {
//		if(entity.isAlbino()) {
//			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//				return ALBINO_SLEEPING;
//			} else return ALBINO;
//		} else if (entity.isMelanistic()) {
//			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//				return MELANISTIC_SLEEPING;
//			} else return MELANISTIC;
//		} else {
//			if (entity.isAsleep() || entity.tickCount % 50 >= 0 && entity.tickCount % 50 <= 5) {
//				return KAYENTASUCHUS_SLEEPING;
//			} else return KAYENTASUCHUS;
//		}
//	}
}
