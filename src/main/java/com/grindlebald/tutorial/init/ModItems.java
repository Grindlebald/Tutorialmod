package com.grindlebald.tutorial.init;

import com.grindlebald.tutorial.Blocks.Oven;
import com.grindlebald.tutorial.Blocks.RubyBlock;
import com.grindlebald.tutorial.Blocks.RubyOreBlock;
import com.grindlebald.tutorial.Tutorial;
import com.grindlebald.tutorial.items.ItemBase;
import com.grindlebald.tutorial.items.ModSpawnEggItem;
import com.grindlebald.tutorial.items.RubyApple;
import com.grindlebald.tutorial.util.enums.ModArmorMaterial;
import com.grindlebald.tutorial.util.enums.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tutorial.MOD_ID);

    //Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<RubyApple> RUBY_APPLE = ITEMS.register("ruby_apple", RubyApple::new);

    public static final RegistryObject<ModSpawnEggItem> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.RED_PANDA, 0x990000, 0xbd4f00, new Item.Properties().group(Tutorial.TAB)));

    //Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY, 76, -3f, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModItemTier.RUBY, 2, -1.0f, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModItemTier.RUBY, 96, -3.5f, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModItemTier.RUBY, 3, -1.0f, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModItemTier.RUBY, 3, -1.0f, new Item.Properties().group(Tutorial.TAB)));


    //Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            ()-> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(Tutorial.TAB)));


    //Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
            () -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties().group(Tutorial.TAB)));

    public static final RegistryObject<Item> RUBY_ORE_BLOCK_ITEM = ITEMS.register("ruby_ore_block",
            () -> new BlockItem(ModBlocks.RUBY_ORE_BLOCK.get(), new Item.Properties().group(Tutorial.TAB)));
    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven",
            () -> new BlockItem(ModBlocks.OVEN.get(), new Item.Properties().group(Tutorial.TAB)));


}
