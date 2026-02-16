package com.sumrakk.thelionkingremake.world.gen.tree;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import com.sumrakk.thelionkingremake.world.gen.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TwoLayerFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class BananaTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        // Используем фичу с бананами
        BaseTreeFeatureConfig config = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(ModBlocks.BANANA_LOG.get().getDefaultState()),
                new SimpleBlockStateProvider(ModBlocks.BANANALEAVES.get().getDefaultState()),
                null,
                null,
                new TwoLayerFeature(0, 0, 0)
        ).build();

        return ModFeatures.BANANA_TREE.get().withConfiguration(config);
    }
}