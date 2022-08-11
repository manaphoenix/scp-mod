package com.skythecodemaster.scp.common.blocks;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.common.registry.TileRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
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
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightDoorOld extends DirectionalBlock implements EntityBlock {
  
  public boolean state = false; // true for open, false for close
  public boolean lastState = false; // This is the previous state of the state, so we dont spam stuffs
  
  private static final Logger LOGGER = LogUtils.getLogger(); // Collect a logger
  
  private static final VoxelShape SHAPE_NORTH = Shapes.box(0,0,0.375f,1,2,0.625f);
  private static final VoxelShape SHAPE_SOUTH = SHAPE_NORTH;
  private static final VoxelShape SHAPE_EAST = Shapes.box(0.375f,0,0,0.625f,2,1);
  private static final VoxelShape SHAPE_WEST = SHAPE_EAST;
  
  public LightDoorOld() {
    super(Properties.of(Material.STONE).noOcclusion());
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return TileRegistry.LIGHT_DOOR_ENTITY.get().create(pos,state);
  }
  
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    if (!level.isClientSide()) {
      return (lvl,pos,stt,te) -> {
        if (te instanceof LightDoorOldBlockEntity ldobe) ldobe.tick(lvl,pos,stt,this);
      };
    }
    return null;
    //return type == BlockEntityTypes.LIGHT_DOOR_OLD_TILE.get() ? LightDoorOldBlockEntity::tick : null;
  }

  @Override
  public RenderShape getRenderShape(BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }
  
  // Called every tick, might move state change to BE? too lazy.
  public void doState() {
    if (lastState != state) {
      lastState = state;
      LOGGER.info("Door state: %s".format(String.valueOf(state)));
    }
  }
  
  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    //return this.defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
  }

  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING);
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
