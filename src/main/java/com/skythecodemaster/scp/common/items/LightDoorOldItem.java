package com.skythecodemaster.scp.common.items;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LightDoorOldItem extends BlockItem {
  public LightDoorOldItem(Block block, Properties properties) {
    super(block,properties.tab(SkySCPMod.TAB));
  }
  public LightDoorOldItem(Block block) {
    super(block,new Properties().tab(SkySCPMod.TAB));
  }
}