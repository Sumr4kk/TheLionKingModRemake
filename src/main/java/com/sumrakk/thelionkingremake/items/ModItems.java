package com.sumrakk.thelionkingremake.items;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sumrakk.thelionkingremake.blocks.ModBlocks.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheLionKingRemake.MOD_ID);

    public static final RegistryObject<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_ITEMS).maxStackSize(1)));
    // ============= БРЁВНА (LOGS) =============
    public static final RegistryObject<Item> WOOD_ACACIA = ITEMS.register("wood_acacia",
            () -> new BlockItem(ModBlocks.ACACIA_LOG.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> WOOD_RAINFOREST = ITEMS.register("wood_rainforest",
            () -> new BlockItem(ModBlocks.RAINFOREST_LOG.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> WOOD_MANGO = ITEMS.register("wood_mango",
            () -> new BlockItem(ModBlocks.MANGO_LOG.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> WOOD_BANANA = ITEMS.register("wood_banana",
            () -> new BlockItem(ModBlocks.BANANA_LOG.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> WOOD_PASSION = ITEMS.register("wood_passion",
            () -> new BlockItem(ModBlocks.PASSION_LOG.get(), new Item.Properties().maxStackSize(64)));

    // ============= ДОСКИ (PLANKS) =============
    public static final RegistryObject<Item> ACACIA_PLANKS = ITEMS.register("planks_acacia",
            () -> new BlockItem(ModBlocks.PLANKS_ACACIA.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> RAINFOREST_PLANKS = ITEMS.register("planks_rainforest",
            () -> new BlockItem(ModBlocks.PLANKS_RAINFOREST.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> MANGO_PLANKS = ITEMS.register("planks_mango",
            () -> new BlockItem(ModBlocks.PLANKS_MANGO.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> BANANA_PLANKS = ITEMS.register("planks_banana",
            () -> new BlockItem(ModBlocks.PLANKS_BANANA.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> PASSION_PLANKS = ITEMS.register("planks_passion",
            () -> new BlockItem(ModBlocks.PLANKS_PASSION.get(), new Item.Properties().maxStackSize(64)));


    // ============= ЛИСТВА (LEAVES) =============
    public static final RegistryObject<Item> ACACIALEAVES = ITEMS.register("acacialeaves",
            () -> new BlockItem(ModBlocks.ACACIALEAVES.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> RAINFORESTLEAVES = ITEMS.register("rainforestleaves",
            () -> new BlockItem(ModBlocks.RAINFORESTLEAVES.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> MANGOLEAVES = ITEMS.register("mangoleaves",
            () -> new BlockItem(ModBlocks.MANGOLEAVES.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> BANANALEAVES = ITEMS.register("bananaleaves",
            () -> new BlockItem(ModBlocks.BANANALEAVES.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> PASSIONLEAVES = ITEMS.register("passionleaves",
            () -> new BlockItem(ModBlocks.PASSIONLEAVES.get(), new Item.Properties().maxStackSize(64)));

    // ============= КАМЕНЬ (STONE) =============
    public static final RegistryObject<Item> PRIDESTONE = ITEMS.register("pridestone",
            () -> new BlockItem(ModBlocks.PRIDESTONE.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> ORE_PEACOCK_ITEM = ITEMS.register("ore_peacock",
            () -> new BlockItem(ModBlocks.ORE_PEACOCK.get(), new Item.Properties().maxStackSize(64)));

    // ============= САЖЕНЦЫ (SAPLINGS) =============
    public static final RegistryObject<Item> ACACIASAPLING_ITEM = ITEMS.register("acaciasapling",
            () -> new BlockItem(ModBlocks.ACACIASAPLING.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> RAINFORESTSAPLING_ITEM = ITEMS.register("rainforestsapling",
            () -> new BlockItem(ModBlocks.RAINFORESTSAPLING.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> MANGOSAPLING_ITEM = ITEMS.register("mangosapling",
            () -> new BlockItem(ModBlocks.MANGOSAPLING.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> BANANASAPLING_ITEM = ITEMS.register("bananasapling",
            () -> new BlockItem(ModBlocks.BANANASAPLING.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> PASSIONSAPLING_ITEM = ITEMS.register("passionsapling",
            () -> new BlockItem(ModBlocks.PASSIONSAPLING.get(), new Item.Properties().maxStackSize(64)));

    // =========== ПЛОДЫ =============
    public static final RegistryObject<Item> MANGO_FRUIT = ITEMS.register("mango_fruit",
            () -> new Item(new Item.Properties().maxStackSize(64).food(new Food.Builder()
                    .hunger(2).saturation(0.6f).build())));

    public static final RegistryObject<Item> BANANA_FRUIT = ITEMS.register("banana_fruit",
            () -> new Item(new Item.Properties().maxStackSize(64).food(new Food.Builder()
                    .hunger(2).saturation(0.6f).build())));

    public static final RegistryObject<Item> PASSION_FRUIT = ITEMS.register("passion_fruit",
            () -> new Item(new Item.Properties().maxStackSize(64).food(new Food.Builder()
                    .hunger(2).saturation(0.5f).build())));

    public static final RegistryObject<Item> ARID_GRASS_ITEM = ITEMS.register("arid_grass",
            () -> new BlockItem(ARID_GRASS.get(), new Item.Properties().maxStackSize(64)));

    // ========== ЦВЕТЫ =================

    public static final RegistryObject<Item> RED_FLOWER_ITEM = ITEMS.register("red_flower",
            () -> new BlockItem(RED_FLOWER_BASE.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> PURPLE_FLOWER_ITEM = ITEMS.register("purple_flower",
            () -> new BlockItem(PURPLE_FLOWER_BASE.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> PINK_FLOWER_ITEM = ITEMS.register("pink_flower",
            () -> new BlockItem(PINK_FLOWER.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> BLUE_FLOWER_ITEM = ITEMS.register("blue_flower",
            () -> new BlockItem(BLUE_FLOWER.get(), new Item.Properties().maxStackSize(64)));

    public static final RegistryObject<Item> WHITE_FLOWER_ITEM = ITEMS.register("white_flower",
            () -> new BlockItem(WHITE_FLOWER.get(), new Item.Properties().maxStackSize(64)));

    // =========== РЕСУРСЫ ==============

    public static final RegistryObject<Item> PEACOCK_GEM = ITEMS.register("peacock_gem",
            () -> new Item(new Item.Properties().maxStackSize(64).rarity(Rarity.UNCOMMON)));

    // ============= ИНСТРУМЕНТЫ ИЗ ПАВЛИНЬЕГО САМОЦВЕТА =============
    public static final RegistryObject<Item> PEACOCK_SWORD = ITEMS.register("peacock_sword",
            () -> new SwordItem(ModToolTier.PEACOCK_GEM, 3, -2.4f,
                    new Item.Properties().maxStackSize(1))
    );

    public static final RegistryObject<Item> PEACOCK_PICKAXE = ITEMS.register("peacock_pickaxe",
            () -> new PickaxeItem(ModToolTier.PEACOCK_GEM, 1, -2.8f,
                    new Item.Properties().maxStackSize(1))
    );

    public static final RegistryObject<Item> PEACOCK_AXE = ITEMS.register("peacock_axe",
            () -> new AxeItem(ModToolTier.PEACOCK_GEM, 5, -3.0f,
                    new Item.Properties().maxStackSize(1))
    );

    public static final RegistryObject<Item> PEACOCK_SHOVEL = ITEMS.register("peacock_shovel",
            () -> new ShovelItem(ModToolTier.PEACOCK_GEM, 1.5f, -3.0f,
                    new Item.Properties().maxStackSize(1))
    );

    public static final RegistryObject<Item> PEACOCK_HOE = ITEMS.register("peacock_hoe",
            () -> new HoeItem(ModToolTier.PEACOCK_GEM, -3, 0.0f,
                    new Item.Properties().maxStackSize(1))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

