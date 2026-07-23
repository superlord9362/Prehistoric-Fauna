package superlord.prehistoricfauna.common.items;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import superlord.prehistoricfauna.init.PFBlocks;

public class StegosaurScytheItem extends TieredItem {
	private final float attackDamage;
	protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.defaultBlockState(), Blocks.DIRT_PATH, Blocks.FARMLAND.defaultBlockState(), Blocks.DIRT, Blocks.FARMLAND.defaultBlockState(), Blocks.COARSE_DIRT, Blocks.DIRT.defaultBlockState(), PFBlocks.MOSSY_DIRT.get(), Blocks.FARMLAND.defaultBlockState()));
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    private static final double EXTRA_REACH = 2.0;
    private static final double SWEEP_RADIUS = 3.5;
    private static final float SWEEP_DAMAGE_FRACTION = 0.75f;

	public StegosaurScytheItem(Tier p_43308_, Properties p_43309_) {
		super(p_43308_, p_43309_);
		attackDamage = p_43308_.getAttackDamageBonus() + 3;
		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", attackDamage, AttributeModifier.Operation.ADDITION));	      
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)-3.2, AttributeModifier.Operation.ADDITION));
		builder.put(net.minecraftforge.common.ForgeMod.ENTITY_REACH.get(), new AttributeModifier(java.util.UUID.fromString("a9b2e3f4-1c2d-4e5f-8a9b-0c1d2e3f4a5b"), "Scythe reach", EXTRA_REACH, AttributeModifier.Operation.ADDITION));
		defaultModifiers = builder.build();
	}

	public InteractionResult useOn(UseOnContext p_41341_) {
		Level level = p_41341_.getLevel();
		BlockPos blockpos = p_41341_.getClickedPos();
		BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(p_41341_, net.minecraftforge.common.ToolActions.HOE_TILL, false);
		Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
		if (pair == null) {
			return InteractionResult.PASS;
		} else {
			Predicate<UseOnContext> predicate = pair.getFirst();
			Consumer<UseOnContext> consumer = pair.getSecond();
			if (predicate.test(p_41341_)) {
				Player player = p_41341_.getPlayer();
				level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				if (!level.isClientSide) {
					consumer.accept(p_41341_);
					if (player != null) {
						p_41341_.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> {
							p_150845_.broadcastBreakEvent(p_41341_.getHand());
						});
					}
				}

				return InteractionResult.sidedSuccess(level.isClientSide);
			} else {
				return InteractionResult.PASS;
			}
		}
	}

	public static Consumer<UseOnContext> changeIntoState(BlockState p_150859_) {
		return (p_150848_) -> {
			p_150848_.getLevel().setBlock(p_150848_.getClickedPos(), p_150859_, 11);
		};
	}

	public static Consumer<UseOnContext> changeIntoStateAndDropItem(BlockState p_150850_, ItemLike p_150851_) {
		return (p_150855_) -> {
			p_150855_.getLevel().setBlock(p_150855_.getClickedPos(), p_150850_, 11);
			Block.popResourceFromFace(p_150855_.getLevel(), p_150855_.getClickedPos(), p_150855_.getClickedFace(), new ItemStack(p_150851_));
		};
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (e) -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		if (!attacker.level().isClientSide()) {
			float sweepDamage = Math.max(1.0f, attackDamage * SWEEP_DAMAGE_FRACTION);

			AABB sweepBox = target.getBoundingBox().inflate(SWEEP_RADIUS);
			for (Entity nearby : attacker.level().getEntities(attacker, sweepBox)) {
				if (nearby == target) continue;
				if (!(nearby instanceof LivingEntity livingNearby)) continue;
				if (attacker.distanceToSqr(nearby) > (SWEEP_RADIUS + EXTRA_REACH) * (SWEEP_RADIUS + EXTRA_REACH)) continue;

				livingNearby.hurt(attacker.level().damageSources().playerAttack(attacker instanceof Player p ? p : null), sweepDamage);

				double dx = nearby.getX() - attacker.getX();
				double dz = nearby.getZ() - attacker.getZ();
				double len = Math.sqrt(dx * dx + dz * dz);
				if (len > 0) {
					nearby.setDeltaMovement(nearby.getDeltaMovement().add(dx / len * 0.4, 0.1, dz / len * 0.4));
				}
			}
			attacker.level().playSound(null,
					attacker.getX(), attacker.getY(), attacker.getZ(),
					SoundEvents.PLAYER_ATTACK_SWEEP,
					attacker.getSoundSource(), 1.0F, 1.0F);
		}

		return true;
	}

	public static boolean onlyIfAirAbove(UseOnContext p_150857_) {
		return p_150857_.getClickedFace() != Direction.DOWN && p_150857_.getLevel().getBlockState(p_150857_.getClickedPos().above()).isAir();
	}

	@Override
	public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
		return net.minecraftforge.common.ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
	}

	public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player p_43294_) {
		return !p_43294_.isCreative();
	}

	public float getDamage() {
		return this.attackDamage;
	}

	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43274_) {
		return p_43274_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43274_);
	}

}
