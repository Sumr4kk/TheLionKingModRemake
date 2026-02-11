package com.sumrakk.thelionkingremake.items;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheLionKingRemake.MOD_ID);

    public static final RegistryObject<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_ITEMS).maxStackSize(1)));
    public static final RegistryObject<Item> ACACIALEAVES = ITEMS.register("acacialeaves", () -> new BlockItem(ModBlocks.ACACIALEAVES.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));
    public static final RegistryObject<Item> PRIDESTONE = ITEMS.register("pridestone", () -> new BlockItem(ModBlocks.PRIDESTONE.get(), new Item.Properties().group(ModItemGroups.THE_LION_KING_REMAKE_BLOCKS).maxStackSize(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

