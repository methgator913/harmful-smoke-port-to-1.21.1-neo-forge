package net.skilful_kit.harmfulsmoke.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;

public class StrongTobaccoExposureEffect extends MobEffect {

    public StrongTobaccoExposureEffect() {
        super(MobEffectCategory.HARMFUL, 0x5A3A00);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            if (!player.level().isClientSide()) {
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
                player.getFoodData().addExhaustion(0.5f);
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }

    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }
}
