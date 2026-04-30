package net.skilful_kit.harmfulsmoke.init;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.core.registries.Registries;
import net.skilful_kit.harmfulsmoke.HarmfulsmokeMod;
import net.skilful_kit.harmfulsmoke.block.TobaccoPlantBlock;
import net.skilful_kit.harmfulsmoke.block.WildTobaccoPlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class HarmfulsmokeBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, HarmfulsmokeMod.MODID);

    public static final DeferredBlock<TobaccoPlantBlock> TOBACCO_PLANT = BLOCKS.register(
            "tobacco_plant",
            () -> new TobaccoPlantBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .noCollission()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .noOcclusion()
                            .pushReaction(PushReaction.DESTROY)
            )
    );

    public static final DeferredBlock<WildTobaccoPlantBlock> WILD_TOBACCO_PLANT = BLOCKS.register(
            "wild_tobacco_plant",
            () -> new WildTobaccoPlantBlock(
                    (Supplier<net.minecraft.world.effect.MobEffect>) () -> HarmfulsmokeEffects.TOBACCO_EXPOSURE.get(),
                    5,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .sound(SoundType.GRASS)
                            .offsetType(BlockBehaviour.OffsetType.XZ)
                            .noCollission()
                            .instabreak()
                            .pushReaction(PushReaction.DESTROY)
                            .noOcclusion()
            )
    );
}
