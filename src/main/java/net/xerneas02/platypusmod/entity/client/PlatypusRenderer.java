package net.xerneas02.platypusmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.xerneas02.platypusmod.PlatypusMod;
import net.xerneas02.platypusmod.entity.custom.PlatypusEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PlatypusRenderer extends GeoEntityRenderer<PlatypusEntity> {

    public PlatypusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PlatypusModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(PlatypusEntity animatable) {
        return new ResourceLocation(PlatypusMod.MODID_ID, "textures/entity/platypus.png");
    }

    @Override
    public RenderType getRenderType(PlatypusEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        if (animatable.isBaby()){
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
