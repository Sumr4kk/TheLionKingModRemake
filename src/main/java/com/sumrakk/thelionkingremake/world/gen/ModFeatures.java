package com.sumrakk.thelionkingremake.world.gen;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.world.gen.feature.MangoTreeFeature;
import com.sumrakk.thelionkingremake.world.gen.feature.PassionTreeFeature;
import com.sumrakk.thelionkingremake.world.gen.feature.TwoLayerRainForestTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, TheLionKingRemake.MOD_ID);

    // RainForestTree фичи
    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> TWO_LAYER_RAINFOREST_TREE =
            FEATURES.register("two_layer_rainforest_tree",
                    () -> new TwoLayerRainForestTreeFeature(BaseTreeFeatureConfig.CODEC));

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> GIANT_TWO_LAYER_RAINFOREST_TREE =
            FEATURES.register("giant_two_layer_rainforest_tree",
                    () -> new TwoLayerRainForestTreeFeature(BaseTreeFeatureConfig.CODEC));

    // PassionTree фича
    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> PASSION_TREE =
            FEATURES.register("passion_tree",
                    () -> new PassionTreeFeature(BaseTreeFeatureConfig.CODEC));

    // MangoTree фича
    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> MANGO_TREE =
            FEATURES.register("mango_tree",
                    () -> new MangoTreeFeature(BaseTreeFeatureConfig.CODEC));
}