package superlord.prehistoricfauna.particles;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CretaceousPortalParticle extends SpriteTexturedParticle {

	private final double portalPosX;
	private final double portalPosY;
	private final double portalPosZ;

	public CretaceousPortalParticle(World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
		this.motionX = xSpeed;
		this.motionY = ySpeed;
		this.motionZ = zSpeed;
		this.posX = xCoord;
		this.posY = yCoord;
		this.posZ = zCoord;
		this.portalPosX = this.posX;
		this.portalPosY = this.posY;
		this.portalPosZ = this.posZ;
		this.maxAge = (int)(Math.random() * 10.0D) + 40;
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void move(double x, double y, double z) {
		this.setBoundingBox(this.getBoundingBox().offset(x, y, z));
		this.resetPositionToBB();
	}

	@Override
	public float getScale(float partialTick) {
		float f = ((float)this.age + partialTick) / (float)this.maxAge;
		f = 1.0F - f;
		f = f * f;
		f = 1.0F - f;
		return this.particleScale * f;
	}

	@Override
	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.age++ >= this.maxAge) {
			this.setExpired();
		} else {
			float f = (float)this.age / (float)this.maxAge;
			float f1 = -f + f * f * 2.0F;
			float f2 = 1.0F - f1;
			this.posX = this.portalPosX + this.motionX * (double)f2;
			this.posY = this.portalPosY + this.motionY * (double)f2 + (double)(1.0F - f);
			this.posZ = this.portalPosZ + this.motionZ * (double)f2;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;
		
		public Factory(IAnimatedSprite sprite) {
			this.spriteSet = sprite;
		}

		@Override
		public Particle makeParticle(BasicParticleType type, World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			CretaceousPortalParticle portalParticle = new CretaceousPortalParticle(world, x, y, z, xSpeed, ySpeed, zSpeed);
			portalParticle.selectSpriteRandomly(this.spriteSet);
			return portalParticle;
		}
	}

}
