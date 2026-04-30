package net.skilful_kit.harmfulsmoke.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeItems;

public class CigarItem extends Item {

    public CigarItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean hasLighter = player.getOffhandItem().is(HarmfulsmokeItems.LIGHTER.get())
                || player.getInventory().hasAnyOf(java.util.Set.of(HarmfulsmokeItems.LIGHTER.get()));
        if (!level.isClientSide() && hasLighter) {
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            ItemStack litCigar = new ItemStack(HarmfulsmokeItems.LIT_CIGAR.get());
            if (!player.getInventory().add(litCigar)) {
                player.drop(litCigar, false);
            }
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.pass(stack);
    }
}
