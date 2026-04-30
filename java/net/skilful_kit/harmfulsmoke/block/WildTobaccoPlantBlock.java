package net.skilful_kit.harmfulsmoke.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class WildTobaccoPlantBlock extends FlowerBlock {

    public WildTobaccoPlantBlock(Supplier<MobEffect> effect, int effectDuration, BlockBehaviour.Properties properties) {
        super(effect, effectDuration, properties);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;
    }
}
