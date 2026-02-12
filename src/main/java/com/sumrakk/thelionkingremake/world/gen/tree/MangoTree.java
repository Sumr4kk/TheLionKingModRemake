package com.sumrakk.thelionkingremake.world.gen.tree;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class MangoTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random random, boolean largeHive) {
        // ============= ОБЫЧНЫЙ ДУБ - 1 СЛОЙ ЛИСТВЫ! =============
        BaseTreeFeatureConfig.Builder builder = new BaseTreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(ModBlocks.MANGO_LOG.get().getDefaultState()),
                new SimpleBlockStateProvider(ModBlocks.MANGOLEAVES.get().getDefaultState()),
                new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3), // КРУГЛАЯ КРОНА
                new StraightTrunkPlacer(4, 2, 0),                                           // ПРЯМОЙ СТВОЛ
                new TwoLayerFeature(1, 0, 1)                                                // ТОНКИЙ 1x1
        );

        return Feature.TREE.withConfiguration(builder.build());
    }
}