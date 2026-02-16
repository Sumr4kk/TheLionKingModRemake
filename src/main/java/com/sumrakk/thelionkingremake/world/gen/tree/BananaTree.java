package com.sumrakk.thelionkingremake.world.gen.tree;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class BananaTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        // Выбираем размер случайно
        int height = 5 + random.nextInt(5); // 5-10 блоков
        int leafRadius = 2 + random.nextInt(2); // 2-3 блока

        BaseTreeFeatureConfig.Builder builder = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()),
                new SimpleBlockStateProvider(ModBlocks.BANANALEAVES.get().getDefaultState()),
                new AcaciaFoliagePlacer(
                        FeatureSpread.create(leafRadius),
                        FeatureSpread.create(0)
                ),
                new StraightTrunkPlacer(height, 1, 1),
                new TwoLayerFeature(1, 0, 1)
        );

        return Feature.TREE.withConfiguration(builder.build());
    }
}