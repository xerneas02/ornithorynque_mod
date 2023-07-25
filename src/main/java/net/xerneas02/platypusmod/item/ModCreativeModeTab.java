package net.xerneas02.platypusmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab PLATYPUS_TAB = new CreativeModeTab("platypustab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATYPUS_BUCKET.get());
        }
    };
}
