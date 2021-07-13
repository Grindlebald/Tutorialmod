package com.grindlebald.tutorial.events;


import com.grindlebald.tutorial.Tutorial;
import com.grindlebald.tutorial.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {


    @SubscribeEvent
    public static void onJumpWithBoots(LivingEvent.LivingJumpEvent event){
        Entity player = event.getEntity();
        if (player.isAlive()) {
            Iterable<ItemStack> armor = player.getArmorInventoryList();

            for (ItemStack stack : armor) {
                checkArmor(stack, player);
            }
        }
    }
    public static void checkArmor(ItemStack stack, Entity player) {
        if (stack.getItem().equals(ModItems.RUBY_BOOTS.get()) ) {
            Tutorial.LOGGER.info("Player tried to jump with a Ruby Armor");
            World world = player.getEntityWorld();
            world.setBlockState(player.getPosition().add(0, -1, 0), Blocks.WHITE_WOOL.getDefaultState());
        }
    }
    @SubscribeEvent
    public static void onDamageSheep(AttackEntityEvent event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.RUBY_HOE.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity) {

                    PlayerEntity player = event.getPlayer();
                    target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 200));
                    target.setGlowing(true);
                    ((SheepEntity) target).setSheared(true);
                    target.setSwimming(true);

                    // Client Only
                    if (!event.getPlayer().getEntityWorld().isRemote) {
                        String msg = TextFormatting.GOLD + "Where are you heading?";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }


}


