package net.skilful_kit.harmfulsmoke.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.effects.StrongTobaccoExposureEffect;
import net.skilful_kit.harmfulsmoke.effects.TobaccoExposureEffect;

public class HarmfulsmokeEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, HarmfulsmokeMod.MODID);

    public static final DeferredHolder<MobEffect, TobaccoExposureEffect> TOBACCO_EXPOSURE =
            MOB_EFFECTS.register("tobacco_exposure", TobaccoExposureEffect::new);

    public static final DeferredHolder<MobEffect, StrongTobaccoExposureEffect> STRONG_TOBACCO_EXPOSURE =
            MOB_EFFECTS.register("strong_tobacco_exposure", StrongTobaccoExposureEffect::new);
}
