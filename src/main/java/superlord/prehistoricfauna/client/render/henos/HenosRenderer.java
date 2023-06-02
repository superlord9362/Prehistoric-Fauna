package superlord.prehistoricfauna.client.render.henos;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ClientEvents;
import superlord.prehistoricfauna.client.model.henos.HenosModel;
import superlord.prehistoricfauna.client.model.henos.HenosSummonedModel;
import superlord.prehistoricfauna.client.render.layer.HenosGemGlowLayer;
import superlord.prehistoricfauna.common.entity.henos.Henos;
import superlord.prehistoricfauna.init.PFRenderTypes;

@OnlyIn(Dist.CLIENT)
public class HenosRenderer extends MobRenderer<Henos, EntityModel<Henos>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/henos.png");
	private static final ResourceLocation SUMMONED_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/henos_summoned.png");
	private static final ResourceLocation FUNKY_MONKEY = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/brass_monkey.png");
	private static final ResourceLocation TEXTURE_LIT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/henos_lit.png");
	private static final ResourceLocation SUMMONED_TEXTURE_LIT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/henos_summoned_lit.png");
	private static final ResourceLocation FUNKY_MONKEY_LIT = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/brass_monkey_lit.png");
	private static HenosModel HENOS;
	private static HenosModel HENOS_HEALING;
	private static HenosSummonedModel SUMMONED;
	private static HenosSummonedModel SUMMONED_HEALING;

	private static final ResourceLocation BEAM_TEXTURE = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/henos/beam.png");
	private static final RenderType BEAM_RENDER_TYPE = PFRenderTypes.getBossBeam(BEAM_TEXTURE);

	public HenosRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new HenosModel(renderManagerIn.bakeLayer(ClientEvents.HENOS), 0.0F), 1.25F);
		this.addLayer(new HenosGemGlowLayer(this));
		this.addLayer(new HealingLayer(this));
		HENOS = new HenosModel(renderManagerIn.bakeLayer(ClientEvents.HENOS), 0);
		HENOS_HEALING = new HenosModel(renderManagerIn.bakeLayer(ClientEvents.HENOS), 0.5F);
		SUMMONED = new HenosSummonedModel(renderManagerIn.bakeLayer(ClientEvents.SUMMONED_HENOS), 0);
		SUMMONED_HEALING = new HenosSummonedModel(renderManagerIn.bakeLayer(ClientEvents.SUMMONED_HENOS), 0.5F);
	}

	public boolean shouldRender(Henos p_114836_, Frustum p_114837_, double p_114838_, double p_114839_, double p_114840_) {
		if (super.shouldRender(p_114836_, p_114837_, p_114838_, p_114839_, p_114840_)) {
			return true;
		} else {
			if (p_114836_.hasLaserTarget()) {
				LivingEntity livingentity = p_114836_.getLaserTarget();
				if (livingentity != null) {
					Vec3 vec3 = this.getPosition(livingentity, (double)livingentity.getBbHeight() * 0.5D, 1.0F);
					Vec3 vec31 = this.getPosition(p_114836_, (double)p_114836_.getEyeHeight(), 1.0F);
					return p_114837_.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
				}
			}

			return false;
		}
	}

	private Vec3 getPosition(LivingEntity p_114803_, double p_114804_, float p_114805_) {
		double d0 = Mth.lerp((double)p_114805_, p_114803_.xOld, p_114803_.getX());
		double d1 = Mth.lerp((double)p_114805_, p_114803_.yOld, p_114803_.getY()) + p_114804_;
		double d2 = Mth.lerp((double)p_114805_, p_114803_.zOld, p_114803_.getZ());
		return new Vec3(d0, d1, d2);
	}

	protected void setupRotations(Henos entityIn, PoseStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.setupRotations(entityIn, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		Vec3 vec = entityIn.getLaserTargetPos(partialTicks);
		double d0 = vec.x - entityIn.getX();
		double d2 = vec.z - entityIn.getZ();
		float f1 = Mth.wrapDegrees(180.0F - rotationYaw);
		float f2 = Mth.wrapDegrees((float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) + 90.0F);
		float f3 = entityIn.getLaserTargetProgress(partialTicks);
		matrixStackIn.mulPose(Vector3f.YN.rotationDegrees(f1 * f3));
		matrixStackIn.mulPose(Vector3f.YN.rotationDegrees(f2 * f3));
	}

	public void render(Henos entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		Entity livingentity = entityIn.getLaserTarget();
		if (livingentity != null) {
			float f1 = (float) entityIn.level.getGameTime() + partialTicks;
			float f2 = f1 * -0.2F % 1.0F;
			float f3 = entityIn.getBbHeight() * 0.625F;
			matrixStackIn.pushPose();
			matrixStackIn.translate(0.0D, f3, 0.0D);
			Vec3 vector3d = entityIn.getLaserTargetPos(partialTicks);
			Vec3 vector3d1 = this.getPosition(entityIn, f3, partialTicks);
			Vec3 vector3d2 = vector3d.subtract(vector3d1);
			float f4 = (float) (vector3d2.length());
			vector3d2 = vector3d2.normalize();
			float f5 = (float) Math.acos(vector3d2.y);
			float f6 = (float) Math.atan2(vector3d2.z, vector3d2.x);
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees((((float) Math.PI / 2F) - f6) * (180F / (float) Math.PI)));
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(f5 * (180F / (float) Math.PI)));
			float f8 = 1F;
			int j = (int) (f8 * 255.0F);
			int k = (int) (f8 * 255.0F);
			int l = (int) (f8 * 255.0F);
			float width = (100 - (100 - Mth.clamp(entityIn.getLaserTick(), 5, 100))) * 0.01F;
			float f11 = Mth.cos(0 + 2.3561945F) * 0.8F;
			float f12 = Mth.sin(0 + 2.3561945F) * 0.8F;
			float f13 = Mth.cos(0 + ((float) Math.PI / 4F)) * 0.8F;
			float f14 = Mth.sin(0 + ((float) Math.PI / 4F)) * 0.8F;
			float f15 = Mth.cos(0 + 3.926991F) * 0.8F;
			float f16 = Mth.sin(0 + 3.926991F) * 0.8F;
			float f17 = Mth.cos(0 + 5.4977875F) * 0.8F;
			float f18 = Mth.sin(0 + 5.4977875F) * 0.8F;
			float f19 = Mth.cos(0 + (float) Math.PI) * width;
			float f20 = Mth.sin(0 + (float) Math.PI) * width;
			float f21 = Mth.cos(0 + 0.0F) * width;
			float f22 = Mth.sin(0 + 0.0F) * width;
			float f23 = Mth.cos(0 + ((float) Math.PI / 2F)) * width;
			float f24 = Mth.sin(0 + ((float) Math.PI / 2F)) * width;
			float f25 = Mth.cos(0 + ((float) Math.PI * 1.5F)) * width;
			float f26 = Mth.sin(0 + ((float) Math.PI * 1.5F)) * width;
			float f29 = -1.0F + f2;
			float f30 = f4 * 0.5F + f29;
			VertexConsumer ivertexbuilder = bufferIn.getBuffer(BEAM_RENDER_TYPE);
			PoseStack.Pose matrixstack$entry = matrixStackIn.last();
			Matrix4f matrix4f = matrixstack$entry.pose();
			Matrix3f matrix3f = matrixstack$entry.normal();
			vertex(ivertexbuilder, matrix4f, matrix3f, f19, f4, f20, j, k, l, 0.4999F, f30);
			vertex(ivertexbuilder, matrix4f, matrix3f, f19, 0.0F, f20, j, k, l, 0.4999F, f29);
			vertex(ivertexbuilder, matrix4f, matrix3f, f21, 0.0F, f22, j, k, l, 0.0F, f29);
			vertex(ivertexbuilder, matrix4f, matrix3f, f21, f4, f22, j, k, l, 0.0F, f30);
			vertex(ivertexbuilder, matrix4f, matrix3f, f23, f4, f24, j, k, l, 0.4999F, f30);
			vertex(ivertexbuilder, matrix4f, matrix3f, f23, 0.0F, f24, j, k, l, 0.4999F, f29);
			vertex(ivertexbuilder, matrix4f, matrix3f, f25, 0.0F, f26, j, k, l, 0.0F, f29);
			vertex(ivertexbuilder, matrix4f, matrix3f, f25, f4, f26, j, k, l, 0.0F, f30);

			float f31 = 0.0F;
			if (entityIn.tickCount % 2 == 0) {
				f31 = 0.5F;
			}

			vertex(ivertexbuilder, matrix4f, matrix3f, f11, f4, f12, j, k, l, 0.5F, f31 + 0.5F);
			vertex(ivertexbuilder, matrix4f, matrix3f, f13, f4, f14, j, k, l, 1.0F, f31 + 0.5F);
			vertex(ivertexbuilder, matrix4f, matrix3f, f17, f4, f18, j, k, l, 1.0F, f31);
			vertex(ivertexbuilder, matrix4f, matrix3f, f15, f4, f16, j, k, l, 0.5F, f31);
			matrixStackIn.popPose();
		}
	}

	private static void vertex(VertexConsumer p_114842_, Matrix4f p_114843_, Matrix3f p_114844_, float p_114845_, float p_114846_, float p_114847_, int p_114848_, int p_114849_, int p_114850_, float p_114851_, float p_114852_) {
		p_114842_.vertex(p_114843_, p_114845_, p_114846_, p_114847_).color(p_114848_, p_114849_, p_114850_, 255).uv(p_114851_, p_114852_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(240).normal(p_114844_, 0.0F, 1.0F, 0.0F).endVertex();
	}

	protected void scale(Henos entityIn, PoseStack matrixStackIn, float partialTickTime) {
		if (entityIn.isSummoned()) {
			model = SUMMONED;
		} else {
			model = HENOS;
		}
		super.scale(entityIn, matrixStackIn, partialTickTime);
	}

	class HealingLayer extends RenderLayer<Henos, EntityModel<Henos>>{

		public HealingLayer(RenderLayerParent<Henos, EntityModel<Henos>> entityRendererIn) {
			super(entityRendererIn);
		}

		@Override
		public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Henos entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			if(entitylivingbaseIn.hasHealingShield()){
				EntityModel<Henos> model = entitylivingbaseIn.isSummoned() ? SUMMONED_HEALING : HENOS_HEALING;
				VertexConsumer vertexBuilder = bufferIn.getBuffer(PFRenderTypes.getBossGlint());
				model.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(matrixStackIn, vertexBuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, entitylivingbaseIn.getShieldThickness());
			}
		}
	}

	@Override
	public ResourceLocation getTextureLocation(Henos entity) {
		String s = ChatFormatting.stripFormatting(entity.getName().getString());
		if (!entity.isSummoned() && s != null && "Brass Monkey".equals(s)) {
			if (entity.getLaserTick() > 0) {
				return FUNKY_MONKEY_LIT;
			} else {
				return FUNKY_MONKEY;
			}
		}
		if (entity.isSummoned()) {
			if (entity.getLaserTick() > 0) {
				return SUMMONED_TEXTURE_LIT;
			} else {
				return SUMMONED_TEXTURE;
			}
		} else {
			if (entity.getLaserTick() > 0) {
				return TEXTURE_LIT;
			} else {
				return TEXTURE;
			}
		}
	}
}