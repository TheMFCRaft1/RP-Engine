
package com.themfcraft.rpengine.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import com.themfcraft.rpengine.init.RpEngineModTabs;

public abstract class PoliceUniformArmorItem extends ArmorItem {
	public PoliceUniformArmorItem(EquipmentSlotType type, Item.Properties properties) {
		super(new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType type) {
				return new int[]{13, 15, 16, 11}[type.getIndex()] * 15;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType type) {
				return new int[]{2, 5, 6, 2}[type.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return null;
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.LEATHER));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "police_uniform_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Chestplate extends PoliceUniformArmorItem {
		public Chestplate() {
			super(EquipmentSlotType.CHEST, new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "rp_engine:textures/models/armor/policeuniform_layer_1.png";
		}
	}

	public static class Leggings extends PoliceUniformArmorItem {
		public Leggings() {
			super(EquipmentSlotType.LEGS, new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "rp_engine:textures/models/armor/policeuniform_layer_2.png";
		}
	}

	public static class Boots extends PoliceUniformArmorItem {
		public Boots() {
			super(EquipmentSlotType.FEET, new Item.Properties().group(RpEngineModTabs.TAB_RP_ENGINE));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "rp_engine:textures/models/armor/policeuniform_layer_1.png";
		}
	}
}
