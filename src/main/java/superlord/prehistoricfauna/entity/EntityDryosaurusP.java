package superlord.prehistoricfauna.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Activity;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Attacking;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Climbing;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Following;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Jumping;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Moving;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Response;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Stalking;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Taming;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.Untaming;
import superlord.prehistoricfauna.entity.ai.PrehistoricEntityTypeAI.WaterAbility;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.util.handlers.LootTableHandler;
import superlord.prehistoricfauna.util.handlers.Sounds;
import superlord.prehistoricfauna.entity.ai.*;

public class EntityDryosaurusP extends EntityPrehistoric {
	
    public int timeUntilNextEgg;

	public EntityDryosaurusP(World world) {
		super(world, EntityType.DRYOSAURUS, 1, 3, 10, 32, 0.2, 0.35, 0, 0);
		this.maxSize = 1.2F;
		this.minSize = 0.5F;
		this.teenAge = 3;
		developsResistance = false;
		this.nearByMobsAllowed = 10;
		hasTeenTexture = false;
		hasFeatherToggle=false;
		teenAge = 2;
		this.setActualSize(1.3F, 1.2F);
		this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
	}
	
	public void initEntityAI() {
		this.tasks.addTask(1, new DinoMeleeAttackAI(this, 1.0D, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new DinoAIWander(this, 1.0D));
		this.tasks.addTask(3, new DinoAIEatBlocks(this));
		this.tasks.addTask(3, new DinoAIEatBlocks(this));
		this.tasks.addTask(4, new EntityAIPanic(this, 1.5D));
		this.tasks.addTask(7, new DinoAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new DinoAILookIdle(this));
	}

	@Override
	public void setSpawnValues() {
		
	}

	@Override
	public Activity aiActivityType() {
		return PrehistoricEntityTypeAI.Activity.DIURINAL;
	}

	@Override
	public Attacking aiAttackType() {
		return PrehistoricEntityTypeAI.Attacking.BASIC;
	}

	@Override
	public Climbing aiClimbType() {
		return PrehistoricEntityTypeAI.Climbing.NONE;
	}

	@Override
	public Following aiFollowType() {
		return PrehistoricEntityTypeAI.Following.NONE;
	}

	@Override
	public Jumping aiJumpType() {
		return PrehistoricEntityTypeAI.Jumping.BASIC;
	}

	@Override
	public Response aiResponseType() {
		return PrehistoricEntityTypeAI.Response.SCARED;
	}

	@Override
	public Stalking aiStalkType() {
		return PrehistoricEntityTypeAI.Stalking.NONE;
	}

	@Override
	public Taming aiTameType() {
		return PrehistoricEntityTypeAI.Taming.IMPRINTING;
	}

	@Override
	public Untaming aiUntameType() {
		return PrehistoricEntityTypeAI.Untaming.NONE;
	}

	@Override
	public Moving aiMovingType() {
		return PrehistoricEntityTypeAI.Moving.WALK;
	}

	@Override
	public WaterAbility aiWaterAbilityType() {
		return PrehistoricEntityTypeAI.WaterAbility.NONE;
	}

	@Override
	public int getAdultAge() {
		return 8;
	}

	@Override
	public boolean doesFlock() {
		return false;
	}

	@Override
	public int getMaxHunger() {
		return 50;
	}

	@Override
	public Item getOrderItem() {
		return Items.STICK;
	}

	@Override
	public boolean canBeRidden() {
		return false;
	}
	
	@Nullable
    protected SoundEvent getAmbientSound() {
        return Sounds.DRYOSAURUS_IDLE;
    }
	
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return Sounds.DRYOSAURUS_HURT;
    }
    
    protected SoundEvent getDeathSound() {
        return Sounds.DRYOSAURUS_HURT;
    }
    
    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableHandler.DRYOSAURUS;
    }
    
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ModItems.DRYOSAURUS_EGG_ENTITY, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

}
