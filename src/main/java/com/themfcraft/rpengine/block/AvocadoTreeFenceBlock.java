
package com.themfcraft.rpengine.block;

public class AvocadoTreeFenceBlock extends FenceBlock {
	public AvocadoTreeFenceBlock() {
		super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f));
	}

	@Override
	public boolean canConnect(BlockState state, boolean checkattach, Direction face) {
		boolean flag = state.getBlock() instanceof FenceBlock && state.getMaterial() == this.material;
		boolean flag1 = state.getBlock() instanceof FenceGateBlock && FenceGateBlock.isParallel(state, face);
		return !cannotAttach(state.getBlock()) && checkattach || flag || flag1;
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 5;
	}
}