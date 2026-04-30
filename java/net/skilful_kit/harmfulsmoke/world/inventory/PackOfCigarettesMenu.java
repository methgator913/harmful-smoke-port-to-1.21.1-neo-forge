package net.skilful_kit.harmfulsmoke.world.inventory;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeItems;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeMenus;

public class PackOfCigarettesMenu extends AbstractContainerMenu {

    private final IItemHandler itemHandler;
    private final ItemStack packStack;

    // Server-side constructor (called from item)
    public PackOfCigarettesMenu(int containerId, Inventory playerInventory, ItemStack packStack) {
        super(HarmfulsmokeMenus.PACK_OF_CIGARETTES_MENU.get(), containerId);
        this.packStack = packStack;

        // Load or create the ItemStackHandler from the pack NBT
        ItemStackHandler handler = new ItemStackHandler(8) {
            @Override
            public boolean isItemValid(int slot, ItemStack stack) {
                return stack.is(HarmfulsmokeItems.CIGARETTE.get())
                        || stack.is(HarmfulsmokeItems.LIT_CIGARETTE.get())
                        || stack.is(HarmfulsmokeItems.ALMOST_FINISHED_CIGARETTE.get())
                        || stack.is(HarmfulsmokeItems.CIGARETTE_BUTT.get());
            }
        };

        // Deserialize stored items from pack NBT
        if (packStack.getTag() != null && packStack.getTag().contains("Inventory")) {
            handler.deserializeNBT(packStack.getTag().getCompound("Inventory"));
        }

        this.itemHandler = handler;

        // Add pack slots (8 cigarette slots, 2 rows of 4)
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
                addSlot(new SlotItemHandler(itemHandler, row * 4 + col, 26 + col * 18, 18 + row * 18) {
                    @Override
                    public boolean mayPlace(ItemStack stack) {
                        return isItemValid(getContainerSlot(), stack);
                    }
                });
            }
        }

        // Player inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        // Hotbar
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    // Client-side constructor (called via IMenuTypeExtension from FriendlyByteBuf)
    public PackOfCigarettesMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buf) {
        this(containerId, playerInventory, buf.readItem());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            result = slotStack.copy();
            if (index < 8) {
                if (!moveItemStackTo(slotStack, 8, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!moveItemStackTo(slotStack, 0, 8, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return result;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        // Save inventory back to pack NBT
        if (itemHandler instanceof ItemStackHandler handler) {
            packStack.getOrCreateTag().put("Inventory", handler.serializeNBT());
        }
    }

    public IItemHandler getItemHandler() {
        return itemHandler;
    }
}
