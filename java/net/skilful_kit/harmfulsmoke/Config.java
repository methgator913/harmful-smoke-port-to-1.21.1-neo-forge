package net.skilful_kit.harmfulsmoke;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    // Cigarette settings
    public static final ModConfigSpec.ConfigValue<Boolean> CIGARETTE_EFFECTS_ENABLED;
    public static final ModConfigSpec.ConfigValue<Double> CIGARETTE_HEALTH_REDUCTION;

    // Cigar settings
    public static final ModConfigSpec.ConfigValue<Boolean> CIGAR_EFFECTS_ENABLED;
    public static final ModConfigSpec.ConfigValue<Double> CIGAR_HEALTH_REDUCTION;

    static {
        BUILDER.push("Cigarette Settings");
        CIGARETTE_EFFECTS_ENABLED = BUILDER.comment("Enable tobacco exposure effects from cigarettes")
                .define("cigaretteEffectsEnabled", true);
        CIGARETTE_HEALTH_REDUCTION = BUILDER.comment("Health reduction from smoking (in half-hearts)")
                .defineInRange("cigaretteHealthReduction", 1.0, 0.0, 20.0);
        BUILDER.pop();

        BUILDER.push("Cigar Settings");
        CIGAR_EFFECTS_ENABLED = BUILDER.comment("Enable tobacco exposure effects from cigars")
                .define("cigarEffectsEnabled", true);
        CIGAR_HEALTH_REDUCTION = BUILDER.comment("Health reduction from smoking cigars (in half-hearts)")
                .defineInRange("cigarHealthReduction", 2.0, 0.0, 20.0);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
