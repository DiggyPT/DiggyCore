package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.block.DiggyBlocks;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMaterialFlags.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.item.DiggyItems.*;
import static net.phoenix.diggycore.common.machine.DiggyMachines.CYCLOTRON;

public class DiggyCyclotronRecipes {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

    public static void init(Consumer<FinishedRecipe> provider) {
        ASSEMBLER_RECIPES.recipeBuilder("diggycore:casing_cyclotron")
                .inputItems(plate, Dysprosium, 6)
                .inputItems(frameGt, Iridium)
                .circuitMeta(6)
                .outputItems(
                        DiggyBlocks.CYCLOTRON_CASING.asStack(ConfigHolder.INSTANCE.recipes.casingsPerCraft))
                .duration(50).EUt(VH[LuV])
                .addMaterialInfo(true).save(provider);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("diggycore:cyclotron")
                .inputItems(DiggyBlocks.CYCLOTRON_CASING.asStack())
                .inputItems(CustomTags.LuV_CIRCUITS, 4)
                .inputItems(plateDouble, METEORIC_IRON)
                .inputItems(plateDouble, TERFENOL_D)
                .inputItems(FIELD_GENERATOR_IV, 2)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 48)
                .inputItems(wireGtSingle, SamariumIronArsenicOxide, 16)
                .inputFluids(SolderingAlloy.getFluid(L * 8))
                .inputFluids(Epoxy.getFluid(L * 8))
                .outputItems(CYCLOTRON.asStack())
                .scannerResearch(b -> b
                        .researchStack(ChemicalHelper.get(vial, Deuterium))
                        .duration(1200)
                        .EUt(VA[IV]))
                .duration(800).EUt(VA[LuV]).save(provider);

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
                .circuitMeta(2)
                .chancedOutput(NEUTRON.asStack(), 8000, 1)
                .chancedOutput(POSITRON.asStack(), 8000, 1).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:hydrogen_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(vial, Hydrogen, 1)
                .circuitMeta(1)
                .outputItems(PROTON.asStack(), ELECTRON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:deuterium_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(vial, Deuterium, 1)
                .circuitMeta(1)
                .outputItems(PROTON.asStack(), NEUTRON.asStack(), ELECTRON.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:tritium_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(vial, Tritium, 1)
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

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:proton_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(PROTON.asStack())
                .circuitMeta(1)
                .outputItems(UP_QUARK.asStack(2), DOWN_QUARK.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:neutron_decompose")
                .EUt(VH[LuV])
                .duration(12 * SECOND)
                .inputItems(NEUTRON.asStack())
                .circuitMeta(1)
                .outputItems(UP_QUARK.asStack(1), DOWN_QUARK.asStack(2)).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:proton_beam1")
                .EUt(VH[ZPM])
                .duration(12 * SECOND)
                .inputItems(PROTON.asStack())
                .circuitMeta(2)
                .outputItems(STRANGE_QUARK.asStack(), STRANGE_ANTIQUARK.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:proton_beam2")
                .EUt(VH[ZPM])
                .duration(24 * SECOND)
                .inputItems(PROTON.asStack())
                .circuitMeta(3)
                .outputItems(CHARM_QUARK.asStack(), CHARM_ANTIQUARK.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:proton_beam3")
                .EUt(VH[ZPM])
                .duration(48 * SECOND)
                .inputItems(PROTON.asStack())
                .circuitMeta(4)
                .outputItems(BOTTOM_QUARK.asStack(), BOTTOM_ANTIQUARK.asStack()).save(provider);

        DiggyRecipeTypes.CYCLOTRON_RECIPES.recipeBuilder("diggycore:proton_beam4")
                .EUt(VH[ZPM])
                .duration(96 * SECOND)
                .inputItems(PROTON.asStack())
                .circuitMeta(5)
                .outputItems(TOP_QUARK.asStack(), TOP_ANTIQUARK.asStack()).save(provider);
    }
}
