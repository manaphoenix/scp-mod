package com.skythecodemaster.scp.common.blocks;

import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.common.items.LightDoorOldItem;
import com.skythecodemaster.scp.common.setup.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightDoorOld extends DirectionalBlock implements EntityBlock, IAnimatable {
  public LightDoorOld() {
    super(Properties.of(Material.STONE).noOcclusion());
  }
  
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return BlockEntityTypes.LIGHT_DOOR_OLD_TILE.get().create(pos,state);
  }
  @Override
  public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }
  
  private AnimationFactory factory = new AnimationFactory(this);
  private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.skysscp.scp_light_door_old"));
    return PlayState.CONTINUE;
  }
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController<LightDoorOld>(this,"controller",0,this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
}
