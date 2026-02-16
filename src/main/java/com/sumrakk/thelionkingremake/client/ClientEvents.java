package com.sumrakk.thelionkingremake.client;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TheLionKingRemake.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.ACACIASAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.RAINFORESTSAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGOSAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BANANASAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PASSIONSAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.MANGO_FRUIT.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.BANANA_FRUIT.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PASSION_FRUIT.get(), RenderType.getCutout());
        });
    }
}