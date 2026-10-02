package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;

import earth.terrarium.adastra.common.registry.ModFluids;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.AdvancedChemMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;
import static net.phoenix.diggycore.common.item.DiggyItems.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyChemRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:desh_oxide")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(dust, DESH)
                .inputFluids(Oxygen, 2000)
                .circuitMeta(1)
                .outputItems(dust, DESH_OXIDE).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:pbk")
                .EUt(VH[LuV])
                .duration(30 * SECOND)
                .inputItems(dust, IRRADIATED_DESH_OXIDE)
                .inputItems(dust, Dysprosium)
                .circuitMeta(1)
                .outputItems(dust, PBK, 2).save(provider);

        GTRecipeTypes.AUTOCLAVE_RECIPES.recipeBuilder("diggycore:pbk_grow")
                .EUt(VH[LuV])
                .duration(60 * SECOND)
                .inputItems(dust, PBK)
                .inputFluids(UPSILON, 1000)
                .outputItems(gem, PBK).save(provider);

        DiggyRecipeTypes.PARTICLE_BEAM_ENGRAVER_RECIPES.recipeBuilder("diggycore:fra_axion")
                .EUt(VH[LuV])
                .duration(25 * SECOND)
                .inputItems(AXION)
                .inputItems(MICROFRACTAL_LOOP)
                .notConsumable(lens, PBK)
                .outputItems(FRA_AXION).save(provider);

        DiggyRecipeTypes.PARTICLE_BEAM_ENGRAVER_RECIPES.recipeBuilder("diggycore:fra_coded_matter")
                .EUt(VH[LuV])
                .duration(30 * SECOND)
                .inputItems(ingot, PROTOVERSE_COATED_HIROKUNO)
                .inputItems(FRA_AXION)
                .notConsumable(lens, LUNAR_SAPPHIRE)
                .outputItems(dust, FRA_CODED_MATTER).save(provider);

        DiggyRecipeTypes.PARTICLE_BEAM_ENGRAVER_RECIPES.recipeBuilder("diggycore:protoverse_coated_hirokuno")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(ingot, HIROKUNO)
                .inputItems(PROTOVERSE)
                .notConsumable(lens, ISAACMANITE)
                .outputItems(ingot, PROTOVERSE_COATED_HIROKUNO).save(provider);

        GTRecipeTypes.CANNER_RECIPES.recipeBuilder("diggycore:acetone_catalyst_make")
                .EUt(VH[LV])
                .duration(5 * SECOND)
                .inputItems(rod, Polytetrafluoroethylene, 4)
                .inputFluids(Acetone, 500)
                .outputItems(ACETONE_CATALYST).save(provider);

        DiggyRecipeTypes.CHEMICAL_PLANT_RECIPES.recipeBuilder("diggycore:cryo_fuel_make")
                .EUt(VH[IV])
                .duration(14 * SECOND)
                .inputItems(dust, Ice, 32)
                .inputItems(dustSmall, Potash, 2)
                .inputFluids(LiquidAir, 1000)
                .inputFluids(Bromine, 200)
                .circuitMeta(1)
                .outputFluids(new FluidStack(ModFluids.CRYO_FUEL.get(), 1000)).save(provider);

        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder("diggycore:bromine_make_air")
                .EUt(VH[HV])
                .duration(10 * SECOND)
                .inputFluids(SaltWater, 1000)
                .inputFluids(Chlorine, 500)
                .inputFluids(Air, 2000)
                .circuitMeta(1)
                .outputFluids(Bromine.getFluid(500))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000)).save(provider);

        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder("diggycore:bromine_make_steam")
                .EUt(VH[HV])
                .duration(7 * SECOND)
                .inputFluids(SaltWater, 1000)
                .inputFluids(Chlorine, 500)
                .inputFluids(Steam, 1000)
                .circuitMeta(1)
                .outputFluids(Bromine.getFluid(500))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000)).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:terfenol_d_make")
                .EUt(VH[EV])
                .duration(12 * SECOND)
                .inputItems(dust, Terbium, 3)
                .inputItems(dust, Dysprosium, 7)
                .inputItems(dust, Iron, 20)
                .circuitMeta(1)
                .outputItems(dust, TERFENOL_D, 30).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("diggycore:terfenol_x_make")
                .EUt(VH[EV])
                .duration(12 * SECOND)
                .inputItems(dust, Terbium, 3)
                .inputItems(dust, DESH, 7)
                .inputItems(dust, Iron, 20)
                .circuitMeta(1)
                .outputItems(dust, TERFENOL_X, 30).save(provider);
    }
}
