package com.skythecodemaster.scp.common.blockentities;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.common.blocks.LightDoorNew;
import com.skythecodemaster.scp.common.registry.TileRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LightDoorNewBlockEntity extends BlockEntity implements IAnimatable {
  private static final Logger LOGGER = LogUtils.getLogger(); // Collect a logger
  private final AnimationFactory factory = new AnimationFactory(this);
  
  private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    // check if block is powered
    BlockEntity block = event.getAnimatable();
    if (block.getBlockState().getValue(LightDoorNew.POWERED)) {
      event.getController().setAnimation(new AnimationBuilder().addAnimation("ldn.anim.open", false).addAnimation("ldn.anim.idle_open", false));
    } else {
      event.getController().setAnimation(new AnimationBuilder().addAnimation("ldn.anim.close", false).addAnimation("ldn.anim.idle_close", false));
    }
    
    return PlayState.CONTINUE;
  }
  
  public LightDoorNewBlockEntity(BlockPos pos, BlockState state) {
    super(TileRegistry.LIGHT_DOOR_ENTITY.get(), pos, state);
  }
  
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
}
