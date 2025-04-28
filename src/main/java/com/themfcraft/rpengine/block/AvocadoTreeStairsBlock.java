
package com.themfcraft.rpengine.block;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

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
