package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkySCPMod.MOD_ID);

    public static final RegistryObject<BlockItem> GENERIC_BLOCK_ITEM = ITEMS.register("generic_block",
            () -> new BlockItem(BlockRegistry.GENERIC_BLOCK.get(),
                    new Item.Properties().tab(SkySCPMod.scpTab)));
    public static final RegistryObject<BlockItem> LIGHT_DOOR_OLD_ITEM = ITEMS.register("light_door_old",
            () -> new BlockItem(BlockRegistry.LIGHT_DOOR_OLD.get(),
                    new Item.Properties().tab(SkySCPMod.scpTab)));
}
