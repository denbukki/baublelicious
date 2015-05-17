package com.baublelicious.items;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;

public class ItemBelt extends ItemBaubles {
  public ItemBelt() {
    setUnlocalizedName("ItemBelt");
  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    return BaubleType.BELT;
  }

}
