package com.skythecodemaster.scp.common.setup;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import com.skythecodemaster.scp.common.blocks.GenericBlock;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import com.skythecodemaster.scp.common.items.LightDoorOldItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.skythecodemaster.scp.common.setup.Registration;

import java.util.function.Supplier;

public class BlockEntityTypes {
  public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SkySCPMod.MOD_ID);
  public static final RegistryObject<BlockEntityType<LightDoorOldBlockEntity>> LIGHT_DOOR_OLD_TILE = TILE_ENTITIES.register("light_door_old_tile",() -> BlockEntityType.Builder.of(LightDoorOldBlockEntity::new, Blocks.LIGHT_DOOR_OLD.get()).build(null));
}