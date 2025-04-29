
package com.themfcraft.rpengine.block;

public class AvocadoTreeLeavesBlock extends LeavesBlock {
	public AvocadoTreeLeavesBlock() {
		super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2f).notSolid());
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 30;
	}
}