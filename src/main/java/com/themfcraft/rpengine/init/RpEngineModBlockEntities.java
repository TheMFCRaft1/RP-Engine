/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;

import java.util.function.Supplier;

import com.themfcraft.rpengine.block.entity.IdCardMakerBlockEntity;
import com.themfcraft.rpengine.RpEngineMod;

public class RpEngineModBlockEntities {
	public static final DeferredRegister<TileEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RpEngineMod.MODID);
	public static final RegistryObject<TileEntityType<?>> ID_CARD_MAKER = register("id_card_maker", RpEngineModBlocks.ID_CARD_MAKER, IdCardMakerBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<TileEntityType<?>> register(String registryname, RegistryObject<Block> block, Supplier<? extends TileEntity> supplier) {
		return REGISTRY.register(registryname, () -> TileEntityType.Builder.create(supplier, block.get()).build(null));
	}
}
