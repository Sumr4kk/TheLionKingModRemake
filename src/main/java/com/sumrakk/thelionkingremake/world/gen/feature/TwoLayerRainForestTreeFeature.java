package com.sumrakk.thelionkingremake.world.gen.feature;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class TwoLayerRainForestTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public TwoLayerRainForestTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
        // Определяем размер дерева
        boolean isLarge = rand.nextInt(5) < 2; // 40% большое, 60% маленькое

        int trunkHeight;
        int middleLayerHeight;
        int topLayerHeight;

        if (isLarge) {
            // БОЛЬШОЕ ДЕРЕВО (2x2 ствол)
            trunkHeight = 14 + rand.nextInt(6); // 14-20 блоков
            middleLayerHeight = 6 + rand.nextInt(3); // листва на высоте 6-8
            topLayerHeight = trunkHeight - 2; // шапка наверху
        } else {
            // МАЛЕНЬКОЕ ДЕРЕВО (1x1 ствол)
            trunkHeight = 8 + rand.nextInt(4); // 8-12 блоков
            middleLayerHeight = 4 + rand.nextInt(2); // листва на высоте 4-5
            topLayerHeight = trunkHeight - 1; // шапка наверху
        }

        // Проверяем, достаточно ли места
        BlockPos topPos = pos.up(trunkHeight + 3);
        if (!world.isAreaLoaded(topPos, 5) || !world.isAirBlock(topPos)) {
            return false;
        }

        // ============= ГЕНЕРИРУЕМ СТВОЛ =============
        if (isLarge) {
            // Ствол 2x2 для большого дерева
            for (int y = 0; y <= trunkHeight; y++) {
                world.setBlockState(pos.add(0, y, 0), ModBlocks.RAINFOREST_LOG.get().getDefaultState(), 3);
                world.setBlockState(pos.add(1, y, 0), ModBlocks.RAINFOREST_LOG.get().getDefaultState(), 3);
                world.setBlockState(pos.add(0, y, 1), ModBlocks.RAINFOREST_LOG.get().getDefaultState(), 3);
                world.setBlockState(pos.add(1, y, 1), ModBlocks.RAINFOREST_LOG.get().getDefaultState(), 3);
            }
        } else {
            // Ствол 1x1 для маленького дерева
            for (int y = 0; y <= trunkHeight; y++) {
                world.setBlockState(pos.up(y), ModBlocks.RAINFOREST_LOG.get().getDefaultState(), 3);
            }
        }

        // ============= ГЕНЕРИРУЕМ НИЖНИЙ СЛОЙ ЛИСТВЫ (ПОСЕРЕДИНЕ) =============
        generateLeafLayer(world, rand, pos.up(middleLayerHeight), isLarge ? 3 : 2);

        // ============= ГЕНЕРИРУЕМ ВЕРХНИЙ СЛОЙ ЛИСТВЫ (ШАПКА) =============
        generateTopLeaves(world, rand, pos.up(topLayerHeight), isLarge ? 4 : 3, isLarge);

        return true;
    }

    private void generateLeafLayer(ISeedReader world, Random rand, BlockPos center, int radius) {
        BlockState leaves = ModBlocks.RAINFORESTLEAVES.get().getDefaultState();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z <= radius * radius + 1) {
                    BlockPos leafPos = center.add(x, 0, z);
                    if (world.isAirBlock(leafPos) || world.getBlockState(leafPos).getBlock() == ModBlocks.RAINFOREST_LOG.get()) {
                        world.setBlockState(leafPos, leaves, 3);
                    }

                    // Добавляем немного листвы на 1 блок ниже по краям
                    if (Math.abs(x) == radius || Math.abs(z) == radius) {
                        BlockPos lowerPos = center.add(x, -1, z);
                        if (world.isAirBlock(lowerPos) && rand.nextInt(3) == 0) {
                            world.setBlockState(lowerPos, leaves, 3);
                        }
                    }
                }
            }
        }
    }

    // Генерирует шапку листвы наверху (многослойную)
    private void generateTopLeaves(ISeedReader world, Random rand, BlockPos center, int radius, boolean isLarge) {
        BlockState leaves = ModBlocks.RAINFORESTLEAVES.get().getDefaultState();

        // Нижний слой шапки
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z <= radius * radius + 1) {
                    BlockPos leafPos = center.add(x, 0, z);
                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Средний слой
        for (int x = -(radius-1); x <= (radius-1); x++) {
            for (int z = -(radius-1); z <= (radius-1); z++) {
                if (x * x + z * z <= (radius-1) * (radius-1) + 1) {
                    BlockPos leafPos = center.add(x, 1, z);
                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Верхний слой (макушка)
        BlockPos topPos = center.up(2);
        world.setBlockState(topPos, leaves, 3);

        // Боковые свисающие листья (как лианы)
        if (isLarge) {
            for (int i = 0; i < 4; i++) {
                BlockPos sidePos = center.add(rand.nextInt(radius*2) - radius, -1, rand.nextInt(radius*2) - radius);
                if (world.isAirBlock(sidePos) && world.getBlockState(sidePos.down()).getBlock() == ModBlocks.RAINFOREST_LOG.get()) {
                    world.setBlockState(sidePos, leaves, 3);
                }
            }
        }
    }
}