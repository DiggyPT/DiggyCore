package net.phoenix.diggycore.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static net.phoenix.diggycore.common.data.DiggyRecipeTypes.APIARY_RECIPES;
import static net.phoenix.diggycore.common.data.materials.DiggyMaterialFlags.bee;

public class DiggyBeeBreedingRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        makePrimaryBeeRecipe(provider, Iron);
        makePrimaryBeeRecipe(provider, Copper);
        makePrimaryBeeRecipe(provider, Tin);
        makePrimaryBeeRecipe(provider, Sphalerite);
        makePrimaryBeeRecipe(provider, Naquadah);
        makePrimaryBeeRecipe(provider, Aluminium);

        makeBeeBreeding(provider, Iron, Copper, Pyrite);
        makeBeeBreeding(provider, Copper, Pyrite, Chalcopyrite);
        makeBeeBreeding(provider, Chalcopyrite, Sphalerite, Chalcocite);
        makeBeeBreeding(provider, Chalcopyrite, Chalcocite, Tetrahedrite);
        makeBeeBreeding(provider, Iron, Sphalerite, Goethite, Graphite, 30);
        makeBeeBreeding(provider, Iron, Goethite, Hematite, Limonite);
        makeBeeBreeding(provider, Copper, Diamond, Gold, Silver);
        makeBeeBreeding(provider, Silver, Diamond, Silver, Cooperite, 2);
        makeBeeBreeding(provider, Graphite, Copper, Coal);
        makeBeeBreeding(provider, Tin, Hematite, Cassiterite, CassiteriteSand, 30);
        makeBeeBreeding(provider, Graphite, Coal, Coal, Diamond, 6); // second output is rare.
        makeBeeBreeding(provider, Coal, Tin, Salt, RockSalt, 20);
        makeBeeBreeding(provider, Salt, RockSalt, Saltpeter);
        makeBeeBreeding(provider, Goethite, Limonite, Hematite, Redstone, 10);
        makeBeeBreeding(provider, Redstone, Diamond, Ruby, Realgar);
        makeBeeBreeding(provider, Redstone, Realgar, Cinnabar);
        makeBeeBreeding(provider, CassiteriteSand, Iron, BasalticMineralSand, GraniticMineralSand);
        makeBeeBreeding(provider, BasalticMineralSand, CassiteriteSand, GlauconiteSand, GarnetSand, 18);
        makeBeeBreeding(provider, BasalticMineralSand, GraniticMineralSand, FullersEarth, Gypsum);
        makeBeeBreeding(provider, BasalticMineralSand, Coal, Oilsands);
        makeBeeBreeding(provider, GarnetSand, Diamond, Olivine, Magnesite);
        makeBeeBreeding(provider, Magnesite, GarnetSand, Bentonite, Soapstone, 15);
        makeBeeBreeding(provider, Soapstone, GlauconiteSand, Talc, Pentlandite, 20);
        makeBeeBreeding(provider, Pentlandite, Salt, Garnierite, Cobaltite, 20);
        makeBeeBreeding(provider, Pentlandite, Garnierite, Nickel);
        makeBeeBreeding(provider, Cobaltite, Nickel, Cobalt);
        makeBeeBreeding(provider, Hematite, Chalcocite, Bornite);
        makeBeeBreeding(provider, Bornite, Diamond, BlueTopaz);
        makeBeeBreeding(provider, BlueTopaz, Limonite, Topaz);
        makeBeeBreeding(provider, BlueTopaz, Diamond, Sapphire, GreenSapphire, 32);
        makeBeeBreeding(provider, GreenSapphire, Sapphire, Almandine, Pyrope);
        makeBeeBreeding(provider, Pyrope, Sapphire, Apatite, TricalciumPhosphate, 20);
        makeBeeBreeding(provider, Apatite, TricalciumPhosphate, TricalciumPhosphate, Pyrochlore);
        makeBeeBreeding(provider, Lepidolite, Spodumene, Lithium);
        makeBeeBreeding(provider, Salt, Saltpeter, Lepidolite, RockSalt, 20);
        makeBeeBreeding(provider, Salt, RockSalt, Spodumene, Saltpeter, 20);
        makeBeeBreeding(provider, Redstone, BlueTopaz, Electrotine, Diamond, 4);
        makeBeeBreeding(provider, Electrotine, Diatomite, Electrotine, Alunite, 16);
        makeBeeBreeding(provider, Alunite, Sapphire, Lapis, Calcite, 24);
        makeBeeBreeding(provider, Lapis, Sapphire, Lazurite, Sodalite);
        makeBeeBreeding(provider, Gypsum, Calcite, Kyanite, Mica, 30);
        makeBeeBreeding(provider, Mica, Gypsum, Pollucite);
        makeBeeBreeding(provider, Mica, Lapis, Bauxite);
        makeBeeBreeding(provider, Silver, Silver, Lead, Galena);
        makeBeeBreeding(provider, Tetrahedrite, Copper, Stibnite);
        makeBeeBreeding(provider, Ruby, GarnetSand, GarnetRed, GarnetYellow, 10);
        makeBeeBreeding(provider, GarnetRed, Iron, Amethyst);
        makeBeeBreeding(provider, GarnetYellow, Diamond, Opal);
        makeBeeBreeding(provider, GarnetYellow, Olivine, Emerald);
        makeBeeBreeding(provider, Emerald, Iron, Beryllium);
        makeBeeBreeding(provider, Emerald, Sphalerite, Thorium);
        makeBeeBreeding(provider, Sphalerite, Beryllium, Sphalerite, Bastnasite, 18);
        makeBeeBreeding(provider, Bastnasite, GarnetSand, Monazite, Neodymium, 18);
        makeBeeBreeding(provider, Galena, Sphalerite, Wulfenite);
        makeBeeBreeding(provider, Wulfenite, RockSalt, Molybdenite);
        makeBeeBreeding(provider, Molybdenite, Silver, Molybdenum);
        makeBeeBreeding(provider, Molybdenite, TricalciumPhosphate, Powellite);
        makeBeeBreeding(provider, Iron, Gold, Magnetite);
        makeBeeBreeding(provider, Magnetite, FullersEarth, VanadiumMagnetite);
        makeBeeBreeding(provider, Scheelite, Molybdenite, Chromite);
        makeBeeBreeding(provider, Pyrite, Sphalerite, Sulfur);
        makeBeeBreeding(provider, GarnetRed, Saltpeter, Grossular);
        makeBeeBreeding(provider, Grossular, Copper, Pyrolusite, Tantalite, 22);
        makeBeeBreeding(provider, Grossular, Grossular, Grossular, Spessartine, 8);
        makeBeeBreeding(provider, Amethyst, Sulfur, Quartzite, CertusQuartz, 16);
        makeBeeBreeding(provider, Quartzite, CertusQuartz, Barite, NetherQuartz, 40);
        makeBeeBreeding(provider, Chalcopyrite, Cassiterite, Zeolite, Realgar, 20);
        makeBeeBreeding(provider, Pollucite, Lithium, Trona);

        makeBeeBreeding(provider, Naquadah, Scheelite, Naquadah, Plutonium239, 2);
        makeBeeBreeding(provider, Aluminium, Iron, Ilmenite);
        makeBeeBreeding(provider, Lithium, Ilmenite, Scheelite, Tungstate, 40);
        makeBeeBreeding(provider, Plutonium239, Naquadah, Uraninite, Pitchblende, 32);

        mBBsameChance(provider, Cooperite, Tungstate, Platinum, Palladium, 2);
        mBBsameChance(provider, Cassiterite, CassiteriteSand, Diatomite, Asbestos, 16);
    }

    public static void makeBeeBreeding(Consumer<FinishedRecipe> provider, Material input1, Material input2,
                                       Material output) {
        APIARY_RECIPES.recipeBuilder(output.getName() + "_bee_breeding")
                .notConsumable(bee, input1)
                .notConsumable(bee, input2)
                .inputItems(Items.SUGAR)
                .outputItems(bee, output)
                .duration((int) SECONDS * 60)
                .EUt(VA[LV])
                .save(provider);
    }

    public static void makeBeeBreeding(Consumer<FinishedRecipe> provider, Material input1, Material input2,
                                       Material output1, Material output2, int smolChance) {
        int bigChance = 100 - smolChance;
        APIARY_RECIPES.recipeBuilder(output1.getName() + output2.getName() + "_bee_breeding")
                .notConsumable(bee, input1)
                .notConsumable(bee, input2)
                .inputItems(Items.SUGAR)
                .chancedOutput(bee, output1, bigChance * 100, 100)
                .chancedOutput(bee, output2, smolChance * 100, 100)
                .duration((int) SECONDS * 60)
                .EUt(VA[LV])
                .save(provider);
    }

    public static void makeBeeBreeding(Consumer<FinishedRecipe> provider, Material input1, Material input2,
                                       Material output1, Material output2) {
        makeBeeBreeding(provider, input1, input2, output1, output2, 50);
    }

    public static void mBBsameChance(Consumer<FinishedRecipe> provider, Material input1, Material input2,
                                     Material output1, Material output2, int smolChance) {
        APIARY_RECIPES.recipeBuilder(output1.getName() + output2.getName() + "_bee_breeding")
                .notConsumable(bee, input1)
                .notConsumable(bee, input2)
                .inputItems(Items.SUGAR)
                .chancedOutput(bee, output1, smolChance * 100, 100)
                .chancedOutput(bee, output2, smolChance * 100, 100)
                .duration((int) SECONDS * 60)
                .EUt(VA[LV])
                .save(provider);
    }

    public static void makePrimaryBeeRecipe(Consumer<FinishedRecipe> provider, Material input) {
        MIXER_RECIPES.recipeBuilder(input.getName() + "_bee_primary_make")
                .inputItems(Items.HONEYCOMB)
                .inputItems(Items.SUGAR)
                .inputItems(rawOre, input)
                .outputItems(bee, input)
                .duration((int) SECONDS * 40)
                .EUt(VA[LV])
                .save(provider);
    }
}
