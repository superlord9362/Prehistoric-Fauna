package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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
import superlord.prehistoricfauna.init.PFTags;

public class DinosaurEggBlock extends Block {
	public static final int MAX_HATCH_LEVEL = 2;
	public static final int MIN_EGGS = 1;
	public static final int MAX_EGGS = 4;
	private static final VoxelShape ONE_EGG_AABB = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 7.0D, 12.0D);
	private static final VoxelShape MULTIPLE_EGGS_AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 7.0D, 15.0D);
	public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
	public static final IntegerProperty EGGS = BlockStateProperties.EGGS;
	public static final BooleanProperty CITIPATIFIED = BooleanProperty.create("citipatified");
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	public DinosaurEggBlock(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, BlockBehaviour.Properties p_57759_) {
		super(p_57759_);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)).setValue(EGGS, Integer.valueOf(1)));
	}

	public void stepOn(Level p_154857_, BlockPos p_154858_, BlockState p_154859_, Entity p_154860_) {
		this.destroyEgg(p_154857_, p_154859_, p_154858_, p_154860_, 100);
		super.stepOn(p_154857_, p_154858_, p_154859_, p_154860_);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.below());
		return blockstate.isFaceSturdy(worldIn, pos.below(), Direction.UP) && !blockstate.is(PFTags.NESTS) && !state.is(Blocks.WATER);
	}

	public void fallOn(Level p_154845_, BlockState p_154846_, BlockPos p_154847_, Entity p_154848_, float p_154849_) {
		if (!(p_154848_ instanceof Zombie)) {
			this.destroyEgg(p_154845_, p_154846_, p_154847_, p_154848_, 3);
		}

		super.fallOn(p_154845_, p_154846_, p_154847_, p_154848_, p_154849_);
	}

	private void destroyEgg(Level p_154851_, BlockState p_154852_, BlockPos p_154853_, Entity p_154854_, int p_154855_) {
		if (this.canDestroyEgg(p_154851_, p_154854_)) {
			if (!p_154851_.isClientSide && p_154851_.random.nextInt(p_154855_) == 0 && p_154852_.is(Blocks.TURTLE_EGG)) {
				this.decreaseEggs(p_154851_, p_154853_, p_154852_);
			}

		}
	}

	public EntityType<?> getEntityType() {
		return this.entityTypeSupplier.get();
	}

	private void decreaseEggs(Level p_57792_, BlockPos p_57793_, BlockState p_57794_) {
		p_57792_.playSound((Player)null, p_57793_, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + p_57792_.random.nextFloat() * 0.2F);
		int i = p_57794_.getValue(EGGS);
		if (i <= 1) {
			p_57792_.destroyBlock(p_57793_, false);
		} else {
			p_57792_.setBlock(p_57793_, p_57794_.setValue(EGGS, Integer.valueOf(i - 1)), 2);
			p_57792_.levelEvent(2001, p_57793_, Block.getId(p_57794_));
		}

	}

	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		if (this.shouldUpdateHatchLevel(worldIn, state, pos) && onSand(worldIn, pos)) {
			int i = state.getValue(HATCH);
			if (i < 2) {
				worldIn.playSound((Player) null, pos, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS,
						0.7F, 0.9F + rand.nextFloat() * 0.2F);
				worldIn.setBlock(pos, state.setValue(HATCH, Integer.valueOf(i + 1)), 2);
			} else {
				worldIn.playSound((Player) null, pos, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS,
						0.7F, 0.9F + rand.nextFloat() * 0.2F);
				worldIn.removeBlock(pos, false);

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
					dinosaurEntity.moveTo((double) pos.getX() + 0.3D + (double) j * 0.2D,
							(double) pos.getY(), (double) pos.getZ() + 0.3D, 0.0F, 0.0F);
					worldIn.addFreshEntity(dinosaurEntity);
				}
			}
		}
	}

	public static boolean onSand(BlockGetter blockReader, BlockPos pos) {
		return blockReader.getBlockState(pos.below()).getBlock() == Blocks.SAND || blockReader.getBlockState(pos.below()).getBlock() == Blocks.RED_SAND || blockReader.getBlockState(pos.below()).getBlock() == Blocks.COARSE_DIRT || blockReader.getBlockState(pos.below()).getBlock() == Blocks.GRASS_BLOCK || blockReader.getBlockState(pos.below()).getBlock() == Blocks.DIRT || blockReader.getBlockState(pos.below()).getBlock() == PFBlocks.LOAM.get() || blockReader.getBlockState(pos.below()).getBlock() == PFBlocks.PACKED_LOAM.get() || blockReader.getBlockState(pos.below()).getBlock() == PFBlocks.SILT.get() || blockReader.getBlockState(pos.below()).getBlock() == PFBlocks.HARDENED_SILT.get() || blockReader.getBlockState(pos.below()).getBlock() == PFBlocks.MOSSY_DIRT.get() || blockReader.getBlockState(pos.below()).getBlock() == Blocks.PODZOL || blockReader.getBlockState(pos.below()).getBlock() == Blocks.MYCELIUM || blockReader.getBlockState(pos.below()).is(BlockTags.LEAVES);
	}

	public void onPlace(BlockState p_57814_, Level p_57815_, BlockPos p_57816_, BlockState p_57817_, boolean p_57818_) {
		if (onSand(p_57815_, p_57816_) && !p_57815_.isClientSide) {
			p_57815_.levelEvent(2005, p_57816_, 0);
		}

	}

	private boolean shouldUpdateHatchLevel(Level world, BlockState state, BlockPos pos) {
		if (PrehistoricFaunaConfig.eggHeating) {
			long roundTime = world.getDayTime() % 24000;
			boolean night = roundTime >= 13000 && roundTime <= 22000;
			int i = world.getBrightness(LightLayer.SKY, pos);
			int j = world.getBrightness(LightLayer.BLOCK, pos);
			int hardshellDeathTime = 24000;
			int softshellDeathTime = 18000;
			int brightness;
			if (night) {
				brightness = j;
			} else {
				brightness = Math.max(i, j);
			}
			if (brightness < 7) {
				if (PrehistoricFaunaConfig.softShellAndHardShellEggs && state.is(PFTags.SOFT_SHELL_EGG_BLOCKS)) {
					for (int l = softshellDeathTime; l > 0; l--) {
						if (l == 0) {
							world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
						}
					}
				} else {
					for (int l = hardshellDeathTime; l > 0; l--) {
						if (l == 0) {
							world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
						}
					}
				}
			} else {
				boolean citipatified = state.getValue(CITIPATIFIED);
				int regularTime = 24000;
				int citipatifiedTime = 12000;
				Random rand = new Random();
				for (int l = regularTime + rand.nextInt(6000); l>=0; l--) {
					if (l == 0) {
						return true;
					}
				}
				if (citipatified) {
					for (int l = citipatifiedTime + rand.nextInt(6000); l >= 0; l--) {
						if (l == 0) {
							return true;
						}
					}
				}
				return false;
			}
		}
		return false;
	}

	public void playerDestroy(Level p_57771_, Player p_57772_, BlockPos p_57773_, BlockState p_57774_, @Nullable BlockEntity p_57775_, ItemStack p_57776_) {
		super.playerDestroy(p_57771_, p_57772_, p_57773_, p_57774_, p_57775_, p_57776_);
		this.decreaseEggs(p_57771_, p_57773_, p_57774_);
	}

	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(BlockState p_57796_, BlockPlaceContext p_57797_) {
		return !p_57797_.isSecondaryUseActive() && p_57797_.getItemInHand().is(this.asItem()) && p_57796_.getValue(EGGS) < 4 ? true : super.canBeReplaced(p_57796_, p_57797_);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_57761_) {
		BlockState blockstate = p_57761_.getLevel().getBlockState(p_57761_.getClickedPos());
		return blockstate.is(this) ? blockstate.setValue(EGGS, Integer.valueOf(Math.min(4, blockstate.getValue(EGGS) + 1))) : super.getStateForPlacement(p_57761_);
	}

	public VoxelShape getShape(BlockState p_57809_, BlockGetter p_57810_, BlockPos p_57811_, CollisionContext p_57812_) {
		return p_57809_.getValue(EGGS) > 1 ? MULTIPLE_EGGS_AABB : ONE_EGG_AABB;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_57799_) {
		p_57799_.add(HATCH, EGGS, CITIPATIFIED);
	}

	private boolean canDestroyEgg(Level p_57768_, Entity trampler) {
		if (!(trampler.getType() == this.entityTypeSupplier.get())) {
			//|| trampler instanceof CitipatiEntity || trampler instanceof TelmasaurusEntity
			if (!(trampler instanceof LivingEntity)) {
				return false;
			} else {
				return trampler instanceof Player || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(p_57768_, trampler);
			}
		} else {
			return false;
		}
	}

}
