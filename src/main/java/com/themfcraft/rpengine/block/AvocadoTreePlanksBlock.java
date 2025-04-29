
package com.themfcraft.rpengine.block;

public class AvocadoTreePlanksBlock extends Block {
	public AvocadoTreePlanksBlock() {
		super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).harvestLevel(0).harvestTool(ToolType.AXE));
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 5;
	}
}