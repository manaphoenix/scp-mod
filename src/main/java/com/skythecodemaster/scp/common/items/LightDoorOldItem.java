package com.skythecodemaster.scp.common.items;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LightDoorOldItem extends BlockItem implements IAnimatable {
  public LightDoorOldItem(Block block, Properties properties) {
    super(block,properties.tab(SkySCPMod.TAB));
  }
  public LightDoorOldItem(Block block) {
    super(block,new Properties().tab(SkySCPMod.TAB));
  }
  private AnimationFactory factory = new AnimationFactory(this);
  private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.skysscp.scp_light_door_old"));
    return PlayState.CONTINUE;
  }
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController<LightDoorOldItem>(this,"controller",0,this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
}