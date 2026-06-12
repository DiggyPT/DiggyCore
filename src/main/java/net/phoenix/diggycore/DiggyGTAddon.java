package net.phoenix.diggycore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.data.recipes.FinishedRecipe;
import net.phoenix.diggycore.common.data.materials.DiggyElements;
import net.phoenix.diggycore.common.data.recipe.DiggyCyclotronRecipes;
import net.phoenix.diggycore.common.data.recipe.DiggySpaceflightRecipes;
import net.phoenix.diggycore.common.data.recipe.generated.DiggyMaterialPartRecipeGen;
import net.phoenix.diggycore.common.registry.DiggyRegistration;
import net.phoenix.diggycore.data.recipe.DiggyBeeBreedingRecipes;
import net.phoenix.diggycore.data.recipe.MachineMakeRecipes;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class DiggyGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return DiggyRegistration.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return DiggyCore.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        // CustomTagPrefixes.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        DiggyMaterialPartRecipeGen.init(provider);
        DiggyBeeBreedingRecipes.init(provider);
        MachineMakeRecipes.init(provider);
        DiggySpaceflightRecipes.init(provider);
        DiggyCyclotronRecipes.init(provider);
    }

    @Override
    public void registerElements() {
        DiggyElements.init();
    }

    // If you have custom ingredient types, uncomment this & change to match your capability.
    // KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
    /*
     * public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE,
     * CustomRecipeCapabilities.PRESSURE, false);
     * public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE,
     * CustomRecipeCapabilities.PRESSURE, true);
     * 
     * @Override
     * public void registerRecipeKeys(KJSRecipeKeyEvent event) {
     * event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
     * }
     */

    @Override
    public void registerOreVeins() {
        // DiggyOres.create(Consumer<ResourceLocation> consumer);
    }
}
