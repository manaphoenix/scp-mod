package com.skythecodemaster.scp.client.renderers;

import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.client.models.LightDoorOldModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class LightDoorOldRenderer extends GeoBlockRenderer<LightDoorOldBlockEntity> {
  public LightDoorOldRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    super(rendererDispatcherIn, new LightDoorOldModel());
  }
}
