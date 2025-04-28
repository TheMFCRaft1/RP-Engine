
package com.themfcraft.rpengine.block;

public class AvocadoTreeSlabBlock extends SlabBlock {
	public AvocadoTreeSlabBlock() {
		super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f));
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 5;
	}
}