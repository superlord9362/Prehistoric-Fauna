package superlord.prehistoricfauna.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BossHealParticle extends SpriteTexturedParticle {

	private double targetX;
	private double targetY;
	private double targetZ;
	private float speed;
	private BossHealParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z, motionX, motionY, motionZ);
		this.particleRed = 0.2039216F;
		this.particleGreen = 0.9F + rand.nextFloat() * 0.1F;
		this.particleBlue = 0.6392157F;
		this.particleScale *= 1.0F + rand.nextFloat();
		targetX = motionX;
		targetY = motionY;
		targetZ = motionZ;
		this.speed = 0.1F + rand.nextFloat() * 0.1F;
		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;
		this.maxAge = 8;
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
			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}
			this.motionX = (this.targetX - this.posX) * speed;
			this.motionY = (this.targetY - this.posY) * speed;
			this.motionZ = (this.targetZ - this.posZ) * speed;
			particleRed	= (float)Math.min(particleRed - 0.1D, 0.0D);
			particleBlue = (float)Math.min(particleBlue - 0.1D, 0.0D);

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
			BossHealParticle particle = new BossHealParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			particle.selectSpriteRandomly(this.spriteSet);
			return particle;
		}
	}

}