package net.xerneas02.platypusmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.xerneas02.platypusmod.PlatypusMod;
import net.xerneas02.platypusmod.entity.custom.SnailEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnailModel extends AnimatedGeoModel<SnailEntity> {
    @Override
    public ResourceLocation getModelResource(SnailEntity object) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "geo/snail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SnailEntity object) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "textures/entity/snail.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SnailEntity animatable) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "animations/snail.animation.json");
    }
}