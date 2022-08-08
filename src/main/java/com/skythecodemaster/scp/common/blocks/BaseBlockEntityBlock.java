package com.skythecodemaster.scp.common.blocks;

import com.skythecodemaster.scp.common.setup.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BaseBlockEntityBlock extends BaseEntityBlock {
  
  public BaseBlockEntityBlock(Properties properties) {
    super(properties);
  }
  
  public BaseBlockEntityBlock() {
    this(
      Properties.of(Material.HEAVY_METAL)
        .strength( 1,5)
        .sound(SoundType.METAL)
        .noOcclusion()
        .requiresCorrectToolForDrops()
    );
  }
  @NotNull
  @Override
  public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
    
    return InteractionResult.SUCCESS;
  }
  
  @Nullable
  @Override
  public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
    return null;
  }
}
