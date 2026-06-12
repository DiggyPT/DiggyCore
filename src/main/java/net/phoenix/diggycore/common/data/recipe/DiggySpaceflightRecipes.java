package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.config.ConfigHolder;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.block.DiggyBlocks;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MIXER_RECIPES;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;

public class DiggySpaceflightRecipes {

    public static int SECOND = 20; // contrary to gtvalues one this one is a int not a long.

    public static void init(Consumer<FinishedRecipe> provider) {
        DiggyRecipeTypes.GC_COMPRESSOR_RECIPES.recipeBuilder("diggycore:hd_tier1")
                .EUt(VH[EV])
                .duration(12 * SECOND)
                .inputItems(plate, Steel, 2)
                .inputItems(plate, Aluminium, 2)
                .inputItems(plate, Bronze, 2)
                .circuitMeta(1)
                .outputItems(plate, HEAVY_DUTY_PLATING_TIER_1, 1).save(provider);

        DiggyRecipeTypes.GC_COMPRESSOR_RECIPES.recipeBuilder("diggycore:hd_tier2")
                .EUt(VH[EV])
                .duration(24 * SECOND)
                .inputItems(plate, HEAVY_DUTY_PLATING_TIER_1, 1)
                .inputItems(plate, METEORIC_IRON, 2)
                .inputItems(plate, DESH, 1)
                .circuitMeta(2)
                .outputItems(plate, HEAVY_DUTY_PLATING_TIER_2, 1).save(provider);

        ASSEMBLER_RECIPES.recipeBuilder("diggycore:casing_galaxyspace_grade")
                .inputItems(plate, MARAGING_STEEL_200, 6)
                .inputItems(frameGt, Invar)
                .circuitMeta(6)
                .outputItems(
                        DiggyBlocks.GALAXYSPACE_GRADE_CASING.asStack(ConfigHolder.INSTANCE.recipes.casingsPerCraft))
                .duration(50).EUt(16)
                .addMaterialInfo(true).save(provider);

        MIXER_RECIPES.recipeBuilder("diggycore:maraging_steel_200")
                .inputItems(dust, Iron, 16)
                .inputItems(dust, Titanium)
                .inputItems(dust, Aluminium)
                .inputItems(dust, Nickel, 2)
                .inputItems(dust, Cobalt)
                .circuitMeta(1)
                .outputItems(dust, MARAGING_STEEL_200, 21)
                .duration(12 * SECOND).EUt(VH[EV]).save(provider);
    }
}
