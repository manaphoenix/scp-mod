package com.skythecodemaster.scp.common.blocks;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightDoorOld extends DirectionalBlock implements EntityBlock {

  public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
  public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

  private static final VoxelShape SHAPE_NORTH = Shapes.box(0,0,0.375f,1,2,0.625f);
  private static final VoxelShape SHAPE_SOUTH = SHAPE_NORTH;
  private static final VoxelShape SHAPE_EAST = Shapes.box(0.375f,0,0,0.625f,2,1);
  private static final VoxelShape SHAPE_WEST = SHAPE_EAST;
  
  public LightDoorOld() {
    super(Properties.of(Material.STONE).noOcclusion());
    this.stateDefinition.any().setValue(OPEN, false).setValue(POWERED, false);
  }

  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return TileRegistry.LIGHT_DOOR_ENTITY.get().create(pos,state);
  }

  @Override
  public RenderShape getRenderShape(BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }
  
  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
  }

  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING, OPEN, POWERED);
  }

  @Override
  public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos posOf, boolean something) {
    boolean flag = world.hasNeighborSignal(pos) || world.hasNeighborSignal(pos.above());

    world.setBlock(pos, state.setValue(POWERED, flag).setValue(OPEN, flag), 2);
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pPos, CollisionContext context) {
    if (state.getValue(OPEN)) {
      return Shapes.box(0,0,0,0,0,0);
    } else {
      return switch (state.getValue(BlockStateProperties.FACING)) {
        case NORTH, DOWN, UP -> SHAPE_NORTH;
        case SOUTH -> SHAPE_SOUTH;
        case EAST -> SHAPE_EAST;
        case WEST -> SHAPE_WEST;
      };
    }
  }
}
