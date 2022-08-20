package com.skythecodemaster.scp.common.datagen;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.registry.SoundRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class Sounds extends SoundDefinitionsProvider {

    protected Sounds(DataGenerator generator, String modId, ExistingFileHelper helper) {
        super(generator, modId, helper);
    }

    @Override
    public void registerSounds() {
        this.add(SoundRegistry.HEAVY_DOOR_OLD_OPEN_SOUND.get(), SoundDefinition.definition()
                .subtitle("skysscp.subtitle.heavy_door_old_open")
                .with(
                        sound(new ResourceLocation(SkySCPMod.MOD_ID, "heavy_old_open_1")),
                        sound(new ResourceLocation(SkySCPMod.MOD_ID, "heavy_old_open_2")),
                        sound(new ResourceLocation(SkySCPMod.MOD_ID, "heavy_old_open_3"))
                )
        );
        this.add(SoundRegistry.HEAVY_DOOR_OLD_CLOSE_SOUND.get(), SoundDefinition.definition()
                .subtitle("skysscp.subtitle.heavy_door_old_close_sound")
                .with(
                        sound(new ResourceLocation(SkySCPMod.MOD_ID, "heavy_old_close_1")),
                        sound(new ResourceLocation(SkySCPMod.MOD_ID, "heavy_old_close_2")),
                        sound(new ResourceLocation(SkySCPMod.MOD_ID, "heavy_old_close_3"))
                )
        );
    }
}
