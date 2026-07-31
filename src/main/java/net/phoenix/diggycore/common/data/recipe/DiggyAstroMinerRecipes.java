package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems;
import net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class DiggyAstroMinerRecipes {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

    public static void generateMinerRecipe(Consumer<FinishedRecipe> provider, Material ore, String dimension, Material drill, int amount, int duration, int voltage)
    {
        int rawAmount = amount;
        int blockAmount = 0;

        while (rawAmount >= 9)
        {
            rawAmount -= 9;
            blockAmount += 1;
        }

        if (blockAmount > 0) {
            GTRecipeBuilder builder = DiggyRecipeTypes.ASTRO_MINER_RECIPES.recipeBuilder("diggycore:" + ore.getName() + "_mine_" + dimension.replace(':', '_'))
                    .notConsumable(TagPrefix.toolHeadDrill, drill)
                    .outputItems(TagPrefix.rawOreBlock, ore, blockAmount)
                    .outputItems(TagPrefix.rawOre, ore, rawAmount)
                    .dimension(ResourceLocation.parse(dimension))
                    .duration(duration * SECOND).EUt(VH[voltage]);

            builder.save(provider);
        } else {
            GTRecipeBuilder builder = DiggyRecipeTypes.ASTRO_MINER_RECIPES.recipeBuilder("diggycore:" + ore.getName() + "_mine_" + dimension.replace(':', '_'))
                    .notConsumable(TagPrefix.toolHeadDrill, drill)
                    .outputItems(TagPrefix.rawOre, ore, rawAmount)
                    .dimension(ResourceLocation.parse(dimension))
                    .duration(duration * SECOND).EUt(VH[voltage]);

            builder.save(provider);
        }
    }

    public static void init(Consumer<FinishedRecipe> provider) {
        generateMinerRecipe(provider, DiggyMetallurgicAndGems.METEORIC_IRON, "ad_astra:moon", Ultimet, 9, 20, LV);
        generateMinerRecipe(provider, DiggyMetallurgicAndGems.LUNAR_SAPPHIRE, "ad_astra:moon", Ultimet, 3, 20, LV);
        generateMinerRecipe(provider, DiggyNewElementsAndAddFlags.DESH, "ad_astra:moon", Ultimet, 6, 20, LV);
        generateMinerRecipe(provider, DiggyNewElementsAndAddFlags.OSTRUM, "ad_astra:mars", Ultimet, 6, 20, LV);
        //generateMinerRecipe(provider, DiggyNewElementsAndAddFlags.CALORITE, "ad_astra:venus", Ultimet, 6, 20, LV);
        generateMinerRecipe(provider, DiggyMetallurgicAndGems.CENTAURITE, "df_planets:proxima_b", Ultimet, 6, 20, LV);
        generateMinerRecipe(provider, DiggyMetallurgicAndGems.CENTAURITE, "df_planets:proxima_d", Ultimet, 6, 20, LV);
    }
}