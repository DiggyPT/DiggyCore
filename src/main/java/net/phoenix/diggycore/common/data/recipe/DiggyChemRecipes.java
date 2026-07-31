package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.AdvancedChemMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;
import static net.phoenix.diggycore.common.item.DiggyItems.*;

public class DiggyChemRecipes {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

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
    }
}
