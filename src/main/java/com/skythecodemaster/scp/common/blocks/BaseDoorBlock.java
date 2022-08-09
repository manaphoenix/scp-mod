package com.skythecodemaster.scp.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public class BaseDoorBlock extends BlockEntity {
  private boolean open = false;
  
  public BaseDoorBlock(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
    super(p_155228_, p_155229_, p_155230_);
  }
  
  public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }
  
  private void reflectState() {
  
  }
  @NotNull
  public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
    open = !open;
    
    reflectState();
    return InteractionResult.SUCCESS;
  }
}
