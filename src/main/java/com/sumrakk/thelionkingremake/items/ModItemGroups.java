package com.sumrakk.thelionkingremake.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
    public static final ItemGroup THE_LION_KING_REMAKE = new ItemGroup("thelionkingremake") {
        private ItemStack cachedIcon = null;
        @Override
        public ItemStack createIcon() {
            if (cachedIcon == null) {
                if (ModItems.LOGO != null && ModItems.LOGO.isPresent()) {
                    cachedIcon = new ItemStack(ModItems.LOGO.get());
                } else {
                    cachedIcon = new ItemStack(net.minecraft.item.Items.APPLE);
                }
            }
            return cachedIcon;
        }
    };
}
