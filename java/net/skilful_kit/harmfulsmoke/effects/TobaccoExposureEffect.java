package net.skilful_kit.harmfulsmoke.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;

public class TobaccoExposureEffect extends MobEffect {

    public TobaccoExposureEffect() {
        super(MobEffectCategory.HARMFUL, 0x8B6914);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            if (!player.level().isClientSide()) {
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0, false, false));
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
