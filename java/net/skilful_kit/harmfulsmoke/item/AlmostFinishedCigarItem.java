package net.skilful_kit.harmfulsmoke.item;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
public class AlmostFinishedCigarItem extends Item {
    public AlmostFinishedCigarItem(Properties p) { super(p); }
    @Override public UseAnim getUseAnimation(ItemStack s) { return UseAnim.DRINK; }
    @Override public int getUseDuration(ItemStack s) { return 32; }
}
