package com.sumrakk.thelionkingremake.world.gen.tree;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class PrideTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        BaseTreeFeatureConfig config = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(ModBlocks.ACACIA_LOG.get().getDefaultState()),      // ВАШЕ бревно
                new SimpleBlockStateProvider(ModBlocks.ACACIALEAVES.get().getDefaultState()),   // ВАША листва
                new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),     // ДУБ
                new StraightTrunkPlacer(4, 2, 0),                                               // ДУБ
                new TwoLayerFeature(1, 0, 1)
        ).setIgnoreVines().build();

        return Feature.TREE.withConfiguration(config);
    }
}