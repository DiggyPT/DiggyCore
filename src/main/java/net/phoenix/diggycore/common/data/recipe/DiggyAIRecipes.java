package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.mcreator.dfplanets.init.DfPlanetsModBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.AdvancedChemMaterials;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.item.DiggyItems.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyAIRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:tech_unit1")
                .inputItems(GTItems.ELECTRIC_MOTOR_IV, 6)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(TECH_AI_UNIT)
                .duration(240 * SECOND).EUt(VH[LuV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:tech_unit2")
                .inputItems(GTItems.ELECTRIC_MOTOR_LuV, 3)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(TECH_AI_UNIT)
                .duration(180 * SECOND).EUt(VH[LuV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:tech_unit3")
                .inputItems(GTItems.ELECTRIC_MOTOR_ZPM, 3)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(TECH_AI_UNIT, 2)
                .duration(120 * SECOND).EUt(VH[LuV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:tech_model")
                .inputItems(TECH_AI_UNIT, 24)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(TECH_AI_MODEL)
                .duration(120 * SECOND).EUt(VH[IV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:ai_slop") // muna mintip muna mintip
                .notConsumable(AGI_AI_MODEL)
                .circuitMeta(7)
                .outputFluids(AdvancedChemMaterials.AI_SLOP.getFluid(8000))
                .duration(90 * SECOND).EUt(VH[IV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:bio_unit1")
                .inputItems(GTItems.BIO_CHAFF, 12)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(BIO_AI_UNIT)
                .duration(240 * SECOND).EUt(VH[LuV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:bio_unit2")
                .inputItems(DfPlanetsModBlocks.GHILLIE_KELP, 6)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(BIO_AI_UNIT)
                .duration(240 * SECOND).EUt(VH[LuV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:bio_unit3")
                .inputItems(DfPlanetsModBlocks.BACTERIAL_CLOUD, 6)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(BIO_AI_UNIT, 2)
                .duration(240 * SECOND).EUt(VH[LuV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:bio_model")
                .inputItems(BIO_AI_UNIT, 24)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(BIO_AI_MODEL)
                .duration(120 * SECOND).EUt(VH[IV]).save(provider);

        DiggyRecipeTypes.AI_TRAINING_CENTER_RECIPES.recipeBuilder("diggycore:agi_model")
                .inputItems(TECH_AI_UNIT, 24)
                .inputItems(BIO_AI_UNIT, 24)
                .inputItems(CustomTags.IV_CIRCUITS, 8)
                .solderMultiplier(16)
                .outputFluids(Steam.getFluid(12000))
                .outputItems(AGI_AI_MODEL)
                .duration(120 * SECOND).EUt(VH[ZPM]).save(provider);
    }
}
