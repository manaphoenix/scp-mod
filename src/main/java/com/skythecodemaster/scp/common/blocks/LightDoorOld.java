package com.skythecodemaster.scp.common.blocks;

import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LightDoorOld extends DirectionalBlock implements EntityBlock {
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

}
