/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.block.Block;

import com.themfcraft.rpengine.block.IdCardMakerBlock;
import com.themfcraft.rpengine.block.AvocadotreesaplingBlock;
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
	public static final RegistryObject<Block> AVOCADO_TREE_WOOD = REGISTRY.register("avocado_tree_wood", () -> new AvocadoTreeWoodBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_LOG = REGISTRY.register("avocado_tree_log", () -> new AvocadoTreeLogBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_PLANKS = REGISTRY.register("avocado_tree_planks", () -> new AvocadoTreePlanksBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_LEAVES = REGISTRY.register("avocado_tree_leaves", () -> new AvocadoTreeLeavesBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_STAIRS = REGISTRY.register("avocado_tree_stairs", () -> new AvocadoTreeStairsBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_SLAB = REGISTRY.register("avocado_tree_slab", () -> new AvocadoTreeSlabBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_FENCE = REGISTRY.register("avocado_tree_fence", () -> new AvocadoTreeFenceBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_FENCE_GATE = REGISTRY.register("avocado_tree_fence_gate", () -> new AvocadoTreeFenceGateBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_PRESSURE_PLATE = REGISTRY.register("avocado_tree_pressure_plate", () -> new AvocadoTreePressurePlateBlock());
	public static final RegistryObject<Block> AVOCADO_TREE_BUTTON = REGISTRY.register("avocado_tree_button", () -> new AvocadoTreeButtonBlock());
	public static final RegistryObject<Block> AVOCADOTREESAPLING = REGISTRY.register("avocadotreesapling", () -> new AvocadotreesaplingBlock());
	public static final RegistryObject<Block> ID_CARD_MAKER = REGISTRY.register("id_card_maker", () -> new IdCardMakerBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			AvocadotreesaplingBlock.registerRenderLayer();
		}
	}
}
