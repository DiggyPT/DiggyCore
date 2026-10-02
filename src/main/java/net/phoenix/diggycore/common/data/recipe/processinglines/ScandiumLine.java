package net.phoenix.diggycore.common.data.recipe.processinglines;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.phoenix.diggycore.common.item.DiggyItems;

import earth.terrarium.adastra.common.registry.ModBlocks;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.BasicChemistryMaterials.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class ScandiumLine {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.SIFTER_RECIPES.recipeBuilder("diggycore:moon_sand_sift_basic")
                .EUt(VH[MV])
                .duration(12 * SECOND)
                .inputItems(ModBlocks.MOON_SAND)
                .chancedOutput(crushed, CHANGESITE, 3000, 100)
                .chancedOutput(crushed, Uraninite, 2000, 100)
                .chancedOutput(DiggyItems.MOON_GANGUE.asStack(), 4000, 100).save(provider);

        GTRecipeTypes.MACERATOR_RECIPES.recipeBuilder("diggycore:moon_gangue_crush")
                .EUt(VH[LV])
                .duration(30 * SECOND)
                .inputItems(DiggyItems.MOON_GANGUE.asStack())
                .outputItems(dust, MOON_GANGUE).save(provider);

        GTRecipeTypes.ELECTROLYZER_RECIPES.recipeBuilder("diggycore:moon_gangue_separate")
                .EUt(VH[MV])
                .duration(20 * SECOND)
                .inputItems(dust, MOON_GANGUE)
                .chancedOutput(new ItemStack(ModBlocks.MOON_SAND.get().asItem(), 1), 500, 100) // well getting that as
                                                                                               // an itemstack was hard
                .chancedOutput(crushed, THORTVEITITE, 3000, 100).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:hydrogen_fluoride_make")
                .EUt(VH[LV])
                .duration(20 * SECOND)
                .inputFluids(Hydrogen, 1000)
                .inputFluids(Fluorine, 1000)
                .outputFluids(HYDROGEN_FLUORIDE.getFluid(1000)).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:ammonium_bifluoride_make")
                .EUt(VH[LV])
                .duration(20 * SECOND)
                .inputFluids(Ammonia, 1000)
                .inputFluids(HYDROGEN_FLUORIDE, 1000)
                .outputFluids(AMMONIUM_BIFLUORIDE.getFluid(1000)).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:thortveitite_separate")
                .EUt(VH[LV])
                .duration(20 * SECOND)
                .inputItems(dust, THORTVEITITE)
                .inputFluids(AMMONIUM_BIFLUORIDE, 6000)
                .outputItems(dust, SCANDIUM_FLUORIDE, 2)
                .outputFluids(AMMONIUM_FLUORIDE.getFluid(6000))
                .outputFluids(Water.getFluid(3000)).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:scandium_make")
                .EUt(VH[HV])
                .duration(10 * SECOND)
                .inputItems(dust, SCANDIUM_FLUORIDE, 2)
                .inputItems(dust, Calcium, 3)
                .outputItems(dust, CALCIUM_FLUORIDE, 2)
                .outputItems(dust, Scandium, 2).save(provider);

        GTRecipeTypes.ELECTROLYZER_RECIPES.recipeBuilder("diggycore:changesite_decompose")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .inputItems(dust, CHANGESITE, 4)
                .outputItems(dust, TricalciumPhosphate, 2)
                .outputItems(dust, Yttrium, 1)
                .outputItems(dust, Iron, 1)
                .outputFluids(Helium3.getFluid(500)).save(provider);
    }
}
