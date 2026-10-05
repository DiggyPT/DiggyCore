package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.mcreator.dfplanets.init.DfPlanetsModBlocks;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static net.phoenix.diggycore.common.item.DiggyItems.*;

public class DiggyCircuitRecipes {

    public static void universalCircuitRecipe(int voltage, Consumer<FinishedRecipe> provider) {
        ASSEMBLER_RECIPES.recipeBuilder("diggycore:" + GTValues.VN[voltage].toLowerCase() + "_universal_circuit_make")
                .inputItems(CustomTags.CIRCUITS_ARRAY[voltage])
                .circuitMeta(9)
                .outputItems(THE_CIRCUIT_BOYS[voltage])
                .duration(1).EUt(VH[ULV])
                .addMaterialInfo(true).save(provider);
    }

    public static void init(Consumer<FinishedRecipe> provider) {
        universalCircuitRecipe(0, provider);
        universalCircuitRecipe(1, provider);
        universalCircuitRecipe(2, provider);
        universalCircuitRecipe(3, provider);
        universalCircuitRecipe(4, provider);
        universalCircuitRecipe(5, provider);
        universalCircuitRecipe(6, provider);
        universalCircuitRecipe(7, provider);
        universalCircuitRecipe(8, provider);
        universalCircuitRecipe(9, provider);
        universalCircuitRecipe(10, provider);
        universalCircuitRecipe(11, provider);
        universalCircuitRecipe(12, provider);
        universalCircuitRecipe(13, provider);
        universalCircuitRecipe(14, provider);

        ASSEMBLER_RECIPES.recipeBuilder("diggycore:mainframe_convert")
                .inputItems(GTItems.MAINFRAME_IV)
                .circuitMeta(10)
                .outputItems(DfPlanetsModBlocks.MICROPROCESSOR_MAINFRAME)
                .duration(1).EUt(VH[ULV])
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("diggycore:mainframe_convert2")
                .outputItems(GTItems.MAINFRAME_IV)
                .circuitMeta(10)
                .inputItems(DfPlanetsModBlocks.MICROPROCESSOR_MAINFRAME)
                .duration(1).EUt(VH[ULV])
                .save(provider);
    }
}
