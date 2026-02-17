package com.sumrakk.thelionkingremake.items;

import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModItemGroups {
    // ============= ВКЛАДКА ДЛЯ ПРЕДМЕТОВ =============
    public static final ItemGroup THE_LION_KING_REMAKE_ITEMS = new ItemGroup("thelionkingremake_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.LOGO.get());
        }

        @Override
        @OnlyIn(Dist.CLIENT)
        public void fill(NonNullList<ItemStack> items) {
            items.clear();

            // ============= ПРЕДМЕТЫ =============
            items.add(new ItemStack(ModItems.LOGO.get()));

            // ============= САЖЕНЦЫ =============
            items.add(new ItemStack(ModBlocks.ACACIASAPLING.get()));
            items.add(new ItemStack(ModBlocks.RAINFORESTSAPLING.get()));
            items.add(new ItemStack(ModBlocks.MANGOSAPLING.get()));
            items.add(new ItemStack(ModBlocks.BANANASAPLING.get()));
            items.add(new ItemStack(ModBlocks.PASSIONSAPLING.get()));
            items.add(new ItemStack(ModBlocks.ARID_GRASS.get()));

            // =========== ПЛОДЫ ============
            items.add(new ItemStack(ModItems.MANGO_FRUIT.get()));
            items.add(new ItemStack(ModItems.BANANA_FRUIT.get()));
            items.add(new ItemStack(ModItems.PASSION_FRUIT.get()));

            // ============ ЦВЕТЫ =============
            items.add(new ItemStack(ModBlocks.RED_FLOWER_BASE.get()));
            items.add(new ItemStack(ModBlocks.PURPLE_FLOWER_BASE.get()));
            items.add(new ItemStack(ModBlocks.PINK_FLOWER.get()));
            items.add(new ItemStack(ModBlocks.BLUE_FLOWER.get()));
            items.add(new ItemStack(ModBlocks.WHITE_FLOWER.get()));
        }
    };

    // ============= ВКЛАДКА ДЛЯ БЛОКОВ =============
    public static final ItemGroup THE_LION_KING_REMAKE_BLOCKS = new ItemGroup("thelionkingremake_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.PRIDESTONE.get());
        }

        @Override
        @OnlyIn(Dist.CLIENT)
        public void fill(NonNullList<ItemStack> items) {
            // Очищаем стандартное наполнение
            items.clear();

            // ============= 1. БРЁВНА =============
            items.add(new ItemStack(ModBlocks.ACACIA_LOG.get()));
            items.add(new ItemStack(ModBlocks.RAINFOREST_LOG.get()));
            items.add(new ItemStack(ModBlocks.MANGO_LOG.get()));
            items.add(new ItemStack(ModBlocks.BANANA_LOG.get()));
            items.add(new ItemStack(ModBlocks.PASSION_LOG.get()));

            // ============= 2. ДОСКИ =============
            items.add(new ItemStack(ModBlocks.PLANKS_ACACIA.get()));
            items.add(new ItemStack(ModBlocks.PLANKS_RAINFOREST.get()));
            items.add(new ItemStack(ModBlocks.PLANKS_MANGO.get()));
            items.add(new ItemStack(ModBlocks.PLANKS_BANANA.get()));
            items.add(new ItemStack(ModBlocks.PLANKS_PASSION.get()));

            // ============= 3. ЛИСТВА =============
            items.add(new ItemStack(ModBlocks.ACACIALEAVES.get()));
            items.add(new ItemStack(ModBlocks.RAINFORESTLEAVES.get()));
            items.add(new ItemStack(ModBlocks.MANGOLEAVES.get()));
            items.add(new ItemStack(ModBlocks.BANANALEAVES.get()));
            items.add(new ItemStack(ModBlocks.PASSIONLEAVES.get()));

            // ============= 4. КАМЕНЬ =============
            items.add(new ItemStack(ModBlocks.PRIDESTONE.get()));
            items.add(new ItemStack(ModBlocks.ORE_PEACOCK.get()));
        }
    };
}