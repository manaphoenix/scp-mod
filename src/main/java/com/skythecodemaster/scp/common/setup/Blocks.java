package com.skythecodemaster.scp.common.setup;

import com.skythecodemaster.scp.common.blocks.GenericBlock;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import com.skythecodemaster.scp.common.items.LightDoorOldItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import com.skythecodemaster.scp.common.items.BaseBlockItem;

import java.util.function.Supplier;

public class Blocks {
  static void register(){};
  
  public static final RegistryObject<Block> GENERIC_BLOCK = register("generic_block",() -> new GenericBlock(), () -> new BaseBlockItem(Blocks.GENERIC_BLOCK.get()));
  public static final RegistryObject<Block> LIGHT_DOOR_OLD = register("light_door_old", () -> new LightDoorOld(), () -> new LightDoorOldItem(Blocks.LIGHT_DOOR_OLD.get()));
  
  private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
    return Registration.BLOCKS.register(name,block);
  }
  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Supplier<BlockItem> blockItem) {
    RegistryObject<T> registryObject = registerNoItem(name,block);
    Registration.ITEMS.register(name,blockItem);
    return registryObject;
  }
}
