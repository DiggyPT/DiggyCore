package net.phoenix.diggycore.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.DiggyRecipeTypes.CASIMIR_GENERATOR_FUELS;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyGeneratorRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        CASIMIR_GENERATOR_FUELS.recipeBuilder("diggycore:casimir_centaurium")
                .notConsumable(plateDense, CENTAURIUM, 2)
                .duration(20 * SECOND).EUt(-VH[LV])
                .addMaterialInfo(true).save(provider);
    }
}
