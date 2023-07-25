package net.xerneas02.platypusmod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xerneas02.platypusmod.PlatypusMod;
import net.xerneas02.platypusmod.entity.custom.PlatypusEggEntity;
import net.xerneas02.platypusmod.entity.custom.PlatypusEntity;
import net.xerneas02.platypusmod.entity.custom.SnailEntity;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PlatypusMod.MODID_ID);

    public static  final RegistryObject<EntityType<PlatypusEntity>> PLATYPUS =
            ENTITY_TYPES.register("platypus",
                    () -> EntityType.Builder.of(PlatypusEntity::new, MobCategory.AMBIENT)
                            .sized(1.0f, 0.5f)
                            .build(new ResourceLocation(PlatypusMod.MODID_ID, "platypus").toString()));

    public static final RegistryObject<EntityType<PlatypusEggEntity>> PLATYPUS_EGG =
            ENTITY_TYPES.register("platypus_egg",
                    () -> registerEntity(EntityType.Builder.of(PlatypusEggEntity::new, MobCategory.MISC)
                            .sized(0.3F, 0.3F)
                            .fireImmune(), "platypus_egg"));

    public static  final RegistryObject<EntityType<SnailEntity>> SNAIL =
            ENTITY_TYPES.register("snail",
                    () -> EntityType.Builder.of(SnailEntity::new, MobCategory.AMBIENT)
                            .sized(0.3f, 0.3f)
                            .build(new ResourceLocation(PlatypusMod.MODID_ID, "snail").toString()));

    private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        return (EntityType) builder.build(entityName);
    }

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
