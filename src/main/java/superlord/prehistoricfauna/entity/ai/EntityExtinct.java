package superlord.prehistoricfauna.entity.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.entity.EntityType;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.message.MessageFoodParticles;

public abstract class EntityExtinct extends EntityAnimal{
	
	public Flock flockObj;
    public EntityType type;
    protected int nearByMobsAllowed;
    private static final DataParameter<Integer> AGETICK = EntityDataManager.<Integer>createKey(EntityExtinct.class, DataSerializers.VARINT);
    public abstract int getAdultAge();
    public int teenAge;
    public float actualWidth;
    public float minSize;
    public float maxSize;
    public boolean hasBabyTexture;
    public boolean hasTeenTexture = false;
    public boolean hasFeatherToggle = false;
    public boolean featherToggle;

    public void setActualSize(float width, float height) {
        this.actualWidth = width;
        this.setSize(width, height);
    }
    

	public EntityExtinct(World worldIn) {
		super(worldIn);
		this.nearByMobsAllowed = 15;
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.doesFlock() && flockObj == null) {
            if (this.getNearbyFlock() != null) {
                this.getNearbyFlock().flockMembers.add(this);
            } else {
                flockObj = new Flock();
                flockObj.createFlock(this);
            }
        }
        if (this.flockObj != null) {
            if (this == flockObj.flockLeader) {
                this.flockObj.onUpdate();
            }
        }
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(AGETICK, 0);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("AgeTick", this.getAgeInTicks());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setAgeinTicks(compound.getInteger("AgeTick"));
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemStack = player.getHeldItem(hand);
		if (itemStack.getItem() == ModItems.COBBLE_BRICK && !player.world.isRemote) {
            if (this.getAgeInDays() < this.getAdultAge()) {
                    itemStack.shrink(1);
                    if (!player.capabilities.isCreativeMode) {
                        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE, 1));
                    }
                    Main.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(ModItems.COBBLE_BRICK)));
                    this.grow(1);
                    return true;
                }
            }

            if (!this.world.isRemote) {
                player.sendStatusMessage(new TextComponentTranslation("prehistoric.essencefail"), true);
            }

            return false;
        }

	
	
	 public void grow(int ageInDays) {
	        this.setAgeInDays(this.getAgeInDays() + ageInDays);
	        this.setScaleForAge(false);
	        if (this.getAgeInDays() % 25 == 0) {
	            for (int i = 0; i < this.getAgeScale() * 4; i++) {
	                double motionX = getRNG().nextGaussian() * 0.07D;
	                double motionY = getRNG().nextGaussian() * 0.07D;
	                double motionZ = getRNG().nextGaussian() * 0.07D;
	                float f = (float) (getRNG().nextFloat() * (this.getEntityBoundingBox().maxX - this.getEntityBoundingBox().minX) + this.getEntityBoundingBox().minX);
	                float f1 = (float) (getRNG().nextFloat() * (this.getEntityBoundingBox().maxY - this.getEntityBoundingBox().minY) + this.getEntityBoundingBox().minY);
	                float f2 = (float) (getRNG().nextFloat() * (this.getEntityBoundingBox().maxZ - this.getEntityBoundingBox().minZ) + this.getEntityBoundingBox().minZ);
	                if (world.isRemote) {
	                    this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, f, f1, f2, motionX, motionY, motionZ, new int[]{});
	                }
	            }
	        }
	    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.getGrowingAge() < 0) {
			this.setGrowingAge(0);
		}
		if (world.isRemote) {
			this.setScaleForAge(true);
		}
	}
	 
	    public boolean isMovementBlocked() {
	        return this.getHealth() <= 0.0F;
	    }
	
	    public int getAgeInDays() {
	        return this.dataManager.get(AGETICK) / 24000;
	    }

	    public void setAgeInDays(int days) {
	        this.dataManager.set(AGETICK, days * 24000);
	    }

	    public void setAgeinTicks(int ticks) {
	        this.dataManager.set(AGETICK, ticks);
	    }

	
	 public EntityExtinct findFlockLeader(List<EntityExtinct> flock) {
	        int index = new Random().nextInt(flock.size());
	        return flock.get(index);
	    }
	 
	    public abstract boolean doesFlock();
	    
	    public Flock getNearbyFlock() {
	        EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
	        double d0 = 64;
	        List<EntityExtinct> list = world.getEntitiesWithinAABB(EntityExtinct.class, this.getEntityBoundingBox().expand(d0, 4.0D, d0), null);
	        Collections.sort(list, theNearestAttackableTargetSorter);
	        if (!list.isEmpty()) {
	            for (EntityExtinct mob : list) {
	                if (mob != this && mob.type == this.type && mob.flockObj != null && mob.flockObj.flockLeader == mob) {
	                    return mob.flockObj;
	                }
	            }
	        }
	        return null;
	    }
	    
	    public boolean isThereNearbyTypes() {
	        Entity targetEntity;
	        EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
	        double d0 = 64;
	        List<EntityExtinct> list = world.getEntitiesWithinAABB(EntityExtinct.class, this.getEntityBoundingBox().expand(d0, 4.0D, d0), null);
	        Collections.sort(list, theNearestAttackableTargetSorter);

	        if (list.isEmpty() || this.doesFlock()) {
	            return false;
	        } else {
	            List<EntityExtinct> listOfType = new ArrayList<EntityExtinct>();
	            for (EntityExtinct mob : list) {
	                if (mob != this && mob.type == this.type && mob.isAdult()) {
	                    listOfType.add(mob);
	                }
	            }
	            return listOfType.size() > this.nearByMobsAllowed;
	        }
	    }
	    
	    public boolean isAdult() {
	        return this.getAgeInDays() >= getAdultAge();
	    }
	    
	    public boolean isTeen() {
	        return this.getAgeInDays() >= teenAge && this.getAgeInDays() < getAdultAge();
	    }
	    
	    
	    
	    public int getAgeInTicks() {
	        return  this.dataManager.get(AGETICK);
	    }
	    
	    public float getAgeScale() {
	        float step = (this.maxSize - this.minSize) / ((this.getAdultAge() * 24000) + 1);
	        if (this.getAgeInTicks() > this.getAdultAge() * 24000) {
	            return this.minSize + ((step) * this.getAdultAge() * 24000);
	        }
	        return this.minSize + ((step * this.getAgeInTicks()));
	    }

	
	
}
