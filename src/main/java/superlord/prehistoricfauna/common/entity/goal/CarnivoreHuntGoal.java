package superlord.prehistoricfauna.common.entity.goal;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Torvosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFTags;

@SuppressWarnings("rawtypes")
public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
	double huntSpeed;
	Predicate<LivingEntity> targetPredicate;
	private UUID lastLootedTargetId = null;
	DinosaurEntity dinosaur;

	@SuppressWarnings("unchecked")
	public CarnivoreHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
		super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		this.huntSpeed = huntSpeed;
		this.targetPredicate = targetPredicate;
		this.dinosaur = goalOwnerIn;
	}

	public boolean canUse() {
		return super.canUse() && dinosaur.getCurrentHunger() <= dinosaur.getHalfHunger() && !dinosaur.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(dinosaur) && !dinosaur.trusts(target.getUUID()) && !dinosaur.isOpportunist();
	}

	public boolean canContinueToUse() {
		return dinosaur.getCurrentHunger() < dinosaur.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
	}

	public void tick() {
		dinosaur.getNavigation().setSpeedModifier(huntSpeed);
		if (dinosaur.getTarget() != null) {
			LivingEntity target = dinosaur.getTarget();
			if (!target.is(null)) {
				if (target.isDeadOrDying() && dinosaur instanceof Torvosaurus) {
					if (!target.getUUID().equals(lastLootedTargetId)) {
	                    lastLootedTargetId = target.getUUID();
	                    ServerLevel level = (ServerLevel) dinosaur.level();
	                    LootParams params = new LootParams.Builder(level)
	                            .withParameter(LootContextParams.ORIGIN, dinosaur.position())
	                            .withParameter(LootContextParams.THIS_ENTITY, target)
	                            .withParameter(LootContextParams.DAMAGE_SOURCE, dinosaur.damageSources().mobAttack(dinosaur))
	                            .create(LootContextParamSets.ENTITY);
	                    ResourceLocation lootTableId = target.getLootTable();
	                    LootTable table = level.getServer().getLootData().getLootTable(lootTableId);
	                    List<ItemStack> drops = table.getRandomItems(params);
	                    for (ItemStack stack : drops) {
	                        dinosaur.spawnAtLocation(stack);
	                    }
	                }
				}
				if (target.getType().is(PFTags.INSECTS_2_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 2 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 2);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 3 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 3);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 4 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 4);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 6 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 6);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 8 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 8);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 10 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 10);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 15 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 15);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 20 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 20);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_30_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 30 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 30);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_40_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 40 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 40);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_60_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 60 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 60);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_80_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 80 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 80);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_100_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 100 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 100);
						}
					}
				}
				if (target.getType().is(PFTags.ANIMALS_200_HUNGER)) {
					if (target.isDeadOrDying()) {
						if (dinosaur.getCurrentHunger() + 200 >= dinosaur.maxHunger) {
							dinosaur.setHunger(dinosaur.maxHunger);
						} else {
							dinosaur.setHunger(dinosaur.currentHunger + 200);
						}
					}
				}
			} else stop();
		} else stop();
		super.tick();
	}

}
