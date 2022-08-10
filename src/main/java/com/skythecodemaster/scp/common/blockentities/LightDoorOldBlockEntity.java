package com.skythecodemaster.scp.common.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static com.skythecodemaster.scp.common.setup.BlockEntityTypes.LIGHT_DOOR_OLD_TILE;

public class LightDoorOldBlockEntity extends BlockEntity implements IAnimatable {
  public LightDoorOldBlockEntity(BlockPos pos, BlockState state) {
    super(LIGHT_DOOR_OLD_TILE.get(),pos,state);
  }
  
  private AnimationFactory factory = new AnimationFactory(this);
  private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    event.getController().setAnimation(new AnimationBuilder().addAnimation("LDO.anim.open"));
    return PlayState.CONTINUE;
  }
  
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController<LightDoorOldBlockEntity>(this,"controller",0,this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
}
