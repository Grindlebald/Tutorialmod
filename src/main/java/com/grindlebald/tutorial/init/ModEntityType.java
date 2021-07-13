package com.grindlebald.tutorial.init;

import com.grindlebald.tutorial.Tutorial;
import com.grindlebald.tutorial.entities.RedPandaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Tutorial.MOD_ID);

    // Entity Types
    public static final RegistryObject<EntityType<RedPandaEntity>> RED_PANDA = ENTITY_TYPES.register("red_panda",
            () -> EntityType.Builder.create(RedPandaEntity::new, EntityClassification.CREATURE)
                    .size(0.8f, 0.6f) // Hitbox Size
                    .build(new ResourceLocation(Tutorial.MOD_ID, "red_panda").toString()));
}
