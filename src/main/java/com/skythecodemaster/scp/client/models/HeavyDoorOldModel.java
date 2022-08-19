package com.skythecodemaster.scp.client.models;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.HeavyDoorOldBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeavyDoorOldModel extends AnimatedGeoModel<HeavyDoorOldBlockEntity> {
  @Override
  public ResourceLocation getModelLocation(HeavyDoorOldBlockEntity object) {
    return new ResourceLocation(SkySCPMod.MOD_ID, "geo/scp_heavy_door_old.geo.json");
  }
  
  @Override
  public ResourceLocation getTextureLocation(HeavyDoorOldBlockEntity object) {
    return new ResourceLocation(SkySCPMod.MOD_ID, "textures/block/scp_heavy_door_old.png");
  }
  
  @Override
  public ResourceLocation getAnimationFileLocation(HeavyDoorOldBlockEntity animatable) {
    return new ResourceLocation(SkySCPMod.MOD_ID, "animations/scp_heavy_door_old.animation.json");
  }
}