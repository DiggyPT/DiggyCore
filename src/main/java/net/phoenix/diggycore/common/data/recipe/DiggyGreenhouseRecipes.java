package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.common.data.*;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.item.DiggyItems;
import net.phoenix.diggycore.data.recipe.condition.GreenhouseMoistureCondition;
import net.phoenix.diggycore.data.recipe.condition.GreenhouseNitrogenCondition;
import net.phoenix.diggycore.data.recipe.condition.GreenhousePHCondition;
import net.phoenix.diggycore.data.recipe.condition.GreenhouseTemperatureCondition;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggyGreenhouseRecipes {

    public static void agronomyRecipes(Consumer<FinishedRecipe> provider) {
        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_nitrogen_injection")
                .inputFluids(Nitrogen.getFluid(1000))
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, -10)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_nitrogen_injection_smol")
                .inputFluids(Nitrogen.getFluid(100))
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, -1)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_nitrogen_removal")
                .notConsumable(rod, Cobalt, 2)
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 10)
                .duration(10 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_nitrogen_removal_smol")
                .notConsumable(rod, Cobalt, 2)
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 1)
                .duration(2 * SECOND)
                .EUt(VA[LV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_temperature_injection")
                .inputFluids(CarbonDioxide.getFluid(1000))
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_TEMPERATURE_USED, -10)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_temperature_injection_smol")
                .inputFluids(CarbonDioxide.getFluid(100))
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_TEMPERATURE_USED, -1)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_temperature_removal")
                .inputFluids(SulfurDioxide.getFluid(1000))
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_TEMPERATURE_USED, 10)
                .duration(10 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_temperature_removal_smol")
                .inputFluids(SulfurDioxide.getFluid(100))
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_TEMPERATURE_USED, 1)
                .duration(2 * SECOND)
                .EUt(VA[LV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_moisture_injection")
                .inputFluids(Steam.getFluid(1000))
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_MOISTURE_USED, -10)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_moisture_injection_smol")
                .inputFluids(Steam.getFluid(100))
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_MOISTURE_USED, -1)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_moisture_removal")
                .inputItems(pipeNormalFluid, GTMaterials.Bronze, 4)
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_MOISTURE_USED, 10)
                .duration(10 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_moisture_removal_smol")
                .inputItems(pipeTinyFluid, GTMaterials.Bronze, 4)
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_MOISTURE_USED, 1)
                .duration(2 * SECOND)
                .EUt(VA[LV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_ph_injection")
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_PH_USED, -10)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_ph_injection_smol")
                .inputFluids(HydrochloricAcid.getFluid(100))
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_PH_USED, -1)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_ph_removal")
                .inputItems(dust, CalciumHydroxide)
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_PH_USED, 10)
                .duration(10 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_ph_removal_smol")
                .inputItems(dustTiny, CalciumHydroxide)
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_PH_USED, 1)
                .duration(2 * SECOND)
                .EUt(VA[LV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_radio_injection")
                .inputItems(rod, Uranium235)
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_RADIOACTIVITY_USED, -10)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_radio_injection_smol")
                .inputItems(nugget, Uranium235)
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_RADIOACTIVITY_USED, -1)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_radio_removal")
                .inputItems(dust, RadAway)
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_RADIOACTIVITY_USED, 10)
                .duration(10 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_radio_removal_smol")
                .inputItems(dustTiny, RadAway)
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_RADIOACTIVITY_USED, 1)
                .duration(2 * SECOND)
                .EUt(VA[LV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_emc_injection")
                .inputItems(DiggyItems.EMC_BALL)
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_EMC_USED, -10)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_emc_injection_smol")
                .inputItems(DiggyItems.EMC_BALL)
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_EMC_USED, -1)
                .duration(20)
                .EUt(4)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_radio_removal")
                .inputFluids(CoalTar.getFluid(1000))
                .circuitMeta(1)
                .addData(DiggyRecipeTypes.GREENHOUSE_EMC_USED, 10)
                .duration(10 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:gh_radio_removal_smol")
                .inputFluids(CoalTar.getFluid(100))
                .circuitMeta(2)
                .addData(DiggyRecipeTypes.GREENHOUSE_EMC_USED, 1)
                .duration(2 * SECOND)
                .EUt(VA[LV])
                .save(provider);
    }

    public static void init(Consumer<FinishedRecipe> provider) {
        agronomyRecipes(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:wheat_grow")
                .notConsumable(new ItemStack(Items.WHEAT_SEEDS, 12))
                .outputItems(Items.WHEAT, 36)
                .outputItems(Items.WHEAT_SEEDS, 6)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseNitrogenCondition(32, 54))
                .addCondition(new GreenhouseMoistureCondition(23, 67))
                .duration(40 * SECOND)
                .EUt(32)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:potato_grow")
                .notConsumable(new ItemStack(Items.POTATO, 12))
                .outputItems(Items.POTATO, 36)
                .chancedOutput(new ItemStack(Items.POISONOUS_POTATO, 1), 1000, 1)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(21, 40))
                .addCondition(new GreenhouseMoistureCondition(23, 67))
                .duration(40 * SECOND)
                .EUt(32)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:carrot_grow")
                .notConsumable(new ItemStack(Items.CARROT, 12))
                .outputItems(Items.CARROT, 36)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(16, 21))
                .addCondition(new GreenhousePHCondition(6, 7))
                .duration(40 * SECOND)
                .EUt(32)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:beetroot_grow")
                .notConsumable(new ItemStack(Items.BEETROOT_SEEDS, 12))
                .inputItems(dustTiny, Boron)
                .outputItems(Items.BEETROOT, 36)
                .outputItems(Items.BEETROOT_SEEDS, 6)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhousePHCondition(7, 8))
                .addCondition(new GreenhouseNitrogenCondition(75, 89))
                .duration(40 * SECOND)
                .EUt(32)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:pumpkin_grow")
                .notConsumable(new ItemStack(Items.PUMPKIN_SEEDS, 8))
                .outputItems(Items.PUMPKIN, 24)
                .outputItems(Items.PUMPKIN_SEEDS, 3)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhousePHCondition(6, 9))
                .addCondition(new GreenhouseMoistureCondition(23, 56))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:melon_grow")
                .notConsumable(new ItemStack(Items.MELON_SEEDS, 8))
                .outputItems(Items.MELON_SLICE, 12)
                .outputItems(Items.MELON, 4)
                .outputItems(Items.MELON_SEEDS, 3)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(30, 36))
                .addCondition(new GreenhouseMoistureCondition(60, 78))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:sugar_cane_grow")
                .notConsumable(new ItemStack(Items.SUGAR_CANE, 12))
                .outputItems(Items.SUGAR_CANE, 24)
                .outputItems(Items.SUGAR, 12)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(25, 43))
                .addCondition(new GreenhouseMoistureCondition(40, 53))
                .duration(40 * SECOND)
                .EUt(32)
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:oak_sapling_grow")
                .notConsumable(new ItemStack(Items.OAK_SAPLING, 8))
                .outputItems(Blocks.OAK_LOG.asItem(), 32)
                .outputItems(Items.APPLE, 6)
                .outputItems(Items.OAK_SAPLING, 4)
                .outputItems(Blocks.OAK_LEAVES.asItem(), 16)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseNitrogenCondition(32, 54))
                .addCondition(new GreenhouseMoistureCondition(23, 67))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:birch_sapling_grow")
                .notConsumable(new ItemStack(Items.BIRCH_SAPLING, 8))
                .outputItems(Blocks.BIRCH_LOG.asItem(), 32)
                .outputItems(Items.BIRCH_SAPLING, 4)
                .outputItems(Blocks.BIRCH_LEAVES.asItem(), 16)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(-4, 13))
                .addCondition(new GreenhouseMoistureCondition(23, 34))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:dark_oak_sapling_grow")
                .notConsumable(new ItemStack(Items.DARK_OAK_SAPLING, 8))
                .outputItems(Blocks.DARK_OAK_LOG.asItem(), 64)
                .outputItems(Items.DARK_OAK_SAPLING, 12)
                .outputItems(Blocks.DARK_OAK_LEAVES.asItem(), 32)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseNitrogenCondition(11, 31))
                .addCondition(new GreenhouseMoistureCondition(23, 67))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:spruce_sapling_grow")
                .notConsumable(new ItemStack(Items.SPRUCE_SAPLING, 8))
                .outputItems(Blocks.SPRUCE_LOG.asItem(), 32)
                .outputItems(Items.SPRUCE_SAPLING, 4)
                .outputItems(Blocks.SPRUCE_LEAVES.asItem(), 16)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(-4, 13))
                .addCondition(new GreenhouseNitrogenCondition(11, 31))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:jungle_sapling_grow")
                .notConsumable(new ItemStack(Items.JUNGLE_SAPLING, 8))
                .outputItems(Blocks.JUNGLE_LOG.asItem(), 64)
                .outputItems(Items.COCOA_BEANS, 16)
                .outputItems(Items.JUNGLE_SAPLING, 4)
                .outputItems(Blocks.JUNGLE_LEAVES.asItem(), 16)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(30, 36))
                .addCondition(new GreenhouseMoistureCondition(60, 78))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:acacia_sapling_grow")
                .notConsumable(new ItemStack(Items.ACACIA_SAPLING, 8))
                .outputItems(Blocks.ACACIA_LOG.asItem(), 32)
                .outputItems(Items.ACACIA_SAPLING, 4)
                .outputItems(Blocks.ACACIA_LEAVES.asItem(), 16)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(30, 36))
                .addCondition(new GreenhouseMoistureCondition(0, 12))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:cherry_sapling_grow")
                .notConsumable(new ItemStack(Items.CHERRY_SAPLING, 8))
                .outputItems(Blocks.CHERRY_LOG.asItem(), 32)
                .outputItems(Items.CHERRY_SAPLING, 12)
                .outputItems(Blocks.CHERRY_LEAVES.asItem(), 24)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseTemperatureCondition(0, 14))
                .addCondition(new GreenhousePHCondition(8, 10))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);

        DiggyRecipeTypes.GREENHOUSE_RECIPES.recipeBuilder("diggycore:rubber_sapling_grow")
                .notConsumable(new ItemStack(GTBlocks.RUBBER_SAPLING, 8))
                .outputItems(GTBlocks.RUBBER_LOG, 32)
                .outputItems(GTItems.STICKY_RESIN, 12)
                .outputItems(GTBlocks.RUBBER_SAPLING, 4)
                .outputItems(GTBlocks.RUBBER_LEAVES, 16)
                // .addData(DiggyRecipeTypes.GREENHOUSE_NITROGEN_USED, 0)
                .addCondition(new GreenhouseNitrogenCondition(32, 54))
                .addCondition(new GreenhouseMoistureCondition(23, 67))
                .duration(60 * SECOND)
                .EUt(VA[MV])
                .save(provider);
    }
}
