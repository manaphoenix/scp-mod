package com.skythecodemaster.scp.common.blockentities;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.common.blocks.HeavyDoorOld;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import com.skythecodemaster.scp.common.registry.SoundRegistry;
import com.skythecodemaster.scp.common.registry.TileRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class HeavyDoorOldBlockEntity
  extends BlockEntity
  implements IAnimatable {
  private static final Logger LOGGER = LogUtils.getLogger(); // Collect a logger
  private final AnimationFactory factory = new AnimationFactory(this);

  private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    // check if block is powered
    BlockEntity block = event.getAnimatable();
    if (block.getBlockState().getValue(HeavyDoorOld.POWERED)) {
      event
        .getController()
        .setAnimation(
          new AnimationBuilder()
            .addAnimation("hdo.anim.open", false)
            .addAnimation("hdo.anim.idle_open", false)
        );
    } else {
      event
        .getController()
        .setAnimation(
          new AnimationBuilder()
            .addAnimation("hdo.anim.close", false)
            .addAnimation("hdo.anim.idle_close", false)
        );
    }

    return PlayState.CONTINUE;
  }

  private <E extends BlockEntity & IAnimatable> void soundListener(SoundKeyframeEvent<E> event) {
    ClientLevel level1 = Minecraft.getInstance().level;
    if (level1 == null) {
      return;
    }

    // check if block is powered
    if (getBlockState().getValue(HeavyDoorOld.POWERED)) {
      level1.playLocalSound(getBlockPos(), SoundRegistry.HEAVY_DOOR_OLD_OPEN_SOUND.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
    } else {
      level1.playLocalSound(getBlockPos(), SoundRegistry.HEAVY_DOOR_OLD_CLOSE_SOUND.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
    }
  }

  public HeavyDoorOldBlockEntity(BlockPos pos, BlockState state) {
    super(TileRegistry.HEAVY_DOOR_OLD_ENTITY.get(), pos, state);
  }

  @Override
  public void registerControllers(AnimationData data) {
    AnimationController controller = new AnimationController(
      this,
      "controller",
      0,
      this::predicate
    );

    controller.registerSoundListener(this::soundListener);
    data.addAnimationController(controller);
  }

  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
}
