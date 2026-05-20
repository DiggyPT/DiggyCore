package net.phoenix.diggycore.common.block;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.phoenix.diggycore.DiggyCore;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import org.jetbrains.annotations.NotNull;

import static net.phoenix.diggycore.common.registry.DiggyRegistration.REGISTRATE;

public class DiggyBlocks {

    public static void init() {}

    private static @NotNull BlockEntry<Block> registerSimpleBlock(String name, String id, String texture,
                                                                  NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 6.0f)
                        .requiresCorrectToolForDrops())
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), DiggyCore.id("block/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    private static @NotNull BlockEntry<Block> registerDirtBlock(String name, String id, String texture,
                                                                NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.DIRT)
                .tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(0.5f, 0.5f))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), DiggyCore.id("block/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }

    public static final BlockEntry<Block> ANTI_HIGGS_ROOM_FILTER_CASING = createCleanroomFilters(
            AntiHiggsFilterType.FILTER_CASING_ANTI_HIGGS);

    private static BlockEntry<Block> createCleanroomFilters(IFilterType filterType) {
        var filterBlock = REGISTRATE.block(filterType.getSerializedName(), Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(properties -> properties.strength(2.0f, 8.0f).sound(SoundType.METAL)
                        .isValidSpawn((blockState, blockGetter, blockPos, entityType) -> false))
                .blockstate(GTModels.createCleanroomFilterModel(filterType))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH, CustomTags.TOOL_TIERS[1])
                .item(BlockItem::new)
                .build()
                .register();
        GTCEuAPI.CLEANROOM_FILTERS.put(filterType, filterBlock);
        return filterBlock;
    }

    public static BlockEntry<Block> GREENHOUSE_DIRT = registerDirtBlock(
            "Greenhouse Dirt", "greenhouse_dirt",
            "greenhouse_dirt", BlockItem::new);

    public static BlockEntry<Block> GREENHOUSE_CASING = registerSimpleBlock(
            "Greenhouse Casing", "greenhouse_casing",
            "casings/greenhouse_casing", BlockItem::new);
}
