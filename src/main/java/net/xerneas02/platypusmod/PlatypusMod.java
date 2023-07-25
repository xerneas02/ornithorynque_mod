package net.xerneas02.platypusmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xerneas02.platypusmod.block.ModBlocks;
import net.xerneas02.platypusmod.entity.ModEntity;
import net.xerneas02.platypusmod.entity.client.PlatypusRenderer;
import net.xerneas02.platypusmod.entity.client.SnailRenderer;
import net.xerneas02.platypusmod.entity.custom.PlatypusEntity;
import net.xerneas02.platypusmod.entity.custom.SnailEntity;
import net.xerneas02.platypusmod.item.ModItems;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PlatypusMod.MODID_ID)
public class PlatypusMod
{
    public static final String MODID_ID = "platypusmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public PlatypusMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        GeckoLib.initialize();
        ModEntity.register(modEventBus);




        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntity.PLATYPUS.get(),
                    SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    PlatypusEntity::checkPlatypusSpawnRules);
            SpawnPlacements.register(ModEntity.SNAIL.get(),
                    SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    SnailEntity::checkSnailSpawnRules);
        });
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            EntityRenderers.register(ModEntity.PLATYPUS.get(), PlatypusRenderer::new);
            EntityRenderers.register(ModEntity.SNAIL.get(), SnailRenderer::new);
        }
    }
}
