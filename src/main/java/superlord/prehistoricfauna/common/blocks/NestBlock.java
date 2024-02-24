package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class NestBlock extends Block {
	public static final IntegerProperty PLANT_LEVEL = IntegerProperty.create("plant_level", 0, 3);

	protected static final VoxelShape BLOCK = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

	public NestBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(PLANT_LEVEL, 0));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(PLANT_LEVEL);
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return BLOCK;
	}

	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return BLOCK;
	}

	public int maxPlantFilled() {
		return 3;
	}

	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = player.getItemInHand(hand);
		Random random = new Random();
		int addChance = random.nextInt(5);
		BlockState filledState = world.getBlockState(pos);
		if ((stack.is(PFTags.PLANTS_2_HUNGER_ITEM) || stack.is(PFTags.PLANTS_4_HUNGER_ITEM) || stack.is(PFTags.PLANTS_6_HUNGER_ITEM) || stack.is(PFTags.PLANTS_8_HUNGER_ITEM) || stack.is(PFTags.PLANTS_10_HUNGER_ITEM) || stack.is(PFTags.PLANTS_12_HUNGER_ITEM) || stack.is(PFTags.PLANTS_15_HUNGER_ITEM) || stack.is(PFTags.PLANTS_20_HUNGER_ITEM) || stack.is(PFTags.PLANTS_25_HUNGER_ITEM) || stack.is(PFTags.PLANTS_30_HUNGER_ITEM)) && addChance == 0 && state.getValue(PLANT_LEVEL) < this.maxPlantFilled()) {
			world.setBlock(pos, state.setValue(PLANT_LEVEL, filledState.getValue(PLANT_LEVEL) + 1), 0);
			world.levelEvent(2005, pos, 0);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		}
		Item heldItem = stack.getItem();
		if (heldItem == PFItems.ANKYLOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.ANKYLOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.BASILEMYS_EGG.get()) world.setBlock(pos, PFBlocks.BASILEMYS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.DAKOTARAPTOR_EGG.get()) world.setBlock(pos, PFBlocks.DAKOTARAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.PALAEOSANIWA_EGG.get()) world.setBlock(pos, PFBlocks.PALAEOSANIWA_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.THESCELOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.THESCELOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.THORACOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.THORACOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.TRICERATOPS_EGG.get()) world.setBlock(pos, PFBlocks.TRICERATOPS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.TYRANNOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.TYRANNOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.AEPYORNITHOMIMUS_EGG.get()) world.setBlock(pos, PFBlocks.AEPYORNITHOMIMUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.CITIPATI_EGG.get()) world.setBlock(pos, PFBlocks.CITIPATI_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.HALSZKARAPTOR_EGG.get()) world.setBlock(pos, PFBlocks.HALSZKARAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.OVIRAPTOR_EGG.get()) world.setBlock(pos, PFBlocks.OVIRAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.PINACOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.PINACOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.PLESIOHADROS_EGG.get()) world.setBlock(pos, PFBlocks.PLESIOHADROS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.PROTOCERATOPS_EGG.get()) world.setBlock(pos, PFBlocks.PROTOCERATOPS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.TELMASAURUS_EGG.get()) world.setBlock(pos, PFBlocks.TELMASAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.VELOCIRAPTOR_EGG.get()) world.setBlock(pos, PFBlocks.VELOCIRAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.CALSOYASUCHUS_EGG.get()) world.setBlock(pos, PFBlocks.CALSOYASUCHUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.DILOPHOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.DILOPHOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.KAYENTATHERIUM_EGG.get()) world.setBlock(pos, PFBlocks.KAYENTATHERIUM_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.MEGAPNOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.MEGAPNOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.SARAHSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.SARAHSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.SCELIDOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.SCELIDOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.SCUTELLOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.SCUTELLOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.ALLOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.ALLOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.CAMARASAURUS_EGG.get()) world.setBlock(pos, PFBlocks.CAMARASAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.CERATOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.CERATOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.DRYOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.DRYOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.EILENODON_EGG.get()) world.setBlock(pos, PFBlocks.EILENODON_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.HESPERORNITHOIDES_EGG.get()) world.setBlock(pos, PFBlocks.HESPERORNITHOIDES_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.STEGOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.STEGOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.COELOPHYSIS_EGG.get()) world.setBlock(pos, PFBlocks.COELOPHYSIS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.DESMATOSUCHUS_EGG.get()) world.setBlock(pos, PFBlocks.DESMATOSUCHUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.PLACERIAS_EGG.get()) world.setBlock(pos, PFBlocks.PLACERIAS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.POPOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.POPOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.POSTOSUCHUS_EGG.get()) world.setBlock(pos, PFBlocks.POSTOSUCHUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.TRILOPHOSAURUS_EGG.get()) world.setBlock(pos, PFBlocks.TRILOPHOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.TYPOTHORAX_EGG.get()) world.setBlock(pos, PFBlocks.TYPOTHORAX_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.CHROMOGISAURUS_EGG.get()) world.setBlock(pos, PFBlocks.CHROMOGISAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.EXAERETODON_EGG.get()) world.setBlock(pos, PFBlocks.EXAERETODON_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.HERRERASAURUS_EGG.get()) world.setBlock(pos, PFBlocks.HERRERASAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.HYPERODAPEDON_EGG.get()) world.setBlock(pos, PFBlocks.HYPERODAPEDON_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.ISCHIGUALASTIA_EGG.get()) world.setBlock(pos, PFBlocks.ISCHIGUALASTIA_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.SAUROSUCHUS_EGG.get()) world.setBlock(pos, PFBlocks.SAUROSUCHUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		if (heldItem == PFItems.SILLOSUCHUS_EGG.get()) world.setBlock(pos, PFBlocks.SILLOSUCHUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
		return InteractionResult.PASS;
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.isFaceSturdy(worldIn, pos, Direction.UP) && state.getBlock() != Blocks.MAGMA_BLOCK && state.getBlock() != this;
	}

}
