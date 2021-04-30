package superlord.prehistoricfauna.world.feature.cretaceous;

public class DidelphodonBurrowFeature { /** extends Feature<DidelphodonBurrowConfig> {
   public DidelphodonBurrowFeature(Function<Dynamic<?>, ? extends DidelphodonBurrowConfig> func) {
      super(func);
   }

   @Override
   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, DidelphodonBurrowConfig config) {
	   int i = 0;
	   for(int j = 0; j < config.count; ++j) {
		   int k = rand.nextInt(8) - rand.nextInt(8);
		   int l = rand.nextInt(8) - rand.nextInt(8);
		   int i1 = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + k, pos.getZ() + l);
		   BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
		   if (worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.COARSE_DIRT || worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.PODZOL || worldIn.getBlockState(blockpos).getBlock() == Blocks.AIR && worldIn.getBlockState(blockpos.down()).getBlock() == BlockInit.MOSSY_DIRT) {
			   BlockState blockstate = BlockInit.DIDELPHODON_BURROW.getDefaultState();
			   if (blockstate.isValidPosition(worldIn, blockpos)) {
				   worldIn.setBlockState(blockpos.down(), blockstate, 2);
				   DidelphodonBurrowTileEntity didelphodonburrowtileentity = new DidelphodonBurrowTileEntity();
				   int j1 = 1 + rand.nextInt(2);
				   for (int k1 = 0; k1 < j1; ++k1) {
					   DidelphodonEntity didelphodonentity = new DidelphodonEntity(ModEntityTypes.DIDELPHODON_ENTITY, worldIn.getWorld());
					   didelphodonburrowtileentity.tryEnterBurrow(didelphodonentity, rand.nextInt(599));
				   }
			   }
			   ++i;
		   }
	   }
	   return i > 0;
   }
*/
}