package net.skilful_kit.harmfulsmoke;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeBlocks;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeEffects;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeItems;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeMenus;

import java.util.function.Supplier;

@Mod(HarmfulsmokeMod.MODID)
public class HarmfulsmokeMod {

    public static final String MODID = "harmfulsmoke";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> HARMFUL_SMOKE_TAB = CREATIVE_MODE_TABS.register(
            "harmful_smoke",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.harmful_smoke"))
                    .icon(() -> new ItemStack(HarmfulsmokeItems.CIGARETTE.get()))
                    .displayItems((params, output) -> {
                        HarmfulsmokeItems.ITEMS.getEntries().forEach(reg -> output.accept(reg.get()));
                    })
                    .build()
    );

    public HarmfulsmokeMod(IEventBus modEventBus, ModContainer modContainer) {
        HarmfulsmokeBlocks.BLOCKS.register(modEventBus);
        HarmfulsmokeItems.ITEMS.register(modEventBus);
        HarmfulsmokeEffects.MOB_EFFECTS.register(modEventBus);
        HarmfulsmokeMenus.MENUS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
