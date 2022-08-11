package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileRegistry {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, SkySCPMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<LightDoorOldBlockEntity>> LIGHT_DOOR_ENTITY = TILES
            .register("light_door_old_tile", () -> BlockEntityType.Builder
                    .of(LightDoorOldBlockEntity::new, BlockRegistry.LIGHT_DOOR_OLD.get()).build(null));
}
