package net.skilful_kit.harmfulsmoke.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.item.*;

public class HarmfulsmokeItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(HarmfulsmokeMod.MODID);

    // Basic tobacco items
    public static final DeferredItem<Item> TOBACCO_LEAF = ITEMS.register(
            "tobacco_leaf",
            () -> new TobaccoLeavesItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> DRIED_TOBACCO_LEAF = ITEMS.register(
            "dried_tobacco_leaf",
            () -> new DriedTobaccoLeavesItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> SHREDDED_TOBACCO = ITEMS.register(
            "shredded_tobacco",
            () -> new ShreddedTobaccoItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> FILTER_FOR_CIGARETTES = ITEMS.register(
            "filter_for_cigarettes",
            () -> new FilterForCigarettesItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> TOBACCO_SEEDS = ITEMS.register(
            "tobacco_seeds",
            () -> new TobaccoSeedsItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    // Cigarettes
    public static final DeferredItem<Item> CIGARETTE = ITEMS.register(
            "cigarette",
            () -> new CigaretteItem(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> LIT_CIGARETTE = ITEMS.register(
            "lit_cigarette",
            () -> new LitCigaretteItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build()))
    );

    public static final DeferredItem<Item> ALMOST_FINISHED_CIGARETTE = ITEMS.register(
            "almost_finished_cigarette",
            () -> new AlmostFinishedCigaretteItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build()))
    );

    public static final DeferredItem<Item> CIGARETTE_BUTT = ITEMS.register(
            "cigarette_butt",
            () -> new CigaretteButtItem(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON))
    );

    // Cigars
    public static final DeferredItem<Item> CIGAR = ITEMS.register(
            "cigar",
            () -> new CigarItem(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> LIT_CIGAR = ITEMS.register(
            "lit_cigar",
            () -> new LitCigarItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build()))
    );

    public static final DeferredItem<Item> HALF_SMOKED_CIGAR = ITEMS.register(
            "half-smoked_cigar",
            () -> new HalfSmokedCigarItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build()))
    );

    public static final DeferredItem<Item> ALMOST_FINISHED_CIGAR = ITEMS.register(
            "almost_finished_cigar",
            () -> new AlmostFinishedCigarItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build()))
    );

    // Equipment / special items
    public static final DeferredItem<Item> LIGHTER = ITEMS.register(
            "lighter",
            () -> new LighterItem(new Item.Properties().stacksTo(1).durability(100).rarity(Rarity.COMMON))
    );

    public static final DeferredItem<Item> PACK_OF_CIGARETTES = ITEMS.register(
            "pack_of_cigarettes",
            () -> new PackOfCigarettesItem(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON))
    );

    // Decorative wearable items (helmet slot)
    public static final DeferredItem<Item> DECO_CIGARETTE = ITEMS.register(
            "deco_cigarette",
            DecoCigaretteItem::new
    );

    public static final DeferredItem<Item> DECO_CIGAR = ITEMS.register(
            "deco_cigar",
            DecoCigarItem::new
    );

    // Block items
    public static final DeferredItem<BlockItem> TOBACCO_PLANT_ITEM = ITEMS.registerSimpleBlockItem(
            "tobacco_plant", HarmfulsmokeBlocks.TOBACCO_PLANT
    );

    public static final DeferredItem<BlockItem> WILD_TOBACCO_PLANT_ITEM = ITEMS.registerSimpleBlockItem(
            "wild_tobacco_plant", HarmfulsmokeBlocks.WILD_TOBACCO_PLANT
    );
}
