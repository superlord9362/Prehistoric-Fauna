package superlord.prehistoricfauna.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class BossLaserParticle extends SpriteTexturedParticle {
	private BossLaserParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z, motionX, motionY, motionZ);
		this.particleGravity = 0.06F;
		this.particleRed = 0.2039216F;
		this.particleGreen = 0.9176471F + rand.nextFloat() * 0.05F;
		this.particleBlue = 0.6392157F;
		this.particleScale *= 1.5F;
		this.maxAge = 6;
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	public int getBrightnessForRender(float f) {
		return 240;
	}

	public float getScale(float scaleFactor) {
		return this.particleScale * MathHelper.clamp(((float)this.age + scaleFactor) / (float)this.maxAge * 32.0F, 0.0F, 1.0F);
	}

	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.age++ >= this.maxAge) {
			this.setExpired();
		} else {
			this.move(this.motionX, this.motionY, this.motionZ);
			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}
			if(particleRed < 1.0F){
				particleRed	= (float)Math.min(particleRed + 0.05D, 1.0D);
			}
			if(particleBlue < 1.0F){
				particleBlue = (float)Math.min(particleBlue + 0.05D, 1.0D);
			}
			if(particleGreen < 1.0F){
				particleGreen	= (float)Math.min(particleGreen + 0.05D, 1.0D);
			}

			this.motionY -= (double)this.particleGravity;
			this.move(this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double)0.98F;
			this.motionY *= (double)0.98F;
			this.motionZ *= (double)0.98F;

		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			BossLaserParticle particle = new BossLaserParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			particle.selectSpriteRandomly(this.spriteSet);
			return particle;
		}
	}

}
