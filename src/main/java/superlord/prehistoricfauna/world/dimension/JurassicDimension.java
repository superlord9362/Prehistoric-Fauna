package superlord.prehistoricfauna.world.dimension;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class JurassicDimension extends Dimension {

	private final float[] colorsSunriseSunset = new float[4];

	public JurassicDimension(World world, DimensionType type) {
		super(world, type, 0.0F);
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new PFChunkGenerator(world, new JurassicBiomeProvider(), new PFGenSettings());
	}
	
	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
	}
	
	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return null;
	}
	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
		double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
		return (float)(d0 * 2.0D + d1) / 3.0F;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		float f = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		float f1 = 0.7529412F;
		float f2 = 0.84705883F;
		float f3 = 1.0F;
		f1 = f1 * (f * 0.94F + 0.06F);
		f2 = f2 * (f * 0.94F + 0.06F);
		f3 = f3 * (f * 0.91F + 0.09F);
		return new Vec3d((double)f1, (double)f2, (double)f3);
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}
	
	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}
	
	@Override
	public int getActualHeight() {
		return 256;
	}
	
	@SuppressWarnings("unused")
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		float f = 0.4F;
		float f1 = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) - 0.0F;
		float f2 = -0.0F;
		if (f1 >= -0.4F && f1 <= 0.4F) {
			float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F;
			float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
			f4 = f4 * f4;
			this.colorsSunriseSunset[0] = f3 * 0.3F + 0.7F;
			this.colorsSunriseSunset[1] = f3 * f3 * 0.7F + 0.2F;
			this.colorsSunriseSunset[2] = f3 * f3 * 0.0F + 0.2F;
			this.colorsSunriseSunset[3] = f4;
			return this.colorsSunriseSunset;
		} else {
			return null;
		}
	}
	
	@Override
	public boolean canDoRainSnowIce(final Chunk chunk) {
		return true;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public float getCloudHeight() {
		return 200;
	}
	

}
