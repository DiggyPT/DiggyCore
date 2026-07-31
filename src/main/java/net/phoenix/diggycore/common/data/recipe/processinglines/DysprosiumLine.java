package net.phoenix.diggycore.common.data.recipe.processinglines;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.BasicChemistryMaterials.*;

public class DysprosiumLine {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:dysprosium_fluoride_make")
                .EUt(VH[LV])
                .duration(12 * SECOND)
                .inputItems(dust, DYSPROSIUM_CATION)
                .inputFluids(Fluorine, 3000)
                .circuitMeta(1)
                .outputItems(dust, DYSPROSIUM_TRIFLUORIDE).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:dysprosium_chloride_make")
                .EUt(VH[LV])
                .duration(12 * SECOND)
                .inputItems(dust, DYSPROSIUM_CATION)
                .inputFluids(Chlorine, 3000)
                .circuitMeta(2)
                .outputItems(dust, DYSPROSIUM_TRICHLORIDE).save(provider);

        GTRecipeTypes.BLAST_RECIPES.recipeBuilder("diggycore:dysprosium_from_dycl3")
                .EUt(VH[MV])
                .duration(20 * SECOND)
                .inputItems(dust, DYSPROSIUM_TRICHLORIDE)
                .inputItems(dust, Lithium, 3)
                .circuitMeta(1)
                .outputItems(ingot, Dysprosium)
                .outputItems(dust, LithiumChloride, 3).save(provider);

        GTRecipeTypes.BLAST_RECIPES.recipeBuilder("diggycore:dysprosium_from_dyf3")
                .EUt(VH[MV])
                .duration(20 * SECOND)
                .inputItems(dust, DYSPROSIUM_TRIFLUORIDE, 2)
                .inputItems(dust, Calcium, 3)
                .circuitMeta(2)
                .outputItems(ingot, Dysprosium, 2)
                .outputItems(dust, CALCIUM_FLUORIDE, 3).save(provider);

        GTRecipeTypes.ELECTROLYZER_RECIPES.recipeBuilder("diggycore:calcium_fluoride_decompose")
                .EUt(VH[MV])
                .duration(12 * SECOND)
                .inputItems(dust, CALCIUM_FLUORIDE)
                .circuitMeta(1)
                .outputItems(dust, Calcium)
                .outputFluids(Fluorine.getFluid(2000)).save(provider);
    }
}
