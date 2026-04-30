package net.skilful_kit.harmfulsmoke.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.world.inventory.PackOfCigarettesMenu;

public class HarmfulsmokeMenus {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, HarmfulsmokeMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<PackOfCigarettesMenu>> PACK_OF_CIGARETTES_MENU =
            MENUS.register("pack_of_cigarettes_menu",
                    () -> IMenuTypeExtension.create(PackOfCigarettesMenu::new));
}
