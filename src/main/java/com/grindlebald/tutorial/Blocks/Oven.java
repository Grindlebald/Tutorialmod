package com.grindlebald.tutorial.Blocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 5, 1, 16, 10, 2),
            Block.makeCuboidShape(0, 7, 2, 16, 8, 14),
            Block.makeCuboidShape(0, 1, 6, 16, 2, 10),
            Block.makeCuboidShape(0, 2, 5, 16, 3, 11),
            Block.makeCuboidShape(0, 3, 4, 16, 4, 12),
            Block.makeCuboidShape(0, 4, 3, 16, 5, 13),
            Block.makeCuboidShape(0, 10, 3, 16, 11, 13),
            Block.makeCuboidShape(0, 12, 5, 16, 13, 11),
            Block.makeCuboidShape(0, 11, 4, 16, 12, 12),
            Block.makeCuboidShape(0, 13, 6, 16, 14, 10),
            Block.makeCuboidShape(0, 5, 2, 16, 6, 14),
            Block.makeCuboidShape(0, 6, 2, 16, 7, 14),
            Block.makeCuboidShape(0, 8, 2, 16, 9, 14),
            Block.makeCuboidShape(0, 9, 2, 16, 10, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(14, 5, 0, 15, 10, 16),
            Block.makeCuboidShape(2, 5, 0, 14, 8, 16),
            Block.makeCuboidShape(6, 1, 0, 10, 2, 16),
            Block.makeCuboidShape(5, 2, 0, 11, 3, 16),
            Block.makeCuboidShape(4, 3, 0, 12, 4, 16),
            Block.makeCuboidShape(3, 4, 0, 13, 5, 16),
            Block.makeCuboidShape(3, 10, 0, 13, 11, 16),
            Block.makeCuboidShape(5, 12, 0, 11, 13, 16),
            Block.makeCuboidShape(4, 11, 0, 12, 12, 16),
            Block.makeCuboidShape(6, 13, 0, 10, 14, 16),
            Block.makeCuboidShape(2, 5, 0, 14, 6, 16),
            Block.makeCuboidShape(2, 6, 0, 14, 7, 16),
            Block.makeCuboidShape(2, 8, 0, 14, 9, 16),
            Block.makeCuboidShape(2, 9, 0, 14, 10, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 5, 14., 16, 10, 15),
            Block.makeCuboidShape(0, 7, 2, 16, 8, 14),
            Block.makeCuboidShape(0, 1, 6, 16, 2, 10),
            Block.makeCuboidShape(0, 2, 5, 16, 3, 11),
            Block.makeCuboidShape(0, 3, 4, 16, 4, 12),
            Block.makeCuboidShape(0, 4, 3, 16, 5, 13),
            Block.makeCuboidShape(0, 10, 3, 16, 11, 13),
            Block.makeCuboidShape(0, 12, 5, 16, 13, 11),
            Block.makeCuboidShape(0, 11, 4, 16, 12, 12),
            Block.makeCuboidShape(0, 13, 6, 16, 14, 10),
            Block.makeCuboidShape(0, 5, 2, 16, 6, 14),
            Block.makeCuboidShape(0, 6, 2, 16, 7, 14),
            Block.makeCuboidShape(0, 8, 2, 16, 9, 14),
            Block.makeCuboidShape(0, 9, 2, 16, 10, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 5, 0, 2, 10    , 16),
            Block.makeCuboidShape(2, 7, 0, 14, 8, 16),
            Block.makeCuboidShape(6, 1, 0, 10, 2, 16),
            Block.makeCuboidShape(5, 2, 0, 11, 3, 16),
            Block.makeCuboidShape(4, 3, 0, 12, 4, 16),
            Block.makeCuboidShape(3, 4, 0, 13, 5, 16),
            Block.makeCuboidShape(3, 10, 0, 13, 11, 16),
            Block.makeCuboidShape(5, 12, 0, 11, 13, 16),
            Block.makeCuboidShape(4, 11, 0, 12, 12, 16),
            Block.makeCuboidShape(6, 13, 0, 10, 14, 16),
            Block.makeCuboidShape(2, 5, 0, 14, 6, 16),
            Block.makeCuboidShape(2, 6, 0, 14, 7, 16),
            Block.makeCuboidShape(2, 8, 0, 14, 9, 16),
            Block.makeCuboidShape(2, 9, 0, 14, 10, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public Oven() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5F, 4.0F)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());}

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
}