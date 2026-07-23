package superlord.prehistoricfauna.client.render.layer;

public class KayentasuchusEyeLayer {
//	extends RenderLayer<Kayentasuchus, KayentasuchusModel> {
//}
//	
//	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/kayentasuchus/kayentasuchus_eyeglow.png"));
//	private final RenderLayerParent<Kayentasuchus, KayentasuchusModel> kayentasuchusRenderer;
//	
//	public KayentasuchusEyeLayer(RenderLayerParent<Kayentasuchus, KayentasuchusModel> rendererIn) {
//		super(rendererIn);
//		this.kayentasuchusRenderer = rendererIn;
//	}
//	
//	@Override
//	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Kayentasuchus kayentasuchus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
//		if (!(kayentasuchusRenderer.getModel() instanceof KayentasuchusModel)) {
//			return;
//		}
//		long roundTime = kayentasuchus.level().getDayTime() % 24000;
//		boolean night = roundTime >= 13000 && roundTime <= 22000;
//		BlockPos kayentasuchusPos = kayentasuchus.blockPosition();
//		int i = kayentasuchus.level().getBrightness(LightLayer.SKY, kayentasuchusPos);
//		int j = kayentasuchus.level().getBrightness(LightLayer.BLOCK, kayentasuchusPos);
//		int brightness;
//		if (night) {
//			brightness = j;
//		} else {
//			brightness = Math.max(i, j);
//		}
//		if (brightness < 7) {
//			RenderType tex = null;
//			if (kayentasuchus.isAsleep() || kayentasuchus.tickCount % 50 >= 0 && kayentasuchus.tickCount % 50 <= 5) {
//				tex = null;
//			} else tex = TEXTURE;
//	        if(tex != null){
//	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
//	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
//	        }
//		}
//	}
	
}
