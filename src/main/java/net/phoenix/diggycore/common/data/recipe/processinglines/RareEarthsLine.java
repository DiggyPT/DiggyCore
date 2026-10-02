package net.phoenix.diggycore.common.data.recipe.processinglines;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.phoenix.diggycore.common.block.DiggyBlocks;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.RareEarthMaterials.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class RareEarthsLine {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.BLAST_RECIPES.recipeBuilder("diggycore:monazite_cook")
                .EUt(VH[EV])
                .duration(20 * SECOND)
                .blastFurnaceTemp(250)
                .inputItems(dust, Monazite)
                .inputFluids(new FluidStack(SulfuricAcid.getFluid(), 500))
                .outputFluids(new FluidStack(MUDDY_MONAZITE_SOLUTION.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:muddy_monazite_distill")
                .EUt(VH[EV])
                .duration(3 * SECOND)
                .inputFluids(new FluidStack(MUDDY_MONAZITE_SOLUTION.getFluid(), 1000))
                .inputFluids(new FluidStack(Water.getFluid(), 10000))
                .outputFluids(new FluidStack(MONAZITE_SOLUTION.getFluid(), 11000))
                .chancedOutput(dust, SiliconDioxide, 3000, 500)
                .chancedOutput(dust, THORIUM_DIOXIDE, 3000, 500)
                .chancedOutput(dust, ZIRCON, 3000, 500)
                .save(provider);

        GTRecipeTypes.SIFTER_RECIPES.recipeBuilder("diggycore:monazite_solution_sift")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .inputFluids(new FluidStack(MONAZITE_SOLUTION.getFluid(), 10000))
                .outputItems(dust, MONAZITE_SULFATE)
                .chancedOutput(dust, SiliconDioxide, 3000, 500)
                .chancedOutput(dust, Rutile, 3000, 500)
                .chancedOutput(dust, Ilmenite, 3000, 500)
                .chancedOutput(dust, ZIRCON, 3000, 500)
                .save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:ammonia_solution_make")
                .EUt(VH[MV])
                .duration(3 * SECOND)
                .inputFluids(new FluidStack(Ammonia.getFluid(), 1000))
                .inputFluids(new FluidStack(Water.getFluid(), 1000))
                .outputFluids(new FluidStack(AMMONIA_SOLUTION.getFluid(), 2000))
                .save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:monazite_sulfate_solution_make")
                .EUt(VH[HV])
                .duration(6 * SECOND)
                .inputItems(dust, MONAZITE_SULFATE)
                .inputFluids(new FluidStack(Water.getFluid(), 1000))
                .outputFluids(new FluidStack(MONAZITE_SULFATE_SOLUTION.getFluid(), 1500))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:monazite_sulfate_solution_neutralise")
                .EUt(VH[HV])
                .duration(10 * SECOND)
                .inputFluids(new FluidStack(MONAZITE_SULFATE_SOLUTION.getFluid(), 1000))
                .inputFluids(new FluidStack(AMMONIA_SOLUTION.getFluid(), 1000))
                .outputFluids(new FluidStack(NEUTRALISED_MONAZITE_SULFATE_SOLUTION.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.SIFTER_RECIPES.recipeBuilder("diggycore:nmss_sift")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .inputFluids(new FluidStack(NEUTRALISED_MONAZITE_SULFATE_SOLUTION.getFluid(), 1000))
                .outputItems(dust, RARE_EARTH_FILTRATE)
                .chancedOutput(DiggyBlocks.THORIUM_PHOSPHATE_CAKE.asStack(), 3000, 500)
                .save(provider);

        GTRecipeTypes.ARC_FURNACE_RECIPES.recipeBuilder("diggycore:thorium_phosphate_dry")
                .EUt(VH[MV])
                .duration(10 * SECOND)
                .inputItems(DiggyBlocks.THORIUM_PHOSPHATE_CAKE.asStack())
                .outputItems(dust, THORIUM_PHOSPHATE)
                .save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:rare_earth_filtrate_neutralise")
                .EUt(VH[EV])
                .duration(10 * SECOND)
                .inputItems(dust, RARE_EARTH_FILTRATE)
                .inputFluids(new FluidStack(AMMONIA_SOLUTION.getFluid(), 500))
                .outputItems(dust, NEUTRALISED_RARE_EARTH_FILTRATE)
                .save(provider);

        GTRecipeTypes.SIFTER_RECIPES.recipeBuilder("diggycore:nref_sift")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .inputItems(dust, NEUTRALISED_RARE_EARTH_FILTRATE)
                .outputItems(dust, RARE_EARTH_HYDROXIDE_CONCENTRATE)
                .chancedOutput(dust, URANIUM_FILTRATE, 3000, 500)
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:uranium_filtrate_neutralise")
                .EUt(VH[HV])
                .duration(10 * SECOND)
                .inputItems(dust, URANIUM_FILTRATE)
                .inputFluids(new FluidStack(AMMONIA_SOLUTION.getFluid(), 500))
                .outputItems(dust, NEUTRALISED_URANIUM_FILTRATE)
                .save(provider);

        GTRecipeTypes.SIFTER_RECIPES.recipeBuilder("diggycore:neutralised_uranium_sift")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .inputItems(dust, NEUTRALISED_URANIUM_FILTRATE)
                .outputItems(dust, Uranium238)
                .save(provider);

        GTRecipeTypes.BLAST_RECIPES.recipeBuilder("diggycore:rare_earth_salt_make")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .blastFurnaceTemp(90)
                .inputItems(dust, RARE_EARTH_HYDROXIDE_CONCENTRATE)
                .inputFluids(new FluidStack(SulfuricAcid.getFluid(), 3000))
                .outputItems(dust, RARE_EARTH_SALT)
                .outputFluids(new FluidStack(Water.getFluid(), 3000))
                .save(provider);

        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder("diggycore:rare_earths_separate")
                .EUt(VH[HV])
                .duration(20 * SECOND)
                .inputItems(dust, RARE_EARTH_SALT)
                .inputFluids(new FluidStack(TRIBUTYL_PHOSPHATE.getFluid(), 1000))
                .inputFluids(new FluidStack(KEROSENE.getFluid(), 1000))
                .outputItems(dust, LIGHT_RARE_EARTHS)
                .outputItems(dust, MIDDLE_RARE_EARTHS)
                .outputItems(dust, HEAVY_RARE_EARTHS)
                .save(provider);

        DiggyRecipeTypes.ION_EXCHANGER_RECIPES.recipeBuilder("diggycore:middle_rare_earths_separate")
                .EUt(VH[HV])
                .duration(40 * SECOND)
                .inputItems(dust, MIDDLE_RARE_EARTHS)
                .chancedOutput(dustSmall, SAMARIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, EUROPIUM_PRECIPITATE, 500, 1000)
                .chancedOutput(dustSmall, GADOLINIUM_PRECIPITATE, 2500, 1000)
                .save(provider);

        DiggyRecipeTypes.ION_EXCHANGER_RECIPES.recipeBuilder("diggycore:heavy_rare_earths_separate")
                .EUt(VH[HV])
                .duration(40 * SECOND)
                .inputItems(dust, HEAVY_RARE_EARTHS)
                .chancedOutput(dustSmall, TERBIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, DYSPROSIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, HOLMIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, ERBIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, THULIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, YTTERBIUM_PRECIPITATE, 2500, 1000)
                .chancedOutput(dustSmall, LUTETIUM_PRECIPITATE, 2500, 1000)
                .save(provider);

        makeElementPurificationRecipe(LANTHANUM_PRECIPITATE, LANTHANUM_OXIDE, Lanthanum, provider);
        makeElementPurificationRecipe(CERIUM_PRECIPITATE, CERIUM_OXIDE, Cerium, provider);
        makeElementPurificationRecipe(PRASEODYMIUM_PRECIPITATE, PRASEODYMIUM_OXIDE, Cerium, provider);
        makeElementPurificationRecipe(NEODYMIUM_PRECIPITATE, NEODYMIUM_OXIDE, Neodymium, provider);
        makeElementPurificationRecipe(SAMARIUM_PRECIPITATE, SAMARIUM_OXIDE, Samarium, provider);
        makeElementPurificationRecipe(EUROPIUM_PRECIPITATE, EUROPIUM_OXIDE, Europium, provider);
        makeElementPurificationRecipe(GADOLINIUM_PRECIPITATE, GADOLINIUM_OXIDE, Gadolinium, provider);
        makeElementPurificationRecipe(TERBIUM_PRECIPITATE, TERBIUM_OXIDE, Terbium, provider);
        makeElementPurificationRecipe(DYSPROSIUM_PRECIPITATE, DYSPROSIUM_OXIDE, Dysprosium, provider);
        makeElementPurificationRecipe(HOLMIUM_PRECIPITATE, HOLMIUM_OXIDE, Holmium, provider);
        makeElementPurificationRecipe(ERBIUM_PRECIPITATE, ERBIUM_OXIDE, Erbium, provider);
        makeElementPurificationRecipe(THULIUM_PRECIPITATE, THULIUM_OXIDE, Thulium, provider);
        makeElementPurificationRecipe(YTTERBIUM_PRECIPITATE, YTTERBIUM_OXIDE, Ytterbium, provider);
        makeElementPurificationRecipe(LUTETIUM_PRECIPITATE, LUTETIUM_OXIDE, Thulium, provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:butyraldehyde_make_better_lol")
                .EUt(480)
                .duration(10 * SECOND)
                .inputFluids(new FluidStack(Propene.getFluid(), 1000))
                .inputFluids(new FluidStack(Hydrogen.getFluid(), 2000))
                .inputFluids(new FluidStack(CarbonMonoxide.getFluid(), 1000))
                .outputFluids(new FluidStack(Butyraldehyde.getFluid(), 1000))
                .outputFluids(new FluidStack(I_BUTANAL.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:isobutanol_make")
                .EUt(480)
                .duration(5 * SECOND)
                .inputFluids(new FluidStack(I_BUTANAL.getFluid(), 1000))
                .inputFluids(new FluidStack(Hydrogen.getFluid(), 2000))
                .outputFluids(new FluidStack(ISOBUTANOL.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:n_butanol_make")
                .EUt(480)
                .duration(5 * SECOND)
                .inputFluids(new FluidStack(Butyraldehyde.getFluid(), 1000))
                .inputFluids(new FluidStack(Hydrogen.getFluid(), 2000))
                .outputFluids(new FluidStack(N_BUTANOL.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:phosphorus_trichloride_make")
                .EUt(480)
                .duration(10 * SECOND)
                .inputItems(dust, Phosphorus)
                .inputFluids(new FluidStack(Chlorine.getFluid(), 3000))
                .outputFluids(new FluidStack(PHOSPHORUS_TRICHLORIDE.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:phosphoryl_trichloride_make")
                .EUt(480)
                .duration(10 * SECOND)
                .inputFluids(new FluidStack(PHOSPHORUS_TRICHLORIDE.getFluid(), 1000))
                .inputFluids(new FluidStack(Oxygen.getFluid(), 500))
                .outputFluids(new FluidStack(PHOSPHORYL_CHLORIDE.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("diggycore:tributyl_phosphate_make")
                .EUt(VA[EV])
                .duration(10 * SECOND)
                .inputFluids(new FluidStack(PHOSPHORYL_CHLORIDE.getFluid(), 1000))
                .inputFluids(new FluidStack(N_BUTANOL.getFluid(), 3000))
                .outputFluids(new FluidStack(TRIBUTYL_PHOSPHATE.getFluid(), 1000))
                .outputFluids(new FluidStack(HydrochloricAcid.getFluid(), 3000))
                .save(provider);
    }

    public static void makeElementPurificationRecipe(Material elmPrecipitate, Material elmOxide, Material element,
                                                     Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.BLAST_RECIPES.recipeBuilder("diggycore:" + elmPrecipitate.getName() + "_calcination")
                .EUt(VH[EV])
                .duration(20 * SECOND)
                .blastFurnaceTemp(1000)
                .inputItems(dust, elmPrecipitate)
                .outputItems(dust, elmOxide)
                .outputFluids(new FluidStack(CarbonMonoxide.getFluid(), 1000))
                .outputFluids(new FluidStack(CarbonDioxide.getFluid(), 1000))
                .save(provider);

        GTRecipeTypes.BLAST_RECIPES.recipeBuilder("diggycore:" + elmOxide.getName() + "_reduce")
                .EUt(VH[EV])
                .duration(20 * SECOND)
                .blastFurnaceTemp(1000)
                .inputItems(dust, elmOxide)
                .inputItems(dust, Calcium)
                .outputItems(dust, element)
                .outputItems(dust, Quicklime)
                .save(provider);
    }
}
