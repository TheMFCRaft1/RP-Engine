
package com.themfcraft.rpengine.block;

public class AvocadoTreeStairsBlock extends StairsBlock {
	public AvocadoTreeStairsBlock() {
		super(() -> Blocks.AIR.getDefaultState(), Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 2f));
	}

	@Override
	public float getExplosionResistance() {
		return 2f;
	}

	@Override
	public boolean ticksRandomly(BlockState state) {
		return false;
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 5;
	}
}