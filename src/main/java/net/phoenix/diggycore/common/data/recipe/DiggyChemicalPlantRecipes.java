package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.config.ConfigHolder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.block.DiggyBlocks;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.item.DiggyItems;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.BasicChemistryMaterials.*;

public class DiggyChemicalPlantRecipes {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

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
    }
}
