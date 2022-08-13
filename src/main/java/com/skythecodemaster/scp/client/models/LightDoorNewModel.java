package com.skythecodemaster.scp.client.models;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.LightDoorNewBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LightDoorNewModel extends AnimatedGeoModel<LightDoorNewBlockEntity> {
  @Override
  public ResourceLocation getModelLocation(LightDoorNewBlockEntity object) {
    return new ResourceLocation(SkySCPMod.MOD_ID, "geo/scp_light_door_new.geo.json");
  }
  
  @Override
  public ResourceLocation getTextureLocation(LightDoorNewBlockEntity object) {
    return new ResourceLocation(SkySCPMod.MOD_ID, "textures/block/scp_light_door_new.png");
  }
  
  @Override
  public ResourceLocation getAnimationFileLocation(LightDoorNewBlockEntity animatable) {
    return new ResourceLocation(SkySCPMod.MOD_ID, "animations/scp_light_door_new.animation.json");
  }
}