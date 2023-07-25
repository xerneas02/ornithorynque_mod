package net.xerneas02.platypusmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xerneas02.platypusmod.PlatypusMod;
import net.xerneas02.platypusmod.entity.ModEntity;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PlatypusMod.MODID_ID);

    public static final RegistryObject<Item> SNAIL = ITEMS.register("snail", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PLATYPUS_TAB).stacksTo(16)));
    public static final RegistryObject<Item> PLATYPUS_EGG = ITEMS.register("platypus_egg", () -> new PlatypusEggItem(new Item.Properties().tab(ModCreativeModeTab.PLATYPUS_TAB).stacksTo(16)));
    public static final RegistryObject<Item> PLATYPUS_BUCKET = ITEMS.register("platypus_bucket", () -> new MobBucketItem(ModEntity.PLATYPUS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_AXOLOTL,new Item.Properties().tab(ModCreativeModeTab.PLATYPUS_TAB).stacksTo(1)));
    public static final RegistryObject<Item> PLATYPUS_SPAWN_EGG = ITEMS.register("platypus_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.PLATYPUS , 0x713F1B, 0x3F3F3F, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.SNAIL , 0x965700, 0x547200, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public  static  void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
