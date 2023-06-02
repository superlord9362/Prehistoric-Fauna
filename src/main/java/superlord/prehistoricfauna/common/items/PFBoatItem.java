package superlord.prehistoricfauna.common.items;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.PFBoat;
import superlord.prehistoricfauna.common.entity.PFBoat.PFBoatTypes;

public class PFBoatItem  extends Item {
	
	private static final Predicate<Entity> RIDERS = EntitySelector.NO_SPECTATORS.and(Entity::canBeCollidedWith);
	private final PFBoatTypes type;
	
	public PFBoatItem(PFBoat.PFBoatTypes type, Item.Properties properties) {
		super(properties);
		this.type = type;
	}
	
	@Override
	   public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		HitResult raytraceresult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.ANY);
		if (raytraceresult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			Vec3 vec3d = player.getViewVector(1.0F);
			List<Entity> list = world.getEntities(player, player.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), RIDERS);
			if (!list.isEmpty()) {
				Vec3 vec3d1 = player.getEyePosition(1.0F);
				for (Entity entity : list) {
					AABB axisalignedbb = entity.getBoundingBox().inflate(entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
                        return InteractionResultHolder.pass(itemstack);
					}
				}
			}
			if (raytraceresult.getType() == HitResult.Type.BLOCK) {
				PFBoat PFBoat = new PFBoat(world, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				PrehistoricFauna.LOGGER.info("BOAT ENTITY: " + PFBoat.getEntityData());
				PFBoat.setPFBoatType(this.type);
				PFBoat.yRotO = player.yRotO;
				if (!world.noCollision(PFBoat, PFBoat.getBoundingBox().inflate(-0.1D))) {
					return InteractionResultHolder.fail(itemstack);
				} else {
					if (!world.isClientSide) {
						world.addFreshEntity(PFBoat);
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					}
					player.awardStat(Stats.ITEM_USED.get(this));
					return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
				}
 			} else {
 				return InteractionResultHolder.pass(itemstack);
 			}
		}
	}
}
