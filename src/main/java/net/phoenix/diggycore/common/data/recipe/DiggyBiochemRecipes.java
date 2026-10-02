package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.BioChemMaterials;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.DESH;
import static net.phoenix.diggycore.common.item.DiggyItems.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyBiochemRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:desh_oxide")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(dust, DESH)
                .inputFluids(Oxygen, 2000)
                .circuitMeta(1)
                .outputItems(dust, DESH_OXIDE).save(provider);

        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder("diggycore:bio_stellar_sludge_make")
                .EUt(VH[IV])
                .duration(12 * SECOND)
                .inputItems(dust, BioChemMaterials.EKANIS)
                .inputItems(gemExquisite, SEA_CRYSTAL)
                .inputFluids(Helium3, 2000)
                .circuitMeta(1)
                .outputItems(dustTiny, Diamond)
                .outputItems(dustTiny, Neptunium)
                .outputFluids(BioChemMaterials.BIO_STELLAR_SLUDGE.getFluid(1000))
                .save(provider);

        GTRecipeTypes.DISTILLERY_RECIPES.recipeBuilder("diggycore:bio_stellar_sludge_separate")
                .EUt(VH[EV])
                .duration(12 * SECOND)
                .inputFluids(BioChemMaterials.BIO_STELLAR_SLUDGE, 1000)
                .circuitMeta(1)
                .outputItems(dust, NetherStar)
                .outputFluids(BioChemMaterials.XENOSE_SLUDGE.getFluid(1000)).save(provider);

        GTRecipeTypes.DISTILLERY_RECIPES.recipeBuilder("diggycore:xenose_sludge_distill")
                .EUt(VH[EV])
                .duration(12 * SECOND)
                .inputFluids(BioChemMaterials.XENOSE_SLUDGE, 1000)
                .circuitMeta(1)
                .outputItems(dust, BioChemMaterials.XENOSE)
                .save(provider);

        GTRecipeTypes.FERMENTING_RECIPES.recipeBuilder("diggycore:moldy_apple_make")
                .EUt(VH[HV])
                .duration(60 * SECOND)
                .inputItems(Items.APPLE)
                .inputFluids(Steam, 100)
                .circuitMeta(1)
                .outputItems(MOLDY_APPLE)
                .save(provider);

        GTRecipeTypes.MACERATOR_RECIPES.recipeBuilder("diggycore:amylase_make")
                .EUt(VH[HV])
                .duration(3 * SECOND)
                .inputItems(MOLDY_APPLE)
                .outputItems(AMYLASE_ENZYME)
                .outputItems(dustSmall, Sugar)
                .save(provider);

        DiggyRecipeTypes.BIO_REACTOR_RECIPES.recipeBuilder("diggycore:xenose_separate")
                .EUt(VH[HV])
                .duration(30 * SECOND)
                .inputItems(dust, BioChemMaterials.XENOSE)
                .notConsumable(AMYLASE_ENZYME)
                .outputItems(dust, Tellurium)
                .outputItems(dust, BioChemMaterials.GALACTOSE)
                .save(provider);
    }
}
