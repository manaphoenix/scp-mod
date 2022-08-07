package com.skythecodemaster.scp.common.setup;

import com.skythecodemaster.scp.common.blocks.GenericBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import com.skythecodemaster.scp.common.setup.Registration;
import com.skythecodemaster.scp.common.items.BaseBlockItem;

import java.util.function.Supplier;

public class Blocks {
  static void register(){};
  
  public static final RegistryObject<Block> GENERIC_BLOCK = register("generic_block",() -> GenericBlock::new, () -> new BaseBlockItem(Blocks.GENERIC_BLOCK.get()));
  
  private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
    return Registration.BLOCKS.register(name,block);
  }
  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Supplier<BlockItem> blockItem) {
    RegistryObject<T> registryObject = registerNoItem(name,block);
    Registration.ITEMS.register(name,blockItem);
    return registryObject;
  }
}
