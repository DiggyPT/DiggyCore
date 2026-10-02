package net.phoenix.diggycore.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.mcreator.dfplanets.init.DfPlanetsModBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.phoenix.diggycore.common.data.DiggyRecipeTypes;
import net.phoenix.diggycore.common.data.materials.RareEarthMaterials;

import earth.terrarium.adastra.common.registry.ModBlocks;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.phoenix.diggycore.common.data.materials.DiggyMetallurgicAndGems.*;
import static net.phoenix.diggycore.common.data.materials.DiggyNewElementsAndAddFlags.*;
import static net.phoenix.diggycore.common.utils.DiggyValues.SECOND;

public class DiggySpaceflightRecipes {

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

        DiggyRecipeTypes.GC_COMPRESSOR_RECIPES.recipeBuilder("diggycore:hd_tier3")
                .EUt(VH[IV])
                .duration(12 * SECOND)
                .inputItems(plate, HEAVY_DUTY_PLATING_TIER_2, 1)
                .inputItems(plate, OSTRUM, 4)
                .circuitMeta(3)
                .outputItems(plate, HEAVY_DUTY_PLATING_TIER_3, 1).save(provider);

        MIXER_RECIPES.recipeBuilder("diggycore:maraging_steel_200")
                .inputItems(dust, Iron, 16)
                .inputItems(dust, Titanium)
                .inputItems(dust, Aluminium)
                .inputItems(dust, Nickel, 2)
                .inputItems(dust, Cobalt)
                .circuitMeta(1)
                .outputItems(dust, MARAGING_STEEL_200, 21)
                .duration(12 * SECOND).EUt(VH[EV]).save(provider);

        // processing sands
        MACERATOR_RECIPES.recipeBuilder("diggycore:moon_sand_make")
                .inputItems(ModBlocks.MOON_STONE)
                .outputItems(ModBlocks.MOON_SAND)
                .dimension(ResourceLocation.parse("ad_astra:moon"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        MACERATOR_RECIPES.recipeBuilder("diggycore:mars_sand_make")
                .inputItems(ModBlocks.MARS_STONE)
                .outputItems(ModBlocks.MARS_SAND)
                .dimension(ResourceLocation.parse("ad_astra:mars"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        MACERATOR_RECIPES.recipeBuilder("diggycore:venus_sand_make")
                .inputItems(ModBlocks.VENUS_STONE)
                .outputItems(ModBlocks.VENUS_SAND)
                .dimension(ResourceLocation.parse("ad_astra:venus"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        MACERATOR_RECIPES.recipeBuilder("diggycore:proxima_regolith_make")
                .inputItems(DfPlanetsModBlocks.PROXIMA_ROCK)
                .outputItems(DfPlanetsModBlocks.PROXIMA_B_REGOLITH)
                .dimension(ResourceLocation.parse("df_planets:proxima_b"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("diggycore:moon_rock_make")
                .notConsumable(ModBlocks.MOON_STONE.get().asItem())
                .outputItems(ModBlocks.MOON_STONE)
                .adjacentFluids(GTMaterials.Lava.getFluid(), GTMaterials.Lava.getFluid())
                .dimension(ResourceLocation.parse("ad_astra:moon"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("diggycore:mars_rock_make")
                .notConsumable(ModBlocks.MARS_STONE.get().asItem())
                .outputItems(ModBlocks.MARS_STONE)
                .adjacentFluids(GTMaterials.Lava.getFluid(), GTMaterials.Lava.getFluid())
                .dimension(ResourceLocation.parse("ad_astra:mars"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("diggycore:venus_rock_make")
                .notConsumable(ModBlocks.VENUS_STONE.get().asItem())
                .outputItems(ModBlocks.VENUS_STONE)
                .adjacentFluids(GTMaterials.Lava.getFluid(), GTMaterials.Lava.getFluid())
                .dimension(ResourceLocation.parse("ad_astra:venus"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("diggycore:prox_b_rock_make")
                .notConsumable(DfPlanetsModBlocks.PROXIMA_B_REGOLITH.get().asItem())
                .outputItems(DfPlanetsModBlocks.PROXIMA_B_REGOLITH)
                .adjacentFluids(GTMaterials.Lava.getFluid(), GTMaterials.Lava.getFluid())
                .dimension(ResourceLocation.parse("df_planets:proxima_b"))
                .duration(20 * SECOND).EUt(16)
                .addMaterialInfo(true).save(provider);

        DISTILLATION_RECIPES.recipeBuilder("diggycore:kerosene_make")
                .inputFluids(Oil.getFluid(1000))
                .outputFluids(Naphtha.getFluid(100))
                .outputFluids(RareEarthMaterials.KEROSENE.getFluid(250))
                .outputFluids(Gasoline.getFluid(10))
                .outputFluids(Diesel.getFluid(10))
                .dimension(ResourceLocation.parse("ad_astra:earth_orbit"))
                .dimension(ResourceLocation.parse("ad_astra:glacio_orbit"))
                .dimension(ResourceLocation.parse("ad_astra:mars_orbit"))
                .dimension(ResourceLocation.parse("ad_astra:mercury_orbit"))
                .dimension(ResourceLocation.parse("ad_astra:moon_orbit"))
                .dimension(ResourceLocation.parse("ad_astra:venus_orbit"))
                .duration(60 * SECOND).EUt(450)
                .addMaterialInfo(true).save(provider);
    }
}
