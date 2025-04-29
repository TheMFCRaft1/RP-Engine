
package com.themfcraft.rpengine.block;

public class AvocadoTreeLogBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

	public AvocadoTreeLogBlock() {
		super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f).harvestLevel(0).harvestTool(ToolType.AXE));
		this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.Y));
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(AXIS);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(AXIS, context.getFace().getAxis());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
			if (state.get(AXIS) == Direction.Axis.X) {
				return state.with(AXIS, Direction.Axis.Z);
			} else if (state.get(AXIS) == Direction.Axis.Z) {
				return state.with(AXIS, Direction.Axis.X);
			}
		}
		return state;
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 5;
	}
}