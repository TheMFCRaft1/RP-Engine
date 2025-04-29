
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;

import com.themfcraft.rpengine.item.TenDollarBillItem;
import com.themfcraft.rpengine.item.SyringeItem;
import com.themfcraft.rpengine.item.SmartphoneItem;
import com.themfcraft.rpengine.item.PoliceUniformArmorItem;
import com.themfcraft.rpengine.item.OneDollarBillItem;
import com.themfcraft.rpengine.item.MedKitItem;
import com.themfcraft.rpengine.item.IronCoinItem;
import com.themfcraft.rpengine.item.GoldenCoinItem;
import com.themfcraft.rpengine.item.FiveDollarBillItem;
import com.themfcraft.rpengine.item.FireDeparmentPortableAlarmItem;
import com.themfcraft.rpengine.item.FiftieDollarBillItem;
import com.themfcraft.rpengine.item.CopperCoinItem;
import com.themfcraft.rpengine.item.BatonItem;
import com.themfcraft.rpengine.item.AvocadoSeedItem;
import com.themfcraft.rpengine.item.AvocadoItem;
import com.themfcraft.rpengine.RpEngineMod;

public class RpEngineModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RpEngineMod.MODID);
	public static final RegistryObject<Item> SMARTPHONE = REGISTRY.register("smartphone", () -> new SmartphoneItem());
	public static final RegistryObject<Item> COPPER_COIN = REGISTRY.register("copper_coin", () -> new CopperCoinItem());
	public static final RegistryObject<Item> IRON_COIN = REGISTRY.register("iron_coin", () -> new IronCoinItem());
	public static final RegistryObject<Item> GOLDEN_COIN = REGISTRY.register("golden_coin", () -> new GoldenCoinItem());
	public static final RegistryObject<Item> ONE_DOLLAR_BILL = REGISTRY.register("one_dollar_bill", () -> new OneDollarBillItem());
	public static final RegistryObject<Item> FIVE_DOLLAR_BILL = REGISTRY.register("five_dollar_bill", () -> new FiveDollarBillItem());
	public static final RegistryObject<Item> TEN_DOLLAR_BILL = REGISTRY.register("ten_dollar_bill", () -> new TenDollarBillItem());
	public static final RegistryObject<Item> FIFTIE_DOLLAR_BILL = REGISTRY.register("fiftie_dollar_bill", () -> new FiftieDollarBillItem());
	public static final RegistryObject<Item> BATON = REGISTRY.register("baton", () -> new BatonItem());
	public static final RegistryObject<Item> MED_KIT = REGISTRY.register("med_kit", () -> new MedKitItem());
	public static final RegistryObject<Item> SYRINGE = REGISTRY.register("syringe", () -> new SyringeItem());
	public static final RegistryObject<Item> FIRE_DEPARMENT_PORTABLE_ALARM = REGISTRY.register("fire_deparment_portable_alarm", () -> new FireDeparmentPortableAlarmItem());
	public static final RegistryObject<Item> AVOCADO = REGISTRY.register("avocado", () -> new AvocadoItem());
	public static final RegistryObject<Item> POLICE_UNIFORM_ARMOR_CHESTPLATE = REGISTRY.register("police_uniform_armor_chestplate", () -> new PoliceUniformArmorItem.Chestplate());
	public static final RegistryObject<Item> POLICE_UNIFORM_ARMOR_LEGGINGS = REGISTRY.register("police_uniform_armor_leggings", () -> new PoliceUniformArmorItem.Leggings());
	public static final RegistryObject<Item> POLICE_UNIFORM_ARMOR_BOOTS = REGISTRY.register("police_uniform_armor_boots", () -> new PoliceUniformArmorItem.Boots());
	public static final RegistryObject<Item> AVOCADO_TREE_WOOD = block(RpEngineModBlocks.AVOCADO_TREE_WOOD, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_LOG = block(RpEngineModBlocks.AVOCADO_TREE_LOG, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_PLANKS = block(RpEngineModBlocks.AVOCADO_TREE_PLANKS, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_LEAVES = block(RpEngineModBlocks.AVOCADO_TREE_LEAVES, ItemGroup.DECORATIONS);
	public static final RegistryObject<Item> AVOCADO_TREE_STAIRS = block(RpEngineModBlocks.AVOCADO_TREE_STAIRS, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_SLAB = block(RpEngineModBlocks.AVOCADO_TREE_SLAB, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_FENCE = block(RpEngineModBlocks.AVOCADO_TREE_FENCE, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_FENCE_GATE = block(RpEngineModBlocks.AVOCADO_TREE_FENCE_GATE, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_PRESSURE_PLATE = block(RpEngineModBlocks.AVOCADO_TREE_PRESSURE_PLATE, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_TREE_BUTTON = block(RpEngineModBlocks.AVOCADO_TREE_BUTTON, ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Item> AVOCADO_SEED = REGISTRY.register("avocado_seed", () -> new AvocadoSeedItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block, ItemGroup tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().group(tab)));
	}
}
