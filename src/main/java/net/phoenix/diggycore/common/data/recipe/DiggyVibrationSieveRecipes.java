package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems;
import net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags;

import earth.terrarium.adastra.common.registry.ModBlocks;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyVibrationSieveRecipes {

    /*
     * public static void generateMinerRecipe(Consumer<FinishedRecipe> provider, Material ore, String dimension,
     * Material drill, int amount, int duration, int voltage) {
     * int rawAmount = amount;
     * int blockAmount = 0;
     * 
     * while (rawAmount >= 9) {
     * rawAmount -= 9;
     * blockAmount += 1;
     * }
     * 
     * if (blockAmount > 0) {
     * GTRecipeBuilder builder = DiggyRecipeTypes.VIBRATION_SIEVE_RECIPES
     * .recipeBuilder("diggycore:" + ore.getName() + "_sift_" + dimension.replace(':', '_'))
     * .notConsumable(TagPrefix.toolHeadDrill, drill)
     * .outputItems(TagPrefix.rawOreBlock, ore, blockAmount)
     * .outputItems(TagPrefix.rawOre, ore, rawAmount)
     * .dimension(ResourceLocation.parse(dimension))
     * .duration(duration * SECOND).EUt(VH[voltage]);
     * 
     * builder.save(provider);
     * } else {
     * GTRecipeBuilder builder = DiggyRecipeTypes.VIBRATION_SIEVE_RECIPES
     * .recipeBuilder("diggycore:" + ore.getName() + "_sift_" + dimension.replace(':', '_'))
     * .notConsumable(TagPrefix.toolHeadDrill, drill)
     * .outputItems(TagPrefix.rawOre, ore, rawAmount)
     * .dimension(ResourceLocation.parse(dimension))
     * .duration(duration * SECOND).EUt(VH[voltage]);
     * 
     * builder.save(provider);
     * }
     * }
     */

    public static void init(Consumer<FinishedRecipe> provider) {
        DiggyRecipeTypes.VIBRATION_SIEVE_RECIPES.recipeBuilder("diggycore:moon_sift")
                .EUt(VH[EV])
                .duration(30 * SECOND)
                .inputItems(ModBlocks.MOON_SAND, 64)
                .dimension(ResourceLocation.parse("ad_astra:moon"))
                .circuitMeta(1)
                .outputItems(TagPrefix.crushed, DiggyMetallurgicAndGems.METEORIC_IRON, 8)
                .outputItems(TagPrefix.crushed, DiggyNewElementsAndAddFlags.DESH, 4)
                .outputItems(TagPrefix.crushed, DiggyMetallurgicAndGems.LUNAR_SAPPHIRE, 4).save(provider);

        DiggyRecipeTypes.VIBRATION_SIEVE_RECIPES.recipeBuilder("diggycore:mars_sift")
                .EUt(VH[EV])
                .duration(30 * SECOND)
                .inputItems(ModBlocks.MARS_SAND, 64)
                .dimension(ResourceLocation.parse("ad_astra:mars"))
                .circuitMeta(1)
                .outputItems(TagPrefix.crushed, DiggyNewElementsAndAddFlags.OSTRUM, 8)
                .outputItems(TagPrefix.crushed, DiggyMetallurgicAndGems.SEA_CRYSTAL, 4).save(provider);

        DiggyRecipeTypes.VIBRATION_SIEVE_RECIPES.recipeBuilder("diggycore:venus_sift")
                .EUt(VH[EV])
                .duration(30 * SECOND)
                .inputItems(ModBlocks.VENUS_SAND, 64)
                .dimension(ResourceLocation.parse("ad_astra:venus"))
                .circuitMeta(1)
                // .outputItems(TagPrefix.crushed, DiggyNewElementsAndAddFlags.CALORITE, 8)
                .outputItems(TagPrefix.crushed, DiggyNewElementsAndAddFlags.PHOENICIUM, 4).save(provider);
    }
}
