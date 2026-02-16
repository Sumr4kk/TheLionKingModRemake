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

public class PassionTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public PassionTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
        // Параметры дерева маракуйи - как лиана, извилистое
        int trunkHeight = 6 + rand.nextInt(8);  // 6-14 блоков

        // Проверяем место
        BlockPos topPos = pos.up(trunkHeight + 4);
        if (!world.isAreaLoaded(topPos, 4) || !world.isAirBlock(topPos)) {
            return false;
        }

        BlockState log = ModBlocks.PASSION_LOG.get().getDefaultState();
        BlockState leaves = ModBlocks.PASSIONLEAVES.get().getDefaultState();

        // ============= ГЕНЕРИРУЕМ ИЗВИЛИСТЫЙ СТВОЛ =============
        BlockPos currentPos = pos;
        for (int y = 0; y < trunkHeight; y++) {
            // Ствол 1x1
            world.setBlockState(currentPos, log, 3);

            // Иногда делаем небольшое смещение для извилистости
            if (y > 2 && y < trunkHeight - 2 && rand.nextInt(4) == 0) {
                if (rand.nextBoolean()) {
                    currentPos = currentPos.add(1, 1, 0);
                } else {
                    currentPos = currentPos.add(-1, 1, 0);
                }
                if (rand.nextBoolean()) {
                    currentPos = currentPos.add(0, 0, 1);
                } else {
                    currentPos = currentPos.add(0, 0, -1);
                }
            } else {
                currentPos = currentPos.up();
            }
        }

        // ============= ГЕНЕРИРУЕМ ЛИСТВУ ПУЧКАМИ =============
        generateLeafClusters(world, rand, pos, trunkHeight, leaves);

        return true;
    }

    private void generateLeafClusters(ISeedReader world, Random rand, BlockPos startPos, int trunkHeight, BlockState leaves) {
        // Создаем несколько пучков листвы вдоль ствола
        int numClusters = 3 + rand.nextInt(3); // 3-5 пучков

        for (int i = 0; i < numClusters; i++) {
            int clusterY = 2 + rand.nextInt(trunkHeight - 3); // высота пучка
            BlockPos clusterPos = startPos.up(clusterY);

            // Размер пучка
            int clusterSize = 1 + rand.nextInt(2); // 1-2

            // Генерируем пучок листвы
            for (int x = -clusterSize; x <= clusterSize; x++) {
                for (int z = -clusterSize; z <= clusterSize; z++) {
                    // Делаем круглую форму
                    if (x * x + z * z <= clusterSize * clusterSize + 1) {
                        // Не ставим на ствол
                        if (x == 0 && z == 0) continue;

                        BlockPos leafPos = clusterPos.add(x, 0, z);
                        if (world.isAirBlock(leafPos) && rand.nextInt(3) != 0) {
                            world.setBlockState(leafPos, leaves, 3);
                        }

                        // Иногда добавляем листву выше/ниже
                        if (rand.nextInt(3) == 0) {
                            BlockPos leafUp = clusterPos.add(x, 1, z);
                            if (world.isAirBlock(leafUp)) {
                                world.setBlockState(leafUp, leaves, 3);
                            }
                        }
                        if (rand.nextInt(3) == 0) {
                            BlockPos leafDown = clusterPos.add(x, -1, z);
                            if (world.isAirBlock(leafDown)) {
                                world.setBlockState(leafDown, leaves, 3);
                            }
                        }
                    }
                }
            }

            // Добавляем свисающие лианы с пучков
            for (int side = 0; side < 4; side++) {
                if (rand.nextInt(3) == 0) {
                    BlockPos vineStart = clusterPos.add(
                            side == 0 ? clusterSize : (side == 1 ? -clusterSize : 0),
                            0,
                            side == 2 ? clusterSize : (side == 3 ? -clusterSize : 0)
                    );

                    // Свисаем вниз на 1-2 блока
                    for (int down = 1; down <= 2; down++) {
                        BlockPos vinePos = vineStart.down(down);
                        if (world.isAirBlock(vinePos) && rand.nextInt(2) == 0) {
                            world.setBlockState(vinePos, leaves, 3);
                        }
                    }
                }
            }
        }

        // Большой пучок на верхушке
        BlockPos topPos = startPos.up(trunkHeight);
        int topSize = 2;
        for (int x = -topSize; x <= topSize; x++) {
            for (int z = -topSize; z <= topSize; z++) {
                if (x * x + z * z <= topSize * topSize + 1) {
                    if (x == 0 && z == 0) continue;

                    BlockPos leafPos = topPos.add(x, 0, z);
                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }

                    // Верхний слой
                    BlockPos leafUp = topPos.add(x, 1, z);
                    if (world.isAirBlock(leafUp) && (x * x + z * z <= (topSize-1) * (topSize-1) + 1)) {
                        world.setBlockState(leafUp, leaves, 3);
                    }
                }
            }
        }

        // Макушка
        world.setBlockState(topPos.up(2), leaves, 3);
    }
}