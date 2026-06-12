package net.phoenix.diggycore.common.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMaterialFlags.*;
import static net.phoenix.diggycore.common.item.DiggyItems.*;

public class DiggyCyclotronRecipes {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

    public static void init(Consumer<FinishedRecipe> provider)
    {
        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:californium")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(vial, Berkelium, 1)
                .inputItems(NEUTRON, 1)
                .circuitMeta(1)
                .chancedOutput(vial, Californium, 8000, 1).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:cowan_reines_neutrino_experiment")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(ELECTRON_ANTINEUTRINO, 1)
                .inputItems(PROTON, 1)
                .circuitMeta(1)
                .chancedOutput(NEUTRON.asStack(), 8000, 1)
                .chancedOutput(POSITRON.asStack(), 8000, 1).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:hydrogen_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputFluids(Hydrogen, 1000)
                .circuitMeta(1)
                .outputItems(PROTON.asStack(), ELECTRON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:deuterium_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputFluids(Deuterium, 1000)
                .circuitMeta(1)
                .outputItems(PROTON.asStack(), NEUTRON.asStack(), ELECTRON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:tritium_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputFluids(Tritium, 1000)
                .circuitMeta(1)
                .outputItems(PROTON.asStack(), NEUTRON.asStack(2), ELECTRON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:proton_make")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(UP_QUARK.asStack(2), DOWN_QUARK.asStack())
                .circuitMeta(1)
                .outputItems(PROTON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:neutron_make")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(UP_QUARK.asStack(), DOWN_QUARK.asStack(2))
                .circuitMeta(2)
                .outputItems(NEUTRON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:cuandavis_make")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(UP_QUARK.asStack(2), RIZZ_QUARK.asStack())
                .circuitMeta(3)
                .outputItems(CUANDAVIS.asStack()).save(provider);
    }
}
