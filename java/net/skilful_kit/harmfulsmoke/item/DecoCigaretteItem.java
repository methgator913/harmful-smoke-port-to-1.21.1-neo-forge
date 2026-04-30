package net.skilful_kit.harmfulsmoke.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.client.model.Modelcigarette_head1;

import java.util.List;
import java.util.function.Consumer;

public class DecoCigaretteItem extends Item {

    public DecoCigaretteItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<net.minecraft.network.chat.Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(net.minecraft.network.chat.Component.translatable("tooltip.harmfulsmoke.deco_cigarette"));
    }

    // NeoForge 1.21.1: IClientItemExtensions for custom helmet model
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                var minecraft = net.minecraft.client.Minecraft.getInstance();
                var modelPart = minecraft.getEntityModels().bakeLayer(Modelcigarette_head1.LAYER_LOCATION);
                return new Modelcigarette_head1<>(modelPart);
            }
        });
    }

    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
