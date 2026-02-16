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

public class BananaTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public BananaTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
        // Параметры дерева банана - форма как у пальмы
        int trunkHeight = 5 + rand.nextInt(6);  // 5-11 блоков

        // Проверяем место
        BlockPos topPos = pos.up(trunkHeight + 4);
        if (!world.isAreaLoaded(topPos, 4) || !world.isAirBlock(topPos)) {
            return false;
        }

        BlockState log = ModBlocks.BANANA_LOG.get().getDefaultState();
        BlockState leaves = ModBlocks.BANANALEAVES.get().getDefaultState();
        BlockState fruit = ModBlocks.BANANA_FRUIT.get().getDefaultState();

        // ============= ГЕНЕРИРУЕМ СТВОЛ =============
        for (int y = 0; y < trunkHeight; y++) {
            world.setBlockState(pos.up(y), log, 3);
        }

        // ============= ГЕНЕРИРУЕМ КРОНУ (ПЛОСКАЯ) =============
        BlockPos crownPos = pos.up(trunkHeight - 1);

        // Плоская крона как у пальмы (Acacia стиль)
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (Math.abs(x) + Math.abs(z) <= 3) {
                    BlockPos leafPos = crownPos.add(x, 0, z);
                    if (world.isAirBlock(leafPos)) {
                        world.setBlockState(leafPos, leaves, 3);
                    }
                }
            }
        }

        // Второй слой
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos leafPos = crownPos.add(x, 1, z);
                if (world.isAirBlock(leafPos)) {
                    world.setBlockState(leafPos, leaves, 3);
                }
            }
        }

        // ============= ГЕНЕРИРУЕМ ПЛОДЫ БАНАНА =============
        generateFruits(world, rand, crownPos, fruit);

        return true;
    }

    private void generateFruits(ISeedReader world, Random rand, BlockPos crownPos, BlockState fruit) {
        // 4-6 бананов на дерево
        int numFruits = 4 + rand.nextInt(3);  // 4-6 плодов

        HashSet<BlockPos> usedPositions = new HashSet<>();

        for (int i = 0; i < numFruits; i++) {
            for (int attempt = 0; attempt < 20; attempt++) {

                // Бананы свисают с краев кроны
                int fruitX = rand.nextInt(5) - 2;
                int fruitZ = rand.nextInt(5) - 2;

                // Бананы обычно свисают гроздьями, ставим их чуть ниже
                BlockPos fruitPos = crownPos.add(fruitX, -1, fruitZ);

                // Проверяем, что сверху есть листва и место свободно
                BlockPos abovePos = fruitPos.up();
                if (world.getBlockState(abovePos).getBlock() == ModBlocks.BANANALEAVES.get() &&
                        world.isAirBlock(fruitPos) && !usedPositions.contains(fruitPos)) {

                    world.setBlockState(fruitPos, fruit, 3);
                    usedPositions.add(fruitPos);
                    break;
                }
            }
        }

        // Добавляем немного бананов на самой кроне
        int extraFruits = 1 + rand.nextInt(2);  // 1-2 дополнительных

        for (int i = 0; i < extraFruits; i++) {
            for (int attempt = 0; attempt < 10; attempt++) {
                int x = rand.nextInt(3) - 1;
                int z = rand.nextInt(3) - 1;

                if (x != 0 || z != 0) {
                    BlockPos fruitPos = crownPos.add(x, 0, z);

                    if (world.getBlockState(fruitPos).getBlock() == ModBlocks.BANANALEAVES.get()) {
                        BlockPos belowPos = fruitPos.down();
                        if (world.isAirBlock(belowPos) && !usedPositions.contains(belowPos)) {
                            world.setBlockState(belowPos, fruit, 3);
                            usedPositions.add(belowPos);
                            break;
                        }
                    }
                }
            }
        }
    }
}