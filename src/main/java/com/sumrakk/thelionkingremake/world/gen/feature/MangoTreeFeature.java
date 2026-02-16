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

public class MangoTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public MangoTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
        // Параметры дерева манго - как дуб
        int trunkHeight = 4 + rand.nextInt(4);  // 4-8 блоков

        // Проверяем место
        BlockPos topPos = pos.up(trunkHeight + 4);
        if (!world.isAreaLoaded(topPos, 4) || !world.isAirBlock(topPos)) {
            return false;
        }

        BlockState log = ModBlocks.MANGO_LOG.get().getDefaultState();
        BlockState leaves = ModBlocks.MANGOLEAVES.get().getDefaultState();
        BlockState fruit = ModBlocks.MANGO_FRUIT.get().getDefaultState();

        // ============= ГЕНЕРИРУЕМ СТВОЛ =============
        for (int y = 0; y < trunkHeight; y++) {
            world.setBlockState(pos.up(y), log, 3);
        }

        // ============= ГЕНЕРИРУЕМ КРОНУ =============
        BlockPos crownPos = pos.up(trunkHeight - 1);

        // Нижний слой кроны (радиус 2)
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (x * x + z * z <= 5) {
                    BlockPos leafPos = crownPos.add(x, 0, z);
                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Второй слой кроны (радиус 1)
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos leafPos = crownPos.add(x, 1, z);
                if (world.isAirBlock(leafPos)) {
                    world.setBlockState(leafPos, leaves, 3);
                }
            }
        }

        // Третий слой (центр)
        world.setBlockState(crownPos.up(2), leaves, 3);

        // ============= ГЕНЕРИРУЕМ ПЛОДЫ МАНГО =============
        generateFruits(world, rand, crownPos, fruit);

        return true;
    }

    private void generateFruits(ISeedReader world, Random rand, BlockPos crownPos, BlockState fruit) {
        // 4-5 плодов на дерево
        int numFruits = 4 + rand.nextInt(2);  // 4-5 плодов

        // Список занятых позиций (чтобы не ставить несколько плодов в одно место)
        java.util.HashSet<BlockPos> usedPositions = new java.util.HashSet<>();

        for (int i = 0; i < numFruits; i++) {
            // Пытаемся найти свободное место (максимум 20 попыток)
            for (int attempt = 0; attempt < 20; attempt++) {

                // Выбираем случайную позицию в кроне
                int fruitX = rand.nextInt(5) - 2;  // -2 до 2
                int fruitZ = rand.nextInt(5) - 2;
                int fruitY = rand.nextInt(3);      // 0, 1, 2

                BlockPos leafPos = crownPos.add(fruitX, fruitY, fruitZ);

                // Проверяем, что это листва
                if (world.getBlockState(leafPos).getBlock() == ModBlocks.MANGOLEAVES.get()) {

                    // Плод свисает СНИЗУ
                    BlockPos fruitPos = leafPos.down();

                    // Проверяем, что место свободно и не занято
                    if (world.isAirBlock(fruitPos) && !usedPositions.contains(fruitPos)) {

                        // Ставим плод
                        world.setBlockState(fruitPos, fruit, 3);
                        usedPositions.add(fruitPos);
                        break;  // Нашли место, выходим из попыток
                    }
                }
            }
        }

        // Добавляем немного плодов по краям кроны
        int extraFruits = 1 + rand.nextInt(2);  // 1-2 дополнительных плода

        for (int i = 0; i < extraFruits; i++) {
            for (int attempt = 0; attempt < 20; attempt++) {
                int x = rand.nextInt(5) - 2;
                int z = rand.nextInt(5) - 2;

                if (Math.abs(x) >= 1 || Math.abs(z) >= 1) {  // Не центр
                    BlockPos edgePos = crownPos.add(x, 0, z);

                    if (world.getBlockState(edgePos).getBlock() == ModBlocks.MANGOLEAVES.get()) {
                        BlockPos fruitPos = edgePos.down();

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
}