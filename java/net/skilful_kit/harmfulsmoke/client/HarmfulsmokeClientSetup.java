package net.skilful_kit.harmfulsmoke.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.client.gui.PackOfCigarettesScreen;
import net.skilful_kit.harmfulsmoke.client.model.Modelcigar_head1;
import net.skilful_kit.harmfulsmoke.client.model.Modelcigarette_head1;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeMenus;

@EventBusSubscriber(modid = HarmfulsmokeMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HarmfulsmokeClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(HarmfulsmokeMenus.PACK_OF_CIGARETTES_MENU.get(), PackOfCigarettesScreen::new);
        });
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Modelcigar_head1.LAYER_LOCATION, Modelcigar_head1::createBodyLayer);
        event.registerLayerDefinition(Modelcigarette_head1.LAYER_LOCATION, Modelcigarette_head1::createBodyLayer);
    }
}
