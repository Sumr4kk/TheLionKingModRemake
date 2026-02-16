package com.sumrakk.thelionkingremake.blocks;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.world.gen.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.AcaciaTree;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheLionKingRemake.MOD_ID);
    // ============= БРЁВНА (LOGS) =============
    public static final RegistryObject<Block> ACACIA_LOG = BLOCKS.register("wood_acacia", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> RAINFOREST_LOG = BLOCKS.register("wood_rainforest", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> MANGO_LOG = BLOCKS.register("wood_mango", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("wood_banana", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> PASSION_LOG = BLOCKS.register("wood_passion", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));

    // ============= ДОСКИ (PLANKS) =============
    public static final RegistryObject<Block> PLANKS_ACACIA = BLOCKS.register("planks_acacia", () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 3.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> PLANKS_RAINFOREST = BLOCKS.register("planks_rainforest", () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 3.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> PLANKS_MANGO = BLOCKS.register("planks_mango", () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 3.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> PLANKS_BANANA = BLOCKS.register("planks_banana", () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 3.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));
    public static final RegistryObject<Block> PLANKS_PASSION = BLOCKS.register("planks_passion", () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0f, 3.0f)
            .sound(SoundType.WOOD)
            .harvestLevel(0)
            .harvestTool(ToolType.AXE)
    ));

    // ============= ЛИСТВА (LEAVES) =============
    public static final RegistryObject<Block> ACACIALEAVES = BLOCKS.register("acacialeaves", () -> new Block(AbstractBlock.Properties.create(Material.LEAVES)
            .hardnessAndResistance(0.2f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setSuffocates((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
    ));
    public static final RegistryObject<Block> RAINFORESTLEAVES = BLOCKS.register("rainforestleaves", () -> new Block(AbstractBlock.Properties.create(Material.LEAVES)
            .hardnessAndResistance(0.2f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setSuffocates((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
    ));
    public static final RegistryObject<Block> MANGOLEAVES = BLOCKS.register("mangoleaves", () -> new Block(AbstractBlock.Properties.create(Material.LEAVES)
            .hardnessAndResistance(0.2f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setSuffocates((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
    ));
    public static final RegistryObject<Block> BANANALEAVES = BLOCKS.register("bananaleaves", () -> new Block(AbstractBlock.Properties.create(Material.LEAVES)
            .hardnessAndResistance(0.2f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setSuffocates((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
    ));
    public static final RegistryObject<Block> PASSIONLEAVES = BLOCKS.register("passionleaves", () -> new Block(AbstractBlock.Properties.create(Material.LEAVES)
            .hardnessAndResistance(0.2f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setSuffocates((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
    ));

    // ============= КАМЕНЬ (STONE) =============
    public static final RegistryObject<Block> PRIDESTONE = BLOCKS.register("pridestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
            .hardnessAndResistance(2.0f, 6.0f)
            .sound(SoundType.STONE)
            .setRequiresTool()
            .harvestLevel(0)
            .harvestTool(ToolType.PICKAXE)
    ));

    // ============= САЖЕНЦЫ (SAPLINGS) =============
    public static final RegistryObject<Block> ACACIASAPLING = BLOCKS.register("acaciasapling", () -> new SaplingBlock(new PrideTree(), AbstractBlock.Properties.create(Material.PLANTS)
            .doesNotBlockMovement()
            .hardnessAndResistance(0.0f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
            .tickRandomly()
    ));
    public static final RegistryObject<Block> RAINFORESTSAPLING = BLOCKS.register("rainforestsapling", () -> new SaplingBlock(new RainForestTree(), AbstractBlock.Properties.create(Material.PLANTS)
            .doesNotBlockMovement()
            .hardnessAndResistance(0.0f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
            .tickRandomly()
    ));
    public static final RegistryObject<Block> MANGOSAPLING = BLOCKS.register("mangosapling", () -> new SaplingBlock(new MangoTree(), AbstractBlock.Properties.create(Material.PLANTS)
            .doesNotBlockMovement()
            .hardnessAndResistance(0.0f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
            .tickRandomly()
    ));
    public static final RegistryObject<Block> BANANASAPLING = BLOCKS.register("bananasapling", () -> new SaplingBlock(new BananaTree(), AbstractBlock.Properties.create(Material.PLANTS)
            .doesNotBlockMovement()
            .hardnessAndResistance(0.0f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
            .tickRandomly()
    ));
    public static final RegistryObject<Block> PASSIONSAPLING = BLOCKS.register("passionsapling", () -> new SaplingBlock(new PassionTree(), AbstractBlock.Properties.create(Material.PLANTS)
            .doesNotBlockMovement()
            .hardnessAndResistance(0.0f)
            .sound(SoundType.PLANT)
            .notSolid()
            .setOpaque((state, reader, pos) -> false)
            .setBlocksVision((state, reader, pos) -> false)
            .tickRandomly()
    ));
}
