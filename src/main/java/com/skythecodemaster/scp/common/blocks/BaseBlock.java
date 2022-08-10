package com.skythecodemaster.scp.common.blocks;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class BaseBlock extends Block {
  private final TagKey<Block> harvestTag;
  
  public BaseBlock() {
    this(BlockTags.NEEDS_IRON_TOOL);
  }
  
  public BaseBlock(TagKey<Block> harvestTag) {
    this(
      Properties.of(Material.HEAVY_METAL)
        .strength( 1,5)
        .sound(SoundType.METAL)
        .noOcclusion()
        .requiresCorrectToolForDrops(),
      harvestTag
    );
  }
  
  public BaseBlock(Properties properties) {
    this(
      properties,
      BlockTags.NEEDS_IRON_TOOL
    );
  }
  
  public BaseBlock(Properties properties, TagKey<Block> harvestTag) {
    super(properties);
    this.harvestTag = harvestTag;
  }
  
  public TagKey<Block> getHarvestTag() {
    return harvestTag;
  }
}
