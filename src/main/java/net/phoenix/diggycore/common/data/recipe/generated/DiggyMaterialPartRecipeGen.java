package net.phoenix.diggycore.common.data.recipe.generated;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.DiggyMaterialFlags;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

// kylie gen-ner
public class DiggyMaterialPartRecipeGen {

    public static void generateDoubleIngotRecipes(Consumer<FinishedRecipe> provider) {
        GTCEuAPI.materialManager.getRegisteredMaterials().forEach((material) -> {

            if (material == null || material.isNull()) return;

            ItemStack inputStack = ChemicalHelper.get(TagPrefix.ingot, material, 2);

            if (inputStack.isEmpty()) return;

            ItemStack doubleIngotStack = ChemicalHelper.get(DiggyMaterialFlags.double_ingot, material, 1);
            if (doubleIngotStack.isEmpty()) return;

            GTRecipeBuilder builder = GTRecipeTypes.BENDER_RECIPES.recipeBuilder(
                    "diggycore:" + material.getName() + "_double_ingot")
                    .EUt(GTValues.VH[GTValues.LV])
                    .duration(100)
                    .inputItems(inputStack)
                    .circuitMeta(3)
                    .outputItems(doubleIngotStack);

            builder.save(provider);
        });
    }

    public static void generateVialRecipes(Consumer<FinishedRecipe> provider) {
        GTCEuAPI.materialManager.getRegisteredMaterials().forEach((material) -> {

            if (material == null || material.isNull()) return;

            ItemStack inputStack = ChemicalHelper.get(dustSmall, material, 1);

            if (inputStack.isEmpty()) return;

            ItemStack vialStack = ChemicalHelper.get(DiggyMaterialFlags.vial, material, 1);
            if (vialStack.isEmpty()) return;

            GTRecipeBuilder builderC = GTRecipeTypes.COMPRESSOR_RECIPES.recipeBuilder(
                    "diggycore:" + material.getName() + "_vial")
                    .EUt(GTValues.VH[GTValues.LV])
                    .duration(50)
                    .inputItems(inputStack)
                    .circuitMeta(3)
                    .outputItems(vialStack);

            GTRecipeBuilder builderE = GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(
                    "diggycore:" + material.getName() + "_vial_to_small_dust")
                    .EUt(GTValues.VH[GTValues.LV])
                    .duration(15)
                    .inputItems(vialStack)
                    .outputItems(inputStack);

            builderC.save(provider);
            builderE.save(provider);

        });
    }

    public static void generateBeeRecipes(Consumer<FinishedRecipe> provider) {
        GTCEuAPI.materialManager.getRegisteredMaterials().forEach((material) -> {

            if (material == null || material.isNull()) return;

            ItemStack outputStack = ChemicalHelper.get(TagPrefix.rawOre, material, 1);

            if (outputStack.isEmpty()) return;

            ItemStack combStack = ChemicalHelper.get(DiggyMaterialFlags.comb, material, 1);
            if (combStack.isEmpty()) return;

            ItemStack beeStack = ChemicalHelper.get(DiggyMaterialFlags.bee, material, 1);
            ItemStack beeStackDouble = ChemicalHelper.get(DiggyMaterialFlags.bee, material, 2);
            if (beeStack.isEmpty()) return;

            GTRecipeBuilder builder1 = GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(
                    "diggycore:" + material.getName() + "_comb_destruction")
                    .EUt(GTValues.VH[GTValues.LV])
                    .duration(200)
                    .inputItems(combStack)
                    .outputItems(outputStack)
                    .chancedOutput(outputStack, 4000, 1000);

            GTRecipeBuilder builder2 = DiggyRecipeTypes.APIARY_RECIPES.recipeBuilder(
                    "diggycore:" + material.getName() + "_bee_make")
                    .EUt(GTValues.VH[GTValues.LV])
                    .duration((int) GTValues.MINUTES)
                    .notConsumable(beeStack)
                    .outputItems(combStack)
                    .chancedOutput(combStack, 1000, 400);

            GTRecipeBuilder builder3 = GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(
                    "diggycore:" + material.getName() + "_bee_reproduction")
                    .EUt(GTValues.VH[GTValues.LV])
                    .duration(2400)
                    .notConsumable(beeStackDouble)
                    .inputItems(dustSmall, Sugar)
                    .outputItems(beeStack);

            builder1.save(provider);
            builder2.save(provider);
            builder3.save(provider);
        });
    }
}
