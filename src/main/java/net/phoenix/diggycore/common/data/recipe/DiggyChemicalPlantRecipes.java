package net.phoenix.diggycore.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.BasicChemistryMaterials;
import net.phoenix.diggycore.common.item.DiggyItems;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.BasicChemistryMaterials.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyChemicalPlantRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        DiggyRecipeTypes.CHEMICAL_PLANT_RECIPES.recipeBuilder("diggycore:hydrazine")
                .notConsumable(DiggyItems.ACETONE_CATALYST)
                .inputFluids(Ammonia, 2000)
                .inputFluids(HydrogenPeroxide, 1000)
                .outputFluids(HYDRAZINE.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .circuitMeta(1)
                .duration(10 * SECOND).EUt(VH[EV])
                .addMaterialInfo(true).save(provider);

        DiggyRecipeTypes.CHEMICAL_PLANT_RECIPES.recipeBuilder("diggycore:aerozine_make")
                .EUt(VH[IV])
                .duration(14 * SECOND)
                .inputFluids(BasicChemistryMaterials.HYDRAZINE, 1000)
                .inputFluids(Dimethylhydrazine, 1000)
                .circuitMeta(1)
                .outputFluids(BasicChemistryMaterials.AEROZINE.getFluid(2000)).save(provider);
    }
}
