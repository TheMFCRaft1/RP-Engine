
package com.themfcraft.rpengine.item;

import java.util.List;

public class AvocadoItem extends Item {
	public AvocadoItem() {
		super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		list.add(new StringTextComponent(""));
	}
}
