package com.skythecodemaster.scp.common.blocks;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.common.setup.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightDoorOld extends DirectionalBlock implements EntityBlock, IAnimatable {
  
  public boolean state = false; // true for open, false for close
  private boolean lastState = false; // This is the previous state of the state, so we dont spam stuffs
  
  private static final Logger LOGGER = LogUtils.getLogger(); // Collect a logger
  
  private static final VoxelShape SHAPE_NORTH = Shapes.box(0,0,0.375f,1,2,0.625f);
  private static final VoxelShape SHAPE_SOUTH = SHAPE_NORTH;
  private static final VoxelShape SHAPE_EAST = Shapes.box(0.375f,0,0,0.625f,2,1);
  private static final VoxelShape SHAPE_WEST = SHAPE_EAST;
  
  public LightDoorOld() {
    super(Properties.of(Material.STONE).noOcclusion());
  }
  
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    BlockEntity x = BlockEntityTypes.LIGHT_DOOR_OLD_TILE.get().create(pos,state);
    ((LightDoorOldBlockEntity) x).attachedDoor = this;
    return x;
  }
  
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    return type == BlockEntityTypes.LIGHT_DOOR_OLD_TILE.get() ? LightDoorOldBlockEntity::tick : null;
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
  
  public void doState() {
    if (lastState != state) {
      lastState = state;
      LOGGER.info("Door state: %s".format(String.valueOf(state)));
    }
  }
  
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController<LightDoorOld>(this,"controller",0,this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
  
  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    //return this.defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
  }
  
  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(BlockStateProperties.FACING);
  }
  
  @Override
  public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pPos, CollisionContext context) {
    if (this.state) {
      return Shapes.box(0,0,0,0,0,0);
    } else {
      return switch (state.getValue(BlockStateProperties.FACING)) {
        case NORTH, DOWN, UP -> SHAPE_NORTH;
        case SOUTH -> SHAPE_SOUTH;
        case EAST -> SHAPE_EAST;
        case WEST -> SHAPE_WEST;
      };
    }
    //return Shapes.box(0,0,0.375f,1,2,0.625f);
  }
}
