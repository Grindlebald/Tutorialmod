package com.grindlebald.tutorial.world.gen;

import com.grindlebald.tutorial.Tutorial;
import com.grindlebald.tutorial.init.ModEntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {


                if (biome.getCategory() == Biome.Category.JUNGLE) {
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityType.RED_PANDA.get(), 1, 1, 3));
                }

        }
    }
}
