package net.skilful_kit.harmfulsmoke.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.skilful_kit.harmfulsmoke.Config;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeEffects;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeItems;

@EventBusSubscriber(modid = HarmfulsmokeMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class SmokingEventHandler {

    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity = event.getEntity();
        ItemStack stack = event.getItem();

        if (!(entity instanceof Player player)) return;
        Level level = player.level();
        if (level.isClientSide()) return;

        // --- Lit Cigarette -> Almost Finished Cigarette ---
        if (stack.is(HarmfulsmokeItems.LIT_CIGARETTE.get())) {
            if (!player.isCreative()) stack.shrink(1);
            giveItem(player, new ItemStack(HarmfulsmokeItems.ALMOST_FINISHED_CIGARETTE.get()));
            spawnSmoke(level, player);
            applyTobaccoEffect(player, false);
        }
        // --- Almost Finished Cigarette -> Cigarette Butt ---
        else if (stack.is(HarmfulsmokeItems.ALMOST_FINISHED_CIGARETTE.get())) {
            if (!player.isCreative()) stack.shrink(1);
            giveItem(player, new ItemStack(HarmfulsmokeItems.CIGARETTE_BUTT.get()));
            spawnSmoke(level, player);
            applyTobaccoEffect(player, false);
        }
        // --- Lit Cigar -> Half-Smoked Cigar ---
        else if (stack.is(HarmfulsmokeItems.LIT_CIGAR.get())) {
            if (!player.isCreative()) stack.shrink(1);
            giveItem(player, new ItemStack(HarmfulsmokeItems.HALF_SMOKED_CIGAR.get()));
            spawnSmoke(level, player);
            applyTobaccoEffect(player, true);
        }
        // --- Half-Smoked Cigar -> Almost Finished Cigar ---
        else if (stack.is(HarmfulsmokeItems.HALF_SMOKED_CIGAR.get())) {
            if (!player.isCreative()) stack.shrink(1);
            giveItem(player, new ItemStack(HarmfulsmokeItems.ALMOST_FINISHED_CIGAR.get()));
            spawnSmoke(level, player);
            applyTobaccoEffect(player, true);
        }
        // --- Almost Finished Cigar -> gone (nothing remains) ---
        else if (stack.is(HarmfulsmokeItems.ALMOST_FINISHED_CIGAR.get())) {
            if (!player.isCreative()) stack.shrink(1);
            spawnSmoke(level, player);
            applyTobaccoEffect(player, true);
        }
    }

    private static void applyTobaccoEffect(Player player, boolean strong) {
        if (strong && Boolean.TRUE.equals(Config.CIGAR_EFFECTS_ENABLED.get())) {
            player.addEffect(new MobEffectInstance(HarmfulsmokeEffects.STRONG_TOBACCO_EXPOSURE.get(), 600, 0, false, true));
        } else if (!strong && Boolean.TRUE.equals(Config.CIGARETTE_EFFECTS_ENABLED.get())) {
            player.addEffect(new MobEffectInstance(HarmfulsmokeEffects.TOBACCO_EXPOSURE.get(), 400, 0, false, true));
        }
    }

    private static void spawnSmoke(Level level, Player player) {
        if (!level.isClientSide()) {
            // Send smoke particles via server-side particle spawning
            if (level instanceof net.minecraft.server.level.ServerLevel serverLevel) {
                serverLevel.sendParticles(
                        net.minecraft.core.particles.ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                        player.getX(), player.getEyeY(), player.getZ(),
                        3, 0.1, 0.1, 0.1, 0.01
                );
            }
        }
    }

    private static void giveItem(Player player, ItemStack result) {
        if (!player.getInventory().add(result)) {
            player.drop(result, false);
        }
    }
}
