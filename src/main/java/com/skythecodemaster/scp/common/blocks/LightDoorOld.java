package com.skythecodemaster.scp.common.blocks;

import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.common.setup.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.skythecodemaster.scp.common.setup.BlockEntityTypes.LIGHT_DOOR_OLD_TILE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightDoorOld extends BaseBlock {
  public LightDoorOld() {
    super();
  }
  
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new BlockEntityTypes.LIGHT_DOOR_OLD_TILE.get().create(pos,state);
  }
  @Override
  public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }

}
