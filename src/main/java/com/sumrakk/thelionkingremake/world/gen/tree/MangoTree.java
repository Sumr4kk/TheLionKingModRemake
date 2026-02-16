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

public class MangoTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        // Используем НАШУ кастомную фичу с плодами
        BaseTreeFeatureConfig config = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(ModBlocks.MANGO_LOG.get().getDefaultState()),
                new SimpleBlockStateProvider(ModBlocks.MANGOLEAVES.get().getDefaultState()),
                null,
                null,
                new TwoLayerFeature(0, 0, 0)
        ).build();

        return ModFeatures.MANGO_TREE.get().withConfiguration(config);
    }
}