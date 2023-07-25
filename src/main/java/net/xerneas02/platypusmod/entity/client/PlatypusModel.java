package net.xerneas02.platypusmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.xerneas02.platypusmod.PlatypusMod;
import net.xerneas02.platypusmod.entity.custom.PlatypusEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlatypusModel extends AnimatedGeoModel<PlatypusEntity> {
    @Override
    public ResourceLocation getModelResource(PlatypusEntity object) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "geo/platypus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlatypusEntity object) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "textures/entity/platypus.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlatypusEntity animatable) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "animations/platypus.animation.json");
    }
}
