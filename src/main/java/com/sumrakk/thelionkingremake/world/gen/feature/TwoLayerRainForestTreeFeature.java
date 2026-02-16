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
        // Определяем размер по registry name фичи
        boolean isGiant = this.getRegistryName() != null && this.getRegistryName().getPath().contains("giant");

        int trunkHeight;
        int middleLayerHeight;
        int topLayerHeight;
        int middleLeafRadius;
        int topLeafRadius;

        if (isGiant) {
            // ============= ГИГАНТСКОЕ ДЕРЕВО =============
            trunkHeight = 30 + rand.nextInt(20);      // 30-50 блоков
            middleLayerHeight = 12 + rand.nextInt(8);  // листва посередине (12-20 блоков)
            topLayerHeight = trunkHeight - 3;          // шапка чуть ниже верхушки
            middleLeafRadius = 4;                        // Средняя крона радиус 4
            topLeafRadius = 5;                           // Верхняя крона радиус 5
        } else {
            // ============= ОБЫЧНОЕ ДЕРЕВО =============
            trunkHeight = 12 + rand.nextInt(8);        // 12-20 блоков
            middleLayerHeight = 5 + rand.nextInt(5);    // листва посередине (5-10 блоков)
            topLayerHeight = trunkHeight - 2;           // шапка наверху
            middleLeafRadius = 3;                         // Средняя крона радиус 3
            topLeafRadius = 4;                            // Верхняя крона радиус 4
        }

        // Проверяем, достаточно ли места
        BlockPos topPos = pos.up(trunkHeight + topLeafRadius + 3);
        if (!world.isAreaLoaded(topPos, topLeafRadius + 3) || !world.isAirBlock(topPos)) {
            return false;
        }

        BlockState log = ModBlocks.RAINFOREST_LOG.get().getDefaultState();
        BlockState leaves = ModBlocks.RAINFORESTLEAVES.get().getDefaultState();

        // ============= ГЕНЕРИРУЕМ СТВОЛ 1x1 =============
        for (int y = 0; y <= trunkHeight; y++) {
            world.setBlockState(pos.up(y), log, 3);
        }

        // ============= ГЕНЕРИРУЕМ НИЖНИЙ СЛОЙ ЛИСТВЫ (ПОСЕРЕДИНЕ) =============
        generateLeafLayer(world, rand, pos.up(middleLayerHeight), middleLeafRadius, leaves);

        // ============= ГЕНЕРИРУЕМ ВЕРХНИЙ СЛОЙ ЛИСТВЫ (ШАПКА) =============
        generateTopLeaves(world, rand, pos.up(topLayerHeight), topLeafRadius, leaves);

        return true;
    }

    private void generateLeafLayer(ISeedReader world, Random rand, BlockPos center, int radius, BlockState leaves) {
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                // Делаем круг, а не квадрат
                if (x * x + z * z <= radius * radius + 1) {
                    BlockPos leafPos = center.add(x, 0, z);

                    // НЕ ставим листву на ствол
                    if (x == 0 && z == 0) continue;

                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }

                    // Добавляем свисающие листья вниз по краям
                    if (Math.abs(x) >= radius-1 || Math.abs(z) >= radius-1) {
                        for (int down = 1; down <= 2; down++) {
                            BlockPos lowerPos = center.add(x, -down, z);
                            if (world.isAirBlock(lowerPos) && rand.nextInt(3) == 0) {
                                world.setBlockState(lowerPos, leaves, 3);
                            }
                        }
                    }
                }
            }
        }
    }

    private void generateTopLeaves(ISeedReader world, Random rand, BlockPos center, int radius, BlockState leaves) {
        // Нижний слой шапки (Y = 0)
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z <= radius * radius + 1) {
                    BlockPos leafPos = center.add(x, 0, z);

                    // НЕ ставим листву на ствол
                    if (x == 0 && z == 0) continue;

                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Второй слой (Y = 1)
        int midRadius = radius;
        for (int x = -midRadius; x <= midRadius; x++) {
            for (int z = -midRadius; z <= midRadius; z++) {
                if (x * x + z * z <= midRadius * midRadius + 1) {
                    BlockPos leafPos = center.add(x, 1, z);

                    // НЕ ставим листву на ствол
                    if (x == 0 && z == 0) continue;

                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Третий слой (Y = 2)
        int topRadius = radius - 1;
        for (int x = -topRadius; x <= topRadius; x++) {
            for (int z = -topRadius; z <= topRadius; z++) {
                if (x * x + z * z <= topRadius * topRadius + 1) {
                    BlockPos leafPos = center.add(x, 2, z);

                    // НЕ ставим листву на ствол
                    if (x == 0 && z == 0) continue;

                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Макушка (Y = 3) - маленький пучок
        int tinyRadius = radius - 2;
        if (tinyRadius > 0) {
            for (int x = -tinyRadius; x <= tinyRadius; x++) {
                for (int z = -tinyRadius; z <= tinyRadius; z++) {
                    if (x * x + z * z <= tinyRadius * tinyRadius + 1) {
                        BlockPos leafPos = center.add(x, 3, z);

                        // НЕ ставим листву на ствол
                        if (x == 0 && z == 0) continue;

                        if (world.isAirBlock(leafPos)) {
                            world.setBlockState(leafPos, leaves, 3);
                        }
                    }
                }
            }
        } else {
            // Если дерево маленькое, просто ставим одну листву сверху (не на ствол)
            BlockPos topPos = center.add(1, 3, 0);
            if (world.isAirBlock(topPos)) {
                world.setBlockState(topPos, leaves, 3);
            }
            topPos = center.add(-1, 3, 0);
            if (world.isAirBlock(topPos)) {
                world.setBlockState(topPos, leaves, 3);
            }
            topPos = center.add(0, 3, 1);
            if (world.isAirBlock(topPos)) {
                world.setBlockState(topPos, leaves, 3);
            }
            topPos = center.add(0, 3, -1);
            if (world.isAirBlock(topPos)) {
                world.setBlockState(topPos, leaves, 3);
            }
        }

        // Свисающие листья с нижнего слоя шапки
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z <= radius * radius + 1) {
                    // Пропускаем ствол
                    if (x == 0 && z == 0) continue;

                    // Свисаем вниз на 1-2 блока с краев
                    if (Math.abs(x) >= radius-1 || Math.abs(z) >= radius-1) {
                        for (int down = 1; down <= 2; down++) {
                            BlockPos lowerPos = center.add(x, -down, z);
                            if (world.isAirBlock(lowerPos) && rand.nextInt(3) == 0) {
                                // Проверяем, не над стволом ли это
                                boolean overTrunk = false;
                                for (int checkY = 0; checkY < down; checkY++) {
                                    if (world.getBlockState(lowerPos.up(checkY)).getBlock() == ModBlocks.RAINFOREST_LOG.get()) {
                                        overTrunk = true;
                                        break;
                                    }
                                }
                                if (!overTrunk) {
                                    world.setBlockState(lowerPos, leaves, 3);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}