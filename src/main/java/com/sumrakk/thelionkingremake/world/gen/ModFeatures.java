package com.sumrakk.thelionkingremake.world.gen;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.world.gen.feature.TwoLayerRainForestTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, TheLionKingRemake.MOD_ID);

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> TWO_LAYER_RAINFOREST_TREE =
            FEATURES.register("two_layer_rainforest_tree",
                    () -> new TwoLayerRainForestTreeFeature(BaseTreeFeatureConfig.CODEC));
}