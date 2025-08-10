package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Cretaraneus;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class Gobiulus extends PathfinderMob {

	public Gobiulus(EntityType<? extends Gobiulus> p_20966_, Level p_20967_) {
		super(p_20966_, p_20967_);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, PFTags.GOBIULUS_AVOIDING, 6.0F, 1.0D, 1.2D));
	}

	public int getMaxAir() {
		return 0;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
	}

	protected void playStepSound(BlockPos p_33543_, BlockState p_33544_) {
		this.playSound(SoundEvents.SILVERFISH_STEP, 0.15F, 1.0F);
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item == Items.GLASS_BOTTLE) {
			if (!player.isCreative()) {
				itemstack.shrink(1);
			}
			player.addItem(new ItemStack(PFItems.BOTTLED_GOBIULUS.get()));
			this.discard();
		}
		return super.mobInteract(player, hand);
	}

	public static boolean canBugSpawn(EntityType<? extends PathfinderMob> animal, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND) || worldIn.getBlockState(pos.below()).is(BlockTags.LEAVES) || worldIn.getBlockState(pos.below()).is(BlockTags.LOGS_THAT_BURN)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.GOBIULUS_SPAWN_EGG.get());
	}

}
