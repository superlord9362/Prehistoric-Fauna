package superlord.prehistoricfauna.common.entity;

import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class PrehistoricEntity extends Animal {
	private int inLove;
	private UUID playerInLove;

	protected PrehistoricEntity(EntityType<? extends PrehistoricEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	protected void customServerAiStep() {
		if (this.getAge() != 0) {
			this.inLove = 0;
		}

		super.customServerAiStep();
	}

	public void aiStep() {
		super.aiStep();
		if (this.getAge() != 0) {
			this.inLove = 0;
		}

		if (this.inLove > 0) {
			--this.inLove;
			if (this.inLove % 10 == 0) {
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				double d2 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			}
		}

	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == null;
	}

	public boolean hurt(DamageSource p_27567_, float p_27568_) {
	      if (this.isInvulnerableTo(p_27567_)) {
	         return false;
	      } else {
	         this.inLove = 0;
	         return super.hurt(p_27567_, p_27568_);
	      }
	   }

	@SuppressWarnings("deprecation")
	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getBlockState(pos.below()).getBlock() == Blocks.GRASS_BLOCK ? 10.0F : worldIn.getBrightness(pos) - 0.5F;
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("InLove", this.inLove);
		if (this.playerInLove != null) {
			compound.putUUID("LoveCause", this.playerInLove);
		}

	}

	public double getYOffset() {
		return 0.14D;
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.inLove = compound.getInt("InLove");
		this.playerInLove = compound.hasUUID("LoveCause") ? compound.getUUID("LoveCause") : null;
	}

	public static boolean checkAnimalSpawnRules(EntityType<? extends Animal> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
		return worldIn.getBlockState(pos.below()).getBlock() == Blocks.GRASS_BLOCK && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public int getAmbientSoundInterval() {
		return 120;
	}

	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	protected int getExperienceReward(Player player) {
		return 1 + this.level.random.nextInt(3);
	}

	protected void usePlayerItem(Player player, ItemStack stack) {
		if (!player.getAbilities().instabuild) {
			stack.shrink(1);
		}

	}

	public boolean canBreed() {
		return this.inLove <= 0;
	}

	public void setInLove(@Nullable Player player) {
		this.inLove = 600;
		if (player != null) {
			this.playerInLove = player.getUUID();
		}

		this.level.broadcastEntityEvent(this, (byte)18);
	}

	public void setInLove(int ticks) {
		this.inLove = ticks;
	}

	@Nullable
	public ServerPlayer getLoveCause() {
		if (this.playerInLove == null) {
			return null;
		} else {
			Player playerentity = this.level.getPlayerByUUID(this.playerInLove);
			return playerentity instanceof ServerPlayer ? (ServerPlayer)playerentity : null;
		}
	}

	public boolean isInLove() {
		return this.inLove > 0;
	}

	public void resetInLove() {
		this.inLove = 0;
	}

	public boolean canMateWith(PrehistoricEntity otherAnimal) {
		if (otherAnimal == this) {
			return false;
		} else if (otherAnimal.getClass() != this.getClass()) {
			return false;
		} else {
			return this.isInLove() && otherAnimal.isInLove();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 18) {
			for(int i = 0; i < 7; ++i) {
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				double d2 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			}
		} else {
			super.handleEntityEvent(id);
		}

	}

}
