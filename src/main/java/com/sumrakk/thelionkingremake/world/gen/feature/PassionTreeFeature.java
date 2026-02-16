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
import java.util.HashSet;

public class PassionTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public PassionTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
        // Параметры лианы маракуйи
        int vineHeight = 6 + rand.nextInt(6);  // 6-12 блоков

        // Проверяем место
        BlockPos topPos = pos.up(vineHeight + 4);
        if (!world.isAreaLoaded(topPos, 4) || !world.isAirBlock(topPos)) {
            return false;
        }

        BlockState log = ModBlocks.PASSION_LOG.get().getDefaultState();
        BlockState leaves = ModBlocks.PASSIONLEAVES.get().getDefaultState();
        BlockState fruit = ModBlocks.PASSION_FRUIT.get().getDefaultState();

        // ============= ГЕНЕРИРУЕМ ИЗВИЛИСТЫЙ СТВОЛ =============
        BlockPos currentPos = pos;
        for (int y = 0; y < vineHeight; y++) {
            world.setBlockState(currentPos, log, 3);

            // Плавные изгибы (реже и мягче)
            if (y > 2 && y < vineHeight - 2 && rand.nextInt(7) == 0) {
                int dir = rand.nextInt(4);
                if (dir == 0 && world.isAirBlock(currentPos.north().up()))
                    currentPos = currentPos.north();
                else if (dir == 1 && world.isAirBlock(currentPos.south().up()))
                    currentPos = currentPos.south();
                else if (dir == 2 && world.isAirBlock(currentPos.east().up()))
                    currentPos = currentPos.east();
                else if (dir == 3 && world.isAirBlock(currentPos.west().up()))
                    currentPos = currentPos.west();
            }
            currentPos = currentPos.up();
        }

        // ============= ГЕНЕРИРУЕМ ЛИСТВУ =============
        // Верхушка (основная крона)
        BlockPos topPos2 = pos.up(vineHeight - 1);
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                // Круглая форма, а не квадрат
                if (x * x + z * z <= 5) {
                    BlockPos leafPos = topPos2.add(x, 0, z);
                    if (world.isAirBlock(leafPos) && rand.nextBoolean()) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Несколько листьев вдоль ствола (случайно)
        for (int y = 2; y < vineHeight - 2; y += 2) {
            if (rand.nextInt(3) == 0) {
                BlockPos sidePos = pos.up(y);
                for (int i = 0; i < 4; i++) {
                    int dir = rand.nextInt(4);
                    BlockPos leafPos = null;
                    if (dir == 0) leafPos = sidePos.north();
                    else if (dir == 1) leafPos = sidePos.south();
                    else if (dir == 2) leafPos = sidePos.east();
                    else leafPos = sidePos.west();

                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                        break;
                    }
                }
            }
        }

        // ============= ГЕНЕРИРУЕМ ПЛОДЫ МАРАКУЙИ =============
        generateFruits(world, rand, pos, vineHeight, fruit);

        return true;
    }

    private void generateFruits(ISeedReader world, Random rand, BlockPos startPos, int vineHeight, BlockState fruit) {
        // МЕНЬШЕ плодов: 3-5 штук
        int numFruits = 3 + rand.nextInt(3);  // 3-5 плодов

        HashSet<BlockPos> usedPositions = new HashSet<>();

        for (int i = 0; i < numFruits; i++) {
            for (int attempt = 0; attempt < 30; attempt++) {

                // Выбираем высоту вдоль ствола (не слишком низко и не слишком высоко)
                int fruitY = 3 + rand.nextInt(vineHeight - 5);
                BlockPos vinePos = startPos.up(fruitY);

                // Выбираем направление
                int side = rand.nextInt(4);
                BlockPos fruitPos = null;

                if (side == 0) fruitPos = vinePos.north();
                else if (side == 1) fruitPos = vinePos.south();
                else if (side == 2) fruitPos = vinePos.east();
                else fruitPos = vinePos.west();

                // УБРАЛИ ГРОЗДЬЯ - просто один плод

                // Проверяем место
                if (world.isAirBlock(fruitPos) && !usedPositions.contains(fruitPos)) {

                    // Проверяем, есть ли рядом ствол или листва
                    boolean hasSupport = false;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dz = -1; dz <= 1; dz++) {
                            BlockPos checkPos = fruitPos.add(dx, 0, dz);
                            if (world.getBlockState(checkPos).getBlock() == ModBlocks.PASSION_LOG.get() ||
                                    world.getBlockState(checkPos).getBlock() == ModBlocks.PASSIONLEAVES.get()) {
                                hasSupport = true;
                            }
                        }
                    }

                    if (hasSupport) {
                        world.setBlockState(fruitPos, fruit, 3);
                        usedPositions.add(fruitPos);
                        break;
                    }
                }
            }
        }

        // Один-два плода на верхушке
        int topFruits = 1 + rand.nextInt(2);  // 1-2 плода

        for (int i = 0; i < topFruits; i++) {
            for (int attempt = 0; attempt < 10; attempt++) {
                int x = rand.nextInt(3) - 1;
                int z = rand.nextInt(3) - 1;

                if (x != 0 || z != 0) {
                    BlockPos fruitPos = startPos.up(vineHeight).add(x, -1, z);
                    if (world.isAirBlock(fruitPos) && !usedPositions.contains(fruitPos)) {
                        world.setBlockState(fruitPos, fruit, 3);
                        usedPositions.add(fruitPos);
                        break;
                    }
                }
            }
        }
    }
}