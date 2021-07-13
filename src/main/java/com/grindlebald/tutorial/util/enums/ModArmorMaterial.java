package com.grindlebald.tutorial.util.enums;

import com.grindlebald.tutorial.Tutorial;
import com.grindlebald.tutorial.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;


public enum ModArmorMaterial implements IArmorMaterial {

    RUBY(Tutorial.MOD_ID + ":ruby", 100, new int[] { 16, 20, 24, 18 }, 50,
            SoundEvents.BLOCK_ANVIL_USE, 50.0f, () -> {return Ingredient.fromItems(ModItems.RUBY.get());},10);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantabilty;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResitance;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantabilty,
                     SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResitance){
        this.name = name;
        this.maxDamageFactor =maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantabilty = enchantabilty;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResitance = knockbackResitance;
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantabilty;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }
    @OnlyIn(Dist.CLIENT)

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResitance;
    }
}
