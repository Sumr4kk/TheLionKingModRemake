package com.sumrakk.thelionkingremake.world.gen.tree;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.trunkplacer.*;

import javax.annotation.Nullable;
import java.util.Random;

public class PrideTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        int treeType = random.nextInt(10); // 0-9

        // ============= 20% БОЛЬШОЕ ТРОПИЧЕСКОЕ (2x2) =============
        if (treeType < 2) {
            BaseTreeFeatureConfig.Builder builder = new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.ACACIA_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.ACACIALEAVES.get().getDefaultState()),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2),
                    new GiantTrunkPlacer(8, 2, 4),
                    new TwoLayerFeature(2, 1, 2)
            );
            return Feature.TREE.withConfiguration(builder.build());
        }

        // ============= 30% ТРОПИЧЕСКОЕ ГИГАНТСКОЕ (2x2) - ИСПРАВЛЕНО! =============
        else if (treeType < 5) {
            BaseTreeFeatureConfig.Builder builder = new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.ACACIA_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.ACACIALEAVES.get().getDefaultState()),
                    new JungleFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(1), 4), // БОЛЬШАЯ КРОНА!
                    new GiantTrunkPlacer(16, 4, 6),  // ОЧЕНЬ ВЫСОКИЙ ТОЛСТЫЙ СТВОЛ!
                    new TwoLayerFeature(2, 1, 2)     // СТВОЛ 2x2 ВО ВСЮ ВЫСОТУ!
            );
            return Feature.TREE.withConfiguration(builder.build());
        }

        // ============= 25% АКАЦИЯ =============
        else if (treeType < 8) {
            BaseTreeFeatureConfig.Builder builder = new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.ACACIA_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.ACACIALEAVES.get().getDefaultState()),
                    new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                    new ForkyTrunkPlacer(5, 3, 3),
                    new TwoLayerFeature(1, 0, 1)
            );
            return Feature.TREE.withConfiguration(builder.build());
        }

        // ============= 25% МАЛЕНЬКОЕ ТРОПИЧЕСКОЕ =============
        else {
            BaseTreeFeatureConfig.Builder builder = new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.ACACIA_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(ModBlocks.ACACIALEAVES.get().getDefaultState()),
                    new JungleFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 2),
                    new StraightTrunkPlacer(5, 2, 3),
                    new TwoLayerFeature(1, 0, 1)
            );
            return Feature.TREE.withConfiguration(builder.build());
        }
    }
}