package com.grindlebald.tutorial.items;

import com.grindlebald.tutorial.Tutorial;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RubyApple extends Item {
    public RubyApple() {
        super(new Item.Properties()
            .group(Tutorial.TAB)
            .food(new Food.Builder()
                    .hunger(15)
                    .saturation(15.0f)
                    .effect(new EffectInstance(Effects.STRENGTH, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.ABSORPTION, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.GLOWING, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.HASTE, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.HEALTH_BOOST, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.SPEED, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.JUMP_BOOST, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.REGENERATION, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.RESISTANCE, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.WATER_BREATHING, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.INVISIBILITY, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.NIGHT_VISION, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.SATURATION, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.LUCK, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.SLOW_FALLING, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.CONDUIT_POWER, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.DOLPHINS_GRACE, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 5000, 9), 1.0f)
                    .effect(new EffectInstance(Effects.INSTANT_DAMAGE, 6000, 2147483647), 0.5f)
                    .fastToEat()
                    .setAlwaysEdible()
                    .meat()

            .build())








        );
    }
}
