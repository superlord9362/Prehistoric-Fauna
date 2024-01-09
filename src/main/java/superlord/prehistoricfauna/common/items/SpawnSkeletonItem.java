package superlord.prehistoricfauna.common.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nullable;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.registries.RegistryObject;

public class SpawnSkeletonItem extends Item {
	
	private static final Map<? extends EntityType<?>, SpawnSkeletonItem> EGGS = Maps.newIdentityHashMap();
    public static final List<SpawnSkeletonItem> UNADDED_EGGS = new ArrayList<SpawnSkeletonItem>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public SpawnSkeletonItem(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final Item.Properties properties) {
        super(properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }

    public SpawnSkeletonItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final Item.Properties properties) {
        super(properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
    }
    
    public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		if (!(world instanceof ServerLevel)) {
			return InteractionResult.SUCCESS;
		} else {
			ItemStack itemstack = context.getItemInHand();
			BlockPos blockpos = context.getClickedPos();
			Direction direction = context.getClickedFace();
			BlockState blockstate = world.getBlockState(blockpos);
			if (blockstate.is(Blocks.SPAWNER)) {
				BlockEntity tileentity = world.getBlockEntity(blockpos);
				if (tileentity instanceof SpawnerBlockEntity) {
					BaseSpawner abstractspawner = ((SpawnerBlockEntity)tileentity).getSpawner();
					EntityType<?> entitytype1 = this.getType(itemstack.getTag());
					abstractspawner.setEntityId(entitytype1);
					tileentity.setChanged();
					world.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
					itemstack.shrink(1);
					return InteractionResult.CONSUME;
				}
			}

			BlockPos blockpos1;
			if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
				blockpos1 = blockpos;
			} else {
				blockpos1 = blockpos.relative(direction);
			}

			EntityType<?> entitytype = this.getType(itemstack.getTag());
			if (entitytype.spawn((ServerLevel)world, itemstack, context.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
				itemstack.shrink(1);
			}

			return InteractionResult.CONSUME;
		}
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	 * {@link #onItemUse}.
	 */
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.SOURCE_ONLY);
		if (raytraceresult.getType() != HitResult.Type.BLOCK) {
			return InteractionResultHolder.pass(itemstack);
		} else if (!(worldIn instanceof ServerLevel)) {
			return InteractionResultHolder.success(itemstack);
		} else {
			BlockHitResult blockraytraceresult = (BlockHitResult)raytraceresult;
			BlockPos blockpos = blockraytraceresult.getBlockPos();
			if (!(worldIn.getBlockState(blockpos).getBlock() instanceof LiquidBlock)) {
				return InteractionResultHolder.pass(itemstack);
			} else if (worldIn.mayInteract(playerIn, blockpos) && playerIn.mayUseItemAt(blockpos, blockraytraceresult.getDirection(), itemstack)) {
				EntityType<?> entitytype = this.getType(itemstack.getTag());
				if (entitytype.spawn((ServerLevel)worldIn, itemstack, playerIn, blockpos, MobSpawnType.SPAWN_EGG, false, false) == null) {
					return InteractionResultHolder.pass(itemstack);
				} else {
					if (!playerIn.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					return InteractionResultHolder.consume(itemstack);
				}
			} else {
				return InteractionResultHolder.fail(itemstack);
			}
		}
	}

	public boolean spawnsEntity(@Nullable CompoundTag nbt, EntityType<?> type) {
		return Objects.equals(this.getType(nbt), type);
	}
	
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static SpawnSkeletonItem getEgg(@Nullable EntityType<?> type) {
		return EGGS.get(type);
	}

	public static Iterable<SpawnSkeletonItem> getEggs() {
		return Iterables.unmodifiableIterable(EGGS.values());
	}

	public EntityType<?> getType(@Nullable CompoundTag nbt) {
		if (nbt != null && nbt.contains("EntityTag", 10)) {
			CompoundTag compoundnbt = nbt.getCompound("EntityTag");
			if (compoundnbt.contains("id", 8)) {
				return EntityType.byString(compoundnbt.getString("id")).orElse(this.entityTypeSupplier.get());
			}
		}

		return this.entityTypeSupplier.get();
	}

	public Optional<Mob> getChildToSpawn(Player player, Mob mob, EntityType<? extends Mob> entityType, ServerLevel world, Vec3 pos, ItemStack stack) {
		if (!this.spawnsEntity(stack.getTag(), entityType)) {
			return Optional.empty();
		} else {
			Mob mobentity;
			if (mob instanceof AgeableMob) {
				mobentity = ((AgeableMob)mob).getBreedOffspring(world, (AgeableMob)mob);
			} else {
				mobentity = entityType.create(world);
			}

			if (mobentity == null) {
				return Optional.empty();
			} else {
				mobentity.setBaby(true);
				if (!mobentity.isBaby()) {
					return Optional.empty();
				} else {
					mobentity.moveTo(pos.x(), pos.y(), pos.z(), 0.0F, 0.0F);
					world.addFreshEntityWithPassengers(mobentity);
					if (stack.hasCustomHoverName()) {
						mobentity.setCustomName(stack.getDisplayName());
					}

					if (!player.getAbilities().instabuild) {
						stack.shrink(1);
					}

					return Optional.of(mobentity);
				}
			}
		}
	}
    
}