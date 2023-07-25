package net.xerneas02.platypusmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.xerneas02.platypusmod.PlatypusMod;
import net.xerneas02.platypusmod.entity.ModEntity;
import net.xerneas02.platypusmod.entity.custom.PlatypusEntity;
import net.xerneas02.platypusmod.entity.custom.SnailEntity;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = PlatypusMod.MODID_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntity.PLATYPUS.get(), PlatypusEntity.setAttributes());
            event.put(ModEntity.SNAIL.get(), SnailEntity.setAttributes());
        }

    }
}
