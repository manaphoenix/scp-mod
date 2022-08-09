package com.skythecodemaster.scp.common.models;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.items.LightDoorOldItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

abstract class LightDoorOldModel extends AnimatedGeoModel<LightDoorOldItem> {
  public ResourceLocation getModelLocation(com.skythecodemaster.scp.common.models.LightDoorOldModel object) {
    return new ResourceLocation(SkySCPMod.MOD_ID,"geo/SCPLightDoorOld.geo.json");
  }
  
  public ResourceLocation getTextureLocation(com.skythecodemaster.scp.common.models.LightDoorOldModel object) {
    return new ResourceLocation(SkySCPMod.MOD_ID,"textures/scp_light_door_old.png");
  }
  
  public ResourceLocation getAnimationFileLocation(com.skythecodemaster.scp.common.models.LightDoorOldModel animatable) {
    return new ResourceLocation(SkySCPMod.MOD_ID,"animations/scp_light_door_old.animation.json");
  }
}