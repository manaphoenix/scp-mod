package com.skythecodemaster.scp.common.items;

import com.skythecodemaster.scp.SkySCPMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

// Literally just adds it to the tab menu lol
public class BaseBlockItem extends BlockItem {
  public BaseBlockItem(Block block, Properties properties) {
    super(block,properties.tab(SkySCPMod.TAB));
  }
  public BaseBlockItem(Block block) {
    super(block,new Properties().tab(SkySCPMod.TAB));
  }
}
