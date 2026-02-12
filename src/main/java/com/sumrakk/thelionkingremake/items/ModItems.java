package com.sumrakk.thelionkingremake.items;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.sumrakk.thelionkingremake.blocks.ModBlocks.ACACIASAPLING;
import static com.sumrakk.thelionkingremake.blocks.ModBlocks.RAINFORESTSAPLING;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheLionKingRemake.MOD_ID);

    public static final RegistryObject<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_ITEMS).maxStackSize(1)));
    public static final RegistryObject<Item> ACACIALEAVES = ITEMS.register("acacialeaves", () -> new BlockItem(ModBlocks.ACACIALEAVES.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> PRIDESTONE = ITEMS.register("pridestone", () -> new BlockItem(ModBlocks.PRIDESTONE.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> ACACIASAPLING_ITEM = ITEMS.register("acaciasapling", () -> new BlockItem(ACACIASAPLING.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_ITEMS).maxStackSize(64)));
    public static final RegistryObject<Item> WOOD_ACACIA = ITEMS.register("wood_acacia", () -> new BlockItem(ModBlocks.ACACIA_LOG.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> ACACIA_PLANKS = ITEMS.register("planks_acacia", () -> new BlockItem(ModBlocks.PLANKS_ACACIA.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> RAINFORESTLEAVES = ITEMS.register("rainforestleaves", () -> new BlockItem(ModBlocks.RAINFORESTLEAVES.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> RAINFORESTSAPLING_ITEM = ITEMS.register("rainforestsapling", () -> new BlockItem(RAINFORESTSAPLING.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_ITEMS).maxStackSize(64)));
    public static final RegistryObject<Item> WOOD_RAINFOREST = ITEMS.register("wood_rainforest", () -> new BlockItem(ModBlocks.RAINFOREST_LOG.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> RAINFOREST_PLANKS = ITEMS.register("planks_rainforest", () -> new BlockItem(ModBlocks.PLANKS_RAINFOREST.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

