package net.phoenix.diggycore.common.block;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.phoenix.diggycore.DiggyCore;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    private static @NotNull BlockEntry<Block> registerColumnBlock(String name, String id, String textureSide,
                                                                  String textureEnd, String tooltip,
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
                        prov.models().cubeColumn(ctx.getName(), DiggyCore.id("block/" + textureSide),
                                DiggyCore.id("block/" + textureEnd))))
                .lang(name)
                .item((b, p) -> new BlockItem(b, p) {

                    @Override
                    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                                List<Component> tooltipComponents,
                                                TooltipFlag isAdvanced) {
                        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
                        tooltipComponents.add(1, Component.literal(tooltip).withStyle(ChatFormatting.GRAY));
                    }
                })
                .build()
                .register();
    }

    private static @NotNull BlockEntry<Block> registerEngine(String name, String id, String tooltip) {
        return registerColumnBlock(name, id, "rocket_engines/" + id + "/side", "rocket_engines/" + id + "/end", tooltip,
                BlockItem::new);
    }

    private static @NotNull BlockEntry<Block> registerMainframeBlock(String name, String id, @Nullable String tooltip) {
        ResourceLocation sideTexture = DiggyCore.id("block/mainframe_blocks/" + id + "/side");
        ResourceLocation frontTexture = DiggyCore.id("block/mainframe_blocks/" + id + "/front");
        ResourceLocation blankTexture = DiggyCore.id("block/mainframe_blocks/blank");
        return REGISTRATE
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 6.0f)
                        .requiresCorrectToolForDrops())
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cube(ctx.getName(), blankTexture, blankTexture, frontTexture, blankTexture,
                                sideTexture, blankTexture)))
                .lang(name)
                .item((b, p) -> new BlockItem(b, p) {

                    @Override
                    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                                List<Component> tooltipComponents,
                                                TooltipFlag isAdvanced) {
                        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
                        tooltipComponents.add(1, Component.literal(tooltip));
                    }
                })
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

    public static BlockEntry<Block> GALAXYSPACE_GRADE_CASING = registerSimpleBlock(
            "Galaxyspace-Grade Casing", "galaxyspace_grade_casing",
            "casings/galaxyspace_grade_casing", BlockItem::new);

    public static BlockEntry<Block> CYCLOTRON_CASING = registerSimpleBlock(
            "Cyclotron Casing", "cyclotron_casing",
            "casings/cyclotron_casing", BlockItem::new);

    public static BlockEntry<Block> ION_ENGINE = registerEngine("Ion Engine", "ion_engine",
            "Creates a cloud of positive ions from a neutral gas by ionizing it to extract some electrons from its atoms. " +
                    "The ions are then accelerated using electricity to create thrust.");

    public static BlockEntry<Block> ALCUBIERRE_DRIVE = registerEngine("Alcubierre Drive", "alcubierre_drive",
            "Uses exotic matter to warp spacetime, contracting it in front of the rocket and distending it in the back of the rocket. " +
                    "The rocket can then travel faster-than-light to an outside observer.");

    public static BlockEntry<Block> TEGAN_DRIVE = registerEngine("Tegan Drive", "tegan_drive",
            "Breaches the inner frame of reality and navigates through the fractal structures within to " +
                    "shorten interstellar distances drastically.");

    public static BlockEntry<Block> TURING_CASING = registerColumnBlock("Turing Casing", "turing_casing",
            "casings/turing/side", "casings/turing/end",
            "A less advanced iteration of the Computer Casing.", BlockItem::new);
}
