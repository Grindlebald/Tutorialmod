package com.grindlebald.tutorial.items;

import com.grindlebald.tutorial.Tutorial;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Tutorial.TAB));
    }
}


