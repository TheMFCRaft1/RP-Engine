/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.themfcraft.rpengine.init;

public class RpEngineModTabs {
	public static ItemGroup TAB_RP_FOOD;

	public static void load() {
		TAB_RP_FOOD = new ItemGroup("tab_rp_food") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.COOKIE);
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
