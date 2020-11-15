package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix3f;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.TimeGuardianEntity;
import superlord.prehistoricfauna.entity.model.BossModel;

@OnlyIn(Dist.CLIENT)
public class BossRenderer extends MobRenderer<TimeGuardianEntity, BossModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/didelphodon.png");
	private static final ResourceLocation BEAM_TEXTURE = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/beam.png");
	private static final RenderType field_229107_h_ = RenderType.getEntityCutoutNoCull(BEAM_TEXTURE);

	public BossRenderer(EntityRendererManager rm) {
		super(rm, new BossModel(), 1.0F);
	}

	public void render(TimeGuardianEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		double rot = this.interpolateValue(entityIn.prevRenderYawOffset, entityIn.renderYawOffset, partialTicks) * 0.01745329238474369D + (Math.PI / 2D);
		double xMod = Math.cos(rot) * (double) (entityIn.getWidth() + 1f);
		double zMod = Math.sin(rot) * (double) (entityIn.getWidth() + 1f);
		double yMod = entityIn.getHeight() + 0.8f;
		Vec3d lurePos = this.getPosition(entityIn, xMod, yMod, zMod, partialTicks);
		if (entityIn.isUsingBeam()) {
			float f = 240.0F;
			float f1 = (float)entityIn.world.getGameTime() + partialTicks;
			float f2 = f1 * 0.5F % 1.0F;
			float f3 = entityIn.getEyeHeight();
			matrixStackIn.push();
			matrixStackIn.translate(0.0D, (double)f3, 0.0D);
			Vec3d laserAngle = Vec3d.fromPitchYaw(this.interpolateRotation(entityIn.getPrevLaserPitch(), entityIn.getLaserPitch(), partialTicks), this.interpolateRotation(entityIn.getPrevLaserYaw(), entityIn.getLaserYaw(), partialTicks));
			double range = 30d;
			Vec3d hitVec = lurePos.add(laserAngle.scale(range));
			Vec3d vec3d = hitVec;
			Vec3d vec3d2 = vec3d.subtract(lurePos);
			float f4 = (float)(vec3d2.length() + 1.0D);
			vec3d2 = vec3d2.normalize();
			float f5 = (float)Math.acos(vec3d2.y);
			float f6 = (float)Math.atan2(vec3d2.z, vec3d2.x);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees((((float)Math.PI / 2F) - f6) * (180F / (float)Math.PI)));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f5 * (180F / (float)Math.PI)));
			float f7 = f1 * 0.05F * -1.5F;
			float f8 = f * f;
			int j = 64 + (int)(f8 * 191.0F);
			int k = 32 + (int)(f8 * 191.0F);
			int l = 128 - (int)(f8 * 64.0F);
			float f11 = MathHelper.cos(f7 + 2.3561945F) * 0.282F;
			float f12 = MathHelper.sin(f7 + 2.3561945F) * 0.282F;
			float f13 = MathHelper.cos(f7 + ((float)Math.PI / 4F)) * 0.282F;
			float f14 = MathHelper.sin(f7 + ((float)Math.PI / 4F)) * 0.282F;
			float f15 = MathHelper.cos(f7 + 3.926991F) * 0.282F;
			float f16 = MathHelper.sin(f7 + 3.926991F) * 0.282F;
			float f17 = MathHelper.cos(f7 + 5.4977875F) * 0.282F;
			float f18 = MathHelper.sin(f7 + 5.4977875F) * 0.282F;
			float f19 = MathHelper.cos(f7 + (float)Math.PI) * 0.2F;
			float f20 = MathHelper.sin(f7 + (float)Math.PI) * 0.2F;
			float f21 = MathHelper.cos(f7 + 0.0F) * 0.2F;
			float f22 = MathHelper.sin(f7 + 0.0F) * 0.2F;
			float f23 = MathHelper.cos(f7 + ((float)Math.PI / 2F)) * 0.2F;
			float f24 = MathHelper.sin(f7 + ((float)Math.PI / 2F)) * 0.2F;
			float f25 = MathHelper.cos(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
			float f26 = MathHelper.sin(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
			float f29 = -1.0F + f2;
			float f30 = f4 * 2.5F + f29;
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(field_229107_h_);
			MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
			Matrix4f matrix4f = matrixstack$entry.getMatrix();
			Matrix3f matrix3f = matrixstack$entry.getNormal();
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f19, f4, f20, j, k, l, 0.4999F, f30);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f19, 0.0F, f20, j, k, l, 0.4999F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f21, 0.0F, f22, j, k, l, 0.0F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f21, f4, f22, j, k, l, 0.0F, f30);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f23, f4, f24, j, k, l, 0.4999F, f30);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f23, 0.0F, f24, j, k, l, 0.4999F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f25, 0.0F, f26, j, k, l, 0.0F, f29);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f25, f4, f26, j, k, l, 0.0F, f30);
			float f31 = 0.0F;
			if (entityIn.ticksExisted % 2 == 0) {
				f31 = 0.5F;
			}

			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f11, f4, f12, j, k, l, 0.5F, f31 + 0.5F);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f13, f4, f14, j, k, l, 1.0F, f31 + 0.5F);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f17, f4, f18, j, k, l, 1.0F, f31);
			func_229108_a_(ivertexbuilder, matrix4f, matrix3f, f15, f4, f16, j, k, l, 0.5F, f31);
			matrixStackIn.pop();
		}
	}

	private static void func_229108_a_(IVertexBuilder p_229108_0_, Matrix4f p_229108_1_, Matrix3f p_229108_2_, float p_229108_3_, float p_229108_4_, float p_229108_5_, int p_229108_6_, int p_229108_7_, int p_229108_8_, float p_229108_9_, float p_229108_10_) {
		p_229108_0_.pos(p_229108_1_, p_229108_3_, p_229108_4_, p_229108_5_).color(p_229108_6_, p_229108_7_, p_229108_8_, 255).tex(p_229108_9_, p_229108_10_).overlay(OverlayTexture.NO_OVERLAY).lightmap(15728880).normal(p_229108_2_, 0.0F, 1.0F, 0.0F).endVertex();
	}

	private Vec3d getPosition(LivingEntity entityLivingBaseIn, double xMod, double yMod, double zMod, float partialTicks) {
		double d0 = xMod + entityLivingBaseIn.lastTickPosX + (entityLivingBaseIn.getPosX() - entityLivingBaseIn.lastTickPosX) * (double) partialTicks;
		double d1 = yMod + entityLivingBaseIn.lastTickPosY + (entityLivingBaseIn.getPosY() - entityLivingBaseIn.lastTickPosY) * (double) partialTicks;
		double d2 = zMod + entityLivingBaseIn.lastTickPosZ + (entityLivingBaseIn.getPosZ() - entityLivingBaseIn.lastTickPosZ) * (double) partialTicks;
		return new Vec3d(d0, d1, d2);
	}

	protected float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		float f;

		f = yawOffset - prevYawOffset;
		while (f < -180.0F) {
			f += 360.0F;
		}

		while (f >= 180.0F) {
			f -= 360.0F;
		}

		return prevYawOffset + partialTicks * f;
	}

	private double interpolateValue(double start, double end, double pct)
	{
		return start + (end - start) * pct;
	}

	public ResourceLocation getEntityTexture(TimeGuardianEntity entity) {
		return TEXTURE;
	}
}