package com.grindlebald.tutorial.init;

import com.grindlebald.tutorial.Blocks.Oven;
import com.grindlebald.tutorial.Blocks.RubyBlock;
import com.grindlebald.tutorial.Blocks.RubyOreBlock;
import com.grindlebald.tutorial.Tutorial;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Tutorial.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE_BLOCK = BLOCKS.register("ruby_ore_block", RubyOreBlock::new);

    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);

}
