package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blocks.GenericBlock;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkySCPMod.MOD_ID);
  
  public static final RegistryObject<GenericBlock> SCPENIUM_BLOCK = BLOCKS.register("generic_block",
    GenericBlock::new);
  public static final RegistryObject<LightDoorOld> LIGHT_DOOR_OLD = BLOCKS.register("light_door_old",
    LightDoorOld::new);
}
