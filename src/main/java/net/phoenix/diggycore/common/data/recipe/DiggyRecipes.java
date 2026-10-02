package net.phoenix.diggycore.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.data.recipe.generated.DiggyMaterialPartRecipeGen;
import net.phoenix.diggycore.common.data.recipe.processinglines.DiggyProcessingLinesInit;
import net.phoenix.diggycore.data.recipe.DiggyBeeBreedingRecipes;
import net.phoenix.diggycore.data.recipe.MachineMakeRecipes;

import java.util.function.Consumer;

public class DiggyRecipes {

    // Initialises all recipe subcategories.
    public static void init(Consumer<FinishedRecipe> provider) {
        DiggyMaterialPartRecipeGen.init(provider);
        DiggyBeeBreedingRecipes.init(provider);
        MachineMakeRecipes.init(provider);
        DiggySpaceflightRecipes.init(provider);
        DiggyCyclotronRecipes.init(provider);
        DiggyAIRecipes.init(provider);
        DiggyChemRecipes.init(provider);
        DiggyProcessingLinesInit.init(provider);
        DiggyChemicalPlantRecipes.init(provider);
        DiggyVibrationSieveRecipes.init(provider);
        DiggyCircuitRecipes.init(provider);
        DiggyGeneratorRecipes.init(provider);
        DiggyGreenhouseRecipes.init(provider);
        DiggyBiochemRecipes.init(provider);
        DiggyMultiRecipes.init(provider);
    }
}
