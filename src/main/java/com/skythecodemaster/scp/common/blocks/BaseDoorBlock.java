package com.skythecodemaster.scp.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;

public class BaseDoorBlock extends BaseBlock {
  private boolean open = false;
  
  public BaseDoorBlock() {
    super();
  }
}
