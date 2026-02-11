package com.sumrakk.thelionkingremake.blocks;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheLionKingRemake.MOD_ID);

    public static final RegistryObject<Block> ACACIALEAVES = BLOCKS.register("acacialeaves", () -> new Block(AbstractBlock.Properties.create(Material.LEAVES)
            .hardnessAndResistance(0.2f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setSuffocates((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
    ));

    public static final RegistryObject<Block> PRIDESTONE = BLOCKS.register("pridestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
            .hardnessAndResistance(2.0f, 6.0f)
            .sound(SoundType.STONE)
            .setRequiresTool()
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
    ));
}
