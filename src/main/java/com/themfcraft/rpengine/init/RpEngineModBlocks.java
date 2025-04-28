/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import com.themfcraft.rpengine.block.AvocadoTreeWoodBlock;
import com.themfcraft.rpengine.block.AvocadoTreeStairsBlock;
import com.themfcraft.rpengine.block.AvocadoTreeSlabBlock;
import com.themfcraft.rpengine.block.AvocadoTreePressurePlateBlock;
import com.themfcraft.rpengine.block.AvocadoTreePlanksBlock;
import com.themfcraft.rpengine.block.AvocadoTreeLogBlock;
import com.themfcraft.rpengine.block.AvocadoTreeLeavesBlock;
import com.themfcraft.rpengine.block.AvocadoTreeFenceGateBlock;
import com.themfcraft.rpengine.block.AvocadoTreeFenceBlock;
import com.themfcraft.rpengine.block.AvocadoTreeButtonBlock;
import com.themfcraft.rpengine.RpEngineMod;

public class RpEngineModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RpEngineMod.MODID);
	public static final RegistryObject<Block> AVOCADO_TREE_PRESSURE_PLATE = REGISTRY.register("avocado_tree_pressure_plate", () -> new AvocadoTreePressurePlateBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_STAIRS = REGISTRY.register("avocado_tree_stairs", () -> new AvocadoTreeStairsBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_FENCE = REGISTRY.register("avocado_tree_fence", () -> new AvocadoTreeFenceBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_PLANKS = REGISTRY.register("avocado_tree_planks", () -> new AvocadoTreePlanksBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_SLAB = REGISTRY.register("avocado_tree_slab", () -> new AvocadoTreeSlabBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_BUTTON = REGISTRY.register("avocado_tree_button", () -> new AvocadoTreeButtonBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_LOG = REGISTRY.register("avocado_tree_log", () -> new AvocadoTreeLogBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_LEAVES = REGISTRY.register("avocado_tree_leaves", () -> new AvocadoTreeLeavesBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_FENCE_GATE = REGISTRY.register("avocado_tree_fence_gate", () -> new AvocadoTreeFenceGateBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_WOOD = REGISTRY.register("avocado_tree_wood", () -> new AvocadoTreeWoodBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
