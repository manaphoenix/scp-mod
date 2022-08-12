package com.skythecodemaster.scp;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.client.renderers.LightDoorOldRenderer;
import com.skythecodemaster.scp.common.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import com.skythecodemaster.scp.common.registry.BlockRegistry;
import com.skythecodemaster.scp.common.registry.TileRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SkySCPMod.MOD_ID)
public class SkySCPMod {
  public static boolean DISABLE_IN_DEV = false;
  public static final String MOD_ID = "skysscp";
  public static CreativeModeTab scpTab;
  // Directly reference a slf4j logger
  private static final Logger LOGGER = LogUtils.getLogger();
  
  public SkySCPMod() {
    LOGGER.info("SCP: Secure, Contain, Protect");
    if (!FMLEnvironment.production && !DISABLE_IN_DEV) {
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      TileRegistry.TILES.register(bus);
      BlockRegistry.BLOCKS.register(bus);
      ItemRegistry.ITEMS.register(bus);
      scpTab = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), "skysscptab") {
        @Override
        public ItemStack makeIcon() {
          return new ItemStack(BlockRegistry.SCPENIUM_BLOCK.get());
        }
      };
    }
    
    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  
  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    // Do something when the server starts
    LOGGER.info("HELLO from server starting");
  }
  
  // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
  // Event bus for receiving Registry Events)
  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
      // Register a new block here
      LOGGER.info("HELLO from Register Block");
    }
    
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
      event.registerBlockEntityRenderer(TileRegistry.LIGHT_DOOR_ENTITY.get(), LightDoorOldRenderer::new);
    }
  }
}
