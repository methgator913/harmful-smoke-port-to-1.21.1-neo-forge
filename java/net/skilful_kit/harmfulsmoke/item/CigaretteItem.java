package net.skilful_kit.harmfulsmoke.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeItems;

public class CigaretteItem extends Item {

    public CigaretteItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        // Check if player has lighter in offhand or inventory
        boolean hasLighter = player.getOffhandItem().is(HarmfulsmokeItems.LIGHTER.get())
                || player.getInventory().hasAnyOf(java.util.Set.of(HarmfulsmokeItems.LIGHTER.get()));
        if (!level.isClientSide() && hasLighter) {
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            ItemStack litCig = new ItemStack(HarmfulsmokeItems.LIT_CIGARETTE.get());
            if (!player.getInventory().add(litCig)) {
                player.drop(litCig, false);
            }
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.pass(stack);
    }
}
