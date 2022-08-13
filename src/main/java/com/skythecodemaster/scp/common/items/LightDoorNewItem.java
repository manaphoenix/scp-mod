package com.skythecodemaster.scp.common.items;

import com.skythecodemaster.scp.SkySCPMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class LightDoorNewItem extends BlockItem {
  public LightDoorNewItem(Block block, Properties properties) {
    super(block, properties.tab(SkySCPMod.scpTab));
  }
  
  public LightDoorNewItem(Block block) {
    super(block, new Properties().tab(SkySCPMod.scpTab));
  }
}