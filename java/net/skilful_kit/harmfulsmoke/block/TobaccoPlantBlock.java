package net.skilful_kit.harmfulsmoke.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.ItemLike;
import net.skilful_kit.harmfulsmoke.init.HarmfulsmokeItems;

public class TobaccoPlantBlock extends CropBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            box(0, 0, 0, 16, 4, 16),
            box(0, 0, 0, 16, 6, 16),
            box(0, 0, 0, 16, 8, 16),
            box(0, 0, 0, 16, 10, 16),
            box(0, 0, 0, 16, 13, 16),
            box(0, 0, 0, 16, 16, 16)
    };

    public TobaccoPlantBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return HarmfulsmokeItems.TOBACCO_SEEDS.get();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[Math.min(state.getValue(AGE), SHAPE_BY_AGE.length - 1)];
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(net.minecraft.world.level.block.Blocks.FARMLAND);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(AGE);
    }
}
