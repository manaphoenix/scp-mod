package com.skythecodemaster.scp.common.blockentities;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static com.skythecodemaster.scp.common.setup.BlockEntityTypes.LIGHT_DOOR_OLD_TILE;

public class LightDoorOldBlockEntity extends BlockEntity implements IAnimatable {
  private static final Logger LOGGER = LogUtils.getLogger(); // Collect a logger
  
  public LightDoorOldBlockEntity(BlockPos pos, BlockState state) {
    super(LIGHT_DOOR_OLD_TILE.get(),pos,state);
  }

  private AnimationFactory factory = new AnimationFactory(this);
  private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    // check if block is powered
    BlockEntity block = event.getAnimatable();
    boolean powered = block.getLevel().hasNeighborSignal(block.getBlockPos()) || block.getLevel().hasNeighborSignal(block.getBlockPos().above());
    if (powered) {
      event.getController().setAnimation(new AnimationBuilder().addAnimation("LDO.anim.open", false));
    } else {
      event.getController().setAnimation(new AnimationBuilder().addAnimation("LDO.anim.close", false));
    }

    return PlayState.CONTINUE;
  }
  
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController<LightDoorOldBlockEntity>(this,"controller",60,this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
  
  public void tick(Level level, BlockPos pos, BlockState state, LightDoorOld door) {
    if (level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above())) {
      door.state = true;
    } else {
      door.state = false;
    }
    if (door.state != door.lastState) {
      door.doState();
    }
  }
}
