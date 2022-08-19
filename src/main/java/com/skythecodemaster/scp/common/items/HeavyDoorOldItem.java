package com.skythecodemaster.scp.common.items;

import com.skythecodemaster.scp.SkySCPMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class HeavyDoorOldItem extends BlockItem {
  public HeavyDoorOldItem(Block block, Properties properties) {
    super(block, properties.tab(SkySCPMod.scpTab));
  }
  
  public HeavyDoorOldItem(Block block) {
    super(block, new Properties().tab(SkySCPMod.scpTab));
  }
}