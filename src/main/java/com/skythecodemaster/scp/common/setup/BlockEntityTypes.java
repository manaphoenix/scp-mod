package com.skythecodemaster.scp.common.setup;

import com.skythecodemaster.scp.common.blocks.GenericBlock;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import com.skythecodemaster.scp.common.items.BaseBlockItem;
import com.skythecodemaster.scp.common.items.LightDoorOldItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypes {
  static void register(){}
  public static final RegistryObject<BlockEntityType<LightDoorOld>> LIGHT_DOOR_OLD = register("light_door_old",() -> new GenericBlock(), () -> new LightDoorOldItem());


}
