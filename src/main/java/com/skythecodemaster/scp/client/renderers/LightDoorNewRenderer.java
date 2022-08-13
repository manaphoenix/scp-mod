package com.skythecodemaster.scp.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.skythecodemaster.scp.client.models.LightDoorNewModel;
import com.skythecodemaster.scp.common.blockentities.LightDoorNewBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class LightDoorNewRenderer extends GeoBlockRenderer<LightDoorNewBlockEntity> {
  public LightDoorNewRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    super(rendererDispatcherIn, new LightDoorNewModel());
  }
  
  @Override
  public RenderType getRenderType(LightDoorNewBlockEntity animatable, float partialTicks, PoseStack stack,
                                  MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                  ResourceLocation textureLocation) {
    return RenderType.entitySolid(getTextureLocation(animatable));
  }
}
