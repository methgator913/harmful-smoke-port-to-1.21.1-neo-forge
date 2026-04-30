package net.skilful_kit.harmfulsmoke.item;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.IContainerFactory;
import net.skilful_kit.harmfulsmoke.world.inventory.PackOfCigarettesMenu;

public class PackOfCigarettesItem extends Item {

    public PackOfCigarettesItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            // Capture the item stack for the menu
            final ItemStack packStack = stack;
            serverPlayer.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("item.harmfulsmoke.pack_of_cigarettes");
                }

                @Override
                public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
                    return new PackOfCigarettesMenu(containerId, playerInventory, packStack);
                }
            }, buf -> buf.writeItem(packStack));
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
