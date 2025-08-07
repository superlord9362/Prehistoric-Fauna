package superlord.prehistoricfauna.common.blocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.vehicle.MinecartTNT;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.common.entity.BurrowingDinosaur;
import superlord.prehistoricfauna.common.entity.block.BurrowBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class BurrowBlock extends BaseEntityBlock {
	@SuppressWarnings("unused")
	private static final float AABB_OFFSET = 1.0F;
	private static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;
	private static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), (p_153923_) -> {
		p_153923_.put(Direction.NORTH, NORTH_AABB);
		p_153923_.put(Direction.EAST, EAST_AABB);
		p_153923_.put(Direction.SOUTH, SOUTH_AABB);
		p_153923_.put(Direction.WEST, WEST_AABB);
		p_153923_.put(Direction.UP, UP_AABB);
		p_153923_.put(Direction.DOWN, DOWN_AABB);
	});
	protected static final Direction[] DIRECTIONS = Direction.values();
	private final ImmutableMap<BlockState, VoxelShape> shapesCache;
	private final boolean canRotate;
	private final boolean canMirrorX;
	private final boolean canMirrorZ;

	public BurrowBlock(BlockBehaviour.Properties p_153822_) {
		super(p_153822_);
		this.registerDefaultState(getDefaultMultifaceState(this.stateDefinition));
		this.shapesCache = this.getShapeForEachState(BurrowBlock::calculateMultifaceShape);
		this.canRotate = Direction.Plane.HORIZONTAL.stream().allMatch(this::isFaceSupported);
		this.canMirrorX = Direction.Plane.HORIZONTAL.stream().filter(Direction.Axis.X).filter(this::isFaceSupported).count() % 2L == 0L;
		this.canMirrorZ = Direction.Plane.HORIZONTAL.stream().filter(Direction.Axis.Z).filter(this::isFaceSupported).count() % 2L == 0L;
	}

	public static Set<Direction> availableFaces(BlockState p_221585_) {
		if (!(p_221585_.getBlock() instanceof MultifaceBlock)) {
			return Set.of();
		} else {
			Set<Direction> set = EnumSet.noneOf(Direction.class);

			for(Direction direction : Direction.values()) {
				if (hasFace(p_221585_, direction)) {
					set.add(direction);
				}
			}

			return set;
		}
	}

	public static Set<Direction> unpack(byte p_221570_) {
		Set<Direction> set = EnumSet.noneOf(Direction.class);

		for(Direction direction : Direction.values()) {
			if ((p_221570_ & (byte)(1 << direction.ordinal())) > 0) {
				set.add(direction);
			}
		}

		return set;
	}

	public static byte pack(Collection<Direction> p_221577_) {
		byte b0 = 0;

		for(Direction direction : p_221577_) {
			b0 = (byte)(b0 | 1 << direction.ordinal());
		}

		return b0;
	}

	protected boolean isFaceSupported(Direction p_153921_) {
		return true;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153917_) {
		for(Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				p_153917_.add(getFaceProperty(direction));
			}
		}

	}

	private void angerNearbyBurrowers(Level p_49650_, BlockPos p_49651_) {
		List<BurrowingDinosaur> list = p_49650_.getEntitiesOfClass(BurrowingDinosaur.class, (new AABB(p_49651_)).inflate(8.0D, 6.0D, 8.0D));
		if (!list.isEmpty()) {
			List<Player> list1 = p_49650_.getEntitiesOfClass(Player.class, (new AABB(p_49651_)).inflate(8.0D, 6.0D, 8.0D));
			if (list1.isEmpty()) return; //Forge: Prevent Error when no players are around.
			int i = list1.size();

			for(BurrowingDinosaur burrower : list) {
				if (burrower.getTarget() == null && burrower.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
					burrower.setTarget(list1.get(p_49650_.random.nextInt(i)));
				}
			}
		}

	}

	public BlockState updateShape(BlockState p_153904_, Direction p_153905_, BlockState p_153906_, LevelAccessor p_153907_, BlockPos p_153908_, BlockPos p_153909_) {
		if (!this.canSurvive(p_153904_, p_153907_, p_153908_)) {
			BlockEntity blockentity = p_153907_.getBlockEntity(p_153908_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_153904_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
			return Blocks.AIR.defaultBlockState();
		}
		if (p_153907_.getBlockState(p_153909_).getBlock() instanceof FireBlock || !this.canSurvive(p_153906_, p_153907_, p_153909_)) {
			BlockEntity blockentity = p_153907_.getBlockEntity(p_153908_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_153904_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
		}
		if (!hasAnyFace(p_153904_)) {
			BlockEntity blockentity = p_153907_.getBlockEntity(p_153908_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_153904_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
			return Blocks.AIR.defaultBlockState();
		} else {
			BlockEntity blockentity = p_153907_.getBlockEntity(p_153908_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_153904_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
			return hasFace(p_153904_, p_153905_) && !canAttachTo(p_153907_, p_153905_, p_153909_, p_153906_) ? removeFace(p_153904_, getFaceProperty(p_153905_)) : p_153904_;
		}
	}

	public VoxelShape getShape(BlockState p_153851_, BlockGetter p_153852_, BlockPos p_153853_, CollisionContext p_153854_) {
		return this.shapesCache.get(p_153851_);
	}

	public boolean canSurvive(BlockState p_153888_, LevelReader p_153889_, BlockPos p_153890_) {
		boolean flag = false;

		for(Direction direction : DIRECTIONS) {
			if (hasFace(p_153888_, direction)) {
				BlockPos blockpos = p_153890_.relative(direction);
				if (!canAttachTo(p_153889_, direction, blockpos, p_153889_.getBlockState(blockpos))) {
					BlockEntity blockentity = p_153889_.getBlockEntity(p_153890_);
					if (blockentity instanceof BurrowBlockEntity) {
						BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
						burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_153888_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
					}
					return false;
				}

				flag = true;
			}
		}
		if (!flag) {
			BlockEntity blockentity = p_153889_.getBlockEntity(p_153890_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_153888_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
		}
		System.out.println("Can survive: " + flag);
		return flag;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_153824_) {
		Level level = p_153824_.getLevel();
		BlockPos blockpos = p_153824_.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		return Arrays.stream(p_153824_.getNearestLookingDirections()).map((p_153865_) -> {
			return this.getStateForPlacement(blockstate, level, blockpos, p_153865_);
		}).filter(Objects::nonNull).findFirst().orElse((BlockState)null);
	}

	public boolean isValidStateForPlacement(BlockGetter p_221572_, BlockState p_221573_, BlockPos p_221574_, Direction p_221575_) {
		if (this.isFaceSupported(p_221575_) && (!p_221573_.is(this) || !hasFace(p_221573_, p_221575_))) {
			BlockPos blockpos = p_221574_.relative(p_221575_);
			return canAttachTo(p_221572_, p_221575_, blockpos, p_221572_.getBlockState(blockpos));
		} else {
			BlockEntity blockentity = p_221572_.getBlockEntity(p_221574_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_221573_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
			return false;
		}
	}

	@Nullable
	public BlockState getStateForPlacement(BlockState p_153941_, BlockGetter p_153942_, BlockPos p_153943_, Direction p_153944_) {
		if (!this.isValidStateForPlacement(p_153942_, p_153941_, p_153943_, p_153944_)) {
			return null;
		} else {
			BlockState blockstate;
			if (p_153941_.is(this)) {
				blockstate = p_153941_;
			} else {
				blockstate = this.defaultBlockState();
			}

			return blockstate.setValue(getFaceProperty(p_153944_), Boolean.valueOf(true));
		}
	}

	public BlockState rotate(BlockState p_153895_, Rotation p_153896_) {
		return !this.canRotate ? p_153895_ : this.mapDirections(p_153895_, p_153896_::rotate);
	}

	public BlockState mirror(BlockState p_153892_, Mirror p_153893_) {
		if (p_153893_ == Mirror.FRONT_BACK && !this.canMirrorX) {
			return p_153892_;
		} else {
			return p_153893_ == Mirror.LEFT_RIGHT && !this.canMirrorZ ? p_153892_ : this.mapDirections(p_153892_, p_153893_::mirror);
		}
	}

	private BlockState mapDirections(BlockState p_153911_, Function<Direction, Direction> p_153912_) {
		BlockState blockstate = p_153911_;

		for(Direction direction : DIRECTIONS) {
			if (this.isFaceSupported(direction)) {
				blockstate = blockstate.setValue(getFaceProperty(p_153912_.apply(direction)), p_153911_.getValue(getFaceProperty(direction)));
			}
		}

		return blockstate;
	}

	public static boolean hasFace(BlockState p_153901_, Direction p_153902_) {
		BooleanProperty booleanproperty = getFaceProperty(p_153902_);
		return p_153901_.hasProperty(booleanproperty) && p_153901_.getValue(booleanproperty);
	}

	public static boolean canAttachTo(BlockGetter p_153830_, Direction p_153831_, BlockPos p_153832_, BlockState p_153833_) {
		return (Block.isFaceFull(p_153833_.getBlockSupportShape(p_153830_, p_153832_), p_153831_.getOpposite()) || Block.isFaceFull(p_153833_.getCollisionShape(p_153830_, p_153832_), p_153831_.getOpposite()));
	}

	private static BlockState removeFace(BlockState p_153898_, BooleanProperty p_153899_) {
		BlockState blockstate = p_153898_.setValue(p_153899_, Boolean.valueOf(false));
		if (hasAnyFace(blockstate)) return blockstate;
		else  {
			return Blocks.AIR.defaultBlockState();			
		}
	}

	public static BooleanProperty getFaceProperty(Direction p_153934_) {
		return PROPERTY_BY_DIRECTION.get(p_153934_);
	}

	private static BlockState getDefaultMultifaceState(StateDefinition<Block, BlockState> p_153919_) {
		BlockState blockstate = p_153919_.any();

		for(BooleanProperty booleanproperty : PROPERTY_BY_DIRECTION.values()) {
			if (blockstate.hasProperty(booleanproperty)) {
				blockstate = blockstate.setValue(booleanproperty, Boolean.valueOf(false));
			}
		}

		return blockstate;
	}

	public void playerDestroy(Level p_49584_, Player p_49585_, BlockPos p_49586_, BlockState p_49587_, @Nullable BlockEntity p_49588_, ItemStack p_49589_) {
		super.playerDestroy(p_49584_, p_49585_, p_49586_, p_49587_, p_49588_, p_49589_);
		if (!p_49584_.isClientSide && p_49588_ instanceof BurrowBlockEntity burrowblockentity) {
			burrowblockentity.emptyAllLivingFromBurrow(p_49585_, p_49587_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			p_49584_.updateNeighbourForOutputSignal(p_49586_, this);
			this.angerNearbyBurrowers(p_49584_, p_49586_);
		}

	}


	private static VoxelShape calculateMultifaceShape(BlockState p_153959_) {
		VoxelShape voxelshape = Shapes.empty();

		for(Direction direction : DIRECTIONS) {
			if (hasFace(p_153959_, direction)) {
				voxelshape = Shapes.or(voxelshape, SHAPE_BY_DIRECTION.get(direction));
			}
		}

		return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
	}

	protected static boolean hasAnyFace(BlockState p_153961_) {
		return Arrays.stream(DIRECTIONS).anyMatch((p_221583_) -> {
			return hasFace(p_153961_, p_221583_);
		});
	}

	public RenderShape getRenderShape(BlockState p_49653_) {
		return RenderShape.MODEL;
	}

	@Nullable
	public BlockEntity newBlockEntity(BlockPos p_152184_, BlockState p_152185_) {
		return new BurrowBlockEntity(p_152184_, p_152185_);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
		return p_152180_.isClientSide ? null : createTickerHelper(p_152182_, PFBlockEntities.BURROW.get(), BurrowBlockEntity::serverTick);
	}

	public void playerWillDestroy(Level p_49608_, BlockPos p_49609_, BlockState p_49610_, Player p_49611_) {
		if (!p_49608_.isClientSide && p_49611_.isCreative() && p_49608_.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
			BlockEntity blockentity = p_49608_.getBlockEntity(p_49609_);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				ItemStack itemstack = new ItemStack(this);
				boolean flag = !burrowblockentity.isEmpty();
				if (flag) {
					if (flag) {
						CompoundTag compoundtag = new CompoundTag();
						compoundtag.put("Burrowers", burrowblockentity.writeBurrowers());
						BlockItem.setBlockEntityData(itemstack, PFBlockEntities.BURROW.get(), compoundtag);
					}
					CompoundTag compoundtag1 = new CompoundTag();
					itemstack.addTagElement("BlockStateTag", compoundtag1);
					ItemEntity itementity = new ItemEntity(p_49608_, (double)p_49609_.getX(), (double)p_49609_.getY(), (double)p_49609_.getZ(), itemstack);
					itementity.setDefaultPickUpDelay();
					p_49608_.addFreshEntity(itementity);
				}
			}
		}

		super.playerWillDestroy(p_49608_, p_49609_, p_49610_, p_49611_);
	}

	@SuppressWarnings("deprecation")
	public List<ItemStack> getDrops(BlockState p_49636_, LootParams.Builder p_287581_) {
		Entity entity = p_287581_.getOptionalParameter(LootContextParams.THIS_ENTITY);
		if (entity instanceof PrimedTnt || entity instanceof Creeper || entity instanceof WitherSkull || entity instanceof WitherBoss || entity instanceof MinecartTNT) {
			BlockEntity blockentity = p_287581_.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
			if (blockentity instanceof BurrowBlockEntity) {
				BurrowBlockEntity burrowblockentity = (BurrowBlockEntity)blockentity;
				burrowblockentity.emptyAllLivingFromBurrow((Player)null, p_49636_, BurrowBlockEntity.BurrowerReleaseStatus.EMERGENCY);
			}
		}

		return super.getDrops(p_49636_, p_287581_);
	}

}
