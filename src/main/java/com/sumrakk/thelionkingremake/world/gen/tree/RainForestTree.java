package com.sumrakk.thelionkingremake.world.gen.tree;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import com.sumrakk.thelionkingremake.world.gen.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;

import javax.annotation.Nullable;
import java.util.Random;

public class RainForestTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        // 10% шанс на ГИГАНТСКОЕ дерево
        if (random.nextInt(10) == 0) {
            // ГИГАНТСКОЕ дерево
            BaseTreeFeatureConfig config = new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.RAINFOREST_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.RAINFORESTLEAVES.get().getDefaultState()),
                    null,
                    null,
                    new TwoLayerFeature(0, 0, 0)
            ).build();

            return ModFeatures.GIANT_TWO_LAYER_RAINFOREST_TREE.get().withConfiguration(config);

        } else {
            // Обычное дерево
            BaseTreeFeatureConfig config = new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.RAINFOREST_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.RAINFORESTLEAVES.get().getDefaultState()),
                    null,
                    null,
                    new TwoLayerFeature(0, 0, 0)
            ).build();

            return ModFeatures.TWO_LAYER_RAINFOREST_TREE.get().withConfiguration(config);
        }
    }
}