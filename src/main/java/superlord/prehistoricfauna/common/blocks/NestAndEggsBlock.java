package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class NestAndEggsBlock extends Block {
	public static final int MAX_HATCH_LEVEL = 2;
	public static final int MIN_EGGS = 1;
	public static final int MAX_EGGS = 4;
	public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
	public static final IntegerProperty EGGS = BlockStateProperties.EGGS;
	public static final IntegerProperty PLANT_LEVEL = IntegerProperty.create("plant_level", 0, 3);
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;
	protected static final VoxelShape BLOCK = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);

	public NestAndEggsBlock(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, BlockBehaviour.Properties p_57759_) {
		super(p_57759_);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)).setValue(EGGS, Integer.valueOf(1)).setValue(PLANT_LEVEL, Integer.valueOf(0)));
	}

	public int maxPlantFilled() {
		return 3;
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return BLOCK;
	}

	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return BLOCK;
	}

	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		Entity dinosaurEntity = this.entityTypeSupplier.get().create(world);
		ItemStack stack = player.getItemInHand(hand);
		Item heldItem = stack.getItem();
		Random random = new Random();
		int addChance = random.nextInt(5);
		int i = state.getValue(EGGS);
		BlockState filledState = world.getBlockState(pos);
		if ((stack.is(PFTags.PLANTS_2_HUNGER_ITEM) || stack.is(PFTags.PLANTS_4_HUNGER_ITEM) || stack.is(PFTags.PLANTS_6_HUNGER_ITEM) || stack.is(PFTags.PLANTS_8_HUNGER_ITEM) || stack.is(PFTags.PLANTS_10_HUNGER_ITEM) || stack.is(PFTags.PLANTS_12_HUNGER_ITEM) || stack.is(PFTags.PLANTS_15_HUNGER_ITEM) || stack.is(PFTags.PLANTS_20_HUNGER_ITEM) || stack.is(PFTags.PLANTS_25_HUNGER_ITEM) || stack.is(PFTags.PLANTS_30_HUNGER_ITEM)) && addChance == 0 && state.getValue(PLANT_LEVEL) < this.maxPlantFilled()) {
			world.setBlock(pos, state.setValue(PLANT_LEVEL, filledState.getValue(PLANT_LEVEL) + 1), 0);
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		}
		if (!(stack.is(PFTags.EGGS_5_HUNGER) || stack.is(PFTags.EGGS_10_HUNGER) || stack.is(PFTags.EGGS_15_HUNGER))) {
			if (state.getValue(EGGS) > 1) {
				world.setBlock(pos, state.setValue(EGGS, Integer.valueOf(i - 1)), 2);
			} else {
				world.setBlock(pos, PFBlocks.NEST.get().defaultBlockState().setValue(NestBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)), 0);
			}
			if (dinosaurEntity instanceof DinosaurEntity dinosaur) {
				for (Entity parentEntity : world.getEntities(dinosaurEntity, new AABB(pos.getX() - 4, pos.getY() - 4, pos.getZ() - 4, pos.getX() + 4, pos.getY() + 4, pos.getZ() + 4))) {
					if (parentEntity instanceof DinosaurEntity parentDinosaur) {
						if ((parentDinosaur.getAttribute(Attributes.ATTACK_DAMAGE).getValue() != 0 || parentDinosaur.getAttribute(Attributes.ATTACK_DAMAGE) != null) && !parentDinosaur.isBaby() && !parentDinosaur.trusts(player.getUUID())) {
							parentDinosaur.setTarget(player);
						}
					}
				}
				ItemEntity item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dinosaur.getEggItem()));
				world.addFreshEntity(item);
			} else if (dinosaurEntity instanceof Triceratops triceratops) {
				for (Entity parentEntity : world.getEntities(triceratops, new AABB(pos.getX() - 4, pos.getY() - 4, pos.getZ() - 4, pos.getX() + 4, pos.getY() + 4, pos.getZ() + 4))) {
					if (parentEntity instanceof Triceratops parentDinosaur) {
						if (parentDinosaur.getAttribute(Attributes.ATTACK_DAMAGE).getValue() != 0 && !parentDinosaur.isBaby() && !parentDinosaur.trusts(player.getUUID())) {
							parentDinosaur.setTarget(player);
						}
					}
				}
				ItemEntity item = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(PFItems.TRICERATOPS_EGG.get()));
				world.addFreshEntity(item);
			}
		} else {
			if (state.getValue(EGGS) != MAX_EGGS) {
				if (heldItem instanceof BlockItem) {
					BlockItem blockItem = (BlockItem) stack.getItem();
					if (blockItem.getBlock() instanceof DinosaurEggBlock eggBlock) {
						if (eggBlock.getEntityType() == this.entityTypeSupplier.get()) {
							world.setBlock(pos, state.setValue(EGGS, Integer.valueOf(i + 1)), 2);
							if (!player.isCreative()) {
								stack.shrink(1);
							}
						}
					}
				}
			}
		}
		return InteractionResult.PASS;
	}

	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		if (this.shouldUpdateHatchLevel(worldIn, state)) {
			int i = state.getValue(HATCH);
			if (i < 2) {
				worldIn.playSound((Player) null, pos, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + rand.nextFloat() * 0.2F);
				worldIn.setBlock(pos, state.setValue(HATCH, Integer.valueOf(i + 1)), 2);
			} else {
				worldIn.levelEvent(2001, pos, Block.getId(state));
				worldIn.playSound((Player) null, pos, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + rand.nextFloat() * 0.2F);
				BlockState filledState = worldIn.getBlockState(pos);
				worldIn.setBlockAndUpdate(pos, PFBlocks.NEST.get().defaultBlockState().setValue(NestBlock.PLANT_LEVEL, filledState.getValue(PLANT_LEVEL)));

				for (int j = 0; j < state.getValue(EGGS); ++j) {
					worldIn.levelEvent(2001, pos, Block.getId(state));
					Entity dinosaurEntity = this.entityTypeSupplier.get().create(worldIn);
					if (dinosaurEntity instanceof DinosaurEntity) {
						DinosaurEntity dinosaur = (DinosaurEntity)dinosaurEntity;
						for(Player player : dinosaur.level.getEntitiesOfClass(Player.class, dinosaur.getBoundingBox().inflate(8.0D, 8.0D, 8.0D))) {
							dinosaur.addTrustedUUID(player.getUUID());
						}
						if (dinosaur instanceof Camarasaurus) {
							((Animal)dinosaurEntity).setAge(-72000);
						} else if (dinosaur instanceof Tyrannosaurus) {
							((Animal)dinosaurEntity).setAge(-48000);
						} else {
							((Animal)dinosaurEntity).setAge(-24000);
						}
					}
					if (dinosaurEntity instanceof Triceratops) {
						Triceratops dinosaur = (Triceratops)dinosaurEntity;
						for(Player player : dinosaur.level.getEntitiesOfClass(Player.class, dinosaur.getBoundingBox().inflate(8.0D, 8.0D, 8.0D))) {
							dinosaur.addTrustedUUID(player.getUUID());
						}
						((Animal)dinosaurEntity).setAge(-48000);
					}
					dinosaurEntity.moveTo((double) pos.getX() + 0.3D + (double) j * 0.2D, (double) pos.getY(), (double) pos.getZ() + 0.3D, 0.0F, 0.0F);
					worldIn.addFreshEntity(dinosaurEntity);
				}
			}
		}
	}

	private boolean shouldUpdateHatchLevel(Level world, BlockState state) {
		if (PrehistoricFaunaConfig.softShellAndHardShellEggs) {
			if (state.is(PFTags.SOFT_SHELL_EGG_BLOCKS)) {
				if (state.getValue(PLANT_LEVEL) == 1) {
					int regularTime = 7200;
					Random rand = new Random();
					for (int i = regularTime + rand.nextInt(600); i>=0; i--) {
						if (i == 0) {
							return true;
						}
					}
				}
				if (state.getValue(PLANT_LEVEL) == 2) {
					int regularTime = 4800;
					Random rand = new Random();
					for (int i = regularTime + rand.nextInt(600); i>=0; i--) {
						if (i == 0) {
							return true;
						}
					}
				}
				if (state.getValue(PLANT_LEVEL) == 3) {
					int regularTime = 2400;
					Random rand = new Random();
					for (int i = regularTime + rand.nextInt(600); i>=0; i--) {
						if (i == 0) {
							return true;
						}
					}
				}
			} else {
				int regularTime = 2400;
				Random rand = new Random();
				for (int i = regularTime + rand.nextInt(600); i>=0; i--) {
					if (i == 0) {
						return true;
					}
				}
			}
		} else {
			int regularTime = 2400;
			Random rand = new Random();
			for (int i = regularTime + rand.nextInt(600); i>=0; i--) {
				if (i == 0) {
					return true;
				}
			}
		}
		return false;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57799_) {
		p_57799_.add(HATCH, EGGS, PLANT_LEVEL);
	}
}
