package com.skythecodemaster.scp.common.items;

import com.skythecodemaster.scp.SkySCPMod;
import net.minecraft.world.item.Item;

public class ScpeniumItem extends Item {
  
  public ScpeniumItem() {
    super(new Properties()
      .tab(SkySCPMod.scpTab)
      .setNoRepair()
      .stacksTo(64)
    );
  }
}
