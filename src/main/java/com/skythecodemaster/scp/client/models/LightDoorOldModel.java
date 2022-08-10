package com.skythecodemaster.scp.client.models;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import com.skythecodemaster.scp.common.items.LightDoorOldItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LightDoorOldModel extends AnimatedGeoModel<LightDoorOldBlockEntity> {
  @Override
  public ResourceLocation getModelLocation(LightDoorOldBlockEntity object) {
    return new ResourceLocation(SkySCPMod.MOD_ID,"geo/scp_light_door_old.geo.json");
  }
  
  @Override
  public ResourceLocation getTextureLocation(LightDoorOldBlockEntity object) {
    return new ResourceLocation(SkySCPMod.MOD_ID,"textures/block/scp_light_door_old.png");
  }
  
  @Override
  public ResourceLocation getAnimationFileLocation(LightDoorOldBlockEntity animatable) {
    return new ResourceLocation(SkySCPMod.MOD_ID,"animations/scp_light_door_old.animation.json");
  }
}